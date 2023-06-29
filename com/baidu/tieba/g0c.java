package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.m2c;
import com.baidu.tieba.n2c;
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
public class g0c implements n2c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Dialog b;
    public n2c c;
    public n2c.b d;
    public IPayCallback<CurrencyChargeMessage> e;
    public ezb f;
    public boolean g;

    public g0c(Activity activity, boolean z, Dialog dialog, n2c n2cVar, n2c.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback, ezb ezbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Boolean.valueOf(z), dialog, n2cVar, bVar, iPayCallback, ezbVar};
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
        this.c = n2cVar;
        this.d = bVar;
        this.e = iPayCallback;
        this.f = ezbVar;
        this.g = z;
    }

    @Override // com.baidu.tieba.n2c.a
    public void a(a1c a1cVar, w0c w0cVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, a1cVar, w0cVar, appCustomExpand) == null) {
            a1c a1cVar2 = new a1c(PayType.ALI_PAY_SIGN, a1cVar.b, a1cVar.c, a1cVar.d, a1cVar.e, a1cVar.f, a1cVar.g);
            RLog.info("PayWayViewCallback", "onStartSignPay payType=" + a1cVar2.a + ", payAmount=" + w0cVar + ", alwaysConfirm=" + a1cVar.g);
            this.f.p(this.a, w0cVar, a1cVar2, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.n2c.a
    public void b(a1c a1cVar, w0c w0cVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a1cVar, w0cVar, appCustomExpand) == null) {
            RLog.info("PayWayViewCallback", "onStartPay payType=" + a1cVar.a + ", payAmount=" + w0cVar);
            this.f.k(this.a, a1cVar, w0cVar, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.n2c.a
    public void c(z0c z0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, z0cVar) == null) {
            RLog.info("PayWayViewCallback", "showSplitOrderView info:" + z0cVar);
            p1c.a(this.b, PayDialogType.PAY_WAY_DIALOG);
            ezb ezbVar = this.f;
            Activity activity = this.a;
            m2c.b bVar = z0cVar.b;
            ezbVar.a(activity, bVar.a, bVar.d, bVar.e, PaySplitOrderViewSource.SOURCE_FROM_PAY_WAY_DIALOG, bVar.f, this.e);
        }
    }

    @Override // com.baidu.tieba.n2c.a
    public void onRefreshViewFail(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            PayFinishInfo b = q1c.b(PayDialogType.PAY_WAY_DIALOG, i, str, this.g);
            RLog.info("PayWayViewCallback", "showPayWayDialog onRefreshViewFail message:" + b);
            this.f.l(b);
            p1c.b(this.b, PayDialogType.PAY_WAY_DIALOG);
        }
    }

    @Override // com.baidu.tieba.n2c.a
    public void toHelpCenterPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f.u(this.a);
        }
    }
}
