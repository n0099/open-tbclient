package com.baidu.tieba.account;

import android.text.TextUtils;
import android.webkit.JsPromptResult;
/* loaded from: classes.dex */
class n implements com.baidu.tieba.tbadkCore.e.b {
    final /* synthetic */ AccountRestoreActivity aVJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(AccountRestoreActivity accountRestoreActivity) {
        this.aVJ = accountRestoreActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.e.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (TextUtils.equals("AccountJsBridge", str) && TextUtils.equals("exit", str2)) {
            jsPromptResult.confirm();
            this.aVJ.exitPage();
            return true;
        }
        return false;
    }
}
