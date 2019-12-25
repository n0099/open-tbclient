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
    private static String dkU;
    private static Map<String, String> dkV;
    private static boolean dkW;
    private static int dkX;
    private static int dkY;
    private static boolean dkZ;
    private static String dla;
    private static int dlb;
    private static int dlc;
    private static boolean dld;
    private static Map<String, String> mDebugParamsMap;
    private static boolean dkQ = false;
    private static boolean dkR = false;
    private static int dkS = 8;
    private static int dkT = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            dkW = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, dkW);
            dkX = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.aCY().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, dkX);
            dkY = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.aCY().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, dkY);
            dlb = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.aCY().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, dlb);
            dlc = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.aCY().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, dlc);
            dld = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, dld);
            dkZ = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, dkZ);
            dla = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(dla)) {
                com.baidu.tbadk.core.sharedPref.b.aCY().putString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, dla);
                tX(dla);
            }
            dkU = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(dkU)) {
                com.baidu.tbadk.core.sharedPref.b.aCY().putString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, dkU);
                tY(dkU);
            }
        }
    }

    private static void tX(String str) {
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

    private static void tY(String str) {
        if (!StringUtils.isNull(str)) {
            if (dkV == null) {
                dkV = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                dkV.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                dkV.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                dkV.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                dkV.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                dkV.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean aJh() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, true) : dkW;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aCY().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, 0) : dkX;
    }

    public static int aJi() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aCY().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, 5) : dkY;
    }

    public static boolean aJj() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, false) : dkZ;
    }

    public static String aJk() {
        String string = com.baidu.tbadk.core.sharedPref.b.aCY().getString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        tX(string);
        return string;
    }

    public static Map<String, String> aJl() {
        if (!isInit) {
            aJk();
        }
        return mDebugParamsMap;
    }

    public static String aJm() {
        if (!isInit) {
            aJk();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int aJn() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aCY().getInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, 10000) : dlb;
    }

    public static int aJo() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aCY().getInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, 3000) : dlc;
    }

    public static boolean aJp() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, false) : dld;
    }

    private static String aJq() {
        String string = com.baidu.tbadk.core.sharedPref.b.aCY().getString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        tY(string);
        return string;
    }

    public static boolean aJr() {
        if (!isInit) {
            aJq();
        }
        if (dkV == null) {
            return false;
        }
        String str = dkV.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        dkQ = "1".equals(str);
        return dkQ;
    }

    public static boolean aJs() {
        if (!isInit) {
            aJq();
        }
        if (dkV == null) {
            return false;
        }
        String str = dkV.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        dkR = "1".equals(str);
        return dkR;
    }

    public static int aJt() {
        if (!isInit) {
            aJq();
        }
        if (dkV == null) {
            return 8;
        }
        String str = dkV.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        dkS = com.baidu.adp.lib.f.b.toInt(str, 8);
        return dkS;
    }

    public static int aJu() {
        if (!isInit) {
            aJq();
        }
        if (dkV == null) {
            return 16;
        }
        String str = dkV.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        dkT = com.baidu.adp.lib.f.b.toInt(str, 16);
        return dkT;
    }

    public static boolean aJv() {
        if (!isInit) {
            aJq();
        }
        if (dkV == null) {
            return cu("18:00", "01:00");
        }
        String str = dkV.get("step_cache_rush_hour");
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
