package com.baidu.tieba.homepage.personalize.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.r;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeHttpResponse;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeRequest;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeSocketResponse;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class RecPersonalizePageModel extends BdBaseModel<BaseFragmentActivity> {
    private boolean cAE;
    private a daq;
    private com.baidu.adp.framework.listener.a mNetMessageListener;

    /* loaded from: classes.dex */
    public interface a {
        void b(DataRes dataRes, boolean z, boolean z2);

        void r(int i, String str);
    }

    public RecPersonalizePageModel(com.baidu.adp.base.e<BaseFragmentActivity> eVar, BdUniqueId bdUniqueId) {
        super(eVar);
        this.cAE = false;
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
                if (responsedMessage != null && RecPersonalizePageModel.this.daq != null) {
                    if (responsedMessage.getOrginalMessage() != null) {
                        Object extra = responsedMessage.getOrginalMessage().getExtra();
                        if (extra instanceof RecPersonalizeRequest) {
                            RecPersonalizeRequest recPersonalizeRequest = (RecPersonalizeRequest) extra;
                            z = recPersonalizeRequest.getLoadType() == 1;
                            z2 = recPersonalizeRequest.getNeedForumlist() == 1;
                            if (responsedMessage.getError() == 0) {
                                RecPersonalizePageModel.this.daq.r(responsedMessage.getError(), responsedMessage.getErrorString());
                            } else {
                                DataRes dataRes = null;
                                if (responsedMessage instanceof RecPersonalizeSocketResponse) {
                                    dataRes = ((RecPersonalizeSocketResponse) responsedMessage).getResultData();
                                } else if (responsedMessage instanceof RecPersonalizeHttpResponse) {
                                    dataRes = ((RecPersonalizeHttpResponse) responsedMessage).getResultData();
                                }
                                RecPersonalizePageModel.this.daq.b(dataRes, z, z2);
                            }
                            if (!(responsedMessage instanceof RecPersonalizeSocketResponse)) {
                                RecPersonalizePageModel.this.e(responsedMessage);
                                return;
                            } else if (responsedMessage instanceof RecPersonalizeHttpResponse) {
                                RecPersonalizePageModel.this.f(responsedMessage);
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
        VU();
        Za();
        registerListener(this.mNetMessageListener);
    }

    public void a(a aVar) {
        this.daq = aVar;
    }

    public void o(int i, int i2, int i3, int i4) {
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

    private void Za() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309264);
        bVar.setResponsedClass(RecPersonalizeSocketResponse.class);
        bVar.m(true);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void VU() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, com.baidu.tieba.tbadkCore.a.a.ay(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, 309264));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(RecPersonalizeHttpResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        if (!this.cAE) {
            this.cAE = true;
            a(1, false, responsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        if (!this.cAE) {
            this.cAE = true;
            a(1, true, responsedMessage);
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (r.FW().FX() && com.baidu.tieba.homepage.framework.a.aoY().getCreateTime() > 0) {
            long kP = com.baidu.tieba.homepage.framework.a.aoY().kP(1);
            long createTime = com.baidu.tieba.homepage.framework.a.aoY().getCreateTime();
            g gVar = new g(1005, z, responsedMessage, 0L, createTime, com.baidu.tieba.homepage.framework.a.aoY().kO(1), false, kP + createTime);
            if (gVar != null) {
                gVar.pageType = i;
                gVar.FR();
            }
            com.baidu.tieba.homepage.framework.a.aoY().setCreateTime(0L);
        }
    }
}
