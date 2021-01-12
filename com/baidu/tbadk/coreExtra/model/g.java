package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private static String frR;
    private static Map<String, String> frS;
    private static boolean frT;
    private static int frU;
    private static int frV;
    private static boolean frW;
    private static String frX;
    private static Map<String, String> frY;
    private static int frZ;
    private static int fsa;
    private static boolean fsb;
    private static boolean frN = false;
    private static boolean frO = false;
    private static int frP = 8;
    private static int frQ = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            frT = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, frT);
            frU = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.brx().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, frU);
            frV = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.brx().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, frV);
            frZ = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.brx().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, frZ);
            fsa = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.brx().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, fsa);
            fsb = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, fsb);
            frW = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, frW);
            frX = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(frX)) {
                com.baidu.tbadk.core.sharedPref.b.brx().putString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, frX);
                BP(frX);
            }
            frR = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(frR)) {
                com.baidu.tbadk.core.sharedPref.b.brx().putString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, frR);
                BQ(frR);
            }
        }
    }

    private static void BP(String str) {
        if (!StringUtils.isNull(str)) {
            if (frY == null) {
                frY = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                frY.put("debug_avformat_open_input", jSONObject.optString("debug_avformat_open_input"));
                frY.put("debug_dns_strategy", jSONObject.optString("debug_dns_strategy"));
                frY.put("debug_url_null_strategy", jSONObject.optString("debug_url_null_strategy"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static void BQ(String str) {
        if (!StringUtils.isNull(str)) {
            if (frS == null) {
                frS = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                frS.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                frS.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                frS.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                frS.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                frS.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean byD() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, true) : frT;
    }

    public static int byE() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.brx().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, 0) : frU;
    }

    public static int byF() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.brx().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, 5) : frV;
    }
}
