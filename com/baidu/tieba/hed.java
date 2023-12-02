package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fgd;
import com.baidu.tieba.hgd;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes6.dex */
public class hed implements add {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public zcd b;
    public PayUIKitConfig c;
    public PayFlowType d;
    public ycd e;
    public int f;
    public int g;
    public long h;

    /* loaded from: classes6.dex */
    public class a implements IPayCallback<CurrencyChargeMessage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IPayCallback a;
        public final /* synthetic */ ued b;
        public final /* synthetic */ Activity c;
        public final /* synthetic */ qed d;
        public final /* synthetic */ Dialog e;
        public final /* synthetic */ agd f;
        public final /* synthetic */ AppCustomExpand g;
        public final /* synthetic */ hgd.b h;
        public final /* synthetic */ hed i;

        public a(hed hedVar, IPayCallback iPayCallback, ued uedVar, Activity activity, qed qedVar, Dialog dialog, agd agdVar, AppCustomExpand appCustomExpand, hgd.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hedVar, iPayCallback, uedVar, activity, qedVar, dialog, agdVar, appCustomExpand, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = hedVar;
            this.a = iPayCallback;
            this.b = uedVar;
            this.c = activity;
            this.d = qedVar;
            this.e = dialog;
            this.f = agdVar;
            this.g = appCustomExpand;
            this.h = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(CurrencyChargeMessage currencyChargeMessage, PayCallBackBean payCallBackBean) {
            IPayCallback iPayCallback;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, currencyChargeMessage, payCallBackBean) == null) && (iPayCallback = this.a) != null) {
                iPayCallback.onSuccess(currencyChargeMessage, payCallBackBean);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            IPayCallback iPayCallback;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, payCallBackBean) == null) && (iPayCallback = this.a) != null) {
                iPayCallback.onFail(i, str, payCallBackBean);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStart() {
            IPayCallback iPayCallback;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (iPayCallback = this.a) != null) {
                iPayCallback.onPayStart();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStatus(PurchaseStatus purchaseStatus, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, purchaseStatus, payCallBackBean) == null) {
                if (purchaseStatus == PurchaseStatus.ORDER_FAIL && this.b.a == PayType.ALI_PAY_SIGN) {
                    RLog.info(this.i.a, "prepareShowPaySignDialog onPayStatus ORDER_FAIL, payWay.payType=PayType.ALI_PAY_SIGN");
                    ued uedVar = this.b;
                    uedVar.a = PayType.ALI_PAY;
                    this.i.e(this.c, this.d, uedVar, this.e, this.f, this.g, this.h, this.a);
                    return;
                }
                IPayCallback iPayCallback = this.a;
                if (iPayCallback != null) {
                    iPayCallback.onPayStatus(purchaseStatus, payCallBackBean);
                }
            }
        }
    }

    public hed(int i, int i2, zcd zcdVar, PayUIKitConfig payUIKitConfig, PayFlowType payFlowType, ycd ycdVar) {
        MiddleRevenueConfig middleRevenueConfig;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), zcdVar, payUIKitConfig, payFlowType, ycdVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "PaySignManager";
        this.h = 0L;
        RLog.info("PaySignManager", "create PaySignManager:" + this);
        this.f = i;
        this.g = i2;
        this.b = zcdVar;
        this.c = payUIKitConfig;
        this.d = payFlowType;
        this.e = ycdVar;
        if (payUIKitConfig != null && (middleRevenueConfig = payUIKitConfig.revenueConfig) != null) {
            this.h = middleRevenueConfig.getUid();
        }
    }

    @Override // com.baidu.tieba.add
    public void a(Activity activity, qed qedVar, ued uedVar, Dialog dialog, agd agdVar, AppCustomExpand appCustomExpand, hgd.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{activity, qedVar, uedVar, dialog, agdVar, appCustomExpand, bVar, iPayCallback}) == null) {
            String str = this.a;
            RLog.info(str, "prepareShowPaySignDialog:" + this);
            a aVar = new a(this, iPayCallback, uedVar, activity, qedVar, dialog, agdVar, appCustomExpand, bVar);
            boolean z = false;
            if (!uedVar.g) {
                z = pfd.b(activity, this.h + "").a("pay_sp_key_sign_pay_skip_remind", false);
            }
            String str2 = this.a;
            RLog.info(str2, "prepareShowPaySignDialog, isSkipShowSignDialog=" + z);
            if (z) {
                e(activity, qedVar, uedVar, dialog, agdVar, appCustomExpand, bVar, aVar);
                return;
            }
            fgd.b bVar2 = new fgd.b();
            bVar2.a = uedVar.g;
            bVar2.b = qedVar;
            bVar2.c = bVar.f;
            fgd f = this.b.f(activity, bVar2, this.c);
            f.setCallback(new wdd(activity, d(activity, f, bVar2), this.e, qedVar, uedVar, dialog, agdVar, appCustomExpand, bVar, aVar));
        }
    }

    public final Dialog d(Activity activity, fgd fgdVar, fgd.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, fgdVar, bVar)) == null) {
            return qgd.b.e(activity, "title", fgdVar.getContentView(), new vdd(this.f, this.g), bVar.c, PayDialogType.PAY_SIGN_DIALOG, this.d);
        }
        return (Dialog) invokeLLL.objValue;
    }

    public final void e(Activity activity, qed qedVar, ued uedVar, Dialog dialog, agd agdVar, AppCustomExpand appCustomExpand, hgd.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, qedVar, uedVar, dialog, agdVar, appCustomExpand, bVar, iPayCallback}) == null) {
            String str = this.a;
            RLog.info(str, "prepareShowPaySignDialog startPay payType=" + uedVar.a);
            this.e.k(activity, uedVar, qedVar, dialog, agdVar, appCustomExpand, bVar, iPayCallback);
        }
    }
}
