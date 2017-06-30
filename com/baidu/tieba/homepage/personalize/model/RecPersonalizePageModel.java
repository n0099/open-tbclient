package com.baidu.tieba.homepage.personalize.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.j.aa;
import com.baidu.tbadk.j.n;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeHttpResponse;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeRequest;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeSocketResponse;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class RecPersonalizePageModel extends BdBaseModel<BaseFragmentActivity> {
    private a cKT;
    private boolean ckJ;
    private com.baidu.adp.framework.listener.a mNetMessageListener;

    /* loaded from: classes.dex */
    public interface a {
        void b(DataRes dataRes, boolean z, boolean z2);

        void s(int i, String str);
    }

    public RecPersonalizePageModel(com.baidu.adp.base.g<BaseFragmentActivity> gVar, BdUniqueId bdUniqueId) {
        super(gVar);
        this.ckJ = false;
        this.mNetMessageListener = new g(this, CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
        setUniqueId(bdUniqueId);
        Ty();
        UP();
        registerListener(this.mNetMessageListener);
    }

    public void a(a aVar) {
        this.cKT = aVar;
    }

    public void d(int i, int i2, int i3, int i4, int i5) {
        RecPersonalizeRequest recPersonalizeRequest = new RecPersonalizeRequest();
        recPersonalizeRequest.setLoadType(i);
        recPersonalizeRequest.setThreadCount(i2);
        recPersonalizeRequest.setTag(getUniqueId());
        recPersonalizeRequest.setPn(i3);
        recPersonalizeRequest.setSuggestCount(i4);
        recPersonalizeRequest.setNeedForumlist(i5);
        sendMessage(recPersonalizeRequest);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        sendMessage(new RecPersonalizeRequest());
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    private void UP() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309264);
        bVar.setResponsedClass(RecPersonalizeSocketResponse.class);
        bVar.m(true);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void Ty() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, com.baidu.tieba.tbadkCore.a.a.ax(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, 309264));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(RecPersonalizeHttpResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        if (!this.ckJ) {
            this.ckJ = true;
            a(1, false, responsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(ResponsedMessage<?> responsedMessage) {
        if (!this.ckJ) {
            this.ckJ = true;
            a(1, true, responsedMessage);
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (aa.Gb().Gc() && com.baidu.tieba.homepage.framework.a.amb().getCreateTime() > 0) {
            long km = com.baidu.tieba.homepage.framework.a.amb().km(1);
            long createTime = com.baidu.tieba.homepage.framework.a.amb().getCreateTime();
            n nVar = new n(1005, z, responsedMessage, 0L, createTime, com.baidu.tieba.homepage.framework.a.amb().kl(1), false, km + createTime);
            if (nVar != null) {
                nVar.pageType = i;
                nVar.FW();
            }
            com.baidu.tieba.homepage.framework.a.amb().setCreateTime(0L);
        }
    }
}
