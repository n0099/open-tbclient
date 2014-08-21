package com.baidu.tieba.barcode;

import android.app.Dialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements DialogInterface.OnClickListener {
    final /* synthetic */ CaptureActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(CaptureActivity captureActivity) {
        this.a = captureActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface != null) {
            if (dialogInterface instanceof Dialog) {
                com.baidu.adp.lib.e.e.b((Dialog) dialogInterface, this.a);
            }
            this.a.onPause();
            this.a.onResume();
        }
    }
}
