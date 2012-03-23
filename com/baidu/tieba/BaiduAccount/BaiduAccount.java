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
        BaiduAccount accountData = new BaiduAccount(context);
        return accountData;
    }

    public BaiduAccount(Context context) {
        this.mAccountManager = null;
        this.mAccountManager = AccountManager.get(context);
    }

    public String getCurrentAccount() {
        Account[] accounts = this.mAccountManager.getAccountsByType(AccountProxy.BAIDUACCOUNT_TYPE);
        if (accounts.length <= 0) {
            return null;
        }
        String Account = accounts[0].name;
        return Account;
    }

    public void addOnAccountsUpdatedListener(final BaiduOnAccountsUpdateListener listener) {
        if (listener != null) {
            this.mAccountManager.addOnAccountsUpdatedListener(new OnAccountsUpdateListener() { // from class: com.baidu.tieba.BaiduAccount.BaiduAccount.1
                @Override // android.accounts.OnAccountsUpdateListener
                public void onAccountsUpdated(Account[] accounts) {
                    String account = null;
                    int i = 0;
                    while (true) {
                        if (i >= accounts.length) {
                            break;
                        } else if (!AccountProxy.BAIDUACCOUNT_TYPE.equals(accounts[i].type)) {
                            i++;
                        } else {
                            account = accounts[i].name;
                            break;
                        }
                    }
                    listener.onAccountsUpdated(account);
                }
            }, null, true);
        }
    }

    public String backgroundReLogin(String account_name, String bduss, CallbackListener relogin_callback, CallbackListener error_callbark) {
        String token = null;
        String account = getCurrentAccount();
        if (account != null && account.equals(account_name)) {
            Account[] accounts = this.mAccountManager.getAccountsByType(AccountProxy.BAIDUACCOUNT_TYPE);
            this.mAccountManager.invalidateAuthToken(AccountProxy.BAIDUACCOUNT_TYPE, bduss);
            try {
                try {
                    token = this.mAccountManager.blockingGetAuthToken(accounts[0], "BDUSS", false);
                } catch (Exception e) {
                    Log.d(LogTag, "Exception e = " + e.getMessage());
                    if (0 == 0) {
                        relogin_callback.callback();
                    }
                }
            } finally {
                if (0 == 0) {
                    relogin_callback.callback();
                }
            }
        } else {
            relogin_callback.callback();
        }
        return token;
    }
}
