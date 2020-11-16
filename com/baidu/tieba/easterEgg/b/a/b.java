package com.baidu.tieba.easterEgg.b.a;

import android.webkit.JsPromptResult;
/* loaded from: classes23.dex */
public class b implements com.baidu.tieba.easterEgg.b {
    @Override // com.baidu.tieba.easterEgg.b
    public String getMethodName() {
        return "showH5Dialog";
    }

    @Override // com.baidu.tieba.easterEgg.b
    public void a(String str, String str2, String str3, String str4, JsPromptResult jsPromptResult) {
        if (getMethodName().equals(str)) {
            try {
                com.baidu.tieba.easterEgg.a.cpP().IO(str2);
            } catch (Throwable th) {
                com.baidu.tieba.easterEgg.a.cpP().cpQ();
            }
        }
    }
}
