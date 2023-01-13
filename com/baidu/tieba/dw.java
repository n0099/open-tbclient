package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class dw {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, cw> a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cw a(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, context)) == null) {
            synchronized (dw.class) {
                if (TextUtils.isEmpty(str)) {
                    str = context.getPackageName() + "_preferences";
                }
                if (a == null) {
                    a = new HashMap<>();
                }
                if (a.get(str) != null) {
                    return a.get(str);
                }
                cw cwVar = new cw(str);
                a.put(str, cwVar);
                return cwVar;
            }
        }
        return (cw) invokeLL.objValue;
    }
}
