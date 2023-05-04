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
public class ez8 extends pp9 {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId e1;
    public transient /* synthetic */ FieldHolder $fh;
    public fz4 b1;
    public fz4 c1;
    public fz4 d1;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947751750, "Lcom/baidu/tieba/ez8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947751750, "Lcom/baidu/tieba/ez8;");
                return;
            }
        }
        e1 = BdUniqueId.gen();
    }

    public ez8() {
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

    @Override // com.baidu.tieba.pp9, com.baidu.tieba.in
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
            fz4 fz4Var = this.b1;
            if (fz4Var != null && !StringUtils.isNull(fz4Var.b)) {
                return true;
            }
            fz4 fz4Var2 = this.c1;
            if (fz4Var2 != null && !StringUtils.isNull(fz4Var2.b)) {
                return true;
            }
            fz4 fz4Var3 = this.d1;
            if (fz4Var3 != null) {
                return !StringUtils.isNull(fz4Var3.b);
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
