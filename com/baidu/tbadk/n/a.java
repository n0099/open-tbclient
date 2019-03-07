package com.baidu.tbadk.n;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static String bduss;
    private static boolean coB = false;
    private static String stoken;
    private static String tbs;

    public static void eV(boolean z) {
        coB = z;
    }

    public static boolean isLogin() {
        return coB;
    }

    public static void pr(String str) {
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

    public static boolean cZ(Context context) {
        if (!coB) {
            cY(context);
        }
        return coB;
    }

    public static void cY(Context context) {
        if (context != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(context, true)));
        }
    }
}
