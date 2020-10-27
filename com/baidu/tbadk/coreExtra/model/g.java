package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private static int faA;
    private static boolean faB;
    private static String far;
    private static Map<String, String> fas;
    private static boolean fat;
    private static int fau;
    private static int fav;
    private static boolean faw;
    private static String fax;
    private static Map<String, String> fay;
    private static int faz;
    private static boolean fan = false;
    private static boolean fao = false;
    private static int fap = 8;
    private static int faq = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            fat = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, fat);
            fau = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.bnH().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, fau);
            fav = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.bnH().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, fav);
            faz = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.bnH().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, faz);
            faA = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.bnH().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, faA);
            faB = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, faB);
            faw = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, faw);
            fax = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(fax)) {
                com.baidu.tbadk.core.sharedPref.b.bnH().putString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, fax);
                CI(fax);
            }
            far = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(far)) {
                com.baidu.tbadk.core.sharedPref.b.bnH().putString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, far);
                CJ(far);
            }
        }
    }

    private static void CI(String str) {
        if (!StringUtils.isNull(str)) {
            if (fay == null) {
                fay = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                fay.put("debug_avformat_open_input", jSONObject.optString("debug_avformat_open_input"));
                fay.put("debug_dns_strategy", jSONObject.optString("debug_dns_strategy"));
                fay.put("debug_url_null_strategy", jSONObject.optString("debug_url_null_strategy"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static void CJ(String str) {
        if (!StringUtils.isNull(str)) {
            if (fas == null) {
                fas = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                fas.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                fas.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                fas.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                fas.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                fas.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean buM() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, true) : fat;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bnH().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, 0) : fau;
    }

    public static int buN() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bnH().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, 5) : fav;
    }

    public static boolean buO() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, false) : faw;
    }
}
