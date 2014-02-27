package com.baidu.tieba.barcode;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i implements DialogInterface.OnCancelListener {
    final /* synthetic */ CaptureActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(CaptureActivity captureActivity) {
        this.a = captureActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.a.setResult(0);
        this.a.finish();
    }
}
