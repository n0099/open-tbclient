package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class h48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ThreadData> a;

    public h48() {
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

    public List<ThreadData> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<ThreadData> list = this.a;
            if (list == null) {
                return false;
            }
            return !ListUtils.isEmpty(list);
        }
        return invokeV.booleanValue;
    }

    public f48 a(boolean z, d48 d48Var) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048576, this, z, d48Var)) == null) {
            f48 f48Var = new f48();
            f48Var.c = d48Var.i();
            f48Var.e = d48Var.a();
            f48Var.f = d48Var.c();
            ArrayList<ThreadData> h = d48Var.h();
            if (z) {
                if (!ListUtils.isEmpty(h)) {
                    this.a.clear();
                    this.a.addAll(h);
                }
            } else if (!ListUtils.isEmpty(h)) {
                this.a.addAll(h);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.a);
            c38.e(true, arrayList, d48Var.e());
            c38.e(true, arrayList, d48Var.f());
            c38.e(true, arrayList, d48Var.d());
            c38.e(true, arrayList, d48Var.g());
            f48Var.a = c38.c(arrayList);
            return f48Var;
        }
        return (f48) invokeZL.objValue;
    }
}
