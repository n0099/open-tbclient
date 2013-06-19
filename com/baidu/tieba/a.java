package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import com.baidu.account.AccountProxy;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
/* loaded from: classes.dex */
public class a {
    public static void a(Context context) {
        com.baidu.tieba.a.a F = TiebaApplication.F();
        if (F == null) {
            F = new com.baidu.tieba.a.a();
            F.a(1);
            TiebaApplication.a(F);
        }
        BaiduAccount baiduAccount = BaiduAccount.get(context);
        String currentAccount = baiduAccount.getCurrentAccount();
        if (currentAccount != null && !currentAccount.equals(F.b())) {
            b(F.a());
            F.b(currentAccount);
            F.d(null);
            F.a((String) null);
            F.a(1);
            TiebaApplication.e().R();
            TiebaApplication.e().a(0L, 0L, 0L, 0L);
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
                com.baidu.tieba.c.ai aiVar = new com.baidu.tieba.c.ai();
                aiVar.a(i);
                aVar = new com.baidu.tieba.a.a();
                aVar.b(aiVar.a().c());
                aVar.d(aiVar.a().l());
                aVar.a(1);
                if (aiVar.b() != null) {
                    aVar.e(aiVar.b().b());
                }
                aVar.a(aiVar.a().a());
            }
        }
        return aVar;
    }
}
