package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dv0 extends pv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gv0 d;
    public mv0 e;
    public lv0 f;
    public hv0 g;
    public fv0 h;

    public dv0() {
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
        lv0 lv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (lv0Var = this.f) != null) {
            lv0Var.b();
        }
    }

    public void C() {
        lv0 lv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (lv0Var = this.f) != null) {
            lv0Var.a();
        }
    }

    @Override // com.baidu.tieba.pv0, com.baidu.tieba.qv0
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
        fv0 fv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (fv0Var = this.h) != null) {
            fv0Var.a(z, z2);
        }
    }

    public void F(int i, int i2) {
        hv0 hv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) && (hv0Var = this.g) != null) {
            hv0Var.a(i, i2);
        }
    }

    public void E(boolean z) {
        mv0 mv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (mv0Var = this.e) != null) {
            mv0Var.a(z);
        }
    }

    public void G(int i) {
        gv0 gv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (gv0Var = this.d) != null) {
            gv0Var.a(i);
        }
    }

    @Override // com.baidu.tieba.qv0
    public void b(yw0 yw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, yw0Var) == null) {
            super.b(yw0Var);
            if (InteractiveEvent.ACTION_INTERACTIVE_START.equals(yw0Var.c())) {
                B();
            } else if (InteractiveEvent.ACTION_INTERACTIVE_FINISH.equals(yw0Var.c())) {
                C();
            }
        }
    }
}
