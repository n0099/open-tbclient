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
public class fn7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PriorityOrganizer a;
    public final PriorityOrganizer.Task b;
    public an7 c;
    public xm7 d;
    public ym7 e;
    public bn7 f;
    public cn7 g;
    public zm7 h;
    public gn7 i;
    public hn7 j;
    public en7 k;
    public dn7 l;

    public fn7(FrsActivity frsActivity, FrsFragment frsFragment) {
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
        this.a = PriorityOrganizer.m();
        this.c = new an7(frsActivity, frsFragment);
        this.d = new xm7(frsActivity, frsFragment);
        this.e = new ym7(frsActivity, frsFragment);
        this.f = new bn7(frsActivity, frsFragment);
        this.g = new cn7(frsActivity, frsFragment);
        this.h = new zm7(frsActivity, frsFragment);
        this.i = new gn7(frsActivity, frsFragment);
        this.j = new hn7(frsActivity, frsFragment);
        this.k = new en7(frsActivity, frsFragment);
        dn7 dn7Var = new dn7(frsActivity, frsFragment);
        this.l = dn7Var;
        an7 an7Var = this.c;
        PriorityOrganizer.t(an7Var, this.d, this.e, dn7Var, this.f, this.g, this.h, this.i, this.j, this.k);
        this.b = an7Var;
    }

    public void a(boolean z) {
        cn7 cn7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (cn7Var = this.g) != null) {
            cn7Var.F(z);
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
