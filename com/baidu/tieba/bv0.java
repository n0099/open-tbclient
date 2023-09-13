package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bv0 extends nv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ev0 d;
    public kv0 e;
    public jv0 f;
    public fv0 g;
    public dv0 h;

    public bv0() {
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
        jv0 jv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (jv0Var = this.f) != null) {
            jv0Var.b();
        }
    }

    public void C() {
        jv0 jv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (jv0Var = this.f) != null) {
            jv0Var.a();
        }
    }

    @Override // com.baidu.tieba.nv0, com.baidu.tieba.ov0
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
        dv0 dv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (dv0Var = this.h) != null) {
            dv0Var.a(z, z2);
        }
    }

    public void F(int i, int i2) {
        fv0 fv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) && (fv0Var = this.g) != null) {
            fv0Var.a(i, i2);
        }
    }

    public void E(boolean z) {
        kv0 kv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (kv0Var = this.e) != null) {
            kv0Var.a(z);
        }
    }

    public void G(int i) {
        ev0 ev0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (ev0Var = this.d) != null) {
            ev0Var.a(i);
        }
    }

    @Override // com.baidu.tieba.ov0
    public void b(ww0 ww0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ww0Var) == null) {
            super.b(ww0Var);
            if (InteractiveEvent.ACTION_INTERACTIVE_START.equals(ww0Var.c())) {
                B();
            } else if (InteractiveEvent.ACTION_INTERACTIVE_FINISH.equals(ww0Var.c())) {
                C();
            }
        }
    }
}
