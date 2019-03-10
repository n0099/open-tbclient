package com.baidu.tieba.homepage.concern.message;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipReqMessage;
import tbclient.Userlike.DataRes;
/* loaded from: classes4.dex */
public class ConcernNetModel extends BdBaseModel<BaseFragmentActivity> {
    private b fHd;
    private a fHe;
    private com.baidu.adp.framework.listener.a fHf;
    private com.baidu.adp.framework.listener.a mNetMessageListener;

    /* loaded from: classes4.dex */
    public interface a {
        void ki(boolean z);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void J(int i, String str);

        void a(DataRes dataRes, boolean z);
    }

    public ConcernNetModel(e<BaseFragmentActivity> eVar, BdUniqueId bdUniqueId) {
        super(eVar);
        this.mNetMessageListener = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_PAGE, 309474) { // from class: com.baidu.tieba.homepage.concern.message.ConcernNetModel.1
            /* JADX WARN: Removed duplicated region for block: B:13:0x002e  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
            @Override // com.baidu.adp.framework.listener.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                if (responsedMessage != null && ConcernNetModel.this.fHd != null) {
                    if (responsedMessage.getOrginalMessage() != null) {
                        Object extra = responsedMessage.getOrginalMessage().getExtra();
                        if (extra instanceof ConcernPageRequestMessage) {
                            z = ap.isEmpty(((ConcernPageRequestMessage) extra).getPageTag());
                            if (responsedMessage.getError() == 0) {
                                ConcernNetModel.this.fHd.J(responsedMessage.getError(), responsedMessage.getErrorString());
                                return;
                            }
                            DataRes dataRes = null;
                            if (responsedMessage instanceof ConcernPageSocketResMessage) {
                                dataRes = ((ConcernPageSocketResMessage) responsedMessage).getResultData();
                            } else if (responsedMessage instanceof ConcernPageHttpResMessage) {
                                dataRes = ((ConcernPageHttpResMessage) responsedMessage).getResultData();
                            }
                            ConcernNetModel.this.fHd.a(dataRes, z);
                            return;
                        }
                    }
                    z = false;
                    if (responsedMessage.getError() == 0) {
                    }
                }
            }
        };
        this.fHf = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_CHECK_RED_NOTIFY, 309476) { // from class: com.baidu.tieba.homepage.concern.message.ConcernNetModel.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                CheckRedNotifySocketResMessage checkRedNotifySocketResMessage;
                boolean z;
                if (responsedMessage != null && ConcernNetModel.this.fHe != null && responsedMessage.getError() == 0) {
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
                    ConcernNetModel.this.fHe.ki(z2);
                    if (z2 && (responsedMessage.getmOrginalMessage().getExtra() instanceof CheckRedNotifyReqMessage) && ((CheckRedNotifyReqMessage) responsedMessage.getmOrginalMessage().getExtra()).reqUnreadTipAfterFinish) {
                        ConcernNetModel.this.sendMessage(new ConcernUnreadTipReqMessage());
                    }
                }
            }
        };
        setUniqueId(bdUniqueId);
        aOR();
        aRQ();
        registerListener(this.mNetMessageListener);
        registerListener(this.fHf);
    }

    public void a(b bVar) {
        this.fHd = bVar;
    }

    public void a(a aVar) {
        this.fHe = aVar;
    }

    public void we(String str) {
        ConcernPageRequestMessage concernPageRequestMessage = new ConcernPageRequestMessage();
        concernPageRequestMessage.setPageTag(str);
        concernPageRequestMessage.setTag(getUniqueId());
        sendMessage(concernPageRequestMessage);
    }

    public void kh(boolean z) {
        CheckRedNotifyReqMessage checkRedNotifyReqMessage = new CheckRedNotifyReqMessage();
        checkRedNotifyReqMessage.setTag(getUniqueId());
        checkRedNotifyReqMessage.reqUnreadTipAfterFinish = z;
        sendMessage(checkRedNotifyReqMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        sendMessage(new ConcernPageRequestMessage());
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    private void aRQ() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309474);
        bVar.setResponsedClass(ConcernPageSocketResMessage.class);
        bVar.L(true);
        MessageManager.getInstance().registerTask(bVar);
        com.baidu.tbadk.task.b bVar2 = new com.baidu.tbadk.task.b(309476);
        bVar2.setResponsedClass(CheckRedNotifySocketResMessage.class);
        bVar2.L(true);
        MessageManager.getInstance().registerTask(bVar2);
    }

    private void aOR() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_PAGE, com.baidu.tieba.tbadkCore.a.a.br(TbConfig.URL_CONCERN_PAGE, 309474));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(ConcernPageHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_CHECK_RED_NOTIFY, com.baidu.tieba.tbadkCore.a.a.br(TbConfig.URL_CONCERN_CHECK_RED_NOTIFY, 309476));
        tbHttpMessageTask2.setIsNeedAddCommenParam(true);
        tbHttpMessageTask2.setResponsedClass(CheckRedNotifyHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }
}
