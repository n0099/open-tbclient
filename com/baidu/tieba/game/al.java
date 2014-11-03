package com.baidu.tieba.game;

import android.graphics.Bitmap;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.GameHttpResponsedMessage;
/* loaded from: classes.dex */
public class al extends com.baidu.tbadk.browser.q {
    final /* synthetic */ GameWebViewActivity aIq;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public al(GameWebViewActivity gameWebViewActivity) {
        super(gameWebViewActivity);
        this.aIq = gameWebViewActivity;
    }

    @Override // com.baidu.tbadk.browser.q, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        HttpMessageListener httpMessageListener;
        super.onPageStarted(webView, str, bitmap);
        if (!com.baidu.tbadk.core.util.az.aA(str)) {
            MessageManager.getInstance().unRegisterListener(this.aIq.getUniqueId());
            MessageManager.getInstance().removeMessage(this.aIq.getUniqueId());
            HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.H5_GAME_HTTP_CMD, str);
            httpMessageTask.setResponsedClass(GameHttpResponsedMessage.class);
            MessageManager.getInstance().registerTask(httpMessageTask);
            GameWebViewActivity gameWebViewActivity = this.aIq;
            httpMessageListener = this.aIq.aIp;
            gameWebViewActivity.registerListener(httpMessageListener);
            MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.H5_GAME_HTTP_CMD));
        }
    }
}
