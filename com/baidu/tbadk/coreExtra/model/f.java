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
    private static int dpA;
    private static int dpB;
    private static boolean dpC;
    private static String dpt;
    private static Map<String, String> dpu;
    private static boolean dpv;
    private static int dpw;
    private static int dpx;
    private static boolean dpy;
    private static String dpz;
    private static Map<String, String> mDebugParamsMap;
    private static boolean dpp = false;
    private static boolean dpq = false;
    private static int dpr = 8;
    private static int dps = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            dpv = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, dpv);
            dpw = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.aFD().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, dpw);
            dpx = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.aFD().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, dpx);
            dpA = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.aFD().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, dpA);
            dpB = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.aFD().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, dpB);
            dpC = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, dpC);
            dpy = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, dpy);
            dpz = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(dpz)) {
                com.baidu.tbadk.core.sharedPref.b.aFD().putString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, dpz);
                ut(dpz);
            }
            dpt = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(dpt)) {
                com.baidu.tbadk.core.sharedPref.b.aFD().putString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, dpt);
                uu(dpt);
            }
        }
    }

    private static void ut(String str) {
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

    private static void uu(String str) {
        if (!StringUtils.isNull(str)) {
            if (dpu == null) {
                dpu = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                dpu.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                dpu.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                dpu.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                dpu.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                dpu.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean aLX() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, true) : dpv;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aFD().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, 0) : dpw;
    }

    public static int aLY() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aFD().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, 5) : dpx;
    }

    public static boolean aLZ() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, false) : dpy;
    }

    public static String aMa() {
        String string = com.baidu.tbadk.core.sharedPref.b.aFD().getString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        ut(string);
        return string;
    }

    public static Map<String, String> aMb() {
        if (!isInit) {
            aMa();
        }
        return mDebugParamsMap;
    }

    public static String aMc() {
        if (!isInit) {
            aMa();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int aMd() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aFD().getInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, 10000) : dpA;
    }

    public static int aMe() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aFD().getInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, 3000) : dpB;
    }

    public static boolean aMf() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, false) : dpC;
    }

    private static String aMg() {
        String string = com.baidu.tbadk.core.sharedPref.b.aFD().getString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        uu(string);
        return string;
    }

    public static boolean aMh() {
        if (!isInit) {
            aMg();
        }
        if (dpu == null) {
            return false;
        }
        String str = dpu.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        dpp = "1".equals(str);
        return dpp;
    }

    public static boolean aMi() {
        if (!isInit) {
            aMg();
        }
        if (dpu == null) {
            return false;
        }
        String str = dpu.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        dpq = "1".equals(str);
        return dpq;
    }

    public static int aMj() {
        if (!isInit) {
            aMg();
        }
        if (dpu == null) {
            return 8;
        }
        String str = dpu.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        dpr = com.baidu.adp.lib.f.b.toInt(str, 8);
        return dpr;
    }

    public static int aMk() {
        if (!isInit) {
            aMg();
        }
        if (dpu == null) {
            return 16;
        }
        String str = dpu.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        dps = com.baidu.adp.lib.f.b.toInt(str, 16);
        return dps;
    }

    public static boolean aMl() {
        if (!isInit) {
            aMg();
        }
        if (dpu == null) {
            return cD("18:00", "01:00");
        }
        String str = dpu.get("step_cache_rush_hour");
        if (StringUtils.isNull(str)) {
            return cD("18:00", "01:00");
        }
        try {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (String str2 : split) {
                String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split2.length == 2 && cD(split2[0], split2[1])) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean cD(String str, String str2) {
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
