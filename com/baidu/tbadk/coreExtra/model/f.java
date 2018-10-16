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
    private static String aNq;
    private static Map<String, String> aNr;
    private static boolean aNs;
    private static int aNt;
    private static int aNu;
    private static boolean aNv;
    private static String aNw;
    private static int aNx;
    private static int aNy;
    private static boolean aNz;
    private static Map<String, String> mDebugParamsMap;
    private static boolean aNm = false;
    private static boolean aNn = false;
    private static int aNo = 8;
    private static int aNp = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            aNs = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_switch", aNs);
            aNt = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_type", aNt);
            aNu = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_number", aNu);
            aNx = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_prepare_max_wait_time", aNx);
            aNy = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_prepare_max_loading_time", aNy);
            aNz = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_is_open_prepare_time", aNz);
            aNv = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_moov_check", aNv);
            aNw = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(aNw)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_debug_type", aNw);
                gD(aNw);
            }
            aNq = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(aNq)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_step_cache_strategy", aNq);
                gE(aNq);
            }
        }
    }

    private static void gD(String str) {
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

    private static void gE(String str) {
        if (!StringUtils.isNull(str)) {
            if (aNr == null) {
                aNr = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                aNr.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                aNr.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                aNr.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                aNr.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                aNr.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean Iv() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_switch", true) : aNs;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_type", 0) : aNt;
    }

    public static int Iw() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_number", 5) : aNu;
    }

    public static boolean Ix() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_moov_check", false) : aNv;
    }

    public static String Iy() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_debug_type", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        gD(string);
        return string;
    }

    public static Map<String, String> Iz() {
        if (!isInit) {
            Iy();
        }
        return mDebugParamsMap;
    }

    public static String IA() {
        if (!isInit) {
            Iy();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int IB() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_prepare_max_wait_time", 10000) : aNx;
    }

    public static int IC() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_prepare_max_loading_time", 3000) : aNy;
    }

    public static boolean ID() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_is_open_prepare_time", false) : aNz;
    }

    private static String IE() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_step_cache_strategy", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        gE(string);
        return string;
    }

    public static boolean IF() {
        if (!isInit) {
            IE();
        }
        if (aNr == null) {
            return false;
        }
        String str = aNr.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        aNm = "1".equals(str);
        return aNm;
    }

    public static boolean IG() {
        if (!isInit) {
            IE();
        }
        if (aNr == null) {
            return false;
        }
        String str = aNr.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        aNn = "1".equals(str);
        return aNn;
    }

    public static int IH() {
        if (!isInit) {
            IE();
        }
        if (aNr == null) {
            return 8;
        }
        String str = aNr.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        aNo = com.baidu.adp.lib.g.b.l(str, 8);
        return aNo;
    }

    public static int II() {
        if (!isInit) {
            IE();
        }
        if (aNr == null) {
            return 16;
        }
        String str = aNr.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        aNp = com.baidu.adp.lib.g.b.l(str, 16);
        return aNp;
    }

    public static boolean IJ() {
        if (!isInit) {
            IE();
        }
        if (aNr == null) {
            return aC("18:00", "01:00");
        }
        String str = aNr.get("step_cache_rush_hour");
        if (StringUtils.isNull(str)) {
            return aC("18:00", "01:00");
        }
        try {
            String[] split = str.split(",");
            for (String str2 : split) {
                String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split2.length == 2 && aC(split2[0], split2[1])) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean aC(String str, String str2) {
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
