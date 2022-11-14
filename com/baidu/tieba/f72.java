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
import com.baidu.tieba.b72;
import com.baidu.tieba.j43;
import com.baidu.tieba.pd3;
import com.baidu.tieba.rz9;
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
public abstract class f72 extends j72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public zb4 A;
    public xz9<dd4> B;
    public String c;
    public xz9<? super ed4> d;
    public xz9<? super fd4> e;
    public xz9<? super cd4> f;
    public xz9<? super ad4> g;
    public xz9<? super gd4> h;
    public nh4 i;
    public ed4 j;
    public List<fd4> k;
    public cd4 l;
    public ad4 m;
    public PMSAppInfo n;
    public String o;
    public List<UbcFlowEvent> p;
    public fd4 q;
    public long r;
    public final Set<o72> s;
    public final Set<yi3<PMSAppInfo>> t;
    public final ii3 u;
    public wb4<ed4> v;
    public wb4<fd4> w;
    public final wb4<gd4> x;
    public wb4<cd4> y;
    public wb4<ad4> z;

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
    public class a extends tb4<ed4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f72 a;

        /* renamed from: com.baidu.tieba.f72$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0262a implements yi3<j43.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0262a(a aVar) {
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
            @Override // com.baidu.tieba.yi3
            /* renamed from: b */
            public void a(j43.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.b)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    bc4.a(this.a.a, bundle, "event_performance_ubc");
                }
            }
        }

        public a(f72 f72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wb4
        /* renamed from: l */
        public String d(ed4 ed4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ed4Var)) == null) {
                int i = ed4Var.h;
                if (i == 0) {
                    return x72.g();
                }
                if (i == 1) {
                    return x72.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tb4, com.baidu.tieba.wb4
        /* renamed from: q */
        public void c(ed4 ed4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048587, this, ed4Var) != null) {
                return;
            }
            String l0 = this.a.l0();
            if (f72.C) {
                kp2.d(l0).e().d(1);
            }
            super.c(ed4Var);
            f12.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        @Override // com.baidu.tieba.yb4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.tb4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tb4, com.baidu.tieba.wb4
        /* renamed from: o */
        public void e(ed4 ed4Var, zc4 zc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, ed4Var, zc4Var) == null) {
                super.e(ed4Var, zc4Var);
                f12.k("SwanAppPkgDownloadCallback", "onDownloadError：" + zc4Var.toString());
                this.a.i.l(ed4Var);
                yf3 yf3Var = new yf3();
                yf3Var.k(11L);
                yf3Var.i(zc4Var.a);
                yf3Var.d("主包下载失败");
                yf3Var.f(zc4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(ed4Var, yf3Var));
                }
                b72.c().a(ed4Var, this.a.k0(), yf3Var);
                jk4.k(ed4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tb4, com.baidu.tieba.wb4
        /* renamed from: p */
        public void i(ed4 ed4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, ed4Var) == null) {
                String l0 = this.a.l0();
                if (f72.C) {
                    kp2.d(l0).e().d(1);
                }
                super.i(ed4Var);
                this.a.p.add(new UbcFlowEvent("na_pms_end_download"));
                yf3 z0 = this.a.z0(ed4Var);
                f12.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + ed4Var.i);
                if (z0 == null) {
                    f72 f72Var = this.a;
                    f72Var.j = ed4Var;
                    f72Var.i.m(ed4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(ed4Var);
                        if (f72.C) {
                            Log.d("SwanAppPkgDownloadCallback", this.a.i0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.a.d.onCompleted();
                    }
                    b72.c().b(ed4Var, this.a.k0());
                    return;
                }
                this.a.i.l(ed4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(ed4Var, z0));
                }
                b72.c().a(ed4Var, this.a.k0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tb4, com.baidu.tieba.wb4
        /* renamed from: r */
        public void f(ed4 ed4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, ed4Var) == null) {
                String l0 = this.a.l0();
                if (f72.C) {
                    kp2.d(l0).e().d(1);
                }
                super.f(ed4Var);
                if (f72.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": main onDownloading");
                }
                this.a.D0(ed4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tb4, com.baidu.tieba.wb4
        /* renamed from: s */
        public zc4 h(ed4 ed4Var, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{ed4Var, file, Long.valueOf(j), readableByteChannel})) == null) {
                String l0 = this.a.l0();
                if (f72.C) {
                    kp2.d(l0).f(ed4Var.toString()).d(1);
                }
                C0262a c0262a = new C0262a(this);
                Bundle bundle = new Bundle();
                bundle.putLong(CloudStabilityUBCUtils.KEY_LENGTH, j);
                bundle.putFloat("progress_granularity", 0.1f);
                dn2 dn2Var = new dn2();
                dn2Var.u(c0262a);
                dn2Var.K(bundle);
                dn2Var.J(new cn2(ed4Var, this.a));
                dn2Var.J(new an2(ed4Var.m, this.a));
                dn2Var.M(readableByteChannel);
                boolean N = dn2Var.N();
                dn2Var.o(c0262a);
                if (f72.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": onProcessStream: installOk=" + N);
                }
                if (N) {
                    f12.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    jk4.L(file);
                }
                if (N) {
                    return new zc4(2300, "业务层处理下载流成功");
                }
                return new zc4(2301, "业务层处理下载流失败");
            }
            return (zc4) invokeCommon.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ yi3 b;

        public b(f72 f72Var, Collection collection, yi3 yi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var, collection, yi3Var};
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
            this.b = yi3Var;
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
    public class c implements yi3<o72> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yi3 a;
        public final /* synthetic */ f72 b;

        public c(f72 f72Var, yi3 yi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var, yi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f72Var;
            this.a = yi3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yi3
        /* renamed from: b */
        public void a(o72 o72Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o72Var) == null) {
                this.a.a(o72Var);
                f72 f72Var = this.b;
                f72Var.h0(f72Var.s, o72Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements yi3<o72> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yf3 a;
        public final /* synthetic */ boolean b;

        public d(f72 f72Var, yf3 yf3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var, yf3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yf3Var;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yi3
        /* renamed from: b */
        public void a(o72 o72Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o72Var) == null) {
                o72Var.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements yi3<o72> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public e(f72 f72Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.yi3
        /* renamed from: b */
        public void a(o72 o72Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o72Var) == null) {
                o72Var.b(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements b72.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ed4 a;
        public final /* synthetic */ f72 b;

        public f(f72 f72Var, ed4 ed4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var, ed4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f72Var;
            this.a = ed4Var;
        }

        @Override // com.baidu.tieba.b72.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                f72 f72Var = this.b;
                ed4 ed4Var = this.a;
                f72Var.j = ed4Var;
                f72Var.i.m(ed4Var);
                if (this.b.d != null) {
                    this.b.d.onNext(this.a);
                    this.b.d.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.b72.c
        public void b(PMSDownloadType pMSDownloadType, yf3 yf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, yf3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, yf3Var));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements b72.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fd4 a;
        public final /* synthetic */ f72 b;

        public g(f72 f72Var, fd4 fd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var, fd4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f72Var;
            this.a = fd4Var;
        }

        @Override // com.baidu.tieba.b72.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                f72 f72Var = this.b;
                if (f72Var.k == null) {
                    f72Var.k = new ArrayList();
                }
                fd4 fd4Var = this.a;
                f72 f72Var2 = this.b;
                fd4Var.o = f72Var2.o;
                f72Var2.k.add(fd4Var);
                this.b.i.m(this.a);
                if (this.b.e != null) {
                    this.b.e.onNext(this.a);
                    if (!this.b.i.i()) {
                        this.b.e.onCompleted();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.b72.c
        public void b(PMSDownloadType pMSDownloadType, yf3 yf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, yf3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.e != null) {
                    this.b.e.onError(new PkgDownloadError(this.a, yf3Var));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements b72.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cd4 a;
        public final /* synthetic */ f72 b;

        public h(f72 f72Var, cd4 cd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var, cd4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f72Var;
            this.a = cd4Var;
        }

        @Override // com.baidu.tieba.b72.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                f72 f72Var = this.b;
                cd4 cd4Var = this.a;
                f72Var.l = cd4Var;
                f72Var.i.m(cd4Var);
                if (this.b.f != null) {
                    this.b.f.onNext(this.a);
                    this.b.f.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.b72.c
        public void b(PMSDownloadType pMSDownloadType, yf3 yf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, yf3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.f != null) {
                    this.b.f.onError(new PkgDownloadError(this.a, yf3Var));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements b72.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ad4 a;
        public final /* synthetic */ f72 b;

        public i(f72 f72Var, ad4 ad4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var, ad4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f72Var;
            this.a = ad4Var;
        }

        @Override // com.baidu.tieba.b72.c
        public void b(PMSDownloadType pMSDownloadType, yf3 yf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, yf3Var) == null) {
                f12.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + yf3Var.toString());
                this.b.i.l(this.a);
                this.b.q0(this.a);
            }
        }

        @Override // com.baidu.tieba.b72.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                f12.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                f72 f72Var = this.b;
                ad4 ad4Var = this.a;
                f72Var.m = ad4Var;
                f72Var.i.m(ad4Var);
                this.b.q0(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends xz9<dd4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f72 e;

        public j(f72 f72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = f72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sz9
        /* renamed from: g */
        public void onNext(dd4 dd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dd4Var) == null) {
                f12.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 单个包下载、业务层处理完成：" + dd4Var.i);
            }
        }

        @Override // com.baidu.tieba.sz9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                f12.l("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载OnError", th);
                this.e.w0(th);
            }
        }

        @Override // com.baidu.tieba.sz9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                f12.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载onCompleted");
                this.e.v0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements rz9.a<ed4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f72 a;

        public k(f72 f72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rz9.a, com.baidu.tieba.f0a
        public void call(xz9<? super ed4> xz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, xz9Var) != null) {
                return;
            }
            this.a.d = xz9Var;
        }
    }

    /* loaded from: classes4.dex */
    public class l implements rz9.a<fd4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f72 a;

        public l(f72 f72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rz9.a, com.baidu.tieba.f0a
        public void call(xz9<? super fd4> xz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, xz9Var) != null) {
                return;
            }
            this.a.e = xz9Var;
        }
    }

    /* loaded from: classes4.dex */
    public class m implements rz9.a<cd4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f72 a;

        public m(f72 f72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rz9.a, com.baidu.tieba.f0a
        public void call(xz9<? super cd4> xz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, xz9Var) != null) {
                return;
            }
            this.a.f = xz9Var;
        }
    }

    /* loaded from: classes4.dex */
    public class n implements rz9.a<ad4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f72 a;

        public n(f72 f72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rz9.a, com.baidu.tieba.f0a
        public void call(xz9<? super ad4> xz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, xz9Var) != null) {
                return;
            }
            this.a.g = xz9Var;
        }
    }

    /* loaded from: classes4.dex */
    public class o implements rz9.a<gd4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f72 a;

        public o(f72 f72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rz9.a, com.baidu.tieba.f0a
        public void call(xz9<? super gd4> xz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, xz9Var) != null) {
                return;
            }
            this.a.h = xz9Var;
        }
    }

    /* loaded from: classes4.dex */
    public class p extends m72<f72> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f72 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(f72 f72Var, f72 f72Var2) {
            super(f72Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var, f72Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((j72) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = f72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m72, com.baidu.tieba.tb4, com.baidu.tieba.wb4
        /* renamed from: s */
        public void c(fd4 fd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, fd4Var) == null) {
                super.c(fd4Var);
                f12.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tb4, com.baidu.tieba.wb4
        /* renamed from: u */
        public void f(fd4 fd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fd4Var) == null) {
                super.f(fd4Var);
                this.c.E0(fd4Var);
            }
        }

        @Override // com.baidu.tieba.m72, com.baidu.tieba.tb4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.c.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.m72
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.c.o;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.m72
        public void p(@NonNull fd4 fd4Var, @Nullable yf3 yf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, fd4Var, yf3Var) == null) {
                super.p(fd4Var, yf3Var);
                f12.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + fd4Var.i);
                f72 f72Var = this.c;
                if (f72Var.k == null) {
                    f72Var.k = new ArrayList();
                }
                f72 f72Var2 = this.c;
                fd4Var.o = f72Var2.o;
                if (yf3Var == null) {
                    f72Var2.k.add(fd4Var);
                    this.c.i.m(fd4Var);
                    b72.c().b(fd4Var, this.c.k0());
                } else {
                    f72Var2.i.l(fd4Var);
                    b72.c().a(fd4Var, this.c.k0(), yf3Var);
                }
                if (this.c.e != null) {
                    this.c.e.onNext(fd4Var);
                    if (!this.c.i.i()) {
                        this.c.e.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tb4, com.baidu.tieba.wb4
        /* renamed from: q */
        public void e(fd4 fd4Var, zc4 zc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, fd4Var, zc4Var) == null) {
                super.q(fd4Var, zc4Var);
                f12.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + zc4Var.toString());
                this.c.i.l(fd4Var);
                yf3 yf3Var = new yf3();
                yf3Var.k(12L);
                yf3Var.i(zc4Var.a);
                yf3Var.d("分包下载失败");
                yf3Var.f(zc4Var.toString());
                if (this.c.e != null) {
                    this.c.e.onError(new PkgDownloadError(fd4Var, yf3Var));
                }
                b72.c().a(fd4Var, this.c.k0(), yf3Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q extends k72<f72> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f72 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(f72 f72Var, f72 f72Var2) {
            super(f72Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var, f72Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((j72) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f72Var;
        }

        @Override // com.baidu.tieba.k72
        public void u(gd4 gd4Var, yf3 yf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, gd4Var, yf3Var) == null) {
                f12.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + yf3Var);
                this.b.i.l(gd4Var);
                if (this.b.h != null) {
                    this.b.h.onError(new PkgDownloadError(gd4Var, yf3Var));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.k72, com.baidu.tieba.tb4, com.baidu.tieba.wb4
        /* renamed from: v */
        public void c(gd4 gd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, gd4Var) == null) {
                super.c(gd4Var);
                f12.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.tb4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.k72
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.b.k0();
            }
            return (PMSDownloadType) invokeV.objValue;
        }

        @Override // com.baidu.tieba.k72
        public void r(@NonNull gd4 gd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, gd4Var) == null) {
                this.b.i.m(gd4Var);
                if (this.b.h != null) {
                    this.b.h.onNext(gd4Var);
                    if (!this.b.i.c()) {
                        this.b.h.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.k72, com.baidu.tieba.tb4, com.baidu.tieba.wb4
        /* renamed from: w */
        public void f(gd4 gd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, gd4Var) == null) {
                super.f(gd4Var);
                if (f72.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.b.i0() + ": dependent onDownloading");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r extends tb4<cd4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f72 a;

        public r(f72 f72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wb4
        /* renamed from: l */
        public String d(cd4 cd4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cd4Var)) == null) {
                int i = cd4Var.h;
                if (i == 0) {
                    return x72.h();
                }
                if (i == 1) {
                    return x72.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tb4, com.baidu.tieba.wb4
        /* renamed from: q */
        public void c(cd4 cd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, cd4Var) == null) {
                super.c(cd4Var);
                f12.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.yb4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.tb4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tb4, com.baidu.tieba.wb4
        /* renamed from: o */
        public void e(cd4 cd4Var, zc4 zc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cd4Var, zc4Var) == null) {
                super.e(cd4Var, zc4Var);
                f12.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + zc4Var.toString());
                this.a.i.l(cd4Var);
                yf3 yf3Var = new yf3();
                yf3Var.k(13L);
                yf3Var.i(zc4Var.a);
                yf3Var.d("Framework包下载失败");
                yf3Var.f(zc4Var.toString());
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(cd4Var, yf3Var));
                }
                b72.c().a(cd4Var, this.a.k0(), yf3Var);
                jk4.k(cd4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tb4, com.baidu.tieba.wb4
        /* renamed from: p */
        public void i(cd4 cd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, cd4Var) == null) {
                super.i(cd4Var);
                f12.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + cd4Var.i);
                yf3 y0 = this.a.y0(cd4Var);
                if (y0 == null) {
                    f72 f72Var = this.a;
                    f72Var.l = cd4Var;
                    f72Var.i.m(cd4Var);
                    if (this.a.f != null) {
                        this.a.f.onNext(cd4Var);
                        this.a.f.onCompleted();
                    }
                    b72.c().b(cd4Var, this.a.k0());
                    return;
                }
                this.a.i.l(cd4Var);
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(cd4Var, y0));
                }
                b72.c().a(cd4Var, this.a.k0(), y0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tb4, com.baidu.tieba.wb4
        /* renamed from: r */
        public void f(cd4 cd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, cd4Var) == null) {
                super.f(cd4Var);
                if (f72.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": framework onDownloading");
                }
                this.a.C0(cd4Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s extends tb4<ad4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f72 a;

        public s(f72 f72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wb4
        /* renamed from: l */
        public String d(ad4 ad4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ad4Var)) == null) {
                int i = ad4Var.h;
                if (i == 0) {
                    return x72.d();
                }
                if (i == 1) {
                    return x72.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tb4, com.baidu.tieba.wb4
        /* renamed from: q */
        public void c(ad4 ad4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, ad4Var) == null) {
                super.c(ad4Var);
                f12.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.yb4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.tb4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tb4, com.baidu.tieba.wb4
        /* renamed from: o */
        public void e(ad4 ad4Var, zc4 zc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ad4Var, zc4Var) == null) {
                super.e(ad4Var, zc4Var);
                f12.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + zc4Var.toString());
                this.a.i.l(ad4Var);
                yf3 yf3Var = new yf3();
                yf3Var.k(14L);
                yf3Var.i(zc4Var.a);
                yf3Var.d("Extension下载失败");
                yf3Var.f(zc4Var.toString());
                if (f72.C) {
                    Log.e("SwanAppPkgDownloadCallback", yf3Var.toString());
                }
                this.a.q0(ad4Var);
                b72.c().a(ad4Var, this.a.k0(), yf3Var);
                jk4.k(ad4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tb4, com.baidu.tieba.wb4
        /* renamed from: p */
        public void i(ad4 ad4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, ad4Var) == null) {
                super.i(ad4Var);
                f12.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + ad4Var.i);
                yf3 x0 = this.a.x0(ad4Var);
                if (x0 == null) {
                    f72 f72Var = this.a;
                    f72Var.m = ad4Var;
                    f72Var.i.m(ad4Var);
                    this.a.q0(ad4Var);
                    b72.c().b(ad4Var, this.a.k0());
                    return;
                }
                if (f72.C) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + ad4Var.toString());
                }
                this.a.i.l(ad4Var);
                this.a.q0(ad4Var);
                b72.c().a(ad4Var, this.a.k0(), x0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tb4, com.baidu.tieba.wb4
        /* renamed from: r */
        public void f(ad4 ad4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, ad4Var) == null) {
                super.f(ad4Var);
                if (f72.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": extension onDownloading");
                }
                this.a.B0(ad4Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t implements zb4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f72 a;

        public t(f72 f72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f72Var;
        }

        @Override // com.baidu.tieba.zb4
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (f72.C) {
                    Log.e("SwanAppPkgDownloadCallback", this.a.i0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                f72 f72Var = this.a;
                f72Var.n = pMSAppInfo;
                if (pMSAppInfo != null) {
                    f72Var.o0(pMSAppInfo);
                    d03.k(this.a.n.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u implements yi3<yi3<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public u(f72 f72Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.yi3
        /* renamed from: b */
        public void a(yi3<PMSAppInfo> yi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yi3Var) == null) {
                yi3Var.a(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public v(f72 f72Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var, collection, obj};
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

        public w(f72 f72Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var, collection, obj};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947716968, "Lcom/baidu/tieba/f72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947716968, "Lcom/baidu/tieba/f72;");
                return;
            }
        }
        C = pk1.a;
    }

    @Override // com.baidu.tieba.ac4
    public wb4<fd4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.w;
        }
        return (wb4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ac4
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    @Override // com.baidu.tieba.ac4
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
            return bc4.b(this, "get_launch_id").getString("launch_id", "");
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ac4
    public zb4 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.A;
        }
        return (zb4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ac4
    public wb4<gd4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.x;
        }
        return (wb4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ac4
    public wb4<ad4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.z;
        }
        return (wb4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ac4
    public wb4<cd4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.y;
        }
        return (wb4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ac4
    public wb4<ed4> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.v;
        }
        return (wb4) invokeV.objValue;
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            f12.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public f72(String str) {
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
        this.u = new ii3();
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

    @Override // com.baidu.tieba.ac4
    public void G(nh4 nh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, nh4Var) == null) {
            super.G(nh4Var);
            this.r = System.currentTimeMillis();
            if (C) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.r);
            }
            if (nh4Var == null) {
                return;
            }
            if (C) {
                Log.i("SwanAppPkgDownloadCallback", i0() + ": onPrepareDownload: countSet=" + nh4Var.n());
            }
            this.p.add(new UbcFlowEvent("na_pms_start_download"));
            this.i = nh4Var;
            if (!nh4Var.k()) {
                n0();
            }
        }
    }

    public yf3 y0(cd4 cd4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, cd4Var)) == null) {
            if (C) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + cd4Var);
            }
            pd3.b c2 = pd3.c(cd4Var, cd4Var.h);
            if (!TextUtils.isEmpty(cd4Var.a)) {
                f12.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + cd4Var.a);
                jk4.k(cd4Var.a);
            }
            if (!c2.c()) {
                yf3 yf3Var = new yf3();
                yf3Var.k(13L);
                yf3Var.b(2907L);
                yf3Var.d("Core包更新失败");
                return yf3Var;
            }
            return null;
        }
        return (yf3) invokeL.objValue;
    }

    public final void B0(ad4 ad4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ad4Var) == null) {
            b72.c().d(ad4Var, new i(this, ad4Var));
        }
    }

    public final void C0(cd4 cd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cd4Var) == null) {
            b72.c().d(cd4Var, new h(this, cd4Var));
        }
    }

    public final void D0(ed4 ed4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ed4Var) == null) {
            b72.c().d(ed4Var, new f(this, ed4Var));
        }
    }

    public final void E0(fd4 fd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fd4Var) == null) {
            b72.c().d(fd4Var, new g(this, fd4Var));
        }
    }

    public f72 e0(yi3<PMSAppInfo> yi3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, yi3Var)) == null) {
            f0(this.t, yi3Var);
            return this;
        }
        return (f72) invokeL.objValue;
    }

    public synchronized f72 g0(o72 o72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, o72Var)) == null) {
            synchronized (this) {
                f0(this.s, o72Var);
            }
            return this;
        }
        return (f72) invokeL.objValue;
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 == 1013) {
                cc4.i().z(this.o, i2);
            } else {
                cc4.i().z(this.o, 0);
            }
        }
    }

    public f72 o0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, pMSAppInfo)) == null) {
            p0(this.t, new u(this, pMSAppInfo));
            return this;
        }
        return (f72) invokeL.objValue;
    }

    public final void q0(ad4 ad4Var) {
        xz9<? super ad4> xz9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, ad4Var) == null) && (xz9Var = this.g) != null) {
            xz9Var.onNext(ad4Var);
            this.g.onCompleted();
        }
    }

    public f72 r0(@NonNull yi3<o72> yi3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, yi3Var)) == null) {
            p0(this.s, new c(this, yi3Var));
            return this;
        }
        return (f72) invokeL.objValue;
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
            yy2.a(this.o, str, this.p, str2);
            this.p.clear();
        }
    }

    public final synchronized <CallbackT> f72 f0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (f72) invokeLL.objValue;
    }

    public final synchronized <CallbackT> f72 h0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (f72) invokeLL.objValue;
    }

    public final synchronized <CallbackT> f72 p0(@NonNull Collection<CallbackT> collection, @NonNull yi3<CallbackT> yi3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, collection, yi3Var)) == null) {
            synchronized (this) {
                this.u.a(new b(this, collection, yi3Var));
            }
            return this;
        }
        return (f72) invokeLL.objValue;
    }

    public void t0(boolean z, yf3 yf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, yf3Var) == null) {
            r0(new d(this, yf3Var, z));
        }
    }

    @Override // com.baidu.tieba.ac4
    public void C(zc4 zc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, zc4Var) == null) {
            f12.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + zc4Var);
            if (zc4Var != null && zc4Var.a == 1010) {
                G0();
            }
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public yf3 z0(ed4 ed4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, ed4Var)) == null) {
            if (ed4Var == null) {
                yf3 yf3Var = new yf3();
                yf3Var.k(11L);
                yf3Var.i(2310L);
                yf3Var.f("pkg info is empty");
                cg3.a().f(yf3Var);
                return yf3Var;
            }
            return null;
        }
        return (yf3) invokeL.objValue;
    }

    public yf3 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PMSAppInfo pMSAppInfo = this.n;
            if (pMSAppInfo == null) {
                if (this.j == null) {
                    yf3 yf3Var = new yf3();
                    yf3Var.k(10L);
                    yf3Var.i(2903L);
                    yf3Var.d("Server未返回主包&AppInfo");
                    return yf3Var;
                }
                PMSAppInfo u2 = cc4.i().u(this.o);
                if (u2 == null) {
                    yf3 yf3Var2 = new yf3();
                    yf3Var2.k(10L);
                    yf3Var2.i(2904L);
                    yf3Var2.d("Server未返回AppInfo数据，本地也没有数据");
                    return yf3Var2;
                }
                this.n = u2;
                x72.k(u2, this.j);
                this.n.initMaxAgeInfo();
                this.n.updateInstallSrc(J());
                if (cc4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                    return null;
                }
                yf3 yf3Var3 = new yf3();
                yf3Var3.k(10L);
                yf3Var3.i(2906L);
                yf3Var3.d("更新DB失败");
                return yf3Var3;
            }
            ed4 ed4Var = this.j;
            if (ed4Var != null) {
                x72.k(pMSAppInfo, ed4Var);
            } else if (y72.f(this.k)) {
                fd4 fd4Var = this.k.get(0);
                this.q = fd4Var;
                fd4Var.o = this.o;
                x72.l(this.n, fd4Var);
            } else {
                PMSAppInfo u3 = cc4.i().u(this.o);
                if (u3 == null) {
                    yf3 yf3Var4 = new yf3();
                    yf3Var4.k(10L);
                    yf3Var4.i(2905L);
                    yf3Var4.d("Server未返回包数据，本地也没有数据");
                    return yf3Var4;
                }
                PMSAppInfo pMSAppInfo2 = this.n;
                pMSAppInfo2.appId = this.o;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.n.initMaxAgeInfo();
            this.n.updateInstallSrc(J());
            if (cc4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                x72.o(this.n);
                return null;
            }
            yf3 yf3Var5 = new yf3();
            yf3Var5.k(10L);
            yf3Var5.i(2906L);
            yf3Var5.d("更新DB失败");
            return yf3Var5;
        }
        return (yf3) invokeV.objValue;
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PMSAppInfo u2 = cc4.i().u(this.o);
            f12.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(J());
                ed4 ed4Var = this.j;
                if (ed4Var != null) {
                    ed4Var.c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.n;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(J());
                }
                cc4.i().l(u2);
            }
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.i.f()) {
                arrayList.add(rz9.a(new k(this)));
            }
            if (this.i.h()) {
                arrayList.add(rz9.a(new l(this)));
            }
            if (this.i.e()) {
                arrayList.add(rz9.a(new m(this)));
            }
            if (this.i.d()) {
                arrayList.add(rz9.a(new n(this)));
            }
            if (this.i.b()) {
                arrayList.add(rz9.a(new o(this)));
            }
            if (!arrayList.isEmpty()) {
                rz9.i(arrayList).u(this.B);
            }
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048609, this) != null) || this.n == null) {
            return;
        }
        PMSAppInfo u2 = cc4.i().u(this.o);
        if (u2 == null) {
            f12.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.n.appId = this.o;
        u2.updateInstallSrc(J());
        this.n.copyLocalAppInfoData(u2);
        this.n.initMaxAgeInfo();
        if (cc4.i().l(this.n)) {
            x72.o(this.n);
        }
    }

    public yf3 x0(ad4 ad4Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, ad4Var)) == null) {
            lf2 lf2Var = new lf2();
            lf2Var.b = ad4Var.i;
            lf2Var.a = ad4Var.j;
            lf2Var.c = ad4Var.a;
            lf2Var.d = ad4Var.m;
            if (oe2.b(ad4Var.h, lf2Var) == null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                yf3 yf3Var = new yf3();
                yf3Var.k(14L);
                yf3Var.b(2908L);
                yf3Var.d("Extension包更新失败");
                return yf3Var;
            }
            return null;
        }
        return (yf3) invokeL.objValue;
    }
}
