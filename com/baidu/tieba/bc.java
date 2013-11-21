package com.baidu.tieba;

import com.baidu.tieba.data.CombineDownload;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements au {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f1117a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(UpdateDialog updateDialog) {
        this.f1117a = updateDialog;
    }

    @Override // com.baidu.tieba.au
    public void a(boolean z) {
        CombineDownload combineDownload;
        if (!z) {
            this.f1117a.a();
        } else {
            UpdateDialog updateDialog = this.f1117a;
            combineDownload = this.f1117a.b;
            updateDialog.a(combineDownload.getAppUrl());
        }
        this.f1117a.finish();
    }

    @Override // com.baidu.tieba.au
    public void a() {
        this.f1117a.finish();
    }
}
