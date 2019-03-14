package com.baidu.tieba.aiapps.apps.media.video;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.w.e;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(String str, String str2, String str3, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.e("VideoStatusEventHelper", "dispatchNetStatusEvent failed slaveId: " + str2 + " ,videoId: " + str);
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", str2);
        hashMap.put("vtype", str3);
        try {
            jSONObject.putOpt("videoId", str);
            hashMap.put("data", jSONObject.toString());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (DEBUG) {
            Log.d("VideoStatusEventHelper", "Video dispatch Params : " + hashMap.toString());
        }
        e.Ec().a(new com.baidu.swan.apps.m.a.b("video", hashMap));
    }
}
