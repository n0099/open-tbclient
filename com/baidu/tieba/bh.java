package com.baidu.tieba;

import com.baidu.tieba.data.CombineDownload;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements ay {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f1163a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(UpdateDialog updateDialog) {
        this.f1163a = updateDialog;
    }

    @Override // com.baidu.tieba.ay
    public void a(boolean z) {
        CombineDownload combineDownload;
        if (!z) {
            this.f1163a.a();
        } else {
            UpdateDialog updateDialog = this.f1163a;
            combineDownload = this.f1163a.b;
            updateDialog.a(combineDownload.getAppUrl());
        }
        this.f1163a.finish();
    }

    @Override // com.baidu.tieba.ay
    public void a() {
        this.f1163a.finish();
    }
}
