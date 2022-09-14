package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class ee1<T> implements ge1<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<T> a;
    public ce1<List<T>> b;
    public ce1<List<T>> c;

    public ee1() {
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

    public static ee1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new ee1() : (ee1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ge1
    public void a(ce1<List<T>> ce1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ce1Var) == null) {
            this.b = ce1Var;
            this.a = null;
        }
    }

    @Override // com.baidu.tieba.ge1
    public List<T> getList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<T> list = this.a;
            if (list != null) {
                return list;
            }
            ce1<List<T>> ce1Var = this.b;
            if (ce1Var != null) {
                List<T> list2 = ce1Var.get();
                this.a = list2;
                return list2;
            }
            ce1<List<T>> ce1Var2 = this.c;
            if (ce1Var2 != null) {
                return ce1Var2.get();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }
}
