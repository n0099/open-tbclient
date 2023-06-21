package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.d2b.a;
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
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.ReadyCacheStatistic;
import com.fun.ad.sdk.internal.api.PidLoader;
import com.fun.ad.sdk.internal.api.SidSessionMeta;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class d2b<S extends a> implements FunAdLoader {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;
    public S b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947654069, "Lcom/baidu/tieba/d2b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947654069, "Lcom/baidu/tieba/d2b;");
                return;
            }
        }
        c = !d2b.class.desiredAssertionStatus();
    }

    public d2b() {
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

    public static /* synthetic */ int g(PidLoader pidLoader, PidLoader pidLoader2) {
        return -Double.compare(pidLoader.getBiddingOrBasePrices(), pidLoader2.getBiddingOrBasePrices());
    }

    public static /* synthetic */ int i(PidLoader pidLoader, PidLoader pidLoader2) {
        return -Double.compare(pidLoader.getBiddingOrBasePrices(), pidLoader2.getBiddingOrBasePrices());
    }

    public static /* synthetic */ int j(PidLoader pidLoader, PidLoader pidLoader2) {
        return -Double.compare(pidLoader.getBiddingOrBasePrices(), pidLoader2.getBiddingOrBasePrices());
    }

    public final PidLoader b(PidLoader pidLoader, PidLoader pidLoader2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pidLoader, pidLoader2)) == null) {
            if (pidLoader == null && pidLoader2 == null) {
                return null;
            }
            return (pidLoader != null && (pidLoader2 == null || pidLoader.getBiddingOrBasePrices() >= pidLoader2.getBiddingOrBasePrices())) ? pidLoader : pidLoader2;
        }
        return (PidLoader) invokeLL.objValue;
    }

    public final S c() {
        InterceptResult invokeV;
        S s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this.a) {
                s = this.b;
                if (s == null) {
                    s = h();
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

    public final LinkedList<PidLoader> e(List<PidLoader> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
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

    public abstract void f(String str);

    public abstract S h();

    /* loaded from: classes5.dex */
    public static abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final SidSessionMeta a;
        public final com.fun.d0 b;
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
            this.b = new com.fun.d0(sidSessionMeta, str2);
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
                com.fun.d0 d0Var = this.b;
                d0Var.getClass();
                d0Var.b("ldr_ld_err", NotificationCompat.CATEGORY_ERROR, str);
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

    public ReadyCacheStatistic a(List<PidLoader> list, List<PidLoader> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, list, list2)) == null) {
            LinkedList<PidLoader> e = e(list);
            Collections.sort(e, new Comparator() { // from class: com.baidu.tieba.s0b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    InterceptResult invokeLL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL2 = interceptable2.invokeLL(1048576, this, obj, obj2)) == null) ? d2b.g((PidLoader) obj, (PidLoader) obj2) : invokeLL2.intValue;
                }
            });
            LinkedList<PidLoader> e2 = e(list2);
            Collections.sort(e2, new Comparator() { // from class: com.baidu.tieba.b1b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    InterceptResult invokeLL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL2 = interceptable2.invokeLL(1048576, this, obj, obj2)) == null) ? d2b.i((PidLoader) obj, (PidLoader) obj2) : invokeLL2.intValue;
                }
            });
            PidLoader poll = e.poll();
            PidLoader poll2 = e2.poll();
            if (poll == null && poll2 == null) {
                return null;
            }
            PidLoader b = b(poll, poll2);
            FunAdType adType = b.getAdType();
            FunAdType adType2 = b.getAdType();
            String str = b.getPid().pid;
            b.getSubAidInfo().getClass();
            ReadyCacheStatistic readyCacheStatistic = new ReadyCacheStatistic(adType2, str, "");
            if (this.b != null) {
                S s = this.b;
                String str2 = b.getPid().pid;
                v7b subAidInfo = b.getSubAidInfo();
                com.fun.d0 d0Var = s.b;
                subAidInfo.getClass();
                d0Var.getClass();
                d0Var.b("ldr_rdy_show", "k_rdy_adtype", adType.getPlatform() + "-" + adType.getAdType().toString(), "k_rdy_pid", str2, "k_rdy_ntwnm", "", "subAid", "");
            }
            return readyCacheStatistic;
        }
        return (ReadyCacheStatistic) invokeLL.objValue;
    }

    public final <N> N d(List<PidLoader> list, List<PidLoader> list2, a8b<N> a8bVar, String str) {
        InterceptResult invokeLLLL;
        double d;
        String str2;
        double biddingOrBasePrices;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, list, list2, a8bVar, str)) == null) {
            LinkedList<PidLoader> e = e(list);
            Collections.sort(e, new Comparator() { // from class: com.baidu.tieba.u0b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, obj, obj2)) == null) ? d2b.j((PidLoader) obj, (PidLoader) obj2) : invokeLL.intValue;
                }
            });
            LinkedList<PidLoader> e2 = e(list2);
            if (e2.size() > 0 && e.size() > 0) {
                PidLoader pidLoader = e2.get(0);
                if (pidLoader != null) {
                    try {
                        biddingOrBasePrices = pidLoader.getBiddingOrBasePrices();
                    } catch (Exception e3) {
                        LogPrinter.e(e3);
                    }
                } else {
                    biddingOrBasePrices = 0.0d;
                }
                PidLoader pidLoader2 = e.get(0);
                double biddingOrBasePrices2 = pidLoader2.getBiddingOrBasePrices();
                String str3 = pidLoader2.getPid().ssp.type;
                if (biddingOrBasePrices > biddingOrBasePrices2) {
                    String str4 = pidLoader.getPid().ssp.type;
                    e.get(0).setBiddingResult(str4, biddingOrBasePrices, biddingOrBasePrices2, 2);
                    str3 = str4;
                } else {
                    biddingOrBasePrices = biddingOrBasePrices2;
                }
                for (int i = 1; i < e.size(); i++) {
                    e.get(i).setBiddingResult(str3, biddingOrBasePrices, biddingOrBasePrices2, 2);
                }
            }
            PidLoader poll = e.poll();
            PidLoader poll2 = e2.poll();
            while (true) {
                if (poll == null && poll2 == null) {
                    return null;
                }
                PidLoader b = b(poll, poll2);
                if (b == poll) {
                    poll = e.poll();
                } else {
                    poll2 = e2.poll();
                }
                PidLoader pidLoader3 = poll2;
                PidLoader b2 = b(poll, pidLoader3);
                if (b2 != null) {
                    d = b2.getBiddingOrBasePrices();
                } else {
                    d = 0.0d;
                }
                b.setBiddingResult(b.getPid().ssp.type, b.getBiddingOrBasePrices(), d, 1);
                N a2 = a8bVar.a(b, str);
                if (a2 != null) {
                    LogPrinter.d("show pid : %s ", b.getPid().pid);
                    if (b.getPid().isBidding) {
                        str2 = b.getPid().pid;
                    } else {
                        str2 = "";
                    }
                    f(str2);
                    return a2;
                }
                poll2 = pidLoader3;
            }
        } else {
            return (N) invokeLLLL.objValue;
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
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
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
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, funAdSlot, funAdLoadListener) == null) {
            synchronized (this.a) {
                S s = this.b;
                if (s != null && !s.c()) {
                    com.fun.d0 d0Var = s.b;
                    d0Var.getClass();
                    d0Var.b("ldr_ld_err", NotificationCompat.CATEGORY_ERROR, "irr");
                    s.g();
                }
                this.b = null;
            }
            S c2 = c();
            c2.getClass();
            if (funAdLoadListener != null) {
                c2.b.b("ldr_ld_start", new Object[0]);
                c2.c = funAdLoadListener;
                c2.a(context, funAdSlot, funAdLoadListener);
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public final <T extends ViewGroup> boolean show(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, activity, t, str, funAdInteractionListener)) == null) {
            S c2 = c();
            c2.b.b("ldr_sh_start", new Object[0]);
            return c2.d(activity, t, funAdInteractionListener);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public final <T extends ViewGroup> FunSplashAd showSplash(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, activity, t, str, funAdInteractionListener)) == null) {
            S c2 = c();
            c2.b.b("ldr_sh_start", new Object[0]);
            return c2.e(activity, t, funAdInteractionListener);
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }
}
