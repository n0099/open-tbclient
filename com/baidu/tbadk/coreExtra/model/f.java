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
    private static String auc;
    private static Map<String, String> aud;
    private static boolean aue;
    private static int auf;
    private static int aug;
    private static boolean auh;
    private static String aui;
    private static Map<String, String> mDebugParamsMap;
    private static boolean atY = false;
    private static boolean atZ = false;
    private static int aua = 8;
    private static int aub = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            aue = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_switch", aue);
            auf = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_type", auf);
            aug = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_number", aug);
            auh = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_moov_check", auh);
            aui = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(aui)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_debug_type", aui);
                fe(aui);
            }
            auc = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(auc)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_step_cache_strategy", auc);
                ff(auc);
            }
        }
    }

    private static void fe(String str) {
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

    private static void ff(String str) {
        if (!StringUtils.isNull(str)) {
            if (aud == null) {
                aud = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                aud.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                aud.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                aud.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                aud.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                aud.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean AC() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_switch", true) : aue;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_type", 0) : auf;
    }

    public static int AD() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_number", 5) : aug;
    }

    public static boolean AE() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_moov_check", false) : auh;
    }

    public static String AF() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_debug_type", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        fe(string);
        return string;
    }

    public static Map<String, String> AG() {
        if (!isInit) {
            AF();
        }
        return mDebugParamsMap;
    }

    public static String AH() {
        if (!isInit) {
            AF();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    private static String AI() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_step_cache_strategy", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        ff(string);
        return string;
    }

    public static boolean AJ() {
        if (!isInit) {
            AI();
        }
        if (aud == null) {
            return false;
        }
        String str = aud.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        atY = "1".equals(str);
        return atY;
    }

    public static boolean AK() {
        if (!isInit) {
            AI();
        }
        if (aud == null) {
            return false;
        }
        String str = aud.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        atZ = "1".equals(str);
        return atZ;
    }

    public static int AL() {
        if (!isInit) {
            AI();
        }
        if (aud == null) {
            return 8;
        }
        String str = aud.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        aua = com.baidu.adp.lib.g.b.g(str, 8);
        return aua;
    }

    public static int AM() {
        if (!isInit) {
            AI();
        }
        if (aud == null) {
            return 16;
        }
        String str = aud.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        aub = com.baidu.adp.lib.g.b.g(str, 16);
        return aub;
    }

    public static boolean AN() {
        if (!isInit) {
            AI();
        }
        if (aud == null) {
            return ai("18:00", "01:00");
        }
        String str = aud.get("step_cache_rush_hour");
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
