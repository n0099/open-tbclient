package com.baidu.tieba.aiapps.apps.media.b;

import android.util.Log;
import android.util.SparseArray;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.scheme.SapiScheme;
import com.baidu.sapi2.utils.SapiGIDEvent;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static final SparseArray<Integer> cVk = new SparseArray<>(32);

    static {
        cVk.put(10015, 2001);
        cVk.put(10013, Integer.valueOf((int) BaseActivity.EXTRA_PARAM_FROM_PASS_SDK_ENTER));
        cVk.put(904, 2003);
        cVk.put(10012, 2004);
        cVk.put(SapiGIDEvent.BUSINESS_GET_GID, 2006);
        cVk.put(701, 2007);
        cVk.put(SapiGIDEvent.BUSINESS_LOGOUT, 2008);
        cVk.put(SapiGIDEvent.SYSTEM_SCREEN_ON, 2009);
        cVk.put(10007, -2301);
        cVk.put(10008, 2101);
        cVk.put(923, 2103);
        cVk.put(10009, 2105);
        cVk.put(10010, 2106);
        cVk.put(10003, 2107);
        cVk.put(10011, 2108);
        cVk.put(10014, Integer.valueOf((int) SapiScheme.REQUEST_CODE_START_SC_APP_VERIFY));
        cVk.put(3002, 3002);
        cVk.put(3003, 3003);
        cVk.put(3004, 3005);
    }

    public static int lP(int i) {
        if (cVk.indexOfKey(i) < 0) {
            if (DEBUG) {
                Log.e("LiveStatusCodeAdapter", "Please check sStatusCodeMap already putted correct K,V pair. what: " + i);
            }
            return 100;
        }
        return cVk.get(i).intValue();
    }

    public static String lQ(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i);
            return jSONObject.toString();
        } catch (JSONException e) {
            return null;
        }
    }
}
