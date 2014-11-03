package com.baidu.tieba.frs;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity aBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(FrsActivity frsActivity) {
        this.aBu = frsActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.model.bc bcVar;
        b bVar;
        b bVar2;
        if (dialogInterface instanceof Dialog) {
            com.baidu.adp.lib.g.j.b((Dialog) dialogInterface, this.aBu);
        }
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            bcVar = this.aBu.aAP;
            bVar = this.aBu.azN;
            String name = bVar.zL().getName();
            bVar2 = this.aBu.azN;
            bcVar.g(name, Long.valueOf(bVar2.zL().getId()).longValue());
            return;
        }
        LoginActivity.a((Activity) this.aBu, this.aBu.getString(com.baidu.tieba.y.login_to_use), true, 11036);
    }
}
