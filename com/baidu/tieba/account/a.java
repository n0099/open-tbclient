package com.baidu.tieba.account;

import android.app.Activity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.cb;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class a {
    private static a a = null;
    private Activity b;
    private int c;
    private ArrayList<AccountData> f;
    private k d = null;
    private boolean e = false;
    private int g = 0;
    private boolean h = false;
    private final az i = new b(this);
    private final at j = new d(this);
    private final at k = new f(this);
    private final az l = new h(this);

    public final void a(k kVar) {
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
                if (split != null && split.length > 0) {
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
                        com.baidu.adp.lib.util.e.b("AccountShareHelper", "parseBDUSS", e.getMessage());
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

    public final void a(Activity activity, boolean z) {
        o a2;
        if (UtilHelper.b()) {
            this.b = activity;
            this.e = z;
            AccountData y = TiebaApplication.y();
            if (y != null && (a2 = a(y.getBDUSS())) != null) {
                ay.a(y.getAccount(), a2.a, a2.b, this.i, false);
            }
        }
    }

    public final void a(Activity activity, int i) {
        if (UtilHelper.b() && TiebaApplication.y() == null) {
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
        l lVar;
        o a2;
        while (this.f != null && this.g < this.f.size()) {
            ArrayList<AccountData> arrayList = this.f;
            int i = this.g;
            this.g = i + 1;
            AccountData accountData = arrayList.get(i);
            if (accountData == null || accountData.getAccount().equals(TiebaApplication.z()) || (a2 = a(accountData.getBDUSS())) == null) {
                lVar = null;
                continue;
            } else {
                l lVar2 = new l();
                lVar2.c = accountData.getAccount();
                lVar2.a = a2.a;
                lVar2.b = a2.b;
                lVar = lVar2;
                continue;
            }
            if (lVar != null) {
                ay.a(lVar.c, lVar.a, lVar.b, this.l, false);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void k(a aVar) {
        l d = m.a().d();
        if (d == null || aVar.b == null) {
            return;
        }
        ReLoginShareActivity.a(aVar.b, d.c, d.a, d.b, aVar.c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ AccountData a(a aVar, String str) {
        int size = aVar.f.size();
        for (int i = 0; i < size; i++) {
            AccountData accountData = aVar.f.get(i);
            if (accountData.getAccount().equals(str)) {
                return accountData;
            }
        }
        return null;
    }

    public static void b(String str) {
        try {
            cb.a(TiebaApplication.g().b(), str, "click", 1, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
