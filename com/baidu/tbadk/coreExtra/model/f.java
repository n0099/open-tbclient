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
    private static String bkR;
    private static Map<String, String> bkS;
    private static boolean bkT;
    private static int bkU;
    private static int bkV;
    private static boolean bkW;
    private static String bkX;
    private static int bkY;
    private static int bkZ;
    private static boolean bla;
    private static Map<String, String> mDebugParamsMap;
    private static boolean bkN = false;
    private static boolean bkO = false;
    private static int bkP = 8;
    private static int bkQ = 16;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            isInit = true;
            bkT = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_switch", bkT);
            bkU = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_type", bkU);
            bkV = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_number", bkV);
            bkY = jSONObject.optInt("prepare_max_wait_time", 10000);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_prepare_max_wait_time", bkY);
            bkZ = jSONObject.optInt("prepare_max_loading_time", PushConstants.WORK_RECEIVER_EVENTCORE_ERROR);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_prepare_max_loading_time", bkZ);
            bla = jSONObject.optInt("is_open_prepare_time", 0) == 1;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_is_open_prepare_time", bla);
            bkW = jSONObject.optInt("moov_check", 0) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_moov_check", bkW);
            bkX = jSONObject.optString("android_debug_type");
            if (!StringUtils.isNull(bkX)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_debug_type", bkX);
                fB(bkX);
            }
            bkR = jSONObject.optString("step_cache_strategy");
            if (!StringUtils.isNull(bkR)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_report_config_step_cache_strategy", bkR);
                fC(bkR);
            }
        }
    }

    private static void fB(String str) {
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

    private static void fC(String str) {
        if (!StringUtils.isNull(str)) {
            if (bkS == null) {
                bkS = new HashMap();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                bkS.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
                bkS.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
                bkS.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
                bkS.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
                bkS.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean ID() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_switch", true) : bkT;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_type", 0) : bkU;
    }

    public static int IE() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_number", 5) : bkV;
    }

    public static boolean IF() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_moov_check", false) : bkW;
    }

    public static String IG() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_debug_type", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        fB(string);
        return string;
    }

    public static Map<String, String> IH() {
        if (!isInit) {
            IG();
        }
        return mDebugParamsMap;
    }

    public static String II() {
        if (!isInit) {
            IG();
        }
        return mDebugParamsMap == null ? "0" : mDebugParamsMap.get("debug_avformat_open_input");
    }

    public static int IJ() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_prepare_max_wait_time", 10000) : bkY;
    }

    public static int IK() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_prepare_max_loading_time", PushConstants.WORK_RECEIVER_EVENTCORE_ERROR) : bkZ;
    }

    public static boolean IL() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_is_open_prepare_time", false) : bla;
    }

    private static String IM() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_report_config_step_cache_strategy", "");
        if (StringUtils.isNull(string)) {
            return "";
        }
        fC(string);
        return string;
    }

    public static boolean IN() {
        if (!isInit) {
            IM();
        }
        if (bkS == null) {
            return false;
        }
        String str = bkS.get("step_cache_force_use_proxy");
        if (StringUtils.isNull(str)) {
            return false;
        }
        bkN = "1".equals(str);
        return bkN;
    }

    public static boolean IO() {
        if (!isInit) {
            IM();
        }
        if (bkS == null) {
            return false;
        }
        String str = bkS.get("step_cache_switch");
        if (StringUtils.isNull(str)) {
            return false;
        }
        bkO = "1".equals(str);
        return bkO;
    }

    public static int IP() {
        if (!isInit) {
            IM();
        }
        if (bkS == null) {
            return 8;
        }
        String str = bkS.get("step_cache_rush_hour_cache_duration");
        if (StringUtils.isNull(str)) {
            return 8;
        }
        bkP = com.baidu.adp.lib.g.b.h(str, 8);
        return bkP;
    }

    public static int IQ() {
        if (!isInit) {
            IM();
        }
        if (bkS == null) {
            return 16;
        }
        String str = bkS.get("step_cache_normol_cache_duration");
        if (StringUtils.isNull(str)) {
            return 16;
        }
        bkQ = com.baidu.adp.lib.g.b.h(str, 16);
        return bkQ;
    }

    public static boolean IR() {
        if (!isInit) {
            IM();
        }
        if (bkS == null) {
            return ah("18:00", "01:00");
        }
        String str = bkS.get("step_cache_rush_hour");
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
