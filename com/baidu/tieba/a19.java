package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a19 extends sr9 {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId e1;
    public transient /* synthetic */ FieldHolder $fh;
    public o05 b1;
    public o05 c1;
    public o05 d1;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947562464, "Lcom/baidu/tieba/a19;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947562464, "Lcom/baidu/tieba/a19;");
                return;
            }
        }
        e1 = BdUniqueId.gen();
    }

    public a19() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.sr9, com.baidu.tieba.rn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return e1;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public boolean s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            o05 o05Var = this.b1;
            if (o05Var != null && !StringUtils.isNull(o05Var.b)) {
                return true;
            }
            o05 o05Var2 = this.c1;
            if (o05Var2 != null && !StringUtils.isNull(o05Var2.b)) {
                return true;
            }
            o05 o05Var3 = this.d1;
            if (o05Var3 != null) {
                return !StringUtils.isNull(o05Var3.b);
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
