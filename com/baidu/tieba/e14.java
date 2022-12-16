package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Singleton
@Service
/* loaded from: classes4.dex */
public class e14 implements jl1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e14() {
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

    @Override // com.baidu.tieba.jl1
    public List<b63> a(b53 b53Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, b53Var)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new uz3(b53Var));
            arrayList.add(new vz3(b53Var));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.baidu.tieba.jl1
    public List<b63> c(b53 b53Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b53Var)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new n44(b53Var));
            arrayList.add(new m44(b53Var));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.baidu.tieba.jl1
    public List<b63> b(b53 b53Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b53Var)) == null) {
            return Arrays.asList(new h04(b53Var), new wy3(b53Var), new fz3(b53Var), new sz3(b53Var));
        }
        return (List) invokeL.objValue;
    }
}
