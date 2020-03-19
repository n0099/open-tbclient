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
    private static String dpT;
    private static Map<String, String> dpU;
    private static boolean dpV;
    private static int dpW;
    private static int dpX;
    private static boolean dpY;
    private static String dpZ;
    private static int dqa;
    private static int dqb;
    private static boolean dqc;
    private static Map<String, String> mDebugParamsMap;
    private static boolean dpP = false;
    private static boolean dpQ = false;
    private static int dpR = 8;
    private static int dpS = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            dpV = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, dpV);
            dpW = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.aFH().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, dpW);
            dpX = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.aFH().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, dpX);
            dqa = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.aFH().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, dqa);
            dqb = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.aFH().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, dqb);
            dqc = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, dqc);
            dpY = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, dpY);
            dpZ = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(dpZ)) {
                com.baidu.tbadk.core.sharedPref.b.aFH().putString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, dpZ);
                uu(dpZ);
            }
            dpT = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(dpT)) {
                com.baidu.tbadk.core.sharedPref.b.aFH().putString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, dpT);
                uv(dpT);
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
            if (dpU == null) {
                dpU = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                dpU.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                dpU.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                dpU.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                dpU.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                dpU.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean aMc() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, true) : dpV;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aFH().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, 0) : dpW;
    }

    public static int aMd() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aFH().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, 5) : dpX;
    }

    public static boolean aMe() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, false) : dpY;
    }

    public static String aMf() {
        String string = com.baidu.tbadk.core.sharedPref.b.aFH().getString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        uu(string);
        return string;
    }

    public static Map<String, String> aMg() {
        if (!isInit) {
            aMf();
        }
        return mDebugParamsMap;
    }

    public static String aMh() {
        if (!isInit) {
            aMf();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int aMi() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aFH().getInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, 10000) : dqa;
    }

    public static int aMj() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aFH().getInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, 3000) : dqb;
    }

    public static boolean aMk() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, false) : dqc;
    }

    private static String aMl() {
        String string = com.baidu.tbadk.core.sharedPref.b.aFH().getString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        uv(string);
        return string;
    }

    public static boolean aMm() {
        if (!isInit) {
            aMl();
        }
        if (dpU == null) {
            return false;
        }
        String str = dpU.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        dpP = "1".equals(str);
        return dpP;
    }

    public static boolean aMn() {
        if (!isInit) {
            aMl();
        }
        if (dpU == null) {
            return false;
        }
        String str = dpU.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        dpQ = "1".equals(str);
        return dpQ;
    }

    public static int aMo() {
        if (!isInit) {
            aMl();
        }
        if (dpU == null) {
            return 8;
        }
        String str = dpU.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        dpR = com.baidu.adp.lib.f.b.toInt(str, 8);
        return dpR;
    }

    public static int aMp() {
        if (!isInit) {
            aMl();
        }
        if (dpU == null) {
            return 16;
        }
        String str = dpU.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        dpS = com.baidu.adp.lib.f.b.toInt(str, 16);
        return dpS;
    }

    public static boolean aMq() {
        if (!isInit) {
            aMl();
        }
        if (dpU == null) {
            return cC("18:00", "01:00");
        }
        String str = dpU.get("step_cache_rush_hour");
        if (StringUtils.isNull(str)) {
            return cC("18:00", "01:00");
        }
        try {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (String str2 : split) {
                String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split2.length == 2 && cC(split2[0], split2[1])) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean cC(String str, String str2) {
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
