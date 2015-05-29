package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends BroadcastReceiver {
    final /* synthetic */ UpdateDialog this$0;

    private ai(UpdateDialog updateDialog) {
        this.this$0 = updateDialog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ai(UpdateDialog updateDialog, ai aiVar) {
        this(updateDialog);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z;
        w wVar;
        w wVar2;
        w wVar3;
        w wVar4;
        w wVar5;
        this.this$0.avP = intent.getBooleanExtra("action_background_downloading", false);
        z = this.this$0.avP;
        if (z) {
            this.this$0.showToast(t.background_updating);
            wVar5 = this.this$0.avV;
            wVar5.dismiss();
            this.this$0.finish();
        } else if (intent.getBooleanExtra("action_update_complete", false)) {
            wVar4 = this.this$0.avV;
            wVar4.dismiss();
            this.this$0.finish();
        } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
            wVar3 = this.this$0.avV;
            wVar3.dismiss();
            this.this$0.showToast(this.this$0.getPageContext().getString(t.update_app_error));
            this.this$0.finish();
            this.this$0.EU();
        } else {
            int intExtra = intent.getIntExtra("action_update_download_progress", 0);
            wVar = this.this$0.avV;
            if (wVar != null) {
                wVar2 = this.this$0.avV;
                wVar2.updateProgress(intExtra);
            }
        }
    }
}
