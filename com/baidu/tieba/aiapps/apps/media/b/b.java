package com.baidu.tieba.aiapps.apps.media.b;

import android.util.SparseArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final SparseArray<Integer> eEx = new SparseArray<>(32);
    private static final SparseArray<String> eEy = new SparseArray<>();

    static {
        eEy.put(-2022, "MEDIA_ERR_NETWORK");
        eEy.put(-111, "MEDIA_ERR_NETWORK");
        eEy.put(3005, "MEDIA_ERR_NETWORK");
    }

    private static JSONObject w(String str, Object obj) {
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

    public static JSONObject oF(int i) {
        return w("errMsg", oG(i));
    }

    private static String oG(int i) {
        return eEy.get(i, "MEDIA_ERR_SRC_NOT_SUPPORTED");
    }
}
