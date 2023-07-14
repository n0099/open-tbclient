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
/* loaded from: classes5.dex */
public final class dg5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Inject(force = false)
    public final dl1<bg5> a;

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            bl1 b = bl1.b();
            this.a = b;
            b.a(new cg5());
        }
    }

    public dg5() {
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

    public final uf5 a(String schema) {
        InterceptResult invokeL;
        List<bg5> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, schema)) == null) {
            Intrinsics.checkNotNullParameter(schema, "schema");
            dl1<bg5> dl1Var = this.a;
            if (dl1Var != null && (list = dl1Var.getList()) != null) {
                for (bg5 bg5Var : list) {
                    uf5 a = bg5Var.a(schema);
                    if (a.b()) {
                        return a;
                    }
                }
            }
            return new uf5();
        }
        return (uf5) invokeL.objValue;
    }
}
