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
    private static boolean dpB;
    private static String dps;
    private static Map<String, String> dpt;
    private static boolean dpu;
    private static int dpv;
    private static int dpw;
    private static boolean dpx;
    private static String dpy;
    private static int dpz;
    private static Map<String, String> mDebugParamsMap;
    private static boolean dpo = false;
    private static boolean dpp = false;
    private static int dpq = 8;
    private static int dpr = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            dpu = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, dpu);
            dpv = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.aFB().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, dpv);
            dpw = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.aFB().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, dpw);
            dpz = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.aFB().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, dpz);
            dpA = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.aFB().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, dpA);
            dpB = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, dpB);
            dpx = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, dpx);
            dpy = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(dpy)) {
                com.baidu.tbadk.core.sharedPref.b.aFB().putString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, dpy);
                ut(dpy);
            }
            dps = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(dps)) {
                com.baidu.tbadk.core.sharedPref.b.aFB().putString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, dps);
                uu(dps);
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
            if (dpt == null) {
                dpt = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                dpt.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                dpt.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                dpt.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                dpt.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                dpt.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean aLV() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, true) : dpu;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aFB().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, 0) : dpv;
    }

    public static int aLW() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aFB().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, 5) : dpw;
    }

    public static boolean aLX() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, false) : dpx;
    }

    public static String aLY() {
        String string = com.baidu.tbadk.core.sharedPref.b.aFB().getString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        ut(string);
        return string;
    }

    public static Map<String, String> aLZ() {
        if (!isInit) {
            aLY();
        }
        return mDebugParamsMap;
    }

    public static String aMa() {
        if (!isInit) {
            aLY();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int aMb() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aFB().getInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, 10000) : dpz;
    }

    public static int aMc() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aFB().getInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, 3000) : dpA;
    }

    public static boolean aMd() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, false) : dpB;
    }

    private static String aMe() {
        String string = com.baidu.tbadk.core.sharedPref.b.aFB().getString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        uu(string);
        return string;
    }

    public static boolean aMf() {
        if (!isInit) {
            aMe();
        }
        if (dpt == null) {
            return false;
        }
        String str = dpt.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        dpo = "1".equals(str);
        return dpo;
    }

    public static boolean aMg() {
        if (!isInit) {
            aMe();
        }
        if (dpt == null) {
            return false;
        }
        String str = dpt.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        dpp = "1".equals(str);
        return dpp;
    }

    public static int aMh() {
        if (!isInit) {
            aMe();
        }
        if (dpt == null) {
            return 8;
        }
        String str = dpt.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        dpq = com.baidu.adp.lib.f.b.toInt(str, 8);
        return dpq;
    }

    public static int aMi() {
        if (!isInit) {
            aMe();
        }
        if (dpt == null) {
            return 16;
        }
        String str = dpt.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        dpr = com.baidu.adp.lib.f.b.toInt(str, 16);
        return dpr;
    }

    public static boolean aMj() {
        if (!isInit) {
            aMe();
        }
        if (dpt == null) {
            return cD("18:00", "01:00");
        }
        String str = dpt.get("step_cache_rush_hour");
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
