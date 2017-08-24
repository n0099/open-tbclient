package com.baidu.tieba.bigv;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.g.b;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0075a bEm;
    private boolean mIsLoading = false;
    private com.baidu.adp.framework.listener.a mNetMessageListener = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CHECK_BIG_V, 309463) { // from class: com.baidu.tieba.bigv.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            a.this.mIsLoading = false;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                Message<?> orginalMessage = responsedMessage.getOrginalMessage();
                if (orginalMessage.getExtra() instanceof BigVCheckRequestMessage) {
                    BigVCheckRequestMessage bigVCheckRequestMessage = (BigVCheckRequestMessage) orginalMessage.getExtra();
                    if (responsedMessage.hasError() || a.this.mUserId == bigVCheckRequestMessage.getUserId()) {
                        int error = responsedMessage.getError();
                        String errorString = responsedMessage.getErrorString();
                        boolean isBigV = responsedMessage instanceof BigVCheckSocketResponseMessage ? ((BigVCheckSocketResponseMessage) responsedMessage).isBigV() : responsedMessage instanceof BigVCheckHttpResponseMessage ? ((BigVCheckHttpResponseMessage) responsedMessage).isBigV() : false;
                        if (b.d(TbadkCoreApplication.getCurrentAccount(), 0L) == a.this.mUserId && TbadkCoreApplication.getCurrentAccountObj() != null) {
                            TbadkCoreApplication.getCurrentAccountObj().setIsBigV(isBigV);
                        }
                        if (a.this.bEm != null) {
                            a.this.bEm.a(error, errorString, a.this.mUserId, isBigV);
                        }
                    }
                }
            }
        }
    };
    private e<?> mPageContext;
    private long mUserId;

    /* renamed from: com.baidu.tieba.bigv.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0075a {
        void a(int i, String str, long j, boolean z);
    }

    public void a(InterfaceC0075a interfaceC0075a) {
        this.bEm = interfaceC0075a;
    }

    public a(e<?> eVar, BdUniqueId bdUniqueId) {
        this.mPageContext = eVar;
        this.mNetMessageListener.setTag(bdUniqueId);
        this.mNetMessageListener.getSocketMessageListener().isSelfListener();
        this.mNetMessageListener.getHttpMessageListener().isSelfListener();
        eVar.registerListener(this.mNetMessageListener);
        UH();
        VV();
    }

    private void UH() {
        com.baidu.tieba.tbadkCore.a.a.a(309463, CmdConfigHttp.CMD_CHECK_BIG_V, TbConfig.URL_CHECK_BIG_V, BigVCheckHttpResponseMessage.class, true, true, true, true);
    }

    private void VV() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(309463);
        socketMessageTask.m(true);
        socketMessageTask.setResponsedClass(BigVCheckSocketResponseMessage.class);
        socketMessageTask.n(false);
        MessageManager.getInstance().registerTask(socketMessageTask);
    }

    public void aL(long j) {
        if (!this.mIsLoading) {
            this.mUserId = j;
            this.mIsLoading = true;
            BigVCheckRequestMessage bigVCheckRequestMessage = new BigVCheckRequestMessage();
            bigVCheckRequestMessage.setUserId(j);
            this.mPageContext.sendMessage(bigVCheckRequestMessage);
        }
    }
}
