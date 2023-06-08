package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagTagInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes5.dex */
public class bvb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(double d, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Double.valueOf(d), Double.valueOf(d2)})) == null) {
            RLog.info("PayAmountHelper", "countPayAmountMargin targetAmount:" + d + " accountAmount:" + d2);
            double d3 = (d - d2) / 100.0d;
            double d4 = 1.0d;
            if (d3 > 1.0d) {
                if (d3 > 1.0d && d3 <= 10.0d) {
                    d4 = Math.ceil(d3);
                } else {
                    if (d3 % 10.0d > 0.0d) {
                        d3 = (((int) (d3 / 10.0d)) + 1) * 10;
                    }
                    d4 = d3;
                }
            }
            RLog.info("PayAmountHelper", "countPayAmountMargin amountMarginCount:" + d4);
            return (int) d4;
        }
        return invokeCommon.intValue;
    }

    public static int b(List<jub> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, list, i)) == null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (list.get(i2).c() == i) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeLI.intValue;
    }

    public static jub c(List<jub> list, PayUIKitConfig payUIKitConfig, double d, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{list, payUIKitConfig, Double.valueOf(d), Double.valueOf(d2)})) == null) {
            RLog.info("PayAmountHelper", "createPayAmount targetAmount:" + d + " accountAmount:" + d2);
            if (list != null && !list.isEmpty()) {
                int a = a(d, d2);
                RLog.info("PayAmountHelper", "countPayAmountMargin amountMargin:" + a);
                int b = b(list, a);
                RLog.info("PayAmountHelper", "findPayAmountPositionFromConfigList position:" + b);
                if (b >= 0) {
                    d(list, b);
                } else {
                    f(list, payUIKitConfig, a);
                }
                return list.get(0);
            }
            return null;
        }
        return (jub) invokeCommon.objValue;
    }

    public static void d(List<jub> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, null, list, i) == null) {
            RLog.info("PayAmountHelper", "movePayAmountList position:" + i);
            RLog.debug("PayAmountHelper", "movePayAmountList configAmountList:" + list);
            if (i != 0) {
                list.add(0, list.remove(i));
            }
            if (list.get(0).a.giftBagTagInfos != null && !list.get(0).a.giftBagTagInfos.isEmpty()) {
                list.get(0).a.giftBagTagInfos.get(0).tag = "推荐";
                return;
            }
            GiftBagTagInfo giftBagTagInfo = new GiftBagTagInfo();
            giftBagTagInfo.tag = "推荐";
            list.get(0).a.giftBagTagInfos = new ArrayList();
            list.get(0).a.giftBagTagInfos.add(giftBagTagInfo);
        }
    }

    public static boolean e(jub jubVar) {
        InterceptResult invokeL;
        ProductInfo productInfo;
        List<GiftBagsInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jubVar)) == null) {
            if (jubVar != null && (productInfo = jubVar.a) != null && (list = productInfo.giftbags) != null && !list.isEmpty()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void f(List<jub> list, PayUIKitConfig payUIKitConfig, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65541, null, list, payUIKitConfig, i) == null) {
            RLog.debug("PayAmountHelper", "replacePayAmountList configAmountList:" + list);
            if (i > 500000) {
                i = 500000;
            }
            jub a = wub.a(i * 100, payUIKitConfig);
            RLog.info("PayAmountHelper", "createPayAmount customPayAmount:" + a);
            if (e(list.get(0))) {
                list.remove(list.size() - 1);
            } else if (e(list.get(list.size() - 1))) {
                list.remove(0);
            } else {
                list.remove(0);
            }
            GiftBagTagInfo giftBagTagInfo = new GiftBagTagInfo();
            giftBagTagInfo.tag = "推荐";
            a.a.giftBagTagInfos = new ArrayList();
            a.a.giftBagTagInfos.add(giftBagTagInfo);
            list.add(0, a);
        }
    }
}
