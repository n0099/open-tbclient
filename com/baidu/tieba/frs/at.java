package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.model.ci;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1319a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(FrsImageActivity frsImageActivity) {
        this.f1319a = frsImageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ci ciVar;
        com.baidu.tieba.model.ar arVar;
        com.baidu.tieba.model.ar arVar2;
        dialogInterface.dismiss();
        String A = TiebaApplication.A();
        if (A != null && A.length() > 0) {
            ciVar = this.f1319a.u;
            arVar = this.f1319a.r;
            String name = arVar.a().getName();
            arVar2 = this.f1319a.r;
            ciVar.a(name, Long.valueOf(arVar2.a().getId()).longValue());
            return;
        }
        LoginActivity.a((Activity) this.f1319a, this.f1319a.getString(R.string.login_to_use), true, 11036);
    }
}
