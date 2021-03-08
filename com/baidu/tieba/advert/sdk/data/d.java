package com.baidu.tieba.advert.sdk.data;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes7.dex */
public class d {
    public static String getImei(Context context) {
        String str;
        try {
            str = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            Log.i(BdStatsConstant.StatsType.ERROR, e.getMessage());
            str = "";
        }
        if (str == null || str.equals("")) {
            return Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
        return str;
    }

    public static String getPhoneModel() {
        return Build.MODEL;
    }

    public static String bMH() {
        return Build.VERSION.RELEASE;
    }

    public static Integer fF(Context context) {
        return Integer.valueOf(context.getResources().getDisplayMetrics().heightPixels);
    }

    public static Integer fG(Context context) {
        return Integer.valueOf(context.getResources().getDisplayMetrics().widthPixels);
    }

    public static Integer fH(Context context) {
        int value;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        Integer valueOf = Integer.valueOf(WirelessNetworkType.UNKNOWN_NETWORK.getValue());
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            String typeName = activeNetworkInfo.getTypeName();
            if (typeName.equalsIgnoreCase("WIFI")) {
                return Integer.valueOf(WirelessNetworkType.WIFI.getValue());
            }
            if (typeName.equalsIgnoreCase("MOBILE")) {
                if (TextUtils.isEmpty(Proxy.getDefaultHost())) {
                    value = isFastMobileNetwork(context) ? WirelessNetworkType.MOBILE_3G.getValue() : WirelessNetworkType.MOBILE_2G.getValue();
                } else {
                    value = WirelessNetworkType.NETWORKTYPE_WAP.getValue();
                }
                return Integer.valueOf(value);
            }
            return valueOf;
        }
        return Integer.valueOf(WirelessNetworkType.UNKNOWN_NETWORK.getValue());
    }

    private static boolean isFastMobileNetwork(Context context) {
        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
            case 0:
                return false;
            case 1:
                return false;
            case 2:
                return false;
            case 3:
                return true;
            case 4:
                return false;
            case 5:
                return true;
            case 6:
                return true;
            case 7:
                return false;
            case 8:
                return true;
            case 9:
                return true;
            case 10:
                return true;
            case 11:
                return false;
            case 12:
                return true;
            case 13:
                return true;
            case 14:
                return true;
            case 15:
                return true;
            default:
                return false;
        }
    }
}
