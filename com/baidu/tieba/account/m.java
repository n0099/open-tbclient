package com.baidu.tieba.account;

import android.text.TextUtils;
import android.webkit.JsPromptResult;
/* loaded from: classes.dex */
class m implements com.baidu.tieba.tbadkCore.e.b {
    final /* synthetic */ AccountRestoreActivity aIk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(AccountRestoreActivity accountRestoreActivity) {
        this.aIk = accountRestoreActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.e.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (TextUtils.equals("AccountJsBridge", str) && TextUtils.equals("exit", str2)) {
            jsPromptResult.confirm();
            this.aIk.exitPage();
            return true;
        }
        return false;
    }
}
