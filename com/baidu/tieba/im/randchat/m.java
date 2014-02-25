package com.baidu.tieba.im.randchat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class m extends BroadcastReceiver {
    final /* synthetic */ WaittingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(WaittingActivity waittingActivity) {
        this.a = waittingActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() == null) {
            this.a.showToast(R.string.rand_chat_waiting_net_error);
        }
    }
}
