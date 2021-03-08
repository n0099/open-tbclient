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
    private HttpMessageListener gOV;
    private a hlY;
    private com.baidu.tieba.ala.live.personcenter.admin.b.a hmd;

    /* loaded from: classes10.dex */
    public interface a {
        void aJ(int i, String str);

        void mK(boolean z);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gOV = new HttpMessageListener(1021078, true) { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaAdminListResponseMessage) {
                    AlaAdminListResponseMessage alaAdminListResponseMessage = (AlaAdminListResponseMessage) httpResponsedMessage;
                    if (!alaAdminListResponseMessage.isSuccess()) {
                        if (b.this.hlY != null) {
                            b.this.hlY.aJ(alaAdminListResponseMessage.getError(), alaAdminListResponseMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    b.this.hmd = alaAdminListResponseMessage.bYs();
                    if (b.this.hlY != null) {
                        b.this.hlY.mK(false);
                    }
                }
            }
        };
        registerTask();
        registerListener(this.gOV);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021078, TbConfig.SERVER_ADDRESS + "ala/perm/getAnchorAdmin");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaAdminListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void bYt() {
        sendMessage(new com.baidu.tieba.ala.live.personcenter.admin.message.a());
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        bYt();
        return true;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public List<IAdapterData> getUserList() {
        return hasData() ? new ArrayList(this.hmd.getUserList()) : new ArrayList();
    }

    public int bYr() {
        if (hasData()) {
            return this.hmd.bYr();
        }
        return -1;
    }

    public void a(a aVar) {
        this.hlY = aVar;
    }

    public void a(com.baidu.tieba.ala.live.personcenter.admin.b.b bVar) {
        if (hasData()) {
            this.hmd.getUserList().remove(bVar);
            if (this.hlY != null) {
                this.hlY.mK(false);
            }
        }
    }

    private boolean hasData() {
        return (this.hmd == null || this.hmd.getUserList() == null || this.hmd.getUserList().isEmpty()) ? false : true;
    }
}
