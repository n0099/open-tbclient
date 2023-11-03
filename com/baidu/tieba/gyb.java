package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.tieba.zyb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.internal.api.ReporterPidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.AdReporter;
import java.util.HashMap;
/* loaded from: classes6.dex */
public abstract class gyb<A extends zyb> extends ReporterPidLoader<A> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public gyb(FunAdType funAdType, Ssp.Pid pid) {
        this(funAdType, pid, true);
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
                this((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public gyb(FunAdType funAdType, Ssp.Pid pid, boolean z) {
        this(funAdType, pid, z, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {funAdType, pid, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public gyb(FunAdType funAdType, Ssp.Pid pid, boolean z, boolean z2) {
        this(funAdType, pid, z, z2, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {funAdType, pid, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue(), ((Boolean) objArr2[4]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gyb(FunAdType funAdType, Ssp.Pid pid, boolean z, boolean z2, boolean z3) {
        super(funAdType, pid, z, z2, z3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {funAdType, pid, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue(), ((Boolean) objArr2[4]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.ReporterPidLoader
    public AdReporter<A> createAdReporter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new sxb(this.mPid) : (AdReporter) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public double getAdBiddingPrices(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            try {
                return Double.parseDouble(((zyb) obj).a()) / 100.0d;
            } catch (Exception unused) {
                return 0.0d;
            }
        }
        return invokeL.doubleValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void setAdBiddingResult(Object obj, String str, double d, double d2, boolean z, int i) {
        int i2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{obj, str, Double.valueOf(d), Double.valueOf(d2), Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            zyb zybVar = (zyb) obj;
            String valueOf = String.valueOf(d2 * 100.0d);
            if (z) {
                zybVar.a(valueOf);
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(SplashAd.KEY_BIDFAIL_ECPM, Integer.valueOf((int) (d * 100.0d)));
            if (str.equals(FunAdSdk.PLATFORM_CSJ)) {
                i2 = 1;
            } else if (str.equals(FunAdSdk.PLATFORM_GDT)) {
                i2 = 2;
            } else if (str.equals(FunAdSdk.PLATFORM_KS)) {
                i2 = 3;
            } else if (str.equals(FunAdSdk.PLATFORM_SIG)) {
                i2 = 4;
            } else if (str.equals("baidu") && !this.mPid.isBidding) {
                i2 = 9;
            } else {
                i2 = 10;
            }
            hashMap.put(SplashAd.KEY_BIDFAIL_ADN, Integer.valueOf(i2));
            if (i == 3) {
                str2 = YYOption.UrlProtocol.USER;
            } else if (i == 5) {
                str2 = "900";
            } else {
                str2 = "203";
            }
            zybVar.a(str2, hashMap);
        }
    }
}
