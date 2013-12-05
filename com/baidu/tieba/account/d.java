package com.baidu.tieba.account;

import com.baidu.loginshare.ILoginShareListener;
import com.baidu.loginshare.LoginShareEvent;
import com.baidu.loginshare.Token;
import com.baidu.tieba.util.bd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements ILoginShareListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1076a;

    private d(a aVar) {
        this.f1076a = aVar;
    }

    @Override // com.baidu.loginshare.ILoginShareListener
    public void onLoginShareEvent(Token token) {
        if (token != null) {
            LoginShareEvent loginShareEvent = token.mEvent;
            String str = token.mUsername;
            String str2 = token.mBduss;
            String str3 = token.mPtoken;
            bd.e(getClass().getName(), "onLoginShareEvent", "bduss = " + str2);
            bd.e(getClass().getName(), "onLoginShareEvent", "username = " + str);
            bd.e(getClass().getName(), "onLoginShareEvent", "ptoken = " + str3);
            if (loginShareEvent == LoginShareEvent.VALID) {
                if (str2 != null && str3 != null) {
                    bd.e(getClass().getName(), "onLoginShareEvent", "login");
                    this.f1076a.a(true, str2, str3, str);
                    return;
                }
                return;
            }
            bd.e(getClass().getName(), "onLoginShareEvent", "logout");
            this.f1076a.a(false, null, null, null);
        }
    }
}
