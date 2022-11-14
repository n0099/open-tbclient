package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c18 extends PostData {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId Z0;
    public transient /* synthetic */ FieldHolder $fh;
    public wt4 W0;
    public wt4 X0;
    public wt4 Y0;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947622015, "Lcom/baidu/tieba/c18;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947622015, "Lcom/baidu/tieba/c18;");
                return;
            }
        }
        Z0 = BdUniqueId.gen();
    }

    public c18() {
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

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.tieba.xn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return Z0;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public boolean m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            wt4 wt4Var = this.W0;
            if (wt4Var != null && !StringUtils.isNull(wt4Var.b)) {
                return true;
            }
            wt4 wt4Var2 = this.X0;
            if (wt4Var2 != null && !StringUtils.isNull(wt4Var2.b)) {
                return true;
            }
            wt4 wt4Var3 = this.Y0;
            if (wt4Var3 != null && !StringUtils.isNull(wt4Var3.b)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
