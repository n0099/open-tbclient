package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.av9;
import com.baidu.tieba.ev9;
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
public final class hz9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ov9<Throwable> a;
    public static volatile sv9<av9.a, av9.a> b;
    public static volatile sv9<ev9.c, ev9.c> c;
    public static volatile sv9<yu9.f, yu9.f> d;
    public static volatile tv9<av9, av9.a, av9.a> e;
    public static volatile tv9<ev9, ev9.c, ev9.c> f;
    public static volatile tv9<yu9, yu9.f, yu9.f> g;
    public static volatile sv9<dv9, dv9> h;
    public static volatile sv9<dv9, dv9> i;
    public static volatile sv9<dv9, dv9> j;
    public static volatile sv9<nv9, nv9> k;
    public static volatile sv9<hv9, hv9> l;
    public static volatile sv9<hv9, hv9> m;
    public static volatile rv9<? extends ScheduledExecutorService> n;
    public static volatile sv9<Throwable, Throwable> o;
    public static volatile sv9<Throwable, Throwable> p;
    public static volatile sv9<Throwable, Throwable> q;
    public static volatile sv9<av9.b, av9.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements sv9<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.sv9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                kz9.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements sv9<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.sv9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                kz9.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements sv9<av9.a, av9.a> {
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
        @Override // com.baidu.tieba.sv9
        public av9.a call(av9.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                kz9.c().d().a(aVar);
                return aVar;
            }
            return (av9.a) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements sv9<ev9.c, ev9.c> {
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
        @Override // com.baidu.tieba.sv9
        public ev9.c call(ev9.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                kz9.c().g().a(cVar);
                return cVar;
            }
            return (ev9.c) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements sv9<yu9.f, yu9.f> {
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
        @Override // com.baidu.tieba.sv9
        public yu9.f call(yu9.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                kz9.c().a().a(fVar);
                return fVar;
            }
            return (yu9.f) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class f implements ov9<Throwable> {
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
        @Override // com.baidu.tieba.ov9
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                kz9.c().b().a(th);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class g implements tv9<av9, av9.a, av9.a> {
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
        @Override // com.baidu.tieba.tv9
        public av9.a call(av9 av9Var, av9.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, av9Var, aVar)) == null) {
                kz9.c().d().e(av9Var, aVar);
                return aVar;
            }
            return (av9.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class h implements sv9<hv9, hv9> {
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
        @Override // com.baidu.tieba.sv9
        public hv9 call(hv9 hv9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hv9Var)) == null) {
                kz9.c().d().d(hv9Var);
                return hv9Var;
            }
            return (hv9) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class i implements tv9<ev9, ev9.c, ev9.c> {
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
        @Override // com.baidu.tieba.tv9
        public ev9.c call(ev9 ev9Var, ev9.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ev9Var, cVar)) == null) {
                mz9 g = kz9.c().g();
                if (g == nz9.e()) {
                    return cVar;
                }
                sw9 sw9Var = new sw9(cVar);
                g.d(ev9Var, sw9Var);
                return new pw9(sw9Var);
            }
            return (ev9.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class j implements sv9<hv9, hv9> {
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
        @Override // com.baidu.tieba.sv9
        public hv9 call(hv9 hv9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hv9Var)) == null) {
                kz9.c().g().c(hv9Var);
                return hv9Var;
            }
            return (hv9) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class k implements tv9<yu9, yu9.f, yu9.f> {
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
        @Override // com.baidu.tieba.tv9
        public yu9.f call(yu9 yu9Var, yu9.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, yu9Var, fVar)) == null) {
                kz9.c().a().c(yu9Var, fVar);
                return fVar;
            }
            return (yu9.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class l implements sv9<nv9, nv9> {
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
        @Override // com.baidu.tieba.sv9
        public nv9 call(nv9 nv9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, nv9Var)) == null) {
                kz9.c().f().k(nv9Var);
                return nv9Var;
            }
            return (nv9) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class m implements sv9<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.sv9
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                kz9.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class n implements sv9<av9.b, av9.b> {
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
        @Override // com.baidu.tieba.sv9
        public av9.b call(av9.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                kz9.c().d().b(bVar);
                return bVar;
            }
            return (av9.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947841154, "Lcom/baidu/tieba/hz9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947841154, "Lcom/baidu/tieba/hz9;");
                return;
            }
        }
        b();
    }

    public static rv9<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? n : (rv9) invokeV.objValue;
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
            sv9<Throwable, Throwable> sv9Var = q;
            return sv9Var != null ? sv9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T> yu9.f e(yu9 yu9Var, yu9.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, yu9Var, fVar)) == null) {
            tv9<yu9, yu9.f, yu9.f> tv9Var = g;
            return tv9Var != null ? tv9Var.call(yu9Var, fVar) : fVar;
        }
        return (yu9.f) invokeLL.objValue;
    }

    public static dv9 f(dv9 dv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, dv9Var)) == null) {
            sv9<dv9, dv9> sv9Var = h;
            return sv9Var != null ? sv9Var.call(dv9Var) : dv9Var;
        }
        return (dv9) invokeL.objValue;
    }

    public static yu9.f g(yu9.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            sv9<yu9.f, yu9.f> sv9Var = d;
            return sv9Var != null ? sv9Var.call(fVar) : fVar;
        }
        return (yu9.f) invokeL.objValue;
    }

    public static <T> av9.a<T> h(av9.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            sv9<av9.a, av9.a> sv9Var = b;
            return sv9Var != null ? sv9Var.call(aVar) : aVar;
        }
        return (av9.a) invokeL.objValue;
    }

    public static <T> ev9.c<T> i(ev9.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            sv9<ev9.c, ev9.c> sv9Var = c;
            return sv9Var != null ? sv9Var.call(cVar) : cVar;
        }
        return (ev9.c) invokeL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            ov9<Throwable> ov9Var = a;
            if (ov9Var != null) {
                try {
                    ov9Var.call(th);
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

    public static dv9 k(dv9 dv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, dv9Var)) == null) {
            sv9<dv9, dv9> sv9Var = i;
            return sv9Var != null ? sv9Var.call(dv9Var) : dv9Var;
        }
        return (dv9) invokeL.objValue;
    }

    public static dv9 l(dv9 dv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, dv9Var)) == null) {
            sv9<dv9, dv9> sv9Var = j;
            return sv9Var != null ? sv9Var.call(dv9Var) : dv9Var;
        }
        return (dv9) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            sv9<Throwable, Throwable> sv9Var = o;
            return sv9Var != null ? sv9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> av9.b<R, T> n(av9.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            sv9<av9.b, av9.b> sv9Var = r;
            return sv9Var != null ? sv9Var.call(bVar) : bVar;
        }
        return (av9.b) invokeL.objValue;
    }

    public static hv9 o(hv9 hv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, hv9Var)) == null) {
            sv9<hv9, hv9> sv9Var = l;
            return sv9Var != null ? sv9Var.call(hv9Var) : hv9Var;
        }
        return (hv9) invokeL.objValue;
    }

    public static <T> av9.a<T> p(av9<T> av9Var, av9.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, av9Var, aVar)) == null) {
            tv9<av9, av9.a, av9.a> tv9Var = e;
            return tv9Var != null ? tv9Var.call(av9Var, aVar) : aVar;
        }
        return (av9.a) invokeLL.objValue;
    }

    public static nv9 q(nv9 nv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, nv9Var)) == null) {
            sv9<nv9, nv9> sv9Var = k;
            return sv9Var != null ? sv9Var.call(nv9Var) : nv9Var;
        }
        return (nv9) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            sv9<Throwable, Throwable> sv9Var = p;
            return sv9Var != null ? sv9Var.call(th) : th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static hv9 s(hv9 hv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, hv9Var)) == null) {
            sv9<hv9, hv9> sv9Var = m;
            return sv9Var != null ? sv9Var.call(hv9Var) : hv9Var;
        }
        return (hv9) invokeL.objValue;
    }

    public static <T> ev9.c<T> t(ev9<T> ev9Var, ev9.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, ev9Var, cVar)) == null) {
            tv9<ev9, ev9.c, ev9.c> tv9Var = f;
            return tv9Var != null ? tv9Var.call(ev9Var, cVar) : cVar;
        }
        return (ev9.c) invokeLL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }
}
