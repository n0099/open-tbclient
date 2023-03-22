package com.baidu.tieba;

import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.core.util.Pair;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public interface hd6 {
    public static final ServiceReference a = new ServiceReference("Frames", "JsPromptBridge");

    void a(WebView webView, String str, HashMap<String, Object> hashMap);

    void b(List<Pair<String, String>> list);

    boolean c(WebView webView, String str, JsPromptResult jsPromptResult);

    void d(jd6 jd6Var, Object obj);
}
