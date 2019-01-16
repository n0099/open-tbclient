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
    private static String aSl;
    private static Map<String, String> aSm;
    private static boolean aSn;
    private static int aSo;
    private static int aSp;
    private static boolean aSq;
    private static String aSr;
    private static int aSs;
    private static int aSt;
    private static boolean aSu;
    private static Map<String, String> mDebugParamsMap;
    private static boolean aSh = false;
    private static boolean aSi = false;
    private static int aSj = 8;
    private static int aSk = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            aSn = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_switch", aSn);
            aSo = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_type", aSo);
            aSp = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_number", aSp);
            aSs = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_prepare_max_wait_time", aSs);
            aSt = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_prepare_max_loading_time", aSt);
            aSu = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_is_open_prepare_time", aSu);
            aSq = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_moov_check", aSq);
            aSr = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(aSr)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_debug_type", aSr);
                hk(aSr);
            }
            aSl = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(aSl)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_step_cache_strategy", aSl);
                hl(aSl);
            }
        }
    }

    private static void hk(String str) {
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

    private static void hl(String str) {
        if (!StringUtils.isNull(str)) {
            if (aSm == null) {
                aSm = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                aSm.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                aSm.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                aSm.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                aSm.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                aSm.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean Kb() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_switch", true) : aSn;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_type", 0) : aSo;
    }

    public static int Kc() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_number", 5) : aSp;
    }

    public static boolean Kd() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_moov_check", false) : aSq;
    }

    public static String Ke() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_debug_type", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        hk(string);
        return string;
    }

    public static Map<String, String> Kf() {
        if (!isInit) {
            Ke();
        }
        return mDebugParamsMap;
    }

    public static String Kg() {
        if (!isInit) {
            Ke();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int Kh() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_prepare_max_wait_time", 10000) : aSs;
    }

    public static int Ki() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_prepare_max_loading_time", 3000) : aSt;
    }

    public static boolean Kj() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_is_open_prepare_time", false) : aSu;
    }

    private static String Kk() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_step_cache_strategy", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        hl(string);
        return string;
    }

    public static boolean Kl() {
        if (!isInit) {
            Kk();
        }
        if (aSm == null) {
            return false;
        }
        String str = aSm.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        aSh = "1".equals(str);
        return aSh;
    }

    public static boolean Km() {
        if (!isInit) {
            Kk();
        }
        if (aSm == null) {
            return false;
        }
        String str = aSm.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        aSi = "1".equals(str);
        return aSi;
    }

    public static int Kn() {
        if (!isInit) {
            Kk();
        }
        if (aSm == null) {
            return 8;
        }
        String str = aSm.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        aSj = com.baidu.adp.lib.g.b.l(str, 8);
        return aSj;
    }

    public static int Ko() {
        if (!isInit) {
            Kk();
        }
        if (aSm == null) {
            return 16;
        }
        String str = aSm.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        aSk = com.baidu.adp.lib.g.b.l(str, 16);
        return aSk;
    }

    public static boolean Kp() {
        if (!isInit) {
            Kk();
        }
        if (aSm == null) {
            return aG("18:00", "01:00");
        }
        String str = aSm.get("step_cache_rush_hour");
        if (StringUtils.isNull(str)) {
            return aG("18:00", "01:00");
        }
        try {
            String[] split = str.split(",");
            for (String str2 : split) {
                String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split2.length == 2 && aG(split2[0], split2[1])) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean aG(String str, String str2) {
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
