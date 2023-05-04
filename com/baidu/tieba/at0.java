package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class at0 extends mt0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dt0 d;
    public jt0 e;
    public it0 f;
    public et0 g;
    public ct0 h;

    public at0() {
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
        it0 it0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (it0Var = this.f) != null) {
            it0Var.b();
        }
    }

    public void C() {
        it0 it0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (it0Var = this.f) != null) {
            it0Var.a();
        }
    }

    @Override // com.baidu.tieba.mt0, com.baidu.tieba.nt0
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
        ct0 ct0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (ct0Var = this.h) != null) {
            ct0Var.a(z, z2);
        }
    }

    public void F(int i, int i2) {
        et0 et0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) && (et0Var = this.g) != null) {
            et0Var.a(i, i2);
        }
    }

    public void E(boolean z) {
        jt0 jt0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (jt0Var = this.e) != null) {
            jt0Var.a(z);
        }
    }

    public void G(int i) {
        dt0 dt0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (dt0Var = this.d) != null) {
            dt0Var.a(i);
        }
    }

    @Override // com.baidu.tieba.nt0
    public void b(vu0 vu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vu0Var) == null) {
            super.b(vu0Var);
            if (InteractiveEvent.ACTION_INTERACTIVE_START.equals(vu0Var.c())) {
                B();
            } else if (InteractiveEvent.ACTION_INTERACTIVE_FINISH.equals(vu0Var.c())) {
                C();
            }
        }
    }
}
