package com.baidu.tieba.aiapps.apps.n;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatDelegate;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes12.dex */
public class a {
    public static boolean getNightModeSwitcherState() {
        return com.baidu.swan.apps.w.a.Uv().getNightModeSwitcherState();
    }

    public static void hL(boolean z) {
        Intent intent = new Intent("com.baidu.swan.skin.nightmodechanged");
        intent.putExtra("key_night_mode", z);
        LocalBroadcastManager.getInstance(AppRuntime.getAppContext()).sendBroadcast(intent);
    }

    public static void bbp() {
        int defaultNightMode = AppCompatDelegate.getDefaultNightMode();
        int i = getNightModeSwitcherState() ? 2 : 1;
        if (defaultNightMode != i) {
            AppCompatDelegate.setDefaultNightMode(i);
        }
    }
}
