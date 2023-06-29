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
import com.baidu.tieba.gc3;
import com.baidu.tieba.ml3;
import com.baidu.tieba.xsb;
import com.baidu.tieba.ye2;
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
public abstract class cf2 extends gf2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public wj4 A;
    public dtb<al4> B;
    public String c;
    public dtb<? super bl4> d;
    public dtb<? super cl4> e;
    public dtb<? super zk4> f;
    public dtb<? super xk4> g;
    public dtb<? super dl4> h;
    public kp4 i;
    public bl4 j;
    public List<cl4> k;
    public zk4 l;
    public xk4 m;
    public PMSAppInfo n;
    public String o;
    public List<UbcFlowEvent> p;
    public cl4 q;
    public long r;
    public final Set<lf2> s;
    public final Set<vq3<PMSAppInfo>> t;
    public final fq3 u;
    public tj4<bl4> v;
    public tj4<cl4> w;
    public final tj4<dl4> x;
    public tj4<zk4> y;
    public tj4<xk4> z;

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
    public class a extends qj4<bl4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf2 a;

        /* renamed from: com.baidu.tieba.cf2$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0268a implements vq3<gc3.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0268a(a aVar) {
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
            @Override // com.baidu.tieba.vq3
            /* renamed from: b */
            public void a(gc3.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.b)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    yj4.a(this.a.a, bundle, "event_performance_ubc");
                }
            }
        }

        public a(cf2 cf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tj4
        /* renamed from: l */
        public String d(bl4 bl4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bl4Var)) == null) {
                int i = bl4Var.h;
                if (i == 0) {
                    return uf2.g();
                }
                if (i == 1) {
                    return uf2.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qj4, com.baidu.tieba.tj4
        /* renamed from: q */
        public void c(bl4 bl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048587, this, bl4Var) != null) {
                return;
            }
            String l0 = this.a.l0();
            if (cf2.C) {
                hx2.d(l0).e().d(1);
            }
            super.c(bl4Var);
            c92.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        @Override // com.baidu.tieba.vj4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.qj4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qj4, com.baidu.tieba.tj4
        /* renamed from: o */
        public void e(bl4 bl4Var, wk4 wk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, bl4Var, wk4Var) == null) {
                super.e(bl4Var, wk4Var);
                c92.k("SwanAppPkgDownloadCallback", "onDownloadError：" + wk4Var.toString());
                this.a.i.l(bl4Var);
                vn3 vn3Var = new vn3();
                vn3Var.k(11L);
                vn3Var.i(wk4Var.a);
                vn3Var.d("主包下载失败");
                vn3Var.f(wk4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(bl4Var, vn3Var));
                }
                ye2.c().a(bl4Var, this.a.k0(), vn3Var);
                gs4.k(bl4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qj4, com.baidu.tieba.tj4
        /* renamed from: p */
        public void i(bl4 bl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, bl4Var) == null) {
                String l0 = this.a.l0();
                if (cf2.C) {
                    hx2.d(l0).e().d(1);
                }
                super.i(bl4Var);
                this.a.p.add(new UbcFlowEvent("na_pms_end_download"));
                vn3 z0 = this.a.z0(bl4Var);
                c92.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + bl4Var.i);
                if (z0 == null) {
                    cf2 cf2Var = this.a;
                    cf2Var.j = bl4Var;
                    cf2Var.i.m(bl4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(bl4Var);
                        if (cf2.C) {
                            Log.d("SwanAppPkgDownloadCallback", this.a.i0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.a.d.onCompleted();
                    }
                    ye2.c().b(bl4Var, this.a.k0());
                    return;
                }
                this.a.i.l(bl4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(bl4Var, z0));
                }
                ye2.c().a(bl4Var, this.a.k0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qj4, com.baidu.tieba.tj4
        /* renamed from: r */
        public void f(bl4 bl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, bl4Var) == null) {
                String l0 = this.a.l0();
                if (cf2.C) {
                    hx2.d(l0).e().d(1);
                }
                super.f(bl4Var);
                if (cf2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": main onDownloading");
                }
                this.a.D0(bl4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qj4, com.baidu.tieba.tj4
        /* renamed from: s */
        public wk4 h(bl4 bl4Var, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{bl4Var, file, Long.valueOf(j), readableByteChannel})) == null) {
                String l0 = this.a.l0();
                if (cf2.C) {
                    hx2.d(l0).f(bl4Var.toString()).d(1);
                }
                C0268a c0268a = new C0268a(this);
                Bundle bundle = new Bundle();
                bundle.putLong("length", j);
                bundle.putFloat("progress_granularity", 0.1f);
                av2 av2Var = new av2();
                av2Var.u(c0268a);
                av2Var.K(bundle);
                av2Var.J(new zu2(bl4Var, this.a));
                av2Var.J(new xu2(bl4Var.m, this.a));
                av2Var.M(readableByteChannel);
                boolean N = av2Var.N();
                av2Var.o(c0268a);
                if (cf2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": onProcessStream: installOk=" + N);
                }
                if (N) {
                    c92.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    gs4.L(file);
                }
                if (N) {
                    return new wk4(2300, "业务层处理下载流成功");
                }
                return new wk4(2301, "业务层处理下载流失败");
            }
            return (wk4) invokeCommon.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ vq3 b;

        public b(cf2 cf2Var, Collection collection, vq3 vq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf2Var, collection, vq3Var};
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
            this.b = vq3Var;
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
    public class c implements vq3<lf2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vq3 a;
        public final /* synthetic */ cf2 b;

        public c(cf2 cf2Var, vq3 vq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf2Var, vq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cf2Var;
            this.a = vq3Var;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.baidu.tieba.cf2.Q(com.baidu.tieba.cf2, java.util.Collection, java.lang.Object):com.baidu.tieba.cf2
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
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(com.baidu.tieba.lf2 r5) {
            /*
                r4 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tieba.cf2.c.$ic
                if (r0 != 0) goto L13
            L4:
                com.baidu.tieba.vq3 r0 = r4.a
                r0.a(r5)
                com.baidu.tieba.cf2 r0 = r4.b
                java.util.Set r1 = com.baidu.tieba.cf2.P(r0)
                com.baidu.tieba.cf2.Q(r0, r1, r5)
                return
            L13:
                r2 = r0
                r3 = 1048577(0x100001, float:1.46937E-39)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r2.invokeL(r3, r4, r5)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.cf2.c.a(com.baidu.tieba.lf2):void");
        }
    }

    /* loaded from: classes5.dex */
    public class d implements vq3<lf2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vn3 a;
        public final /* synthetic */ boolean b;

        public d(cf2 cf2Var, vn3 vn3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf2Var, vn3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vn3Var;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(lf2 lf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lf2Var) == null) {
                lf2Var.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements vq3<lf2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public e(cf2 cf2Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf2Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(lf2 lf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lf2Var) == null) {
                lf2Var.b(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements ye2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bl4 a;
        public final /* synthetic */ cf2 b;

        public f(cf2 cf2Var, bl4 bl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf2Var, bl4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cf2Var;
            this.a = bl4Var;
        }

        @Override // com.baidu.tieba.ye2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                cf2 cf2Var = this.b;
                bl4 bl4Var = this.a;
                cf2Var.j = bl4Var;
                cf2Var.i.m(bl4Var);
                if (this.b.d != null) {
                    this.b.d.onNext(this.a);
                    this.b.d.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.ye2.c
        public void b(PMSDownloadType pMSDownloadType, vn3 vn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, vn3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, vn3Var));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements ye2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cl4 a;
        public final /* synthetic */ cf2 b;

        public g(cf2 cf2Var, cl4 cl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf2Var, cl4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cf2Var;
            this.a = cl4Var;
        }

        @Override // com.baidu.tieba.ye2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                cf2 cf2Var = this.b;
                if (cf2Var.k == null) {
                    cf2Var.k = new ArrayList();
                }
                cl4 cl4Var = this.a;
                cf2 cf2Var2 = this.b;
                cl4Var.o = cf2Var2.o;
                cf2Var2.k.add(cl4Var);
                this.b.i.m(this.a);
                if (this.b.e != null) {
                    this.b.e.onNext(this.a);
                    if (!this.b.i.i()) {
                        this.b.e.onCompleted();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ye2.c
        public void b(PMSDownloadType pMSDownloadType, vn3 vn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, vn3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.e != null) {
                    this.b.e.onError(new PkgDownloadError(this.a, vn3Var));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements ye2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zk4 a;
        public final /* synthetic */ cf2 b;

        public h(cf2 cf2Var, zk4 zk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf2Var, zk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cf2Var;
            this.a = zk4Var;
        }

        @Override // com.baidu.tieba.ye2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                cf2 cf2Var = this.b;
                zk4 zk4Var = this.a;
                cf2Var.l = zk4Var;
                cf2Var.i.m(zk4Var);
                if (this.b.f != null) {
                    this.b.f.onNext(this.a);
                    this.b.f.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.ye2.c
        public void b(PMSDownloadType pMSDownloadType, vn3 vn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, vn3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.f != null) {
                    this.b.f.onError(new PkgDownloadError(this.a, vn3Var));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements ye2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk4 a;
        public final /* synthetic */ cf2 b;

        public i(cf2 cf2Var, xk4 xk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf2Var, xk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cf2Var;
            this.a = xk4Var;
        }

        @Override // com.baidu.tieba.ye2.c
        public void b(PMSDownloadType pMSDownloadType, vn3 vn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, vn3Var) == null) {
                c92.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + vn3Var.toString());
                this.b.i.l(this.a);
                this.b.q0(this.a);
            }
        }

        @Override // com.baidu.tieba.ye2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                c92.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                cf2 cf2Var = this.b;
                xk4 xk4Var = this.a;
                cf2Var.m = xk4Var;
                cf2Var.i.m(xk4Var);
                this.b.q0(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j extends dtb<al4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf2 e;

        public j(cf2 cf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = cf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ysb
        /* renamed from: g */
        public void onNext(al4 al4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, al4Var) == null) {
                c92.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 单个包下载、业务层处理完成：" + al4Var.i);
            }
        }

        @Override // com.baidu.tieba.ysb
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                c92.l("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载OnError", th);
                this.e.w0(th);
            }
        }

        @Override // com.baidu.tieba.ysb
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c92.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载onCompleted");
                this.e.v0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements xsb.a<bl4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf2 a;

        public k(cf2 cf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xsb.a, com.baidu.tieba.ltb
        public void call(dtb<? super bl4> dtbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dtbVar) != null) {
                return;
            }
            this.a.d = dtbVar;
        }
    }

    /* loaded from: classes5.dex */
    public class l implements xsb.a<cl4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf2 a;

        public l(cf2 cf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xsb.a, com.baidu.tieba.ltb
        public void call(dtb<? super cl4> dtbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dtbVar) != null) {
                return;
            }
            this.a.e = dtbVar;
        }
    }

    /* loaded from: classes5.dex */
    public class m implements xsb.a<zk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf2 a;

        public m(cf2 cf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xsb.a, com.baidu.tieba.ltb
        public void call(dtb<? super zk4> dtbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dtbVar) != null) {
                return;
            }
            this.a.f = dtbVar;
        }
    }

    /* loaded from: classes5.dex */
    public class n implements xsb.a<xk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf2 a;

        public n(cf2 cf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xsb.a, com.baidu.tieba.ltb
        public void call(dtb<? super xk4> dtbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dtbVar) != null) {
                return;
            }
            this.a.g = dtbVar;
        }
    }

    /* loaded from: classes5.dex */
    public class o implements xsb.a<dl4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf2 a;

        public o(cf2 cf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xsb.a, com.baidu.tieba.ltb
        public void call(dtb<? super dl4> dtbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dtbVar) != null) {
                return;
            }
            this.a.h = dtbVar;
        }
    }

    /* loaded from: classes5.dex */
    public class p extends jf2<cf2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(cf2 cf2Var, cf2 cf2Var2) {
            super(cf2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf2Var, cf2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((gf2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf2, com.baidu.tieba.qj4, com.baidu.tieba.tj4
        /* renamed from: s */
        public void c(cl4 cl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, cl4Var) == null) {
                super.c(cl4Var);
                c92.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qj4, com.baidu.tieba.tj4
        /* renamed from: u */
        public void f(cl4 cl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cl4Var) == null) {
                super.f(cl4Var);
                this.c.E0(cl4Var);
            }
        }

        @Override // com.baidu.tieba.jf2, com.baidu.tieba.qj4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.c.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.jf2
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.c.o;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.jf2
        public void p(@NonNull cl4 cl4Var, @Nullable vn3 vn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, cl4Var, vn3Var) == null) {
                super.p(cl4Var, vn3Var);
                c92.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + cl4Var.i);
                cf2 cf2Var = this.c;
                if (cf2Var.k == null) {
                    cf2Var.k = new ArrayList();
                }
                cf2 cf2Var2 = this.c;
                cl4Var.o = cf2Var2.o;
                if (vn3Var == null) {
                    cf2Var2.k.add(cl4Var);
                    this.c.i.m(cl4Var);
                    ye2.c().b(cl4Var, this.c.k0());
                } else {
                    cf2Var2.i.l(cl4Var);
                    ye2.c().a(cl4Var, this.c.k0(), vn3Var);
                }
                if (this.c.e != null) {
                    this.c.e.onNext(cl4Var);
                    if (!this.c.i.i()) {
                        this.c.e.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qj4, com.baidu.tieba.tj4
        /* renamed from: q */
        public void e(cl4 cl4Var, wk4 wk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, cl4Var, wk4Var) == null) {
                super.q(cl4Var, wk4Var);
                c92.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + wk4Var.toString());
                this.c.i.l(cl4Var);
                vn3 vn3Var = new vn3();
                vn3Var.k(12L);
                vn3Var.i(wk4Var.a);
                vn3Var.d("分包下载失败");
                vn3Var.f(wk4Var.toString());
                if (this.c.e != null) {
                    this.c.e.onError(new PkgDownloadError(cl4Var, vn3Var));
                }
                ye2.c().a(cl4Var, this.c.k0(), vn3Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q extends hf2<cf2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(cf2 cf2Var, cf2 cf2Var2) {
            super(cf2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf2Var, cf2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((gf2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cf2Var;
        }

        @Override // com.baidu.tieba.hf2
        public void u(dl4 dl4Var, vn3 vn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, dl4Var, vn3Var) == null) {
                c92.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + vn3Var);
                this.b.i.l(dl4Var);
                if (this.b.h != null) {
                    this.b.h.onError(new PkgDownloadError(dl4Var, vn3Var));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf2, com.baidu.tieba.qj4, com.baidu.tieba.tj4
        /* renamed from: v */
        public void c(dl4 dl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, dl4Var) == null) {
                super.c(dl4Var);
                c92.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.qj4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.hf2
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.b.k0();
            }
            return (PMSDownloadType) invokeV.objValue;
        }

        @Override // com.baidu.tieba.hf2
        public void r(@NonNull dl4 dl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dl4Var) == null) {
                this.b.i.m(dl4Var);
                if (this.b.h != null) {
                    this.b.h.onNext(dl4Var);
                    if (!this.b.i.c()) {
                        this.b.h.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf2, com.baidu.tieba.qj4, com.baidu.tieba.tj4
        /* renamed from: w */
        public void f(dl4 dl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, dl4Var) == null) {
                super.f(dl4Var);
                if (cf2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.b.i0() + ": dependent onDownloading");
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r extends qj4<zk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf2 a;

        public r(cf2 cf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tj4
        /* renamed from: l */
        public String d(zk4 zk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, zk4Var)) == null) {
                int i = zk4Var.h;
                if (i == 0) {
                    return uf2.h();
                }
                if (i == 1) {
                    return uf2.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qj4, com.baidu.tieba.tj4
        /* renamed from: q */
        public void c(zk4 zk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, zk4Var) == null) {
                super.c(zk4Var);
                c92.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.vj4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.qj4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qj4, com.baidu.tieba.tj4
        /* renamed from: o */
        public void e(zk4 zk4Var, wk4 wk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zk4Var, wk4Var) == null) {
                super.e(zk4Var, wk4Var);
                c92.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + wk4Var.toString());
                this.a.i.l(zk4Var);
                vn3 vn3Var = new vn3();
                vn3Var.k(13L);
                vn3Var.i(wk4Var.a);
                vn3Var.d("Framework包下载失败");
                vn3Var.f(wk4Var.toString());
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(zk4Var, vn3Var));
                }
                ye2.c().a(zk4Var, this.a.k0(), vn3Var);
                gs4.k(zk4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qj4, com.baidu.tieba.tj4
        /* renamed from: p */
        public void i(zk4 zk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, zk4Var) == null) {
                super.i(zk4Var);
                c92.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + zk4Var.i);
                vn3 y0 = this.a.y0(zk4Var);
                if (y0 == null) {
                    cf2 cf2Var = this.a;
                    cf2Var.l = zk4Var;
                    cf2Var.i.m(zk4Var);
                    if (this.a.f != null) {
                        this.a.f.onNext(zk4Var);
                        this.a.f.onCompleted();
                    }
                    ye2.c().b(zk4Var, this.a.k0());
                    return;
                }
                this.a.i.l(zk4Var);
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(zk4Var, y0));
                }
                ye2.c().a(zk4Var, this.a.k0(), y0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qj4, com.baidu.tieba.tj4
        /* renamed from: r */
        public void f(zk4 zk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, zk4Var) == null) {
                super.f(zk4Var);
                if (cf2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": framework onDownloading");
                }
                this.a.C0(zk4Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s extends qj4<xk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf2 a;

        public s(cf2 cf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tj4
        /* renamed from: l */
        public String d(xk4 xk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, xk4Var)) == null) {
                int i = xk4Var.h;
                if (i == 0) {
                    return uf2.d();
                }
                if (i == 1) {
                    return uf2.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qj4, com.baidu.tieba.tj4
        /* renamed from: q */
        public void c(xk4 xk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, xk4Var) == null) {
                super.c(xk4Var);
                c92.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.vj4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.qj4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qj4, com.baidu.tieba.tj4
        /* renamed from: o */
        public void e(xk4 xk4Var, wk4 wk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xk4Var, wk4Var) == null) {
                super.e(xk4Var, wk4Var);
                c92.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + wk4Var.toString());
                this.a.i.l(xk4Var);
                vn3 vn3Var = new vn3();
                vn3Var.k(14L);
                vn3Var.i(wk4Var.a);
                vn3Var.d("Extension下载失败");
                vn3Var.f(wk4Var.toString());
                if (cf2.C) {
                    Log.e("SwanAppPkgDownloadCallback", vn3Var.toString());
                }
                this.a.q0(xk4Var);
                ye2.c().a(xk4Var, this.a.k0(), vn3Var);
                gs4.k(xk4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qj4, com.baidu.tieba.tj4
        /* renamed from: p */
        public void i(xk4 xk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, xk4Var) == null) {
                super.i(xk4Var);
                c92.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + xk4Var.i);
                vn3 x0 = this.a.x0(xk4Var);
                if (x0 == null) {
                    cf2 cf2Var = this.a;
                    cf2Var.m = xk4Var;
                    cf2Var.i.m(xk4Var);
                    this.a.q0(xk4Var);
                    ye2.c().b(xk4Var, this.a.k0());
                    return;
                }
                if (cf2.C) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + xk4Var.toString());
                }
                this.a.i.l(xk4Var);
                this.a.q0(xk4Var);
                ye2.c().a(xk4Var, this.a.k0(), x0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qj4, com.baidu.tieba.tj4
        /* renamed from: r */
        public void f(xk4 xk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, xk4Var) == null) {
                super.f(xk4Var);
                if (cf2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": extension onDownloading");
                }
                this.a.B0(xk4Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements wj4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf2 a;

        public t(cf2 cf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cf2Var;
        }

        @Override // com.baidu.tieba.wj4
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (cf2.C) {
                    Log.e("SwanAppPkgDownloadCallback", this.a.i0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                cf2 cf2Var = this.a;
                cf2Var.n = pMSAppInfo;
                if (pMSAppInfo != null) {
                    cf2Var.o0(pMSAppInfo);
                    a83.k(this.a.n.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements vq3<vq3<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public u(cf2 cf2Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf2Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(vq3<PMSAppInfo> vq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vq3Var) == null) {
                vq3Var.a(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public v(cf2 cf2Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf2Var, collection, obj};
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

        public w(cf2 cf2Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf2Var, collection, obj};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947672762, "Lcom/baidu/tieba/cf2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947672762, "Lcom/baidu/tieba/cf2;");
                return;
            }
        }
        C = ms1.a;
    }

    @Override // com.baidu.tieba.xj4
    public tj4<cl4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.w;
        }
        return (tj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xj4
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    @Override // com.baidu.tieba.xj4
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
            return yj4.b(this, "get_launch_id").getString("launch_id", "");
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xj4
    public wj4 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.A;
        }
        return (wj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xj4
    public tj4<dl4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.x;
        }
        return (tj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xj4
    public tj4<xk4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.z;
        }
        return (tj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xj4
    public tj4<zk4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.y;
        }
        return (tj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xj4
    public tj4<bl4> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.v;
        }
        return (tj4) invokeV.objValue;
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            c92.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public cf2(String str) {
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
        this.u = new fq3();
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

    @Override // com.baidu.tieba.xj4
    public void G(kp4 kp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, kp4Var) == null) {
            super.G(kp4Var);
            this.r = System.currentTimeMillis();
            if (C) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.r);
            }
            if (kp4Var == null) {
                return;
            }
            if (C) {
                Log.i("SwanAppPkgDownloadCallback", i0() + ": onPrepareDownload: countSet=" + kp4Var.n());
            }
            this.p.add(new UbcFlowEvent("na_pms_start_download"));
            this.i = kp4Var;
            if (!kp4Var.k()) {
                n0();
            }
        }
    }

    public vn3 y0(zk4 zk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, zk4Var)) == null) {
            if (C) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + zk4Var);
            }
            ml3.b c2 = ml3.c(zk4Var, zk4Var.h);
            if (!TextUtils.isEmpty(zk4Var.a)) {
                c92.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + zk4Var.a);
                gs4.k(zk4Var.a);
            }
            if (!c2.c()) {
                vn3 vn3Var = new vn3();
                vn3Var.k(13L);
                vn3Var.b(2907L);
                vn3Var.d("Core包更新失败");
                return vn3Var;
            }
            return null;
        }
        return (vn3) invokeL.objValue;
    }

    public final void B0(xk4 xk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xk4Var) == null) {
            ye2.c().d(xk4Var, new i(this, xk4Var));
        }
    }

    public final void C0(zk4 zk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, zk4Var) == null) {
            ye2.c().d(zk4Var, new h(this, zk4Var));
        }
    }

    public final void D0(bl4 bl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bl4Var) == null) {
            ye2.c().d(bl4Var, new f(this, bl4Var));
        }
    }

    public final void E0(cl4 cl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cl4Var) == null) {
            ye2.c().d(cl4Var, new g(this, cl4Var));
        }
    }

    public cf2 e0(vq3<PMSAppInfo> vq3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, vq3Var)) == null) {
            f0(this.t, vq3Var);
            return this;
        }
        return (cf2) invokeL.objValue;
    }

    public synchronized cf2 g0(lf2 lf2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, lf2Var)) == null) {
            synchronized (this) {
                f0(this.s, lf2Var);
            }
            return this;
        }
        return (cf2) invokeL.objValue;
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 == 1013) {
                zj4.i().z(this.o, i2);
            } else {
                zj4.i().z(this.o, 0);
            }
        }
    }

    public cf2 o0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, pMSAppInfo)) == null) {
            p0(this.t, new u(this, pMSAppInfo));
            return this;
        }
        return (cf2) invokeL.objValue;
    }

    public final void q0(xk4 xk4Var) {
        dtb<? super xk4> dtbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, xk4Var) == null) && (dtbVar = this.g) != null) {
            dtbVar.onNext(xk4Var);
            this.g.onCompleted();
        }
    }

    public cf2 r0(@NonNull vq3<lf2> vq3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, vq3Var)) == null) {
            p0(this.s, new c(this, vq3Var));
            return this;
        }
        return (cf2) invokeL.objValue;
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
            v63.a(this.o, str, this.p, str2);
            this.p.clear();
        }
    }

    public final synchronized <CallbackT> cf2 f0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (cf2) invokeLL.objValue;
    }

    public final synchronized <CallbackT> cf2 h0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (cf2) invokeLL.objValue;
    }

    public final synchronized <CallbackT> cf2 p0(@NonNull Collection<CallbackT> collection, @NonNull vq3<CallbackT> vq3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, collection, vq3Var)) == null) {
            synchronized (this) {
                this.u.a(new b(this, collection, vq3Var));
            }
            return this;
        }
        return (cf2) invokeLL.objValue;
    }

    public void t0(boolean z, vn3 vn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, vn3Var) == null) {
            r0(new d(this, vn3Var, z));
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
    public static /* synthetic */ com.baidu.tieba.cf2 Q(com.baidu.tieba.cf2 r0, java.util.Collection r1, java.lang.Object r2) {
        /*
            r0.h0(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.cf2.Q(com.baidu.tieba.cf2, java.util.Collection, java.lang.Object):com.baidu.tieba.cf2");
    }

    @Override // com.baidu.tieba.xj4
    public void C(wk4 wk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, wk4Var) == null) {
            c92.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + wk4Var);
            if (wk4Var != null && wk4Var.a == 1010) {
                G0();
            }
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public vn3 z0(bl4 bl4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, bl4Var)) == null) {
            if (bl4Var == null) {
                vn3 vn3Var = new vn3();
                vn3Var.k(11L);
                vn3Var.i(2310L);
                vn3Var.f("pkg info is empty");
                zn3.a().f(vn3Var);
                return vn3Var;
            }
            return null;
        }
        return (vn3) invokeL.objValue;
    }

    public vn3 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PMSAppInfo pMSAppInfo = this.n;
            if (pMSAppInfo == null) {
                if (this.j == null) {
                    vn3 vn3Var = new vn3();
                    vn3Var.k(10L);
                    vn3Var.i(2903L);
                    vn3Var.d("Server未返回主包&AppInfo");
                    return vn3Var;
                }
                PMSAppInfo u2 = zj4.i().u(this.o);
                if (u2 == null) {
                    vn3 vn3Var2 = new vn3();
                    vn3Var2.k(10L);
                    vn3Var2.i(2904L);
                    vn3Var2.d("Server未返回AppInfo数据，本地也没有数据");
                    return vn3Var2;
                }
                this.n = u2;
                uf2.k(u2, this.j);
                this.n.initMaxAgeInfo();
                this.n.updateInstallSrc(J());
                if (zj4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                    return null;
                }
                vn3 vn3Var3 = new vn3();
                vn3Var3.k(10L);
                vn3Var3.i(2906L);
                vn3Var3.d("更新DB失败");
                return vn3Var3;
            }
            bl4 bl4Var = this.j;
            if (bl4Var != null) {
                uf2.k(pMSAppInfo, bl4Var);
            } else if (vf2.f(this.k)) {
                cl4 cl4Var = this.k.get(0);
                this.q = cl4Var;
                cl4Var.o = this.o;
                uf2.l(this.n, cl4Var);
            } else {
                PMSAppInfo u3 = zj4.i().u(this.o);
                if (u3 == null) {
                    vn3 vn3Var4 = new vn3();
                    vn3Var4.k(10L);
                    vn3Var4.i(2905L);
                    vn3Var4.d("Server未返回包数据，本地也没有数据");
                    return vn3Var4;
                }
                PMSAppInfo pMSAppInfo2 = this.n;
                pMSAppInfo2.appId = this.o;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.n.initMaxAgeInfo();
            this.n.updateInstallSrc(J());
            if (zj4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                uf2.o(this.n);
                return null;
            }
            vn3 vn3Var5 = new vn3();
            vn3Var5.k(10L);
            vn3Var5.i(2906L);
            vn3Var5.d("更新DB失败");
            return vn3Var5;
        }
        return (vn3) invokeV.objValue;
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PMSAppInfo u2 = zj4.i().u(this.o);
            c92.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(J());
                bl4 bl4Var = this.j;
                if (bl4Var != null) {
                    bl4Var.c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.n;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(J());
                }
                zj4.i().l(u2);
            }
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.i.f()) {
                arrayList.add(xsb.d(new k(this)));
            }
            if (this.i.h()) {
                arrayList.add(xsb.d(new l(this)));
            }
            if (this.i.e()) {
                arrayList.add(xsb.d(new m(this)));
            }
            if (this.i.d()) {
                arrayList.add(xsb.d(new n(this)));
            }
            if (this.i.b()) {
                arrayList.add(xsb.d(new o(this)));
            }
            if (!arrayList.isEmpty()) {
                xsb.q(arrayList).D(this.B);
            }
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048609, this) != null) || this.n == null) {
            return;
        }
        PMSAppInfo u2 = zj4.i().u(this.o);
        if (u2 == null) {
            c92.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.n.appId = this.o;
        u2.updateInstallSrc(J());
        this.n.copyLocalAppInfoData(u2);
        this.n.initMaxAgeInfo();
        if (zj4.i().l(this.n)) {
            uf2.o(this.n);
        }
    }

    public vn3 x0(xk4 xk4Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, xk4Var)) == null) {
            in2 in2Var = new in2();
            in2Var.b = xk4Var.i;
            in2Var.a = xk4Var.j;
            in2Var.c = xk4Var.a;
            in2Var.d = xk4Var.m;
            if (lm2.b(xk4Var.h, in2Var) == null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                vn3 vn3Var = new vn3();
                vn3Var.k(14L);
                vn3Var.b(2908L);
                vn3Var.d("Extension包更新失败");
                return vn3Var;
            }
            return null;
        }
        return (vn3) invokeL.objValue;
    }
}
