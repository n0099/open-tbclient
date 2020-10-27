package com.baidu.tbadk.mutiprocess;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes.dex */
public class f {
    private static String bduss;
    private static boolean fnx = false;
    private static String stoken;
    private static String tbs;

    public static void kh(boolean z) {
        fnx = z;
    }

    public static boolean isLogin() {
        return fnx;
    }

    public static void setBduss(String str) {
        bduss = str;
    }

    public static String getBduss() {
        return bduss;
    }

    public static void setStoken(String str) {
        stoken = str;
    }

    public static String getStoken() {
        return stoken;
    }

    public static void setTbs(String str) {
        tbs = str;
    }

    public static String getTbs() {
        return tbs;
    }

    public static boolean checkUpIsLogin(Context context) {
        if (!fnx) {
            skipToLoginActivity(context);
        }
        return fnx;
    }

    public static void skipToLoginActivity(Context context) {
        if (context != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(context, true)));
        }
    }
}
