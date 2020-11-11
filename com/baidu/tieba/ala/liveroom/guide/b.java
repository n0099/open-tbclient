package com.baidu.tieba.ala.liveroom.guide;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes4.dex */
public class b extends BdBaseModel {
    private a hjn;
    private HttpMessageListener hjq = new HttpMessageListener(1021153) { // from class: com.baidu.tieba.ala.liveroom.guide.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021153 && (httpResponsedMessage instanceof YanZhiSignInHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    if (b.this.hjn != null) {
                        b.this.hjn.e(0, ((YanZhiSignInHttpResponseMessage) httpResponsedMessage).ccE(), ((YanZhiSignInHttpResponseMessage) httpResponsedMessage).ccF());
                    }
                } else if (b.this.hjn != null) {
                    b.this.hjn.e(httpResponsedMessage.getError(), true, true);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        void e(int i, boolean z, boolean z2);
    }

    public b(a aVar) {
        this.hjn = aVar;
        ccw();
        MessageManager.getInstance().registerListener(this.hjq);
    }

    private void ccw() {
        com.baidu.live.tieba.f.a.a.a(1021153, "ala/user/getUserSignInStatus", YanZhiSignInHttpResponseMessage.class, true, true, true, true);
    }

    public void ccx() {
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
        if (this.hjq != null) {
            MessageManager.getInstance().unRegisterListener(this.hjq);
        }
    }
}
