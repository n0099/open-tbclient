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
    private static String caQ;
    private static Map<String, String> caR;
    private static boolean caS;
    private static int caT;
    private static int caU;
    private static boolean caV;
    private static String caW;
    private static int caX;
    private static int caY;
    private static boolean caZ;
    private static Map<String, String> mDebugParamsMap;
    private static boolean caM = false;
    private static boolean caN = false;
    private static int caO = 8;
    private static int caP = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            caS = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_switch", caS);
            caT = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_type", caT);
            caU = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_number", caU);
            caX = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_prepare_max_wait_time", caX);
            caY = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_prepare_max_loading_time", caY);
            caZ = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_is_open_prepare_time", caZ);
            caV = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_moov_check", caV);
            caW = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(caW)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_debug_type", caW);
                nW(caW);
            }
            caQ = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(caQ)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_step_cache_strategy", caQ);
                nX(caQ);
            }
        }
    }

    private static void nW(String str) {
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

    private static void nX(String str) {
        if (!StringUtils.isNull(str)) {
            if (caR == null) {
                caR = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                caR.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                caR.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                caR.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                caR.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                caR.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean ajz() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_switch", true) : caS;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_type", 0) : caT;
    }

    public static int ajA() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_number", 5) : caU;
    }

    public static boolean ajB() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_moov_check", false) : caV;
    }

    public static String ajC() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_debug_type", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        nW(string);
        return string;
    }

    public static Map<String, String> ajD() {
        if (!isInit) {
            ajC();
        }
        return mDebugParamsMap;
    }

    public static String ajE() {
        if (!isInit) {
            ajC();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int ajF() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_prepare_max_wait_time", 10000) : caX;
    }

    public static int ajG() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_prepare_max_loading_time", 3000) : caY;
    }

    public static boolean ajH() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_is_open_prepare_time", false) : caZ;
    }

    private static String ajI() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_step_cache_strategy", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        nX(string);
        return string;
    }

    public static boolean ajJ() {
        if (!isInit) {
            ajI();
        }
        if (caR == null) {
            return false;
        }
        String str = caR.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        caM = "1".equals(str);
        return caM;
    }

    public static boolean ajK() {
        if (!isInit) {
            ajI();
        }
        if (caR == null) {
            return false;
        }
        String str = caR.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        caN = "1".equals(str);
        return caN;
    }

    public static int ajL() {
        if (!isInit) {
            ajI();
        }
        if (caR == null) {
            return 8;
        }
        String str = caR.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        caO = com.baidu.adp.lib.g.b.l(str, 8);
        return caO;
    }

    public static int ajM() {
        if (!isInit) {
            ajI();
        }
        if (caR == null) {
            return 16;
        }
        String str = caR.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        caP = com.baidu.adp.lib.g.b.l(str, 16);
        return caP;
    }

    public static boolean ajN() {
        if (!isInit) {
            ajI();
        }
        if (caR == null) {
            return bP("18:00", "01:00");
        }
        String str = caR.get("step_cache_rush_hour");
        if (StringUtils.isNull(str)) {
            return bP("18:00", "01:00");
        }
        try {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (String str2 : split) {
                String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split2.length == 2 && bP(split2[0], split2[1])) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean bP(String str, String str2) {
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
