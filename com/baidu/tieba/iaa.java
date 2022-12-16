package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.NetworkUtil;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.TraceIdUtil;
import com.yy.mobile.framework.revenuesdk.payapi.AppPayServiceListener;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayStatus;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.SplitRecordItem;
import java.util.List;
import java.util.Map;
import tv.athena.revenue.RevenueManager;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.YYPayUIKit;
import tv.athena.revenue.payui.model.PayFinishInfo;
import tv.athena.revenue.payui.model.PayScene;
import tv.athena.revenue.payui.model.PayStartInfo;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.PaySplitOrderViewSource;
import tv.athena.revenue.payui.view.WindowParams;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes4.dex */
public class iaa implements c9a, g9a {
    public static /* synthetic */ Interceptable $ic;
    public static Gson s;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public Context b;
    public PayUIKitConfig c;
    public AppPayServiceListener d;
    public y8a e;
    public String f;
    public d9a g;
    public int h;
    public int i;
    public PayFlowType j;
    public PayDialogType k;
    public b9a l;
    public e9a m;
    public Handler n;
    public yba o;
    public PayFinishInfo p;
    public boolean q;
    public f9a r;

    /* loaded from: classes4.dex */
    public class a extends AppPayServiceListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ Dialog b;
        public final /* synthetic */ IYYPayWayView c;
        public final /* synthetic */ IYYPayWayView.b d;
        public final /* synthetic */ IPayCallback e;
        public final /* synthetic */ iaa f;

        public a(iaa iaaVar, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar, IPayCallback iPayCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iaaVar, activity, dialog, iYYPayWayView, bVar, iPayCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = iaaVar;
            this.a = activity;
            this.b = dialog;
            this.c = iYYPayWayView;
            this.d = bVar;
            this.e = iPayCallback;
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.AppPayServiceListener, com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener
        public void onCurrencyChargeMessage(CurrencyChargeMessage currencyChargeMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, currencyChargeMessage) != null) {
                return;
            }
            this.f.I(currencyChargeMessage, this.a, this.b, this.c, this.d, this.e);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ Dialog b;
        public final /* synthetic */ IYYPayWayView c;
        public final /* synthetic */ iaa d;

        public b(iaa iaaVar, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iaaVar, activity, dialog, iYYPayWayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = iaaVar;
            this.a = activity;
            this.b = dialog;
            this.c = iYYPayWayView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !xba.a.a(this.a)) {
                return;
            }
            this.d.L(this.b, this.c, false);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ int b;
        public final /* synthetic */ uaa c;
        public final /* synthetic */ xaa d;
        public final /* synthetic */ IPayCallback e;
        public final /* synthetic */ String f;
        public final /* synthetic */ IYYPayWayView.b g;
        public final /* synthetic */ PayCallBackBean h;
        public final /* synthetic */ Dialog i;
        public final /* synthetic */ iaa j;

        public c(iaa iaaVar, Activity activity, int i, uaa uaaVar, xaa xaaVar, IPayCallback iPayCallback, String str, IYYPayWayView.b bVar, PayCallBackBean payCallBackBean, Dialog dialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iaaVar, activity, Integer.valueOf(i), uaaVar, xaaVar, iPayCallback, str, bVar, payCallBackBean, dialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = iaaVar;
            this.a = activity;
            this.b = i;
            this.c = uaaVar;
            this.d = xaaVar;
            this.e = iPayCallback;
            this.f = str;
            this.g = bVar;
            this.h = payCallBackBean;
            this.i = dialog;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.j.r.release();
                this.j.l.d(null);
                if (!xba.a.a(this.a)) {
                    return;
                }
                IYYPayResultView.c cVar = new IYYPayResultView.c();
                IYYPayResultView.b bVar = new IYYPayResultView.b(IYYPayResultView.Result.PAY_FAIL, null);
                cVar.a = bVar;
                bVar.a(this.b);
                cVar.e = this.c;
                cVar.g = this.d;
                cVar.h = this.e;
                cVar.i = this.j.q;
                cVar.a.b(this.f);
                cVar.j = this.g;
                cVar.f = this.j.j;
                cVar.l = this.h;
                IYYPayWayView.b bVar2 = this.g;
                if (bVar2 != null) {
                    cVar.b = bVar2.g;
                    cVar.k = bVar2.k;
                }
                this.j.O(this.a, cVar);
                kba.a(this.i, PayDialogType.PAY_WAY_DIALOG);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ xaa b;
        public final /* synthetic */ Dialog c;
        public final /* synthetic */ IYYPayWayView d;
        public final /* synthetic */ iaa e;

        public d(iaa iaaVar, Activity activity, xaa xaaVar, Dialog dialog, IYYPayWayView iYYPayWayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iaaVar, activity, xaaVar, dialog, iYYPayWayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = iaaVar;
            this.a = activity;
            this.b = xaaVar;
            this.c = dialog;
            this.d = iYYPayWayView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.r.release();
                this.e.l.d(null);
                if (!xba.a.a(this.a)) {
                    return;
                }
                PayType payType = this.b.a;
                if (payType == null) {
                    RLog.error(this.e.a, "updateViewOnPaySuccess error payType null", new Object[0]);
                } else if (sba.d(payType.getChannel(), this.b.a.getMethod())) {
                    RLog.info(this.e.a, "updateViewOnPaySuccess but h5 not loadding");
                } else {
                    this.e.L(this.c, this.d, true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ Dialog b;
        public final /* synthetic */ IYYPayWayView c;
        public final /* synthetic */ iaa d;

        public e(iaa iaaVar, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iaaVar, activity, dialog, iYYPayWayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = iaaVar;
            this.a = activity;
            this.b = dialog;
            this.c = iYYPayWayView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !xba.a.a(this.a)) {
                return;
            }
            this.d.L(this.b, this.c, true);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ Dialog b;
        public final /* synthetic */ IYYPayWayView c;
        public final /* synthetic */ iaa d;

        public f(iaa iaaVar, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iaaVar, activity, dialog, iYYPayWayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = iaaVar;
            this.a = activity;
            this.b = dialog;
            this.c = iYYPayWayView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !xba.a.a(this.a)) {
                return;
            }
            this.d.L(this.b, this.c, false);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947848160, "Lcom/baidu/tieba/iaa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947848160, "Lcom/baidu/tieba/iaa;");
                return;
            }
        }
        s = new Gson();
    }

    @Override // com.baidu.tieba.c9a
    public f9a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.r;
        }
        return (f9a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.c9a
    public PayDialogType v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.k;
        }
        return (PayDialogType) invokeV.objValue;
    }

    public iaa(Context context, int i, int i2, y8a y8aVar, d9a d9aVar, b9a b9aVar, PayFlowType payFlowType, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), y8aVar, d9aVar, b9aVar, payFlowType, payUIKitConfig};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "PayFlowHandlerImpl";
        this.k = PayDialogType.PAY_NONE_DIALOG;
        this.n = new Handler(Looper.getMainLooper());
        this.o = null;
        this.p = null;
        this.q = false;
        this.a += "@" + hashCode();
        this.b = context;
        this.h = i;
        this.i = i2;
        this.e = y8aVar;
        this.c = payUIKitConfig;
        this.g = d9aVar;
        this.l = b9aVar;
        this.j = payFlowType;
        this.r = new maa(d9aVar, payFlowType, this, i, i2, payUIKitConfig);
        this.m = new laa(this.h, this.i, this.g, this.c, payFlowType, this);
        RLog.info(this.a, "create PayFlowHandlerImpl: " + this + " mPayFlowType:" + this.j.name());
    }

    @Override // com.baidu.tieba.c9a
    public void f(Activity activity, xaa xaaVar, uaa uaaVar, Dialog dialog, IYYPayWayView iYYPayWayView, AppCustomExpand appCustomExpand, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Map<String, String> map;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{activity, xaaVar, uaaVar, dialog, iYYPayWayView, appCustomExpand, bVar, iPayCallback}) == null) {
            String str = this.a;
            RLog.info(str, " requestPayInternal viewParams:" + bVar);
            w9a w9aVar = new w9a(this.h, this.i, iPayCallback, activity, dialog, iYYPayWayView, this, xaaVar, bVar, this, uaaVar);
            this.f = TraceIdUtil.newTraceId();
            if (bVar != null) {
                map = bVar.e;
            } else {
                map = null;
            }
            String str2 = this.a;
            RLog.info(str2, " requestPayInternal new mTraceId:" + this.f + " clientInfoExpand:" + map);
            PayType payType = xaaVar.a;
            if (payType != PayType.DXM_PAY_KJ && payType != PayType.UNION_PAY && payType != PayType.DXM_PAY_H5) {
                b2 = "";
            } else {
                b2 = vaa.b(this.c);
            }
            String str3 = b2;
            S(xaaVar);
            b8a yYPayMiddleService = RevenueManager.instance().getYYPayMiddleService(this.h, this.i);
            if (yYPayMiddleService != null) {
                yYPayMiddleService.b(activity, this.j, xaaVar.a, uaaVar.a, appCustomExpand, map, w9aVar, this.f, str3, uaaVar.b());
            } else {
                RLog.error(this.a, " requestPayInternal error yyPayMiddleService null", new Object[0]);
            }
        }
    }

    public final void N(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, runnable) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                this.n.post(runnable);
            }
        }
    }

    public final void R(PayDialogType payDialogType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, payDialogType) == null) {
            if (payDialogType == PayDialogType.PAY_AMOUNT_DIALOG || payDialogType == PayDialogType.PAY_INPUT_DIALOG || payDialogType == PayDialogType.PAY_WAY_DIALOG || payDialogType == PayDialogType.PAY_SPLIT_ORDER_DIALOG) {
                j(lba.b(payDialogType, 1, "", this.q));
            }
        }
    }

    @Override // com.baidu.tieba.c9a
    public void j(PayFinishInfo payFinishInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, payFinishInfo) == null) {
            String str = this.a;
            RLog.info(str, "updatePayFinishState old:" + this.p + " new:" + payFinishInfo);
            this.p = payFinishInfo;
        }
    }

    @Override // com.baidu.tieba.c9a
    public void u(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, activity) == null) {
            iba.a(this.j, this.h, this.i, this.c, activity, vaa.c(this.c), "帮助中心");
        }
    }

    public final boolean D(Activity activity, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, activity, absViewEventHandler)) == null) {
            if (NetworkUtil.isNetworkStrictlyAvailable(activity)) {
                return true;
            }
            Toast.makeText(activity, "网络不给力,请稍后重试(c)", 1).show();
            RLog.error(this.a, "showPayAmountDialog fail: network error", new Object[0]);
            j(lba.a(PayDialogType.PAY_AMOUNT_DIALOG, ErrorCode.NETWORK_NO_AVAILABLE, "展示支付面板失败,网络不通无法请求支付服务"));
            d(CancelType.ON_START_SHOW_FAIL, absViewEventHandler);
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.c9a
    public void q(yba ybaVar, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, ybaVar, dialog) == null) {
            String str = this.a;
            RLog.info(str, "refreshCurrentVisibleBottomPayView payView:" + ybaVar + " payDialog:" + dialog);
            if (dialog != null) {
                ybaVar.attachWindow(dialog.getWindow());
            }
            this.o = ybaVar;
        }
    }

    public final Dialog E(Activity activity, IYYPayAmountView iYYPayAmountView, AbsViewEventHandler absViewEventHandler, IYYPayAmountView.ViewParams viewParams) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, iYYPayAmountView, absViewEventHandler, viewParams)) == null) {
            RLog.info(this.a, "createPayAmountDialog");
            String string = activity.getString(R.string.pay_ui_dialog_title);
            if (viewParams != null && !TextUtils.isEmpty(viewParams.payAmountDialogTitle)) {
                string = viewParams.payAmountDialogTitle;
            }
            String str = string;
            k(absViewEventHandler, PayDialogType.PAY_AMOUNT_DIALOG);
            return kca.b.d(activity, str, iYYPayAmountView.getContentView(), new p9a(this.h, this.i, this, absViewEventHandler), absViewEventHandler, PayDialogType.PAY_AMOUNT_DIALOG, this.j, this.c);
        }
        return (Dialog) invokeLLLL.objValue;
    }

    @Override // com.baidu.tieba.g9a
    public void i(Activity activity, xaa xaaVar, Dialog dialog, IYYPayWayView iYYPayWayView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048601, this, activity, xaaVar, dialog, iYYPayWayView) == null) {
            String str = this.a;
            RLog.info(str, "updateViewOnPaySuccess mPayFlowType" + this.j.name());
            if (this.k == PayDialogType.PAY_NONE_DIALOG) {
                RLog.info(this.a, "updateViewOnPayFail 但支付流程已结束");
            } else {
                N(new d(this, activity, xaaVar, dialog, iYYPayWayView));
            }
        }
    }

    public final Dialog F(Activity activity, IYYPayResultView.c cVar, IYYPayResultView iYYPayResultView) {
        InterceptResult invokeLLL;
        AbsViewEventHandler absViewEventHandler;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, cVar, iYYPayResultView)) == null) {
            RLog.info(this.a, "createPayResultDialog");
            if (cVar != null) {
                absViewEventHandler = cVar.b;
            } else {
                absViewEventHandler = null;
            }
            AbsViewEventHandler absViewEventHandler2 = absViewEventHandler;
            k(absViewEventHandler2, PayDialogType.PAY_RESULT_DIALOG);
            return kca.b.e(activity, activity.getString(R.string.pay_ui_dialog_pay_title), iYYPayResultView.getContentView(), new x9a(absViewEventHandler2, this, activity, iYYPayResultView), absViewEventHandler2, PayDialogType.PAY_RESULT_DIALOG, this.j, this.c, true);
        }
        return (Dialog) invokeLLL.objValue;
    }

    public final void L(Dialog dialog, IYYPayWayView iYYPayWayView, boolean z) {
        IYYPayWayView.PayViewState payViewState;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, dialog, iYYPayWayView, z) == null) {
            String str = this.a;
            RLog.info(str, "refreshPayWayView isLoading=" + z);
            if (z) {
                payViewState = IYYPayWayView.PayViewState.WAITING_VIEW_STATE;
            } else {
                payViewState = IYYPayWayView.PayViewState.SELECTING_VIEW_STATE;
            }
            if (iYYPayWayView != null) {
                iYYPayWayView.setViewState(payViewState);
            }
            if (z) {
                kca.b.f(dialog);
            } else {
                kca.b.b(dialog);
            }
        }
    }

    public final Dialog G(Activity activity, IYYPayWayView iYYPayWayView, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, activity, iYYPayWayView, absViewEventHandler)) == null) {
            RLog.info(this.a, "createPayWayDialog");
            k(absViewEventHandler, PayDialogType.PAY_WAY_DIALOG);
            return kca.b.d(activity, activity.getString(R.string.pay_ui_dialog_pay_title), iYYPayWayView.getContentView(), new daa(this.h, this.i, activity, iYYPayWayView, absViewEventHandler, this), absViewEventHandler, PayDialogType.PAY_WAY_DIALOG, this.j, this.c);
        }
        return (Dialog) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.c9a
    public void g(Activity activity, IPayCallback<CurrencyChargeMessage> iPayCallback, IYYPayAmountView.ViewParams viewParams) {
        AbsViewEventHandler absViewEventHandler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048599, this, activity, iPayCallback, viewParams) == null) {
            String str = this.a;
            RLog.info(str, "pay_dialog_show_flow:showPayAmountDialog viewParams:" + viewParams);
            if (viewParams != null) {
                absViewEventHandler = viewParams.viewEventListener;
            } else {
                absViewEventHandler = null;
            }
            K(absViewEventHandler);
            if (!D(activity, absViewEventHandler) || H(activity, iPayCallback, viewParams)) {
                return;
            }
            IYYPayAmountView a2 = this.g.a(activity, viewParams, this.l);
            a2.refreshView();
            Dialog E = E(activity, a2, absViewEventHandler, viewParams);
            a2.setCallback(new r9a(this.h, this.i, E, viewParams, activity, iPayCallback, this));
            q(a2, E);
        }
    }

    public final boolean H(Activity activity, IPayCallback<CurrencyChargeMessage> iPayCallback, IYYPayAmountView.ViewParams viewParams) {
        InterceptResult invokeLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, activity, iPayCallback, viewParams)) == null) {
            if (viewParams != null && viewParams.targetAmount > 0 && viewParams.payScene == PayScene.DIALOG_QUICK_PAY) {
                z = true;
            } else {
                z = false;
            }
            String str = this.a;
            RLog.info(str, "fastShowPayWayDialog isQuickPay:" + z);
            if (!z) {
                return false;
            }
            this.q = true;
            if (viewParams.targetAmount > 5.0E7d) {
                viewParams.targetAmount = 50000000;
            }
            t(activity, eba.a(viewParams.targetAmount, this.c), null, null, viewParams, iPayCallback);
            String str2 = this.a;
            RLog.info(str2, "fastShowPayWayDialog targetAmount:" + viewParams.targetAmount);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.c9a
    public void b(Activity activity, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        AbsViewEventHandler absViewEventHandler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, activity, bVar, iPayCallback) == null) {
            String str = this.a;
            RLog.info(str, "pay_dialog_show_flow:showPayWayDialog viewParams:" + bVar);
            if (eba.b(this.h, this.i) == null) {
                RLog.error(this.a, "showPayWayDialog null appPayService", new Object[0]);
                return;
            }
            if (bVar == null) {
                bVar = new IYYPayWayView.b();
            }
            bVar.h = this.j;
            IYYPayWayView g = this.g.g(activity, bVar, this.r);
            g.refreshView();
            if (bVar != null) {
                absViewEventHandler = bVar.g;
            } else {
                absViewEventHandler = null;
            }
            Dialog G = G(activity, g, absViewEventHandler);
            g.setCallback(new eaa(activity, this.q, G, g, bVar, iPayCallback, this));
            q(g, G);
            M(activity, G, g, bVar, iPayCallback);
        }
    }

    public final void I(CurrencyChargeMessage currencyChargeMessage, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{currencyChargeMessage, activity, dialog, iYYPayWayView, bVar, iPayCallback}) == null) {
            String str = currencyChargeMessage.traceid;
            String str2 = this.a;
            RLog.info(str2, "onCurrencyChargeMessage messgaeTraceId:" + str + " message:" + currencyChargeMessage.toString());
            if (!str.equals(this.f)) {
                RLog.warn(this.a, "messgaeTraceId not equal mTraceId");
                return;
            }
            boolean z = true;
            if (currencyChargeMessage.status != 1) {
                z = false;
            }
            this.l.f(currencyChargeMessage.giftBagsInfo);
            j(lba.e(currencyChargeMessage.status, currencyChargeMessage.message));
            T(activity, dialog, iYYPayWayView, bVar, currencyChargeMessage, iPayCallback);
            Q(currencyChargeMessage);
            if (iPayCallback != null) {
                if (z) {
                    iPayCallback.onSuccess(currencyChargeMessage, null);
                } else {
                    iPayCallback.onFail(currencyChargeMessage.status, "", null);
                }
            }
        }
    }

    public void T(Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar, CurrencyChargeMessage currencyChargeMessage, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        boolean z;
        IYYPayResultView.Result result;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{activity, dialog, iYYPayWayView, bVar, currencyChargeMessage, iPayCallback}) == null) {
            boolean z3 = false;
            if (currencyChargeMessage.status == 1) {
                z = true;
            } else {
                z = false;
            }
            if (xba.a.a(activity)) {
                if (currencyChargeMessage.status == 1) {
                    result = IYYPayResultView.Result.PAY_SUUCESS;
                } else {
                    result = IYYPayResultView.Result.PAY_FAIL;
                }
                IYYPayResultView.b bVar2 = new IYYPayResultView.b(result, currencyChargeMessage);
                if (bVar != null && bVar.f) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if ((z && z2) ? true : true) {
                    P(activity, currencyChargeMessage, dialog, bVar2, iYYPayWayView, bVar, iPayCallback);
                } else {
                    kba.b(dialog, PayDialogType.PAY_WAY_DIALOG);
                }
            }
        }
    }

    @Override // com.baidu.tieba.c9a
    public void t(Activity activity, uaa uaaVar, List<PayWayInfo> list, String str, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{activity, uaaVar, list, str, viewParams, iPayCallback}) == null) {
            String str2 = this.a;
            RLog.info(str2, "showPayWayDialog IYYPayAmountView.ViewParams:" + viewParams);
            IYYPayWayView.b bVar = new IYYPayWayView.b();
            bVar.c = uaaVar;
            bVar.a = list;
            bVar.b = str;
            if (viewParams != null) {
                bVar.d = viewParams.appCustomExpand;
                bVar.f = viewParams.closeOnSuccess;
                bVar.g = viewParams.viewEventListener;
                bVar.e = viewParams.clientInfoExpand;
                bVar.i = viewParams.windowParams;
                bVar.j = viewParams.showFaqPage;
                bVar.k = viewParams.splitOrderPayScene;
            }
            b(activity, bVar, iPayCallback);
        }
    }

    public final void J(AbsViewEventHandler absViewEventHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, absViewEventHandler) == null) {
            if (absViewEventHandler == null) {
                RLog.info(this.a, "notifyPayFinishState but handler null");
                return;
            }
            String str = null;
            try {
                str = s.toJson(this.p);
            } catch (Throwable th) {
                String str2 = this.a;
                RLog.error(str2, "notifyPayFinishState error t:" + th, new Object[0]);
            }
            String str3 = this.a;
            RLog.info(str3, "onPayInfo notifyPayFinishState handler:" + absViewEventHandler + " state:" + this.p + " json:" + str);
            if (str != null) {
                absViewEventHandler.onPayInfo(2, str);
            }
        }
    }

    public final void K(AbsViewEventHandler absViewEventHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, absViewEventHandler) == null) {
            if (absViewEventHandler == null) {
                RLog.info(this.a, "notifyPayStartState but handler null");
                return;
            }
            String str = null;
            try {
                str = s.toJson(new PayStartInfo(1, "支付流程开始"));
            } catch (Throwable th) {
                String str2 = this.a;
                RLog.error(str2, "notifyPayStartState error t:" + th, new Object[0]);
            }
            String str3 = this.a;
            RLog.info(str3, "onPayInfo notifyPayStartState handler:" + absViewEventHandler + " json:" + str);
            if (str != null) {
                absViewEventHandler.onPayInfo(1, str);
            }
        }
    }

    public final void Q(CurrencyChargeMessage currencyChargeMessage) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, currencyChargeMessage) == null) {
            boolean z = true;
            if (currencyChargeMessage.status != 1) {
                z = false;
            }
            if (!z) {
                String str2 = this.a;
                RLog.info(str2, "statisticOnCurrencyChargeMessage but pay fail status:" + currencyChargeMessage.status);
                return;
            }
            int i = currencyChargeMessage.cid;
            String str3 = currencyChargeMessage.payChannel;
            String str4 = currencyChargeMessage.payMethod;
            if (this.j == PayFlowType.WALLET_PAY_FLOW) {
                str = "14";
            } else {
                str = "7";
            }
            aba.d(this.h, currencyChargeMessage.usedChannel, str, str3, str4, String.valueOf(i));
            String str5 = this.a;
            RLog.info(str5, "statisticOnCurrencyChargeMessage payChannel:" + str3 + " payMethod:" + str4);
        }
    }

    public void M(Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048585, this, activity, dialog, iYYPayWayView, bVar, iPayCallback) == null) {
            IAppPayService b2 = eba.b(this.h, this.i);
            if (b2 == null) {
                RLog.error(this.a, "registerPayServiceListener null appPayService", new Object[0]);
                return;
            }
            this.d = new a(this, activity, dialog, iYYPayWayView, bVar, iPayCallback);
            RLog.info(this.a, "registerPayServiceListener");
            b2.addPayListener(this.d);
        }
    }

    public void O(Activity activity, IYYPayResultView.c cVar) {
        AbsViewEventHandler absViewEventHandler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, activity, cVar) == null) {
            RLog.info(this.a, "pay_dialog_show_flow:showPayResultDialog viewParams:" + cVar);
            IPayCallback<CurrencyChargeMessage> iPayCallback = null;
            if (cVar != null) {
                absViewEventHandler = cVar.b;
            } else {
                absViewEventHandler = null;
            }
            if (cVar != null) {
                iPayCallback = cVar.h;
            }
            IPayCallback<CurrencyChargeMessage> iPayCallback2 = iPayCallback;
            IYYPayResultView e2 = this.g.e(activity, cVar, this.l);
            Dialog F = F(activity, cVar, e2);
            e2.setCallback(new y9a(activity, e2, absViewEventHandler, F, this, iPayCallback2, cVar));
            q(e2, F);
        }
    }

    @Override // com.baidu.tieba.c9a
    public void d(CancelType cancelType, AbsViewEventHandler absViewEventHandler) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, cancelType, absViewEventHandler) == null) {
            if (cancelType != CancelType.BUTTOM_AREA_CLICK && cancelType != CancelType.EMPTY_AREA_CLICK && cancelType != CancelType.ON_DIALOG_CANCEL && cancelType != CancelType.ON_START_SHOW_FAIL) {
                z = false;
            } else {
                z = true;
            }
            String str = this.a;
            RLog.info(str, "checkNotifyViewFlowClose cancelType:" + cancelType.name() + " shouldNotifyPayFlowChange:" + z);
            if (z) {
                J(absViewEventHandler);
                k(absViewEventHandler, PayDialogType.PAY_NONE_DIALOG);
            }
        }
    }

    @Override // com.baidu.tieba.c9a
    public void k(AbsViewEventHandler absViewEventHandler, PayDialogType payDialogType) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, absViewEventHandler, payDialogType) == null) {
            if (payDialogType != null) {
                str = payDialogType.name();
            } else {
                str = StringUtil.NULL_STRING;
            }
            String str2 = this.a;
            RLog.info(str2, "notifyPayFlowChange payDialogType:" + str);
            R(payDialogType);
            this.k = payDialogType;
            oaa.c(this.h, this.i, this.j, payDialogType);
            if (absViewEventHandler != null && payDialogType != null) {
                absViewEventHandler.onViewStateChange(payDialogType);
            } else {
                RLog.debug(this.a, "notifyPayFlowChange null");
            }
        }
    }

    public final void P(Activity activity, CurrencyChargeMessage currencyChargeMessage, Dialog dialog, IYYPayResultView.b bVar, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar2, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        List<SplitRecordItem> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{activity, currencyChargeMessage, dialog, bVar, iYYPayWayView, bVar2, iPayCallback}) == null) {
            if (sba.d(currencyChargeMessage.payChannel, currencyChargeMessage.payMethod)) {
                L(dialog, iYYPayWayView, false);
                return;
            }
            kba.a(dialog, PayDialogType.PAY_WAY_DIALOG);
            IYYPayResultView.c cVar = new IYYPayResultView.c();
            cVar.a = bVar;
            cVar.b = bVar2.g;
            cVar.c = bVar2.i;
            cVar.h = iPayCallback;
            cVar.i = this.q;
            if (currencyChargeMessage != null) {
                list = currencyChargeMessage.splitRecordItemList;
            } else {
                list = null;
            }
            cVar.d = list;
            cVar.j = bVar2;
            cVar.k = bVar2.k;
            cVar.f = this.j;
            O(activity, cVar);
        }
    }

    public final void S(xaa xaaVar) {
        PayType payType;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, xaaVar) == null) {
            String str = this.a;
            RLog.info(str, "updatePayFrequencyState payWay:" + xaaVar);
            if (xaaVar != null && (payType = xaaVar.a) != null && payType == PayType.ALI_PAY) {
                YYPayUIKit uIKit = YYPayUIKit.getUIKit(this.h, this.i);
                if (uIKit == null) {
                    RLog.error(this.a, "updatePayFrequencyState error payUIKit null", new Object[0]);
                } else {
                    uIKit.setIsPayFrequency(true);
                }
            }
        }
    }

    @Override // com.baidu.tieba.c9a
    public void a(Activity activity, uaa uaaVar, List<PayWayInfo> list, String str, PaySplitOrderViewSource paySplitOrderViewSource, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{activity, uaaVar, list, str, paySplitOrderViewSource, viewParams, iPayCallback}) == null) {
            String str2 = this.a;
            RLog.info(str2, "prepareShowSplitOrderDialog viewParams:" + viewParams);
            this.r.a(activity, uaaVar, list, str, paySplitOrderViewSource, viewParams, iPayCallback);
        }
    }

    @Override // com.baidu.tieba.c9a
    public void c(int i, String str, PayCallBackBean payCallBackBean) {
        y8a y8aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048595, this, i, str, payCallBackBean) == null) && (y8aVar = this.e) != null) {
            y8aVar.a(i, str, payCallBackBean);
        }
    }

    @Override // com.baidu.tieba.c9a
    public boolean p(Activity activity, IYYPayResultView iYYPayResultView, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048608, this, activity, iYYPayResultView, absViewEventHandler)) == null) {
            if (this.l.b(activity, new u9a(), this, absViewEventHandler)) {
                RLog.info(this.a, "showPayGiftDialog");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.c9a
    public boolean s(Activity activity, IYYPayWayView iYYPayWayView, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048613, this, activity, iYYPayWayView, absViewEventHandler)) == null) {
            if (this.l.e(activity, new s9a(iYYPayWayView), this, absViewEventHandler)) {
                RLog.info(this.a, "showConfirmFinishDialog");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.g9a
    public void h(int i, String str, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar, uaa uaaVar, xaa xaaVar, PayCallBackBean payCallBackBean, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i), str, activity, dialog, iYYPayWayView, bVar, uaaVar, xaaVar, payCallBackBean, iPayCallback}) == null) {
            String str2 = this.a;
            RLog.info(str2, "updateViewOnPayFail mPayFlowType" + this.j.name() + " payCallBackBean:" + payCallBackBean);
            if (this.k == PayDialogType.PAY_NONE_DIALOG) {
                RLog.info(this.a, "updateViewOnPayFail 但支付流程已结束");
                return;
            }
            j(lba.e(i, str));
            if (i == PayStatus.CANCEL.getCode()) {
                String str3 = this.a;
                RLog.info(str3, "updateViewOnPayFail 用户取消支付 code:" + i);
                N(new b(this, activity, dialog, iYYPayWayView));
                return;
            }
            N(new c(this, activity, i, uaaVar, xaaVar, iPayCallback, str, bVar, payCallBackBean, dialog));
        }
    }

    @Override // com.baidu.tieba.c9a
    public void l(Activity activity, List<PayWayInfo> list, String str, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        AbsViewEventHandler absViewEventHandler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048604, this, activity, list, str, viewParams, iPayCallback) == null) {
            String str2 = this.a;
            RLog.info(str2, "pay_dialog_show_flow:showInputDialog viewParams:" + viewParams);
            this.r.release();
            if (viewParams != null) {
                absViewEventHandler = viewParams.viewEventListener;
            } else {
                absViewEventHandler = null;
            }
            AbsViewEventHandler absViewEventHandler2 = absViewEventHandler;
            k(absViewEventHandler2, PayDialogType.PAY_INPUT_DIALOG);
            oca.a.f(activity, new q9a(this, absViewEventHandler2, this.c, activity, list, viewParams, str, iPayCallback), absViewEventHandler2, PayDialogType.PAY_INPUT_DIALOG, this.c, this.j);
        }
    }

    @Override // com.baidu.tieba.c9a
    public void m(Activity activity, uaa uaaVar, xaa xaaVar, Dialog dialog, IYYPayWayView iYYPayWayView, AppCustomExpand appCustomExpand, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        AbsViewEventHandler absViewEventHandler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{activity, uaaVar, xaaVar, dialog, iYYPayWayView, appCustomExpand, bVar, iPayCallback}) == null) {
            if (bVar != null) {
                absViewEventHandler = bVar.g;
            } else {
                absViewEventHandler = null;
            }
            k(absViewEventHandler, PayDialogType.PAY_SIGN_DIALOG);
            this.m.a(activity, uaaVar, xaaVar, dialog, iYYPayWayView, appCustomExpand, bVar, iPayCallback);
        }
    }

    @Override // com.baidu.tieba.c9a
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.f = null;
            IAppPayService b2 = eba.b(this.h, this.i);
            if (b2 == null) {
                RLog.error(this.a, "unregisterPayServiceListener null appPayService", new Object[0]);
            } else if (this.d != null) {
                RLog.info(this.a, "unregisterPayServiceListener");
                b2.removePayListener(this.d);
                this.d = null;
            }
        }
    }

    @Override // com.baidu.tieba.c9a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            String str = this.a;
            RLog.info(str, "clear:" + this);
            this.o = null;
            this.r.release();
            this.k = PayDialogType.PAY_NONE_DIALOG;
            this.p = null;
            this.q = false;
        }
    }

    @Override // com.baidu.tieba.c9a
    public void o(Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, activity, str) == null) {
            iba.a(this.j, this.h, this.i, this.c, activity, vaa.a(str, this.c), "");
        }
    }

    @Override // com.baidu.tieba.g9a
    public void r(Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, PurchaseStatus purchaseStatus) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048610, this, activity, dialog, iYYPayWayView, purchaseStatus) == null) {
            String str2 = this.a;
            RLog.info(str2, "updateViewOnPayStatus  mPayFlowType" + this.j.name());
            if (this.k == PayDialogType.PAY_NONE_DIALOG) {
                RLog.info(this.a, "updateViewOnPayFail 但支付流程已结束");
                return;
            }
            int i = 1;
            if (purchaseStatus != null && purchaseStatus == PurchaseStatus.ORDER_START) {
                j(lba.d(1, "开始下单"));
                N(new e(this, activity, dialog, iYYPayWayView));
            } else if ((purchaseStatus != null && purchaseStatus == PurchaseStatus.ORDER_SUCCESS) || purchaseStatus == PurchaseStatus.ORDER_FAIL) {
                if (purchaseStatus != PurchaseStatus.ORDER_SUCCESS) {
                    i = -1;
                }
                if (purchaseStatus == PurchaseStatus.ORDER_SUCCESS) {
                    str = "下单成功";
                } else {
                    str = " 下单失败";
                }
                j(lba.c(i, str));
                N(new f(this, activity, dialog, iYYPayWayView));
            }
        }
    }

    @Override // com.baidu.tieba.c9a
    public void refreshWindow(WindowParams windowParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, windowParams) == null) {
            String str = this.a;
            RLog.info(str, "refreshWindow mVisibleBottomPayView:" + this.o + " windowParams:" + windowParams);
            yba ybaVar = this.o;
            if (ybaVar != null && windowParams != null) {
                ybaVar.refreshWindow(windowParams);
            }
        }
    }
}
