package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
import com.kwad.sdk.core.response.model.AdInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class etb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static RippedAd a(AdInfo adInfo) {
        InterceptResult invokeL;
        String str;
        String str2;
        List<AdInfo.AdMaterialInfo.MaterialFeature> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, adInfo)) == null) {
            AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
            AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
            RippedAd.Builder builder = new RippedAd.Builder();
            AdInfo.AdMaterialInfo adMaterialInfo = adInfo.adMaterialInfo;
            ArrayList arrayList = null;
            if (adMaterialInfo == null || (list = adMaterialInfo.materialFeatureList) == null || list.isEmpty()) {
                str = null;
            } else if (adMaterialInfo.materialType == 1) {
                AdInfo.AdMaterialInfo.MaterialFeature materialFeature = adMaterialInfo.materialFeatureList.get(0);
                str2 = materialFeature.materialUrl;
                str = materialFeature.coverUrl;
                builder.setCorporation(adBaseInfo.corporationName).setTitle(adBaseInfo.productName).setDescription(adBaseInfo.adDescription).setAppName(adBaseInfo.appName).setAppPkg(adBaseInfo.appPackageName).setAppUrl(adConversionInfo.appDownloadUrl).setIconUrl(adBaseInfo.appIconUrl).setImageUrl(RippedAd.combineStrWithComma(arrayList)).setVideoImageUrl(str).setVideoUrl(str2).setClickUrl(adConversionInfo.h5Url).setDeepLinkUrl(adConversionInfo.deeplinkUrl).setConvUrl(adBaseInfo.convUrl);
                return builder.build();
            } else {
                ArrayList arrayList2 = new ArrayList();
                for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature2 : adMaterialInfo.materialFeatureList) {
                    arrayList2.add(materialFeature2.materialUrl);
                }
                str = null;
                arrayList = arrayList2;
            }
            str2 = str;
            builder.setCorporation(adBaseInfo.corporationName).setTitle(adBaseInfo.productName).setDescription(adBaseInfo.adDescription).setAppName(adBaseInfo.appName).setAppPkg(adBaseInfo.appPackageName).setAppUrl(adConversionInfo.appDownloadUrl).setIconUrl(adBaseInfo.appIconUrl).setImageUrl(RippedAd.combineStrWithComma(arrayList)).setVideoImageUrl(str).setVideoUrl(str2).setClickUrl(adConversionInfo.h5Url).setDeepLinkUrl(adConversionInfo.deeplinkUrl).setConvUrl(adBaseInfo.convUrl);
            return builder.build();
        }
        return (RippedAd) invokeL.objValue;
    }
}
