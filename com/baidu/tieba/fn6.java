package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.webkit.sdk.WebView;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface fn6 {
    public static final ServiceReference a = new ServiceReference(WebView.LOGTAG, "IWebViewDebug");

    JSONObject a();

    void b();

    void c();
}
