package com.baidu.tieba.barcode;

import com.baidu.tbadk.core.util.bm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements bm {
    final /* synthetic */ CaptureActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(CaptureActivity captureActivity) {
        this.a = captureActivity;
    }

    @Override // com.baidu.tbadk.core.util.bm
    public void a() {
        this.a.onPause();
        this.a.onResume();
    }
}
