package com.baidu.tieba;

import com.baidu.tieba.data.CombineDownload;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements ap {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f1073a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(UpdateDialog updateDialog) {
        this.f1073a = updateDialog;
    }

    @Override // com.baidu.tieba.ap
    public void a(boolean z) {
        CombineDownload combineDownload;
        if (!z) {
            this.f1073a.b();
        } else {
            UpdateDialog updateDialog = this.f1073a;
            combineDownload = this.f1073a.b;
            updateDialog.c(combineDownload.getAppUrl());
        }
        this.f1073a.finish();
    }

    @Override // com.baidu.tieba.ap
    public void a() {
        this.f1073a.finish();
    }
}
