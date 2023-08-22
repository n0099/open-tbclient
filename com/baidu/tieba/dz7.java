package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class dz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ThreadData> a;
    public dc9 b;

    public dz7() {
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
        this.a = new ArrayList();
    }

    public List<ThreadData> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<ThreadData> list = this.a;
            if (list == null) {
                return false;
            }
            return !ListUtils.isEmpty(list);
        }
        return invokeV.booleanValue;
    }

    public final void a(e88 e88Var) {
        dc9 dc9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, e88Var) == null) && (dc9Var = this.b) != null && !ListUtils.isEmpty(dc9Var.b)) {
            e88Var.a.add(0, this.b);
        }
    }

    public e88 b(int i, boolean z, cz7 cz7Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), cz7Var})) == null) {
            e88 e88Var = new e88();
            e88Var.c = cz7Var.f();
            e88Var.e = cz7Var.a();
            e88Var.f = cz7Var.b();
            ArrayList<ThreadData> e = cz7Var.e();
            if (z) {
                this.b = cz7Var.d();
                if (!ListUtils.isEmpty(e)) {
                    this.a.clear();
                    this.a.addAll(e);
                    e88Var.d = 1;
                }
            } else if (!ListUtils.isEmpty(e)) {
                this.a.addAll(e);
                e88Var.d = i + 1;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.a);
            b78.e(true, arrayList, cz7Var.c());
            e88Var.a = b78.c(arrayList);
            a(e88Var);
            dc9 dc9Var = this.b;
            if (dc9Var != null && dc9Var.a && TbSingleton.getInstance().isShouldShowHomeLocalCompleteInfoCard()) {
                e88Var.a.add(0, new b88());
            }
            return e88Var;
        }
        return (e88) invokeCommon.objValue;
    }
}
