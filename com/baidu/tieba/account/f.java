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
    final /* synthetic */ AccountActivity awf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AccountActivity accountActivity) {
        this.awf = accountActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.account.AccountActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        m mVar;
        m mVar2;
        m mVar3;
        mVar = this.awf.avZ;
        if (mVar.getItemId(i) >= 0) {
            mVar2 = this.awf.avZ;
            if (!mVar2.Fb()) {
                mVar3 = this.awf.avZ;
                AccountData accountData = (AccountData) mVar3.getItem(i);
                if (accountData != null && accountData.getIsActive() != 1) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001193, TbadkCoreApplication.getCurrentAccount()));
                    this.awf.l(accountData);
                    return;
                }
                return;
            }
            return;
        }
        TbadkCoreApplication.m411getInst().login(this.awf.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.awf.getPageContext().getPageActivity())));
    }
}
