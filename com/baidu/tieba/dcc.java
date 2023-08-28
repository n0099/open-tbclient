package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n7c;
import com.baidu.tieba.p7c;
import com.baidu.tieba.t7c;
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
public final class dcc {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d8c<Throwable> a;
    public static volatile i8c<p7c.a, p7c.a> b;
    public static volatile i8c<t7c.c, t7c.c> c;
    public static volatile i8c<n7c.f, n7c.f> d;
    public static volatile j8c<p7c, p7c.a, p7c.a> e;
    public static volatile j8c<t7c, t7c.c, t7c.c> f;
    public static volatile j8c<n7c, n7c.f, n7c.f> g;
    public static volatile i8c<s7c, s7c> h;
    public static volatile i8c<s7c, s7c> i;
    public static volatile i8c<s7c, s7c> j;
    public static volatile i8c<c8c, c8c> k;
    public static volatile i8c<w7c, w7c> l;
    public static volatile i8c<w7c, w7c> m;
    public static volatile h8c<? extends ScheduledExecutorService> n;
    public static volatile i8c<Throwable, Throwable> o;
    public static volatile i8c<Throwable, Throwable> p;
    public static volatile i8c<Throwable, Throwable> q;
    public static volatile i8c<p7c.b, p7c.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements i8c<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.i8c
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                gcc.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements i8c<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.i8c
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                gcc.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements i8c<p7c.a, p7c.a> {
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
        @Override // com.baidu.tieba.i8c
        public p7c.a call(p7c.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                gcc.c().d().a(aVar);
                return aVar;
            }
            return (p7c.a) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements i8c<t7c.c, t7c.c> {
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
        @Override // com.baidu.tieba.i8c
        public t7c.c call(t7c.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                gcc.c().g().a(cVar);
                return cVar;
            }
            return (t7c.c) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements i8c<n7c.f, n7c.f> {
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
        @Override // com.baidu.tieba.i8c
        public n7c.f call(n7c.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                gcc.c().a().a(fVar);
                return fVar;
            }
            return (n7c.f) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class f implements d8c<Throwable> {
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
        @Override // com.baidu.tieba.d8c
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                gcc.c().b().a(th);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class g implements j8c<p7c, p7c.a, p7c.a> {
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
        @Override // com.baidu.tieba.j8c
        public p7c.a call(p7c p7cVar, p7c.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, p7cVar, aVar)) == null) {
                gcc.c().d().e(p7cVar, aVar);
                return aVar;
            }
            return (p7c.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class h implements i8c<w7c, w7c> {
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
        @Override // com.baidu.tieba.i8c
        public w7c call(w7c w7cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, w7cVar)) == null) {
                gcc.c().d().d(w7cVar);
                return w7cVar;
            }
            return (w7c) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class i implements j8c<t7c, t7c.c, t7c.c> {
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
        @Override // com.baidu.tieba.j8c
        public t7c.c call(t7c t7cVar, t7c.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, t7cVar, cVar)) == null) {
                icc g = gcc.c().g();
                if (g == jcc.e()) {
                    return cVar;
                }
                o9c o9cVar = new o9c(cVar);
                g.d(t7cVar, o9cVar);
                return new l9c(o9cVar);
            }
            return (t7c.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class j implements i8c<w7c, w7c> {
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
        @Override // com.baidu.tieba.i8c
        public w7c call(w7c w7cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, w7cVar)) == null) {
                gcc.c().g().c(w7cVar);
                return w7cVar;
            }
            return (w7c) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class k implements j8c<n7c, n7c.f, n7c.f> {
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
        @Override // com.baidu.tieba.j8c
        public n7c.f call(n7c n7cVar, n7c.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, n7cVar, fVar)) == null) {
                gcc.c().a().c(n7cVar, fVar);
                return fVar;
            }
            return (n7c.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class l implements i8c<c8c, c8c> {
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
        @Override // com.baidu.tieba.i8c
        public c8c call(c8c c8cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c8cVar)) == null) {
                gcc.c().f().k(c8cVar);
                return c8cVar;
            }
            return (c8c) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class m implements i8c<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.i8c
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                gcc.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class n implements i8c<p7c.b, p7c.b> {
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
        @Override // com.baidu.tieba.i8c
        public p7c.b call(p7c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                gcc.c().d().b(bVar);
                return bVar;
            }
            return (p7c.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947701189, "Lcom/baidu/tieba/dcc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947701189, "Lcom/baidu/tieba/dcc;");
                return;
            }
        }
        b();
    }

    public static h8c<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return n;
        }
        return (h8c) invokeV.objValue;
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
            i8c<Throwable, Throwable> i8cVar = q;
            if (i8cVar != null) {
                return i8cVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static s7c f(s7c s7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, s7cVar)) == null) {
            i8c<s7c, s7c> i8cVar = h;
            if (i8cVar != null) {
                return i8cVar.call(s7cVar);
            }
            return s7cVar;
        }
        return (s7c) invokeL.objValue;
    }

    public static n7c.f g(n7c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            i8c<n7c.f, n7c.f> i8cVar = d;
            if (i8cVar != null) {
                return i8cVar.call(fVar);
            }
            return fVar;
        }
        return (n7c.f) invokeL.objValue;
    }

    public static <T> p7c.a<T> h(p7c.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            i8c<p7c.a, p7c.a> i8cVar = b;
            if (i8cVar != null) {
                return i8cVar.call(aVar);
            }
            return aVar;
        }
        return (p7c.a) invokeL.objValue;
    }

    public static <T> t7c.c<T> i(t7c.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            i8c<t7c.c, t7c.c> i8cVar = c;
            if (i8cVar != null) {
                return i8cVar.call(cVar);
            }
            return cVar;
        }
        return (t7c.c) invokeL.objValue;
    }

    public static s7c k(s7c s7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, s7cVar)) == null) {
            i8c<s7c, s7c> i8cVar = i;
            if (i8cVar != null) {
                return i8cVar.call(s7cVar);
            }
            return s7cVar;
        }
        return (s7c) invokeL.objValue;
    }

    public static s7c l(s7c s7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, s7cVar)) == null) {
            i8c<s7c, s7c> i8cVar = j;
            if (i8cVar != null) {
                return i8cVar.call(s7cVar);
            }
            return s7cVar;
        }
        return (s7c) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            i8c<Throwable, Throwable> i8cVar = o;
            if (i8cVar != null) {
                return i8cVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> p7c.b<R, T> n(p7c.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            i8c<p7c.b, p7c.b> i8cVar = r;
            if (i8cVar != null) {
                return i8cVar.call(bVar);
            }
            return bVar;
        }
        return (p7c.b) invokeL.objValue;
    }

    public static w7c o(w7c w7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, w7cVar)) == null) {
            i8c<w7c, w7c> i8cVar = l;
            if (i8cVar != null) {
                return i8cVar.call(w7cVar);
            }
            return w7cVar;
        }
        return (w7c) invokeL.objValue;
    }

    public static c8c q(c8c c8cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, c8cVar)) == null) {
            i8c<c8c, c8c> i8cVar = k;
            if (i8cVar != null) {
                return i8cVar.call(c8cVar);
            }
            return c8cVar;
        }
        return (c8c) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            i8c<Throwable, Throwable> i8cVar = p;
            if (i8cVar != null) {
                return i8cVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static w7c s(w7c w7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, w7cVar)) == null) {
            i8c<w7c, w7c> i8cVar = m;
            if (i8cVar != null) {
                return i8cVar.call(w7cVar);
            }
            return w7cVar;
        }
        return (w7c) invokeL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static <T> n7c.f e(n7c n7cVar, n7c.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, n7cVar, fVar)) == null) {
            j8c<n7c, n7c.f, n7c.f> j8cVar = g;
            if (j8cVar != null) {
                return j8cVar.call(n7cVar, fVar);
            }
            return fVar;
        }
        return (n7c.f) invokeLL.objValue;
    }

    public static <T> p7c.a<T> p(p7c<T> p7cVar, p7c.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, p7cVar, aVar)) == null) {
            j8c<p7c, p7c.a, p7c.a> j8cVar = e;
            if (j8cVar != null) {
                return j8cVar.call(p7cVar, aVar);
            }
            return aVar;
        }
        return (p7c.a) invokeLL.objValue;
    }

    public static <T> t7c.c<T> t(t7c<T> t7cVar, t7c.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, t7cVar, cVar)) == null) {
            j8c<t7c, t7c.c, t7c.c> j8cVar = f;
            if (j8cVar != null) {
                return j8cVar.call(t7cVar, cVar);
            }
            return cVar;
        }
        return (t7c.c) invokeLL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            d8c<Throwable> d8cVar = a;
            if (d8cVar != null) {
                try {
                    d8cVar.call(th);
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
