package com.baidu.tieba.account;

import android.webkit.JsPromptResult;
/* loaded from: classes.dex */
class m implements com.baidu.tieba.tbadkCore.e.c {
    final /* synthetic */ AccountRestoreActivity aGA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(AccountRestoreActivity accountRestoreActivity) {
        this.aGA = accountRestoreActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.e.c
    public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
        com.baidu.tieba.tbadkCore.e.a aVar;
        com.baidu.tieba.tbadkCore.e.a aVar2;
        aVar = this.aGA.jsBridge;
        if (aVar != null) {
            aVar2 = this.aGA.jsBridge;
            return aVar2.a(str, jsPromptResult);
        }
        return false;
    }
}
