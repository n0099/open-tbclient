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
/* loaded from: classes3.dex */
public class e4a implements f3a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public l4a c;
    public PayUIKitConfig d;

    public e4a(int i, int i2, l4a l4aVar, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), l4aVar, payUIKitConfig};
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
        this.c = l4aVar;
        this.d = payUIKitConfig;
    }

    @Override // com.baidu.tieba.f3a
    public IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, b3a b3aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, viewParams, b3aVar)) == null) ? new YYPayAmountView(activity, this.a, this.b, this.d, viewParams, this.c, b3aVar) : (IYYPayAmountView) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.f3a
    public p5a b(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) ? new YYPayConfirmView(activity, this.a, this.b, this.d) : (p5a) invokeL.objValue;
    }

    @Override // com.baidu.tieba.f3a
    public o5a c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) ? new YYPayCampaignView(activity, this.a, this.b, this.d) : (o5a) invokeL.objValue;
    }

    @Override // com.baidu.tieba.f3a
    public q5a d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) ? new YYPayGiftView(activity, this.a, this.b, this.d) : (q5a) invokeL.objValue;
    }

    @Override // com.baidu.tieba.f3a
    public IYYPayWayView e(Activity activity, IYYPayWayView.b bVar, b3a b3aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, activity, bVar, b3aVar)) == null) ? new YYPayWayView(activity, this.a, this.b, bVar, this.c, this.d, b3aVar) : (IYYPayWayView) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.f3a
    public IYYPayResultView f(Activity activity, IYYPayResultView.c cVar, b3a b3aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, activity, cVar, b3aVar)) == null) ? new YYPayResultView(activity, this.d, this.c, this.a, this.b, cVar, b3aVar) : (IYYPayResultView) invokeLLL.objValue;
    }
}
