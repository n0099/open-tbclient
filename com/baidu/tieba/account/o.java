package com.baidu.tieba.account;

import android.webkit.JsPromptResult;
/* loaded from: classes.dex */
class o implements com.baidu.tieba.tbadkCore.e.c {
    final /* synthetic */ AccountRestoreActivity aWh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(AccountRestoreActivity accountRestoreActivity) {
        this.aWh = accountRestoreActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.e.c
    public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
        com.baidu.tieba.tbadkCore.e.a aVar;
        com.baidu.tieba.tbadkCore.e.a aVar2;
        aVar = this.aWh.jsBridge;
        if (aVar != null) {
            aVar2 = this.aWh.jsBridge;
            return aVar2.b(str, jsPromptResult);
        }
        return false;
    }
}
