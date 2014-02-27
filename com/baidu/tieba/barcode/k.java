package com.baidu.tieba.barcode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
final class k extends BroadcastReceiver {
    final /* synthetic */ CaptureActivity a;

    private k(CaptureActivity captureActivity) {
        this.a = captureActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(CaptureActivity captureActivity, byte b) {
        this(captureActivity);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.a.releaseResouce();
        if (intent.getBooleanExtra("result", false)) {
            CaptureActivity.a(this.a);
        } else {
            this.a.showToast(intent.getStringExtra("error"));
        }
    }
}
