package com.baidu.tieba.aiapps.apps.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes4.dex */
public class d {
    public static String don = "https://mbd.baidu.com";

    public static String aGf() {
        return String.format("%s/ma/invoice/create", don);
    }

    public static String aGg() {
        return String.format("%s/ma/invoice/list", don);
    }

    public static String aGh() {
        return String.format("%s/ma/invoice/oa_list", don);
    }

    public static String aGi() {
        return String.format("%s/ma/invoice/modify", don);
    }

    public static String aGj() {
        return String.format("%s/ma/invoice/modify_default", don);
    }

    public static String aGk() {
        return String.format("%s/ma/invoice/del", don);
    }

    public static String aGl() {
        return String.format("%s/ma/address", don);
    }

    public static String sh(String str) {
        String ed = ed(aGp());
        String ed2 = ed(getUid());
        return F(F(F(F(F(F(F(F(str, "uid", ed2), "ua", ed(abo())), "ut", ed), "osbranch", aGn()), "pkgname", getPkgName()), "network", aGm()), "appname", getAppName()), BdStatsConstant.StatsKey.CURRENT_CHANNEL, aGt());
    }

    public static String aGm() {
        return aGv() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + aGu();
    }

    public static String aGn() {
        return "a0";
    }

    public static String getUid() {
        return com.baidu.swan.apps.u.a.Jn().bf(AppRuntime.getAppContext());
    }

    public static String abo() {
        Context appContext = AppRuntime.getAppContext();
        int displayWidth = z.getDisplayWidth(appContext);
        int displayHeight = z.getDisplayHeight(appContext);
        int bU = z.bU(appContext);
        String aGo = aGo();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(displayWidth);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(displayHeight);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(aGo);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(ac.getVersionName());
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(bU);
        return stringBuffer.toString();
    }

    public static String aGo() {
        return "android";
    }

    public static String getPkgName() {
        return AppRuntime.getApplication().getPackageName();
    }

    public static String aGp() {
        String aGs = aGs();
        String aGr = aGr();
        int i = Build.VERSION.SDK_INT;
        return aGs + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + aGr + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + aGq();
    }

    public static String aGq() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return "NUL";
        }
        return str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }

    public static String aGr() {
        String str = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(str)) {
            return "0.0";
        }
        return str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }

    public static String aGs() {
        String str = Build.MODEL;
        if (TextUtils.isEmpty(str)) {
            return "NUL";
        }
        return str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }

    public static String F(String str, String str2, String str3) {
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

    public static String ed(String str) {
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
        return com.baidu.swan.apps.u.a.Ju().getHostName();
    }

    private static String aGt() {
        return com.baidu.swan.c.c.adu();
    }

    private static int aGu() {
        NetworkInfo activeNetworkInfo = SwanAppNetworkUtils.getActiveNetworkInfo(com.baidu.swan.apps.u.a.Ji());
        if (activeNetworkInfo == null) {
            return 0;
        }
        return activeNetworkInfo.getSubtype();
    }

    private static int aGv() {
        NetworkInfo networkInfo;
        String str = null;
        try {
            networkInfo = ((ConnectivityManager) com.baidu.swan.apps.u.a.Ji().getSystemService("connectivity")).getActiveNetworkInfo();
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
