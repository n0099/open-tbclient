package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.RewardMaterial;
/* loaded from: classes5.dex */
public class cz4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public boolean c;
    public boolean d;

    public cz4() {
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

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public static cz4 e(JSONObject jSONObject) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            cz4 cz4Var = new cz4();
            cz4Var.a = jSONObject.optString("icon");
            cz4Var.b = jSONObject.optString("unlock_level");
            boolean z2 = false;
            if (jSONObject.optInt("is_matched") == 1) {
                z = true;
            } else {
                z = false;
            }
            cz4Var.c = z;
            if (jSONObject.optInt("is_newest_matched_level") == 1) {
                z2 = true;
            }
            cz4Var.d = z2;
            return cz4Var;
        }
        return (cz4) invokeL.objValue;
    }

    public static cz4 f(RewardMaterial rewardMaterial) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, rewardMaterial)) == null) {
            if (rewardMaterial == null) {
                return null;
            }
            cz4 cz4Var = new cz4();
            cz4Var.a = rewardMaterial.icon;
            cz4Var.b = rewardMaterial.unlock_level;
            boolean z2 = false;
            if (rewardMaterial.is_matched.intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            cz4Var.c = z;
            if (rewardMaterial.is_newest_matched_level.intValue() == 1) {
                z2 = true;
            }
            cz4Var.d = z2;
            return cz4Var;
        }
        return (cz4) invokeL.objValue;
    }
}
