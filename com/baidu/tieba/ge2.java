package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.model.PMSException;
import com.baidu.tieba.ud2;
import com.baidu.tieba.x0c;
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
public abstract class ge2 extends ce2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public d1c<? super vj4> c;
    public d1c<? super tj4> d;
    public go4 e;
    public rp3<Exception> f;
    public pi4<vj4> g;
    public pi4<tj4> h;
    public d1c<wj4> i;

    public abstract int U();

    public abstract PMSDownloadType V();

    public abstract String W();

    public abstract String X();

    public abstract rm3 b0(tj4 tj4Var);

    public abstract rm3 c0(vj4 vj4Var);

    /* loaded from: classes6.dex */
    public class a extends mi4<vj4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge2 a;

        public a(ge2 ge2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pi4
        /* renamed from: l */
        public String d(vj4 vj4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, vj4Var)) == null) {
                return this.a.X();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: q */
        public void c(vj4 vj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, vj4Var) == null) {
                super.c(vj4Var);
                y72.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: r */
        public void f(vj4 vj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, vj4Var) == null) {
                super.f(vj4Var);
                if (ge2.j) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.a.g0(vj4Var);
            }
        }

        @Override // com.baidu.tieba.ri4
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
        @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: o */
        public void e(vj4 vj4Var, sj4 sj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, vj4Var, sj4Var) == null) {
                super.e(vj4Var, sj4Var);
                y72.k("UpdateCoreCallback", "onDownloadError:" + sj4Var);
                this.a.e.l(vj4Var);
                rm3 rm3Var = new rm3();
                rm3Var.k(13L);
                rm3Var.i(sj4Var.a);
                rm3Var.d("Framework包下载失败");
                rm3Var.f(sj4Var.toString());
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(vj4Var, rm3Var));
                }
                ud2.c().a(vj4Var, this.a.V(), rm3Var);
                cr4.k(vj4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: p */
        public void i(vj4 vj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vj4Var) == null) {
                super.i(vj4Var);
                y72.k("UpdateCoreCallback", "onFileDownloaded: " + vj4Var.i);
                rm3 c0 = this.a.c0(vj4Var);
                if (c0 == null) {
                    this.a.e.m(vj4Var);
                    if (this.a.c != null) {
                        this.a.c.onNext(vj4Var);
                        this.a.c.onCompleted();
                    }
                    vi4.i().m(vj4Var);
                    ud2.c().b(vj4Var, this.a.V());
                    zo3.a();
                    return;
                }
                this.a.e.l(vj4Var);
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(vj4Var, c0));
                }
                ud2.c().a(vj4Var, this.a.V(), c0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends mi4<tj4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge2 a;

        public b(ge2 ge2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pi4
        /* renamed from: l */
        public String d(tj4 tj4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, tj4Var)) == null) {
                return this.a.W();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: q */
        public void c(tj4 tj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, tj4Var) == null) {
                super.c(tj4Var);
                y72.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: r */
        public void f(tj4 tj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, tj4Var) == null) {
                super.f(tj4Var);
                if (ge2.j) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.a.f0(tj4Var);
            }
        }

        @Override // com.baidu.tieba.ri4
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
        @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: o */
        public void e(tj4 tj4Var, sj4 sj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, tj4Var, sj4Var) == null) {
                super.e(tj4Var, sj4Var);
                y72.k("UpdateCoreCallback", "onDownloadError:" + sj4Var);
                this.a.e.l(tj4Var);
                rm3 rm3Var = new rm3();
                rm3Var.k(14L);
                rm3Var.i(sj4Var.a);
                rm3Var.d("Extension下载失败");
                rm3Var.f(sj4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(tj4Var, rm3Var));
                }
                ud2.c().a(tj4Var, this.a.V(), rm3Var);
                cr4.k(tj4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: p */
        public void i(tj4 tj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tj4Var) == null) {
                super.i(tj4Var);
                y72.k("UpdateCoreCallback", "onFileDownloaded: " + tj4Var.i);
                rm3 b0 = this.a.b0(tj4Var);
                if (b0 == null) {
                    this.a.e.m(tj4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(tj4Var);
                        this.a.d.onCompleted();
                    }
                    vi4.i().m(tj4Var);
                    ud2.c().b(tj4Var, this.a.V());
                    return;
                }
                this.a.e.l(tj4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(tj4Var, b0));
                }
                ud2.c().a(tj4Var, this.a.V(), b0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ud2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vj4 a;
        public final /* synthetic */ ge2 b;

        public c(ge2 ge2Var, vj4 vj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var, vj4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ge2Var;
            this.a = vj4Var;
        }

        @Override // com.baidu.tieba.ud2.c
        public void b(PMSDownloadType pMSDownloadType, rm3 rm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, rm3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.c != null) {
                    this.b.c.onError(new PkgDownloadError(this.a, rm3Var));
                }
            }
        }

        @Override // com.baidu.tieba.ud2.c
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
    public class d implements ud2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tj4 a;
        public final /* synthetic */ ge2 b;

        public d(ge2 ge2Var, tj4 tj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var, tj4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ge2Var;
            this.a = tj4Var;
        }

        @Override // com.baidu.tieba.ud2.c
        public void b(PMSDownloadType pMSDownloadType, rm3 rm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, rm3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, rm3Var));
                }
            }
        }

        @Override // com.baidu.tieba.ud2.c
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
    public class e implements x0c.a<vj4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge2 a;

        public e(ge2 ge2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.x0c.a, com.baidu.tieba.l1c
        public void call(d1c<? super vj4> d1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, d1cVar) != null) {
                return;
            }
            this.a.c = d1cVar;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements x0c.a<tj4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge2 a;

        public f(ge2 ge2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.x0c.a, com.baidu.tieba.l1c
        public void call(d1c<? super tj4> d1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, d1cVar) != null) {
                return;
            }
            this.a.d = d1cVar;
        }
    }

    /* loaded from: classes6.dex */
    public class g extends d1c<wj4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge2 e;

        public g(ge2 ge2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ge2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.y0c
        /* renamed from: g */
        public void onNext(wj4 wj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wj4Var) == null) {
                y72.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + wj4Var.i);
            }
        }

        @Override // com.baidu.tieba.y0c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                y72.l("UpdateCoreCallback", "OnError", th);
                this.e.d0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.y0c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                y72.k("UpdateCoreCallback", "包下载完成");
                this.e.e0();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947790965, "Lcom/baidu/tieba/ge2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947790965, "Lcom/baidu/tieba/ge2;");
                return;
            }
        }
        j = ir1.a;
    }

    @Override // com.baidu.tieba.ti4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (j) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.ti4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            y72.k("UpdateCoreCallback", "onNoPackage:");
            e0();
        }
    }

    public final d1c<wj4> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == null) {
                this.i = new g(this);
            }
            return this.i;
        }
        return (d1c) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ti4
    public pi4<tj4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == null) {
                this.h = new b(this);
            }
            return this.h;
        }
        return (pi4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ti4
    public pi4<vj4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.g == null) {
                this.g = new a(this);
            }
            return this.g;
        }
        return (pi4) invokeV.objValue;
    }

    public ge2(rp3<Exception> rp3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rp3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = rp3Var;
    }

    @Override // com.baidu.tieba.ti4
    public void G(go4 go4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, go4Var) == null) {
            super.G(go4Var);
            if (go4Var == null) {
                return;
            }
            this.e = go4Var;
            if (!go4Var.k()) {
                Z();
            }
        }
    }

    public void a0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            y72.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            rp3<Exception> rp3Var = this.f;
            if (rp3Var != null) {
                rp3Var.a(exc);
            }
            this.f = null;
        }
    }

    public void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            y72.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            zn4.d(U(), 0L);
            vu3.a(0L);
            a0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public final void f0(tj4 tj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, tj4Var) == null) {
            ud2.c().d(tj4Var, new d(this, tj4Var));
        }
    }

    public final void g0(vj4 vj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, vj4Var) == null) {
            ud2.c().d(vj4Var, new c(this, vj4Var));
        }
    }

    @Override // com.baidu.tieba.ti4
    public void C(sj4 sj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sj4Var) == null) {
            super.C(sj4Var);
            y72.k("UpdateCoreCallback", "onFetchError: " + sj4Var.toString());
            if (sj4Var.a == 1010) {
                e0();
                return;
            }
            d0(new PMSException("UpdateCoreCallback failed by fetch error = " + sj4Var, sj4Var));
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.e.e()) {
                arrayList.add(x0c.d(new e(this)));
            }
            if (this.e.d()) {
                arrayList.add(x0c.d(new f(this)));
            }
            if (!arrayList.isEmpty()) {
                x0c.q(arrayList).F(Y());
            }
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            y72.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            zn4.d(U(), currentTimeMillis);
            a0(null);
        }
    }
}
