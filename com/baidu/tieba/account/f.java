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
    final /* synthetic */ AccountActivity aVw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AccountActivity accountActivity) {
        this.aVw = accountActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.account.AccountActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AccountData accountData;
        if (this.aVw.aVo.getItemId(i) >= 0) {
            if (!this.aVw.aVo.Ma() && (accountData = (AccountData) this.aVw.aVo.getItem(i)) != null && accountData.getIsActive() != 1) {
                if (!TextUtils.isEmpty(accountData.getAccount())) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_ACCOUNT, TbadkCoreApplication.getCurrentAccount()));
                    this.aVw.l(accountData);
                    return;
                }
                this.aVw.k(accountData);
                return;
            }
            return;
        }
        TbadkCoreApplication.m9getInst().login(this.aVw.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.aVw.getPageContext().getPageActivity())));
    }
}
