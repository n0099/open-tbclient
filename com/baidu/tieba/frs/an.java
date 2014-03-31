package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* loaded from: classes.dex */
final class an implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.model.bc bcVar;
        g gVar;
        g gVar2;
        dialogInterface.dismiss();
        String E = TbadkApplication.E();
        if (E != null && E.length() > 0) {
            bcVar = this.a.F;
            gVar = this.a.D;
            String name = gVar.f().getName();
            gVar2 = this.a.D;
            bcVar.a(name, Long.valueOf(gVar2.f().getId()).longValue());
            return;
        }
        LoginActivity.a((Activity) this.a, this.a.getString(com.baidu.tieba.a.k.login_to_use), true, 11036);
    }
}
