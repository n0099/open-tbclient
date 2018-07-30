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
    private static String aFB;
    private static Map<String, String> aFC;
    private static boolean aFD;
    private static int aFE;
    private static int aFF;
    private static boolean aFG;
    private static String aFH;
    private static int aFI;
    private static int aFJ;
    private static boolean aFK;
    private static Map<String, String> mDebugParamsMap;
    private static boolean aFx = false;
    private static boolean aFy = false;
    private static int aFz = 8;
    private static int aFA = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            aFD = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_switch", aFD);
            aFE = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_type", aFE);
            aFF = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_number", aFF);
            aFI = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_prepare_max_wait_time", aFI);
            aFJ = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_prepare_max_loading_time", aFJ);
            aFK = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_is_open_prepare_time", aFK);
            aFG = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_moov_check", aFG);
            aFH = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(aFH)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_debug_type", aFH);
                fS(aFH);
            }
            aFB = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(aFB)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_step_cache_strategy", aFB);
                fT(aFB);
            }
        }
    }

    private static void fS(String str) {
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

    private static void fT(String str) {
        if (!StringUtils.isNull(str)) {
            if (aFC == null) {
                aFC = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                aFC.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                aFC.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                aFC.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                aFC.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                aFC.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean Fe() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_switch", true) : aFD;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_type", 0) : aFE;
    }

    public static int Ff() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_number", 5) : aFF;
    }

    public static boolean Fg() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_moov_check", false) : aFG;
    }

    public static String Fh() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_debug_type", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        fS(string);
        return string;
    }

    public static Map<String, String> Fi() {
        if (!isInit) {
            Fh();
        }
        return mDebugParamsMap;
    }

    public static String Fj() {
        if (!isInit) {
            Fh();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int Fk() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_prepare_max_wait_time", 10000) : aFI;
    }

    public static int Fl() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_prepare_max_loading_time", 3000) : aFJ;
    }

    public static boolean Fm() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_is_open_prepare_time", false) : aFK;
    }

    private static String Fn() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_step_cache_strategy", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        fT(string);
        return string;
    }

    public static boolean Fo() {
        if (!isInit) {
            Fn();
        }
        if (aFC == null) {
            return false;
        }
        String str = aFC.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        aFx = "1".equals(str);
        return aFx;
    }

    public static boolean Fp() {
        if (!isInit) {
            Fn();
        }
        if (aFC == null) {
            return false;
        }
        String str = aFC.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        aFy = "1".equals(str);
        return aFy;
    }

    public static int Fq() {
        if (!isInit) {
            Fn();
        }
        if (aFC == null) {
            return 8;
        }
        String str = aFC.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        aFz = com.baidu.adp.lib.g.b.g(str, 8);
        return aFz;
    }

    public static int Fr() {
        if (!isInit) {
            Fn();
        }
        if (aFC == null) {
            return 16;
        }
        String str = aFC.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        aFA = com.baidu.adp.lib.g.b.g(str, 16);
        return aFA;
    }

    public static boolean Fs() {
        if (!isInit) {
            Fn();
        }
        if (aFC == null) {
            return ak("18:00", "01:00");
        }
        String str = aFC.get("step_cache_rush_hour");
        if (StringUtils.isNull(str)) {
            return ak("18:00", "01:00");
        }
        try {
            String[] split = str.split(",");
            for (String str2 : split) {
                String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split2.length == 2 && ak(split2[0], split2[1])) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean ak(String str, String str2) {
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
