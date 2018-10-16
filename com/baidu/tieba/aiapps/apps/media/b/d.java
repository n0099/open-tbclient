package com.baidu.tieba.aiapps.apps.media.b;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsCommonMessage;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class d {
    public static void x(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lType", "statechange");
            hashMap.put("liveId", str2);
            hashMap.put("data", str3);
            hashMap.put("wvID", str);
            AiAppsController.getInstance().sendJSMessage(new AiAppsCommonMessage("live", hashMap));
        }
    }

    public static void y(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lType", "netstatus");
            hashMap.put("liveId", str2);
            hashMap.put("data", str3);
            hashMap.put("wvID", str);
            AiAppsController.getInstance().sendJSMessage(new AiAppsCommonMessage("live", hashMap));
        }
    }
}
