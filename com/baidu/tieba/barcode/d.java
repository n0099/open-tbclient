package com.baidu.tieba.barcode;

import com.baidu.tbadk.core.util.bk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements bk {
    final /* synthetic */ CaptureActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(CaptureActivity captureActivity) {
        this.a = captureActivity;
    }

    @Override // com.baidu.tbadk.core.util.bk
    public final void a() {
        this.a.onPause();
        this.a.onResume();
    }
}
