package com.baidu.tieba.barcode;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CaptureActivity f1146a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(CaptureActivity captureActivity) {
        this.f1146a = captureActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
            this.f1146a.onPause();
            this.f1146a.onResume();
        }
    }
}
