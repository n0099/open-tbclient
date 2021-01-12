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
/* loaded from: classes10.dex */
public class b extends BdBaseModel {
    private HttpMessageListener gKs;
    private a hfL;
    private com.baidu.tieba.ala.live.personcenter.admin.b.a hfQ;

    /* loaded from: classes10.dex */
    public interface a {
        void aF(int i, String str);

        void mG(boolean z);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gKs = new HttpMessageListener(1021078, true) { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaAdminListResponseMessage) {
                    AlaAdminListResponseMessage alaAdminListResponseMessage = (AlaAdminListResponseMessage) httpResponsedMessage;
                    if (!alaAdminListResponseMessage.isSuccess()) {
                        if (b.this.hfL != null) {
                            b.this.hfL.aF(alaAdminListResponseMessage.getError(), alaAdminListResponseMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    b.this.hfQ = alaAdminListResponseMessage.bXf();
                    if (b.this.hfL != null) {
                        b.this.hfL.mG(false);
                    }
                }
            }
        };
        registerTask();
        registerListener(this.gKs);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021078, TbConfig.SERVER_ADDRESS + "ala/perm/getAnchorAdmin");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaAdminListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void bXg() {
        sendMessage(new com.baidu.tieba.ala.live.personcenter.admin.message.a());
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        bXg();
        return true;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public List<IAdapterData> getUserList() {
        return hasData() ? new ArrayList(this.hfQ.getUserList()) : new ArrayList();
    }

    public int bXe() {
        if (hasData()) {
            return this.hfQ.bXe();
        }
        return -1;
    }

    public void a(a aVar) {
        this.hfL = aVar;
    }

    public void a(com.baidu.tieba.ala.live.personcenter.admin.b.b bVar) {
        if (hasData()) {
            this.hfQ.getUserList().remove(bVar);
            if (this.hfL != null) {
                this.hfL.mG(false);
            }
        }
    }

    private boolean hasData() {
        return (this.hfQ == null || this.hfQ.getUserList() == null || this.hfQ.getUserList().isEmpty()) ? false : true;
    }
}
