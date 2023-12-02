package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.AdRipper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.ad.sdk.internal.api.utils.PxUtils;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import java.util.List;
/* loaded from: classes6.dex */
public class i6c extends v5c<b6c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements KsLoadManager.FeedAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i6c a;

        public a(i6c i6cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i6cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i6cVar;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                LogPrinter.e("KSNativeExpressAd onError code: " + i + ", message: " + str, new Object[0]);
                this.a.onError(i, str);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                LogPrinter.d();
                if (list == null || list.isEmpty()) {
                    LogPrinter.e("onNativeAdLoad error: adList is null or empty", new Object[0]);
                    onError(0, "NoFill");
                    return;
                }
                KsFeedAd ksFeedAd = list.get(0);
                if (ksFeedAd != null) {
                    this.a.onAdLoaded(new b6c(ksFeedAd), new String[0]);
                    return;
                }
                LogPrinter.e("onNativeAdLoad error: ad is null or empty", new Object[0]);
                onError(0, "NoFill");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends w6c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final b6c a;
        public final View b;
        public final String c;
        public FunAdInteractionListener d;
        public boolean e;
        public boolean f;
        public final /* synthetic */ i6c g;

        public b(i6c i6cVar, b6c b6cVar, View view2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i6cVar, b6cVar, view2, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = i6cVar;
            this.a = b6cVar;
            this.b = view2;
            this.c = str;
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onAdClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LogPrinter.d();
                this.g.onAdClicked((i6c) this.a, this.f, new String[0]);
                this.f = true;
                FunAdInteractionListener funAdInteractionListener = this.d;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onAdClicked(this.c, this.g.mPid.ssp.type, this.g.mPid.pid);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                LogPrinter.d();
                this.g.onAdShow((i6c) this.a, this.e, new String[0]);
                this.e = true;
                FunAdInteractionListener funAdInteractionListener = this.d;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onAdShow(this.c, this.g.mPid.ssp.type, this.g.mPid.pid);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onDislikeClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.d();
                View view2 = this.b;
                if (view2 != null && view2.getParent() != null) {
                    ((ViewGroup) this.b.getParent()).removeView(this.b);
                }
                this.g.onAdClose(this.a);
                FunAdInteractionListener funAdInteractionListener = this.d;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onAdClose(this.c);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i6c(Ssp.Pid pid) {
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
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public AdRipper createAdRipper(Ssp.Pid pid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pid)) == null) ? new g6c(pid) : (AdRipper) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            b6c b6cVar = (b6c) obj;
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, funAdSlot) == null) {
            KsScene build = new KsScene.Builder(Long.parseLong(this.mPid.pid)).adNum(1).build();
            if (funAdSlot.getExpressWidth() != 0) {
                build.setWidth(PxUtils.dp2px(funAdSlot.getExpressWidth()));
            }
            if (funAdSlot.getExpressHeight() != 0) {
                build.setHeight(PxUtils.dp2px(funAdSlot.getExpressHeight()));
            }
            onLoadStart(funAdSlot);
            KsLoadManager loadManager = KsAdSDK.getLoadManager();
            if (loadManager == null) {
                onError(FunAdSdk.PLATFORM_KS);
            } else {
                loadManager.loadConfigFeedAd(build, new a(this));
            }
        }
    }

    public final View f(Context context, b6c b6cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, b6cVar)) == null) {
            View feedView = ((KsFeedAd) b6cVar.a).getFeedView(context);
            FrameLayout frameLayout = new FrameLayout(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            int dp2px = PxUtils.dp2px(10.0f);
            layoutParams.leftMargin = dp2px;
            layoutParams.rightMargin = dp2px;
            layoutParams.topMargin = dp2px;
            layoutParams.bottomMargin = dp2px;
            frameLayout.addView(feedView, layoutParams);
            return frameLayout;
        }
        return (View) invokeLL.objValue;
    }

    public final void h(b6c b6cVar, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, b6cVar, bVar) == null) {
            ((KsFeedAd) b6cVar.a).setAdInteractionListener(bVar);
            ((KsFeedAd) b6cVar.a).setVideoPlayConfig(new KsAdVideoPlayConfig.Builder().videoSoundEnable(FunAdSdk.getFunAdConfig().isVideoSoundEnable).dataFlowAutoStart(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart).build());
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd2 getNativeAdInternal2(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, context, str, obj)) == null) {
            return new BaseNativeAd2(FunNativeAd2.NativeType.EXPRESS, (b6c) obj, new l6c(this, this, context));
        }
        return (FunNativeAd2) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, activity, viewGroup, str, obj)) == null) {
            b6c b6cVar = (b6c) obj;
            View f = f(activity, b6cVar);
            onShowStart(b6cVar);
            h(b6cVar, new b(this, b6cVar, f, str));
            if (f.getParent() != null) {
                ((ViewGroup) f.getParent()).removeView(f);
            }
            viewGroup.removeAllViews();
            viewGroup.addView(f);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
