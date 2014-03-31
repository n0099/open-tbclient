package com.baidu.tieba;

import com.baidu.tieba.data.CombineDownload;
/* loaded from: classes.dex */
final class af implements q {
    final /* synthetic */ UpdateDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    @Override // com.baidu.tieba.q
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

    @Override // com.baidu.tieba.q
    public final void b() {
        m mVar;
        mVar = this.a.c;
        mVar.dismiss();
        this.a.finish();
    }

    @Override // com.baidu.tieba.q
    public final void c() {
        this.a.a();
    }

    @Override // com.baidu.tieba.q
    public final void a() {
        this.a.finish();
    }
}
