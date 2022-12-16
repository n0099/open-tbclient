package com.baidu.tieba;

import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes3.dex */
public class a15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            synchronized (a15.class) {
                File file = new File(FileHelper.getCacheDir() + "voice");
                if (file.exists() && file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles == null) {
                        return;
                    }
                    for (File file2 : listFiles) {
                        file2.delete();
                    }
                }
            }
        }
    }

    public static boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            return FileHelper.renameTo(str, FileHelper.getFilePath(str2, 1, true));
        }
        return invokeLL.booleanValue;
    }

    public static z05 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            z05 z05Var = new z05();
            if (str == null) {
                z05Var.f(6);
                z05Var.g(z05.a(z05Var.b()));
                return z05Var;
            }
            if (!FileHelper.CheckTempDir(FileHelper.getCacheDir() + "voice")) {
                z05Var.f(7);
                z05Var.g(z05.a(z05Var.b()));
                return z05Var;
            }
            String b = fj.b(FileHelper.GetStreamFromTmpFile(str));
            if (b == null) {
                z05Var.f(5);
                z05Var.g(z05.a(z05Var.b()));
            } else {
                String filePath = FileHelper.getFilePath(b, 1, true);
                if (FileHelper.renameTo(str, filePath)) {
                    z05Var.i(filePath);
                    z05Var.h(b);
                } else {
                    z05Var.f(1);
                    z05Var.g(z05.a(z05Var.b()));
                }
            }
            return z05Var;
        }
        return (z05) invokeL.objValue;
    }
}
