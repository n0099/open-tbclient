package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import com.baidu.account.AccountProxy;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
public class f {
    public static void a(Context context) {
        AccountData G = TiebaApplication.G();
        if (G == null) {
            G = new AccountData();
            G.setIsActive(1);
            TiebaApplication.a(G, context);
        }
        BaiduAccount baiduAccount = BaiduAccount.get(context);
        String currentAccount = baiduAccount.getCurrentAccount();
        if (currentAccount != null && !currentAccount.equals(G.getAccount())) {
            b(G.getID());
            G.setAccount(currentAccount);
            G.setPortrait(null);
            G.setID(null);
            G.setIsActive(1);
            TiebaApplication.g().S();
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

    public static AccountData a(com.baidu.tieba.util.ag agVar, String str, String str2) {
        AccountData accountData = null;
        if (agVar != null) {
            StringBuffer stringBuffer = new StringBuffer(60);
            stringBuffer.append(com.baidu.tieba.data.h.f1165a);
            stringBuffer.append("c/s/login");
            agVar.a(stringBuffer.toString());
            agVar.a("un", str);
            agVar.a("bdusstoken", str2);
            agVar.a("channel_id", TiebaApplication.g().bg());
            agVar.a("channel_uid", TiebaApplication.g().bf());
            String j = agVar.j();
            if (agVar.c() && j != null) {
                com.baidu.tieba.model.bd bdVar = new com.baidu.tieba.model.bd();
                bdVar.a(j);
                accountData = new AccountData();
                accountData.setAccount(bdVar.a().getName());
                accountData.setBDUSS(bdVar.a().getBDUSS());
                accountData.setPortrait(bdVar.a().getPortrait());
                accountData.setIsActive(1);
                if (bdVar.b() != null) {
                    accountData.setTbs(bdVar.b().getTbs());
                }
                accountData.setID(bdVar.a().getId());
            }
        }
        return accountData;
    }
}
