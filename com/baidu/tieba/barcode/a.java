package com.baidu.tieba.barcode;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CaptureActivity f1134a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CaptureActivity captureActivity) {
        this.f1134a = captureActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1134a.setResult(0);
        this.f1134a.finish();
    }
}
