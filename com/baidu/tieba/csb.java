package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.CustomInflater;
import com.fun.ad.sdk.ExpressInflater;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunNativeView;
import com.fun.ad.sdk.channel.model.jy.JYNativeAdView;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.FunNativeAd2Bridger;
import com.fun.ad.sdk.internal.api.FunNativeAdListenerHelper;
import com.fun.ad.sdk.internal.api.ReporterPidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.win.opensdk.PBMediaView;
import com.win.opensdk.PBNative;
import com.win.opensdk.PBNativeListener;
/* loaded from: classes5.dex */
public class csb extends FunNativeAd2Bridger<PBNative, JYNativeAdView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ fsb b;
    public final /* synthetic */ bsb c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public csb(bsb bsbVar, ReporterPidLoader reporterPidLoader, fsb fsbVar) {
        super(reporterPidLoader);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bsbVar, reporterPidLoader, fsbVar};
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
        this.c = bsbVar;
        this.b = fsbVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'android.view.View' to match base method */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.fun.ad.sdk.channel.model.jy.JYNativeAdView, android.view.View] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public JYNativeAdView createExpressView(PBNative pBNative) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pBNative)) == null) {
            return this.c.e(pBNative);
        }
        return (View) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.CustomInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showCustom(Activity activity, CustomInflater customInflater, String str, PBNative pBNative, BaseNativeAd2<PBNative, JYNativeAdView> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Ssp.Pid pid;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, customInflater, str, pBNative, baseNativeAd2, funAdInteractionListener}) == null) {
            PBNative pBNative2 = pBNative;
            bsb bsbVar = this.c;
            FunNativeAdListenerHelper<PBNative, PBNativeListener> funNativeAdListenerHelper = bsbVar.e;
            pid = bsbVar.mPid;
            funNativeAdListenerHelper.startShow(pBNative2, str, pid, null, funAdInteractionListener);
            ViewGroup inflate = customInflater.inflate();
            if (inflate instanceof FunNativeView) {
                inflate = ((FunNativeView) inflate).getRoot();
            }
            pBNative2.registerViewForInteraction(inflate, (PBMediaView) this.b.getVideoView(), customInflater.getClickViews());
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.ExpressInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showExpress(Activity activity, ExpressInflater expressInflater, String str, PBNative pBNative, BaseNativeAd2<PBNative, JYNativeAdView> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Ssp.Pid pid;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, expressInflater, str, pBNative, baseNativeAd2, funAdInteractionListener}) == null) {
            bsb bsbVar = this.c;
            FunNativeAdListenerHelper<PBNative, PBNativeListener> funNativeAdListenerHelper = bsbVar.e;
            pid = bsbVar.mPid;
            funNativeAdListenerHelper.startShow(pBNative, str, pid, null, funAdInteractionListener);
            expressInflater.inflate();
        }
    }
}
