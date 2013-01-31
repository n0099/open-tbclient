package com.baidu.tieba.BaiduAccount;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.OnAccountsUpdateListener;
import android.content.Context;
import android.util.Log;
import com.baidu.account.AccountProxy;
/* loaded from: classes.dex */
public class BaiduAccount {
    private static String LogTag = "TiebaLog";
    private AccountManager mAccountManager;

    /* loaded from: classes.dex */
    public interface BaiduOnAccountsUpdateListener {
        void onAccountsUpdated(String str);
    }

    /* loaded from: classes.dex */
    public interface CallbackListener {
        void callback();
    }

    public static BaiduAccount get(Context context) {
        return new BaiduAccount(context);
    }

    public BaiduAccount(Context context) {
        this.mAccountManager = null;
        this.mAccountManager = AccountManager.get(context);
    }

    public String getCurrentAccount() {
        Account[] accountsByType = this.mAccountManager.getAccountsByType(AccountProxy.BAIDUACCOUNT_TYPE);
        if (accountsByType.length <= 0) {
            return null;
        }
        return accountsByType[0].name;
    }

    public void addOnAccountsUpdatedListener(final BaiduOnAccountsUpdateListener baiduOnAccountsUpdateListener) {
        if (baiduOnAccountsUpdateListener != null) {
            this.mAccountManager.addOnAccountsUpdatedListener(new OnAccountsUpdateListener() { // from class: com.baidu.tieba.BaiduAccount.BaiduAccount.1
                @Override // android.accounts.OnAccountsUpdateListener
                public void onAccountsUpdated(Account[] accountArr) {
                    String str;
                    int i = 0;
                    while (true) {
                        if (i >= accountArr.length) {
                            str = null;
                            break;
                        } else if (!AccountProxy.BAIDUACCOUNT_TYPE.equals(accountArr[i].type)) {
                            i++;
                        } else {
                            str = accountArr[i].name;
                            break;
                        }
                    }
                    baiduOnAccountsUpdateListener.onAccountsUpdated(str);
                }
            }, null, true);
        }
    }

    public String backgroundReLogin(String str, String str2, CallbackListener callbackListener, CallbackListener callbackListener2) {
        String str3 = null;
        String currentAccount = getCurrentAccount();
        if (currentAccount != null && currentAccount.equals(str)) {
            Account[] accountsByType = this.mAccountManager.getAccountsByType(AccountProxy.BAIDUACCOUNT_TYPE);
            this.mAccountManager.invalidateAuthToken(AccountProxy.BAIDUACCOUNT_TYPE, str2);
            try {
                try {
                    str3 = this.mAccountManager.blockingGetAuthToken(accountsByType[0], "BDUSS", false);
                } catch (Exception e) {
                    Log.d(LogTag, "Exception e = " + e.getMessage());
                    if (0 == 0) {
                        callbackListener.callback();
                    }
                }
            } finally {
                if (0 == 0) {
                    callbackListener.callback();
                }
            }
        } else {
            callbackListener.callback();
        }
        return str3;
    }
}
