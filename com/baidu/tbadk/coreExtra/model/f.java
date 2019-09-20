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
    private static String ckZ;
    private static Map<String, String> cla;
    private static boolean clb;
    private static int clc;
    private static int cld;
    private static boolean cle;
    private static String clf;
    private static int clg;
    private static int clh;
    private static boolean cli;
    private static Map<String, String> mDebugParamsMap;
    private static boolean ckV = false;
    private static boolean ckW = false;
    private static int ckX = 8;
    private static int ckY = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            clb = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("video_report_config_switch", clb);
            clc = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.ahU().putInt("video_report_config_upload_type", clc);
            cld = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.ahU().putInt("video_report_config_upload_number", cld);
            clg = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.ahU().putInt("video_report_prepare_max_wait_time", clg);
            clh = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.ahU().putInt("video_report_prepare_max_loading_time", clh);
            cli = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("video_report_is_open_prepare_time", cli);
            cle = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("video_report_config_moov_check", cle);
            clf = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(clf)) {
                com.baidu.tbadk.core.sharedPref.b.ahU().putString("video_report_config_debug_type", clf);
                pI(clf);
            }
            ckZ = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(ckZ)) {
                com.baidu.tbadk.core.sharedPref.b.ahU().putString("video_report_config_step_cache_strategy", ckZ);
                pJ(ckZ);
            }
        }
    }

    private static void pI(String str) {
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

    private static void pJ(String str) {
        if (!StringUtils.isNull(str)) {
            if (cla == null) {
                cla = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                cla.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                cla.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                cla.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                cla.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                cla.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean apQ() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("video_report_config_switch", true) : clb;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.ahU().getInt("video_report_config_upload_type", 0) : clc;
    }

    public static int apR() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.ahU().getInt("video_report_config_upload_number", 5) : cld;
    }

    public static boolean apS() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("video_report_config_moov_check", false) : cle;
    }

    public static String apT() {
        String string = com.baidu.tbadk.core.sharedPref.b.ahU().getString("video_report_config_debug_type", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        pI(string);
        return string;
    }

    public static Map<String, String> apU() {
        if (!isInit) {
            apT();
        }
        return mDebugParamsMap;
    }

    public static String apV() {
        if (!isInit) {
            apT();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int apW() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.ahU().getInt("video_report_prepare_max_wait_time", 10000) : clg;
    }

    public static int apX() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.ahU().getInt("video_report_prepare_max_loading_time", 3000) : clh;
    }

    public static boolean apY() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("video_report_is_open_prepare_time", false) : cli;
    }

    private static String apZ() {
        String string = com.baidu.tbadk.core.sharedPref.b.ahU().getString("video_report_config_step_cache_strategy", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        pJ(string);
        return string;
    }

    public static boolean aqa() {
        if (!isInit) {
            apZ();
        }
        if (cla == null) {
            return false;
        }
        String str = cla.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        ckV = "1".equals(str);
        return ckV;
    }

    public static boolean aqb() {
        if (!isInit) {
            apZ();
        }
        if (cla == null) {
            return false;
        }
        String str = cla.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        ckW = "1".equals(str);
        return ckW;
    }

    public static int aqc() {
        if (!isInit) {
            apZ();
        }
        if (cla == null) {
            return 8;
        }
        String str = cla.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        ckX = com.baidu.adp.lib.g.b.f(str, 8);
        return ckX;
    }

    public static int aqd() {
        if (!isInit) {
            apZ();
        }
        if (cla == null) {
            return 16;
        }
        String str = cla.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        ckY = com.baidu.adp.lib.g.b.f(str, 16);
        return ckY;
    }

    public static boolean aqe() {
        if (!isInit) {
            apZ();
        }
        if (cla == null) {
            return ca("18:00", "01:00");
        }
        String str = cla.get("step_cache_rush_hour");
        if (StringUtils.isNull(str)) {
            return ca("18:00", "01:00");
        }
        try {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (String str2 : split) {
                String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split2.length == 2 && ca(split2[0], split2[1])) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean ca(String str, String str2) {
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
