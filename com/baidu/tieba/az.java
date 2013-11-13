package com.baidu.tieba;

import com.baidu.tieba.data.CombineDownload;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements ar {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f1109a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(UpdateDialog updateDialog) {
        this.f1109a = updateDialog;
    }

    @Override // com.baidu.tieba.ar
    public void a(boolean z) {
        CombineDownload combineDownload;
        if (!z) {
            this.f1109a.a();
        } else {
            UpdateDialog updateDialog = this.f1109a;
            combineDownload = this.f1109a.b;
            updateDialog.a(combineDownload.getAppUrl());
        }
        this.f1109a.finish();
    }

    @Override // com.baidu.tieba.ar
    public void a() {
        this.f1109a.finish();
    }
}
