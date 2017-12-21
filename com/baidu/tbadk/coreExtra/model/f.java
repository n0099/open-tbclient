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
    private static String auk;
    private static Map<String, String> aul;
    private static boolean aum;
    private static int aun;
    private static int auo;
    private static boolean aup;
    private static String auq;
    private static Map<String, String> mDebugParamsMap;
    private static boolean aug = false;
    private static boolean auh = false;
    private static int aui = 8;
    private static int auj = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            aum = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_switch", aum);
            aun = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_type", aun);
            auo = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_number", auo);
            aup = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_moov_check", aup);
            auq = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(auq)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_debug_type", auq);
                fd(auq);
            }
            auk = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(auk)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_step_cache_strategy", auk);
                fe(auk);
            }
        }
    }

    private static void fd(String str) {
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

    private static void fe(String str) {
        if (!StringUtils.isNull(str)) {
            if (aul == null) {
                aul = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                aul.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                aul.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                aul.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                aul.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                aul.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean AD() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_switch", true) : aum;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_type", 0) : aun;
    }

    public static int AE() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_number", 5) : auo;
    }

    public static boolean AF() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_moov_check", false) : aup;
    }

    public static String AG() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_debug_type", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        fd(string);
        return string;
    }

    public static Map<String, String> AH() {
        if (!isInit) {
            AG();
        }
        return mDebugParamsMap;
    }

    public static String AI() {
        if (!isInit) {
            AG();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    private static String AJ() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_step_cache_strategy", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        fe(string);
        return string;
    }

    public static boolean AK() {
        if (!isInit) {
            AJ();
        }
        if (aul == null) {
            return false;
        }
        String str = aul.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        aug = "1".equals(str);
        return aug;
    }

    public static boolean AL() {
        if (!isInit) {
            AJ();
        }
        if (aul == null) {
            return false;
        }
        String str = aul.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        auh = "1".equals(str);
        return auh;
    }

    public static int AM() {
        if (!isInit) {
            AJ();
        }
        if (aul == null) {
            return 8;
        }
        String str = aul.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        aui = com.baidu.adp.lib.g.b.g(str, 8);
        return aui;
    }

    public static int AN() {
        if (!isInit) {
            AJ();
        }
        if (aul == null) {
            return 16;
        }
        String str = aul.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        auj = com.baidu.adp.lib.g.b.g(str, 16);
        return auj;
    }

    public static boolean AO() {
        if (!isInit) {
            AJ();
        }
        if (aul == null) {
            return ai("18:00", "01:00");
        }
        String str = aul.get("step_cache_rush_hour");
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
