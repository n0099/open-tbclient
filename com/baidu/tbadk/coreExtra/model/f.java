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
    private static String ciR;
    private static Map<String, String> ciS;
    private static boolean ciT;
    private static int ciU;
    private static int ciV;
    private static boolean ciW;
    private static String ciX;
    private static int ciY;
    private static int ciZ;
    private static boolean cja;
    private static Map<String, String> mDebugParamsMap;
    private static boolean ciN = false;
    private static boolean ciO = false;
    private static int ciP = 8;
    private static int ciQ = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            ciT = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("video_report_config_switch", ciT);
            ciU = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.agM().putInt("video_report_config_upload_type", ciU);
            ciV = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.agM().putInt("video_report_config_upload_number", ciV);
            ciY = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.agM().putInt("video_report_prepare_max_wait_time", ciY);
            ciZ = jSONObject.optInt("prepare_max_loading_time", 3000);
            com.baidu.tbadk.core.sharedPref.b.agM().putInt("video_report_prepare_max_loading_time", ciZ);
            cja = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("video_report_is_open_prepare_time", cja);
            ciW = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("video_report_config_moov_check", ciW);
            ciX = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(ciX)) {
                com.baidu.tbadk.core.sharedPref.b.agM().putString("video_report_config_debug_type", ciX);
                ph(ciX);
            }
            ciR = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(ciR)) {
                com.baidu.tbadk.core.sharedPref.b.agM().putString("video_report_config_step_cache_strategy", ciR);
                pi(ciR);
            }
        }
    }

    private static void ph(String str) {
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

    private static void pi(String str) {
        if (!StringUtils.isNull(str)) {
            if (ciS == null) {
                ciS = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                ciS.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                ciS.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                ciS.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                ciS.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                ciS.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean aow() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("video_report_config_switch", true) : ciT;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.agM().getInt("video_report_config_upload_type", 0) : ciU;
    }

    public static int aox() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.agM().getInt("video_report_config_upload_number", 5) : ciV;
    }

    public static boolean aoy() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("video_report_config_moov_check", false) : ciW;
    }

    public static String aoz() {
        String string = com.baidu.tbadk.core.sharedPref.b.agM().getString("video_report_config_debug_type", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        ph(string);
        return string;
    }

    public static Map<String, String> aoA() {
        if (!isInit) {
            aoz();
        }
        return mDebugParamsMap;
    }

    public static String aoB() {
        if (!isInit) {
            aoz();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int aoC() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.agM().getInt("video_report_prepare_max_wait_time", 10000) : ciY;
    }

    public static int aoD() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.agM().getInt("video_report_prepare_max_loading_time", 3000) : ciZ;
    }

    public static boolean aoE() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("video_report_is_open_prepare_time", false) : cja;
    }

    private static String aoF() {
        String string = com.baidu.tbadk.core.sharedPref.b.agM().getString("video_report_config_step_cache_strategy", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        pi(string);
        return string;
    }

    public static boolean aoG() {
        if (!isInit) {
            aoF();
        }
        if (ciS == null) {
            return false;
        }
        String str = ciS.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        ciN = "1".equals(str);
        return ciN;
    }

    public static boolean aoH() {
        if (!isInit) {
            aoF();
        }
        if (ciS == null) {
            return false;
        }
        String str = ciS.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        ciO = "1".equals(str);
        return ciO;
    }

    public static int aoI() {
        if (!isInit) {
            aoF();
        }
        if (ciS == null) {
            return 8;
        }
        String str = ciS.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        ciP = com.baidu.adp.lib.g.b.f(str, 8);
        return ciP;
    }

    public static int aoJ() {
        if (!isInit) {
            aoF();
        }
        if (ciS == null) {
            return 16;
        }
        String str = ciS.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        ciQ = com.baidu.adp.lib.g.b.f(str, 16);
        return ciQ;
    }

    public static boolean aoK() {
        if (!isInit) {
            aoF();
        }
        if (ciS == null) {
            return bZ("18:00", "01:00");
        }
        String str = ciS.get("step_cache_rush_hour");
        if (StringUtils.isNull(str)) {
            return bZ("18:00", "01:00");
        }
        try {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (String str2 : split) {
                String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split2.length == 2 && bZ(split2[0], split2[1])) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean bZ(String str, String str2) {
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
