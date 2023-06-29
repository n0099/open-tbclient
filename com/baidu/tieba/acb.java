package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.internal.api.PidLoader;
import com.fun.ad.sdk.internal.api.SidSessionMeta;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
import java.util.Map;
/* loaded from: classes5.dex */
public class acb implements PidLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final PidLoader a;
    public final long b;
    public long c;

    public acb(PidLoader pidLoader) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pidLoader};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = pidLoader;
        this.b = pidLoader.getPid().tmout * 60 * 1000;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public void addListener(ncb ncbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ncbVar) == null) {
            this.a.addListener(new a(this, ncbVar));
        }
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.destroy();
        }
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public void destroy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.a.destroy(z);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public int getAdCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.getAdCount() : invokeV.intValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public FunAdType getAdType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.getAdType() : (FunAdType) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public double getBiddingOrBasePrices() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.getBiddingOrBasePrices() : invokeV.doubleValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public FunNativeAd2 getNativeAd2(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, context, str)) == null) ? this.a.getNativeAd2(context, str) : (FunNativeAd2) invokeLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public Ssp.Pid getPid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a.getPid() : (Ssp.Pid) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public lcb getSubAidInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a.getSubAidInfo() : (lcb) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public boolean isLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a.isLoaded() && System.currentTimeMillis() - this.c < this.b : invokeV.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public boolean load(Context context, FunAdSlot funAdSlot, SidSessionMeta sidSessionMeta) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, context, funAdSlot, sidSessionMeta)) == null) ? this.a.load(context, funAdSlot, sidSessionMeta) : invokeLLL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public void removeListener(ncb ncbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, ncbVar) == null) {
            this.a.removeListener(ncbVar);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public void setBiddingResult(String str, double d, double d2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i)}) == null) {
            this.a.setBiddingResult(str, d, d2, i);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public boolean show(Activity activity, ViewGroup viewGroup, String str, SidSessionMeta sidSessionMeta) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, activity, viewGroup, str, sidSessionMeta)) == null) ? this.a.show(activity, viewGroup, str, sidSessionMeta) : invokeLLLL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public FunSplashAd showSplash(Activity activity, ViewGroup viewGroup, String str, SidSessionMeta sidSessionMeta) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, activity, viewGroup, str, sidSessionMeta)) == null) ? this.a.showSplash(activity, viewGroup, str, sidSessionMeta) : (FunSplashAd) invokeLLLL.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements ncb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ncb a;
        public final /* synthetic */ acb b;

        public a(acb acbVar, ncb ncbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {acbVar, ncbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = acbVar;
            this.a = ncbVar;
        }

        @Override // com.baidu.tieba.ncb
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.a(i, str);
            }
        }

        @Override // com.baidu.tieba.ncb
        public void a(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
                this.a.a(map);
            }
        }

        @Override // com.baidu.tieba.ncb
        public void a(boolean z, int i, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), map}) == null) {
                this.a.a(z, i, map);
            }
        }

        @Override // com.baidu.tieba.ncb
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.a.b();
            }
        }

        @Override // com.baidu.tieba.ncb
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) {
                this.a.b(i, str);
            }
        }

        @Override // com.baidu.tieba.ncb
        public void c(RippedAd rippedAd, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, rippedAd, map) == null) {
                this.a.c(rippedAd, map);
            }
        }

        @Override // com.baidu.tieba.ncb
        public void d(RippedAd rippedAd, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, rippedAd, map) == null) {
                this.a.d(rippedAd, map);
            }
        }

        @Override // com.baidu.tieba.ncb
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.c = System.currentTimeMillis();
                this.a.a();
            }
        }
    }
}
