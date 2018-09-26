package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.lib.util.StringUtils;
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
    private static String aIO;
    private static Map<String, String> aIP;
    private static boolean aIQ;
    private static int aIR;
    private static int aIS;
    private static boolean aIT;
    private static String aIU;
    private static int aIV;
    private static int aIW;
    private static boolean aIX;
    private static Map<String, String> mDebugParamsMap;
    private static boolean aIK = false;
    private static boolean aIL = false;
    private static int aIM = 8;
    private static int aIN = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            aIQ = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_switch", aIQ);
            aIR = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_type", aIR);
            aIS = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_number", aIS);
            aIV = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_prepare_max_wait_time", aIV);
            aIW = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_prepare_max_loading_time", aIW);
            aIX = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_is_open_prepare_time", aIX);
            aIT = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_moov_check", aIT);
            aIU = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(aIU)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_debug_type", aIU);
                go(aIU);
            }
            aIO = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(aIO)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_step_cache_strategy", aIO);
                gp(aIO);
            }
        }
    }

    private static void go(String str) {
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

    private static void gp(String str) {
        if (!StringUtils.isNull(str)) {
            if (aIP == null) {
                aIP = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                aIP.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                aIP.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                aIP.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                aIP.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                aIP.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean Gu() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_switch", true) : aIQ;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_type", 0) : aIR;
    }

    public static int Gv() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_number", 5) : aIS;
    }

    public static boolean Gw() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_moov_check", false) : aIT;
    }

    public static String Gx() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_debug_type", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        go(string);
        return string;
    }

    public static Map<String, String> Gy() {
        if (!isInit) {
            Gx();
        }
        return mDebugParamsMap;
    }

    public static String Gz() {
        if (!isInit) {
            Gx();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int GA() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_prepare_max_wait_time", 10000) : aIV;
    }

    public static int GB() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_prepare_max_loading_time", 3000) : aIW;
    }

    public static boolean GC() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_is_open_prepare_time", false) : aIX;
    }

    private static String GD() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_step_cache_strategy", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        gp(string);
        return string;
    }

    public static boolean GE() {
        if (!isInit) {
            GD();
        }
        if (aIP == null) {
            return false;
        }
        String str = aIP.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        aIK = "1".equals(str);
        return aIK;
    }

    public static boolean GF() {
        if (!isInit) {
            GD();
        }
        if (aIP == null) {
            return false;
        }
        String str = aIP.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        aIL = "1".equals(str);
        return aIL;
    }

    public static int GG() {
        if (!isInit) {
            GD();
        }
        if (aIP == null) {
            return 8;
        }
        String str = aIP.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        aIM = com.baidu.adp.lib.g.b.l(str, 8);
        return aIM;
    }

    public static int GH() {
        if (!isInit) {
            GD();
        }
        if (aIP == null) {
            return 16;
        }
        String str = aIP.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        aIN = com.baidu.adp.lib.g.b.l(str, 16);
        return aIN;
    }

    public static boolean GI() {
        if (!isInit) {
            GD();
        }
        if (aIP == null) {
            return ar("18:00", "01:00");
        }
        String str = aIP.get("step_cache_rush_hour");
        if (StringUtils.isNull(str)) {
            return ar("18:00", "01:00");
        }
        try {
            String[] split = str.split(",");
            for (String str2 : split) {
                String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split2.length == 2 && ar(split2[0], split2[1])) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean ar(String str, String str2) {
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
