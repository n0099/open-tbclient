package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.rca;
import com.baidu.tieba.tca;
import com.baidu.tieba.xca;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes3.dex */
public final class aha {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hda<Throwable> a;
    public static volatile lda<tca.a, tca.a> b;
    public static volatile lda<xca.c, xca.c> c;
    public static volatile lda<rca.f, rca.f> d;
    public static volatile mda<tca, tca.a, tca.a> e;
    public static volatile mda<xca, xca.c, xca.c> f;
    public static volatile mda<rca, rca.f, rca.f> g;
    public static volatile lda<wca, wca> h;
    public static volatile lda<wca, wca> i;
    public static volatile lda<wca, wca> j;
    public static volatile lda<gda, gda> k;
    public static volatile lda<ada, ada> l;
    public static volatile lda<ada, ada> m;
    public static volatile kda<? extends ScheduledExecutorService> n;
    public static volatile lda<Throwable, Throwable> o;
    public static volatile lda<Throwable, Throwable> p;
    public static volatile lda<Throwable, Throwable> q;
    public static volatile lda<tca.b, tca.b> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements lda<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.lda
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                dha.c().g().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements lda<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.lda
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                dha.c().a().b(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements lda<tca.a, tca.a> {
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
        @Override // com.baidu.tieba.lda
        public tca.a call(tca.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                dha.c().d().a(aVar);
                return aVar;
            }
            return (tca.a) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements lda<xca.c, xca.c> {
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
        @Override // com.baidu.tieba.lda
        public xca.c call(xca.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                dha.c().g().a(cVar);
                return cVar;
            }
            return (xca.c) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements lda<rca.f, rca.f> {
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
        @Override // com.baidu.tieba.lda
        public rca.f call(rca.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                dha.c().a().a(fVar);
                return fVar;
            }
            return (rca.f) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements hda<Throwable> {
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
        @Override // com.baidu.tieba.hda
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                dha.c().b().a(th);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class g implements mda<tca, tca.a, tca.a> {
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
        @Override // com.baidu.tieba.mda
        public tca.a call(tca tcaVar, tca.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tcaVar, aVar)) == null) {
                dha.c().d().e(tcaVar, aVar);
                return aVar;
            }
            return (tca.a) invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class h implements lda<ada, ada> {
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
        @Override // com.baidu.tieba.lda
        public ada call(ada adaVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, adaVar)) == null) {
                dha.c().d().d(adaVar);
                return adaVar;
            }
            return (ada) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class i implements mda<xca, xca.c, xca.c> {
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
        @Override // com.baidu.tieba.mda
        public xca.c call(xca xcaVar, xca.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, xcaVar, cVar)) == null) {
                fha g = dha.c().g();
                if (g == gha.e()) {
                    return cVar;
                }
                lea leaVar = new lea(cVar);
                g.d(xcaVar, leaVar);
                return new iea(leaVar);
            }
            return (xca.c) invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class j implements lda<ada, ada> {
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
        @Override // com.baidu.tieba.lda
        public ada call(ada adaVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, adaVar)) == null) {
                dha.c().g().c(adaVar);
                return adaVar;
            }
            return (ada) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class k implements mda<rca, rca.f, rca.f> {
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
        @Override // com.baidu.tieba.mda
        public rca.f call(rca rcaVar, rca.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, rcaVar, fVar)) == null) {
                dha.c().a().c(rcaVar, fVar);
                return fVar;
            }
            return (rca.f) invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class l implements lda<gda, gda> {
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
        @Override // com.baidu.tieba.lda
        public gda call(gda gdaVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gdaVar)) == null) {
                dha.c().f().k(gdaVar);
                return gdaVar;
            }
            return (gda) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class m implements lda<Throwable, Throwable> {
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
        @Override // com.baidu.tieba.lda
        public Throwable call(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
                dha.c().d().c(th);
                return th;
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class n implements lda<tca.b, tca.b> {
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
        @Override // com.baidu.tieba.lda
        public tca.b call(tca.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                dha.c().d().b(bVar);
                return bVar;
            }
            return (tca.b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947616559, "Lcom/baidu/tieba/aha;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947616559, "Lcom/baidu/tieba/aha;");
                return;
            }
        }
        b();
    }

    public static kda<? extends ScheduledExecutorService> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return n;
        }
        return (kda) invokeV.objValue;
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
            lda<Throwable, Throwable> ldaVar = q;
            if (ldaVar != null) {
                return ldaVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static wca f(wca wcaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, wcaVar)) == null) {
            lda<wca, wca> ldaVar = h;
            if (ldaVar != null) {
                return ldaVar.call(wcaVar);
            }
            return wcaVar;
        }
        return (wca) invokeL.objValue;
    }

    public static rca.f g(rca.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fVar)) == null) {
            lda<rca.f, rca.f> ldaVar = d;
            if (ldaVar != null) {
                return ldaVar.call(fVar);
            }
            return fVar;
        }
        return (rca.f) invokeL.objValue;
    }

    public static <T> tca.a<T> h(tca.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            lda<tca.a, tca.a> ldaVar = b;
            if (ldaVar != null) {
                return ldaVar.call(aVar);
            }
            return aVar;
        }
        return (tca.a) invokeL.objValue;
    }

    public static <T> xca.c<T> i(xca.c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            lda<xca.c, xca.c> ldaVar = c;
            if (ldaVar != null) {
                return ldaVar.call(cVar);
            }
            return cVar;
        }
        return (xca.c) invokeL.objValue;
    }

    public static wca k(wca wcaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, wcaVar)) == null) {
            lda<wca, wca> ldaVar = i;
            if (ldaVar != null) {
                return ldaVar.call(wcaVar);
            }
            return wcaVar;
        }
        return (wca) invokeL.objValue;
    }

    public static wca l(wca wcaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, wcaVar)) == null) {
            lda<wca, wca> ldaVar = j;
            if (ldaVar != null) {
                return ldaVar.call(wcaVar);
            }
            return wcaVar;
        }
        return (wca) invokeL.objValue;
    }

    public static Throwable m(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            lda<Throwable, Throwable> ldaVar = o;
            if (ldaVar != null) {
                return ldaVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T, R> tca.b<R, T> n(tca.b<R, T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bVar)) == null) {
            lda<tca.b, tca.b> ldaVar = r;
            if (ldaVar != null) {
                return ldaVar.call(bVar);
            }
            return bVar;
        }
        return (tca.b) invokeL.objValue;
    }

    public static ada o(ada adaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, adaVar)) == null) {
            lda<ada, ada> ldaVar = l;
            if (ldaVar != null) {
                return ldaVar.call(adaVar);
            }
            return adaVar;
        }
        return (ada) invokeL.objValue;
    }

    public static gda q(gda gdaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, gdaVar)) == null) {
            lda<gda, gda> ldaVar = k;
            if (ldaVar != null) {
                return ldaVar.call(gdaVar);
            }
            return gdaVar;
        }
        return (gda) invokeL.objValue;
    }

    public static Throwable r(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, th)) == null) {
            lda<Throwable, Throwable> ldaVar = p;
            if (ldaVar != null) {
                return ldaVar.call(th);
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static ada s(ada adaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, adaVar)) == null) {
            lda<ada, ada> ldaVar = m;
            if (ldaVar != null) {
                return ldaVar.call(adaVar);
            }
            return adaVar;
        }
        return (ada) invokeL.objValue;
    }

    public static void u(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static <T> rca.f e(rca rcaVar, rca.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, rcaVar, fVar)) == null) {
            mda<rca, rca.f, rca.f> mdaVar = g;
            if (mdaVar != null) {
                return mdaVar.call(rcaVar, fVar);
            }
            return fVar;
        }
        return (rca.f) invokeLL.objValue;
    }

    public static <T> tca.a<T> p(tca<T> tcaVar, tca.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, tcaVar, aVar)) == null) {
            mda<tca, tca.a, tca.a> mdaVar = e;
            if (mdaVar != null) {
                return mdaVar.call(tcaVar, aVar);
            }
            return aVar;
        }
        return (tca.a) invokeLL.objValue;
    }

    public static <T> xca.c<T> t(xca<T> xcaVar, xca.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, xcaVar, cVar)) == null) {
            mda<xca, xca.c, xca.c> mdaVar = f;
            if (mdaVar != null) {
                return mdaVar.call(xcaVar, cVar);
            }
            return cVar;
        }
        return (xca.c) invokeLL.objValue;
    }

    public static void j(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            hda<Throwable> hdaVar = a;
            if (hdaVar != null) {
                try {
                    hdaVar.call(th);
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
