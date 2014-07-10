package com.baidu.tieba.barcode;

import com.baidu.tbadk.core.util.bu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements bu {
    final /* synthetic */ CaptureActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(CaptureActivity captureActivity) {
        this.a = captureActivity;
    }

    @Override // com.baidu.tbadk.core.util.bu
    public void a() {
        this.a.onPause();
        this.a.onResume();
    }
}
