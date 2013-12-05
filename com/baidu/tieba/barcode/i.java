package com.baidu.tieba.barcode;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CaptureActivity f1149a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(CaptureActivity captureActivity) {
        this.f1149a = captureActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f1149a.setResult(0);
        this.f1149a.finish();
    }
}
