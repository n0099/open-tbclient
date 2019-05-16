package com.baidu.tieba.aiapps.apps.media.video;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.view.container.SwanAppNAViewContainer;
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
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("wvID", str2);
            jSONObject2.put("vtype", str3);
            jSONObject.putOpt("videoId", str);
            jSONObject2.put("data", jSONObject.toString());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.console.c.d("VideoStatusEventHelper", "Video dispatch Params : " + jSONObject2.toString());
        com.baidu.swan.apps.view.container.c.d.a(str2, str, "video", str3, jSONObject2);
    }

    public static void a(final String str, final String str2, final boolean z, b bVar) {
        final SwanAppNAViewContainer aFd = bVar.aFd();
        aFd.post(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.d.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    int af = z.af(SwanAppNAViewContainer.this.getWidth());
                    int af2 = z.af(SwanAppNAViewContainer.this.getHeight());
                    jSONObject.putOpt("fullscreen", z ? "1" : "0");
                    jSONObject.putOpt("width", String.valueOf(af));
                    jSONObject.putOpt("height", String.valueOf(af2));
                } catch (JSONException e) {
                    if (d.DEBUG) {
                        e.printStackTrace();
                    }
                }
                d.a(str, str2, "fullscreenchange", jSONObject);
            }
        });
    }
}
