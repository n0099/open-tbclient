package com.baidu.tieba.frs;

import android.app.AlertDialog;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        AlertDialog alertDialog;
        if (TiebaApplication.b().k()) {
            StatService.onEvent(this.a, "frs_add_main_screen", "frsclick", 1);
        }
        FrsActivity frsActivity = this.a;
        str = this.a.g;
        frsActivity.c(str);
        alertDialog = this.a.U;
        alertDialog.dismiss();
    }
}
