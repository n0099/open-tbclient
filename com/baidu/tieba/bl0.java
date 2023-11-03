package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.yk0;
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
public class bl0 extends qe0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.qe0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "reward" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements yk0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h71 a;

        public a(bl0 bl0Var, h71 h71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bl0Var, h71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h71Var;
        }
    }

    public bl0() {
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

    @Override // com.baidu.tieba.qe0
    public boolean b(@NonNull Context context, @NonNull ue0 ue0Var, @Nullable Map<String, Object> map, @Nullable ye0 ye0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ue0Var, map, ye0Var)) == null) {
            super.b(context, ue0Var, map, ye0Var);
            String str = ue0Var.d().get("task_params");
            if (TextUtils.isEmpty(str)) {
                c(ye0Var, ue0Var, 202, false);
                return true;
            }
            HashMap<String, String> e = e(str);
            if (e != null && !e.isEmpty()) {
                if (TextUtils.isEmpty(e.get("android_pid")) && hj0.b().a().a("reward_sdk_switch", 0) != 1) {
                    c(ye0Var, ue0Var, 202, false);
                    return true;
                }
                String str2 = e.get("android_pid");
                e.remove("android_pid");
                e.remove("ios_pid");
                h71 h71Var = new h71(context);
                h71Var.e(context.getString(R.string.nad_reward_video_lp_task_loading));
                h71Var.c(false);
                h71Var.d(false);
                l11.b(h71Var);
                dl0 dl0Var = new dl0(e);
                yk0 yk0Var = (yk0) ServiceManager.getService(yk0.a);
                if (yk0Var != null && hj0.b().a().a("reward_sdk_switch", 0) == 1) {
                    yk0Var.a(f(str), new a(this, h71Var));
                    return true;
                }
                dl0Var.e(h71Var, str2);
                c(ye0Var, ue0Var, 0, true);
                return true;
            }
            c(ye0Var, ue0Var, 202, false);
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

    @Nullable
    public final JSONObject f(@Nullable String str) {
        InterceptResult invokeL;
        qn0 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("ext_policy");
                if (TextUtils.isEmpty(optString)) {
                    a2 = qn0.e();
                } else {
                    a2 = qn0.a(new JSONObject(optString));
                }
                if (a2 != null) {
                    a2.c = "1";
                    jSONObject.putOpt("ext_policy", qn0.f(a2).toString());
                    jSONObject.putOpt(AdExtParam.KEY_NAD_CORE_VERSION, "5.12.0.110");
                }
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }
}
