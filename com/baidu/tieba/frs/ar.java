package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.model.bf bfVar;
        g gVar;
        g gVar2;
        dialogInterface.dismiss();
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            bfVar = this.a.N;
            gVar = this.a.L;
            String name = gVar.i().getName();
            gVar2 = this.a.L;
            bfVar.a(name, Long.valueOf(gVar2.i().getId()).longValue());
            return;
        }
        LoginActivity.a((Activity) this.a, this.a.getString(com.baidu.tieba.x.login_to_use), true, 11036);
    }
}
