package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class bl1<T> implements dl1<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<T> a;
    public zk1<List<T>> b;
    public zk1<List<T>> c;

    public bl1() {
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

    public static bl1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new bl1();
        }
        return (bl1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dl1
    public List<T> getList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<T> list = this.a;
            if (list != null) {
                return list;
            }
            zk1<List<T>> zk1Var = this.b;
            if (zk1Var != null) {
                List<T> list2 = zk1Var.get();
                this.a = list2;
                return list2;
            }
            zk1<List<T>> zk1Var2 = this.c;
            if (zk1Var2 != null) {
                return zk1Var2.get();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dl1
    public void a(zk1<List<T>> zk1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zk1Var) == null) {
            this.b = zk1Var;
            this.a = null;
        }
    }
}
