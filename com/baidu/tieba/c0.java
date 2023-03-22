package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.g7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class c0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i0<y> a;
    public g7<b0, k6<y>> b;
    public g7<b0, i0<y>> c;
    public q7<c> d;
    public g7<b0, n6> e;
    public b f;
    public boolean g;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class b extends j7<n6> {
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
        @Override // com.baidu.tieba.j7
        /* renamed from: g */
        public n6 d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new n6();
            }
            return (n6) invokeV.objValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public z a;
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

    public c0(i0<y> i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new g7<>();
        this.c = new g7<>();
        this.d = new q7<>(true, 16);
        this.e = new g7<>();
        this.f = new b(null);
        this.g = false;
        this.a = i0Var;
    }

    public final i0<y> d(b0 b0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, b0Var)) == null) {
            i0<y> c2 = this.c.c(b0Var);
            if (c2 == null) {
                k6<y> k6Var = new k6<>(false, 16);
                i0<y> i0Var = new i0<>(k6Var);
                this.b.i(b0Var, k6Var);
                this.c.i(b0Var, i0Var);
                this.e.i(b0Var, new n6());
                Iterator<y> it = this.a.iterator();
                while (it.hasNext()) {
                    f(it.next());
                }
                return i0Var;
            }
            return c2;
        }
        return (i0) invokeL.objValue;
    }

    public void e(z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, zVar) == null) {
            int i = 0;
            while (true) {
                q7<c> q7Var = this.d;
                if (i < q7Var.b) {
                    if (q7Var.get(i).a == zVar) {
                        g7.e<n6> n = this.e.n();
                        n.c();
                        while (n.hasNext()) {
                            n6 next = n.next();
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

    public void a(b0 b0Var, int i, z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, b0Var, i, zVar) == null) {
            d(b0Var);
            int i2 = 0;
            while (true) {
                q7<c> q7Var = this.d;
                if (i2 >= q7Var.b || q7Var.get(i2).b > i) {
                    break;
                }
                i2++;
            }
            g7.e<n6> n = this.e.n();
            n.c();
            while (n.hasNext()) {
                n6 next = n.next();
                for (int h = next.h(); h > i2; h--) {
                    if (next.e(h - 1)) {
                        next.k(h);
                    } else {
                        next.c(h);
                    }
                }
                next.c(i2);
            }
            this.e.c(b0Var).k(i2);
            c cVar = new c(null);
            cVar.a = zVar;
            cVar.b = i;
            this.d.insert(i2, cVar);
        }
    }

    public i0<y> b(b0 b0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b0Var)) == null) {
            return d(b0Var);
        }
        return (i0) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public void f(y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, yVar) == null) {
            n6 e = this.f.e();
            n6 e2 = this.f.e();
            g7.c<b0> f = this.e.f();
            f.c();
            while (true) {
                boolean z = false;
                if (!f.hasNext()) {
                    break;
                }
                b0 next = f.next();
                int g = next.g();
                n6 f2 = yVar.f();
                boolean e3 = f2.e(g);
                if (next.h(yVar) && !yVar.d) {
                    z = true;
                }
                if (e3 != z) {
                    n6 c2 = this.e.c(next);
                    k6<y> c3 = this.b.c(next);
                    if (z) {
                        e.j(c2);
                        c3.a(yVar);
                        f2.k(g);
                    } else {
                        e2.j(c2);
                        c3.i(yVar, true);
                        f2.c(g);
                    }
                }
            }
            this.g = true;
            c[] o = this.d.o();
            try {
                for (int i = e2.i(0); i >= 0; i = e2.i(i + 1)) {
                    o[i].a.a(yVar);
                }
                for (int i2 = e.i(0); i2 >= 0; i2 = e.i(i2 + 1)) {
                    o[i2].a.b(yVar);
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
