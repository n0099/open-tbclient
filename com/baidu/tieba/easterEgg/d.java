package com.baidu.tieba.easterEgg;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes24.dex */
public class d {
    private HttpMessageListener fmn = new HttpMessageListener(CmdConfigHttp.CMD_GET_RN_SYNC) { // from class: com.baidu.tieba.easterEgg.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof RnSyncResponseMessage) {
                RnSyncResponseMessage rnSyncResponseMessage = (RnSyncResponseMessage) httpResponsedMessage;
                d.this.irX = rnSyncResponseMessage.getData();
                if (d.this.irY != null) {
                    d.this.irY.a(rnSyncResponseMessage.isSuccess(), rnSyncResponseMessage.getData());
                }
            }
        }
    };
    private com.baidu.tieba.easterEgg.a.a irX;
    private a irY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes24.dex */
    public interface a {
        void a(boolean z, com.baidu.tieba.easterEgg.a.a aVar);
    }

    public d() {
        MessageManager.getInstance().registerListener(this.fmn);
    }

    public void startLoad() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_RN_SYNC));
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fmn);
    }

    public void a(a aVar) {
        this.irY = aVar;
    }
}
