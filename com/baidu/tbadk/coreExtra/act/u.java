package com.baidu.tbadk.coreExtra.act;

import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import java.util.List;
/* loaded from: classes.dex */
public class u implements l {
    private static u abA;

    private u() {
    }

    public static synchronized u vc() {
        u uVar;
        synchronized (u.class) {
            if (abA == null) {
                abA = new u();
            }
            uVar = abA;
        }
        return uVar;
    }

    @Override // com.baidu.tbadk.coreExtra.act.l
    public void h(AccountData accountData) {
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = accountData.getID();
        sapiAccount.displayname = accountData.getAccount();
        sapiAccount.bduss = accountData.getBDUSS();
        SapiAccountManager.getInstance().validate(sapiAccount);
    }

    @Override // com.baidu.tbadk.coreExtra.act.l
    public void i(AccountData accountData) {
        List<SapiAccount> loginAccounts = SapiAccountManager.getInstance().getLoginAccounts();
        if (!TextUtils.isEmpty(accountData.getID()) && loginAccounts != null && loginAccounts.size() > 0) {
            for (SapiAccount sapiAccount : loginAccounts) {
                if (accountData.getID().equals(sapiAccount.uid)) {
                    SapiAccountManager.getInstance().validate(sapiAccount);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.act.l
    public void va() {
        SapiAccountManager.getInstance().logout();
    }

    @Override // com.baidu.tbadk.coreExtra.act.l
    public void j(AccountData accountData) {
        if (accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) {
            SapiAccountManager.getInstance().logout();
            return;
        }
        List<SapiAccount> loginAccounts = SapiAccountManager.getInstance().getLoginAccounts();
        if (loginAccounts != null && loginAccounts.size() > 0) {
            for (SapiAccount sapiAccount : loginAccounts) {
                if (accountData.getID().equals(sapiAccount.uid)) {
                    SapiAccountManager.getInstance().removeLoginAccount(sapiAccount);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.act.l
    public AccountData sj() {
        SapiAccount session;
        AccountData h;
        SapiAccount.ReloginCredentials reloginCredentials = SapiAccountManager.getInstance().getSession().getReloginCredentials();
        if (reloginCredentials == null || SapiAccountManager.getInstance().getAccountService().blockingRelogin(reloginCredentials) != 0 || (session = SapiAccountManager.getInstance().getSession()) == null || com.baidu.tbadk.core.a.a.qi() == null || (h = com.baidu.tbadk.core.a.a.qi().h(session.username, session.bduss, session.ptoken)) == null) {
            return null;
        }
        com.baidu.tbadk.core.a.d.b(h);
        TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(h, h.getBDUSS(), h.getTbs());
        TbadkCoreApplication.setCurrentAccount(h, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
        return h;
    }

    @Override // com.baidu.tbadk.coreExtra.act.l
    public void a(com.baidu.tbadk.core.a.b bVar) {
    }
}
