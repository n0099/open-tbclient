package com.baidu.tieba.easterEgg.b.a;

import android.webkit.JsPromptResult;
/* loaded from: classes6.dex */
public class b implements com.baidu.tieba.easterEgg.c {
    @Override // com.baidu.tieba.easterEgg.c
    public String beH() {
        return "showH5Dialog";
    }

    @Override // com.baidu.tieba.easterEgg.c
    public void a(String str, String str2, String str3, String str4, JsPromptResult jsPromptResult) {
        if (beH().equals(str)) {
            try {
                com.baidu.tieba.easterEgg.b.beC().vR(str2);
            } catch (Throwable th) {
                com.baidu.tieba.easterEgg.b.beC().beD();
            }
        }
    }
}
