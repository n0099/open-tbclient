package com.baidu.tieba;

import android.view.View;
import com.baidu.tieba.data.CombineDownload;
/* loaded from: classes.dex */
final class aj implements View.OnClickListener {
    final /* synthetic */ UpdateDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        m mVar;
        boolean z;
        CombineDownload combineDownload;
        mVar = this.a.c;
        mVar.a();
        z = this.a.f;
        if (z) {
            UpdateDialog updateDialog = this.a;
            combineDownload = this.a.b;
            UpdateDialog.a(updateDialog, combineDownload.getAppUrl());
            return;
        }
        UpdateDialog.d(this.a);
    }
}
