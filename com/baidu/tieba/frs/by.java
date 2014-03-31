package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* loaded from: classes.dex */
final class by implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.model.bc bcVar;
        cy cyVar;
        cy cyVar2;
        dialogInterface.dismiss();
        String E = TbadkApplication.E();
        if (E != null && E.length() > 0) {
            bcVar = this.a.u;
            cyVar = this.a.q;
            String name = cyVar.b().getName();
            cyVar2 = this.a.q;
            bcVar.a(name, Long.valueOf(cyVar2.b().getId()).longValue());
            return;
        }
        LoginActivity.a((Activity) this.a, this.a.getString(com.baidu.tieba.a.k.login_to_use), true, 11036);
    }
}
