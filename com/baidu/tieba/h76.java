package com.baidu.tieba;

import android.webkit.JsPromptResult;
import android.webkit.WebView;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.HashMap;
/* loaded from: classes4.dex */
public interface h76 {
    public static final ServiceReference a = new ServiceReference("Frames", "JsPromptBridge");

    void a(WebView webView, String str, HashMap<String, Object> hashMap);

    boolean b(WebView webView, String str, JsPromptResult jsPromptResult);

    void c(j76 j76Var, Object obj);
}
