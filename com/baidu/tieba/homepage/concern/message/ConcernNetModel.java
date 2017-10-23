package com.baidu.tieba.homepage.concern.message;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.story.l;
import tbclient.Userlike.DataRes;
/* loaded from: classes.dex */
public class ConcernNetModel extends BdBaseModel<BaseFragmentActivity> {
    private b cWl;
    private a cWm;
    private com.baidu.adp.framework.listener.a cWn;
    private com.baidu.adp.framework.listener.a mNetMessageListener;

    /* loaded from: classes.dex */
    public interface a {
        void fA(boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void b(DataRes dataRes, boolean z);

        void r(int i, String str);
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
                if (responsedMessage != null && ConcernNetModel.this.cWl != null) {
                    if (responsedMessage.getOrginalMessage() != null) {
                        Object extra = responsedMessage.getOrginalMessage().getExtra();
                        if (extra instanceof ConcernPageRequestMessage) {
                            z = am.isEmpty(((ConcernPageRequestMessage) extra).getPageTag());
                            if (responsedMessage.getError() == 0) {
                                ConcernNetModel.this.cWl.r(responsedMessage.getError(), responsedMessage.getErrorString());
                                return;
                            }
                            DataRes dataRes = null;
                            if (responsedMessage instanceof ConcernPageSocketResMessage) {
                                dataRes = ((ConcernPageSocketResMessage) responsedMessage).getResultData();
                            } else if (responsedMessage instanceof ConcernPageHttpResMessage) {
                                dataRes = ((ConcernPageHttpResMessage) responsedMessage).getResultData();
                            }
                            ConcernNetModel.this.cWl.b(dataRes, z);
                            l.bmR().bmU();
                            return;
                        }
                    }
                    z = false;
                    if (responsedMessage.getError() == 0) {
                    }
                }
            }
        };
        this.cWn = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_CHECK_RED_NOTIFY, 309476) { // from class: com.baidu.tieba.homepage.concern.message.ConcernNetModel.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                CheckRedNotifySocketResMessage checkRedNotifySocketResMessage;
                if (responsedMessage != null && ConcernNetModel.this.cWm != null && responsedMessage.getError() == 0) {
                    boolean z = false;
                    if (responsedMessage instanceof CheckRedNotifyHttpResMessage) {
                        CheckRedNotifyHttpResMessage checkRedNotifyHttpResMessage = (CheckRedNotifyHttpResMessage) responsedMessage;
                        if (checkRedNotifyHttpResMessage != null) {
                            z = checkRedNotifyHttpResMessage.isShowRedNotify();
                        }
                    } else if ((responsedMessage instanceof CheckRedNotifySocketResMessage) && (checkRedNotifySocketResMessage = (CheckRedNotifySocketResMessage) responsedMessage) != null) {
                        z = checkRedNotifySocketResMessage.isShowRedNotify();
                    }
                    ConcernNetModel.this.cWm.fA(z);
                }
            }
        };
        setUniqueId(bdUniqueId);
        VU();
        Za();
        registerListener(this.mNetMessageListener);
        registerListener(this.cWn);
    }

    public void a(b bVar) {
        this.cWl = bVar;
    }

    public void a(a aVar) {
        this.cWm = aVar;
    }

    public void lp(String str) {
        ConcernPageRequestMessage concernPageRequestMessage = new ConcernPageRequestMessage();
        concernPageRequestMessage.setPageTag(str);
        concernPageRequestMessage.setTag(getUniqueId());
        sendMessage(concernPageRequestMessage);
    }

    public void aoX() {
        CheckRedNotifyReqMessage checkRedNotifyReqMessage = new CheckRedNotifyReqMessage();
        checkRedNotifyReqMessage.setTag(getUniqueId());
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

    private void Za() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309474);
        bVar.setResponsedClass(ConcernPageSocketResMessage.class);
        bVar.m(true);
        MessageManager.getInstance().registerTask(bVar);
        com.baidu.tbadk.task.b bVar2 = new com.baidu.tbadk.task.b(309476);
        bVar2.setResponsedClass(CheckRedNotifySocketResMessage.class);
        bVar2.m(true);
        MessageManager.getInstance().registerTask(bVar2);
    }

    private void VU() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_PAGE, com.baidu.tieba.tbadkCore.a.a.ay(TbConfig.URL_CONCERN_PAGE, 309474));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(ConcernPageHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_CHECK_RED_NOTIFY, com.baidu.tieba.tbadkCore.a.a.ay(TbConfig.URL_CONCERN_CHECK_RED_NOTIFY, 309476));
        tbHttpMessageTask2.setIsNeedAddCommenParam(true);
        tbHttpMessageTask2.setResponsedClass(CheckRedNotifyHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }
}
