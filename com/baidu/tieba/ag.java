package com.baidu.tieba;

import android.view.View;
/* loaded from: classes.dex */
final class ag implements View.OnClickListener {
    final /* synthetic */ UpdateDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        k kVar;
        boolean z;
        kVar = this.a.c;
        kVar.dismiss();
        this.a.finish();
        z = this.a.e;
        if (!z) {
            return;
        }
        this.a.a();
    }
}
