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
import com.baidu.tieba.e13;
import com.baidu.tieba.ka3;
import com.baidu.tieba.w32;
import com.baidu.tieba.yu9;
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
/* loaded from: classes3.dex */
public abstract class a42 extends e42 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public s84 A;
    public ev9<w94> B;
    public String c;
    public ev9<? super x94> d;
    public ev9<? super y94> e;
    public ev9<? super v94> f;
    public ev9<? super t94> g;
    public ev9<? super z94> h;
    public ge4 i;
    public x94 j;
    public List<y94> k;
    public v94 l;
    public t94 m;
    public PMSAppInfo n;
    public String o;
    public List<UbcFlowEvent> p;
    public y94 q;
    public long r;
    public final Set<j42> s;
    public final Set<tf3<PMSAppInfo>> t;
    public final df3 u;
    public p84<x94> v;
    public p84<y94> w;
    public final p84<z94> x;
    public p84<v94> y;
    public p84<t94> z;

    /* loaded from: classes3.dex */
    public class a extends m84<x94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a42 a;

        /* renamed from: com.baidu.tieba.a42$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0199a implements tf3<e13.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0199a(a aVar) {
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
            @Override // com.baidu.tieba.tf3
            /* renamed from: b */
            public void a(e13.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.b)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    u84.a(this.a.a, bundle, "event_performance_ubc");
                }
            }
        }

        public a(a42 a42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a42Var;
        }

        @Override // com.baidu.tieba.m84
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.j0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p84
        /* renamed from: l */
        public String d(x94 x94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, x94Var)) == null) {
                int i = x94Var.h;
                if (i == 0) {
                    return s42.g();
                }
                if (i == 1) {
                    return s42.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.r84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: o */
        public void e(x94 x94Var, s94 s94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, x94Var, s94Var) == null) {
                super.e(x94Var, s94Var);
                ay1.k("SwanAppPkgDownloadCallback", "onDownloadError：" + s94Var.toString());
                this.a.i.l(x94Var);
                tc3 tc3Var = new tc3();
                tc3Var.k(11L);
                tc3Var.i(s94Var.a);
                tc3Var.d("主包下载失败");
                tc3Var.f(s94Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(x94Var, tc3Var));
                }
                w32.c().a(x94Var, this.a.k0(), tc3Var);
                ch4.k(x94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: p */
        public void i(x94 x94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, x94Var) == null) {
                String l0 = this.a.l0();
                if (a42.C) {
                    fm2.d(l0).e().d(1);
                }
                super.i(x94Var);
                this.a.p.add(new UbcFlowEvent("na_pms_end_download"));
                tc3 z0 = this.a.z0(x94Var);
                ay1.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + x94Var.i);
                if (z0 == null) {
                    a42 a42Var = this.a;
                    a42Var.j = x94Var;
                    a42Var.i.m(x94Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(x94Var);
                        if (a42.C) {
                            Log.d("SwanAppPkgDownloadCallback", this.a.i0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.a.d.onCompleted();
                    }
                    w32.c().b(x94Var, this.a.k0());
                    return;
                }
                this.a.i.l(x94Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(x94Var, z0));
                }
                w32.c().a(x94Var, this.a.k0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: q */
        public void c(x94 x94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, x94Var) == null) {
                String l0 = this.a.l0();
                if (a42.C) {
                    fm2.d(l0).e().d(1);
                }
                super.c(x94Var);
                ay1.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: r */
        public void f(x94 x94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, x94Var) == null) {
                String l0 = this.a.l0();
                if (a42.C) {
                    fm2.d(l0).e().d(1);
                }
                super.f(x94Var);
                if (a42.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": main onDownloading");
                }
                this.a.D0(x94Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: s */
        public s94 h(x94 x94Var, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{x94Var, file, Long.valueOf(j), readableByteChannel})) == null) {
                String l0 = this.a.l0();
                if (a42.C) {
                    fm2.d(l0).f(x94Var.toString()).d(1);
                }
                C0199a c0199a = new C0199a(this);
                Bundle bundle = new Bundle();
                bundle.putLong(CloudStabilityUBCUtils.KEY_LENGTH, j);
                bundle.putFloat("progress_granularity", 0.1f);
                yj2 yj2Var = new yj2();
                yj2Var.u(c0199a);
                yj2Var.K(bundle);
                yj2Var.J(new xj2(x94Var, this.a));
                yj2Var.J(new vj2(x94Var.m, this.a));
                yj2Var.M(readableByteChannel);
                boolean N = yj2Var.N();
                yj2Var.o(c0199a);
                if (a42.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": onProcessStream: installOk=" + N);
                }
                if (N) {
                    ay1.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    ch4.L(file);
                }
                return N ? new s94(2300, "业务层处理下载流成功") : new s94(2301, "业务层处理下载流失败");
            }
            return (s94) invokeCommon.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ tf3 b;

        public b(a42 a42Var, Collection collection, tf3 tf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a42Var, collection, tf3Var};
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
            this.b = tf3Var;
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

    /* loaded from: classes3.dex */
    public class c implements tf3<j42> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tf3 a;
        public final /* synthetic */ a42 b;

        public c(a42 a42Var, tf3 tf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a42Var, tf3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a42Var;
            this.a = tf3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tf3
        /* renamed from: b */
        public void a(j42 j42Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j42Var) == null) {
                this.a.a(j42Var);
                a42 a42Var = this.b;
                a42Var.h0(a42Var.s, j42Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements tf3<j42> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tc3 a;
        public final /* synthetic */ boolean b;

        public d(a42 a42Var, tc3 tc3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a42Var, tc3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tc3Var;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tf3
        /* renamed from: b */
        public void a(j42 j42Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j42Var) == null) {
                j42Var.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements tf3<j42> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public e(a42 a42Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a42Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.tf3
        /* renamed from: b */
        public void a(j42 j42Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j42Var) == null) {
                j42Var.b(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements w32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x94 a;
        public final /* synthetic */ a42 b;

        public f(a42 a42Var, x94 x94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a42Var, x94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a42Var;
            this.a = x94Var;
        }

        @Override // com.baidu.tieba.w32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                a42 a42Var = this.b;
                x94 x94Var = this.a;
                a42Var.j = x94Var;
                a42Var.i.m(x94Var);
                if (this.b.d != null) {
                    this.b.d.onNext(this.a);
                    this.b.d.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.w32.c
        public void b(PMSDownloadType pMSDownloadType, tc3 tc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, tc3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, tc3Var));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements w32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y94 a;
        public final /* synthetic */ a42 b;

        public g(a42 a42Var, y94 y94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a42Var, y94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a42Var;
            this.a = y94Var;
        }

        @Override // com.baidu.tieba.w32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                a42 a42Var = this.b;
                if (a42Var.k == null) {
                    a42Var.k = new ArrayList();
                }
                y94 y94Var = this.a;
                a42 a42Var2 = this.b;
                y94Var.o = a42Var2.o;
                a42Var2.k.add(y94Var);
                this.b.i.m(this.a);
                if (this.b.e != null) {
                    this.b.e.onNext(this.a);
                    if (this.b.i.i()) {
                        return;
                    }
                    this.b.e.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.w32.c
        public void b(PMSDownloadType pMSDownloadType, tc3 tc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, tc3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.e != null) {
                    this.b.e.onError(new PkgDownloadError(this.a, tc3Var));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements w32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v94 a;
        public final /* synthetic */ a42 b;

        public h(a42 a42Var, v94 v94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a42Var, v94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a42Var;
            this.a = v94Var;
        }

        @Override // com.baidu.tieba.w32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                a42 a42Var = this.b;
                v94 v94Var = this.a;
                a42Var.l = v94Var;
                a42Var.i.m(v94Var);
                if (this.b.f != null) {
                    this.b.f.onNext(this.a);
                    this.b.f.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.w32.c
        public void b(PMSDownloadType pMSDownloadType, tc3 tc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, tc3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.f != null) {
                    this.b.f.onError(new PkgDownloadError(this.a, tc3Var));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements w32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t94 a;
        public final /* synthetic */ a42 b;

        public i(a42 a42Var, t94 t94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a42Var, t94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a42Var;
            this.a = t94Var;
        }

        @Override // com.baidu.tieba.w32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                ay1.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                a42 a42Var = this.b;
                t94 t94Var = this.a;
                a42Var.m = t94Var;
                a42Var.i.m(t94Var);
                this.b.q0(this.a);
            }
        }

        @Override // com.baidu.tieba.w32.c
        public void b(PMSDownloadType pMSDownloadType, tc3 tc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, tc3Var) == null) {
                ay1.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + tc3Var.toString());
                this.b.i.l(this.a);
                this.b.q0(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j extends ev9<w94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a42 e;

        public j(a42 a42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = a42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zu9
        /* renamed from: g */
        public void onNext(w94 w94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, w94Var) == null) {
                ay1.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 单个包下载、业务层处理完成：" + w94Var.i);
            }
        }

        @Override // com.baidu.tieba.zu9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ay1.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载onCompleted");
                this.e.v0();
            }
        }

        @Override // com.baidu.tieba.zu9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                ay1.l("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载OnError", th);
                this.e.w0(th);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements yu9.a<x94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a42 a;

        public k(a42 a42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yu9.a, com.baidu.tieba.mv9
        public void call(ev9<? super x94> ev9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ev9Var) == null) {
                this.a.d = ev9Var;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements yu9.a<y94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a42 a;

        public l(a42 a42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yu9.a, com.baidu.tieba.mv9
        public void call(ev9<? super y94> ev9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ev9Var) == null) {
                this.a.e = ev9Var;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements yu9.a<v94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a42 a;

        public m(a42 a42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yu9.a, com.baidu.tieba.mv9
        public void call(ev9<? super v94> ev9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ev9Var) == null) {
                this.a.f = ev9Var;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements yu9.a<t94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a42 a;

        public n(a42 a42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yu9.a, com.baidu.tieba.mv9
        public void call(ev9<? super t94> ev9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ev9Var) == null) {
                this.a.g = ev9Var;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o implements yu9.a<z94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a42 a;

        public o(a42 a42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yu9.a, com.baidu.tieba.mv9
        public void call(ev9<? super z94> ev9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ev9Var) == null) {
                this.a.h = ev9Var;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p extends h42<a42> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a42 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(a42 a42Var, a42 a42Var2) {
            super(a42Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a42Var, a42Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((e42) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = a42Var;
        }

        @Override // com.baidu.tieba.h42, com.baidu.tieba.m84
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c.j0() : invokeV.intValue;
        }

        @Override // com.baidu.tieba.h42
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c.o : (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.h42
        public void p(@NonNull y94 y94Var, @Nullable tc3 tc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, y94Var, tc3Var) == null) {
                super.p(y94Var, tc3Var);
                ay1.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + y94Var.i);
                a42 a42Var = this.c;
                if (a42Var.k == null) {
                    a42Var.k = new ArrayList();
                }
                a42 a42Var2 = this.c;
                y94Var.o = a42Var2.o;
                if (tc3Var == null) {
                    a42Var2.k.add(y94Var);
                    this.c.i.m(y94Var);
                    w32.c().b(y94Var, this.c.k0());
                } else {
                    a42Var2.i.l(y94Var);
                    w32.c().a(y94Var, this.c.k0(), tc3Var);
                }
                if (this.c.e != null) {
                    this.c.e.onNext(y94Var);
                    if (this.c.i.i()) {
                        return;
                    }
                    this.c.e.onCompleted();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: q */
        public void e(y94 y94Var, s94 s94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, y94Var, s94Var) == null) {
                super.q(y94Var, s94Var);
                ay1.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + s94Var.toString());
                this.c.i.l(y94Var);
                tc3 tc3Var = new tc3();
                tc3Var.k(12L);
                tc3Var.i(s94Var.a);
                tc3Var.d("分包下载失败");
                tc3Var.f(s94Var.toString());
                if (this.c.e != null) {
                    this.c.e.onError(new PkgDownloadError(y94Var, tc3Var));
                }
                w32.c().a(y94Var, this.c.k0(), tc3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.h42, com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: s */
        public void c(y94 y94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, y94Var) == null) {
                super.c(y94Var);
                ay1.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: u */
        public void f(y94 y94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, y94Var) == null) {
                super.f(y94Var);
                this.c.E0(y94Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q extends f42<a42> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a42 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(a42 a42Var, a42 a42Var2) {
            super(a42Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a42Var, a42Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((e42) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a42Var;
        }

        @Override // com.baidu.tieba.m84
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b.j0() : invokeV.intValue;
        }

        @Override // com.baidu.tieba.f42
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b.k0() : (PMSDownloadType) invokeV.objValue;
        }

        @Override // com.baidu.tieba.f42
        public void r(@NonNull z94 z94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, z94Var) == null) {
                this.b.i.m(z94Var);
                if (this.b.h != null) {
                    this.b.h.onNext(z94Var);
                    if (this.b.i.c()) {
                        return;
                    }
                    this.b.h.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.f42
        public void u(z94 z94Var, tc3 tc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, z94Var, tc3Var) == null) {
                ay1.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + tc3Var);
                this.b.i.l(z94Var);
                if (this.b.h != null) {
                    this.b.h.onError(new PkgDownloadError(z94Var, tc3Var));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.f42, com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: v */
        public void c(z94 z94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, z94Var) == null) {
                super.c(z94Var);
                ay1.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.f42, com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: w */
        public void f(z94 z94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, z94Var) == null) {
                super.f(z94Var);
                if (a42.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.b.i0() + ": dependent onDownloading");
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r extends m84<v94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a42 a;

        public r(a42 a42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a42Var;
        }

        @Override // com.baidu.tieba.m84
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.j0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p84
        /* renamed from: l */
        public String d(v94 v94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, v94Var)) == null) {
                int i = v94Var.h;
                if (i == 0) {
                    return s42.h();
                }
                if (i == 1) {
                    return s42.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.r84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: o */
        public void e(v94 v94Var, s94 s94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, v94Var, s94Var) == null) {
                super.e(v94Var, s94Var);
                ay1.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + s94Var.toString());
                this.a.i.l(v94Var);
                tc3 tc3Var = new tc3();
                tc3Var.k(13L);
                tc3Var.i(s94Var.a);
                tc3Var.d("Framework包下载失败");
                tc3Var.f(s94Var.toString());
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(v94Var, tc3Var));
                }
                w32.c().a(v94Var, this.a.k0(), tc3Var);
                ch4.k(v94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: p */
        public void i(v94 v94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, v94Var) == null) {
                super.i(v94Var);
                ay1.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + v94Var.i);
                tc3 y0 = this.a.y0(v94Var);
                if (y0 == null) {
                    a42 a42Var = this.a;
                    a42Var.l = v94Var;
                    a42Var.i.m(v94Var);
                    if (this.a.f != null) {
                        this.a.f.onNext(v94Var);
                        this.a.f.onCompleted();
                    }
                    w32.c().b(v94Var, this.a.k0());
                    return;
                }
                this.a.i.l(v94Var);
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(v94Var, y0));
                }
                w32.c().a(v94Var, this.a.k0(), y0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: q */
        public void c(v94 v94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, v94Var) == null) {
                super.c(v94Var);
                ay1.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: r */
        public void f(v94 v94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, v94Var) == null) {
                super.f(v94Var);
                if (a42.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": framework onDownloading");
                }
                this.a.C0(v94Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class s extends m84<t94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a42 a;

        public s(a42 a42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a42Var;
        }

        @Override // com.baidu.tieba.m84
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.j0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p84
        /* renamed from: l */
        public String d(t94 t94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, t94Var)) == null) {
                int i = t94Var.h;
                if (i == 0) {
                    return s42.d();
                }
                if (i == 1) {
                    return s42.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.r84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: o */
        public void e(t94 t94Var, s94 s94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t94Var, s94Var) == null) {
                super.e(t94Var, s94Var);
                ay1.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + s94Var.toString());
                this.a.i.l(t94Var);
                tc3 tc3Var = new tc3();
                tc3Var.k(14L);
                tc3Var.i(s94Var.a);
                tc3Var.d("Extension下载失败");
                tc3Var.f(s94Var.toString());
                if (a42.C) {
                    Log.e("SwanAppPkgDownloadCallback", tc3Var.toString());
                }
                this.a.q0(t94Var);
                w32.c().a(t94Var, this.a.k0(), tc3Var);
                ch4.k(t94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: p */
        public void i(t94 t94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, t94Var) == null) {
                super.i(t94Var);
                ay1.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + t94Var.i);
                tc3 x0 = this.a.x0(t94Var);
                if (x0 != null) {
                    if (a42.C) {
                        Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + t94Var.toString());
                    }
                    this.a.i.l(t94Var);
                    this.a.q0(t94Var);
                    w32.c().a(t94Var, this.a.k0(), x0);
                    return;
                }
                a42 a42Var = this.a;
                a42Var.m = t94Var;
                a42Var.i.m(t94Var);
                this.a.q0(t94Var);
                w32.c().b(t94Var, this.a.k0());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: q */
        public void c(t94 t94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, t94Var) == null) {
                super.c(t94Var);
                ay1.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: r */
        public void f(t94 t94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, t94Var) == null) {
                super.f(t94Var);
                if (a42.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": extension onDownloading");
                }
                this.a.B0(t94Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class t implements s84 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a42 a;

        public t(a42 a42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a42Var;
        }

        @Override // com.baidu.tieba.s84
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (a42.C) {
                    Log.e("SwanAppPkgDownloadCallback", this.a.i0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                a42 a42Var = this.a;
                a42Var.n = pMSAppInfo;
                if (pMSAppInfo != null) {
                    a42Var.o0(pMSAppInfo);
                    yw2.k(this.a.n.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u implements tf3<tf3<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public u(a42 a42Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a42Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.tf3
        /* renamed from: b */
        public void a(tf3<PMSAppInfo> tf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tf3Var) == null) {
                tf3Var.a(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public v(a42 a42Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a42Var, collection, obj};
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

    /* loaded from: classes3.dex */
    public class w implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public w(a42 a42Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a42Var, collection, obj};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947565130, "Lcom/baidu/tieba/a42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947565130, "Lcom/baidu/tieba/a42;");
                return;
            }
        }
        C = kh1.a;
    }

    public a42(String str) {
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
        this.u = new df3();
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

    @Override // com.baidu.tieba.t84
    public p84<y94> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.w : (p84) invokeV.objValue;
    }

    public void A0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            tv2.a(this.o, str, this.p, str2);
            this.p.clear();
        }
    }

    public final void B0(t94 t94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t94Var) == null) {
            w32.c().d(t94Var, new i(this, t94Var));
        }
    }

    @Override // com.baidu.tieba.t84
    public void C(s94 s94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, s94Var) == null) {
            ay1.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + s94Var);
            if (s94Var != null && s94Var.a == 1010) {
                G0();
            }
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void C0(v94 v94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, v94Var) == null) {
            w32.c().d(v94Var, new h(this, v94Var));
        }
    }

    @Override // com.baidu.tieba.t84
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    public final void D0(x94 x94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, x94Var) == null) {
            w32.c().d(x94Var, new f(this, x94Var));
        }
    }

    @Override // com.baidu.tieba.t84
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void E0(y94 y94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, y94Var) == null) {
            w32.c().d(y94Var, new g(this, y94Var));
        }
    }

    public tc3 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PMSAppInfo pMSAppInfo = this.n;
            if (pMSAppInfo == null) {
                if (this.j == null) {
                    tc3 tc3Var = new tc3();
                    tc3Var.k(10L);
                    tc3Var.i(2903L);
                    tc3Var.d("Server未返回主包&AppInfo");
                    return tc3Var;
                }
                PMSAppInfo u2 = v84.i().u(this.o);
                if (u2 == null) {
                    tc3 tc3Var2 = new tc3();
                    tc3Var2.k(10L);
                    tc3Var2.i(2904L);
                    tc3Var2.d("Server未返回AppInfo数据，本地也没有数据");
                    return tc3Var2;
                }
                this.n = u2;
                s42.k(u2, this.j);
                this.n.initMaxAgeInfo();
                this.n.updateInstallSrc(J());
                if (v84.i().b(this.j, this.k, this.l, this.m, this.n)) {
                    return null;
                }
                tc3 tc3Var3 = new tc3();
                tc3Var3.k(10L);
                tc3Var3.i(2906L);
                tc3Var3.d("更新DB失败");
                return tc3Var3;
            }
            x94 x94Var = this.j;
            if (x94Var != null) {
                s42.k(pMSAppInfo, x94Var);
            } else if (t42.f(this.k)) {
                y94 y94Var = this.k.get(0);
                this.q = y94Var;
                y94Var.o = this.o;
                s42.l(this.n, y94Var);
            } else {
                PMSAppInfo u3 = v84.i().u(this.o);
                if (u3 == null) {
                    tc3 tc3Var4 = new tc3();
                    tc3Var4.k(10L);
                    tc3Var4.i(2905L);
                    tc3Var4.d("Server未返回包数据，本地也没有数据");
                    return tc3Var4;
                }
                PMSAppInfo pMSAppInfo2 = this.n;
                pMSAppInfo2.appId = this.o;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.n.initMaxAgeInfo();
            this.n.updateInstallSrc(J());
            if (v84.i().b(this.j, this.k, this.l, this.m, this.n)) {
                s42.o(this.n);
                return null;
            }
            tc3 tc3Var5 = new tc3();
            tc3Var5.k(10L);
            tc3Var5.i(2906L);
            tc3Var5.d("更新DB失败");
            return tc3Var5;
        }
        return (tc3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t84
    public void G(ge4 ge4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ge4Var) == null) {
            super.G(ge4Var);
            this.r = System.currentTimeMillis();
            if (C) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.r);
            }
            if (ge4Var == null) {
                return;
            }
            if (C) {
                Log.i("SwanAppPkgDownloadCallback", i0() + ": onPrepareDownload: countSet=" + ge4Var.n());
            }
            this.p.add(new UbcFlowEvent("na_pms_start_download"));
            this.i = ge4Var;
            if (ge4Var.k()) {
                return;
            }
            n0();
        }
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PMSAppInfo u2 = v84.i().u(this.o);
            ay1.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(J());
                x94 x94Var = this.j;
                if (x94Var != null) {
                    x94Var.c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.n;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(J());
                }
                v84.i().l(u2);
            }
        }
    }

    public a42 e0(tf3<PMSAppInfo> tf3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, tf3Var)) == null) {
            f0(this.t, tf3Var);
            return this;
        }
        return (a42) invokeL.objValue;
    }

    public final synchronized <CallbackT> a42 f0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (a42) invokeLL.objValue;
    }

    public synchronized a42 g0(j42 j42Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, j42Var)) == null) {
            synchronized (this) {
                f0(this.s, j42Var);
            }
            return this;
        }
        return (a42) invokeL.objValue;
    }

    public final synchronized <CallbackT> a42 h0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (a42) invokeLL.objValue;
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

    public int j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return 100;
        }
        return invokeV.intValue;
    }

    public abstract PMSDownloadType k0();

    public final String l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? u84.b(this, "get_launch_id").getString("launch_id", "") : (String) invokeV.objValue;
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 == 1013) {
                v84.i().z(this.o, i2);
            } else {
                v84.i().z(this.o, 0);
            }
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.i.f()) {
                arrayList.add(yu9.a(new k(this)));
            }
            if (this.i.h()) {
                arrayList.add(yu9.a(new l(this)));
            }
            if (this.i.e()) {
                arrayList.add(yu9.a(new m(this)));
            }
            if (this.i.d()) {
                arrayList.add(yu9.a(new n(this)));
            }
            if (this.i.b()) {
                arrayList.add(yu9.a(new o(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            yu9.i(arrayList).u(this.B);
        }
    }

    public a42 o0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, pMSAppInfo)) == null) {
            p0(this.t, new u(this, pMSAppInfo));
            return this;
        }
        return (a42) invokeL.objValue;
    }

    @Override // com.baidu.tieba.t84
    public s84 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.A : (s84) invokeV.objValue;
    }

    public final synchronized <CallbackT> a42 p0(@NonNull Collection<CallbackT> collection, @NonNull tf3<CallbackT> tf3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, collection, tf3Var)) == null) {
            synchronized (this) {
                this.u.a(new b(this, collection, tf3Var));
            }
            return this;
        }
        return (a42) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.t84
    public p84<z94> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.x : (p84) invokeV.objValue;
    }

    public final void q0(t94 t94Var) {
        ev9<? super t94> ev9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, t94Var) == null) || (ev9Var = this.g) == null) {
            return;
        }
        ev9Var.onNext(t94Var);
        this.g.onCompleted();
    }

    @Override // com.baidu.tieba.t84
    public p84<t94> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.z : (p84) invokeV.objValue;
    }

    public a42 r0(@NonNull tf3<j42> tf3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, tf3Var)) == null) {
            p0(this.s, new c(this, tf3Var));
            return this;
        }
        return (a42) invokeL.objValue;
    }

    @Override // com.baidu.tieba.t84
    public p84<v94> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.y : (p84) invokeV.objValue;
    }

    public void s0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, pMSAppInfo) == null) {
            r0(new e(this, pMSAppInfo));
        }
    }

    public void t0(boolean z, tc3 tc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, tc3Var) == null) {
            r0(new d(this, tc3Var, z));
        }
    }

    @Override // com.baidu.tieba.t84
    public p84<x94> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.v : (p84) invokeV.objValue;
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.n == null) {
            return;
        }
        PMSAppInfo u2 = v84.i().u(this.o);
        if (u2 == null) {
            ay1.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.n.appId = this.o;
        u2.updateInstallSrc(J());
        this.n.copyLocalAppInfoData(u2);
        this.n.initMaxAgeInfo();
        if (v84.i().l(this.n)) {
            s42.o(this.n);
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            ay1.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public abstract void w0(Throwable th);

    public tc3 x0(t94 t94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, t94Var)) == null) {
            gc2 gc2Var = new gc2();
            gc2Var.b = t94Var.i;
            gc2Var.a = t94Var.j;
            gc2Var.c = t94Var.a;
            gc2Var.d = t94Var.m;
            if (jb2.b(t94Var.h, gc2Var) == null) {
                return null;
            }
            tc3 tc3Var = new tc3();
            tc3Var.k(14L);
            tc3Var.b(2908L);
            tc3Var.d("Extension包更新失败");
            return tc3Var;
        }
        return (tc3) invokeL.objValue;
    }

    public tc3 y0(v94 v94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, v94Var)) == null) {
            if (C) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + v94Var);
            }
            ka3.b c2 = ka3.c(v94Var, v94Var.h);
            if (!TextUtils.isEmpty(v94Var.a)) {
                ay1.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + v94Var.a);
                ch4.k(v94Var.a);
            }
            if (c2.c()) {
                return null;
            }
            tc3 tc3Var = new tc3();
            tc3Var.k(13L);
            tc3Var.b(2907L);
            tc3Var.d("Core包更新失败");
            return tc3Var;
        }
        return (tc3) invokeL.objValue;
    }

    public tc3 z0(x94 x94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, x94Var)) == null) {
            if (x94Var == null) {
                tc3 tc3Var = new tc3();
                tc3Var.k(11L);
                tc3Var.i(2310L);
                tc3Var.f("pkg info is empty");
                xc3.a().f(tc3Var);
                return tc3Var;
            }
            return null;
        }
        return (tc3) invokeL.objValue;
    }
}
