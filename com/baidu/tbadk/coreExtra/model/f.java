package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private static String dlk;
    private static Map<String, String> dll;
    private static boolean dlm;
    private static int dln;
    private static int dlo;
    private static boolean dlp;
    private static String dlq;
    private static int dlr;
    private static int dls;
    private static boolean dlt;
    private static Map<String, String> mDebugParamsMap;
    private static boolean dlg = false;
    private static boolean dlh = false;
    private static int dli = 8;
    private static int dlj = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            dlm = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, dlm);
            dln = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.aDr().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, dln);
            dlo = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.aDr().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, dlo);
            dlr = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.aDr().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, dlr);
            dls = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.aDr().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, dls);
            dlt = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, dlt);
            dlp = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, dlp);
            dlq = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(dlq)) {
                com.baidu.tbadk.core.sharedPref.b.aDr().putString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, dlq);
                uc(dlq);
            }
            dlk = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(dlk)) {
                com.baidu.tbadk.core.sharedPref.b.aDr().putString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, dlk);
                ud(dlk);
            }
        }
    }

    private static void uc(String str) {
        if (!StringUtils.isNull(str)) {
            if (mDebugParamsMap == null) {
                mDebugParamsMap = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                mDebugParamsMap.put("debug_avformat_open_input", jSONObject.optString("debug_avformat_open_input"));
                mDebugParamsMap.put("debug_dns_strategy", jSONObject.optString("debug_dns_strategy"));
                mDebugParamsMap.put("debug_url_null_strategy", jSONObject.optString("debug_url_null_strategy"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static void ud(String str) {
        if (!StringUtils.isNull(str)) {
            if (dll == null) {
                dll = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                dll.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                dll.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                dll.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                dll.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                dll.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean aJB() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, true) : dlm;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aDr().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, 0) : dln;
    }

    public static int aJC() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aDr().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, 5) : dlo;
    }

    public static boolean aJD() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, false) : dlp;
    }

    public static String aJE() {
        String string = com.baidu.tbadk.core.sharedPref.b.aDr().getString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        uc(string);
        return string;
    }

    public static Map<String, String> aJF() {
        if (!isInit) {
            aJE();
        }
        return mDebugParamsMap;
    }

    public static String aJG() {
        if (!isInit) {
            aJE();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int aJH() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aDr().getInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, 10000) : dlr;
    }

    public static int aJI() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aDr().getInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, 3000) : dls;
    }

    public static boolean aJJ() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, false) : dlt;
    }

    private static String aJK() {
        String string = com.baidu.tbadk.core.sharedPref.b.aDr().getString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        ud(string);
        return string;
    }

    public static boolean aJL() {
        if (!isInit) {
            aJK();
        }
        if (dll == null) {
            return false;
        }
        String str = dll.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        dlg = "1".equals(str);
        return dlg;
    }

    public static boolean aJM() {
        if (!isInit) {
            aJK();
        }
        if (dll == null) {
            return false;
        }
        String str = dll.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        dlh = "1".equals(str);
        return dlh;
    }

    public static int aJN() {
        if (!isInit) {
            aJK();
        }
        if (dll == null) {
            return 8;
        }
        String str = dll.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        dli = com.baidu.adp.lib.f.b.toInt(str, 8);
        return dli;
    }

    public static int aJO() {
        if (!isInit) {
            aJK();
        }
        if (dll == null) {
            return 16;
        }
        String str = dll.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        dlj = com.baidu.adp.lib.f.b.toInt(str, 16);
        return dlj;
    }

    public static boolean aJP() {
        if (!isInit) {
            aJK();
        }
        if (dll == null) {
            return cu("18:00", "01:00");
        }
        String str = dll.get("step_cache_rush_hour");
        if (StringUtils.isNull(str)) {
            return cu("18:00", "01:00");
        }
        try {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (String str2 : split) {
                String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split2.length == 2 && cu(split2[0], split2[1])) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean cu(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        try {
            return a(simpleDateFormat.parse(simpleDateFormat.format(new Date())), simpleDateFormat.parse(str), simpleDateFormat.parse(str2));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean a(Date date, Date date2, Date date3) {
        Date date4;
        Date date5 = null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime(date3);
        if (calendar.equals(calendar2) || calendar.equals(calendar3)) {
            return true;
        }
        if (!calendar2.after(calendar3)) {
            return calendar.after(calendar2) && calendar.before(calendar3);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        try {
            date4 = simpleDateFormat.parse("24:00");
            try {
                date5 = simpleDateFormat.parse("00:00");
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            date4 = null;
        }
        return a(date, date2, date4) || a(date, date5, date3);
    }
}
