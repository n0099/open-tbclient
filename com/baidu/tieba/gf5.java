package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class gf5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Inject(force = false)
    public final pk1<ef5> a;

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            nk1 b = nk1.b();
            this.a = b;
            b.a(new ff5());
        }
    }

    public gf5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b();
    }

    public final we5 a(String schema) {
        InterceptResult invokeL;
        List<ef5> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, schema)) == null) {
            Intrinsics.checkNotNullParameter(schema, "schema");
            pk1<ef5> pk1Var = this.a;
            if (pk1Var != null && (list = pk1Var.getList()) != null) {
                for (ef5 ef5Var : list) {
                    we5 a = ef5Var.a(schema);
                    if (a.b()) {
                        return a;
                    }
                }
            }
            return new we5();
        }
        return (we5) invokeL.objValue;
    }
}
