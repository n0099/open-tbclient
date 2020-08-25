package com.baidu.tieba.homepage.concern.message;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipReqMessage;
import tbclient.Userlike.DataRes;
/* loaded from: classes16.dex */
public class ConcernNetModel extends BdBaseModel<BaseFragmentActivity> {
    private com.baidu.adp.framework.listener.a dOR;
    private b iHN;
    private a iHO;
    private boolean iHP;
    private com.baidu.adp.framework.listener.a iHQ;

    /* loaded from: classes16.dex */
    public interface a {
        void pB(boolean z);
    }

    /* loaded from: classes16.dex */
    public interface b {
        void am(int i, String str);

        void b(DataRes dataRes, boolean z);
    }

    public ConcernNetModel(e<BaseFragmentActivity> eVar, BdUniqueId bdUniqueId) {
        super(eVar);
        this.iHP = false;
        this.dOR = new com.baidu.adp.framework.listener.a(1003343, CmdConfigSocket.CMD_CONCERN_PAGE) { // from class: com.baidu.tieba.homepage.concern.message.ConcernNetModel.1
            /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
            /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
            @Override // com.baidu.adp.framework.listener.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                if (responsedMessage != null && ConcernNetModel.this.iHN != null) {
                    ConcernNetModel.this.iHP = false;
                    if (responsedMessage.getOrginalMessage() != null) {
                        Object extra = responsedMessage.getOrginalMessage().getExtra();
                        if (extra instanceof ConcernPageRequestMessage) {
                            z = at.isEmpty(((ConcernPageRequestMessage) extra).getPageTag());
                            if (responsedMessage.getError() == 0) {
                                ConcernNetModel.this.iHN.am(responsedMessage.getError(), responsedMessage.getErrorString());
                                return;
                            }
                            DataRes dataRes = null;
                            if (responsedMessage instanceof ConcernPageSocketResMessage) {
                                dataRes = ((ConcernPageSocketResMessage) responsedMessage).getResultData();
                            } else if (responsedMessage instanceof ConcernPageHttpResMessage) {
                                dataRes = ((ConcernPageHttpResMessage) responsedMessage).getResultData();
                            }
                            ConcernNetModel.this.iHN.b(dataRes, z);
                            return;
                        }
                    }
                    z = false;
                    if (responsedMessage.getError() == 0) {
                    }
                }
            }
        };
        this.iHQ = new com.baidu.adp.framework.listener.a(1003344, CmdConfigSocket.CMD_CONCERN_CHECK_RED_NOTIFY) { // from class: com.baidu.tieba.homepage.concern.message.ConcernNetModel.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                CheckRedNotifySocketResMessage checkRedNotifySocketResMessage;
                boolean isShowRedNotify;
                if (responsedMessage != null && ConcernNetModel.this.iHO != null && responsedMessage.getError() == 0) {
                    if (responsedMessage instanceof CheckRedNotifyHttpResMessage) {
                        CheckRedNotifyHttpResMessage checkRedNotifyHttpResMessage = (CheckRedNotifyHttpResMessage) responsedMessage;
                        if (checkRedNotifyHttpResMessage != null) {
                            isShowRedNotify = checkRedNotifyHttpResMessage.isShowRedNotify();
                        }
                        isShowRedNotify = false;
                    } else {
                        if ((responsedMessage instanceof CheckRedNotifySocketResMessage) && (checkRedNotifySocketResMessage = (CheckRedNotifySocketResMessage) responsedMessage) != null) {
                            isShowRedNotify = checkRedNotifySocketResMessage.isShowRedNotify();
                        }
                        isShowRedNotify = false;
                    }
                    ConcernNetModel.this.iHO.pB(false);
                    if (isShowRedNotify && (responsedMessage.getmOrginalMessage().getExtra() instanceof CheckRedNotifyReqMessage) && ((CheckRedNotifyReqMessage) responsedMessage.getmOrginalMessage().getExtra()).reqUnreadTipAfterFinish) {
                        ConcernNetModel.this.sendMessage(new ConcernUnreadTipReqMessage());
                    }
                }
            }
        };
        setUniqueId(bdUniqueId);
        bhB();
        bhA();
        registerListener(this.dOR);
        registerListener(this.iHQ);
    }

    public void a(b bVar) {
        this.iHN = bVar;
    }

    public void a(a aVar) {
        this.iHO = aVar;
    }

    public void JB(String str) {
        if (!this.iHP) {
            this.iHP = true;
            ConcernPageRequestMessage concernPageRequestMessage = new ConcernPageRequestMessage();
            concernPageRequestMessage.setPageTag(str);
            concernPageRequestMessage.setTag(getUniqueId());
            sendMessage(concernPageRequestMessage);
        }
    }

    public void pA(boolean z) {
        CheckRedNotifyReqMessage checkRedNotifyReqMessage = new CheckRedNotifyReqMessage();
        checkRedNotifyReqMessage.setTag(getUniqueId());
        checkRedNotifyReqMessage.reqUnreadTipAfterFinish = z;
        sendMessage(checkRedNotifyReqMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        if (!this.iHP) {
            this.iHP = true;
            sendMessage(new ConcernPageRequestMessage());
        }
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.iHP = false;
        cancelMessage();
        return false;
    }

    private void bhA() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(CmdConfigSocket.CMD_CONCERN_PAGE);
        bVar.setResponsedClass(ConcernPageSocketResMessage.class);
        bVar.setNeedAck(true);
        MessageManager.getInstance().registerTask(bVar);
        com.baidu.tbadk.task.b bVar2 = new com.baidu.tbadk.task.b(CmdConfigSocket.CMD_CONCERN_CHECK_RED_NOTIFY);
        bVar2.setResponsedClass(CheckRedNotifySocketResMessage.class);
        bVar2.setNeedAck(true);
        MessageManager.getInstance().registerTask(bVar2);
    }

    private void bhB() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003343, com.baidu.tieba.tbadkCore.a.a.bH(TbConfig.URL_CONCERN_PAGE, CmdConfigSocket.CMD_CONCERN_PAGE));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(ConcernPageHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(1003344, com.baidu.tieba.tbadkCore.a.a.bH(TbConfig.URL_CONCERN_CHECK_RED_NOTIFY, CmdConfigSocket.CMD_CONCERN_CHECK_RED_NOTIFY));
        tbHttpMessageTask2.setIsNeedAddCommenParam(true);
        tbHttpMessageTask2.setResponsedClass(CheckRedNotifyHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }
}
