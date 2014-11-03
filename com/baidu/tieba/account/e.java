package com.baidu.tieba.account;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements AdapterView.OnItemClickListener {
    final /* synthetic */ AccountActivity aew;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AccountActivity accountActivity) {
        this.aew = accountActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        l lVar;
        l lVar2;
        l lVar3;
        i iVar;
        i iVar2;
        lVar = this.aew.aer;
        if (lVar.getItemId(i) >= 0) {
            lVar2 = this.aew.aer;
            if (!lVar2.xf()) {
                lVar3 = this.aew.aer;
                AccountData accountData = (AccountData) lVar3.getItem(i);
                if (accountData != null && accountData.getIsActive() != 1) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001193, TbadkApplication.getCurrentAccount()));
                    this.aew.aeu = new i(this.aew, accountData);
                    iVar = this.aew.aeu;
                    iVar.setPriority(3);
                    iVar2 = this.aew.aeu;
                    iVar2.execute(new Object[0]);
                    return;
                }
                return;
            }
            return;
        }
        LoginActivity.x(this.aew);
    }
}
