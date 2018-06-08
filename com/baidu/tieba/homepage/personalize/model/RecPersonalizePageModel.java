package com.baidu.tieba.homepage.personalize.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.k.m;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeHttpResponse;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeRequest;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeSocketResponse;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class RecPersonalizePageModel extends BdBaseModel<BaseFragmentActivity> {
    private a dRM;
    private boolean dxN;
    private com.baidu.adp.framework.listener.a mNetMessageListener;

    /* loaded from: classes2.dex */
    public interface a {
        void b(DataRes dataRes, boolean z, boolean z2);

        void q(int i, String str);
    }

    public RecPersonalizePageModel(com.baidu.adp.base.e<BaseFragmentActivity> eVar, BdUniqueId bdUniqueId) {
        super(eVar);
        this.dxN = false;
        this.mNetMessageListener = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264) { // from class: com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.1
            /* JADX WARN: Removed duplicated region for block: B:19:0x0035  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x004a  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x0054  */
            /* JADX WARN: Removed duplicated region for block: B:32:0x0076  */
            @Override // com.baidu.adp.framework.listener.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                boolean z2 = false;
                if (responsedMessage != null && RecPersonalizePageModel.this.dRM != null) {
                    if (responsedMessage.getOrginalMessage() != null) {
                        Object extra = responsedMessage.getOrginalMessage().getExtra();
                        if (extra instanceof RecPersonalizeRequest) {
                            RecPersonalizeRequest recPersonalizeRequest = (RecPersonalizeRequest) extra;
                            z = recPersonalizeRequest.getLoadType() == 1;
                            z2 = recPersonalizeRequest.getNeedForumlist() == 1;
                            if (responsedMessage.getError() == 0) {
                                RecPersonalizePageModel.this.dRM.q(responsedMessage.getError(), responsedMessage.getErrorString());
                            } else {
                                DataRes dataRes = null;
                                if (responsedMessage instanceof RecPersonalizeSocketResponse) {
                                    dataRes = ((RecPersonalizeSocketResponse) responsedMessage).getResultData();
                                } else if (responsedMessage instanceof RecPersonalizeHttpResponse) {
                                    dataRes = ((RecPersonalizeHttpResponse) responsedMessage).getResultData();
                                }
                                RecPersonalizePageModel.this.dRM.b(dataRes, z, z2);
                            }
                            if (!(responsedMessage instanceof RecPersonalizeSocketResponse)) {
                                RecPersonalizePageModel.this.a(responsedMessage, z);
                                return;
                            } else if (responsedMessage instanceof RecPersonalizeHttpResponse) {
                                RecPersonalizePageModel.this.b(responsedMessage, z);
                                return;
                            } else {
                                return;
                            }
                        }
                    }
                    z = false;
                    if (responsedMessage.getError() == 0) {
                    }
                    if (!(responsedMessage instanceof RecPersonalizeSocketResponse)) {
                    }
                }
            }
        };
        setUniqueId(bdUniqueId);
        age();
        akr();
        registerListener(this.mNetMessageListener);
    }

    public void a(a aVar) {
        this.dRM = aVar;
    }

    public void r(int i, int i2, int i3, int i4) {
        RecPersonalizeRequest recPersonalizeRequest = new RecPersonalizeRequest();
        recPersonalizeRequest.setLoadType(i);
        recPersonalizeRequest.setThreadCount(i2);
        recPersonalizeRequest.setTag(getUniqueId());
        recPersonalizeRequest.setPn(i3);
        recPersonalizeRequest.setSuggestCount(i4);
        recPersonalizeRequest.setNeedForumlist(0);
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

    private void akr() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309264);
        bVar.setResponsedClass(RecPersonalizeSocketResponse.class);
        bVar.p(true);
        bVar.setPriority(4);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void age() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, com.baidu.tieba.tbadkCore.a.a.aN(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, 309264));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(RecPersonalizeHttpResponse.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage, boolean z) {
        if (!this.dxN) {
            this.dxN = true;
            a(1, false, responsedMessage);
        }
        a(z, false, responsedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ResponsedMessage<?> responsedMessage, boolean z) {
        if (!this.dxN) {
            this.dxN = true;
            a(1, true, responsedMessage);
        }
        a(z, true, responsedMessage);
    }

    public void a(boolean z, boolean z2, ResponsedMessage<?> responsedMessage) {
        if (m.Ks().Kt()) {
            long mi = com.baidu.tieba.homepage.framework.a.aCk().mi(1);
            long createTime = com.baidu.tieba.homepage.framework.a.aCk().getCreateTime();
            com.baidu.tbadk.k.d dVar = new com.baidu.tbadk.k.d(1005, z2, responsedMessage, 0L, createTime, com.baidu.tieba.homepage.framework.a.aCk().mh(1), false, mi + createTime);
            dVar.pageType = 1;
            if (z) {
                dVar.aTg = mi;
                dVar.bW(false);
                return;
            }
            dVar.aTf = mi;
            dVar.bW(true);
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.Ks().Kt() && com.baidu.tieba.homepage.framework.a.aCk().getCreateTime() > 0) {
            long mi = com.baidu.tieba.homepage.framework.a.aCk().mi(1);
            long createTime = com.baidu.tieba.homepage.framework.a.aCk().getCreateTime();
            com.baidu.tbadk.k.d dVar = new com.baidu.tbadk.k.d(1005, z, responsedMessage, 0L, createTime, com.baidu.tieba.homepage.framework.a.aCk().mh(1), false, mi + createTime);
            if (dVar != null) {
                dVar.pageType = i;
                dVar.Kp();
            }
            com.baidu.tieba.homepage.framework.a.aCk().setCreateTime(0L);
        }
    }
}
