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
/* loaded from: classes6.dex */
public class h84 implements ms1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public h84() {
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

    @Override // com.baidu.tieba.ms1
    public List<ed3> a(ec3 ec3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ec3Var)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new x64(ec3Var));
            arrayList.add(new y64(ec3Var));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ms1
    public List<ed3> c(ec3 ec3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ec3Var)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new qb4(ec3Var));
            arrayList.add(new pb4(ec3Var));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ms1
    public List<ed3> b(ec3 ec3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ec3Var)) == null) {
            return Arrays.asList(new k74(ec3Var), new z54(ec3Var), new i64(ec3Var), new v64(ec3Var));
        }
        return (List) invokeL.objValue;
    }
}
