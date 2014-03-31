package com.baidu.tieba.barcode;

import android.view.View;
import com.baidu.tbadk.core.util.az;
/* loaded from: classes.dex */
final class b implements View.OnClickListener {
    final /* synthetic */ CaptureActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(CaptureActivity captureActivity) {
        this.a = captureActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (CaptureActivity.d(this.a)) {
            az.b(this.a);
        }
    }
}
