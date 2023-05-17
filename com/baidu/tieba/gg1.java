package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final class gg1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return h() + "/cps/user/recordBatch/sapp";
        }
        return (String) invokeV.objValue;
    }

    public static final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return h() + "/cashier/calcMoney";
        }
        return (String) invokeV.objValue;
    }

    public static final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return h() + "/cashier/channelAllInfo";
        }
        return (String) invokeV.objValue;
    }

    public static final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return h() + "/cashier/order/orderInfo";
        }
        return (String) invokeV.objValue;
    }

    public static final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return h() + "/cps/user/record/sapp";
        }
        return (String) invokeV.objValue;
    }

    public static final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return h() + "/cashier/drmb/drmbPay";
        }
        return (String) invokeV.objValue;
    }

    public static final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (dg1.a() != 1) {
                return "https://trade.baidu-int.com/sandbox/tradegateway";
            }
            return "https://etrade-api.baidu.com";
        }
        return (String) invokeV.objValue;
    }

    public static final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return h() + "/cashier/launchpayment";
        }
        return (String) invokeV.objValue;
    }

    public static final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return h() + "/cashier/pay";
        }
        return (String) invokeV.objValue;
    }

    public static final String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return h() + "/cashier/sdkAdaptH5QueryPay";
        }
        return (String) invokeV.objValue;
    }

    public static final String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            return h() + "/cashier/drmb/reqCode";
        }
        return (String) invokeV.objValue;
    }

    public static final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (dg1.a() != 2) {
                return h() + "/cashier/innerChannelAllInfo";
            }
            return h() + "/cashier/innerChannelAllInfo";
        }
        return (String) invokeV.objValue;
    }

    public static final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (dg1.a() != 1) {
                return h() + "/cashier/agreement/judgeGuideSign";
            }
            return h() + "/cashier/agreement/judgeGuideSign";
        }
        return (String) invokeV.objValue;
    }

    public static final String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (dg1.a() != 1) {
                return h() + "/cashier/agreement/guideApplySign";
            }
            return h() + "/cashier/agreement/guideApplySign";
        }
        return (String) invokeV.objValue;
    }
}
