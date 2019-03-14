package com.baidu.tieba.aiapps.apps.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.android.common.util.CommonParam;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.x;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes4.dex */
public class d {
    public static String getHost() {
        return "https://mbd.baidu.com";
    }

    public static String rw(String str) {
        String dz = dz(ayN());
        String dz2 = dz(getUid());
        return z(z(z(z(z(z(z(str, "uid", dz2), "ua", dz(RQ())), "ut", dz), "osbranch", ayL()), "pkgname", nQ()), "network", ayK()), "appname", getAppName());
    }

    public static String ayK() {
        return ayZ() + "_" + ayY();
    }

    public static String ayL() {
        return "a0";
    }

    public static String getUid() {
        return CommonParam.getCUID(TbadkCoreApplication.getInst());
    }

    public static String RQ() {
        Context appContext = AppRuntime.getAppContext();
        int displayWidth = x.getDisplayWidth(appContext);
        int displayHeight = x.getDisplayHeight(appContext);
        int cr = x.cr(appContext);
        String ayM = ayM();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(displayWidth);
        stringBuffer.append("_");
        stringBuffer.append(displayHeight);
        stringBuffer.append("_");
        stringBuffer.append(ayM);
        stringBuffer.append("_");
        stringBuffer.append(TbadkCoreApplication.getInst().getVersionName());
        stringBuffer.append("_");
        stringBuffer.append(cr);
        return stringBuffer.toString();
    }

    public static String ayM() {
        return "android";
    }

    public static String nQ() {
        return AppRuntime.getApplication().getPackageName();
    }

    public static String ayN() {
        String ayQ = ayQ();
        String ayP = ayP();
        int i = Build.VERSION.SDK_INT;
        return ayQ + "_" + ayP + "_" + i + "_" + ayO();
    }

    public static String ayO() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return "NUL";
        }
        return str.replace("_", Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }

    public static String ayP() {
        String str = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(str)) {
            return "0.0";
        }
        return str.replace("_", Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }

    public static String ayQ() {
        String str = Build.MODEL;
        if (TextUtils.isEmpty(str)) {
            return "NUL";
        }
        return str.replace("_", Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }

    public static String z(String str, String str2, String str3) {
        StringBuilder sb;
        StringBuilder sb2;
        String str4 = null;
        if (!TextUtils.isEmpty(str)) {
            String str5 = str2 + "=";
            int indexOf = str.indexOf("?");
            if (indexOf < 0) {
                int indexOf2 = str.indexOf("#");
                if (indexOf2 < 0) {
                    sb2 = new StringBuilder(str);
                } else {
                    str4 = str.substring(indexOf2);
                    sb2 = new StringBuilder(str.substring(0, indexOf2));
                }
                sb2.append("?").append(str5).append(str3);
                if (str4 != null) {
                    sb2.append(str4);
                }
                return sb2.toString();
            } else if (str.indexOf("&" + str5, indexOf) < 0 && str.indexOf("?" + str5, indexOf) < 0) {
                int indexOf3 = str.indexOf("#");
                if (indexOf3 < 0) {
                    sb = new StringBuilder(str);
                } else {
                    str4 = str.substring(indexOf3);
                    str = str.substring(0, indexOf3);
                    sb = new StringBuilder(str);
                }
                if (!str.endsWith("&") && !str.endsWith("?")) {
                    sb.append("&");
                }
                sb.append(str5).append(str3);
                if (str4 != null) {
                    sb.append(str4);
                }
                return sb.toString();
            } else {
                return str;
            }
        }
        return str;
    }

    public static String dz(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String ayR() {
        return String.format("%s/ma/address", getHost());
    }

    public static String ayS() {
        return String.format("%s/ma/invoice/modify", getHost());
    }

    public static String ayT() {
        return String.format("%s/ma/invoice/modify_default", getHost());
    }

    public static String ayU() {
        return String.format("%s/ma/invoice/del", getHost());
    }

    public static String ayV() {
        return String.format("%s/ma/invoice/list", getHost());
    }

    public static String ayW() {
        return String.format("%s/ma/invoice/oa_list", getHost());
    }

    public static String ayX() {
        return String.format("%s/ma/invoice/create", getHost());
    }

    private static String getAppName() {
        return "tieba";
    }

    private static int ayY() {
        return j.kR();
    }

    private static int ayZ() {
        NetworkInfo networkInfo;
        String str = null;
        try {
            networkInfo = ((ConnectivityManager) TbadkCoreApplication.getInst().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (NullPointerException e) {
            networkInfo = null;
        }
        if (networkInfo != null) {
            if ("wifi".equals(networkInfo.getTypeName().toLowerCase())) {
                str = "WIFI";
            } else {
                str = networkInfo.getExtraInfo();
            }
        }
        if (str == null) {
            return 5;
        }
        String upperCase = str.toUpperCase();
        if ("WIFI".equals(upperCase)) {
            return 1;
        }
        if ("3GNET".equals(upperCase)) {
            return 21;
        }
        if ("3GWAP".equals(upperCase)) {
            return 22;
        }
        if ("CMNET".equals(upperCase)) {
            return 31;
        }
        if ("UNINET".equals(upperCase)) {
            return 32;
        }
        if ("CTNET".equals(upperCase)) {
            return 33;
        }
        if ("CMWAP".equals(upperCase)) {
            return 41;
        }
        if ("UNIWAP".equals(upperCase)) {
            return 42;
        }
        if (!"CTWAP".equals(upperCase)) {
            return 5;
        }
        return 43;
    }
}
