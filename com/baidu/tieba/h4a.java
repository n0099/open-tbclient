package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUIEventType;
import java.util.List;
import tv.athena.revenue.payui.model.PayFinishInfo;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes4.dex */
public class h4a implements IYYPayAmountView.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public Dialog c;
    public IYYPayAmountView.ViewParams d;
    public Activity e;
    public IPayCallback f;
    public v3a g;

    public h4a(int i, int i2, Dialog dialog, IYYPayAmountView.ViewParams viewParams, Activity activity, IPayCallback iPayCallback, v3a v3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), dialog, viewParams, activity, iPayCallback, v3aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PayAmountViewCallback", "create PayAmountViewCallback appId:" + i + " userChannel:" + i2);
        this.a = i;
        this.b = i2;
        this.c = dialog;
        this.d = viewParams;
        this.e = activity;
        this.f = iPayCallback;
        this.g = v3aVar;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
    public void onRefreshViewFail(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
            PayFinishInfo a = v5a.a(PayDialogType.PAY_AMOUNT_DIALOG, i, str);
            RLog.error("PayAmountViewCallback", "showPayAmountDialog onFail code:" + i + " failReason:" + str + " message:" + a, new Object[0]);
            this.g.g(a);
            u5a.b(this.c, PayDialogType.PAY_AMOUNT_DIALOG);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
    public void showInputNumberDialog(Activity activity, List list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, list, str) == null) {
            RLog.info("PayAmountViewCallback", "showInputNumberDialog bubbleActMsg:" + str);
            u5a.a(this.c, PayDialogType.PAY_AMOUNT_DIALOG);
            this.g.i(activity, list, str, this.d, this.f);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
    public void toPayWayDialog(e5a e5aVar, List list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, e5aVar, list, str) == null) {
            RLog.info("PayAmountViewCallback", "toPayWayDialog bubbleActMsg:" + str);
            u5a.a(this.c, PayDialogType.PAY_AMOUNT_DIALOG);
            this.g.n(this.e, e5aVar, list, str, this.d, this.f);
            l5a.b(this.a, this.b, PayUIEventType.purchasegotopay);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
    public void toHelpCenterPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.g.o(this.e);
        }
    }
}
