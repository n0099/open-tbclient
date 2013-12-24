package com.baidu.tieba.account;

import android.app.Activity;
import com.baidu.loginshare.Token;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.UtilHelper;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private static a a = null;
    private Activity b;
    private int c;
    private ArrayList<AccountData> e;
    private boolean d = false;
    private int f = 0;
    private boolean g = false;
    private be h = new c(this);
    private as i = new e(this);
    private as j = new g(this);
    private be k = new i(this);

    private a() {
    }

    public static a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    public static Token a(String str) {
        Token token;
        Exception e;
        String[] split;
        try {
            if (TiebaApplication.o() || str == null || (split = str.split("[|]")) == null || split.length < 1) {
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
                com.baidu.tieba.util.be.b("AccountShareHelper", "parseBDUSS", e.getMessage());
                return token;
            }
        } catch (Exception e3) {
            token = null;
            e = e3;
        }
    }

    public void a(Activity activity, boolean z) {
        Token a2;
        if (UtilHelper.b()) {
            this.b = activity;
            this.d = z;
            AccountData F = TiebaApplication.F();
            if (F != null && (a2 = a(F.getBDUSS())) != null) {
                bd.a(F.getAccount(), a2.mBduss, a2.mPtoken, this.h, false);
            }
        }
    }

    public void a(Activity activity, int i) {
        if (UtilHelper.b() && TiebaApplication.F() == null) {
            this.g = true;
            this.b = activity;
            this.c = i;
            b bVar = new b(this);
            bVar.setPriority(3);
            bVar.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        if (this.f < this.e.size()) {
            ArrayList<AccountData> arrayList = this.e;
            int i = this.f;
            this.f = i + 1;
            k a2 = a(arrayList.get(i));
            if (a2 == null) {
                return b();
            }
            bd.a(a2.c, a2.a, a2.b, this.k, false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        k d = l.a().d();
        if (d != null && this.b != null) {
            ReLoginShareActivity.a(this.b, d.c, d.a, d.b, this.c);
        }
    }

    private k a(AccountData accountData) {
        Token a2;
        if (accountData == null || accountData.getAccount().equals(TiebaApplication.G()) || (a2 = a(accountData.getBDUSS())) == null) {
            return null;
        }
        k kVar = new k();
        kVar.c = accountData.getAccount();
        kVar.a = a2.mBduss;
        kVar.b = a2.mPtoken;
        return kVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AccountData c(String str) {
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            AccountData accountData = this.e.get(i);
            if (accountData.getAccount().equals(str)) {
                return accountData;
            }
        }
        return null;
    }

    public void b(String str) {
        try {
            if (TiebaApplication.h().t()) {
                StatService.onEvent(TiebaApplication.h(), str, "click", 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
