package com.baidu.tbadk.imageManager;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ag;
import com.baidu.tieba.rz5;
import com.baidu.tieba.wz5;
import com.baidu.tieba.x46;
import com.baidu.tieba.zf;
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
    public zf<String, BdImage> a;
    public zf<String, BdImage> b;
    public x46<String, BdImage> c;
    public zf<String, Bitmap> d;
    public zf<String, BdImage> e;
    public ag<rz5> f;
    public wz5 g;

    /* loaded from: classes4.dex */
    public class a extends zf<String, BdImage> {
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
        @Override // com.baidu.tieba.zf
        /* renamed from: o */
        public void b(boolean z, String str, BdImage bdImage, BdImage bdImage2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, bdImage, bdImage2}) == null) && bdImage != null) {
                bdImage.recycle();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends zf<String, BdImage> {
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
        @Override // com.baidu.tieba.zf
        /* renamed from: p */
        public int m(String str, BdImage bdImage) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, bdImage)) == null) {
                if (bdImage != null) {
                    return bdImage.size();
                }
                return 0;
            }
            return invokeLL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zf
        /* renamed from: o */
        public void b(boolean z, String str, BdImage bdImage, BdImage bdImage2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), str, bdImage, bdImage2}) == null) && bdImage != null && !this.h.c.b(str)) {
                bdImage.recycle();
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016308, str));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends zf<String, Bitmap> {
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
        @Override // com.baidu.tieba.zf
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

    public static TbImageMemoryCache B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return h;
        }
        return (TbImageMemoryCache) invokeV.objValue;
    }

    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b.g();
        }
        return invokeV.intValue;
    }

    public void J() {
        ag<rz5> agVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (agVar = this.f) != null) {
            agVar.g(0);
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
        this.c = new x46<>();
        this.b = new b(this, 0);
        this.d = new c(this, 0);
        this.e = new zf<>(Integer.MAX_VALUE);
    }

    public BdImage C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return this.a.f(str);
        }
        return (BdImage) invokeL.objValue;
    }

    public BdImage D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            BdImage c2 = this.c.c(str);
            if (c2 != null && c2.isValidNow()) {
                return c2;
            }
            return q(str);
        }
        return (BdImage) invokeL.objValue;
    }

    public BdImage F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            return this.e.f(str);
        }
        return (BdImage) invokeL.objValue;
    }

    public void L(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.d.k(i);
        }
    }

    public void M(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.a.k(i);
        }
    }

    public void N(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.b.k(i);
        }
    }

    public final BdImage q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            BdImage f = this.b.f(str);
            if (f != null && f.isValidNow()) {
                d(str, f);
            }
            return f;
        }
        return (BdImage) invokeL.objValue;
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.a.i(str);
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.b.i(str);
        }
    }

    public boolean v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
            return this.b.e(i);
        }
        return invokeI.booleanValue;
    }

    public Bitmap w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            return this.d.f(str);
        }
        return (Bitmap) invokeL.objValue;
    }

    public ag<rz5> G(int i) {
        InterceptResult invokeI;
        wz5 wz5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (this.f != null && (wz5Var = this.g) != null) {
                if (wz5Var.g() == i) {
                    return this.f;
                }
                this.g.j(i);
                this.f.c();
            }
            if (this.g == null) {
                this.g = new wz5(i);
            }
            if (this.f == null) {
                this.f = new ag<>(this.g, 6, 0);
            }
            return this.f;
        }
        return (ag) invokeI.objValue;
    }

    public void I(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            M(i);
            N(i2);
            L(60);
        }
    }

    public final void d(String str, BdImage bdImage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, bdImage) == null) {
            this.c.d(str, bdImage);
        }
    }

    public void i(String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, str, bitmap) == null) && !StringUtils.isNull(str) && bitmap != null) {
            this.d.h(str, bitmap);
        }
    }

    public void j(String str, BdImage bdImage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, bdImage) == null) {
            k(str, bdImage, false);
        }
    }

    public void m(String str, BdImage bdImage) {
        zf<String, BdImage> zfVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, str, bdImage) == null) && bdImage != null && (zfVar = this.b) != null) {
            zfVar.h(str, bdImage);
            q(str);
        }
    }

    public void p(String str, BdImage bdImage) {
        zf<String, BdImage> zfVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, str, bdImage) == null) && bdImage != null && (zfVar = this.e) != null) {
            zfVar.h(str, bdImage);
        }
    }

    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.b.l() + "/" + this.b.g() + "/" + this.b.d() + "_" + this.a.l() + "/" + this.a.g() + "/" + this.a.d();
        }
        return (String) invokeV.objValue;
    }

    public void k(String str, BdImage bdImage, boolean z) {
        zf<String, BdImage> zfVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048590, this, str, bdImage, z) == null) && bdImage != null && (zfVar = this.a) != null) {
            zfVar.h(str, bdImage);
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
