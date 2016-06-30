package com.baidu.tieba.account;

import android.text.TextUtils;
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
public class f implements AdapterView.OnItemClickListener {
    final /* synthetic */ AccountActivity aLu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AccountActivity accountActivity) {
        this.aLu = accountActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.account.AccountActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AccountData accountData;
        if (this.aLu.aLm.getItemId(i) >= 0) {
            if (!this.aLu.aLm.IZ() && (accountData = (AccountData) this.aLu.aLm.getItem(i)) != null && accountData.getIsActive() != 1) {
                if (!TextUtils.isEmpty(accountData.getAccount())) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_ACCOUNT, TbadkCoreApplication.getCurrentAccount()));
                    this.aLu.k(accountData);
                    return;
                }
                this.aLu.j(accountData);
                return;
            }
            return;
        }
        TbadkCoreApplication.m9getInst().login(this.aLu.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.aLu.getPageContext().getPageActivity())));
    }
}
