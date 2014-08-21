package com.baidu.tieba.game;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.message.http.GameHttpResponsedMessage;
/* loaded from: classes.dex */
class ai extends HttpMessageListener {
    final /* synthetic */ GameWebViewActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(GameWebViewActivity gameWebViewActivity, int i) {
        super(i);
        this.a = gameWebViewActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        int i;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002300 && httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof GameHttpResponsedMessage)) {
            String screenOrientation = ((GameHttpResponsedMessage) httpResponsedMessage).getScreenOrientation();
            GameWebViewActivity gameWebViewActivity = this.a;
            if (com.baidu.tbadk.core.frameworkData.a.PORTRAIT.equals(screenOrientation)) {
                i = 1;
            } else {
                i = 0;
            }
            gameWebViewActivity.setRequestedOrientation(i);
        }
    }
}
