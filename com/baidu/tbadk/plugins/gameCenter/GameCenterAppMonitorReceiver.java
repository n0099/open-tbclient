package com.baidu.tbadk.plugins.gameCenter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class GameCenterAppMonitorReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (a.La() != null) {
            try {
                a.La().onReceive(context, intent);
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }
}
