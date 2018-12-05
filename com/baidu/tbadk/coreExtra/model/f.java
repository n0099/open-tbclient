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
    private static String aRF;
    private static Map<String, String> aRG;
    private static boolean aRH;
    private static int aRI;
    private static int aRJ;
    private static boolean aRK;
    private static String aRL;
    private static int aRM;
    private static int aRN;
    private static boolean aRO;
    private static Map<String, String> mDebugParamsMap;
    private static boolean aRB = false;
    private static boolean aRC = false;
    private static int aRD = 8;
    private static int aRE = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            aRH = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_switch", aRH);
            aRI = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_type", aRI);
            aRJ = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_number", aRJ);
            aRM = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_prepare_max_wait_time", aRM);
            aRN = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_prepare_max_loading_time", aRN);
            aRO = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_is_open_prepare_time", aRO);
            aRK = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_moov_check", aRK);
            aRL = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(aRL)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_debug_type", aRL);
                gW(aRL);
            }
            aRF = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(aRF)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_step_cache_strategy", aRF);
                gX(aRF);
            }
        }
    }

    private static void gW(String str) {
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

    private static void gX(String str) {
        if (!StringUtils.isNull(str)) {
            if (aRG == null) {
                aRG = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                aRG.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                aRG.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                aRG.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                aRG.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                aRG.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean JL() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_switch", true) : aRH;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_type", 0) : aRI;
    }

    public static int JM() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_number", 5) : aRJ;
    }

    public static boolean JN() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_moov_check", false) : aRK;
    }

    public static String JO() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_debug_type", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        gW(string);
        return string;
    }

    public static Map<String, String> JP() {
        if (!isInit) {
            JO();
        }
        return mDebugParamsMap;
    }

    public static String JQ() {
        if (!isInit) {
            JO();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int JR() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_prepare_max_wait_time", 10000) : aRM;
    }

    public static int JS() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_prepare_max_loading_time", 3000) : aRN;
    }

    public static boolean JT() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_is_open_prepare_time", false) : aRO;
    }

    private static String JU() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_step_cache_strategy", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        gX(string);
        return string;
    }

    public static boolean JV() {
        if (!isInit) {
            JU();
        }
        if (aRG == null) {
            return false;
        }
        String str = aRG.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        aRB = "1".equals(str);
        return aRB;
    }

    public static boolean JW() {
        if (!isInit) {
            JU();
        }
        if (aRG == null) {
            return false;
        }
        String str = aRG.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        aRC = "1".equals(str);
        return aRC;
    }

    public static int JX() {
        if (!isInit) {
            JU();
        }
        if (aRG == null) {
            return 8;
        }
        String str = aRG.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        aRD = com.baidu.adp.lib.g.b.l(str, 8);
        return aRD;
    }

    public static int JY() {
        if (!isInit) {
            JU();
        }
        if (aRG == null) {
            return 16;
        }
        String str = aRG.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        aRE = com.baidu.adp.lib.g.b.l(str, 16);
        return aRE;
    }

    public static boolean JZ() {
        if (!isInit) {
            JU();
        }
        if (aRG == null) {
            return aF("18:00", "01:00");
        }
        String str = aRG.get("step_cache_rush_hour");
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
