package com.baidu.tieba.easterEgg.b.a;

import android.webkit.JsPromptResult;
/* loaded from: classes3.dex */
public class c implements com.baidu.tieba.easterEgg.c {
    @Override // com.baidu.tieba.easterEgg.c
    public String getMethodName() {
        return "showNativeDialog";
    }

    @Override // com.baidu.tieba.easterEgg.c
    public void a(String str, String str2, String str3, String str4, JsPromptResult jsPromptResult) {
        if (getMethodName().equals(str)) {
            com.baidu.tieba.easterEgg.b.anp().aV(str2, str3);
        }
    }
}
