package com.baidu.tieba.game;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class GameInstallReceiver extends BroadcastReceiver {
    public static final String ACTION_INSTALL = "android.intent.action.PACKAGE_ADDED";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && ACTION_INSTALL.equals(intent.getAction())) {
            String dataString = intent.getDataString();
            if (!TextUtils.isEmpty(dataString)) {
                String[] split = dataString.split(":");
                if (split != null && split.length == 2) {
                    dataString = split[1];
                }
                new ae(this, dataString).execute(new Void[0]);
            }
        }
    }
}
