package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.PrintStream;
/* loaded from: classes4.dex */
public class g89 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (TbadkCoreApplication.getInst().isDebugMode() || zw4.h()) {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                if (stackTrace.length < 5) {
                    return;
                }
                StackTraceElement stackTraceElement = stackTrace[4];
                String methodName = stackTraceElement.getMethodName();
                String className = stackTraceElement.getClassName();
                PrintStream printStream = System.out;
                printStream.println("MainTabLog:" + className + ":" + methodName + ":" + str);
            }
        }
    }
}
