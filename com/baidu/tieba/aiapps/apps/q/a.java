package com.baidu.tieba.aiapps.apps.q;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes4.dex */
public class a {
    public static void bl(boolean z) {
        b.putBoolean("PREFS_NIGHT_MODE", z);
    }

    public static boolean Ev() {
        return b.getBoolean("PREFS_NIGHT_MODE", false);
    }

    public static void gA(boolean z) {
        Intent intent = new Intent("com.baidu.swan.skin.nightmodechanged");
        intent.putExtra("key_night_mode", z);
        LocalBroadcastManager.getInstance(AppRuntime.getAppContext()).sendBroadcast(intent);
    }
}
