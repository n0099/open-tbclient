package com.baidu.tieba.frs;

import android.app.AlertDialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        AlertDialog alertDialog;
        FrsActivity frsActivity = this.a;
        str = this.a.f;
        frsActivity.c(str);
        alertDialog = this.a.T;
        alertDialog.dismiss();
    }
}
