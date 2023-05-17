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
public class bi7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PriorityOrganizer a;
    public final PriorityOrganizer.Task b;
    public wh7 c;
    public th7 d;
    public uh7 e;
    public xh7 f;
    public yh7 g;
    public vh7 h;
    public ci7 i;
    public di7 j;
    public ai7 k;
    public zh7 l;

    public bi7(FrsActivity frsActivity, FrsFragment frsFragment) {
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
        this.a = PriorityOrganizer.n();
        this.c = new wh7(frsActivity, frsFragment);
        this.d = new th7(frsActivity, frsFragment);
        this.e = new uh7(frsActivity, frsFragment);
        this.f = new xh7(frsActivity, frsFragment);
        this.g = new yh7(frsActivity, frsFragment);
        this.h = new vh7(frsActivity, frsFragment);
        this.i = new ci7(frsActivity, frsFragment);
        this.j = new di7(frsActivity, frsFragment);
        this.k = new ai7(frsActivity, frsFragment);
        zh7 zh7Var = new zh7(frsActivity, frsFragment);
        this.l = zh7Var;
        wh7 wh7Var = this.c;
        PriorityOrganizer.t(wh7Var, this.d, this.e, zh7Var, this.f, this.g, this.h, this.i, this.j, this.k);
        this.b = wh7Var;
    }

    public void a(boolean z) {
        yh7 yh7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (yh7Var = this.g) != null) {
            yh7Var.F(z);
        }
    }

    public void b() {
        PriorityOrganizer.Task task;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !LooperBlockSwitch.getIsOn() && (task = this.b) != null && !task.v(true)) {
            this.b.E(true);
            this.a.z(this.b);
        }
    }
}
