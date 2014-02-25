package com.baidu.tieba.account;

import android.app.Activity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.cb;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private static a a = null;
    private Activity b;
    private int c;
    private ArrayList<AccountData> f;
    private k d = null;
    private boolean e = false;
    private int g = 0;
    private boolean h = false;
    private az i = new b(this);
    private at j = new d(this);
    private at k = new f(this);
    private az l = new h(this);

    public void a(k kVar) {
        this.d = kVar;
    }

    private a() {
    }

    public static a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    public static o a(String str) {
        o oVar;
        Exception e;
        if (str != null) {
            try {
                String[] split = str.split("[|]");
                if (split != null && split.length >= 1) {
                    oVar = new o();
                    try {
                        oVar.a = split[0];
                        if (split.length >= 2) {
                            oVar.b = split[1];
                            return oVar;
                        }
                        return oVar;
                    } catch (Exception e2) {
                        e = e2;
                        com.baidu.adp.lib.util.f.b("AccountShareHelper", "parseBDUSS", e.getMessage());
                        return oVar;
                    }
                }
            } catch (Exception e3) {
                oVar = null;
                e = e3;
            }
        }
        return null;
    }

    public void a(Activity activity, boolean z) {
        o a2;
        if (UtilHelper.b()) {
            this.b = activity;
            this.e = z;
            AccountData E = TiebaApplication.E();
            if (E != null && (a2 = a(E.getBDUSS())) != null) {
                ay.a(E.getAccount(), a2.a, a2.b, this.i, false);
            }
        }
    }

    public void a(Activity activity, int i) {
        if (UtilHelper.b() && TiebaApplication.E() == null) {
            this.h = true;
            this.b = activity;
            this.c = i;
            j jVar = new j(this);
            jVar.setPriority(3);
            jVar.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        if (this.g < this.f.size()) {
            ArrayList<AccountData> arrayList = this.f;
            int i = this.g;
            this.g = i + 1;
            l a2 = a(arrayList.get(i));
            if (a2 == null) {
                return b();
            }
            ay.a(a2.c, a2.a, a2.b, this.l, false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        l c = m.a().c();
        if (c != null && this.b != null) {
            ReLoginShareActivity.a(this.b, c.c, c.a, c.b, this.c);
        }
    }

    private l a(AccountData accountData) {
        o a2;
        if (accountData == null || accountData.getAccount().equals(TiebaApplication.F()) || (a2 = a(accountData.getBDUSS())) == null) {
            return null;
        }
        l lVar = new l();
        lVar.c = accountData.getAccount();
        lVar.a = a2.a;
        lVar.b = a2.b;
        return lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AccountData c(String str) {
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            AccountData accountData = this.f.get(i);
            if (accountData.getAccount().equals(str)) {
                return accountData;
            }
        }
        return null;
    }

    public void b(String str) {
        try {
            cb.a(TiebaApplication.g().b(), str, "click", 1, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
