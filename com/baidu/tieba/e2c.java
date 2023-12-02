package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.e2c.a;
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
public abstract class e2c<S extends a> implements FunAdLoader {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ boolean a;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object b;
    public S c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947683891, "Lcom/baidu/tieba/e2c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947683891, "Lcom/baidu/tieba/e2c;");
                return;
            }
        }
        a = !e2c.class.desiredAssertionStatus();
    }

    public e2c() {
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
        this.b = new Object();
    }

    public static /* synthetic */ int b(PidLoader pidLoader, PidLoader pidLoader2) {
        return -Double.compare(pidLoader.getBiddingOrBasePrices(), pidLoader2.getBiddingOrBasePrices());
    }

    public static /* synthetic */ int c(PidLoader pidLoader, PidLoader pidLoader2) {
        return -Double.compare(pidLoader.getBiddingOrBasePrices(), pidLoader2.getBiddingOrBasePrices());
    }

    public static /* synthetic */ int d(PidLoader pidLoader, PidLoader pidLoader2) {
        return -Double.compare(pidLoader.getBiddingOrBasePrices(), pidLoader2.getBiddingOrBasePrices());
    }

    public final S a() {
        InterceptResult invokeV;
        S s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this.b) {
                s = this.c;
                if (s == null) {
                    s = b();
                    if (!a && s == null) {
                        throw new AssertionError();
                    }
                    this.c = s;
                }
            }
            return s;
        }
        return (S) invokeV.objValue;
    }

    public final PidLoader a(PidLoader pidLoader, PidLoader pidLoader2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, pidLoader, pidLoader2)) == null) {
            if (pidLoader == null && pidLoader2 == null) {
                return null;
            }
            return (pidLoader != null && (pidLoader2 == null || pidLoader.getBiddingOrBasePrices() >= pidLoader2.getBiddingOrBasePrices())) ? pidLoader : pidLoader2;
        }
        return (PidLoader) invokeLL.objValue;
    }

    public final LinkedList<PidLoader> a(List<PidLoader> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
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

    public abstract void a(String str);

    public abstract S b();

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

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c == null : invokeV.booleanValue;
        }

        public abstract boolean a(Activity activity, ViewGroup viewGroup, FunAdInteractionListener funAdInteractionListener);

        public abstract FunSplashAd b(Activity activity, ViewGroup viewGroup, FunAdInteractionListener funAdInteractionListener);

        public abstract void c();

        public final void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                com.fun.d0 d0Var = this.b;
                d0Var.getClass();
                d0Var.b("ldr_ld_err", NotificationCompat.CATEGORY_ERROR, str);
                this.c.onError(this.a.sid);
                c();
            }
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.b.b("ldr_ld_succeed", new Object[0]);
                this.c.onAdLoaded(this.a.sid);
                c();
            }
        }
    }

    public ReadyCacheStatistic a(List<PidLoader> list, List<PidLoader> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, list2)) == null) {
            LinkedList<PidLoader> a2 = a(list);
            Collections.sort(a2, new Comparator() { // from class: com.baidu.tieba.t0c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    InterceptResult invokeLL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL2 = interceptable2.invokeLL(1048576, this, obj, obj2)) == null) ? e2c.b((PidLoader) obj, (PidLoader) obj2) : invokeLL2.intValue;
                }
            });
            LinkedList<PidLoader> a3 = a(list2);
            Collections.sort(a3, new Comparator() { // from class: com.baidu.tieba.c1c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    InterceptResult invokeLL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL2 = interceptable2.invokeLL(1048576, this, obj, obj2)) == null) ? e2c.c((PidLoader) obj, (PidLoader) obj2) : invokeLL2.intValue;
                }
            });
            PidLoader poll = a2.poll();
            PidLoader poll2 = a3.poll();
            if (poll == null && poll2 == null) {
                return null;
            }
            PidLoader a4 = a(poll, poll2);
            FunAdType adType = a4.getAdType();
            FunAdType adType2 = a4.getAdType();
            String str = a4.getPid().pid;
            a4.getSubAidInfo().getClass();
            ReadyCacheStatistic readyCacheStatistic = new ReadyCacheStatistic(adType2, str, "");
            if (this.c != null) {
                S s = this.c;
                String str2 = a4.getPid().pid;
                n7c subAidInfo = a4.getSubAidInfo();
                com.fun.d0 d0Var = s.b;
                subAidInfo.getClass();
                d0Var.getClass();
                d0Var.b("ldr_rdy_show", "k_rdy_adtype", adType.getPlatform() + "-" + adType.getAdType().toString(), "k_rdy_pid", str2, "k_rdy_ntwnm", "", "subAid", "");
            }
            return readyCacheStatistic;
        }
        return (ReadyCacheStatistic) invokeLL.objValue;
    }

    public final <N> N a(List<PidLoader> list, List<PidLoader> list2, s7c<N> s7cVar, String str) {
        InterceptResult invokeLLLL;
        double d;
        String str2;
        double biddingOrBasePrices;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, list, list2, s7cVar, str)) == null) {
            LinkedList<PidLoader> a2 = a(list);
            Collections.sort(a2, new Comparator() { // from class: com.baidu.tieba.v0c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, obj, obj2)) == null) ? e2c.d((PidLoader) obj, (PidLoader) obj2) : invokeLL.intValue;
                }
            });
            LinkedList<PidLoader> a3 = a(list2);
            if (a3.size() > 0 && a2.size() > 0) {
                PidLoader pidLoader = a3.get(0);
                if (pidLoader != null) {
                    try {
                        biddingOrBasePrices = pidLoader.getBiddingOrBasePrices();
                    } catch (Exception e) {
                        LogPrinter.e(e);
                    }
                } else {
                    biddingOrBasePrices = 0.0d;
                }
                PidLoader pidLoader2 = a2.get(0);
                double biddingOrBasePrices2 = pidLoader2.getBiddingOrBasePrices();
                String str3 = pidLoader2.getPid().ssp.type;
                if (biddingOrBasePrices > biddingOrBasePrices2) {
                    String str4 = pidLoader.getPid().ssp.type;
                    a2.get(0).setBiddingResult(str4, biddingOrBasePrices, biddingOrBasePrices2, 2);
                    str3 = str4;
                } else {
                    biddingOrBasePrices = biddingOrBasePrices2;
                }
                for (int i = 1; i < a2.size(); i++) {
                    a2.get(i).setBiddingResult(str3, biddingOrBasePrices, biddingOrBasePrices2, 2);
                }
            }
            PidLoader poll = a2.poll();
            PidLoader poll2 = a3.poll();
            while (true) {
                if (poll == null && poll2 == null) {
                    return null;
                }
                PidLoader a4 = a(poll, poll2);
                if (a4 == poll) {
                    poll = a2.poll();
                } else {
                    poll2 = a3.poll();
                }
                PidLoader pidLoader3 = poll2;
                PidLoader a5 = a(poll, pidLoader3);
                if (a5 != null) {
                    d = a5.getBiddingOrBasePrices();
                } else {
                    d = 0.0d;
                }
                a4.setBiddingResult(a4.getPid().ssp.type, a4.getBiddingOrBasePrices(), d, 1);
                N a6 = s7cVar.a(a4, str);
                if (a6 != null) {
                    LogPrinter.d("show pid : %s ", a4.getPid().pid);
                    if (a4.getPid().isBidding) {
                        str2 = a4.getPid().pid;
                    } else {
                        str2 = "";
                    }
                    a(str2);
                    return a6;
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
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this.b) {
                S s = this.c;
                if (s != null) {
                    s.c();
                }
                this.c = null;
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public void recycleListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this.b) {
                S s = this.c;
                if (s != null) {
                    s.c();
                }
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public final void load(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, funAdSlot, funAdLoadListener) == null) {
            synchronized (this.b) {
                S s = this.c;
                if (s != null && !s.a()) {
                    com.fun.d0 d0Var = s.b;
                    d0Var.getClass();
                    d0Var.b("ldr_ld_err", NotificationCompat.CATEGORY_ERROR, "irr");
                    s.c();
                }
                this.c = null;
            }
            S a2 = a();
            a2.getClass();
            if (funAdLoadListener != null) {
                a2.b.b("ldr_ld_start", new Object[0]);
                a2.c = funAdLoadListener;
                a2.a(context, funAdSlot, funAdLoadListener);
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
            S a2 = a();
            a2.b.b("ldr_sh_start", new Object[0]);
            return a2.a(activity, t, funAdInteractionListener);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public final <T extends ViewGroup> FunSplashAd showSplash(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, activity, t, str, funAdInteractionListener)) == null) {
            S a2 = a();
            a2.b.b("ldr_sh_start", new Object[0]);
            return a2.b(activity, t, funAdInteractionListener);
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }
}
