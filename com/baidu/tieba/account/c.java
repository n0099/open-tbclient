package com.baidu.tieba.account;

import com.baidu.loginshare.ILoginShareListener;
import com.baidu.loginshare.LoginShareEvent;
import com.baidu.loginshare.Token;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements ILoginShareListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f874a;

    private c(a aVar) {
        this.f874a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(a aVar, c cVar) {
        this(aVar);
    }

    @Override // com.baidu.loginshare.ILoginShareListener
    public void onLoginShareEvent(Token token) {
        if (token != null) {
            LoginShareEvent loginShareEvent = token.mEvent;
            String str = token.mUsername;
            String str2 = token.mBduss;
            String str3 = token.mPtoken;
            com.baidu.tieba.util.aj.e(getClass().getName(), "onLoginShareEvent", "bduss = " + str2);
            com.baidu.tieba.util.aj.e(getClass().getName(), "onLoginShareEvent", "username = " + str);
            com.baidu.tieba.util.aj.e(getClass().getName(), "onLoginShareEvent", "ptoken = " + str3);
            if (loginShareEvent == LoginShareEvent.VALID) {
                if (str2 != null && str3 != null) {
                    com.baidu.tieba.util.aj.e(getClass().getName(), "onLoginShareEvent", "login");
                    this.f874a.a(true, str2, str3, str);
                    return;
                }
                return;
            }
            com.baidu.tieba.util.aj.e(getClass().getName(), "onLoginShareEvent", "logout");
            this.f874a.a(false, null, null, null);
        }
    }
}
