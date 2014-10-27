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
    final /* synthetic */ AccountActivity aeo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AccountActivity accountActivity) {
        this.aeo = accountActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        l lVar;
        l lVar2;
        l lVar3;
        i iVar;
        i iVar2;
        lVar = this.aeo.aej;
        if (lVar.getItemId(i) >= 0) {
            lVar2 = this.aeo.aej;
            if (!lVar2.xd()) {
                lVar3 = this.aeo.aej;
                AccountData accountData = (AccountData) lVar3.getItem(i);
                if (accountData != null && accountData.getIsActive() != 1) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001193, TbadkApplication.getCurrentAccount()));
                    this.aeo.aem = new i(this.aeo, accountData);
                    iVar = this.aeo.aem;
                    iVar.setPriority(3);
                    iVar2 = this.aeo.aem;
                    iVar2.execute(new Object[0]);
                    return;
                }
                return;
            }
            return;
        }
        LoginActivity.x(this.aeo);
    }
}
