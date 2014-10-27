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
    final /* synthetic */ AccountActivity aeo;
    private AccountData aer;
    private boolean aes;
    private int mType = 0;

    public f(AccountActivity accountActivity, boolean z, AccountData accountData) {
        this.aeo = accountActivity;
        this.aes = false;
        this.aer = accountData;
        this.aes = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.aeo.showLoadingDialog(this.aeo.getString(com.baidu.tieba.y.deleting), new g(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public AccountData doInBackground(Object... objArr) {
        try {
            Thread.sleep(1000L);
            if (this.aes) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, this.aer.getID()));
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001193, this.aer.getID()));
            com.baidu.tieba.util.j.hB(this.aer.getID());
            String currentAccount = TbadkApplication.getCurrentAccount();
            com.baidu.tbadk.core.sharedPref.b.lk().remove("get_addresslist_switch" + this.aer.getID());
            if (this.aer.getID().equals(currentAccount)) {
                SapiAccountManager.getInstance().logout();
                this.mType = 2;
                xc();
                return null;
            }
            List<SapiAccount> loginAccounts = SapiAccountManager.getInstance().getLoginAccounts();
            if (!TextUtils.isEmpty(this.aer.getID()) && loginAccounts != null && loginAccounts.size() > 0) {
                Iterator<SapiAccount> it = loginAccounts.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SapiAccount next = it.next();
                    if (this.aer.getID().equals(next.uid)) {
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

    private void xc() {
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
        if (this.aer != null) {
            new h(this.aeo, this.aer.getBDUSS()).start();
        }
        this.aeo.closeLoadingDialog();
        if (this.mType != 0) {
            TbadkApplication.setCurrentAccount(null, this.aeo);
        }
        switch (this.mType) {
            case 0:
                this.aeo.showToast(this.aeo.getString(com.baidu.tieba.y.success));
                arrayList = this.aeo.aei;
                arrayList.remove(this.aer);
                this.aer = null;
                lVar = this.aeo.aej;
                lVar.notifyDataSetChanged();
                break;
            case 2:
                TbadkApplication.m251getInst().onUserChanged();
                com.baidu.tbadk.core.b.b.a(this.aeo, 11, false);
                break;
        }
        this.aeo.aen = null;
    }
}
