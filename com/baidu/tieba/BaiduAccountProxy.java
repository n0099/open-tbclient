package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import com.baidu.account.AccountProxy;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.model.LoginModel;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.TiebaLog;
/* loaded from: classes.dex */
public class BaiduAccountProxy {
    public static void initAccount(Context context) {
        AccountData accountData = TiebaApplication.getCurrentAccountObj();
        if (accountData == null) {
            accountData = new AccountData();
            accountData.setIsActive(1);
            TiebaApplication.setCurrentAccount(accountData);
        }
        BaiduAccount baiduAccount = BaiduAccount.get(context);
        String account = baiduAccount.getCurrentAccount();
        if (account != null && !account.equals(accountData.getAccount())) {
            deleteInfo(accountData.getID());
            accountData.setAccount(account);
            accountData.setBDUSS(null);
            accountData.setID(null);
            accountData.setIsActive(1);
            TiebaApplication.app.initSetting();
            TiebaApplication.app.refreshMsg(0L, 0L, 0L);
        }
        baiduAccount.addOnAccountsUpdatedListener(new BaiduAccount.BaiduOnAccountsUpdateListener() { // from class: com.baidu.tieba.BaiduAccountProxy.1
            @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.BaiduOnAccountsUpdateListener
            public void onAccountsUpdated(String account2) {
                TiebaLog.d(getClass().getName(), "onAccountsUpdated", "account changed");
                if ((account2 != null && account2.equals(TiebaApplication.getCurrentAccountName())) || TiebaApplication.getCurrentAccountObj() == null) {
                    return;
                }
                BaiduAccountProxy.deleteInfo(TiebaApplication.getCurrentAccount());
                AccountData data = TiebaApplication.getCurrentAccountObj();
                data.setBDUSS(null);
                data.setAccount(account2);
                data.setID(null);
                data.setIsActive(1);
                TiebaApplication.app.refreshMsg(0L, 0L, 0L);
                TiebaApplication.app.initSetting();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.BaiduAccountProxy$2] */
    public static void deleteInfo(final String id) {
        if (id != null) {
            new Thread() { // from class: com.baidu.tieba.BaiduAccountProxy.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    super.run();
                    DatabaseService.deleteAccountAllInfo(id);
                }
            }.start();
        }
    }

    public static void getAccountData(final Activity activity) {
        TiebaLog.d("BaiduAccountProxy", "getAccountData", null);
        AccountProxy proxy = new AccountProxy(activity);
        proxy.getTokenAsync(AccountProxy.BAIDUACCOUNT_TYPE, new AccountProxy.TokenCallback() { // from class: com.baidu.tieba.BaiduAccountProxy.3
            @Override // com.baidu.account.AccountProxy.TokenCallback
            public void callBack(String token) {
                TiebaLog.d("BaiduAccountProxy", "getAccountData", "token = " + token);
                if (token != null) {
                    BaiduAccount baiduAccount = BaiduAccount.get(activity);
                    AccountData accountData = new AccountData();
                    accountData.setAccount(baiduAccount.getCurrentAccount());
                    accountData.setBDUSS(token);
                    accountData.setIsActive(1);
                    AccountData locAccount = TiebaApplication.getCurrentAccountObj();
                    if (locAccount != null) {
                        if (!accountData.getAccount().equals(locAccount.getAccount())) {
                            BaiduAccountProxy.deleteInfo(locAccount.getID());
                            TiebaApplication.setCurrentAccount(accountData);
                            TiebaApplication.app.initSetting();
                        } else {
                            if (!token.equals(locAccount.getBDUSS())) {
                                DatabaseService.updateAccountToken(locAccount.getAccount(), token);
                            }
                            locAccount.setBDUSS(token);
                        }
                    } else {
                        TiebaApplication.setCurrentAccount(accountData);
                        TiebaApplication.app.initSetting();
                    }
                    if (activity instanceof LogoActivity) {
                        MainTabActivity.startActivityOnUserChanged(activity, null);
                        activity.finish();
                    } else if (activity instanceof MainTabActivity) {
                        if (activity.isFinishing()) {
                            MainTabActivity.startActivity(activity, (String) null);
                            return;
                        }
                        ((MainTabActivity) activity).refreshAllUI();
                        ((MainTabActivity) activity).getUid();
                    }
                } else if (activity instanceof MainTabActivity) {
                    if (TiebaApplication.getCurrentBduss() == null) {
                        activity.finish();
                    }
                } else {
                    activity.finish();
                }
            }
        });
    }

    public static AccountData getAccountDataByToken(NetWork network, String account, String token) {
        AccountData data = null;
        if (network == null) {
            return null;
        }
        StringBuffer address = new StringBuffer(60);
        address.append(Config.SERVER_ADDRESS);
        address.append(Config.LOGIN_ADDRESS);
        network.setUrl(address.toString());
        network.addPostData("un", account);
        network.addPostData("bdusstoken", token);
        String ret = network.postNetData();
        if (network.isRequestSuccess() && ret != null) {
            LoginModel loginData = new LoginModel();
            loginData.parserJson(ret);
            data = new AccountData();
            data.setAccount(loginData.getUser().getName());
            data.setBDUSS(loginData.getUser().getBDUSS());
            data.setIsActive(1);
            if (loginData.getAnti() != null) {
                data.setTbs(loginData.getAnti().getTbs());
            }
            data.setID(loginData.getUser().getId());
        }
        return data;
    }

    public static AccountData getAccountDataByBaidu(NetWork network, Activity activity) {
        AccountProxy proxy = new AccountProxy(activity);
        proxy.hasBaiduAccount();
        return null;
    }
}
