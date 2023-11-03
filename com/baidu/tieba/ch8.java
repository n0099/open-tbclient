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
/* loaded from: classes5.dex */
public class ch8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ThreadData> a;

    public ch8() {
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

    public ah8 a(boolean z, yg8 yg8Var) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048576, this, z, yg8Var)) == null) {
            ah8 ah8Var = new ah8();
            ah8Var.c = yg8Var.i();
            ah8Var.e = yg8Var.a();
            ah8Var.f = yg8Var.c();
            ArrayList<ThreadData> h = yg8Var.h();
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
            xf8.e(true, arrayList, yg8Var.e());
            xf8.e(true, arrayList, yg8Var.f());
            xf8.e(true, arrayList, yg8Var.d());
            xf8.e(true, arrayList, yg8Var.g());
            ah8Var.a = xf8.c(arrayList);
            return ah8Var;
        }
        return (ah8) invokeZL.objValue;
    }
}
