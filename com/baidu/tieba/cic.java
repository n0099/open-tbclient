package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ikc;
import com.baidu.tieba.jkc;
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
public class cic implements jkc.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Dialog b;
    public jkc c;
    public jkc.b d;
    public IPayCallback<CurrencyChargeMessage> e;
    public ahc f;
    public boolean g;

    public cic(Activity activity, boolean z, Dialog dialog, jkc jkcVar, jkc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback, ahc ahcVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Boolean.valueOf(z), dialog, jkcVar, bVar, iPayCallback, ahcVar};
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
        this.c = jkcVar;
        this.d = bVar;
        this.e = iPayCallback;
        this.f = ahcVar;
        this.g = z;
    }

    @Override // com.baidu.tieba.jkc.a
    public void a(wic wicVar, sic sicVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, wicVar, sicVar, appCustomExpand) == null) {
            wic wicVar2 = new wic(PayType.ALI_PAY_SIGN, wicVar.b, wicVar.c, wicVar.d, wicVar.e, wicVar.f, wicVar.g);
            RLog.info("PayWayViewCallback", "onStartSignPay payType=" + wicVar2.a + ", payAmount=" + sicVar + ", alwaysConfirm=" + wicVar.g);
            this.f.p(this.a, sicVar, wicVar2, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.jkc.a
    public void b(wic wicVar, sic sicVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wicVar, sicVar, appCustomExpand) == null) {
            RLog.info("PayWayViewCallback", "onStartPay payType=" + wicVar.a + ", payAmount=" + sicVar);
            this.f.k(this.a, wicVar, sicVar, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.jkc.a
    public void c(vic vicVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vicVar) == null) {
            RLog.info("PayWayViewCallback", "showSplitOrderView info:" + vicVar);
            ljc.a(this.b, PayDialogType.PAY_WAY_DIALOG);
            ahc ahcVar = this.f;
            Activity activity = this.a;
            ikc.b bVar = vicVar.b;
            ahcVar.a(activity, bVar.a, bVar.d, bVar.e, PaySplitOrderViewSource.SOURCE_FROM_PAY_WAY_DIALOG, bVar.f, this.e);
        }
    }

    @Override // com.baidu.tieba.jkc.a
    public void onRefreshViewFail(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            PayFinishInfo b = mjc.b(PayDialogType.PAY_WAY_DIALOG, i, str, this.g);
            RLog.info("PayWayViewCallback", "showPayWayDialog onRefreshViewFail message:" + b);
            this.f.l(b);
            ljc.b(this.b, PayDialogType.PAY_WAY_DIALOG);
        }
    }

    @Override // com.baidu.tieba.jkc.a
    public void toHelpCenterPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f.u(this.a);
        }
    }
}
