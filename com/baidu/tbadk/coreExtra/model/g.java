package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private static String eFO;
    private static Map<String, String> eFP;
    private static boolean eFQ;
    private static int eFR;
    private static int eFS;
    private static boolean eFT;
    private static String eFU;
    private static Map<String, String> eFV;
    private static int eFW;
    private static int eFX;
    private static boolean eFY;
    private static boolean eFK = false;
    private static boolean eFL = false;
    private static int eFM = 8;
    private static int eFN = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            eFQ = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, eFQ);
            eFR = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.bjf().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, eFR);
            eFS = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.bjf().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, eFS);
            eFW = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.bjf().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, eFW);
            eFX = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.bjf().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, eFX);
            eFY = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, eFY);
            eFT = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, eFT);
            eFU = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(eFU)) {
                com.baidu.tbadk.core.sharedPref.b.bjf().putString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, eFU);
                BD(eFU);
            }
            eFO = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(eFO)) {
                com.baidu.tbadk.core.sharedPref.b.bjf().putString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, eFO);
                BE(eFO);
            }
        }
    }

    private static void BD(String str) {
        if (!StringUtils.isNull(str)) {
            if (eFV == null) {
                eFV = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                eFV.put("debug_avformat_open_input", jSONObject.optString("debug_avformat_open_input"));
                eFV.put("debug_dns_strategy", jSONObject.optString("debug_dns_strategy"));
                eFV.put("debug_url_null_strategy", jSONObject.optString("debug_url_null_strategy"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static void BE(String str) {
        if (!StringUtils.isNull(str)) {
            if (eFP == null) {
                eFP = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                eFP.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                eFP.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                eFP.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                eFP.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                eFP.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean bqj() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, true) : eFQ;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bjf().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, 0) : eFR;
    }

    public static int bqk() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bjf().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, 5) : eFS;
    }

    public static boolean bql() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, false) : eFT;
    }
}
