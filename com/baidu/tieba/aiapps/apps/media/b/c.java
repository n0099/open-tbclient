package com.baidu.tieba.aiapps.apps.media.b;

import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
/* loaded from: classes12.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void ab(String str, String str2, String str3) {
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
        com.baidu.swan.apps.y.f.WQ().a(new com.baidu.swan.apps.n.a.b("live", hashMap));
    }
}
