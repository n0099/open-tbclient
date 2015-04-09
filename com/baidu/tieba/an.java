package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends BroadcastReceiver {
    final /* synthetic */ UpdateDialog this$0;

    private an(UpdateDialog updateDialog) {
        this.this$0 = updateDialog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ an(UpdateDialog updateDialog, an anVar) {
        this(updateDialog);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z;
        ab abVar;
        ab abVar2;
        ab abVar3;
        ab abVar4;
        ab abVar5;
        this.this$0.aum = intent.getBooleanExtra("action_background_downloading", false);
        z = this.this$0.aum;
        if (z) {
            this.this$0.showToast(y.background_updating);
            abVar5 = this.this$0.aus;
            abVar5.dismiss();
            this.this$0.finish();
        } else if (intent.getBooleanExtra("action_update_complete", false)) {
            abVar4 = this.this$0.aus;
            abVar4.dismiss();
            this.this$0.finish();
        } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
            abVar3 = this.this$0.aus;
            abVar3.dismiss();
            this.this$0.showToast(this.this$0.getPageContext().getString(y.update_app_error));
            this.this$0.finish();
            this.this$0.Eh();
        } else {
            int intExtra = intent.getIntExtra("action_update_download_progress", 0);
            abVar = this.this$0.aus;
            if (abVar != null) {
                abVar2 = this.this$0.aus;
                abVar2.updateProgress(intExtra);
            }
        }
    }
}
