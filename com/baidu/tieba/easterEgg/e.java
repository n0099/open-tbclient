package com.baidu.tieba.easterEgg;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.easterEgg.a.a cNA;
    private a cNB;
    private HttpMessageListener mNetListener = new HttpMessageListener(CmdConfigHttp.CMD_GET_RN_SYNC) { // from class: com.baidu.tieba.easterEgg.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof RnSyncResponseMessage) {
                RnSyncResponseMessage rnSyncResponseMessage = (RnSyncResponseMessage) httpResponsedMessage;
                e.this.cNA = rnSyncResponseMessage.getData();
                if (e.this.cNB != null) {
                    e.this.cNB.a(rnSyncResponseMessage.isSuccess(), rnSyncResponseMessage.getData());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void a(boolean z, com.baidu.tieba.easterEgg.a.a aVar);
    }

    public e() {
        MessageManager.getInstance().registerListener(this.mNetListener);
    }

    public void MO() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_RN_SYNC));
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mNetListener);
    }

    public void a(a aVar) {
        this.cNB = aVar;
    }
}
