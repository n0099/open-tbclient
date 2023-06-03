package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.nu5;
import com.baidu.tieba.ou5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class gv5<Q extends nu5, P extends ou5> extends fv5 implements jv5<P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void i(BdUniqueId bdUniqueId);

    public abstract void j(nt5 nt5Var);

    public gv5() {
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
}
