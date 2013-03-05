package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import com.baidu.account.AccountProxy;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
/* loaded from: classes.dex */
public class a {
    public static void a(Context context) {
        com.baidu.tieba.a.a A = TiebaApplication.A();
        if (A == null) {
            A = new com.baidu.tieba.a.a();
            A.a(1);
            TiebaApplication.a(A);
        }
        BaiduAccount baiduAccount = BaiduAccount.get(context);
        String currentAccount = baiduAccount.getCurrentAccount();
        if (currentAccount != null && !currentAccount.equals(A.b())) {
            b(A.a());
            A.b(currentAccount);
            A.d(null);
            A.a((String) null);
            A.a(1);
            TiebaApplication.b().M();
            TiebaApplication.b().a(0L, 0L, 0L);
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

    public static com.baidu.tieba.a.a a(com.baidu.tieba.c.t tVar, String str, String str2) {
        com.baidu.tieba.a.a aVar = null;
        if (tVar != null) {
            StringBuffer stringBuffer = new StringBuffer(60);
            stringBuffer.append("http://c.tieba.baidu.com/");
            stringBuffer.append("c/s/login");
            tVar.a(stringBuffer.toString());
            tVar.a("un", str);
            tVar.a("bdusstoken", str2);
            String i = tVar.i();
            if (tVar.b() && i != null) {
                com.baidu.tieba.b.g gVar = new com.baidu.tieba.b.g();
                gVar.a(i);
                aVar = new com.baidu.tieba.a.a();
                aVar.b(gVar.a().b());
                aVar.d(gVar.a().j());
                aVar.a(1);
                if (gVar.b() != null) {
                    aVar.e(gVar.b().b());
                }
                aVar.a(gVar.a().a());
            }
        }
        return aVar;
    }
}
