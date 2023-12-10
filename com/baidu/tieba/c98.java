package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.funad.view.FunAdButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.ChannelNativeAds;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
/* loaded from: classes5.dex */
public class c98 implements ChannelNativeAds.GdtADStatusChangeListener, KsAppDownloadListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FunAdButton a;
    public final lwa b;
    public ChannelNativeAds c;

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public c98(FunAdButton funAdButton, lwa lwaVar, ChannelNativeAds channelNativeAds) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {funAdButton, lwaVar, channelNativeAds};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = funAdButton;
        this.b = lwaVar;
        this.c = channelNativeAds;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            FunAdButton funAdButton = this.a;
            if (funAdButton != null && funAdButton.getTag() == this.b) {
                this.a.setText(i);
            }
            lwa lwaVar = this.b;
            if (lwaVar != null) {
                lwaVar.l(TbadkApplication.getInst().getString(i));
            }
        }
    }

    public void b(int i) {
        FunAdButton funAdButton;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (funAdButton = this.a) != null && funAdButton.getTag() == this.b) {
            this.a.setProgress(i);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            b(i);
        }
    }

    @Override // com.fun.ad.sdk.ChannelNativeAds.GdtADStatusChangeListener
    public void onADStatusChanged() {
        NativeUnifiedADData nativeUnifiedADData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ChannelNativeAds channelNativeAds = this.c;
            if (channelNativeAds != null) {
                nativeUnifiedADData = (NativeUnifiedADData) channelNativeAds.gdtNative;
            } else {
                nativeUnifiedADData = null;
            }
            if (nativeUnifiedADData == null) {
                return;
            }
            if (!nativeUnifiedADData.isAppAd()) {
                a(R.string.obfuscated_res_0x7f0f00e1);
                return;
            }
            int appStatus = nativeUnifiedADData.getAppStatus();
            if (appStatus != 0) {
                if (appStatus != 1) {
                    if (appStatus != 2) {
                        if (appStatus != 4) {
                            if (appStatus != 8) {
                                if (appStatus != 16) {
                                    a(R.string.obfuscated_res_0x7f0f00e1);
                                    return;
                                } else {
                                    a(R.string.obfuscated_res_0x7f0f00de);
                                    return;
                                }
                            }
                            a(R.string.obfuscated_res_0x7f0f00dc);
                            return;
                        }
                        b(nativeUnifiedADData.getProgress());
                        return;
                    }
                    a(R.string.obfuscated_res_0x7f0f00e0);
                    return;
                }
                a(R.string.obfuscated_res_0x7f0f00df);
                return;
            }
            a(R.string.obfuscated_res_0x7f0f00db);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a(R.string.obfuscated_res_0x7f0f00db);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a(R.string.obfuscated_res_0x7f0f00dc);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a(R.string.obfuscated_res_0x7f0f00db);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            a(R.string.obfuscated_res_0x7f0f00dd);
        }
    }
}
