package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.core.prefetch.statistics.item.RecordType;
import com.baidu.swan.apps.core.turbo.PreloadState;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.cp2;
import com.baidu.tieba.kb2;
import com.baidu.tieba.nb2;
import com.baidu.tieba.oc3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebView;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ad2 implements vr2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean A;
    public static volatile ad2 B;
    public static int C;
    public static boolean D;
    public static PreloadState E;
    public static boolean F;
    public static final boolean G;
    public static int H;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanCoreVersion a;
    @Nullable
    public ExtensionCore b;
    public i52 c;
    public List<s> d;
    public final List<u42> e;
    public j82<i82> f;
    public c82 g;
    public boolean h;
    public ns1<?> i;
    public ns1<?> j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public final HashMap<String, ps1> o;
    public LinkedList<gg2> p;
    public final Object q;
    public final Object r;
    public final String s;
    public String t;
    public s u;
    public is1 v;
    public ts1 w;
    public volatile boolean x;
    public boolean y;
    public boolean z;

    @Override // com.baidu.tieba.vr2
    public void a(ps1 ps1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, ps1Var) == null) {
        }
    }

    @Override // com.baidu.tieba.vr2
    public void c(ps1 ps1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, ps1Var) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public static class a extends s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.ad2$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0229a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0229a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ad2.O0(false);
                }
            }
        }

        public a() {
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

        @Override // com.baidu.tieba.ad2.s
        public void c(ad2 ad2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ad2Var) == null) {
                boolean z = !TextUtils.isEmpty(f63.K().getAppId());
                g32.k("SwanAppCoreRuntime", "sReleaseCallback:isSwanAppRunning" + z);
                if (!z) {
                    f63.K().y().Y(15);
                    ak3.e0(new RunnableC0229a(this));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends u42 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c82 a;
        public final /* synthetic */ dr2 b;
        public final /* synthetic */ cp2.g c;
        public final /* synthetic */ ad2 d;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    g gVar = this.a;
                    c82 c82Var = gVar.a;
                    ns1 ns1Var = gVar.d.j;
                    g gVar2 = this.a;
                    r93.i(c82Var, ns1Var, gVar2.b, gVar2.c);
                    ad2 ad2Var = this.a.d;
                    ad2Var.N0(ad2Var.i);
                }
            }
        }

        public g(ad2 ad2Var, c82 c82Var, dr2 dr2Var, cp2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ad2Var, c82Var, dr2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ad2Var;
            this.a = c82Var;
            this.b = dr2Var;
            this.c = gVar;
        }

        @Override // com.baidu.tieba.u42
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            synchronized (this.d.r) {
                this.d.l = true;
            }
            lz2.p("preload").F(new UbcFlowEvent("na_pre_load_naslave_ok"));
            g32.k("SwanAppCoreRuntime", "prepareNaSlave finished");
            ak3.e0(new a(this));
        }
    }

    /* loaded from: classes5.dex */
    public class k extends s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ad2 a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ad2 a;

            public a(k kVar, ad2 ad2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, ad2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = ad2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.a.f1();
            }
        }

        public k(ad2 ad2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ad2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ad2Var;
        }

        @Override // com.baidu.tieba.ad2.s
        public void c(ad2 ad2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ad2Var) == null) {
                if (ad2.A) {
                    el4.b().e();
                    y53 f = y53.f(ad2.p(), R.string.obfuscated_res_0x7f0f01dc);
                    f.l(1);
                    f.G();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                ak3.a0(new a(this, ad2Var));
                if (ad2.A) {
                    Log.i("SwanAppCoreRuntime", "onReady: successfully.");
                }
                b33.Q().Y(14);
                if (qc2.f() || qc2.g()) {
                    this.a.G0();
                }
            }
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "prepare " + super.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class m extends s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr2 a;
        public final /* synthetic */ cp2.g b;
        public final /* synthetic */ ad2 c;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ad2 a;
            public final /* synthetic */ m b;

            public a(m mVar, ad2 ad2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, ad2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = mVar;
                this.a = ad2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.m) {
                    return;
                }
                lz2.p("startup").F(new UbcFlowEvent("na_pre_load_ok"));
                gc3.d().i("na_pre_load_ok");
                lz2.h("preload", "startup");
                m mVar = this.b;
                mVar.c.u0(this.a, mVar.a, mVar.b);
                lz2.j(this.b.a, false);
            }
        }

        public m(ad2 ad2Var, dr2 dr2Var, cp2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ad2Var, dr2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ad2Var;
            this.a = dr2Var;
            this.b = gVar;
        }

        @Override // com.baidu.tieba.ad2.s
        public void c(ad2 ad2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ad2Var) == null) {
                ak3.e0(new a(this, ad2Var));
            }
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "startFirstPage " + super.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class q implements i52 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ ad2 b;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ q a;

            public a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = qVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (ad2.A) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener do prepare. isReleased: " + this.a.b.m);
                    }
                    if (this.a.b.m) {
                        if (ad2.A) {
                            Log.d("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("runtime object is release.")));
                            return;
                        }
                        return;
                    }
                    this.a.b.h1();
                    this.a.b.g1();
                    if (this.a.b.a != null) {
                        q qVar = this.a;
                        qVar.b.F0(qVar.a);
                        this.a.b.M0();
                        return;
                    }
                    PreloadState unused = ad2.E = PreloadState.LOAD_FAILED;
                    this.a.b.i0();
                }
            }
        }

        public q(ad2 ad2Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ad2Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ad2Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.i52
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (ad2.A) {
                    Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                }
                lz2.p("preload").F(new UbcFlowEvent("na_pre_load_blink_init_ok"));
                ak3.e0(new a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class u {
        public static /* synthetic */ Interceptable $ic;
        public static final int a;
        public static final int b;
        public static int c;
        public static int d;
        public static t e;
        public static final Runnable f;
        public static final Runnable g;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes5.dex */
        public static class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || f63.K().q().z0()) {
                    return;
                }
                if (ad2.B.n0()) {
                    g32.k("SwanAppCoreRuntime", "checkAndRetry: runtimeReady is true, return.");
                    return;
                }
                boolean z = true;
                if (u.d >= 1) {
                    g32.k("SwanAppCoreRuntime", "checkAndRetry: over max retry count, return.");
                    return;
                }
                if (!((u.e == null || !u.e.a()) ? false : false)) {
                    if (u.e == null) {
                        t unused = u.e = new t(f63.K().getMainLooper());
                    }
                    u.e.e(r.d());
                }
                g32.k("SwanAppCoreRuntime", "start retry runtime.");
                ad2.Q0();
                zh3 zh3Var = new zh3();
                zh3Var.k(5L);
                zh3Var.i(49L);
                zh3Var.f("start retry");
                u.j(zh3Var);
            }
        }

        /* loaded from: classes5.dex */
        public static class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b() {
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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || f63.K().q().z0()) {
                    return;
                }
                if (ad2.B.n0()) {
                    g32.k("SwanAppCoreRuntime", "Retry: successfully.");
                } else if (u.d >= 1) {
                    g32.k("SwanAppCoreRuntime", "isMasterReady:" + ad2.B.l0() + ",isSlaveReady:" + ad2.B.o0());
                    zh3 zh3Var = new zh3();
                    zh3Var.k(5L);
                    zh3Var.i(49L);
                    zh3Var.f("retry timeout");
                    u.j(zh3Var);
                    if (ur2.a().b()) {
                        ar2.e(ad2.p(), zh3Var, 0, f63.K().getAppId());
                        qc3.m(f63.K().q().X(), 0, zh3Var);
                        np2.p0().flush(false);
                    }
                    pi3.j(f63.K().w());
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-951340535, "Lcom/baidu/tieba/ad2$u;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-951340535, "Lcom/baidu/tieba/ad2$u;");
                    return;
                }
            }
            a = r.b();
            b = r.a();
            c = 0;
            d = 0;
            f = new a();
            g = new b();
        }

        public static /* synthetic */ CopyOnWriteArrayList a() {
            return g();
        }

        public static CopyOnWriteArrayList<s> g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
                return new CopyOnWriteArrayList<>(ad2.B.d);
            }
            return (CopyOnWriteArrayList) invokeV.objValue;
        }

        public static void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65545, null) == null) {
                d++;
                g32.k("SwanAppCoreRuntime", "incrementRetryTimes: retry times " + d);
            }
        }

        public static void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65547, null) == null) {
                d = c;
            }
        }

        public static int h(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bool)) == null) {
                if (bool.booleanValue()) {
                    return a;
                }
                return b;
            }
            return invokeL.intValue;
        }

        public static void j(zh3 zh3Var) {
            g63 q;
            int k;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(65546, null, zh3Var) != null) || (q = f63.K().q()) == null || (k = q.k()) != 0) {
                return;
            }
            hd3 hd3Var = new hd3();
            hd3Var.p(zh3Var);
            hd3Var.r(q.Z());
            hd3Var.q(zc3.n(k));
            hd3Var.m(g63.h0());
            zc3.R(hd3Var);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements l82<i82> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ad2 a;

        public b(ad2 ad2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ad2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ad2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.l82
        /* renamed from: b */
        public void a(boolean z, i82 i82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, i82Var) != null) {
                return;
            }
            this.a.y = z;
            if (z) {
                lz2.p("startup").D("prefetch_env", "1");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements r82 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ad2 a;

        public c(ad2 ad2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ad2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ad2Var;
        }

        @Override // com.baidu.tieba.r82
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                lz2.p("preload").F(new UbcFlowEvent("na_pre_load_master_ok"));
                synchronized (this.a.q) {
                    this.a.h = true;
                    this.a.Q();
                    this.a.w0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends u42 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ad2 a;

        public d(ad2 ad2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ad2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ad2Var;
        }

        @Override // com.baidu.tieba.u42
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                g32.k("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                lz2.p("preload").F(new UbcFlowEvent("na_pre_load_master_ok"));
                synchronized (this.a.q) {
                    this.a.h = true;
                    this.a.Q();
                    this.a.w0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends u42 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ad2 a;

        public e(ad2 ad2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ad2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ad2Var;
        }

        @Override // com.baidu.tieba.u42
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                g32.k("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                lz2.p("preload").F(new UbcFlowEvent("na_pre_load_slave_ok"));
                this.a.k = true;
                this.a.w0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends u42 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ad2 a;

        public f(ad2 ad2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ad2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ad2Var;
        }

        @Override // com.baidu.tieba.u42
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            synchronized (this.a.r) {
                this.a.l = true;
            }
            lz2.p("preload").F(new UbcFlowEvent("na_pre_load_naslave_ok"));
            for (u42 u42Var : this.a.e) {
                u42Var.a(str);
            }
            this.a.e.clear();
            g32.k("SwanAppCoreRuntime", "prepareNaSlave finished");
        }
    }

    /* loaded from: classes5.dex */
    public class h implements zk3<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ad2 a;

        public h(ad2 ad2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ad2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ad2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zk3
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) != null) {
                return;
            }
            this.a.U0(u.h(bool));
        }
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zk3 a;

        public i(ad2 ad2Var, zk3 zk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ad2Var, zk3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zk3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean a = np2.u0().a();
                if (ad2.A) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isLowDevice " + a);
                }
                zk3 zk3Var = this.a;
                if (zk3Var != null) {
                    zk3Var.a(Boolean.FALSE);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j(ad2 ad2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ad2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ti3.k();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l extends s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ad2 a;

        public l(ad2 ad2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ad2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ad2Var;
        }

        @Override // com.baidu.tieba.ad2.s
        public void c(ad2 ad2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ad2Var) == null) {
                if (qc2.f() || qc2.g()) {
                    this.a.G0();
                }
                if (ad2.A) {
                    Log.i("SwanAppCoreRuntime", "onReady: retry successfully.");
                }
            }
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM + super.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public n(ad2 ad2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ad2Var, str};
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                r93.k(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o(ad2 ad2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ad2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                r93.j();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g63 a;
        public final /* synthetic */ ad2 b;

        public p(ad2 ad2Var, g63 g63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ad2Var, g63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ad2Var;
            this.a = g63Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            boolean equals;
            c82 c82Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (qc2.d() && TextUtils.isEmpty(tr2.V().A()) && !qc2.h(this.a)) {
                    if (ad2.A) {
                        Log.d("SwanAppCoreRuntime", "NASlave，尚未设置baseUrl");
                        return;
                    }
                    return;
                }
                String d = r93.d(tr2.V(), this.a.Z(), this.a.R());
                int c = qc2.c(d);
                if (!this.b.O(c)) {
                    vc2.c(11);
                    return;
                }
                ns1 ns1Var = null;
                if (nb2.a.b()) {
                    equals = true;
                } else {
                    SwanAppConfigData R = this.a.R();
                    if (R != null) {
                        str = R.h(d);
                    } else {
                        str = null;
                    }
                    equals = "main".equals(str);
                    int i = 0;
                    if (str == null) {
                        i = 12;
                    } else if (!equals) {
                        i = 13;
                    }
                    if (i != 0) {
                        vc2.c(i);
                    }
                }
                if (c != 0 || this.b.i == null) {
                    if (c == 1 && this.b.j != null) {
                        ns1Var = this.b.j;
                    }
                } else {
                    ns1Var = this.b.i;
                }
                ns1 ns1Var2 = ns1Var;
                if (ns1Var2 == null) {
                    return;
                }
                if (equals && this.a.R() != null) {
                    if (ad2.G) {
                        c82Var = ((i82) this.b.f.e(this.a.X().g0())).i();
                    } else {
                        c82Var = this.b.g;
                    }
                    ob2.c().b(c82Var, ns1Var2, this.a.Z(), this.a.R(), null, true);
                } else if (this.a.R() == null) {
                    vc2.c(15);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class r {
        public static /* synthetic */ Interceptable $ic = null;
        public static int a = -1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-951340628, "Lcom/baidu/tieba/ad2$r;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-951340628, "Lcom/baidu/tieba/ad2$r;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                np2.g0().getSwitch("swan_core_runtime_high_end_timeout", 6000);
                if (ad2.A) {
                    Log.i("SwanAppCoreRuntime", "getHighDeviceTimeout: 6000");
                }
                return 6000;
            }
            return invokeV.intValue;
        }

        public static int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                np2.g0().getSwitch("swan_core_runtime_low_end_timeout", 8000);
                if (ad2.A) {
                    Log.i("SwanAppCoreRuntime", "getLowDeviceTimeout: timeoutMs 8000");
                }
                return 8000;
            }
            return invokeV.intValue;
        }

        public static int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                np2.g0().getSwitch("swan_core_runtime_retry_process_timeout", 8000);
                if (ad2.A) {
                    Log.i("SwanAppCoreRuntime", "getRetryProcessTimeout: 8000");
                }
                return 8000;
            }
            return invokeV.intValue;
        }

        public static boolean e() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
                if (c() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                g32.k("SwanAppCoreRuntime", "isEnable: " + z);
                return z;
            }
            return invokeV.booleanValue;
        }

        public static int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                if (a < 0) {
                    np2.g0().getSwitch("swan_core_runtime_delayed_retry_switch", 0);
                    a = 0;
                }
                return a;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class s implements zk3<ad2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract void c(ad2 ad2Var);

        public s() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zk3
        /* renamed from: b */
        public void a(ad2 ad2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ad2Var) == null) {
                c(ad2Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class t extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
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

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return hasMessages(1002);
            }
            return invokeV.booleanValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return hasMessages(1001);
            }
            return invokeV.booleanValue;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                removeCallbacksAndMessages(null);
                removeCallbacks(u.f);
                removeCallbacks(u.g);
            }
        }

        public void d(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                sendEmptyMessageDelayed(1001, i);
            }
        }

        @Override // android.os.Handler
        public void dispatchMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, message) == null) {
                int i = message.what;
                if (i == 1001) {
                    u.f.run();
                } else if (i == 1002) {
                    u.g.run();
                }
            }
        }

        public void e(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                sendEmptyMessageDelayed(1002, i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class v {
        public static /* synthetic */ Interceptable $ic;
        public static boolean a;
        public static boolean b;
        public transient /* synthetic */ FieldHolder $fh;

        public static String b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? i == 1 ? "V8" : i == 0 ? WebView.LOGTAG : "AB" : (String) invokeI.objValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-951340504, "Lcom/baidu/tieba/ad2$v;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-951340504, "Lcom/baidu/tieba/ad2$v;");
                    return;
                }
            }
            boolean x = np2.g0().x();
            a = x;
            b = x;
        }

        public static String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
            }
            return (String) invokeV.objValue;
        }

        public static void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65542, null) == null) {
                b = a;
            }
        }

        public static boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                if (ad2.A) {
                    String a2 = a();
                    char c = 65535;
                    int hashCode = a2.hashCode();
                    if (hashCode != -1406842887) {
                        if (hashCode != 2081) {
                            if (hashCode == 2722 && a2.equals("V8")) {
                                c = 0;
                            }
                        } else if (a2.equals("AB")) {
                            c = 2;
                        }
                    } else if (a2.equals(WebView.LOGTAG)) {
                        c = 1;
                    }
                    if (c == 0) {
                        return true;
                    }
                    if (c == 1) {
                        return false;
                    }
                }
                return b;
            }
            return invokeV.booleanValue;
        }

        public static boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                String a2 = a();
                if (a2.equals("V8")) {
                    return true;
                }
                if (a2.equals("AB")) {
                    return np2.g0().x();
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
                PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putString("aiapps_v8_master_switch", str).apply();
            }
        }

        public static void g(Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65543, null, intent) == null) && intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                a = intent.getBooleanExtra("bundle_key_v8_ab", a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947611258, "Lcom/baidu/tieba/ad2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947611258, "Lcom/baidu/tieba/ad2;");
                return;
            }
        }
        A = rm1.a;
        C = 10150;
        D = false;
        E = PreloadState.UNKNOWN;
        F = false;
        G = ga2.h();
        H = -1;
    }

    public static void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, null) == null) {
            if (G) {
                if (B.f != null) {
                    B.f.reset();
                }
            } else if (B.g != null) {
                if (B.g instanceof g82) {
                    B.g.destroy();
                }
                B.g = null;
            }
        }
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && qc2.d() && !m0() && this.j == null) {
            lz2.p("preload").F(new UbcFlowEvent("na_pre_load_naslave_start"));
            this.j = L0(S(), 1, new f(this));
            j0();
        }
    }

    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (!TextUtils.isEmpty(d0())) {
                return d0() + "runtime/index.js";
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            SwanCoreVersion swanCoreVersion = this.a;
            if (swanCoreVersion == null || !swanCoreVersion.isAvailable()) {
                g32.k("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid:" + this.a)));
                Z0(lf3.g(0));
            }
        }
    }

    public ad2() {
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
        this.d = new CopyOnWriteArrayList();
        this.e = new CopyOnWriteArrayList();
        this.p = new LinkedList<>();
        this.q = new Object();
        this.r = new Object();
        this.s = UUID.randomUUID().toString();
        this.x = false;
        this.z = false;
        wr2.e(this);
        this.o = new HashMap<>();
        this.v = np2.F0();
        this.w = xs1.a().b().a();
        if (G) {
            this.f = new u82();
        }
    }

    public String Y() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            h1();
            if (s0()) {
                str = Z();
            } else {
                str = this.a.swanCorePath + File.separator + "master/master.html";
            }
            if (t42.d()) {
                L(str, false);
            } else if (x32.d()) {
                w32.k();
                w32.g().h("loadmaster");
                return x32.a();
            } else {
                t42.g(str);
            }
            return yj3.w(str);
        }
        return (String) invokeV.objValue;
    }

    public final void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            if (this.x) {
                if (A) {
                    Log.i("SwanAppCoreRuntime", "Cancel preload additional slave, already tried");
                    return;
                }
                return;
            }
            boolean z = true;
            this.x = true;
            f63 K = f63.K();
            z = (K == null || !K.E()) ? false : false;
            boolean v2 = np2.g0().v();
            if (!z && v2) {
                if (A) {
                    Log.i("SwanAppCoreRuntime", "Start preload additional slave manager");
                }
                lc2.n(S());
            } else if (A) {
                Log.i("SwanAppCoreRuntime", "Can't preload additional slave manager, isOccupied: " + z + ", ab: " + v2);
            }
        }
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048642, this) != null) || this.d.isEmpty()) {
            return;
        }
        M();
        E = PreloadState.LOADED;
        u.k();
        R("event_preload_finish");
        lz2.p("preload").F(new UbcFlowEvent("na_pre_load_end"));
        v82.i().q();
        for (s sVar : this.d) {
            if (sVar != null) {
                if (A) {
                    Log.i("SwanAppCoreRuntime", "onReady result: " + sVar.toString());
                }
                sVar.a(this);
            }
        }
        this.d.clear();
    }

    public static int C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return D0().statsCode(F);
        }
        return invokeV.intValue;
    }

    public static PreloadState D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return E;
        }
        return (PreloadState) invokeV.objValue;
    }

    public static synchronized void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            synchronized (ad2.class) {
                g32.k("SwanAppCoreRuntime", "releaseAndRetry");
                P0(false, true);
            }
        }
    }

    public static Context S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            return AppRuntime.getAppContext();
        }
        return (Context) invokeV.objValue;
    }

    public static ad2 V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            if (B == null) {
                synchronized (ad2.class) {
                    if (B == null) {
                        B = new ad2();
                    }
                }
            }
            return B;
        }
        return (ad2) invokeV.objValue;
    }

    public static /* synthetic */ Context p() {
        return S();
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            I0(new k(this));
        }
    }

    public final void M() {
        j82<i82> j82Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (j82Var = this.f) != null && E != PreloadState.LOADED) {
            j82Var.c(new b(this));
        }
    }

    @Nullable
    public ExtensionCore U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.b;
        }
        return (ExtensionCore) invokeV.objValue;
    }

    @NonNull
    public HashMap<String, ps1> W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.o;
        }
        return (HashMap) invokeV.objValue;
    }

    public c82 X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (G) {
                if (!this.f.g()) {
                    return null;
                }
                return ((i82) this.f.a()).i();
            }
            return this.g;
        }
        return (c82) invokeV.objValue;
    }

    public String b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.s;
        }
        return (String) invokeV.objValue;
    }

    public void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            ak3.e0(new o(this));
        }
    }

    public String d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (this.a == null) {
                return "";
            }
            return this.a.swanCorePath + File.separator;
        }
        return (String) invokeV.objValue;
    }

    public SwanCoreVersion e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.a;
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    public is1 g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.v;
        }
        return (is1) invokeV.objValue;
    }

    public final void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            ExtensionCore extensionCore = this.b;
            if (extensionCore == null || !extensionCore.isAvailable()) {
                g32.k("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
                Y0(pg2.c(0));
            }
        }
    }

    @Nullable
    public String h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            j0();
            return this.t;
        }
        return (String) invokeV.objValue;
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.y;
        }
        return invokeV.booleanValue;
    }

    public boolean l0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            synchronized (this.q) {
                z = this.h;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean m0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            synchronized (this.r) {
                z = this.l;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean n0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            synchronized (this.q) {
                if (this.h && this.k) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            synchronized (this.q) {
                z = this.k;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.n;
        }
        return invokeV.booleanValue;
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.z;
        }
        return invokeV.booleanValue;
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            if (G) {
                return this.f.i();
            }
            return this.g instanceof g82;
        }
        return invokeV.booleanValue;
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048643, this) != null) || this.d.isEmpty() || !n0()) {
            return;
        }
        v0();
    }

    public static synchronized void O0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, null, z) == null) {
            synchronized (ad2.class) {
                g32.k("SwanAppCoreRuntime", "release");
                P0(z, false);
            }
        }
    }

    public void A0(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, intent) == null) {
            B0(intent, null);
        }
    }

    public void K(@NonNull u42 u42Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, u42Var) == null) {
            this.e.add(u42Var);
        }
    }

    public final void N0(ns1<?> ns1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, ns1Var) == null) {
            if (ns1Var != null) {
                lc2.p(ns1Var);
            }
            this.i = null;
            this.j = null;
        }
    }

    public final boolean O(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            if (i2 == 0 && n0() && this.i != null) {
                return true;
            }
            if (i2 == 1 && m0() && this.j != null) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void R(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("KEY_PRELOAD_STATE", E.statsCode(F));
            f63.K().v(str, bundle);
        }
    }

    public final void T(zk3<Boolean> zk3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, zk3Var) == null) {
            aj3.k(new i(this, zk3Var), "SWAN_DEVICE_PERFORMANCE_CHECK");
        }
    }

    public void X0(@NonNull g63 g63Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, g63Var) == null) {
            ak3.e0(new p(this, g63Var));
        }
    }

    public void c1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            ak3.e0(new n(this, str));
        }
    }

    @Override // com.baidu.tieba.vr2
    public void d(ps1 ps1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, ps1Var) == null) {
            this.o.put(ps1Var.a(), ps1Var);
        }
    }

    public void d1(dr2 dr2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, dr2Var) == null) {
            ExtensionCore extensionCore = this.b;
            if (extensionCore != null) {
                dr2Var.D0(extensionCore);
            } else {
                this.b = dr2Var.P();
            }
        }
    }

    public void e1(dr2 dr2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, dr2Var) == null) {
            SwanCoreVersion swanCoreVersion = this.a;
            if (swanCoreVersion != null) {
                dr2Var.a1(swanCoreVersion);
            } else {
                this.a = dr2Var.k0();
            }
        }
    }

    public ps1 f0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, str)) == null) {
            if (!this.o.isEmpty() && !TextUtils.isEmpty(str)) {
                return this.o.get(str);
            }
            return null;
        }
        return (ps1) invokeL.objValue;
    }

    public void i1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.n = z;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: com.baidu.tieba.ad2 */
    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized void P0(boolean z, boolean z2) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            synchronized (ad2.class) {
                if (A) {
                    Log.d("SwanAppCoreRuntime", "release");
                }
                if (B == null) {
                    return;
                }
                E = PreloadState.UNKNOWN;
                B.m = true;
                B.u = null;
                D = false;
                if (z2) {
                    u.i();
                    copyOnWriteArrayList = u.a();
                } else {
                    copyOnWriteArrayList = null;
                }
                if (B.c != null) {
                    B.w.a(B.c);
                }
                rx1.f();
                mf3.c();
                T0();
                wr2.f(B);
                B = null;
                ob2.c().d();
                F = z;
                V().B0(null, copyOnWriteArrayList);
            }
        }
    }

    public void a1(dr2 dr2Var, cp2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, dr2Var, gVar) == null) {
            if (A) {
                Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.a);
                Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + dr2Var.k0());
            }
            e1(dr2Var);
            d1(dr2Var);
            lz2.o().F(new UbcFlowEvent("na_pre_load_check"));
            gc3.d().i("na_pre_load_check");
            I0(new m(this, dr2Var, gVar));
        }
    }

    public final void z0(String str, PrefetchEvent prefetchEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048646, this, str, prefetchEvent) != null) || !ga2.o()) {
            return;
        }
        ns1<?> ns1Var = this.i;
        if (ns1Var != null && o0()) {
            g32.i(PrefetchEvent.MODULE, "start prefetch slave");
            long j2 = 0;
            if (A) {
                j2 = System.currentTimeMillis();
                Log.d("SwanAppCoreRuntime", "prefetch slave start");
            }
            g63 q2 = f63.K().q();
            if (q2 == null) {
                return;
            }
            fb2 a2 = fb2.a(ns1Var, prefetchEvent, q2);
            if (ak3.S(ns1Var, a2.k)) {
                W0(ns1Var.a(), a2.b());
            }
            if (A) {
                Log.d("SwanAppCoreRuntime", "prefetch slave end");
                long currentTimeMillis = System.currentTimeMillis();
                Log.d("SwanAppCoreRuntime", "prefetch slave cost - " + (currentTimeMillis - j2) + "ms");
            }
            g32.i(PrefetchEvent.MODULE, "prefetch slave finish");
        } else if (A) {
            Log.d("SwanAppCoreRuntime", "slave is not ready can not prefetch");
        }
    }

    public static synchronized void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            synchronized (ad2.class) {
                g32.k("SwanAppCoreRuntime", "releaseForCoreUpdate");
                if (A) {
                    Log.d("SwanAppCoreRuntime", "releaseForCoreUpdate:ReleaseRuntimeWaitMaster:true.");
                }
                if (B != null && !B.l0()) {
                    if (B.u == null) {
                        B.u = new a();
                    }
                    B.I0(B.u);
                    return;
                }
                f63.K().y().Y(15);
                O0(false);
            }
        }
    }

    public static void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, null) == null) {
            if (B.o != null) {
                for (ps1 ps1Var : ((HashMap) B.o.clone()).values()) {
                    if (ps1Var != null) {
                        ps1Var.destroy();
                    }
                }
            }
            S0();
            if (B.i != null) {
                B.i = null;
            }
            if (B.j != null) {
                B.j = null;
            }
        }
    }

    public final void M0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && !this.k && this.i == null) {
            if (A) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            lz2.p("preload").F(new UbcFlowEvent("na_pre_load_slave_start"));
            this.i = L0(S(), 0, new e(this));
            j0();
        }
    }

    public final boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (x32.d() || np2.o().N() || vf2.d.w() || !t0()) {
                return false;
            }
            boolean c2 = v.c();
            boolean exists = new File(Z()).exists();
            if (!c2 || !exists) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || this.p.isEmpty()) {
            return;
        }
        Iterator<gg2> it = this.p.iterator();
        while (it.hasNext()) {
            gg2 next = it.next();
            if (A) {
                Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.a);
            }
            V0(next);
        }
        this.p.clear();
    }

    @Nullable
    public String a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            h1();
            if (this.a == null) {
                return null;
            }
            String str = this.a.swanCorePath + File.separator + "slave-talos/index.js";
            if (t42.d()) {
                L(str, true);
            } else if (x32.d()) {
                return x32.b();
            } else {
                t42.g(str);
            }
            return yj3.w(str);
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public String c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            h1();
            if (this.a == null) {
                return null;
            }
            String str = this.a.swanCorePath + File.separator + "slaves/slaves.html";
            if (t42.d()) {
                L(str, true);
            } else if (x32.d()) {
                return x32.b();
            } else {
                t42.g(str);
            }
            return yj3.w(str);
        }
        return (String) invokeV.objValue;
    }

    public final void j0() {
        ns1<?> ns1Var;
        ns1<?> ns1Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            if (TextUtils.isEmpty(this.t) && (ns1Var2 = this.i) != null) {
                this.t = ns1Var2.getUserAgent();
            }
            if (TextUtils.isEmpty(this.t) && (ns1Var = this.j) != null) {
                this.t = ns1Var.getUserAgent();
            }
            if (!TextUtils.isEmpty(this.t)) {
                g32.k("SwanAppCoreRuntime", "initWebViewUa ua: " + this.t);
            }
        }
    }

    public final boolean p0() {
        InterceptResult invokeV;
        long j2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            if (A) {
                j2 = System.currentTimeMillis();
            } else {
                j2 = 0;
            }
            SwanCoreVersion swanCoreVersion = this.a;
            if (swanCoreVersion != null && swanCoreVersion.isAvailable()) {
                z = true;
            } else {
                z = false;
            }
            ExtensionCore extensionCore = this.b;
            if (extensionCore != null && extensionCore.extensionCoreVersionCode != 0) {
                z &= extensionCore.isAvailable();
            }
            if (A) {
                long currentTimeMillis = System.currentTimeMillis();
                Log.d("SwanAppCoreRuntime", "isSwanAvailable cost - " + (currentTimeMillis - j2) + "ms");
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            if (!np2.w0().d() && zb3.a() != null) {
                boolean exists = new File(zb3.a()).exists();
                if (A) {
                    Log.d("V8LoadChecker", "is v8 load success: " + exists);
                }
                return exists;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void B0(Intent intent, CopyOnWriteArrayList<s> copyOnWriteArrayList) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent, copyOnWriteArrayList) == null) {
            if (f63.K().q().z0()) {
                g32.i("SwanAppCoreRuntime", "swan/web, preloadCoreRuntime: " + f63.K().q().P());
                return;
            }
            uz2.c().f();
            zz2.e().f();
            if (n0()) {
                g32.k("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
                return;
            }
            boolean z = true;
            D = true;
            g32.k("SwanAppCoreRuntime", "preloadCoreRuntime start.");
            R("event_preload_start");
            if (intent == null) {
                swanCoreVersion = lf3.g(0);
                extensionCore = pg2.c(0);
            } else {
                intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
                np2.g().g(intent.getIntExtra("bundle_key_preload_switch", C));
                H = intent.getIntExtra("bundle_key_main_pid", H);
                swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
                extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            }
            if (swanCoreVersion == null) {
                R("event_preload_error");
                g32.l("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
                return;
            }
            Z0(swanCoreVersion);
            if (extensionCore == null) {
                g32.k("SwanAppCoreRuntime", "preloadCoreRuntime with null extensionCore");
            }
            Y0(extensionCore);
            v.f();
            aj3.k(new j(this), "prepare ab description");
            if (N()) {
                bc3 c2 = zb3.c();
                if (!c2.b() && !c2.a()) {
                    R("event_preload_error");
                    return;
                }
            }
            if (!((copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) ? false : false)) {
                J0();
            } else {
                K0(copyOnWriteArrayList);
            }
            g32.k("SwanAppCoreRuntime", "preloadCoreRuntime end.");
        }
    }

    public c82 E0(boolean z, u42 u42Var) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, u42Var)) == null) {
            c82 h2 = this.v.h(S(), z ? 1 : 0);
            lz2.p("preload").F(new UbcFlowEvent("na_pre_load_master_created"));
            h2.loadUrl(Y());
            h2.b(u42Var);
            return h2;
        }
        return (c82) invokeZL.objValue;
    }

    public final String L(String str, boolean z) {
        InterceptResult invokeLZ;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, str, z)) == null) {
            if (z) {
                str2 = "slave";
            } else {
                str2 = "master";
            }
            if (!TextUtils.isEmpty(str)) {
                t42.b(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
            }
            return str;
        }
        return (String) invokeLZ.objValue;
    }

    public final void F0(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            synchronized (this.q) {
                if (G) {
                    z2 = this.f.f();
                } else if (this.g != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!this.h && !z2) {
                    g32.k("SwanAppCoreRuntime", "prepareMaster start.");
                    lz2.p("preload").F(new UbcFlowEvent("na_pre_load_master_start"));
                    if (G) {
                        this.f.j(z, new c(this));
                        return;
                    }
                    this.g = this.v.h(S(), z ? 1 : 0);
                    lz2.p("preload").F(new UbcFlowEvent("na_pre_load_master_created"));
                    this.g.loadUrl(Y());
                    this.g.b(new d(this));
                }
            }
        }
    }

    public void Y0(ExtensionCore extensionCore) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, extensionCore) == null) {
            if (extensionCore != null && extensionCore.isAvailable()) {
                if (A) {
                    Log.d("SwanAppCoreRuntime", "setExtensionCore before. extension core: " + this.b);
                }
                this.b = extensionCore;
                if (A) {
                    Log.d("SwanAppCoreRuntime", "setExtensionCore after. extension core: " + this.b);
                }
            } else if (A) {
                StringBuilder sb = new StringBuilder();
                sb.append("setExtensionCore extensionCore is invalid: ");
                Object obj = extensionCore;
                if (extensionCore == null) {
                    obj = " null";
                }
                sb.append(obj);
                Log.w("SwanAppCoreRuntime", sb.toString());
            }
        }
    }

    public void Z0(SwanCoreVersion swanCoreVersion) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, swanCoreVersion) == null) {
            if (swanCoreVersion != null && swanCoreVersion.isAvailable()) {
                if (A) {
                    Log.d("SwanAppCoreRuntime", "setSwanCoreVersion before. swan core: " + this.a);
                }
                this.a = swanCoreVersion;
                if (A) {
                    Log.d("SwanAppCoreRuntime", "setSwanCoreVersion after. swan core: " + this.a);
                }
            } else if (A) {
                Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("setSwanCoreVersion failed.")));
                Log.e("SwanAppCoreRuntime", "setSwanCoreVersion swanCoreVersion is invalid: " + swanCoreVersion);
            }
        }
    }

    public void x0(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z) == null) {
            if (G) {
                z2 = this.f.f();
            } else if (this.g != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z && !this.h && z2) {
                if (A) {
                    Log.d("SwanAppCoreRuntime", "onJSLoaded -- master");
                }
                lz2.p("preload").F(new UbcFlowEvent("na_pre_load_master_js_ok"));
                synchronized (this.q) {
                    this.h = true;
                    Q();
                    w0();
                }
            } else if (!z && this.i != null && !this.k) {
                if (A) {
                    Log.d("SwanAppCoreRuntime", "onJSLoaded -- slave");
                }
                lz2.p("preload").F(new UbcFlowEvent("na_pre_load_slave_js_ok"));
                this.k = true;
                w0();
            }
        }
    }

    public void H0(c82 c82Var, dr2 dr2Var, cp2.g gVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, c82Var, dr2Var, gVar) == null) {
            boolean m0 = m0();
            HybridUbcFlow o2 = lz2.o();
            if (m0) {
                str = "1";
            } else {
                str = "0";
            }
            o2.D("preload", str);
            g32.k("SwanAppCoreRuntime", "prepareNaSlave preload = " + m0);
            if (m0) {
                r93.i(c82Var, this.j, dr2Var, gVar);
                N0(this.i);
                return;
            }
            g gVar2 = new g(this, c82Var, dr2Var, gVar);
            if (this.j != null) {
                K(gVar2);
                return;
            }
            lz2.p("preload").F(new UbcFlowEvent("na_pre_load_naslave_start"));
            this.j = L0(S(), 1, gVar2);
            j0();
        }
    }

    public void I0(s sVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sVar) == null) {
            if (f63.K().q().z0()) {
                g32.i("SwanAppCoreRuntime", "swan/web, prepareRuntime: " + f63.K().q().P());
                return;
            }
            uz2.c().f();
            zz2.e().f();
            if (sVar != null && !this.d.contains(sVar)) {
                this.d.add(sVar);
            }
            boolean n0 = n0();
            HybridUbcFlow o2 = lz2.o();
            if (n0) {
                str = "1";
            } else {
                str = "0";
            }
            o2.D("preload", str);
            g32.k("SwanAppCoreRuntime", "prepareRuntime preload = " + n0);
            if (n0) {
                v0();
                return;
            }
            E = PreloadState.LOADING;
            lz2.p("preload").F(new UbcFlowEvent("na_pre_load_start"));
            h1();
            boolean N = N();
            this.z = N;
            if (N) {
                bc3 c2 = zb3.c();
                if (!c2.b() && c2.a()) {
                    this.z = false;
                }
            }
            boolean z = this.z;
            g32.k("SwanAppCoreRuntime", "mIsUseV8Master:" + this.z);
            if (this.z) {
                F0(true);
            }
            if (this.c == null) {
                this.c = new q(this, z);
                if (A) {
                    Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
                }
                this.w.b(this.c);
            }
        }
    }

    public final void K0(CopyOnWriteArrayList<s> copyOnWriteArrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, copyOnWriteArrayList) == null) {
            if (this.d == null) {
                this.d = new CopyOnWriteArrayList();
            }
            Iterator<s> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (!this.d.contains(next)) {
                    this.d.add(next);
                }
            }
            I0(new l(this));
        }
    }

    public final void U0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            g32.k("SwanAppCoreRuntime", "resetAndPostRunnable");
            if (u.e == null) {
                t unused = u.e = new t(f63.K().getMainLooper());
            }
            u.e.c();
            u.e.d(i2);
        }
    }

    @Override // com.baidu.tieba.vr2
    public void b(ps1 ps1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, ps1Var) == null) {
            String a2 = ps1Var.a();
            this.o.remove(a2);
            if (ps1Var instanceof ns1) {
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onUnload");
                hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, a2);
                V0(new ig2(hashMap));
                g32.i("SwanApp", "onUnload");
            }
            o53.a();
        }
    }

    public ns1 L0(Context context, int i2, u42 u42Var) {
        InterceptResult invokeLIL;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048587, this, context, i2, u42Var)) == null) {
            if (A) {
                j2 = System.currentTimeMillis();
            } else {
                j2 = 0;
            }
            try {
                ns1 e2 = this.v.e(context, i2);
                if (i2 == 1) {
                    lz2.p("preload").F(new UbcFlowEvent("na_pre_load_naslave_created"));
                } else {
                    lz2.p("preload").F(new UbcFlowEvent("na_pre_load_slave_created"));
                }
                e2.b(u42Var);
                String c0 = c0();
                if (i2 == 1) {
                    c0 = a0();
                }
                if (c0 != null) {
                    g63 c02 = g63.c0();
                    if (c02 != null && !TextUtils.isEmpty(c02.P())) {
                        String builder = Uri.parse(c0).buildUpon().appendQueryParameter(PrefetchEvent.EVENT_KEY_APP_PATH, cp2.v(c02.P(), c02.l0(), false, null, null).getAbsolutePath()).toString();
                        if (!builder.endsWith(File.separator)) {
                            builder = builder + File.separator;
                        }
                        c0 = builder;
                    }
                    e2.loadUrl(c0);
                }
                g32.k("SwanAppCoreRuntime", "prepareSlave loadUrl " + c0);
                if (A) {
                    long currentTimeMillis = System.currentTimeMillis();
                    Log.d("SwanAppCoreRuntime", "prepareSlave cost - " + (currentTimeMillis - j2) + "ms");
                }
                return e2;
            } catch (NullPointerException e3) {
                t42.e(context);
                throw e3;
            }
        }
        return (ns1) invokeLIL.objValue;
    }

    public void P(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048593, this, z) != null) || !r.e()) {
            return;
        }
        if (!f63.K().q().x0() && !f63.K().q().z0()) {
            if (u.e != null && u.e.b()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z && z2) {
                if (A) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isReuse " + z + ", return.");
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isRunning " + z2 + ", return.");
                }
            } else if (n0()) {
                if (A) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: runtime ready, return.");
                }
            } else {
                T(new h(this));
            }
        } else if (A) {
            Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: is game frame or web, return.");
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public void V0(gg2 gg2Var) {
        e52 e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, gg2Var) == null) {
            if (gg2Var == null) {
                if (!A) {
                    return;
                }
                throw new IllegalArgumentException("message must be non-null.");
            }
            synchronized (this.q) {
                if (!this.h) {
                    if (A) {
                        Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + gg2Var.a)));
                    }
                    this.p.add(gg2Var);
                    return;
                }
                if (G) {
                    if (!this.f.g()) {
                        this.f.d(gg2Var);
                        return;
                    } else if (this.f.a() == 0) {
                        return;
                    } else {
                        e2 = ((i82) this.f.a()).i().e();
                    }
                } else {
                    c82 c82Var = this.g;
                    if (c82Var == null) {
                        return;
                    }
                    e2 = c82Var.e();
                }
                if (A) {
                    Log.d("SwanAppCoreRuntime", "master dispatch msg:" + gg2Var.a);
                }
                cg2.a(e2, gg2Var);
            }
        }
    }

    public void W0(String str, gg2 gg2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, str, gg2Var) == null) {
            if (m82.a(str)) {
                V0(gg2Var);
            } else if (w72.a(str)) {
                cg2.a(r32.k().l(), gg2Var);
            } else {
                ps1 ps1Var = this.o.get(str);
                if (ps1Var == null) {
                    if (A) {
                        Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + gg2Var);
                        return;
                    }
                    return;
                }
                cg2.a(ps1Var.getWebView(), gg2Var);
            }
        }
    }

    public final void i0() {
        boolean z;
        String P;
        boolean z2;
        Object valueOf;
        Object valueOf2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            synchronized (this.q) {
                z = false;
                this.h = false;
                if (G) {
                    this.f.reset();
                } else {
                    this.g = null;
                }
            }
            this.k = false;
            this.l = false;
            this.i = null;
            this.j = null;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("swanjs version", qf3.e(0));
                jSONObject.put("system model", Build.MODEL);
                jSONObject.put("is V8", s0());
                jSONObject.put("in main", ProcessUtils.isMainProcess());
                SwanCoreVersion g2 = lf3.g(0);
                if (g2 == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    valueOf = StringUtil.NULL_STRING;
                } else {
                    valueOf = Long.valueOf(g2.swanCoreVersionCode);
                }
                jSONObject.put("swan app core", valueOf);
                SwanCoreVersion g3 = lf3.g(1);
                if (g3 == null) {
                    z = true;
                }
                if (z) {
                    valueOf2 = StringUtil.NULL_STRING;
                } else {
                    valueOf2 = Long.valueOf(g3.swanCoreVersionCode);
                }
                jSONObject.put("swan game core", valueOf2);
            } catch (JSONException e2) {
                if (A) {
                    e2.printStackTrace();
                }
            }
            oc3.b bVar = new oc3.b(10001);
            if (g63.M() == null) {
                P = "null appKey";
            } else {
                P = g63.M().P();
            }
            bVar.h(P);
            bVar.i(jSONObject.toString());
            bVar.m();
        }
    }

    public final void u0(ad2 ad2Var, dr2 dr2Var, cp2.g gVar) {
        c82 c82Var;
        ns1<?> ns1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048641, this, ad2Var, dr2Var, gVar) == null) {
            if (G) {
                j82<i82> j82Var = ad2Var.f;
                if (j82Var.h()) {
                    c82Var = ((i82) j82Var.e(dr2Var.g0())).i();
                } else {
                    c82Var = null;
                }
            } else {
                c82Var = ad2Var.g;
            }
            if (c82Var != null) {
                String d2 = r93.d(tr2.V(), dr2Var, gVar.b);
                int c2 = qc2.c(d2);
                if (A) {
                    Log.d("SwanAppCoreRuntime", "launchFirstPage: " + d2 + " salveType:" + c2);
                }
                if ((c2 == 0 || !qc2.d()) && (ns1Var = ad2Var.i) != null) {
                    r93.i(c82Var, ns1Var, dr2Var, gVar);
                    N0(ad2Var.j);
                } else if (c2 == 1) {
                    H0(c82Var, dr2Var, gVar);
                }
            }
            if (A) {
                Log.d("SwanAppCoreRuntime", "startFirstPage mMasterManager=" + ad2Var.g + " mSlaveManager=" + ad2Var.i + " mNASlaveManager=" + ad2Var.j);
            }
        }
    }

    public void y0(String str, PrefetchEvent prefetchEvent, PMSAppInfo pMSAppInfo) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048645, this, str, prefetchEvent, pMSAppInfo) == null) && G) {
            if (pMSAppInfo != null && TextUtils.equals(prefetchEvent.appId, pMSAppInfo.appId)) {
                if (n0() && p0()) {
                    ns1<?> ns1Var = this.i;
                    if (ns1Var != null) {
                        prefetchEvent.isT7Available = ns1Var.I();
                    } else {
                        prefetchEvent.isT7Available = q0();
                    }
                    PrefetchEvent.c createMessage = PrefetchEvent.createMessage(prefetchEvent, pMSAppInfo);
                    jb2 d2 = jb2.d();
                    kb2.b a2 = kb2.a();
                    a2.h(RecordType.PREFETCH_EVENT);
                    a2.f(createMessage.a);
                    d2.f(str, a2.e());
                    String str3 = prefetchEvent.pageUrl;
                    Map<String, String> t2 = createMessage.t();
                    if (t2 != null) {
                        str2 = t2.get("pageRoutePath");
                    } else {
                        str2 = null;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        str3 = str2;
                    }
                    if (!cp2.C(prefetchEvent.appPath, str3)) {
                        if (A) {
                            Log.w("SwanAppCoreRuntime", "page path - " + str3 + " not exit");
                        }
                        g32.k("SwanAppCoreRuntime", "page path not exist - " + str3);
                        return;
                    }
                    if (createMessage.u()) {
                        f32.d();
                        g32.i(PrefetchEvent.MODULE, "start prefetch");
                    }
                    this.f.b(str, createMessage, pMSAppInfo);
                    z0(str, prefetchEvent);
                    if (A) {
                        String str4 = this.a.swanCoreVersionName;
                        Log.i("SwanAppCoreRuntime", "swan-core version - " + str4);
                        Log.i("SwanAppCoreRuntime", "swan-core support preload ,fire a preload event");
                    }
                    if (!qc2.e() && !qc2.g()) {
                        return;
                    }
                    if (TextUtils.isEmpty(tr2.V().A()) && !qc2.h(g63.c0())) {
                        if (A) {
                            Log.d("SwanAppCoreRuntime", "NASlave，尚未设置baseUrl");
                            return;
                        }
                        return;
                    } else if (qc2.c(str3) == 1) {
                        G0();
                        return;
                    } else {
                        return;
                    }
                }
                g32.k("SwanAppCoreRuntime", "Runtime is not ready or swanJs is not available");
            } else if (A) {
                Log.w("SwanAppCoreRuntime", "prefetch appId not equals current app info's appId");
            }
        }
    }
}
