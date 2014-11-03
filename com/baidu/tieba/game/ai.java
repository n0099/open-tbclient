package com.baidu.tieba.game;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.message.http.GameHttpResponsedMessage;
/* loaded from: classes.dex */
class ai extends HttpMessageListener {
    final /* synthetic */ GameWebViewActivity aIq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(GameWebViewActivity gameWebViewActivity, int i) {
        super(i);
        this.aIq = gameWebViewActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002300 && httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof GameHttpResponsedMessage)) {
            String screenOrientation = ((GameHttpResponsedMessage) httpResponsedMessage).getScreenOrientation();
            if (com.baidu.tbadk.core.frameworkData.a.PORTRAIT.equals(screenOrientation)) {
                this.aIq.setRequestedOrientation(1);
            } else if ("landscape".equals(screenOrientation)) {
                this.aIq.setRequestedOrientation(0);
            }
        }
    }
}
