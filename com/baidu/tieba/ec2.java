package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.model.PMSException;
import com.baidu.tieba.sb2;
import com.baidu.tieba.tca;
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
public abstract class ec2 extends ac2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public zca<? super th4> c;
    public zca<? super rh4> d;
    public em4 e;
    public pn3<Exception> f;
    public ng4<th4> g;
    public ng4<rh4> h;
    public zca<uh4> i;

    public abstract int U();

    public abstract PMSDownloadType V();

    public abstract String W();

    public abstract String X();

    public abstract pk3 b0(rh4 rh4Var);

    public abstract pk3 c0(th4 th4Var);

    /* loaded from: classes4.dex */
    public class a extends kg4<th4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ec2 a;

        public a(ec2 ec2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ec2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ec2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ng4
        /* renamed from: l */
        public String d(th4 th4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, th4Var)) == null) {
                return this.a.X();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg4, com.baidu.tieba.ng4
        /* renamed from: q */
        public void c(th4 th4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, th4Var) == null) {
                super.c(th4Var);
                w52.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg4, com.baidu.tieba.ng4
        /* renamed from: r */
        public void f(th4 th4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, th4Var) == null) {
                super.f(th4Var);
                if (ec2.j) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.a.g0(th4Var);
            }
        }

        @Override // com.baidu.tieba.pg4
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
        @Override // com.baidu.tieba.kg4, com.baidu.tieba.ng4
        /* renamed from: o */
        public void e(th4 th4Var, qh4 qh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, th4Var, qh4Var) == null) {
                super.e(th4Var, qh4Var);
                w52.k("UpdateCoreCallback", "onDownloadError:" + qh4Var);
                this.a.e.l(th4Var);
                pk3 pk3Var = new pk3();
                pk3Var.k(13L);
                pk3Var.i(qh4Var.a);
                pk3Var.d("Framework包下载失败");
                pk3Var.f(qh4Var.toString());
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(th4Var, pk3Var));
                }
                sb2.c().a(th4Var, this.a.V(), pk3Var);
                ap4.k(th4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg4, com.baidu.tieba.ng4
        /* renamed from: p */
        public void i(th4 th4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, th4Var) == null) {
                super.i(th4Var);
                w52.k("UpdateCoreCallback", "onFileDownloaded: " + th4Var.i);
                pk3 c0 = this.a.c0(th4Var);
                if (c0 == null) {
                    this.a.e.m(th4Var);
                    if (this.a.c != null) {
                        this.a.c.onNext(th4Var);
                        this.a.c.onCompleted();
                    }
                    tg4.i().m(th4Var);
                    sb2.c().b(th4Var, this.a.V());
                    xm3.a();
                    return;
                }
                this.a.e.l(th4Var);
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(th4Var, c0));
                }
                sb2.c().a(th4Var, this.a.V(), c0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends kg4<rh4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ec2 a;

        public b(ec2 ec2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ec2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ec2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ng4
        /* renamed from: l */
        public String d(rh4 rh4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, rh4Var)) == null) {
                return this.a.W();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg4, com.baidu.tieba.ng4
        /* renamed from: q */
        public void c(rh4 rh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, rh4Var) == null) {
                super.c(rh4Var);
                w52.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg4, com.baidu.tieba.ng4
        /* renamed from: r */
        public void f(rh4 rh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, rh4Var) == null) {
                super.f(rh4Var);
                if (ec2.j) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.a.f0(rh4Var);
            }
        }

        @Override // com.baidu.tieba.pg4
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
        @Override // com.baidu.tieba.kg4, com.baidu.tieba.ng4
        /* renamed from: o */
        public void e(rh4 rh4Var, qh4 qh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, rh4Var, qh4Var) == null) {
                super.e(rh4Var, qh4Var);
                w52.k("UpdateCoreCallback", "onDownloadError:" + qh4Var);
                this.a.e.l(rh4Var);
                pk3 pk3Var = new pk3();
                pk3Var.k(14L);
                pk3Var.i(qh4Var.a);
                pk3Var.d("Extension下载失败");
                pk3Var.f(qh4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(rh4Var, pk3Var));
                }
                sb2.c().a(rh4Var, this.a.V(), pk3Var);
                ap4.k(rh4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg4, com.baidu.tieba.ng4
        /* renamed from: p */
        public void i(rh4 rh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rh4Var) == null) {
                super.i(rh4Var);
                w52.k("UpdateCoreCallback", "onFileDownloaded: " + rh4Var.i);
                pk3 b0 = this.a.b0(rh4Var);
                if (b0 == null) {
                    this.a.e.m(rh4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(rh4Var);
                        this.a.d.onCompleted();
                    }
                    tg4.i().m(rh4Var);
                    sb2.c().b(rh4Var, this.a.V());
                    return;
                }
                this.a.e.l(rh4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(rh4Var, b0));
                }
                sb2.c().a(rh4Var, this.a.V(), b0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements sb2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ th4 a;
        public final /* synthetic */ ec2 b;

        public c(ec2 ec2Var, th4 th4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ec2Var, th4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ec2Var;
            this.a = th4Var;
        }

        @Override // com.baidu.tieba.sb2.c
        public void b(PMSDownloadType pMSDownloadType, pk3 pk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, pk3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.c != null) {
                    this.b.c.onError(new PkgDownloadError(this.a, pk3Var));
                }
            }
        }

        @Override // com.baidu.tieba.sb2.c
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
    public class d implements sb2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rh4 a;
        public final /* synthetic */ ec2 b;

        public d(ec2 ec2Var, rh4 rh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ec2Var, rh4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ec2Var;
            this.a = rh4Var;
        }

        @Override // com.baidu.tieba.sb2.c
        public void b(PMSDownloadType pMSDownloadType, pk3 pk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, pk3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, pk3Var));
                }
            }
        }

        @Override // com.baidu.tieba.sb2.c
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
    public class e implements tca.a<th4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ec2 a;

        public e(ec2 ec2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ec2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ec2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tca.a, com.baidu.tieba.hda
        public void call(zca<? super th4> zcaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, zcaVar) != null) {
                return;
            }
            this.a.c = zcaVar;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements tca.a<rh4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ec2 a;

        public f(ec2 ec2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ec2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ec2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tca.a, com.baidu.tieba.hda
        public void call(zca<? super rh4> zcaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, zcaVar) != null) {
                return;
            }
            this.a.d = zcaVar;
        }
    }

    /* loaded from: classes4.dex */
    public class g extends zca<uh4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ec2 e;

        public g(ec2 ec2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ec2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ec2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.uca
        /* renamed from: g */
        public void onNext(uh4 uh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, uh4Var) == null) {
                w52.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + uh4Var.i);
            }
        }

        @Override // com.baidu.tieba.uca
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                w52.l("UpdateCoreCallback", "OnError", th);
                this.e.d0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.uca
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                w52.k("UpdateCoreCallback", "包下载完成");
                this.e.e0();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947729461, "Lcom/baidu/tieba/ec2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947729461, "Lcom/baidu/tieba/ec2;");
                return;
            }
        }
        j = gp1.a;
    }

    @Override // com.baidu.tieba.rg4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (j) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.rg4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            w52.k("UpdateCoreCallback", "onNoPackage:");
            e0();
        }
    }

    public final zca<uh4> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == null) {
                this.i = new g(this);
            }
            return this.i;
        }
        return (zca) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rg4
    public ng4<rh4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == null) {
                this.h = new b(this);
            }
            return this.h;
        }
        return (ng4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rg4
    public ng4<th4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.g == null) {
                this.g = new a(this);
            }
            return this.g;
        }
        return (ng4) invokeV.objValue;
    }

    public ec2(pn3<Exception> pn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pn3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = pn3Var;
    }

    @Override // com.baidu.tieba.rg4
    public void G(em4 em4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, em4Var) == null) {
            super.G(em4Var);
            if (em4Var == null) {
                return;
            }
            this.e = em4Var;
            if (!em4Var.k()) {
                Z();
            }
        }
    }

    public void a0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            w52.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            pn3<Exception> pn3Var = this.f;
            if (pn3Var != null) {
                pn3Var.a(exc);
            }
            this.f = null;
        }
    }

    public void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            w52.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            xl4.d(U(), 0L);
            ts3.a(0L);
            a0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public final void f0(rh4 rh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, rh4Var) == null) {
            sb2.c().d(rh4Var, new d(this, rh4Var));
        }
    }

    public final void g0(th4 th4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, th4Var) == null) {
            sb2.c().d(th4Var, new c(this, th4Var));
        }
    }

    @Override // com.baidu.tieba.rg4
    public void C(qh4 qh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qh4Var) == null) {
            super.C(qh4Var);
            w52.k("UpdateCoreCallback", "onFetchError: " + qh4Var.toString());
            if (qh4Var.a == 1010) {
                e0();
                return;
            }
            d0(new PMSException("UpdateCoreCallback failed by fetch error = " + qh4Var, qh4Var));
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.e.e()) {
                arrayList.add(tca.a(new e(this)));
            }
            if (this.e.d()) {
                arrayList.add(tca.a(new f(this)));
            }
            if (!arrayList.isEmpty()) {
                tca.i(arrayList).u(Y());
            }
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            w52.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            xl4.d(U(), currentTimeMillis);
            a0(null);
        }
    }
}
