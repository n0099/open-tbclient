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
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUIEventType;
import java.util.List;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.model.PayFinishInfo;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes5.dex */
public class btb implements IYYPayAmountView.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public Dialog c;
    public IYYPayAmountView.ViewParams d;
    public Activity e;
    public IPayCallback<CurrencyChargeMessage> f;
    public msb g;
    public ovb h;

    public btb(int i, int i2, Dialog dialog, IYYPayAmountView.ViewParams viewParams, Activity activity, IPayCallback<CurrencyChargeMessage> iPayCallback, msb msbVar, ovb ovbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), dialog, viewParams, activity, iPayCallback, msbVar, ovbVar};
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
        this.g = msbVar;
        this.h = ovbVar;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
    public void onRefreshViewFail(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
            PayFinishInfo a = yub.a(PayDialogType.PAY_AMOUNT_DIALOG, i, str);
            RLog.error("PayAmountViewCallback", "showPayAmountDialog onFail code:" + i + " failReason:" + str + " message:" + a, new Object[0]);
            this.g.l(a);
            xub.b(this.c, PayDialogType.PAY_AMOUNT_DIALOG);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
    public void onStartPay(iub iubVar, eub eubVar, AppCustomExpand appCustomExpand, List<PayWayInfo> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iubVar, eubVar, appCustomExpand, list, str) == null) {
            RLog.info("PayAmountViewCallback", "onStartPay payType=" + iubVar.a + ", payAmount=" + eubVar);
            this.g.k(this.e, iubVar, eubVar, this.c, this.h, appCustomExpand, gvb.a(eubVar, list, str, this.d), this.f);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
    public void onStartSignPay(iub iubVar, eub eubVar, AppCustomExpand appCustomExpand, List<PayWayInfo> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, iubVar, eubVar, appCustomExpand, list, str) == null) {
            iub iubVar2 = new iub(PayType.ALI_PAY_SIGN, iubVar.b, iubVar.c, iubVar.d, iubVar.e, iubVar.f, iubVar.g);
            RLog.info("PayAmountViewCallback", "onStartSignPay payType=" + iubVar2.a + ", payAmount=" + eubVar);
            this.g.p(this.e, eubVar, iubVar2, this.c, this.h, appCustomExpand, gvb.a(eubVar, list, str, this.d), this.f);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
    public void showInputNumberDialog(Activity activity, List<PayWayInfo> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, list, str) == null) {
            RLog.info("PayAmountViewCallback", "showInputNumberDialog bubbleActMsg:" + str);
            xub.a(this.c, PayDialogType.PAY_AMOUNT_DIALOG);
            this.g.n(activity, list, str, this.d, this.f);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
    public void toPayWayDialog(eub eubVar, List<PayWayInfo> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, eubVar, list, str) == null) {
            RLog.info("PayAmountViewCallback", "toPayWayDialog bubbleActMsg:" + str);
            xub.a(this.c, PayDialogType.PAY_AMOUNT_DIALOG);
            this.g.t(this.e, eubVar, list, str, this.d, this.f);
            nub.b(this.a, this.b, PayUIEventType.purchasegotopay);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
    public void toBannerConfigWebPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.g.q(this.e, str);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
    public void toHelpCenterPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.g.u(this.e);
        }
    }
}
