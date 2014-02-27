package com.baidu.tieba.account;

import android.app.Activity;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.loginshare.ILoginShareListener;
import com.baidu.loginshare.LoginShareEvent;
import com.baidu.loginshare.Token;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n implements ILoginShareListener {
    final /* synthetic */ m a;

    private n(m mVar) {
        this.a = mVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(m mVar, byte b) {
        this(mVar);
    }

    @Override // com.baidu.loginshare.ILoginShareListener
    public final void onLoginShareEvent(Token token) {
        if (token != null) {
            TiebaApplication.y();
            LoginShareEvent loginShareEvent = token.mEvent;
            String str = token.mUsername;
            String str2 = token.mBduss;
            String str3 = token.mPtoken;
            if (loginShareEvent == LoginShareEvent.VALID) {
                if (str2 != null && str3 != null) {
                    com.baidu.adp.lib.util.e.e(getClass().getName(), "onLoginShareEvent", "login");
                    m mVar = this.a;
                    TiebaApplication.g().q(String.valueOf(r3 ? SocialConstants.TRUE : "2") + ":" + str2 + ":" + str3 + ":" + str);
                    return;
                }
                return;
            }
            com.baidu.adp.lib.util.e.e(getClass().getName(), "onLoginShareEvent", "logout");
            m mVar2 = this.a;
            TiebaApplication.g().q(String.valueOf(r3 ? SocialConstants.TRUE : "2") + ":" + null + ":" + null + ":" + str);
            AccountData y = TiebaApplication.y();
            o a = a.a(y.getBDUSS());
            if (y != null && !com.baidu.tieba.util.bs.c(y.getAccount()) && y.getAccount().equals(str) && a != null && !com.baidu.tieba.util.bs.c(a.a) && a.a.equals(str2)) {
                a.a().a((Activity) null, true);
                a.a();
                a.b("detect_bduss_logout");
            }
        }
    }
}
