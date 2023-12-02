package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cva implements pi {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId g;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public boolean f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947689595, "Lcom/baidu/tieba/cva;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947689595, "Lcom/baidu/tieba/cva;");
                return;
            }
        }
        g = BdUniqueId.gen();
    }

    public cva() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = false;
    }

    @Override // com.baidu.tieba.pi
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return g;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public static boolean a(@NonNull cva cvaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cvaVar)) == null) {
            if (!TextUtils.isEmpty(cvaVar.a) && !TextUtils.isEmpty(cvaVar.c) && !TextUtils.isEmpty(cvaVar.b) && !TextUtils.isEmpty(cvaVar.e) && !TextUtils.isEmpty(cvaVar.d)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public static cva b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            cva cvaVar = new cva();
            cvaVar.a = jSONObject.optString("forum_id");
            cvaVar.c = jSONObject.optString("forum_name");
            cvaVar.b = jSONObject.optString("avatar");
            cvaVar.e = jSONObject.optString("slogan");
            cvaVar.d = jSONObject.optString("desc");
            return cvaVar;
        }
        return (cva) invokeL.objValue;
    }
}
