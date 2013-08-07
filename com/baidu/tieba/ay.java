package com.baidu.tieba;

import com.baidu.tieba.data.CombineDownload;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements ap {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f915a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(UpdateDialog updateDialog) {
        this.f915a = updateDialog;
    }

    @Override // com.baidu.tieba.ap
    public void a(boolean z) {
        CombineDownload combineDownload;
        if (z) {
            UpdateDialog updateDialog = this.f915a;
            combineDownload = this.f915a.b;
            updateDialog.c(combineDownload.getAppUrl());
        } else {
            this.f915a.b();
        }
        this.f915a.finish();
    }

    @Override // com.baidu.tieba.ap
    public void a() {
        this.f915a.finish();
    }
}
