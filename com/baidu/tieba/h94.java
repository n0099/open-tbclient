package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class h94 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public static volatile h94 d;
    public transient /* synthetic */ FieldHolder $fh;
    public GameRecorderController a;
    public boolean b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947778534, "Lcom/baidu/tieba/h94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947778534, "Lcom/baidu/tieba/h94;");
                return;
            }
        }
        c = qp1.a;
        d = null;
    }

    public h94() {
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

    public static h94 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (h94.class) {
                    if (d == null) {
                        d = new h94();
                    }
                }
            }
            return d;
        }
        return (h94) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (c) {
                Log.i("GameRecorderManager", "isGamePause:" + this.b);
            }
            return this.b;
        }
        return invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b = true;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b = false;
        }
    }

    @NonNull
    public GameRecorderController b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (c) {
                Log.i("GameRecorderManager", "getRecorderController:" + this.a);
            }
            GameRecorderController gameRecorderController = this.a;
            if (gameRecorderController == null) {
                return GameRecorderController.j();
            }
            return gameRecorderController;
        }
        return (GameRecorderController) invokeV.objValue;
    }

    public void f(GameRecorderController gameRecorderController) {
        GameRecorderController gameRecorderController2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, gameRecorderController) == null) && (gameRecorderController2 = this.a) != null && gameRecorderController2 == gameRecorderController) {
            gameRecorderController2.p();
            this.a = null;
        }
    }

    public void g(GameRecorderController gameRecorderController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gameRecorderController) == null) {
            GameRecorderController gameRecorderController2 = this.a;
            if (gameRecorderController2 != null && gameRecorderController2 != gameRecorderController) {
                gameRecorderController2.p();
            }
            this.a = gameRecorderController;
        }
    }
}
