package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class f67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final e67 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            boolean z = false;
            int optInt = jSONObject.optInt("text_id", 0);
            String info = jSONObject.optString("text_info");
            if ((info == null || info.length() == 0) ? true : true) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(info, "info");
            return new e67(optInt, info);
        }
        return (e67) invokeL.objValue;
    }
}
