package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.model.PMSException;
import com.baidu.tieba.gob;
import com.baidu.tieba.ve2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class hf2 extends df2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public mob<? super wk4> c;
    public mob<? super uk4> d;
    public hp4 e;
    public sq3<Exception> f;
    public qj4<wk4> g;
    public qj4<uk4> h;
    public mob<xk4> i;

    public abstract int U();

    public abstract PMSDownloadType V();

    public abstract String W();

    public abstract String X();

    public abstract sn3 b0(uk4 uk4Var);

    public abstract sn3 c0(wk4 wk4Var);

    /* loaded from: classes6.dex */
    public class a extends nj4<wk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hf2 a;

        public a(hf2 hf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qj4
        /* renamed from: l */
        public String d(wk4 wk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, wk4Var)) == null) {
                return this.a.X();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: q */
        public void c(wk4 wk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, wk4Var) == null) {
                super.c(wk4Var);
                z82.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: r */
        public void f(wk4 wk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, wk4Var) == null) {
                super.f(wk4Var);
                if (hf2.j) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.a.g0(wk4Var);
            }
        }

        @Override // com.baidu.tieba.sj4
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
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: o */
        public void e(wk4 wk4Var, tk4 tk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, wk4Var, tk4Var) == null) {
                super.e(wk4Var, tk4Var);
                z82.k("UpdateCoreCallback", "onDownloadError:" + tk4Var);
                this.a.e.l(wk4Var);
                sn3 sn3Var = new sn3();
                sn3Var.k(13L);
                sn3Var.i(tk4Var.a);
                sn3Var.d("Framework包下载失败");
                sn3Var.f(tk4Var.toString());
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(wk4Var, sn3Var));
                }
                ve2.c().a(wk4Var, this.a.V(), sn3Var);
                ds4.k(wk4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: p */
        public void i(wk4 wk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, wk4Var) == null) {
                super.i(wk4Var);
                z82.k("UpdateCoreCallback", "onFileDownloaded: " + wk4Var.i);
                sn3 c0 = this.a.c0(wk4Var);
                if (c0 == null) {
                    this.a.e.m(wk4Var);
                    if (this.a.c != null) {
                        this.a.c.onNext(wk4Var);
                        this.a.c.onCompleted();
                    }
                    wj4.i().m(wk4Var);
                    ve2.c().b(wk4Var, this.a.V());
                    aq3.a();
                    return;
                }
                this.a.e.l(wk4Var);
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(wk4Var, c0));
                }
                ve2.c().a(wk4Var, this.a.V(), c0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends nj4<uk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hf2 a;

        public b(hf2 hf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qj4
        /* renamed from: l */
        public String d(uk4 uk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, uk4Var)) == null) {
                return this.a.W();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: q */
        public void c(uk4 uk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, uk4Var) == null) {
                super.c(uk4Var);
                z82.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: r */
        public void f(uk4 uk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, uk4Var) == null) {
                super.f(uk4Var);
                if (hf2.j) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.a.f0(uk4Var);
            }
        }

        @Override // com.baidu.tieba.sj4
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
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: o */
        public void e(uk4 uk4Var, tk4 tk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, uk4Var, tk4Var) == null) {
                super.e(uk4Var, tk4Var);
                z82.k("UpdateCoreCallback", "onDownloadError:" + tk4Var);
                this.a.e.l(uk4Var);
                sn3 sn3Var = new sn3();
                sn3Var.k(14L);
                sn3Var.i(tk4Var.a);
                sn3Var.d("Extension下载失败");
                sn3Var.f(tk4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(uk4Var, sn3Var));
                }
                ve2.c().a(uk4Var, this.a.V(), sn3Var);
                ds4.k(uk4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: p */
        public void i(uk4 uk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, uk4Var) == null) {
                super.i(uk4Var);
                z82.k("UpdateCoreCallback", "onFileDownloaded: " + uk4Var.i);
                sn3 b0 = this.a.b0(uk4Var);
                if (b0 == null) {
                    this.a.e.m(uk4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(uk4Var);
                        this.a.d.onCompleted();
                    }
                    wj4.i().m(uk4Var);
                    ve2.c().b(uk4Var, this.a.V());
                    return;
                }
                this.a.e.l(uk4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(uk4Var, b0));
                }
                ve2.c().a(uk4Var, this.a.V(), b0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ve2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wk4 a;
        public final /* synthetic */ hf2 b;

        public c(hf2 hf2Var, wk4 wk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hf2Var, wk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hf2Var;
            this.a = wk4Var;
        }

        @Override // com.baidu.tieba.ve2.c
        public void b(PMSDownloadType pMSDownloadType, sn3 sn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, sn3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.c != null) {
                    this.b.c.onError(new PkgDownloadError(this.a, sn3Var));
                }
            }
        }

        @Override // com.baidu.tieba.ve2.c
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

    /* loaded from: classes6.dex */
    public class d implements ve2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uk4 a;
        public final /* synthetic */ hf2 b;

        public d(hf2 hf2Var, uk4 uk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hf2Var, uk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hf2Var;
            this.a = uk4Var;
        }

        @Override // com.baidu.tieba.ve2.c
        public void b(PMSDownloadType pMSDownloadType, sn3 sn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, sn3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, sn3Var));
                }
            }
        }

        @Override // com.baidu.tieba.ve2.c
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

    /* loaded from: classes6.dex */
    public class e implements gob.a<wk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hf2 a;

        public e(hf2 hf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gob.a, com.baidu.tieba.uob
        public void call(mob<? super wk4> mobVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, mobVar) != null) {
                return;
            }
            this.a.c = mobVar;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements gob.a<uk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hf2 a;

        public f(hf2 hf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gob.a, com.baidu.tieba.uob
        public void call(mob<? super uk4> mobVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, mobVar) != null) {
                return;
            }
            this.a.d = mobVar;
        }
    }

    /* loaded from: classes6.dex */
    public class g extends mob<xk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hf2 e;

        public g(hf2 hf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = hf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hob
        /* renamed from: g */
        public void onNext(xk4 xk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, xk4Var) == null) {
                z82.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + xk4Var.i);
            }
        }

        @Override // com.baidu.tieba.hob
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                z82.l("UpdateCoreCallback", "OnError", th);
                this.e.d0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.hob
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                z82.k("UpdateCoreCallback", "包下载完成");
                this.e.e0();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947821717, "Lcom/baidu/tieba/hf2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947821717, "Lcom/baidu/tieba/hf2;");
                return;
            }
        }
        j = js1.a;
    }

    @Override // com.baidu.tieba.uj4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (j) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.uj4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            z82.k("UpdateCoreCallback", "onNoPackage:");
            e0();
        }
    }

    public final mob<xk4> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == null) {
                this.i = new g(this);
            }
            return this.i;
        }
        return (mob) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uj4
    public qj4<uk4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == null) {
                this.h = new b(this);
            }
            return this.h;
        }
        return (qj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uj4
    public qj4<wk4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.g == null) {
                this.g = new a(this);
            }
            return this.g;
        }
        return (qj4) invokeV.objValue;
    }

    public hf2(sq3<Exception> sq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sq3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = sq3Var;
    }

    @Override // com.baidu.tieba.uj4
    public void G(hp4 hp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hp4Var) == null) {
            super.G(hp4Var);
            if (hp4Var == null) {
                return;
            }
            this.e = hp4Var;
            if (!hp4Var.k()) {
                Z();
            }
        }
    }

    public void a0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            z82.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            sq3<Exception> sq3Var = this.f;
            if (sq3Var != null) {
                sq3Var.a(exc);
            }
            this.f = null;
        }
    }

    public void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            z82.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            ap4.d(U(), 0L);
            wv3.a(0L);
            a0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public final void f0(uk4 uk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, uk4Var) == null) {
            ve2.c().d(uk4Var, new d(this, uk4Var));
        }
    }

    public final void g0(wk4 wk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, wk4Var) == null) {
            ve2.c().d(wk4Var, new c(this, wk4Var));
        }
    }

    @Override // com.baidu.tieba.uj4
    public void C(tk4 tk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tk4Var) == null) {
            super.C(tk4Var);
            z82.k("UpdateCoreCallback", "onFetchError: " + tk4Var.toString());
            if (tk4Var.a == 1010) {
                e0();
                return;
            }
            d0(new PMSException("UpdateCoreCallback failed by fetch error = " + tk4Var, tk4Var));
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.e.e()) {
                arrayList.add(gob.a(new e(this)));
            }
            if (this.e.d()) {
                arrayList.add(gob.a(new f(this)));
            }
            if (!arrayList.isEmpty()) {
                gob.k(arrayList).w(Y());
            }
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            z82.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            ap4.d(U(), currentTimeMillis);
            a0(null);
        }
    }
}
