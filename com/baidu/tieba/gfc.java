package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.qac;
import com.baidu.tieba.sac;
import com.baidu.tieba.wac;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes6.dex */
public final class gfc {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gbc<Throwable> a;
    public static volatile lbc<sac.a, sac.a> b;
    public static volatile lbc<wac.c, wac.c> c;
    public static volatile lbc<qac.f, qac.f> d;
    public static volatile mbc<sac, sac.a, sac.a> e;
    public static volatile mbc<wac, wac.c, wac.c> f;
    public static volatile mbc<qac, qac.f, qac.f> g;
    public static volatile lbc<vac, vac> h;
    public static volatile lbc<vac, vac> i;
    public static volatile lbc<vac, vac> j;
    public static volatile lbc<fbc, fbc> k;
    public static volatile lbc<zac, zac> l;
    public static volatile lbc<zac, zac> m;
    public static volatile kbc<? extends ScheduledExecutorService> n;
    public static volatile lbc<Throwable, Throwable> o;
    public static volatile lbc<Throwable, Throwable> p;
    public static volatile lbc<Throwable, Throwable> q;
    public static volatile lbc<sac.b, sac.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements lbc<Throwable, Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lbc
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                jfc.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements lbc<Throwable, Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lbc
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                jfc.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements lbc<sac.a, sac.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lbc
        public sac.a call(sac.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                jfc.c().d().a(aVar);
                return aVar;
            }
            return (sac.a) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements lbc<wac.c, wac.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lbc
        public wac.c call(wac.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                jfc.c().g().a(cVar);
                return cVar;
            }
            return (wac.c) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements lbc<qac.f, qac.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lbc
        public qac.f call(qac.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                jfc.c().a().a(fVar);
                return fVar;
            }
            return (qac.f) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class f implements gbc<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gbc
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                jfc.c().b().a(th);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class g implements mbc<sac, sac.a, sac.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mbc
        public sac.a call(sac sacVar, sac.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sacVar, aVar)) == null) {
                jfc.c().d().e(sacVar, aVar);
                return aVar;
            }
            return (sac.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class h implements lbc<zac, zac> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lbc
        public zac call(zac zacVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, zacVar)) == null) {
                jfc.c().d().d(zacVar);
                return zacVar;
            }
            return (zac) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class i implements mbc<wac, wac.c, wac.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mbc
        public wac.c call(wac wacVar, wac.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, wacVar, cVar)) == null) {
                lfc g = jfc.c().g();
                if (g == mfc.e()) {
                    return cVar;
                }
                rcc rccVar = new rcc(cVar);
                g.d(wacVar, rccVar);
                return new occ(rccVar);
            }
            return (wac.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class j implements lbc<zac, zac> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lbc
        public zac call(zac zacVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, zacVar)) == null) {
                jfc.c().g().c(zacVar);
                return zacVar;
            }
            return (zac) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class k implements mbc<qac, qac.f, qac.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mbc
        public qac.f call(qac qacVar, qac.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, qacVar, fVar)) == null) {
                jfc.c().a().c(qacVar, fVar);
                return fVar;
            }
            return (qac.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class l implements lbc<fbc, fbc> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lbc
        public fbc call(fbc fbcVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fbcVar)) == null) {
                jfc.c().f().k(fbcVar);
                return fbcVar;
            }
            return (fbc) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class m implements lbc<Throwable, Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lbc
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                jfc.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class n implements lbc<sac.b, sac.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public n() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lbc
        public sac.b call(sac.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                jfc.c().d().b(bVar);
                return bVar;
            }
            return (sac.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947793445, "Lcom/baidu/tieba/gfc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947793445, "Lcom/baidu/tieba/gfc;");
                return;
            }
        }
        b();
    }

    public static kbc<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return n;
        }
        return (kbc) invokeV.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            b = new c();
            c = new d();
            d = new e();
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            a = new f();
            e = new g();
            l = new h();
            f = new i();
            m = new j();
            g = new k();
            k = new l();
            o = new m();
            r = new n();
            p = new a();
            q = new b();
            c();
        }
    }

    public static Throwable d(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, th)) == null) {
            lbc<Throwable, Throwable> lbcVar = q;
            if (lbcVar != null) {
                return lbcVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static vac f(vac vacVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, vacVar)) == null) {
            lbc<vac, vac> lbcVar = h;
            if (lbcVar != null) {
                return lbcVar.call(vacVar);
            }
            return vacVar;
        }
        return (vac) invokeL.objValue;
    }

    public static qac.f g(qac.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            lbc<qac.f, qac.f> lbcVar = d;
            if (lbcVar != null) {
                return lbcVar.call(fVar);
            }
            return fVar;
        }
        return (qac.f) invokeL.objValue;
    }

    public static <T> sac.a<T> h(sac.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            lbc<sac.a, sac.a> lbcVar = b;
            if (lbcVar != null) {
                return lbcVar.call(aVar);
            }
            return aVar;
        }
        return (sac.a) invokeL.objValue;
    }

    public static <T> wac.c<T> i(wac.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            lbc<wac.c, wac.c> lbcVar = c;
            if (lbcVar != null) {
                return lbcVar.call(cVar);
            }
            return cVar;
        }
        return (wac.c) invokeL.objValue;
    }

    public static vac k(vac vacVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, vacVar)) == null) {
            lbc<vac, vac> lbcVar = i;
            if (lbcVar != null) {
                return lbcVar.call(vacVar);
            }
            return vacVar;
        }
        return (vac) invokeL.objValue;
    }

    public static vac l(vac vacVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, vacVar)) == null) {
            lbc<vac, vac> lbcVar = j;
            if (lbcVar != null) {
                return lbcVar.call(vacVar);
            }
            return vacVar;
        }
        return (vac) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            lbc<Throwable, Throwable> lbcVar = o;
            if (lbcVar != null) {
                return lbcVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> sac.b<R, T> n(sac.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            lbc<sac.b, sac.b> lbcVar = r;
            if (lbcVar != null) {
                return lbcVar.call(bVar);
            }
            return bVar;
        }
        return (sac.b) invokeL.objValue;
    }

    public static zac o(zac zacVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, zacVar)) == null) {
            lbc<zac, zac> lbcVar = l;
            if (lbcVar != null) {
                return lbcVar.call(zacVar);
            }
            return zacVar;
        }
        return (zac) invokeL.objValue;
    }

    public static fbc q(fbc fbcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, fbcVar)) == null) {
            lbc<fbc, fbc> lbcVar = k;
            if (lbcVar != null) {
                return lbcVar.call(fbcVar);
            }
            return fbcVar;
        }
        return (fbc) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            lbc<Throwable, Throwable> lbcVar = p;
            if (lbcVar != null) {
                return lbcVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static zac s(zac zacVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, zacVar)) == null) {
            lbc<zac, zac> lbcVar = m;
            if (lbcVar != null) {
                return lbcVar.call(zacVar);
            }
            return zacVar;
        }
        return (zac) invokeL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static <T> qac.f e(qac qacVar, qac.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, qacVar, fVar)) == null) {
            mbc<qac, qac.f, qac.f> mbcVar = g;
            if (mbcVar != null) {
                return mbcVar.call(qacVar, fVar);
            }
            return fVar;
        }
        return (qac.f) invokeLL.objValue;
    }

    public static <T> sac.a<T> p(sac<T> sacVar, sac.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, sacVar, aVar)) == null) {
            mbc<sac, sac.a, sac.a> mbcVar = e;
            if (mbcVar != null) {
                return mbcVar.call(sacVar, aVar);
            }
            return aVar;
        }
        return (sac.a) invokeLL.objValue;
    }

    public static <T> wac.c<T> t(wac<T> wacVar, wac.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, wacVar, cVar)) == null) {
            mbc<wac, wac.c, wac.c> mbcVar = f;
            if (mbcVar != null) {
                return mbcVar.call(wacVar, cVar);
            }
            return cVar;
        }
        return (wac.c) invokeLL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            gbc<Throwable> gbcVar = a;
            if (gbcVar != null) {
                try {
                    gbcVar.call(th);
                    return;
                } catch (Throwable th2) {
                    PrintStream printStream = System.err;
                    printStream.println("The onError handler threw an Exception. It shouldn't. => " + th2.getMessage());
                    th2.printStackTrace();
                    u(th2);
                }
            }
            u(th);
        }
    }
}
