package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PaysSettingInfo;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.model.ThemeColorConfig;
/* loaded from: classes5.dex */
public class ewb {
    public static /* synthetic */ Interceptable $ic = null;
    public static PaysSettingInfo a = null;
    public static String b = "https://web.yy.com/yy_wallet/pay-protocol.html?";
    public static String c = "https://web.yy.com/yy_wallet/wallet.html?";
    public static String d = "https://web.yy.com/yy_wallet/pay-success.html?&orderId=${orderId}";
    public static String e = "https://web.yy.com/yy_wallet/help-faq.html?";
    public static String f = "https://web.yy.com/yy_wallet/sec_currency_charge.html?";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947750169, "Lcom/baidu/tieba/ewb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947750169, "Lcom/baidu/tieba/ewb;");
        }
    }

    public static String a(String str, PayUIKitConfig payUIKitConfig, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, str, payUIKitConfig, i)) == null) {
            if (payUIKitConfig != null && payUIKitConfig.revenueConfig != null) {
                StringBuilder sb = new StringBuilder(str);
                sb.append("&uid=" + payUIKitConfig.revenueConfig.getUid());
                sb.append("&hostId=" + payUIKitConfig.revenueConfig.getHostId());
                sb.append("&appid=" + payUIKitConfig.revenueConfig.getAppId());
                sb.append("&usedChannel=" + payUIKitConfig.revenueConfig.getUseChannel());
                sb.append("&authType=" + payUIKitConfig.revenueConfig.getAuthType());
                sb.append("&clientVersion=" + payUIKitConfig.revenueConfig.getVersion());
                sb.append("&sdkVersion=4.3.45-bdpay");
                if (i != 0) {
                    sb.append("&currencyType=" + i);
                }
                int i2 = 0;
                ThemeColorConfig themeColorConfig = payUIKitConfig.themeColorConfig;
                if (themeColorConfig != null && themeColorConfig.getThemeResId().intValue() == R.style.obfuscated_res_0x7f100167) {
                    i2 = 1;
                }
                sb.append("&theme=" + i2);
                return sb.toString();
            }
            return str;
        }
        return (String) invokeLLI.objValue;
    }

    public static String b(PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, payUIKitConfig)) == null) {
            if (payUIKitConfig != null && payUIKitConfig.revenueConfig != null) {
                return a(d, payUIKitConfig, 0);
            }
            return d;
        }
        return (String) invokeL.objValue;
    }

    public static String c(PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, payUIKitConfig)) == null) {
            if (payUIKitConfig != null && payUIKitConfig.revenueConfig != null) {
                return a(e, payUIKitConfig, 0);
            }
            return e;
        }
        return (String) invokeL.objValue;
    }

    public static String e(PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, payUIKitConfig)) == null) {
            if (payUIKitConfig != null && payUIKitConfig.revenueConfig != null) {
                return a(f, payUIKitConfig, 71);
            }
            return f;
        }
        return (String) invokeL.objValue;
    }

    public static String f(PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, payUIKitConfig)) == null) {
            if (payUIKitConfig != null && payUIKitConfig.revenueConfig != null) {
                return a(c, payUIKitConfig, 0);
            }
            return c;
        }
        return (String) invokeL.objValue;
    }

    public static String g(PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, payUIKitConfig)) == null) {
            if (payUIKitConfig == null && payUIKitConfig.revenueConfig == null) {
                return b;
            }
            return a(b, payUIKitConfig, 0);
        }
        return (String) invokeL.objValue;
    }

    public static PaysSettingInfo d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return a;
        }
        return (PaysSettingInfo) invokeV.objValue;
    }

    public static void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, null, z) == null) {
            if (z) {
                b = "https://webtest.yy.com/yy_wallet/pay-protocol.html?";
                c = "https://webtest.yy.com/yy_wallet/wallet.html?";
                d = "https://webtest.yy.com/yy_wallet/pay-success.html?&orderId=${orderId}";
                e = "https://webtest.yy.com/yy_wallet/help-faq.html?";
                f = "https://webtest.yy.com/yy_wallet/sec_currency_charge.html?";
                return;
            }
            b = "https://web.yy.com/yy_wallet/pay-protocol.html?";
            c = "https://web.yy.com/yy_wallet/wallet.html?";
            d = "https://web.yy.com/yy_wallet/pay-success.html?&orderId=${orderId}";
            e = "https://web.yy.com/yy_wallet/help-faq.html?";
            f = "https://web.yy.com/yy_wallet/sec_currency_charge.html?";
        }
    }

    public static void i(PaysSettingInfo paysSettingInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, paysSettingInfo, str) == null) {
            RLog.info("PaySettingConfig", "setPaysSettingInfo info:" + paysSettingInfo + " from:" + str);
            a = paysSettingInfo;
        }
    }
}
