package com.baidu.tieba.barcode;

import android.view.View;
import com.baidu.tieba.write.bd;
/* loaded from: classes.dex */
class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CaptureActivity f1141a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(CaptureActivity captureActivity) {
        this.f1141a = captureActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean e;
        e = this.f1141a.e();
        if (e) {
            bd.b(this.f1141a);
        }
    }
}
