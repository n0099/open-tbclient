package com.baidu.tieba;

import com.baidu.tieba.data.CombineDownload;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements ak {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f941a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(UpdateDialog updateDialog) {
        this.f941a = updateDialog;
    }

    @Override // com.baidu.tieba.ak
    public void a(boolean z) {
        CombineDownload combineDownload;
        if (z) {
            UpdateDialog updateDialog = this.f941a;
            combineDownload = this.f941a.b;
            updateDialog.c(combineDownload.getAppUrl());
        } else {
            this.f941a.b();
        }
        this.f941a.finish();
    }

    @Override // com.baidu.tieba.ak
    public void a() {
        this.f941a.finish();
    }
}
