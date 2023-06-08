package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.g1b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.internal.api.ReporterPidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.flavor.Flavors;
import com.fun.ad.sdk.internal.api.flavor.IAdForbidStrategyManager;
import com.fun.ad.sdk.internal.api.ripper.AdRipper;
import com.fun.ad.sdk.internal.api.utils.AdReporter;
/* loaded from: classes6.dex */
public abstract class h1b<A extends g1b> extends ReporterPidLoader<A> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TTAdNative e;
    public final Handler f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h1b(FunAdType funAdType, Ssp.Pid pid) {
        this(funAdType, pid, false);
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
    public h1b(FunAdType funAdType, Ssp.Pid pid, boolean z) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h1b(FunAdType funAdType, Ssp.Pid pid, boolean z, boolean z2) {
        super(funAdType, pid, true, z, z2);
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
                super((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue(), ((Boolean) objArr2[4]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(int i) {
        onError(e(i));
    }

    @Override // com.fun.ad.sdk.internal.api.ReporterPidLoader
    public AdReporter<A> createAdReporter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new j1b(this.mPid) : (AdReporter) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public AdRipper createAdRipper(Ssp.Pid pid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pid)) == null) ? new q0b(pid) : (AdRipper) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader, com.fun.ad.sdk.internal.api.PidLoader
    public synchronized void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                super.destroy();
                this.e = null;
            }
        }
    }

    public String e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? i != -8 ? i != 112 ? i != 228 ? "" : "cheat" : "toomuch" : "toofast" : (String) invokeI.objValue;
    }

    public abstract void f(Context context, FunAdSlot funAdSlot);

    @Override // com.fun.ad.sdk.internal.api.ReporterPidLoader
    public Object getErrInfo(int i, String str) {
        InterceptResult invokeIL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i, str)) == null) {
            if (i != 20001 || TextUtils.isEmpty(str)) {
                return Integer.valueOf(i);
            }
            String[] split = str.split("\\D+");
            int length = split.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    str2 = "";
                    break;
                }
                String str3 = split[i2];
                if (str3.length() > 1) {
                    str2 = i + "_" + str3;
                    break;
                }
                i2++;
            }
            return TextUtils.isEmpty(str2) ? Integer.valueOf(i) : str2;
        }
        return invokeIL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, context, funAdSlot) == null) {
            onLoadStart(funAdSlot);
            if (this.e == null) {
                this.e = TTAdSdk.getAdManager().createAdNative(context.getApplicationContext());
            }
            IAdForbidStrategyManager iAdForbidStrategyManager = Flavors.STRATEGY_MANAGER;
            Ssp.Pid pid = this.mPid;
            final int checkForbidStatus = iAdForbidStrategyManager.checkForbidStatus(pid.ssp.type, pid.pid);
            if (checkForbidStatus != 0) {
                this.f.postAtTime(new Runnable() { // from class: com.baidu.tieba.n0b
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            h1b.this.g(checkForbidStatus);
                        }
                    }
                }, 50L);
            } else {
                f(context, funAdSlot);
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public double getAdBiddingPrices(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            return ((g1b) obj).a();
        }
        return invokeL.doubleValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void setAdBiddingResult(Object obj, String str, double d, double d2, boolean z, int i) {
        String str2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{obj, str, Double.valueOf(d), Double.valueOf(d2), Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            g1b g1bVar = (g1b) obj;
            double d3 = d * 100.0d;
            double d4 = d2 * 100.0d;
            if (FunAdSdk.PLATFORM_GDT.equals(str)) {
                str2 = "ylh";
            } else if ("baidu".equals(str)) {
                str2 = "bqt";
            } else if (FunAdSdk.PLATFORM_KS.equals(str)) {
                str2 = "kuai";
            } else {
                str2 = null;
            }
            String str3 = str2;
            if (i != 3 && i != 5) {
                i2 = 102;
            } else {
                i2 = 1;
            }
            g1bVar.b(str3, d3, d4, z, i2);
        }
    }
}
