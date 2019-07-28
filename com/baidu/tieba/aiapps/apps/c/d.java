package com.baidu.tieba.aiapps.apps.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes4.dex */
public class d {
    public static String dcY = "https://mbd.baidu.com";

    public static String aFm() {
        return String.format("%s/ma/invoice/create", dcY);
    }

    public static String aFn() {
        return String.format("%s/ma/invoice/list", dcY);
    }

    public static String aFo() {
        return String.format("%s/ma/invoice/oa_list", dcY);
    }

    public static String aFp() {
        return String.format("%s/ma/invoice/modify", dcY);
    }

    public static String aFq() {
        return String.format("%s/ma/invoice/modify_default", dcY);
    }

    public static String aFr() {
        return String.format("%s/ma/invoice/del", dcY);
    }

    public static String aFs() {
        return String.format("%s/ma/address", dcY);
    }

    public static String sZ(String str) {
        String ds = ds(aFw());
        String ds2 = ds(getUid());
        return B(B(B(B(B(B(B(B(str, "uid", ds2), "ua", ds(Wv())), "ut", ds), "osbranch", aFu()), "pkgname", nb()), "network", aFt()), "appname", getAppName()), "cfrom", aFA());
    }

    public static String aFt() {
        return aFC() + "_" + aFB();
    }

    public static String aFu() {
        return "a0";
    }

    public static String getUid() {
        return com.baidu.swan.apps.u.a.Ep().bd(AppRuntime.getAppContext());
    }

    public static String Wv() {
        Context appContext = AppRuntime.getAppContext();
        int displayWidth = z.getDisplayWidth(appContext);
        int displayHeight = z.getDisplayHeight(appContext);
        int bU = z.bU(appContext);
        String aFv = aFv();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(displayWidth);
        stringBuffer.append("_");
        stringBuffer.append(displayHeight);
        stringBuffer.append("_");
        stringBuffer.append(aFv);
        stringBuffer.append("_");
        stringBuffer.append(ac.getVersionName());
        stringBuffer.append("_");
        stringBuffer.append(bU);
        return stringBuffer.toString();
    }

    public static String aFv() {
        return "android";
    }

    public static String nb() {
        return AppRuntime.getApplication().getPackageName();
    }

    public static String aFw() {
        String aFz = aFz();
        String aFy = aFy();
        int i = Build.VERSION.SDK_INT;
        return aFz + "_" + aFy + "_" + i + "_" + aFx();
    }

    public static String aFx() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return "NUL";
        }
        return str.replace("_", Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }

    public static String aFy() {
        String str = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(str)) {
            return "0.0";
        }
        return str.replace("_", Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }

    public static String aFz() {
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

    public static String ds(String str) {
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
        return com.baidu.swan.apps.u.a.Ew().getHostName();
    }

    private static String aFA() {
        return com.baidu.swan.c.c.YB();
    }

    private static int aFB() {
        NetworkInfo activeNetworkInfo = SwanAppNetworkUtils.getActiveNetworkInfo(com.baidu.swan.apps.u.a.Ek());
        if (activeNetworkInfo == null) {
            return 0;
        }
        return activeNetworkInfo.getSubtype();
    }

    private static int aFC() {
        NetworkInfo networkInfo;
        String str = null;
        try {
            networkInfo = ((ConnectivityManager) com.baidu.swan.apps.u.a.Ek().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (NullPointerException e) {
            networkInfo = null;
        }
        if (networkInfo != null) {
            if (IXAdSystemUtils.NT_WIFI.equals(networkInfo.getTypeName().toLowerCase())) {
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
