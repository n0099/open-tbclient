package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class au0 extends mu0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public du0 d;
    public ju0 e;
    public iu0 f;
    public eu0 g;
    public cu0 h;

    public au0() {
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
        iu0 iu0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (iu0Var = this.f) != null) {
            iu0Var.b();
        }
    }

    public void C() {
        iu0 iu0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (iu0Var = this.f) != null) {
            iu0Var.a();
        }
    }

    @Override // com.baidu.tieba.mu0, com.baidu.tieba.nu0
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
        cu0 cu0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (cu0Var = this.h) != null) {
            cu0Var.a(z, z2);
        }
    }

    public void F(int i, int i2) {
        eu0 eu0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) && (eu0Var = this.g) != null) {
            eu0Var.a(i, i2);
        }
    }

    public void E(boolean z) {
        ju0 ju0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (ju0Var = this.e) != null) {
            ju0Var.a(z);
        }
    }

    public void G(int i) {
        du0 du0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (du0Var = this.d) != null) {
            du0Var.a(i);
        }
    }

    @Override // com.baidu.tieba.nu0
    public void b(vv0 vv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vv0Var) == null) {
            super.b(vv0Var);
            if (InteractiveEvent.ACTION_INTERACTIVE_START.equals(vv0Var.c())) {
                B();
            } else if (InteractiveEvent.ACTION_INTERACTIVE_FINISH.equals(vv0Var.c())) {
                C();
            }
        }
    }
}
