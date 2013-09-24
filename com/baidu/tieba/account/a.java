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
    private b f883a = null;
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
            if (!TiebaApplication.n()) {
                Token token = new Token();
                String E = TiebaApplication.E();
                if (E != null) {
                    d();
                    String[] split = E.split("[|]");
                    if (split != null && split.length == 2) {
                        token.mBduss = split[0];
                        token.mPtoken = split[1];
                        if (token.mPtoken != null && token.mPtoken.length() > 0) {
                            token.mUsername = TiebaApplication.G();
                            LoginShareAssistant.getInstance().valid(token);
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.av.b(getClass().getName(), "valid", e.getMessage());
        }
    }

    public void a(String str) {
        String[] split;
        try {
            if (!TiebaApplication.n()) {
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
            com.baidu.tieba.util.av.b(getClass().getName(), "invalid", e.getMessage());
        }
    }

    public void a(Token token) {
        if (token != null) {
            try {
                if (!TiebaApplication.n()) {
                    LoginShareAssistant.getInstance().invalid(token);
                }
            } catch (Exception e) {
                com.baidu.tieba.util.av.b(getClass().getName(), "invalid", e.getMessage());
            }
        }
    }

    public void c() {
        try {
            if (!TiebaApplication.n()) {
                LoginShareAssistant.getInstance().onActivityCreate();
            }
        } catch (Exception e) {
            com.baidu.tieba.util.av.b(getClass().getName(), "onActivityCreate", e.getMessage());
        }
    }

    public void a(Context context) {
        String aH;
        try {
            if (!TiebaApplication.n() && (aH = TiebaApplication.g().aH()) != null) {
                this.f883a = new b(this);
                String[] split = aH.split(":");
                int length = split.length;
                if (length >= 1) {
                    if ("1".equals(split[0])) {
                        this.f883a.f910a = true;
                    } else {
                        this.f883a.f910a = false;
                    }
                }
                if (length >= 2) {
                    this.f883a.b = split[1];
                }
                if (length >= 3) {
                    this.f883a.c = split[2];
                }
                if (length >= 4) {
                    if (split[3] == null || split[3].equalsIgnoreCase("null")) {
                        this.f883a.d = null;
                    } else {
                        this.f883a.d = split[3];
                    }
                }
                if (this.f883a != null && !this.f883a.f910a) {
                    DatabaseService.k();
                    TiebaApplication.a((AccountData) null, context);
                    d();
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.av.b(getClass().getName(), "prepare", e.getMessage());
        }
    }

    public static Token b(String str) {
        Token token;
        Exception e;
        String[] split;
        try {
            if (TiebaApplication.n() || str == null || (split = str.split("[|]")) == null || split.length < 1) {
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
                com.baidu.tieba.util.av.b("AccountShareHelper", "parseBDUSS", e.getMessage());
                return token;
            }
        } catch (Exception e3) {
            token = null;
            e = e3;
        }
    }

    public void d() {
        this.f883a = null;
        TiebaApplication.g().aG();
    }

    public void e() {
        this.f883a = null;
    }

    public void a(Activity activity, int i) {
        String G;
        if (this.f883a != null && this.f883a.f910a && TiebaApplication.C() == null && ((G = TiebaApplication.G()) == null || !G.equals(this.f883a.d))) {
            ReLoginShareActivity.a(activity, this.f883a.d, this.f883a.b, this.f883a.c, i);
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
            com.baidu.tieba.util.av.b(getClass().getName(), "init", e.getMessage());
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
