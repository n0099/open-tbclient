package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends BroadcastReceiver {
    final /* synthetic */ UpdateDialog this$0;

    private ay(UpdateDialog updateDialog) {
        this.this$0 = updateDialog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ay(UpdateDialog updateDialog, ay ayVar) {
        this(updateDialog);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ab abVar;
        ab abVar2;
        ab abVar3;
        ab abVar4;
        if (intent.getBooleanExtra("action_update_complete", false)) {
            abVar4 = this.this$0.h;
            abVar4.dismiss();
            this.this$0.finish();
        } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
            abVar3 = this.this$0.h;
            abVar3.dismiss();
            this.this$0.showToast(this.this$0.getString(x.update_app_error));
            this.this$0.finish();
            this.this$0.b();
        } else {
            int intExtra = intent.getIntExtra("action_update_download_progress", 0);
            abVar = this.this$0.h;
            if (abVar != null) {
                abVar2 = this.this$0.h;
                abVar2.a(intExtra);
            }
        }
    }
}
