package com.baidu.tieba;

import com.baidu.tieba.data.CombineDownload;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements ax {
    final /* synthetic */ UpdateDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    @Override // com.baidu.tieba.ax
    public void a(boolean z) {
        CombineDownload combineDownload;
        if (!z) {
            this.a.a();
        } else {
            UpdateDialog updateDialog = this.a;
            combineDownload = this.a.b;
            updateDialog.a(combineDownload.getAppUrl());
        }
        this.a.finish();
    }

    @Override // com.baidu.tieba.ax
    public void a() {
        this.a.finish();
    }
}
