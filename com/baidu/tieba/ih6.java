package com.baidu.tieba;

import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.core.util.Pair;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public interface ih6 {
    public static final ServiceReference a = new ServiceReference("Frames", "JsPromptBridge");

    void a(List<Pair<String, String>> list);

    void b(String str, HashMap<String, Object> hashMap);

    boolean c(WebView webView, String str, JsPromptResult jsPromptResult);

    void d(View view2, String str, HashMap<String, Object> hashMap);

    void e(View view2, String str, ValueCallback<String> valueCallback);

    void f(kh6 kh6Var, Object obj);
}
