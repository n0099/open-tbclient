package com.baidu.tieba;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.location.Location;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.CsjPrivacySwitch;
import com.baidu.tbadk.switchs.GdtPrivacySwitch;
import com.baidu.tbadk.switchs.KsPrivacySwitch;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.tieba.vx6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.TTLocation;
import com.fun.ad.sdk.CacheStatistic;
import com.fun.ad.sdk.FunAdCallback;
import com.fun.ad.sdk.FunAdConfig;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdLoadListener;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.FunNativeView;
import com.fun.ad.sdk.FunNativeViewInflater;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.channel.ModuleConfigCsj;
import com.fun.ad.sdk.channel.ModuleConfigKs;
import com.kwad.sdk.api.KsCustomController;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class ey6 implements vx6.f {
    public static /* synthetic */ Interceptable $ic;
    public static final String d;
    public transient /* synthetic */ FieldHolder $fh;
    public p a;
    public HashMap<String, Long> b;
    public final FunAdCallback c;

    /* loaded from: classes4.dex */
    public class b implements vx6.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FunNativeAd2 a;
        public final /* synthetic */ List b;
        public final /* synthetic */ List c;
        public final /* synthetic */ ViewGroup d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ String f;
        public final /* synthetic */ FunAdInteractionListener g;

        /* loaded from: classes4.dex */
        public class a extends FunNativeViewInflater {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, FunNativeAd2 funNativeAd2) {
                super(funNativeAd2);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, funNativeAd2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((FunNativeAd2) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
            }

            @Override // com.fun.ad.sdk.CustomInflater
            public List<View> getClickViews() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.c.b;
                }
                return (List) invokeV.objValue;
            }

            @Override // com.fun.ad.sdk.CustomInflater
            public List<View> getCreativeViews() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return this.c.c;
                }
                return (List) invokeV.objValue;
            }
        }

        public b(ey6 ey6Var, FunNativeAd2 funNativeAd2, List list, List list2, ViewGroup viewGroup, Activity activity, String str, FunAdInteractionListener funAdInteractionListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey6Var, funNativeAd2, list, list2, viewGroup, activity, str, funAdInteractionListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = funNativeAd2;
            this.b = list;
            this.c = list2;
            this.d = viewGroup;
            this.e = activity;
            this.f = str;
            this.g = funAdInteractionListener;
        }

        @Override // com.baidu.tieba.vx6.l
        public void initComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.getNativeType() == FunNativeAd2.NativeType.EXPRESS) {
                return;
            }
            a aVar = new a(this, this.a);
            ViewGroup viewGroup = null;
            if (this.d.getParent() instanceof ViewGroup) {
                viewGroup = (ViewGroup) this.d.getParent();
                viewGroup.removeView(this.d);
            }
            FunNativeView inflate = FunNativeView.inflate(this.e, this.d);
            if (viewGroup != null) {
                viewGroup.addView(inflate);
            }
            aVar.setFunNativeView(inflate);
            this.a.show(this.e, aVar, this.f, this.g);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements FunAdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vx6.i a;
        public final /* synthetic */ vx6.g b;
        public final /* synthetic */ ey6 c;

        public a(ey6 ey6Var, vx6.i iVar, vx6.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey6Var, iVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ey6Var;
            this.a = iVar;
            this.b = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str, String str2, String str3) {
            vx6.i iVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) && (iVar = this.a) != null) {
                iVar.onAdClicked(str, str2, str3);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                vx6.i iVar = this.a;
                if (iVar != null) {
                    iVar.onAdShow(str, str2, str3);
                }
                this.c.y("advert_show", str, 1, this.b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str, String str2, String str3) {
            vx6.i iVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) && (iVar = this.a) != null) {
                iVar.a(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            vx6.i iVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && (iVar = this.a) != null) {
                iVar.onAdClose(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                vx6.i iVar = this.a;
                if (iVar != null) {
                    iVar.onAdError(str);
                }
                this.c.y("advert_show", str, 0, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements FunAdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vx6.i a;
        public final /* synthetic */ vx6.g b;
        public final /* synthetic */ ey6 c;

        public c(ey6 ey6Var, vx6.i iVar, vx6.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey6Var, iVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ey6Var;
            this.a = iVar;
            this.b = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str, String str2, String str3) {
            vx6.i iVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) && (iVar = this.a) != null) {
                iVar.onAdClicked(str, str2, str3);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str, String str2, String str3) {
            vx6.i iVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) && (iVar = this.a) != null) {
                iVar.a(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            vx6.i iVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && (iVar = this.a) != null) {
                iVar.onAdClose(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                vx6.i iVar = this.a;
                if (iVar != null) {
                    iVar.onAdError(str);
                }
                this.c.y("advert_show", str, 0, this.b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                vx6.i iVar = this.a;
                if (iVar != null) {
                    iVar.onAdShow(str, str2, str3);
                }
                if (this.c.a != null) {
                    this.c.a.b = str;
                    this.c.a.c = str2;
                }
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    Log.d("IAdSdkSplash", "BEAR ad sspType=" + str2 + ", sid=" + str + " ,pid=" + str3);
                }
                this.c.y("advert_show", str, 1, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements vx6.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ String c;
        public final /* synthetic */ FunAdInteractionListener d;
        public final /* synthetic */ ey6 e;

        public d(ey6 ey6Var, Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey6Var, activity, viewGroup, str, funAdInteractionListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ey6Var;
            this.a = activity;
            this.b = viewGroup;
            this.c = str;
            this.d = funAdInteractionListener;
        }

        @Override // com.baidu.tieba.vx6.l
        public void initComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FunSplashAd showSplash = FunAdSdk.getAdFactory().showSplash(this.a, this.b, this.c, this.d);
                if (showSplash != null) {
                    this.e.a = new p();
                    this.e.a.a = showSplash;
                }
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    Log.d("IAdSdkSplash", "BEAR ad showSplash:" + this.e.a);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends TTCustomController {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(ey6 ey6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        /* renamed from: a */
        public TTLocation getTTLocation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new TTLocation(xg.c(TbadkCoreApplication.getInst().getLocationLng(), 0.0d), xg.c(TbadkCoreApplication.getInst().getLocationLat(), 0.0d));
            }
            return (TTLocation) invokeV.objValue;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean alist() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return CsjPrivacySwitch.isOpen();
            }
            return invokeV.booleanValue;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public String getDevImei() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return TbadkCoreApplication.getInst().getImei();
            }
            return (String) invokeV.objValue;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseLocation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return CsjPrivacySwitch.isOpen();
            }
            return invokeV.booleanValue;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUsePhoneState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return CsjPrivacySwitch.isOpen();
            }
            return invokeV.booleanValue;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseWifiState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return CsjPrivacySwitch.isOpen();
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class f extends KsCustomController {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseOaid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUsePhoneState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public f(ey6 ey6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canReadInstalledPackages() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return KsPrivacySwitch.isOpen();
            }
            return invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canReadLocation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return KsPrivacySwitch.isOpen();
            }
            return invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseMacAddress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return KsPrivacySwitch.isOpen();
            }
            return invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseNetworkState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return KsPrivacySwitch.isOpen();
            }
            return invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseStoragePermission() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return KsPrivacySwitch.isOpen();
            }
            return invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getAndroidId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return TbadkCoreApplication.getInst().getAndroidId();
            }
            return (String) invokeV.objValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getImei() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return TbadkCoreApplication.getInst().getImei();
            }
            return (String) invokeV.objValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String[] getImeis() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new String[]{TbadkCoreApplication.getInst().getImei(), TbadkCoreApplication.getInst().getImei()} : (String[]) invokeV.objValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getMacAddress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst());
            }
            return (String) invokeV.objValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getOaid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
            }
            return (String) invokeV.objValue;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public Location getLocation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                Location location = new Location("");
                location.setLatitude(xg.c(TbadkCoreApplication.getInst().getLocationLat(), 0.0d));
                location.setLongitude(xg.c(TbadkCoreApplication.getInst().getLocationLng(), 0.0d));
                return location;
            }
            return (Location) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements FunAdCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ey6 a;

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdClose(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3) == null) {
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, str3) == null) {
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdShowError(String str, String str2, String str3, int i, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, str3, Integer.valueOf(i), str4}) == null) {
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onRewardedVideo(String str, String str2, String str3, boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, str2, str3, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        public g(ey6 ey6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ey6Var;
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdLoad(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3) == null) {
                this.a.b.put(str, Long.valueOf(System.currentTimeMillis()));
            }
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdLoaded(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLLL(1048580, this, str, str2, str3) != null) {
                return;
            }
            this.a.x(str);
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdLoadError(String str, String str2, String str3, int i, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, Integer.valueOf(i), str4}) == null) {
                this.a.x(str);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW_ERROR).param("obj_locate", i).param("obj_source", str).param("obj_param1", str4).param(TiebaStatic.Params.OBJ_PARAM2, str2).param(TiebaStatic.Params.OBJ_PARAM3, str3));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements FunAdSdk.SdkInitializeCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vx6.l a;

        @Override // com.fun.ad.sdk.FunAdSdk.SdkInitializeCallback
        public void onModulesInitComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public h(ey6 ey6Var, vx6.l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey6Var, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lVar;
        }

        @Override // com.fun.ad.sdk.FunAdSdk.SdkInitializeCallback
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GlobalSetting.setAgreePrivacyStrategy(GdtPrivacySwitch.isOpen());
                vx6.l lVar = this.a;
                if (lVar != null) {
                    lVar.initComplete();
                    ky6.a("小熊SDK开始初始化完成！");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements FunAdLoadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vx6.h a;
        public final /* synthetic */ vx6.g b;
        public final /* synthetic */ ey6 c;

        public i(ey6 ey6Var, vx6.h hVar, vx6.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey6Var, hVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ey6Var;
            this.a = hVar;
            this.b = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onAdLoaded(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                vx6.h hVar = this.a;
                if (hVar != null) {
                    hVar.a(str, 0);
                }
                this.c.y("advert_load", str, 1, this.b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                vx6.h hVar = this.a;
                if (hVar != null) {
                    hVar.onError(str);
                }
                this.c.y("advert_load", str, 0, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements vx6.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WeakReference a;
        public final /* synthetic */ FunAdSlot b;
        public final /* synthetic */ FunAdLoadListener c;

        public j(ey6 ey6Var, WeakReference weakReference, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey6Var, weakReference, funAdSlot, funAdLoadListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = weakReference;
            this.b = funAdSlot;
            this.c = funAdLoadListener;
        }

        @Override // com.baidu.tieba.vx6.l
        public void initComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.get() != null) {
                FunAdSdk.getAdFactory().loadAd((Context) this.a.get(), this.b, this.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements FunAdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vx6.i a;
        public final /* synthetic */ vx6.g b;
        public final /* synthetic */ ey6 c;

        public k(ey6 ey6Var, vx6.i iVar, vx6.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey6Var, iVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ey6Var;
            this.a = iVar;
            this.b = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str, String str2, String str3) {
            vx6.i iVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) && (iVar = this.a) != null) {
                iVar.onAdClicked(str, str2, str3);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                vx6.i iVar = this.a;
                if (iVar != null) {
                    iVar.onAdShow(str, str2, str3);
                }
                this.c.y("advert_show", str, 1, this.b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str, String str2, String str3) {
            vx6.i iVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) && (iVar = this.a) != null) {
                iVar.a(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            vx6.i iVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && (iVar = this.a) != null) {
                iVar.onAdClose(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                vx6.i iVar = this.a;
                if (iVar != null) {
                    iVar.onAdError(str);
                }
                this.c.y("advert_show", str, 0, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements vx6.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ String c;
        public final /* synthetic */ FunAdInteractionListener d;

        public l(ey6 ey6Var, Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey6Var, activity, viewGroup, str, funAdInteractionListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
            this.b = viewGroup;
            this.c = str;
            this.d = funAdInteractionListener;
        }

        @Override // com.baidu.tieba.vx6.l
        public void initComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FunAdSdk.getAdFactory().showAd(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements vx6.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public m(ey6 ey6Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey6Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // com.baidu.tieba.vx6.l
        public void initComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FunAdSdk.getAdFactory().destroyAd(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements FunAdLoadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vx6.h a;
        public final /* synthetic */ vx6.g b;
        public final /* synthetic */ ey6 c;

        public n(ey6 ey6Var, vx6.h hVar, vx6.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey6Var, hVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ey6Var;
            this.a = hVar;
            this.b = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onAdLoaded(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                vx6.h hVar = this.a;
                if (hVar != null) {
                    hVar.a(str, 0);
                }
                this.c.y("advert_load", str, 1, this.b);
            }
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                vx6.h hVar = this.a;
                if (hVar != null) {
                    hVar.onError(str);
                }
                this.c.y("advert_load", str, 0, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements vx6.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ FunAdSlot b;
        public final /* synthetic */ FunAdLoadListener c;

        public o(ey6 ey6Var, Activity activity, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey6Var, activity, funAdSlot, funAdLoadListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
            this.b = funAdSlot;
            this.c = funAdLoadListener;
        }

        @Override // com.baidu.tieba.vx6.l
        public void initComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    FunAdSdk.getAdFactory().loadAd(this.a, this.b, this.c);
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FunSplashAd a;
        public String b;
        public String c;

        public p() {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947750727, "Lcom/baidu/tieba/ey6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947750727, "Lcom/baidu/tieba/ey6;");
                return;
            }
        }
        d = vq4.a();
    }

    public ey6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new HashMap<>();
        this.c = new g(this);
    }

    public final ModuleConfigCsj.Builder v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return new ModuleConfigCsj.Builder().setTitleBarTheme(1).setTtSupportMultiProcess(true).setTTCustomController(new e(this));
        }
        return (ModuleConfigCsj.Builder) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vx6.f
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            destroyAd(str);
        }
    }

    @Override // com.baidu.tieba.vx6.f
    public void destroyAd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            u(new m(this, str));
        }
    }

    @Override // com.baidu.tieba.vx6.f
    public ViewGroup e(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            return new NativeAdContainer(context);
        }
        return (ViewGroup) invokeL.objValue;
    }

    @Override // com.baidu.tieba.vx6.f
    public View f(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj instanceof FunNativeAd2) {
                FunNativeAd2 funNativeAd2 = (FunNativeAd2) obj;
                dy6.D(funNativeAd2);
                dy6.E(funNativeAd2);
                return dy6.m(funNativeAd2);
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.tieba.vx6.f
    public boolean h(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if (obj instanceof FunNativeAd2) {
                return dy6.M((FunNativeAd2) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.vx6.f
    public boolean isAdReady(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            u(null);
            if (FunAdSdk.isSdkInitializeComplete() && FunAdSdk.getAdFactory().isAdReady(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void u(vx6.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, lVar) == null) {
            k(TbadkCoreApplication.getInst(), lVar);
        }
    }

    @Override // com.baidu.tieba.vx6.f
    public void c(ImageView imageView, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, imageView, obj) == null) && (obj instanceof FunNativeAd2) && imageView != null) {
            dy6.L(imageView, (FunNativeAd2) obj);
        }
    }

    @Override // com.baidu.tieba.vx6.f
    public Object i(@NonNull Activity activity, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, activity, str)) == null) {
            u(null);
            return FunAdSdk.getAdFactory().getNativeAd2(activity, str);
        }
        return invokeLL.objValue;
    }

    @Override // com.baidu.tieba.vx6.f
    public void j(Object obj, vx6.j jVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, obj, jVar) == null) && (obj instanceof FunNativeAd2)) {
            FunNativeAd2 funNativeAd2 = (FunNativeAd2) obj;
            dy6.K(funNativeAd2, dy6.s(funNativeAd2), jVar);
        }
    }

    @Override // com.baidu.tieba.vx6.f
    public void g(Activity activity, String str, ViewGroup viewGroup, vx6.i iVar, vx6.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(1048583, this, activity, str, viewGroup, iVar, gVar) != null) || viewGroup == null) {
            return;
        }
        u(new d(this, activity, viewGroup, str, new c(this, iVar, gVar)));
    }

    @Override // com.baidu.tieba.vx6.f
    public void n(Activity activity, String str, ViewGroup viewGroup, vx6.i iVar, vx6.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(1048591, this, activity, str, viewGroup, iVar, gVar) != null) || viewGroup == null) {
            return;
        }
        u(new l(this, activity, viewGroup, str, new k(this, iVar, gVar)));
    }

    @Override // com.baidu.tieba.vx6.f
    public void b(Activity activity, String str, int i2, vx6.h hVar, vx6.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, str, Integer.valueOf(i2), hVar, gVar}) == null) {
            u(new o(this, activity, new FunAdSlot.Builder().setSid(str).setAdCount(i2).setExpressWidth(yi.l(activity)).build(), new n(this, hVar, gVar)));
        }
    }

    @Override // com.baidu.tieba.vx6.f
    public void d(Context context, String str, int i2, int i3, vx6.h hVar, vx6.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, str, Integer.valueOf(i2), Integer.valueOf(i3), hVar, gVar}) == null) {
            FunAdSlot.Builder builder = new FunAdSlot.Builder();
            builder.setSid(str).setAdCount(i2).setExpressWidth(yi.l(context));
            if (i3 > 0) {
                builder.setExpressHeight(i3);
            }
            u(new j(this, new WeakReference(context), builder.build(), new i(this, hVar, gVar)));
        }
    }

    @Override // com.baidu.tieba.vx6.f
    public void k(Application application, vx6.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, application, lVar) == null) {
            if (FunAdSdk.isSdkInitializeComplete()) {
                if (lVar != null) {
                    lVar.initComplete();
                    return;
                }
                return;
            }
            FunAdConfig.Builder builder = new FunAdConfig.Builder(application);
            if (ti5.c()) {
                builder.forbiddenPlatform(FunAdSdk.PLATFORM_CSJ);
                ky6.a("不初始化 PLATFORM_CSJ");
            } else {
                ky6.a("初始化 PLATFORM_CSJ");
            }
            if (ti5.d()) {
                builder.forbiddenPlatform(FunAdSdk.PLATFORM_GDT);
                ky6.a("不初始化 PLATFORM_GDT");
            } else {
                ky6.a("初始化 PLATFORM_GDT");
            }
            if (ti5.e()) {
                builder.forbiddenPlatform(FunAdSdk.PLATFORM_KS);
                ky6.a("不初始化 PLATFORM_KS");
            } else {
                ky6.a("初始化 PLATFORM_KS");
            }
            boolean z = true;
            FunAdConfig.Builder videoDataFlowAutoStart = builder.setAppName(application.getString(R.string.obfuscated_res_0x7f0f029e)).setAppId(d).setUserId("").setUseTextureView(true).setVideoSoundEnable(false).setVideoDataFlowAutoStart(false);
            if (!vq4.g() && !vq4.h() && !TbadkCoreApplication.getInst().isDebugMode()) {
                z = false;
            }
            videoDataFlowAutoStart.setLogEnabled(z).setKsAdConfig(w().build()).setCsjAdConfig(v().build());
            GlobalSetting.setAgreePrivacyStrategy(GdtPrivacySwitch.isOpen());
            ky6.a("小熊SDK开始初始化，APPID 是：" + d);
            FunAdSdk.init(builder.build(), this.c, new h(this, lVar));
        }
    }

    @Override // com.baidu.tieba.vx6.f
    public List<ux6> l(String str) {
        InterceptResult invokeL;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (!FunAdSdk.isSdkInitializeComplete()) {
                return new ArrayList();
            }
            List<CacheStatistic> cacheStatistics = FunAdSdk.getAdFactory().getCacheStatistics(str);
            ArrayList arrayList = new ArrayList(cacheStatistics.size());
            for (CacheStatistic cacheStatistic : cacheStatistics) {
                FunAdType funAdType = cacheStatistic.adType;
                if (funAdType == null) {
                    str2 = "";
                } else {
                    str2 = funAdType.getAdType().toString();
                }
                FunAdType funAdType2 = cacheStatistic.adType;
                if (funAdType2 == null) {
                    str3 = "";
                } else {
                    str3 = funAdType2.getPlatform();
                }
                arrayList.add(new ux6(str2, str3, cacheStatistic.pid, cacheStatistic.hashCode(), cacheStatistic.count, cacheStatistic.basePrice));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void x(String str) {
        Long l2;
        long j2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, str) == null) && (l2 = this.b.get(str)) != null) {
            SpeedStatsManager.getInstance().setTaskRunTime("Ad_load" + str, System.currentTimeMillis() - l2.longValue());
            SpeedStatsManager speedStatsManager = SpeedStatsManager.getInstance();
            String str2 = "Ad_end" + str;
            if (SpeedStatsManager.getInstance().isAdLoadEnd()) {
                j2 = 1;
            } else {
                j2 = 0;
            }
            speedStatsManager.setTaskRunTime(str2, j2);
            this.b.remove(str);
        }
    }

    @Override // com.baidu.tieba.vx6.f
    public void m(Activity activity, @NonNull Object obj, vx6.i iVar, ViewGroup viewGroup, List<View> list, List<View> list2, vx6.g gVar, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{activity, obj, iVar, viewGroup, list, list2, gVar, str}) == null) && !activity.isDestroyed() && (obj instanceof FunNativeAd2)) {
            u(new b(this, (FunNativeAd2) obj, list, list2, viewGroup, activity, str, new a(this, iVar, gVar)));
        }
    }

    @Override // com.baidu.tieba.vx6.f
    public u09 o(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, obj)) == null) {
            u09 u09Var = null;
            if (obj instanceof FunNativeAd2) {
                FunNativeAd2 funNativeAd2 = (FunNativeAd2) obj;
                int s = dy6.s(funNativeAd2);
                if (s == -1) {
                    return null;
                }
                u09Var = new u09();
                String c2 = dy6.c(funNativeAd2, s);
                if (xi.isEmpty(c2)) {
                    c2 = "推广";
                }
                u09Var.k(c2);
                u09Var.l(dy6.v(funNativeAd2, s));
                u09Var.j(dy6.q(funNativeAd2, s));
                u09Var.g(dy6.n(funNativeAd2));
                u09Var.h(dy6.b(funNativeAd2));
                u09Var.i(s);
            }
            return u09Var;
        }
        return (u09) invokeL.objValue;
    }

    public final ModuleConfigKs.Builder w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return new ModuleConfigKs.Builder().setKsCustomController(new f(this)).setKsCanReadICCID(KsPrivacySwitch.isOpen()).setKsCanReadNearbyWifiList(KsPrivacySwitch.isOpen()).setKsCanReadMacAddress(KsPrivacySwitch.isOpen());
        }
        return (ModuleConfigKs.Builder) invokeV.objValue;
    }

    public final void y(String str, String str2, int i2, vx6.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048597, this, str, str2, i2, gVar) == null) {
            fh a2 = tf5.a();
            a2.b("type", "bear");
            a2.b("locate", gVar.a);
            a2.b(SetImageWatermarkTypeReqMsg.SWITCH, gVar.b);
            a2.b("sid", str2);
            a2.c("isSuccess", Integer.valueOf(i2));
            BdStatisticsManager.getInstance().debug(str, a2);
        }
    }
}
