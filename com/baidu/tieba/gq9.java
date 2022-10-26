package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.eq9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.CustomInflater;
import com.fun.ad.sdk.ExpressInflater;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.FunNativeAd2Bridger;
import com.fun.ad.sdk.internal.api.ReporterPidLoader;
import com.kwad.sdk.api.KsNativeAd;
/* loaded from: classes4.dex */
public class gq9 extends FunNativeAd2Bridger {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final eq9.b b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ eq9 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gq9(eq9 eq9Var, ReporterPidLoader reporterPidLoader, KsNativeAd ksNativeAd, Context context) {
        super(reporterPidLoader);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eq9Var, reporterPidLoader, ksNativeAd, context};
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
        this.d = eq9Var;
        this.c = context;
        this.b = new eq9.b(eq9Var, ksNativeAd);
    }

    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public View createExpressView(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            return this.d.e(this.c, (KsNativeAd) obj);
        }
        return (View) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showCustom(Activity activity, CustomInflater customInflater, String str, Object obj, BaseNativeAd2 baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, customInflater, str, obj, baseNativeAd2, funAdInteractionListener}) == null) {
            this.d.i((KsNativeAd) obj, str, customInflater.inflate(), customInflater.getClickViews(), this.b, funAdInteractionListener);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showExpress(Activity activity, ExpressInflater expressInflater, String str, Object obj, BaseNativeAd2 baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, expressInflater, str, obj, baseNativeAd2, funAdInteractionListener}) == null) {
            this.d.i((KsNativeAd) obj, str, expressInflater.inflate(), ((com.fun.module.ks.x) baseNativeAd2.getExpressView()).getClickViews(), this.b, funAdInteractionListener);
        }
    }
}
