package com.baidu.tieba.aiapps.apps.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
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
    public static String deS = "https://mbd.baidu.com";

    public static String aFS() {
        return String.format("%s/ma/invoice/create", deS);
    }

    public static String aFT() {
        return String.format("%s/ma/invoice/list", deS);
    }

    public static String aFU() {
        return String.format("%s/ma/invoice/oa_list", deS);
    }

    public static String aFV() {
        return String.format("%s/ma/invoice/modify", deS);
    }

    public static String aFW() {
        return String.format("%s/ma/invoice/modify_default", deS);
    }

    public static String aFX() {
        return String.format("%s/ma/invoice/del", deS);
    }

    public static String aFY() {
        return String.format("%s/ma/address", deS);
    }

    public static String ty(String str) {
        String du = du(aGc());
        String du2 = du(getUid());
        return B(B(B(B(B(B(B(B(str, "uid", du2), "ua", du(Wz())), "ut", du), "osbranch", aGa()), "pkgname", nb()), DpStatConstants.KEY_NETWORK, aFZ()), "appname", getAppName()), "cfrom", aGg());
    }

    public static String aFZ() {
        return aGi() + "_" + aGh();
    }

    public static String aGa() {
        return "a0";
    }

    public static String getUid() {
        return com.baidu.swan.apps.u.a.Et().bd(AppRuntime.getAppContext());
    }

    public static String Wz() {
        Context appContext = AppRuntime.getAppContext();
        int displayWidth = z.getDisplayWidth(appContext);
        int displayHeight = z.getDisplayHeight(appContext);
        int bU = z.bU(appContext);
        String aGb = aGb();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(displayWidth);
        stringBuffer.append("_");
        stringBuffer.append(displayHeight);
        stringBuffer.append("_");
        stringBuffer.append(aGb);
        stringBuffer.append("_");
        stringBuffer.append(ac.getVersionName());
        stringBuffer.append("_");
        stringBuffer.append(bU);
        return stringBuffer.toString();
    }

    public static String aGb() {
        return "android";
    }

    public static String nb() {
        return AppRuntime.getApplication().getPackageName();
    }

    public static String aGc() {
        String aGf = aGf();
        String aGe = aGe();
        int i = Build.VERSION.SDK_INT;
        return aGf + "_" + aGe + "_" + i + "_" + aGd();
    }

    public static String aGd() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return "NUL";
        }
        return str.replace("_", Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }

    public static String aGe() {
        String str = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(str)) {
            return "0.0";
        }
        return str.replace("_", Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }

    public static String aGf() {
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

    public static String du(String str) {
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
        return com.baidu.swan.apps.u.a.EA().getHostName();
    }

    private static String aGg() {
        return com.baidu.swan.c.c.YF();
    }

    private static int aGh() {
        NetworkInfo activeNetworkInfo = SwanAppNetworkUtils.getActiveNetworkInfo(com.baidu.swan.apps.u.a.Eo());
        if (activeNetworkInfo == null) {
            return 0;
        }
        return activeNetworkInfo.getSubtype();
    }

    private static int aGi() {
        NetworkInfo networkInfo;
        String str = null;
        try {
            networkInfo = ((ConnectivityManager) com.baidu.swan.apps.u.a.Eo().getSystemService("connectivity")).getActiveNetworkInfo();
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
