package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b6b;
import com.baidu.tieba.k0b;
import com.baidu.tieba.xza;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.CacheStatistic;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdLoadListener;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.ReadyCacheStatistic;
import com.fun.ad.sdk.internal.api.PidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.flavor.CallBackAware;
import com.fun.ad.sdk.internal.api.flavor.Flavors;
import com.fun.ad.sdk.internal.api.flavor.IAdForbidStrategyManager;
import com.fun.ad.sdk.internal.api.flavor.RCInterceptor;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
/* loaded from: classes5.dex */
public class b6b extends k0b<b> {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int m = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final xza d;
    public final Map<Ssp.Pid, PidLoader> e;
    public final Random f;
    public FunAdInteractionListener g;
    public final boolean h;
    public final List<PidLoader> i;
    public final List<PidLoader> j;
    public final List<xza.a> k;
    public final Handler l;

    public b6b(xza xzaVar, f6b f6bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xzaVar, f6bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new Random();
        this.l = new a(this, Looper.getMainLooper());
        this.d = xzaVar;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        for (xza.b bVar : xzaVar.b) {
            for (xza.a aVar : bVar.b) {
                PidLoader a2 = f6bVar.a(aVar.c);
                if (a2 != null) {
                    if (aVar.c.isBidding) {
                        arrayList2.add(a2);
                        arrayList3.add(aVar);
                    } else {
                        arrayList.add(a2);
                    }
                    a2.addListener(new c(this, aVar, a2));
                    hashMap.put(aVar.c, a2);
                }
            }
        }
        this.e = Collections.unmodifiableMap(hashMap);
        this.i = Collections.unmodifiableList(arrayList);
        List<PidLoader> unmodifiableList = Collections.unmodifiableList(arrayList2);
        this.j = unmodifiableList;
        this.k = Collections.unmodifiableList(arrayList3);
        this.h = !unmodifiableList.isEmpty();
        if (hashMap2.isEmpty()) {
            return;
        }
        Collections.unmodifiableMap(hashMap2);
    }

    public static /* synthetic */ Object o(sza szaVar, PidLoader pidLoader, String str) {
        Object a2 = szaVar.a(pidLoader);
        if (a2 == null || !szaVar.a((sza) a2)) {
            return null;
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean q(List list, xza.a aVar) {
        PidLoader pidLoader = this.e.get(aVar.c);
        return (list == null || !list.contains(pidLoader)) && pidLoader != null && pidLoader.isLoaded();
    }

    @Override // com.baidu.tieba.k0b, com.fun.ad.sdk.FunAdLoader
    public synchronized void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                this.l.removeMessages(101, this);
                this.l.removeMessages(100);
                super.destroy();
                this.g = null;
                for (xza.b bVar : this.d.b) {
                    for (xza.a aVar : bVar.b) {
                        PidLoader pidLoader = this.e.get(aVar.c);
                        if (pidLoader != null) {
                            pidLoader.destroy();
                        }
                    }
                }
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public ReadyCacheStatistic getCacheStatistic(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? a(this.j, this.i) : (ReadyCacheStatistic) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized List<CacheStatistic> getCacheStatistics(String str) {
        InterceptResult invokeL;
        ArrayList arrayList;
        PidLoader pidLoader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                for (xza.b bVar : this.d.b) {
                    for (xza.a aVar : bVar.b) {
                        if (aVar != null && (pidLoader = this.e.get(aVar.c)) != null && pidLoader.isLoaded()) {
                            arrayList.add(new CacheStatistic(pidLoader.getAdType(), pidLoader.getPid().pid, pidLoader.getAdCount(), pidLoader.getBiddingOrBasePrices()));
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public FunNativeAd2 getNativeAd2(final Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            FunNativeAd2 funNativeAd2 = (FunNativeAd2) p(new h6b() { // from class: com.baidu.tieba.yya
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.h6b
                public final Object a(PidLoader pidLoader, String str) {
                    InterceptResult invokeLL;
                    FunNativeAd2 nativeAd2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, pidLoader, str)) == null) {
                        nativeAd2 = pidLoader.getNativeAd2(context, str);
                        return nativeAd2;
                    }
                    return invokeLL.objValue;
                }
            });
            if (funNativeAd2 == null) {
                LogPrinter.e("getNativeAd for sid:%s with No ready pidLoader found", this.d.a);
            }
            return funNativeAd2;
        }
        return (FunNativeAd2) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized boolean isReady() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                Iterator<xza.b> it = this.d.b.iterator();
                loop0: while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    for (xza.a aVar : it.next().b) {
                        PidLoader pidLoader = this.e.get(aVar.c);
                        if (pidLoader != null && pidLoader.isLoaded()) {
                            z = true;
                            break loop0;
                        }
                    }
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final PidLoader l(xza.b bVar, final List<PidLoader> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bVar, list)) == null) {
            xza.a aVar = (xza.a) qza.a(this.f, bVar.b, new rza() { // from class: com.baidu.tieba.kza
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.rza
                public final boolean a(Object obj) {
                    InterceptResult invokeL;
                    boolean q;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) {
                        q = b6b.this.q(list, (xza.a) obj);
                        return q;
                    }
                    return invokeL.booleanValue;
                }
            });
            if (aVar == null) {
                return null;
            }
            return this.e.get(aVar.c);
        }
        return (PidLoader) invokeLL.objValue;
    }

    public final <Result> Result n(FunAdInteractionListener funAdInteractionListener, final sza<Result> szaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, funAdInteractionListener, szaVar)) == null) {
            this.g = funAdInteractionListener;
            if (p(new h6b() { // from class: com.baidu.tieba.uya
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.h6b
                public final Object a(PidLoader pidLoader, String str) {
                    InterceptResult invokeLL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL2 = interceptable2.invokeLL(1048576, this, pidLoader, str)) == null) ? b6b.o(sza.this, pidLoader, str) : invokeLL2.objValue;
                }
            }) == null) {
                funAdInteractionListener.onAdError(this.d.a);
                this.g = null;
                LogPrinter.e("showFailed for SerialSlotId(%s), because no ready loader found", this.d.a);
            }
            return null;
        }
        return (Result) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.k0b, com.fun.ad.sdk.FunAdLoader
    public void recycleListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.recycleListener();
            this.g = null;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends k0b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context d;
        public FunAdSlot e;
        public Iterator<xza.b> f;
        public final HashSet<xza.a> g;
        public final LinkedHashMap<xza.a, Integer> h;
        public final List<PidLoader> i;
        public boolean j;
        public boolean k;
        public boolean l;
        public double m;
        public boolean n;
        public int o;
        public final /* synthetic */ b6b p;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-963763971, "Lcom/baidu/tieba/b6b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-963763971, "Lcom/baidu/tieba/b6b$b;");
                    return;
                }
            }
            b6b.class.desiredAssertionStatus();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(b6b b6bVar) {
            super(b6bVar.d.a, b6bVar.d.c, "s");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b6bVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.p = b6bVar;
            this.g = new HashSet<>();
            this.h = new LinkedHashMap<>();
            this.i = new ArrayList();
            this.j = true;
            this.k = false;
            this.l = false;
            this.m = 0.0d;
            this.o = 0;
        }

        public static /* synthetic */ int h(PidLoader pidLoader, PidLoader pidLoader2) {
            return -Double.compare(pidLoader.getBiddingOrBasePrices(), pidLoader2.getBiddingOrBasePrices());
        }

        public final boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !this.f.hasNext() && this.g.isEmpty() : invokeV.booleanValue;
        }

        /* loaded from: classes5.dex */
        public class a implements sza<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ ViewGroup b;
            public final /* synthetic */ b c;

            public a(b bVar, Activity activity, ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, activity, viewGroup};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = activity;
                this.b = viewGroup;
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Boolean, java.lang.Object] */
            @Override // com.baidu.tieba.sza
            public Boolean a(PidLoader pidLoader) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pidLoader)) == null) {
                    b bVar = this.c;
                    return Boolean.valueOf(pidLoader.show(this.a, this.b, bVar.p.d.a, bVar.a));
                }
                return invokeL.objValue;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.baidu.tieba.sza
            public boolean a(Boolean bool) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool)) == null) {
                    return bool.booleanValue();
                }
                return invokeL.booleanValue;
            }
        }

        /* renamed from: com.baidu.tieba.b6b$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0249b implements sza<FunSplashAd> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ ViewGroup b;
            public final /* synthetic */ b c;

            public C0249b(b bVar, Activity activity, ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, activity, viewGroup};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = activity;
                this.b = viewGroup;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.baidu.tieba.sza
            public boolean a(FunSplashAd funSplashAd) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funSplashAd)) == null) {
                    return true;
                }
                return invokeL.booleanValue;
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            /* JADX WARN: Type inference failed for: r1v0, types: [com.fun.ad.sdk.FunSplashAd, java.lang.Object] */
            @Override // com.baidu.tieba.sza
            public FunSplashAd a(PidLoader pidLoader) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pidLoader)) == null) {
                    b bVar = this.c;
                    return pidLoader.showSplash(this.a, this.b, bVar.p.d.a, bVar.a);
                }
                return invokeL.objValue;
            }
        }

        @Override // com.baidu.tieba.k0b.a
        public void a(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, context, funAdSlot, funAdLoadListener) == null) {
                this.p.l.removeMessages(100);
                this.p.l.removeMessages(101, this);
                this.d = context;
                this.e = funAdSlot;
                if (this.p.d.b.isEmpty()) {
                    LogPrinter.e("No groups found in SerialSlotId(%s)", this.p.d.a);
                    b("g_empty");
                    return;
                }
                this.f = this.p.d.b.iterator();
                b6b b6bVar = this.p;
                if (!b6bVar.h) {
                    this.j = true;
                } else {
                    this.j = false;
                    long j = 0;
                    synchronized (b6bVar) {
                        ArrayList arrayList = new ArrayList();
                        for (xza.a aVar : this.p.k) {
                            long j2 = aVar.d.a;
                            if (j2 > j) {
                                j = j2;
                            }
                            b6b b6bVar2 = this.p;
                            b6bVar2.getClass();
                            PidLoader pidLoader = b6bVar2.e.get(aVar.c);
                            if (pidLoader != null) {
                                if (pidLoader.isLoaded()) {
                                    pidLoader.destroy(true);
                                }
                                RCInterceptor shouldIntercept = Flavors.PLUGIN_RC.shouldIntercept(pidLoader.getPid().pid, pidLoader.getAdType());
                                if (shouldIntercept == null || !shouldIntercept.shouldInterceptLoad()) {
                                    this.h.put(aVar, 0);
                                    arrayList.add(pidLoader);
                                }
                            }
                        }
                        if (arrayList.isEmpty()) {
                            this.j = true;
                        } else {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ((PidLoader) it.next()).load(this.d, this.e, this.a);
                            }
                            this.p.l.sendMessageDelayed(this.p.l.obtainMessage(101, this), j);
                        }
                    }
                }
                n();
            }
        }

        @Override // com.baidu.tieba.k0b.a
        public boolean d(Activity activity, ViewGroup viewGroup, FunAdInteractionListener funAdInteractionListener) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, viewGroup, funAdInteractionListener)) == null) {
                b6b b6bVar = this.p;
                a aVar = new a(this, activity, viewGroup);
                int i = b6b.m;
                b6bVar.n(funAdInteractionListener, aVar);
                return false;
            }
            return invokeLLL.booleanValue;
        }

        @Override // com.baidu.tieba.k0b.a
        public FunSplashAd e(Activity activity, ViewGroup viewGroup, FunAdInteractionListener funAdInteractionListener) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, viewGroup, funAdInteractionListener)) == null) {
                b6b b6bVar = this.p;
                C0249b c0249b = new C0249b(this, activity, viewGroup);
                int i = b6b.m;
                b6bVar.n(funAdInteractionListener, c0249b);
                return null;
            }
            return (FunSplashAd) invokeLLL.objValue;
        }

        @Override // com.baidu.tieba.k0b.a
        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.c = null;
                synchronized (this.p) {
                    this.j = true;
                    this.p.l.removeMessages(100, this);
                    this.p.l.removeMessages(101, this);
                    this.g.clear();
                }
            }
        }

        public void i(xza.a aVar) {
            PidLoader pidLoader;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                synchronized (this.p) {
                    if (!m()) {
                        return;
                    }
                    b6b b6bVar = this.p;
                    int i = b6b.m;
                    b6bVar.getClass();
                    if (aVar == null) {
                        pidLoader = null;
                    } else {
                        pidLoader = b6bVar.e.get(aVar.c);
                    }
                    if (pidLoader != null) {
                        this.i.add(pidLoader);
                    }
                    b6b b6bVar2 = this.p;
                    if (b6bVar2.h) {
                        boolean z = aVar.c.isBidding;
                        if (z && !this.j) {
                            b6bVar2.l.removeMessages(101, this);
                            this.h.put(aVar, 1);
                            if (pidLoader != null) {
                                if (pidLoader.getBiddingOrBasePrices() > this.m) {
                                    this.m = pidLoader.getBiddingOrBasePrices();
                                }
                                LogPrinter.d("bidding ad:" + aVar.c.pid + "load success：", new Object[0]);
                            }
                            this.k = true;
                            if (!this.l && !k()) {
                                return;
                            }
                        } else if (!z) {
                            b6bVar2.l.removeMessages(100, this);
                            this.l = true;
                            if (!this.k && !this.j) {
                                return;
                            }
                        }
                    }
                    if (!this.g.remove(aVar) && !aVar.c.isBidding) {
                        return;
                    }
                    j();
                    f();
                }
            }
        }

        public final void j() {
            double d;
            double d2;
            String str;
            double d3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || !this.p.h || this.i.isEmpty()) {
                return;
            }
            PidLoader pidLoader = null;
            Collections.sort(this.i, new Comparator() { // from class: com.baidu.tieba.aza
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, obj, obj2)) == null) ? b6b.b.h((PidLoader) obj, (PidLoader) obj2) : invokeLL.intValue;
                }
            });
            if (this.i.size() >= 1) {
                pidLoader = this.i.get(0);
                d2 = pidLoader.getBiddingOrBasePrices();
                if (this.i.size() >= 2) {
                    d3 = this.i.get(1).getBiddingOrBasePrices();
                } else {
                    d3 = 0.0d;
                }
                if (d3 != 0.0d) {
                    pidLoader.setBiddingResult(pidLoader.getPid().ssp.type, d2, d3, 1);
                }
                d = d3;
            } else {
                d = 0.0d;
                d2 = 0.0d;
            }
            for (Map.Entry<xza.a, Integer> entry : this.h.entrySet()) {
                entry.getValue().intValue();
                PidLoader pidLoader2 = this.p.e.get(entry.getKey().c);
                if (pidLoader2 != null && pidLoader2 != pidLoader) {
                    if (pidLoader == null) {
                        str = "";
                    } else {
                        str = pidLoader.getPid().ssp.type;
                    }
                    pidLoader2.setBiddingResult(str, d2, d, 2);
                }
            }
        }

        public final void l() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                if (!this.j) {
                    Iterator<Map.Entry<xza.a, Integer>> it = this.h.entrySet().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().getValue().intValue() != -1) {
                                z = false;
                                break;
                            }
                        } else {
                            z = true;
                            break;
                        }
                    }
                    this.j = z;
                }
                if (this.j) {
                    this.p.l.removeMessages(101, this);
                }
                boolean z2 = this.j;
                if (z2 && this.l) {
                    j();
                    f();
                } else if (z2 && k()) {
                    LogPrinter.d("All loader load failed, callback onError(%s)", this.p.d.a);
                    j();
                    b("af");
                }
            }
        }

        public final boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (this.p.b != this) {
                    return false;
                }
                if (c()) {
                    LogPrinter.d("Give up load by LoadHandler with listener already recycled", new Object[0]);
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public void n() {
            PidLoader pidLoader;
            RCInterceptor shouldIntercept;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                synchronized (this.p) {
                    if (this.n) {
                        this.o++;
                        this.n = false;
                    }
                    if (!m()) {
                        return;
                    }
                    if (k()) {
                        if (this.j) {
                            LogPrinter.d("All loader load failed, callback onError(%s)", this.p.d.a);
                            j();
                            b("af");
                        } else if (this.k) {
                            j();
                            f();
                        }
                    } else if (!this.f.hasNext()) {
                        LogPrinter.d("All loader already started, just wait for the loader callback", new Object[0]);
                    } else {
                        xza.b next = this.f.next();
                        this.n = true;
                        if (next.b.isEmpty()) {
                            LogPrinter.e("There is an empty group in SerialSid(%s)", this.p.d.a);
                            n();
                            return;
                        }
                        double d = 0.0d;
                        boolean z = true;
                        for (xza.a aVar : next.b) {
                            Ssp.Pid pid = aVar.c;
                            if (!pid.isBidding) {
                                double a2 = y5b.a(pid.pid) * 1000.0d;
                                if (d < a2) {
                                    d = a2;
                                }
                                z = false;
                            }
                        }
                        if (!z) {
                            double d2 = this.m;
                            if (d2 != 0.0d && d2 > d) {
                                if (!m()) {
                                    return;
                                }
                                j();
                                f();
                                return;
                            }
                        }
                        ArrayList arrayList = new ArrayList();
                        for (xza.a aVar2 : next.b) {
                            Ssp.Pid pid2 = aVar2.c;
                            if (!pid2.isBidding && (pidLoader = this.p.e.get(pid2)) != null && ((shouldIntercept = Flavors.PLUGIN_RC.shouldIntercept(pidLoader.getPid().pid, pidLoader.getAdType())) == null || !shouldIntercept.shouldInterceptLoad())) {
                                this.g.add(aVar2);
                                if (pidLoader.isLoaded()) {
                                    i(aVar2);
                                    return;
                                }
                                arrayList.add(pidLoader);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            LogPrinter.e("No group which ready to load found in SerialSid(%s)", this.p.d.a);
                            n();
                            return;
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((PidLoader) it.next()).load(this.d, this.e, this.a);
                        }
                        this.p.l.removeMessages(100, this);
                        this.p.l.sendMessageDelayed(this.p.l.obtainMessage(100, this), next.a);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b6b b6bVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b6bVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i != 100) {
                    if (i == 101) {
                        b bVar = (b) message.obj;
                        if (bVar == null) {
                            LogPrinter.d("MSG_BIDDING_LOAD_TIMEOUT: give up load without LoadHandler", new Object[0]);
                            return;
                        }
                        bVar.j = true;
                        bVar.l();
                        return;
                    }
                    return;
                }
                b bVar2 = (b) message.obj;
                if (bVar2 == null) {
                    LogPrinter.d("MSG_CONTINUE_LOAD: give up load without LoadHandler", new Object[0]);
                } else {
                    bVar2.n();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements e6b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ boolean d;
        public transient /* synthetic */ FieldHolder $fh;
        public final xza.a a;
        public final PidLoader b;
        public final /* synthetic */ b6b c;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-963763940, "Lcom/baidu/tieba/b6b$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-963763940, "Lcom/baidu/tieba/b6b$c;");
                    return;
                }
            }
            d = !b6b.class.desiredAssertionStatus();
        }

        public c(b6b b6bVar, xza.a aVar, PidLoader pidLoader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b6bVar, aVar, pidLoader};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.c = b6bVar;
            this.a = aVar;
            this.b = pidLoader;
        }

        @Override // com.baidu.tieba.e6b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // com.baidu.tieba.e6b
        public void a() {
            b bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (bVar = (b) this.c.b) != null) {
                bVar.i(this.a);
            }
        }

        @Override // com.baidu.tieba.e6b
        public void a(int i, String str) {
            b bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && (bVar = (b) this.c.b) != null) {
                xza.a aVar = this.a;
                synchronized (bVar.p) {
                    if (bVar.m()) {
                        if (aVar.c.isBidding) {
                            if (bVar.h.containsKey(aVar)) {
                                bVar.h.put(aVar, -1);
                                bVar.l();
                            }
                        } else if (bVar.g.remove(aVar)) {
                            if (bVar.k()) {
                                if (bVar.k) {
                                    bVar.j();
                                    bVar.f();
                                } else if (bVar.j) {
                                    bVar.j();
                                    LogPrinter.d("All loader load failed, callback onError(%s)", bVar.p.d.a);
                                    bVar.b("af");
                                }
                            } else if (bVar.g.isEmpty()) {
                                bVar.p.l.removeMessages(100, bVar);
                                bVar.p.l.obtainMessage(100, bVar).sendToTarget();
                            }
                        }
                    }
                }
                IAdForbidStrategyManager iAdForbidStrategyManager = Flavors.STRATEGY_MANAGER;
                Ssp.Pid pid = this.a.c;
                iAdForbidStrategyManager.setErrInfo(pid.ssp.type, pid.pid, i, str);
            }
        }

        @Override // com.baidu.tieba.e6b
        public void a(Map<String, String> map) {
            b6b b6bVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) && (funAdInteractionListener = (b6bVar = this.c).g) != null) {
                CallBackAware callBackAware = Flavors.CALL_BACK_AWARE;
                String str = b6bVar.d.a;
                Ssp.Pid pid = this.a.c;
                callBackAware.onAdClose(funAdInteractionListener, str, pid.ssp.type, pid.pid, map);
            }
        }

        @Override // com.baidu.tieba.e6b
        public void a(boolean z, int i, Map<String, String> map) {
            b6b b6bVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), map}) == null) && (funAdInteractionListener = (b6bVar = this.c).g) != null) {
                CallBackAware callBackAware = Flavors.CALL_BACK_AWARE;
                String str = b6bVar.d.a;
                Ssp.Pid pid = this.a.c;
                callBackAware.onRewardedVideo(funAdInteractionListener, str, z, pid.ssp.type, i, pid.pid, map);
            }
        }

        @Override // com.baidu.tieba.e6b
        public void b(int i, String str) {
            b6b b6bVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) && (funAdInteractionListener = (b6bVar = this.c).g) != null) {
                funAdInteractionListener.onAdError(b6bVar.d.a);
            }
        }

        @Override // com.baidu.tieba.e6b
        public void c(RippedAd rippedAd, Map<String, String> map) {
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048582, this, rippedAd, map) == null) && (funAdInteractionListener = this.c.g) != null) {
                if (!d && this.a.c == null) {
                    throw new AssertionError();
                }
                RCInterceptor shouldIntercept = Flavors.PLUGIN_RC.shouldIntercept(this.a.c.pid, this.b.getAdType());
                if (shouldIntercept != null) {
                    shouldIntercept.onAdClick(rippedAd);
                }
                CallBackAware callBackAware = Flavors.CALL_BACK_AWARE;
                String str = this.c.d.a;
                Ssp.Pid pid = this.a.c;
                callBackAware.onAdClicked(funAdInteractionListener, str, pid.ssp.type, pid.pid, rippedAd, map);
            }
        }

        @Override // com.baidu.tieba.e6b
        public void d(RippedAd rippedAd, Map<String, String> map) {
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048583, this, rippedAd, map) == null) && (funAdInteractionListener = this.c.g) != null) {
                if (!d && this.a.c == null) {
                    throw new AssertionError();
                }
                RCInterceptor shouldIntercept = Flavors.PLUGIN_RC.shouldIntercept(this.a.c.pid, this.b.getAdType());
                if (shouldIntercept != null) {
                    shouldIntercept.onAdShow(rippedAd);
                }
                CallBackAware callBackAware = Flavors.CALL_BACK_AWARE;
                String str = this.c.d.a;
                Ssp.Pid pid = this.a.c;
                callBackAware.show(funAdInteractionListener, str, pid.ssp.type, pid.pid, rippedAd, map);
            }
        }
    }

    @Override // com.baidu.tieba.k0b
    public void f(String str) {
        PidLoader pidLoader;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            for (xza.a aVar : this.k) {
                if (!aVar.c.pid.equals(str) && (pidLoader = this.e.get(aVar.c)) != null && pidLoader.isLoaded()) {
                    LogPrinter.d("destroy bid : %s ", aVar.c.pid);
                    pidLoader.destroy(true);
                }
            }
        }
    }

    public final <N> N p(h6b<N> h6bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, h6bVar)) == null) {
            if (this.h) {
                return (N) d(this.j, this.i, h6bVar, this.d.a);
            }
            for (xza.b bVar : this.d.b) {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    PidLoader l = l(bVar, arrayList);
                    if (l != null) {
                        N a2 = h6bVar.a(l, this.d.a);
                        if (a2 == null) {
                            arrayList.add(l);
                        } else {
                            return a2;
                        }
                    }
                }
            }
            return null;
        }
        return (N) invokeL.objValue;
    }

    /* JADX DEBUG: Return type fixed from 'com.baidu.tieba.k0b$a' to match base method */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.baidu.tieba.b6b$b, com.baidu.tieba.k0b$a] */
    @Override // com.baidu.tieba.k0b
    public b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return new b(this);
        }
        return (k0b.a) invokeV.objValue;
    }
}
