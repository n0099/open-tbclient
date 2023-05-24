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
public class ci7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PriorityOrganizer a;
    public final PriorityOrganizer.Task b;
    public xh7 c;
    public uh7 d;
    public vh7 e;
    public yh7 f;
    public zh7 g;
    public wh7 h;
    public di7 i;
    public ei7 j;
    public bi7 k;
    public ai7 l;

    public ci7(FrsActivity frsActivity, FrsFragment frsFragment) {
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
        this.c = new xh7(frsActivity, frsFragment);
        this.d = new uh7(frsActivity, frsFragment);
        this.e = new vh7(frsActivity, frsFragment);
        this.f = new yh7(frsActivity, frsFragment);
        this.g = new zh7(frsActivity, frsFragment);
        this.h = new wh7(frsActivity, frsFragment);
        this.i = new di7(frsActivity, frsFragment);
        this.j = new ei7(frsActivity, frsFragment);
        this.k = new bi7(frsActivity, frsFragment);
        ai7 ai7Var = new ai7(frsActivity, frsFragment);
        this.l = ai7Var;
        xh7 xh7Var = this.c;
        PriorityOrganizer.t(xh7Var, this.d, this.e, ai7Var, this.f, this.g, this.h, this.i, this.j, this.k);
        this.b = xh7Var;
    }

    public void a(boolean z) {
        zh7 zh7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (zh7Var = this.g) != null) {
            zh7Var.F(z);
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
