package com.baidu.tieba.barcode;

import android.view.View;
import com.baidu.tieba.write.bd;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ CaptureActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(CaptureActivity captureActivity) {
        this.a = captureActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean e;
        e = this.a.e();
        if (e) {
            bd.b(this.a);
        }
    }
}
