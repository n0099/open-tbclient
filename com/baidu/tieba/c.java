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
            TiebaApplication.f().T();
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

    public static AccountData a(com.baidu.tieba.util.u uVar, String str, String str2) {
        AccountData accountData = null;
        if (uVar != null) {
            StringBuffer stringBuffer = new StringBuffer(60);
            stringBuffer.append(com.baidu.tieba.data.g.f1013a);
            stringBuffer.append("c/s/login");
            uVar.a(stringBuffer.toString());
            uVar.a("un", str);
            uVar.a("bdusstoken", str2);
            uVar.a("channel_id", TiebaApplication.f().bj());
            String k = uVar.k();
            if (uVar.d() && k != null) {
                com.baidu.tieba.model.at atVar = new com.baidu.tieba.model.at();
                atVar.a(k);
                accountData = new AccountData();
                accountData.setAccount(atVar.a().getName());
                accountData.setBDUSS(atVar.a().getBDUSS());
                accountData.setIsActive(1);
                if (atVar.b() != null) {
                    accountData.setTbs(atVar.b().getTbs());
                }
                accountData.setID(atVar.a().getId());
            }
        }
        return accountData;
    }
}
