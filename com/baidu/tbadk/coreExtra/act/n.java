package com.baidu.tbadk.coreExtra.act;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class n extends BroadcastReceiver {
    final /* synthetic */ EditHeadActivity this$0;

    private n(EditHeadActivity editHeadActivity) {
        this.this$0 = editHeadActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(EditHeadActivity editHeadActivity, n nVar) {
        this(editHeadActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.this$0.releaseResouce();
        if (intent.getBooleanExtra("result", false)) {
            EditHeadActivity.i(this.this$0);
            return;
        }
        this.this$0.showToast(intent.getStringExtra("error"));
        if (EditHeadActivity.d(this.this$0) != null) {
            EditHeadActivity.d(this.this$0).setEnabled(false);
        }
    }
}
