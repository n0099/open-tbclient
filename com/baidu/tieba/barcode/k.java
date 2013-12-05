package com.baidu.tieba.barcode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CaptureActivity f1151a;

    private k(CaptureActivity captureActivity) {
        this.f1151a = captureActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(CaptureActivity captureActivity, a aVar) {
        this(captureActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f1151a.releaseResouce();
        if (intent.getBooleanExtra("result", false)) {
            this.f1151a.g();
        } else {
            this.f1151a.showToast(intent.getStringExtra("error"));
        }
    }
}
