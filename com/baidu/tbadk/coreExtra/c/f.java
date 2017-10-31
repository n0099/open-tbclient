package com.baidu.tbadk.coreExtra.c;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private static boolean atx;
    private static int aty;
    private static int atz;
    private static boolean isInit = false;

    public static void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            isInit = true;
            atx = jSONObject.optInt("switch", 1) != 0;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_report_config_switch", atx);
            aty = jSONObject.optInt("upload_type", 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_type", aty);
            atz = jSONObject.optInt("upload_number", 5);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("video_report_config_upload_number", atz);
        }
    }

    public static boolean Aq() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_report_config_switch", true) : atx;
    }

    public static int getReportType() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_type", 0) : aty;
    }

    public static int Ar() {
        return !isInit ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_report_config_upload_number", 5) : atz;
    }
}
