package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.switchs.LooperBlockSwitch;
import com.baidu.tbadk.util.PriorityOrganizer;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class as7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PriorityOrganizer a;
    public final PriorityOrganizer.Task b;
    public vr7 c;
    public sr7 d;
    public tr7 e;
    public wr7 f;
    public xr7 g;
    public ur7 h;
    public bs7 i;
    public cs7 j;
    public zr7 k;
    public yr7 l;

    public as7(FrsActivity frsActivity, FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsActivity, frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = PriorityOrganizer.o();
        this.c = new vr7(frsActivity, frsFragment);
        this.d = new sr7(frsActivity, frsFragment);
        this.e = new tr7(frsActivity, frsFragment);
        this.f = new wr7(frsActivity, frsFragment);
        this.g = new xr7(frsActivity, frsFragment);
        this.h = new ur7(frsActivity, frsFragment);
        this.i = new bs7(frsActivity, frsFragment);
        this.j = new cs7(frsActivity, frsFragment);
        this.k = new zr7(frsActivity, frsFragment);
        yr7 yr7Var = new yr7(frsActivity, frsFragment);
        this.l = yr7Var;
        vr7 vr7Var = this.c;
        PriorityOrganizer.u(vr7Var, this.d, this.e, yr7Var, this.f, this.g, this.h, this.i, this.j, this.k);
        this.b = vr7Var;
    }

    public void a(boolean z) {
        xr7 xr7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (xr7Var = this.g) != null) {
            xr7Var.F(z);
        }
    }

    public void b() {
        PriorityOrganizer.Task task;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !LooperBlockSwitch.getIsOn() && (task = this.b) != null && !task.v(true)) {
            this.b.E(true);
            this.a.A(this.b);
        }
    }
}
