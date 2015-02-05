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
public class f implements AdapterView.OnItemClickListener {
    final /* synthetic */ AccountActivity amF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AccountActivity accountActivity) {
        this.amF = accountActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        m mVar;
        m mVar2;
        m mVar3;
        mVar = this.amF.amA;
        if (mVar.getItemId(i) >= 0) {
            mVar2 = this.amF.amA;
            if (!mVar2.AT()) {
                mVar3 = this.amF.amA;
                AccountData accountData = (AccountData) mVar3.getItem(i);
                if (accountData != null && accountData.getIsActive() != 1) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001193, TbadkCoreApplication.getCurrentAccount()));
                    this.amF.h(accountData);
                    return;
                }
                return;
            }
            return;
        }
        this.amF.sendMessage(new CustomMessage(2002001, new LoginActivityConfig(this.amF.getPageContext().getPageActivity())));
    }
}
