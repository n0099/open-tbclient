package com.baidu.tieba.account;

import android.content.Context;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.loginshare.LoginShareAssistant;
import com.baidu.loginshare.Token;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public final class m {
    private static m a = null;
    private n b = null;

    private m() {
    }

    public static m a() {
        if (a == null) {
            a = new m();
        }
        return a;
    }

    public final void a(Context context) {
        try {
            LoginShareAssistant loginShareAssistant = LoginShareAssistant.getInstance();
            loginShareAssistant.initial(context, "tb", "1536");
            this.b = new n(this, (byte) 0);
            loginShareAssistant.setLoginShareListener(this.b);
        } catch (Error e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "init", e.getMessage());
        }
    }

    public final void b() {
        try {
            Token token = new Token();
            String x = TiebaApplication.x();
            if (x != null) {
                TiebaApplication.g();
                TiebaApplication.aC();
                String[] split = x.split("[|]");
                if (split != null && split.length == 2) {
                    token.mBduss = split[0];
                    token.mPtoken = split[1];
                    if (token.mPtoken != null && token.mPtoken.length() > 0) {
                        token.mUsername = TiebaApplication.z();
                        LoginShareAssistant.getInstance().valid(token);
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "valid", e.getMessage());
        }
    }

    public final void a(String str) {
        String[] split;
        try {
            Token token = new Token();
            if (str != null && (split = str.split("[|]")) != null && split.length == 2) {
                token.mBduss = split[0];
                token.mPtoken = split[1];
                if (token.mPtoken != null && token.mPtoken.length() > 0) {
                    LoginShareAssistant.getInstance().invalid(token);
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "invalid", e.getMessage());
        }
    }

    public final void c() {
        try {
            LoginShareAssistant.getInstance().onActivityCreate();
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "onActivityCreate", e.getMessage());
        }
    }

    public final void b(String str) {
        try {
            l d = a().d();
            if (d != null) {
                if ("null".equals(d.c) || (!com.baidu.tieba.util.bs.c(str) && str.equals(d.c))) {
                    TiebaApplication.g();
                    TiebaApplication.aC();
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "tryToRemoveShareAccount", e.getMessage());
        }
    }

    public final l d() {
        l lVar;
        l lVar2;
        boolean z = false;
        try {
            String aD = TiebaApplication.g().aD();
            if (com.baidu.tieba.util.bs.c(aD)) {
                lVar2 = null;
            } else {
                l lVar3 = new l();
                try {
                    String[] split = aD.split(":");
                    int length = split.length;
                    boolean equals = length > 0 ? SocialConstants.TRUE.equals(split[0]) : false;
                    if (length >= 2) {
                        try {
                            lVar3.a = split[1];
                        } catch (Exception e) {
                            e = e;
                            z = equals;
                            lVar = lVar3;
                            com.baidu.adp.lib.util.e.b(getClass().getName(), "getShareAccountData", e.getMessage());
                            lVar2 = lVar;
                            if (lVar2 == null) {
                            }
                            return null;
                        }
                    }
                    if (length >= 3) {
                        lVar3.b = split[2];
                    }
                    if (length < 4) {
                        z = equals;
                        lVar2 = lVar3;
                    } else if (split[3] == null || split[3].equalsIgnoreCase("null")) {
                        lVar3.c = null;
                        lVar2 = lVar3;
                    } else {
                        lVar3.c = split[3];
                        z = equals;
                        lVar2 = lVar3;
                    }
                } catch (Exception e2) {
                    e = e2;
                    lVar = lVar3;
                }
            }
        } catch (Exception e3) {
            e = e3;
            lVar = null;
        }
        if (lVar2 == null && z) {
            return lVar2;
        }
        return null;
    }
}
