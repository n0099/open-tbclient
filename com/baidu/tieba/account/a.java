package com.baidu.tieba.account;

import android.app.Activity;
import android.content.Context;
import com.baidu.loginshare.LoginShareAssistant;
import com.baidu.loginshare.Token;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
public class a {
    private static a b = null;

    /* renamed from: a  reason: collision with root package name */
    private b f867a = null;
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
            if (!TiebaApplication.p()) {
                Token token = new Token();
                String G = TiebaApplication.G();
                if (G != null) {
                    d();
                    String[] split = G.split("[|]");
                    if (split != null && split.length == 2) {
                        token.mBduss = split[0];
                        token.mPtoken = split[1];
                        if (token.mPtoken != null && token.mPtoken.length() > 0) {
                            token.mUsername = TiebaApplication.I();
                            LoginShareAssistant.getInstance().valid(token);
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "valid", e.getMessage());
        }
    }

    public void a(String str) {
        String[] split;
        try {
            if (!TiebaApplication.p()) {
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
            com.baidu.tieba.util.aq.b(getClass().getName(), "invalid", e.getMessage());
        }
    }

    public void a(Token token) {
        if (token != null) {
            try {
                if (!TiebaApplication.p()) {
                    LoginShareAssistant.getInstance().invalid(token);
                }
            } catch (Exception e) {
                com.baidu.tieba.util.aq.b(getClass().getName(), "invalid", e.getMessage());
            }
        }
    }

    public void c() {
        try {
            if (!TiebaApplication.p()) {
                LoginShareAssistant.getInstance().onActivityCreate();
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "onActivityCreate", e.getMessage());
        }
    }

    public void a(Context context) {
        String aH;
        try {
            if (!TiebaApplication.p() && (aH = TiebaApplication.g().aH()) != null) {
                this.f867a = new b(this);
                String[] split = aH.split(":");
                int length = split.length;
                if (length >= 1) {
                    if ("1".equals(split[0])) {
                        this.f867a.f894a = true;
                    } else {
                        this.f867a.f894a = false;
                    }
                }
                if (length >= 2) {
                    this.f867a.b = split[1];
                }
                if (length >= 3) {
                    this.f867a.c = split[2];
                }
                if (length >= 4) {
                    if (split[3] == null || split[3].equalsIgnoreCase("null")) {
                        this.f867a.d = null;
                    } else {
                        this.f867a.d = split[3];
                    }
                }
                if (this.f867a != null && !this.f867a.f894a) {
                    DatabaseService.k();
                    TiebaApplication.a((AccountData) null, context);
                    d();
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "prepare", e.getMessage());
        }
    }

    public static Token b(String str) {
        Token token;
        Exception e;
        String[] split;
        try {
            if (TiebaApplication.p() || str == null || (split = str.split("[|]")) == null || split.length < 1) {
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
                com.baidu.tieba.util.aq.b("AccountShareHelper", "parseBDUSS", e.getMessage());
                return token;
            }
        } catch (Exception e3) {
            token = null;
            e = e3;
        }
    }

    public void d() {
        this.f867a = null;
        TiebaApplication.g().aG();
    }

    public void e() {
        this.f867a = null;
    }

    public void a(Activity activity, int i) {
        String I;
        if (this.f867a != null && this.f867a.f894a && TiebaApplication.E() == null && ((I = TiebaApplication.I()) == null || !I.equals(this.f867a.d))) {
            ReLoginShareActivity.a(activity, this.f867a.d, this.f867a.b, this.f867a.c, i);
        }
        e();
    }

    public void b(Context context) {
        try {
            LoginShareAssistant loginShareAssistant = LoginShareAssistant.getInstance();
            loginShareAssistant.initial(context, "tb", "1536");
            this.c = new c(this, null);
            loginShareAssistant.setLoginShareListener(this.c);
        } catch (Error e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "init", e.getMessage());
        }
    }

    public void a(boolean z, String str, String str2, String str3) {
        String str4 = "1:";
        if (!z) {
            str4 = "2:";
        }
        TiebaApplication.g().r(String.valueOf(str4) + str + ":" + str2 + ":" + str3);
    }
}
