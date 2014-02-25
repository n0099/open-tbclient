package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.model.bx bxVar;
        com.baidu.tieba.model.al alVar;
        com.baidu.tieba.model.al alVar2;
        dialogInterface.dismiss();
        String A = TiebaApplication.A();
        if (A != null && A.length() > 0) {
            bxVar = this.a.u;
            alVar = this.a.q;
            String name = alVar.b().getName();
            alVar2 = this.a.q;
            bxVar.a(name, Long.valueOf(alVar2.b().getId()).longValue());
            return;
        }
        LoginActivity.a((Activity) this.a, this.a.getString(R.string.login_to_use), true, 11036);
    }
}
