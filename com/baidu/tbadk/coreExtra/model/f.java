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
    private static String dPM;
    private static Map<String, String> dPN;
    private static boolean dPO;
    private static int dPP;
    private static int dPQ;
    private static boolean dPR;
    private static String dPS;
    private static int dPT;
    private static int dPU;
    private static boolean dPV;
    private static Map<String, String> mDebugParamsMap;
    private static boolean dPI = false;
    private static boolean dPJ = false;
    private static int dPK = 8;
    private static int dPL = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            dPO = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, dPO);
            dPP = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.aNV().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, dPP);
            dPQ = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.aNV().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, dPQ);
            dPT = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.aNV().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, dPT);
            dPU = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.aNV().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, dPU);
            dPV = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, dPV);
            dPR = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, dPR);
            dPS = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(dPS)) {
                com.baidu.tbadk.core.sharedPref.b.aNV().putString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, dPS);
                vI(dPS);
            }
            dPM = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(dPM)) {
                com.baidu.tbadk.core.sharedPref.b.aNV().putString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, dPM);
                vJ(dPM);
            }
        }
    }

    private static void vI(String str) {
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

    private static void vJ(String str) {
        if (!StringUtils.isNull(str)) {
            if (dPN == null) {
                dPN = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                dPN.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                dPN.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                dPN.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                dPN.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                dPN.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean aUz() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, true) : dPO;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aNV().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, 0) : dPP;
    }

    public static int aUA() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aNV().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, 5) : dPQ;
    }

    public static boolean aUB() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, false) : dPR;
    }

    public static String aUC() {
        String string = com.baidu.tbadk.core.sharedPref.b.aNV().getString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        vI(string);
        return string;
    }

    public static Map<String, String> aUD() {
        if (!isInit) {
            aUC();
        }
        return mDebugParamsMap;
    }

    public static String aUE() {
        if (!isInit) {
            aUC();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int aUF() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aNV().getInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, 10000) : dPT;
    }

    public static int aUG() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aNV().getInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, 3000) : dPU;
    }

    public static boolean aUH() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, false) : dPV;
    }

    private static String aUI() {
        String string = com.baidu.tbadk.core.sharedPref.b.aNV().getString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        vJ(string);
        return string;
    }

    public static boolean aUJ() {
        if (!isInit) {
            aUI();
        }
        if (dPN == null) {
            return false;
        }
        String str = dPN.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        dPI = "1".equals(str);
        return dPI;
    }

    public static boolean aUK() {
        if (!isInit) {
            aUI();
        }
        if (dPN == null) {
            return false;
        }
        String str = dPN.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        dPJ = "1".equals(str);
        return dPJ;
    }

    public static int aUL() {
        if (!isInit) {
            aUI();
        }
        if (dPN == null) {
            return 8;
        }
        String str = dPN.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        dPK = com.baidu.adp.lib.f.b.toInt(str, 8);
        return dPK;
    }

    public static int aUM() {
        if (!isInit) {
            aUI();
        }
        if (dPN == null) {
            return 16;
        }
        String str = dPN.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        dPL = com.baidu.adp.lib.f.b.toInt(str, 16);
        return dPL;
    }

    public static boolean aUN() {
        if (!isInit) {
            aUI();
        }
        if (dPN == null) {
            return cN("18:00", "01:00");
        }
        String str = dPN.get("step_cache_rush_hour");
        if (StringUtils.isNull(str)) {
            return cN("18:00", "01:00");
        }
        try {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (String str2 : split) {
                String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split2.length == 2 && cN(split2[0], split2[1])) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean cN(String str, String str2) {
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
