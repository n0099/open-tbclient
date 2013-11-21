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
            TiebaApplication.g().Q();
            com.baidu.tieba.mention.t.a().a(true);
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

    public static AccountData a(com.baidu.tieba.util.ap apVar, String str, String str2) {
        AccountData accountData = null;
        if (apVar != null) {
            StringBuffer stringBuffer = new StringBuffer(60);
            stringBuffer.append(com.baidu.tieba.data.h.f1201a);
            stringBuffer.append("c/s/login");
            apVar.a(stringBuffer.toString());
            apVar.a("un", str);
            apVar.a("bdusstoken", str2);
            apVar.a("channel_id", TiebaApplication.g().bb());
            apVar.a("channel_uid", TiebaApplication.g().ba());
            String j = apVar.j();
            if (apVar.c() && j != null) {
                com.baidu.tieba.model.be beVar = new com.baidu.tieba.model.be();
                beVar.a(j);
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
