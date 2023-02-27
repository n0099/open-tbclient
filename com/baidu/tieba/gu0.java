package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class gu0 extends su0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ju0 d;
    public pu0 e;
    public ou0 f;
    public ku0 g;
    public iu0 h;

    public gu0() {
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
        ou0 ou0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (ou0Var = this.f) != null) {
            ou0Var.b();
        }
    }

    public void C() {
        ou0 ou0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (ou0Var = this.f) != null) {
            ou0Var.a();
        }
    }

    @Override // com.baidu.tieba.su0, com.baidu.tieba.tu0
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
        iu0 iu0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (iu0Var = this.h) != null) {
            iu0Var.a(z, z2);
        }
    }

    public void F(int i, int i2) {
        ku0 ku0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) && (ku0Var = this.g) != null) {
            ku0Var.a(i, i2);
        }
    }

    public void E(boolean z) {
        pu0 pu0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (pu0Var = this.e) != null) {
            pu0Var.a(z);
        }
    }

    public void G(int i) {
        ju0 ju0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (ju0Var = this.d) != null) {
            ju0Var.a(i);
        }
    }

    @Override // com.baidu.tieba.tu0
    public void b(bw0 bw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bw0Var) == null) {
            super.b(bw0Var);
            if (InteractiveEvent.ACTION_INTERACTIVE_START.equals(bw0Var.c())) {
                B();
            } else if (InteractiveEvent.ACTION_INTERACTIVE_FINISH.equals(bw0Var.c())) {
                C();
            }
        }
    }
}
