package com.baidu.tieba.homepage.concern.message;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipReqMessage;
import tbclient.Userlike.DataRes;
/* loaded from: classes9.dex */
public class ConcernNetModel extends BdBaseModel<BaseFragmentActivity> {
    private com.baidu.adp.framework.listener.a dve;
    private b hYf;
    private a hYg;
    private boolean hYh;
    private com.baidu.adp.framework.listener.a hYi;

    /* loaded from: classes9.dex */
    public interface a {
        void og(boolean z);
    }

    /* loaded from: classes9.dex */
    public interface b {
        void al(int i, String str);

        void b(DataRes dataRes, boolean z);
    }

    public ConcernNetModel(e<BaseFragmentActivity> eVar, BdUniqueId bdUniqueId) {
        super(eVar);
        this.hYh = false;
        this.dve = new com.baidu.adp.framework.listener.a(1003343, CmdConfigSocket.CMD_CONCERN_PAGE) { // from class: com.baidu.tieba.homepage.concern.message.ConcernNetModel.1
            /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
            /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
            @Override // com.baidu.adp.framework.listener.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                if (responsedMessage != null && ConcernNetModel.this.hYf != null) {
                    ConcernNetModel.this.hYh = false;
                    if (responsedMessage.getOrginalMessage() != null) {
                        Object extra = responsedMessage.getOrginalMessage().getExtra();
                        if (extra instanceof ConcernPageRequestMessage) {
                            z = aq.isEmpty(((ConcernPageRequestMessage) extra).getPageTag());
                            if (responsedMessage.getError() == 0) {
                                ConcernNetModel.this.hYf.al(responsedMessage.getError(), responsedMessage.getErrorString());
                                return;
                            }
                            DataRes dataRes = null;
                            if (responsedMessage instanceof ConcernPageSocketResMessage) {
                                dataRes = ((ConcernPageSocketResMessage) responsedMessage).getResultData();
                            } else if (responsedMessage instanceof ConcernPageHttpResMessage) {
                                dataRes = ((ConcernPageHttpResMessage) responsedMessage).getResultData();
                            }
                            ConcernNetModel.this.hYf.b(dataRes, z);
                            return;
                        }
                    }
                    z = false;
                    if (responsedMessage.getError() == 0) {
                    }
                }
            }
        };
        this.hYi = new com.baidu.adp.framework.listener.a(1003344, CmdConfigSocket.CMD_CONCERN_CHECK_RED_NOTIFY) { // from class: com.baidu.tieba.homepage.concern.message.ConcernNetModel.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                CheckRedNotifySocketResMessage checkRedNotifySocketResMessage;
                boolean z;
                if (responsedMessage != null && ConcernNetModel.this.hYg != null && responsedMessage.getError() == 0) {
                    boolean z2 = false;
                    if (responsedMessage instanceof CheckRedNotifyHttpResMessage) {
                        CheckRedNotifyHttpResMessage checkRedNotifyHttpResMessage = (CheckRedNotifyHttpResMessage) responsedMessage;
                        if (checkRedNotifyHttpResMessage == null) {
                            z = false;
                        } else {
                            z = checkRedNotifyHttpResMessage.isShowRedNotify();
                        }
                        z2 = z;
                    } else if ((responsedMessage instanceof CheckRedNotifySocketResMessage) && (checkRedNotifySocketResMessage = (CheckRedNotifySocketResMessage) responsedMessage) != null) {
                        z2 = checkRedNotifySocketResMessage.isShowRedNotify();
                    }
                    ConcernNetModel.this.hYg.og(z2);
                    if (z2 && (responsedMessage.getmOrginalMessage().getExtra() instanceof CheckRedNotifyReqMessage) && ((CheckRedNotifyReqMessage) responsedMessage.getmOrginalMessage().getExtra()).reqUnreadTipAfterFinish) {
                        ConcernNetModel.this.sendMessage(new ConcernUnreadTipReqMessage());
                    }
                }
            }
        };
        setUniqueId(bdUniqueId);
        aTm();
        aTl();
        registerListener(this.dve);
        registerListener(this.hYi);
    }

    public void a(b bVar) {
        this.hYf = bVar;
    }

    public void a(a aVar) {
        this.hYg = aVar;
    }

    public void Fz(String str) {
        if (!this.hYh) {
            this.hYh = true;
            ConcernPageRequestMessage concernPageRequestMessage = new ConcernPageRequestMessage();
            concernPageRequestMessage.setPageTag(str);
            concernPageRequestMessage.setTag(getUniqueId());
            sendMessage(concernPageRequestMessage);
        }
    }

    public void of(boolean z) {
        CheckRedNotifyReqMessage checkRedNotifyReqMessage = new CheckRedNotifyReqMessage();
        checkRedNotifyReqMessage.setTag(getUniqueId());
        checkRedNotifyReqMessage.reqUnreadTipAfterFinish = z;
        sendMessage(checkRedNotifyReqMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        if (!this.hYh) {
            this.hYh = true;
            sendMessage(new ConcernPageRequestMessage());
        }
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.hYh = false;
        cancelMessage();
        return false;
    }

    private void aTl() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(CmdConfigSocket.CMD_CONCERN_PAGE);
        bVar.setResponsedClass(ConcernPageSocketResMessage.class);
        bVar.setNeedAck(true);
        MessageManager.getInstance().registerTask(bVar);
        com.baidu.tbadk.task.b bVar2 = new com.baidu.tbadk.task.b(CmdConfigSocket.CMD_CONCERN_CHECK_RED_NOTIFY);
        bVar2.setResponsedClass(CheckRedNotifySocketResMessage.class);
        bVar2.setNeedAck(true);
        MessageManager.getInstance().registerTask(bVar2);
    }

    private void aTm() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003343, com.baidu.tieba.tbadkCore.a.a.bF(TbConfig.URL_CONCERN_PAGE, CmdConfigSocket.CMD_CONCERN_PAGE));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(ConcernPageHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(1003344, com.baidu.tieba.tbadkCore.a.a.bF(TbConfig.URL_CONCERN_CHECK_RED_NOTIFY, CmdConfigSocket.CMD_CONCERN_CHECK_RED_NOTIFY));
        tbHttpMessageTask2.setIsNeedAddCommenParam(true);
        tbHttpMessageTask2.setResponsedClass(CheckRedNotifyHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }
}
