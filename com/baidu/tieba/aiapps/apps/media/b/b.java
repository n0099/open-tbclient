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
    private static final SparseArray<Integer> dfi = new SparseArray<>(32);

    static {
        dfi.put(10015, 2001);
        dfi.put(10013, 2002);
        dfi.put(904, 2003);
        dfi.put(10012, 2004);
        dfi.put(10004, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND));
        dfi.put(701, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_NAV_MODULE));
        dfi.put(10005, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE));
        dfi.put(10006, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE));
        dfi.put(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_BAIDUMAP_NULL, -2301);
        dfi.put(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_RESULT_NULL, 2101);
        dfi.put(923, 2103);
        dfi.put(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_RESULT_PARSER_FAILED, 2105);
        dfi.put(10010, 2106);
        dfi.put(10003, 2107);
        dfi.put(10011, 2108);
        dfi.put(10014, 3001);
        dfi.put(3002, 3002);
        dfi.put(3003, 3003);
        dfi.put(3004, 3005);
    }

    public static int mI(int i) {
        if (dfi.indexOfKey(i) < 0) {
            if (DEBUG) {
                Log.e("LiveStatusCodeAdapter", "Please check sStatusCodeMap already putted correct K,V pair. what: " + i);
            }
            return 100;
        }
        return dfi.get(i).intValue();
    }

    public static String mJ(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i);
            return jSONObject.toString();
        } catch (JSONException e) {
            return null;
        }
    }
}
