package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.lib.util.StringUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
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
    private static String biM;
    private static Map<String, String> biN;
    private static boolean biO;
    private static int biP;
    private static int biQ;
    private static boolean biR;
    private static String biS;
    private static int biT;
    private static int biU;
    private static boolean biV;
    private static Map<String, String> mDebugParamsMap;
    private static boolean biI = false;
    private static boolean biJ = false;
    private static int biK = 8;
    private static int biL = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            biO = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_switch", biO);
            biP = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_type", biP);
            biQ = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_number", biQ);
            biT = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_prepare_max_wait_time", biT);
            biU = jSONObject.optInt("prepare_max_loading_time", PushConstants.WORK_RECEIVER_EVENTCORE_ERROR);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_prepare_max_loading_time", biU);
            biV = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_is_open_prepare_time", biV);
            biR = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_moov_check", biR);
            biS = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(biS)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_debug_type", biS);
                fs(biS);
            }
            biM = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(biM)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_step_cache_strategy", biM);
                ft(biM);
            }
        }
    }

    private static void fs(String str) {
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

    private static void ft(String str) {
        if (!StringUtils.isNull(str)) {
            if (biN == null) {
                biN = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                biN.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                biN.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                biN.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                biN.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                biN.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean HX() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_switch", true) : biO;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_type", 0) : biP;
    }

    public static int HY() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_number", 5) : biQ;
    }

    public static boolean HZ() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_moov_check", false) : biR;
    }

    public static String Ia() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_debug_type", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        fs(string);
        return string;
    }

    public static Map<String, String> Ib() {
        if (!isInit) {
            Ia();
        }
        return mDebugParamsMap;
    }

    public static String Ic() {
        if (!isInit) {
            Ia();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int Id() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_prepare_max_wait_time", 10000) : biT;
    }

    public static int Ie() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_prepare_max_loading_time", PushConstants.WORK_RECEIVER_EVENTCORE_ERROR) : biU;
    }

    public static boolean If() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_is_open_prepare_time", false) : biV;
    }

    private static String Ig() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_step_cache_strategy", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        ft(string);
        return string;
    }

    public static boolean Ih() {
        if (!isInit) {
            Ig();
        }
        if (biN == null) {
            return false;
        }
        String str = biN.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        biI = "1".equals(str);
        return biI;
    }

    public static boolean Ii() {
        if (!isInit) {
            Ig();
        }
        if (biN == null) {
            return false;
        }
        String str = biN.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        biJ = "1".equals(str);
        return biJ;
    }

    public static int Ij() {
        if (!isInit) {
            Ig();
        }
        if (biN == null) {
            return 8;
        }
        String str = biN.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        biK = com.baidu.adp.lib.g.b.h(str, 8);
        return biK;
    }

    public static int Ik() {
        if (!isInit) {
            Ig();
        }
        if (biN == null) {
            return 16;
        }
        String str = biN.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        biL = com.baidu.adp.lib.g.b.h(str, 16);
        return biL;
    }

    public static boolean Il() {
        if (!isInit) {
            Ig();
        }
        if (biN == null) {
            return ag("18:00", "01:00");
        }
        String str = biN.get("step_cache_rush_hour");
        if (StringUtils.isNull(str)) {
            return ag("18:00", "01:00");
        }
        try {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (String str2 : split) {
                String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split2.length == 2 && ag(split2[0], split2[1])) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean ag(String str, String str2) {
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
