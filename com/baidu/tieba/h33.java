package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h33 implements i33 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public h33() {
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

    @Override // com.baidu.tieba.i33
    public List<u23> a(JSONObject jSONObject) {
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
            JSONObject optJSONObject = jSONObject.optJSONObject("caller");
            if (optJSONObject == null) {
                return arrayList;
            }
            b(optString, optJSONObject.optJSONObject("swan"), arrayList, 0);
            b(optString, optJSONObject.optJSONObject("boxjs"), arrayList, 1);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void b(String str, @Nullable JSONObject jSONObject, @NonNull List<u23> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject, list, i) == null) && jSONObject != null && jSONObject.length() > 0) {
            JSONArray optJSONArray = jSONObject.optJSONArray("startTime");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("endTime");
            if (optJSONArray != null && optJSONArray2 != null) {
                int min = Math.min(optJSONArray.length(), optJSONArray2.length());
                for (int i2 = 0; i2 < min; i2++) {
                    u23 u23Var = new u23();
                    u23Var.g(i);
                    u23Var.f(str);
                    u23Var.i(optJSONArray.optLong(i2));
                    u23Var.h(optJSONArray2.optLong(i2));
                    list.add(u23Var);
                }
            }
        }
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && i33.a) {
            Log.d("Api-Parser", str);
        }
    }
}
