package com.baidu.tieba.frs;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cg implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.model.bf bfVar;
        Cdo cdo;
        Cdo cdo2;
        if (dialogInterface instanceof Dialog) {
            com.baidu.adp.lib.e.e.b((Dialog) dialogInterface, this.a);
        }
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            bfVar = this.a.x;
            cdo = this.a.t;
            String name = cdo.b().getName();
            cdo2 = this.a.t;
            bfVar.a(name, Long.valueOf(cdo2.b().getId()).longValue());
            return;
        }
        LoginActivity.a((Activity) this.a, this.a.getString(com.baidu.tieba.x.login_to_use), true, 11036);
    }
}
