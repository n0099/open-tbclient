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
/* loaded from: classes4.dex */
public class b extends BdBaseModel {
    private HttpMessageListener fSL;
    private a glf;
    private boolean hasMore;
    private int pn;
    private int totalCount;
    private List<com.baidu.tieba.ala.live.personcenter.forbidden.b.b> userList;

    /* loaded from: classes4.dex */
    public interface a {
        void an(int i, String str);

        void kS(boolean z);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.userList = new ArrayList();
        this.pn = 1;
        this.hasMore = false;
        this.fSL = new HttpMessageListener(1021079, true) { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaForbiddenListResponseMessage) {
                    AlaForbiddenListResponseMessage alaForbiddenListResponseMessage = (AlaForbiddenListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.live.personcenter.forbidden.message.a aVar = (com.baidu.tieba.ala.live.personcenter.forbidden.message.a) alaForbiddenListResponseMessage.getmOrginalMessage();
                    if (!alaForbiddenListResponseMessage.isSuccess()) {
                        if (b.this.glf != null) {
                            b.this.glf.an(alaForbiddenListResponseMessage.getError(), alaForbiddenListResponseMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    com.baidu.tieba.ala.live.personcenter.forbidden.b.a bMS = alaForbiddenListResponseMessage.bMS();
                    b.this.totalCount = bMS.getTotalCount();
                    if (aVar.bAM()) {
                        b.this.userList = bMS.getUserList();
                    } else {
                        b.this.pn = aVar.getPn();
                        b.this.userList.addAll(bMS.getUserList());
                    }
                    b.this.hasMore = bMS.hasMore();
                    if (b.this.glf != null) {
                        b.this.glf.kS(b.this.hasMore);
                    }
                }
            }
        };
        registerTask();
        registerListener(this.fSL);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021079, TbConfig.SERVER_ADDRESS + "ala/perm/getImBlacklist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaForbiddenListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void bMC() {
        com.baidu.tieba.ala.live.personcenter.forbidden.message.a aVar = new com.baidu.tieba.ala.live.personcenter.forbidden.message.a();
        aVar.setPn(1);
        aVar.buildParams();
        sendMessage(aVar);
    }

    public void bLy() {
        com.baidu.tieba.ala.live.personcenter.forbidden.message.a aVar = new com.baidu.tieba.ala.live.personcenter.forbidden.message.a();
        aVar.setPn(this.pn + 1);
        aVar.buildParams();
        sendMessage(aVar);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        bMC();
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
        this.glf = aVar;
    }

    public void a(com.baidu.tieba.ala.live.personcenter.forbidden.b.b bVar) {
        this.userList.remove(bVar);
        this.totalCount--;
        if (this.glf != null) {
            this.glf.kS(this.hasMore);
        }
    }
}
