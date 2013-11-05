package com.baidu.tieba.account;

import android.app.Activity;
import android.content.Context;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.loginshare.LoginShareAssistant;
import com.baidu.loginshare.Token;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.be;
/* loaded from: classes.dex */
public class a {
    private static a b = null;

    /* renamed from: a  reason: collision with root package name */
    private c f1012a = null;
    private d c = null;

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
                String F = TiebaApplication.F();
                if (F != null) {
                    d();
                    String[] split = F.split("[|]");
                    if (split != null && split.length == 2) {
                        token.mBduss = split[0];
                        token.mPtoken = split[1];
                        if (token.mPtoken != null && token.mPtoken.length() > 0) {
                            token.mUsername = TiebaApplication.H();
                            LoginShareAssistant.getInstance().valid(token);
                        }
                    }
                }
            }
        } catch (Exception e) {
            be.b(getClass().getName(), "valid", e.getMessage());
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
            be.b(getClass().getName(), "invalid", e.getMessage());
        }
    }

    public void a(Token token) {
        if (token != null) {
            try {
                if (!TiebaApplication.n()) {
                    LoginShareAssistant.getInstance().invalid(token);
                }
            } catch (Exception e) {
                be.b(getClass().getName(), "invalid", e.getMessage());
            }
        }
    }

    public void c() {
        try {
            if (!TiebaApplication.n()) {
                LoginShareAssistant.getInstance().onActivityCreate();
            }
        } catch (Exception e) {
            be.b(getClass().getName(), "onActivityCreate", e.getMessage());
        }
    }

    public void a(Context context) {
        String aM;
        try {
            if (!TiebaApplication.n() && (aM = TiebaApplication.g().aM()) != null) {
                this.f1012a = new c(this);
                String[] split = aM.split(":");
                int length = split.length;
                if (length >= 1) {
                    if (SocialConstants.TRUE.equals(split[0])) {
                        this.f1012a.f1040a = true;
                    } else {
                        this.f1012a.f1040a = false;
                    }
                }
                if (length >= 2) {
                    this.f1012a.b = split[1];
                }
                if (length >= 3) {
                    this.f1012a.c = split[2];
                }
                if (length >= 4) {
                    if (split[3] == null || split[3].equalsIgnoreCase("null")) {
                        this.f1012a.d = null;
                    } else {
                        this.f1012a.d = split[3];
                    }
                }
                if (this.f1012a != null && !this.f1012a.f1040a) {
                    DatabaseService.k();
                    TiebaApplication.a((AccountData) null, context);
                    d();
                }
            }
        } catch (Exception e) {
            be.b(getClass().getName(), "prepare", e.getMessage());
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
                be.b("AccountShareHelper", "parseBDUSS", e.getMessage());
                return token;
            }
        } catch (Exception e3) {
            token = null;
            e = e3;
        }
    }

    public void d() {
        this.f1012a = null;
        TiebaApplication.g().aL();
    }

    public void e() {
        this.f1012a = null;
    }

    public void a(Activity activity, int i) {
        String H;
        if (this.f1012a != null && this.f1012a.f1040a && TiebaApplication.C() == null && ((H = TiebaApplication.H()) == null || !H.equals(this.f1012a.d))) {
            ReLoginShareActivity.a(activity, this.f1012a.d, this.f1012a.b, this.f1012a.c, i);
        }
        e();
    }

    public void b(Context context) {
        try {
            LoginShareAssistant loginShareAssistant = LoginShareAssistant.getInstance();
            loginShareAssistant.initial(context, "tb", "1536");
            this.c = new d(this);
            loginShareAssistant.setLoginShareListener(this.c);
        } catch (Error e) {
            be.b(getClass().getName(), "init", e.getMessage());
        }
    }

    public void a(boolean z, String str, String str2, String str3) {
        String str4 = "1:";
        if (!z) {
            str4 = "2:";
        }
        TiebaApplication.g().r(str4 + str + ":" + str2 + ":" + str3);
    }
}
