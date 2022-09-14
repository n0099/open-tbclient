package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.model.PMSException;
import com.baidu.tieba.qw9;
import com.baidu.tieba.u52;
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
public abstract class g62 extends c62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public ww9<? super vb4> c;
    public ww9<? super tb4> d;
    public gg4 e;
    public rh3<Exception> f;
    public pa4<vb4> g;
    public pa4<tb4> h;
    public ww9<wb4> i;

    /* loaded from: classes4.dex */
    public class a extends ma4<vb4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g62 a;

        public a(g62 g62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pa4
        /* renamed from: l */
        public String d(vb4 vb4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, vb4Var)) == null) ? this.a.X() : (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.ra4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: o */
        public void e(vb4 vb4Var, sb4 sb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, vb4Var, sb4Var) == null) {
                super.e(vb4Var, sb4Var);
                yz1.k("UpdateCoreCallback", "onDownloadError:" + sb4Var);
                this.a.e.l(vb4Var);
                re3 re3Var = new re3();
                re3Var.k(13L);
                re3Var.i(sb4Var.a);
                re3Var.d("Framework包下载失败");
                re3Var.f(sb4Var.toString());
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(vb4Var, re3Var));
                }
                u52.c().a(vb4Var, this.a.V(), re3Var);
                cj4.k(vb4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: p */
        public void i(vb4 vb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vb4Var) == null) {
                super.i(vb4Var);
                yz1.k("UpdateCoreCallback", "onFileDownloaded: " + vb4Var.i);
                re3 c0 = this.a.c0(vb4Var);
                if (c0 == null) {
                    this.a.e.m(vb4Var);
                    if (this.a.c != null) {
                        this.a.c.onNext(vb4Var);
                        this.a.c.onCompleted();
                    }
                    va4.i().m(vb4Var);
                    u52.c().b(vb4Var, this.a.V());
                    zg3.a();
                    return;
                }
                this.a.e.l(vb4Var);
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(vb4Var, c0));
                }
                u52.c().a(vb4Var, this.a.V(), c0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: q */
        public void c(vb4 vb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, vb4Var) == null) {
                super.c(vb4Var);
                yz1.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: r */
        public void f(vb4 vb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, vb4Var) == null) {
                super.f(vb4Var);
                if (g62.j) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.a.g0(vb4Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends ma4<tb4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g62 a;

        public b(g62 g62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pa4
        /* renamed from: l */
        public String d(tb4 tb4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, tb4Var)) == null) ? this.a.W() : (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.ra4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: o */
        public void e(tb4 tb4Var, sb4 sb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, tb4Var, sb4Var) == null) {
                super.e(tb4Var, sb4Var);
                yz1.k("UpdateCoreCallback", "onDownloadError:" + sb4Var);
                this.a.e.l(tb4Var);
                re3 re3Var = new re3();
                re3Var.k(14L);
                re3Var.i(sb4Var.a);
                re3Var.d("Extension下载失败");
                re3Var.f(sb4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(tb4Var, re3Var));
                }
                u52.c().a(tb4Var, this.a.V(), re3Var);
                cj4.k(tb4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: p */
        public void i(tb4 tb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tb4Var) == null) {
                super.i(tb4Var);
                yz1.k("UpdateCoreCallback", "onFileDownloaded: " + tb4Var.i);
                re3 b0 = this.a.b0(tb4Var);
                if (b0 == null) {
                    this.a.e.m(tb4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(tb4Var);
                        this.a.d.onCompleted();
                    }
                    va4.i().m(tb4Var);
                    u52.c().b(tb4Var, this.a.V());
                    return;
                }
                this.a.e.l(tb4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(tb4Var, b0));
                }
                u52.c().a(tb4Var, this.a.V(), b0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: q */
        public void c(tb4 tb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, tb4Var) == null) {
                super.c(tb4Var);
                yz1.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: r */
        public void f(tb4 tb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, tb4Var) == null) {
                super.f(tb4Var);
                if (g62.j) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.a.f0(tb4Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements u52.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vb4 a;
        public final /* synthetic */ g62 b;

        public c(g62 g62Var, vb4 vb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g62Var, vb4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g62Var;
            this.a = vb4Var;
        }

        @Override // com.baidu.tieba.u52.c
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

        @Override // com.baidu.tieba.u52.c
        public void b(PMSDownloadType pMSDownloadType, re3 re3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, re3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.c != null) {
                    this.b.c.onError(new PkgDownloadError(this.a, re3Var));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements u52.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tb4 a;
        public final /* synthetic */ g62 b;

        public d(g62 g62Var, tb4 tb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g62Var, tb4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g62Var;
            this.a = tb4Var;
        }

        @Override // com.baidu.tieba.u52.c
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

        @Override // com.baidu.tieba.u52.c
        public void b(PMSDownloadType pMSDownloadType, re3 re3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, re3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, re3Var));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements qw9.a<vb4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g62 a;

        public e(g62 g62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qw9.a, com.baidu.tieba.ex9
        public void call(ww9<? super vb4> ww9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ww9Var) == null) {
                this.a.c = ww9Var;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements qw9.a<tb4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g62 a;

        public f(g62 g62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qw9.a, com.baidu.tieba.ex9
        public void call(ww9<? super tb4> ww9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ww9Var) == null) {
                this.a.d = ww9Var;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends ww9<wb4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g62 e;

        public g(g62 g62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = g62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rw9
        /* renamed from: g */
        public void onNext(wb4 wb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wb4Var) == null) {
                yz1.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + wb4Var.i);
            }
        }

        @Override // com.baidu.tieba.rw9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                yz1.k("UpdateCoreCallback", "包下载完成");
                this.e.e0();
            }
        }

        @Override // com.baidu.tieba.rw9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                yz1.l("UpdateCoreCallback", "OnError", th);
                this.e.d0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947745798, "Lcom/baidu/tieba/g62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947745798, "Lcom/baidu/tieba/g62;");
                return;
            }
        }
        j = ij1.a;
    }

    public g62(rh3<Exception> rh3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rh3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = rh3Var;
    }

    @Override // com.baidu.tieba.ta4
    public void C(sb4 sb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sb4Var) == null) {
            super.C(sb4Var);
            yz1.k("UpdateCoreCallback", "onFetchError: " + sb4Var.toString());
            if (sb4Var.a == 1010) {
                e0();
                return;
            }
            d0(new PMSException("UpdateCoreCallback failed by fetch error = " + sb4Var, sb4Var));
        }
    }

    @Override // com.baidu.tieba.ta4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (j) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.ta4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            yz1.k("UpdateCoreCallback", "onNoPackage:");
            e0();
        }
    }

    @Override // com.baidu.tieba.ta4
    public void G(gg4 gg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gg4Var) == null) {
            super.G(gg4Var);
            if (gg4Var == null) {
                return;
            }
            this.e = gg4Var;
            if (gg4Var.k()) {
                return;
            }
            Z();
        }
    }

    public abstract int U();

    public abstract PMSDownloadType V();

    public abstract String W();

    public abstract String X();

    public final ww9<wb4> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == null) {
                this.i = new g(this);
            }
            return this.i;
        }
        return (ww9) invokeV.objValue;
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.e.e()) {
                arrayList.add(qw9.a(new e(this)));
            }
            if (this.e.d()) {
                arrayList.add(qw9.a(new f(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            qw9.i(arrayList).u(Y());
        }
    }

    public void a0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            yz1.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            rh3<Exception> rh3Var = this.f;
            if (rh3Var != null) {
                rh3Var.a(exc);
            }
            this.f = null;
        }
    }

    public abstract re3 b0(tb4 tb4Var);

    public abstract re3 c0(vb4 vb4Var);

    public void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            yz1.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            zf4.d(U(), 0L);
            vm3.a(0L);
            a0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            yz1.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            zf4.d(U(), currentTimeMillis);
            a0(null);
        }
    }

    public final void f0(tb4 tb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, tb4Var) == null) {
            u52.c().d(tb4Var, new d(this, tb4Var));
        }
    }

    public final void g0(vb4 vb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, vb4Var) == null) {
            u52.c().d(vb4Var, new c(this, vb4Var));
        }
    }

    @Override // com.baidu.tieba.ta4
    public pa4<tb4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == null) {
                this.h = new b(this);
            }
            return this.h;
        }
        return (pa4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ta4
    public pa4<vb4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.g == null) {
                this.g = new a(this);
            }
            return this.g;
        }
        return (pa4) invokeV.objValue;
    }
}
