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
    private static String aEH;
    private static Map<String, String> aEI;
    private static boolean aEJ;
    private static int aEK;
    private static int aEL;
    private static boolean aEM;
    private static String aEN;
    private static int aEO;
    private static int aEP;
    private static boolean aEQ;
    private static Map<String, String> mDebugParamsMap;
    private static boolean aED = false;
    private static boolean aEE = false;
    private static int aEF = 8;
    private static int aEG = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            aEJ = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_switch", aEJ);
            aEK = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_type", aEK);
            aEL = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_number", aEL);
            aEO = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_prepare_max_wait_time", aEO);
            aEP = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_prepare_max_loading_time", aEP);
            aEQ = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_is_open_prepare_time", aEQ);
            aEM = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_moov_check", aEM);
            aEN = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(aEN)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_debug_type", aEN);
                fQ(aEN);
            }
            aEH = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(aEH)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_step_cache_strategy", aEH);
                fR(aEH);
            }
        }
    }

    private static void fQ(String str) {
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

    private static void fR(String str) {
        if (!StringUtils.isNull(str)) {
            if (aEI == null) {
                aEI = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                aEI.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                aEI.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                aEI.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                aEI.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                aEI.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean EQ() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_switch", true) : aEJ;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_type", 0) : aEK;
    }

    public static int ER() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_number", 5) : aEL;
    }

    public static boolean ES() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_moov_check", false) : aEM;
    }

    public static String ET() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_debug_type", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        fQ(string);
        return string;
    }

    public static Map<String, String> EU() {
        if (!isInit) {
            ET();
        }
        return mDebugParamsMap;
    }

    public static String EV() {
        if (!isInit) {
            ET();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int EW() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_prepare_max_wait_time", 10000) : aEO;
    }

    public static int EX() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_prepare_max_loading_time", 3000) : aEP;
    }

    public static boolean EY() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_is_open_prepare_time", false) : aEQ;
    }

    private static String EZ() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_step_cache_strategy", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        fR(string);
        return string;
    }

    public static boolean Fa() {
        if (!isInit) {
            EZ();
        }
        if (aEI == null) {
            return false;
        }
        String str = aEI.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        aED = "1".equals(str);
        return aED;
    }

    public static boolean Fb() {
        if (!isInit) {
            EZ();
        }
        if (aEI == null) {
            return false;
        }
        String str = aEI.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        aEE = "1".equals(str);
        return aEE;
    }

    public static int Fc() {
        if (!isInit) {
            EZ();
        }
        if (aEI == null) {
            return 8;
        }
        String str = aEI.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        aEF = com.baidu.adp.lib.g.b.g(str, 8);
        return aEF;
    }

    public static int Fd() {
        if (!isInit) {
            EZ();
        }
        if (aEI == null) {
            return 16;
        }
        String str = aEI.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        aEG = com.baidu.adp.lib.g.b.g(str, 16);
        return aEG;
    }

    public static boolean Fe() {
        if (!isInit) {
            EZ();
        }
        if (aEI == null) {
            return am("18:00", "01:00");
        }
        String str = aEI.get("step_cache_rush_hour");
        if (StringUtils.isNull(str)) {
            return am("18:00", "01:00");
        }
        try {
            String[] split = str.split(",");
            for (String str2 : split) {
                String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split2.length == 2 && am(split2[0], split2[1])) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean am(String str, String str2) {
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
