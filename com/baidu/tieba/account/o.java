package com.baidu.tieba.account;

import android.webkit.JsPromptResult;
/* loaded from: classes.dex */
class o implements com.baidu.tieba.tbadkCore.e.c {
    final /* synthetic */ AccountRestoreActivity aVw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(AccountRestoreActivity accountRestoreActivity) {
        this.aVw = accountRestoreActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.e.c
    public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
        com.baidu.tieba.tbadkCore.e.a aVar;
        com.baidu.tieba.tbadkCore.e.a aVar2;
        aVar = this.aVw.jsBridge;
        if (aVar != null) {
            aVar2 = this.aVw.jsBridge;
            return aVar2.b(str, jsPromptResult);
        }
        return false;
    }
}
