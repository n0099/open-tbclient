package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.x4b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.ChannelNativeAds;
import com.fun.ad.sdk.CustomInflater;
import com.fun.ad.sdk.ExpressInflater;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunNativeView;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.FunNativeAd2Bridger;
import com.fun.ad.sdk.internal.api.FunNativeAdListenerHelper;
import com.fun.ad.sdk.internal.api.ReporterPidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import java.lang.ref.WeakReference;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class b5b extends FunNativeAd2Bridger<n5b, com.fun.module.gdt.t> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final x4b.c b;
    public final /* synthetic */ i5b c;
    public final /* synthetic */ x4b d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b5b(x4b x4bVar, ReporterPidLoader reporterPidLoader, n5b n5bVar, String str, i5b i5bVar) {
        super(reporterPidLoader);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x4bVar, reporterPidLoader, n5bVar, str, i5bVar};
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
        this.d = x4bVar;
        this.c = i5bVar;
        this.b = new x4b.c(x4bVar, n5bVar, str);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.ExpressInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public /* bridge */ /* synthetic */ void showExpress(Activity activity, ExpressInflater expressInflater, String str, n5b n5bVar, BaseNativeAd2<n5b, com.fun.module.gdt.t> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        a(expressInflater, str, n5bVar, funAdInteractionListener);
    }

    public static void b(com.fun.module.gdt.t tVar, n5b n5bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, tVar, n5bVar) == null) {
            tVar.b((NativeUnifiedADData) n5bVar.a);
        }
    }

    /* JADX DEBUG: Incorrect args count in method signature: (Landroid/app/Activity;Lcom/fun/ad/sdk/ExpressInflater;Ljava/lang/String;Lcom/baidu/tieba/n5b;Lcom/fun/ad/sdk/internal/api/BaseNativeAd2<Lcom/baidu/tieba/n5b;Lcom/fun/module/gdt/t;>;Lcom/fun/ad/sdk/FunAdInteractionListener;)V */
    public void a(ExpressInflater expressInflater, String str, final n5b n5bVar, FunAdInteractionListener funAdInteractionListener) {
        Ssp.Pid pid;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, expressInflater, str, n5bVar, funAdInteractionListener) == null) {
            final com.fun.module.gdt.t tVar = (com.fun.module.gdt.t) expressInflater.getExpressView();
            x4b x4bVar = this.d;
            FunNativeAdListenerHelper<n5b, NativeADEventListener> funNativeAdListenerHelper = x4bVar.e;
            pid = x4bVar.mPid;
            funNativeAdListenerHelper.startShow(n5bVar, str, pid, this.b, funAdInteractionListener);
            this.b.d = new x4b.e() { // from class: com.baidu.tieba.g4b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.x4b.e
                public final void onADStatusChanged() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        b5b.b(com.fun.module.gdt.t.this, n5bVar);
                    }
                }
            };
            this.d.n(tVar, n5bVar, this.b);
            expressInflater.inflate();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'android.view.View' to match base method */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View, com.fun.module.gdt.t] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public com.fun.module.gdt.t createExpressView(n5b n5bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n5bVar)) == null) {
            return this.d.g(FunAdSdk.getAppContext(), (NativeUnifiedADData) n5bVar.a);
        }
        return (View) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.CustomInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showCustom(Activity activity, CustomInflater customInflater, String str, n5b n5bVar, BaseNativeAd2<n5b, com.fun.module.gdt.t> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        NativeAdContainer nativeAdContainer;
        NativeAdContainer nativeAdContainer2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, customInflater, str, n5bVar, baseNativeAd2, funAdInteractionListener}) == null) {
            n5b n5bVar2 = n5bVar;
            ChannelNativeAds.GdtADStatusChangeListener gdtADStatusChangeListener = this.c.c.getGdtADStatusChangeListener();
            if (gdtADStatusChangeListener != null) {
                this.b.d = new a5b(this, gdtADStatusChangeListener);
            } else {
                this.b.d = null;
            }
            ViewGroup inflate = customInflater.inflate();
            if (inflate instanceof FunNativeView) {
                FunNativeView funNativeView = (FunNativeView) inflate;
                Iterator<WeakReference<NativeAdContainer>> it = i4b.b.a.iterator();
                while (it.hasNext()) {
                    NativeAdContainer nativeAdContainer3 = it.next().get();
                    if (nativeAdContainer3 == null) {
                        it.remove();
                    } else if (nativeAdContainer3 == funNativeView.getRoot()) {
                        it.remove();
                        nativeAdContainer2 = nativeAdContainer3;
                        break;
                    }
                }
                if (funNativeView.getRoot() instanceof NativeAdContainer) {
                    nativeAdContainer = (NativeAdContainer) funNativeView.getRoot();
                    nativeAdContainer2 = nativeAdContainer;
                }
                nativeAdContainer2 = null;
            } else {
                if (inflate instanceof NativeAdContainer) {
                    nativeAdContainer = (NativeAdContainer) inflate;
                    nativeAdContainer2 = nativeAdContainer;
                }
                nativeAdContainer2 = null;
            }
            this.d.q(n5bVar2, str, nativeAdContainer2, this.c.d, customInflater.getClickViews(), this.b, funAdInteractionListener);
        }
    }
}
