package com.baidu.tieba;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.impl.YYPayAmountView;
import tv.athena.revenue.payui.view.impl.YYPayCampaignView;
import tv.athena.revenue.payui.view.impl.YYPayConfirmView;
import tv.athena.revenue.payui.view.impl.YYPayGiftView;
import tv.athena.revenue.payui.view.impl.YYPayResultView;
import tv.athena.revenue.payui.view.impl.YYPayWayView;
/* loaded from: classes4.dex */
public class f6a implements g5a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public m6a c;
    public PayUIKitConfig d;

    public f6a(int i, int i2, m6a m6aVar, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), m6aVar, payUIKitConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PayViewImpl", "create PayViewImpl mAppId:" + i + " mUserChannel:" + i2);
        this.a = i;
        this.b = i2;
        this.c = m6aVar;
        this.d = payUIKitConfig;
    }

    @Override // com.baidu.tieba.g5a
    public IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, c5a c5aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, viewParams, c5aVar)) == null) {
            return new YYPayAmountView(activity, this.a, this.b, this.d, viewParams, this.c, c5aVar);
        }
        return (IYYPayAmountView) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.g5a
    public IYYPayWayView e(Activity activity, IYYPayWayView.b bVar, c5a c5aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, activity, bVar, c5aVar)) == null) {
            return new YYPayWayView(activity, this.a, this.b, bVar, this.c, this.d, c5aVar);
        }
        return (IYYPayWayView) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.g5a
    public IYYPayResultView f(Activity activity, IYYPayResultView.c cVar, c5a c5aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, activity, cVar, c5aVar)) == null) {
            return new YYPayResultView(activity, this.d, this.c, this.a, this.b, cVar, c5aVar);
        }
        return (IYYPayResultView) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.g5a
    public q7a b(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) {
            return new YYPayConfirmView(activity, this.a, this.b, this.d);
        }
        return (q7a) invokeL.objValue;
    }

    @Override // com.baidu.tieba.g5a
    public p7a c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            return new YYPayCampaignView(activity, this.a, this.b, this.d);
        }
        return (p7a) invokeL.objValue;
    }

    @Override // com.baidu.tieba.g5a
    public r7a d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) {
            return new YYPayGiftView(activity, this.a, this.b, this.d);
        }
        return (r7a) invokeL.objValue;
    }
}
