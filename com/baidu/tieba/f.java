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
            F.setPortrait(null);
            F.setID(null);
            F.setIsActive(1);
            TiebaApplication.h().O();
            com.baidu.tieba.mention.t.a().a(true);
            TiebaApplication.l((String) null);
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

    public static AccountData a(com.baidu.tieba.util.an anVar, String str, String str2) {
        AccountData accountData = null;
        if (anVar != null) {
            StringBuffer stringBuffer = new StringBuffer(60);
            stringBuffer.append(com.baidu.tieba.data.h.a);
            stringBuffer.append("c/s/login");
            anVar.a(stringBuffer.toString());
            anVar.a("un", str);
            anVar.a("bdusstoken", str2);
            anVar.a("channel_id", TiebaApplication.h().bc());
            anVar.a("channel_uid", TiebaApplication.h().bb());
            String l = anVar.l();
            if (anVar.c() && l != null) {
                com.baidu.tieba.model.be beVar = new com.baidu.tieba.model.be();
                beVar.a(l);
                accountData = new AccountData();
                accountData.setAccount(beVar.a().getName());
                accountData.setBDUSS(beVar.a().getBDUSS());
                accountData.setPortrait(beVar.a().getPortrait());
                accountData.setIsActive(1);
                if (beVar.b() != null) {
                    accountData.setTbs(beVar.b().getTbs());
                }
                accountData.setID(beVar.a().getId());
            }
        }
        return accountData;
    }
}
