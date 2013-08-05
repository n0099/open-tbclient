package com.baidu.tieba;

import com.baidu.tieba.data.CombineDownload;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements ap {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f917a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(UpdateDialog updateDialog) {
        this.f917a = updateDialog;
    }

    @Override // com.baidu.tieba.ap
    public void a(boolean z) {
        CombineDownload combineDownload;
        if (z) {
            UpdateDialog updateDialog = this.f917a;
            combineDownload = this.f917a.b;
            updateDialog.c(combineDownload.getAppUrl());
        } else {
            this.f917a.b();
        }
        this.f917a.finish();
    }

    @Override // com.baidu.tieba.ap
    public void a() {
        this.f917a.finish();
    }
}
