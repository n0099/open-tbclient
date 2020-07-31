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
    private HttpMessageListener fEf;
    private a fUA;
    private com.baidu.tieba.ala.live.personcenter.admin.b.a fUF;

    /* loaded from: classes4.dex */
    public interface a {
        void ao(int i, String str);

        void kq(boolean z);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fEf = new HttpMessageListener(1021078, true) { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaAdminListResponseMessage) {
                    AlaAdminListResponseMessage alaAdminListResponseMessage = (AlaAdminListResponseMessage) httpResponsedMessage;
                    if (!alaAdminListResponseMessage.isSuccess()) {
                        if (b.this.fUA != null) {
                            b.this.fUA.ao(alaAdminListResponseMessage.getError(), alaAdminListResponseMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    b.this.fUF = alaAdminListResponseMessage.bBW();
                    if (b.this.fUA != null) {
                        b.this.fUA.kq(false);
                    }
                }
            }
        };
        registerTask();
        registerListener(this.fEf);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021078, TbConfig.SERVER_ADDRESS + "ala/perm/getAnchorAdmin");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaAdminListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void bBX() {
        sendMessage(new com.baidu.tieba.ala.live.personcenter.admin.message.a());
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        bBX();
        return true;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public List<IAdapterData> getUserList() {
        return hasData() ? new ArrayList(this.fUF.getUserList()) : new ArrayList();
    }

    public int bBV() {
        if (hasData()) {
            return this.fUF.bBV();
        }
        return -1;
    }

    public void a(a aVar) {
        this.fUA = aVar;
    }

    public void a(com.baidu.tieba.ala.live.personcenter.admin.b.b bVar) {
        if (hasData()) {
            this.fUF.getUserList().remove(bVar);
            if (this.fUA != null) {
                this.fUA.kq(false);
            }
        }
    }

    private boolean hasData() {
        return (this.fUF == null || this.fUF.getUserList() == null || this.fUF.getUserList().isEmpty()) ? false : true;
    }
}
