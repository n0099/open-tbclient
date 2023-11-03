package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.q3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class c1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i1<y0> a;
    public q3<b1, h3<y0>> b;
    public q3<b1, i1<y0>> c;
    public w3<c> d;
    public q3<b1, i3> e;
    public b f;
    public boolean g;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b extends s3<i3> {
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
        @Override // com.baidu.tieba.s3
        /* renamed from: g */
        public i3 d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new i3();
            }
            return (i3) invokeV.objValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public z0 a;
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

    public c1(i1<y0> i1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new q3<>();
        this.c = new q3<>();
        this.d = new w3<>(true, 16);
        this.e = new q3<>();
        this.f = new b(null);
        this.g = false;
        this.a = i1Var;
    }

    public final i1<y0> d(b1 b1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, b1Var)) == null) {
            i1<y0> b2 = this.c.b(b1Var);
            if (b2 == null) {
                h3<y0> h3Var = new h3<>(false, 16);
                i1<y0> i1Var = new i1<>(h3Var);
                this.b.h(b1Var, h3Var);
                this.c.h(b1Var, i1Var);
                this.e.h(b1Var, new i3());
                Iterator<y0> it = this.a.iterator();
                while (it.hasNext()) {
                    f(it.next());
                }
                return i1Var;
            }
            return b2;
        }
        return (i1) invokeL.objValue;
    }

    public void e(z0 z0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, z0Var) == null) {
            int i = 0;
            while (true) {
                w3<c> w3Var = this.d;
                if (i < w3Var.b) {
                    if (w3Var.get(i).a == z0Var) {
                        q3.e<i3> m = this.e.m();
                        m.c();
                        while (m.hasNext()) {
                            i3 next = m.next();
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
                        this.d.f(i);
                        i--;
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b1 b1Var, int i, z0 z0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, b1Var, i, z0Var) == null) {
            d(b1Var);
            int i2 = 0;
            while (true) {
                w3<c> w3Var = this.d;
                if (i2 >= w3Var.b || w3Var.get(i2).b > i) {
                    break;
                }
                i2++;
            }
            q3.e<i3> m = this.e.m();
            m.c();
            while (m.hasNext()) {
                i3 next = m.next();
                for (int h = next.h(); h > i2; h--) {
                    if (next.e(h - 1)) {
                        next.k(h);
                    } else {
                        next.c(h);
                    }
                }
                next.c(i2);
            }
            this.e.b(b1Var).k(i2);
            c cVar = new c(null);
            cVar.a = z0Var;
            cVar.b = i;
            this.d.d(i2, cVar);
        }
    }

    public i1<y0> b(b1 b1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b1Var)) == null) {
            return d(b1Var);
        }
        return (i1) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public void f(y0 y0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, y0Var) == null) {
            i3 e = this.f.e();
            i3 e2 = this.f.e();
            q3.c<b1> e3 = this.e.e();
            e3.c();
            while (true) {
                boolean z = false;
                if (!e3.hasNext()) {
                    break;
                }
                b1 next = e3.next();
                int g = next.g();
                i3 f = y0Var.f();
                boolean e4 = f.e(g);
                if (next.h(y0Var) && !y0Var.d) {
                    z = true;
                }
                if (e4 != z) {
                    i3 b2 = this.e.b(next);
                    h3<y0> b3 = this.b.b(next);
                    if (z) {
                        e.j(b2);
                        b3.a(y0Var);
                        f.k(g);
                    } else {
                        e2.j(b2);
                        b3.g(y0Var, true);
                        f.c(g);
                    }
                }
            }
            this.g = true;
            c[] i = this.d.i();
            try {
                for (int i2 = e2.i(0); i2 >= 0; i2 = e2.i(i2 + 1)) {
                    i[i2].a.a(y0Var);
                }
                for (int i3 = e.i(0); i3 >= 0; i3 = e.i(i3 + 1)) {
                    i[i3].a.b(y0Var);
                }
            } finally {
                e.b();
                e2.b();
                this.f.c(e);
                this.f.c(e2);
                this.d.j();
                this.g = false;
            }
        }
    }
}
