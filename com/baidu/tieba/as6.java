package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.danmu.cache.CacheManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class as6 {
    public static /* synthetic */ Interceptable $ic;
    public static final a f;
    public static final as6 g;
    public transient /* synthetic */ FieldHolder $fh;
    public final bs6 a;
    public boolean b;
    public int c;
    public CacheManager d;
    public int e;

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
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

        public final as6 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return as6.g;
            }
            return (as6) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947625797, "Lcom/baidu/tieba/as6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947625797, "Lcom/baidu/tieba/as6;");
                return;
            }
        }
        f = new a(null);
        g = new as6();
    }

    public as6() {
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
        this.a = new bs6();
    }

    public final void d() {
        CacheManager cacheManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                int i = this.c - 1;
                this.c = i;
                if (i <= 0 && this.b && (cacheManager = this.d) != null) {
                    cacheManager.l(this);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.c <= 0) {
                    m();
                } else {
                    this.b = true;
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                this.a.b();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a.e();
        }
        return invokeV.intValue;
    }

    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a.f();
        }
        return invokeV.intValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this) {
                this.c++;
            }
        }
    }

    public static /* synthetic */ as6 c(as6 as6Var, int i, int i2, int i3, boolean z, int i4, int i5, Object obj) {
        int i6;
        if ((i5 & 16) != 0) {
            i6 = 32;
        } else {
            i6 = i4;
        }
        as6Var.b(i, i2, i3, z, i6);
        return as6Var;
    }

    public final as6 b(int i, int i2, int i3, boolean z, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4)})) == null) {
            synchronized (this) {
                this.a.a(i, i2, i3, z, i4);
                this.e = h(this.a.c());
            }
            return this;
        }
        return (as6) invokeCommon.objValue;
    }

    public final bs6 g() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            bs6 bs6Var = this.a;
            if (!Intrinsics.areEqual(bs6Var.c(), mt6.b()) && !bs6Var.c().isRecycled()) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return null;
            }
            return bs6Var;
        }
        return (bs6) invokeV.objValue;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public final int h(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bitmap)) == null) {
            if (bitmap == null) {
                return 0;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return bitmap.getAllocationByteCount();
            }
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
        return invokeL.intValue;
    }

    public final void n(CacheManager cacheManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cacheManager) == null) {
            this.d = cacheManager;
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this) {
                if (!Intrinsics.areEqual(Thread.currentThread().getName(), "AkDanmaku-Cache")) {
                    BdLog.e("DanmakuEngineDrawingCache recycle called must on cache thread but now on " + Thread.currentThread().getName());
                }
                if (this.c > 0) {
                    return;
                }
                this.b = false;
                this.a.g();
                this.e = 0;
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
