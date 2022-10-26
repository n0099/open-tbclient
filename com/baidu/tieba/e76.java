package com.baidu.tieba;

import android.graphics.PointF;
import android.graphics.RectF;
import androidx.core.util.Pools;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.danmu.ui.DanmakuPlayer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class e76 {
    public static /* synthetic */ Interceptable $ic;
    public static final e76 a;
    public static final Pools.SimplePool b;
    public static final Pools.SimplePool c;
    public static final Pools.SimplePool d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947687301, "Lcom/baidu/tieba/e76;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947687301, "Lcom/baidu/tieba/e76;");
                return;
            }
        }
        a = new e76();
        b = new Pools.SimplePool(200);
        c = new Pools.SimplePool(200);
        d = new Pools.SimplePool(1000);
    }

    public e76() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final PointF b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PointF pointF = (PointF) c.acquire();
            if (pointF == null) {
                return new PointF();
            }
            return pointF;
        }
        return (PointF) invokeV.objValue;
    }

    public final RectF c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            RectF rectF = (RectF) b.acquire();
            if (rectF == null) {
                return new RectF();
            }
            return rectF;
        }
        return (RectF) invokeV.objValue;
    }

    public final x46 a(y46 data, DanmakuPlayer player) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, data, player)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(player, "player");
            x46 x46Var = (x46) d.acquire();
            if (x46Var == null) {
                x46Var = null;
            } else {
                x46Var.l(data);
                x46Var.p(player.m().w());
            }
            if (x46Var == null) {
                return new x46(data, player);
            }
            return x46Var;
        }
        return (x46) invokeLL.objValue;
    }
}
