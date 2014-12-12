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
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(FrsActivity frsActivity) {
        this.aCV = frsActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.tbadkCore.au auVar;
        com.baidu.tieba.tbadkCore.e eVar;
        com.baidu.tieba.tbadkCore.e eVar2;
        if (dialogInterface instanceof Dialog) {
            com.baidu.adp.lib.g.k.b((Dialog) dialogInterface, this.aCV.getPageContext());
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            auVar = this.aCV.aCi;
            eVar = this.aCV.aCh;
            String name = eVar.aej().getName();
            eVar2 = this.aCV.aCh;
            auVar.i(name, Long.valueOf(eVar2.aej().getId()).longValue());
            return;
        }
        this.aCV.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) this.aCV.getPageContext().getPageActivity(), this.aCV.getPageContext().getString(com.baidu.tieba.z.login_to_use), true, 11036)));
    }
}
