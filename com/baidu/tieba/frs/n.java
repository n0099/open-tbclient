package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.model.ci;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ci ciVar;
        com.baidu.tieba.model.ak akVar;
        com.baidu.tieba.model.ak akVar2;
        dialogInterface.dismiss();
        String A = TiebaApplication.A();
        if (A != null && A.length() > 0) {
            ciVar = this.a.y;
            akVar = this.a.w;
            String name = akVar.b().getName();
            akVar2 = this.a.w;
            ciVar.a(name, Long.valueOf(akVar2.b().getId()).longValue());
            return;
        }
        LoginActivity.a((Activity) this.a, this.a.getString(R.string.login_to_use), true, 11036);
    }
}
