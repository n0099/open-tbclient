package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.lib.util.StringUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
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
    private static String biE;
    private static Map<String, String> biF;
    private static boolean biG;
    private static int biH;
    private static int biI;
    private static boolean biJ;
    private static String biK;
    private static int biL;
    private static int biM;
    private static boolean biN;
    private static Map<String, String> mDebugParamsMap;
    private static boolean biA = false;
    private static boolean biB = false;
    private static int biC = 8;
    private static int biD = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            biG = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_switch", biG);
            biH = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_type", biH);
            biI = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_number", biI);
            biL = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_prepare_max_wait_time", biL);
            biM = jSONObject.optInt("prepare_max_loading_time", PushConstants.WORK_RECEIVER_EVENTCORE_ERROR);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_prepare_max_loading_time", biM);
            biN = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_is_open_prepare_time", biN);
            biJ = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_moov_check", biJ);
            biK = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(biK)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_debug_type", biK);
                fk(biK);
            }
            biE = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(biE)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_step_cache_strategy", biE);
                fl(biE);
            }
        }
    }

    private static void fk(String str) {
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

    private static void fl(String str) {
        if (!StringUtils.isNull(str)) {
            if (biF == null) {
                biF = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                biF.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                biF.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                biF.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                biF.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                biF.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean HV() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_switch", true) : biG;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_type", 0) : biH;
    }

    public static int HW() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_number", 5) : biI;
    }

    public static boolean HX() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_moov_check", false) : biJ;
    }

    public static String HY() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_debug_type", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        fk(string);
        return string;
    }

    public static Map<String, String> HZ() {
        if (!isInit) {
            HY();
        }
        return mDebugParamsMap;
    }

    public static String Ia() {
        if (!isInit) {
            HY();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int Ib() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_prepare_max_wait_time", 10000) : biL;
    }

    public static int Ic() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_prepare_max_loading_time", PushConstants.WORK_RECEIVER_EVENTCORE_ERROR) : biM;
    }

    public static boolean Id() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_is_open_prepare_time", false) : biN;
    }

    private static String Ie() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_step_cache_strategy", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        fl(string);
        return string;
    }

    public static boolean If() {
        if (!isInit) {
            Ie();
        }
        if (biF == null) {
            return false;
        }
        String str = biF.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        biA = "1".equals(str);
        return biA;
    }

    public static boolean Ig() {
        if (!isInit) {
            Ie();
        }
        if (biF == null) {
            return false;
        }
        String str = biF.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        biB = "1".equals(str);
        return biB;
    }

    public static int Ih() {
        if (!isInit) {
            Ie();
        }
        if (biF == null) {
            return 8;
        }
        String str = biF.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        biC = com.baidu.adp.lib.g.b.h(str, 8);
        return biC;
    }

    public static int Ii() {
        if (!isInit) {
            Ie();
        }
        if (biF == null) {
            return 16;
        }
        String str = biF.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        biD = com.baidu.adp.lib.g.b.h(str, 16);
        return biD;
    }

    public static boolean Ij() {
        if (!isInit) {
            Ie();
        }
        if (biF == null) {
            return ah("18:00", "01:00");
        }
        String str = biF.get("step_cache_rush_hour");
        if (StringUtils.isNull(str)) {
            return ah("18:00", "01:00");
        }
        try {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (String str2 : split) {
                String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split2.length == 2 && ah(split2[0], split2[1])) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean ah(String str, String str2) {
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
