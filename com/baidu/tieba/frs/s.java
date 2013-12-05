package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.model.cj;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1419a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsActivity frsActivity) {
        this.f1419a = frsActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        cj cjVar;
        com.baidu.tieba.model.ak akVar;
        com.baidu.tieba.model.ak akVar2;
        dialogInterface.dismiss();
        String B = TiebaApplication.B();
        if (B != null && B.length() > 0) {
            cjVar = this.f1419a.y;
            akVar = this.f1419a.w;
            String name = akVar.a().getName();
            akVar2 = this.f1419a.w;
            cjVar.a(name, Long.valueOf(akVar2.a().getId()).longValue());
            return;
        }
        LoginActivity.a((Activity) this.f1419a, this.f1419a.getString(R.string.login_to_use), true, 11036);
    }
}
