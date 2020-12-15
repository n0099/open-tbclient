package com.baidu.tieba.ala.liveroom.guide;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes4.dex */
public class b extends BdBaseModel {
    private a hst;
    private HttpMessageListener hsw = new HttpMessageListener(1021153) { // from class: com.baidu.tieba.ala.liveroom.guide.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021153 && (httpResponsedMessage instanceof YanZhiSignInHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    if (b.this.hst != null) {
                        b.this.hst.e(0, ((YanZhiSignInHttpResponseMessage) httpResponsedMessage).cfQ(), ((YanZhiSignInHttpResponseMessage) httpResponsedMessage).cfR());
                    }
                } else if (b.this.hst != null) {
                    b.this.hst.e(httpResponsedMessage.getError(), true, true);
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
        this.hst = aVar;
        cfI();
        MessageManager.getInstance().registerListener(this.hsw);
    }

    private void cfI() {
        com.baidu.live.tieba.f.a.a.a(1021153, "ala/user/getUserSignInStatus", YanZhiSignInHttpResponseMessage.class, true, true, true, true);
    }

    public void cfJ() {
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
        if (this.hsw != null) {
            MessageManager.getInstance().unRegisterListener(this.hsw);
        }
    }
}
