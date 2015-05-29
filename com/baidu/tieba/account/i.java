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
public class i extends BdAsyncTask<Object, Integer, AccountData> {
    final /* synthetic */ AccountActivity awf;
    private AccountData awj;
    private boolean awk;
    private int mType = 0;

    public i(AccountActivity accountActivity, boolean z, AccountData accountData) {
        this.awf = accountActivity;
        this.awk = false;
        this.awj = accountData;
        this.awk = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public AccountData doInBackground(Object... objArr) {
        try {
            try {
                Thread.sleep(1000L);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            if (this.awk) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, this.awj.getID()));
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001193, this.awj.getID()));
            o.deleteAccountAllInfo(this.awj.getID());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            com.baidu.tbadk.core.sharedPref.b.sl().remove("get_addresslist_switch" + this.awj.getID());
            if (this.awj.getID().equals(currentAccount)) {
                com.baidu.tbadk.coreExtra.act.l uV = com.baidu.tbadk.coreExtra.act.a.uV();
                if (uV != null) {
                    uV.va();
                }
                this.mType = 2;
                return null;
            }
            com.baidu.tbadk.coreExtra.act.l uV2 = com.baidu.tbadk.coreExtra.act.a.uV();
            if (uV2 != null) {
                uV2.j(this.awj);
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
        if (this.awj != null) {
            new j(this.awf, this.awj.getBDUSS()).start();
        }
        this.awf.closeLoadingDialog();
        if (this.mType != 0) {
            TbadkCoreApplication.setCurrentAccount(null, this.awf.getPageContext().getPageActivity());
        }
        switch (this.mType) {
            case 0:
                this.awf.showToast(this.awf.getPageContext().getString(com.baidu.tieba.t.success));
                arrayList = this.awf.avY;
                arrayList.remove(this.awj);
                this.awj = null;
                mVar = this.awf.avZ;
                mVar.notifyDataSetChanged();
                break;
            case 2:
                TbadkCoreApplication.m411getInst().onUserChanged();
                com.baidu.tbadk.core.c.b.a(this.awf.getPageContext().getPageActivity(), 11, false);
                break;
        }
        this.awf.awe = null;
    }
}
