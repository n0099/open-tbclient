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
    private static String eel;
    private static Map<String, String> eem;
    private static boolean een;
    private static int eeo;
    private static int eep;
    private static boolean eeq;
    private static String eer;
    private static int ees;
    private static int eet;
    private static boolean eeu;
    private static Map<String, String> mDebugParamsMap;
    private static boolean eeh = false;
    private static boolean eei = false;
    private static int eej = 8;
    private static int eek = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            een = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, een);
            eeo = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.aTX().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, eeo);
            eep = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.aTX().putInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, eep);
            ees = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.aTX().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, ees);
            eet = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.aTX().putInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, eet);
            eeu = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, eeu);
            eeq = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, eeq);
            eer = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(eer)) {
                com.baidu.tbadk.core.sharedPref.b.aTX().putString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, eer);
                xr(eer);
            }
            eel = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(eel)) {
                com.baidu.tbadk.core.sharedPref.b.aTX().putString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, eel);
                xs(eel);
            }
        }
    }

    private static void xr(String str) {
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

    private static void xs(String str) {
        if (!StringUtils.isNull(str)) {
            if (eem == null) {
                eem = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                eem.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                eem.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                eem.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                eem.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                eem.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean baH() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_SWITCH, true) : een;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aTX().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_TYPE, 0) : eeo;
    }

    public static int baI() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aTX().getInt(SharedPrefConfig.KEY_REPORT_PLAY_UPLOAD_NUMBER, 5) : eep;
    }

    public static boolean baJ() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.KEY_REPORT_PLAY_MOOV_CHECK, false) : eeq;
    }

    public static String baK() {
        String string = com.baidu.tbadk.core.sharedPref.b.aTX().getString(SharedPrefConfig.KEY_REPORT_PLAY_DEBUG_TYPE, "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        xr(string);
        return string;
    }

    public static Map<String, String> baL() {
        if (!isInit) {
            baK();
        }
        return mDebugParamsMap;
    }

    public static String baM() {
        if (!isInit) {
            baK();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int baN() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aTX().getInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_WAIT_TIME, 10000) : ees;
    }

    public static int baO() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aTX().getInt(SharedPrefConfig.KEY_REPORT_PREPARE_MAX_LOADING_TIME, 3000) : eet;
    }

    public static boolean baP() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.KEY_REPORT_IS_OPEN_PREPARE_TIME, false) : eeu;
    }

    private static String baQ() {
        String string = com.baidu.tbadk.core.sharedPref.b.aTX().getString(SharedPrefConfig.KEY_STEP_CHACHE_STRATEGY, "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        xs(string);
        return string;
    }

    public static boolean baR() {
        if (!isInit) {
            baQ();
        }
        if (eem == null) {
            return false;
        }
        String str = eem.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        eeh = "1".equals(str);
        return eeh;
    }

    public static boolean baS() {
        if (!isInit) {
            baQ();
        }
        if (eem == null) {
            return false;
        }
        String str = eem.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        eei = "1".equals(str);
        return eei;
    }

    public static int baT() {
        if (!isInit) {
            baQ();
        }
        if (eem == null) {
            return 8;
        }
        String str = eem.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        eej = com.baidu.adp.lib.f.b.toInt(str, 8);
        return eej;
    }

    public static int baU() {
        if (!isInit) {
            baQ();
        }
        if (eem == null) {
            return 16;
        }
        String str = eem.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        eek = com.baidu.adp.lib.f.b.toInt(str, 16);
        return eek;
    }

    public static boolean baV() {
        if (!isInit) {
            baQ();
        }
        if (eem == null) {
            return dm("18:00", "01:00");
        }
        String str = eem.get("step_cache_rush_hour");
        if (StringUtils.isNull(str)) {
            return dm("18:00", "01:00");
        }
        try {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (String str2 : split) {
                String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split2.length == 2 && dm(split2[0], split2[1])) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean dm(String str, String str2) {
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
