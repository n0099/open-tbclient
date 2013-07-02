package com.baidu.tieba;

import com.baidu.tieba.data.CombineDownload;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements an {
    final /* synthetic */ UpdateDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    @Override // com.baidu.tieba.an
    public void a(boolean z) {
        CombineDownload combineDownload;
        if (z) {
            UpdateDialog updateDialog = this.a;
            combineDownload = this.a.b;
            updateDialog.c(combineDownload.getAppUrl());
        } else {
            this.a.b();
        }
        this.a.finish();
    }

    @Override // com.baidu.tieba.an
    public void a() {
        this.a.finish();
    }
}
