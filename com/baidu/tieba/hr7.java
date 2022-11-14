package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hr7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, th)) == null) {
            if (th == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder(th.toString());
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null) {
                for (int i = 0; i < stackTrace.length; i++) {
                    StackTraceElement stackTraceElement = stackTrace[i];
                    if (stackTraceElement != null && i < 7) {
                        sb.append(" ----> ");
                        sb.append(stackTraceElement.getClassName());
                        sb.append(".");
                        sb.append(stackTraceElement.getMethodName());
                        sb.append("()");
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
