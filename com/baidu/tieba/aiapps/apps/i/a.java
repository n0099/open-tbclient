package com.baidu.tieba.aiapps.apps.i;

import android.content.Intent;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes9.dex */
public class a {
    public static boolean aii() {
        return com.baidu.swan.apps.t.a.axs().aii();
    }

    public static void mh(boolean z) {
        Intent intent = new Intent("com.baidu.swan.skin.nightmodechanged");
        intent.putExtra("key_night_mode", z);
        LocalBroadcastManager.getInstance(AppRuntime.getAppContext()).sendBroadcast(intent);
    }

    public static void bNN() {
        int defaultNightMode = AppCompatDelegate.getDefaultNightMode();
        int i = aii() ? 2 : 1;
        if (defaultNightMode != i) {
            AppCompatDelegate.setDefaultNightMode(i);
        }
    }
}
