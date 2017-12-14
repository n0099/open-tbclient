package com.baidu.tbadk.plugins.gameCenter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class GameCenterDownloadReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (a.GS() != null) {
            try {
                a.GS().onReceive(context, intent);
            } catch (RuntimeException e) {
                BdLog.e(e);
            }
        }
    }
}
