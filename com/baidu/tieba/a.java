package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import com.baidu.account.AccountProxy;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
/* loaded from: classes.dex */
public class a {
    public static void a(Context context) {
        com.baidu.tieba.a.a C = TiebaApplication.C();
        if (C == null) {
            C = new com.baidu.tieba.a.a();
            C.a(1);
            TiebaApplication.a(C);
        }
        BaiduAccount baiduAccount = BaiduAccount.get(context);
        String currentAccount = baiduAccount.getCurrentAccount();
        if (currentAccount != null && !currentAccount.equals(C.b())) {
            b(C.a());
            C.b(currentAccount);
            C.d(null);
            C.a((String) null);
            C.a(1);
            TiebaApplication.d().O();
            TiebaApplication.d().a(0L, 0L, 0L);
        }
        baiduAccount.addOnAccountsUpdatedListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str) {
        if (str != null) {
            new c(str).start();
        }
    }

    public static boolean a(Activity activity) {
        AccountProxy accountProxy = new AccountProxy(activity);
        return accountProxy.hasBaiduAccount() && accountProxy.getNumOfAccounts(AccountProxy.BAIDUACCOUNT_TYPE) > 0;
    }

    public static void a(Activity activity, int i, String str, boolean z) {
        new AccountProxy(activity).getTokenAsync(AccountProxy.BAIDUACCOUNT_TYPE, new d(activity, str, i, z));
    }

    public static com.baidu.tieba.a.a a(com.baidu.tieba.d.t tVar, String str, String str2) {
        com.baidu.tieba.a.a aVar = null;
        if (tVar != null) {
            StringBuffer stringBuffer = new StringBuffer(60);
            stringBuffer.append(com.baidu.tieba.a.i.e);
            stringBuffer.append("c/s/login");
            tVar.a(stringBuffer.toString());
            tVar.a("un", str);
            tVar.a("bdusstoken", str2);
            String i = tVar.i();
            if (tVar.b() && i != null) {
                com.baidu.tieba.c.af afVar = new com.baidu.tieba.c.af();
                afVar.a(i);
                aVar = new com.baidu.tieba.a.a();
                aVar.b(afVar.a().c());
                aVar.d(afVar.a().j());
                aVar.a(1);
                if (afVar.b() != null) {
                    aVar.e(afVar.b().b());
                }
                aVar.a(afVar.a().a());
            }
        }
        return aVar;
    }
}
