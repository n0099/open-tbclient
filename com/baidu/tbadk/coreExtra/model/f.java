package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
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
    private static String cxi;
    private static Map<String, String> cxj;
    private static boolean cxk;
    private static int cxl;
    private static int cxm;
    private static boolean cxn;
    private static String cxo;
    private static int cxp;
    private static int cxq;
    private static boolean cxr;
    private static Map<String, String> mDebugParamsMap;
    private static boolean cxe = false;
    private static boolean cxf = false;
    private static int cxg = 8;
    private static int cxh = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            cxk = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, cxk);
            cxl = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.alP().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, cxl);
            cxm = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.alP().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, cxm);
            cxp = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.alP().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, cxp);
            cxq = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.alP().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, cxq);
            cxr = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, cxr);
            cxn = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, cxn);
            cxo = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(cxo)) {
                com.baidu.tbadk.core.sharedPref.b.alP().putString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, cxo);
                oT(cxo);
            }
            cxi = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(cxi)) {
                com.baidu.tbadk.core.sharedPref.b.alP().putString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, cxi);
                oU(cxi);
            }
        }
    }

    private static void oT(String str) {
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

    private static void oU(String str) {
        if (!StringUtils.isNull(str)) {
            if (cxj == null) {
                cxj = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                cxj.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                cxj.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                cxj.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                cxj.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                cxj.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean arI() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, true) : cxk;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.alP().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, 0) : cxl;
    }

    public static int arJ() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.alP().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, 5) : cxm;
    }

    public static boolean arK() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, false) : cxn;
    }

    public static String arL() {
        String string = com.baidu.tbadk.core.sharedPref.b.alP().getString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        oT(string);
        return string;
    }

    public static Map<String, String> arM() {
        if (!isInit) {
            arL();
        }
        return mDebugParamsMap;
    }

    public static String arN() {
        if (!isInit) {
            arL();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int arO() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.alP().getInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, 10000) : cxp;
    }

    public static int arP() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.alP().getInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, 3000) : cxq;
    }

    public static boolean arQ() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, false) : cxr;
    }

    private static String arR() {
        String string = com.baidu.tbadk.core.sharedPref.b.alP().getString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        oU(string);
        return string;
    }

    public static boolean arS() {
        if (!isInit) {
            arR();
        }
        if (cxj == null) {
            return false;
        }
        String str = cxj.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        cxe = "1".equals(str);
        return cxe;
    }

    public static boolean arT() {
        if (!isInit) {
            arR();
        }
        if (cxj == null) {
            return false;
        }
        String str = cxj.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        cxf = "1".equals(str);
        return cxf;
    }

    public static int arU() {
        if (!isInit) {
            arR();
        }
        if (cxj == null) {
            return 8;
        }
        String str = cxj.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        cxg = com.baidu.adp.lib.g.b.toInt(str, 8);
        return cxg;
    }

    public static int arV() {
        if (!isInit) {
            arR();
        }
        if (cxj == null) {
            return 16;
        }
        String str = cxj.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        cxh = com.baidu.adp.lib.g.b.toInt(str, 16);
        return cxh;
    }

    public static boolean arW() {
        if (!isInit) {
            arR();
        }
        if (cxj == null) {
            return bX("18:00", "01:00");
        }
        String str = cxj.get("step_cache_rush_hour");
        if (StringUtils.isNull(str)) {
            return bX("18:00", "01:00");
        }
        try {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (String str2 : split) {
                String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split2.length == 2 && bX(split2[0], split2[1])) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean bX(String str, String str2) {
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
