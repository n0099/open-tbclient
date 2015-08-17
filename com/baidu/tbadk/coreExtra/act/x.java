package com.baidu.tbadk.coreExtra.act;

import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class x implements l {
    private static x agH;

    private x() {
    }

    public static synchronized x wk() {
        x xVar;
        synchronized (x.class) {
            if (agH == null) {
                agH = new x();
            }
            xVar = agH;
        }
        return xVar;
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
    public void we() {
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
    public AccountData tq() {
        SapiAccount session;
        AccountData j;
        SapiAccount.ReloginCredentials reloginCredentials = SapiAccountManager.getInstance().getSession().getReloginCredentials();
        if (reloginCredentials == null || SapiAccountManager.getInstance().getAccountService().blockingRelogin(reloginCredentials) != 0 || (session = SapiAccountManager.getInstance().getSession()) == null || com.baidu.tbadk.core.a.a.rj() == null || (j = com.baidu.tbadk.core.a.a.rj().j(session.username, session.bduss, session.ptoken)) == null) {
            return null;
        }
        com.baidu.tbadk.core.a.b.b(j);
        TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(j, j.getBDUSS(), j.getTbs());
        TbadkCoreApplication.setCurrentAccount(j, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
        return j;
    }

    @Override // com.baidu.tbadk.coreExtra.act.l
    public void a(a.InterfaceC0040a interfaceC0040a) {
    }

    @Override // com.baidu.tbadk.coreExtra.act.l
    public List<AccountData> wf() {
        ArrayList arrayList = new ArrayList();
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        List<SapiAccount> loginAccounts = SapiAccountManager.getInstance().getLoginAccounts();
        if (loginAccounts != null) {
            for (SapiAccount sapiAccount : loginAccounts) {
                AccountData accountData = new AccountData();
                accountData.setID(sapiAccount.uid);
                if (TextUtils.isEmpty(sapiAccount.username)) {
                    accountData.setAccount(sapiAccount.displayname);
                } else {
                    accountData.setAccount(sapiAccount.username);
                }
                accountData.setBDUSS(sapiAccount.bduss);
                if (session != null && !TextUtils.isEmpty(session.uid) && session.uid.equals(sapiAccount.uid)) {
                    accountData.setIsActive(1);
                }
                arrayList.add(accountData);
            }
        }
        return arrayList;
    }
}
