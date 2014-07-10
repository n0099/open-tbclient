package com.baidu.tieba;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements View.OnClickListener {
    final /* synthetic */ UpdateDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        ac acVar;
        z = this.a.a;
        if (z) {
            this.a.b();
        }
        acVar = this.a.h;
        acVar.dismiss();
        this.a.finish();
    }
}
