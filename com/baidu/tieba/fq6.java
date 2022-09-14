package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.util.PriorityOrganizer;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PriorityOrganizer a;
    public yp6 b;
    public zp6 c;
    public bq6 d;
    public cq6 e;
    public aq6 f;
    public gq6 g;
    public hq6 h;
    public dq6 i;
    public eq6 j;

    public fq6(FrsActivity frsActivity, FrsFragment frsFragment) {
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
        this.b = new yp6(frsActivity, frsFragment);
        this.c = new zp6(frsActivity, frsFragment);
        this.d = new bq6(frsActivity, frsFragment);
        this.e = new cq6(frsActivity, frsFragment);
        this.f = new aq6(frsActivity, frsFragment);
        this.g = new gq6(frsActivity, frsFragment);
        this.h = new hq6(frsActivity, frsFragment);
        this.i = new dq6(frsActivity, frsFragment);
        eq6 eq6Var = new eq6(frsActivity, frsFragment);
        this.j = eq6Var;
        PriorityOrganizer.s(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, eq6Var);
    }

    public void a(boolean z) {
        cq6 cq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (cq6Var = this.e) == null) {
            return;
        }
        cq6Var.H(z);
    }

    public void b() {
        yp6 yp6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (yp6Var = this.b) == null || yp6Var.w(true)) {
            return;
        }
        this.b.F(true);
        this.a.v(this.b);
    }
}
