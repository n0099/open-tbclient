package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cv9;
import com.baidu.tieba.wu9;
import com.baidu.tieba.yu9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes4.dex */
public final class fz9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mv9<Throwable> a;
    public static volatile qv9<yu9.a, yu9.a> b;
    public static volatile qv9<cv9.c, cv9.c> c;
    public static volatile qv9<wu9.f, wu9.f> d;
    public static volatile rv9<yu9, yu9.a, yu9.a> e;
    public static volatile rv9<cv9, cv9.c, cv9.c> f;
    public static volatile rv9<wu9, wu9.f, wu9.f> g;
    public static volatile qv9<bv9, bv9> h;
    public static volatile qv9<bv9, bv9> i;
    public static volatile qv9<bv9, bv9> j;
    public static volatile qv9<lv9, lv9> k;
    public static volatile qv9<fv9, fv9> l;
    public static volatile qv9<fv9, fv9> m;
    public static volatile pv9<? extends ScheduledExecutorService> n;
    public static volatile qv9<Throwable, Throwable> o;
    public static volatile qv9<Throwable, Throwable> p;
    public static volatile qv9<Throwable, Throwable> q;
    public static volatile qv9<yu9.b, yu9.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements qv9<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.qv9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                iz9.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements qv9<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.qv9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                iz9.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements qv9<yu9.a, yu9.a> {
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
        @Override // com.baidu.tieba.qv9
        public yu9.a call(yu9.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                iz9.c().d().a(aVar);
                return aVar;
            }
            return (yu9.a) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements qv9<cv9.c, cv9.c> {
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
        @Override // com.baidu.tieba.qv9
        public cv9.c call(cv9.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                iz9.c().g().a(cVar);
                return cVar;
            }
            return (cv9.c) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements qv9<wu9.f, wu9.f> {
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
        @Override // com.baidu.tieba.qv9
        public wu9.f call(wu9.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                iz9.c().a().a(fVar);
                return fVar;
            }
            return (wu9.f) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class f implements mv9<Throwable> {
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
        @Override // com.baidu.tieba.mv9
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                iz9.c().b().a(th);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class g implements rv9<yu9, yu9.a, yu9.a> {
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
        @Override // com.baidu.tieba.rv9
        public yu9.a call(yu9 yu9Var, yu9.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, yu9Var, aVar)) == null) {
                iz9.c().d().e(yu9Var, aVar);
                return aVar;
            }
            return (yu9.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class h implements qv9<fv9, fv9> {
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
        @Override // com.baidu.tieba.qv9
        public fv9 call(fv9 fv9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fv9Var)) == null) {
                iz9.c().d().d(fv9Var);
                return fv9Var;
            }
            return (fv9) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class i implements rv9<cv9, cv9.c, cv9.c> {
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
        @Override // com.baidu.tieba.rv9
        public cv9.c call(cv9 cv9Var, cv9.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cv9Var, cVar)) == null) {
                kz9 g = iz9.c().g();
                if (g == lz9.e()) {
                    return cVar;
                }
                qw9 qw9Var = new qw9(cVar);
                g.d(cv9Var, qw9Var);
                return new nw9(qw9Var);
            }
            return (cv9.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class j implements qv9<fv9, fv9> {
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
        @Override // com.baidu.tieba.qv9
        public fv9 call(fv9 fv9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fv9Var)) == null) {
                iz9.c().g().c(fv9Var);
                return fv9Var;
            }
            return (fv9) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class k implements rv9<wu9, wu9.f, wu9.f> {
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
        @Override // com.baidu.tieba.rv9
        public wu9.f call(wu9 wu9Var, wu9.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, wu9Var, fVar)) == null) {
                iz9.c().a().c(wu9Var, fVar);
                return fVar;
            }
            return (wu9.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class l implements qv9<lv9, lv9> {
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
        @Override // com.baidu.tieba.qv9
        public lv9 call(lv9 lv9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lv9Var)) == null) {
                iz9.c().f().k(lv9Var);
                return lv9Var;
            }
            return (lv9) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class m implements qv9<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.qv9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                iz9.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class n implements qv9<yu9.b, yu9.b> {
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
        @Override // com.baidu.tieba.qv9
        public yu9.b call(yu9.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                iz9.c().d().b(bVar);
                return bVar;
            }
            return (yu9.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947781572, "Lcom/baidu/tieba/fz9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947781572, "Lcom/baidu/tieba/fz9;");
                return;
            }
        }
        b();
    }

    public static pv9<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? n : (pv9) invokeV.objValue;
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

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            b = new c();
            c = new d();
            d = new e();
        }
    }

    public static Throwable d(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, th)) == null) {
            qv9<Throwable, Throwable> qv9Var = q;
            return qv9Var != null ? qv9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T> wu9.f e(wu9 wu9Var, wu9.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, wu9Var, fVar)) == null) {
            rv9<wu9, wu9.f, wu9.f> rv9Var = g;
            return rv9Var != null ? rv9Var.call(wu9Var, fVar) : fVar;
        }
        return (wu9.f) invokeLL.objValue;
    }

    public static bv9 f(bv9 bv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bv9Var)) == null) {
            qv9<bv9, bv9> qv9Var = h;
            return qv9Var != null ? qv9Var.call(bv9Var) : bv9Var;
        }
        return (bv9) invokeL.objValue;
    }

    public static wu9.f g(wu9.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            qv9<wu9.f, wu9.f> qv9Var = d;
            return qv9Var != null ? qv9Var.call(fVar) : fVar;
        }
        return (wu9.f) invokeL.objValue;
    }

    public static <T> yu9.a<T> h(yu9.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            qv9<yu9.a, yu9.a> qv9Var = b;
            return qv9Var != null ? qv9Var.call(aVar) : aVar;
        }
        return (yu9.a) invokeL.objValue;
    }

    public static <T> cv9.c<T> i(cv9.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            qv9<cv9.c, cv9.c> qv9Var = c;
            return qv9Var != null ? qv9Var.call(cVar) : cVar;
        }
        return (cv9.c) invokeL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            mv9<Throwable> mv9Var = a;
            if (mv9Var != null) {
                try {
                    mv9Var.call(th);
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

    public static bv9 k(bv9 bv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bv9Var)) == null) {
            qv9<bv9, bv9> qv9Var = i;
            return qv9Var != null ? qv9Var.call(bv9Var) : bv9Var;
        }
        return (bv9) invokeL.objValue;
    }

    public static bv9 l(bv9 bv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, bv9Var)) == null) {
            qv9<bv9, bv9> qv9Var = j;
            return qv9Var != null ? qv9Var.call(bv9Var) : bv9Var;
        }
        return (bv9) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            qv9<Throwable, Throwable> qv9Var = o;
            return qv9Var != null ? qv9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> yu9.b<R, T> n(yu9.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            qv9<yu9.b, yu9.b> qv9Var = r;
            return qv9Var != null ? qv9Var.call(bVar) : bVar;
        }
        return (yu9.b) invokeL.objValue;
    }

    public static fv9 o(fv9 fv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, fv9Var)) == null) {
            qv9<fv9, fv9> qv9Var = l;
            return qv9Var != null ? qv9Var.call(fv9Var) : fv9Var;
        }
        return (fv9) invokeL.objValue;
    }

    public static <T> yu9.a<T> p(yu9<T> yu9Var, yu9.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, yu9Var, aVar)) == null) {
            rv9<yu9, yu9.a, yu9.a> rv9Var = e;
            return rv9Var != null ? rv9Var.call(yu9Var, aVar) : aVar;
        }
        return (yu9.a) invokeLL.objValue;
    }

    public static lv9 q(lv9 lv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, lv9Var)) == null) {
            qv9<lv9, lv9> qv9Var = k;
            return qv9Var != null ? qv9Var.call(lv9Var) : lv9Var;
        }
        return (lv9) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            qv9<Throwable, Throwable> qv9Var = p;
            return qv9Var != null ? qv9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static fv9 s(fv9 fv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, fv9Var)) == null) {
            qv9<fv9, fv9> qv9Var = m;
            return qv9Var != null ? qv9Var.call(fv9Var) : fv9Var;
        }
        return (fv9) invokeL.objValue;
    }

    public static <T> cv9.c<T> t(cv9<T> cv9Var, cv9.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, cv9Var, cVar)) == null) {
            rv9<cv9, cv9.c, cv9.c> rv9Var = f;
            return rv9Var != null ? rv9Var.call(cv9Var, cVar) : cVar;
        }
        return (cv9.c) invokeLL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }
}
