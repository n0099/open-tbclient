package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private static String fgi;
    private static Map<String, String> fgj;
    private static boolean fgk;
    private static int fgl;
    private static int fgm;
    private static boolean fgn;
    private static String fgo;
    private static Map<String, String> fgp;
    private static int fgq;
    private static int fgr;
    private static boolean fgs;
    private static boolean fge = false;
    private static boolean fgf = false;
    private static int fgg = 8;
    private static int fgh = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            fgk = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, fgk);
            fgl = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.bqh().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, fgl);
            fgm = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.bqh().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, fgm);
            fgq = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.bqh().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, fgq);
            fgr = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.bqh().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, fgr);
            fgs = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, fgs);
            fgn = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, fgn);
            fgo = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(fgo)) {
                com.baidu.tbadk.core.sharedPref.b.bqh().putString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, fgo);
                CW(fgo);
            }
            fgi = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(fgi)) {
                com.baidu.tbadk.core.sharedPref.b.bqh().putString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, fgi);
                CX(fgi);
            }
        }
    }

    private static void CW(String str) {
        if (!StringUtils.isNull(str)) {
            if (fgp == null) {
                fgp = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                fgp.put("debug_avformat_open_input", jSONObject.optString("debug_avformat_open_input"));
                fgp.put("debug_dns_strategy", jSONObject.optString("debug_dns_strategy"));
                fgp.put("debug_url_null_strategy", jSONObject.optString("debug_url_null_strategy"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static void CX(String str) {
        if (!StringUtils.isNull(str)) {
            if (fgj == null) {
                fgj = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                fgj.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                fgj.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                fgj.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                fgj.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                fgj.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean bxm() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, true) : fgk;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bqh().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, 0) : fgl;
    }

    public static int bxn() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bqh().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, 5) : fgm;
    }

    public static boolean bxo() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, false) : fgn;
    }
}
