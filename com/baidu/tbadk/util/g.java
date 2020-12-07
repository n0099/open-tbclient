package com.baidu.tbadk.util;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.net.NetworkInterface;
import java.util.Enumeration;
/* loaded from: classes.dex */
public class g {
    private g() {
    }

    public static g bGp() {
        return a.fFv;
    }

    /* loaded from: classes.dex */
    private static class a {
        private static g fFv = new g();
    }

    public String getLocalMacAddress(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        try {
            if (Build.VERSION.SDK_INT < 23) {
                WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo == null) {
                    return null;
                }
                return connectionInfo.getMacAddress();
            }
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                byte[] hardwareAddress = nextElement.getHardwareAddress();
                if (hardwareAddress != null && hardwareAddress.length != 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        stringBuffer.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                    }
                    if (stringBuffer.length() > 0) {
                        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                    }
                    str = stringBuffer.toString();
                    if ("wlan0".equals(nextElement.getName())) {
                        return str;
                    }
                }
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String bGq() {
        return Build.VERSION.RELEASE;
    }

    public String bGr() {
        return Build.MODEL;
    }

    public String bGs() {
        return Build.DEVICE;
    }

    public String getDeviceBrand() {
        return Build.BRAND;
    }

    @RequiresApi(api = 17)
    public String fe(Context context) {
        return String.valueOf(getDisplayMetrics(context).widthPixels);
    }

    @RequiresApi(api = 17)
    public String ff(Context context) {
        return String.valueOf(getDisplayMetrics(context).heightPixels);
    }

    @RequiresApi(api = 17)
    public String fg(Context context) {
        return String.valueOf(getDisplayMetrics(context).density);
    }

    @RequiresApi(api = 17)
    public String fh(Context context) {
        return fe(context) + "*" + ff(context);
    }

    @RequiresApi(api = 17)
    private DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context == null) {
            return displayMetrics;
        }
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics;
    }
}
