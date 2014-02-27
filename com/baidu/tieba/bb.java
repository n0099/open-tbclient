package com.baidu.tieba;

import com.baidu.tieba.data.CombineDownload;
/* loaded from: classes.dex */
final class bb implements aq {
    final /* synthetic */ UpdateDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    @Override // com.baidu.tieba.aq
    public final void a(boolean z) {
        CombineDownload combineDownload;
        if (z) {
            UpdateDialog updateDialog = this.a;
            combineDownload = this.a.b;
            UpdateDialog.a(updateDialog, combineDownload.getAppUrl());
        } else {
            UpdateDialog.b(this.a);
        }
        this.a.finish();
    }

    @Override // com.baidu.tieba.aq
    public final void a() {
        this.a.finish();
    }
}
