package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.model.PMSException;
import com.baidu.tieba.re2;
import com.baidu.tieba.u1c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes5.dex */
public abstract class df2 extends ze2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public a2c<? super sk4> c;
    public a2c<? super qk4> d;
    public dp4 e;
    public oq3<Exception> f;
    public mj4<sk4> g;
    public mj4<qk4> h;
    public a2c<tk4> i;

    public abstract int U();

    public abstract PMSDownloadType V();

    public abstract String W();

    public abstract String X();

    public abstract on3 b0(qk4 qk4Var);

    public abstract on3 c0(sk4 sk4Var);

    /* loaded from: classes5.dex */
    public class a extends jj4<sk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ df2 a;

        public a(df2 df2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {df2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = df2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4
        /* renamed from: l */
        public String d(sk4 sk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, sk4Var)) == null) {
                return this.a.X();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: q */
        public void c(sk4 sk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, sk4Var) == null) {
                super.c(sk4Var);
                v82.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: r */
        public void f(sk4 sk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, sk4Var) == null) {
                super.f(sk4Var);
                if (df2.j) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.a.g0(sk4Var);
            }
        }

        @Override // com.baidu.tieba.oj4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: o */
        public void e(sk4 sk4Var, pk4 pk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, sk4Var, pk4Var) == null) {
                super.e(sk4Var, pk4Var);
                v82.k("UpdateCoreCallback", "onDownloadError:" + pk4Var);
                this.a.e.l(sk4Var);
                on3 on3Var = new on3();
                on3Var.k(13L);
                on3Var.i(pk4Var.a);
                on3Var.d("Framework包下载失败");
                on3Var.f(pk4Var.toString());
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(sk4Var, on3Var));
                }
                re2.c().a(sk4Var, this.a.V(), on3Var);
                zr4.k(sk4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: p */
        public void i(sk4 sk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sk4Var) == null) {
                super.i(sk4Var);
                v82.k("UpdateCoreCallback", "onFileDownloaded: " + sk4Var.i);
                on3 c0 = this.a.c0(sk4Var);
                if (c0 == null) {
                    this.a.e.m(sk4Var);
                    if (this.a.c != null) {
                        this.a.c.onNext(sk4Var);
                        this.a.c.onCompleted();
                    }
                    sj4.i().m(sk4Var);
                    re2.c().b(sk4Var, this.a.V());
                    wp3.a();
                    return;
                }
                this.a.e.l(sk4Var);
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(sk4Var, c0));
                }
                re2.c().a(sk4Var, this.a.V(), c0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends jj4<qk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ df2 a;

        public b(df2 df2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {df2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = df2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4
        /* renamed from: l */
        public String d(qk4 qk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, qk4Var)) == null) {
                return this.a.W();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: q */
        public void c(qk4 qk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, qk4Var) == null) {
                super.c(qk4Var);
                v82.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: r */
        public void f(qk4 qk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, qk4Var) == null) {
                super.f(qk4Var);
                if (df2.j) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.a.f0(qk4Var);
            }
        }

        @Override // com.baidu.tieba.oj4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: o */
        public void e(qk4 qk4Var, pk4 pk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, qk4Var, pk4Var) == null) {
                super.e(qk4Var, pk4Var);
                v82.k("UpdateCoreCallback", "onDownloadError:" + pk4Var);
                this.a.e.l(qk4Var);
                on3 on3Var = new on3();
                on3Var.k(14L);
                on3Var.i(pk4Var.a);
                on3Var.d("Extension下载失败");
                on3Var.f(pk4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(qk4Var, on3Var));
                }
                re2.c().a(qk4Var, this.a.V(), on3Var);
                zr4.k(qk4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: p */
        public void i(qk4 qk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qk4Var) == null) {
                super.i(qk4Var);
                v82.k("UpdateCoreCallback", "onFileDownloaded: " + qk4Var.i);
                on3 b0 = this.a.b0(qk4Var);
                if (b0 == null) {
                    this.a.e.m(qk4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(qk4Var);
                        this.a.d.onCompleted();
                    }
                    sj4.i().m(qk4Var);
                    re2.c().b(qk4Var, this.a.V());
                    return;
                }
                this.a.e.l(qk4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(qk4Var, b0));
                }
                re2.c().a(qk4Var, this.a.V(), b0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements re2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sk4 a;
        public final /* synthetic */ df2 b;

        public c(df2 df2Var, sk4 sk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {df2Var, sk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = df2Var;
            this.a = sk4Var;
        }

        @Override // com.baidu.tieba.re2.c
        public void b(PMSDownloadType pMSDownloadType, on3 on3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, on3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.c != null) {
                    this.b.c.onError(new PkgDownloadError(this.a, on3Var));
                }
            }
        }

        @Override // com.baidu.tieba.re2.c
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
    }

    /* loaded from: classes5.dex */
    public class d implements re2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qk4 a;
        public final /* synthetic */ df2 b;

        public d(df2 df2Var, qk4 qk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {df2Var, qk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = df2Var;
            this.a = qk4Var;
        }

        @Override // com.baidu.tieba.re2.c
        public void b(PMSDownloadType pMSDownloadType, on3 on3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, on3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, on3Var));
                }
            }
        }

        @Override // com.baidu.tieba.re2.c
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
    }

    /* loaded from: classes5.dex */
    public class e implements u1c.a<sk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ df2 a;

        public e(df2 df2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {df2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = df2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.u1c.a, com.baidu.tieba.i2c
        public void call(a2c<? super sk4> a2cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, a2cVar) != null) {
                return;
            }
            this.a.c = a2cVar;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements u1c.a<qk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ df2 a;

        public f(df2 df2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {df2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = df2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.u1c.a, com.baidu.tieba.i2c
        public void call(a2c<? super qk4> a2cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, a2cVar) != null) {
                return;
            }
            this.a.d = a2cVar;
        }
    }

    /* loaded from: classes5.dex */
    public class g extends a2c<tk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ df2 e;

        public g(df2 df2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {df2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = df2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v1c
        /* renamed from: g */
        public void onNext(tk4 tk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, tk4Var) == null) {
                v82.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + tk4Var.i);
            }
        }

        @Override // com.baidu.tieba.v1c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                v82.l("UpdateCoreCallback", "OnError", th);
                this.e.d0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.v1c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                v82.k("UpdateCoreCallback", "包下载完成");
                this.e.e0();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947702553, "Lcom/baidu/tieba/df2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947702553, "Lcom/baidu/tieba/df2;");
                return;
            }
        }
        j = fs1.a;
    }

    @Override // com.baidu.tieba.qj4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (j) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.qj4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            v82.k("UpdateCoreCallback", "onNoPackage:");
            e0();
        }
    }

    public final a2c<tk4> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == null) {
                this.i = new g(this);
            }
            return this.i;
        }
        return (a2c) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qj4
    public mj4<qk4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == null) {
                this.h = new b(this);
            }
            return this.h;
        }
        return (mj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qj4
    public mj4<sk4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.g == null) {
                this.g = new a(this);
            }
            return this.g;
        }
        return (mj4) invokeV.objValue;
    }

    public df2(oq3<Exception> oq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oq3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = oq3Var;
    }

    @Override // com.baidu.tieba.qj4
    public void G(dp4 dp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dp4Var) == null) {
            super.G(dp4Var);
            if (dp4Var == null) {
                return;
            }
            this.e = dp4Var;
            if (!dp4Var.k()) {
                Z();
            }
        }
    }

    public void a0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            v82.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            oq3<Exception> oq3Var = this.f;
            if (oq3Var != null) {
                oq3Var.a(exc);
            }
            this.f = null;
        }
    }

    public void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            v82.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            wo4.d(U(), 0L);
            sv3.a(0L);
            a0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public final void f0(qk4 qk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, qk4Var) == null) {
            re2.c().d(qk4Var, new d(this, qk4Var));
        }
    }

    public final void g0(sk4 sk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, sk4Var) == null) {
            re2.c().d(sk4Var, new c(this, sk4Var));
        }
    }

    @Override // com.baidu.tieba.qj4
    public void C(pk4 pk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pk4Var) == null) {
            super.C(pk4Var);
            v82.k("UpdateCoreCallback", "onFetchError: " + pk4Var.toString());
            if (pk4Var.a == 1010) {
                e0();
                return;
            }
            d0(new PMSException("UpdateCoreCallback failed by fetch error = " + pk4Var, pk4Var));
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.e.e()) {
                arrayList.add(u1c.d(new e(this)));
            }
            if (this.e.d()) {
                arrayList.add(u1c.d(new f(this)));
            }
            if (!arrayList.isEmpty()) {
                u1c.q(arrayList).F(Y());
            }
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            v82.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            wo4.d(U(), currentTimeMillis);
            a0(null);
        }
    }
}
