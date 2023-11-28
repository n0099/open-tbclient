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
import com.baidu.tieba.d92;
import com.baidu.tieba.eoc;
import com.baidu.tieba.l63;
import com.baidu.tieba.rf3;
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
public abstract class h92 extends l92 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public be4 A;
    public koc<ff4> B;
    public String c;
    public koc<? super gf4> d;
    public koc<? super hf4> e;
    public koc<? super ef4> f;
    public koc<? super cf4> g;
    public koc<? super if4> h;
    public pj4 i;
    public gf4 j;
    public List<hf4> k;
    public ef4 l;
    public cf4 m;
    public PMSAppInfo n;
    public String o;
    public List<UbcFlowEvent> p;
    public hf4 q;
    public long r;
    public final Set<q92> s;
    public final Set<al3<PMSAppInfo>> t;
    public final kk3 u;
    public yd4<gf4> v;
    public yd4<hf4> w;
    public final yd4<if4> x;
    public yd4<ef4> y;
    public yd4<cf4> z;

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
    public class a extends vd4<gf4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h92 a;

        /* renamed from: com.baidu.tieba.h92$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0342a implements al3<l63.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0342a(a aVar) {
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
            @Override // com.baidu.tieba.al3
            /* renamed from: b */
            public void a(l63.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.b)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    de4.a(this.a.a, bundle, "event_performance_ubc");
                }
            }
        }

        public a(h92 h92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4
        /* renamed from: l */
        public String d(gf4 gf4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gf4Var)) == null) {
                int i = gf4Var.h;
                if (i == 0) {
                    return z92.g();
                }
                if (i == 1) {
                    return z92.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: q */
        public void c(gf4 gf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048587, this, gf4Var) != null) {
                return;
            }
            String l0 = this.a.l0();
            if (h92.C) {
                mr2.d(l0).e().d(1);
            }
            super.c(gf4Var);
            h32.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        @Override // com.baidu.tieba.ae4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.vd4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: o */
        public void e(gf4 gf4Var, bf4 bf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, gf4Var, bf4Var) == null) {
                super.e(gf4Var, bf4Var);
                h32.k("SwanAppPkgDownloadCallback", "onDownloadError：" + bf4Var.toString());
                this.a.i.l(gf4Var);
                ai3 ai3Var = new ai3();
                ai3Var.k(11L);
                ai3Var.i(bf4Var.a);
                ai3Var.d("主包下载失败");
                ai3Var.f(bf4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(gf4Var, ai3Var));
                }
                d92.c().a(gf4Var, this.a.k0(), ai3Var);
                km4.k(gf4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: p */
        public void i(gf4 gf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, gf4Var) == null) {
                String l0 = this.a.l0();
                if (h92.C) {
                    mr2.d(l0).e().d(1);
                }
                super.i(gf4Var);
                this.a.p.add(new UbcFlowEvent("na_pms_end_download"));
                ai3 z0 = this.a.z0(gf4Var);
                h32.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + gf4Var.i);
                if (z0 == null) {
                    h92 h92Var = this.a;
                    h92Var.j = gf4Var;
                    h92Var.i.m(gf4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(gf4Var);
                        if (h92.C) {
                            Log.d("SwanAppPkgDownloadCallback", this.a.i0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.a.d.onCompleted();
                    }
                    d92.c().b(gf4Var, this.a.k0());
                    return;
                }
                this.a.i.l(gf4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(gf4Var, z0));
                }
                d92.c().a(gf4Var, this.a.k0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: r */
        public void f(gf4 gf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, gf4Var) == null) {
                String l0 = this.a.l0();
                if (h92.C) {
                    mr2.d(l0).e().d(1);
                }
                super.f(gf4Var);
                if (h92.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": main onDownloading");
                }
                this.a.D0(gf4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: s */
        public bf4 h(gf4 gf4Var, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{gf4Var, file, Long.valueOf(j), readableByteChannel})) == null) {
                String l0 = this.a.l0();
                if (h92.C) {
                    mr2.d(l0).f(gf4Var.toString()).d(1);
                }
                C0342a c0342a = new C0342a(this);
                Bundle bundle = new Bundle();
                bundle.putLong("length", j);
                bundle.putFloat("progress_granularity", 0.1f);
                fp2 fp2Var = new fp2();
                fp2Var.u(c0342a);
                fp2Var.K(bundle);
                fp2Var.J(new ep2(gf4Var, this.a));
                fp2Var.J(new cp2(gf4Var.m, this.a));
                fp2Var.M(readableByteChannel);
                boolean N = fp2Var.N();
                fp2Var.o(c0342a);
                if (h92.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": onProcessStream: installOk=" + N);
                }
                if (N) {
                    h32.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    km4.L(file);
                }
                if (N) {
                    return new bf4(2300, "业务层处理下载流成功");
                }
                return new bf4(2301, "业务层处理下载流失败");
            }
            return (bf4) invokeCommon.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ al3 b;

        public b(h92 h92Var, Collection collection, al3 al3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var, collection, al3Var};
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
            this.b = al3Var;
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
    public class c implements al3<q92> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ al3 a;
        public final /* synthetic */ h92 b;

        public c(h92 h92Var, al3 al3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var, al3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h92Var;
            this.a = al3Var;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.baidu.tieba.h92.Q(com.baidu.tieba.h92, java.util.Collection, java.lang.Object):com.baidu.tieba.h92
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
        @Override // com.baidu.tieba.al3
        /* renamed from: b */
        public void a(com.baidu.tieba.q92 r5) {
            /*
                r4 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tieba.h92.c.$ic
                if (r0 != 0) goto L13
            L4:
                com.baidu.tieba.al3 r0 = r4.a
                r0.a(r5)
                com.baidu.tieba.h92 r0 = r4.b
                java.util.Set r1 = com.baidu.tieba.h92.P(r0)
                com.baidu.tieba.h92.Q(r0, r1, r5)
                return
            L13:
                r2 = r0
                r3 = 1048577(0x100001, float:1.46937E-39)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r2.invokeL(r3, r4, r5)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.h92.c.a(com.baidu.tieba.q92):void");
        }
    }

    /* loaded from: classes6.dex */
    public class d implements al3<q92> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ai3 a;
        public final /* synthetic */ boolean b;

        public d(h92 h92Var, ai3 ai3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var, ai3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ai3Var;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.al3
        /* renamed from: b */
        public void a(q92 q92Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q92Var) == null) {
                q92Var.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements al3<q92> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public e(h92 h92Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.al3
        /* renamed from: b */
        public void a(q92 q92Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q92Var) == null) {
                q92Var.b(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements d92.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gf4 a;
        public final /* synthetic */ h92 b;

        public f(h92 h92Var, gf4 gf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var, gf4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h92Var;
            this.a = gf4Var;
        }

        @Override // com.baidu.tieba.d92.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                h92 h92Var = this.b;
                gf4 gf4Var = this.a;
                h92Var.j = gf4Var;
                h92Var.i.m(gf4Var);
                if (this.b.d != null) {
                    this.b.d.onNext(this.a);
                    this.b.d.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.d92.c
        public void b(PMSDownloadType pMSDownloadType, ai3 ai3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ai3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, ai3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements d92.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hf4 a;
        public final /* synthetic */ h92 b;

        public g(h92 h92Var, hf4 hf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var, hf4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h92Var;
            this.a = hf4Var;
        }

        @Override // com.baidu.tieba.d92.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                h92 h92Var = this.b;
                if (h92Var.k == null) {
                    h92Var.k = new ArrayList();
                }
                hf4 hf4Var = this.a;
                h92 h92Var2 = this.b;
                hf4Var.o = h92Var2.o;
                h92Var2.k.add(hf4Var);
                this.b.i.m(this.a);
                if (this.b.e != null) {
                    this.b.e.onNext(this.a);
                    if (!this.b.i.i()) {
                        this.b.e.onCompleted();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.d92.c
        public void b(PMSDownloadType pMSDownloadType, ai3 ai3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ai3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.e != null) {
                    this.b.e.onError(new PkgDownloadError(this.a, ai3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements d92.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ef4 a;
        public final /* synthetic */ h92 b;

        public h(h92 h92Var, ef4 ef4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var, ef4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h92Var;
            this.a = ef4Var;
        }

        @Override // com.baidu.tieba.d92.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                h92 h92Var = this.b;
                ef4 ef4Var = this.a;
                h92Var.l = ef4Var;
                h92Var.i.m(ef4Var);
                if (this.b.f != null) {
                    this.b.f.onNext(this.a);
                    this.b.f.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.d92.c
        public void b(PMSDownloadType pMSDownloadType, ai3 ai3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ai3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.f != null) {
                    this.b.f.onError(new PkgDownloadError(this.a, ai3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements d92.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf4 a;
        public final /* synthetic */ h92 b;

        public i(h92 h92Var, cf4 cf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var, cf4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h92Var;
            this.a = cf4Var;
        }

        @Override // com.baidu.tieba.d92.c
        public void b(PMSDownloadType pMSDownloadType, ai3 ai3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ai3Var) == null) {
                h32.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + ai3Var.toString());
                this.b.i.l(this.a);
                this.b.q0(this.a);
            }
        }

        @Override // com.baidu.tieba.d92.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                h32.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                h92 h92Var = this.b;
                cf4 cf4Var = this.a;
                h92Var.m = cf4Var;
                h92Var.i.m(cf4Var);
                this.b.q0(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends koc<ff4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h92 e;

        public j(h92 h92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = h92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.foc
        /* renamed from: g */
        public void onNext(ff4 ff4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ff4Var) == null) {
                h32.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 单个包下载、业务层处理完成：" + ff4Var.i);
            }
        }

        @Override // com.baidu.tieba.foc
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                h32.l("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载OnError", th);
                this.e.w0(th);
            }
        }

        @Override // com.baidu.tieba.foc
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                h32.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载onCompleted");
                this.e.v0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements eoc.a<gf4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h92 a;

        public k(h92 h92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.soc
        /* renamed from: a */
        public void call(koc<? super gf4> kocVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, kocVar) != null) {
                return;
            }
            this.a.d = kocVar;
        }
    }

    /* loaded from: classes6.dex */
    public class l implements eoc.a<hf4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h92 a;

        public l(h92 h92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.soc
        /* renamed from: a */
        public void call(koc<? super hf4> kocVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, kocVar) != null) {
                return;
            }
            this.a.e = kocVar;
        }
    }

    /* loaded from: classes6.dex */
    public class m implements eoc.a<ef4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h92 a;

        public m(h92 h92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.soc
        /* renamed from: a */
        public void call(koc<? super ef4> kocVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, kocVar) != null) {
                return;
            }
            this.a.f = kocVar;
        }
    }

    /* loaded from: classes6.dex */
    public class n implements eoc.a<cf4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h92 a;

        public n(h92 h92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.soc
        /* renamed from: a */
        public void call(koc<? super cf4> kocVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, kocVar) != null) {
                return;
            }
            this.a.g = kocVar;
        }
    }

    /* loaded from: classes6.dex */
    public class o implements eoc.a<if4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h92 a;

        public o(h92 h92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.soc
        /* renamed from: a */
        public void call(koc<? super if4> kocVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, kocVar) != null) {
                return;
            }
            this.a.h = kocVar;
        }
    }

    /* loaded from: classes6.dex */
    public class p extends o92<h92> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h92 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(h92 h92Var, h92 h92Var2) {
            super(h92Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var, h92Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((l92) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = h92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.o92, com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: s */
        public void c(hf4 hf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, hf4Var) == null) {
                super.c(hf4Var);
                h32.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: u */
        public void f(hf4 hf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hf4Var) == null) {
                super.f(hf4Var);
                this.c.E0(hf4Var);
            }
        }

        @Override // com.baidu.tieba.o92, com.baidu.tieba.vd4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.c.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.o92
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.c.o;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.o92
        public void p(@NonNull hf4 hf4Var, @Nullable ai3 ai3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, hf4Var, ai3Var) == null) {
                super.p(hf4Var, ai3Var);
                h32.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + hf4Var.i);
                h92 h92Var = this.c;
                if (h92Var.k == null) {
                    h92Var.k = new ArrayList();
                }
                h92 h92Var2 = this.c;
                hf4Var.o = h92Var2.o;
                if (ai3Var == null) {
                    h92Var2.k.add(hf4Var);
                    this.c.i.m(hf4Var);
                    d92.c().b(hf4Var, this.c.k0());
                } else {
                    h92Var2.i.l(hf4Var);
                    d92.c().a(hf4Var, this.c.k0(), ai3Var);
                }
                if (this.c.e != null) {
                    this.c.e.onNext(hf4Var);
                    if (!this.c.i.i()) {
                        this.c.e.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: q */
        public void e(hf4 hf4Var, bf4 bf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, hf4Var, bf4Var) == null) {
                super.q(hf4Var, bf4Var);
                h32.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + bf4Var.toString());
                this.c.i.l(hf4Var);
                ai3 ai3Var = new ai3();
                ai3Var.k(12L);
                ai3Var.i(bf4Var.a);
                ai3Var.d("分包下载失败");
                ai3Var.f(bf4Var.toString());
                if (this.c.e != null) {
                    this.c.e.onError(new PkgDownloadError(hf4Var, ai3Var));
                }
                d92.c().a(hf4Var, this.c.k0(), ai3Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q extends m92<h92> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h92 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(h92 h92Var, h92 h92Var2) {
            super(h92Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var, h92Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((l92) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h92Var;
        }

        @Override // com.baidu.tieba.m92
        public void u(if4 if4Var, ai3 ai3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, if4Var, ai3Var) == null) {
                h32.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + ai3Var);
                this.b.i.l(if4Var);
                if (this.b.h != null) {
                    this.b.h.onError(new PkgDownloadError(if4Var, ai3Var));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m92, com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: v */
        public void c(if4 if4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, if4Var) == null) {
                super.c(if4Var);
                h32.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.vd4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.m92
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.b.k0();
            }
            return (PMSDownloadType) invokeV.objValue;
        }

        @Override // com.baidu.tieba.m92
        public void r(@NonNull if4 if4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, if4Var) == null) {
                this.b.i.m(if4Var);
                if (this.b.h != null) {
                    this.b.h.onNext(if4Var);
                    if (!this.b.i.c()) {
                        this.b.h.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m92, com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: w */
        public void f(if4 if4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, if4Var) == null) {
                super.f(if4Var);
                if (h92.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.b.i0() + ": dependent onDownloading");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r extends vd4<ef4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h92 a;

        public r(h92 h92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4
        /* renamed from: l */
        public String d(ef4 ef4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ef4Var)) == null) {
                int i = ef4Var.h;
                if (i == 0) {
                    return z92.h();
                }
                if (i == 1) {
                    return z92.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: q */
        public void c(ef4 ef4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, ef4Var) == null) {
                super.c(ef4Var);
                h32.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.ae4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.vd4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: o */
        public void e(ef4 ef4Var, bf4 bf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ef4Var, bf4Var) == null) {
                super.e(ef4Var, bf4Var);
                h32.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + bf4Var.toString());
                this.a.i.l(ef4Var);
                ai3 ai3Var = new ai3();
                ai3Var.k(13L);
                ai3Var.i(bf4Var.a);
                ai3Var.d("Framework包下载失败");
                ai3Var.f(bf4Var.toString());
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(ef4Var, ai3Var));
                }
                d92.c().a(ef4Var, this.a.k0(), ai3Var);
                km4.k(ef4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: p */
        public void i(ef4 ef4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, ef4Var) == null) {
                super.i(ef4Var);
                h32.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + ef4Var.i);
                ai3 y0 = this.a.y0(ef4Var);
                if (y0 == null) {
                    h92 h92Var = this.a;
                    h92Var.l = ef4Var;
                    h92Var.i.m(ef4Var);
                    if (this.a.f != null) {
                        this.a.f.onNext(ef4Var);
                        this.a.f.onCompleted();
                    }
                    d92.c().b(ef4Var, this.a.k0());
                    return;
                }
                this.a.i.l(ef4Var);
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(ef4Var, y0));
                }
                d92.c().a(ef4Var, this.a.k0(), y0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: r */
        public void f(ef4 ef4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, ef4Var) == null) {
                super.f(ef4Var);
                if (h92.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": framework onDownloading");
                }
                this.a.C0(ef4Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s extends vd4<cf4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h92 a;

        public s(h92 h92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4
        /* renamed from: l */
        public String d(cf4 cf4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cf4Var)) == null) {
                int i = cf4Var.h;
                if (i == 0) {
                    return z92.d();
                }
                if (i == 1) {
                    return z92.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: q */
        public void c(cf4 cf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, cf4Var) == null) {
                super.c(cf4Var);
                h32.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.ae4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.vd4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: o */
        public void e(cf4 cf4Var, bf4 bf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cf4Var, bf4Var) == null) {
                super.e(cf4Var, bf4Var);
                h32.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + bf4Var.toString());
                this.a.i.l(cf4Var);
                ai3 ai3Var = new ai3();
                ai3Var.k(14L);
                ai3Var.i(bf4Var.a);
                ai3Var.d("Extension下载失败");
                ai3Var.f(bf4Var.toString());
                if (h92.C) {
                    Log.e("SwanAppPkgDownloadCallback", ai3Var.toString());
                }
                this.a.q0(cf4Var);
                d92.c().a(cf4Var, this.a.k0(), ai3Var);
                km4.k(cf4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: p */
        public void i(cf4 cf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, cf4Var) == null) {
                super.i(cf4Var);
                h32.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + cf4Var.i);
                ai3 x0 = this.a.x0(cf4Var);
                if (x0 == null) {
                    h92 h92Var = this.a;
                    h92Var.m = cf4Var;
                    h92Var.i.m(cf4Var);
                    this.a.q0(cf4Var);
                    d92.c().b(cf4Var, this.a.k0());
                    return;
                }
                if (h92.C) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + cf4Var.toString());
                }
                this.a.i.l(cf4Var);
                this.a.q0(cf4Var);
                d92.c().a(cf4Var, this.a.k0(), x0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: r */
        public void f(cf4 cf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, cf4Var) == null) {
                super.f(cf4Var);
                if (h92.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": extension onDownloading");
                }
                this.a.B0(cf4Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements be4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h92 a;

        public t(h92 h92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h92Var;
        }

        @Override // com.baidu.tieba.be4
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (h92.C) {
                    Log.e("SwanAppPkgDownloadCallback", this.a.i0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                h92 h92Var = this.a;
                h92Var.n = pMSAppInfo;
                if (pMSAppInfo != null) {
                    h92Var.o0(pMSAppInfo);
                    f23.k(this.a.n.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements al3<al3<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public u(h92 h92Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.al3
        /* renamed from: b */
        public void a(al3<PMSAppInfo> al3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, al3Var) == null) {
                al3Var.a(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public v(h92 h92Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var, collection, obj};
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

        public w(h92 h92Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var, collection, obj};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947778472, "Lcom/baidu/tieba/h92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947778472, "Lcom/baidu/tieba/h92;");
                return;
            }
        }
        C = sm1.a;
    }

    @Override // com.baidu.tieba.ce4
    public yd4<hf4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.w;
        }
        return (yd4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ce4
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    @Override // com.baidu.tieba.ce4
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
            return de4.b(this, "get_launch_id").getString("launch_id", "");
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ce4
    public be4 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.A;
        }
        return (be4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ce4
    public yd4<if4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.x;
        }
        return (yd4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ce4
    public yd4<cf4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.z;
        }
        return (yd4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ce4
    public yd4<ef4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.y;
        }
        return (yd4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ce4
    public yd4<gf4> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.v;
        }
        return (yd4) invokeV.objValue;
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            h32.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public h92(String str) {
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
        this.u = new kk3();
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

    @Override // com.baidu.tieba.ce4
    public void G(pj4 pj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, pj4Var) == null) {
            super.G(pj4Var);
            this.r = System.currentTimeMillis();
            if (C) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.r);
            }
            if (pj4Var == null) {
                return;
            }
            if (C) {
                Log.i("SwanAppPkgDownloadCallback", i0() + ": onPrepareDownload: countSet=" + pj4Var.n());
            }
            this.p.add(new UbcFlowEvent("na_pms_start_download"));
            this.i = pj4Var;
            if (!pj4Var.k()) {
                n0();
            }
        }
    }

    public ai3 y0(ef4 ef4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, ef4Var)) == null) {
            if (C) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + ef4Var);
            }
            rf3.b c2 = rf3.c(ef4Var, ef4Var.h);
            if (!TextUtils.isEmpty(ef4Var.a)) {
                h32.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + ef4Var.a);
                km4.k(ef4Var.a);
            }
            if (!c2.c()) {
                ai3 ai3Var = new ai3();
                ai3Var.k(13L);
                ai3Var.b(2907L);
                ai3Var.d("Core包更新失败");
                return ai3Var;
            }
            return null;
        }
        return (ai3) invokeL.objValue;
    }

    public final void B0(cf4 cf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cf4Var) == null) {
            d92.c().d(cf4Var, new i(this, cf4Var));
        }
    }

    public final void C0(ef4 ef4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ef4Var) == null) {
            d92.c().d(ef4Var, new h(this, ef4Var));
        }
    }

    public final void D0(gf4 gf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, gf4Var) == null) {
            d92.c().d(gf4Var, new f(this, gf4Var));
        }
    }

    public final void E0(hf4 hf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hf4Var) == null) {
            d92.c().d(hf4Var, new g(this, hf4Var));
        }
    }

    public h92 e0(al3<PMSAppInfo> al3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, al3Var)) == null) {
            f0(this.t, al3Var);
            return this;
        }
        return (h92) invokeL.objValue;
    }

    public synchronized h92 g0(q92 q92Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, q92Var)) == null) {
            synchronized (this) {
                f0(this.s, q92Var);
            }
            return this;
        }
        return (h92) invokeL.objValue;
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 == 1013) {
                ee4.i().z(this.o, i2);
            } else {
                ee4.i().z(this.o, 0);
            }
        }
    }

    public h92 o0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, pMSAppInfo)) == null) {
            p0(this.t, new u(this, pMSAppInfo));
            return this;
        }
        return (h92) invokeL.objValue;
    }

    public final void q0(cf4 cf4Var) {
        koc<? super cf4> kocVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, cf4Var) == null) && (kocVar = this.g) != null) {
            kocVar.onNext(cf4Var);
            this.g.onCompleted();
        }
    }

    public h92 r0(@NonNull al3<q92> al3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, al3Var)) == null) {
            p0(this.s, new c(this, al3Var));
            return this;
        }
        return (h92) invokeL.objValue;
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
            a13.a(this.o, str, this.p, str2);
            this.p.clear();
        }
    }

    public final synchronized <CallbackT> h92 f0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (h92) invokeLL.objValue;
    }

    public final synchronized <CallbackT> h92 h0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (h92) invokeLL.objValue;
    }

    public final synchronized <CallbackT> h92 p0(@NonNull Collection<CallbackT> collection, @NonNull al3<CallbackT> al3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, collection, al3Var)) == null) {
            synchronized (this) {
                this.u.a(new b(this, collection, al3Var));
            }
            return this;
        }
        return (h92) invokeLL.objValue;
    }

    public void t0(boolean z, ai3 ai3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, ai3Var) == null) {
            r0(new d(this, ai3Var, z));
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
    public static /* synthetic */ com.baidu.tieba.h92 Q(com.baidu.tieba.h92 r0, java.util.Collection r1, java.lang.Object r2) {
        /*
            r0.h0(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.h92.Q(com.baidu.tieba.h92, java.util.Collection, java.lang.Object):com.baidu.tieba.h92");
    }

    @Override // com.baidu.tieba.ce4
    public void C(bf4 bf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bf4Var) == null) {
            h32.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + bf4Var);
            if (bf4Var != null && bf4Var.a == 1010) {
                G0();
            }
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public ai3 z0(gf4 gf4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, gf4Var)) == null) {
            if (gf4Var == null) {
                ai3 ai3Var = new ai3();
                ai3Var.k(11L);
                ai3Var.i(2310L);
                ai3Var.f("pkg info is empty");
                ei3.a().f(ai3Var);
                return ai3Var;
            }
            return null;
        }
        return (ai3) invokeL.objValue;
    }

    public ai3 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PMSAppInfo pMSAppInfo = this.n;
            if (pMSAppInfo == null) {
                if (this.j == null) {
                    ai3 ai3Var = new ai3();
                    ai3Var.k(10L);
                    ai3Var.i(2903L);
                    ai3Var.d("Server未返回主包&AppInfo");
                    return ai3Var;
                }
                PMSAppInfo u2 = ee4.i().u(this.o);
                if (u2 == null) {
                    ai3 ai3Var2 = new ai3();
                    ai3Var2.k(10L);
                    ai3Var2.i(2904L);
                    ai3Var2.d("Server未返回AppInfo数据，本地也没有数据");
                    return ai3Var2;
                }
                this.n = u2;
                z92.k(u2, this.j);
                this.n.initMaxAgeInfo();
                this.n.updateInstallSrc(J());
                if (ee4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                    return null;
                }
                ai3 ai3Var3 = new ai3();
                ai3Var3.k(10L);
                ai3Var3.i(2906L);
                ai3Var3.d("更新DB失败");
                return ai3Var3;
            }
            gf4 gf4Var = this.j;
            if (gf4Var != null) {
                z92.k(pMSAppInfo, gf4Var);
            } else if (aa2.f(this.k)) {
                hf4 hf4Var = this.k.get(0);
                this.q = hf4Var;
                hf4Var.o = this.o;
                z92.l(this.n, hf4Var);
            } else {
                PMSAppInfo u3 = ee4.i().u(this.o);
                if (u3 == null) {
                    ai3 ai3Var4 = new ai3();
                    ai3Var4.k(10L);
                    ai3Var4.i(2905L);
                    ai3Var4.d("Server未返回包数据，本地也没有数据");
                    return ai3Var4;
                }
                PMSAppInfo pMSAppInfo2 = this.n;
                pMSAppInfo2.appId = this.o;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.n.initMaxAgeInfo();
            this.n.updateInstallSrc(J());
            if (ee4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                z92.o(this.n);
                return null;
            }
            ai3 ai3Var5 = new ai3();
            ai3Var5.k(10L);
            ai3Var5.i(2906L);
            ai3Var5.d("更新DB失败");
            return ai3Var5;
        }
        return (ai3) invokeV.objValue;
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PMSAppInfo u2 = ee4.i().u(this.o);
            h32.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(J());
                gf4 gf4Var = this.j;
                if (gf4Var != null) {
                    gf4Var.c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.n;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(J());
                }
                ee4.i().l(u2);
            }
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.i.f()) {
                arrayList.add(eoc.d(new k(this)));
            }
            if (this.i.h()) {
                arrayList.add(eoc.d(new l(this)));
            }
            if (this.i.e()) {
                arrayList.add(eoc.d(new m(this)));
            }
            if (this.i.d()) {
                arrayList.add(eoc.d(new n(this)));
            }
            if (this.i.b()) {
                arrayList.add(eoc.d(new o(this)));
            }
            if (!arrayList.isEmpty()) {
                eoc.q(arrayList).F(this.B);
            }
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048609, this) != null) || this.n == null) {
            return;
        }
        PMSAppInfo u2 = ee4.i().u(this.o);
        if (u2 == null) {
            h32.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.n.appId = this.o;
        u2.updateInstallSrc(J());
        this.n.copyLocalAppInfoData(u2);
        this.n.initMaxAgeInfo();
        if (ee4.i().l(this.n)) {
            z92.o(this.n);
        }
    }

    public ai3 x0(cf4 cf4Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, cf4Var)) == null) {
            nh2 nh2Var = new nh2();
            nh2Var.b = cf4Var.i;
            nh2Var.a = cf4Var.j;
            nh2Var.c = cf4Var.a;
            nh2Var.d = cf4Var.m;
            if (qg2.b(cf4Var.h, nh2Var) == null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                ai3 ai3Var = new ai3();
                ai3Var.k(14L);
                ai3Var.b(2908L);
                ai3Var.d("Extension包更新失败");
                return ai3Var;
            }
            return null;
        }
        return (ai3) invokeL.objValue;
    }
}
