package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class av0 extends mv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dv0 d;
    public jv0 e;
    public iv0 f;
    public ev0 g;
    public cv0 h;

    public av0() {
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

    public void B() {
        iv0 iv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (iv0Var = this.f) != null) {
            iv0Var.b();
        }
    }

    public void C() {
        iv0 iv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (iv0Var = this.f) != null) {
            iv0Var.a();
        }
    }

    @Override // com.baidu.tieba.mv0, com.baidu.tieba.nv0
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.r();
            this.d = null;
            this.e = null;
            this.g = null;
            this.f = null;
            this.h = null;
        }
    }

    public void D(boolean z, boolean z2) {
        cv0 cv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (cv0Var = this.h) != null) {
            cv0Var.a(z, z2);
        }
    }

    public void F(int i, int i2) {
        ev0 ev0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) && (ev0Var = this.g) != null) {
            ev0Var.a(i, i2);
        }
    }

    public void E(boolean z) {
        jv0 jv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (jv0Var = this.e) != null) {
            jv0Var.a(z);
        }
    }

    public void G(int i) {
        dv0 dv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (dv0Var = this.d) != null) {
            dv0Var.a(i);
        }
    }

    @Override // com.baidu.tieba.nv0
    public void b(vw0 vw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vw0Var) == null) {
            super.b(vw0Var);
            if (InteractiveEvent.ACTION_INTERACTIVE_START.equals(vw0Var.c())) {
                B();
            } else if (InteractiveEvent.ACTION_INTERACTIVE_FINISH.equals(vw0Var.c())) {
                C();
            }
        }
    }
}
