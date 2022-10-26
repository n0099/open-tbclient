package com.baidu.tieba;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.dialog.CancelType;
/* loaded from: classes4.dex */
public class g4a implements s6a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public v3a a;
    public AbsViewEventHandler b;
    public PayUIKitConfig c;
    public Activity d;
    public List e;
    public IYYPayAmountView.ViewParams f;
    public IPayCallback g;
    public String h;

    public g4a(v3a v3aVar, AbsViewEventHandler absViewEventHandler, PayUIKitConfig payUIKitConfig, Activity activity, List list, IYYPayAmountView.ViewParams viewParams, String str, IPayCallback iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v3aVar, absViewEventHandler, payUIKitConfig, activity, list, viewParams, str, iPayCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("AmountInputDialogListener", "create AmountInputDialogListener");
        this.a = v3aVar;
        this.b = absViewEventHandler;
        this.c = payUIKitConfig;
        this.d = activity;
        this.e = list;
        this.f = viewParams;
        this.g = iPayCallback;
        this.h = str;
    }

    @Override // com.baidu.tieba.s6a
    public void a(CancelType cancelType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
            RLog.info("AmountInputDialogListener", "InputDialog notifyCancelType clickArea:" + cancelType);
            this.a.c(cancelType, this.b);
        }
    }

    @Override // com.baidu.tieba.s6a
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            e5a a = o5a.a((int) (i * 100.0d), this.c);
            RLog.info("AmountInputDialogListener", "showInputDialog: mPayAmountCustom:%s", a);
            this.a.n(this.d, a, this.e, this.h, this.f, this.g);
        }
    }
}
