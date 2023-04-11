package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.model.PMSException;
import com.baidu.tieba.f1b;
import com.baidu.tieba.qa2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes3.dex */
public abstract class cb2 extends ya2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public l1b<? super rg4> c;
    public l1b<? super pg4> d;
    public cl4 e;
    public nm3<Exception> f;
    public lf4<rg4> g;
    public lf4<pg4> h;
    public l1b<sg4> i;

    public abstract int U();

    public abstract PMSDownloadType V();

    public abstract String W();

    public abstract String X();

    public abstract nj3 b0(pg4 pg4Var);

    public abstract nj3 c0(rg4 rg4Var);

    /* loaded from: classes3.dex */
    public class a extends if4<rg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cb2 a;

        public a(cb2 cb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cb2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf4
        /* renamed from: l */
        public String d(rg4 rg4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, rg4Var)) == null) {
                return this.a.X();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.if4, com.baidu.tieba.lf4
        /* renamed from: q */
        public void c(rg4 rg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, rg4Var) == null) {
                super.c(rg4Var);
                u42.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.if4, com.baidu.tieba.lf4
        /* renamed from: r */
        public void f(rg4 rg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, rg4Var) == null) {
                super.f(rg4Var);
                if (cb2.j) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.a.g0(rg4Var);
            }
        }

        @Override // com.baidu.tieba.nf4
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
        @Override // com.baidu.tieba.if4, com.baidu.tieba.lf4
        /* renamed from: o */
        public void e(rg4 rg4Var, og4 og4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, rg4Var, og4Var) == null) {
                super.e(rg4Var, og4Var);
                u42.k("UpdateCoreCallback", "onDownloadError:" + og4Var);
                this.a.e.l(rg4Var);
                nj3 nj3Var = new nj3();
                nj3Var.k(13L);
                nj3Var.i(og4Var.a);
                nj3Var.d("Framework包下载失败");
                nj3Var.f(og4Var.toString());
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(rg4Var, nj3Var));
                }
                qa2.c().a(rg4Var, this.a.V(), nj3Var);
                yn4.k(rg4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.if4, com.baidu.tieba.lf4
        /* renamed from: p */
        public void i(rg4 rg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rg4Var) == null) {
                super.i(rg4Var);
                u42.k("UpdateCoreCallback", "onFileDownloaded: " + rg4Var.i);
                nj3 c0 = this.a.c0(rg4Var);
                if (c0 == null) {
                    this.a.e.m(rg4Var);
                    if (this.a.c != null) {
                        this.a.c.onNext(rg4Var);
                        this.a.c.onCompleted();
                    }
                    rf4.i().m(rg4Var);
                    qa2.c().b(rg4Var, this.a.V());
                    vl3.a();
                    return;
                }
                this.a.e.l(rg4Var);
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(rg4Var, c0));
                }
                qa2.c().a(rg4Var, this.a.V(), c0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends if4<pg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cb2 a;

        public b(cb2 cb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cb2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf4
        /* renamed from: l */
        public String d(pg4 pg4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, pg4Var)) == null) {
                return this.a.W();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.if4, com.baidu.tieba.lf4
        /* renamed from: q */
        public void c(pg4 pg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, pg4Var) == null) {
                super.c(pg4Var);
                u42.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.if4, com.baidu.tieba.lf4
        /* renamed from: r */
        public void f(pg4 pg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, pg4Var) == null) {
                super.f(pg4Var);
                if (cb2.j) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.a.f0(pg4Var);
            }
        }

        @Override // com.baidu.tieba.nf4
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
        @Override // com.baidu.tieba.if4, com.baidu.tieba.lf4
        /* renamed from: o */
        public void e(pg4 pg4Var, og4 og4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, pg4Var, og4Var) == null) {
                super.e(pg4Var, og4Var);
                u42.k("UpdateCoreCallback", "onDownloadError:" + og4Var);
                this.a.e.l(pg4Var);
                nj3 nj3Var = new nj3();
                nj3Var.k(14L);
                nj3Var.i(og4Var.a);
                nj3Var.d("Extension下载失败");
                nj3Var.f(og4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(pg4Var, nj3Var));
                }
                qa2.c().a(pg4Var, this.a.V(), nj3Var);
                yn4.k(pg4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.if4, com.baidu.tieba.lf4
        /* renamed from: p */
        public void i(pg4 pg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pg4Var) == null) {
                super.i(pg4Var);
                u42.k("UpdateCoreCallback", "onFileDownloaded: " + pg4Var.i);
                nj3 b0 = this.a.b0(pg4Var);
                if (b0 == null) {
                    this.a.e.m(pg4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(pg4Var);
                        this.a.d.onCompleted();
                    }
                    rf4.i().m(pg4Var);
                    qa2.c().b(pg4Var, this.a.V());
                    return;
                }
                this.a.e.l(pg4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(pg4Var, b0));
                }
                qa2.c().a(pg4Var, this.a.V(), b0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements qa2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rg4 a;
        public final /* synthetic */ cb2 b;

        public c(cb2 cb2Var, rg4 rg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cb2Var, rg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cb2Var;
            this.a = rg4Var;
        }

        @Override // com.baidu.tieba.qa2.c
        public void b(PMSDownloadType pMSDownloadType, nj3 nj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, nj3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.c != null) {
                    this.b.c.onError(new PkgDownloadError(this.a, nj3Var));
                }
            }
        }

        @Override // com.baidu.tieba.qa2.c
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

    /* loaded from: classes3.dex */
    public class d implements qa2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pg4 a;
        public final /* synthetic */ cb2 b;

        public d(cb2 cb2Var, pg4 pg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cb2Var, pg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cb2Var;
            this.a = pg4Var;
        }

        @Override // com.baidu.tieba.qa2.c
        public void b(PMSDownloadType pMSDownloadType, nj3 nj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, nj3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, nj3Var));
                }
            }
        }

        @Override // com.baidu.tieba.qa2.c
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

    /* loaded from: classes3.dex */
    public class e implements f1b.a<rg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cb2 a;

        public e(cb2 cb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cb2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.f1b.a, com.baidu.tieba.t1b
        public void call(l1b<? super rg4> l1bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, l1bVar) != null) {
                return;
            }
            this.a.c = l1bVar;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements f1b.a<pg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cb2 a;

        public f(cb2 cb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cb2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.f1b.a, com.baidu.tieba.t1b
        public void call(l1b<? super pg4> l1bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, l1bVar) != null) {
                return;
            }
            this.a.d = l1bVar;
        }
    }

    /* loaded from: classes3.dex */
    public class g extends l1b<sg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cb2 e;

        public g(cb2 cb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = cb2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.g1b
        /* renamed from: g */
        public void onNext(sg4 sg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sg4Var) == null) {
                u42.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + sg4Var.i);
            }
        }

        @Override // com.baidu.tieba.g1b
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                u42.l("UpdateCoreCallback", "OnError", th);
                this.e.d0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.g1b
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                u42.k("UpdateCoreCallback", "包下载完成");
                this.e.e0();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947668918, "Lcom/baidu/tieba/cb2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947668918, "Lcom/baidu/tieba/cb2;");
                return;
            }
        }
        j = eo1.a;
    }

    @Override // com.baidu.tieba.pf4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (j) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.pf4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            u42.k("UpdateCoreCallback", "onNoPackage:");
            e0();
        }
    }

    public final l1b<sg4> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == null) {
                this.i = new g(this);
            }
            return this.i;
        }
        return (l1b) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pf4
    public lf4<pg4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == null) {
                this.h = new b(this);
            }
            return this.h;
        }
        return (lf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pf4
    public lf4<rg4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.g == null) {
                this.g = new a(this);
            }
            return this.g;
        }
        return (lf4) invokeV.objValue;
    }

    public cb2(nm3<Exception> nm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nm3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = nm3Var;
    }

    @Override // com.baidu.tieba.pf4
    public void G(cl4 cl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cl4Var) == null) {
            super.G(cl4Var);
            if (cl4Var == null) {
                return;
            }
            this.e = cl4Var;
            if (!cl4Var.k()) {
                Z();
            }
        }
    }

    public void a0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            u42.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            nm3<Exception> nm3Var = this.f;
            if (nm3Var != null) {
                nm3Var.a(exc);
            }
            this.f = null;
        }
    }

    public void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            u42.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            vk4.d(U(), 0L);
            rr3.a(0L);
            a0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public final void f0(pg4 pg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, pg4Var) == null) {
            qa2.c().d(pg4Var, new d(this, pg4Var));
        }
    }

    public final void g0(rg4 rg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, rg4Var) == null) {
            qa2.c().d(rg4Var, new c(this, rg4Var));
        }
    }

    @Override // com.baidu.tieba.pf4
    public void C(og4 og4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, og4Var) == null) {
            super.C(og4Var);
            u42.k("UpdateCoreCallback", "onFetchError: " + og4Var.toString());
            if (og4Var.a == 1010) {
                e0();
                return;
            }
            d0(new PMSException("UpdateCoreCallback failed by fetch error = " + og4Var, og4Var));
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.e.e()) {
                arrayList.add(f1b.a(new e(this)));
            }
            if (this.e.d()) {
                arrayList.add(f1b.a(new f(this)));
            }
            if (!arrayList.isEmpty()) {
                f1b.i(arrayList).u(Y());
            }
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            u42.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            vk4.d(U(), currentTimeMillis);
            a0(null);
        }
    }
}
