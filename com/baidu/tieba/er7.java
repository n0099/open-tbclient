package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.util.PriorityOrganizer;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class er7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zq7 a;
    public wq7 b;
    public xq7 c;
    public ar7 d;
    public br7 e;
    public yq7 f;
    public fr7 g;
    public gr7 h;
    public dr7 i;
    public cr7 j;

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public er7(FrsActivity frsActivity, FrsFragment frsFragment) {
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
        PriorityOrganizer.create();
        this.a = new zq7(frsActivity, frsFragment);
        this.b = new wq7(frsActivity, frsFragment);
        this.c = new xq7(frsActivity, frsFragment);
        this.d = new ar7(frsActivity, frsFragment);
        this.e = new br7(frsActivity, frsFragment);
        this.f = new yq7(frsActivity, frsFragment);
        this.g = new fr7(frsActivity, frsFragment);
        this.h = new gr7(frsActivity, frsFragment);
        this.i = new dr7(frsActivity, frsFragment);
        cr7 cr7Var = new cr7(frsActivity, frsFragment);
        this.j = cr7Var;
        PriorityOrganizer.makeChain(this.a, this.b, this.c, cr7Var, this.d, this.e, this.f, this.g, this.h, this.i);
    }

    public void a(boolean z) {
        br7 br7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (br7Var = this.e) != null) {
            br7Var.a(z);
        }
    }
}
