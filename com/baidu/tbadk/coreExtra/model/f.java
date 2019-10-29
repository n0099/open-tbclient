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
    private static String cxZ;
    private static Map<String, String> cya;
    private static boolean cyb;
    private static int cyc;
    private static int cyd;
    private static boolean cye;
    private static String cyf;
    private static int cyg;
    private static int cyh;
    private static boolean cyi;
    private static Map<String, String> mDebugParamsMap;
    private static boolean cxV = false;
    private static boolean cxW = false;
    private static int cxX = 8;
    private static int cxY = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            cyb = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, cyb);
            cyc = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.alR().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, cyc);
            cyd = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.alR().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, cyd);
            cyg = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.alR().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, cyg);
            cyh = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.alR().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, cyh);
            cyi = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, cyi);
            cye = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, cye);
            cyf = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(cyf)) {
                com.baidu.tbadk.core.sharedPref.b.alR().putString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, cyf);
                oT(cyf);
            }
            cxZ = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(cxZ)) {
                com.baidu.tbadk.core.sharedPref.b.alR().putString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, cxZ);
                oU(cxZ);
            }
        }
    }

    private static void oT(String str) {
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

    private static void oU(String str) {
        if (!StringUtils.isNull(str)) {
            if (cya == null) {
                cya = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                cya.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                cya.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                cya.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                cya.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                cya.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean arK() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, true) : cyb;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.alR().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, 0) : cyc;
    }

    public static int arL() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.alR().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, 5) : cyd;
    }

    public static boolean arM() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, false) : cye;
    }

    public static String arN() {
        String string = com.baidu.tbadk.core.sharedPref.b.alR().getString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        oT(string);
        return string;
    }

    public static Map<String, String> arO() {
        if (!isInit) {
            arN();
        }
        return mDebugParamsMap;
    }

    public static String arP() {
        if (!isInit) {
            arN();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int arQ() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.alR().getInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, 10000) : cyg;
    }

    public static int arR() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.alR().getInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, 3000) : cyh;
    }

    public static boolean arS() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, false) : cyi;
    }

    private static String arT() {
        String string = com.baidu.tbadk.core.sharedPref.b.alR().getString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        oU(string);
        return string;
    }

    public static boolean arU() {
        if (!isInit) {
            arT();
        }
        if (cya == null) {
            return false;
        }
        String str = cya.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        cxV = "1".equals(str);
        return cxV;
    }

    public static boolean arV() {
        if (!isInit) {
            arT();
        }
        if (cya == null) {
            return false;
        }
        String str = cya.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        cxW = "1".equals(str);
        return cxW;
    }

    public static int arW() {
        if (!isInit) {
            arT();
        }
        if (cya == null) {
            return 8;
        }
        String str = cya.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        cxX = com.baidu.adp.lib.g.b.toInt(str, 8);
        return cxX;
    }

    public static int arX() {
        if (!isInit) {
            arT();
        }
        if (cya == null) {
            return 16;
        }
        String str = cya.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        cxY = com.baidu.adp.lib.g.b.toInt(str, 16);
        return cxY;
    }

    public static boolean arY() {
        if (!isInit) {
            arT();
        }
        if (cya == null) {
            return bX("18:00", "01:00");
        }
        String str = cya.get("step_cache_rush_hour");
        if (StringUtils.isNull(str)) {
            return bX("18:00", "01:00");
        }
        try {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (String str2 : split) {
                String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split2.length == 2 && bX(split2[0], split2[1])) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean bX(String str, String str2) {
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
