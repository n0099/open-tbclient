package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.kp5;
import com.baidu.tieba.lp5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class dq5<Q extends kp5, P extends lp5> extends cq5 implements gq5<P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h(BdUniqueId bdUniqueId);

    public abstract void i(ko5 ko5Var);

    public dq5() {
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
