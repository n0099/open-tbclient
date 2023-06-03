package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.model.PMSException;
import com.baidu.tieba.imb;
import com.baidu.tieba.ue2;
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
public abstract class gf2 extends cf2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public omb<? super vk4> c;
    public omb<? super tk4> d;
    public gp4 e;
    public rq3<Exception> f;
    public pj4<vk4> g;
    public pj4<tk4> h;
    public omb<wk4> i;

    public abstract int U();

    public abstract PMSDownloadType V();

    public abstract String W();

    public abstract String X();

    public abstract rn3 b0(tk4 tk4Var);

    public abstract rn3 c0(vk4 vk4Var);

    /* loaded from: classes5.dex */
    public class a extends mj4<vk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gf2 a;

        public a(gf2 gf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pj4
        /* renamed from: l */
        public String d(vk4 vk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, vk4Var)) == null) {
                return this.a.X();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
        /* renamed from: q */
        public void c(vk4 vk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, vk4Var) == null) {
                super.c(vk4Var);
                y82.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
        /* renamed from: r */
        public void f(vk4 vk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, vk4Var) == null) {
                super.f(vk4Var);
                if (gf2.j) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.a.g0(vk4Var);
            }
        }

        @Override // com.baidu.tieba.rj4
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
        @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
        /* renamed from: o */
        public void e(vk4 vk4Var, sk4 sk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, vk4Var, sk4Var) == null) {
                super.e(vk4Var, sk4Var);
                y82.k("UpdateCoreCallback", "onDownloadError:" + sk4Var);
                this.a.e.l(vk4Var);
                rn3 rn3Var = new rn3();
                rn3Var.k(13L);
                rn3Var.i(sk4Var.a);
                rn3Var.d("Framework包下载失败");
                rn3Var.f(sk4Var.toString());
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(vk4Var, rn3Var));
                }
                ue2.c().a(vk4Var, this.a.V(), rn3Var);
                cs4.k(vk4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
        /* renamed from: p */
        public void i(vk4 vk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vk4Var) == null) {
                super.i(vk4Var);
                y82.k("UpdateCoreCallback", "onFileDownloaded: " + vk4Var.i);
                rn3 c0 = this.a.c0(vk4Var);
                if (c0 == null) {
                    this.a.e.m(vk4Var);
                    if (this.a.c != null) {
                        this.a.c.onNext(vk4Var);
                        this.a.c.onCompleted();
                    }
                    vj4.i().m(vk4Var);
                    ue2.c().b(vk4Var, this.a.V());
                    zp3.a();
                    return;
                }
                this.a.e.l(vk4Var);
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(vk4Var, c0));
                }
                ue2.c().a(vk4Var, this.a.V(), c0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends mj4<tk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gf2 a;

        public b(gf2 gf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pj4
        /* renamed from: l */
        public String d(tk4 tk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, tk4Var)) == null) {
                return this.a.W();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
        /* renamed from: q */
        public void c(tk4 tk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, tk4Var) == null) {
                super.c(tk4Var);
                y82.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
        /* renamed from: r */
        public void f(tk4 tk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, tk4Var) == null) {
                super.f(tk4Var);
                if (gf2.j) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.a.f0(tk4Var);
            }
        }

        @Override // com.baidu.tieba.rj4
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
        @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
        /* renamed from: o */
        public void e(tk4 tk4Var, sk4 sk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, tk4Var, sk4Var) == null) {
                super.e(tk4Var, sk4Var);
                y82.k("UpdateCoreCallback", "onDownloadError:" + sk4Var);
                this.a.e.l(tk4Var);
                rn3 rn3Var = new rn3();
                rn3Var.k(14L);
                rn3Var.i(sk4Var.a);
                rn3Var.d("Extension下载失败");
                rn3Var.f(sk4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(tk4Var, rn3Var));
                }
                ue2.c().a(tk4Var, this.a.V(), rn3Var);
                cs4.k(tk4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
        /* renamed from: p */
        public void i(tk4 tk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tk4Var) == null) {
                super.i(tk4Var);
                y82.k("UpdateCoreCallback", "onFileDownloaded: " + tk4Var.i);
                rn3 b0 = this.a.b0(tk4Var);
                if (b0 == null) {
                    this.a.e.m(tk4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(tk4Var);
                        this.a.d.onCompleted();
                    }
                    vj4.i().m(tk4Var);
                    ue2.c().b(tk4Var, this.a.V());
                    return;
                }
                this.a.e.l(tk4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(tk4Var, b0));
                }
                ue2.c().a(tk4Var, this.a.V(), b0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ue2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vk4 a;
        public final /* synthetic */ gf2 b;

        public c(gf2 gf2Var, vk4 vk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gf2Var, vk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gf2Var;
            this.a = vk4Var;
        }

        @Override // com.baidu.tieba.ue2.c
        public void b(PMSDownloadType pMSDownloadType, rn3 rn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, rn3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.c != null) {
                    this.b.c.onError(new PkgDownloadError(this.a, rn3Var));
                }
            }
        }

        @Override // com.baidu.tieba.ue2.c
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
    public class d implements ue2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tk4 a;
        public final /* synthetic */ gf2 b;

        public d(gf2 gf2Var, tk4 tk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gf2Var, tk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gf2Var;
            this.a = tk4Var;
        }

        @Override // com.baidu.tieba.ue2.c
        public void b(PMSDownloadType pMSDownloadType, rn3 rn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, rn3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, rn3Var));
                }
            }
        }

        @Override // com.baidu.tieba.ue2.c
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
    public class e implements imb.a<vk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gf2 a;

        public e(gf2 gf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.imb.a, com.baidu.tieba.wmb
        public void call(omb<? super vk4> ombVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, ombVar) != null) {
                return;
            }
            this.a.c = ombVar;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements imb.a<tk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gf2 a;

        public f(gf2 gf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.imb.a, com.baidu.tieba.wmb
        public void call(omb<? super tk4> ombVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, ombVar) != null) {
                return;
            }
            this.a.d = ombVar;
        }
    }

    /* loaded from: classes5.dex */
    public class g extends omb<wk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gf2 e;

        public g(gf2 gf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = gf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jmb
        /* renamed from: g */
        public void onNext(wk4 wk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wk4Var) == null) {
                y82.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + wk4Var.i);
            }
        }

        @Override // com.baidu.tieba.jmb
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                y82.l("UpdateCoreCallback", "OnError", th);
                this.e.d0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.jmb
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                y82.k("UpdateCoreCallback", "包下载完成");
                this.e.e0();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947791926, "Lcom/baidu/tieba/gf2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947791926, "Lcom/baidu/tieba/gf2;");
                return;
            }
        }
        j = is1.a;
    }

    @Override // com.baidu.tieba.tj4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (j) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.tj4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            y82.k("UpdateCoreCallback", "onNoPackage:");
            e0();
        }
    }

    public final omb<wk4> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == null) {
                this.i = new g(this);
            }
            return this.i;
        }
        return (omb) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tj4
    public pj4<tk4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == null) {
                this.h = new b(this);
            }
            return this.h;
        }
        return (pj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tj4
    public pj4<vk4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.g == null) {
                this.g = new a(this);
            }
            return this.g;
        }
        return (pj4) invokeV.objValue;
    }

    public gf2(rq3<Exception> rq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rq3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = rq3Var;
    }

    @Override // com.baidu.tieba.tj4
    public void G(gp4 gp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gp4Var) == null) {
            super.G(gp4Var);
            if (gp4Var == null) {
                return;
            }
            this.e = gp4Var;
            if (!gp4Var.k()) {
                Z();
            }
        }
    }

    public void a0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            y82.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            rq3<Exception> rq3Var = this.f;
            if (rq3Var != null) {
                rq3Var.a(exc);
            }
            this.f = null;
        }
    }

    public void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            y82.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            zo4.d(U(), 0L);
            vv3.a(0L);
            a0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public final void f0(tk4 tk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, tk4Var) == null) {
            ue2.c().d(tk4Var, new d(this, tk4Var));
        }
    }

    public final void g0(vk4 vk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, vk4Var) == null) {
            ue2.c().d(vk4Var, new c(this, vk4Var));
        }
    }

    @Override // com.baidu.tieba.tj4
    public void C(sk4 sk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sk4Var) == null) {
            super.C(sk4Var);
            y82.k("UpdateCoreCallback", "onFetchError: " + sk4Var.toString());
            if (sk4Var.a == 1010) {
                e0();
                return;
            }
            d0(new PMSException("UpdateCoreCallback failed by fetch error = " + sk4Var, sk4Var));
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.e.e()) {
                arrayList.add(imb.a(new e(this)));
            }
            if (this.e.d()) {
                arrayList.add(imb.a(new f(this)));
            }
            if (!arrayList.isEmpty()) {
                imb.k(arrayList).w(Y());
            }
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            y82.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            zo4.d(U(), currentTimeMillis);
            a0(null);
        }
    }
}
