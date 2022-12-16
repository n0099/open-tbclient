package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.a72;
import com.baidu.tieba.b3a;
import com.baidu.tieba.i43;
import com.baidu.tieba.od3;
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
/* loaded from: classes4.dex */
public abstract class e72 extends i72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public yb4 A;
    public h3a<cd4> B;
    public String c;
    public h3a<? super dd4> d;
    public h3a<? super ed4> e;
    public h3a<? super bd4> f;
    public h3a<? super zc4> g;
    public h3a<? super fd4> h;
    public mh4 i;
    public dd4 j;
    public List<ed4> k;
    public bd4 l;
    public zc4 m;
    public PMSAppInfo n;
    public String o;
    public List<UbcFlowEvent> p;
    public ed4 q;
    public long r;
    public final Set<n72> s;
    public final Set<xi3<PMSAppInfo>> t;
    public final hi3 u;
    public vb4<dd4> v;
    public vb4<ed4> w;
    public final vb4<fd4> x;
    public vb4<bd4> y;
    public vb4<zc4> z;

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

    /* loaded from: classes4.dex */
    public class a extends sb4<dd4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e72 a;

        /* renamed from: com.baidu.tieba.e72$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0258a implements xi3<i43.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0258a(a aVar) {
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
            @Override // com.baidu.tieba.xi3
            /* renamed from: b */
            public void a(i43.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.b)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    ac4.a(this.a.a, bundle, "event_performance_ubc");
                }
            }
        }

        public a(e72 e72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vb4
        /* renamed from: l */
        public String d(dd4 dd4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, dd4Var)) == null) {
                int i = dd4Var.h;
                if (i == 0) {
                    return w72.g();
                }
                if (i == 1) {
                    return w72.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: q */
        public void c(dd4 dd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048587, this, dd4Var) != null) {
                return;
            }
            String l0 = this.a.l0();
            if (e72.C) {
                jp2.d(l0).e().d(1);
            }
            super.c(dd4Var);
            e12.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        @Override // com.baidu.tieba.xb4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.sb4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: o */
        public void e(dd4 dd4Var, yc4 yc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, dd4Var, yc4Var) == null) {
                super.e(dd4Var, yc4Var);
                e12.k("SwanAppPkgDownloadCallback", "onDownloadError：" + yc4Var.toString());
                this.a.i.l(dd4Var);
                xf3 xf3Var = new xf3();
                xf3Var.k(11L);
                xf3Var.i(yc4Var.a);
                xf3Var.d("主包下载失败");
                xf3Var.f(yc4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(dd4Var, xf3Var));
                }
                a72.c().a(dd4Var, this.a.k0(), xf3Var);
                ik4.k(dd4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: p */
        public void i(dd4 dd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, dd4Var) == null) {
                String l0 = this.a.l0();
                if (e72.C) {
                    jp2.d(l0).e().d(1);
                }
                super.i(dd4Var);
                this.a.p.add(new UbcFlowEvent("na_pms_end_download"));
                xf3 z0 = this.a.z0(dd4Var);
                e12.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + dd4Var.i);
                if (z0 == null) {
                    e72 e72Var = this.a;
                    e72Var.j = dd4Var;
                    e72Var.i.m(dd4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(dd4Var);
                        if (e72.C) {
                            Log.d("SwanAppPkgDownloadCallback", this.a.i0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.a.d.onCompleted();
                    }
                    a72.c().b(dd4Var, this.a.k0());
                    return;
                }
                this.a.i.l(dd4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(dd4Var, z0));
                }
                a72.c().a(dd4Var, this.a.k0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: r */
        public void f(dd4 dd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, dd4Var) == null) {
                String l0 = this.a.l0();
                if (e72.C) {
                    jp2.d(l0).e().d(1);
                }
                super.f(dd4Var);
                if (e72.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": main onDownloading");
                }
                this.a.D0(dd4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: s */
        public yc4 h(dd4 dd4Var, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{dd4Var, file, Long.valueOf(j), readableByteChannel})) == null) {
                String l0 = this.a.l0();
                if (e72.C) {
                    jp2.d(l0).f(dd4Var.toString()).d(1);
                }
                C0258a c0258a = new C0258a(this);
                Bundle bundle = new Bundle();
                bundle.putLong(CloudStabilityUBCUtils.KEY_LENGTH, j);
                bundle.putFloat("progress_granularity", 0.1f);
                cn2 cn2Var = new cn2();
                cn2Var.u(c0258a);
                cn2Var.K(bundle);
                cn2Var.J(new bn2(dd4Var, this.a));
                cn2Var.J(new zm2(dd4Var.m, this.a));
                cn2Var.M(readableByteChannel);
                boolean N = cn2Var.N();
                cn2Var.o(c0258a);
                if (e72.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": onProcessStream: installOk=" + N);
                }
                if (N) {
                    e12.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    ik4.L(file);
                }
                if (N) {
                    return new yc4(2300, "业务层处理下载流成功");
                }
                return new yc4(2301, "业务层处理下载流失败");
            }
            return (yc4) invokeCommon.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ xi3 b;

        public b(e72 e72Var, Collection collection, xi3 xi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e72Var, collection, xi3Var};
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
            this.b = xi3Var;
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

    /* loaded from: classes4.dex */
    public class c implements xi3<n72> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xi3 a;
        public final /* synthetic */ e72 b;

        public c(e72 e72Var, xi3 xi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e72Var, xi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e72Var;
            this.a = xi3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(n72 n72Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n72Var) == null) {
                this.a.a(n72Var);
                e72 e72Var = this.b;
                e72Var.h0(e72Var.s, n72Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements xi3<n72> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf3 a;
        public final /* synthetic */ boolean b;

        public d(e72 e72Var, xf3 xf3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e72Var, xf3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xf3Var;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(n72 n72Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n72Var) == null) {
                n72Var.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements xi3<n72> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public e(e72 e72Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e72Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(n72 n72Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n72Var) == null) {
                n72Var.b(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements a72.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dd4 a;
        public final /* synthetic */ e72 b;

        public f(e72 e72Var, dd4 dd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e72Var, dd4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e72Var;
            this.a = dd4Var;
        }

        @Override // com.baidu.tieba.a72.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                e72 e72Var = this.b;
                dd4 dd4Var = this.a;
                e72Var.j = dd4Var;
                e72Var.i.m(dd4Var);
                if (this.b.d != null) {
                    this.b.d.onNext(this.a);
                    this.b.d.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.a72.c
        public void b(PMSDownloadType pMSDownloadType, xf3 xf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, xf3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, xf3Var));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements a72.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ed4 a;
        public final /* synthetic */ e72 b;

        public g(e72 e72Var, ed4 ed4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e72Var, ed4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e72Var;
            this.a = ed4Var;
        }

        @Override // com.baidu.tieba.a72.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                e72 e72Var = this.b;
                if (e72Var.k == null) {
                    e72Var.k = new ArrayList();
                }
                ed4 ed4Var = this.a;
                e72 e72Var2 = this.b;
                ed4Var.o = e72Var2.o;
                e72Var2.k.add(ed4Var);
                this.b.i.m(this.a);
                if (this.b.e != null) {
                    this.b.e.onNext(this.a);
                    if (!this.b.i.i()) {
                        this.b.e.onCompleted();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.a72.c
        public void b(PMSDownloadType pMSDownloadType, xf3 xf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, xf3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.e != null) {
                    this.b.e.onError(new PkgDownloadError(this.a, xf3Var));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements a72.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bd4 a;
        public final /* synthetic */ e72 b;

        public h(e72 e72Var, bd4 bd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e72Var, bd4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e72Var;
            this.a = bd4Var;
        }

        @Override // com.baidu.tieba.a72.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                e72 e72Var = this.b;
                bd4 bd4Var = this.a;
                e72Var.l = bd4Var;
                e72Var.i.m(bd4Var);
                if (this.b.f != null) {
                    this.b.f.onNext(this.a);
                    this.b.f.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.a72.c
        public void b(PMSDownloadType pMSDownloadType, xf3 xf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, xf3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.f != null) {
                    this.b.f.onError(new PkgDownloadError(this.a, xf3Var));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements a72.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zc4 a;
        public final /* synthetic */ e72 b;

        public i(e72 e72Var, zc4 zc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e72Var, zc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e72Var;
            this.a = zc4Var;
        }

        @Override // com.baidu.tieba.a72.c
        public void b(PMSDownloadType pMSDownloadType, xf3 xf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, xf3Var) == null) {
                e12.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + xf3Var.toString());
                this.b.i.l(this.a);
                this.b.q0(this.a);
            }
        }

        @Override // com.baidu.tieba.a72.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                e12.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                e72 e72Var = this.b;
                zc4 zc4Var = this.a;
                e72Var.m = zc4Var;
                e72Var.i.m(zc4Var);
                this.b.q0(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends h3a<cd4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e72 e;

        public j(e72 e72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = e72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c3a
        /* renamed from: g */
        public void onNext(cd4 cd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cd4Var) == null) {
                e12.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 单个包下载、业务层处理完成：" + cd4Var.i);
            }
        }

        @Override // com.baidu.tieba.c3a
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                e12.l("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载OnError", th);
                this.e.w0(th);
            }
        }

        @Override // com.baidu.tieba.c3a
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                e12.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载onCompleted");
                this.e.v0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements b3a.a<dd4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e72 a;

        public k(e72 e72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b3a.a, com.baidu.tieba.p3a
        public void call(h3a<? super dd4> h3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, h3aVar) != null) {
                return;
            }
            this.a.d = h3aVar;
        }
    }

    /* loaded from: classes4.dex */
    public class l implements b3a.a<ed4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e72 a;

        public l(e72 e72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b3a.a, com.baidu.tieba.p3a
        public void call(h3a<? super ed4> h3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, h3aVar) != null) {
                return;
            }
            this.a.e = h3aVar;
        }
    }

    /* loaded from: classes4.dex */
    public class m implements b3a.a<bd4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e72 a;

        public m(e72 e72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b3a.a, com.baidu.tieba.p3a
        public void call(h3a<? super bd4> h3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, h3aVar) != null) {
                return;
            }
            this.a.f = h3aVar;
        }
    }

    /* loaded from: classes4.dex */
    public class n implements b3a.a<zc4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e72 a;

        public n(e72 e72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b3a.a, com.baidu.tieba.p3a
        public void call(h3a<? super zc4> h3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, h3aVar) != null) {
                return;
            }
            this.a.g = h3aVar;
        }
    }

    /* loaded from: classes4.dex */
    public class o implements b3a.a<fd4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e72 a;

        public o(e72 e72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b3a.a, com.baidu.tieba.p3a
        public void call(h3a<? super fd4> h3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, h3aVar) != null) {
                return;
            }
            this.a.h = h3aVar;
        }
    }

    /* loaded from: classes4.dex */
    public class p extends l72<e72> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e72 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(e72 e72Var, e72 e72Var2) {
            super(e72Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e72Var, e72Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((i72) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = e72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.l72, com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: s */
        public void c(ed4 ed4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, ed4Var) == null) {
                super.c(ed4Var);
                e12.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: u */
        public void f(ed4 ed4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ed4Var) == null) {
                super.f(ed4Var);
                this.c.E0(ed4Var);
            }
        }

        @Override // com.baidu.tieba.l72, com.baidu.tieba.sb4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.c.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.l72
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.c.o;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.l72
        public void p(@NonNull ed4 ed4Var, @Nullable xf3 xf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, ed4Var, xf3Var) == null) {
                super.p(ed4Var, xf3Var);
                e12.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + ed4Var.i);
                e72 e72Var = this.c;
                if (e72Var.k == null) {
                    e72Var.k = new ArrayList();
                }
                e72 e72Var2 = this.c;
                ed4Var.o = e72Var2.o;
                if (xf3Var == null) {
                    e72Var2.k.add(ed4Var);
                    this.c.i.m(ed4Var);
                    a72.c().b(ed4Var, this.c.k0());
                } else {
                    e72Var2.i.l(ed4Var);
                    a72.c().a(ed4Var, this.c.k0(), xf3Var);
                }
                if (this.c.e != null) {
                    this.c.e.onNext(ed4Var);
                    if (!this.c.i.i()) {
                        this.c.e.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: q */
        public void e(ed4 ed4Var, yc4 yc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, ed4Var, yc4Var) == null) {
                super.q(ed4Var, yc4Var);
                e12.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + yc4Var.toString());
                this.c.i.l(ed4Var);
                xf3 xf3Var = new xf3();
                xf3Var.k(12L);
                xf3Var.i(yc4Var.a);
                xf3Var.d("分包下载失败");
                xf3Var.f(yc4Var.toString());
                if (this.c.e != null) {
                    this.c.e.onError(new PkgDownloadError(ed4Var, xf3Var));
                }
                a72.c().a(ed4Var, this.c.k0(), xf3Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q extends j72<e72> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e72 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(e72 e72Var, e72 e72Var2) {
            super(e72Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e72Var, e72Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((i72) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e72Var;
        }

        @Override // com.baidu.tieba.j72
        public void u(fd4 fd4Var, xf3 xf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, fd4Var, xf3Var) == null) {
                e12.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + xf3Var);
                this.b.i.l(fd4Var);
                if (this.b.h != null) {
                    this.b.h.onError(new PkgDownloadError(fd4Var, xf3Var));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.j72, com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: v */
        public void c(fd4 fd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, fd4Var) == null) {
                super.c(fd4Var);
                e12.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.sb4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.j72
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.b.k0();
            }
            return (PMSDownloadType) invokeV.objValue;
        }

        @Override // com.baidu.tieba.j72
        public void r(@NonNull fd4 fd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, fd4Var) == null) {
                this.b.i.m(fd4Var);
                if (this.b.h != null) {
                    this.b.h.onNext(fd4Var);
                    if (!this.b.i.c()) {
                        this.b.h.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.j72, com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: w */
        public void f(fd4 fd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, fd4Var) == null) {
                super.f(fd4Var);
                if (e72.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.b.i0() + ": dependent onDownloading");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r extends sb4<bd4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e72 a;

        public r(e72 e72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vb4
        /* renamed from: l */
        public String d(bd4 bd4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bd4Var)) == null) {
                int i = bd4Var.h;
                if (i == 0) {
                    return w72.h();
                }
                if (i == 1) {
                    return w72.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: q */
        public void c(bd4 bd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, bd4Var) == null) {
                super.c(bd4Var);
                e12.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.xb4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.sb4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: o */
        public void e(bd4 bd4Var, yc4 yc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bd4Var, yc4Var) == null) {
                super.e(bd4Var, yc4Var);
                e12.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + yc4Var.toString());
                this.a.i.l(bd4Var);
                xf3 xf3Var = new xf3();
                xf3Var.k(13L);
                xf3Var.i(yc4Var.a);
                xf3Var.d("Framework包下载失败");
                xf3Var.f(yc4Var.toString());
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(bd4Var, xf3Var));
                }
                a72.c().a(bd4Var, this.a.k0(), xf3Var);
                ik4.k(bd4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: p */
        public void i(bd4 bd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, bd4Var) == null) {
                super.i(bd4Var);
                e12.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + bd4Var.i);
                xf3 y0 = this.a.y0(bd4Var);
                if (y0 == null) {
                    e72 e72Var = this.a;
                    e72Var.l = bd4Var;
                    e72Var.i.m(bd4Var);
                    if (this.a.f != null) {
                        this.a.f.onNext(bd4Var);
                        this.a.f.onCompleted();
                    }
                    a72.c().b(bd4Var, this.a.k0());
                    return;
                }
                this.a.i.l(bd4Var);
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(bd4Var, y0));
                }
                a72.c().a(bd4Var, this.a.k0(), y0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: r */
        public void f(bd4 bd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, bd4Var) == null) {
                super.f(bd4Var);
                if (e72.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": framework onDownloading");
                }
                this.a.C0(bd4Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s extends sb4<zc4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e72 a;

        public s(e72 e72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vb4
        /* renamed from: l */
        public String d(zc4 zc4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, zc4Var)) == null) {
                int i = zc4Var.h;
                if (i == 0) {
                    return w72.d();
                }
                if (i == 1) {
                    return w72.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: q */
        public void c(zc4 zc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, zc4Var) == null) {
                super.c(zc4Var);
                e12.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.xb4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.sb4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: o */
        public void e(zc4 zc4Var, yc4 yc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zc4Var, yc4Var) == null) {
                super.e(zc4Var, yc4Var);
                e12.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + yc4Var.toString());
                this.a.i.l(zc4Var);
                xf3 xf3Var = new xf3();
                xf3Var.k(14L);
                xf3Var.i(yc4Var.a);
                xf3Var.d("Extension下载失败");
                xf3Var.f(yc4Var.toString());
                if (e72.C) {
                    Log.e("SwanAppPkgDownloadCallback", xf3Var.toString());
                }
                this.a.q0(zc4Var);
                a72.c().a(zc4Var, this.a.k0(), xf3Var);
                ik4.k(zc4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: p */
        public void i(zc4 zc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, zc4Var) == null) {
                super.i(zc4Var);
                e12.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + zc4Var.i);
                xf3 x0 = this.a.x0(zc4Var);
                if (x0 == null) {
                    e72 e72Var = this.a;
                    e72Var.m = zc4Var;
                    e72Var.i.m(zc4Var);
                    this.a.q0(zc4Var);
                    a72.c().b(zc4Var, this.a.k0());
                    return;
                }
                if (e72.C) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + zc4Var.toString());
                }
                this.a.i.l(zc4Var);
                this.a.q0(zc4Var);
                a72.c().a(zc4Var, this.a.k0(), x0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: r */
        public void f(zc4 zc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, zc4Var) == null) {
                super.f(zc4Var);
                if (e72.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": extension onDownloading");
                }
                this.a.B0(zc4Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t implements yb4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e72 a;

        public t(e72 e72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e72Var;
        }

        @Override // com.baidu.tieba.yb4
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (e72.C) {
                    Log.e("SwanAppPkgDownloadCallback", this.a.i0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                e72 e72Var = this.a;
                e72Var.n = pMSAppInfo;
                if (pMSAppInfo != null) {
                    e72Var.o0(pMSAppInfo);
                    c03.k(this.a.n.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u implements xi3<xi3<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public u(e72 e72Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e72Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(xi3<PMSAppInfo> xi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xi3Var) == null) {
                xi3Var.a(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public v(e72 e72Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e72Var, collection, obj};
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

    /* loaded from: classes4.dex */
    public class w implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public w(e72 e72Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e72Var, collection, obj};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947687177, "Lcom/baidu/tieba/e72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947687177, "Lcom/baidu/tieba/e72;");
                return;
            }
        }
        C = ok1.a;
    }

    @Override // com.baidu.tieba.zb4
    public vb4<ed4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.w;
        }
        return (vb4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zb4
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    @Override // com.baidu.tieba.zb4
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
            return ac4.b(this, "get_launch_id").getString("launch_id", "");
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zb4
    public yb4 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.A;
        }
        return (yb4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zb4
    public vb4<fd4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.x;
        }
        return (vb4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zb4
    public vb4<zc4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.z;
        }
        return (vb4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zb4
    public vb4<bd4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.y;
        }
        return (vb4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zb4
    public vb4<dd4> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.v;
        }
        return (vb4) invokeV.objValue;
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            e12.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public e72(String str) {
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
        this.u = new hi3();
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

    @Override // com.baidu.tieba.zb4
    public void G(mh4 mh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, mh4Var) == null) {
            super.G(mh4Var);
            this.r = System.currentTimeMillis();
            if (C) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.r);
            }
            if (mh4Var == null) {
                return;
            }
            if (C) {
                Log.i("SwanAppPkgDownloadCallback", i0() + ": onPrepareDownload: countSet=" + mh4Var.n());
            }
            this.p.add(new UbcFlowEvent("na_pms_start_download"));
            this.i = mh4Var;
            if (!mh4Var.k()) {
                n0();
            }
        }
    }

    public xf3 y0(bd4 bd4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, bd4Var)) == null) {
            if (C) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + bd4Var);
            }
            od3.b c2 = od3.c(bd4Var, bd4Var.h);
            if (!TextUtils.isEmpty(bd4Var.a)) {
                e12.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + bd4Var.a);
                ik4.k(bd4Var.a);
            }
            if (!c2.c()) {
                xf3 xf3Var = new xf3();
                xf3Var.k(13L);
                xf3Var.b(2907L);
                xf3Var.d("Core包更新失败");
                return xf3Var;
            }
            return null;
        }
        return (xf3) invokeL.objValue;
    }

    public final void B0(zc4 zc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zc4Var) == null) {
            a72.c().d(zc4Var, new i(this, zc4Var));
        }
    }

    public final void C0(bd4 bd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bd4Var) == null) {
            a72.c().d(bd4Var, new h(this, bd4Var));
        }
    }

    public final void D0(dd4 dd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dd4Var) == null) {
            a72.c().d(dd4Var, new f(this, dd4Var));
        }
    }

    public final void E0(ed4 ed4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ed4Var) == null) {
            a72.c().d(ed4Var, new g(this, ed4Var));
        }
    }

    public e72 e0(xi3<PMSAppInfo> xi3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, xi3Var)) == null) {
            f0(this.t, xi3Var);
            return this;
        }
        return (e72) invokeL.objValue;
    }

    public synchronized e72 g0(n72 n72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, n72Var)) == null) {
            synchronized (this) {
                f0(this.s, n72Var);
            }
            return this;
        }
        return (e72) invokeL.objValue;
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 == 1013) {
                bc4.i().z(this.o, i2);
            } else {
                bc4.i().z(this.o, 0);
            }
        }
    }

    public e72 o0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, pMSAppInfo)) == null) {
            p0(this.t, new u(this, pMSAppInfo));
            return this;
        }
        return (e72) invokeL.objValue;
    }

    public final void q0(zc4 zc4Var) {
        h3a<? super zc4> h3aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, zc4Var) == null) && (h3aVar = this.g) != null) {
            h3aVar.onNext(zc4Var);
            this.g.onCompleted();
        }
    }

    public e72 r0(@NonNull xi3<n72> xi3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, xi3Var)) == null) {
            p0(this.s, new c(this, xi3Var));
            return this;
        }
        return (e72) invokeL.objValue;
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
            xy2.a(this.o, str, this.p, str2);
            this.p.clear();
        }
    }

    public final synchronized <CallbackT> e72 f0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (e72) invokeLL.objValue;
    }

    public final synchronized <CallbackT> e72 h0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (e72) invokeLL.objValue;
    }

    public final synchronized <CallbackT> e72 p0(@NonNull Collection<CallbackT> collection, @NonNull xi3<CallbackT> xi3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, collection, xi3Var)) == null) {
            synchronized (this) {
                this.u.a(new b(this, collection, xi3Var));
            }
            return this;
        }
        return (e72) invokeLL.objValue;
    }

    public void t0(boolean z, xf3 xf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, xf3Var) == null) {
            r0(new d(this, xf3Var, z));
        }
    }

    @Override // com.baidu.tieba.zb4
    public void C(yc4 yc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, yc4Var) == null) {
            e12.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + yc4Var);
            if (yc4Var != null && yc4Var.a == 1010) {
                G0();
            }
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public xf3 z0(dd4 dd4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, dd4Var)) == null) {
            if (dd4Var == null) {
                xf3 xf3Var = new xf3();
                xf3Var.k(11L);
                xf3Var.i(2310L);
                xf3Var.f("pkg info is empty");
                bg3.a().f(xf3Var);
                return xf3Var;
            }
            return null;
        }
        return (xf3) invokeL.objValue;
    }

    public xf3 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PMSAppInfo pMSAppInfo = this.n;
            if (pMSAppInfo == null) {
                if (this.j == null) {
                    xf3 xf3Var = new xf3();
                    xf3Var.k(10L);
                    xf3Var.i(2903L);
                    xf3Var.d("Server未返回主包&AppInfo");
                    return xf3Var;
                }
                PMSAppInfo u2 = bc4.i().u(this.o);
                if (u2 == null) {
                    xf3 xf3Var2 = new xf3();
                    xf3Var2.k(10L);
                    xf3Var2.i(2904L);
                    xf3Var2.d("Server未返回AppInfo数据，本地也没有数据");
                    return xf3Var2;
                }
                this.n = u2;
                w72.k(u2, this.j);
                this.n.initMaxAgeInfo();
                this.n.updateInstallSrc(J());
                if (bc4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                    return null;
                }
                xf3 xf3Var3 = new xf3();
                xf3Var3.k(10L);
                xf3Var3.i(2906L);
                xf3Var3.d("更新DB失败");
                return xf3Var3;
            }
            dd4 dd4Var = this.j;
            if (dd4Var != null) {
                w72.k(pMSAppInfo, dd4Var);
            } else if (x72.f(this.k)) {
                ed4 ed4Var = this.k.get(0);
                this.q = ed4Var;
                ed4Var.o = this.o;
                w72.l(this.n, ed4Var);
            } else {
                PMSAppInfo u3 = bc4.i().u(this.o);
                if (u3 == null) {
                    xf3 xf3Var4 = new xf3();
                    xf3Var4.k(10L);
                    xf3Var4.i(2905L);
                    xf3Var4.d("Server未返回包数据，本地也没有数据");
                    return xf3Var4;
                }
                PMSAppInfo pMSAppInfo2 = this.n;
                pMSAppInfo2.appId = this.o;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.n.initMaxAgeInfo();
            this.n.updateInstallSrc(J());
            if (bc4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                w72.o(this.n);
                return null;
            }
            xf3 xf3Var5 = new xf3();
            xf3Var5.k(10L);
            xf3Var5.i(2906L);
            xf3Var5.d("更新DB失败");
            return xf3Var5;
        }
        return (xf3) invokeV.objValue;
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PMSAppInfo u2 = bc4.i().u(this.o);
            e12.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(J());
                dd4 dd4Var = this.j;
                if (dd4Var != null) {
                    dd4Var.c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.n;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(J());
                }
                bc4.i().l(u2);
            }
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.i.f()) {
                arrayList.add(b3a.a(new k(this)));
            }
            if (this.i.h()) {
                arrayList.add(b3a.a(new l(this)));
            }
            if (this.i.e()) {
                arrayList.add(b3a.a(new m(this)));
            }
            if (this.i.d()) {
                arrayList.add(b3a.a(new n(this)));
            }
            if (this.i.b()) {
                arrayList.add(b3a.a(new o(this)));
            }
            if (!arrayList.isEmpty()) {
                b3a.i(arrayList).u(this.B);
            }
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048609, this) != null) || this.n == null) {
            return;
        }
        PMSAppInfo u2 = bc4.i().u(this.o);
        if (u2 == null) {
            e12.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.n.appId = this.o;
        u2.updateInstallSrc(J());
        this.n.copyLocalAppInfoData(u2);
        this.n.initMaxAgeInfo();
        if (bc4.i().l(this.n)) {
            w72.o(this.n);
        }
    }

    public xf3 x0(zc4 zc4Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, zc4Var)) == null) {
            kf2 kf2Var = new kf2();
            kf2Var.b = zc4Var.i;
            kf2Var.a = zc4Var.j;
            kf2Var.c = zc4Var.a;
            kf2Var.d = zc4Var.m;
            if (ne2.b(zc4Var.h, kf2Var) == null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                xf3 xf3Var = new xf3();
                xf3Var.k(14L);
                xf3Var.b(2908L);
                xf3Var.d("Extension包更新失败");
                return xf3Var;
            }
            return null;
        }
        return (xf3) invokeL.objValue;
    }
}
