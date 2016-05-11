package com.baidu.tieba.account;

import android.webkit.JsPromptResult;
/* loaded from: classes.dex */
class n implements com.baidu.tieba.tbadkCore.e.c {
    final /* synthetic */ AccountRestoreActivity aIk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(AccountRestoreActivity accountRestoreActivity) {
        this.aIk = accountRestoreActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.e.c
    public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
        com.baidu.tieba.tbadkCore.e.a aVar;
        com.baidu.tieba.tbadkCore.e.a aVar2;
        aVar = this.aIk.jsBridge;
        if (aVar != null) {
            aVar2 = this.aIk.jsBridge;
            return aVar2.b(str, jsPromptResult);
        }
        return false;
    }
}
