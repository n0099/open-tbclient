package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class fd2 extends wc2<JSONObject, v32> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public fd2() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ad2
    @NonNull
    /* renamed from: c */
    public v32 a(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            if (b()) {
                if (wc2.a) {
                    v82.b("Api-HandleException", "has triggered fmp before remove skeleton");
                }
                return new v32(0);
            } else if (jSONObject == null) {
                return new v32(202);
            } else {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    return new v32(202, "data is required");
                }
                String optString = optJSONObject.optString("path");
                if (TextUtils.isEmpty(optString)) {
                    return new v32(202, "path is required");
                }
                uc2 uc2Var = new uc2();
                uc2Var.g(optString);
                uc2Var.e();
                return new v32(0);
            }
        }
        return (v32) invokeL.objValue;
    }
}
