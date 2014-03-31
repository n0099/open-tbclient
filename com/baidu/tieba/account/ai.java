package com.baidu.tieba.account;

import android.os.Handler;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.plugins.BdSapiCoreLightDelegate;
/* loaded from: classes.dex */
final class ai implements BdSapiCoreLightDelegate.SapiCoreLightCallback {
    final /* synthetic */ SapiFastRegActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(SapiFastRegActivity sapiFastRegActivity) {
        this.a = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.plugins.BdSapiCoreLightDelegate.SapiCoreLightCallback
    public final void onAuthorizationSuccess(String str, String str2, String str3, String str4, String str5) {
        Handler handler;
        com.baidu.tbadk.core.a.u uVar;
        if (!bc.c(str)) {
            this.a.b = "login_user";
            uVar = this.a.e;
            com.baidu.tbadk.core.a.t.a(str, str2, str3, uVar, true);
            return;
        }
        AccountData accountData = new AccountData();
        accountData.setAccount(str);
        accountData.setID(str4);
        accountData.setBDUSS(String.valueOf(str2) + "|" + str3);
        accountData.setPortrait(str5);
        this.a.b = "regist_user";
        handler = this.a.d;
        handler.post(new aj(this, accountData));
    }

    @Override // com.baidu.tbadk.plugins.BdSapiCoreLightDelegate.SapiCoreLightCallback
    public final void onAuthorizationFailed(int i, String str) {
        com.baidu.adp.lib.util.f.e("simon", "onFailed", str);
        this.a.finish();
    }

    @Override // com.baidu.tbadk.plugins.BdSapiCoreLightDelegate.SapiCoreLightCallback
    public final void finishActivity() {
        this.a.finish();
    }
}
