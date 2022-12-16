package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b3a;
import com.baidu.tieba.f3a;
import com.baidu.tieba.z2a;
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
public final class i7a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile p3a<Throwable> a;
    public static volatile t3a<b3a.a, b3a.a> b;
    public static volatile t3a<f3a.c, f3a.c> c;
    public static volatile t3a<z2a.f, z2a.f> d;
    public static volatile u3a<b3a, b3a.a, b3a.a> e;
    public static volatile u3a<f3a, f3a.c, f3a.c> f;
    public static volatile u3a<z2a, z2a.f, z2a.f> g;
    public static volatile t3a<e3a, e3a> h;
    public static volatile t3a<e3a, e3a> i;
    public static volatile t3a<e3a, e3a> j;
    public static volatile t3a<o3a, o3a> k;
    public static volatile t3a<i3a, i3a> l;
    public static volatile t3a<i3a, i3a> m;
    public static volatile s3a<? extends ScheduledExecutorService> n;
    public static volatile t3a<Throwable, Throwable> o;
    public static volatile t3a<Throwable, Throwable> p;
    public static volatile t3a<Throwable, Throwable> q;
    public static volatile t3a<b3a.b, b3a.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements t3a<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.t3a
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                l7a.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements t3a<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.t3a
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                l7a.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements t3a<b3a.a, b3a.a> {
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
        @Override // com.baidu.tieba.t3a
        public b3a.a call(b3a.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                l7a.c().d().a(aVar);
                return aVar;
            }
            return (b3a.a) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements t3a<f3a.c, f3a.c> {
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
        @Override // com.baidu.tieba.t3a
        public f3a.c call(f3a.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                l7a.c().g().a(cVar);
                return cVar;
            }
            return (f3a.c) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements t3a<z2a.f, z2a.f> {
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
        @Override // com.baidu.tieba.t3a
        public z2a.f call(z2a.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                l7a.c().a().a(fVar);
                return fVar;
            }
            return (z2a.f) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class f implements p3a<Throwable> {
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
        @Override // com.baidu.tieba.p3a
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                l7a.c().b().a(th);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class g implements u3a<b3a, b3a.a, b3a.a> {
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
        @Override // com.baidu.tieba.u3a
        public b3a.a call(b3a b3aVar, b3a.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, b3aVar, aVar)) == null) {
                l7a.c().d().e(b3aVar, aVar);
                return aVar;
            }
            return (b3a.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class h implements t3a<i3a, i3a> {
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
        @Override // com.baidu.tieba.t3a
        public i3a call(i3a i3aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, i3aVar)) == null) {
                l7a.c().d().d(i3aVar);
                return i3aVar;
            }
            return (i3a) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class i implements u3a<f3a, f3a.c, f3a.c> {
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
        @Override // com.baidu.tieba.u3a
        public f3a.c call(f3a f3aVar, f3a.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, f3aVar, cVar)) == null) {
                n7a g = l7a.c().g();
                if (g == o7a.e()) {
                    return cVar;
                }
                t4a t4aVar = new t4a(cVar);
                g.d(f3aVar, t4aVar);
                return new q4a(t4aVar);
            }
            return (f3a.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class j implements t3a<i3a, i3a> {
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
        @Override // com.baidu.tieba.t3a
        public i3a call(i3a i3aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, i3aVar)) == null) {
                l7a.c().g().c(i3aVar);
                return i3aVar;
            }
            return (i3a) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class k implements u3a<z2a, z2a.f, z2a.f> {
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
        @Override // com.baidu.tieba.u3a
        public z2a.f call(z2a z2aVar, z2a.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, z2aVar, fVar)) == null) {
                l7a.c().a().c(z2aVar, fVar);
                return fVar;
            }
            return (z2a.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class l implements t3a<o3a, o3a> {
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
        @Override // com.baidu.tieba.t3a
        public o3a call(o3a o3aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, o3aVar)) == null) {
                l7a.c().f().k(o3aVar);
                return o3aVar;
            }
            return (o3a) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class m implements t3a<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.t3a
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                l7a.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class n implements t3a<b3a.b, b3a.b> {
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
        @Override // com.baidu.tieba.t3a
        public b3a.b call(b3a.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                l7a.c().d().b(bVar);
                return bVar;
            }
            return (b3a.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947807798, "Lcom/baidu/tieba/i7a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947807798, "Lcom/baidu/tieba/i7a;");
                return;
            }
        }
        b();
    }

    public static s3a<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return n;
        }
        return (s3a) invokeV.objValue;
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
            t3a<Throwable, Throwable> t3aVar = q;
            if (t3aVar != null) {
                return t3aVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static e3a f(e3a e3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, e3aVar)) == null) {
            t3a<e3a, e3a> t3aVar = h;
            if (t3aVar != null) {
                return t3aVar.call(e3aVar);
            }
            return e3aVar;
        }
        return (e3a) invokeL.objValue;
    }

    public static z2a.f g(z2a.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            t3a<z2a.f, z2a.f> t3aVar = d;
            if (t3aVar != null) {
                return t3aVar.call(fVar);
            }
            return fVar;
        }
        return (z2a.f) invokeL.objValue;
    }

    public static <T> b3a.a<T> h(b3a.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            t3a<b3a.a, b3a.a> t3aVar = b;
            if (t3aVar != null) {
                return t3aVar.call(aVar);
            }
            return aVar;
        }
        return (b3a.a) invokeL.objValue;
    }

    public static <T> f3a.c<T> i(f3a.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            t3a<f3a.c, f3a.c> t3aVar = c;
            if (t3aVar != null) {
                return t3aVar.call(cVar);
            }
            return cVar;
        }
        return (f3a.c) invokeL.objValue;
    }

    public static e3a k(e3a e3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, e3aVar)) == null) {
            t3a<e3a, e3a> t3aVar = i;
            if (t3aVar != null) {
                return t3aVar.call(e3aVar);
            }
            return e3aVar;
        }
        return (e3a) invokeL.objValue;
    }

    public static e3a l(e3a e3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, e3aVar)) == null) {
            t3a<e3a, e3a> t3aVar = j;
            if (t3aVar != null) {
                return t3aVar.call(e3aVar);
            }
            return e3aVar;
        }
        return (e3a) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            t3a<Throwable, Throwable> t3aVar = o;
            if (t3aVar != null) {
                return t3aVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> b3a.b<R, T> n(b3a.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            t3a<b3a.b, b3a.b> t3aVar = r;
            if (t3aVar != null) {
                return t3aVar.call(bVar);
            }
            return bVar;
        }
        return (b3a.b) invokeL.objValue;
    }

    public static i3a o(i3a i3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, i3aVar)) == null) {
            t3a<i3a, i3a> t3aVar = l;
            if (t3aVar != null) {
                return t3aVar.call(i3aVar);
            }
            return i3aVar;
        }
        return (i3a) invokeL.objValue;
    }

    public static o3a q(o3a o3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, o3aVar)) == null) {
            t3a<o3a, o3a> t3aVar = k;
            if (t3aVar != null) {
                return t3aVar.call(o3aVar);
            }
            return o3aVar;
        }
        return (o3a) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            t3a<Throwable, Throwable> t3aVar = p;
            if (t3aVar != null) {
                return t3aVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static i3a s(i3a i3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, i3aVar)) == null) {
            t3a<i3a, i3a> t3aVar = m;
            if (t3aVar != null) {
                return t3aVar.call(i3aVar);
            }
            return i3aVar;
        }
        return (i3a) invokeL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static <T> z2a.f e(z2a z2aVar, z2a.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, z2aVar, fVar)) == null) {
            u3a<z2a, z2a.f, z2a.f> u3aVar = g;
            if (u3aVar != null) {
                return u3aVar.call(z2aVar, fVar);
            }
            return fVar;
        }
        return (z2a.f) invokeLL.objValue;
    }

    public static <T> b3a.a<T> p(b3a<T> b3aVar, b3a.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, b3aVar, aVar)) == null) {
            u3a<b3a, b3a.a, b3a.a> u3aVar = e;
            if (u3aVar != null) {
                return u3aVar.call(b3aVar, aVar);
            }
            return aVar;
        }
        return (b3a.a) invokeLL.objValue;
    }

    public static <T> f3a.c<T> t(f3a<T> f3aVar, f3a.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, f3aVar, cVar)) == null) {
            u3a<f3a, f3a.c, f3a.c> u3aVar = f;
            if (u3aVar != null) {
                return u3aVar.call(f3aVar, cVar);
            }
            return cVar;
        }
        return (f3a.c) invokeLL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            p3a<Throwable> p3aVar = a;
            if (p3aVar != null) {
                try {
                    p3aVar.call(th);
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
