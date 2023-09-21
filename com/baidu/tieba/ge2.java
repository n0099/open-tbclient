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
import com.baidu.tieba.ce2;
import com.baidu.tieba.kb3;
import com.baidu.tieba.kcc;
import com.baidu.tieba.qk3;
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
public abstract class ge2 extends ke2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public aj4 A;
    public qcc<ek4> B;
    public String c;
    public qcc<? super fk4> d;
    public qcc<? super gk4> e;
    public qcc<? super dk4> f;
    public qcc<? super bk4> g;
    public qcc<? super hk4> h;
    public oo4 i;
    public fk4 j;
    public List<gk4> k;
    public dk4 l;
    public bk4 m;
    public PMSAppInfo n;
    public String o;
    public List<UbcFlowEvent> p;
    public gk4 q;
    public long r;
    public final Set<pe2> s;
    public final Set<zp3<PMSAppInfo>> t;
    public final jp3 u;
    public xi4<fk4> v;
    public xi4<gk4> w;
    public final xi4<hk4> x;
    public xi4<dk4> y;
    public xi4<bk4> z;

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
    public class a extends ui4<fk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge2 a;

        /* renamed from: com.baidu.tieba.ge2$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0314a implements zp3<kb3.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0314a(a aVar) {
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
            @Override // com.baidu.tieba.zp3
            /* renamed from: b */
            public void a(kb3.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.b)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    cj4.a(this.a.a, bundle, "event_performance_ubc");
                }
            }
        }

        public a(ge2 ge2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi4
        /* renamed from: l */
        public String d(fk4 fk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, fk4Var)) == null) {
                int i = fk4Var.h;
                if (i == 0) {
                    return ye2.g();
                }
                if (i == 1) {
                    return ye2.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: q */
        public void c(fk4 fk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048587, this, fk4Var) != null) {
                return;
            }
            String l0 = this.a.l0();
            if (ge2.C) {
                lw2.d(l0).e().d(1);
            }
            super.c(fk4Var);
            g82.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        @Override // com.baidu.tieba.zi4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.ui4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: o */
        public void e(fk4 fk4Var, ak4 ak4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, fk4Var, ak4Var) == null) {
                super.e(fk4Var, ak4Var);
                g82.k("SwanAppPkgDownloadCallback", "onDownloadError：" + ak4Var.toString());
                this.a.i.l(fk4Var);
                zm3 zm3Var = new zm3();
                zm3Var.k(11L);
                zm3Var.i(ak4Var.a);
                zm3Var.d("主包下载失败");
                zm3Var.f(ak4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(fk4Var, zm3Var));
                }
                ce2.c().a(fk4Var, this.a.k0(), zm3Var);
                kr4.k(fk4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: p */
        public void i(fk4 fk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, fk4Var) == null) {
                String l0 = this.a.l0();
                if (ge2.C) {
                    lw2.d(l0).e().d(1);
                }
                super.i(fk4Var);
                this.a.p.add(new UbcFlowEvent("na_pms_end_download"));
                zm3 z0 = this.a.z0(fk4Var);
                g82.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + fk4Var.i);
                if (z0 == null) {
                    ge2 ge2Var = this.a;
                    ge2Var.j = fk4Var;
                    ge2Var.i.m(fk4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(fk4Var);
                        if (ge2.C) {
                            Log.d("SwanAppPkgDownloadCallback", this.a.i0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.a.d.onCompleted();
                    }
                    ce2.c().b(fk4Var, this.a.k0());
                    return;
                }
                this.a.i.l(fk4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(fk4Var, z0));
                }
                ce2.c().a(fk4Var, this.a.k0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: r */
        public void f(fk4 fk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, fk4Var) == null) {
                String l0 = this.a.l0();
                if (ge2.C) {
                    lw2.d(l0).e().d(1);
                }
                super.f(fk4Var);
                if (ge2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": main onDownloading");
                }
                this.a.D0(fk4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: s */
        public ak4 h(fk4 fk4Var, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{fk4Var, file, Long.valueOf(j), readableByteChannel})) == null) {
                String l0 = this.a.l0();
                if (ge2.C) {
                    lw2.d(l0).f(fk4Var.toString()).d(1);
                }
                C0314a c0314a = new C0314a(this);
                Bundle bundle = new Bundle();
                bundle.putLong("length", j);
                bundle.putFloat("progress_granularity", 0.1f);
                eu2 eu2Var = new eu2();
                eu2Var.u(c0314a);
                eu2Var.K(bundle);
                eu2Var.J(new du2(fk4Var, this.a));
                eu2Var.J(new bu2(fk4Var.m, this.a));
                eu2Var.M(readableByteChannel);
                boolean N = eu2Var.N();
                eu2Var.o(c0314a);
                if (ge2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": onProcessStream: installOk=" + N);
                }
                if (N) {
                    g82.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    kr4.L(file);
                }
                if (N) {
                    return new ak4(2300, "业务层处理下载流成功");
                }
                return new ak4(2301, "业务层处理下载流失败");
            }
            return (ak4) invokeCommon.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ zp3 b;

        public b(ge2 ge2Var, Collection collection, zp3 zp3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var, collection, zp3Var};
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
            this.b = zp3Var;
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
    public class c implements zp3<pe2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zp3 a;
        public final /* synthetic */ ge2 b;

        public c(ge2 ge2Var, zp3 zp3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var, zp3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ge2Var;
            this.a = zp3Var;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.baidu.tieba.ge2.Q(com.baidu.tieba.ge2, java.util.Collection, java.lang.Object):com.baidu.tieba.ge2
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
        @Override // com.baidu.tieba.zp3
        /* renamed from: b */
        public void a(com.baidu.tieba.pe2 r5) {
            /*
                r4 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tieba.ge2.c.$ic
                if (r0 != 0) goto L13
            L4:
                com.baidu.tieba.zp3 r0 = r4.a
                r0.a(r5)
                com.baidu.tieba.ge2 r0 = r4.b
                java.util.Set r1 = com.baidu.tieba.ge2.P(r0)
                com.baidu.tieba.ge2.Q(r0, r1, r5)
                return
            L13:
                r2 = r0
                r3 = 1048577(0x100001, float:1.46937E-39)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r2.invokeL(r3, r4, r5)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.ge2.c.a(com.baidu.tieba.pe2):void");
        }
    }

    /* loaded from: classes6.dex */
    public class d implements zp3<pe2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zm3 a;
        public final /* synthetic */ boolean b;

        public d(ge2 ge2Var, zm3 zm3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var, zm3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zm3Var;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zp3
        /* renamed from: b */
        public void a(pe2 pe2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pe2Var) == null) {
                pe2Var.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements zp3<pe2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public e(ge2 ge2Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.zp3
        /* renamed from: b */
        public void a(pe2 pe2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pe2Var) == null) {
                pe2Var.b(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ce2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fk4 a;
        public final /* synthetic */ ge2 b;

        public f(ge2 ge2Var, fk4 fk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var, fk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ge2Var;
            this.a = fk4Var;
        }

        @Override // com.baidu.tieba.ce2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                ge2 ge2Var = this.b;
                fk4 fk4Var = this.a;
                ge2Var.j = fk4Var;
                ge2Var.i.m(fk4Var);
                if (this.b.d != null) {
                    this.b.d.onNext(this.a);
                    this.b.d.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.ce2.c
        public void b(PMSDownloadType pMSDownloadType, zm3 zm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, zm3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, zm3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements ce2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gk4 a;
        public final /* synthetic */ ge2 b;

        public g(ge2 ge2Var, gk4 gk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var, gk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ge2Var;
            this.a = gk4Var;
        }

        @Override // com.baidu.tieba.ce2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                ge2 ge2Var = this.b;
                if (ge2Var.k == null) {
                    ge2Var.k = new ArrayList();
                }
                gk4 gk4Var = this.a;
                ge2 ge2Var2 = this.b;
                gk4Var.o = ge2Var2.o;
                ge2Var2.k.add(gk4Var);
                this.b.i.m(this.a);
                if (this.b.e != null) {
                    this.b.e.onNext(this.a);
                    if (!this.b.i.i()) {
                        this.b.e.onCompleted();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ce2.c
        public void b(PMSDownloadType pMSDownloadType, zm3 zm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, zm3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.e != null) {
                    this.b.e.onError(new PkgDownloadError(this.a, zm3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements ce2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk4 a;
        public final /* synthetic */ ge2 b;

        public h(ge2 ge2Var, dk4 dk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var, dk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ge2Var;
            this.a = dk4Var;
        }

        @Override // com.baidu.tieba.ce2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                ge2 ge2Var = this.b;
                dk4 dk4Var = this.a;
                ge2Var.l = dk4Var;
                ge2Var.i.m(dk4Var);
                if (this.b.f != null) {
                    this.b.f.onNext(this.a);
                    this.b.f.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.ce2.c
        public void b(PMSDownloadType pMSDownloadType, zm3 zm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, zm3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.f != null) {
                    this.b.f.onError(new PkgDownloadError(this.a, zm3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements ce2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bk4 a;
        public final /* synthetic */ ge2 b;

        public i(ge2 ge2Var, bk4 bk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var, bk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ge2Var;
            this.a = bk4Var;
        }

        @Override // com.baidu.tieba.ce2.c
        public void b(PMSDownloadType pMSDownloadType, zm3 zm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, zm3Var) == null) {
                g82.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + zm3Var.toString());
                this.b.i.l(this.a);
                this.b.q0(this.a);
            }
        }

        @Override // com.baidu.tieba.ce2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                g82.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                ge2 ge2Var = this.b;
                bk4 bk4Var = this.a;
                ge2Var.m = bk4Var;
                ge2Var.i.m(bk4Var);
                this.b.q0(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends qcc<ek4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge2 e;

        public j(ge2 ge2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ge2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lcc
        /* renamed from: g */
        public void onNext(ek4 ek4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ek4Var) == null) {
                g82.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 单个包下载、业务层处理完成：" + ek4Var.i);
            }
        }

        @Override // com.baidu.tieba.lcc
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                g82.l("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载OnError", th);
                this.e.w0(th);
            }
        }

        @Override // com.baidu.tieba.lcc
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                g82.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载onCompleted");
                this.e.v0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements kcc.a<fk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge2 a;

        public k(ge2 ge2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kcc.a, com.baidu.tieba.ycc
        public void call(qcc<? super fk4> qccVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, qccVar) != null) {
                return;
            }
            this.a.d = qccVar;
        }
    }

    /* loaded from: classes6.dex */
    public class l implements kcc.a<gk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge2 a;

        public l(ge2 ge2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kcc.a, com.baidu.tieba.ycc
        public void call(qcc<? super gk4> qccVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, qccVar) != null) {
                return;
            }
            this.a.e = qccVar;
        }
    }

    /* loaded from: classes6.dex */
    public class m implements kcc.a<dk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge2 a;

        public m(ge2 ge2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kcc.a, com.baidu.tieba.ycc
        public void call(qcc<? super dk4> qccVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, qccVar) != null) {
                return;
            }
            this.a.f = qccVar;
        }
    }

    /* loaded from: classes6.dex */
    public class n implements kcc.a<bk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge2 a;

        public n(ge2 ge2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kcc.a, com.baidu.tieba.ycc
        public void call(qcc<? super bk4> qccVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, qccVar) != null) {
                return;
            }
            this.a.g = qccVar;
        }
    }

    /* loaded from: classes6.dex */
    public class o implements kcc.a<hk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge2 a;

        public o(ge2 ge2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kcc.a, com.baidu.tieba.ycc
        public void call(qcc<? super hk4> qccVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, qccVar) != null) {
                return;
            }
            this.a.h = qccVar;
        }
    }

    /* loaded from: classes6.dex */
    public class p extends ne2<ge2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(ge2 ge2Var, ge2 ge2Var2) {
            super(ge2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var, ge2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ke2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ge2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ne2, com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: s */
        public void c(gk4 gk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, gk4Var) == null) {
                super.c(gk4Var);
                g82.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: u */
        public void f(gk4 gk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gk4Var) == null) {
                super.f(gk4Var);
                this.c.E0(gk4Var);
            }
        }

        @Override // com.baidu.tieba.ne2, com.baidu.tieba.ui4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.c.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.ne2
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.c.o;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.ne2
        public void p(@NonNull gk4 gk4Var, @Nullable zm3 zm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, gk4Var, zm3Var) == null) {
                super.p(gk4Var, zm3Var);
                g82.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + gk4Var.i);
                ge2 ge2Var = this.c;
                if (ge2Var.k == null) {
                    ge2Var.k = new ArrayList();
                }
                ge2 ge2Var2 = this.c;
                gk4Var.o = ge2Var2.o;
                if (zm3Var == null) {
                    ge2Var2.k.add(gk4Var);
                    this.c.i.m(gk4Var);
                    ce2.c().b(gk4Var, this.c.k0());
                } else {
                    ge2Var2.i.l(gk4Var);
                    ce2.c().a(gk4Var, this.c.k0(), zm3Var);
                }
                if (this.c.e != null) {
                    this.c.e.onNext(gk4Var);
                    if (!this.c.i.i()) {
                        this.c.e.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: q */
        public void e(gk4 gk4Var, ak4 ak4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, gk4Var, ak4Var) == null) {
                super.q(gk4Var, ak4Var);
                g82.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + ak4Var.toString());
                this.c.i.l(gk4Var);
                zm3 zm3Var = new zm3();
                zm3Var.k(12L);
                zm3Var.i(ak4Var.a);
                zm3Var.d("分包下载失败");
                zm3Var.f(ak4Var.toString());
                if (this.c.e != null) {
                    this.c.e.onError(new PkgDownloadError(gk4Var, zm3Var));
                }
                ce2.c().a(gk4Var, this.c.k0(), zm3Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q extends le2<ge2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(ge2 ge2Var, ge2 ge2Var2) {
            super(ge2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var, ge2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ke2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ge2Var;
        }

        @Override // com.baidu.tieba.le2
        public void u(hk4 hk4Var, zm3 zm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, hk4Var, zm3Var) == null) {
                g82.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + zm3Var);
                this.b.i.l(hk4Var);
                if (this.b.h != null) {
                    this.b.h.onError(new PkgDownloadError(hk4Var, zm3Var));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.le2, com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: v */
        public void c(hk4 hk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, hk4Var) == null) {
                super.c(hk4Var);
                g82.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.ui4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.le2
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.b.k0();
            }
            return (PMSDownloadType) invokeV.objValue;
        }

        @Override // com.baidu.tieba.le2
        public void r(@NonNull hk4 hk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, hk4Var) == null) {
                this.b.i.m(hk4Var);
                if (this.b.h != null) {
                    this.b.h.onNext(hk4Var);
                    if (!this.b.i.c()) {
                        this.b.h.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.le2, com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: w */
        public void f(hk4 hk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, hk4Var) == null) {
                super.f(hk4Var);
                if (ge2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.b.i0() + ": dependent onDownloading");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r extends ui4<dk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge2 a;

        public r(ge2 ge2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi4
        /* renamed from: l */
        public String d(dk4 dk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, dk4Var)) == null) {
                int i = dk4Var.h;
                if (i == 0) {
                    return ye2.h();
                }
                if (i == 1) {
                    return ye2.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: q */
        public void c(dk4 dk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, dk4Var) == null) {
                super.c(dk4Var);
                g82.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.zi4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.ui4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: o */
        public void e(dk4 dk4Var, ak4 ak4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dk4Var, ak4Var) == null) {
                super.e(dk4Var, ak4Var);
                g82.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + ak4Var.toString());
                this.a.i.l(dk4Var);
                zm3 zm3Var = new zm3();
                zm3Var.k(13L);
                zm3Var.i(ak4Var.a);
                zm3Var.d("Framework包下载失败");
                zm3Var.f(ak4Var.toString());
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(dk4Var, zm3Var));
                }
                ce2.c().a(dk4Var, this.a.k0(), zm3Var);
                kr4.k(dk4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: p */
        public void i(dk4 dk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, dk4Var) == null) {
                super.i(dk4Var);
                g82.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + dk4Var.i);
                zm3 y0 = this.a.y0(dk4Var);
                if (y0 == null) {
                    ge2 ge2Var = this.a;
                    ge2Var.l = dk4Var;
                    ge2Var.i.m(dk4Var);
                    if (this.a.f != null) {
                        this.a.f.onNext(dk4Var);
                        this.a.f.onCompleted();
                    }
                    ce2.c().b(dk4Var, this.a.k0());
                    return;
                }
                this.a.i.l(dk4Var);
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(dk4Var, y0));
                }
                ce2.c().a(dk4Var, this.a.k0(), y0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: r */
        public void f(dk4 dk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, dk4Var) == null) {
                super.f(dk4Var);
                if (ge2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": framework onDownloading");
                }
                this.a.C0(dk4Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s extends ui4<bk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge2 a;

        public s(ge2 ge2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi4
        /* renamed from: l */
        public String d(bk4 bk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bk4Var)) == null) {
                int i = bk4Var.h;
                if (i == 0) {
                    return ye2.d();
                }
                if (i == 1) {
                    return ye2.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: q */
        public void c(bk4 bk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, bk4Var) == null) {
                super.c(bk4Var);
                g82.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.zi4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.ui4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: o */
        public void e(bk4 bk4Var, ak4 ak4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bk4Var, ak4Var) == null) {
                super.e(bk4Var, ak4Var);
                g82.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + ak4Var.toString());
                this.a.i.l(bk4Var);
                zm3 zm3Var = new zm3();
                zm3Var.k(14L);
                zm3Var.i(ak4Var.a);
                zm3Var.d("Extension下载失败");
                zm3Var.f(ak4Var.toString());
                if (ge2.C) {
                    Log.e("SwanAppPkgDownloadCallback", zm3Var.toString());
                }
                this.a.q0(bk4Var);
                ce2.c().a(bk4Var, this.a.k0(), zm3Var);
                kr4.k(bk4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: p */
        public void i(bk4 bk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, bk4Var) == null) {
                super.i(bk4Var);
                g82.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + bk4Var.i);
                zm3 x0 = this.a.x0(bk4Var);
                if (x0 == null) {
                    ge2 ge2Var = this.a;
                    ge2Var.m = bk4Var;
                    ge2Var.i.m(bk4Var);
                    this.a.q0(bk4Var);
                    ce2.c().b(bk4Var, this.a.k0());
                    return;
                }
                if (ge2.C) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + bk4Var.toString());
                }
                this.a.i.l(bk4Var);
                this.a.q0(bk4Var);
                ce2.c().a(bk4Var, this.a.k0(), x0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: r */
        public void f(bk4 bk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, bk4Var) == null) {
                super.f(bk4Var);
                if (ge2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": extension onDownloading");
                }
                this.a.B0(bk4Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements aj4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge2 a;

        public t(ge2 ge2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge2Var;
        }

        @Override // com.baidu.tieba.aj4
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (ge2.C) {
                    Log.e("SwanAppPkgDownloadCallback", this.a.i0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                ge2 ge2Var = this.a;
                ge2Var.n = pMSAppInfo;
                if (pMSAppInfo != null) {
                    ge2Var.o0(pMSAppInfo);
                    e73.k(this.a.n.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements zp3<zp3<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public u(ge2 ge2Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.zp3
        /* renamed from: b */
        public void a(zp3<PMSAppInfo> zp3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zp3Var) == null) {
                zp3Var.a(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public v(ge2 ge2Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var, collection, obj};
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

        public w(ge2 ge2Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var, collection, obj};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947790965, "Lcom/baidu/tieba/ge2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947790965, "Lcom/baidu/tieba/ge2;");
                return;
            }
        }
        C = qr1.a;
    }

    @Override // com.baidu.tieba.bj4
    public xi4<gk4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.w;
        }
        return (xi4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bj4
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    @Override // com.baidu.tieba.bj4
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
            return cj4.b(this, "get_launch_id").getString("launch_id", "");
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bj4
    public aj4 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.A;
        }
        return (aj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bj4
    public xi4<hk4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.x;
        }
        return (xi4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bj4
    public xi4<bk4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.z;
        }
        return (xi4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bj4
    public xi4<dk4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.y;
        }
        return (xi4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bj4
    public xi4<fk4> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.v;
        }
        return (xi4) invokeV.objValue;
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            g82.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public ge2(String str) {
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
        this.u = new jp3();
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

    @Override // com.baidu.tieba.bj4
    public void G(oo4 oo4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, oo4Var) == null) {
            super.G(oo4Var);
            this.r = System.currentTimeMillis();
            if (C) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.r);
            }
            if (oo4Var == null) {
                return;
            }
            if (C) {
                Log.i("SwanAppPkgDownloadCallback", i0() + ": onPrepareDownload: countSet=" + oo4Var.n());
            }
            this.p.add(new UbcFlowEvent("na_pms_start_download"));
            this.i = oo4Var;
            if (!oo4Var.k()) {
                n0();
            }
        }
    }

    public zm3 y0(dk4 dk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, dk4Var)) == null) {
            if (C) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + dk4Var);
            }
            qk3.b c2 = qk3.c(dk4Var, dk4Var.h);
            if (!TextUtils.isEmpty(dk4Var.a)) {
                g82.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + dk4Var.a);
                kr4.k(dk4Var.a);
            }
            if (!c2.c()) {
                zm3 zm3Var = new zm3();
                zm3Var.k(13L);
                zm3Var.b(2907L);
                zm3Var.d("Core包更新失败");
                return zm3Var;
            }
            return null;
        }
        return (zm3) invokeL.objValue;
    }

    public final void B0(bk4 bk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bk4Var) == null) {
            ce2.c().d(bk4Var, new i(this, bk4Var));
        }
    }

    public final void C0(dk4 dk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dk4Var) == null) {
            ce2.c().d(dk4Var, new h(this, dk4Var));
        }
    }

    public final void D0(fk4 fk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fk4Var) == null) {
            ce2.c().d(fk4Var, new f(this, fk4Var));
        }
    }

    public final void E0(gk4 gk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gk4Var) == null) {
            ce2.c().d(gk4Var, new g(this, gk4Var));
        }
    }

    public ge2 e0(zp3<PMSAppInfo> zp3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, zp3Var)) == null) {
            f0(this.t, zp3Var);
            return this;
        }
        return (ge2) invokeL.objValue;
    }

    public synchronized ge2 g0(pe2 pe2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, pe2Var)) == null) {
            synchronized (this) {
                f0(this.s, pe2Var);
            }
            return this;
        }
        return (ge2) invokeL.objValue;
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 == 1013) {
                dj4.i().z(this.o, i2);
            } else {
                dj4.i().z(this.o, 0);
            }
        }
    }

    public ge2 o0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, pMSAppInfo)) == null) {
            p0(this.t, new u(this, pMSAppInfo));
            return this;
        }
        return (ge2) invokeL.objValue;
    }

    public final void q0(bk4 bk4Var) {
        qcc<? super bk4> qccVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, bk4Var) == null) && (qccVar = this.g) != null) {
            qccVar.onNext(bk4Var);
            this.g.onCompleted();
        }
    }

    public ge2 r0(@NonNull zp3<pe2> zp3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, zp3Var)) == null) {
            p0(this.s, new c(this, zp3Var));
            return this;
        }
        return (ge2) invokeL.objValue;
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
            z53.a(this.o, str, this.p, str2);
            this.p.clear();
        }
    }

    public final synchronized <CallbackT> ge2 f0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (ge2) invokeLL.objValue;
    }

    public final synchronized <CallbackT> ge2 h0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (ge2) invokeLL.objValue;
    }

    public final synchronized <CallbackT> ge2 p0(@NonNull Collection<CallbackT> collection, @NonNull zp3<CallbackT> zp3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, collection, zp3Var)) == null) {
            synchronized (this) {
                this.u.a(new b(this, collection, zp3Var));
            }
            return this;
        }
        return (ge2) invokeLL.objValue;
    }

    public void t0(boolean z, zm3 zm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, zm3Var) == null) {
            r0(new d(this, zm3Var, z));
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
    public static /* synthetic */ com.baidu.tieba.ge2 Q(com.baidu.tieba.ge2 r0, java.util.Collection r1, java.lang.Object r2) {
        /*
            r0.h0(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.ge2.Q(com.baidu.tieba.ge2, java.util.Collection, java.lang.Object):com.baidu.tieba.ge2");
    }

    @Override // com.baidu.tieba.bj4
    public void C(ak4 ak4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ak4Var) == null) {
            g82.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + ak4Var);
            if (ak4Var != null && ak4Var.a == 1010) {
                G0();
            }
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public zm3 z0(fk4 fk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, fk4Var)) == null) {
            if (fk4Var == null) {
                zm3 zm3Var = new zm3();
                zm3Var.k(11L);
                zm3Var.i(2310L);
                zm3Var.f("pkg info is empty");
                dn3.a().f(zm3Var);
                return zm3Var;
            }
            return null;
        }
        return (zm3) invokeL.objValue;
    }

    public zm3 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PMSAppInfo pMSAppInfo = this.n;
            if (pMSAppInfo == null) {
                if (this.j == null) {
                    zm3 zm3Var = new zm3();
                    zm3Var.k(10L);
                    zm3Var.i(2903L);
                    zm3Var.d("Server未返回主包&AppInfo");
                    return zm3Var;
                }
                PMSAppInfo u2 = dj4.i().u(this.o);
                if (u2 == null) {
                    zm3 zm3Var2 = new zm3();
                    zm3Var2.k(10L);
                    zm3Var2.i(2904L);
                    zm3Var2.d("Server未返回AppInfo数据，本地也没有数据");
                    return zm3Var2;
                }
                this.n = u2;
                ye2.k(u2, this.j);
                this.n.initMaxAgeInfo();
                this.n.updateInstallSrc(J());
                if (dj4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                    return null;
                }
                zm3 zm3Var3 = new zm3();
                zm3Var3.k(10L);
                zm3Var3.i(2906L);
                zm3Var3.d("更新DB失败");
                return zm3Var3;
            }
            fk4 fk4Var = this.j;
            if (fk4Var != null) {
                ye2.k(pMSAppInfo, fk4Var);
            } else if (ze2.f(this.k)) {
                gk4 gk4Var = this.k.get(0);
                this.q = gk4Var;
                gk4Var.o = this.o;
                ye2.l(this.n, gk4Var);
            } else {
                PMSAppInfo u3 = dj4.i().u(this.o);
                if (u3 == null) {
                    zm3 zm3Var4 = new zm3();
                    zm3Var4.k(10L);
                    zm3Var4.i(2905L);
                    zm3Var4.d("Server未返回包数据，本地也没有数据");
                    return zm3Var4;
                }
                PMSAppInfo pMSAppInfo2 = this.n;
                pMSAppInfo2.appId = this.o;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.n.initMaxAgeInfo();
            this.n.updateInstallSrc(J());
            if (dj4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                ye2.o(this.n);
                return null;
            }
            zm3 zm3Var5 = new zm3();
            zm3Var5.k(10L);
            zm3Var5.i(2906L);
            zm3Var5.d("更新DB失败");
            return zm3Var5;
        }
        return (zm3) invokeV.objValue;
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PMSAppInfo u2 = dj4.i().u(this.o);
            g82.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(J());
                fk4 fk4Var = this.j;
                if (fk4Var != null) {
                    fk4Var.c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.n;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(J());
                }
                dj4.i().l(u2);
            }
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.i.f()) {
                arrayList.add(kcc.d(new k(this)));
            }
            if (this.i.h()) {
                arrayList.add(kcc.d(new l(this)));
            }
            if (this.i.e()) {
                arrayList.add(kcc.d(new m(this)));
            }
            if (this.i.d()) {
                arrayList.add(kcc.d(new n(this)));
            }
            if (this.i.b()) {
                arrayList.add(kcc.d(new o(this)));
            }
            if (!arrayList.isEmpty()) {
                kcc.q(arrayList).F(this.B);
            }
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048609, this) != null) || this.n == null) {
            return;
        }
        PMSAppInfo u2 = dj4.i().u(this.o);
        if (u2 == null) {
            g82.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.n.appId = this.o;
        u2.updateInstallSrc(J());
        this.n.copyLocalAppInfoData(u2);
        this.n.initMaxAgeInfo();
        if (dj4.i().l(this.n)) {
            ye2.o(this.n);
        }
    }

    public zm3 x0(bk4 bk4Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, bk4Var)) == null) {
            mm2 mm2Var = new mm2();
            mm2Var.b = bk4Var.i;
            mm2Var.a = bk4Var.j;
            mm2Var.c = bk4Var.a;
            mm2Var.d = bk4Var.m;
            if (pl2.b(bk4Var.h, mm2Var) == null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                zm3 zm3Var = new zm3();
                zm3Var.k(14L);
                zm3Var.b(2908L);
                zm3Var.d("Extension包更新失败");
                return zm3Var;
            }
            return null;
        }
        return (zm3) invokeL.objValue;
    }
}
