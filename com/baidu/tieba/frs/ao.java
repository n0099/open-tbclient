package com.baidu.tieba.frs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(FrsActivity frsActivity) {
        this.aDW = frsActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.tbadkCore.au auVar;
        com.baidu.tieba.tbadkCore.e eVar;
        com.baidu.tieba.tbadkCore.e eVar2;
        if (dialogInterface instanceof Dialog) {
            com.baidu.adp.lib.g.k.b((Dialog) dialogInterface, this.aDW.getPageContext());
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            auVar = this.aDW.aDj;
            eVar = this.aDW.aDi;
            String name = eVar.aeN().getName();
            eVar2 = this.aDW.aDi;
            auVar.i(name, Long.valueOf(eVar2.aeN().getId()).longValue());
            return;
        }
        this.aDW.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) this.aDW.getPageContext().getPageActivity(), this.aDW.getPageContext().getString(com.baidu.tieba.z.login_to_use), true, 11036)));
    }
}
