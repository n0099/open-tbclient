package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes5.dex */
public class bgb extends ogb<dhb> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements TTAdNative.SplashAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bgb a;

        public a(bgb bgbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bgbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bgbVar;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        @MainThread
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                LogPrinter.e("CSJSplashAd onError code: " + i + ", message: " + str, new Object[0]);
                this.a.onError(i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
        @MainThread
        public void onSplashAdLoad(TTSplashAd tTSplashAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tTSplashAd) == null) {
                LogPrinter.d();
                tTSplashAd.getMediaExtraInfo();
                this.a.onAdLoaded(new dhb(tTSplashAd), new String[0]);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
        @MainThread
        public void onTimeout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.e();
                this.a.onError(0, "Load Timeout");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements TTSplashAd.AdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final dhb a;
        public final String b;
        public boolean c;
        public boolean d;
        public final /* synthetic */ bgb e;

        public b(bgb bgbVar, dhb dhbVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bgbVar, dhbVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = bgbVar;
            this.a = dhbVar;
            this.b = str;
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdClicked(View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) {
                LogPrinter.d();
                this.e.onAdClicked((bgb) this.a, this.d, new String[0]);
                this.d = true;
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdShow(View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i) == null) {
                LogPrinter.d();
                this.e.onAdShow((bgb) this.a, this.c, new String[0]);
                this.c = true;
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdSkip() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.d();
                this.e.onAdClose(this.a);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdTimeOver() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                LogPrinter.d();
                this.e.onAdClose(this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bgb(Ssp.Pid pid) {
        super(FunAdType.obtainType(pid, FunAdType.AdType.SPLASH), pid, false, true);
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
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            dhb dhbVar = (dhb) obj;
        }
    }

    @Override // com.baidu.tieba.ogb
    public void f(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, funAdSlot) == null) {
            int expressHeight = (int) ((funAdSlot.getExpressHeight() * context.getResources().getDisplayMetrics().density) + 0.5f);
            this.e.loadSplashAd(new AdSlot.Builder().setCodeId(this.mPid.pid).setSupportDeepLink(true).setImageAcceptedSize((int) ((funAdSlot.getExpressWidth() * context.getResources().getDisplayMetrics().density) + 0.5f), expressHeight).setExpressViewAcceptedSize(funAdSlot.getExpressWidth(), funAdSlot.getExpressHeight()).build(), new a(this), 5000);
        }
    }

    public final boolean m(ViewGroup viewGroup, dhb dhbVar, TTSplashAd.AdInteractionListener adInteractionListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, dhbVar, adInteractionListener)) == null) {
            View splashView = ((TTSplashAd) dhbVar.a).getSplashView();
            Log.d("feifei", "price:" + dhbVar.a());
            if (splashView.getParent() != null) {
                ((ViewGroup) splashView.getParent()).removeView(splashView);
            }
            viewGroup.removeAllViews();
            viewGroup.addView(splashView);
            onShowStart(dhbVar);
            ((TTSplashAd) dhbVar.a).setSplashInteractionListener(adInteractionListener);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, activity, viewGroup, str, obj)) == null) {
            dhb dhbVar = (dhb) obj;
            m(viewGroup, dhbVar, new b(this, dhbVar, str));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunSplashAd showSplashInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, activity, viewGroup, str, obj)) == null) {
            dhb dhbVar = (dhb) obj;
            lgb lgbVar = new lgb((TTSplashAd) dhbVar.a);
            m(viewGroup, dhbVar, new dgb(this, dhbVar, str, lgbVar));
            return lgbVar;
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }
}
