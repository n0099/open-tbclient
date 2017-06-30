package com.baidu.tieba.bigv;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0060a byl;
    private boolean mIsLoading = false;
    private com.baidu.adp.framework.listener.a mNetMessageListener = new b(this, CmdConfigHttp.CMD_CHECK_BIG_V, 309463);
    private g<?> mPageContext;
    private long mUserId;

    /* renamed from: com.baidu.tieba.bigv.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0060a {
        void a(int i, String str, long j, boolean z);
    }

    public void a(InterfaceC0060a interfaceC0060a) {
        this.byl = interfaceC0060a;
    }

    public a(g<?> gVar, BdUniqueId bdUniqueId) {
        this.mPageContext = gVar;
        this.mNetMessageListener.setTag(bdUniqueId);
        this.mNetMessageListener.getSocketMessageListener().isSelfListener();
        this.mNetMessageListener.getHttpMessageListener().isSelfListener();
        gVar.registerListener(this.mNetMessageListener);
        Ty();
        UP();
    }

    private void Ty() {
        com.baidu.tieba.tbadkCore.a.a.a(309463, CmdConfigHttp.CMD_CHECK_BIG_V, TbConfig.URL_CHECK_BIG_V, BigVCheckHttpResponseMessage.class, true, true, true, true);
    }

    private void UP() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(309463);
        socketMessageTask.m(true);
        socketMessageTask.setResponsedClass(BigVCheckSocketResponseMessage.class);
        socketMessageTask.n(false);
        MessageManager.getInstance().registerTask(socketMessageTask);
    }

    public void aJ(long j) {
        if (!this.mIsLoading) {
            this.mUserId = j;
            this.mIsLoading = true;
            BigVCheckRequestMessage bigVCheckRequestMessage = new BigVCheckRequestMessage();
            bigVCheckRequestMessage.setUserId(j);
            this.mPageContext.sendMessage(bigVCheckRequestMessage);
        }
    }
}
