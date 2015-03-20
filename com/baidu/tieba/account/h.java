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
    final /* synthetic */ AccountActivity auu;
    private AccountData auy;
    private boolean auz;
    private int mType = 0;

    public h(AccountActivity accountActivity, boolean z, AccountData accountData) {
        this.auu = accountActivity;
        this.auz = false;
        this.auy = accountData;
        this.auz = z;
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
            if (this.auz) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, this.auy.getID()));
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001193, this.auy.getID()));
            o.deleteAccountAllInfo(this.auy.getID());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            com.baidu.tbadk.core.sharedPref.b.rB().remove("get_addresslist_switch" + this.auy.getID());
            if (this.auy.getID().equals(currentAccount)) {
                com.baidu.tbadk.coreExtra.act.l um = com.baidu.tbadk.coreExtra.act.a.um();
                if (um != null) {
                    um.ur();
                }
                this.mType = 2;
                return null;
            }
            com.baidu.tbadk.coreExtra.act.l um2 = com.baidu.tbadk.coreExtra.act.a.um();
            if (um2 != null) {
                um2.j(this.auy);
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
        if (this.auy != null) {
            new i(this.auu, this.auy.getBDUSS()).start();
        }
        this.auu.closeLoadingDialog();
        if (this.mType != 0) {
            TbadkCoreApplication.setCurrentAccount(null, this.auu.getPageContext().getPageActivity());
        }
        switch (this.mType) {
            case 0:
                this.auu.showToast(this.auu.getPageContext().getString(com.baidu.tieba.y.success));
                arrayList = this.auu.aun;
                arrayList.remove(this.auy);
                this.auy = null;
                mVar = this.auu.auo;
                mVar.notifyDataSetChanged();
                break;
            case 2:
                TbadkCoreApplication.m411getInst().onUserChanged();
                com.baidu.tbadk.core.c.b.a(this.auu.getPageContext().getPageActivity(), 11, false);
                break;
        }
        this.auu.aut = null;
    }
}
