package com.baidu.tieba.easterEgg;

import android.webkit.JsPromptResult;
import d.b.c.e.p.k;
import d.b.j0.d3.l0.b;
import d.b.j0.g0.f.a.a;
import d.b.j0.g0.f.a.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class EasterEggBridge implements b {
    public static final String KEY_ARGS = "args";
    public static final String KEY_ARGS_EXT = "native_exts";
    public static final String KEY_CALLBACK = "native_clbk";
    public static final String KEY_INTERFACE_NAME = "EasterEggBridge";
    public static final String KEY_METHOD_NAME = "method_name";
    public List<d.b.j0.g0.b> mListener = new ArrayList();

    public EasterEggBridge() {
        addListener(new d.b.j0.g0.f.a.b());
        addListener(new c());
        addListener(new a());
    }

    public void addListener(d.b.j0.g0.b bVar) {
        List<d.b.j0.g0.b> list;
        if (bVar == null || (list = this.mListener) == null) {
            return;
        }
        list.add(bVar);
    }

    public void clearListener() {
        List<d.b.j0.g0.b> list = this.mListener;
        if (list != null) {
            list.clear();
        }
    }

    @Override // d.b.j0.d3.l0.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (KEY_INTERFACE_NAME.equals(str2)) {
            try {
                JSONObject jSONObject = new JSONObject(str3);
                String optString = jSONObject.optString("method_name");
                if (k.isEmpty(str2)) {
                    return false;
                }
                String trim = optString.trim();
                for (d.b.j0.g0.b bVar : this.mListener) {
                    if (trim.equals(bVar.b())) {
                        bVar.a(trim, jSONObject.optString("args"), jSONObject.optString(KEY_ARGS_EXT), jSONObject.optString(KEY_CALLBACK), jsPromptResult);
                    }
                }
            } catch (JSONException unused) {
            }
        }
        return false;
    }

    public void removeListener(d.b.j0.g0.b bVar) {
        List<d.b.j0.g0.b> list;
        if (bVar == null || (list = this.mListener) == null) {
            return;
        }
        list.remove(bVar);
    }
}
