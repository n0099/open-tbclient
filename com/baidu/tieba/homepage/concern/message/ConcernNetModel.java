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
/* loaded from: classes2.dex */
public class ConcernNetModel extends BdBaseModel<BaseFragmentActivity> {
    private b dTF;
    private a dTG;
    private com.baidu.adp.framework.listener.a dTH;
    private com.baidu.adp.framework.listener.a mNetMessageListener;

    /* loaded from: classes2.dex */
    public interface a {
        void gJ(boolean z);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void b(DataRes dataRes, boolean z);

        void s(int i, String str);
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
                if (responsedMessage != null && ConcernNetModel.this.dTF != null) {
                    if (responsedMessage.getOrginalMessage() != null) {
                        Object extra = responsedMessage.getOrginalMessage().getExtra();
                        if (extra instanceof ConcernPageRequestMessage) {
                            z = ap.isEmpty(((ConcernPageRequestMessage) extra).getPageTag());
                            if (responsedMessage.getError() == 0) {
                                ConcernNetModel.this.dTF.s(responsedMessage.getError(), responsedMessage.getErrorString());
                                return;
                            }
                            DataRes dataRes = null;
                            if (responsedMessage instanceof ConcernPageSocketResMessage) {
                                dataRes = ((ConcernPageSocketResMessage) responsedMessage).getResultData();
                            } else if (responsedMessage instanceof ConcernPageHttpResMessage) {
                                dataRes = ((ConcernPageHttpResMessage) responsedMessage).getResultData();
                            }
                            ConcernNetModel.this.dTF.b(dataRes, z);
                            return;
                        }
                    }
                    z = false;
                    if (responsedMessage.getError() == 0) {
                    }
                }
            }
        };
        this.dTH = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_CHECK_RED_NOTIFY, 309476) { // from class: com.baidu.tieba.homepage.concern.message.ConcernNetModel.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                CheckRedNotifySocketResMessage checkRedNotifySocketResMessage;
                boolean z;
                if (responsedMessage != null && ConcernNetModel.this.dTG != null && responsedMessage.getError() == 0) {
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
                    ConcernNetModel.this.dTG.gJ(z2);
                    if (z2 && (responsedMessage.getmOrginalMessage().getExtra() instanceof CheckRedNotifyReqMessage) && ((CheckRedNotifyReqMessage) responsedMessage.getmOrginalMessage().getExtra()).reqUnreadTipAfterFinish) {
                        ConcernNetModel.this.sendMessage(new ConcernUnreadTipReqMessage());
                    }
                }
            }
        };
        setUniqueId(bdUniqueId);
        ahh();
        akm();
        registerListener(this.mNetMessageListener);
        registerListener(this.dTH);
    }

    public void a(b bVar) {
        this.dTF = bVar;
    }

    public void a(a aVar) {
        this.dTG = aVar;
    }

    public void nv(String str) {
        ConcernPageRequestMessage concernPageRequestMessage = new ConcernPageRequestMessage();
        concernPageRequestMessage.setPageTag(str);
        concernPageRequestMessage.setTag(getUniqueId());
        sendMessage(concernPageRequestMessage);
    }

    public void gI(boolean z) {
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

    private void akm() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309474);
        bVar.setResponsedClass(ConcernPageSocketResMessage.class);
        bVar.n(true);
        MessageManager.getInstance().registerTask(bVar);
        com.baidu.tbadk.task.b bVar2 = new com.baidu.tbadk.task.b(309476);
        bVar2.setResponsedClass(CheckRedNotifySocketResMessage.class);
        bVar2.n(true);
        MessageManager.getInstance().registerTask(bVar2);
    }

    private void ahh() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_PAGE, com.baidu.tieba.tbadkCore.a.a.aK(TbConfig.URL_CONCERN_PAGE, 309474));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(ConcernPageHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_CHECK_RED_NOTIFY, com.baidu.tieba.tbadkCore.a.a.aK(TbConfig.URL_CONCERN_CHECK_RED_NOTIFY, 309476));
        tbHttpMessageTask2.setIsNeedAddCommenParam(true);
        tbHttpMessageTask2.setResponsedClass(CheckRedNotifyHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }
}
