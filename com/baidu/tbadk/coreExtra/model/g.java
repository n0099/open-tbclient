package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private static String eDI;
    private static Map<String, String> eDJ;
    private static boolean eDK;
    private static int eDL;
    private static int eDM;
    private static boolean eDN;
    private static String eDO;
    private static Map<String, String> eDP;
    private static int eDQ;
    private static int eDR;
    private static boolean eDS;
    private static boolean eDE = false;
    private static boolean eDF = false;
    private static int eDG = 8;
    private static int eDH = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            eDK = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, eDK);
            eDL = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.bik().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, eDL);
            eDM = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.bik().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, eDM);
            eDQ = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.bik().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, eDQ);
            eDR = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.bik().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, eDR);
            eDS = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, eDS);
            eDN = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, eDN);
            eDO = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(eDO)) {
                com.baidu.tbadk.core.sharedPref.b.bik().putString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, eDO);
                Bh(eDO);
            }
            eDI = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(eDI)) {
                com.baidu.tbadk.core.sharedPref.b.bik().putString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, eDI);
                Bi(eDI);
            }
        }
    }

    private static void Bh(String str) {
        if (!StringUtils.isNull(str)) {
            if (eDP == null) {
                eDP = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                eDP.put("debug_avformat_open_input", jSONObject.optString("debug_avformat_open_input"));
                eDP.put("debug_dns_strategy", jSONObject.optString("debug_dns_strategy"));
                eDP.put("debug_url_null_strategy", jSONObject.optString("debug_url_null_strategy"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static void Bi(String str) {
        if (!StringUtils.isNull(str)) {
            if (eDJ == null) {
                eDJ = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                eDJ.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                eDJ.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                eDJ.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                eDJ.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                eDJ.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean bpp() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, true) : eDK;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, 0) : eDL;
    }

    public static int bpq() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, 5) : eDM;
    }

    public static boolean bpr() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, false) : eDN;
    }
}
