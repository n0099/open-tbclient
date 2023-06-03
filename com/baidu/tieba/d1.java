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
public class d1 implements i8<Void> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e1 a;
    public final a1 b;
    public final f1 c;
    public final g8 d;
    public final long e;
    public volatile boolean f;
    public volatile boolean g;
    public volatile s6<a1> h;
    public volatile h8<Void> i;
    public volatile h8<Void> j;
    public volatile Object k;
    public volatile boolean l;

    public d1(e1 e1Var, a1 a1Var, f1 f1Var, g8 g8Var) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e1Var, a1Var, f1Var, g8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = e1Var;
        this.b = a1Var;
        this.c = f1Var;
        this.d = g8Var;
        if (e1Var.m.d() == 3) {
            j = e8.b();
        } else {
            j = 0;
        }
        this.e = j;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            g1 g1Var = (g1) this.c;
            if (!this.g) {
                if (this.i == null) {
                    this.i = this.d.a(this);
                } else if (this.i.b()) {
                    try {
                        this.i.a();
                        this.g = true;
                        if (this.f) {
                            e1 e1Var = this.a;
                            a1 a1Var = this.b;
                            this.k = g1Var.d(e1Var, a1Var.a, d(this.c, a1Var), this.b.c);
                        }
                    } catch (Exception e) {
                        throw new GdxRuntimeException("Couldn't load dependencies of asset: " + this.b.a, e);
                    }
                }
            } else if (this.j == null && !this.f) {
                this.j = this.d.a(this);
            } else if (this.f) {
                e1 e1Var2 = this.a;
                a1 a1Var2 = this.b;
                this.k = g1Var.d(e1Var2, a1Var2.a, d(this.c, a1Var2), this.b.c);
            } else if (this.j.b()) {
                try {
                    this.j.a();
                    e1 e1Var3 = this.a;
                    a1 a1Var3 = this.b;
                    this.k = g1Var.d(e1Var3, a1Var3.a, d(this.c, a1Var3), this.b.c);
                } catch (Exception e2) {
                    throw new GdxRuntimeException("Couldn't load asset: " + this.b.a, e2);
                }
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            s1 s1Var = (s1) this.c;
            if (!this.g) {
                this.g = true;
                a1 a1Var = this.b;
                this.h = s1Var.a(a1Var.a, d(this.c, a1Var), this.b.c);
                if (this.h == null) {
                    e1 e1Var = this.a;
                    a1 a1Var2 = this.b;
                    this.k = s1Var.c(e1Var, a1Var2.a, d(this.c, a1Var2), this.b.c);
                    return;
                }
                c(this.h);
                this.a.t(this.b.a, this.h);
                return;
            }
            e1 e1Var2 = this.a;
            a1 a1Var3 = this.b;
            this.k = s1Var.c(e1Var2, a1Var3.a, d(this.c, a1Var3), this.b.c);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i8
    public Void call() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.l) {
                return null;
            }
            g1 g1Var = (g1) this.c;
            if (!this.g) {
                a1 a1Var = this.b;
                this.h = g1Var.a(a1Var.a, d(this.c, a1Var), this.b.c);
                if (this.h != null) {
                    c(this.h);
                    this.a.t(this.b.a, this.h);
                } else {
                    e1 e1Var = this.a;
                    a1 a1Var2 = this.b;
                    g1Var.c(e1Var, a1Var2.a, d(this.c, a1Var2), this.b.c);
                    this.f = true;
                }
            } else {
                e1 e1Var2 = this.a;
                a1 a1Var3 = this.b;
                g1Var.c(e1Var2, a1Var3.a, d(this.c, a1Var3), this.b.c);
                this.f = true;
            }
            return null;
        }
        return (Void) invokeV.objValue;
    }

    public final void c(s6<a1> s6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, s6Var) == null) {
            boolean z = s6Var.c;
            s6Var.c = true;
            for (int i = 0; i < s6Var.b; i++) {
                String str = s6Var.get(i).a;
                GenericDeclaration genericDeclaration = s6Var.get(i).b;
                for (int i2 = s6Var.b - 1; i2 > i; i2--) {
                    if (genericDeclaration == s6Var.get(i2).b && str.equals(s6Var.get(i2).a)) {
                        s6Var.h(i2);
                    }
                }
            }
            s6Var.c = z;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            f1 f1Var = this.c;
            if (f1Var instanceof g1) {
                e1 e1Var = this.a;
                a1 a1Var = this.b;
                ((g1) f1Var).e(e1Var, a1Var.a, d(f1Var, a1Var), this.b.c);
            }
        }
    }

    public boolean update() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.c instanceof s1) {
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

    public final b3 d(f1 f1Var, a1 a1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, f1Var, a1Var)) == null) {
            if (a1Var.d == null) {
                a1Var.d = f1Var.b(a1Var.a);
            }
            return a1Var.d;
        }
        return (b3) invokeLL.objValue;
    }
}
