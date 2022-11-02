package com.baidu.tieba;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class e95 {
    public static /* synthetic */ Interceptable $ic;
    public static e95 g;
    public transient /* synthetic */ FieldHolder $fh;
    public mg<String, hn> a;
    public mg<String, hn> b;
    public mg<String, Bitmap> c;
    public mg<String, hn> d;
    public ng<yk5> e;
    public dl5 f;

    /* loaded from: classes3.dex */
    public class a extends mg<String, hn> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e95 e95Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e95Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mg
        /* renamed from: o */
        public void b(boolean z, String str, hn hnVar, hn hnVar2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, hnVar, hnVar2}) == null) && hnVar != null) {
                hnVar.x();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends mg<String, hn> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(e95 e95Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e95Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mg
        /* renamed from: p */
        public int m(String str, hn hnVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, hnVar)) == null) {
                if (hnVar != null) {
                    return hnVar.B();
                }
                return 0;
            }
            return invokeLL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mg
        /* renamed from: o */
        public void b(boolean z, String str, hn hnVar, hn hnVar2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), str, hnVar, hnVar2}) == null) && hnVar != null) {
                BdLog.isDebugMode();
                hnVar.x();
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016308, str));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends mg<String, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(e95 e95Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e95Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mg
        /* renamed from: o */
        public void b(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, bitmap, bitmap2}) == null) && bitmap != null) {
                bitmap.recycle();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947689192, "Lcom/baidu/tieba/e95;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947689192, "Lcom/baidu/tieba/e95;");
                return;
            }
        }
        g = new e95();
    }

    public static e95 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return g;
        }
        return (e95) invokeV.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.b.g();
        }
        return invokeV.intValue;
    }

    public void r() {
        ng<yk5> ngVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (ngVar = this.e) != null) {
            ngVar.g(0);
            this.e.f(0);
            this.e.c();
            this.e = null;
        }
    }

    public e95() {
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
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.a = new a(this, 0);
        this.b = new b(this, 0);
        this.c = new c(this, 0);
        this.d = new mg<>(Integer.MAX_VALUE);
    }

    public void a(String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) && !StringUtils.isNull(str) && bitmap != null) {
            this.c.h(str, bitmap);
        }
    }

    public void b(String str, hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hnVar) == null) {
            c(str, hnVar, false);
        }
    }

    public void d(String str, hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, hnVar) == null) {
            e(str, hnVar, false);
        }
    }

    public void f(String str, hn hnVar) {
        mg<String, hn> mgVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, str, hnVar) == null) && hnVar != null && (mgVar = this.d) != null) {
            mgVar.h(str, hnVar);
        }
    }

    public void q(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i, i2) == null) {
            t(i);
            u(i2);
            s(60);
        }
    }

    public void c(String str, hn hnVar, boolean z) {
        mg<String, hn> mgVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, str, hnVar, z) == null) && hnVar != null && (mgVar = this.a) != null) {
            mgVar.h(str, hnVar);
        }
    }

    public void e(String str, hn hnVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048580, this, str, hnVar, z) == null) && hnVar != null && this.b != null) {
            BdLog.isDebugMode();
            this.b.h(str, hnVar);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.a.i(str);
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.b.i(str);
        }
    }

    public boolean i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return this.b.e(i);
        }
        return invokeI.booleanValue;
    }

    public Bitmap j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            return this.c.f(str);
        }
        return (Bitmap) invokeL.objValue;
    }

    public hn l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            return this.a.f(str);
        }
        return (hn) invokeL.objValue;
    }

    public hn m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            return this.b.f(str);
        }
        return (hn) invokeL.objValue;
    }

    public hn o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            return this.d.f(str);
        }
        return (hn) invokeL.objValue;
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.c.k(i);
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.a.k(i);
        }
    }

    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.b.k(i);
        }
    }

    public ng<yk5> p(int i) {
        InterceptResult invokeI;
        dl5 dl5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            if (this.e != null && (dl5Var = this.f) != null) {
                if (dl5Var.g() == i) {
                    return this.e;
                }
                this.f.j(i);
                this.e.c();
            }
            if (this.f == null) {
                this.f = new dl5(i);
            }
            if (this.e == null) {
                this.e = new ng<>(this.f, 6, 0);
            }
            return this.e;
        }
        return (ng) invokeI.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return "pic:" + this.b.toString() + "  photo:" + this.a.toString();
        }
        return (String) invokeV.objValue;
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.b.l() + "/" + this.b.g() + "/" + this.b.d() + "_" + this.a.l() + "/" + this.a.g() + "/" + this.a.d();
        }
        return (String) invokeV.objValue;
    }
}
