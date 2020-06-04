package com.baidu.tieba.ala.live.personcenter.admin.c;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.live.personcenter.admin.message.AlaAdminListResponseMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BdBaseModel {
    private a fDY;
    private com.baidu.tieba.ala.live.personcenter.admin.b.a fEd;
    private HttpMessageListener fnL;

    /* loaded from: classes3.dex */
    public interface a {
        void al(int i, String str);

        void jz(boolean z);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fnL = new HttpMessageListener(1021078, true) { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaAdminListResponseMessage) {
                    AlaAdminListResponseMessage alaAdminListResponseMessage = (AlaAdminListResponseMessage) httpResponsedMessage;
                    if (!alaAdminListResponseMessage.isSuccess()) {
                        if (b.this.fDY != null) {
                            b.this.fDY.al(alaAdminListResponseMessage.getError(), alaAdminListResponseMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    b.this.fEd = alaAdminListResponseMessage.bvM();
                    if (b.this.fDY != null) {
                        b.this.fDY.jz(false);
                    }
                }
            }
        };
        Fv();
        registerListener(this.fnL);
    }

    private void Fv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021078, TbConfig.SERVER_ADDRESS + "ala/perm/getAnchorAdmin");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaAdminListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void bvN() {
        sendMessage(new com.baidu.tieba.ala.live.personcenter.admin.message.a());
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        bvN();
        return true;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public List<IAdapterData> getUserList() {
        return hasData() ? new ArrayList(this.fEd.getUserList()) : new ArrayList();
    }

    public int bvL() {
        if (hasData()) {
            return this.fEd.bvL();
        }
        return -1;
    }

    public void a(a aVar) {
        this.fDY = aVar;
    }

    public void a(com.baidu.tieba.ala.live.personcenter.admin.b.b bVar) {
        if (hasData()) {
            this.fEd.getUserList().remove(bVar);
            if (this.fDY != null) {
                this.fDY.jz(false);
            }
        }
    }

    private boolean hasData() {
        return (this.fEd == null || this.fEd.getUserList() == null || this.fEd.getUserList().isEmpty()) ? false : true;
    }
}
