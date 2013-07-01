package com.baidu.tieba;

import com.baidu.tieba.data.CombineDownload;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements an {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f703a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(UpdateDialog updateDialog) {
        this.f703a = updateDialog;
    }

    @Override // com.baidu.tieba.an
    public void a(boolean z) {
        CombineDownload combineDownload;
        if (z) {
            UpdateDialog updateDialog = this.f703a;
            combineDownload = this.f703a.b;
            updateDialog.c(combineDownload.getAppUrl());
        } else {
            this.f703a.b();
        }
        this.f703a.finish();
    }

    @Override // com.baidu.tieba.an
    public void a() {
        this.f703a.finish();
    }
}
