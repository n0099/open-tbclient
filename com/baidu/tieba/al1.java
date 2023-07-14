package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class al1<T> implements cl1<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public T a;
    public zk1<T> b;
    public zk1<T> c;

    public al1() {
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

    public static al1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new al1();
        }
        return (al1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cl1
    public T get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            T t = this.a;
            if (t != null) {
                return t;
            }
            zk1<T> zk1Var = this.b;
            if (zk1Var != null) {
                T t2 = zk1Var.get();
                this.a = t2;
                return t2;
            }
            zk1<T> zk1Var2 = this.c;
            if (zk1Var2 != null) {
                return zk1Var2.get();
            }
            return null;
        }
        return (T) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cl1
    public void a(zk1<T> zk1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zk1Var) == null) {
            this.b = zk1Var;
            this.a = null;
        }
    }
}
