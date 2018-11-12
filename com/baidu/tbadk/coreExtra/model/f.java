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
    private static String aOg;
    private static Map<String, String> aOh;
    private static boolean aOi;
    private static int aOj;
    private static int aOk;
    private static boolean aOl;
    private static String aOm;
    private static int aOn;
    private static int aOo;
    private static boolean aOp;
    private static Map<String, String> mDebugParamsMap;
    private static boolean aOc = false;
    private static boolean aOd = false;
    private static int aOe = 8;
    private static int aOf = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            aOi = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_switch", aOi);
            aOj = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_type", aOj);
            aOk = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_number", aOk);
            aOn = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_prepare_max_wait_time", aOn);
            aOo = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_prepare_max_loading_time", aOo);
            aOp = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_is_open_prepare_time", aOp);
            aOl = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_moov_check", aOl);
            aOm = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(aOm)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_debug_type", aOm);
                gE(aOm);
            }
            aOg = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(aOg)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_step_cache_strategy", aOg);
                gF(aOg);
            }
        }
    }

    private static void gE(String str) {
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

    private static void gF(String str) {
        if (!StringUtils.isNull(str)) {
            if (aOh == null) {
                aOh = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                aOh.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                aOh.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                aOh.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                aOh.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                aOh.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean IH() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_switch", true) : aOi;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_type", 0) : aOj;
    }

    public static int II() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_number", 5) : aOk;
    }

    public static boolean IJ() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_moov_check", false) : aOl;
    }

    public static String IK() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_debug_type", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        gE(string);
        return string;
    }

    public static Map<String, String> IL() {
        if (!isInit) {
            IK();
        }
        return mDebugParamsMap;
    }

    public static String IM() {
        if (!isInit) {
            IK();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int IN() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_prepare_max_wait_time", 10000) : aOn;
    }

    public static int IO() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_prepare_max_loading_time", 3000) : aOo;
    }

    public static boolean IP() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_is_open_prepare_time", false) : aOp;
    }

    private static String IQ() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_step_cache_strategy", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        gF(string);
        return string;
    }

    public static boolean IR() {
        if (!isInit) {
            IQ();
        }
        if (aOh == null) {
            return false;
        }
        String str = aOh.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        aOc = "1".equals(str);
        return aOc;
    }

    public static boolean IS() {
        if (!isInit) {
            IQ();
        }
        if (aOh == null) {
            return false;
        }
        String str = aOh.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        aOd = "1".equals(str);
        return aOd;
    }

    public static int IT() {
        if (!isInit) {
            IQ();
        }
        if (aOh == null) {
            return 8;
        }
        String str = aOh.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        aOe = com.baidu.adp.lib.g.b.l(str, 8);
        return aOe;
    }

    public static int IU() {
        if (!isInit) {
            IQ();
        }
        if (aOh == null) {
            return 16;
        }
        String str = aOh.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        aOf = com.baidu.adp.lib.g.b.l(str, 16);
        return aOf;
    }

    public static boolean IV() {
        if (!isInit) {
            IQ();
        }
        if (aOh == null) {
            return aC("18:00", "01:00");
        }
        String str = aOh.get("step_cache_rush_hour");
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
