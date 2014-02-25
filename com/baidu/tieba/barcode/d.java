package com.baidu.tieba.barcode;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements DialogInterface.OnClickListener {
    final /* synthetic */ CaptureActivity a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(CaptureActivity captureActivity, String str) {
        this.a = captureActivity;
        this.b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ProgressBar progressBar;
        com.baidu.tieba.im.util.q.a((Context) this.a, this.b, false);
        Intent intent = new Intent();
        intent.putExtra("result", this.b);
        this.a.setResult(-1, intent);
        progressBar = this.a.k;
        progressBar.setVisibility(8);
        this.a.finish();
    }
}
