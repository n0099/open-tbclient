package com.baidu.tieba.aiapps.apps.media.b;

import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void O(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (DEBUG) {
                Log.e("LiveStatusEventHelper", "dispatchNetStatusEvent failed slaveId: " + str + " ,liveId: " + str2);
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("lType", "netstatus");
        hashMap.put("liveId", str2);
        hashMap.put("data", str3);
        hashMap.put("wvID", str);
        com.baidu.swan.apps.w.e.LE().a(new com.baidu.swan.apps.m.a.b("live", hashMap));
    }
}
