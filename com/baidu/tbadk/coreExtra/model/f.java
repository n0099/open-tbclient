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
    private static String cjX;
    private static Map<String, String> cjY;
    private static boolean cjZ;
    private static int cka;
    private static int ckb;
    private static boolean ckc;
    private static String ckd;
    private static int cke;
    private static int ckf;
    private static boolean ckg;
    private static Map<String, String> mDebugParamsMap;
    private static boolean cjT = false;
    private static boolean cjU = false;
    private static int cjV = 8;
    private static int cjW = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            cjZ = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("video_report_config_switch", cjZ);
            cka = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.ahO().putInt("video_report_config_upload_type", cka);
            ckb = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.ahO().putInt("video_report_config_upload_number", ckb);
            cke = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.ahO().putInt("video_report_prepare_max_wait_time", cke);
            ckf = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.ahO().putInt("video_report_prepare_max_loading_time", ckf);
            ckg = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("video_report_is_open_prepare_time", ckg);
            ckc = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("video_report_config_moov_check", ckc);
            ckd = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(ckd)) {
                com.baidu.tbadk.core.sharedPref.b.ahO().putString("video_report_config_debug_type", ckd);
                px(ckd);
            }
            cjX = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(cjX)) {
                com.baidu.tbadk.core.sharedPref.b.ahO().putString("video_report_config_step_cache_strategy", cjX);
                py(cjX);
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
            if (cjY == null) {
                cjY = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                cjY.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                cjY.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                cjY.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                cjY.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                cjY.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean apC() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("video_report_config_switch", true) : cjZ;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.ahO().getInt("video_report_config_upload_type", 0) : cka;
    }

    public static int apD() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.ahO().getInt("video_report_config_upload_number", 5) : ckb;
    }

    public static boolean apE() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("video_report_config_moov_check", false) : ckc;
    }

    public static String apF() {
        String string = com.baidu.tbadk.core.sharedPref.b.ahO().getString("video_report_config_debug_type", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        px(string);
        return string;
    }

    public static Map<String, String> apG() {
        if (!isInit) {
            apF();
        }
        return mDebugParamsMap;
    }

    public static String apH() {
        if (!isInit) {
            apF();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int apI() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.ahO().getInt("video_report_prepare_max_wait_time", 10000) : cke;
    }

    public static int apJ() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.ahO().getInt("video_report_prepare_max_loading_time", 3000) : ckf;
    }

    public static boolean apK() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("video_report_is_open_prepare_time", false) : ckg;
    }

    private static String apL() {
        String string = com.baidu.tbadk.core.sharedPref.b.ahO().getString("video_report_config_step_cache_strategy", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        py(string);
        return string;
    }

    public static boolean apM() {
        if (!isInit) {
            apL();
        }
        if (cjY == null) {
            return false;
        }
        String str = cjY.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        cjT = "1".equals(str);
        return cjT;
    }

    public static boolean apN() {
        if (!isInit) {
            apL();
        }
        if (cjY == null) {
            return false;
        }
        String str = cjY.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        cjU = "1".equals(str);
        return cjU;
    }

    public static int apO() {
        if (!isInit) {
            apL();
        }
        if (cjY == null) {
            return 8;
        }
        String str = cjY.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        cjV = com.baidu.adp.lib.g.b.f(str, 8);
        return cjV;
    }

    public static int apP() {
        if (!isInit) {
            apL();
        }
        if (cjY == null) {
            return 16;
        }
        String str = cjY.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        cjW = com.baidu.adp.lib.g.b.f(str, 16);
        return cjW;
    }

    public static boolean apQ() {
        if (!isInit) {
            apL();
        }
        if (cjY == null) {
            return ca("18:00", "01:00");
        }
        String str = cjY.get("step_cache_rush_hour");
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
