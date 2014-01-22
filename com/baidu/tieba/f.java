package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import com.baidu.account.AccountProxy;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
public class f {
    public static void a(Context context) {
        AccountData E = TiebaApplication.E();
        if (E == null) {
            E = new AccountData();
            E.setIsActive(1);
            TiebaApplication.a(E, context);
        }
        BaiduAccount baiduAccount = BaiduAccount.get(context);
        String currentAccount = baiduAccount.getCurrentAccount();
        if (currentAccount != null && !currentAccount.equals(E.getAccount())) {
            b(E.getID());
            E.setAccount(currentAccount);
            E.setPortrait(null);
            E.setID(null);
            E.setIsActive(1);
            TiebaApplication.h().N();
            com.baidu.tieba.mention.s.a().a(true);
            TiebaApplication.k((String) null);
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

    public static AccountData a(com.baidu.tieba.util.ax axVar, String str, String str2) {
        AccountData accountData = null;
        if (axVar != null) {
            StringBuffer stringBuffer = new StringBuffer(60);
            stringBuffer.append(com.baidu.tieba.data.h.a);
            stringBuffer.append("c/s/login");
            axVar.a(stringBuffer.toString());
            axVar.a("un", str);
            axVar.a("bdusstoken", str2);
            axVar.a("channel_id", TiebaApplication.h().bb());
            axVar.a("channel_uid", TiebaApplication.h().ba());
            String m = axVar.m();
            if (axVar.d() && m != null) {
                com.baidu.tieba.model.be beVar = new com.baidu.tieba.model.be();
                beVar.a(m);
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
