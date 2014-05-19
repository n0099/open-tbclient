package com.baidu.tieba;

import android.view.View;
import com.baidu.tieba.data.CombineDownload;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements View.OnClickListener {
    final /* synthetic */ UpdateDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        y yVar;
        boolean z;
        CombineDownload combineDownload;
        yVar = this.a.e;
        yVar.a();
        z = this.a.b;
        if (z) {
            UpdateDialog updateDialog = this.a;
            combineDownload = this.a.d;
            updateDialog.a(combineDownload.getAppUrl());
            return;
        }
        this.a.b();
    }
}
