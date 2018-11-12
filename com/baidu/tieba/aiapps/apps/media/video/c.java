package com.baidu.tieba.aiapps.apps.media.video;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsCommonMessage;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public static void a(String str, String str2, String str3, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("wvID", str2);
            hashMap.put("vtype", str3);
            try {
                jSONObject.putOpt("videoId", str);
                hashMap.put("data", jSONObject.toString());
            } catch (JSONException e) {
            }
            AiAppsController.getInstance().sendJSMessage(new AiAppsCommonMessage("video", hashMap));
        }
    }
}
