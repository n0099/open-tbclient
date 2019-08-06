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
    private static String cke;
    private static Map<String, String> ckf;
    private static boolean ckg;
    private static int ckh;
    private static int cki;
    private static boolean ckj;
    private static String ckk;
    private static int ckl;
    private static int ckm;
    private static boolean ckn;
    private static Map<String, String> mDebugParamsMap;
    private static boolean cka = false;
    private static boolean ckb = false;
    private static int ckc = 8;
    private static int ckd = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            ckg = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("video_report_config_switch", ckg);
            ckh = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("video_report_config_upload_type", ckh);
            cki = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("video_report_config_upload_number", cki);
            ckl = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("video_report_prepare_max_wait_time", ckl);
            ckm = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("video_report_prepare_max_loading_time", ckm);
            ckn = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("video_report_is_open_prepare_time", ckn);
            ckj = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("video_report_config_moov_check", ckj);
            ckk = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(ckk)) {
                com.baidu.tbadk.core.sharedPref.b.ahQ().putString("video_report_config_debug_type", ckk);
                px(ckk);
            }
            cke = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(cke)) {
                com.baidu.tbadk.core.sharedPref.b.ahQ().putString("video_report_config_step_cache_strategy", cke);
                py(cke);
            }
        }
    }

    private static void px(String str) {
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

    private static void py(String str) {
        if (!StringUtils.isNull(str)) {
            if (ckf == null) {
                ckf = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                ckf.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                ckf.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                ckf.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                ckf.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                ckf.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean apE() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("video_report_config_switch", true) : ckg;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("video_report_config_upload_type", 0) : ckh;
    }

    public static int apF() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("video_report_config_upload_number", 5) : cki;
    }

    public static boolean apG() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("video_report_config_moov_check", false) : ckj;
    }

    public static String apH() {
        String string = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("video_report_config_debug_type", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        px(string);
        return string;
    }

    public static Map<String, String> apI() {
        if (!isInit) {
            apH();
        }
        return mDebugParamsMap;
    }

    public static String apJ() {
        if (!isInit) {
            apH();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int apK() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("video_report_prepare_max_wait_time", 10000) : ckl;
    }

    public static int apL() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("video_report_prepare_max_loading_time", 3000) : ckm;
    }

    public static boolean apM() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("video_report_is_open_prepare_time", false) : ckn;
    }

    private static String apN() {
        String string = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("video_report_config_step_cache_strategy", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        py(string);
        return string;
    }

    public static boolean apO() {
        if (!isInit) {
            apN();
        }
        if (ckf == null) {
            return false;
        }
        String str = ckf.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        cka = "1".equals(str);
        return cka;
    }

    public static boolean apP() {
        if (!isInit) {
            apN();
        }
        if (ckf == null) {
            return false;
        }
        String str = ckf.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        ckb = "1".equals(str);
        return ckb;
    }

    public static int apQ() {
        if (!isInit) {
            apN();
        }
        if (ckf == null) {
            return 8;
        }
        String str = ckf.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        ckc = com.baidu.adp.lib.g.b.f(str, 8);
        return ckc;
    }

    public static int apR() {
        if (!isInit) {
            apN();
        }
        if (ckf == null) {
            return 16;
        }
        String str = ckf.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        ckd = com.baidu.adp.lib.g.b.f(str, 16);
        return ckd;
    }

    public static boolean apS() {
        if (!isInit) {
            apN();
        }
        if (ckf == null) {
            return ca("18:00", "01:00");
        }
        String str = ckf.get("step_cache_rush_hour");
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
