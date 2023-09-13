package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.uc7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class et6 implements uc7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public et6() {
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

    @Override // com.baidu.tieba.tc7
    public String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return uc7.a.b(this);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tc7
    public Map<String, String> a(f87 f87Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, f87Var)) == null) {
            return uc7.a.a(this, f87Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.uc7
    public String c(f87 businessInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, businessInfo)) == null) {
            Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
            if (Intrinsics.areEqual(businessInfo.a().get("card_head_type"), "live_user")) {
                return "live_user_head_click";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }
}
