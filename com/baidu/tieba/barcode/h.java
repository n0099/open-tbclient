package com.baidu.tieba.barcode;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CaptureActivity f1148a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(CaptureActivity captureActivity) {
        this.f1148a = captureActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1148a.setResult(0);
        this.f1148a.finish();
    }
}
