package com.baidu.tieba.aiapps.apps.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.common.util.CommonParam;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.util.IoUtils;
import com.baidu.fsg.base.statistics.j;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.core.container.init.NgWebViewInitHelper;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes4.dex */
public class c {
    public static String getHost() {
        return "https://mbd.baidu.com";
    }

    public static String f(String str, Map<String, String> map) {
        String kc = kc(str);
        if (map == null) {
            return kc;
        }
        Iterator<String> it = map.keySet().iterator();
        while (true) {
            String str2 = kc;
            if (it.hasNext()) {
                String next = it.next();
                kc = !TextUtils.isEmpty(map.get(next)) ? addParam(str2, next, map.get(next)) : str2;
            } else {
                return str2;
            }
        }
    }

    public static String kc(String str) {
        String encodeValue = getEncodeValue(getDeviceInfo());
        String encodeValue2 = getEncodeValue(getUid());
        return addParam(addParam(addParam(addParam(addParam(addParam(addParam(str, "uid", encodeValue2), j.c, getEncodeValue(WT())), "ut", encodeValue), "osbranch", WS()), "pkgname", nK()), "network", WR()), "appname", getAppName());
    }

    public static String WR() {
        return Xg() + BaseRequestAction.SPLITE + Xf();
    }

    public static String WS() {
        return "a0";
    }

    public static String getUid() {
        return CommonParam.getCUID(TbadkCoreApplication.getInst());
    }

    public static String WT() {
        Context appContext = AppRuntime.getAppContext();
        int displayWidth = AiAppsUIUtils.getDisplayWidth(appContext);
        int displayHeight = AiAppsUIUtils.getDisplayHeight(appContext);
        int densityDpi = AiAppsUIUtils.getDensityDpi(appContext);
        String WU = WU();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(displayWidth);
        stringBuffer.append(BaseRequestAction.SPLITE);
        stringBuffer.append(displayHeight);
        stringBuffer.append(BaseRequestAction.SPLITE);
        stringBuffer.append(WU);
        stringBuffer.append(BaseRequestAction.SPLITE);
        stringBuffer.append(TbadkCoreApplication.getInst().getVersionName());
        stringBuffer.append(BaseRequestAction.SPLITE);
        stringBuffer.append(densityDpi);
        return stringBuffer.toString();
    }

    public static String WU() {
        return HttpConstants.OS_TYPE_VALUE;
    }

    public static String nK() {
        return AppRuntime.getApplication().getPackageName();
    }

    public static String getDeviceInfo() {
        String WX = WX();
        String WW = WW();
        int i = Build.VERSION.SDK_INT;
        return WX + BaseRequestAction.SPLITE + WW + BaseRequestAction.SPLITE + i + BaseRequestAction.SPLITE + WV();
    }

    public static String WV() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return "NUL";
        }
        return str.replace(BaseRequestAction.SPLITE, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }

    public static String WW() {
        String str = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(str)) {
            return "0.0";
        }
        return str.replace(BaseRequestAction.SPLITE, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }

    public static String WX() {
        String str = Build.MODEL;
        if (TextUtils.isEmpty(str)) {
            return "NUL";
        }
        return str.replace(BaseRequestAction.SPLITE, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }

    public static String addParam(String str, String str2, String str3) {
        StringBuilder sb;
        StringBuilder sb2;
        String str4 = null;
        if (!TextUtils.isEmpty(str)) {
            String str5 = str2 + ETAG.EQUAL;
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
            } else if (str.indexOf(ETAG.ITEM_SEPARATOR + str5, indexOf) < 0 && str.indexOf("?" + str5, indexOf) < 0) {
                int indexOf3 = str.indexOf("#");
                if (indexOf3 < 0) {
                    sb = new StringBuilder(str);
                } else {
                    str4 = str.substring(indexOf3);
                    str = str.substring(0, indexOf3);
                    sb = new StringBuilder(str);
                }
                if (!str.endsWith(ETAG.ITEM_SEPARATOR) && !str.endsWith("?")) {
                    sb.append(ETAG.ITEM_SEPARATOR);
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

    public static String getEncodeValue(String str) {
        try {
            return URLEncoder.encode(str, IoUtils.UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String WY() {
        return String.format("%s/ma/address", getHost());
    }

    public static String WZ() {
        return String.format("%s/ma/invoice/modify", getHost());
    }

    public static String Xa() {
        return String.format("%s/ma/invoice/modify_default", getHost());
    }

    public static String Xb() {
        return String.format("%s/ma/invoice/del", getHost());
    }

    public static String Xc() {
        return String.format("%s/ma/invoice/list", getHost());
    }

    public static String Xd() {
        return String.format("%s/ma/invoice/oa_list", getHost());
    }

    public static String Xe() {
        return String.format("%s/ma/invoice/create", getHost());
    }

    private static String getAppName() {
        return NgWebViewInitHelper.INIT_BWEBKIT_APPID;
    }

    private static int Xf() {
        return com.baidu.adp.lib.util.j.kR();
    }

    private static int Xg() {
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
