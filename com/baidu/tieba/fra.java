package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fra.a;
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
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class fra<S extends a> implements FunAdLoader {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;
    public S b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947775124, "Lcom/baidu/tieba/fra;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947775124, "Lcom/baidu/tieba/fra;");
                return;
            }
        }
        c = !fra.class.desiredAssertionStatus();
    }

    public fra() {
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

    public final S b() {
        InterceptResult invokeV;
        S s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this.a) {
                s = this.b;
                if (s == null) {
                    s = f();
                    if (!c && s == null) {
                        throw new AssertionError();
                    }
                    this.b = s;
                }
            }
            return s;
        }
        return (S) invokeV.objValue;
    }

    public final <N> N c(List<PidLoader> list, List<PidLoader> list2, rla<N> rlaVar, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, list, list2, rlaVar, str)) != null) {
            return (N) invokeLLLL.objValue;
        }
        LinkedList<PidLoader> d = d(list);
        Collections.sort(d, new Comparator() { // from class: com.baidu.tieba.yka
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, obj, obj2)) == null) ? fra.e((PidLoader) obj, (PidLoader) obj2) : invokeLL.intValue;
            }
        });
        LinkedList<PidLoader> d2 = d(list2);
        PidLoader poll = d.poll();
        PidLoader poll2 = d2.poll();
        while (true) {
            if (poll == null && poll2 == null) {
                return null;
            }
            PidLoader a2 = a(poll, poll2);
            double biddingOrBasePrices = a2.getBiddingOrBasePrices();
            if (a2 == poll) {
                poll = d.poll();
            } else {
                poll2 = d2.poll();
            }
            PidLoader pidLoader = poll;
            PidLoader pidLoader2 = poll2;
            PidLoader a3 = a(pidLoader, pidLoader2);
            a2.setBiddingResult(a2.getBiddingOrBasePrices(), a3 != null ? a3.getBiddingOrBasePrices() : biddingOrBasePrices, 1);
            N a4 = rlaVar.a(a2, str);
            if (a4 != null) {
                return a4;
            }
            poll = pidLoader;
            poll2 = pidLoader2;
        }
    }

    public final LinkedList<PidLoader> d(List<PidLoader> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            LinkedList<PidLoader> linkedList = new LinkedList<>();
            for (PidLoader pidLoader : list) {
                if (pidLoader.isLoaded()) {
                    linkedList.add(pidLoader);
                }
            }
            return linkedList;
        }
        return (LinkedList) invokeL.objValue;
    }

    public abstract S f();

    /* loaded from: classes4.dex */
    public static abstract class a {
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
                S s = this.b;
                if (s != null) {
                    s.g();
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
                S s = this.b;
                if (s != null) {
                    s.g();
                }
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public final void load(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, context, funAdSlot, funAdLoadListener) == null) {
            synchronized (this.a) {
                S s = this.b;
                if (s != null && !s.c()) {
                    com.fun.h0 h0Var = s.b;
                    h0Var.getClass();
                    h0Var.b("ldr_ld_err", NotificationCompat.CATEGORY_ERROR, "irr");
                    s.g();
                }
                this.b = null;
            }
            S b = b();
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
    public final <T extends ViewGroup> boolean show(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, t, str, funAdInteractionListener)) == null) {
            S b = b();
            b.b.b("ldr_sh_start", new Object[0]);
            return b.d(activity, t, funAdInteractionListener);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public final <T extends ViewGroup> FunSplashAd showSplash(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, activity, t, str, funAdInteractionListener)) == null) {
            S b = b();
            b.b.b("ldr_sh_start", new Object[0]);
            return b.e(activity, t, funAdInteractionListener);
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }
}
