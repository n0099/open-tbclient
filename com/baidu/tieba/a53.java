package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a53 implements c53 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String b;
    public Set<String> c;

    public a53() {
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
        this.b = "boxjs.";
        this.c = Sets.newHashSet("getAppInfoSync", "performpanel", "statisticEvent", "ubcReport", "getSlaveIdSync", "ubcFlowJar");
    }

    @Override // com.baidu.tieba.c53
    public List<o43> a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            ArrayList arrayList = new ArrayList();
            String optString = jSONObject.optString("apiName");
            c("api-name " + optString);
            if (TextUtils.isEmpty(optString)) {
                return arrayList;
            }
            int optInt = jSONObject.optInt("count");
            c("api-count " + optInt);
            if (optInt <= 0) {
                return arrayList;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("startTime");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("endTime");
            if (optJSONArray != null && optJSONArray2 != null) {
                int min = Math.min(optJSONArray.length(), optJSONArray2.length());
                if (min <= 0) {
                    return arrayList;
                }
                for (int i = 0; i < min; i++) {
                    o43 o43Var = new o43();
                    o43Var.f(optString);
                    o43Var.g(b(o43Var));
                    o43Var.i(optJSONArray.optLong(i));
                    o43Var.h(optJSONArray2.optLong(i));
                    arrayList.add(o43Var);
                    if (c53.a) {
                        c(o43Var.toString());
                    }
                }
                return arrayList;
            }
            c("startTimes or endTimes is empty");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final int b(o43 o43Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o43Var)) == null) {
            String a = o43Var.a();
            if (TextUtils.isEmpty(a)) {
                return 0;
            }
            if (!a.startsWith(this.b) && !this.c.contains(a)) {
                return 0;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && c53.a) {
            Log.d("Api-Parser", str);
        }
    }
}
