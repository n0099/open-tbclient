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
/* loaded from: classes4.dex */
public class b extends BdBaseModel {
    private HttpMessageListener fSL;
    private a gjO;
    private com.baidu.tieba.ala.live.personcenter.admin.b.a gjT;

    /* loaded from: classes4.dex */
    public interface a {
        void an(int i, String str);

        void kS(boolean z);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fSL = new HttpMessageListener(1021078, true) { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaAdminListResponseMessage) {
                    AlaAdminListResponseMessage alaAdminListResponseMessage = (AlaAdminListResponseMessage) httpResponsedMessage;
                    if (!alaAdminListResponseMessage.isSuccess()) {
                        if (b.this.gjO != null) {
                            b.this.gjO.an(alaAdminListResponseMessage.getError(), alaAdminListResponseMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    b.this.gjT = alaAdminListResponseMessage.bMB();
                    if (b.this.gjO != null) {
                        b.this.gjO.kS(false);
                    }
                }
            }
        };
        registerTask();
        registerListener(this.fSL);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021078, TbConfig.SERVER_ADDRESS + "ala/perm/getAnchorAdmin");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaAdminListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void bMC() {
        sendMessage(new com.baidu.tieba.ala.live.personcenter.admin.message.a());
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
        return hasData() ? new ArrayList(this.gjT.getUserList()) : new ArrayList();
    }

    public int bMA() {
        if (hasData()) {
            return this.gjT.bMA();
        }
        return -1;
    }

    public void a(a aVar) {
        this.gjO = aVar;
    }

    public void a(com.baidu.tieba.ala.live.personcenter.admin.b.b bVar) {
        if (hasData()) {
            this.gjT.getUserList().remove(bVar);
            if (this.gjO != null) {
                this.gjO.kS(false);
            }
        }
    }

    private boolean hasData() {
        return (this.gjT == null || this.gjT.getUserList() == null || this.gjT.getUserList().isEmpty()) ? false : true;
    }
}
