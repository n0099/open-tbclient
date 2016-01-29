package com.baidu.tieba.account;

import android.webkit.JsPromptResult;
/* loaded from: classes.dex */
class o implements com.baidu.tieba.tbadkCore.e.c {
    final /* synthetic */ AccountRestoreActivity aJe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(AccountRestoreActivity accountRestoreActivity) {
        this.aJe = accountRestoreActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.e.c
    public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
        com.baidu.tieba.tbadkCore.e.a aVar;
        com.baidu.tieba.tbadkCore.e.a aVar2;
        aVar = this.aJe.jsBridge;
        if (aVar != null) {
            aVar2 = this.aJe.jsBridge;
            return aVar2.a(str, jsPromptResult);
        }
        return false;
    }
}
