package com.baidu.tieba.easterEgg.b.a;

import android.webkit.JsPromptResult;
/* loaded from: classes8.dex */
public class b implements com.baidu.tieba.easterEgg.b {
    @Override // com.baidu.tieba.easterEgg.b
    public String cuv() {
        return "showH5Dialog";
    }

    @Override // com.baidu.tieba.easterEgg.b
    public void a(String str, String str2, String str3, String str4, JsPromptResult jsPromptResult) {
        if (cuv().equals(str)) {
            try {
                com.baidu.tieba.easterEgg.a.cuq().Jb(str2);
            } catch (Throwable th) {
                com.baidu.tieba.easterEgg.a.cuq().cur();
            }
        }
    }
}
