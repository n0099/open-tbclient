package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class hc1<T> implements jc1<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<T> a;
    public fc1<List<T>> b;
    public fc1<List<T>> c;

    public hc1() {
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

    public static hc1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new hc1() : (hc1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jc1
    public void a(fc1<List<T>> fc1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fc1Var) == null) {
            this.b = fc1Var;
            this.a = null;
        }
    }

    @Override // com.baidu.tieba.jc1
    public List<T> getList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<T> list = this.a;
            if (list != null) {
                return list;
            }
            fc1<List<T>> fc1Var = this.b;
            if (fc1Var != null) {
                List<T> list2 = fc1Var.get();
                this.a = list2;
                return list2;
            }
            fc1<List<T>> fc1Var2 = this.c;
            if (fc1Var2 != null) {
                return fc1Var2.get();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }
}
