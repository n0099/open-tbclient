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
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.ExpressAdListenerWrapper;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class a2b extends h1b<t1b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<t1b, ExpressAdListenerWrapper<TTNativeExpressAd.ExpressAdInteractionListener>> g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a2b(Ssp.Pid pid) {
        super(FunAdType.obtainType(pid, FunAdType.AdType.NATIVE), pid);
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
                super((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new HashMap<>();
    }

    @Override // com.baidu.tieba.h1b
    public void f(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, funAdSlot) == null) {
            int expressWidth = funAdSlot.getExpressWidth();
            int expressHeight = funAdSlot.getExpressHeight();
            if (expressWidth == 0 && expressHeight == 0 && FunAdSdk.isLogEnabled()) {
                throw new RuntimeException("Invalid expressWidth and expressHeight.");
            }
            this.e.loadNativeExpressAd(new AdSlot.Builder().setCodeId(this.mPid.pid).setSupportDeepLink(true).setAdCount(1).setExpressViewAcceptedSize(expressWidth, expressHeight).build(), new a(this, funAdSlot));
        }
    }

    /* loaded from: classes4.dex */
    public class a implements TTAdNative.NativeExpressAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FunAdSlot a;
        public final /* synthetic */ a2b b;

        public a(a2b a2bVar, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a2bVar, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a2bVar;
            this.a = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                LogPrinter.e("CSJNativeExpressAd onError code: " + i + ", message: " + str, new Object[0]);
                this.b.onError(i, str);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v4, resolved type: com.bytedance.sdk.openadsdk.TTNativeExpressAd */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [A, com.bytedance.sdk.openadsdk.TTNativeExpressAd$ExpressAdInteractionListener, com.baidu.tieba.d2b] */
        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                LogPrinter.e("CSJNativeExpressAd onNativeExpressAdLoad", new Object[0]);
                if (list != null && !list.isEmpty()) {
                    TTNativeExpressAd tTNativeExpressAd = list.get(0);
                    a2b a2bVar = this.b;
                    t1b t1bVar = new t1b(tTNativeExpressAd);
                    String sid = this.a.getSid();
                    a2bVar.getClass();
                    ExpressAdListenerWrapper expressAdListenerWrapper = new ExpressAdListenerWrapper();
                    ?? d2bVar = new d2b(a2bVar, t1bVar, expressAdListenerWrapper, sid);
                    expressAdListenerWrapper.listener = d2bVar;
                    tTNativeExpressAd.setExpressInteractionListener((TTNativeExpressAd.ExpressAdInteractionListener) d2bVar);
                    tTNativeExpressAd.setCanInterruptVideoPlay(true);
                    tTNativeExpressAd.render();
                    return;
                }
                LogPrinter.e("CSJNativeExpressAd onNativeExpressAdLoad error: adList is null or empty", new Object[0]);
                this.b.onError(0, "NoFill");
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            t1b t1bVar = (t1b) obj;
            this.g.remove(t1bVar);
            if (t1bVar != null) {
                ((TTNativeExpressAd) t1bVar.a).destroy();
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd2 getNativeAdInternal2(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, obj)) == null) {
            return new BaseNativeAd2(FunNativeAd2.NativeType.EXPRESS, (t1b) obj, new g2b(this, this));
        }
        return (FunNativeAd2) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, activity, viewGroup, str, obj)) == null) {
            t1b t1bVar = (t1b) obj;
            View expressAdView = ((TTNativeExpressAd) t1bVar.a).getExpressAdView();
            if (expressAdView != null && expressAdView.getParent() != null) {
                ((ViewGroup) expressAdView.getParent()).removeView(expressAdView);
            }
            onShowStart(t1bVar);
            ((TTNativeExpressAd) t1bVar.a).setDislikeCallback(activity, new f2b(this, expressAdView, t1bVar, null, str));
            viewGroup.removeAllViews();
            viewGroup.addView(expressAdView);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
