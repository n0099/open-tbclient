package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class aq0 extends mq0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dq0 d;
    public jq0 e;
    public iq0 f;
    public eq0 g;
    public cq0 h;

    public aq0() {
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
        iq0 iq0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iq0Var = this.f) == null) {
            return;
        }
        iq0Var.b();
    }

    public void C() {
        iq0 iq0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (iq0Var = this.f) == null) {
            return;
        }
        iq0Var.a();
    }

    public void D(boolean z, boolean z2) {
        cq0 cq0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (cq0Var = this.h) == null) {
            return;
        }
        cq0Var.a(z, z2);
    }

    public void E(boolean z) {
        jq0 jq0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (jq0Var = this.e) == null) {
            return;
        }
        jq0Var.a(z);
    }

    public void F(int i, int i2) {
        eq0 eq0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) || (eq0Var = this.g) == null) {
            return;
        }
        eq0Var.a(i, i2);
    }

    public void G(int i) {
        dq0 dq0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (dq0Var = this.d) == null) {
            return;
        }
        dq0Var.a(i);
    }

    @Override // com.baidu.tieba.nq0
    public void b(vr0 vr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vr0Var) == null) {
            super.b(vr0Var);
            if (InteractiveEvent.ACTION_INTERACTIVE_START.equals(vr0Var.c())) {
                B();
            } else if (InteractiveEvent.ACTION_INTERACTIVE_FINISH.equals(vr0Var.c())) {
                C();
            }
        }
    }

    @Override // com.baidu.tieba.mq0, com.baidu.tieba.nq0
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
}
