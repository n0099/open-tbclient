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
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tieba.mu5;
import com.baidu.tieba.ru5;
import com.baidu.tieba.tm;
import com.baidu.tieba.vz5;
import com.baidu.tieba.wf;
import com.baidu.tieba.xf;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class TbImageMemoryCache implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public static TbImageMemoryCache h;
    public transient /* synthetic */ FieldHolder $fh;
    public wf<String, tm> a;
    public wf<String, tm> b;
    public vz5<String, tm> c;
    public wf<String, Bitmap> d;
    public wf<String, tm> e;
    public xf<mu5> f;
    public ru5 g;

    /* loaded from: classes3.dex */
    public class a extends wf<String, tm> {
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
        @Override // com.baidu.tieba.wf
        /* renamed from: o */
        public void b(boolean z, String str, tm tmVar, tm tmVar2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, tmVar, tmVar2}) == null) && tmVar != null) {
                tmVar.x();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends wf<String, tm> {
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
        @Override // com.baidu.tieba.wf
        /* renamed from: p */
        public int m(String str, tm tmVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, tmVar)) == null) {
                if (tmVar != null) {
                    return tmVar.B();
                }
                return 0;
            }
            return invokeLL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wf
        /* renamed from: o */
        public void b(boolean z, String str, tm tmVar, tm tmVar2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), str, tmVar, tmVar2}) == null) && tmVar != null && !this.h.c.b(str)) {
                tmVar.x();
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016308, str));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends wf<String, Bitmap> {
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
        @Override // com.baidu.tieba.wf
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

    public static TbImageMemoryCache v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return h;
        }
        return (TbImageMemoryCache) invokeV.objValue;
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b.g();
        }
        return invokeV.intValue;
    }

    public void I() {
        xf<mu5> xfVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (xfVar = this.f) != null) {
            xfVar.g(0);
            this.f.f(0);
            this.f.c();
            this.f = null;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.c.a();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
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
        this.c = new vz5<>();
        this.b = new b(this, 0);
        this.d = new c(this, 0);
        this.e = new wf<>(Integer.MAX_VALUE);
    }

    public tm E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            return this.e.f(str);
        }
        return (tm) invokeL.objValue;
    }

    public void J(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.d.k(i);
        }
    }

    public void K(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.a.k(i);
        }
    }

    public void M(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.b.k(i);
        }
    }

    public final tm q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            tm f = this.b.f(str);
            if (f != null && f.w()) {
                e(str, f);
            }
            return f;
        }
        return (tm) invokeL.objValue;
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.a.i(str);
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.b.i(str);
        }
    }

    public boolean t(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            return this.b.e(i);
        }
        return invokeI.booleanValue;
    }

    public Bitmap u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            return this.d.f(str);
        }
        return (Bitmap) invokeL.objValue;
    }

    public tm w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            return this.a.f(str);
        }
        return (tm) invokeL.objValue;
    }

    public tm A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (UbsABTestHelper.isImageCacheOptimize()) {
                tm c2 = this.c.c(str);
                if (c2 != null && c2.w()) {
                    return c2;
                }
                return q(str);
            }
            return this.b.f(str);
        }
        return (tm) invokeL.objValue;
    }

    public xf<mu5> F(int i) {
        InterceptResult invokeI;
        ru5 ru5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (this.f != null && (ru5Var = this.g) != null) {
                if (ru5Var.g() == i) {
                    return this.f;
                }
                this.g.j(i);
                this.f.c();
            }
            if (this.g == null) {
                this.g = new ru5(i);
            }
            if (this.f == null) {
                this.f = new xf<>(this.g, 6, 0);
            }
            return this.f;
        }
        return (xf) invokeI.objValue;
    }

    public void H(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            K(i);
            M(i2);
            J(60);
        }
    }

    public final void e(String str, tm tmVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, tmVar) == null) {
            this.c.d(str, tmVar);
        }
    }

    public void g(String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, str, bitmap) == null) && !StringUtils.isNull(str) && bitmap != null) {
            this.d.h(str, bitmap);
        }
    }

    public void i(String str, tm tmVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, tmVar) == null) {
            l(str, tmVar, false);
        }
    }

    public void m(String str, tm tmVar) {
        wf<String, tm> wfVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, str, tmVar) == null) && tmVar != null && (wfVar = this.b) != null) {
            wfVar.h(str, tmVar);
            if (UbsABTestHelper.isImageCacheOptimize()) {
                q(str);
            }
        }
    }

    public void o(String str, tm tmVar) {
        wf<String, tm> wfVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, str, tmVar) == null) && tmVar != null && (wfVar = this.e) != null) {
            wfVar.h(str, tmVar);
        }
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.b.l() + "/" + this.b.g() + "/" + this.b.d() + "_" + this.a.l() + "/" + this.a.g() + "/" + this.a.d();
        }
        return (String) invokeV.objValue;
    }

    public void l(String str, tm tmVar, boolean z) {
        wf<String, tm> wfVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048589, this, str, tmVar, z) == null) && tmVar != null && (wfVar = this.a) != null) {
            wfVar.h(str, tmVar);
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
