package com.baidu.tieba.barcode;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements DialogInterface.OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ CaptureActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(CaptureActivity captureActivity, String str) {
        this.b = captureActivity;
        this.a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ProgressBar progressBar;
        com.baidu.tieba.im.d.i.a((Context) this.b, this.a, false);
        Intent intent = new Intent();
        intent.putExtra("result", this.a);
        this.b.setResult(-1, intent);
        progressBar = this.b.k;
        progressBar.setVisibility(8);
        this.b.finish();
    }
}
