package com.baidu.tieba.account;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements AdapterView.OnItemClickListener {
    final /* synthetic */ AccountActivity aDq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AccountActivity accountActivity) {
        this.aDq = accountActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.account.AccountActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AccountData accountData;
        if (this.aDq.aDk.getItemId(i) >= 0) {
            if (!this.aDq.aDk.FO() && (accountData = (AccountData) this.aDq.aDk.getItem(i)) != null && accountData.getIsActive() != 1) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_ACCOUNT, TbadkCoreApplication.getCurrentAccount()));
                this.aDq.j(accountData);
                return;
            }
            return;
        }
        TbadkCoreApplication.m411getInst().login(this.aDq.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.aDq.getPageContext().getPageActivity())));
    }
}
