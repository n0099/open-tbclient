package com.baidu.tbadk.plugins.gameCenter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.lib.util.BdLog;
import d.a.n0.p0.c.a;
/* loaded from: classes3.dex */
public class GameCenterDownloadReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (a.c() != null) {
            try {
                a.c().onReceive(context, intent);
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }
}
