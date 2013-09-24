package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import com.baidu.account.AccountProxy;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
public class f {
    public static void a(Context context) {
        AccountData F = TiebaApplication.F();
        if (F == null) {
            F = new AccountData();
            F.setIsActive(1);
            TiebaApplication.a(F, context);
        }
        BaiduAccount baiduAccount = BaiduAccount.get(context);
        String currentAccount = baiduAccount.getCurrentAccount();
        if (currentAccount != null && !currentAccount.equals(F.getAccount())) {
            b(F.getID());
            F.setAccount(currentAccount);
            F.setBDUSS(null);
            F.setID(null);
            F.setIsActive(1);
            TiebaApplication.g().R();
            com.baidu.tieba.mention.s.a().a(true);
        }
        baiduAccount.addOnAccountsUpdatedListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str) {
        if (str != null) {
            new h(str).start();
        }
    }

    public static boolean a(Activity activity) {
        AccountProxy accountProxy = new AccountProxy(activity);
        return accountProxy.hasBaiduAccount() && accountProxy.getNumOfAccounts(AccountProxy.BAIDUACCOUNT_TYPE) > 0;
    }

    public static void a(Activity activity, int i, int i2, boolean z) {
        new AccountProxy(activity).getTokenAsync(AccountProxy.BAIDUACCOUNT_TYPE, new i(activity, i2, i, z));
    }

    public static AccountData a(com.baidu.tieba.util.z zVar, String str, String str2) {
        AccountData accountData = null;
        if (zVar != null) {
            StringBuffer stringBuffer = new StringBuffer(60);
            stringBuffer.append(com.baidu.tieba.data.g.f1032a);
            stringBuffer.append("c/s/login");
            zVar.a(stringBuffer.toString());
            zVar.a("un", str);
            zVar.a("bdusstoken", str2);
            zVar.a("channel_id", TiebaApplication.g().aW());
            String j = zVar.j();
            if (zVar.c() && j != null) {
                com.baidu.tieba.model.au auVar = new com.baidu.tieba.model.au();
                auVar.a(j);
                accountData = new AccountData();
                accountData.setAccount(auVar.a().getName());
                accountData.setBDUSS(auVar.a().getBDUSS());
                accountData.setIsActive(1);
                if (auVar.b() != null) {
                    accountData.setTbs(auVar.b().getTbs());
                }
                accountData.setID(auVar.a().getId());
            }
        }
        return accountData;
    }
}
