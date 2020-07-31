package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private static String eth;
    private static Map<String, String> eti;
    private static boolean etj;
    private static int etk;
    private static int etl;
    private static boolean etm;
    private static String etn;
    private static Map<String, String> eto;
    private static int etp;
    private static int etq;
    private static boolean etr;
    private static boolean etd = false;
    private static boolean ete = false;
    private static int etf = 8;
    private static int etg = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            etj = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, etj);
            etk = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.aZP().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, etk);
            etl = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.aZP().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, etl);
            etp = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.aZP().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, etp);
            etq = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.aZP().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, etq);
            etr = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, etr);
            etm = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, etm);
            etn = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(etn)) {
                com.baidu.tbadk.core.sharedPref.b.aZP().putString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, etn);
                yQ(etn);
            }
            eth = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(eth)) {
                com.baidu.tbadk.core.sharedPref.b.aZP().putString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, eth);
                yR(eth);
            }
        }
    }

    private static void yQ(String str) {
        if (!StringUtils.isNull(str)) {
            if (eto == null) {
                eto = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                eto.put("debug_avformat_open_input", jSONObject.optString("debug_avformat_open_input"));
                eto.put("debug_dns_strategy", jSONObject.optString("debug_dns_strategy"));
                eto.put("debug_url_null_strategy", jSONObject.optString("debug_url_null_strategy"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static void yR(String str) {
        if (!StringUtils.isNull(str)) {
            if (eti == null) {
                eti = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                eti.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                eti.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                eti.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                eti.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                eti.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean bgD() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, true) : etj;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aZP().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, 0) : etk;
    }

    public static int bgE() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aZP().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, 5) : etl;
    }

    public static boolean bgF() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, false) : etm;
    }
}
