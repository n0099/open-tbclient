package com.baidu.tieba.aiapps.apps.media.video;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.apps.console.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
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
        c.d("VideoStatusEventHelper", "Video dispatch Params : " + jSONObject2.toString());
        com.baidu.swan.apps.view.b.b.a.a(str2, str, "video", str3, jSONObject2);
    }

    public static void a(final String str, final String str2, final boolean z, VideoContainerManager videoContainerManager) {
        final SwanAppComponentContainerView aXF = videoContainerManager.aXF();
        aXF.post(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.video.b.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    int V = af.V(SwanAppComponentContainerView.this.getWidth());
                    int V2 = af.V(SwanAppComponentContainerView.this.getHeight());
                    jSONObject.putOpt("fullscreen", z ? "1" : "0");
                    jSONObject.putOpt("width", String.valueOf(V));
                    jSONObject.putOpt("height", String.valueOf(V2));
                } catch (JSONException e) {
                    if (b.DEBUG) {
                        e.printStackTrace();
                    }
                }
                b.a(str, str2, "fullscreenchange", jSONObject);
            }
        });
    }
}
