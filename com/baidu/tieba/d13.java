package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d13 implements ty2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nx1 a;
    public String b;
    public f13 c;
    public boolean d;
    public Context e;

    @Override // com.baidu.tieba.ty2
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this : invokeV.objValue;
    }

    @Override // com.baidu.tieba.ty2
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    public d13(Context context, @NonNull f13 f13Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, f13Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = context;
        this.c = f13Var;
        this.b = f13Var.j;
        e();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !TextUtils.isEmpty(this.b)) {
            uy2.a(this);
        }
    }

    @Override // com.baidu.tieba.ty2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c.c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ty2
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public f13 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (f13) invokeV.objValue;
    }

    public nx1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.a == null) {
                v82.i("VrVideo", "create player");
                this.a = cv2.D0().create();
            }
            return this.a;
        }
        return (nx1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ty2
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            f13 f13Var = this.c;
            if (f13Var != null) {
                return f13Var.t;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ty2
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            v82.i("VrVideo", "onBackPressed");
            nx1 nx1Var = this.a;
            if (nx1Var != null && nx1Var.onBackPressed()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ty2
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            v82.i("VrVideo", MissionEvent.MESSAGE_DESTROY);
            nx1 nx1Var = this.a;
            if (nx1Var != null) {
                nx1Var.stop();
                this.a = null;
            }
            uy2.k(this);
        }
    }

    public void g(f13 f13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, f13Var) == null) {
            v82.i("VrVideo", "Open Player " + f13Var.j);
            nx1 nx1Var = this.a;
            if (nx1Var != null) {
                nx1Var.e(f13Var, this.e);
            }
            this.c = f13Var;
        }
    }

    @Override // com.baidu.tieba.ty2
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (z) {
                if (this.d) {
                    e().resume();
                }
                e().b();
            } else if (this.a != null) {
                this.d = e().isPlaying();
                e().pause();
                e().c();
            }
        }
    }

    public void h(f13 f13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, f13Var) == null) {
            v82.b("VrVideo", "update 接口");
            nx1 nx1Var = this.a;
            if (nx1Var != null) {
                nx1Var.d(f13Var, true);
            }
            this.c = f13Var;
        }
    }
}
