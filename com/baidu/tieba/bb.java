package com.baidu.tieba;

import com.baidu.tieba.data.CombineDownload;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements aq {
    final /* synthetic */ UpdateDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    @Override // com.baidu.tieba.aq
    public void a(boolean z) {
        CombineDownload combineDownload;
        if (z) {
            UpdateDialog updateDialog = this.a;
            combineDownload = this.a.b;
            updateDialog.a(combineDownload.getAppUrl());
        } else {
            this.a.a();
        }
        this.a.finish();
    }

    @Override // com.baidu.tieba.aq
    public void a() {
        this.a.finish();
    }
}
