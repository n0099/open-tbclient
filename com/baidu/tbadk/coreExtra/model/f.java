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
    private static String caS;
    private static Map<String, String> caT;
    private static boolean caU;
    private static int caV;
    private static int caW;
    private static boolean caX;
    private static String caY;
    private static int caZ;
    private static int cba;
    private static boolean cbb;
    private static Map<String, String> mDebugParamsMap;
    private static boolean caO = false;
    private static boolean caP = false;
    private static int caQ = 8;
    private static int caR = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            caU = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_switch", caU);
            caV = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_type", caV);
            caW = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_number", caW);
            caZ = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_prepare_max_wait_time", caZ);
            cba = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_prepare_max_loading_time", cba);
            cbb = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_is_open_prepare_time", cbb);
            caX = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_moov_check", caX);
            caY = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(caY)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_debug_type", caY);
                nX(caY);
            }
            caS = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(caS)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_step_cache_strategy", caS);
                nY(caS);
            }
        }
    }

    private static void nX(String str) {
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

    private static void nY(String str) {
        if (!StringUtils.isNull(str)) {
            if (caT == null) {
                caT = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                caT.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                caT.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                caT.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                caT.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                caT.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean ajv() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_switch", true) : caU;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_type", 0) : caV;
    }

    public static int ajw() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_number", 5) : caW;
    }

    public static boolean ajx() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_moov_check", false) : caX;
    }

    public static String ajy() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_debug_type", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        nX(string);
        return string;
    }

    public static Map<String, String> ajz() {
        if (!isInit) {
            ajy();
        }
        return mDebugParamsMap;
    }

    public static String ajA() {
        if (!isInit) {
            ajy();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int ajB() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_prepare_max_wait_time", 10000) : caZ;
    }

    public static int ajC() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_prepare_max_loading_time", 3000) : cba;
    }

    public static boolean ajD() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_is_open_prepare_time", false) : cbb;
    }

    private static String ajE() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_step_cache_strategy", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        nY(string);
        return string;
    }

    public static boolean ajF() {
        if (!isInit) {
            ajE();
        }
        if (caT == null) {
            return false;
        }
        String str = caT.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        caO = "1".equals(str);
        return caO;
    }

    public static boolean ajG() {
        if (!isInit) {
            ajE();
        }
        if (caT == null) {
            return false;
        }
        String str = caT.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        caP = "1".equals(str);
        return caP;
    }

    public static int ajH() {
        if (!isInit) {
            ajE();
        }
        if (caT == null) {
            return 8;
        }
        String str = caT.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        caQ = com.baidu.adp.lib.g.b.l(str, 8);
        return caQ;
    }

    public static int ajI() {
        if (!isInit) {
            ajE();
        }
        if (caT == null) {
            return 16;
        }
        String str = caT.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        caR = com.baidu.adp.lib.g.b.l(str, 16);
        return caR;
    }

    public static boolean ajJ() {
        if (!isInit) {
            ajE();
        }
        if (caT == null) {
            return bP("18:00", "01:00");
        }
        String str = caT.get("step_cache_rush_hour");
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
