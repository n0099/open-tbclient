package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.model.PMSException;
import com.baidu.tieba.av9;
import com.baidu.tieba.w32;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes4.dex */
public abstract class i42 extends e42 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public gv9<? super v94> c;
    public gv9<? super t94> d;
    public ge4 e;
    public tf3<Exception> f;
    public p84<v94> g;
    public p84<t94> h;
    public gv9<w94> i;

    /* loaded from: classes4.dex */
    public class a extends m84<v94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i42 a;

        public a(i42 i42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p84
        /* renamed from: l */
        public String d(v94 v94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, v94Var)) == null) ? this.a.X() : (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.r84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: o */
        public void e(v94 v94Var, s94 s94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, v94Var, s94Var) == null) {
                super.e(v94Var, s94Var);
                ay1.k("UpdateCoreCallback", "onDownloadError:" + s94Var);
                this.a.e.l(v94Var);
                tc3 tc3Var = new tc3();
                tc3Var.k(13L);
                tc3Var.i(s94Var.a);
                tc3Var.d("Framework包下载失败");
                tc3Var.f(s94Var.toString());
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(v94Var, tc3Var));
                }
                w32.c().a(v94Var, this.a.V(), tc3Var);
                ch4.k(v94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: p */
        public void i(v94 v94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, v94Var) == null) {
                super.i(v94Var);
                ay1.k("UpdateCoreCallback", "onFileDownloaded: " + v94Var.i);
                tc3 c0 = this.a.c0(v94Var);
                if (c0 == null) {
                    this.a.e.m(v94Var);
                    if (this.a.c != null) {
                        this.a.c.onNext(v94Var);
                        this.a.c.onCompleted();
                    }
                    v84.i().m(v94Var);
                    w32.c().b(v94Var, this.a.V());
                    bf3.a();
                    return;
                }
                this.a.e.l(v94Var);
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(v94Var, c0));
                }
                w32.c().a(v94Var, this.a.V(), c0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: q */
        public void c(v94 v94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, v94Var) == null) {
                super.c(v94Var);
                ay1.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: r */
        public void f(v94 v94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, v94Var) == null) {
                super.f(v94Var);
                if (i42.j) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.a.g0(v94Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends m84<t94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i42 a;

        public b(i42 i42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p84
        /* renamed from: l */
        public String d(t94 t94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, t94Var)) == null) ? this.a.W() : (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.r84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: o */
        public void e(t94 t94Var, s94 s94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, t94Var, s94Var) == null) {
                super.e(t94Var, s94Var);
                ay1.k("UpdateCoreCallback", "onDownloadError:" + s94Var);
                this.a.e.l(t94Var);
                tc3 tc3Var = new tc3();
                tc3Var.k(14L);
                tc3Var.i(s94Var.a);
                tc3Var.d("Extension下载失败");
                tc3Var.f(s94Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(t94Var, tc3Var));
                }
                w32.c().a(t94Var, this.a.V(), tc3Var);
                ch4.k(t94Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: p */
        public void i(t94 t94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t94Var) == null) {
                super.i(t94Var);
                ay1.k("UpdateCoreCallback", "onFileDownloaded: " + t94Var.i);
                tc3 b0 = this.a.b0(t94Var);
                if (b0 == null) {
                    this.a.e.m(t94Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(t94Var);
                        this.a.d.onCompleted();
                    }
                    v84.i().m(t94Var);
                    w32.c().b(t94Var, this.a.V());
                    return;
                }
                this.a.e.l(t94Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(t94Var, b0));
                }
                w32.c().a(t94Var, this.a.V(), b0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: q */
        public void c(t94 t94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, t94Var) == null) {
                super.c(t94Var);
                ay1.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: r */
        public void f(t94 t94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, t94Var) == null) {
                super.f(t94Var);
                if (i42.j) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.a.f0(t94Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements w32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v94 a;
        public final /* synthetic */ i42 b;

        public c(i42 i42Var, v94 v94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i42Var, v94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i42Var;
            this.a = v94Var;
        }

        @Override // com.baidu.tieba.w32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.e.m(this.a);
                if (this.b.c != null) {
                    this.b.c.onNext(this.a);
                    this.b.c.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.w32.c
        public void b(PMSDownloadType pMSDownloadType, tc3 tc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, tc3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.c != null) {
                    this.b.c.onError(new PkgDownloadError(this.a, tc3Var));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements w32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t94 a;
        public final /* synthetic */ i42 b;

        public d(i42 i42Var, t94 t94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i42Var, t94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i42Var;
            this.a = t94Var;
        }

        @Override // com.baidu.tieba.w32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.e.m(this.a);
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
                this.b.e.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, tc3Var));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements av9.a<v94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i42 a;

        public e(i42 i42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.av9.a, com.baidu.tieba.ov9
        public void call(gv9<? super v94> gv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gv9Var) == null) {
                this.a.c = gv9Var;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements av9.a<t94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i42 a;

        public f(i42 i42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.av9.a, com.baidu.tieba.ov9
        public void call(gv9<? super t94> gv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gv9Var) == null) {
                this.a.d = gv9Var;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends gv9<w94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i42 e;

        public g(i42 i42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = i42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bv9
        /* renamed from: g */
        public void onNext(w94 w94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, w94Var) == null) {
                ay1.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + w94Var.i);
            }
        }

        @Override // com.baidu.tieba.bv9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ay1.k("UpdateCoreCallback", "包下载完成");
                this.e.e0();
            }
        }

        @Override // com.baidu.tieba.bv9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                ay1.l("UpdateCoreCallback", "OnError", th);
                this.e.d0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947803458, "Lcom/baidu/tieba/i42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947803458, "Lcom/baidu/tieba/i42;");
                return;
            }
        }
        j = kh1.a;
    }

    public i42(tf3<Exception> tf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tf3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = tf3Var;
    }

    @Override // com.baidu.tieba.t84
    public void C(s94 s94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, s94Var) == null) {
            super.C(s94Var);
            ay1.k("UpdateCoreCallback", "onFetchError: " + s94Var.toString());
            if (s94Var.a == 1010) {
                e0();
                return;
            }
            d0(new PMSException("UpdateCoreCallback failed by fetch error = " + s94Var, s94Var));
        }
    }

    @Override // com.baidu.tieba.t84
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (j) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.t84
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            ay1.k("UpdateCoreCallback", "onNoPackage:");
            e0();
        }
    }

    @Override // com.baidu.tieba.t84
    public void G(ge4 ge4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ge4Var) == null) {
            super.G(ge4Var);
            if (ge4Var == null) {
                return;
            }
            this.e = ge4Var;
            if (ge4Var.k()) {
                return;
            }
            Z();
        }
    }

    public abstract int U();

    public abstract PMSDownloadType V();

    public abstract String W();

    public abstract String X();

    public final gv9<w94> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == null) {
                this.i = new g(this);
            }
            return this.i;
        }
        return (gv9) invokeV.objValue;
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.e.e()) {
                arrayList.add(av9.a(new e(this)));
            }
            if (this.e.d()) {
                arrayList.add(av9.a(new f(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            av9.i(arrayList).u(Y());
        }
    }

    public void a0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            ay1.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            tf3<Exception> tf3Var = this.f;
            if (tf3Var != null) {
                tf3Var.a(exc);
            }
            this.f = null;
        }
    }

    public abstract tc3 b0(t94 t94Var);

    public abstract tc3 c0(v94 v94Var);

    public void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            ay1.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            zd4.d(U(), 0L);
            wk3.a(0L);
            a0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            ay1.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            zd4.d(U(), currentTimeMillis);
            a0(null);
        }
    }

    public final void f0(t94 t94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, t94Var) == null) {
            w32.c().d(t94Var, new d(this, t94Var));
        }
    }

    public final void g0(v94 v94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, v94Var) == null) {
            w32.c().d(v94Var, new c(this, v94Var));
        }
    }

    @Override // com.baidu.tieba.t84
    public p84<t94> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == null) {
                this.h = new b(this);
            }
            return this.h;
        }
        return (p84) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t84
    public p84<v94> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.g == null) {
                this.g = new a(this);
            }
            return this.g;
        }
        return (p84) invokeV.objValue;
    }
}
