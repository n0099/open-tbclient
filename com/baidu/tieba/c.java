package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import com.baidu.account.AccountProxy;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
public class c {
    public static void a(Context context) {
        AccountData G = TiebaApplication.G();
        if (G == null) {
            G = new AccountData();
            G.setIsActive(1);
            TiebaApplication.a(G);
        }
        BaiduAccount baiduAccount = BaiduAccount.get(context);
        String currentAccount = baiduAccount.getCurrentAccount();
        if (currentAccount != null && !currentAccount.equals(G.getAccount())) {
            b(G.getID());
            G.setAccount(currentAccount);
            G.setBDUSS(null);
            G.setID(null);
            G.setIsActive(1);
            TiebaApplication.f().S();
            TiebaApplication.f().a(0L, 0L, 0L, 0L);
        }
        baiduAccount.addOnAccountsUpdatedListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str) {
        if (str != null) {
            new e(str).start();
        }
    }

    public static boolean a(Activity activity) {
        AccountProxy accountProxy = new AccountProxy(activity);
        return accountProxy.hasBaiduAccount() && accountProxy.getNumOfAccounts(AccountProxy.BAIDUACCOUNT_TYPE) > 0;
    }

    public static void a(Activity activity, int i, String str, boolean z) {
        new AccountProxy(activity).getTokenAsync(AccountProxy.BAIDUACCOUNT_TYPE, new f(activity, str, i, z));
    }

    public static AccountData a(com.baidu.tieba.util.r rVar, String str, String str2) {
        AccountData accountData = null;
        if (rVar != null) {
            StringBuffer stringBuffer = new StringBuffer(60);
            stringBuffer.append(com.baidu.tieba.data.g.a);
            stringBuffer.append("c/s/login");
            rVar.a(stringBuffer.toString());
            rVar.a("un", str);
            rVar.a("bdusstoken", str2);
            String j = rVar.j();
            if (rVar.c() && j != null) {
                com.baidu.tieba.model.al alVar = new com.baidu.tieba.model.al();
                alVar.a(j);
                accountData = new AccountData();
                accountData.setAccount(alVar.a().getName());
                accountData.setBDUSS(alVar.a().getBDUSS());
                accountData.setIsActive(1);
                if (alVar.b() != null) {
                    accountData.setTbs(alVar.b().getTbs());
                }
                accountData.setID(alVar.a().getId());
            }
        }
        return accountData;
    }
}
