package com.baidu.tieba;

import android.net.wifi.WifiConfiguration;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class ae3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(WifiConfiguration wifiConfiguration) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, wifiConfiguration)) == null) {
            if (wifiConfiguration == null) {
                return -1;
            }
            if (wifiConfiguration.allowedKeyManagement.get(1)) {
                return 2;
            }
            if (wifiConfiguration.allowedKeyManagement.get(2) || wifiConfiguration.allowedKeyManagement.get(3)) {
                return 3;
            }
            if (wifiConfiguration.wepKeys[0] != null) {
                return 1;
            }
            return wifiConfiguration.allowedKeyManagement.get(0) ? 0 : -1;
        }
        return invokeL.intValue;
    }

    public static int b(wd3 wd3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, wd3Var)) == null) {
            if (wd3Var == null) {
                return -1;
            }
            if (TextUtils.isEmpty(wd3Var.c) && TextUtils.isEmpty(wd3Var.d)) {
                return 0;
            }
            if (TextUtils.isEmpty(wd3Var.c) || TextUtils.isEmpty(wd3Var.d)) {
                return !TextUtils.isEmpty(wd3Var.d) ? 2 : -1;
            }
            return 3;
        }
        return invokeL.intValue;
    }

    public static int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            if (str.contains("WEP")) {
                return 1;
            }
            if (str.contains("PSK")) {
                return 2;
            }
            return str.contains("EAP") ? 3 : -1;
        }
        return invokeL.intValue;
    }

    public static void d(WifiConfiguration wifiConfiguration, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65539, null, wifiConfiguration, i) == null) || wifiConfiguration == null) {
            return;
        }
        wifiConfiguration.allowedKeyManagement.clear();
        wifiConfiguration.allowedProtocols.clear();
        wifiConfiguration.allowedAuthAlgorithms.clear();
        wifiConfiguration.allowedPairwiseCiphers.clear();
        wifiConfiguration.allowedGroupCiphers.clear();
        if (i == 0) {
            wifiConfiguration.allowedKeyManagement.set(0);
        } else if (i == 1) {
            wifiConfiguration.allowedKeyManagement.set(0);
            wifiConfiguration.allowedAuthAlgorithms.set(0);
            wifiConfiguration.allowedAuthAlgorithms.set(1);
        } else if (i == 2) {
            wifiConfiguration.allowedKeyManagement.set(1);
        } else if (i != 3) {
        } else {
            wifiConfiguration.allowedKeyManagement.set(2);
            wifiConfiguration.allowedKeyManagement.set(3);
        }
    }
}
