package com.baidu.tieba.account;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements AdapterView.OnItemClickListener {
    final /* synthetic */ AccountActivity alO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AccountActivity accountActivity) {
        this.alO = accountActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        l lVar;
        l lVar2;
        l lVar3;
        i iVar;
        i iVar2;
        lVar = this.alO.alJ;
        if (lVar.getItemId(i) >= 0) {
            lVar2 = this.alO.alJ;
            if (!lVar2.Ay()) {
                lVar3 = this.alO.alJ;
                AccountData accountData = (AccountData) lVar3.getItem(i);
                if (accountData != null && accountData.getIsActive() != 1) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001193, TbadkCoreApplication.getCurrentAccount()));
                    this.alO.alM = new i(this.alO, accountData);
                    iVar = this.alO.alM;
                    iVar.setPriority(3);
                    iVar2 = this.alO.alM;
                    iVar2.execute(new Object[0]);
                    return;
                }
                return;
            }
            return;
        }
        this.alO.sendMessage(new CustomMessage(2002001, new LoginActivityConfig(this.alO.getPageContext().getPageActivity())));
    }
}
