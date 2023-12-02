package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ggd;
import com.baidu.tieba.hgd;
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
public class aed implements hgd.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Dialog b;
    public hgd c;
    public hgd.b d;
    public IPayCallback<CurrencyChargeMessage> e;
    public ycd f;
    public boolean g;

    public aed(Activity activity, boolean z, Dialog dialog, hgd hgdVar, hgd.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback, ycd ycdVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Boolean.valueOf(z), dialog, hgdVar, bVar, iPayCallback, ycdVar};
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
        this.c = hgdVar;
        this.d = bVar;
        this.e = iPayCallback;
        this.f = ycdVar;
        this.g = z;
    }

    @Override // com.baidu.tieba.hgd.a
    public void a(ued uedVar, qed qedVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, uedVar, qedVar, appCustomExpand) == null) {
            ued uedVar2 = new ued(PayType.ALI_PAY_SIGN, uedVar.b, uedVar.c, uedVar.d, uedVar.e, uedVar.f, uedVar.g);
            RLog.info("PayWayViewCallback", "onStartSignPay payType=" + uedVar2.a + ", payAmount=" + qedVar + ", alwaysConfirm=" + uedVar.g);
            this.f.p(this.a, qedVar, uedVar2, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.hgd.a
    public void b(ued uedVar, qed qedVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uedVar, qedVar, appCustomExpand) == null) {
            RLog.info("PayWayViewCallback", "onStartPay payType=" + uedVar.a + ", payAmount=" + qedVar);
            this.f.k(this.a, uedVar, qedVar, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.hgd.a
    public void c(ted tedVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tedVar) == null) {
            RLog.info("PayWayViewCallback", "showSplitOrderView info:" + tedVar);
            jfd.a(this.b, PayDialogType.PAY_WAY_DIALOG);
            ycd ycdVar = this.f;
            Activity activity = this.a;
            ggd.b bVar = tedVar.b;
            ycdVar.a(activity, bVar.a, bVar.d, bVar.e, PaySplitOrderViewSource.SOURCE_FROM_PAY_WAY_DIALOG, bVar.f, this.e);
        }
    }

    @Override // com.baidu.tieba.hgd.a
    public void onRefreshViewFail(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            PayFinishInfo b = kfd.b(PayDialogType.PAY_WAY_DIALOG, i, str, this.g);
            RLog.info("PayWayViewCallback", "showPayWayDialog onRefreshViewFail message:" + b);
            this.f.l(b);
            jfd.b(this.b, PayDialogType.PAY_WAY_DIALOG);
        }
    }

    @Override // com.baidu.tieba.hgd.a
    public void toHelpCenterPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f.u(this.a);
        }
    }
}
