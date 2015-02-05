package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd extends BroadcastReceiver {
    final /* synthetic */ UpdateDialog this$0;

    private bd(UpdateDialog updateDialog) {
        this.this$0 = updateDialog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bd(UpdateDialog updateDialog, bd bdVar) {
        this(updateDialog);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z;
        ai aiVar;
        ai aiVar2;
        ai aiVar3;
        ai aiVar4;
        ai aiVar5;
        this.this$0.amq = intent.getBooleanExtra("action_background_downloading", false);
        z = this.this$0.amq;
        if (z) {
            this.this$0.showToast(z.background_updating);
            aiVar5 = this.this$0.amw;
            aiVar5.dismiss();
            this.this$0.finish();
        } else if (intent.getBooleanExtra("action_update_complete", false)) {
            aiVar4 = this.this$0.amw;
            aiVar4.dismiss();
            this.this$0.finish();
        } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
            aiVar3 = this.this$0.amw;
            aiVar3.dismiss();
            this.this$0.showToast(this.this$0.getPageContext().getString(z.update_app_error));
            this.this$0.finish();
            this.this$0.AO();
        } else {
            int intExtra = intent.getIntExtra("action_update_download_progress", 0);
            aiVar = this.this$0.amw;
            if (aiVar != null) {
                aiVar2 = this.this$0.amw;
                aiVar2.updateProgress(intExtra);
            }
        }
    }
}
