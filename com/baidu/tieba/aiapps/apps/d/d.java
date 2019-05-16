package com.baidu.tieba.aiapps.apps.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes4.dex */
public class d {
    public static String dbv = "https://mbd.baidu.com";

    public static String aDT() {
        return String.format("%s/ma/invoice/create", dbv);
    }

    public static String aDU() {
        return String.format("%s/ma/invoice/list", dbv);
    }

    public static String aDV() {
        return String.format("%s/ma/invoice/oa_list", dbv);
    }

    public static String aDW() {
        return String.format("%s/ma/invoice/modify", dbv);
    }

    public static String aDX() {
        return String.format("%s/ma/invoice/modify_default", dbv);
    }

    public static String aDY() {
        return String.format("%s/ma/invoice/del", dbv);
    }

    public static String aDZ() {
        return String.format("%s/ma/address", dbv);
    }

    public static String sH(String str) {
        String m21do = m21do(aEd());
        String m21do2 = m21do(getUid());
        return B(B(B(B(B(B(B(B(str, "uid", m21do2), "ua", m21do(VC())), "ut", m21do), "osbranch", aEb()), "pkgname", mL()), "network", aEa()), "appname", getAppName()), "cfrom", aEh());
    }

    public static String aEa() {
        return aEj() + "_" + aEi();
    }

    public static String aEb() {
        return "a0";
    }

    public static String getUid() {
        return com.baidu.swan.apps.u.a.DG().bd(AppRuntime.getAppContext());
    }

    public static String VC() {
        Context appContext = AppRuntime.getAppContext();
        int displayWidth = z.getDisplayWidth(appContext);
        int displayHeight = z.getDisplayHeight(appContext);
        int bU = z.bU(appContext);
        String aEc = aEc();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(displayWidth);
        stringBuffer.append("_");
        stringBuffer.append(displayHeight);
        stringBuffer.append("_");
        stringBuffer.append(aEc);
        stringBuffer.append("_");
        stringBuffer.append(ac.getVersionName());
        stringBuffer.append("_");
        stringBuffer.append(bU);
        return stringBuffer.toString();
    }

    public static String aEc() {
        return "android";
    }

    public static String mL() {
        return AppRuntime.getApplication().getPackageName();
    }

    public static String aEd() {
        String aEg = aEg();
        String aEf = aEf();
        int i = Build.VERSION.SDK_INT;
        return aEg + "_" + aEf + "_" + i + "_" + aEe();
    }

    public static String aEe() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return "NUL";
        }
        return str.replace("_", Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }

    public static String aEf() {
        String str = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(str)) {
            return "0.0";
        }
        return str.replace("_", Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }

    public static String aEg() {
        String str = Build.MODEL;
        if (TextUtils.isEmpty(str)) {
            return "NUL";
        }
        return str.replace("_", Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }

    public static String B(String str, String str2, String str3) {
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

    /* renamed from: do  reason: not valid java name */
    public static String m21do(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }

    private static String getAppName() {
        return com.baidu.swan.apps.u.a.DN().getHostName();
    }

    private static String aEh() {
        return com.baidu.swan.c.c.XF();
    }

    private static int aEi() {
        NetworkInfo activeNetworkInfo = SwanAppNetworkUtils.getActiveNetworkInfo(com.baidu.swan.apps.u.a.DB());
        if (activeNetworkInfo == null) {
            return 0;
        }
        return activeNetworkInfo.getSubtype();
    }

    private static int aEj() {
        NetworkInfo networkInfo;
        String str = null;
        try {
            networkInfo = ((ConnectivityManager) com.baidu.swan.apps.u.a.DB().getSystemService("connectivity")).getActiveNetworkInfo();
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
