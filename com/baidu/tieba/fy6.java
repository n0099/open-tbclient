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
/* loaded from: classes4.dex */
public class fy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ThreadData> a;
    public bs7 b;

    public fy6() {
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

    public final void a(h67 h67Var) {
        bs7 bs7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, h67Var) == null) && (bs7Var = this.b) != null && !ListUtils.isEmpty(bs7Var.b)) {
            h67Var.a.add(0, this.b);
        }
    }

    public h67 b(int i, boolean z, ey6 ey6Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), ey6Var})) == null) {
            h67 h67Var = new h67();
            h67Var.c = ey6Var.f();
            h67Var.e = ey6Var.a();
            h67Var.f = ey6Var.b();
            ArrayList<ThreadData> e = ey6Var.e();
            if (z) {
                this.b = ey6Var.d();
                if (!ListUtils.isEmpty(e)) {
                    this.a.clear();
                    this.a.addAll(e);
                    h67Var.d = 1;
                }
            } else if (!ListUtils.isEmpty(e)) {
                this.a.addAll(e);
                h67Var.d = i + 1;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.a);
            e57.h(true, arrayList, ey6Var.c());
            h67Var.a = e57.c(arrayList);
            a(h67Var);
            bs7 bs7Var = this.b;
            if (bs7Var != null && bs7Var.a && TbSingleton.getInstance().isShouldShowHomeLocalCompleteInfoCard()) {
                h67Var.a.add(0, new e67());
            }
            return h67Var;
        }
        return (h67) invokeCommon.objValue;
    }
}
