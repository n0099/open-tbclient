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
    private a eKZ;
    private HttpMessageListener eLe;
    private List<com.baidu.tieba.ala.live.personcenter.admin.b.b> userList;

    /* loaded from: classes3.dex */
    public interface a {
        void ag(int i, String str);

        void ie(boolean z);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.userList = new ArrayList();
        this.eLe = new HttpMessageListener(1021078, true) { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaAdminListResponseMessage) {
                    AlaAdminListResponseMessage alaAdminListResponseMessage = (AlaAdminListResponseMessage) httpResponsedMessage;
                    com.baidu.tieba.ala.live.personcenter.admin.message.a aVar = (com.baidu.tieba.ala.live.personcenter.admin.message.a) alaAdminListResponseMessage.getmOrginalMessage();
                    if (!alaAdminListResponseMessage.isSuccess()) {
                        if (b.this.eKZ != null) {
                            b.this.eKZ.ag(alaAdminListResponseMessage.getError(), alaAdminListResponseMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    com.baidu.tieba.ala.live.personcenter.admin.b.a bgx = alaAdminListResponseMessage.bgx();
                    b.this.userList = bgx.getUserList();
                    if (b.this.eKZ != null) {
                        b.this.eKZ.ie(false);
                    }
                }
            }
        };
        te();
        registerListener(this.eLe);
    }

    private void te() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021078, TbConfig.SERVER_ADDRESS + "ala/perm/getAnchorAdmin");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaAdminListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void bgy() {
        sendMessage(new com.baidu.tieba.ala.live.personcenter.admin.message.a());
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        bgy();
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

    public void a(a aVar) {
        this.eKZ = aVar;
    }

    public void a(com.baidu.tieba.ala.live.personcenter.admin.b.b bVar) {
        this.userList.remove(bVar);
        if (this.eKZ != null) {
            this.eKZ.ie(false);
        }
    }
}
