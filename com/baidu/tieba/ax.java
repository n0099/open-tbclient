package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends BroadcastReceiver {
    final /* synthetic */ UpdateDialog a;

    private ax(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ax(UpdateDialog updateDialog, ax axVar) {
        this(updateDialog);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        y yVar;
        y yVar2;
        y yVar3;
        y yVar4;
        int intExtra = intent.getIntExtra("progress", 0);
        String stringExtra = intent.getStringExtra("closeFlag");
        String stringExtra2 = intent.getStringExtra("showToast");
        if (stringExtra != null && "true".equals(stringExtra)) {
            yVar4 = this.a.e;
            yVar4.dismiss();
            this.a.finish();
        }
        if (stringExtra2 != null && "other_error".equals(stringExtra2)) {
            yVar3 = this.a.e;
            yVar3.dismiss();
            this.a.showToast(this.a.getString(u.update_app_error));
            this.a.finish();
            this.a.c();
        }
        yVar = this.a.e;
        if (yVar != null) {
            yVar2 = this.a.e;
            yVar2.a(intExtra);
        }
    }
}
