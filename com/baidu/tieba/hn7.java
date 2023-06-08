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
/* loaded from: classes6.dex */
public class hn7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PriorityOrganizer a;
    public final PriorityOrganizer.Task b;
    public cn7 c;
    public zm7 d;
    public an7 e;
    public dn7 f;
    public en7 g;
    public bn7 h;
    public in7 i;
    public jn7 j;
    public gn7 k;
    public fn7 l;

    public hn7(FrsActivity frsActivity, FrsFragment frsFragment) {
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
        this.c = new cn7(frsActivity, frsFragment);
        this.d = new zm7(frsActivity, frsFragment);
        this.e = new an7(frsActivity, frsFragment);
        this.f = new dn7(frsActivity, frsFragment);
        this.g = new en7(frsActivity, frsFragment);
        this.h = new bn7(frsActivity, frsFragment);
        this.i = new in7(frsActivity, frsFragment);
        this.j = new jn7(frsActivity, frsFragment);
        this.k = new gn7(frsActivity, frsFragment);
        fn7 fn7Var = new fn7(frsActivity, frsFragment);
        this.l = fn7Var;
        cn7 cn7Var = this.c;
        PriorityOrganizer.t(cn7Var, this.d, this.e, fn7Var, this.f, this.g, this.h, this.i, this.j, this.k);
        this.b = cn7Var;
    }

    public void a(boolean z) {
        en7 en7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (en7Var = this.g) != null) {
            en7Var.F(z);
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
