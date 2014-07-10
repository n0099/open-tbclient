package com.baidu.tieba.barcode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class j extends BroadcastReceiver {
    final /* synthetic */ CaptureActivity this$0;

    private j(CaptureActivity captureActivity) {
        this.this$0 = captureActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(CaptureActivity captureActivity, j jVar) {
        this(captureActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.this$0.releaseResouce();
        if (intent.getBooleanExtra("result", false)) {
            CaptureActivity.a(this.this$0);
        } else {
            this.this$0.showToast(intent.getStringExtra("error"));
        }
    }
}
