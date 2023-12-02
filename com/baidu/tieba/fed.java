package com.baidu.tieba;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fgd;
import com.baidu.tieba.ggd;
import com.baidu.tieba.hgd;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.impl.YYPayAmountView;
import tv.athena.revenue.payui.view.impl.YYPayCampaignView;
import tv.athena.revenue.payui.view.impl.YYPayConfirmView;
import tv.athena.revenue.payui.view.impl.YYPayGiftView;
import tv.athena.revenue.payui.view.impl.YYPayResultView;
import tv.athena.revenue.payui.view.impl.YYPaySignView;
import tv.athena.revenue.payui.view.impl.YYPaySplitOrderView;
import tv.athena.revenue.payui.view.impl.YYPayWayView;
/* loaded from: classes5.dex */
public class fed implements zcd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public PayUIKitConfig c;

    public fed(int i, int i2, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), payUIKitConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PayFlowViewImpl", "create PayViewImpl mAppId:" + i + " mUserChannel:" + i2);
        this.a = i;
        this.b = i2;
        this.c = payUIKitConfig;
    }

    @Override // com.baidu.tieba.zcd
    public IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, wcd wcdVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, viewParams, wcdVar)) == null) {
            return new YYPayAmountView(activity, this.a, this.b, this.c, viewParams, wcdVar);
        }
        return (IYYPayAmountView) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.zcd
    public IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, wcd wcdVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, activity, cVar, wcdVar)) == null) {
            return new YYPayResultView(activity, this.c, this.a, this.b, cVar, wcdVar);
        }
        return (IYYPayResultView) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.zcd
    public fgd f(Activity activity, fgd.b bVar, PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, activity, bVar, payUIKitConfig)) == null) {
            return new YYPaySignView(activity, bVar, payUIKitConfig, this.a, this.b);
        }
        return (fgd) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.zcd
    public hgd g(Activity activity, hgd.b bVar, bdd bddVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, activity, bVar, bddVar)) == null) {
            return new YYPayWayView(activity, this.a, this.b, bVar, this.c, bddVar);
        }
        return (hgd) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.zcd
    public dgd b(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) {
            return new YYPayConfirmView(activity, this.a, this.b, this.c);
        }
        return (dgd) invokeL.objValue;
    }

    @Override // com.baidu.tieba.zcd
    public cgd c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            return new YYPayCampaignView(activity, this.a, this.b, this.c);
        }
        return (cgd) invokeL.objValue;
    }

    @Override // com.baidu.tieba.zcd
    public egd d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) {
            return new YYPayGiftView(activity, this.a, this.b, this.c);
        }
        return (egd) invokeL.objValue;
    }

    @Override // com.baidu.tieba.zcd
    public ggd h(Activity activity, PayUIKitConfig payUIKitConfig, ggd.b bVar, bdd bddVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, activity, payUIKitConfig, bVar, bddVar)) == null) {
            return new YYPaySplitOrderView(activity, payUIKitConfig, this.a, this.b, bVar, bddVar);
        }
        return (ggd) invokeLLLL.objValue;
    }
}
