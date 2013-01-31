package com.baidu.tieba.account;

import android.app.Activity;
import android.content.Context;
import com.baidu.loginshare.LoginShareAssistant;
import com.baidu.loginshare.Token;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class a {
    private static a b = null;
    private b a = null;
    private c c = null;

    public static a a() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    private a() {
    }

    public void b() {
        try {
            if (!TiebaApplication.g()) {
                Token token = new Token();
                String x = TiebaApplication.x();
                if (x != null) {
                    e();
                    String[] split = x.split("[|]");
                    if (split != null && split.length == 2) {
                        token.mBduss = split[0];
                        token.mPtoken = split[1];
                        if (token.mPtoken != null && token.mPtoken.length() > 0) {
                            token.mUsername = TiebaApplication.A();
                            LoginShareAssistant.getInstance().valid(token);
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.af.b(getClass().getName(), "valid", e.getMessage());
        }
    }

    public void a(String str) {
        String[] split;
        try {
            if (!TiebaApplication.g()) {
                Token token = new Token();
                if (str != null && (split = str.split("[|]")) != null && split.length == 2) {
                    token.mBduss = split[0];
                    token.mPtoken = split[1];
                    if (token.mPtoken != null && token.mPtoken.length() > 0) {
                        LoginShareAssistant.getInstance().invalid(token);
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.af.b(getClass().getName(), "invalid", e.getMessage());
        }
    }

    public void a(Token token) {
        if (token != null) {
            try {
                if (!TiebaApplication.g()) {
                    LoginShareAssistant.getInstance().invalid(token);
                }
            } catch (Exception e) {
                com.baidu.tieba.c.af.b(getClass().getName(), "invalid", e.getMessage());
            }
        }
    }

    public void c() {
        try {
            if (!TiebaApplication.g()) {
                LoginShareAssistant.getInstance().onActivityCreate();
            }
        } catch (Exception e) {
            com.baidu.tieba.c.af.b(getClass().getName(), "onActivityCreate", e.getMessage());
        }
    }

    public void d() {
        String at;
        try {
            if (!TiebaApplication.g() && (at = TiebaApplication.b().at()) != null) {
                this.a = new b(this);
                String[] split = at.split(":");
                int length = split.length;
                if (length >= 1) {
                    if ("1".equals(split[0])) {
                        this.a.a = true;
                    } else {
                        this.a.a = false;
                    }
                }
                if (length >= 2) {
                    this.a.b = split[1];
                }
                if (length >= 3) {
                    this.a.c = split[2];
                }
                if (length >= 4) {
                    if (split[3] == null || split[3].equalsIgnoreCase("null")) {
                        this.a.d = null;
                    } else {
                        this.a.d = split[3];
                    }
                }
                if (this.a != null && !this.a.a) {
                    com.baidu.tieba.c.k.i();
                    TiebaApplication.a((com.baidu.tieba.a.a) null);
                    e();
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.af.b(getClass().getName(), "prepare", e.getMessage());
        }
    }

    public static Token b(String str) {
        Token token;
        Exception e;
        String[] split;
        try {
            if (TiebaApplication.g() || str == null || (split = str.split("[|]")) == null || split.length < 1) {
                return null;
            }
            token = new Token();
            try {
                token.mBduss = split[0];
                if (split.length >= 2) {
                    token.mPtoken = split[1];
                    return token;
                }
                return token;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.c.af.b("AccountShareHelper", "parseBDUSS", e.getMessage());
                return token;
            }
        } catch (Exception e3) {
            token = null;
            e = e3;
        }
    }

    public void e() {
        this.a = null;
        TiebaApplication.b().as();
    }

    public void f() {
        this.a = null;
    }

    public void a(Activity activity) {
        String A;
        if (this.a != null && this.a.a && TiebaApplication.w() == null && ((A = TiebaApplication.A()) == null || !A.equals(this.a.d))) {
            ReLoginShareActivity.a(activity, this.a.d, this.a.b, this.a.c);
        }
        f();
    }

    public void a(Context context) {
        try {
            LoginShareAssistant loginShareAssistant = LoginShareAssistant.getInstance();
            loginShareAssistant.initial(context, "tb", "1536");
            this.c = new c(this, null);
            loginShareAssistant.setLoginShareListener(this.c);
        } catch (Exception e) {
            com.baidu.tieba.c.af.b(getClass().getName(), "init", e.getMessage());
        }
    }

    public void a(boolean z, String str, String str2, String str3) {
        String str4 = "1:";
        if (!z) {
            str4 = "2:";
        }
        TiebaApplication.b().j(String.valueOf(str4) + str + ":" + str2 + ":" + str3);
    }
}
