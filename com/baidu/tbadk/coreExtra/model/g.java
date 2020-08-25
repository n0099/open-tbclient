package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g {
    private static String eDE;
    private static Map<String, String> eDF;
    private static boolean eDG;
    private static int eDH;
    private static int eDI;
    private static boolean eDJ;
    private static String eDK;
    private static Map<String, String> eDL;
    private static int eDM;
    private static int eDN;
    private static boolean eDO;
    private static boolean eDA = false;
    private static boolean eDB = false;
    private static int eDC = 8;
    private static int eDD = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            eDG = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, eDG);
            eDH = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.bik().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, eDH);
            eDI = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.bik().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, eDI);
            eDM = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.bik().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, eDM);
            eDN = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.bik().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, eDN);
            eDO = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, eDO);
            eDJ = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, eDJ);
            eDK = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(eDK)) {
                com.baidu.tbadk.core.sharedPref.b.bik().putString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, eDK);
                Bg(eDK);
            }
            eDE = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(eDE)) {
                com.baidu.tbadk.core.sharedPref.b.bik().putString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, eDE);
                Bh(eDE);
            }
        }
    }

    private static void Bg(String str) {
        if (!StringUtils.isNull(str)) {
            if (eDL == null) {
                eDL = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                eDL.put("debug_avformat_open_input", jSONObject.optString("debug_avformat_open_input"));
                eDL.put("debug_dns_strategy", jSONObject.optString("debug_dns_strategy"));
                eDL.put("debug_url_null_strategy", jSONObject.optString("debug_url_null_strategy"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static void Bh(String str) {
        if (!StringUtils.isNull(str)) {
            if (eDF == null) {
                eDF = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                eDF.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                eDF.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                eDF.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                eDF.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                eDF.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean bpo() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, true) : eDG;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, 0) : eDH;
    }

    public static int bpp() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, 5) : eDI;
    }

    public static boolean bpq() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, false) : eDJ;
    }
}
