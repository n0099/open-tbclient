package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.model.cj;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1324a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(FrsImageActivity frsImageActivity) {
        this.f1324a = frsImageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        cj cjVar;
        com.baidu.tieba.model.ar arVar;
        com.baidu.tieba.model.ar arVar2;
        dialogInterface.dismiss();
        String A = TiebaApplication.A();
        if (A != null && A.length() > 0) {
            cjVar = this.f1324a.u;
            arVar = this.f1324a.r;
            String name = arVar.a().getName();
            arVar2 = this.f1324a.r;
            cjVar.a(name, Long.valueOf(arVar2.a().getId()).longValue());
            return;
        }
        LoginActivity.a((Activity) this.f1324a, this.f1324a.getString(R.string.login_to_use), true, 11036);
    }
}
