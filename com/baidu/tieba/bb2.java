package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.model.PMSException;
import com.baidu.tieba.ora;
import com.baidu.tieba.pa2;
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
public abstract class bb2 extends xa2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public ura<? super qg4> c;
    public ura<? super og4> d;
    public bl4 e;
    public mm3<Exception> f;
    public kf4<qg4> g;
    public kf4<og4> h;
    public ura<rg4> i;

    public abstract int U();

    public abstract PMSDownloadType V();

    public abstract String W();

    public abstract String X();

    public abstract mj3 b0(og4 og4Var);

    public abstract mj3 c0(qg4 qg4Var);

    /* loaded from: classes3.dex */
    public class a extends hf4<qg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bb2 a;

        public a(bb2 bb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bb2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kf4
        /* renamed from: l */
        public String d(qg4 qg4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, qg4Var)) == null) {
                return this.a.X();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: q */
        public void c(qg4 qg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, qg4Var) == null) {
                super.c(qg4Var);
                t42.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: r */
        public void f(qg4 qg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, qg4Var) == null) {
                super.f(qg4Var);
                if (bb2.j) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.a.g0(qg4Var);
            }
        }

        @Override // com.baidu.tieba.mf4
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
        @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: o */
        public void e(qg4 qg4Var, ng4 ng4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, qg4Var, ng4Var) == null) {
                super.e(qg4Var, ng4Var);
                t42.k("UpdateCoreCallback", "onDownloadError:" + ng4Var);
                this.a.e.l(qg4Var);
                mj3 mj3Var = new mj3();
                mj3Var.k(13L);
                mj3Var.i(ng4Var.a);
                mj3Var.d("Framework包下载失败");
                mj3Var.f(ng4Var.toString());
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(qg4Var, mj3Var));
                }
                pa2.c().a(qg4Var, this.a.V(), mj3Var);
                xn4.k(qg4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: p */
        public void i(qg4 qg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qg4Var) == null) {
                super.i(qg4Var);
                t42.k("UpdateCoreCallback", "onFileDownloaded: " + qg4Var.i);
                mj3 c0 = this.a.c0(qg4Var);
                if (c0 == null) {
                    this.a.e.m(qg4Var);
                    if (this.a.c != null) {
                        this.a.c.onNext(qg4Var);
                        this.a.c.onCompleted();
                    }
                    qf4.i().m(qg4Var);
                    pa2.c().b(qg4Var, this.a.V());
                    ul3.a();
                    return;
                }
                this.a.e.l(qg4Var);
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(qg4Var, c0));
                }
                pa2.c().a(qg4Var, this.a.V(), c0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends hf4<og4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bb2 a;

        public b(bb2 bb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bb2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kf4
        /* renamed from: l */
        public String d(og4 og4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, og4Var)) == null) {
                return this.a.W();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: q */
        public void c(og4 og4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, og4Var) == null) {
                super.c(og4Var);
                t42.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: r */
        public void f(og4 og4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, og4Var) == null) {
                super.f(og4Var);
                if (bb2.j) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.a.f0(og4Var);
            }
        }

        @Override // com.baidu.tieba.mf4
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
        @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: o */
        public void e(og4 og4Var, ng4 ng4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, og4Var, ng4Var) == null) {
                super.e(og4Var, ng4Var);
                t42.k("UpdateCoreCallback", "onDownloadError:" + ng4Var);
                this.a.e.l(og4Var);
                mj3 mj3Var = new mj3();
                mj3Var.k(14L);
                mj3Var.i(ng4Var.a);
                mj3Var.d("Extension下载失败");
                mj3Var.f(ng4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(og4Var, mj3Var));
                }
                pa2.c().a(og4Var, this.a.V(), mj3Var);
                xn4.k(og4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: p */
        public void i(og4 og4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, og4Var) == null) {
                super.i(og4Var);
                t42.k("UpdateCoreCallback", "onFileDownloaded: " + og4Var.i);
                mj3 b0 = this.a.b0(og4Var);
                if (b0 == null) {
                    this.a.e.m(og4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(og4Var);
                        this.a.d.onCompleted();
                    }
                    qf4.i().m(og4Var);
                    pa2.c().b(og4Var, this.a.V());
                    return;
                }
                this.a.e.l(og4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(og4Var, b0));
                }
                pa2.c().a(og4Var, this.a.V(), b0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements pa2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qg4 a;
        public final /* synthetic */ bb2 b;

        public c(bb2 bb2Var, qg4 qg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bb2Var, qg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bb2Var;
            this.a = qg4Var;
        }

        @Override // com.baidu.tieba.pa2.c
        public void b(PMSDownloadType pMSDownloadType, mj3 mj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, mj3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.c != null) {
                    this.b.c.onError(new PkgDownloadError(this.a, mj3Var));
                }
            }
        }

        @Override // com.baidu.tieba.pa2.c
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
    public class d implements pa2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og4 a;
        public final /* synthetic */ bb2 b;

        public d(bb2 bb2Var, og4 og4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bb2Var, og4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bb2Var;
            this.a = og4Var;
        }

        @Override // com.baidu.tieba.pa2.c
        public void b(PMSDownloadType pMSDownloadType, mj3 mj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, mj3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, mj3Var));
                }
            }
        }

        @Override // com.baidu.tieba.pa2.c
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
    public class e implements ora.a<qg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bb2 a;

        public e(bb2 bb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bb2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ora.a, com.baidu.tieba.csa
        public void call(ura<? super qg4> uraVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, uraVar) != null) {
                return;
            }
            this.a.c = uraVar;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements ora.a<og4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bb2 a;

        public f(bb2 bb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bb2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ora.a, com.baidu.tieba.csa
        public void call(ura<? super og4> uraVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, uraVar) != null) {
                return;
            }
            this.a.d = uraVar;
        }
    }

    /* loaded from: classes3.dex */
    public class g extends ura<rg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bb2 e;

        public g(bb2 bb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = bb2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pra
        /* renamed from: g */
        public void onNext(rg4 rg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, rg4Var) == null) {
                t42.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + rg4Var.i);
            }
        }

        @Override // com.baidu.tieba.pra
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                t42.l("UpdateCoreCallback", "OnError", th);
                this.e.d0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.pra
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                t42.k("UpdateCoreCallback", "包下载完成");
                this.e.e0();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947639127, "Lcom/baidu/tieba/bb2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947639127, "Lcom/baidu/tieba/bb2;");
                return;
            }
        }
        j = do1.a;
    }

    @Override // com.baidu.tieba.of4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (j) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.of4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            t42.k("UpdateCoreCallback", "onNoPackage:");
            e0();
        }
    }

    public final ura<rg4> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == null) {
                this.i = new g(this);
            }
            return this.i;
        }
        return (ura) invokeV.objValue;
    }

    @Override // com.baidu.tieba.of4
    public kf4<og4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == null) {
                this.h = new b(this);
            }
            return this.h;
        }
        return (kf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.of4
    public kf4<qg4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.g == null) {
                this.g = new a(this);
            }
            return this.g;
        }
        return (kf4) invokeV.objValue;
    }

    public bb2(mm3<Exception> mm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mm3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = mm3Var;
    }

    @Override // com.baidu.tieba.of4
    public void G(bl4 bl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bl4Var) == null) {
            super.G(bl4Var);
            if (bl4Var == null) {
                return;
            }
            this.e = bl4Var;
            if (!bl4Var.k()) {
                Z();
            }
        }
    }

    public void a0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            t42.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            mm3<Exception> mm3Var = this.f;
            if (mm3Var != null) {
                mm3Var.a(exc);
            }
            this.f = null;
        }
    }

    public void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            t42.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            uk4.d(U(), 0L);
            qr3.a(0L);
            a0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public final void f0(og4 og4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, og4Var) == null) {
            pa2.c().d(og4Var, new d(this, og4Var));
        }
    }

    public final void g0(qg4 qg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, qg4Var) == null) {
            pa2.c().d(qg4Var, new c(this, qg4Var));
        }
    }

    @Override // com.baidu.tieba.of4
    public void C(ng4 ng4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ng4Var) == null) {
            super.C(ng4Var);
            t42.k("UpdateCoreCallback", "onFetchError: " + ng4Var.toString());
            if (ng4Var.a == 1010) {
                e0();
                return;
            }
            d0(new PMSException("UpdateCoreCallback failed by fetch error = " + ng4Var, ng4Var));
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.e.e()) {
                arrayList.add(ora.a(new e(this)));
            }
            if (this.e.d()) {
                arrayList.add(ora.a(new f(this)));
            }
            if (!arrayList.isEmpty()) {
                ora.i(arrayList).u(Y());
            }
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            t42.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            uk4.d(U(), currentTimeMillis);
            a0(null);
        }
    }
}
