package com.baidu.tieba.ala.live.personcenter.forbidden.c;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.live.personcenter.forbidden.message.AlaForbiddenListResponseMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BdBaseModel {
    private HttpMessageListener eFM;
    private a eHb;
    private boolean hasMore;
    private int pn;
    private int totalCount;
    private List<com.baidu.tieba.ala.live.personcenter.forbidden.b.b> userList;

    /* loaded from: classes2.dex */
    public interface a {
        void ad(int i, String str);

        void hN(boolean z);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.userList = new ArrayList();
        this.pn = 1;
        this.hasMore = false;
        this.eFM = new HttpMessageListener(1021079, true) { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaForbiddenListResponseMessage) {
                    AlaForbiddenListResponseMessage alaForbiddenListResponseMessage = (AlaForbiddenListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.live.personcenter.forbidden.message.a aVar = (com.baidu.tieba.ala.live.personcenter.forbidden.message.a) alaForbiddenListResponseMessage.getmOrginalMessage();
                    if (!alaForbiddenListResponseMessage.isSuccess()) {
                        if (b.this.eHb != null) {
                            b.this.eHb.ad(alaForbiddenListResponseMessage.getError(), alaForbiddenListResponseMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    com.baidu.tieba.ala.live.personcenter.forbidden.b.a beh = alaForbiddenListResponseMessage.beh();
                    b.this.totalCount = beh.getTotalCount();
                    if (aVar.aSX()) {
                        b.this.userList = beh.getUserList();
                    } else {
                        b.this.pn = aVar.getPn();
                        b.this.userList.addAll(beh.getUserList());
                    }
                    b.this.hasMore = beh.hasMore();
                    if (b.this.eHb != null) {
                        b.this.eHb.hN(b.this.hasMore);
                    }
                }
            }
        };
        rG();
        registerListener(this.eFM);
    }

    private void rG() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021079, TbConfig.SERVER_ADDRESS + "ala/perm/getImBlacklist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaForbiddenListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void bdQ() {
        com.baidu.tieba.ala.live.personcenter.forbidden.message.a aVar = new com.baidu.tieba.ala.live.personcenter.forbidden.message.a();
        aVar.setPn(1);
        aVar.buildParams();
        sendMessage(aVar);
    }

    public void bcN() {
        com.baidu.tieba.ala.live.personcenter.forbidden.message.a aVar = new com.baidu.tieba.ala.live.personcenter.forbidden.message.a();
        aVar.setPn(this.pn + 1);
        aVar.buildParams();
        sendMessage(aVar);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        bdQ();
        return true;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public List<IAdapterData> getUserList() {
        return new ArrayList(this.userList);
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void a(a aVar) {
        this.eHb = aVar;
    }

    public void a(com.baidu.tieba.ala.live.personcenter.forbidden.b.b bVar) {
        this.userList.remove(bVar);
        this.totalCount--;
        if (this.eHb != null) {
            this.eHb.hN(this.hasMore);
        }
    }
}
