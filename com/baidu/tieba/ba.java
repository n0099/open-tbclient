package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba extends BroadcastReceiver {
    final /* synthetic */ UpdateDialog this$0;

    private ba(UpdateDialog updateDialog) {
        this.this$0 = updateDialog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ba(UpdateDialog updateDialog, ba baVar) {
        this(updateDialog);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z;
        af afVar;
        af afVar2;
        af afVar3;
        af afVar4;
        af afVar5;
        this.this$0.alz = intent.getBooleanExtra("action_background_downloading", false);
        z = this.this$0.alz;
        if (z) {
            this.this$0.showToast(z.background_updating);
            afVar5 = this.this$0.alF;
            afVar5.dismiss();
            this.this$0.finish();
        } else if (intent.getBooleanExtra("action_update_complete", false)) {
            afVar4 = this.this$0.alF;
            afVar4.dismiss();
            this.this$0.finish();
        } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
            afVar3 = this.this$0.alF;
            afVar3.dismiss();
            this.this$0.showToast(this.this$0.getPageContext().getString(z.update_app_error));
            this.this$0.finish();
            this.this$0.Aw();
        } else {
            int intExtra = intent.getIntExtra("action_update_download_progress", 0);
            afVar = this.this$0.alF;
            if (afVar != null) {
                afVar2 = this.this$0.alF;
                afVar2.updateProgress(intExtra);
            }
        }
    }
}
