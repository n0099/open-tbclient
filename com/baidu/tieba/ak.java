package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
final class ak extends BroadcastReceiver {
    final /* synthetic */ UpdateDialog a;

    private ak(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ak(UpdateDialog updateDialog, byte b) {
        this(updateDialog);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        m mVar;
        m mVar2;
        m mVar3;
        m mVar4;
        int intExtra = intent.getIntExtra("progress", 0);
        String stringExtra = intent.getStringExtra("closeFlag");
        String stringExtra2 = intent.getStringExtra("showToast");
        if (stringExtra != null && "true".equals(stringExtra)) {
            mVar4 = this.a.c;
            mVar4.dismiss();
            this.a.finish();
        }
        if (stringExtra2 != null && "other_error".equals(stringExtra2)) {
            mVar3 = this.a.c;
            mVar3.dismiss();
            this.a.showToast(this.a.getString(com.baidu.tieba.a.k.update_app_error));
            this.a.finish();
            this.a.a();
        }
        mVar = this.a.c;
        if (mVar != null) {
            mVar2 = this.a.c;
            mVar2.a(intExtra);
        }
    }
}
