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
/* loaded from: classes7.dex */
public class b extends BdBaseModel {
    private HttpMessageListener fPw;
    private com.baidu.tieba.ala.live.personcenter.admin.b.a ggE;
    private a ggz;

    /* loaded from: classes7.dex */
    public interface a {
        void am(int i, String str);

        void kO(boolean z);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fPw = new HttpMessageListener(1021078, true) { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaAdminListResponseMessage) {
                    AlaAdminListResponseMessage alaAdminListResponseMessage = (AlaAdminListResponseMessage) httpResponsedMessage;
                    if (!alaAdminListResponseMessage.isSuccess()) {
                        if (b.this.ggz != null) {
                            b.this.ggz.am(alaAdminListResponseMessage.getError(), alaAdminListResponseMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    b.this.ggE = alaAdminListResponseMessage.bLq();
                    if (b.this.ggz != null) {
                        b.this.ggz.kO(false);
                    }
                }
            }
        };
        registerTask();
        registerListener(this.fPw);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021078, TbConfig.SERVER_ADDRESS + "ala/perm/getAnchorAdmin");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaAdminListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void bLr() {
        sendMessage(new com.baidu.tieba.ala.live.personcenter.admin.message.a());
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        bLr();
        return true;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public List<IAdapterData> getUserList() {
        return hasData() ? new ArrayList(this.ggE.getUserList()) : new ArrayList();
    }

    public int bLp() {
        if (hasData()) {
            return this.ggE.bLp();
        }
        return -1;
    }

    public void a(a aVar) {
        this.ggz = aVar;
    }

    public void a(com.baidu.tieba.ala.live.personcenter.admin.b.b bVar) {
        if (hasData()) {
            this.ggE.getUserList().remove(bVar);
            if (this.ggz != null) {
                this.ggz.kO(false);
            }
        }
    }

    private boolean hasData() {
        return (this.ggE == null || this.ggE.getUserList() == null || this.ggE.getUserList().isEmpty()) ? false : true;
    }
}
