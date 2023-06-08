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
/* loaded from: classes5.dex */
public class g79 extends jy9 {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId e1;
    public transient /* synthetic */ FieldHolder $fh;
    public n35 b1;
    public n35 c1;
    public n35 d1;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947746976, "Lcom/baidu/tieba/g79;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947746976, "Lcom/baidu/tieba/g79;");
                return;
            }
        }
        e1 = BdUniqueId.gen();
    }

    public g79() {
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

    @Override // com.baidu.tieba.jy9, com.baidu.tieba.vn
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
            n35 n35Var = this.b1;
            if (n35Var != null && !StringUtils.isNull(n35Var.b)) {
                return true;
            }
            n35 n35Var2 = this.c1;
            if (n35Var2 != null && !StringUtils.isNull(n35Var2.b)) {
                return true;
            }
            n35 n35Var3 = this.d1;
            if (n35Var3 != null) {
                return !StringUtils.isNull(n35Var3.b);
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
