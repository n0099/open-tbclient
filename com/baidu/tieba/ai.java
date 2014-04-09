package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
final class ai extends BroadcastReceiver {
    final /* synthetic */ UpdateDialog a;

    private ai(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ai(UpdateDialog updateDialog, byte b) {
        this(updateDialog);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        k kVar;
        k kVar2;
        k kVar3;
        k kVar4;
        int intExtra = intent.getIntExtra("progress", 0);
        String stringExtra = intent.getStringExtra("closeFlag");
        String stringExtra2 = intent.getStringExtra("showToast");
        if (stringExtra != null && "true".equals(stringExtra)) {
            kVar4 = this.a.c;
            kVar4.dismiss();
            this.a.finish();
        }
        if (stringExtra2 != null && "other_error".equals(stringExtra2)) {
            kVar3 = this.a.c;
            kVar3.dismiss();
            this.a.showToast(this.a.getString(com.baidu.tieba.a.k.update_app_error));
            this.a.finish();
            this.a.a();
        }
        kVar = this.a.c;
        if (kVar != null) {
            kVar2 = this.a.c;
            kVar2.a(intExtra);
        }
    }
}
