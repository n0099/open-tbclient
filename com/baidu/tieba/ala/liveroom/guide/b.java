package com.baidu.tieba.ala.liveroom.guide;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes4.dex */
public class b extends BdBaseModel {
    private a gnc;
    private HttpMessageListener gnf = new HttpMessageListener(1021153) { // from class: com.baidu.tieba.ala.liveroom.guide.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021153 && (httpResponsedMessage instanceof YanZhiSignInHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    if (b.this.gnc != null) {
                        b.this.gnc.d(0, ((YanZhiSignInHttpResponseMessage) httpResponsedMessage).bIl(), ((YanZhiSignInHttpResponseMessage) httpResponsedMessage).bIm());
                    }
                } else if (b.this.gnc != null) {
                    b.this.gnc.d(httpResponsedMessage.getError(), true, true);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        void d(int i, boolean z, boolean z2);
    }

    public b(a aVar) {
        this.gnc = aVar;
        bId();
        MessageManager.getInstance().registerListener(this.gnf);
    }

    private void bId() {
        com.baidu.live.tieba.f.a.a.a(1021153, "ala/user/getUserSignInStatus", YanZhiSignInHttpResponseMessage.class, true, true, true, true);
    }

    public void bIe() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021153));
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(1021153);
        if (this.gnf != null) {
            MessageManager.getInstance().unRegisterListener(this.gnf);
        }
    }
}
