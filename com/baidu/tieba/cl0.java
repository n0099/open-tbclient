package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.zk0;
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
/* loaded from: classes5.dex */
public class cl0 extends re0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.re0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "reward" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements zk0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k71 a;

        public a(cl0 cl0Var, k71 k71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cl0Var, k71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k71Var;
        }
    }

    public cl0() {
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

    @Override // com.baidu.tieba.re0
    public boolean b(@NonNull Context context, @NonNull ve0 ve0Var, @Nullable Map<String, Object> map, @Nullable ze0 ze0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ve0Var, map, ze0Var)) == null) {
            super.b(context, ve0Var, map, ze0Var);
            String str = ve0Var.d().get("task_params");
            if (TextUtils.isEmpty(str)) {
                c(ze0Var, ve0Var, 202, false);
                return true;
            }
            HashMap<String, String> f = f(str);
            if (f != null && !f.isEmpty()) {
                if (TextUtils.isEmpty(f.get("android_pid")) && ij0.b().a().a("reward_sdk_switch", 0) != 1) {
                    c(ze0Var, ve0Var, 202, false);
                    return true;
                }
                String str2 = f.get("android_pid");
                f.remove("android_pid");
                f.remove("ios_pid");
                k71 k71Var = new k71(context);
                k71Var.e(context.getString(R.string.nad_reward_video_lp_task_loading));
                k71Var.c(false);
                k71Var.d(false);
                o11.b(k71Var);
                el0 el0Var = new el0(f);
                zk0 zk0Var = (zk0) ServiceManager.getService(zk0.a);
                if (zk0Var != null && ij0.b().a().a("reward_sdk_switch", 0) == 1) {
                    zk0Var.a(g(str), new a(this, k71Var));
                    return true;
                }
                el0Var.e(k71Var, str2);
                c(ze0Var, ve0Var, 0, true);
                return true;
            }
            c(ze0Var, ve0Var, 202, false);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void e(JSONObject jSONObject) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            try {
                int i2 = 0;
                int i3 = 1;
                if (g21.a("nad_reward_sp", "key_is_new_session", 0) == 1) {
                    i = g21.a("nad_reward_sp", "key_session_count", 0) + 1;
                } else {
                    int a2 = g21.a("nad_reward_sp", "key_session_count", 1);
                    i3 = 1 + g21.a("nad_reward_sp", "key_in_session_count", 0);
                    i2 = g21.a("nad_reward_sp", "key_reward_count", 0);
                    i = a2;
                }
                jSONObject.put("session_id", i);
                jSONObject.put("session_reward", i2);
                jSONObject.put("session_refresh", i3);
            } catch (Exception unused) {
            }
        }
    }

    @Nullable
    public final HashMap<String, String> f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
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

    @Nullable
    public final JSONObject g(@Nullable String str) {
        InterceptResult invokeL;
        tn0 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("ext_policy");
                if (TextUtils.isEmpty(optString)) {
                    a2 = tn0.f();
                } else {
                    a2 = tn0.a(new JSONObject(optString));
                }
                if (a2 != null) {
                    a2.c = "1";
                    jSONObject.putOpt("ext_policy", tn0.g(a2).toString());
                    jSONObject.putOpt(AdExtParam.KEY_NAD_CORE_VERSION, "6.1.0.1");
                }
                e(jSONObject);
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }
}
