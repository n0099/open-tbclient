package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.model.ci;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ci ciVar;
        com.baidu.tieba.model.ar arVar;
        com.baidu.tieba.model.ar arVar2;
        dialogInterface.dismiss();
        String A = TiebaApplication.A();
        if (A != null && A.length() > 0) {
            ciVar = this.a.t;
            arVar = this.a.q;
            String name = arVar.b().getName();
            arVar2 = this.a.q;
            ciVar.a(name, Long.valueOf(arVar2.b().getId()).longValue());
            return;
        }
        LoginActivity.a((Activity) this.a, this.a.getString(R.string.login_to_use), true, 11036);
    }
}
