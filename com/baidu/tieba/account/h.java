package com.baidu.tieba.account;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask<Object, Integer, AccountData> {
    final /* synthetic */ AccountActivity auC;
    private AccountData auG;
    private boolean auH;
    private int mType = 0;

    public h(AccountActivity accountActivity, boolean z, AccountData accountData) {
        this.auC = accountActivity;
        this.auH = false;
        this.auG = accountData;
        this.auH = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: i */
    public AccountData doInBackground(Object... objArr) {
        try {
            try {
                Thread.sleep(1000L);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            if (this.auH) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, this.auG.getID()));
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001193, this.auG.getID()));
            o.deleteAccountAllInfo(this.auG.getID());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            com.baidu.tbadk.core.sharedPref.b.rB().remove("get_addresslist_switch" + this.auG.getID());
            if (this.auG.getID().equals(currentAccount)) {
                com.baidu.tbadk.coreExtra.act.l um = com.baidu.tbadk.coreExtra.act.a.um();
                if (um != null) {
                    um.ur();
                }
                this.mType = 2;
                return null;
            }
            com.baidu.tbadk.coreExtra.act.l um2 = com.baidu.tbadk.coreExtra.act.a.um();
            if (um2 != null) {
                um2.j(this.auG);
            }
            this.mType = 0;
            return null;
        } catch (Exception e2) {
            BdLog.detailException(e2);
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: m */
    public void onPostExecute(AccountData accountData) {
        ArrayList arrayList;
        m mVar;
        if (this.auG != null) {
            new i(this.auC, this.auG.getBDUSS()).start();
        }
        this.auC.closeLoadingDialog();
        if (this.mType != 0) {
            TbadkCoreApplication.setCurrentAccount(null, this.auC.getPageContext().getPageActivity());
        }
        switch (this.mType) {
            case 0:
                this.auC.showToast(this.auC.getPageContext().getString(com.baidu.tieba.y.success));
                arrayList = this.auC.auv;
                arrayList.remove(this.auG);
                this.auG = null;
                mVar = this.auC.auw;
                mVar.notifyDataSetChanged();
                break;
            case 2:
                TbadkCoreApplication.m411getInst().onUserChanged();
                com.baidu.tbadk.core.c.b.a(this.auC.getPageContext().getPageActivity(), 11, false);
                break;
        }
        this.auC.auB = null;
    }
}
