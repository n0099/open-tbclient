package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.channel.model.jy.JYNativeAdView;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.FunNativeAdListenerHelper;
import com.fun.ad.sdk.internal.api.ReporterPidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.GlideHelper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.win.opensdk.PBError;
import com.win.opensdk.PBNative;
import com.win.opensdk.PBNativeListener;
/* loaded from: classes4.dex */
public class fo9 extends ReporterPidLoader<PBNative> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FunNativeAdListenerHelper<PBNative, PBNativeListener> e;

    /* loaded from: classes4.dex */
    public class a implements PBNativeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PBNative a;
        public final /* synthetic */ fo9 b;

        public a(fo9 fo9Var, PBNative pBNative) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fo9Var, pBNative};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fo9Var;
            this.a = pBNative;
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LogPrinter.d();
                this.b.e.onAdClick(this.a);
            }
        }

        @Override // com.win.opensdk.PBNativeListener
        public void onDisplayed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                LogPrinter.d();
                this.b.e.onAdShow(this.a);
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pBError) == null) {
                LogPrinter.e("onFail code: " + pBError.getCode() + ", message: " + pBError.getMsg(), new Object[0]);
                this.b.onError(pBError.getCode(), pBError.getMsg());
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                LogPrinter.d();
                this.b.onAdLoaded((fo9) this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fo9(Ssp.Pid pid) {
        super(FunAdType.obtainType(pid, FunAdType.AdType.NATIVE), pid, true, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new FunNativeAdListenerHelper<>(this);
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        PBNative pBNative;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || (pBNative = (PBNative) obj) == null) {
            return;
        }
        this.e.destroy(pBNative);
        pBNative.destroy();
    }

    public JYNativeAdView e(PBNative pBNative) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pBNative)) == null) {
            JYNativeAdView jYNativeAdView = (JYNativeAdView) LayoutInflater.from(FunAdSdk.getAppContext()).inflate(R.layout.fun_jy_ad_native_view, (ViewGroup) null, false);
            jYNativeAdView.a.setText(pBNative.getBody());
            jYNativeAdView.d.setText(pBNative.getHeadline());
            GlideHelper.get().load(jYNativeAdView.getContext(), pBNative.getIcon(), jYNativeAdView.e);
            jYNativeAdView.f.setText(pBNative.getCallToAction());
            jYNativeAdView.g = (pBNative.getMediaViewWidth() * 1.0f) / (pBNative.getMediaViewHeight() * 1.0f);
            pBNative.registerViewForInteraction(jYNativeAdView, jYNativeAdView.c);
            return jYNativeAdView;
        }
        return (JYNativeAdView) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd2 getNativeAdInternal2(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, obj)) == null) {
            PBNative pBNative = (PBNative) obj;
            jo9 jo9Var = new jo9(context, pBNative);
            return new BaseNativeAd2(FunNativeAd2.NativeType.BOTH, pBNative, jo9Var, new go9(this, this, jo9Var));
        }
        return (FunNativeAd2) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean isAdAvailable(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            PBNative pBNative = (PBNative) obj;
            return pBNative != null && pBNative.isReady();
        }
        return invokeL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, funAdSlot) == null) {
            onLoadStart(funAdSlot);
            PBNative pBNative = new PBNative(context.getApplicationContext(), this.mPid.pid);
            pBNative.setNativeListener(new a(this, pBNative));
            pBNative.load();
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, activity, viewGroup, str, obj)) == null) {
            PBNative pBNative = (PBNative) obj;
            this.e.startShow(pBNative, str, this.mPid, null, null);
            JYNativeAdView e = e(pBNative);
            viewGroup.removeAllViews();
            viewGroup.addView(e);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
