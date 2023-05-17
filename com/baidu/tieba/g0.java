package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.k7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class g0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m0<c0> a;
    public k7<f0, o6<c0>> b;
    public k7<f0, m0<c0>> c;
    public u7<c> d;
    public k7<f0, r6> e;
    public b f;
    public boolean g;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b extends n7<r6> {
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
        @Override // com.baidu.tieba.n7
        /* renamed from: g */
        public r6 d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new r6();
            }
            return (r6) invokeV.objValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public d0 a;
        public int b;

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

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public g0(m0<c0> m0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new k7<>();
        this.c = new k7<>();
        this.d = new u7<>(true, 16);
        this.e = new k7<>();
        this.f = new b(null);
        this.g = false;
        this.a = m0Var;
    }

    public final m0<c0> d(f0 f0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, f0Var)) == null) {
            m0<c0> c2 = this.c.c(f0Var);
            if (c2 == null) {
                o6<c0> o6Var = new o6<>(false, 16);
                m0<c0> m0Var = new m0<>(o6Var);
                this.b.i(f0Var, o6Var);
                this.c.i(f0Var, m0Var);
                this.e.i(f0Var, new r6());
                Iterator<c0> it = this.a.iterator();
                while (it.hasNext()) {
                    f(it.next());
                }
                return m0Var;
            }
            return c2;
        }
        return (m0) invokeL.objValue;
    }

    public void e(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, d0Var) == null) {
            int i = 0;
            while (true) {
                u7<c> u7Var = this.d;
                if (i < u7Var.b) {
                    if (u7Var.get(i).a == d0Var) {
                        k7.e<r6> n = this.e.n();
                        n.c();
                        while (n.hasNext()) {
                            r6 next = n.next();
                            int h = next.h();
                            int i2 = i;
                            while (i2 < h) {
                                int i3 = i2 + 1;
                                if (next.e(i3)) {
                                    next.k(i2);
                                } else {
                                    next.c(i2);
                                }
                                i2 = i3;
                            }
                        }
                        this.d.h(i);
                        i--;
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public void a(f0 f0Var, int i, d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, f0Var, i, d0Var) == null) {
            d(f0Var);
            int i2 = 0;
            while (true) {
                u7<c> u7Var = this.d;
                if (i2 >= u7Var.b || u7Var.get(i2).b > i) {
                    break;
                }
                i2++;
            }
            k7.e<r6> n = this.e.n();
            n.c();
            while (n.hasNext()) {
                r6 next = n.next();
                for (int h = next.h(); h > i2; h--) {
                    if (next.e(h - 1)) {
                        next.k(h);
                    } else {
                        next.c(h);
                    }
                }
                next.c(i2);
            }
            this.e.c(f0Var).k(i2);
            c cVar = new c(null);
            cVar.a = d0Var;
            cVar.b = i;
            this.d.insert(i2, cVar);
        }
    }

    public m0<c0> b(f0 f0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f0Var)) == null) {
            return d(f0Var);
        }
        return (m0) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public void f(c0 c0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, c0Var) == null) {
            r6 e = this.f.e();
            r6 e2 = this.f.e();
            k7.c<f0> f = this.e.f();
            f.c();
            while (true) {
                boolean z = false;
                if (!f.hasNext()) {
                    break;
                }
                f0 next = f.next();
                int g = next.g();
                r6 f2 = c0Var.f();
                boolean e3 = f2.e(g);
                if (next.h(c0Var) && !c0Var.d) {
                    z = true;
                }
                if (e3 != z) {
                    r6 c2 = this.e.c(next);
                    o6<c0> c3 = this.b.c(next);
                    if (z) {
                        e.j(c2);
                        c3.a(c0Var);
                        f2.k(g);
                    } else {
                        e2.j(c2);
                        c3.i(c0Var, true);
                        f2.c(g);
                    }
                }
            }
            this.g = true;
            c[] o = this.d.o();
            try {
                for (int i = e2.i(0); i >= 0; i = e2.i(i + 1)) {
                    o[i].a.a(c0Var);
                }
                for (int i2 = e.i(0); i2 >= 0; i2 = e.i(i2 + 1)) {
                    o[i2].a.b(c0Var);
                }
            } finally {
                e.b();
                e2.b();
                this.f.c(e);
                this.f.c(e2);
                this.d.p();
                this.g = false;
            }
        }
    }
}
