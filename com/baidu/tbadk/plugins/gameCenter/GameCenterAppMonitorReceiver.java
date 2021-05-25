package com.baidu.tbadk.plugins.gameCenter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.lib.util.BdLog;
import d.a.m0.p0.c.a;
/* loaded from: classes3.dex */
public class GameCenterAppMonitorReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (a.a() != null) {
            try {
                a.a().onReceive(context, intent);
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }
}
