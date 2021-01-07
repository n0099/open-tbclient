package com.baidu.tieba.easterEgg;

import android.webkit.JsPromptResult;
import com.baidu.tbadk.core.util.at;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class EasterEggBridge implements com.baidu.tieba.tbadkCore.e.b {
    private static final String KEY_ARGS = "args";
    private static final String KEY_ARGS_EXT = "native_exts";
    private static final String KEY_CALLBACK = "native_clbk";
    private static final String KEY_INTERFACE_NAME = "EasterEggBridge";
    private static final String KEY_METHOD_NAME = "method_name";
    private List<b> mListener = new ArrayList();

    public EasterEggBridge() {
        addListener(new com.baidu.tieba.easterEgg.b.a.b());
        addListener(new com.baidu.tieba.easterEgg.b.a.c());
        addListener(new com.baidu.tieba.easterEgg.b.a.a());
    }

    public void addListener(b bVar) {
        if (bVar != null && this.mListener != null) {
            this.mListener.add(bVar);
        }
    }

    public void removeListener(b bVar) {
        if (bVar != null && this.mListener != null) {
            this.mListener.remove(bVar);
        }
    }

    public void clearListener() {
        if (this.mListener != null) {
            this.mListener.clear();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.e.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (KEY_INTERFACE_NAME.equals(str2)) {
            try {
                JSONObject jSONObject = new JSONObject(str3);
                String optString = jSONObject.optString(KEY_METHOD_NAME);
                if (!at.isEmpty(str2)) {
                    String trim = optString.trim();
                    for (b bVar : this.mListener) {
                        if (trim.equals(bVar.cxb())) {
                            bVar.a(trim, jSONObject.optString(KEY_ARGS), jSONObject.optString(KEY_ARGS_EXT), jSONObject.optString(KEY_CALLBACK), jsPromptResult);
                        }
                    }
                }
            } catch (JSONException e) {
            }
        }
        return false;
    }
}
