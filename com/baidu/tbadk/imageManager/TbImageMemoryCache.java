package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.in;
import com.baidu.tieba.l06;
import com.baidu.tieba.lg;
import com.baidu.tieba.mg;
import com.baidu.tieba.q06;
import com.baidu.tieba.u56;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class TbImageMemoryCache implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public static TbImageMemoryCache h;
    public transient /* synthetic */ FieldHolder $fh;
    public lg<String, in> a;
    public lg<String, in> b;
    public u56<String, in> c;
    public lg<String, Bitmap> d;
    public lg<String, in> e;
    public mg<l06> f;
    public q06 g;

    /* loaded from: classes4.dex */
    public class a extends lg<String, in> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TbImageMemoryCache tbImageMemoryCache, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageMemoryCache, Integer.valueOf(i)};
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
        @Override // com.baidu.tieba.lg
        /* renamed from: o */
        public void b(boolean z, String str, in inVar, in inVar2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, inVar, inVar2}) == null) && inVar != null) {
                inVar.x();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends lg<String, in> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbImageMemoryCache h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(TbImageMemoryCache tbImageMemoryCache, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageMemoryCache, Integer.valueOf(i)};
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
            this.h = tbImageMemoryCache;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lg
        /* renamed from: p */
        public int m(String str, in inVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, inVar)) == null) {
                if (inVar != null) {
                    return inVar.B();
                }
                return 0;
            }
            return invokeLL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lg
        /* renamed from: o */
        public void b(boolean z, String str, in inVar, in inVar2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), str, inVar, inVar2}) == null) && inVar != null && !this.h.c.b(str)) {
                inVar.x();
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016308, str));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends lg<String, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(TbImageMemoryCache tbImageMemoryCache, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageMemoryCache, Integer.valueOf(i)};
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
        @Override // com.baidu.tieba.lg
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-8643027, "Lcom/baidu/tbadk/imageManager/TbImageMemoryCache;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-8643027, "Lcom/baidu/tbadk/imageManager/TbImageMemoryCache;");
                return;
            }
        }
        h = new TbImageMemoryCache();
    }

    public static TbImageMemoryCache u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return h;
        }
        return (TbImageMemoryCache) invokeV.objValue;
    }

    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b.g();
        }
        return invokeV.intValue;
    }

    public void H() {
        mg<l06> mgVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (mgVar = this.f) != null) {
            mgVar.g(0);
            this.f.f(0);
            this.f.c();
            this.f = null;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.c.a();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.c.a();
        }
    }

    public TbImageMemoryCache() {
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
        this.e = null;
        this.a = new a(this, 0);
        this.c = new u56<>();
        this.b = new b(this, 0);
        this.d = new c(this, 0);
        this.e = new lg<>(Integer.MAX_VALUE);
    }

    public in D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            return this.e.f(str);
        }
        return (in) invokeL.objValue;
    }

    public void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.d.k(i);
        }
    }

    public void J(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.a.k(i);
        }
    }

    public void L(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.b.k(i);
        }
    }

    public final in p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            in f = this.b.f(str);
            if (f != null && f.w()) {
                d(str, f);
            }
            return f;
        }
        return (in) invokeL.objValue;
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.a.i(str);
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.b.i(str);
        }
    }

    public boolean s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
            return this.b.e(i);
        }
        return invokeI.booleanValue;
    }

    public Bitmap t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            return this.d.f(str);
        }
        return (Bitmap) invokeL.objValue;
    }

    public in v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            return this.a.f(str);
        }
        return (in) invokeL.objValue;
    }

    public in w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            in c2 = this.c.c(str);
            if (c2 != null && c2.w()) {
                return c2;
            }
            return p(str);
        }
        return (in) invokeL.objValue;
    }

    public mg<l06> E(int i) {
        InterceptResult invokeI;
        q06 q06Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (this.f != null && (q06Var = this.g) != null) {
                if (q06Var.g() == i) {
                    return this.f;
                }
                this.g.j(i);
                this.f.c();
            }
            if (this.g == null) {
                this.g = new q06(i);
            }
            if (this.f == null) {
                this.f = new mg<>(this.g, 6, 0);
            }
            return this.f;
        }
        return (mg) invokeI.objValue;
    }

    public void G(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            J(i);
            L(i2);
            I(60);
        }
    }

    public final void d(String str, in inVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, inVar) == null) {
            this.c.d(str, inVar);
        }
    }

    public void f(String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, str, bitmap) == null) && !StringUtils.isNull(str) && bitmap != null) {
            this.d.h(str, bitmap);
        }
    }

    public void g(String str, in inVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, inVar) == null) {
            j(str, inVar, false);
        }
    }

    public void l(String str, in inVar) {
        lg<String, in> lgVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, str, inVar) == null) && inVar != null && (lgVar = this.b) != null) {
            lgVar.h(str, inVar);
            p(str);
        }
    }

    public void m(String str, in inVar) {
        lg<String, in> lgVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, str, inVar) == null) && inVar != null && (lgVar = this.e) != null) {
            lgVar.h(str, inVar);
        }
    }

    public String M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b.l() + "/" + this.b.g() + "/" + this.b.d() + "_" + this.a.l() + "/" + this.a.g() + "/" + this.a.d();
        }
        return (String) invokeV.objValue;
    }

    public void j(String str, in inVar, boolean z) {
        lg<String, in> lgVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048588, this, str, inVar, z) == null) && inVar != null && (lgVar = this.a) != null) {
            lgVar.h(str, inVar);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return "pic:" + this.b.toString() + "  photo:" + this.a.toString();
        }
        return (String) invokeV.objValue;
    }
}
