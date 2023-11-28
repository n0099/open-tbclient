package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hgd;
import com.baidu.tieba.igd;
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
import tv.athena.revenue.payui.view.PaySplitOrderViewSource;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes5.dex */
public class bed implements igd.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Dialog b;
    public igd c;
    public igd.b d;
    public IPayCallback<CurrencyChargeMessage> e;
    public zcd f;
    public boolean g;

    public bed(Activity activity, boolean z, Dialog dialog, igd igdVar, igd.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback, zcd zcdVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Boolean.valueOf(z), dialog, igdVar, bVar, iPayCallback, zcdVar};
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
        this.c = igdVar;
        this.d = bVar;
        this.e = iPayCallback;
        this.f = zcdVar;
        this.g = z;
    }

    @Override // com.baidu.tieba.igd.a
    public void a(ved vedVar, red redVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, vedVar, redVar, appCustomExpand) == null) {
            ved vedVar2 = new ved(PayType.ALI_PAY_SIGN, vedVar.b, vedVar.c, vedVar.d, vedVar.e, vedVar.f, vedVar.g);
            RLog.info("PayWayViewCallback", "onStartSignPay payType=" + vedVar2.a + ", payAmount=" + redVar + ", alwaysConfirm=" + vedVar.g);
            this.f.p(this.a, redVar, vedVar2, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.igd.a
    public void b(ved vedVar, red redVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vedVar, redVar, appCustomExpand) == null) {
            RLog.info("PayWayViewCallback", "onStartPay payType=" + vedVar.a + ", payAmount=" + redVar);
            this.f.k(this.a, vedVar, redVar, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.igd.a
    public void c(ued uedVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uedVar) == null) {
            RLog.info("PayWayViewCallback", "showSplitOrderView info:" + uedVar);
            kfd.a(this.b, PayDialogType.PAY_WAY_DIALOG);
            zcd zcdVar = this.f;
            Activity activity = this.a;
            hgd.b bVar = uedVar.b;
            zcdVar.a(activity, bVar.a, bVar.d, bVar.e, PaySplitOrderViewSource.SOURCE_FROM_PAY_WAY_DIALOG, bVar.f, this.e);
        }
    }

    @Override // com.baidu.tieba.igd.a
    public void onRefreshViewFail(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            PayFinishInfo b = lfd.b(PayDialogType.PAY_WAY_DIALOG, i, str, this.g);
            RLog.info("PayWayViewCallback", "showPayWayDialog onRefreshViewFail message:" + b);
            this.f.l(b);
            kfd.b(this.b, PayDialogType.PAY_WAY_DIALOG);
        }
    }

    @Override // com.baidu.tieba.igd.a
    public void toHelpCenterPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f.u(this.a);
        }
    }
}
