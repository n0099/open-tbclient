package com.baidu.tieba;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.GenericDeclaration;
/* loaded from: classes5.dex */
public class f1 implements k8<Void> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g1 a;
    public final c1 b;
    public final h1 c;
    public final i8 d;
    public final long e;
    public volatile boolean f;
    public volatile boolean g;
    public volatile u6<c1> h;
    public volatile j8<Void> i;
    public volatile j8<Void> j;
    public volatile Object k;
    public volatile boolean l;

    public f1(g1 g1Var, c1 c1Var, h1 h1Var, i8 i8Var) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {g1Var, c1Var, h1Var, i8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = g1Var;
        this.b = c1Var;
        this.c = h1Var;
        this.d = i8Var;
        if (g1Var.m.d() == 3) {
            j = g8.b();
        } else {
            j = 0;
        }
        this.e = j;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            i1 i1Var = (i1) this.c;
            if (!this.g) {
                if (this.i == null) {
                    this.i = this.d.a(this);
                } else if (this.i.b()) {
                    try {
                        this.i.a();
                        this.g = true;
                        if (this.f) {
                            g1 g1Var = this.a;
                            c1 c1Var = this.b;
                            this.k = i1Var.d(g1Var, c1Var.a, d(this.c, c1Var), this.b.c);
                        }
                    } catch (Exception e) {
                        throw new GdxRuntimeException("Couldn't load dependencies of asset: " + this.b.a, e);
                    }
                }
            } else if (this.j == null && !this.f) {
                this.j = this.d.a(this);
            } else if (this.f) {
                g1 g1Var2 = this.a;
                c1 c1Var2 = this.b;
                this.k = i1Var.d(g1Var2, c1Var2.a, d(this.c, c1Var2), this.b.c);
            } else if (this.j.b()) {
                try {
                    this.j.a();
                    g1 g1Var3 = this.a;
                    c1 c1Var3 = this.b;
                    this.k = i1Var.d(g1Var3, c1Var3.a, d(this.c, c1Var3), this.b.c);
                } catch (Exception e2) {
                    throw new GdxRuntimeException("Couldn't load asset: " + this.b.a, e2);
                }
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            u1 u1Var = (u1) this.c;
            if (!this.g) {
                this.g = true;
                c1 c1Var = this.b;
                this.h = u1Var.a(c1Var.a, d(this.c, c1Var), this.b.c);
                if (this.h == null) {
                    g1 g1Var = this.a;
                    c1 c1Var2 = this.b;
                    this.k = u1Var.c(g1Var, c1Var2.a, d(this.c, c1Var2), this.b.c);
                    return;
                }
                c(this.h);
                this.a.t(this.b.a, this.h);
                return;
            }
            g1 g1Var2 = this.a;
            c1 c1Var3 = this.b;
            this.k = u1Var.c(g1Var2, c1Var3.a, d(this.c, c1Var3), this.b.c);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.k8
    public Void call() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.l) {
                return null;
            }
            i1 i1Var = (i1) this.c;
            if (!this.g) {
                c1 c1Var = this.b;
                this.h = i1Var.a(c1Var.a, d(this.c, c1Var), this.b.c);
                if (this.h != null) {
                    c(this.h);
                    this.a.t(this.b.a, this.h);
                } else {
                    g1 g1Var = this.a;
                    c1 c1Var2 = this.b;
                    i1Var.c(g1Var, c1Var2.a, d(this.c, c1Var2), this.b.c);
                    this.f = true;
                }
            } else {
                g1 g1Var2 = this.a;
                c1 c1Var3 = this.b;
                i1Var.c(g1Var2, c1Var3.a, d(this.c, c1Var3), this.b.c);
                this.f = true;
            }
            return null;
        }
        return (Void) invokeV.objValue;
    }

    public final void c(u6<c1> u6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, u6Var) == null) {
            boolean z = u6Var.c;
            u6Var.c = true;
            for (int i = 0; i < u6Var.b; i++) {
                String str = u6Var.get(i).a;
                GenericDeclaration genericDeclaration = u6Var.get(i).b;
                for (int i2 = u6Var.b - 1; i2 > i; i2--) {
                    if (genericDeclaration == u6Var.get(i2).b && str.equals(u6Var.get(i2).a)) {
                        u6Var.h(i2);
                    }
                }
            }
            u6Var.c = z;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            h1 h1Var = this.c;
            if (h1Var instanceof i1) {
                g1 g1Var = this.a;
                c1 c1Var = this.b;
                ((i1) h1Var).e(g1Var, c1Var.a, d(h1Var, c1Var), this.b.c);
            }
        }
    }

    public boolean update() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.c instanceof u1) {
                b();
            } else {
                a();
            }
            if (this.k != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final d3 d(h1 h1Var, c1 c1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, h1Var, c1Var)) == null) {
            if (c1Var.d == null) {
                c1Var.d = h1Var.b(c1Var.a);
            }
            return c1Var.d;
        }
        return (d3) invokeLL.objValue;
    }
}
