package com.baidu.tieba.account;

import android.webkit.JsPromptResult;
/* loaded from: classes.dex */
class n implements com.baidu.tieba.tbadkCore.e.c {
    final /* synthetic */ AccountRestoreActivity aMa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(AccountRestoreActivity accountRestoreActivity) {
        this.aMa = accountRestoreActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.e.c
    public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
        com.baidu.tieba.tbadkCore.e.a aVar;
        com.baidu.tieba.tbadkCore.e.a aVar2;
        aVar = this.aMa.jsBridge;
        if (aVar != null) {
            aVar2 = this.aMa.jsBridge;
            return aVar2.a(str, jsPromptResult);
        }
        return false;
    }
}
