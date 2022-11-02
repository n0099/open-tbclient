package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes3.dex */
public class do0 extends ji0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ji0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "reward" : (String) invokeV.objValue;
    }

    public do0() {
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

    @Override // com.baidu.tieba.ji0
    public boolean b(@NonNull Context context, @NonNull ni0 ni0Var, @Nullable Map<String, Object> map, @Nullable ri0 ri0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ni0Var, map, ri0Var)) == null) {
            super.b(context, ni0Var, map, ri0Var);
            String str = ni0Var.d().get("task_params");
            if (TextUtils.isEmpty(str)) {
                c(ri0Var, ni0Var, 202, false);
                return true;
            }
            HashMap<String, String> e = e(str);
            if (e != null && !e.isEmpty() && !TextUtils.isEmpty(e.get("android_pid"))) {
                e.remove("android_pid");
                e.remove("ios_pid");
                d71 d71Var = new d71(context);
                d71Var.e(context.getString(R.string.obfuscated_res_0x7f0f0c20));
                d71Var.c(false);
                d71Var.d(false);
                fo0 fo0Var = new fo0(e);
                g31.b(d71Var);
                fo0Var.e(d71Var, e.get("android_pid"));
                c(ri0Var, ni0Var, 0, true);
                return true;
            }
            c(ri0Var, ni0Var, 202, false);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Nullable
    public final HashMap<String, String> e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                HashMap<String, String> hashMap = new HashMap<>();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.optString(next));
                }
                return hashMap;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (HashMap) invokeL.objValue;
    }
}
