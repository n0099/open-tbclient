package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
/* loaded from: classes4.dex */
public class e0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public k6<a0> b;
    public i0<a0> c;
    public g7<Class<?>, a0> d;
    public c e;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(a0 a0Var);

        void b(a0 a0Var);
    }

    /* loaded from: classes4.dex */
    public static class b implements Comparator<a0> {
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

        public /* synthetic */ b(a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a0 a0Var, a0 a0Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, a0Var, a0Var2)) == null) {
                int i = a0Var.a;
                int i2 = a0Var2.a;
                if (i > i2) {
                    return 1;
                }
                if (i == i2) {
                    return 0;
                }
                return -1;
            }
            return invokeLL.intValue;
        }
    }

    public e0(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new b(null);
        k6<a0> k6Var = new k6<>(true, 16);
        this.b = k6Var;
        this.c = new i0<>(k6Var);
        this.d = new g7<>();
        this.e = cVar;
    }

    public void a(a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, a0Var) == null) {
            Class<?> cls = a0Var.getClass();
            a0 b2 = b(cls);
            if (b2 != null) {
                d(b2);
            }
            this.b.a(a0Var);
            this.d.i(cls, a0Var);
            this.b.sort(this.a);
            this.e.b(a0Var);
        }
    }

    public <T extends a0> T b(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) {
            return (T) this.d.c(cls);
        }
        return (T) invokeL.objValue;
    }

    public void d(a0 a0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, a0Var) == null) && this.b.i(a0Var, true)) {
            this.d.k(a0Var.getClass());
            this.e.a(a0Var);
        }
    }

    public i0<a0> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (i0) invokeV.objValue;
    }
}
