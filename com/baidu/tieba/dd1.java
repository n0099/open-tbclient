package com.baidu.tieba;

import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
/* loaded from: classes5.dex */
public class dd1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static InetAddress a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            InetAddress inetAddress = null;
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                if (networkInterfaces == null) {
                    return null;
                }
                InetAddress inetAddress2 = null;
                do {
                    try {
                        if (networkInterfaces.hasMoreElements()) {
                            Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                            while (true) {
                                if (inetAddresses.hasMoreElements()) {
                                    InetAddress nextElement = inetAddresses.nextElement();
                                    try {
                                        if (!nextElement.isLoopbackAddress() && !nextElement.getHostAddress().contains(":")) {
                                            inetAddress2 = nextElement;
                                            continue;
                                            break;
                                        }
                                        inetAddress2 = null;
                                    } catch (Exception unused) {
                                        return nextElement;
                                    }
                                }
                            }
                        } else {
                            return inetAddress2;
                        }
                    } catch (Exception unused2) {
                        inetAddress = inetAddress2;
                        return inetAddress;
                    }
                } while (inetAddress2 == null);
                return inetAddress2;
            } catch (Exception unused3) {
            }
        } else {
            return (InetAddress) invokeV.objValue;
        }
    }

    public static String d() {
        InterceptResult invokeV;
        byte[] hardwareAddress;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            try {
                NetworkInterface byName = NetworkInterface.getByName("wlan0");
                if (byName != null && (hardwareAddress = ApiReplaceUtil.getHardwareAddress(byName)) != null) {
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            } catch (Exception unused) {
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        byte[] hardwareAddress;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                InetAddress a = a();
                if (a == null || (hardwareAddress = ApiReplaceUtil.getHardwareAddress(NetworkInterface.getByInetAddress(a))) == null) {
                    return "";
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < hardwareAddress.length; i++) {
                    if (i != 0) {
                        sb.append(':');
                    }
                    String hexString = Integer.toHexString(hardwareAddress[i] & 255);
                    if (hexString.length() == 1) {
                        hexString = 0 + hexString;
                    }
                    sb.append(hexString);
                }
                return sb.toString();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return ApiReplaceUtil.getMacAddress(((WifiManager) od1.a().getApplicationContext().getSystemService("wifi")).getConnectionInfo());
        }
        return (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        String d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (Build.VERSION.SDK_INT < 23) {
                d = b();
            } else {
                d = d();
            }
            if (!f(d)) {
                d = e();
            }
            if (!TextUtils.isEmpty(d)) {
                return d.toUpperCase();
            }
            return d;
        }
        return (String) invokeV.objValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && !str.equals(Config.DEF_MAC_ID)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
