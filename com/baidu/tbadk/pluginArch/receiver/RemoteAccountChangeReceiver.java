package com.baidu.tbadk.pluginArch.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.pluginArch.o;
/* loaded from: classes.dex */
public class RemoteAccountChangeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && "adp.bdstatisticsmanager2.account_changed".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("intent_data_userid");
            if (!TextUtils.isEmpty(stringExtra)) {
                o.a = stringExtra;
            }
        }
    }
}
