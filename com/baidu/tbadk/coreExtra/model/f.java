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
    private static String dPR;
    private static Map<String, String> dPS;
    private static boolean dPT;
    private static int dPU;
    private static int dPV;
    private static boolean dPW;
    private static String dPX;
    private static int dPY;
    private static int dPZ;
    private static boolean dQa;
    private static Map<String, String> mDebugParamsMap;
    private static boolean dPN = false;
    private static boolean dPO = false;
    private static int dPP = 8;
    private static int dPQ = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            dPT = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, dPT);
            dPU = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.aNT().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, dPU);
            dPV = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.aNT().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, dPV);
            dPY = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.aNT().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, dPY);
            dPZ = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.aNT().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, dPZ);
            dQa = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, dQa);
            dPW = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, dPW);
            dPX = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(dPX)) {
                com.baidu.tbadk.core.sharedPref.b.aNT().putString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, dPX);
                vL(dPX);
            }
            dPR = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(dPR)) {
                com.baidu.tbadk.core.sharedPref.b.aNT().putString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, dPR);
                vM(dPR);
            }
        }
    }

    private static void vL(String str) {
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

    private static void vM(String str) {
        if (!StringUtils.isNull(str)) {
            if (dPS == null) {
                dPS = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                dPS.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                dPS.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                dPS.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                dPS.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                dPS.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean aUx() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, true) : dPT;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aNT().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, 0) : dPU;
    }

    public static int aUy() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aNT().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, 5) : dPV;
    }

    public static boolean aUz() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, false) : dPW;
    }

    public static String aUA() {
        String string = com.baidu.tbadk.core.sharedPref.b.aNT().getString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        vL(string);
        return string;
    }

    public static Map<String, String> aUB() {
        if (!isInit) {
            aUA();
        }
        return mDebugParamsMap;
    }

    public static String aUC() {
        if (!isInit) {
            aUA();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int aUD() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aNT().getInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, 10000) : dPY;
    }

    public static int aUE() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aNT().getInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, 3000) : dPZ;
    }

    public static boolean aUF() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, false) : dQa;
    }

    private static String aUG() {
        String string = com.baidu.tbadk.core.sharedPref.b.aNT().getString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        vM(string);
        return string;
    }

    public static boolean aUH() {
        if (!isInit) {
            aUG();
        }
        if (dPS == null) {
            return false;
        }
        String str = dPS.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        dPN = "1".equals(str);
        return dPN;
    }

    public static boolean aUI() {
        if (!isInit) {
            aUG();
        }
        if (dPS == null) {
            return false;
        }
        String str = dPS.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        dPO = "1".equals(str);
        return dPO;
    }

    public static int aUJ() {
        if (!isInit) {
            aUG();
        }
        if (dPS == null) {
            return 8;
        }
        String str = dPS.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        dPP = com.baidu.adp.lib.f.b.toInt(str, 8);
        return dPP;
    }

    public static int aUK() {
        if (!isInit) {
            aUG();
        }
        if (dPS == null) {
            return 16;
        }
        String str = dPS.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        dPQ = com.baidu.adp.lib.f.b.toInt(str, 16);
        return dPQ;
    }

    public static boolean aUL() {
        if (!isInit) {
            aUG();
        }
        if (dPS == null) {
            return cN("18:00", "01:00");
        }
        String str = dPS.get("step_cache_rush_hour");
        if (StringUtils.isNull(str)) {
            return cN("18:00", "01:00");
        }
        try {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (String str2 : split) {
                String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split2.length == 2 && cN(split2[0], split2[1])) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean cN(String str, String str2) {
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
