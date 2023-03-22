package com.baidu.tieba;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes3.dex */
public interface be6 {
    public static final ServiceReference a = new ServiceReference(WebView.LOGTAG, "IWebViewFactoryService");

    void a(android.webkit.WebView webView);

    android.webkit.WebView b(Context context);
}
