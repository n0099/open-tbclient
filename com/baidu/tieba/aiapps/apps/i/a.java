package com.baidu.tieba.aiapps.apps.i;

import android.content.Intent;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes8.dex */
public class a {
    public static boolean ahK() {
        return com.baidu.swan.apps.t.a.awU().ahK();
    }

    public static void md(boolean z) {
        Intent intent = new Intent("com.baidu.swan.skin.nightmodechanged");
        intent.putExtra("key_night_mode", z);
        LocalBroadcastManager.getInstance(AppRuntime.getAppContext()).sendBroadcast(intent);
    }

    public static void bNf() {
        int defaultNightMode = AppCompatDelegate.getDefaultNightMode();
        int i = ahK() ? 2 : 1;
        if (defaultNightMode != i) {
            AppCompatDelegate.setDefaultNightMode(i);
        }
    }
}
