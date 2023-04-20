package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.model.PMSException;
import com.baidu.tieba.n1b;
import com.baidu.tieba.ra2;
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
public abstract class db2 extends za2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public t1b<? super sg4> c;
    public t1b<? super qg4> d;
    public dl4 e;
    public om3<Exception> f;
    public mf4<sg4> g;
    public mf4<qg4> h;
    public t1b<tg4> i;

    public abstract int U();

    public abstract PMSDownloadType V();

    public abstract String W();

    public abstract String X();

    public abstract oj3 b0(qg4 qg4Var);

    public abstract oj3 c0(sg4 sg4Var);

    /* loaded from: classes4.dex */
    public class a extends jf4<sg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db2 a;

        public a(db2 db2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = db2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mf4
        /* renamed from: l */
        public String d(sg4 sg4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, sg4Var)) == null) {
                return this.a.X();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: q */
        public void c(sg4 sg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, sg4Var) == null) {
                super.c(sg4Var);
                v42.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: r */
        public void f(sg4 sg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, sg4Var) == null) {
                super.f(sg4Var);
                if (db2.j) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.a.g0(sg4Var);
            }
        }

        @Override // com.baidu.tieba.of4
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
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: o */
        public void e(sg4 sg4Var, pg4 pg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, sg4Var, pg4Var) == null) {
                super.e(sg4Var, pg4Var);
                v42.k("UpdateCoreCallback", "onDownloadError:" + pg4Var);
                this.a.e.l(sg4Var);
                oj3 oj3Var = new oj3();
                oj3Var.k(13L);
                oj3Var.i(pg4Var.a);
                oj3Var.d("Framework包下载失败");
                oj3Var.f(pg4Var.toString());
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(sg4Var, oj3Var));
                }
                ra2.c().a(sg4Var, this.a.V(), oj3Var);
                zn4.k(sg4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: p */
        public void i(sg4 sg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sg4Var) == null) {
                super.i(sg4Var);
                v42.k("UpdateCoreCallback", "onFileDownloaded: " + sg4Var.i);
                oj3 c0 = this.a.c0(sg4Var);
                if (c0 == null) {
                    this.a.e.m(sg4Var);
                    if (this.a.c != null) {
                        this.a.c.onNext(sg4Var);
                        this.a.c.onCompleted();
                    }
                    sf4.i().m(sg4Var);
                    ra2.c().b(sg4Var, this.a.V());
                    wl3.a();
                    return;
                }
                this.a.e.l(sg4Var);
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(sg4Var, c0));
                }
                ra2.c().a(sg4Var, this.a.V(), c0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends jf4<qg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db2 a;

        public b(db2 db2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = db2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mf4
        /* renamed from: l */
        public String d(qg4 qg4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, qg4Var)) == null) {
                return this.a.W();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: q */
        public void c(qg4 qg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, qg4Var) == null) {
                super.c(qg4Var);
                v42.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: r */
        public void f(qg4 qg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, qg4Var) == null) {
                super.f(qg4Var);
                if (db2.j) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.a.f0(qg4Var);
            }
        }

        @Override // com.baidu.tieba.of4
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
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: o */
        public void e(qg4 qg4Var, pg4 pg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, qg4Var, pg4Var) == null) {
                super.e(qg4Var, pg4Var);
                v42.k("UpdateCoreCallback", "onDownloadError:" + pg4Var);
                this.a.e.l(qg4Var);
                oj3 oj3Var = new oj3();
                oj3Var.k(14L);
                oj3Var.i(pg4Var.a);
                oj3Var.d("Extension下载失败");
                oj3Var.f(pg4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(qg4Var, oj3Var));
                }
                ra2.c().a(qg4Var, this.a.V(), oj3Var);
                zn4.k(qg4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: p */
        public void i(qg4 qg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qg4Var) == null) {
                super.i(qg4Var);
                v42.k("UpdateCoreCallback", "onFileDownloaded: " + qg4Var.i);
                oj3 b0 = this.a.b0(qg4Var);
                if (b0 == null) {
                    this.a.e.m(qg4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(qg4Var);
                        this.a.d.onCompleted();
                    }
                    sf4.i().m(qg4Var);
                    ra2.c().b(qg4Var, this.a.V());
                    return;
                }
                this.a.e.l(qg4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(qg4Var, b0));
                }
                ra2.c().a(qg4Var, this.a.V(), b0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ra2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sg4 a;
        public final /* synthetic */ db2 b;

        public c(db2 db2Var, sg4 sg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db2Var, sg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = db2Var;
            this.a = sg4Var;
        }

        @Override // com.baidu.tieba.ra2.c
        public void b(PMSDownloadType pMSDownloadType, oj3 oj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, oj3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.c != null) {
                    this.b.c.onError(new PkgDownloadError(this.a, oj3Var));
                }
            }
        }

        @Override // com.baidu.tieba.ra2.c
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
    public class d implements ra2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qg4 a;
        public final /* synthetic */ db2 b;

        public d(db2 db2Var, qg4 qg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db2Var, qg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = db2Var;
            this.a = qg4Var;
        }

        @Override // com.baidu.tieba.ra2.c
        public void b(PMSDownloadType pMSDownloadType, oj3 oj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, oj3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, oj3Var));
                }
            }
        }

        @Override // com.baidu.tieba.ra2.c
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
    public class e implements n1b.a<sg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db2 a;

        public e(db2 db2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = db2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.n1b.a, com.baidu.tieba.b2b
        public void call(t1b<? super sg4> t1bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, t1bVar) != null) {
                return;
            }
            this.a.c = t1bVar;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements n1b.a<qg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db2 a;

        public f(db2 db2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = db2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.n1b.a, com.baidu.tieba.b2b
        public void call(t1b<? super qg4> t1bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, t1bVar) != null) {
                return;
            }
            this.a.d = t1bVar;
        }
    }

    /* loaded from: classes4.dex */
    public class g extends t1b<tg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db2 e;

        public g(db2 db2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = db2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.o1b
        /* renamed from: g */
        public void onNext(tg4 tg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, tg4Var) == null) {
                v42.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + tg4Var.i);
            }
        }

        @Override // com.baidu.tieba.o1b
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                v42.l("UpdateCoreCallback", "OnError", th);
                this.e.d0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.o1b
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                v42.k("UpdateCoreCallback", "包下载完成");
                this.e.e0();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947698709, "Lcom/baidu/tieba/db2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947698709, "Lcom/baidu/tieba/db2;");
                return;
            }
        }
        j = fo1.a;
    }

    @Override // com.baidu.tieba.qf4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (j) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.qf4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            v42.k("UpdateCoreCallback", "onNoPackage:");
            e0();
        }
    }

    public final t1b<tg4> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == null) {
                this.i = new g(this);
            }
            return this.i;
        }
        return (t1b) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qf4
    public mf4<qg4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == null) {
                this.h = new b(this);
            }
            return this.h;
        }
        return (mf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qf4
    public mf4<sg4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.g == null) {
                this.g = new a(this);
            }
            return this.g;
        }
        return (mf4) invokeV.objValue;
    }

    public db2(om3<Exception> om3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {om3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = om3Var;
    }

    @Override // com.baidu.tieba.qf4
    public void G(dl4 dl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dl4Var) == null) {
            super.G(dl4Var);
            if (dl4Var == null) {
                return;
            }
            this.e = dl4Var;
            if (!dl4Var.k()) {
                Z();
            }
        }
    }

    public void a0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            v42.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            om3<Exception> om3Var = this.f;
            if (om3Var != null) {
                om3Var.a(exc);
            }
            this.f = null;
        }
    }

    public void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            v42.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            wk4.d(U(), 0L);
            sr3.a(0L);
            a0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public final void f0(qg4 qg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, qg4Var) == null) {
            ra2.c().d(qg4Var, new d(this, qg4Var));
        }
    }

    public final void g0(sg4 sg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, sg4Var) == null) {
            ra2.c().d(sg4Var, new c(this, sg4Var));
        }
    }

    @Override // com.baidu.tieba.qf4
    public void C(pg4 pg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pg4Var) == null) {
            super.C(pg4Var);
            v42.k("UpdateCoreCallback", "onFetchError: " + pg4Var.toString());
            if (pg4Var.a == 1010) {
                e0();
                return;
            }
            d0(new PMSException("UpdateCoreCallback failed by fetch error = " + pg4Var, pg4Var));
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.e.e()) {
                arrayList.add(n1b.a(new e(this)));
            }
            if (this.e.d()) {
                arrayList.add(n1b.a(new f(this)));
            }
            if (!arrayList.isEmpty()) {
                n1b.i(arrayList).u(Y());
            }
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            v42.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            wk4.d(U(), currentTimeMillis);
            a0(null);
        }
    }
}
