package com.baidu.tieba.easterEgg.b.a;

import android.webkit.JsPromptResult;
/* loaded from: classes7.dex */
public class c implements com.baidu.tieba.easterEgg.b {
    @Override // com.baidu.tieba.easterEgg.b
    public String ctj() {
        return "showNativeDialog";
    }

    @Override // com.baidu.tieba.easterEgg.b
    public void a(String str, String str2, String str3, String str4, JsPromptResult jsPromptResult) {
        if (ctj().equals(str)) {
            try {
                com.baidu.tieba.easterEgg.a.cte().eO(str2, str3);
            } catch (Throwable th) {
                com.baidu.tieba.easterEgg.a.cte().ctf();
            }
        }
    }
}
