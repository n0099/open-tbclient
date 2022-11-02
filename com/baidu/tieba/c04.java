package com.baidu.tieba;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.tieba.u04;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
@Singleton
@Service
/* loaded from: classes3.dex */
public class c04 implements ol1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c04() {
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

    @Override // com.baidu.tieba.ol1
    public SwanCoreVersion m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return e04.m().s();
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ol1
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            e04.C();
        }
    }

    @Override // com.baidu.tieba.ol1
    public ExtensionCore s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return e04.m().k();
        }
        return (ExtensionCore) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ol1
    public qe2 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return rz3.i();
        }
        return (qe2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ol1
    public dh2 n(SwanAppActivity swanAppActivity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanAppActivity, str)) == null) {
            return new f04(swanAppActivity, str);
        }
        return (dh2) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ol1
    public void v(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, str, z) == null) {
            k64.a().d(str, z);
        }
    }

    @Override // com.baidu.tieba.ol1
    public m72 o(xi3<Exception> xi3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xi3Var)) == null) {
            return new k04(xi3Var);
        }
        return (m72) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ol1
    public void p(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            e04.m().z(intent);
        }
    }

    @Override // com.baidu.tieba.ol1
    public View q(k32 k32Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, k32Var)) == null) {
            if (k32Var instanceof b04) {
                return ((b04) k32Var).v3();
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ol1
    public void r(V8ExceptionInfo v8ExceptionInfo) {
        DuMixGameSurfaceView r;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, v8ExceptionInfo) == null) && (r = e04.m().r()) != null) {
            r.r(v8ExceptionInfo);
        }
    }

    @Override // com.baidu.tieba.ol1
    public int u(String str, long j) {
        InterceptResult invokeLJ;
        y34 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048585, this, str, j)) == null) {
            if (TextUtils.isEmpty(str) || (a = y34.a(ik4.E(new File(u04.d.h(str, String.valueOf(j)), "game.json")))) == null) {
                return 0;
            }
            return a.b;
        }
        return invokeLJ.intValue;
    }
}
