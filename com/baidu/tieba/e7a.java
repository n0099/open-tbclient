package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.YYPayUIKit;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes3.dex */
public class e7a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, int i, int i2, PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), payFlowType}) == null) {
            YYPayUIKit uIKit = YYPayUIKit.getUIKit(i, i2);
            boolean z = false;
            if (uIKit == null) {
                RLog.error("ViewLifecycleHandler", "notifyPayFlowWork error payUIKit null", new Object[0]);
                return;
            }
            c6a viewLifecycle = uIKit.getViewLifecycle();
            if (viewLifecycle != null) {
                z = true;
            }
            RLog.info("ViewLifecycleHandler", "notifyPayActivityDestory  payFlowType:" + payFlowType + " shouldNotify:" + z);
            if (z) {
                viewLifecycle.d(str, payFlowType);
            }
        }
    }

    public static void b(String str, int i, int i2, PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), payFlowType}) == null) {
            YYPayUIKit uIKit = YYPayUIKit.getUIKit(i, i2);
            boolean z = false;
            if (uIKit == null) {
                RLog.error("ViewLifecycleHandler", "notifyPayFlowWork error payUIKit null", new Object[0]);
                return;
            }
            c6a viewLifecycle = uIKit.getViewLifecycle();
            if (viewLifecycle != null) {
                z = true;
            }
            RLog.info("ViewLifecycleHandler", "notifyPayActivityVisit  payFlowType:" + payFlowType + " shouldNotify:" + z);
            if (z) {
                viewLifecycle.c(str, payFlowType);
            }
        }
    }

    public static void c(int i, int i2, PayFlowType payFlowType, PayDialogType payDialogType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), payFlowType, payDialogType}) == null) {
            YYPayUIKit uIKit = YYPayUIKit.getUIKit(i, i2);
            boolean z = false;
            if (uIKit == null) {
                RLog.error("ViewLifecycleHandler", "notifyPayDialogTypeChange error payUIKit null", new Object[0]);
                return;
            }
            c6a viewLifecycle = uIKit.getViewLifecycle();
            if (viewLifecycle != null) {
                z = true;
            }
            RLog.info("ViewLifecycleHandler", "notifyPayDialogTypeChange mPayFlowType:" + payFlowType + " shouldNotify:" + z);
            if (z) {
                viewLifecycle.b(payFlowType, payDialogType);
            }
        }
    }

    public static void d(int i, int i2, PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65539, null, i, i2, payFlowType) == null) {
            YYPayUIKit uIKit = YYPayUIKit.getUIKit(i, i2);
            boolean z = false;
            if (uIKit == null) {
                RLog.error("ViewLifecycleHandler", "notifyPayFlowWork error payUIKit null", new Object[0]);
                return;
            }
            c6a viewLifecycle = uIKit.getViewLifecycle();
            if (viewLifecycle != null) {
                z = true;
            }
            RLog.info("ViewLifecycleHandler", "notifyPayFlowWork mPayFlowType:" + payFlowType + " shouldNotify:" + z);
            if (z) {
                viewLifecycle.a(payFlowType);
            }
        }
    }
}
