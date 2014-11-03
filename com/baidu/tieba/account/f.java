package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.data.Hao123Data;
import com.baidu.tieba.model.Hao123Model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<Object, Integer, AccountData> {
    private boolean aeA;
    final /* synthetic */ AccountActivity aew;
    private AccountData aez;
    private int mType = 0;

    public f(AccountActivity accountActivity, boolean z, AccountData accountData) {
        this.aew = accountActivity;
        this.aeA = false;
        this.aez = accountData;
        this.aeA = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.aew.showLoadingDialog(this.aew.getString(com.baidu.tieba.y.deleting), new g(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public AccountData doInBackground(Object... objArr) {
        try {
            Thread.sleep(1000L);
            if (this.aeA) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, this.aez.getID()));
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001193, this.aez.getID()));
            com.baidu.tieba.util.j.hB(this.aez.getID());
            String currentAccount = TbadkApplication.getCurrentAccount();
            com.baidu.tbadk.core.sharedPref.b.lk().remove("get_addresslist_switch" + this.aez.getID());
            if (this.aez.getID().equals(currentAccount)) {
                SapiAccountManager.getInstance().logout();
                this.mType = 2;
                xe();
                return null;
            }
            List<SapiAccount> loginAccounts = SapiAccountManager.getInstance().getLoginAccounts();
            if (!TextUtils.isEmpty(this.aez.getID()) && loginAccounts != null && loginAccounts.size() > 0) {
                Iterator<SapiAccount> it = loginAccounts.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SapiAccount next = it.next();
                    if (this.aez.getID().equals(next.uid)) {
                        SapiAccountManager.getInstance().removeLoginAccount(next);
                        break;
                    }
                }
            }
            this.mType = 0;
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    private void xe() {
        String hao123Cache = Hao123Model.getHao123Cache();
        if (!TextUtils.isEmpty(hao123Cache)) {
            Hao123Data hao123Data = (Hao123Data) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(hao123Cache, Hao123Data.class);
            hao123Data.login = "no";
            Hao123Model.setHao123Cache(com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(hao123Data));
            return;
        }
        Hao123Data hao123Data2 = new Hao123Data();
        hao123Data2.login = "no";
        Hao123Model.setHao123Cache(com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(hao123Data2));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(AccountData accountData) {
        ArrayList arrayList;
        l lVar;
        if (this.aez != null) {
            new h(this.aew, this.aez.getBDUSS()).start();
        }
        this.aew.closeLoadingDialog();
        if (this.mType != 0) {
            TbadkApplication.setCurrentAccount(null, this.aew);
        }
        switch (this.mType) {
            case 0:
                this.aew.showToast(this.aew.getString(com.baidu.tieba.y.success));
                arrayList = this.aew.aeq;
                arrayList.remove(this.aez);
                this.aez = null;
                lVar = this.aew.aer;
                lVar.notifyDataSetChanged();
                break;
            case 2:
                TbadkApplication.m251getInst().onUserChanged();
                com.baidu.tbadk.core.b.b.a(this.aew, 11, false);
                break;
        }
        this.aew.aev = null;
    }
}
