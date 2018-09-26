package com.baidu.tieba.homeExtra.b;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.q.c;
/* loaded from: classes3.dex */
public class a implements c.a {
    @Override // com.baidu.tieba.q.c.a
    public void autoTrace(Context context) {
        StatService.autoTrace(context);
    }

    @Override // com.baidu.tieba.q.c.a
    public void setAppChannel(Context context, String str, boolean z) {
        StatService.setAppChannel(context, str, z);
    }

    @Override // com.baidu.tieba.q.c.a
    public void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        StatService.trackWebView(context, webView, webChromeClient);
    }
}
