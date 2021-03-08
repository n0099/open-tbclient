package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private static String fvI;
    private static Map<String, String> fvJ;
    private static boolean fvK;
    private static int fvL;
    private static int fvM;
    private static boolean fvN;
    private static String fvO;
    private static Map<String, String> fvP;
    private static int fvQ;
    private static int fvR;
    private static boolean fvS;
    private static boolean fvE = false;
    private static boolean fvF = false;
    private static int fvG = 8;
    private static int fvH = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            fvK = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, fvK);
            fvL = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.brR().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, fvL);
            fvM = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.brR().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, fvM);
            fvQ = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.brR().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, fvQ);
            fvR = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.brR().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, fvR);
            fvS = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, fvS);
            fvN = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, fvN);
            fvO = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(fvO)) {
                com.baidu.tbadk.core.sharedPref.b.brR().putString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, fvO);
                Cn(fvO);
            }
            fvI = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(fvI)) {
                com.baidu.tbadk.core.sharedPref.b.brR().putString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, fvI);
                Co(fvI);
            }
        }
    }

    private static void Cn(String str) {
        if (!StringUtils.isNull(str)) {
            if (fvP == null) {
                fvP = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                fvP.put("debug_avformat_open_input", jSONObject.optString("debug_avformat_open_input"));
                fvP.put("debug_dns_strategy", jSONObject.optString("debug_dns_strategy"));
                fvP.put("debug_url_null_strategy", jSONObject.optString("debug_url_null_strategy"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static void Co(String str) {
        if (!StringUtils.isNull(str)) {
            if (fvJ == null) {
                fvJ = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                fvJ.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                fvJ.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                fvJ.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                fvJ.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                fvJ.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean byY() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, true) : fvK;
    }

    public static int byZ() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.brR().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, 0) : fvL;
    }

    public static int bza() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.brR().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, 5) : fvM;
    }
}
