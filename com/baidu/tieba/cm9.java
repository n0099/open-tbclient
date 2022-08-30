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
import com.baidu.tieba.lg9;
import com.baidu.tieba.tl9;
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
import com.fun.ad.sdk.internal.api.PidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.flavor.CallBackAware;
import com.fun.ad.sdk.internal.api.flavor.Flavors;
import com.fun.ad.sdk.internal.api.flavor.RCInterceptor;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
/* loaded from: classes3.dex */
public class cm9 extends tl9<b> {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int l = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final lg9 d;
    public final Map<Ssp.Pid, PidLoader> e;
    public final Random f;
    public FunAdInteractionListener g;
    public final boolean h;
    public final List<PidLoader> i;
    public final List<PidLoader> j;
    public final Handler k;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(cm9 cm9Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cm9Var, looper};
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 100) {
                b bVar = (b) message.obj;
                if (bVar == null) {
                    LogPrinter.d("MSG_CONTINUE_LOAD: give up load without LoadHandler", new Object[0]);
                } else {
                    bVar.k();
                }
            }
        }
    }

    public cm9(lg9 lg9Var, bg9 bg9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lg9Var, bg9Var};
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
        this.k = new a(this, Looper.getMainLooper());
        this.d = lg9Var;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (lg9.b bVar : lg9Var.b) {
            for (lg9.a aVar : bVar.b) {
                PidLoader a2 = bg9Var.a(aVar.c);
                if (a2 != null) {
                    if (aVar.c.isBidding) {
                        arrayList2.add(a2);
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
        this.h = !unmodifiableList.isEmpty();
    }

    public static /* synthetic */ Object l(mg9 mg9Var, PidLoader pidLoader, String str) {
        Object a2 = mg9Var.a(pidLoader);
        if (a2 == null || !mg9Var.a((mg9) a2)) {
            return null;
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean m(List list, lg9.a aVar) {
        PidLoader pidLoader = this.e.get(aVar.c);
        return (list == null || !list.contains(pidLoader)) && pidLoader != null && pidLoader.isLoaded();
    }

    @Override // com.baidu.tieba.tl9, com.fun.ad.sdk.FunAdLoader
    public synchronized void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                this.k.removeMessages(100);
                super.destroy();
                this.g = null;
                for (lg9.b bVar : this.d.b) {
                    for (lg9.a aVar : bVar.b) {
                        PidLoader pidLoader = this.e.get(aVar.c);
                        if (pidLoader != null) {
                            pidLoader.destroy();
                        }
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Return type fixed from 'com.baidu.tieba.tl9$a' to match base method */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.baidu.tieba.cm9$b, com.baidu.tieba.tl9$a] */
    @Override // com.baidu.tieba.tl9
    public b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new b(this) : (tl9.a) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized List<CacheStatistic> getCacheStatistics(String str) {
        InterceptResult invokeL;
        ArrayList arrayList;
        PidLoader pidLoader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                for (lg9.b bVar : this.d.b) {
                    for (lg9.a aVar : bVar.b) {
                        if (aVar != null && (pidLoader = this.e.get(aVar.c)) != null && pidLoader.isLoaded()) {
                            arrayList.add(new CacheStatistic(pidLoader.getAdType(), pidLoader.getPid().pid, pidLoader.getAdCount(), pidLoader.getPid().basePrice));
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            FunNativeAd2 funNativeAd2 = (FunNativeAd2) k(new fg9() { // from class: com.baidu.tieba.qf9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.fg9
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

    public final PidLoader h(lg9.b bVar, final List<PidLoader> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, bVar, list)) == null) {
            lg9.a aVar = (lg9.a) dg9.a(this.f, bVar.b, new kg9() { // from class: com.baidu.tieba.vf9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.kg9
                public final boolean a(Object obj) {
                    InterceptResult invokeL;
                    boolean m;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) {
                        m = cm9.this.m(list, (lg9.a) obj);
                        return m;
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

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized boolean isReady() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                Iterator<lg9.b> it = this.d.b.iterator();
                loop0: while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    for (lg9.a aVar : it.next().b) {
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

    public final <Result> Result j(FunAdInteractionListener funAdInteractionListener, final mg9<Result> mg9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, funAdInteractionListener, mg9Var)) == null) {
            this.g = funAdInteractionListener;
            if (k(new fg9() { // from class: com.baidu.tieba.sf9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.fg9
                public final Object a(PidLoader pidLoader, String str) {
                    InterceptResult invokeLL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL2 = interceptable2.invokeLL(1048576, this, pidLoader, str)) == null) ? cm9.l(mg9.this, pidLoader, str) : invokeLL2.objValue;
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

    public final <N> N k(fg9<N> fg9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, fg9Var)) == null) {
            if (this.h) {
                return (N) c(this.j, this.i, fg9Var, this.d.a);
            }
            for (lg9.b bVar : this.d.b) {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    PidLoader h = h(bVar, arrayList);
                    if (h != null) {
                        N a2 = fg9Var.a(h, this.d.a);
                        if (a2 != null) {
                            return a2;
                        }
                        arrayList.add(h);
                    }
                }
            }
            return null;
        }
        return (N) invokeL.objValue;
    }

    @Override // com.baidu.tieba.tl9, com.fun.ad.sdk.FunAdLoader
    public void recycleListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.recycleListener();
            this.g = null;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements wf9 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ boolean d;
        public transient /* synthetic */ FieldHolder $fh;
        public final lg9.a a;
        public final PidLoader b;
        public final /* synthetic */ cm9 c;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-885562565, "Lcom/baidu/tieba/cm9$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-885562565, "Lcom/baidu/tieba/cm9$c;");
                    return;
                }
            }
            d = !cm9.class.desiredAssertionStatus();
        }

        public c(cm9 cm9Var, lg9.a aVar, PidLoader pidLoader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cm9Var, aVar, pidLoader};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.c = cm9Var;
            this.a = aVar;
            this.b = pidLoader;
        }

        @Override // com.baidu.tieba.wf9
        public void a() {
            cm9 cm9Var;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (funAdInteractionListener = (cm9Var = this.c).g) == null) {
                return;
            }
            funAdInteractionListener.onAdClose(cm9Var.d.a);
        }

        @Override // com.baidu.tieba.wf9
        public void b(RippedAd rippedAd, String... strArr) {
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048581, this, rippedAd, strArr) == null) || (funAdInteractionListener = this.c.g) == null) {
                return;
            }
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
            callBackAware.onAdClicked(funAdInteractionListener, str, pid.ssp.type, pid.pid, strArr);
        }

        @Override // com.baidu.tieba.wf9
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            }
        }

        @Override // com.baidu.tieba.wf9
        public void c(RippedAd rippedAd, String... strArr) {
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048583, this, rippedAd, strArr) == null) || (funAdInteractionListener = this.c.g) == null) {
                return;
            }
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
            callBackAware.show(funAdInteractionListener, str, pid.ssp.type, pid.pid, rippedAd, strArr);
        }

        @Override // com.baidu.tieba.wf9
        public void a(int i, String str) {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) || (bVar = (b) this.c.b) == null) {
                return;
            }
            lg9.a aVar = this.a;
            synchronized (bVar.k) {
                if (bVar.j() && bVar.g.remove(aVar)) {
                    if (!bVar.f.hasNext() && bVar.g.isEmpty()) {
                        bVar.i(null, bVar.j, true);
                        LogPrinter.d("All loader load failed, callback onError(%s)", bVar.k.d.a);
                        bVar.b("af");
                    } else if (bVar.g.isEmpty()) {
                        bVar.k.k.removeMessages(100, bVar);
                        bVar.k.k.obtainMessage(100, bVar).sendToTarget();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.wf9
        public void b(int i, String str) {
            cm9 cm9Var;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) || (funAdInteractionListener = (cm9Var = this.c).g) == null) {
                return;
            }
            funAdInteractionListener.onAdError(cm9Var.d.a);
        }

        @Override // com.baidu.tieba.wf9
        public void b() {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bVar = (b) this.c.b) == null) {
                return;
            }
            bVar.h(this.a);
        }

        @Override // com.baidu.tieba.wf9
        public void a(boolean z, int i, String... strArr) {
            cm9 cm9Var;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), strArr}) == null) || (funAdInteractionListener = (cm9Var = this.c).g) == null) {
                return;
            }
            CallBackAware callBackAware = Flavors.CALL_BACK_AWARE;
            String str = cm9Var.d.a;
            Ssp.Pid pid = this.a.c;
            callBackAware.onRewardedVideo(funAdInteractionListener, str, z, pid.ssp.type, i, pid.pid, strArr);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends tl9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context d;
        public FunAdSlot e;
        public Iterator<lg9.b> f;
        public final HashSet<lg9.a> g;
        public boolean h;
        public int i;
        public lg9.b j;
        public final /* synthetic */ cm9 k;

        /* renamed from: com.baidu.tieba.cm9$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0218b implements mg9<FunSplashAd> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ ViewGroup b;
            public final /* synthetic */ b c;

            public C0218b(b bVar, Activity activity, ViewGroup viewGroup) {
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
            /* JADX WARN: Type inference failed for: r1v0, types: [com.fun.ad.sdk.FunSplashAd, java.lang.Object] */
            @Override // com.baidu.tieba.mg9
            public FunSplashAd a(PidLoader pidLoader) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pidLoader)) == null) {
                    b bVar = this.c;
                    return pidLoader.showSplash(this.a, this.b, bVar.k.d.a, bVar.a);
                }
                return invokeL.objValue;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.baidu.tieba.mg9
            public boolean a(FunSplashAd funSplashAd) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funSplashAd)) == null) {
                    return true;
                }
                return invokeL.booleanValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(cm9 cm9Var) {
            super(cm9Var.d.a, cm9Var.d.c, "s");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = cm9Var;
            this.g = new HashSet<>();
            this.i = 0;
        }

        @Override // com.baidu.tieba.tl9.a
        public void a(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, context, funAdSlot, funAdLoadListener) == null) {
                this.k.k.removeMessages(100);
                this.d = context;
                this.e = funAdSlot;
                if (this.k.d.b.isEmpty()) {
                    LogPrinter.e("No groups found in SerialSlotId(%s)", this.k.d.a);
                    b("g_empty");
                    return;
                }
                this.f = this.k.d.b.iterator();
                k();
            }
        }

        @Override // com.baidu.tieba.tl9.a
        public boolean d(Activity activity, ViewGroup viewGroup, FunAdInteractionListener funAdInteractionListener) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, viewGroup, funAdInteractionListener)) == null) {
                cm9 cm9Var = this.k;
                a aVar = new a(this, activity, viewGroup);
                int i = cm9.l;
                cm9Var.j(funAdInteractionListener, aVar);
                return false;
            }
            return invokeLLL.booleanValue;
        }

        @Override // com.baidu.tieba.tl9.a
        public FunSplashAd e(Activity activity, ViewGroup viewGroup, FunAdInteractionListener funAdInteractionListener) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, viewGroup, funAdInteractionListener)) == null) {
                cm9 cm9Var = this.k;
                C0218b c0218b = new C0218b(this, activity, viewGroup);
                int i = cm9.l;
                cm9Var.j(funAdInteractionListener, c0218b);
                return null;
            }
            return (FunSplashAd) invokeLLL.objValue;
        }

        @Override // com.baidu.tieba.tl9.a
        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.c = null;
                synchronized (this.k) {
                    this.k.k.removeMessages(100, this);
                    this.g.clear();
                }
            }
        }

        public void h(lg9.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                synchronized (this.k) {
                    if (j()) {
                        if (this.g.remove(aVar)) {
                            i(aVar, aVar.d, false);
                            f();
                        }
                    }
                }
            }
        }

        public final void i(lg9.a aVar, lg9.b bVar, boolean z) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLZ(1048581, this, aVar, bVar, z) == null) && this.k.h && bVar != null) {
                double d = 0.0d;
                for (lg9.a aVar2 : bVar.b) {
                    PidLoader pidLoader = this.k.e.get(aVar2.c);
                    if (pidLoader != null) {
                        if (z) {
                            i = 3;
                        } else if (aVar2 == aVar) {
                            d = pidLoader.getBiddingOrBasePrices();
                            i = 1;
                        } else {
                            i = 2;
                        }
                        pidLoader.setBiddingResult(d, d, i);
                    }
                }
            }
        }

        public final boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (this.k.b != this) {
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

        public void k() {
            RCInterceptor shouldIntercept;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                synchronized (this.k) {
                    if (this.h) {
                        this.i++;
                        this.h = false;
                    }
                    if (j()) {
                        i(null, this.j, true);
                        if (!this.f.hasNext() && this.g.isEmpty()) {
                            LogPrinter.d("All loader load failed, callback onError(%s)", this.k.d.a);
                            b("af");
                        } else if (!this.f.hasNext()) {
                            LogPrinter.d("All loader already started, just wait for the loader callback", new Object[0]);
                        } else {
                            lg9.b next = this.f.next();
                            this.j = next;
                            this.h = true;
                            if (next.b.isEmpty()) {
                                LogPrinter.e("There is an empty group in SerialSid(%s)", this.k.d.a);
                                k();
                                return;
                            }
                            ArrayList arrayList = new ArrayList();
                            for (lg9.a aVar : next.b) {
                                PidLoader pidLoader = this.k.e.get(aVar.c);
                                if (pidLoader != null && ((shouldIntercept = Flavors.PLUGIN_RC.shouldIntercept(pidLoader.getPid().pid, pidLoader.getAdType())) == null || !shouldIntercept.shouldInterceptLoad())) {
                                    this.g.add(aVar);
                                    if (pidLoader.isLoaded()) {
                                        h(aVar);
                                        return;
                                    }
                                    arrayList.add(pidLoader);
                                }
                            }
                            if (arrayList.isEmpty()) {
                                LogPrinter.e("No group which ready to load found in SerialSid(%s)", this.k.d.a);
                                k();
                                return;
                            }
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ((PidLoader) it.next()).load(this.d, this.e, this.a);
                            }
                            this.k.k.removeMessages(100, this);
                            this.k.k.sendMessageDelayed(this.k.k.obtainMessage(100, this), next.a);
                        }
                    }
                }
            }
        }

        /* loaded from: classes3.dex */
        public class a implements mg9<Boolean> {
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
            @Override // com.baidu.tieba.mg9
            public Boolean a(PidLoader pidLoader) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pidLoader)) == null) {
                    b bVar = this.c;
                    return Boolean.valueOf(pidLoader.show(this.a, this.b, bVar.k.d.a, bVar.a));
                }
                return invokeL.objValue;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.baidu.tieba.mg9
            public boolean a(Boolean bool) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool)) == null) ? bool.booleanValue() : invokeL.booleanValue;
            }
        }
    }
}
