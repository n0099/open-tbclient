package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.FunNativeView;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.FunNativeAdListenerHelper;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.AdRipper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.ad.sdk.internal.api.utils.NumberUtils;
import com.fun.ad.sdk.internal.api.utils.PxUtils;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ibb extends rab<xab> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FunNativeAdListenerHelper<xab, KsNativeAd.AdInteractionListener> f;

    /* loaded from: classes6.dex */
    public class a implements KsLoadManager.NativeAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ibb a;

        public a(ibb ibbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ibbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ibbVar;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                LogPrinter.e("onError code: " + i + ", message: " + str, new Object[0]);
                this.a.onError(i, str);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                LogPrinter.d();
                if (list == null || list.isEmpty()) {
                    LogPrinter.e("error: adList is null or empty", new Object[0]);
                    this.a.onError(0, "NoFill");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (KsNativeAd ksNativeAd : list) {
                    if (ksNativeAd != null) {
                        arrayList.add(new xab(ksNativeAd));
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.a.onAdLoaded(arrayList);
                    return;
                }
                LogPrinter.e("onDrawAdLoad error: adList is null or empty", new Object[0]);
                onError(0, "NoFill");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ibb(Ssp.Pid pid) {
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
        this.f = new FunNativeAdListenerHelper<>(this);
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public AdRipper createAdRipper(Ssp.Pid pid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pid)) == null) ? new fbb(pid) : (AdRipper) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, funAdSlot) == null) {
            KsScene build = new KsScene.Builder(Long.parseLong(this.mPid.pid)).adNum(NumberUtils.adjustInt(funAdSlot.getAdCount(), 1, 5)).build();
            if (funAdSlot.getExpressWidth() != 0 && funAdSlot.getExpressHeight() != 0) {
                build.setWidth(PxUtils.dp2px(funAdSlot.getExpressWidth()));
                build.setHeight(PxUtils.dp2px(funAdSlot.getExpressHeight()));
            }
            onLoadStart(funAdSlot);
            KsLoadManager loadManager = KsAdSDK.getLoadManager();
            if (loadManager == null) {
                onError(FunAdSdk.PLATFORM_KS);
            } else {
                loadManager.loadNativeAd(build, new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends tbb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final xab a;
        public final /* synthetic */ ibb b;

        public b(ibb ibbVar, xab xabVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ibbVar, xabVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ibbVar;
            this.a = xabVar;
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, onClickListener)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdClicked(View view2, KsNativeAd ksNativeAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ksNativeAd) == null) {
                this.b.f.onAdClick(this.a);
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdShow(KsNativeAd ksNativeAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ksNativeAd) == null) {
                this.b.f.onAdShow(this.a);
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        xab xabVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) && (xabVar = (xab) obj) != null) {
            this.f.destroy(xabVar);
        }
    }

    public final com.fun.module.ks.y f(Context context, xab xabVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, xabVar)) == null) {
            int materialType = ((KsNativeAd) xabVar.a).getMaterialType();
            int i = R.layout.fun_ks_ad_native_single_img_h5_open_view;
            if (materialType != 1) {
                if (materialType != 2) {
                    if (materialType == 3) {
                        int interactionType = ((KsNativeAd) xabVar.a).getInteractionType();
                        if (interactionType != 1) {
                            if (interactionType == 2) {
                                i = R.layout.fun_ks_ad_native_group_img_h5_open_view;
                            }
                        } else {
                            i = R.layout.fun_ks_ad_native_group_img_app_download_view;
                        }
                    }
                } else if (((KsNativeAd) xabVar.a).getInteractionType() == 1) {
                    i = R.layout.fun_ks_ad_native_single_img_app_download_view;
                }
            } else {
                int interactionType2 = ((KsNativeAd) xabVar.a).getInteractionType();
                if (interactionType2 != 1) {
                    if (interactionType2 == 2) {
                        i = R.layout.fun_ks_ad_native_video_h5_open_view;
                    }
                } else {
                    i = R.layout.fun_ks_ad_native_video_app_download_view;
                }
            }
            com.fun.module.ks.y yVar = (com.fun.module.ks.y) LayoutInflater.from(context).inflate(i, (ViewGroup) null, false);
            yVar.a((KsNativeAd) xabVar.a);
            return yVar;
        }
        return (com.fun.module.ks.y) invokeLL.objValue;
    }

    /* JADX DEBUG: Incorrect args count in method signature: (Landroid/content/Context;Lcom/baidu/tieba/xab;Ljava/lang/String;Landroid/view/ViewGroup;Ljava/util/List<Landroid/view/View;>;Lcom/baidu/tieba/ibb$b;Lcom/fun/ad/sdk/FunAdInteractionListener;)V */
    public void g(xab xabVar, String str, ViewGroup viewGroup, List list, b bVar, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{xabVar, str, viewGroup, list, bVar, funAdInteractionListener}) == null) {
            this.f.startShow(xabVar, str, this.mPid, bVar, funAdInteractionListener);
            if (viewGroup instanceof FunNativeView) {
                viewGroup = ((FunNativeView) viewGroup).getRoot();
            }
            ((KsNativeAd) xabVar.a).registerViewForInteraction(viewGroup, list, bVar);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd getNativeAdInternal(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, str, obj)) == null) {
            return new xbb(context, (xab) obj, str, this.mPid, this);
        }
        return (FunNativeAd) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd2 getNativeAdInternal2(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, context, str, obj)) == null) {
            xab xabVar = (xab) obj;
            return new BaseNativeAd2(FunNativeAd2.NativeType.BOTH, xabVar, new xbb(context, xabVar, str, this.mPid, this), new nbb(this, this, xabVar, context));
        }
        return (FunNativeAd2) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, activity, viewGroup, str, obj)) == null) {
            xab xabVar = (xab) obj;
            onShowStart(xabVar);
            com.fun.module.ks.y f = f(activity, xabVar);
            ((KsNativeAd) xabVar.a).registerViewForInteraction(f, f.getClickViews(), new lbb(this, xabVar));
            viewGroup.removeAllViews();
            viewGroup.addView(f);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
