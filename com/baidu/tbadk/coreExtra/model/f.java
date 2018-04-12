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
    private static boolean awA;
    private static String awB;
    private static int awC;
    private static int awD;
    private static boolean awE;
    private static String awv;
    private static Map<String, String> aww;
    private static boolean awx;
    private static int awy;
    private static int awz;
    private static Map<String, String> mDebugParamsMap;
    private static boolean awr = false;
    private static boolean aws = false;
    private static int awt = 8;
    private static int awu = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            awx = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_switch", awx);
            awy = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_type", awy);
            awz = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_number", awz);
            awC = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_prepare_max_wait_time", awC);
            awD = jSONObject.optInt("prepare_max_loading_time", PushConstants.WORK_RECEIVER_EVENTCORE_ERROR);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_prepare_max_loading_time", awD);
            awE = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_is_open_prepare_time", awE);
            awA = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_moov_check", awA);
            awB = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(awB)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_debug_type", awB);
                ft(awB);
            }
            awv = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(awv)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_step_cache_strategy", awv);
                fu(awv);
            }
        }
    }

    private static void ft(String str) {
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

    private static void fu(String str) {
        if (!StringUtils.isNull(str)) {
            if (aww == null) {
                aww = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                aww.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                aww.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                aww.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                aww.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                aww.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean Br() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_switch", true) : awx;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_type", 0) : awy;
    }

    public static int Bs() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_number", 5) : awz;
    }

    public static boolean Bt() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_moov_check", false) : awA;
    }

    public static String Bu() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_debug_type", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        ft(string);
        return string;
    }

    public static Map<String, String> Bv() {
        if (!isInit) {
            Bu();
        }
        return mDebugParamsMap;
    }

    public static String Bw() {
        if (!isInit) {
            Bu();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int Bx() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_prepare_max_wait_time", 10000) : awC;
    }

    public static int By() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_prepare_max_loading_time", PushConstants.WORK_RECEIVER_EVENTCORE_ERROR) : awD;
    }

    public static boolean Bz() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_is_open_prepare_time", false) : awE;
    }

    private static String BA() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_step_cache_strategy", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        fu(string);
        return string;
    }

    public static boolean BB() {
        if (!isInit) {
            BA();
        }
        if (aww == null) {
            return false;
        }
        String str = aww.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        awr = "1".equals(str);
        return awr;
    }

    public static boolean BC() {
        if (!isInit) {
            BA();
        }
        if (aww == null) {
            return false;
        }
        String str = aww.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        aws = "1".equals(str);
        return aws;
    }

    public static int BD() {
        if (!isInit) {
            BA();
        }
        if (aww == null) {
            return 8;
        }
        String str = aww.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        awt = com.baidu.adp.lib.g.b.g(str, 8);
        return awt;
    }

    public static int BE() {
        if (!isInit) {
            BA();
        }
        if (aww == null) {
            return 16;
        }
        String str = aww.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        awu = com.baidu.adp.lib.g.b.g(str, 16);
        return awu;
    }

    public static boolean BF() {
        if (!isInit) {
            BA();
        }
        if (aww == null) {
            return ai("18:00", "01:00");
        }
        String str = aww.get("step_cache_rush_hour");
        if (StringUtils.isNull(str)) {
            return ai("18:00", "01:00");
        }
        try {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (String str2 : split) {
                String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split2.length == 2 && ai(split2[0], split2[1])) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean ai(String str, String str2) {
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
