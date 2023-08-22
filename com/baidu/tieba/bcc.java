package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.l7c;
import com.baidu.tieba.n7c;
import com.baidu.tieba.r7c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes5.dex */
public final class bcc {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b8c<Throwable> a;
    public static volatile g8c<n7c.a, n7c.a> b;
    public static volatile g8c<r7c.c, r7c.c> c;
    public static volatile g8c<l7c.f, l7c.f> d;
    public static volatile h8c<n7c, n7c.a, n7c.a> e;
    public static volatile h8c<r7c, r7c.c, r7c.c> f;
    public static volatile h8c<l7c, l7c.f, l7c.f> g;
    public static volatile g8c<q7c, q7c> h;
    public static volatile g8c<q7c, q7c> i;
    public static volatile g8c<q7c, q7c> j;
    public static volatile g8c<a8c, a8c> k;
    public static volatile g8c<u7c, u7c> l;
    public static volatile g8c<u7c, u7c> m;
    public static volatile f8c<? extends ScheduledExecutorService> n;
    public static volatile g8c<Throwable, Throwable> o;
    public static volatile g8c<Throwable, Throwable> p;
    public static volatile g8c<Throwable, Throwable> q;
    public static volatile g8c<n7c.b, n7c.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements g8c<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.g8c
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                ecc.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements g8c<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.g8c
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                ecc.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements g8c<n7c.a, n7c.a> {
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
        @Override // com.baidu.tieba.g8c
        public n7c.a call(n7c.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                ecc.c().d().a(aVar);
                return aVar;
            }
            return (n7c.a) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements g8c<r7c.c, r7c.c> {
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
        @Override // com.baidu.tieba.g8c
        public r7c.c call(r7c.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                ecc.c().g().a(cVar);
                return cVar;
            }
            return (r7c.c) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements g8c<l7c.f, l7c.f> {
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
        @Override // com.baidu.tieba.g8c
        public l7c.f call(l7c.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                ecc.c().a().a(fVar);
                return fVar;
            }
            return (l7c.f) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class f implements b8c<Throwable> {
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
        @Override // com.baidu.tieba.b8c
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                ecc.c().b().a(th);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class g implements h8c<n7c, n7c.a, n7c.a> {
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
        @Override // com.baidu.tieba.h8c
        public n7c.a call(n7c n7cVar, n7c.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, n7cVar, aVar)) == null) {
                ecc.c().d().e(n7cVar, aVar);
                return aVar;
            }
            return (n7c.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class h implements g8c<u7c, u7c> {
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
        @Override // com.baidu.tieba.g8c
        public u7c call(u7c u7cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, u7cVar)) == null) {
                ecc.c().d().d(u7cVar);
                return u7cVar;
            }
            return (u7c) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class i implements h8c<r7c, r7c.c, r7c.c> {
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
        @Override // com.baidu.tieba.h8c
        public r7c.c call(r7c r7cVar, r7c.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, r7cVar, cVar)) == null) {
                gcc g = ecc.c().g();
                if (g == hcc.e()) {
                    return cVar;
                }
                m9c m9cVar = new m9c(cVar);
                g.d(r7cVar, m9cVar);
                return new j9c(m9cVar);
            }
            return (r7c.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class j implements g8c<u7c, u7c> {
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
        @Override // com.baidu.tieba.g8c
        public u7c call(u7c u7cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, u7cVar)) == null) {
                ecc.c().g().c(u7cVar);
                return u7cVar;
            }
            return (u7c) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class k implements h8c<l7c, l7c.f, l7c.f> {
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
        @Override // com.baidu.tieba.h8c
        public l7c.f call(l7c l7cVar, l7c.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, l7cVar, fVar)) == null) {
                ecc.c().a().c(l7cVar, fVar);
                return fVar;
            }
            return (l7c.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class l implements g8c<a8c, a8c> {
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
        @Override // com.baidu.tieba.g8c
        public a8c call(a8c a8cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, a8cVar)) == null) {
                ecc.c().f().k(a8cVar);
                return a8cVar;
            }
            return (a8c) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class m implements g8c<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.g8c
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                ecc.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class n implements g8c<n7c.b, n7c.b> {
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
        @Override // com.baidu.tieba.g8c
        public n7c.b call(n7c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                ecc.c().d().b(bVar);
                return bVar;
            }
            return (n7c.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947641607, "Lcom/baidu/tieba/bcc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947641607, "Lcom/baidu/tieba/bcc;");
                return;
            }
        }
        b();
    }

    public static f8c<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return n;
        }
        return (f8c) invokeV.objValue;
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
            g8c<Throwable, Throwable> g8cVar = q;
            if (g8cVar != null) {
                return g8cVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static q7c f(q7c q7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, q7cVar)) == null) {
            g8c<q7c, q7c> g8cVar = h;
            if (g8cVar != null) {
                return g8cVar.call(q7cVar);
            }
            return q7cVar;
        }
        return (q7c) invokeL.objValue;
    }

    public static l7c.f g(l7c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            g8c<l7c.f, l7c.f> g8cVar = d;
            if (g8cVar != null) {
                return g8cVar.call(fVar);
            }
            return fVar;
        }
        return (l7c.f) invokeL.objValue;
    }

    public static <T> n7c.a<T> h(n7c.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            g8c<n7c.a, n7c.a> g8cVar = b;
            if (g8cVar != null) {
                return g8cVar.call(aVar);
            }
            return aVar;
        }
        return (n7c.a) invokeL.objValue;
    }

    public static <T> r7c.c<T> i(r7c.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            g8c<r7c.c, r7c.c> g8cVar = c;
            if (g8cVar != null) {
                return g8cVar.call(cVar);
            }
            return cVar;
        }
        return (r7c.c) invokeL.objValue;
    }

    public static q7c k(q7c q7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, q7cVar)) == null) {
            g8c<q7c, q7c> g8cVar = i;
            if (g8cVar != null) {
                return g8cVar.call(q7cVar);
            }
            return q7cVar;
        }
        return (q7c) invokeL.objValue;
    }

    public static q7c l(q7c q7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, q7cVar)) == null) {
            g8c<q7c, q7c> g8cVar = j;
            if (g8cVar != null) {
                return g8cVar.call(q7cVar);
            }
            return q7cVar;
        }
        return (q7c) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            g8c<Throwable, Throwable> g8cVar = o;
            if (g8cVar != null) {
                return g8cVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> n7c.b<R, T> n(n7c.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            g8c<n7c.b, n7c.b> g8cVar = r;
            if (g8cVar != null) {
                return g8cVar.call(bVar);
            }
            return bVar;
        }
        return (n7c.b) invokeL.objValue;
    }

    public static u7c o(u7c u7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, u7cVar)) == null) {
            g8c<u7c, u7c> g8cVar = l;
            if (g8cVar != null) {
                return g8cVar.call(u7cVar);
            }
            return u7cVar;
        }
        return (u7c) invokeL.objValue;
    }

    public static a8c q(a8c a8cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, a8cVar)) == null) {
            g8c<a8c, a8c> g8cVar = k;
            if (g8cVar != null) {
                return g8cVar.call(a8cVar);
            }
            return a8cVar;
        }
        return (a8c) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            g8c<Throwable, Throwable> g8cVar = p;
            if (g8cVar != null) {
                return g8cVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static u7c s(u7c u7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, u7cVar)) == null) {
            g8c<u7c, u7c> g8cVar = m;
            if (g8cVar != null) {
                return g8cVar.call(u7cVar);
            }
            return u7cVar;
        }
        return (u7c) invokeL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static <T> l7c.f e(l7c l7cVar, l7c.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, l7cVar, fVar)) == null) {
            h8c<l7c, l7c.f, l7c.f> h8cVar = g;
            if (h8cVar != null) {
                return h8cVar.call(l7cVar, fVar);
            }
            return fVar;
        }
        return (l7c.f) invokeLL.objValue;
    }

    public static <T> n7c.a<T> p(n7c<T> n7cVar, n7c.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, n7cVar, aVar)) == null) {
            h8c<n7c, n7c.a, n7c.a> h8cVar = e;
            if (h8cVar != null) {
                return h8cVar.call(n7cVar, aVar);
            }
            return aVar;
        }
        return (n7c.a) invokeLL.objValue;
    }

    public static <T> r7c.c<T> t(r7c<T> r7cVar, r7c.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, r7cVar, cVar)) == null) {
            h8c<r7c, r7c.c, r7c.c> h8cVar = f;
            if (h8cVar != null) {
                return h8cVar.call(r7cVar, cVar);
            }
            return cVar;
        }
        return (r7c.c) invokeLL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            b8c<Throwable> b8cVar = a;
            if (b8cVar != null) {
                try {
                    b8cVar.call(th);
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
