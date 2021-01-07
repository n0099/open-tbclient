package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private static String fwA;
    private static Map<String, String> fwB;
    private static boolean fwC;
    private static int fwD;
    private static int fwE;
    private static boolean fwF;
    private static String fwG;
    private static Map<String, String> fwH;
    private static int fwI;
    private static int fwJ;
    private static boolean fwK;
    private static boolean fww = false;
    private static boolean fwx = false;
    private static int fwy = 8;
    private static int fwz = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            fwC = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, fwC);
            fwD = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.bvr().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, fwD);
            fwE = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.bvr().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, fwE);
            fwI = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.bvr().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, fwI);
            fwJ = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.bvr().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, fwJ);
            fwK = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, fwK);
            fwF = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, fwF);
            fwG = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(fwG)) {
                com.baidu.tbadk.core.sharedPref.b.bvr().putString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, fwG);
                Da(fwG);
            }
            fwA = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(fwA)) {
                com.baidu.tbadk.core.sharedPref.b.bvr().putString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, fwA);
                Db(fwA);
            }
        }
    }

    private static void Da(String str) {
        if (!StringUtils.isNull(str)) {
            if (fwH == null) {
                fwH = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                fwH.put("debug_avformat_open_input", jSONObject.optString("debug_avformat_open_input"));
                fwH.put("debug_dns_strategy", jSONObject.optString("debug_dns_strategy"));
                fwH.put("debug_url_null_strategy", jSONObject.optString("debug_url_null_strategy"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static void Db(String str) {
        if (!StringUtils.isNull(str)) {
            if (fwB == null) {
                fwB = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                fwB.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                fwB.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                fwB.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                fwB.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                fwB.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean bCx() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, true) : fwC;
    }

    public static int bCy() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bvr().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, 0) : fwD;
    }

    public static int bCz() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bvr().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, 5) : fwE;
    }
}
