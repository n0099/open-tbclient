package com.baidu.tieba.easterEgg.b.a;

import android.webkit.JsPromptResult;
/* loaded from: classes6.dex */
public class a implements com.baidu.tieba.easterEgg.c {
    @Override // com.baidu.tieba.easterEgg.c
    public String bfl() {
        return "closeDialog";
    }

    @Override // com.baidu.tieba.easterEgg.c
    public void a(String str, String str2, String str3, String str4, JsPromptResult jsPromptResult) {
        if (bfl().equals(str)) {
            com.baidu.tieba.easterEgg.b.bfg().bfh();
        }
    }
}
