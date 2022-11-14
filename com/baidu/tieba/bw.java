package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes3.dex */
public final class bw {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, aw> a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized aw a(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, context)) == null) {
            synchronized (bw.class) {
                if (TextUtils.isEmpty(str)) {
                    str = context.getPackageName() + "_preferences";
                }
                if (a == null) {
                    a = new HashMap<>();
                }
                if (a.get(str) != null) {
                    return a.get(str);
                }
                aw awVar = new aw(str);
                a.put(str, awVar);
                return awVar;
            }
        }
        return (aw) invokeLL.objValue;
    }
}
