package com.baidu.tieba.frs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(FrsActivity frsActivity) {
        this.aDT = frsActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.tbadkCore.e eVar;
        com.baidu.tieba.tbadkCore.e eVar2;
        com.baidu.tieba.tbadkCore.e eVar3;
        com.baidu.tieba.tbadkCore.au auVar;
        if (dialogInterface instanceof Dialog) {
            com.baidu.adp.lib.g.k.b((Dialog) dialogInterface, this.aDT.getPageContext());
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            eVar = this.aDT.aDf;
            if (eVar != null) {
                eVar2 = this.aDT.aDf;
                if (eVar2.aeI() != null) {
                    eVar3 = this.aDT.aDf;
                    ForumData aeI = eVar3.aeI();
                    if (aeI.getName() != null && aeI.getId() != null) {
                        auVar = this.aDT.aDg;
                        auVar.i(aeI.getName(), com.baidu.adp.lib.g.c.a(aeI.getId(), 0L));
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.aDT.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) this.aDT.getPageContext().getPageActivity(), this.aDT.getPageContext().getString(com.baidu.tieba.z.login_to_use), true, 11036)));
    }
}
