package com.baidu.tbadk.n;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static String bduss;
    private static boolean cwM = false;
    private static String stoken;
    private static String tbs;

    public static void fr(boolean z) {
        cwM = z;
    }

    public static boolean isLogin() {
        return cwM;
    }

    public static void qz(String str) {
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

    public static boolean cE(Context context) {
        if (!cwM) {
            cD(context);
        }
        return cwM;
    }

    public static void cD(Context context) {
        if (context != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(context, true)));
        }
    }
}
