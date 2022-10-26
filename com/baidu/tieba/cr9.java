package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdLoadListener;
import com.fun.ad.sdk.FunAdLoader;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.internal.api.PidLoader;
import com.fun.ad.sdk.internal.api.SidSessionMeta;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class cr9 implements FunAdLoader {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;
    public a b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947684511, "Lcom/baidu/tieba/cr9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947684511, "Lcom/baidu/tieba/cr9;");
                return;
            }
        }
        c = !cr9.class.desiredAssertionStatus();
    }

    public cr9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new Object();
    }

    public static /* synthetic */ int e(PidLoader pidLoader, PidLoader pidLoader2) {
        return -Double.compare(pidLoader.getBiddingOrBasePrices(), pidLoader2.getBiddingOrBasePrices());
    }

    public final PidLoader a(PidLoader pidLoader, PidLoader pidLoader2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, pidLoader, pidLoader2)) == null) {
            if (pidLoader == null && pidLoader2 == null) {
                return null;
            }
            return (pidLoader != null && (pidLoader2 == null || pidLoader.getBiddingOrBasePrices() >= pidLoader2.getBiddingOrBasePrices())) ? pidLoader : pidLoader2;
        }
        return (PidLoader) invokeLL.objValue;
    }

    public final a b() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this.a) {
                aVar = this.b;
                if (aVar == null) {
                    aVar = f();
                    if (!c && aVar == null) {
                        throw new AssertionError();
                    }
                    this.b = aVar;
                }
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public final Object c(List list, List list2, ol9 ol9Var, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, list, list2, ol9Var, str)) != null) {
            return invokeLLLL.objValue;
        }
        LinkedList d = d(list);
        Collections.sort(d, vk9.a);
        LinkedList d2 = d(list2);
        PidLoader pidLoader = (PidLoader) d.poll();
        PidLoader pidLoader2 = (PidLoader) d2.poll();
        while (true) {
            if (pidLoader == null && pidLoader2 == null) {
                return null;
            }
            PidLoader a2 = a(pidLoader, pidLoader2);
            double biddingOrBasePrices = a2.getBiddingOrBasePrices();
            if (a2 == pidLoader) {
                pidLoader = (PidLoader) d.poll();
            } else {
                pidLoader2 = (PidLoader) d2.poll();
            }
            PidLoader pidLoader3 = pidLoader;
            PidLoader pidLoader4 = pidLoader2;
            PidLoader a3 = a(pidLoader3, pidLoader4);
            a2.setBiddingResult(a2.getBiddingOrBasePrices(), a3 != null ? a3.getBiddingOrBasePrices() : biddingOrBasePrices, 1);
            Object a4 = ol9Var.a(a2, str);
            if (a4 != null) {
                return a4;
            }
            pidLoader = pidLoader3;
            pidLoader2 = pidLoader4;
        }
    }

    public final LinkedList d(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            LinkedList linkedList = new LinkedList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                PidLoader pidLoader = (PidLoader) it.next();
                if (pidLoader.isLoaded()) {
                    linkedList.add(pidLoader);
                }
            }
            return linkedList;
        }
        return (LinkedList) invokeL.objValue;
    }

    public abstract a f();

    /* loaded from: classes3.dex */
    public abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final SidSessionMeta a;
        public final com.fun.h0 b;
        public FunAdLoadListener c;

        public a(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            SidSessionMeta sidSessionMeta = new SidSessionMeta(str, i);
            this.a = sidSessionMeta;
            this.b = new com.fun.h0(sidSessionMeta, str2);
        }

        public abstract void a(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener);

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c == null : invokeV.booleanValue;
        }

        public abstract boolean d(Activity activity, ViewGroup viewGroup, FunAdInteractionListener funAdInteractionListener);

        public abstract FunSplashAd e(Activity activity, ViewGroup viewGroup, FunAdInteractionListener funAdInteractionListener);

        public abstract void g();

        public final void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                com.fun.h0 h0Var = this.b;
                h0Var.getClass();
                h0Var.b("ldr_ld_err", NotificationCompat.CATEGORY_ERROR, str);
                this.c.onError(this.a.sid);
                g();
            }
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.b.b("ldr_ld_succeed", new Object[0]);
                this.c.onAdLoaded(this.a.sid);
                g();
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this.a) {
                a aVar = this.b;
                if (aVar != null) {
                    aVar.g();
                }
                this.b = null;
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public void recycleListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this.a) {
                a aVar = this.b;
                if (aVar != null) {
                    aVar.g();
                }
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public final void load(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, context, funAdSlot, funAdLoadListener) == null) {
            synchronized (this.a) {
                a aVar = this.b;
                if (aVar != null && !aVar.c()) {
                    com.fun.h0 h0Var = aVar.b;
                    h0Var.getClass();
                    h0Var.b("ldr_ld_err", NotificationCompat.CATEGORY_ERROR, "irr");
                    aVar.g();
                }
                this.b = null;
            }
            a b = b();
            b.getClass();
            if (funAdLoadListener != null) {
                b.b.b("ldr_ld_start", new Object[0]);
                b.c = funAdLoadListener;
                b.a(context, funAdSlot, funAdLoadListener);
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public final boolean show(Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, viewGroup, str, funAdInteractionListener)) == null) {
            a b = b();
            b.b.b("ldr_sh_start", new Object[0]);
            return b.d(activity, viewGroup, funAdInteractionListener);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public final FunSplashAd showSplash(Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, activity, viewGroup, str, funAdInteractionListener)) == null) {
            a b = b();
            b.b.b("ldr_sh_start", new Object[0]);
            return b.e(activity, viewGroup, funAdInteractionListener);
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }
}
