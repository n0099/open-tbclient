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
    private static String dpG;
    private static Map<String, String> dpH;
    private static boolean dpI;
    private static int dpJ;
    private static int dpK;
    private static boolean dpL;
    private static String dpM;
    private static int dpN;
    private static int dpO;
    private static boolean dpP;
    private static Map<String, String> mDebugParamsMap;
    private static boolean dpC = false;
    private static boolean dpD = false;
    private static int dpE = 8;
    private static int dpF = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            dpI = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, dpI);
            dpJ = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.aFD().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, dpJ);
            dpK = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.aFD().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, dpK);
            dpN = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.aFD().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, dpN);
            dpO = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.aFD().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, dpO);
            dpP = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, dpP);
            dpL = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, dpL);
            dpM = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(dpM)) {
                com.baidu.tbadk.core.sharedPref.b.aFD().putString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, dpM);
                uu(dpM);
            }
            dpG = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(dpG)) {
                com.baidu.tbadk.core.sharedPref.b.aFD().putString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, dpG);
                uv(dpG);
            }
        }
    }

    private static void uu(String str) {
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

    private static void uv(String str) {
        if (!StringUtils.isNull(str)) {
            if (dpH == null) {
                dpH = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                dpH.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                dpH.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                dpH.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                dpH.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                dpH.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean aLY() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, true) : dpI;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aFD().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, 0) : dpJ;
    }

    public static int aLZ() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aFD().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, 5) : dpK;
    }

    public static boolean aMa() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, false) : dpL;
    }

    public static String aMb() {
        String string = com.baidu.tbadk.core.sharedPref.b.aFD().getString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        uu(string);
        return string;
    }

    public static Map<String, String> aMc() {
        if (!isInit) {
            aMb();
        }
        return mDebugParamsMap;
    }

    public static String aMd() {
        if (!isInit) {
            aMb();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int aMe() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aFD().getInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, 10000) : dpN;
    }

    public static int aMf() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aFD().getInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, 3000) : dpO;
    }

    public static boolean aMg() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, false) : dpP;
    }

    private static String aMh() {
        String string = com.baidu.tbadk.core.sharedPref.b.aFD().getString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        uv(string);
        return string;
    }

    public static boolean aMi() {
        if (!isInit) {
            aMh();
        }
        if (dpH == null) {
            return false;
        }
        String str = dpH.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        dpC = "1".equals(str);
        return dpC;
    }

    public static boolean aMj() {
        if (!isInit) {
            aMh();
        }
        if (dpH == null) {
            return false;
        }
        String str = dpH.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        dpD = "1".equals(str);
        return dpD;
    }

    public static int aMk() {
        if (!isInit) {
            aMh();
        }
        if (dpH == null) {
            return 8;
        }
        String str = dpH.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        dpE = com.baidu.adp.lib.f.b.toInt(str, 8);
        return dpE;
    }

    public static int aMl() {
        if (!isInit) {
            aMh();
        }
        if (dpH == null) {
            return 16;
        }
        String str = dpH.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        dpF = com.baidu.adp.lib.f.b.toInt(str, 16);
        return dpF;
    }

    public static boolean aMm() {
        if (!isInit) {
            aMh();
        }
        if (dpH == null) {
            return cD("18:00", "01:00");
        }
        String str = dpH.get("step_cache_rush_hour");
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
