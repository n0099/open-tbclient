package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.common.security.PermissionStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class dm0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;

    public dm0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "";
        this.b = "";
        this.c = "";
    }

    @NonNull
    public static dm0 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            dm0 dm0Var = new dm0();
            JSONObject c = z21.c(str);
            dm0Var.a = c.optString(PermissionStorage.PermissionItem.ITEM_EXT_1);
            dm0Var.b = c.optString(PermissionStorage.PermissionItem.ITEM_EXT_2);
            dm0Var.c = c.optString(PermissionStorage.PermissionItem.ITEM_EXT_3);
            return dm0Var;
        }
        return (dm0) invokeL.objValue;
    }

    public static String b(@NonNull dm0 dm0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dm0Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PermissionStorage.PermissionItem.ITEM_EXT_1, dm0Var.a);
                jSONObject.put(PermissionStorage.PermissionItem.ITEM_EXT_2, dm0Var.b);
                jSONObject.put(PermissionStorage.PermissionItem.ITEM_EXT_3, dm0Var.c);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
