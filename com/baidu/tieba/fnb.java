package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.ChannelNativeAds;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.internal.api.BaseFunNativeAd;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class fnb extends BaseFunNativeAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final knb b;
    public final ChannelNativeAds c;
    public final MediaView d;
    public final umb e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fnb(knb knbVar, MediaView mediaView, String str, Ssp.Pid pid, umb umbVar) {
        super(str, pid);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {knbVar, mediaView, str, pid, umbVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (Ssp.Pid) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = knbVar;
        this.d = mediaView;
        this.c = ChannelNativeAds.createGdt(knbVar.a());
        this.e = umbVar;
    }

    @Override // com.fun.ad.sdk.FunNativeAd, com.fun.ad.sdk.FunNativeInfo
    public ChannelNativeAds getChannelNativeAds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : (ChannelNativeAds) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd, com.fun.ad.sdk.FunNativeInfo
    public View getVideoView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.d : (View) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BaseFunNativeAd
    public void showInternal(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, context, viewGroup, list, list2, funAdInteractionListener) == null) {
            if (viewGroup instanceof NativeAdContainer) {
                this.e.p(this.b, this.mSid, (NativeAdContainer) viewGroup, this.d, list, funAdInteractionListener, this.c.getGdtADStatusChangeListener());
                return;
            }
            LogPrinter.e("adContainer must derive from com.qq.e.ads.nativ.widgetNativeAdContainer", new Object[0]);
            if (FunAdSdk.isLogEnabled()) {
                throw new IllegalArgumentException("adContainer must derive from com.qq.e.ads.nativ.widgetNativeAdContainer");
            }
        }
    }

    @Override // com.fun.ad.sdk.FunNativeAd, com.fun.ad.sdk.FunNativeInfo
    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return ((NativeUnifiedADData) this.b.a).getDesc();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd, com.fun.ad.sdk.FunNativeInfo
    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ((NativeUnifiedADData) this.b.a).getIconUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd, com.fun.ad.sdk.FunNativeInfo
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return ((NativeUnifiedADData) this.b.a).getTitle();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd, com.fun.ad.sdk.FunNativeInfo
    public List<String> getImageUrls() {
        InterceptResult invokeV;
        String imgUrl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<String> imgList = ((NativeUnifiedADData) this.b.a).getImgList();
            if (imgList == null) {
                imgList = new ArrayList<>();
            }
            if (imgList.isEmpty() && (imgUrl = ((NativeUnifiedADData) this.b.a).getImgUrl()) != null) {
                imgList.add(imgUrl);
            }
            return imgList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd, com.fun.ad.sdk.FunNativeInfo
    public FunNativeAd.InteractionType getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!((NativeUnifiedADData) this.b.a).isAppAd()) {
                return FunNativeAd.InteractionType.TYPE_BROWSE;
            }
            int appStatus = ((NativeUnifiedADData) this.b.a).getAppStatus();
            if (appStatus != 0) {
                if (appStatus != 1) {
                    if (appStatus != 2 && appStatus != 4) {
                        if (appStatus != 8) {
                            if (appStatus != 16) {
                                return FunNativeAd.InteractionType.TYPE_UNKNOW;
                            }
                        }
                    }
                }
                return FunNativeAd.InteractionType.TYPE_BROWSE;
            }
            return FunNativeAd.InteractionType.TYPE_DOWNLOAD;
        }
        return (FunNativeAd.InteractionType) invokeV.objValue;
    }
}
