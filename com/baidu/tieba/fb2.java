package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.model.PMSException;
import com.baidu.tieba.j5b;
import com.baidu.tieba.ta2;
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
public abstract class fb2 extends bb2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public p5b<? super ug4> c;
    public p5b<? super sg4> d;
    public fl4 e;
    public qm3<Exception> f;
    public of4<ug4> g;
    public of4<sg4> h;
    public p5b<vg4> i;

    public abstract int U();

    public abstract PMSDownloadType V();

    public abstract String W();

    public abstract String X();

    public abstract qj3 b0(sg4 sg4Var);

    public abstract qj3 c0(ug4 ug4Var);

    /* loaded from: classes4.dex */
    public class a extends lf4<ug4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb2 a;

        public a(fb2 fb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fb2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.of4
        /* renamed from: l */
        public String d(ug4 ug4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ug4Var)) == null) {
                return this.a.X();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: q */
        public void c(ug4 ug4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, ug4Var) == null) {
                super.c(ug4Var);
                x42.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: r */
        public void f(ug4 ug4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, ug4Var) == null) {
                super.f(ug4Var);
                if (fb2.j) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.a.g0(ug4Var);
            }
        }

        @Override // com.baidu.tieba.qf4
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
        @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: o */
        public void e(ug4 ug4Var, rg4 rg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, ug4Var, rg4Var) == null) {
                super.e(ug4Var, rg4Var);
                x42.k("UpdateCoreCallback", "onDownloadError:" + rg4Var);
                this.a.e.l(ug4Var);
                qj3 qj3Var = new qj3();
                qj3Var.k(13L);
                qj3Var.i(rg4Var.a);
                qj3Var.d("Framework包下载失败");
                qj3Var.f(rg4Var.toString());
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(ug4Var, qj3Var));
                }
                ta2.c().a(ug4Var, this.a.V(), qj3Var);
                bo4.k(ug4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: p */
        public void i(ug4 ug4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ug4Var) == null) {
                super.i(ug4Var);
                x42.k("UpdateCoreCallback", "onFileDownloaded: " + ug4Var.i);
                qj3 c0 = this.a.c0(ug4Var);
                if (c0 == null) {
                    this.a.e.m(ug4Var);
                    if (this.a.c != null) {
                        this.a.c.onNext(ug4Var);
                        this.a.c.onCompleted();
                    }
                    uf4.i().m(ug4Var);
                    ta2.c().b(ug4Var, this.a.V());
                    yl3.a();
                    return;
                }
                this.a.e.l(ug4Var);
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(ug4Var, c0));
                }
                ta2.c().a(ug4Var, this.a.V(), c0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends lf4<sg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb2 a;

        public b(fb2 fb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fb2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.of4
        /* renamed from: l */
        public String d(sg4 sg4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, sg4Var)) == null) {
                return this.a.W();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: q */
        public void c(sg4 sg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, sg4Var) == null) {
                super.c(sg4Var);
                x42.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: r */
        public void f(sg4 sg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, sg4Var) == null) {
                super.f(sg4Var);
                if (fb2.j) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.a.f0(sg4Var);
            }
        }

        @Override // com.baidu.tieba.qf4
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
        @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: o */
        public void e(sg4 sg4Var, rg4 rg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, sg4Var, rg4Var) == null) {
                super.e(sg4Var, rg4Var);
                x42.k("UpdateCoreCallback", "onDownloadError:" + rg4Var);
                this.a.e.l(sg4Var);
                qj3 qj3Var = new qj3();
                qj3Var.k(14L);
                qj3Var.i(rg4Var.a);
                qj3Var.d("Extension下载失败");
                qj3Var.f(rg4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(sg4Var, qj3Var));
                }
                ta2.c().a(sg4Var, this.a.V(), qj3Var);
                bo4.k(sg4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: p */
        public void i(sg4 sg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sg4Var) == null) {
                super.i(sg4Var);
                x42.k("UpdateCoreCallback", "onFileDownloaded: " + sg4Var.i);
                qj3 b0 = this.a.b0(sg4Var);
                if (b0 == null) {
                    this.a.e.m(sg4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(sg4Var);
                        this.a.d.onCompleted();
                    }
                    uf4.i().m(sg4Var);
                    ta2.c().b(sg4Var, this.a.V());
                    return;
                }
                this.a.e.l(sg4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(sg4Var, b0));
                }
                ta2.c().a(sg4Var, this.a.V(), b0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ta2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ug4 a;
        public final /* synthetic */ fb2 b;

        public c(fb2 fb2Var, ug4 ug4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb2Var, ug4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fb2Var;
            this.a = ug4Var;
        }

        @Override // com.baidu.tieba.ta2.c
        public void b(PMSDownloadType pMSDownloadType, qj3 qj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, qj3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.c != null) {
                    this.b.c.onError(new PkgDownloadError(this.a, qj3Var));
                }
            }
        }

        @Override // com.baidu.tieba.ta2.c
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

    /* loaded from: classes4.dex */
    public class d implements ta2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sg4 a;
        public final /* synthetic */ fb2 b;

        public d(fb2 fb2Var, sg4 sg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb2Var, sg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fb2Var;
            this.a = sg4Var;
        }

        @Override // com.baidu.tieba.ta2.c
        public void b(PMSDownloadType pMSDownloadType, qj3 qj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, qj3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, qj3Var));
                }
            }
        }

        @Override // com.baidu.tieba.ta2.c
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

    /* loaded from: classes4.dex */
    public class e implements j5b.a<ug4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb2 a;

        public e(fb2 fb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fb2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.j5b.a, com.baidu.tieba.x5b
        public void call(p5b<? super ug4> p5bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, p5bVar) != null) {
                return;
            }
            this.a.c = p5bVar;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements j5b.a<sg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb2 a;

        public f(fb2 fb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fb2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.j5b.a, com.baidu.tieba.x5b
        public void call(p5b<? super sg4> p5bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, p5bVar) != null) {
                return;
            }
            this.a.d = p5bVar;
        }
    }

    /* loaded from: classes4.dex */
    public class g extends p5b<vg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb2 e;

        public g(fb2 fb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = fb2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.k5b
        /* renamed from: g */
        public void onNext(vg4 vg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vg4Var) == null) {
                x42.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + vg4Var.i);
            }
        }

        @Override // com.baidu.tieba.k5b
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                x42.l("UpdateCoreCallback", "OnError", th);
                this.e.d0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.k5b
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                x42.k("UpdateCoreCallback", "包下载完成");
                this.e.e0();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947758291, "Lcom/baidu/tieba/fb2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947758291, "Lcom/baidu/tieba/fb2;");
                return;
            }
        }
        j = ho1.a;
    }

    @Override // com.baidu.tieba.sf4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (j) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.sf4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            x42.k("UpdateCoreCallback", "onNoPackage:");
            e0();
        }
    }

    public final p5b<vg4> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == null) {
                this.i = new g(this);
            }
            return this.i;
        }
        return (p5b) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sf4
    public of4<sg4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == null) {
                this.h = new b(this);
            }
            return this.h;
        }
        return (of4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sf4
    public of4<ug4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.g == null) {
                this.g = new a(this);
            }
            return this.g;
        }
        return (of4) invokeV.objValue;
    }

    public fb2(qm3<Exception> qm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qm3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = qm3Var;
    }

    @Override // com.baidu.tieba.sf4
    public void G(fl4 fl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fl4Var) == null) {
            super.G(fl4Var);
            if (fl4Var == null) {
                return;
            }
            this.e = fl4Var;
            if (!fl4Var.k()) {
                Z();
            }
        }
    }

    public void a0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            x42.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            qm3<Exception> qm3Var = this.f;
            if (qm3Var != null) {
                qm3Var.a(exc);
            }
            this.f = null;
        }
    }

    public void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            x42.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            yk4.d(U(), 0L);
            ur3.a(0L);
            a0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public final void f0(sg4 sg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, sg4Var) == null) {
            ta2.c().d(sg4Var, new d(this, sg4Var));
        }
    }

    public final void g0(ug4 ug4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ug4Var) == null) {
            ta2.c().d(ug4Var, new c(this, ug4Var));
        }
    }

    @Override // com.baidu.tieba.sf4
    public void C(rg4 rg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, rg4Var) == null) {
            super.C(rg4Var);
            x42.k("UpdateCoreCallback", "onFetchError: " + rg4Var.toString());
            if (rg4Var.a == 1010) {
                e0();
                return;
            }
            d0(new PMSException("UpdateCoreCallback failed by fetch error = " + rg4Var, rg4Var));
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.e.e()) {
                arrayList.add(j5b.a(new e(this)));
            }
            if (this.e.d()) {
                arrayList.add(j5b.a(new f(this)));
            }
            if (!arrayList.isEmpty()) {
                j5b.k(arrayList).w(Y());
            }
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            x42.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            yk4.d(U(), currentTimeMillis);
            a0(null);
        }
    }
}
