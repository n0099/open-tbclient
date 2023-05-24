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
import com.baidu.tieba.cc2;
import com.baidu.tieba.i7b;
import com.baidu.tieba.k93;
import com.baidu.tieba.qi3;
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
public abstract class gc2 extends kc2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public ah4 A;
    public o7b<ei4> B;
    public String c;
    public o7b<? super fi4> d;
    public o7b<? super gi4> e;
    public o7b<? super di4> f;
    public o7b<? super bi4> g;
    public o7b<? super hi4> h;
    public om4 i;
    public fi4 j;
    public List<gi4> k;
    public di4 l;
    public bi4 m;
    public PMSAppInfo n;
    public String o;
    public List<UbcFlowEvent> p;
    public gi4 q;
    public long r;
    public final Set<pc2> s;
    public final Set<zn3<PMSAppInfo>> t;
    public final jn3 u;
    public xg4<fi4> v;
    public xg4<gi4> w;
    public final xg4<hi4> x;
    public xg4<di4> y;
    public xg4<bi4> z;

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
    public class a extends ug4<fi4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gc2 a;

        /* renamed from: com.baidu.tieba.gc2$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0310a implements zn3<k93.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0310a(a aVar) {
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
            @Override // com.baidu.tieba.zn3
            /* renamed from: b */
            public void a(k93.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.b)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    ch4.a(this.a.a, bundle, "event_performance_ubc");
                }
            }
        }

        public a(gc2 gc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xg4
        /* renamed from: l */
        public String d(fi4 fi4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, fi4Var)) == null) {
                int i = fi4Var.h;
                if (i == 0) {
                    return yc2.g();
                }
                if (i == 1) {
                    return yc2.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: q */
        public void c(fi4 fi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048587, this, fi4Var) != null) {
                return;
            }
            String l0 = this.a.l0();
            if (gc2.C) {
                lu2.d(l0).e().d(1);
            }
            super.c(fi4Var);
            g62.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        @Override // com.baidu.tieba.zg4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.ug4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: o */
        public void e(fi4 fi4Var, ai4 ai4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, fi4Var, ai4Var) == null) {
                super.e(fi4Var, ai4Var);
                g62.k("SwanAppPkgDownloadCallback", "onDownloadError：" + ai4Var.toString());
                this.a.i.l(fi4Var);
                zk3 zk3Var = new zk3();
                zk3Var.k(11L);
                zk3Var.i(ai4Var.a);
                zk3Var.d("主包下载失败");
                zk3Var.f(ai4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(fi4Var, zk3Var));
                }
                cc2.c().a(fi4Var, this.a.k0(), zk3Var);
                kp4.k(fi4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: p */
        public void i(fi4 fi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, fi4Var) == null) {
                String l0 = this.a.l0();
                if (gc2.C) {
                    lu2.d(l0).e().d(1);
                }
                super.i(fi4Var);
                this.a.p.add(new UbcFlowEvent("na_pms_end_download"));
                zk3 z0 = this.a.z0(fi4Var);
                g62.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + fi4Var.i);
                if (z0 == null) {
                    gc2 gc2Var = this.a;
                    gc2Var.j = fi4Var;
                    gc2Var.i.m(fi4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(fi4Var);
                        if (gc2.C) {
                            Log.d("SwanAppPkgDownloadCallback", this.a.i0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.a.d.onCompleted();
                    }
                    cc2.c().b(fi4Var, this.a.k0());
                    return;
                }
                this.a.i.l(fi4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(fi4Var, z0));
                }
                cc2.c().a(fi4Var, this.a.k0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: r */
        public void f(fi4 fi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, fi4Var) == null) {
                String l0 = this.a.l0();
                if (gc2.C) {
                    lu2.d(l0).e().d(1);
                }
                super.f(fi4Var);
                if (gc2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": main onDownloading");
                }
                this.a.D0(fi4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: s */
        public ai4 h(fi4 fi4Var, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{fi4Var, file, Long.valueOf(j), readableByteChannel})) == null) {
                String l0 = this.a.l0();
                if (gc2.C) {
                    lu2.d(l0).f(fi4Var.toString()).d(1);
                }
                C0310a c0310a = new C0310a(this);
                Bundle bundle = new Bundle();
                bundle.putLong("length", j);
                bundle.putFloat("progress_granularity", 0.1f);
                es2 es2Var = new es2();
                es2Var.u(c0310a);
                es2Var.K(bundle);
                es2Var.J(new ds2(fi4Var, this.a));
                es2Var.J(new bs2(fi4Var.m, this.a));
                es2Var.M(readableByteChannel);
                boolean N = es2Var.N();
                es2Var.o(c0310a);
                if (gc2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": onProcessStream: installOk=" + N);
                }
                if (N) {
                    g62.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    kp4.L(file);
                }
                if (N) {
                    return new ai4(2300, "业务层处理下载流成功");
                }
                return new ai4(2301, "业务层处理下载流失败");
            }
            return (ai4) invokeCommon.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ zn3 b;

        public b(gc2 gc2Var, Collection collection, zn3 zn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc2Var, collection, zn3Var};
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
            this.b = zn3Var;
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
    public class c implements zn3<pc2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zn3 a;
        public final /* synthetic */ gc2 b;

        public c(gc2 gc2Var, zn3 zn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc2Var, zn3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gc2Var;
            this.a = zn3Var;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.baidu.tieba.gc2.Q(com.baidu.tieba.gc2, java.util.Collection, java.lang.Object):com.baidu.tieba.gc2
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
        @Override // com.baidu.tieba.zn3
        /* renamed from: b */
        public void a(com.baidu.tieba.pc2 r5) {
            /*
                r4 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tieba.gc2.c.$ic
                if (r0 != 0) goto L13
            L4:
                com.baidu.tieba.zn3 r0 = r4.a
                r0.a(r5)
                com.baidu.tieba.gc2 r0 = r4.b
                java.util.Set r1 = com.baidu.tieba.gc2.P(r0)
                com.baidu.tieba.gc2.Q(r0, r1, r5)
                return
            L13:
                r2 = r0
                r3 = 1048577(0x100001, float:1.46937E-39)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r2.invokeL(r3, r4, r5)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.gc2.c.a(com.baidu.tieba.pc2):void");
        }
    }

    /* loaded from: classes5.dex */
    public class d implements zn3<pc2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zk3 a;
        public final /* synthetic */ boolean b;

        public d(gc2 gc2Var, zk3 zk3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc2Var, zk3Var, Boolean.valueOf(z)};
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
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zn3
        /* renamed from: b */
        public void a(pc2 pc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pc2Var) == null) {
                pc2Var.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements zn3<pc2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public e(gc2 gc2Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc2Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.zn3
        /* renamed from: b */
        public void a(pc2 pc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pc2Var) == null) {
                pc2Var.b(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements cc2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fi4 a;
        public final /* synthetic */ gc2 b;

        public f(gc2 gc2Var, fi4 fi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc2Var, fi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gc2Var;
            this.a = fi4Var;
        }

        @Override // com.baidu.tieba.cc2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                gc2 gc2Var = this.b;
                fi4 fi4Var = this.a;
                gc2Var.j = fi4Var;
                gc2Var.i.m(fi4Var);
                if (this.b.d != null) {
                    this.b.d.onNext(this.a);
                    this.b.d.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.cc2.c
        public void b(PMSDownloadType pMSDownloadType, zk3 zk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, zk3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, zk3Var));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements cc2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gi4 a;
        public final /* synthetic */ gc2 b;

        public g(gc2 gc2Var, gi4 gi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc2Var, gi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gc2Var;
            this.a = gi4Var;
        }

        @Override // com.baidu.tieba.cc2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                gc2 gc2Var = this.b;
                if (gc2Var.k == null) {
                    gc2Var.k = new ArrayList();
                }
                gi4 gi4Var = this.a;
                gc2 gc2Var2 = this.b;
                gi4Var.o = gc2Var2.o;
                gc2Var2.k.add(gi4Var);
                this.b.i.m(this.a);
                if (this.b.e != null) {
                    this.b.e.onNext(this.a);
                    if (!this.b.i.i()) {
                        this.b.e.onCompleted();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.cc2.c
        public void b(PMSDownloadType pMSDownloadType, zk3 zk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, zk3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.e != null) {
                    this.b.e.onError(new PkgDownloadError(this.a, zk3Var));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements cc2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ di4 a;
        public final /* synthetic */ gc2 b;

        public h(gc2 gc2Var, di4 di4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc2Var, di4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gc2Var;
            this.a = di4Var;
        }

        @Override // com.baidu.tieba.cc2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                gc2 gc2Var = this.b;
                di4 di4Var = this.a;
                gc2Var.l = di4Var;
                gc2Var.i.m(di4Var);
                if (this.b.f != null) {
                    this.b.f.onNext(this.a);
                    this.b.f.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.cc2.c
        public void b(PMSDownloadType pMSDownloadType, zk3 zk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, zk3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.f != null) {
                    this.b.f.onError(new PkgDownloadError(this.a, zk3Var));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements cc2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bi4 a;
        public final /* synthetic */ gc2 b;

        public i(gc2 gc2Var, bi4 bi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc2Var, bi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gc2Var;
            this.a = bi4Var;
        }

        @Override // com.baidu.tieba.cc2.c
        public void b(PMSDownloadType pMSDownloadType, zk3 zk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, zk3Var) == null) {
                g62.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + zk3Var.toString());
                this.b.i.l(this.a);
                this.b.q0(this.a);
            }
        }

        @Override // com.baidu.tieba.cc2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                g62.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                gc2 gc2Var = this.b;
                bi4 bi4Var = this.a;
                gc2Var.m = bi4Var;
                gc2Var.i.m(bi4Var);
                this.b.q0(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j extends o7b<ei4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gc2 e;

        public j(gc2 gc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = gc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.j7b
        /* renamed from: g */
        public void onNext(ei4 ei4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ei4Var) == null) {
                g62.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 单个包下载、业务层处理完成：" + ei4Var.i);
            }
        }

        @Override // com.baidu.tieba.j7b
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                g62.l("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载OnError", th);
                this.e.w0(th);
            }
        }

        @Override // com.baidu.tieba.j7b
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                g62.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载onCompleted");
                this.e.v0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements i7b.a<fi4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gc2 a;

        public k(gc2 gc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i7b.a, com.baidu.tieba.w7b
        public void call(o7b<? super fi4> o7bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, o7bVar) != null) {
                return;
            }
            this.a.d = o7bVar;
        }
    }

    /* loaded from: classes5.dex */
    public class l implements i7b.a<gi4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gc2 a;

        public l(gc2 gc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i7b.a, com.baidu.tieba.w7b
        public void call(o7b<? super gi4> o7bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, o7bVar) != null) {
                return;
            }
            this.a.e = o7bVar;
        }
    }

    /* loaded from: classes5.dex */
    public class m implements i7b.a<di4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gc2 a;

        public m(gc2 gc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i7b.a, com.baidu.tieba.w7b
        public void call(o7b<? super di4> o7bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, o7bVar) != null) {
                return;
            }
            this.a.f = o7bVar;
        }
    }

    /* loaded from: classes5.dex */
    public class n implements i7b.a<bi4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gc2 a;

        public n(gc2 gc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i7b.a, com.baidu.tieba.w7b
        public void call(o7b<? super bi4> o7bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, o7bVar) != null) {
                return;
            }
            this.a.g = o7bVar;
        }
    }

    /* loaded from: classes5.dex */
    public class o implements i7b.a<hi4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gc2 a;

        public o(gc2 gc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i7b.a, com.baidu.tieba.w7b
        public void call(o7b<? super hi4> o7bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, o7bVar) != null) {
                return;
            }
            this.a.h = o7bVar;
        }
    }

    /* loaded from: classes5.dex */
    public class p extends nc2<gc2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gc2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(gc2 gc2Var, gc2 gc2Var2) {
            super(gc2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc2Var, gc2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((kc2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nc2, com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: s */
        public void c(gi4 gi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, gi4Var) == null) {
                super.c(gi4Var);
                g62.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: u */
        public void f(gi4 gi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gi4Var) == null) {
                super.f(gi4Var);
                this.c.E0(gi4Var);
            }
        }

        @Override // com.baidu.tieba.nc2, com.baidu.tieba.ug4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.c.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.nc2
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.c.o;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.nc2
        public void p(@NonNull gi4 gi4Var, @Nullable zk3 zk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, gi4Var, zk3Var) == null) {
                super.p(gi4Var, zk3Var);
                g62.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + gi4Var.i);
                gc2 gc2Var = this.c;
                if (gc2Var.k == null) {
                    gc2Var.k = new ArrayList();
                }
                gc2 gc2Var2 = this.c;
                gi4Var.o = gc2Var2.o;
                if (zk3Var == null) {
                    gc2Var2.k.add(gi4Var);
                    this.c.i.m(gi4Var);
                    cc2.c().b(gi4Var, this.c.k0());
                } else {
                    gc2Var2.i.l(gi4Var);
                    cc2.c().a(gi4Var, this.c.k0(), zk3Var);
                }
                if (this.c.e != null) {
                    this.c.e.onNext(gi4Var);
                    if (!this.c.i.i()) {
                        this.c.e.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: q */
        public void e(gi4 gi4Var, ai4 ai4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, gi4Var, ai4Var) == null) {
                super.q(gi4Var, ai4Var);
                g62.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + ai4Var.toString());
                this.c.i.l(gi4Var);
                zk3 zk3Var = new zk3();
                zk3Var.k(12L);
                zk3Var.i(ai4Var.a);
                zk3Var.d("分包下载失败");
                zk3Var.f(ai4Var.toString());
                if (this.c.e != null) {
                    this.c.e.onError(new PkgDownloadError(gi4Var, zk3Var));
                }
                cc2.c().a(gi4Var, this.c.k0(), zk3Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q extends lc2<gc2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gc2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(gc2 gc2Var, gc2 gc2Var2) {
            super(gc2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc2Var, gc2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((kc2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gc2Var;
        }

        @Override // com.baidu.tieba.lc2
        public void u(hi4 hi4Var, zk3 zk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, hi4Var, zk3Var) == null) {
                g62.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + zk3Var);
                this.b.i.l(hi4Var);
                if (this.b.h != null) {
                    this.b.h.onError(new PkgDownloadError(hi4Var, zk3Var));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lc2, com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: v */
        public void c(hi4 hi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, hi4Var) == null) {
                super.c(hi4Var);
                g62.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.ug4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.lc2
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.b.k0();
            }
            return (PMSDownloadType) invokeV.objValue;
        }

        @Override // com.baidu.tieba.lc2
        public void r(@NonNull hi4 hi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, hi4Var) == null) {
                this.b.i.m(hi4Var);
                if (this.b.h != null) {
                    this.b.h.onNext(hi4Var);
                    if (!this.b.i.c()) {
                        this.b.h.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lc2, com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: w */
        public void f(hi4 hi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, hi4Var) == null) {
                super.f(hi4Var);
                if (gc2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.b.i0() + ": dependent onDownloading");
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r extends ug4<di4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gc2 a;

        public r(gc2 gc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xg4
        /* renamed from: l */
        public String d(di4 di4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, di4Var)) == null) {
                int i = di4Var.h;
                if (i == 0) {
                    return yc2.h();
                }
                if (i == 1) {
                    return yc2.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: q */
        public void c(di4 di4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, di4Var) == null) {
                super.c(di4Var);
                g62.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.zg4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.ug4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: o */
        public void e(di4 di4Var, ai4 ai4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, di4Var, ai4Var) == null) {
                super.e(di4Var, ai4Var);
                g62.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + ai4Var.toString());
                this.a.i.l(di4Var);
                zk3 zk3Var = new zk3();
                zk3Var.k(13L);
                zk3Var.i(ai4Var.a);
                zk3Var.d("Framework包下载失败");
                zk3Var.f(ai4Var.toString());
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(di4Var, zk3Var));
                }
                cc2.c().a(di4Var, this.a.k0(), zk3Var);
                kp4.k(di4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: p */
        public void i(di4 di4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, di4Var) == null) {
                super.i(di4Var);
                g62.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + di4Var.i);
                zk3 y0 = this.a.y0(di4Var);
                if (y0 == null) {
                    gc2 gc2Var = this.a;
                    gc2Var.l = di4Var;
                    gc2Var.i.m(di4Var);
                    if (this.a.f != null) {
                        this.a.f.onNext(di4Var);
                        this.a.f.onCompleted();
                    }
                    cc2.c().b(di4Var, this.a.k0());
                    return;
                }
                this.a.i.l(di4Var);
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(di4Var, y0));
                }
                cc2.c().a(di4Var, this.a.k0(), y0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: r */
        public void f(di4 di4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, di4Var) == null) {
                super.f(di4Var);
                if (gc2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": framework onDownloading");
                }
                this.a.C0(di4Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s extends ug4<bi4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gc2 a;

        public s(gc2 gc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xg4
        /* renamed from: l */
        public String d(bi4 bi4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bi4Var)) == null) {
                int i = bi4Var.h;
                if (i == 0) {
                    return yc2.d();
                }
                if (i == 1) {
                    return yc2.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: q */
        public void c(bi4 bi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, bi4Var) == null) {
                super.c(bi4Var);
                g62.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.zg4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.ug4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: o */
        public void e(bi4 bi4Var, ai4 ai4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bi4Var, ai4Var) == null) {
                super.e(bi4Var, ai4Var);
                g62.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + ai4Var.toString());
                this.a.i.l(bi4Var);
                zk3 zk3Var = new zk3();
                zk3Var.k(14L);
                zk3Var.i(ai4Var.a);
                zk3Var.d("Extension下载失败");
                zk3Var.f(ai4Var.toString());
                if (gc2.C) {
                    Log.e("SwanAppPkgDownloadCallback", zk3Var.toString());
                }
                this.a.q0(bi4Var);
                cc2.c().a(bi4Var, this.a.k0(), zk3Var);
                kp4.k(bi4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: p */
        public void i(bi4 bi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, bi4Var) == null) {
                super.i(bi4Var);
                g62.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + bi4Var.i);
                zk3 x0 = this.a.x0(bi4Var);
                if (x0 == null) {
                    gc2 gc2Var = this.a;
                    gc2Var.m = bi4Var;
                    gc2Var.i.m(bi4Var);
                    this.a.q0(bi4Var);
                    cc2.c().b(bi4Var, this.a.k0());
                    return;
                }
                if (gc2.C) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + bi4Var.toString());
                }
                this.a.i.l(bi4Var);
                this.a.q0(bi4Var);
                cc2.c().a(bi4Var, this.a.k0(), x0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: r */
        public void f(bi4 bi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, bi4Var) == null) {
                super.f(bi4Var);
                if (gc2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": extension onDownloading");
                }
                this.a.B0(bi4Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements ah4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gc2 a;

        public t(gc2 gc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gc2Var;
        }

        @Override // com.baidu.tieba.ah4
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (gc2.C) {
                    Log.e("SwanAppPkgDownloadCallback", this.a.i0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                gc2 gc2Var = this.a;
                gc2Var.n = pMSAppInfo;
                if (pMSAppInfo != null) {
                    gc2Var.o0(pMSAppInfo);
                    e53.k(this.a.n.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements zn3<zn3<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public u(gc2 gc2Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc2Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.zn3
        /* renamed from: b */
        public void a(zn3<PMSAppInfo> zn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zn3Var) == null) {
                zn3Var.a(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public v(gc2 gc2Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc2Var, collection, obj};
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

        public w(gc2 gc2Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc2Var, collection, obj};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947789043, "Lcom/baidu/tieba/gc2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947789043, "Lcom/baidu/tieba/gc2;");
                return;
            }
        }
        C = qp1.a;
    }

    @Override // com.baidu.tieba.bh4
    public xg4<gi4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.w;
        }
        return (xg4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bh4
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    @Override // com.baidu.tieba.bh4
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
            return ch4.b(this, "get_launch_id").getString("launch_id", "");
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bh4
    public ah4 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.A;
        }
        return (ah4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bh4
    public xg4<hi4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.x;
        }
        return (xg4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bh4
    public xg4<bi4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.z;
        }
        return (xg4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bh4
    public xg4<di4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.y;
        }
        return (xg4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bh4
    public xg4<fi4> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.v;
        }
        return (xg4) invokeV.objValue;
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            g62.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public gc2(String str) {
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
        this.u = new jn3();
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

    @Override // com.baidu.tieba.bh4
    public void G(om4 om4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, om4Var) == null) {
            super.G(om4Var);
            this.r = System.currentTimeMillis();
            if (C) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.r);
            }
            if (om4Var == null) {
                return;
            }
            if (C) {
                Log.i("SwanAppPkgDownloadCallback", i0() + ": onPrepareDownload: countSet=" + om4Var.n());
            }
            this.p.add(new UbcFlowEvent("na_pms_start_download"));
            this.i = om4Var;
            if (!om4Var.k()) {
                n0();
            }
        }
    }

    public zk3 y0(di4 di4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, di4Var)) == null) {
            if (C) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + di4Var);
            }
            qi3.b c2 = qi3.c(di4Var, di4Var.h);
            if (!TextUtils.isEmpty(di4Var.a)) {
                g62.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + di4Var.a);
                kp4.k(di4Var.a);
            }
            if (!c2.c()) {
                zk3 zk3Var = new zk3();
                zk3Var.k(13L);
                zk3Var.b(2907L);
                zk3Var.d("Core包更新失败");
                return zk3Var;
            }
            return null;
        }
        return (zk3) invokeL.objValue;
    }

    public final void B0(bi4 bi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bi4Var) == null) {
            cc2.c().d(bi4Var, new i(this, bi4Var));
        }
    }

    public final void C0(di4 di4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, di4Var) == null) {
            cc2.c().d(di4Var, new h(this, di4Var));
        }
    }

    public final void D0(fi4 fi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fi4Var) == null) {
            cc2.c().d(fi4Var, new f(this, fi4Var));
        }
    }

    public final void E0(gi4 gi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gi4Var) == null) {
            cc2.c().d(gi4Var, new g(this, gi4Var));
        }
    }

    public gc2 e0(zn3<PMSAppInfo> zn3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, zn3Var)) == null) {
            f0(this.t, zn3Var);
            return this;
        }
        return (gc2) invokeL.objValue;
    }

    public synchronized gc2 g0(pc2 pc2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, pc2Var)) == null) {
            synchronized (this) {
                f0(this.s, pc2Var);
            }
            return this;
        }
        return (gc2) invokeL.objValue;
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 == 1013) {
                dh4.i().z(this.o, i2);
            } else {
                dh4.i().z(this.o, 0);
            }
        }
    }

    public gc2 o0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, pMSAppInfo)) == null) {
            p0(this.t, new u(this, pMSAppInfo));
            return this;
        }
        return (gc2) invokeL.objValue;
    }

    public final void q0(bi4 bi4Var) {
        o7b<? super bi4> o7bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, bi4Var) == null) && (o7bVar = this.g) != null) {
            o7bVar.onNext(bi4Var);
            this.g.onCompleted();
        }
    }

    public gc2 r0(@NonNull zn3<pc2> zn3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, zn3Var)) == null) {
            p0(this.s, new c(this, zn3Var));
            return this;
        }
        return (gc2) invokeL.objValue;
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
            z33.a(this.o, str, this.p, str2);
            this.p.clear();
        }
    }

    public final synchronized <CallbackT> gc2 f0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (gc2) invokeLL.objValue;
    }

    public final synchronized <CallbackT> gc2 h0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (gc2) invokeLL.objValue;
    }

    public final synchronized <CallbackT> gc2 p0(@NonNull Collection<CallbackT> collection, @NonNull zn3<CallbackT> zn3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, collection, zn3Var)) == null) {
            synchronized (this) {
                this.u.a(new b(this, collection, zn3Var));
            }
            return this;
        }
        return (gc2) invokeLL.objValue;
    }

    public void t0(boolean z, zk3 zk3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, zk3Var) == null) {
            r0(new d(this, zk3Var, z));
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
    public static /* synthetic */ com.baidu.tieba.gc2 Q(com.baidu.tieba.gc2 r0, java.util.Collection r1, java.lang.Object r2) {
        /*
            r0.h0(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.gc2.Q(com.baidu.tieba.gc2, java.util.Collection, java.lang.Object):com.baidu.tieba.gc2");
    }

    @Override // com.baidu.tieba.bh4
    public void C(ai4 ai4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ai4Var) == null) {
            g62.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + ai4Var);
            if (ai4Var != null && ai4Var.a == 1010) {
                G0();
            }
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public zk3 z0(fi4 fi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, fi4Var)) == null) {
            if (fi4Var == null) {
                zk3 zk3Var = new zk3();
                zk3Var.k(11L);
                zk3Var.i(2310L);
                zk3Var.f("pkg info is empty");
                dl3.a().f(zk3Var);
                return zk3Var;
            }
            return null;
        }
        return (zk3) invokeL.objValue;
    }

    public zk3 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PMSAppInfo pMSAppInfo = this.n;
            if (pMSAppInfo == null) {
                if (this.j == null) {
                    zk3 zk3Var = new zk3();
                    zk3Var.k(10L);
                    zk3Var.i(2903L);
                    zk3Var.d("Server未返回主包&AppInfo");
                    return zk3Var;
                }
                PMSAppInfo u2 = dh4.i().u(this.o);
                if (u2 == null) {
                    zk3 zk3Var2 = new zk3();
                    zk3Var2.k(10L);
                    zk3Var2.i(2904L);
                    zk3Var2.d("Server未返回AppInfo数据，本地也没有数据");
                    return zk3Var2;
                }
                this.n = u2;
                yc2.k(u2, this.j);
                this.n.initMaxAgeInfo();
                this.n.updateInstallSrc(J());
                if (dh4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                    return null;
                }
                zk3 zk3Var3 = new zk3();
                zk3Var3.k(10L);
                zk3Var3.i(2906L);
                zk3Var3.d("更新DB失败");
                return zk3Var3;
            }
            fi4 fi4Var = this.j;
            if (fi4Var != null) {
                yc2.k(pMSAppInfo, fi4Var);
            } else if (zc2.f(this.k)) {
                gi4 gi4Var = this.k.get(0);
                this.q = gi4Var;
                gi4Var.o = this.o;
                yc2.l(this.n, gi4Var);
            } else {
                PMSAppInfo u3 = dh4.i().u(this.o);
                if (u3 == null) {
                    zk3 zk3Var4 = new zk3();
                    zk3Var4.k(10L);
                    zk3Var4.i(2905L);
                    zk3Var4.d("Server未返回包数据，本地也没有数据");
                    return zk3Var4;
                }
                PMSAppInfo pMSAppInfo2 = this.n;
                pMSAppInfo2.appId = this.o;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.n.initMaxAgeInfo();
            this.n.updateInstallSrc(J());
            if (dh4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                yc2.o(this.n);
                return null;
            }
            zk3 zk3Var5 = new zk3();
            zk3Var5.k(10L);
            zk3Var5.i(2906L);
            zk3Var5.d("更新DB失败");
            return zk3Var5;
        }
        return (zk3) invokeV.objValue;
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PMSAppInfo u2 = dh4.i().u(this.o);
            g62.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(J());
                fi4 fi4Var = this.j;
                if (fi4Var != null) {
                    fi4Var.c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.n;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(J());
                }
                dh4.i().l(u2);
            }
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.i.f()) {
                arrayList.add(i7b.a(new k(this)));
            }
            if (this.i.h()) {
                arrayList.add(i7b.a(new l(this)));
            }
            if (this.i.e()) {
                arrayList.add(i7b.a(new m(this)));
            }
            if (this.i.d()) {
                arrayList.add(i7b.a(new n(this)));
            }
            if (this.i.b()) {
                arrayList.add(i7b.a(new o(this)));
            }
            if (!arrayList.isEmpty()) {
                i7b.k(arrayList).w(this.B);
            }
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048609, this) != null) || this.n == null) {
            return;
        }
        PMSAppInfo u2 = dh4.i().u(this.o);
        if (u2 == null) {
            g62.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.n.appId = this.o;
        u2.updateInstallSrc(J());
        this.n.copyLocalAppInfoData(u2);
        this.n.initMaxAgeInfo();
        if (dh4.i().l(this.n)) {
            yc2.o(this.n);
        }
    }

    public zk3 x0(bi4 bi4Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, bi4Var)) == null) {
            mk2 mk2Var = new mk2();
            mk2Var.b = bi4Var.i;
            mk2Var.a = bi4Var.j;
            mk2Var.c = bi4Var.a;
            mk2Var.d = bi4Var.m;
            if (pj2.b(bi4Var.h, mk2Var) == null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                zk3 zk3Var = new zk3();
                zk3Var.k(14L);
                zk3Var.b(2908L);
                zk3Var.d("Extension包更新失败");
                return zk3Var;
            }
            return null;
        }
        return (zk3) invokeL.objValue;
    }
}
