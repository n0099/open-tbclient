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
    private static String emU;
    private static Map<String, String> emV;
    private static boolean emW;
    private static int emX;
    private static int emY;
    private static boolean emZ;
    private static String ena;
    private static int enb;
    private static int enc;
    private static boolean ene;
    private static Map<String, String> mDebugParamsMap;
    private static boolean emQ = false;
    private static boolean emR = false;
    private static int emS = 8;
    private static int emT = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            emW = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, emW);
            emX = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.aVP().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, emX);
            emY = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.aVP().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, emY);
            enb = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.aVP().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, enb);
            enc = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.aVP().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, enc);
            ene = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, ene);
            emZ = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, emZ);
            ena = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(ena)) {
                com.baidu.tbadk.core.sharedPref.b.aVP().putString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, ena);
                xK(ena);
            }
            emU = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(emU)) {
                com.baidu.tbadk.core.sharedPref.b.aVP().putString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, emU);
                xL(emU);
            }
        }
    }

    private static void xK(String str) {
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

    private static void xL(String str) {
        if (!StringUtils.isNull(str)) {
            if (emV == null) {
                emV = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                emV.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                emV.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                emV.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                emV.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                emV.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean bcK() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, true) : emW;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aVP().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, 0) : emX;
    }

    public static int bcL() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aVP().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, 5) : emY;
    }

    public static boolean bcM() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, false) : emZ;
    }

    public static String bcN() {
        String string = com.baidu.tbadk.core.sharedPref.b.aVP().getString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        xK(string);
        return string;
    }

    public static Map<String, String> bcO() {
        if (!isInit) {
            bcN();
        }
        return mDebugParamsMap;
    }

    public static String bcP() {
        if (!isInit) {
            bcN();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int bcQ() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aVP().getInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, 10000) : enb;
    }

    public static int bcR() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aVP().getInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, 3000) : enc;
    }

    public static boolean bcS() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, false) : ene;
    }

    private static String bcT() {
        String string = com.baidu.tbadk.core.sharedPref.b.aVP().getString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        xL(string);
        return string;
    }

    public static boolean bcU() {
        if (!isInit) {
            bcT();
        }
        if (emV == null) {
            return false;
        }
        String str = emV.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        emQ = "1".equals(str);
        return emQ;
    }

    public static boolean bcV() {
        if (!isInit) {
            bcT();
        }
        if (emV == null) {
            return false;
        }
        String str = emV.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        emR = "1".equals(str);
        return emR;
    }

    public static int bcW() {
        if (!isInit) {
            bcT();
        }
        if (emV == null) {
            return 8;
        }
        String str = emV.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        emS = com.baidu.adp.lib.f.b.toInt(str, 8);
        return emS;
    }

    public static int bcX() {
        if (!isInit) {
            bcT();
        }
        if (emV == null) {
            return 16;
        }
        String str = emV.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        emT = com.baidu.adp.lib.f.b.toInt(str, 16);
        return emT;
    }

    public static boolean bcY() {
        if (!isInit) {
            bcT();
        }
        if (emV == null) {
            return dp("18:00", "01:00");
        }
        String str = emV.get("step_cache_rush_hour");
        if (StringUtils.isNull(str)) {
            return dp("18:00", "01:00");
        }
        try {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (String str2 : split) {
                String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split2.length == 2 && dp(split2[0], split2[1])) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean dp(String str, String str2) {
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
