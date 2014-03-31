package com.baidu.tieba;

import android.view.View;
/* loaded from: classes.dex */
final class ai implements View.OnClickListener {
    final /* synthetic */ UpdateDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        m mVar;
        boolean z;
        mVar = this.a.c;
        mVar.dismiss();
        this.a.finish();
        z = this.a.e;
        if (!z) {
            return;
        }
        this.a.a();
    }
}
