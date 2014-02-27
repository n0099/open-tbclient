package com.baidu.tieba.barcode;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements DialogInterface.OnClickListener {
    final /* synthetic */ CaptureActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(CaptureActivity captureActivity) {
        this.a = captureActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
            this.a.onPause();
            this.a.onResume();
        }
    }
}
