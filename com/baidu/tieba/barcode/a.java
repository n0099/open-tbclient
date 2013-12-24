package com.baidu.tieba.barcode;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ CaptureActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CaptureActivity captureActivity) {
        this.a = captureActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.setResult(0);
        this.a.finish();
    }
}
