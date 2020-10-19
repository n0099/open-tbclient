package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private static String eRV;
    private static Map<String, String> eRW;
    private static boolean eRX;
    private static int eRY;
    private static int eRZ;
    private static boolean eSa;
    private static String eSb;
    private static Map<String, String> eSc;
    private static int eSd;
    private static int eSe;
    private static boolean eSf;
    private static boolean eRR = false;
    private static boolean eRS = false;
    private static int eRT = 8;
    private static int eRU = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            eRX = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, eRX);
            eRY = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.blO().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, eRY);
            eRZ = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.blO().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, eRZ);
            eSd = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.blO().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, eSd);
            eSe = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.blO().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, eSe);
            eSf = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, eSf);
            eSa = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, eSa);
            eSb = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(eSb)) {
                com.baidu.tbadk.core.sharedPref.b.blO().putString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, eSb);
                Cp(eSb);
            }
            eRV = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(eRV)) {
                com.baidu.tbadk.core.sharedPref.b.blO().putString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, eRV);
                Cq(eRV);
            }
        }
    }

    private static void Cp(String str) {
        if (!StringUtils.isNull(str)) {
            if (eSc == null) {
                eSc = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                eSc.put("debug_avformat_open_input", jSONObject.optString("debug_avformat_open_input"));
                eSc.put("debug_dns_strategy", jSONObject.optString("debug_dns_strategy"));
                eSc.put("debug_url_null_strategy", jSONObject.optString("debug_url_null_strategy"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static void Cq(String str) {
        if (!StringUtils.isNull(str)) {
            if (eRW == null) {
                eRW = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                eRW.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                eRW.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                eRW.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                eRW.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                eRW.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean bsT() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, true) : eRX;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.blO().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, 0) : eRY;
    }

    public static int bsU() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.blO().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, 5) : eRZ;
    }

    public static boolean bsV() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, false) : eSa;
    }
}
