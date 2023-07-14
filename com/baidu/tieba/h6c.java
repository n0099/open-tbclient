package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.s1c;
import com.baidu.tieba.u1c;
import com.baidu.tieba.y1c;
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
public final class h6c {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i2c<Throwable> a;
    public static volatile m2c<u1c.a, u1c.a> b;
    public static volatile m2c<y1c.c, y1c.c> c;
    public static volatile m2c<s1c.f, s1c.f> d;
    public static volatile n2c<u1c, u1c.a, u1c.a> e;
    public static volatile n2c<y1c, y1c.c, y1c.c> f;
    public static volatile n2c<s1c, s1c.f, s1c.f> g;
    public static volatile m2c<x1c, x1c> h;
    public static volatile m2c<x1c, x1c> i;
    public static volatile m2c<x1c, x1c> j;
    public static volatile m2c<h2c, h2c> k;
    public static volatile m2c<b2c, b2c> l;
    public static volatile m2c<b2c, b2c> m;
    public static volatile l2c<? extends ScheduledExecutorService> n;
    public static volatile m2c<Throwable, Throwable> o;
    public static volatile m2c<Throwable, Throwable> p;
    public static volatile m2c<Throwable, Throwable> q;
    public static volatile m2c<u1c.b, u1c.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements m2c<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.m2c
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                k6c.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements m2c<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.m2c
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                k6c.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements m2c<u1c.a, u1c.a> {
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
        @Override // com.baidu.tieba.m2c
        public u1c.a call(u1c.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                k6c.c().d().a(aVar);
                return aVar;
            }
            return (u1c.a) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements m2c<y1c.c, y1c.c> {
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
        @Override // com.baidu.tieba.m2c
        public y1c.c call(y1c.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                k6c.c().g().a(cVar);
                return cVar;
            }
            return (y1c.c) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements m2c<s1c.f, s1c.f> {
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
        @Override // com.baidu.tieba.m2c
        public s1c.f call(s1c.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                k6c.c().a().a(fVar);
                return fVar;
            }
            return (s1c.f) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class f implements i2c<Throwable> {
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
        @Override // com.baidu.tieba.i2c
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                k6c.c().b().a(th);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class g implements n2c<u1c, u1c.a, u1c.a> {
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
        @Override // com.baidu.tieba.n2c
        public u1c.a call(u1c u1cVar, u1c.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, u1cVar, aVar)) == null) {
                k6c.c().d().e(u1cVar, aVar);
                return aVar;
            }
            return (u1c.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class h implements m2c<b2c, b2c> {
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
        @Override // com.baidu.tieba.m2c
        public b2c call(b2c b2cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, b2cVar)) == null) {
                k6c.c().d().d(b2cVar);
                return b2cVar;
            }
            return (b2c) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class i implements n2c<y1c, y1c.c, y1c.c> {
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
        @Override // com.baidu.tieba.n2c
        public y1c.c call(y1c y1cVar, y1c.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, y1cVar, cVar)) == null) {
                m6c g = k6c.c().g();
                if (g == n6c.e()) {
                    return cVar;
                }
                s3c s3cVar = new s3c(cVar);
                g.d(y1cVar, s3cVar);
                return new p3c(s3cVar);
            }
            return (y1c.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class j implements m2c<b2c, b2c> {
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
        @Override // com.baidu.tieba.m2c
        public b2c call(b2c b2cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, b2cVar)) == null) {
                k6c.c().g().c(b2cVar);
                return b2cVar;
            }
            return (b2c) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class k implements n2c<s1c, s1c.f, s1c.f> {
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
        @Override // com.baidu.tieba.n2c
        public s1c.f call(s1c s1cVar, s1c.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, s1cVar, fVar)) == null) {
                k6c.c().a().c(s1cVar, fVar);
                return fVar;
            }
            return (s1c.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class l implements m2c<h2c, h2c> {
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
        @Override // com.baidu.tieba.m2c
        public h2c call(h2c h2cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, h2cVar)) == null) {
                k6c.c().f().k(h2cVar);
                return h2cVar;
            }
            return (h2c) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class m implements m2c<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.m2c
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                k6c.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class n implements m2c<u1c.b, u1c.b> {
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
        @Override // com.baidu.tieba.m2c
        public u1c.b call(u1c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                k6c.c().d().b(bVar);
                return bVar;
            }
            return (u1c.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947777108, "Lcom/baidu/tieba/h6c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947777108, "Lcom/baidu/tieba/h6c;");
                return;
            }
        }
        b();
    }

    public static l2c<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return n;
        }
        return (l2c) invokeV.objValue;
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
            m2c<Throwable, Throwable> m2cVar = q;
            if (m2cVar != null) {
                return m2cVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static x1c f(x1c x1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, x1cVar)) == null) {
            m2c<x1c, x1c> m2cVar = h;
            if (m2cVar != null) {
                return m2cVar.call(x1cVar);
            }
            return x1cVar;
        }
        return (x1c) invokeL.objValue;
    }

    public static s1c.f g(s1c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            m2c<s1c.f, s1c.f> m2cVar = d;
            if (m2cVar != null) {
                return m2cVar.call(fVar);
            }
            return fVar;
        }
        return (s1c.f) invokeL.objValue;
    }

    public static <T> u1c.a<T> h(u1c.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            m2c<u1c.a, u1c.a> m2cVar = b;
            if (m2cVar != null) {
                return m2cVar.call(aVar);
            }
            return aVar;
        }
        return (u1c.a) invokeL.objValue;
    }

    public static <T> y1c.c<T> i(y1c.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            m2c<y1c.c, y1c.c> m2cVar = c;
            if (m2cVar != null) {
                return m2cVar.call(cVar);
            }
            return cVar;
        }
        return (y1c.c) invokeL.objValue;
    }

    public static x1c k(x1c x1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, x1cVar)) == null) {
            m2c<x1c, x1c> m2cVar = i;
            if (m2cVar != null) {
                return m2cVar.call(x1cVar);
            }
            return x1cVar;
        }
        return (x1c) invokeL.objValue;
    }

    public static x1c l(x1c x1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, x1cVar)) == null) {
            m2c<x1c, x1c> m2cVar = j;
            if (m2cVar != null) {
                return m2cVar.call(x1cVar);
            }
            return x1cVar;
        }
        return (x1c) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            m2c<Throwable, Throwable> m2cVar = o;
            if (m2cVar != null) {
                return m2cVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> u1c.b<R, T> n(u1c.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            m2c<u1c.b, u1c.b> m2cVar = r;
            if (m2cVar != null) {
                return m2cVar.call(bVar);
            }
            return bVar;
        }
        return (u1c.b) invokeL.objValue;
    }

    public static b2c o(b2c b2cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, b2cVar)) == null) {
            m2c<b2c, b2c> m2cVar = l;
            if (m2cVar != null) {
                return m2cVar.call(b2cVar);
            }
            return b2cVar;
        }
        return (b2c) invokeL.objValue;
    }

    public static h2c q(h2c h2cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, h2cVar)) == null) {
            m2c<h2c, h2c> m2cVar = k;
            if (m2cVar != null) {
                return m2cVar.call(h2cVar);
            }
            return h2cVar;
        }
        return (h2c) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            m2c<Throwable, Throwable> m2cVar = p;
            if (m2cVar != null) {
                return m2cVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static b2c s(b2c b2cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, b2cVar)) == null) {
            m2c<b2c, b2c> m2cVar = m;
            if (m2cVar != null) {
                return m2cVar.call(b2cVar);
            }
            return b2cVar;
        }
        return (b2c) invokeL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static <T> s1c.f e(s1c s1cVar, s1c.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, s1cVar, fVar)) == null) {
            n2c<s1c, s1c.f, s1c.f> n2cVar = g;
            if (n2cVar != null) {
                return n2cVar.call(s1cVar, fVar);
            }
            return fVar;
        }
        return (s1c.f) invokeLL.objValue;
    }

    public static <T> u1c.a<T> p(u1c<T> u1cVar, u1c.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, u1cVar, aVar)) == null) {
            n2c<u1c, u1c.a, u1c.a> n2cVar = e;
            if (n2cVar != null) {
                return n2cVar.call(u1cVar, aVar);
            }
            return aVar;
        }
        return (u1c.a) invokeLL.objValue;
    }

    public static <T> y1c.c<T> t(y1c<T> y1cVar, y1c.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, y1cVar, cVar)) == null) {
            n2c<y1c, y1c.c, y1c.c> n2cVar = f;
            if (n2cVar != null) {
                return n2cVar.call(y1cVar, cVar);
            }
            return cVar;
        }
        return (y1c.c) invokeLL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            i2c<Throwable> i2cVar = a;
            if (i2cVar != null) {
                try {
                    i2cVar.call(th);
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
