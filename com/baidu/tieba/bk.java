package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk extends BroadcastReceiver {
    final /* synthetic */ UpdateDialog this$0;

    private bk(UpdateDialog updateDialog) {
        this.this$0 = updateDialog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bk(UpdateDialog updateDialog, bk bkVar) {
        this(updateDialog);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ac acVar;
        ac acVar2;
        ac acVar3;
        ac acVar4;
        if (intent.getBooleanExtra("action_update_complete", false)) {
            acVar4 = this.this$0.aeo;
            acVar4.dismiss();
            this.this$0.finish();
        } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
            acVar3 = this.this$0.aeo;
            acVar3.dismiss();
            this.this$0.showToast(this.this$0.getString(y.update_app_error));
            this.this$0.finish();
            this.this$0.xb();
        } else {
            int intExtra = intent.getIntExtra("action_update_download_progress", 0);
            acVar = this.this$0.aeo;
            if (acVar != null) {
                acVar2 = this.this$0.aeo;
                acVar2.dy(intExtra);
            }
        }
    }
}
