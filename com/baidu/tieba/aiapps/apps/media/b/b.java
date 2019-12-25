package com.baidu.tieba.aiapps.apps.media.b;

import android.util.SparseArray;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final SparseArray<Integer> dZL = new SparseArray<>(32);
    private static final SparseArray<String> dZM = new SparseArray<>();

    static {
        dZM.put(-2022, "MEDIA_ERR_NETWORK");
        dZM.put(CyberPlayerManager.MEDIA_ERROR_OPEN_VIDEO_FAIL, "MEDIA_ERR_NETWORK");
        dZM.put(3005, "MEDIA_ERR_NETWORK");
    }

    private static JSONObject r(String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (obj instanceof Integer) {
                jSONObject.put(str, ((Integer) obj).intValue());
            } else if (obj instanceof String) {
                jSONObject.put(str, obj);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public static JSONObject nZ(int i) {
        return r("errMsg", oa(i));
    }

    private static String oa(int i) {
        return dZM.get(i, "MEDIA_ERR_SRC_NOT_SUPPORTED");
    }
}
