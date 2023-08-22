package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.ChannelNativeAds;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.channel.model.gdt.GDTNativeUnifiedVideoView;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.FunNativeAdListenerHelper;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.AdRipper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.ad.sdk.internal.api.utils.NumberUtils;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class eob extends vnb<uob> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FunNativeAdListenerHelper<uob, NativeADEventListener> e;

    /* loaded from: classes5.dex */
    public class a implements NativeADUnifiedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eob a;

        public a(eob eobVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eobVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eobVar;
        }

        @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
        public void onADLoaded(List<NativeUnifiedADData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                LogPrinter.d();
                if (list == null || list.isEmpty()) {
                    LogPrinter.e("onADLoaded error: adList is null or empty", new Object[0]);
                    this.a.onError(0, "NoFill");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (NativeUnifiedADData nativeUnifiedADData : list) {
                    arrayList.add(new uob(nativeUnifiedADData));
                }
                this.a.onAdLoaded(arrayList);
            }
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adError) == null) {
                LogPrinter.e("onError code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg(), new Object[0]);
                this.a.onError(adError.getErrorCode(), adError.getErrorMsg());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements NativeADMediaListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoError(AdError adError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adError) == null) {
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoInit() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoaded(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoading() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements NativeADEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final uob a;
        public boolean b;
        public boolean c;
        public e d;
        public final /* synthetic */ eob e;

        public d(eob eobVar, uob uobVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eobVar, uobVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = eobVar;
            this.a = uobVar;
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LogPrinter.d();
                this.e.onAdClicked((eob) this.a, this.c, new String[0]);
                this.c = true;
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADError(AdError adError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adError) == null) {
                LogPrinter.d();
                this.e.onAdError(this.a, adError.getErrorCode(), adError.getErrorMsg());
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADExposed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.d();
                this.e.onAdShow((eob) this.a, this.b, new String[0]);
                this.b = true;
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADStatusChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                LogPrinter.d();
                e eVar = this.d;
                if (eVar != null) {
                    eVar.onADStatusChanged();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void onADStatusChanged();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eob(Ssp.Pid pid) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(uob uobVar, View view2) {
        onAdClicked((eob) uobVar, true, new String[0]);
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public AdRipper createAdRipper(Ssp.Pid pid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pid)) == null) ? new unb(pid) : (AdRipper) invokeL.objValue;
    }

    @Override // com.baidu.tieba.vnb
    public void e(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, funAdSlot) == null) {
            NativeUnifiedAD nativeUnifiedAD = new NativeUnifiedAD(context.getApplicationContext(), this.mPid.pid, new a(this));
            nativeUnifiedAD.setMinVideoDuration(0);
            nativeUnifiedAD.setMaxVideoDuration(0);
            nativeUnifiedAD.loadData(NumberUtils.adjustInt(funAdSlot.getAdCount(), 1, 10));
        }
    }

    public final com.fun.module.gdt.t g(Context context, NativeUnifiedADData nativeUnifiedADData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, nativeUnifiedADData)) == null) {
            int adPatternType = nativeUnifiedADData.getAdPatternType();
            return (com.fun.module.gdt.t) LayoutInflater.from(context).inflate(adPatternType != 1 ? adPatternType != 2 ? (adPatternType == 3 && nativeUnifiedADData.getImgList().size() == 3) ? R.layout.fun_gdt_ad_native_unified_img3_view : R.layout.fun_gdt_ad_native_unified_img_view : R.layout.fun_gdt_ad_native_unified_video_view : R.layout.fun_gdt_ad_native_unified_img2_view, (ViewGroup) null, false);
        }
        return (com.fun.module.gdt.t) invokeLL.objValue;
    }

    public void p(uob uobVar, String str, NativeAdContainer nativeAdContainer, MediaView mediaView, List<View> list, FunAdInteractionListener funAdInteractionListener, final ChannelNativeAds.GdtADStatusChangeListener gdtADStatusChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{uobVar, str, nativeAdContainer, mediaView, list, funAdInteractionListener, gdtADStatusChangeListener}) == null) {
            c cVar = new c(this, uobVar, str);
            if (gdtADStatusChangeListener != null) {
                cVar.d = new e() { // from class: com.baidu.tieba.knb
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.eob.e
                    public final void onADStatusChanged() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ChannelNativeAds.GdtADStatusChangeListener.this.onADStatusChanged();
                        }
                    }
                };
            }
            q(uobVar, str, nativeAdContainer, mediaView, list, cVar, funAdInteractionListener);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public /* bridge */ /* synthetic */ boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        r(activity, viewGroup, str, (uob) obj);
        return true;
    }

    /* loaded from: classes5.dex */
    public class c extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eob f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(eob eobVar, uob uobVar, String str) {
            super(eobVar, uobVar, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eobVar, uobVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((eob) objArr2[0], (uob) objArr2[1], (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = eobVar;
        }

        @Override // com.baidu.tieba.eob.d, com.qq.e.ads.nativ.NativeADEventListener
        public void onADError(AdError adError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adError) == null) {
                this.f.onAdError(this.a, adError.getErrorCode(), adError.getErrorMsg());
            }
        }

        @Override // com.baidu.tieba.eob.d, com.qq.e.ads.nativ.NativeADEventListener
        public void onADClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f.e.onAdClick(this.a);
            }
        }

        @Override // com.baidu.tieba.eob.d, com.qq.e.ads.nativ.NativeADEventListener
        public void onADExposed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f.e.onAdShow(this.a);
            }
        }
    }

    public static void m(com.fun.module.gdt.t tVar, uob uobVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, tVar, uobVar) == null) {
            tVar.b((NativeUnifiedADData) uobVar.a);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        uob uobVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) && (uobVar = (uob) obj) != null) {
            ((NativeUnifiedADData) uobVar.a).destroy();
            this.e.destroy(uobVar);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunNativeAd2 getNativeAdInternal2(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        MediaView mediaView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, str, obj)) == null) {
            uob uobVar = (uob) obj;
            if (((NativeUnifiedADData) uobVar.a).getAdPatternType() == 2) {
                mediaView = new MediaView(context);
            } else {
                mediaView = null;
            }
            pob pobVar = new pob(uobVar, mediaView, str, this.mPid, this);
            return new BaseNativeAd2(FunNativeAd2.NativeType.BOTH, uobVar, pobVar, new iob(this, this, uobVar, str, pobVar));
        }
        return (FunNativeAd2) invokeLLL.objValue;
    }

    public final void n(com.fun.module.gdt.t tVar, final uob uobVar, NativeADEventListener nativeADEventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, tVar, uobVar, nativeADEventListener) == null) {
            if (tVar instanceof GDTNativeUnifiedVideoView) {
                ((GDTNativeUnifiedVideoView) tVar).setVideoOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mnb
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            eob.this.o(uobVar, view2);
                        }
                    }
                });
            }
            ((NativeUnifiedADData) uobVar.a).setNativeAdEventListener(nativeADEventListener);
            tVar.a((NativeUnifiedADData) uobVar.a);
        }
    }

    public void q(uob uobVar, String str, NativeAdContainer nativeAdContainer, MediaView mediaView, List<View> list, NativeADEventListener nativeADEventListener, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{uobVar, str, nativeAdContainer, mediaView, list, nativeADEventListener, funAdInteractionListener}) == null) {
            this.e.startShow(uobVar, str, this.mPid, nativeADEventListener, funAdInteractionListener);
            if (nativeAdContainer == null) {
                onAdError(uobVar, 0, "NativeAdContainer is null");
                funAdInteractionListener.onAdError(str);
                return;
            }
            ((NativeUnifiedADData) uobVar.a).setNativeAdEventListener(nativeADEventListener);
            ((NativeUnifiedADData) uobVar.a).bindAdToView(nativeAdContainer.getContext(), nativeAdContainer, null, list);
            if (mediaView != null) {
                ((NativeUnifiedADData) uobVar.a).bindMediaView(mediaView, new VideoOption.Builder().setAutoPlayPolicy(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart ? 1 : 0).setAutoPlayMuted(!FunAdSdk.getFunAdConfig().isVideoSoundEnable).setDetailPageMuted(false).setNeedCoverImage(true).setNeedProgressBar(true).setEnableDetailPage(false).setEnableUserControl(false).build(), new b());
            }
        }
    }

    public boolean r(Activity activity, ViewGroup viewGroup, String str, final uob uobVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, viewGroup, str, uobVar)) == null) {
            onShowStart(uobVar);
            final com.fun.module.gdt.t g = g(activity, (NativeUnifiedADData) uobVar.a);
            e eVar = new e() { // from class: com.baidu.tieba.lnb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.eob.e
                public final void onADStatusChanged() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        eob.m(com.fun.module.gdt.t.this, uobVar);
                    }
                }
            };
            d dVar = new d(this, uobVar, str);
            dVar.d = eVar;
            n(g, uobVar, dVar);
            viewGroup.removeAllViews();
            viewGroup.addView(g);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
