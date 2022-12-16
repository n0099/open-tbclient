package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dca;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.model.PayFinishInfo;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.PaySplitOrderViewSource;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes4.dex */
public class eaa implements IYYPayWayView.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Dialog b;
    public IYYPayWayView c;
    public IYYPayWayView.b d;
    public IPayCallback<CurrencyChargeMessage> e;
    public c9a f;
    public boolean g;

    public eaa(Activity activity, boolean z, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback, c9a c9aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Boolean.valueOf(z), dialog, iYYPayWayView, bVar, iPayCallback, c9aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PayWayViewCallback", "create PayWayViewCallback");
        this.a = activity;
        this.b = dialog;
        this.c = iYYPayWayView;
        this.d = bVar;
        this.e = iPayCallback;
        this.f = c9aVar;
        this.g = z;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
    public void a(xaa xaaVar, uaa uaaVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, xaaVar, uaaVar, appCustomExpand) == null) {
            xaa xaaVar2 = new xaa(PayType.ALI_PAY_SIGN, xaaVar.b, xaaVar.c, xaaVar.d, xaaVar.e, xaaVar.f);
            RLog.info("PayWayViewCallback", "onStartSignPay payType=" + xaaVar2.a + ", payAmount=" + uaaVar);
            this.f.m(this.a, uaaVar, xaaVar2, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
    public void b(xaa xaaVar, uaa uaaVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xaaVar, uaaVar, appCustomExpand) == null) {
            RLog.info("PayWayViewCallback", "onStartPay payType=" + xaaVar.a + ", payAmount=" + uaaVar);
            this.f.f(this.a, xaaVar, uaaVar, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
    public void c(waa waaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, waaVar) == null) {
            RLog.info("PayWayViewCallback", "showSplitOrderView info:" + waaVar);
            kba.a(this.b, PayDialogType.PAY_WAY_DIALOG);
            c9a c9aVar = this.f;
            Activity activity = this.a;
            dca.b bVar = waaVar.b;
            c9aVar.a(activity, bVar.a, bVar.d, bVar.e, PaySplitOrderViewSource.SOURCE_FROM_PAY_WAY_DIALOG, bVar.f, this.e);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
    public void onRefreshViewFail(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            PayFinishInfo b = lba.b(PayDialogType.PAY_WAY_DIALOG, i, str, this.g);
            RLog.info("PayWayViewCallback", "showPayWayDialog onRefreshViewFail message:" + b);
            this.f.j(b);
            kba.b(this.b, PayDialogType.PAY_WAY_DIALOG);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
    public void toHelpCenterPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f.u(this.a);
        }
    }
}
