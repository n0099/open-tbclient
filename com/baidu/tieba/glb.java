package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.FunNativeAdListenerHelper;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.AdRipper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class glb extends flb<vkb> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FunNativeAdListenerHelper<vkb, okb> e;

    /* loaded from: classes6.dex */
    public class a implements BaiduNativeManager.ExpressAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ glb a;

        public a(glb glbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {glbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = glbVar;
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onLpClosed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LogPrinter.d();
            }
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onNativeFail(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                LogPrinter.d();
                this.a.onError(i, str);
            }
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onNativeLoad(List<ExpressResponse> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
                if (list == null || list.isEmpty()) {
                    this.a.onError(0, "NoFill");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (ExpressResponse expressResponse : list) {
                    arrayList.add(new vkb(expressResponse));
                }
                this.a.onAdLoaded(arrayList);
            }
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onNoAd(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
                LogPrinter.d();
                this.a.onError(i, str);
            }
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onVideoDownloadFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                LogPrinter.d();
            }
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onVideoDownloadSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                LogPrinter.d();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public glb(Ssp.Pid pid) {
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
        this.e = new FunNativeAdListenerHelper<>(this);
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public AdRipper createAdRipper(Ssp.Pid pid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pid)) == null) ? new ykb(pid) : (AdRipper) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        vkb vkbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) && (vkbVar = (vkb) obj) != null) {
            this.e.destroy(vkbVar);
            vkbVar.a = null;
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd2 getNativeAdInternal2(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, obj)) == null) {
            return new BaseNativeAd2(FunNativeAd2.NativeType.EXPRESS, (vkb) obj, new llb(this, this));
        }
        return (FunNativeAd2) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, funAdSlot) == null) {
            onLoadStart(funAdSlot);
            new BaiduNativeManager(context.getApplicationContext(), this.mPid.pid).loadExpressAd(new RequestParameters.Builder().downloadAppConfirmPolicy(1).build(), new a(this));
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        ViewGroup.LayoutParams layoutParams;
        Rect rect;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, activity, viewGroup, str, obj)) == null) {
            vkb vkbVar = (vkb) obj;
            this.e.startShow(vkbVar, str, this.mPid, null, null);
            View b = mkb.b(vkbVar.a, new jlb(this, vkbVar));
            if (b == null) {
                onAdError(vkbVar, "ExpressView Null");
                return false;
            }
            ExpressResponse expressResponse = vkbVar.a;
            if (expressResponse != null && activity != null) {
                expressResponse.bindInteractionActivity(activity);
            }
            ViewGroup viewGroup2 = (ViewGroup) b.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(b);
            }
            if (vkbVar.a.getStyleType() == 41) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) FunAdSdk.getAppContext().getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay().getRealMetrics(displayMetrics);
                if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                    rect = new Rect(0, 0, displayMetrics.heightPixels, displayMetrics.widthPixels);
                } else {
                    rect = new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
                layoutParams = new ViewGroup.LayoutParams((rect.width() * 3) / 4, -2);
            } else {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
            }
            viewGroup.addView(b, layoutParams);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
