package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private static boolean ffA;
    private static String ffq;
    private static Map<String, String> ffr;
    private static boolean ffs;
    private static int fft;
    private static int ffu;
    private static boolean ffv;
    private static String ffw;
    private static Map<String, String> ffx;
    private static int ffy;
    private static int ffz;
    private static boolean ffm = false;
    private static boolean ffn = false;
    private static int ffo = 8;
    private static int ffp = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            ffs = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, ffs);
            fft = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.bpu().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, fft);
            ffu = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.bpu().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, ffu);
            ffy = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.bpu().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, ffy);
            ffz = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.bpu().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, ffz);
            ffA = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, ffA);
            ffv = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, ffv);
            ffw = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(ffw)) {
                com.baidu.tbadk.core.sharedPref.b.bpu().putString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, ffw);
                Cv(ffw);
            }
            ffq = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(ffq)) {
                com.baidu.tbadk.core.sharedPref.b.bpu().putString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, ffq);
                Cw(ffq);
            }
        }
    }

    private static void Cv(String str) {
        if (!StringUtils.isNull(str)) {
            if (ffx == null) {
                ffx = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                ffx.put("debug_avformat_open_input", jSONObject.optString("debug_avformat_open_input"));
                ffx.put("debug_dns_strategy", jSONObject.optString("debug_dns_strategy"));
                ffx.put("debug_url_null_strategy", jSONObject.optString("debug_url_null_strategy"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static void Cw(String str) {
        if (!StringUtils.isNull(str)) {
            if (ffr == null) {
                ffr = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                ffr.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                ffr.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                ffr.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                ffr.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                ffr.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean bwC() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, true) : ffs;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bpu().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, 0) : fft;
    }

    public static int bwD() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bpu().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, 5) : ffu;
    }

    public static boolean bwE() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, false) : ffv;
    }
}
