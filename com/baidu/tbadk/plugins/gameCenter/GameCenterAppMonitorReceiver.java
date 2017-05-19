package com.baidu.tbadk.plugins.gameCenter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public class GameCenterAppMonitorReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (a.Gc() != null) {
            a.Gc().onReceive(context, intent);
        }
    }
}
