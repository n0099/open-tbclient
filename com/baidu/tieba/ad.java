package com.baidu.tieba;

import com.baidu.tieba.data.CombineDownload;
/* loaded from: classes.dex */
final class ad implements o {
    final /* synthetic */ UpdateDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    @Override // com.baidu.tieba.o
    public final void a(boolean z) {
        CombineDownload combineDownload;
        this.a.f = z;
        if (z) {
            UpdateDialog updateDialog = this.a;
            combineDownload = this.a.b;
            UpdateDialog.a(updateDialog, combineDownload.getAppUrl());
        } else {
            UpdateDialog.d(this.a);
        }
        this.a.e = true;
    }

    @Override // com.baidu.tieba.o
    public final void b() {
        k kVar;
        kVar = this.a.c;
        kVar.dismiss();
        this.a.finish();
    }

    @Override // com.baidu.tieba.o
    public final void c() {
        this.a.a();
    }

    @Override // com.baidu.tieba.o
    public final void a() {
        this.a.finish();
    }
}
