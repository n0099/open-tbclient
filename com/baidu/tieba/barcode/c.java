package com.baidu.tieba.barcode;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CaptureActivity f1143a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(CaptureActivity captureActivity) {
        this.f1143a = captureActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
            this.f1143a.onPause();
            this.f1143a.onResume();
        }
    }
}
