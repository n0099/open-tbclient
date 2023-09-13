package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class hf5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Inject(force = false)
    public final pk1<if5> a;

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            nk1 b = nk1.b();
            this.a = b;
            b.a(new jf5());
        }
    }

    public hf5() {
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
        a();
    }

    public final void b(JSONObject json) {
        List<if5> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, json) == null) {
            Intrinsics.checkNotNullParameter(json, "json");
            pk1<if5> pk1Var = this.a;
            if (pk1Var != null && (list = pk1Var.getList()) != null) {
                for (if5 if5Var : list) {
                    if5Var.parseJson(json);
                }
            }
        }
    }
}
