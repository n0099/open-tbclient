package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private static String fmQ;
    private static Map<String, String> fmR;
    private static boolean fmS;
    private static int fmT;
    private static int fmU;
    private static boolean fmV;
    private static String fmW;
    private static Map<String, String> fmX;
    private static int fmY;
    private static int fmZ;
    private static boolean fna;
    private static boolean fmM = false;
    private static boolean fmN = false;
    private static int fmO = 8;
    private static int fmP = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            fmS = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, fmS);
            fmT = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.bsO().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, fmT);
            fmU = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.bsO().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, fmU);
            fmY = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.bsO().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, fmY);
            fmZ = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.bsO().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, fmZ);
            fna = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, fna);
            fmV = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, fmV);
            fmW = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(fmW)) {
                com.baidu.tbadk.core.sharedPref.b.bsO().putString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, fmW);
                Dd(fmW);
            }
            fmQ = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(fmQ)) {
                com.baidu.tbadk.core.sharedPref.b.bsO().putString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, fmQ);
                De(fmQ);
            }
        }
    }

    private static void Dd(String str) {
        if (!StringUtils.isNull(str)) {
            if (fmX == null) {
                fmX = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                fmX.put("debug_avformat_open_input", jSONObject.optString("debug_avformat_open_input"));
                fmX.put("debug_dns_strategy", jSONObject.optString("debug_dns_strategy"));
                fmX.put("debug_url_null_strategy", jSONObject.optString("debug_url_null_strategy"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static void De(String str) {
        if (!StringUtils.isNull(str)) {
            if (fmR == null) {
                fmR = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                fmR.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                fmR.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                fmR.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                fmR.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                fmR.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean bAc() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, true) : fmS;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bsO().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, 0) : fmT;
    }

    public static int bAd() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bsO().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, 5) : fmU;
    }

    public static boolean bAe() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, false) : fmV;
    }
}
