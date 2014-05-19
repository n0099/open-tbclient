package com.baidu.tieba;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {
    final /* synthetic */ UpdateDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        y yVar;
        boolean z;
        yVar = this.a.e;
        yVar.dismiss();
        this.a.finish();
        z = this.a.a;
        if (!z) {
            return;
        }
        this.a.c();
    }
}
