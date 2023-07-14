package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.ashley.core.ComponentOperationHandler;
import com.badlogic.ashley.core.EntityManager;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final o0<h0> a;
    public final o0<h0> b;
    public n0 c;
    public EntityManager d;
    public ComponentOperationHandler e;
    public l0 f;
    public boolean g;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b implements o0<h0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g0 a;

        public b(g0 g0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g0Var;
        }

        public /* synthetic */ b(g0 g0Var, a aVar) {
            this(g0Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.o0
        /* renamed from: b */
        public void a(p0<h0> p0Var, h0 h0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p0Var, h0Var) == null) {
                this.a.f.f(h0Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ComponentOperationHandler.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g0 a;

        public c(g0 g0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g0Var;
        }

        public /* synthetic */ c(g0 g0Var, a aVar) {
            this(g0Var);
        }

        @Override // com.badlogic.ashley.core.ComponentOperationHandler.b
        public boolean value() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a.g;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements i0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g0 a;

        public d(g0 g0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g0Var;
        }

        @Override // com.baidu.tieba.i0
        public void a(h0 h0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, h0Var) == null) {
                this.a.n(h0Var);
            }
        }

        @Override // com.baidu.tieba.i0
        public void b(h0 h0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h0Var) == null) {
                this.a.d(h0Var);
            }
        }

        public /* synthetic */ d(g0 g0Var, a aVar) {
            this(g0Var);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements n0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g0 a;

        public e(g0 g0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g0Var;
        }

        @Override // com.baidu.tieba.n0.c
        public void a(j0 j0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j0Var) == null) {
                j0Var.h(this.a);
            }
        }

        @Override // com.baidu.tieba.n0.c
        public void b(j0 j0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j0Var) == null) {
                j0Var.d(this.a);
            }
        }

        public /* synthetic */ e(g0 g0Var, a aVar) {
            this(g0Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448303652, "Lcom/baidu/tieba/g0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448303652, "Lcom/baidu/tieba/g0;");
                return;
            }
        }
        k0.d(new Class[0]).b();
    }

    public h0 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return new h0();
        }
        return (h0) invokeV.objValue;
    }

    public r0<j0> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.c.c();
        }
        return (r0) invokeV.objValue;
    }

    public g0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new b(this, null);
        this.b = new b(this, null);
        this.c = new n0(new e(this, null));
        this.d = new EntityManager(new d(this, null));
        this.e = new ComponentOperationHandler(new c(this, null));
        this.f = new l0(this.d.c());
    }

    public void c(h0 h0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, h0Var) == null) {
            if (!this.g && !this.f.c()) {
                z = false;
            } else {
                z = true;
            }
            this.d.a(h0Var, z);
        }
    }

    public void d(h0 h0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h0Var) == null) {
            h0Var.a.a(this.a);
            h0Var.b.a(this.b);
            h0Var.e = this.e;
            this.f.f(h0Var);
        }
    }

    public void g(j0 j0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, j0Var) == null) {
            this.c.a(j0Var);
        }
    }

    public <T extends e0> T h(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cls)) == null) {
            try {
                return (T) m8.i(cls);
            } catch (ReflectionException unused) {
                return null;
            }
        }
        return (T) invokeL.objValue;
    }

    public r0<h0> j(k0 k0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, k0Var)) == null) {
            return this.f.b(k0Var);
        }
        return (r0) invokeL.objValue;
    }

    public <T extends j0> T k(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls)) == null) {
            return (T) this.c.b(cls);
        }
        return (T) invokeL.objValue;
    }

    public void m(h0 h0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, h0Var) == null) {
            if (!this.g && !this.f.c()) {
                z = false;
            } else {
                z = true;
            }
            this.d.e(h0Var, z);
        }
    }

    public void n(h0 h0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, h0Var) == null) {
            this.f.f(h0Var);
            h0Var.a.c(this.a);
            h0Var.b.c(this.b);
            h0Var.e = null;
        }
    }

    public void o(i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, i0Var) == null) {
            this.f.e(i0Var);
        }
    }

    public void p(j0 j0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, j0Var) == null) {
            this.c.d(j0Var);
        }
    }

    public void e(k0 k0Var, int i, i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, k0Var, i, i0Var) == null) {
            this.f.a(k0Var, i, i0Var);
        }
    }

    public void f(k0 k0Var, i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, k0Var, i0Var) == null) {
            e(k0Var, 0, i0Var);
        }
    }

    public void update(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f) == null) {
            if (!this.g) {
                this.g = true;
                r0<j0> c2 = this.c.c();
                for (int i = 0; i < c2.size(); i++) {
                    try {
                        j0 j0Var = c2.get(i);
                        if (j0Var.e()) {
                            j0Var.update(f);
                        }
                        this.e.b();
                        this.d.d();
                    } finally {
                        this.g = false;
                    }
                }
                return;
            }
            throw new IllegalStateException("Cannot call update() on an Engine that is already updating.");
        }
    }
}
