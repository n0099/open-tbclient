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
/* loaded from: classes4.dex */
public class gs2 implements wp2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qo1 a;
    public String b;
    public is2 c;
    public boolean d;
    public Context e;

    public gs2(Context context, @NonNull is2 is2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, is2Var};
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
        this.c = is2Var;
        this.b = is2Var.j;
        e();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.b)) {
            return;
        }
        xp2.a(this);
    }

    @Override // com.baidu.tieba.wp2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c.c : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wp2
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public is2 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (is2) invokeV.objValue;
    }

    public qo1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.a == null) {
                yz1.i("VrVideo", "create player");
                this.a = fm2.D0().create();
            }
            return this.a;
        }
        return (qo1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wp2
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            is2 is2Var = this.c;
            return is2Var != null ? is2Var.t : "";
        }
        return (String) invokeV.objValue;
    }

    public void g(is2 is2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, is2Var) == null) {
            yz1.i("VrVideo", "Open Player " + is2Var.j);
            qo1 qo1Var = this.a;
            if (qo1Var != null) {
                qo1Var.e(is2Var, this.e);
            }
            this.c = is2Var;
        }
    }

    public void h(is2 is2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, is2Var) == null) {
            yz1.b("VrVideo", "update 接口");
            qo1 qo1Var = this.a;
            if (qo1Var != null) {
                qo1Var.d(is2Var, true);
            }
            this.c = is2Var;
        }
    }

    @Override // com.baidu.tieba.wp2
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this : invokeV.objValue;
    }

    @Override // com.baidu.tieba.wp2
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    @Override // com.baidu.tieba.wp2
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

    @Override // com.baidu.tieba.wp2
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            yz1.i("VrVideo", "onBackPressed");
            qo1 qo1Var = this.a;
            return qo1Var != null && qo1Var.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.wp2
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            yz1.i("VrVideo", MissionEvent.MESSAGE_DESTROY);
            qo1 qo1Var = this.a;
            if (qo1Var != null) {
                qo1Var.stop();
                this.a = null;
            }
            xp2.k(this);
        }
    }
}
