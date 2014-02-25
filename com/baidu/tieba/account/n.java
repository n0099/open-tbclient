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
    final /* synthetic */ m a;

    private n(m mVar) {
        this.a = mVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(m mVar, n nVar) {
        this(mVar);
    }

    @Override // com.baidu.loginshare.ILoginShareListener
    public void onLoginShareEvent(Token token) {
        if (token != null) {
            TiebaApplication.E();
            LoginShareEvent loginShareEvent = token.mEvent;
            String str = token.mUsername;
            String str2 = token.mBduss;
            String str3 = token.mPtoken;
            if (loginShareEvent == LoginShareEvent.VALID) {
                if (str2 != null && str3 != null) {
                    com.baidu.adp.lib.util.f.e(getClass().getName(), "onLoginShareEvent", "login");
                    this.a.a(true, str2, str3, str);
                    return;
                }
                return;
            }
            com.baidu.adp.lib.util.f.e(getClass().getName(), "onLoginShareEvent", "logout");
            this.a.a(false, null, null, str);
            AccountData E = TiebaApplication.E();
            o a = a.a(E.getBDUSS());
            if (E != null && !com.baidu.tieba.util.bs.c(E.getAccount()) && E.getAccount().equals(str) && a != null && !com.baidu.tieba.util.bs.c(a.a) && a.a.equals(str2)) {
                a.a().a((Activity) null, true);
                a.a().b("detect_bduss_logout");
            }
        }
    }
}
