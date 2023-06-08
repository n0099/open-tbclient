package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.FunNativeView;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.FunNativeAdListenerHelper;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.ad.sdk.internal.api.utils.NumberUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a1b extends h1b<n1b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FunNativeAdListenerHelper<n1b, TTNativeAd.AdInteractionListener> g;

    /* loaded from: classes4.dex */
    public class a implements TTAdNative.NativeAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a1b a;

        public a(a1b a1bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a1bVar;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                LogPrinter.e("onError code: " + i + ", message: " + str, new Object[0]);
                this.a.onError(i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
        public void onNativeAdLoad(List<TTNativeAd> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                LogPrinter.d("onNativeAdLoad", new Object[0]);
                if (list == null || list.isEmpty()) {
                    LogPrinter.e("onNativeAdLoad error: list is null or empty", new Object[0]);
                    this.a.onError(0, "NoFill");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (TTNativeAd tTNativeAd : list) {
                    arrayList.add(new n1b(tTNativeAd));
                }
                this.a.onAdLoaded(arrayList);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a1b(FunAdType funAdType, Ssp.Pid pid) {
        super(funAdType, pid, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {funAdType, pid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new FunNativeAdListenerHelper<>(this);
    }

    @Override // com.baidu.tieba.h1b
    public void f(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, funAdSlot) == null) {
            l(funAdSlot);
        }
    }

    public void l(FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, funAdSlot) == null) {
            AdSlot.Builder supportDeepLink = new AdSlot.Builder().setCodeId(this.mPid.pid).setSupportDeepLink(true);
            Ssp.Pid pid = this.mPid;
            this.e.loadNativeAd(supportDeepLink.setImageAcceptedSize(pid.width, pid.height).setNativeAdType(1).setAdCount(NumberUtils.adjustInt(funAdSlot.getAdCount(), 1, 3)).build(), new a(this));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements TTNativeAd.AdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final n1b a;
        public final /* synthetic */ a1b b;

        public b(a1b a1bVar, n1b n1bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1bVar, n1bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a1bVar;
            this.a = n1bVar;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdClicked(View view2, TTNativeAd tTNativeAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, tTNativeAd) == null) {
                LogPrinter.d();
                this.b.g.onAdClick(this.a);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdCreativeClick(View view2, TTNativeAd tTNativeAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, tTNativeAd) == null) {
                LogPrinter.d();
                this.b.g.onAdClick(this.a);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdShow(TTNativeAd tTNativeAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tTNativeAd) == null) {
                LogPrinter.d();
                this.b.g.onAdShow(this.a);
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            this.g.destroy((n1b) obj);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd getNativeAdInternal(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, obj)) == null) {
            return new c1b((n1b) obj, str, this.mPid, this);
        }
        return (FunNativeAd) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd2 getNativeAdInternal2(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, context, str, obj)) == null) {
            n1b n1bVar = (n1b) obj;
            return new BaseNativeAd2(FunNativeAd2.NativeType.BOTH, n1bVar, new c1b(n1bVar, str, this.mPid, this), new f1b(this, this, n1bVar));
        }
        return (FunNativeAd2) invokeLLL.objValue;
    }

    public void j(Activity activity, n1b n1bVar, ViewGroup viewGroup, com.fun.module.csj.f0 f0Var, TTNativeAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, activity, n1bVar, viewGroup, f0Var, adInteractionListener) == null) {
            ((TTNativeAd) n1bVar.a).setActivityForDownloadApp(activity);
            ((TTNativeAd) n1bVar.a).registerViewForInteraction(viewGroup, f0Var.getClickViews(), f0Var.getCreativeViews(), adInteractionListener);
            ((TTNativeAd) n1bVar.a).setDownloadListener(f0Var.getDownloadListener());
        }
    }

    public final void k(Context context, n1b n1bVar, String str, ViewGroup viewGroup, List<View> list, List<View> list2, TTNativeAd.AdInteractionListener adInteractionListener, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, n1bVar, str, viewGroup, list, list2, adInteractionListener, funAdInteractionListener}) == null) {
            if (viewGroup instanceof FunNativeView) {
                viewGroup = ((FunNativeView) viewGroup).getRoot();
            }
            this.g.startShow(n1bVar, str, this.mPid, adInteractionListener, funAdInteractionListener);
            if (context instanceof Activity) {
                ((TTNativeAd) n1bVar.a).setActivityForDownloadApp((Activity) context);
            }
            if (list == null) {
                list = new ArrayList<>();
            }
            if (list2 == null) {
                list2 = new ArrayList<>();
            }
            ((TTNativeAd) n1bVar.a).registerViewForInteraction(viewGroup, list, list2, adInteractionListener);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    /* renamed from: p */
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, n1b n1bVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, activity, viewGroup, str, n1bVar)) == null) {
            onShowStart(n1bVar);
            com.fun.module.csj.f0 a2 = b1b.a((TTNativeAd) n1bVar.a);
            if (a2 == null) {
                onAdError(n1bVar, 0, "AdView present failed");
                return false;
            }
            viewGroup.removeAllViews();
            viewGroup.addView(a2);
            j(activity, n1bVar, viewGroup, a2, new d1b(this, n1bVar, null, str));
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
