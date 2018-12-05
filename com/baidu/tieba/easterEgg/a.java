package com.baidu.tieba.easterEgg;

import android.webkit.JsPromptResult;
import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements com.baidu.tieba.tbadkCore.e.b {
    private List<c> dlT = new ArrayList();

    public a() {
        a(new com.baidu.tieba.easterEgg.b.a.b());
        a(new com.baidu.tieba.easterEgg.b.a.c());
        a(new com.baidu.tieba.easterEgg.b.a.a());
    }

    public void a(c cVar) {
        if (cVar != null && this.dlT != null) {
            this.dlT.add(cVar);
        }
    }

    public void aul() {
        if (this.dlT != null) {
            this.dlT.clear();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.e.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if ("EasterEggBridge".equals(str2)) {
            try {
                JSONObject jSONObject = new JSONObject(str3);
                String optString = jSONObject.optString("method_name");
                if (!ao.isEmpty(str2)) {
                    String trim = optString.trim();
                    for (c cVar : this.dlT) {
                        if (trim.equals(cVar.getMethodName())) {
                            cVar.a(trim, jSONObject.optString("args"), jSONObject.optString("native_exts"), jSONObject.optString("native_clbk"), jsPromptResult);
                        }
                    }
                }
            } catch (JSONException e) {
            }
        }
        return false;
    }
}
