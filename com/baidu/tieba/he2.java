package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.de2;
import com.baidu.tieba.lb3;
import com.baidu.tieba.rk3;
import com.baidu.tieba.sac;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class he2 extends le2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public bj4 A;
    public yac<fk4> B;
    public String c;
    public yac<? super gk4> d;
    public yac<? super hk4> e;
    public yac<? super ek4> f;
    public yac<? super ck4> g;
    public yac<? super ik4> h;
    public po4 i;
    public gk4 j;
    public List<hk4> k;
    public ek4 l;
    public ck4 m;
    public PMSAppInfo n;
    public String o;
    public List<UbcFlowEvent> p;
    public hk4 q;
    public long r;
    public final Set<qe2> s;
    public final Set<aq3<PMSAppInfo>> t;
    public final kp3 u;
    public yi4<gk4> v;
    public yi4<hk4> w;
    public final yi4<ik4> x;
    public yi4<ek4> y;
    public yi4<ck4> z;

    public int j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return 100;
        }
        return invokeV.intValue;
    }

    public abstract PMSDownloadType k0();

    public abstract void w0(Throwable th);

    /* loaded from: classes6.dex */
    public class a extends vi4<gk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ he2 a;

        /* renamed from: com.baidu.tieba.he2$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0315a implements aq3<lb3.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0315a(a aVar) {
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
                        return;
                    }
                }
                this.a = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.aq3
            /* renamed from: b */
            public void a(lb3.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.b)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    dj4.a(this.a.a, bundle, "event_performance_ubc");
                }
            }
        }

        public a(he2 he2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {he2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = he2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yi4
        /* renamed from: l */
        public String d(gk4 gk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gk4Var)) == null) {
                int i = gk4Var.h;
                if (i == 0) {
                    return ze2.g();
                }
                if (i == 1) {
                    return ze2.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: q */
        public void c(gk4 gk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048587, this, gk4Var) != null) {
                return;
            }
            String l0 = this.a.l0();
            if (he2.C) {
                mw2.d(l0).e().d(1);
            }
            super.c(gk4Var);
            h82.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        @Override // com.baidu.tieba.aj4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.vi4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: o */
        public void e(gk4 gk4Var, bk4 bk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, gk4Var, bk4Var) == null) {
                super.e(gk4Var, bk4Var);
                h82.k("SwanAppPkgDownloadCallback", "onDownloadError：" + bk4Var.toString());
                this.a.i.l(gk4Var);
                an3 an3Var = new an3();
                an3Var.k(11L);
                an3Var.i(bk4Var.a);
                an3Var.d("主包下载失败");
                an3Var.f(bk4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(gk4Var, an3Var));
                }
                de2.c().a(gk4Var, this.a.k0(), an3Var);
                lr4.k(gk4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: p */
        public void i(gk4 gk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, gk4Var) == null) {
                String l0 = this.a.l0();
                if (he2.C) {
                    mw2.d(l0).e().d(1);
                }
                super.i(gk4Var);
                this.a.p.add(new UbcFlowEvent("na_pms_end_download"));
                an3 z0 = this.a.z0(gk4Var);
                h82.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + gk4Var.i);
                if (z0 == null) {
                    he2 he2Var = this.a;
                    he2Var.j = gk4Var;
                    he2Var.i.m(gk4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(gk4Var);
                        if (he2.C) {
                            Log.d("SwanAppPkgDownloadCallback", this.a.i0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.a.d.onCompleted();
                    }
                    de2.c().b(gk4Var, this.a.k0());
                    return;
                }
                this.a.i.l(gk4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(gk4Var, z0));
                }
                de2.c().a(gk4Var, this.a.k0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: r */
        public void f(gk4 gk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, gk4Var) == null) {
                String l0 = this.a.l0();
                if (he2.C) {
                    mw2.d(l0).e().d(1);
                }
                super.f(gk4Var);
                if (he2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": main onDownloading");
                }
                this.a.D0(gk4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: s */
        public bk4 h(gk4 gk4Var, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{gk4Var, file, Long.valueOf(j), readableByteChannel})) == null) {
                String l0 = this.a.l0();
                if (he2.C) {
                    mw2.d(l0).f(gk4Var.toString()).d(1);
                }
                C0315a c0315a = new C0315a(this);
                Bundle bundle = new Bundle();
                bundle.putLong("length", j);
                bundle.putFloat("progress_granularity", 0.1f);
                fu2 fu2Var = new fu2();
                fu2Var.u(c0315a);
                fu2Var.K(bundle);
                fu2Var.J(new eu2(gk4Var, this.a));
                fu2Var.J(new cu2(gk4Var.m, this.a));
                fu2Var.M(readableByteChannel);
                boolean N = fu2Var.N();
                fu2Var.o(c0315a);
                if (he2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": onProcessStream: installOk=" + N);
                }
                if (N) {
                    h82.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    lr4.L(file);
                }
                if (N) {
                    return new bk4(2300, "业务层处理下载流成功");
                }
                return new bk4(2301, "业务层处理下载流失败");
            }
            return (bk4) invokeCommon.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ aq3 b;

        public b(he2 he2Var, Collection collection, aq3 aq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {he2Var, collection, aq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = collection;
            this.b = aq3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (Object obj : this.a) {
                    this.b.a(obj);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements aq3<qe2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aq3 a;
        public final /* synthetic */ he2 b;

        public c(he2 he2Var, aq3 aq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {he2Var, aq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = he2Var;
            this.a = aq3Var;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.baidu.tieba.he2.Q(com.baidu.tieba.he2, java.util.Collection, java.lang.Object):com.baidu.tieba.he2
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
            	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
            	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
            	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
            	... 1 more
            */
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(com.baidu.tieba.qe2 r5) {
            /*
                r4 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tieba.he2.c.$ic
                if (r0 != 0) goto L13
            L4:
                com.baidu.tieba.aq3 r0 = r4.a
                r0.a(r5)
                com.baidu.tieba.he2 r0 = r4.b
                java.util.Set r1 = com.baidu.tieba.he2.P(r0)
                com.baidu.tieba.he2.Q(r0, r1, r5)
                return
            L13:
                r2 = r0
                r3 = 1048577(0x100001, float:1.46937E-39)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r2.invokeL(r3, r4, r5)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.he2.c.a(com.baidu.tieba.qe2):void");
        }
    }

    /* loaded from: classes6.dex */
    public class d implements aq3<qe2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ an3 a;
        public final /* synthetic */ boolean b;

        public d(he2 he2Var, an3 an3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {he2Var, an3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = an3Var;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(qe2 qe2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qe2Var) == null) {
                qe2Var.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements aq3<qe2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public e(he2 he2Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {he2Var, pMSAppInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pMSAppInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(qe2 qe2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qe2Var) == null) {
                qe2Var.b(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements de2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gk4 a;
        public final /* synthetic */ he2 b;

        public f(he2 he2Var, gk4 gk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {he2Var, gk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = he2Var;
            this.a = gk4Var;
        }

        @Override // com.baidu.tieba.de2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                he2 he2Var = this.b;
                gk4 gk4Var = this.a;
                he2Var.j = gk4Var;
                he2Var.i.m(gk4Var);
                if (this.b.d != null) {
                    this.b.d.onNext(this.a);
                    this.b.d.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.de2.c
        public void b(PMSDownloadType pMSDownloadType, an3 an3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, an3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, an3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements de2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk4 a;
        public final /* synthetic */ he2 b;

        public g(he2 he2Var, hk4 hk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {he2Var, hk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = he2Var;
            this.a = hk4Var;
        }

        @Override // com.baidu.tieba.de2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                he2 he2Var = this.b;
                if (he2Var.k == null) {
                    he2Var.k = new ArrayList();
                }
                hk4 hk4Var = this.a;
                he2 he2Var2 = this.b;
                hk4Var.o = he2Var2.o;
                he2Var2.k.add(hk4Var);
                this.b.i.m(this.a);
                if (this.b.e != null) {
                    this.b.e.onNext(this.a);
                    if (!this.b.i.i()) {
                        this.b.e.onCompleted();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.de2.c
        public void b(PMSDownloadType pMSDownloadType, an3 an3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, an3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.e != null) {
                    this.b.e.onError(new PkgDownloadError(this.a, an3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements de2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ek4 a;
        public final /* synthetic */ he2 b;

        public h(he2 he2Var, ek4 ek4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {he2Var, ek4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = he2Var;
            this.a = ek4Var;
        }

        @Override // com.baidu.tieba.de2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                he2 he2Var = this.b;
                ek4 ek4Var = this.a;
                he2Var.l = ek4Var;
                he2Var.i.m(ek4Var);
                if (this.b.f != null) {
                    this.b.f.onNext(this.a);
                    this.b.f.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.de2.c
        public void b(PMSDownloadType pMSDownloadType, an3 an3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, an3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.f != null) {
                    this.b.f.onError(new PkgDownloadError(this.a, an3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements de2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ck4 a;
        public final /* synthetic */ he2 b;

        public i(he2 he2Var, ck4 ck4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {he2Var, ck4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = he2Var;
            this.a = ck4Var;
        }

        @Override // com.baidu.tieba.de2.c
        public void b(PMSDownloadType pMSDownloadType, an3 an3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, an3Var) == null) {
                h82.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + an3Var.toString());
                this.b.i.l(this.a);
                this.b.q0(this.a);
            }
        }

        @Override // com.baidu.tieba.de2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                h82.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                he2 he2Var = this.b;
                ck4 ck4Var = this.a;
                he2Var.m = ck4Var;
                he2Var.i.m(ck4Var);
                this.b.q0(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends yac<fk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ he2 e;

        public j(he2 he2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {he2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = he2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tac
        /* renamed from: g */
        public void onNext(fk4 fk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fk4Var) == null) {
                h82.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 单个包下载、业务层处理完成：" + fk4Var.i);
            }
        }

        @Override // com.baidu.tieba.tac
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                h82.l("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载OnError", th);
                this.e.w0(th);
            }
        }

        @Override // com.baidu.tieba.tac
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                h82.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载onCompleted");
                this.e.v0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements sac.a<gk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ he2 a;

        public k(he2 he2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {he2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = he2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
        public void call(yac<? super gk4> yacVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, yacVar) != null) {
                return;
            }
            this.a.d = yacVar;
        }
    }

    /* loaded from: classes6.dex */
    public class l implements sac.a<hk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ he2 a;

        public l(he2 he2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {he2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = he2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
        public void call(yac<? super hk4> yacVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, yacVar) != null) {
                return;
            }
            this.a.e = yacVar;
        }
    }

    /* loaded from: classes6.dex */
    public class m implements sac.a<ek4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ he2 a;

        public m(he2 he2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {he2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = he2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
        public void call(yac<? super ek4> yacVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, yacVar) != null) {
                return;
            }
            this.a.f = yacVar;
        }
    }

    /* loaded from: classes6.dex */
    public class n implements sac.a<ck4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ he2 a;

        public n(he2 he2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {he2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = he2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
        public void call(yac<? super ck4> yacVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, yacVar) != null) {
                return;
            }
            this.a.g = yacVar;
        }
    }

    /* loaded from: classes6.dex */
    public class o implements sac.a<ik4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ he2 a;

        public o(he2 he2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {he2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = he2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
        public void call(yac<? super ik4> yacVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, yacVar) != null) {
                return;
            }
            this.a.h = yacVar;
        }
    }

    /* loaded from: classes6.dex */
    public class p extends oe2<he2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ he2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(he2 he2Var, he2 he2Var2) {
            super(he2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {he2Var, he2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((le2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = he2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oe2, com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: s */
        public void c(hk4 hk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, hk4Var) == null) {
                super.c(hk4Var);
                h82.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: u */
        public void f(hk4 hk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hk4Var) == null) {
                super.f(hk4Var);
                this.c.E0(hk4Var);
            }
        }

        @Override // com.baidu.tieba.oe2, com.baidu.tieba.vi4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.c.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.oe2
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.c.o;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.oe2
        public void p(@NonNull hk4 hk4Var, @Nullable an3 an3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, hk4Var, an3Var) == null) {
                super.p(hk4Var, an3Var);
                h82.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + hk4Var.i);
                he2 he2Var = this.c;
                if (he2Var.k == null) {
                    he2Var.k = new ArrayList();
                }
                he2 he2Var2 = this.c;
                hk4Var.o = he2Var2.o;
                if (an3Var == null) {
                    he2Var2.k.add(hk4Var);
                    this.c.i.m(hk4Var);
                    de2.c().b(hk4Var, this.c.k0());
                } else {
                    he2Var2.i.l(hk4Var);
                    de2.c().a(hk4Var, this.c.k0(), an3Var);
                }
                if (this.c.e != null) {
                    this.c.e.onNext(hk4Var);
                    if (!this.c.i.i()) {
                        this.c.e.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: q */
        public void e(hk4 hk4Var, bk4 bk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, hk4Var, bk4Var) == null) {
                super.q(hk4Var, bk4Var);
                h82.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + bk4Var.toString());
                this.c.i.l(hk4Var);
                an3 an3Var = new an3();
                an3Var.k(12L);
                an3Var.i(bk4Var.a);
                an3Var.d("分包下载失败");
                an3Var.f(bk4Var.toString());
                if (this.c.e != null) {
                    this.c.e.onError(new PkgDownloadError(hk4Var, an3Var));
                }
                de2.c().a(hk4Var, this.c.k0(), an3Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q extends me2<he2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ he2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(he2 he2Var, he2 he2Var2) {
            super(he2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {he2Var, he2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((le2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = he2Var;
        }

        @Override // com.baidu.tieba.me2
        public void u(ik4 ik4Var, an3 an3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, ik4Var, an3Var) == null) {
                h82.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + an3Var);
                this.b.i.l(ik4Var);
                if (this.b.h != null) {
                    this.b.h.onError(new PkgDownloadError(ik4Var, an3Var));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.me2, com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: v */
        public void c(ik4 ik4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, ik4Var) == null) {
                super.c(ik4Var);
                h82.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.vi4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.me2
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.b.k0();
            }
            return (PMSDownloadType) invokeV.objValue;
        }

        @Override // com.baidu.tieba.me2
        public void r(@NonNull ik4 ik4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, ik4Var) == null) {
                this.b.i.m(ik4Var);
                if (this.b.h != null) {
                    this.b.h.onNext(ik4Var);
                    if (!this.b.i.c()) {
                        this.b.h.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.me2, com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: w */
        public void f(ik4 ik4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, ik4Var) == null) {
                super.f(ik4Var);
                if (he2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.b.i0() + ": dependent onDownloading");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r extends vi4<ek4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ he2 a;

        public r(he2 he2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {he2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = he2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yi4
        /* renamed from: l */
        public String d(ek4 ek4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ek4Var)) == null) {
                int i = ek4Var.h;
                if (i == 0) {
                    return ze2.h();
                }
                if (i == 1) {
                    return ze2.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: q */
        public void c(ek4 ek4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, ek4Var) == null) {
                super.c(ek4Var);
                h82.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.aj4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.vi4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: o */
        public void e(ek4 ek4Var, bk4 bk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ek4Var, bk4Var) == null) {
                super.e(ek4Var, bk4Var);
                h82.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + bk4Var.toString());
                this.a.i.l(ek4Var);
                an3 an3Var = new an3();
                an3Var.k(13L);
                an3Var.i(bk4Var.a);
                an3Var.d("Framework包下载失败");
                an3Var.f(bk4Var.toString());
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(ek4Var, an3Var));
                }
                de2.c().a(ek4Var, this.a.k0(), an3Var);
                lr4.k(ek4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: p */
        public void i(ek4 ek4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, ek4Var) == null) {
                super.i(ek4Var);
                h82.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + ek4Var.i);
                an3 y0 = this.a.y0(ek4Var);
                if (y0 == null) {
                    he2 he2Var = this.a;
                    he2Var.l = ek4Var;
                    he2Var.i.m(ek4Var);
                    if (this.a.f != null) {
                        this.a.f.onNext(ek4Var);
                        this.a.f.onCompleted();
                    }
                    de2.c().b(ek4Var, this.a.k0());
                    return;
                }
                this.a.i.l(ek4Var);
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(ek4Var, y0));
                }
                de2.c().a(ek4Var, this.a.k0(), y0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: r */
        public void f(ek4 ek4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, ek4Var) == null) {
                super.f(ek4Var);
                if (he2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": framework onDownloading");
                }
                this.a.C0(ek4Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s extends vi4<ck4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ he2 a;

        public s(he2 he2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {he2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = he2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yi4
        /* renamed from: l */
        public String d(ck4 ck4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ck4Var)) == null) {
                int i = ck4Var.h;
                if (i == 0) {
                    return ze2.d();
                }
                if (i == 1) {
                    return ze2.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: q */
        public void c(ck4 ck4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, ck4Var) == null) {
                super.c(ck4Var);
                h82.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.aj4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.vi4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: o */
        public void e(ck4 ck4Var, bk4 bk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ck4Var, bk4Var) == null) {
                super.e(ck4Var, bk4Var);
                h82.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + bk4Var.toString());
                this.a.i.l(ck4Var);
                an3 an3Var = new an3();
                an3Var.k(14L);
                an3Var.i(bk4Var.a);
                an3Var.d("Extension下载失败");
                an3Var.f(bk4Var.toString());
                if (he2.C) {
                    Log.e("SwanAppPkgDownloadCallback", an3Var.toString());
                }
                this.a.q0(ck4Var);
                de2.c().a(ck4Var, this.a.k0(), an3Var);
                lr4.k(ck4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: p */
        public void i(ck4 ck4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, ck4Var) == null) {
                super.i(ck4Var);
                h82.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + ck4Var.i);
                an3 x0 = this.a.x0(ck4Var);
                if (x0 == null) {
                    he2 he2Var = this.a;
                    he2Var.m = ck4Var;
                    he2Var.i.m(ck4Var);
                    this.a.q0(ck4Var);
                    de2.c().b(ck4Var, this.a.k0());
                    return;
                }
                if (he2.C) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + ck4Var.toString());
                }
                this.a.i.l(ck4Var);
                this.a.q0(ck4Var);
                de2.c().a(ck4Var, this.a.k0(), x0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: r */
        public void f(ck4 ck4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, ck4Var) == null) {
                super.f(ck4Var);
                if (he2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": extension onDownloading");
                }
                this.a.B0(ck4Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements bj4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ he2 a;

        public t(he2 he2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {he2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = he2Var;
        }

        @Override // com.baidu.tieba.bj4
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (he2.C) {
                    Log.e("SwanAppPkgDownloadCallback", this.a.i0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                he2 he2Var = this.a;
                he2Var.n = pMSAppInfo;
                if (pMSAppInfo != null) {
                    he2Var.o0(pMSAppInfo);
                    f73.k(this.a.n.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements aq3<aq3<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public u(he2 he2Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {he2Var, pMSAppInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pMSAppInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(aq3<PMSAppInfo> aq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aq3Var) == null) {
                aq3Var.a(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public v(he2 he2Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {he2Var, collection, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = collection;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.add(this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public w(he2 he2Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {he2Var, collection, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = collection;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.remove(this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947820756, "Lcom/baidu/tieba/he2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947820756, "Lcom/baidu/tieba/he2;");
                return;
            }
        }
        C = rr1.a;
    }

    @Override // com.baidu.tieba.cj4
    public yi4<hk4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.w;
        }
        return (yi4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cj4
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    @Override // com.baidu.tieba.cj4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public String i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (TextUtils.isEmpty(this.c)) {
                this.c = getClass().toString();
            }
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public final String l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return dj4.b(this, "get_launch_id").getString("launch_id", "");
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cj4
    public bj4 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.A;
        }
        return (bj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cj4
    public yi4<ik4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.x;
        }
        return (yi4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cj4
    public yi4<ck4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.z;
        }
        return (yi4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cj4
    public yi4<ek4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.y;
        }
        return (yi4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cj4
    public yi4<gk4> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.v;
        }
        return (yi4) invokeV.objValue;
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            h82.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public he2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = "";
        this.r = -1L;
        this.s = new HashSet();
        this.t = new HashSet();
        this.u = new kp3();
        this.v = new a(this);
        this.w = new p(this, this);
        this.x = new q(this, this);
        this.y = new r(this);
        this.z = new s(this);
        this.A = new t(this);
        this.B = new j(this);
        this.o = str;
        this.p = new ArrayList();
    }

    @Override // com.baidu.tieba.cj4
    public void G(po4 po4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, po4Var) == null) {
            super.G(po4Var);
            this.r = System.currentTimeMillis();
            if (C) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.r);
            }
            if (po4Var == null) {
                return;
            }
            if (C) {
                Log.i("SwanAppPkgDownloadCallback", i0() + ": onPrepareDownload: countSet=" + po4Var.n());
            }
            this.p.add(new UbcFlowEvent("na_pms_start_download"));
            this.i = po4Var;
            if (!po4Var.k()) {
                n0();
            }
        }
    }

    public an3 y0(ek4 ek4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, ek4Var)) == null) {
            if (C) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + ek4Var);
            }
            rk3.b c2 = rk3.c(ek4Var, ek4Var.h);
            if (!TextUtils.isEmpty(ek4Var.a)) {
                h82.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + ek4Var.a);
                lr4.k(ek4Var.a);
            }
            if (!c2.c()) {
                an3 an3Var = new an3();
                an3Var.k(13L);
                an3Var.b(2907L);
                an3Var.d("Core包更新失败");
                return an3Var;
            }
            return null;
        }
        return (an3) invokeL.objValue;
    }

    public final void B0(ck4 ck4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ck4Var) == null) {
            de2.c().d(ck4Var, new i(this, ck4Var));
        }
    }

    public final void C0(ek4 ek4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ek4Var) == null) {
            de2.c().d(ek4Var, new h(this, ek4Var));
        }
    }

    public final void D0(gk4 gk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, gk4Var) == null) {
            de2.c().d(gk4Var, new f(this, gk4Var));
        }
    }

    public final void E0(hk4 hk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hk4Var) == null) {
            de2.c().d(hk4Var, new g(this, hk4Var));
        }
    }

    public he2 e0(aq3<PMSAppInfo> aq3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, aq3Var)) == null) {
            f0(this.t, aq3Var);
            return this;
        }
        return (he2) invokeL.objValue;
    }

    public synchronized he2 g0(qe2 qe2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, qe2Var)) == null) {
            synchronized (this) {
                f0(this.s, qe2Var);
            }
            return this;
        }
        return (he2) invokeL.objValue;
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 == 1013) {
                ej4.i().z(this.o, i2);
            } else {
                ej4.i().z(this.o, 0);
            }
        }
    }

    public he2 o0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, pMSAppInfo)) == null) {
            p0(this.t, new u(this, pMSAppInfo));
            return this;
        }
        return (he2) invokeL.objValue;
    }

    public final void q0(ck4 ck4Var) {
        yac<? super ck4> yacVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, ck4Var) == null) && (yacVar = this.g) != null) {
            yacVar.onNext(ck4Var);
            this.g.onCompleted();
        }
    }

    public he2 r0(@NonNull aq3<qe2> aq3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, aq3Var)) == null) {
            p0(this.s, new c(this, aq3Var));
            return this;
        }
        return (he2) invokeL.objValue;
    }

    public void s0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, pMSAppInfo) == null) {
            r0(new e(this, pMSAppInfo));
        }
    }

    public void A0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            a63.a(this.o, str, this.p, str2);
            this.p.clear();
        }
    }

    public final synchronized <CallbackT> he2 f0(Collection<CallbackT> collection, CallbackT callbackt) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, collection, callbackt)) == null) {
            synchronized (this) {
                if (collection != null && callbackt != null) {
                    this.u.a(new v(this, collection, callbackt));
                }
            }
            return this;
        }
        return (he2) invokeLL.objValue;
    }

    public final synchronized <CallbackT> he2 h0(Collection<CallbackT> collection, CallbackT callbackt) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, collection, callbackt)) == null) {
            synchronized (this) {
                if (collection != null && callbackt != null) {
                    this.u.a(new w(this, collection, callbackt));
                }
            }
            return this;
        }
        return (he2) invokeLL.objValue;
    }

    public final synchronized <CallbackT> he2 p0(@NonNull Collection<CallbackT> collection, @NonNull aq3<CallbackT> aq3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, collection, aq3Var)) == null) {
            synchronized (this) {
                this.u.a(new b(this, collection, aq3Var));
            }
            return this;
        }
        return (he2) invokeLL.objValue;
    }

    public void t0(boolean z, an3 an3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, an3Var) == null) {
            r0(new d(this, an3Var, z));
        }
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
        	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
        	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    public static /* synthetic */ com.baidu.tieba.he2 Q(com.baidu.tieba.he2 r0, java.util.Collection r1, java.lang.Object r2) {
        /*
            r0.h0(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.he2.Q(com.baidu.tieba.he2, java.util.Collection, java.lang.Object):com.baidu.tieba.he2");
    }

    @Override // com.baidu.tieba.cj4
    public void C(bk4 bk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bk4Var) == null) {
            h82.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + bk4Var);
            if (bk4Var != null && bk4Var.a == 1010) {
                G0();
            }
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public an3 z0(gk4 gk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, gk4Var)) == null) {
            if (gk4Var == null) {
                an3 an3Var = new an3();
                an3Var.k(11L);
                an3Var.i(2310L);
                an3Var.f("pkg info is empty");
                en3.a().f(an3Var);
                return an3Var;
            }
            return null;
        }
        return (an3) invokeL.objValue;
    }

    public an3 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PMSAppInfo pMSAppInfo = this.n;
            if (pMSAppInfo == null) {
                if (this.j == null) {
                    an3 an3Var = new an3();
                    an3Var.k(10L);
                    an3Var.i(2903L);
                    an3Var.d("Server未返回主包&AppInfo");
                    return an3Var;
                }
                PMSAppInfo u2 = ej4.i().u(this.o);
                if (u2 == null) {
                    an3 an3Var2 = new an3();
                    an3Var2.k(10L);
                    an3Var2.i(2904L);
                    an3Var2.d("Server未返回AppInfo数据，本地也没有数据");
                    return an3Var2;
                }
                this.n = u2;
                ze2.k(u2, this.j);
                this.n.initMaxAgeInfo();
                this.n.updateInstallSrc(J());
                if (ej4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                    return null;
                }
                an3 an3Var3 = new an3();
                an3Var3.k(10L);
                an3Var3.i(2906L);
                an3Var3.d("更新DB失败");
                return an3Var3;
            }
            gk4 gk4Var = this.j;
            if (gk4Var != null) {
                ze2.k(pMSAppInfo, gk4Var);
            } else if (af2.f(this.k)) {
                hk4 hk4Var = this.k.get(0);
                this.q = hk4Var;
                hk4Var.o = this.o;
                ze2.l(this.n, hk4Var);
            } else {
                PMSAppInfo u3 = ej4.i().u(this.o);
                if (u3 == null) {
                    an3 an3Var4 = new an3();
                    an3Var4.k(10L);
                    an3Var4.i(2905L);
                    an3Var4.d("Server未返回包数据，本地也没有数据");
                    return an3Var4;
                }
                PMSAppInfo pMSAppInfo2 = this.n;
                pMSAppInfo2.appId = this.o;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.n.initMaxAgeInfo();
            this.n.updateInstallSrc(J());
            if (ej4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                ze2.o(this.n);
                return null;
            }
            an3 an3Var5 = new an3();
            an3Var5.k(10L);
            an3Var5.i(2906L);
            an3Var5.d("更新DB失败");
            return an3Var5;
        }
        return (an3) invokeV.objValue;
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PMSAppInfo u2 = ej4.i().u(this.o);
            h82.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(J());
                gk4 gk4Var = this.j;
                if (gk4Var != null) {
                    gk4Var.c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.n;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(J());
                }
                ej4.i().l(u2);
            }
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.i.f()) {
                arrayList.add(sac.d(new k(this)));
            }
            if (this.i.h()) {
                arrayList.add(sac.d(new l(this)));
            }
            if (this.i.e()) {
                arrayList.add(sac.d(new m(this)));
            }
            if (this.i.d()) {
                arrayList.add(sac.d(new n(this)));
            }
            if (this.i.b()) {
                arrayList.add(sac.d(new o(this)));
            }
            if (!arrayList.isEmpty()) {
                sac.q(arrayList).F(this.B);
            }
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048609, this) != null) || this.n == null) {
            return;
        }
        PMSAppInfo u2 = ej4.i().u(this.o);
        if (u2 == null) {
            h82.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.n.appId = this.o;
        u2.updateInstallSrc(J());
        this.n.copyLocalAppInfoData(u2);
        this.n.initMaxAgeInfo();
        if (ej4.i().l(this.n)) {
            ze2.o(this.n);
        }
    }

    public an3 x0(ck4 ck4Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, ck4Var)) == null) {
            nm2 nm2Var = new nm2();
            nm2Var.b = ck4Var.i;
            nm2Var.a = ck4Var.j;
            nm2Var.c = ck4Var.a;
            nm2Var.d = ck4Var.m;
            if (ql2.b(ck4Var.h, nm2Var) == null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                an3 an3Var = new an3();
                an3Var.k(14L);
                an3Var.b(2908L);
                an3Var.d("Extension包更新失败");
                return an3Var;
            }
            return null;
        }
        return (an3) invokeL.objValue;
    }
}
