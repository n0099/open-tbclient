package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.model.ci;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1363a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsActivity frsActivity) {
        this.f1363a = frsActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ci ciVar;
        com.baidu.tieba.model.ak akVar;
        com.baidu.tieba.model.ak akVar2;
        dialogInterface.dismiss();
        String A = TiebaApplication.A();
        if (A != null && A.length() > 0) {
            ciVar = this.f1363a.y;
            akVar = this.f1363a.w;
            String name = akVar.a().getName();
            akVar2 = this.f1363a.w;
            ciVar.a(name, Long.valueOf(akVar2.a().getId()).longValue());
            return;
        }
        LoginActivity.a((Activity) this.f1363a, this.f1363a.getString(R.string.login_to_use), true, 11036);
    }
}
