package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private static String fuj;
    private static Map<String, String> fuk;
    private static boolean ful;
    private static int fum;
    private static int fun;
    private static boolean fuo;
    private static String fup;
    private static Map<String, String> fuq;
    private static int fur;
    private static int fus;
    private static boolean fut;
    private static boolean fuf = false;
    private static boolean fug = false;
    private static int fuh = 8;
    private static int fui = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            ful = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, ful);
            fum = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.brQ().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, fum);
            fun = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.brQ().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, fun);
            fur = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.brQ().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, fur);
            fus = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.brQ().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, fus);
            fut = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, fut);
            fuo = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, fuo);
            fup = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(fup)) {
                com.baidu.tbadk.core.sharedPref.b.brQ().putString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, fup);
                Cg(fup);
            }
            fuj = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(fuj)) {
                com.baidu.tbadk.core.sharedPref.b.brQ().putString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, fuj);
                Ch(fuj);
            }
        }
    }

    private static void Cg(String str) {
        if (!StringUtils.isNull(str)) {
            if (fuq == null) {
                fuq = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                fuq.put("debug_avformat_open_input", jSONObject.optString("debug_avformat_open_input"));
                fuq.put("debug_dns_strategy", jSONObject.optString("debug_dns_strategy"));
                fuq.put("debug_url_null_strategy", jSONObject.optString("debug_url_null_strategy"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static void Ch(String str) {
        if (!StringUtils.isNull(str)) {
            if (fuk == null) {
                fuk = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                fuk.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                fuk.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                fuk.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                fuk.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                fuk.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean byV() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, true) : ful;
    }

    public static int byW() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.brQ().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, 0) : fum;
    }

    public static int byX() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.brQ().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, 5) : fun;
    }
}
