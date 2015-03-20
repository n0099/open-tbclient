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
    final /* synthetic */ AccountActivity auu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AccountActivity accountActivity) {
        this.auu = accountActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        m mVar;
        m mVar2;
        m mVar3;
        mVar = this.auu.auo;
        if (mVar.getItemId(i) >= 0) {
            mVar2 = this.auu.auo;
            if (!mVar2.Ei()) {
                mVar3 = this.auu.auo;
                AccountData accountData = (AccountData) mVar3.getItem(i);
                if (accountData != null && accountData.getIsActive() != 1) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001193, TbadkCoreApplication.getCurrentAccount()));
                    this.auu.l(accountData);
                    return;
                }
                return;
            }
            return;
        }
        this.auu.sendMessage(new CustomMessage(2002001, new LoginActivityConfig(this.auu.getPageContext().getPageActivity())));
    }
}
