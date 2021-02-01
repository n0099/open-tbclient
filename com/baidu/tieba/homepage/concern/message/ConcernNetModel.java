package com.baidu.tieba.homepage.concern.message;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.c;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipReqMessage;
import tbclient.Userlike.DataRes;
/* loaded from: classes2.dex */
public class ConcernNetModel extends BdBaseModel<BaseFragmentActivity> {
    private com.baidu.adp.framework.listener.a eDt;
    private b kbM;
    private a kbN;
    private boolean kbO;
    private com.baidu.adp.framework.listener.a kbP;

    /* loaded from: classes2.dex */
    public interface a {
        void sa(boolean z);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void aJ(int i, String str);

        void b(DataRes dataRes, boolean z);
    }

    public ConcernNetModel(f<BaseFragmentActivity> fVar, BdUniqueId bdUniqueId) {
        super(fVar);
        this.kbO = false;
        this.eDt = new com.baidu.adp.framework.listener.a(1003343, CmdConfigSocket.CMD_CONCERN_PAGE) { // from class: com.baidu.tieba.homepage.concern.message.ConcernNetModel.1
            /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
            /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
            @Override // com.baidu.adp.framework.listener.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                if (responsedMessage != null && ConcernNetModel.this.kbM != null) {
                    ConcernNetModel.this.kbO = false;
                    if (responsedMessage.getOrginalMessage() != null) {
                        Object extra = responsedMessage.getOrginalMessage().getExtra();
                        if (extra instanceof ConcernPageRequestMessage) {
                            z = au.isEmpty(((ConcernPageRequestMessage) extra).getPageTag());
                            if (responsedMessage.getError() == 0) {
                                ConcernNetModel.this.kbM.aJ(responsedMessage.getError(), responsedMessage.getErrorString());
                                return;
                            }
                            DataRes dataRes = null;
                            if (responsedMessage instanceof ConcernPageSocketResMessage) {
                                dataRes = ((ConcernPageSocketResMessage) responsedMessage).getResultData();
                            } else if (responsedMessage instanceof ConcernPageHttpResMessage) {
                                dataRes = ((ConcernPageHttpResMessage) responsedMessage).getResultData();
                            }
                            ConcernNetModel.this.kbM.b(dataRes, z);
                            return;
                        }
                    }
                    z = false;
                    if (responsedMessage.getError() == 0) {
                    }
                }
            }
        };
        this.kbP = new com.baidu.adp.framework.listener.a(1003344, CmdConfigSocket.CMD_CONCERN_CHECK_RED_NOTIFY) { // from class: com.baidu.tieba.homepage.concern.message.ConcernNetModel.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                CheckRedNotifySocketResMessage checkRedNotifySocketResMessage;
                boolean isShowRedNotify;
                if (responsedMessage != null && ConcernNetModel.this.kbN != null && responsedMessage.getError() == 0) {
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
                    ConcernNetModel.this.kbN.sa(false);
                    if (isShowRedNotify && (responsedMessage.getmOrginalMessage().getExtra() instanceof CheckRedNotifyReqMessage) && ((CheckRedNotifyReqMessage) responsedMessage.getmOrginalMessage().getExtra()).reqUnreadTipAfterFinish) {
                        ConcernNetModel.this.sendMessage(new ConcernUnreadTipReqMessage());
                    }
                }
            }
        };
        setUniqueId(bdUniqueId);
        brg();
        brf();
        registerListener(this.eDt);
        registerListener(this.kbP);
    }

    public void a(b bVar) {
        this.kbM = bVar;
    }

    public void a(a aVar) {
        this.kbN = aVar;
    }

    public void c(String str, c cVar) {
        if (!this.kbO) {
            this.kbO = true;
            ConcernPageRequestMessage concernPageRequestMessage = new ConcernPageRequestMessage();
            concernPageRequestMessage.setPageTag(str);
            concernPageRequestMessage.setTag(getUniqueId());
            concernPageRequestMessage.setAdInfo(cVar);
            sendMessage(concernPageRequestMessage);
        }
    }

    public void rZ(boolean z) {
        CheckRedNotifyReqMessage checkRedNotifyReqMessage = new CheckRedNotifyReqMessage();
        checkRedNotifyReqMessage.setTag(getUniqueId());
        checkRedNotifyReqMessage.reqUnreadTipAfterFinish = z;
        sendMessage(checkRedNotifyReqMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        if (!this.kbO) {
            this.kbO = true;
            sendMessage(new ConcernPageRequestMessage());
        }
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.kbO = false;
        cancelMessage();
        return false;
    }

    private void brf() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(CmdConfigSocket.CMD_CONCERN_PAGE);
        bVar.setResponsedClass(ConcernPageSocketResMessage.class);
        bVar.setNeedAck(true);
        MessageManager.getInstance().registerTask(bVar);
        com.baidu.tbadk.task.b bVar2 = new com.baidu.tbadk.task.b(CmdConfigSocket.CMD_CONCERN_CHECK_RED_NOTIFY);
        bVar2.setResponsedClass(CheckRedNotifySocketResMessage.class);
        bVar2.setNeedAck(true);
        MessageManager.getInstance().registerTask(bVar2);
    }

    private void brg() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003343, com.baidu.tieba.tbadkCore.a.a.bV(TbConfig.URL_CONCERN_PAGE, CmdConfigSocket.CMD_CONCERN_PAGE));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(ConcernPageHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(1003344, com.baidu.tieba.tbadkCore.a.a.bV(TbConfig.URL_CONCERN_CHECK_RED_NOTIFY, CmdConfigSocket.CMD_CONCERN_CHECK_RED_NOTIFY));
        tbHttpMessageTask2.setIsNeedAddCommenParam(true);
        tbHttpMessageTask2.setResponsedClass(CheckRedNotifyHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }
}
