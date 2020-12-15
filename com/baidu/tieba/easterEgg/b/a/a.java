package com.baidu.tieba.easterEgg.b.a;

import android.webkit.JsPromptResult;
/* loaded from: classes24.dex */
public class a implements com.baidu.tieba.easterEgg.b {
    @Override // com.baidu.tieba.easterEgg.b
    public String getMethodName() {
        return "closeDialog";
    }

    @Override // com.baidu.tieba.easterEgg.b
    public void a(String str, String str2, String str3, String str4, JsPromptResult jsPromptResult) {
        if (getMethodName().equals(str)) {
            com.baidu.tieba.easterEgg.a.cue().cuf();
        }
    }
}
