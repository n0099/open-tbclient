package com.baidu.tieba.im.randchat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class q extends BroadcastReceiver {
    final /* synthetic */ WaittingActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(WaittingActivity waittingActivity) {
        this.this$0 = waittingActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() == null) {
            this.this$0.showToast(y.rand_chat_waiting_net_error);
        }
    }
}
