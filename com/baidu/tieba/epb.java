package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.ChannelNativeAds;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeInfo;
import com.win.opensdk.PBMediaView;
import com.win.opensdk.PBNative;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class epb implements FunNativeInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final PBNative a;
    public final Context b;
    public PBMediaView c;

    public epb(Context context, PBNative pBNative) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, pBNative};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = context;
        this.a = pBNative;
    }

    @Override // com.fun.ad.sdk.FunNativeInfo
    public ChannelNativeAds getChannelNativeAds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ChannelNativeAds.createJy(this.a) : (ChannelNativeAds) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeInfo
    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.getBody() : (String) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeInfo
    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getIcon() : (String) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeInfo
    public List<String> getImageUrls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.a.getIM());
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeInfo
    public FunNativeAd.InteractionType getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.isD() ? FunNativeAd.InteractionType.TYPE_DOWNLOAD : FunNativeAd.InteractionType.TYPE_BROWSE : (FunNativeAd.InteractionType) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeInfo
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.getHeadline() : (String) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeInfo
    public View getVideoView() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String adType = this.a.getAdType();
            adType.hashCode();
            if (!adType.equals("h5") && !adType.equals("video")) {
                z = false;
            } else {
                z = true;
            }
            if (z && this.c == null) {
                this.c = new PBMediaView(this.b.getApplicationContext());
            }
            return this.c;
        }
        return (View) invokeV.objValue;
    }
}
