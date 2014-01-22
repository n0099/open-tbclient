package com.baidu.tieba.account;

import android.content.Context;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.loginshare.LoginShareAssistant;
import com.baidu.loginshare.Token;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class l {
    private static l a = null;
    private n b = null;

    private l() {
    }

    public static l a() {
        if (a == null) {
            a = new l();
        }
        return a;
    }

    public void a(Context context) {
        try {
            LoginShareAssistant loginShareAssistant = LoginShareAssistant.getInstance();
            loginShareAssistant.initial(context, "tb", "1536");
            this.b = new n(this);
            loginShareAssistant.setLoginShareListener(this.b);
        } catch (Error e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "init", e.getMessage());
        }
    }

    public void a(Token token) {
        try {
            if (!TiebaApplication.n()) {
                LoginShareAssistant.getInstance().valid(token);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "valid", e.getMessage());
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
            com.baidu.adp.lib.g.e.b(getClass().getName(), "invalid", e.getMessage());
        }
    }

    public void b() {
        try {
            if (!TiebaApplication.n()) {
                LoginShareAssistant.getInstance().onActivityCreate();
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "onActivityCreate", e.getMessage());
        }
    }

    public void b(String str) {
        try {
            k c = a().c();
            if (c != null) {
                if ("null".equals(c.c) || (!com.baidu.tieba.util.bu.c(str) && str.equals(c.c))) {
                    TiebaApplication.h().aK();
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "tryToRemoveShareAccount", e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public k c() {
        k kVar;
        k kVar2;
        boolean z;
        k kVar3;
        String[] split;
        int length;
        boolean z2 = false;
        try {
        } catch (Exception e) {
            e = e;
            kVar = null;
        }
        if (!TiebaApplication.n()) {
            String aL = TiebaApplication.h().aL();
            if (!com.baidu.tieba.util.bu.c(aL)) {
                kVar = new k();
                try {
                    split = aL.split(":");
                    length = split.length;
                    z = length >= 1 ? SocialConstants.TRUE.equals(split[0]) : false;
                    if (length >= 2) {
                        try {
                            kVar.a = split[1];
                        } catch (Exception e2) {
                            z2 = z;
                            e = e2;
                            com.baidu.adp.lib.g.e.b(getClass().getName(), "getShareAccountData", e.getMessage());
                            kVar2 = kVar;
                            if (kVar2 == null) {
                            }
                        }
                    }
                    if (length >= 3) {
                        kVar.b = split[2];
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                if (length >= 4) {
                    if (split[3] == null || split[3].equalsIgnoreCase("null")) {
                        kVar.c = null;
                        z = false;
                        kVar3 = kVar;
                        boolean z3 = z;
                        kVar2 = kVar3;
                        z2 = z3;
                        if (kVar2 == null && z2) {
                            return kVar2;
                        }
                    }
                    kVar.c = split[3];
                }
                kVar3 = kVar;
                boolean z32 = z;
                kVar2 = kVar3;
                z2 = z32;
                return kVar2 == null ? null : null;
            }
        }
        z = false;
        kVar3 = null;
        boolean z322 = z;
        kVar2 = kVar3;
        z2 = z322;
        if (kVar2 == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, String str2, String str3) {
        TiebaApplication.h().r((z ? SocialConstants.TRUE : "2") + ":" + str + ":" + str2 + ":" + str3);
    }
}
