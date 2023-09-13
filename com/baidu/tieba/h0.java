package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.ashley.core.ComponentOperationHandler;
import com.badlogic.ashley.core.EntityManager;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.o0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final p0<i0> a;
    public final p0<i0> b;
    public o0 c;
    public EntityManager d;
    public ComponentOperationHandler e;
    public m0 f;
    public boolean g;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b implements p0<i0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h0 a;

        public b(h0 h0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h0Var;
        }

        public /* synthetic */ b(h0 h0Var, a aVar) {
            this(h0Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p0
        /* renamed from: b */
        public void a(q0<i0> q0Var, i0 i0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q0Var, i0Var) == null) {
                this.a.f.f(i0Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ComponentOperationHandler.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h0 a;

        public c(h0 h0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h0Var;
        }

        public /* synthetic */ c(h0 h0Var, a aVar) {
            this(h0Var);
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
    public class d implements j0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h0 a;

        public d(h0 h0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h0Var;
        }

        @Override // com.baidu.tieba.j0
        public void a(i0 i0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, i0Var) == null) {
                this.a.n(i0Var);
            }
        }

        @Override // com.baidu.tieba.j0
        public void b(i0 i0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i0Var) == null) {
                this.a.d(i0Var);
            }
        }

        public /* synthetic */ d(h0 h0Var, a aVar) {
            this(h0Var);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements o0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h0 a;

        public e(h0 h0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h0Var;
        }

        @Override // com.baidu.tieba.o0.c
        public void a(k0 k0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k0Var) == null) {
                k0Var.h(this.a);
            }
        }

        @Override // com.baidu.tieba.o0.c
        public void b(k0 k0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k0Var) == null) {
                k0Var.d(this.a);
            }
        }

        public /* synthetic */ e(h0 h0Var, a aVar) {
            this(h0Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448304613, "Lcom/baidu/tieba/h0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448304613, "Lcom/baidu/tieba/h0;");
                return;
            }
        }
        l0.d(new Class[0]).b();
    }

    public i0 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return new i0();
        }
        return (i0) invokeV.objValue;
    }

    public s0<k0> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.c.c();
        }
        return (s0) invokeV.objValue;
    }

    public h0() {
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
        this.c = new o0(new e(this, null));
        this.d = new EntityManager(new d(this, null));
        this.e = new ComponentOperationHandler(new c(this, null));
        this.f = new m0(this.d.c());
    }

    public void c(i0 i0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, i0Var) == null) {
            if (!this.g && !this.f.c()) {
                z = false;
            } else {
                z = true;
            }
            this.d.a(i0Var, z);
        }
    }

    public void d(i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i0Var) == null) {
            i0Var.a.a(this.a);
            i0Var.b.a(this.b);
            i0Var.e = this.e;
            this.f.f(i0Var);
        }
    }

    public void g(k0 k0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, k0Var) == null) {
            this.c.a(k0Var);
        }
    }

    public <T extends f0> T h(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cls)) == null) {
            try {
                return (T) n8.i(cls);
            } catch (ReflectionException unused) {
                return null;
            }
        }
        return (T) invokeL.objValue;
    }

    public s0<i0> j(l0 l0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, l0Var)) == null) {
            return this.f.b(l0Var);
        }
        return (s0) invokeL.objValue;
    }

    public <T extends k0> T k(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls)) == null) {
            return (T) this.c.b(cls);
        }
        return (T) invokeL.objValue;
    }

    public void m(i0 i0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, i0Var) == null) {
            if (!this.g && !this.f.c()) {
                z = false;
            } else {
                z = true;
            }
            this.d.e(i0Var, z);
        }
    }

    public void n(i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, i0Var) == null) {
            this.f.f(i0Var);
            i0Var.a.c(this.a);
            i0Var.b.c(this.b);
            i0Var.e = null;
        }
    }

    public void o(j0 j0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, j0Var) == null) {
            this.f.e(j0Var);
        }
    }

    public void p(k0 k0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, k0Var) == null) {
            this.c.d(k0Var);
        }
    }

    public void e(l0 l0Var, int i, j0 j0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, l0Var, i, j0Var) == null) {
            this.f.a(l0Var, i, j0Var);
        }
    }

    public void f(l0 l0Var, j0 j0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, l0Var, j0Var) == null) {
            e(l0Var, 0, j0Var);
        }
    }

    public void update(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f) == null) {
            if (!this.g) {
                this.g = true;
                s0<k0> c2 = this.c.c();
                for (int i = 0; i < c2.size(); i++) {
                    try {
                        k0 k0Var = c2.get(i);
                        if (k0Var.e()) {
                            k0Var.update(f);
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
