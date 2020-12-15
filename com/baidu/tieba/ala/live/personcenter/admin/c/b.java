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
    private HttpMessageListener gDm;
    private a gYD;
    private com.baidu.tieba.ala.live.personcenter.admin.b.a gYI;

    /* loaded from: classes4.dex */
    public interface a {
        void aC(int i, String str);

        void mn(boolean z);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gDm = new HttpMessageListener(1021078, true) { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaAdminListResponseMessage) {
                    AlaAdminListResponseMessage alaAdminListResponseMessage = (AlaAdminListResponseMessage) httpResponsedMessage;
                    if (!alaAdminListResponseMessage.isSuccess()) {
                        if (b.this.gYD != null) {
                            b.this.gYD.aC(alaAdminListResponseMessage.getError(), alaAdminListResponseMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    b.this.gYI = alaAdminListResponseMessage.bYr();
                    if (b.this.gYD != null) {
                        b.this.gYD.mn(false);
                    }
                }
            }
        };
        registerTask();
        registerListener(this.gDm);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021078, TbConfig.SERVER_ADDRESS + "ala/perm/getAnchorAdmin");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaAdminListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void bYs() {
        sendMessage(new com.baidu.tieba.ala.live.personcenter.admin.message.a());
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        bYs();
        return true;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public List<IAdapterData> getUserList() {
        return hasData() ? new ArrayList(this.gYI.getUserList()) : new ArrayList();
    }

    public int bYq() {
        if (hasData()) {
            return this.gYI.bYq();
        }
        return -1;
    }

    public void a(a aVar) {
        this.gYD = aVar;
    }

    public void a(com.baidu.tieba.ala.live.personcenter.admin.b.b bVar) {
        if (hasData()) {
            this.gYI.getUserList().remove(bVar);
            if (this.gYD != null) {
                this.gYD.mn(false);
            }
        }
    }

    private boolean hasData() {
        return (this.gYI == null || this.gYI.getUserList() == null || this.gYI.getUserList().isEmpty()) ? false : true;
    }
}
