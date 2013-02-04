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

    private a() {
    }

    public static a a() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    public void a(Activity activity) {
        String x;
        if (this.a != null && this.a.a && TiebaApplication.u() == null && ((x = TiebaApplication.x()) == null || !x.equals(this.a.d))) {
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
            com.baidu.tieba.c.ae.b(getClass().getName(), "init", e.getMessage());
        }
    }

    public void a(Token token) {
        if (token != null) {
            try {
                if (TiebaApplication.f()) {
                    return;
                }
                LoginShareAssistant.getInstance().invalid(token);
            } catch (Exception e) {
                com.baidu.tieba.c.ae.b(getClass().getName(), "invalid", e.getMessage());
            }
        }
    }

    public void a(String str) {
        String[] split;
        try {
            if (TiebaApplication.f()) {
                return;
            }
            Token token = new Token();
            if (str == null || (split = str.split("[|]")) == null || split.length != 2) {
                return;
            }
            token.mBduss = split[0];
            token.mPtoken = split[1];
            if (token.mPtoken == null || token.mPtoken.length() <= 0) {
                return;
            }
            LoginShareAssistant.getInstance().invalid(token);
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "invalid", e.getMessage());
        }
    }

    public void a(boolean z, String str, String str2, String str3) {
        TiebaApplication.a().i(String.valueOf(z ? "1:" : "2:") + str + ":" + str2 + ":" + str3);
    }

    public void b() {
        try {
            if (TiebaApplication.f()) {
                return;
            }
            Token token = new Token();
            String v = TiebaApplication.v();
            if (v != null) {
                e();
                String[] split = v.split("[|]");
                if (split == null || split.length != 2) {
                    return;
                }
                token.mBduss = split[0];
                token.mPtoken = split[1];
                if (token.mPtoken == null || token.mPtoken.length() <= 0) {
                    return;
                }
                token.mUsername = TiebaApplication.x();
                LoginShareAssistant.getInstance().valid(token);
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "valid", e.getMessage());
        }
    }

    public void c() {
        try {
            if (TiebaApplication.f()) {
                return;
            }
            LoginShareAssistant.getInstance().onActivityCreate();
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "onActivityCreate", e.getMessage());
        }
    }

    public void d() {
        String aq;
        try {
            if (TiebaApplication.f() || (aq = TiebaApplication.a().aq()) == null) {
                return;
            }
            this.a = new b(this);
            String[] split = aq.split(":");
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
            if (this.a == null || this.a.a) {
                return;
            }
            com.baidu.tieba.c.k.i();
            TiebaApplication.a((com.baidu.tieba.a.a) null);
            e();
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "prepare", e.getMessage());
        }
    }

    public void e() {
        this.a = null;
        TiebaApplication.a().ap();
    }

    public void f() {
        this.a = null;
    }
}
