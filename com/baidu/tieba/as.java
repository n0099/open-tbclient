package com.baidu.tieba;

import com.baidu.tieba.data.CombineDownload;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements ac {
    final /* synthetic */ UpdateDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    @Override // com.baidu.tieba.ac
    public void a(boolean z) {
        CombineDownload combineDownload;
        this.a.b = z;
        if (z) {
            UpdateDialog updateDialog = this.a;
            combineDownload = this.a.d;
            updateDialog.a(combineDownload.getAppUrl());
        } else {
            this.a.b();
        }
        this.a.a = true;
    }

    @Override // com.baidu.tieba.ac
    public void b() {
        y yVar;
        yVar = this.a.e;
        yVar.dismiss();
        this.a.finish();
    }

    @Override // com.baidu.tieba.ac
    public void c() {
        this.a.c();
    }

    @Override // com.baidu.tieba.ac
    public void a() {
        this.a.finish();
    }
}
