package com.baidu.tieba.account;

import android.app.Activity;
import com.baidu.loginshare.ILoginShareListener;
import com.baidu.loginshare.LoginShareEvent;
import com.baidu.loginshare.Token;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements ILoginShareListener {
    final /* synthetic */ l a;

    private n(l lVar) {
        this.a = lVar;
    }

    @Override // com.baidu.loginshare.ILoginShareListener
    public void onLoginShareEvent(Token token) {
        if (token != null) {
            TiebaApplication.F();
            LoginShareEvent loginShareEvent = token.mEvent;
            String str = token.mUsername;
            String str2 = token.mBduss;
            String str3 = token.mPtoken;
            if (loginShareEvent == LoginShareEvent.VALID) {
                if (str2 != null && str3 != null) {
                    com.baidu.tieba.util.bo.e(getClass().getName(), "onLoginShareEvent", "login");
                    this.a.a(true, str2, str3, str);
                    return;
                }
                return;
            }
            com.baidu.tieba.util.bo.e(getClass().getName(), "onLoginShareEvent", "logout");
            this.a.a(false, null, null, str);
            AccountData F = TiebaApplication.F();
            if (F != null && !com.baidu.tieba.util.bm.c(F.getAccount()) && F.getAccount().equals(token.mUsername)) {
                a.a().a((Activity) null, true);
                a.a().b("detect_bduss_logout");
            }
        }
    }
}
