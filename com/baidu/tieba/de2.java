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
import com.baidu.tieba.hb3;
import com.baidu.tieba.nk3;
import com.baidu.tieba.p7c;
import com.baidu.tieba.zd2;
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
/* loaded from: classes5.dex */
public abstract class de2 extends he2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public xi4 A;
    public v7c<bk4> B;
    public String c;
    public v7c<? super ck4> d;
    public v7c<? super dk4> e;
    public v7c<? super ak4> f;
    public v7c<? super yj4> g;
    public v7c<? super ek4> h;
    public lo4 i;
    public ck4 j;
    public List<dk4> k;
    public ak4 l;
    public yj4 m;
    public PMSAppInfo n;
    public String o;
    public List<UbcFlowEvent> p;
    public dk4 q;
    public long r;
    public final Set<me2> s;
    public final Set<wp3<PMSAppInfo>> t;
    public final gp3 u;
    public ui4<ck4> v;
    public ui4<dk4> w;
    public final ui4<ek4> x;
    public ui4<ak4> y;
    public ui4<yj4> z;

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

    /* loaded from: classes5.dex */
    public class a extends ri4<ck4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ de2 a;

        /* renamed from: com.baidu.tieba.de2$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0270a implements wp3<hb3.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0270a(a aVar) {
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
            @Override // com.baidu.tieba.wp3
            /* renamed from: b */
            public void a(hb3.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.b)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    zi4.a(this.a.a, bundle, "event_performance_ubc");
                }
            }
        }

        public a(de2 de2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = de2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4
        /* renamed from: l */
        public String d(ck4 ck4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ck4Var)) == null) {
                int i = ck4Var.h;
                if (i == 0) {
                    return ve2.g();
                }
                if (i == 1) {
                    return ve2.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: q */
        public void c(ck4 ck4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048587, this, ck4Var) != null) {
                return;
            }
            String l0 = this.a.l0();
            if (de2.C) {
                iw2.d(l0).e().d(1);
            }
            super.c(ck4Var);
            d82.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        @Override // com.baidu.tieba.wi4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.ri4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: o */
        public void e(ck4 ck4Var, xj4 xj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, ck4Var, xj4Var) == null) {
                super.e(ck4Var, xj4Var);
                d82.k("SwanAppPkgDownloadCallback", "onDownloadError：" + xj4Var.toString());
                this.a.i.l(ck4Var);
                wm3 wm3Var = new wm3();
                wm3Var.k(11L);
                wm3Var.i(xj4Var.a);
                wm3Var.d("主包下载失败");
                wm3Var.f(xj4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(ck4Var, wm3Var));
                }
                zd2.c().a(ck4Var, this.a.k0(), wm3Var);
                hr4.k(ck4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: p */
        public void i(ck4 ck4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, ck4Var) == null) {
                String l0 = this.a.l0();
                if (de2.C) {
                    iw2.d(l0).e().d(1);
                }
                super.i(ck4Var);
                this.a.p.add(new UbcFlowEvent("na_pms_end_download"));
                wm3 z0 = this.a.z0(ck4Var);
                d82.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + ck4Var.i);
                if (z0 == null) {
                    de2 de2Var = this.a;
                    de2Var.j = ck4Var;
                    de2Var.i.m(ck4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(ck4Var);
                        if (de2.C) {
                            Log.d("SwanAppPkgDownloadCallback", this.a.i0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.a.d.onCompleted();
                    }
                    zd2.c().b(ck4Var, this.a.k0());
                    return;
                }
                this.a.i.l(ck4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(ck4Var, z0));
                }
                zd2.c().a(ck4Var, this.a.k0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: r */
        public void f(ck4 ck4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, ck4Var) == null) {
                String l0 = this.a.l0();
                if (de2.C) {
                    iw2.d(l0).e().d(1);
                }
                super.f(ck4Var);
                if (de2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": main onDownloading");
                }
                this.a.D0(ck4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: s */
        public xj4 h(ck4 ck4Var, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{ck4Var, file, Long.valueOf(j), readableByteChannel})) == null) {
                String l0 = this.a.l0();
                if (de2.C) {
                    iw2.d(l0).f(ck4Var.toString()).d(1);
                }
                C0270a c0270a = new C0270a(this);
                Bundle bundle = new Bundle();
                bundle.putLong("length", j);
                bundle.putFloat("progress_granularity", 0.1f);
                bu2 bu2Var = new bu2();
                bu2Var.u(c0270a);
                bu2Var.K(bundle);
                bu2Var.J(new au2(ck4Var, this.a));
                bu2Var.J(new yt2(ck4Var.m, this.a));
                bu2Var.M(readableByteChannel);
                boolean N = bu2Var.N();
                bu2Var.o(c0270a);
                if (de2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": onProcessStream: installOk=" + N);
                }
                if (N) {
                    d82.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    hr4.L(file);
                }
                if (N) {
                    return new xj4(2300, "业务层处理下载流成功");
                }
                return new xj4(2301, "业务层处理下载流失败");
            }
            return (xj4) invokeCommon.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ wp3 b;

        public b(de2 de2Var, Collection collection, wp3 wp3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de2Var, collection, wp3Var};
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
            this.b = wp3Var;
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

    /* loaded from: classes5.dex */
    public class c implements wp3<me2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wp3 a;
        public final /* synthetic */ de2 b;

        public c(de2 de2Var, wp3 wp3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de2Var, wp3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = de2Var;
            this.a = wp3Var;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.baidu.tieba.de2.Q(com.baidu.tieba.de2, java.util.Collection, java.lang.Object):com.baidu.tieba.de2
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
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(com.baidu.tieba.me2 r5) {
            /*
                r4 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tieba.de2.c.$ic
                if (r0 != 0) goto L13
            L4:
                com.baidu.tieba.wp3 r0 = r4.a
                r0.a(r5)
                com.baidu.tieba.de2 r0 = r4.b
                java.util.Set r1 = com.baidu.tieba.de2.P(r0)
                com.baidu.tieba.de2.Q(r0, r1, r5)
                return
            L13:
                r2 = r0
                r3 = 1048577(0x100001, float:1.46937E-39)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r2.invokeL(r3, r4, r5)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.de2.c.a(com.baidu.tieba.me2):void");
        }
    }

    /* loaded from: classes5.dex */
    public class d implements wp3<me2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wm3 a;
        public final /* synthetic */ boolean b;

        public d(de2 de2Var, wm3 wm3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de2Var, wm3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wm3Var;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(me2 me2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, me2Var) == null) {
                me2Var.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements wp3<me2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public e(de2 de2Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de2Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(me2 me2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, me2Var) == null) {
                me2Var.b(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements zd2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ck4 a;
        public final /* synthetic */ de2 b;

        public f(de2 de2Var, ck4 ck4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de2Var, ck4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = de2Var;
            this.a = ck4Var;
        }

        @Override // com.baidu.tieba.zd2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                de2 de2Var = this.b;
                ck4 ck4Var = this.a;
                de2Var.j = ck4Var;
                de2Var.i.m(ck4Var);
                if (this.b.d != null) {
                    this.b.d.onNext(this.a);
                    this.b.d.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.zd2.c
        public void b(PMSDownloadType pMSDownloadType, wm3 wm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, wm3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, wm3Var));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements zd2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk4 a;
        public final /* synthetic */ de2 b;

        public g(de2 de2Var, dk4 dk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de2Var, dk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = de2Var;
            this.a = dk4Var;
        }

        @Override // com.baidu.tieba.zd2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                de2 de2Var = this.b;
                if (de2Var.k == null) {
                    de2Var.k = new ArrayList();
                }
                dk4 dk4Var = this.a;
                de2 de2Var2 = this.b;
                dk4Var.o = de2Var2.o;
                de2Var2.k.add(dk4Var);
                this.b.i.m(this.a);
                if (this.b.e != null) {
                    this.b.e.onNext(this.a);
                    if (!this.b.i.i()) {
                        this.b.e.onCompleted();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.zd2.c
        public void b(PMSDownloadType pMSDownloadType, wm3 wm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, wm3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.e != null) {
                    this.b.e.onError(new PkgDownloadError(this.a, wm3Var));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements zd2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ak4 a;
        public final /* synthetic */ de2 b;

        public h(de2 de2Var, ak4 ak4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de2Var, ak4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = de2Var;
            this.a = ak4Var;
        }

        @Override // com.baidu.tieba.zd2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                de2 de2Var = this.b;
                ak4 ak4Var = this.a;
                de2Var.l = ak4Var;
                de2Var.i.m(ak4Var);
                if (this.b.f != null) {
                    this.b.f.onNext(this.a);
                    this.b.f.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.zd2.c
        public void b(PMSDownloadType pMSDownloadType, wm3 wm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, wm3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.f != null) {
                    this.b.f.onError(new PkgDownloadError(this.a, wm3Var));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements zd2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yj4 a;
        public final /* synthetic */ de2 b;

        public i(de2 de2Var, yj4 yj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de2Var, yj4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = de2Var;
            this.a = yj4Var;
        }

        @Override // com.baidu.tieba.zd2.c
        public void b(PMSDownloadType pMSDownloadType, wm3 wm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, wm3Var) == null) {
                d82.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + wm3Var.toString());
                this.b.i.l(this.a);
                this.b.q0(this.a);
            }
        }

        @Override // com.baidu.tieba.zd2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                d82.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                de2 de2Var = this.b;
                yj4 yj4Var = this.a;
                de2Var.m = yj4Var;
                de2Var.i.m(yj4Var);
                this.b.q0(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j extends v7c<bk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ de2 e;

        public j(de2 de2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = de2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.q7c
        /* renamed from: g */
        public void onNext(bk4 bk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bk4Var) == null) {
                d82.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 单个包下载、业务层处理完成：" + bk4Var.i);
            }
        }

        @Override // com.baidu.tieba.q7c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                d82.l("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载OnError", th);
                this.e.w0(th);
            }
        }

        @Override // com.baidu.tieba.q7c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d82.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载onCompleted");
                this.e.v0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements p7c.a<ck4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ de2 a;

        public k(de2 de2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = de2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p7c.a, com.baidu.tieba.d8c
        public void call(v7c<? super ck4> v7cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, v7cVar) != null) {
                return;
            }
            this.a.d = v7cVar;
        }
    }

    /* loaded from: classes5.dex */
    public class l implements p7c.a<dk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ de2 a;

        public l(de2 de2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = de2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p7c.a, com.baidu.tieba.d8c
        public void call(v7c<? super dk4> v7cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, v7cVar) != null) {
                return;
            }
            this.a.e = v7cVar;
        }
    }

    /* loaded from: classes5.dex */
    public class m implements p7c.a<ak4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ de2 a;

        public m(de2 de2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = de2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p7c.a, com.baidu.tieba.d8c
        public void call(v7c<? super ak4> v7cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, v7cVar) != null) {
                return;
            }
            this.a.f = v7cVar;
        }
    }

    /* loaded from: classes5.dex */
    public class n implements p7c.a<yj4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ de2 a;

        public n(de2 de2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = de2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p7c.a, com.baidu.tieba.d8c
        public void call(v7c<? super yj4> v7cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, v7cVar) != null) {
                return;
            }
            this.a.g = v7cVar;
        }
    }

    /* loaded from: classes5.dex */
    public class o implements p7c.a<ek4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ de2 a;

        public o(de2 de2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = de2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p7c.a, com.baidu.tieba.d8c
        public void call(v7c<? super ek4> v7cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, v7cVar) != null) {
                return;
            }
            this.a.h = v7cVar;
        }
    }

    /* loaded from: classes5.dex */
    public class p extends ke2<de2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ de2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(de2 de2Var, de2 de2Var2) {
            super(de2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de2Var, de2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((he2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = de2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ke2, com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: s */
        public void c(dk4 dk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, dk4Var) == null) {
                super.c(dk4Var);
                d82.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: u */
        public void f(dk4 dk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dk4Var) == null) {
                super.f(dk4Var);
                this.c.E0(dk4Var);
            }
        }

        @Override // com.baidu.tieba.ke2, com.baidu.tieba.ri4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.c.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.ke2
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.c.o;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.ke2
        public void p(@NonNull dk4 dk4Var, @Nullable wm3 wm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, dk4Var, wm3Var) == null) {
                super.p(dk4Var, wm3Var);
                d82.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + dk4Var.i);
                de2 de2Var = this.c;
                if (de2Var.k == null) {
                    de2Var.k = new ArrayList();
                }
                de2 de2Var2 = this.c;
                dk4Var.o = de2Var2.o;
                if (wm3Var == null) {
                    de2Var2.k.add(dk4Var);
                    this.c.i.m(dk4Var);
                    zd2.c().b(dk4Var, this.c.k0());
                } else {
                    de2Var2.i.l(dk4Var);
                    zd2.c().a(dk4Var, this.c.k0(), wm3Var);
                }
                if (this.c.e != null) {
                    this.c.e.onNext(dk4Var);
                    if (!this.c.i.i()) {
                        this.c.e.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: q */
        public void e(dk4 dk4Var, xj4 xj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, dk4Var, xj4Var) == null) {
                super.q(dk4Var, xj4Var);
                d82.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + xj4Var.toString());
                this.c.i.l(dk4Var);
                wm3 wm3Var = new wm3();
                wm3Var.k(12L);
                wm3Var.i(xj4Var.a);
                wm3Var.d("分包下载失败");
                wm3Var.f(xj4Var.toString());
                if (this.c.e != null) {
                    this.c.e.onError(new PkgDownloadError(dk4Var, wm3Var));
                }
                zd2.c().a(dk4Var, this.c.k0(), wm3Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q extends ie2<de2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ de2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(de2 de2Var, de2 de2Var2) {
            super(de2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de2Var, de2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((he2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = de2Var;
        }

        @Override // com.baidu.tieba.ie2
        public void u(ek4 ek4Var, wm3 wm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, ek4Var, wm3Var) == null) {
                d82.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + wm3Var);
                this.b.i.l(ek4Var);
                if (this.b.h != null) {
                    this.b.h.onError(new PkgDownloadError(ek4Var, wm3Var));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ie2, com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: v */
        public void c(ek4 ek4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, ek4Var) == null) {
                super.c(ek4Var);
                d82.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.ri4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.ie2
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.b.k0();
            }
            return (PMSDownloadType) invokeV.objValue;
        }

        @Override // com.baidu.tieba.ie2
        public void r(@NonNull ek4 ek4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, ek4Var) == null) {
                this.b.i.m(ek4Var);
                if (this.b.h != null) {
                    this.b.h.onNext(ek4Var);
                    if (!this.b.i.c()) {
                        this.b.h.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ie2, com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: w */
        public void f(ek4 ek4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, ek4Var) == null) {
                super.f(ek4Var);
                if (de2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.b.i0() + ": dependent onDownloading");
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r extends ri4<ak4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ de2 a;

        public r(de2 de2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = de2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4
        /* renamed from: l */
        public String d(ak4 ak4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ak4Var)) == null) {
                int i = ak4Var.h;
                if (i == 0) {
                    return ve2.h();
                }
                if (i == 1) {
                    return ve2.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: q */
        public void c(ak4 ak4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, ak4Var) == null) {
                super.c(ak4Var);
                d82.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.wi4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.ri4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: o */
        public void e(ak4 ak4Var, xj4 xj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ak4Var, xj4Var) == null) {
                super.e(ak4Var, xj4Var);
                d82.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + xj4Var.toString());
                this.a.i.l(ak4Var);
                wm3 wm3Var = new wm3();
                wm3Var.k(13L);
                wm3Var.i(xj4Var.a);
                wm3Var.d("Framework包下载失败");
                wm3Var.f(xj4Var.toString());
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(ak4Var, wm3Var));
                }
                zd2.c().a(ak4Var, this.a.k0(), wm3Var);
                hr4.k(ak4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: p */
        public void i(ak4 ak4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, ak4Var) == null) {
                super.i(ak4Var);
                d82.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + ak4Var.i);
                wm3 y0 = this.a.y0(ak4Var);
                if (y0 == null) {
                    de2 de2Var = this.a;
                    de2Var.l = ak4Var;
                    de2Var.i.m(ak4Var);
                    if (this.a.f != null) {
                        this.a.f.onNext(ak4Var);
                        this.a.f.onCompleted();
                    }
                    zd2.c().b(ak4Var, this.a.k0());
                    return;
                }
                this.a.i.l(ak4Var);
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(ak4Var, y0));
                }
                zd2.c().a(ak4Var, this.a.k0(), y0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: r */
        public void f(ak4 ak4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, ak4Var) == null) {
                super.f(ak4Var);
                if (de2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": framework onDownloading");
                }
                this.a.C0(ak4Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s extends ri4<yj4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ de2 a;

        public s(de2 de2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = de2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4
        /* renamed from: l */
        public String d(yj4 yj4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, yj4Var)) == null) {
                int i = yj4Var.h;
                if (i == 0) {
                    return ve2.d();
                }
                if (i == 1) {
                    return ve2.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: q */
        public void c(yj4 yj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, yj4Var) == null) {
                super.c(yj4Var);
                d82.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.wi4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.ri4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: o */
        public void e(yj4 yj4Var, xj4 xj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yj4Var, xj4Var) == null) {
                super.e(yj4Var, xj4Var);
                d82.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + xj4Var.toString());
                this.a.i.l(yj4Var);
                wm3 wm3Var = new wm3();
                wm3Var.k(14L);
                wm3Var.i(xj4Var.a);
                wm3Var.d("Extension下载失败");
                wm3Var.f(xj4Var.toString());
                if (de2.C) {
                    Log.e("SwanAppPkgDownloadCallback", wm3Var.toString());
                }
                this.a.q0(yj4Var);
                zd2.c().a(yj4Var, this.a.k0(), wm3Var);
                hr4.k(yj4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: p */
        public void i(yj4 yj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, yj4Var) == null) {
                super.i(yj4Var);
                d82.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + yj4Var.i);
                wm3 x0 = this.a.x0(yj4Var);
                if (x0 == null) {
                    de2 de2Var = this.a;
                    de2Var.m = yj4Var;
                    de2Var.i.m(yj4Var);
                    this.a.q0(yj4Var);
                    zd2.c().b(yj4Var, this.a.k0());
                    return;
                }
                if (de2.C) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + yj4Var.toString());
                }
                this.a.i.l(yj4Var);
                this.a.q0(yj4Var);
                zd2.c().a(yj4Var, this.a.k0(), x0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: r */
        public void f(yj4 yj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, yj4Var) == null) {
                super.f(yj4Var);
                if (de2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": extension onDownloading");
                }
                this.a.B0(yj4Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements xi4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ de2 a;

        public t(de2 de2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = de2Var;
        }

        @Override // com.baidu.tieba.xi4
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (de2.C) {
                    Log.e("SwanAppPkgDownloadCallback", this.a.i0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                de2 de2Var = this.a;
                de2Var.n = pMSAppInfo;
                if (pMSAppInfo != null) {
                    de2Var.o0(pMSAppInfo);
                    b73.k(this.a.n.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements wp3<wp3<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public u(de2 de2Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de2Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(wp3<PMSAppInfo> wp3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wp3Var) == null) {
                wp3Var.a(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public v(de2 de2Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de2Var, collection, obj};
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

    /* loaded from: classes5.dex */
    public class w implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public w(de2 de2Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de2Var, collection, obj};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947701592, "Lcom/baidu/tieba/de2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947701592, "Lcom/baidu/tieba/de2;");
                return;
            }
        }
        C = nr1.a;
    }

    @Override // com.baidu.tieba.yi4
    public ui4<dk4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.w;
        }
        return (ui4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yi4
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    @Override // com.baidu.tieba.yi4
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
            return zi4.b(this, "get_launch_id").getString("launch_id", "");
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yi4
    public xi4 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.A;
        }
        return (xi4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yi4
    public ui4<ek4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.x;
        }
        return (ui4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yi4
    public ui4<yj4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.z;
        }
        return (ui4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yi4
    public ui4<ak4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.y;
        }
        return (ui4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yi4
    public ui4<ck4> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.v;
        }
        return (ui4) invokeV.objValue;
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            d82.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public de2(String str) {
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
        this.u = new gp3();
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

    @Override // com.baidu.tieba.yi4
    public void G(lo4 lo4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, lo4Var) == null) {
            super.G(lo4Var);
            this.r = System.currentTimeMillis();
            if (C) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.r);
            }
            if (lo4Var == null) {
                return;
            }
            if (C) {
                Log.i("SwanAppPkgDownloadCallback", i0() + ": onPrepareDownload: countSet=" + lo4Var.n());
            }
            this.p.add(new UbcFlowEvent("na_pms_start_download"));
            this.i = lo4Var;
            if (!lo4Var.k()) {
                n0();
            }
        }
    }

    public wm3 y0(ak4 ak4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, ak4Var)) == null) {
            if (C) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + ak4Var);
            }
            nk3.b c2 = nk3.c(ak4Var, ak4Var.h);
            if (!TextUtils.isEmpty(ak4Var.a)) {
                d82.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + ak4Var.a);
                hr4.k(ak4Var.a);
            }
            if (!c2.c()) {
                wm3 wm3Var = new wm3();
                wm3Var.k(13L);
                wm3Var.b(2907L);
                wm3Var.d("Core包更新失败");
                return wm3Var;
            }
            return null;
        }
        return (wm3) invokeL.objValue;
    }

    public final void B0(yj4 yj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yj4Var) == null) {
            zd2.c().d(yj4Var, new i(this, yj4Var));
        }
    }

    public final void C0(ak4 ak4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ak4Var) == null) {
            zd2.c().d(ak4Var, new h(this, ak4Var));
        }
    }

    public final void D0(ck4 ck4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ck4Var) == null) {
            zd2.c().d(ck4Var, new f(this, ck4Var));
        }
    }

    public final void E0(dk4 dk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dk4Var) == null) {
            zd2.c().d(dk4Var, new g(this, dk4Var));
        }
    }

    public de2 e0(wp3<PMSAppInfo> wp3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, wp3Var)) == null) {
            f0(this.t, wp3Var);
            return this;
        }
        return (de2) invokeL.objValue;
    }

    public synchronized de2 g0(me2 me2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, me2Var)) == null) {
            synchronized (this) {
                f0(this.s, me2Var);
            }
            return this;
        }
        return (de2) invokeL.objValue;
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 == 1013) {
                aj4.i().z(this.o, i2);
            } else {
                aj4.i().z(this.o, 0);
            }
        }
    }

    public de2 o0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, pMSAppInfo)) == null) {
            p0(this.t, new u(this, pMSAppInfo));
            return this;
        }
        return (de2) invokeL.objValue;
    }

    public final void q0(yj4 yj4Var) {
        v7c<? super yj4> v7cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, yj4Var) == null) && (v7cVar = this.g) != null) {
            v7cVar.onNext(yj4Var);
            this.g.onCompleted();
        }
    }

    public de2 r0(@NonNull wp3<me2> wp3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, wp3Var)) == null) {
            p0(this.s, new c(this, wp3Var));
            return this;
        }
        return (de2) invokeL.objValue;
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
            w53.a(this.o, str, this.p, str2);
            this.p.clear();
        }
    }

    public final synchronized <CallbackT> de2 f0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (de2) invokeLL.objValue;
    }

    public final synchronized <CallbackT> de2 h0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (de2) invokeLL.objValue;
    }

    public final synchronized <CallbackT> de2 p0(@NonNull Collection<CallbackT> collection, @NonNull wp3<CallbackT> wp3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, collection, wp3Var)) == null) {
            synchronized (this) {
                this.u.a(new b(this, collection, wp3Var));
            }
            return this;
        }
        return (de2) invokeLL.objValue;
    }

    public void t0(boolean z, wm3 wm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, wm3Var) == null) {
            r0(new d(this, wm3Var, z));
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
    public static /* synthetic */ com.baidu.tieba.de2 Q(com.baidu.tieba.de2 r0, java.util.Collection r1, java.lang.Object r2) {
        /*
            r0.h0(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.de2.Q(com.baidu.tieba.de2, java.util.Collection, java.lang.Object):com.baidu.tieba.de2");
    }

    @Override // com.baidu.tieba.yi4
    public void C(xj4 xj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, xj4Var) == null) {
            d82.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + xj4Var);
            if (xj4Var != null && xj4Var.a == 1010) {
                G0();
            }
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public wm3 z0(ck4 ck4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, ck4Var)) == null) {
            if (ck4Var == null) {
                wm3 wm3Var = new wm3();
                wm3Var.k(11L);
                wm3Var.i(2310L);
                wm3Var.f("pkg info is empty");
                an3.a().f(wm3Var);
                return wm3Var;
            }
            return null;
        }
        return (wm3) invokeL.objValue;
    }

    public wm3 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PMSAppInfo pMSAppInfo = this.n;
            if (pMSAppInfo == null) {
                if (this.j == null) {
                    wm3 wm3Var = new wm3();
                    wm3Var.k(10L);
                    wm3Var.i(2903L);
                    wm3Var.d("Server未返回主包&AppInfo");
                    return wm3Var;
                }
                PMSAppInfo u2 = aj4.i().u(this.o);
                if (u2 == null) {
                    wm3 wm3Var2 = new wm3();
                    wm3Var2.k(10L);
                    wm3Var2.i(2904L);
                    wm3Var2.d("Server未返回AppInfo数据，本地也没有数据");
                    return wm3Var2;
                }
                this.n = u2;
                ve2.k(u2, this.j);
                this.n.initMaxAgeInfo();
                this.n.updateInstallSrc(J());
                if (aj4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                    return null;
                }
                wm3 wm3Var3 = new wm3();
                wm3Var3.k(10L);
                wm3Var3.i(2906L);
                wm3Var3.d("更新DB失败");
                return wm3Var3;
            }
            ck4 ck4Var = this.j;
            if (ck4Var != null) {
                ve2.k(pMSAppInfo, ck4Var);
            } else if (we2.f(this.k)) {
                dk4 dk4Var = this.k.get(0);
                this.q = dk4Var;
                dk4Var.o = this.o;
                ve2.l(this.n, dk4Var);
            } else {
                PMSAppInfo u3 = aj4.i().u(this.o);
                if (u3 == null) {
                    wm3 wm3Var4 = new wm3();
                    wm3Var4.k(10L);
                    wm3Var4.i(2905L);
                    wm3Var4.d("Server未返回包数据，本地也没有数据");
                    return wm3Var4;
                }
                PMSAppInfo pMSAppInfo2 = this.n;
                pMSAppInfo2.appId = this.o;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.n.initMaxAgeInfo();
            this.n.updateInstallSrc(J());
            if (aj4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                ve2.o(this.n);
                return null;
            }
            wm3 wm3Var5 = new wm3();
            wm3Var5.k(10L);
            wm3Var5.i(2906L);
            wm3Var5.d("更新DB失败");
            return wm3Var5;
        }
        return (wm3) invokeV.objValue;
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PMSAppInfo u2 = aj4.i().u(this.o);
            d82.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(J());
                ck4 ck4Var = this.j;
                if (ck4Var != null) {
                    ck4Var.c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.n;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(J());
                }
                aj4.i().l(u2);
            }
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.i.f()) {
                arrayList.add(p7c.d(new k(this)));
            }
            if (this.i.h()) {
                arrayList.add(p7c.d(new l(this)));
            }
            if (this.i.e()) {
                arrayList.add(p7c.d(new m(this)));
            }
            if (this.i.d()) {
                arrayList.add(p7c.d(new n(this)));
            }
            if (this.i.b()) {
                arrayList.add(p7c.d(new o(this)));
            }
            if (!arrayList.isEmpty()) {
                p7c.q(arrayList).F(this.B);
            }
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048609, this) != null) || this.n == null) {
            return;
        }
        PMSAppInfo u2 = aj4.i().u(this.o);
        if (u2 == null) {
            d82.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.n.appId = this.o;
        u2.updateInstallSrc(J());
        this.n.copyLocalAppInfoData(u2);
        this.n.initMaxAgeInfo();
        if (aj4.i().l(this.n)) {
            ve2.o(this.n);
        }
    }

    public wm3 x0(yj4 yj4Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, yj4Var)) == null) {
            jm2 jm2Var = new jm2();
            jm2Var.b = yj4Var.i;
            jm2Var.a = yj4Var.j;
            jm2Var.c = yj4Var.a;
            jm2Var.d = yj4Var.m;
            if (ml2.b(yj4Var.h, jm2Var) == null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                wm3 wm3Var = new wm3();
                wm3Var.k(14L);
                wm3Var.b(2908L);
                wm3Var.d("Extension包更新失败");
                return wm3Var;
            }
            return null;
        }
        return (wm3) invokeL.objValue;
    }
}
