package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import com.baidu.account.AccountProxy;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
/* loaded from: classes.dex */
public class a {
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

    public static void a(Activity activity, int i, String str, boolean z) {
        new AccountProxy(activity).getTokenAsync(AccountProxy.BAIDUACCOUNT_TYPE, new d(activity, str, i, z));
    }

    public static void a(Context context) {
        com.baidu.tieba.a.a w = TiebaApplication.w();
        if (w == null) {
            w = new com.baidu.tieba.a.a();
            w.a(1);
            TiebaApplication.a(w);
        }
        BaiduAccount baiduAccount = BaiduAccount.get(context);
        String currentAccount = baiduAccount.getCurrentAccount();
        if (currentAccount != null && !currentAccount.equals(w.b())) {
            b(w.a());
            w.b(currentAccount);
            w.d(null);
            w.a((String) null);
            w.a(1);
            TiebaApplication.a().H();
            TiebaApplication.a().a(0L, 0L, 0L);
        }
        baiduAccount.addOnAccountsUpdatedListener(new b());
    }

    public static boolean a(Activity activity) {
        AccountProxy accountProxy = new AccountProxy(activity);
        return accountProxy.hasBaiduAccount() && accountProxy.getNumOfAccounts(AccountProxy.BAIDUACCOUNT_TYPE) > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str) {
        if (str == null) {
            return;
        }
        new c(str).start();
    }
}
