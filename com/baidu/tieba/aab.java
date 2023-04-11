package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class aab {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "Empty";
            }
            String[] split = str.split("\\?");
            if (split.length > 0) {
                return split[0];
            }
            return V8ExceptionInfo.V8_EXCEPTION_ERROR;
        }
        return (String) invokeL.objValue;
    }
}
