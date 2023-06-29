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
public class e1 implements j8<Void> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f1 a;
    public final b1 b;
    public final g1 c;
    public final h8 d;
    public final long e;
    public volatile boolean f;
    public volatile boolean g;
    public volatile t6<b1> h;
    public volatile i8<Void> i;
    public volatile i8<Void> j;
    public volatile Object k;
    public volatile boolean l;

    public e1(f1 f1Var, b1 b1Var, g1 g1Var, h8 h8Var) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f1Var, b1Var, g1Var, h8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = f1Var;
        this.b = b1Var;
        this.c = g1Var;
        this.d = h8Var;
        if (f1Var.m.d() == 3) {
            j = f8.b();
        } else {
            j = 0;
        }
        this.e = j;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            h1 h1Var = (h1) this.c;
            if (!this.g) {
                if (this.i == null) {
                    this.i = this.d.a(this);
                } else if (this.i.b()) {
                    try {
                        this.i.a();
                        this.g = true;
                        if (this.f) {
                            f1 f1Var = this.a;
                            b1 b1Var = this.b;
                            this.k = h1Var.d(f1Var, b1Var.a, d(this.c, b1Var), this.b.c);
                        }
                    } catch (Exception e) {
                        throw new GdxRuntimeException("Couldn't load dependencies of asset: " + this.b.a, e);
                    }
                }
            } else if (this.j == null && !this.f) {
                this.j = this.d.a(this);
            } else if (this.f) {
                f1 f1Var2 = this.a;
                b1 b1Var2 = this.b;
                this.k = h1Var.d(f1Var2, b1Var2.a, d(this.c, b1Var2), this.b.c);
            } else if (this.j.b()) {
                try {
                    this.j.a();
                    f1 f1Var3 = this.a;
                    b1 b1Var3 = this.b;
                    this.k = h1Var.d(f1Var3, b1Var3.a, d(this.c, b1Var3), this.b.c);
                } catch (Exception e2) {
                    throw new GdxRuntimeException("Couldn't load asset: " + this.b.a, e2);
                }
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            t1 t1Var = (t1) this.c;
            if (!this.g) {
                this.g = true;
                b1 b1Var = this.b;
                this.h = t1Var.a(b1Var.a, d(this.c, b1Var), this.b.c);
                if (this.h == null) {
                    f1 f1Var = this.a;
                    b1 b1Var2 = this.b;
                    this.k = t1Var.c(f1Var, b1Var2.a, d(this.c, b1Var2), this.b.c);
                    return;
                }
                c(this.h);
                this.a.t(this.b.a, this.h);
                return;
            }
            f1 f1Var2 = this.a;
            b1 b1Var3 = this.b;
            this.k = t1Var.c(f1Var2, b1Var3.a, d(this.c, b1Var3), this.b.c);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.j8
    public Void call() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.l) {
                return null;
            }
            h1 h1Var = (h1) this.c;
            if (!this.g) {
                b1 b1Var = this.b;
                this.h = h1Var.a(b1Var.a, d(this.c, b1Var), this.b.c);
                if (this.h != null) {
                    c(this.h);
                    this.a.t(this.b.a, this.h);
                } else {
                    f1 f1Var = this.a;
                    b1 b1Var2 = this.b;
                    h1Var.c(f1Var, b1Var2.a, d(this.c, b1Var2), this.b.c);
                    this.f = true;
                }
            } else {
                f1 f1Var2 = this.a;
                b1 b1Var3 = this.b;
                h1Var.c(f1Var2, b1Var3.a, d(this.c, b1Var3), this.b.c);
                this.f = true;
            }
            return null;
        }
        return (Void) invokeV.objValue;
    }

    public final void c(t6<b1> t6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t6Var) == null) {
            boolean z = t6Var.c;
            t6Var.c = true;
            for (int i = 0; i < t6Var.b; i++) {
                String str = t6Var.get(i).a;
                GenericDeclaration genericDeclaration = t6Var.get(i).b;
                for (int i2 = t6Var.b - 1; i2 > i; i2--) {
                    if (genericDeclaration == t6Var.get(i2).b && str.equals(t6Var.get(i2).a)) {
                        t6Var.h(i2);
                    }
                }
            }
            t6Var.c = z;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            g1 g1Var = this.c;
            if (g1Var instanceof h1) {
                f1 f1Var = this.a;
                b1 b1Var = this.b;
                ((h1) g1Var).e(f1Var, b1Var.a, d(g1Var, b1Var), this.b.c);
            }
        }
    }

    public boolean update() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.c instanceof t1) {
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

    public final c3 d(g1 g1Var, b1 b1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, g1Var, b1Var)) == null) {
            if (b1Var.d == null) {
                b1Var.d = g1Var.b(b1Var.a);
            }
            return b1Var.d;
        }
        return (c3) invokeLL.objValue;
    }
}
