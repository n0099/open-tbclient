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
    final /* synthetic */ AccountActivity awg;
    private AccountData awk;
    private boolean awl;
    private int mType = 0;

    public i(AccountActivity accountActivity, boolean z, AccountData accountData) {
        this.awg = accountActivity;
        this.awl = false;
        this.awk = accountData;
        this.awl = z;
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
            if (this.awl) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, this.awk.getID()));
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001193, this.awk.getID()));
            o.deleteAccountAllInfo(this.awk.getID());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            com.baidu.tbadk.core.sharedPref.b.sl().remove("get_addresslist_switch" + this.awk.getID());
            if (this.awk.getID().equals(currentAccount)) {
                com.baidu.tbadk.coreExtra.act.l uV = com.baidu.tbadk.coreExtra.act.a.uV();
                if (uV != null) {
                    uV.va();
                }
                this.mType = 2;
                return null;
            }
            com.baidu.tbadk.coreExtra.act.l uV2 = com.baidu.tbadk.coreExtra.act.a.uV();
            if (uV2 != null) {
                uV2.j(this.awk);
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
        if (this.awk != null) {
            new j(this.awg, this.awk.getBDUSS()).start();
        }
        this.awg.closeLoadingDialog();
        if (this.mType != 0) {
            TbadkCoreApplication.setCurrentAccount(null, this.awg.getPageContext().getPageActivity());
        }
        switch (this.mType) {
            case 0:
                this.awg.showToast(this.awg.getPageContext().getString(com.baidu.tieba.t.success));
                arrayList = this.awg.avZ;
                arrayList.remove(this.awk);
                this.awk = null;
                mVar = this.awg.awa;
                mVar.notifyDataSetChanged();
                break;
            case 2:
                TbadkCoreApplication.m411getInst().onUserChanged();
                com.baidu.tbadk.core.c.b.a(this.awg.getPageContext().getPageActivity(), 11, false);
                break;
        }
        this.awg.awf = null;
    }
}
