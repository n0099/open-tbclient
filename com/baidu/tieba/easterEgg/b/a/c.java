package com.baidu.tieba.easterEgg.b.a;

import android.webkit.JsPromptResult;
/* loaded from: classes8.dex */
public class c implements com.baidu.tieba.easterEgg.b {
    @Override // com.baidu.tieba.easterEgg.b
    public String cxa() {
        return "showNativeDialog";
    }

    @Override // com.baidu.tieba.easterEgg.b
    public void a(String str, String str2, String str3, String str4, JsPromptResult jsPromptResult) {
        if (cxa().equals(str)) {
            try {
                com.baidu.tieba.easterEgg.a.cwV().eP(str2, str3);
            } catch (Throwable th) {
                com.baidu.tieba.easterEgg.a.cwV().cwW();
            }
        }
    }
}
