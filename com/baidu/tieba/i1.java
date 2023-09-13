package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.e1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class i1<T, P extends e1<T>> extends h1<T, P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void c(g1 g1Var, String str, d3 d3Var, P p);

    public abstract T d(g1 g1Var, String str, d3 d3Var, P p);

    public void e(g1 g1Var, String str, d3 d3Var, P p) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, g1Var, str, d3Var, p) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i1(l1 l1Var) {
        super(l1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((l1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
