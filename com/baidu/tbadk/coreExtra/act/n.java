package com.baidu.tbadk.coreExtra.act;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BroadcastReceiver {
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
        TextView textView;
        TextView textView2;
        this.this$0.releaseResouce();
        if (intent.getBooleanExtra("result", false)) {
            this.this$0.initData();
            return;
        }
        this.this$0.showToast(intent.getStringExtra("error"));
        textView = this.this$0.JC;
        if (textView != null) {
            textView2 = this.this$0.JC;
            textView2.setEnabled(false);
        }
    }
}
