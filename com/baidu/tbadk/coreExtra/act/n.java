package com.baidu.tbadk.coreExtra.act;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class n extends BroadcastReceiver {
    final /* synthetic */ EditHeadActivity a;

    private n(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(EditHeadActivity editHeadActivity, n nVar) {
        this(editHeadActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.a.releaseResouce();
        if (intent.getBooleanExtra("result", false)) {
            EditHeadActivity.i(this.a);
            return;
        }
        this.a.showToast(intent.getStringExtra("error"));
        if (EditHeadActivity.d(this.a) != null) {
            EditHeadActivity.d(this.a).setEnabled(false);
        }
    }
}
