package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class z implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.model.bx bxVar;
        com.baidu.tieba.model.z zVar;
        com.baidu.tieba.model.z zVar2;
        dialogInterface.dismiss();
        String v = TiebaApplication.v();
        if (v != null && v.length() > 0) {
            bxVar = this.a.C;
            zVar = this.a.A;
            String name = zVar.f().getName();
            zVar2 = this.a.A;
            bxVar.a(name, Long.valueOf(zVar2.f().getId()).longValue());
            return;
        }
        LoginActivity.a((Activity) this.a, this.a.getString(R.string.login_to_use), true, 11036);
    }
}
