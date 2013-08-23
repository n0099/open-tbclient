package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import com.baidu.account.AccountProxy;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
public class c {
    public static void a(Context context) {
        AccountData H = TiebaApplication.H();
        if (H == null) {
            H = new AccountData();
            H.setIsActive(1);
            TiebaApplication.a(H, context);
        }
        BaiduAccount baiduAccount = BaiduAccount.get(context);
        String currentAccount = baiduAccount.getCurrentAccount();
        if (currentAccount != null && !currentAccount.equals(H.getAccount())) {
            b(H.getID());
            H.setAccount(currentAccount);
            H.setBDUSS(null);
            H.setID(null);
            H.setIsActive(1);
            TiebaApplication.g().T();
            com.baidu.tieba.mention.r.a().a(true);
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

    public static void a(Activity activity, int i, int i2, boolean z) {
        new AccountProxy(activity).getTokenAsync(AccountProxy.BAIDUACCOUNT_TYPE, new f(activity, i2, i, z));
    }

    public static AccountData a(com.baidu.tieba.util.v vVar, String str, String str2) {
        AccountData accountData = null;
        if (vVar != null) {
            StringBuffer stringBuffer = new StringBuffer(60);
            stringBuffer.append(com.baidu.tieba.data.g.f1014a);
            stringBuffer.append("c/s/login");
            vVar.a(stringBuffer.toString());
            vVar.a("un", str);
            vVar.a("bdusstoken", str2);
            vVar.a("channel_id", TiebaApplication.g().aY());
            String j = vVar.j();
            if (vVar.c() && j != null) {
                com.baidu.tieba.model.as asVar = new com.baidu.tieba.model.as();
                asVar.a(j);
                accountData = new AccountData();
                accountData.setAccount(asVar.a().getName());
                accountData.setBDUSS(asVar.a().getBDUSS());
                accountData.setIsActive(1);
                if (asVar.b() != null) {
                    accountData.setTbs(asVar.b().getTbs());
                }
                accountData.setID(asVar.a().getId());
            }
        }
        return accountData;
    }
}
