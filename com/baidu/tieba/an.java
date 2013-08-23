package com.baidu.tieba;

import com.baidu.tieba.data.CombineDownload;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements ah {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f924a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(UpdateDialog updateDialog) {
        this.f924a = updateDialog;
    }

    @Override // com.baidu.tieba.ah
    public void a(boolean z) {
        CombineDownload combineDownload;
        if (z) {
            UpdateDialog updateDialog = this.f924a;
            combineDownload = this.f924a.b;
            updateDialog.c(combineDownload.getAppUrl());
        } else {
            this.f924a.b();
        }
        this.f924a.finish();
    }

    @Override // com.baidu.tieba.ah
    public void a() {
        this.f924a.finish();
    }
}
