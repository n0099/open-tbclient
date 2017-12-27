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
    private static String bin;
    private static Map<String, String> bio;
    private static boolean bip;
    private static int biq;
    private static int bir;
    private static boolean bis;
    private static String bit;
    private static int biu;
    private static int biv;
    private static boolean biw;
    private static Map<String, String> mDebugParamsMap;
    private static boolean bij = false;
    private static boolean bik = false;
    private static int bil = 8;
    private static int bim = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            bip = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_switch", bip);
            biq = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_type", biq);
            bir = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_number", bir);
            biu = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_prepare_max_wait_time", biu);
            biv = jSONObject.optInt("prepare_max_loading_time", PushConstants.WORK_RECEIVER_EVENTCORE_ERROR);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_prepare_max_loading_time", biv);
            biw = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_is_open_prepare_time", biw);
            bis = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_moov_check", bis);
            bit = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(bit)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_debug_type", bit);
                fk(bit);
            }
            bin = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(bin)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_step_cache_strategy", bin);
                fl(bin);
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
            if (bio == null) {
                bio = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                bio.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                bio.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                bio.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                bio.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                bio.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean Ic() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_switch", true) : bip;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_type", 0) : biq;
    }

    public static int Id() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_number", 5) : bir;
    }

    public static boolean Ie() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_moov_check", false) : bis;
    }

    public static String If() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_debug_type", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        fk(string);
        return string;
    }

    public static Map<String, String> Ig() {
        if (!isInit) {
            If();
        }
        return mDebugParamsMap;
    }

    public static String Ih() {
        if (!isInit) {
            If();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int Ii() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_prepare_max_wait_time", 10000) : biu;
    }

    public static int Ij() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_prepare_max_loading_time", PushConstants.WORK_RECEIVER_EVENTCORE_ERROR) : biv;
    }

    public static boolean Ik() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_is_open_prepare_time", false) : biw;
    }

    private static String Il() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_step_cache_strategy", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        fl(string);
        return string;
    }

    public static boolean Im() {
        if (!isInit) {
            Il();
        }
        if (bio == null) {
            return false;
        }
        String str = bio.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        bij = "1".equals(str);
        return bij;
    }

    public static boolean In() {
        if (!isInit) {
            Il();
        }
        if (bio == null) {
            return false;
        }
        String str = bio.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        bik = "1".equals(str);
        return bik;
    }

    public static int Io() {
        if (!isInit) {
            Il();
        }
        if (bio == null) {
            return 8;
        }
        String str = bio.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        bil = com.baidu.adp.lib.g.b.h(str, 8);
        return bil;
    }

    public static int Ip() {
        if (!isInit) {
            Il();
        }
        if (bio == null) {
            return 16;
        }
        String str = bio.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        bim = com.baidu.adp.lib.g.b.h(str, 16);
        return bim;
    }

    public static boolean Iq() {
        if (!isInit) {
            Il();
        }
        if (bio == null) {
            return ah("18:00", "01:00");
        }
        String str = bio.get("step_cache_rush_hour");
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
