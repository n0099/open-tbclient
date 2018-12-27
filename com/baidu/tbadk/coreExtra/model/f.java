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
    private static String aRH;
    private static Map<String, String> aRI;
    private static boolean aRJ;
    private static int aRK;
    private static int aRL;
    private static boolean aRM;
    private static String aRN;
    private static int aRO;
    private static int aRP;
    private static boolean aRQ;
    private static Map<String, String> mDebugParamsMap;
    private static boolean aRD = false;
    private static boolean aRE = false;
    private static int aRF = 8;
    private static int aRG = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            aRJ = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_switch", aRJ);
            aRK = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_type", aRK);
            aRL = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_number", aRL);
            aRO = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_prepare_max_wait_time", aRO);
            aRP = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_prepare_max_loading_time", aRP);
            aRQ = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_is_open_prepare_time", aRQ);
            aRM = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_moov_check", aRM);
            aRN = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(aRN)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_debug_type", aRN);
                gX(aRN);
            }
            aRH = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(aRH)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_step_cache_strategy", aRH);
                gY(aRH);
            }
        }
    }

    private static void gX(String str) {
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

    private static void gY(String str) {
        if (!StringUtils.isNull(str)) {
            if (aRI == null) {
                aRI = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                aRI.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                aRI.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                aRI.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                aRI.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                aRI.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean JM() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_switch", true) : aRJ;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_type", 0) : aRK;
    }

    public static int JN() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_number", 5) : aRL;
    }

    public static boolean JO() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_moov_check", false) : aRM;
    }

    public static String JP() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_debug_type", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        gX(string);
        return string;
    }

    public static Map<String, String> JQ() {
        if (!isInit) {
            JP();
        }
        return mDebugParamsMap;
    }

    public static String JR() {
        if (!isInit) {
            JP();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int JS() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_prepare_max_wait_time", 10000) : aRO;
    }

    public static int JT() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_prepare_max_loading_time", 3000) : aRP;
    }

    public static boolean JU() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_is_open_prepare_time", false) : aRQ;
    }

    private static String JV() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_step_cache_strategy", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        gY(string);
        return string;
    }

    public static boolean JW() {
        if (!isInit) {
            JV();
        }
        if (aRI == null) {
            return false;
        }
        String str = aRI.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        aRD = "1".equals(str);
        return aRD;
    }

    public static boolean JX() {
        if (!isInit) {
            JV();
        }
        if (aRI == null) {
            return false;
        }
        String str = aRI.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        aRE = "1".equals(str);
        return aRE;
    }

    public static int JY() {
        if (!isInit) {
            JV();
        }
        if (aRI == null) {
            return 8;
        }
        String str = aRI.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        aRF = com.baidu.adp.lib.g.b.l(str, 8);
        return aRF;
    }

    public static int JZ() {
        if (!isInit) {
            JV();
        }
        if (aRI == null) {
            return 16;
        }
        String str = aRI.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        aRG = com.baidu.adp.lib.g.b.l(str, 16);
        return aRG;
    }

    public static boolean Ka() {
        if (!isInit) {
            JV();
        }
        if (aRI == null) {
            return aF("18:00", "01:00");
        }
        String str = aRI.get("step_cache_rush_hour");
        if (StringUtils.isNull(str)) {
            return aF("18:00", "01:00");
        }
        try {
            String[] split = str.split(",");
            for (String str2 : split) {
                String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split2.length == 2 && aF(split2[0], split2[1])) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean aF(String str, String str2) {
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
