package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cm9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.CustomInflater;
import com.fun.ad.sdk.ExpressInflater;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.FunNativeAd2Bridger;
import com.fun.ad.sdk.internal.api.FunNativeAdListenerHelper;
import com.fun.ad.sdk.internal.api.ReporterPidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes4.dex */
public class gm9 extends FunNativeAd2Bridger<pm9, com.fun.module.csj.g0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TTNativeAd.AdInteractionListener b;
    public final /* synthetic */ cm9 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gm9(cm9 cm9Var, ReporterPidLoader reporterPidLoader, pm9 pm9Var) {
        super(reporterPidLoader);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cm9Var, reporterPidLoader, pm9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ReporterPidLoader) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = cm9Var;
        this.b = new cm9.b(cm9Var, pm9Var);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'android.view.View' to match base method */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.fun.module.csj.g0, android.view.View] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public com.fun.module.csj.g0 createExpressView(pm9 pm9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pm9Var)) == null) ? dm9.a((TTNativeAd) pm9Var.a) : (View) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.CustomInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showCustom(Activity activity, CustomInflater customInflater, String str, pm9 pm9Var, BaseNativeAd2<pm9, com.fun.module.csj.g0> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, customInflater, str, pm9Var, baseNativeAd2, funAdInteractionListener}) == null) {
            this.c.g(activity, pm9Var, str, customInflater.inflate(), customInflater.getClickViews(), customInflater.getCreativeViews(), this.b, funAdInteractionListener);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.ExpressInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showExpress(Activity activity, ExpressInflater expressInflater, String str, pm9 pm9Var, BaseNativeAd2<pm9, com.fun.module.csj.g0> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Ssp.Pid pid;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, expressInflater, str, pm9Var, baseNativeAd2, funAdInteractionListener}) == null) {
            pm9 pm9Var2 = pm9Var;
            cm9 cm9Var = this.c;
            FunNativeAdListenerHelper<pm9, TTNativeAd.AdInteractionListener> funNativeAdListenerHelper = cm9Var.f;
            pid = cm9Var.mPid;
            funNativeAdListenerHelper.startShow(pm9Var2, str, pid, this.b, funAdInteractionListener);
            com.fun.module.csj.g0 expressView = baseNativeAd2.getExpressView();
            if (expressView != null) {
                this.c.f(activity, pm9Var2, expressInflater.inflate(), expressView, this.b);
            } else if (FunAdSdk.isLogEnabled()) {
                throw new RuntimeException("The image mode of ad is not support!");
            } else {
                LogPrinter.e("The image mode of ad is not support!", new Object[0]);
            }
        }
    }
}
