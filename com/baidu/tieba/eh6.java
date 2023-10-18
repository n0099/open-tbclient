package com.baidu.tieba;

import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.core.util.Pair;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface eh6 {
    public static final ServiceReference a = new ServiceReference("Frames", "JsPromptBridge");

    void a(List<Pair<String, String>> list);

    void b(String str, HashMap<String, Object> hashMap);

    boolean c(WebView webView, String str, JsPromptResult jsPromptResult);

    void d(View view2, String str, HashMap<String, Object> hashMap);

    void e(View view2, String str, ValueCallback<String> valueCallback);

    void f(gh6 gh6Var, Object obj);

    void g(String str, JSONObject jSONObject, WebView webView);

    void h(String str, JSONObject jSONObject);

    void i(View view2, String str, JSONObject jSONObject);
}
