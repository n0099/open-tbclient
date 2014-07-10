package com.baidu.tieba.barcode;

import android.view.View;
import com.baidu.tbadk.core.util.bj;
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
            bj.b(this.a);
        }
    }
}
