package com.baidu.tieba;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ft6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ik6 a;
    public final FrsFragment b;
    public final cx6 c;
    public final ww6 d;
    public final FrsModelController e;
    public final ol6 f;
    public final ys6 g;

    public ft6(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (frsFragment != null) {
            this.b = frsFragment;
            this.d = frsFragment.q0();
            this.a = this.b.q1();
            this.c = this.b.G3();
            this.e = this.b.N0();
            this.f = this.b.B3();
            this.g = this.b.g1();
            return;
        }
        throw new NullPointerException("FrsActivity is NullPointerException");
    }
}
