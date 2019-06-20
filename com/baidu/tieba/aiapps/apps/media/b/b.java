package com.baidu.tieba.aiapps.apps.media.b;

import android.util.Log;
import android.util.SparseArray;
import com.baidu.mapapi.UIMsg;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final SparseArray<Integer> ddH = new SparseArray<>(32);

    static {
        ddH.put(10015, 2001);
        ddH.put(10013, 2002);
        ddH.put(904, 2003);
        ddH.put(10012, 2004);
        ddH.put(10004, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND));
        ddH.put(701, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_NAV_MODULE));
        ddH.put(10005, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE));
        ddH.put(10006, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE));
        ddH.put(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_BAIDUMAP_NULL, -2301);
        ddH.put(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_RESULT_NULL, 2101);
        ddH.put(923, 2103);
        ddH.put(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_RESULT_PARSER_FAILED, 2105);
        ddH.put(10010, 2106);
        ddH.put(10003, 2107);
        ddH.put(10011, 2108);
        ddH.put(10014, 3001);
        ddH.put(3002, 3002);
        ddH.put(3003, 3003);
        ddH.put(3004, 3005);
    }

    public static int mB(int i) {
        if (ddH.indexOfKey(i) < 0) {
            if (DEBUG) {
                Log.e("LiveStatusCodeAdapter", "Please check sStatusCodeMap already putted correct K,V pair. what: " + i);
            }
            return 100;
        }
        return ddH.get(i).intValue();
    }

    public static String mC(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i);
            return jSONObject.toString();
        } catch (JSONException e) {
            return null;
        }
    }
}
