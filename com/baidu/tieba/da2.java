package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.gp2;
import com.baidu.tieba.jp2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes5.dex */
public class da2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947697748, "Lcom/baidu/tieba/da2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947697748, "Lcom/baidu/tieba/da2;");
                return;
            }
        }
        a = vm1.a;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return e(str, "swan_sub_package_zip");
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return e(str, "swan_sub_package_zip");
        }
        return (String) invokeL.objValue;
    }

    public static boolean f(List<kf4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return false;
            }
            return list.get(0).r;
        }
        return invokeL.booleanValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            return a(gp2.e.i(str, str2).getPath());
        }
        return (String) invokeLL.objValue;
    }

    public static String d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            File a2 = sp2.g().a(str, str2);
            if (a2 != null) {
                return c(a2.getPath());
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static String e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                File file = new File(str, str2);
                if (file.exists()) {
                    return file.getPath();
                }
                if (file.mkdirs()) {
                    return file.getPath();
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean g(kf4 kf4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, kf4Var)) == null) {
            if (kf4Var != null && !TextUtils.isEmpty(kf4Var.o)) {
                return h(new File(kf4Var.a), new File(gp2.e.i(kf4Var.o, String.valueOf(kf4Var.i)).getPath(), kf4Var.p));
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean h(File file, File file2) {
        InterceptResult invokeLL;
        boolean U;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, file, file2)) == null) {
            if (file != null && file2 != null) {
                if (!file.exists()) {
                    if (a) {
                        Log.e("SubPkgDownloadUtil", "解压分包时，ZIP包不存在 zipFile=" + file);
                    }
                    return false;
                } else if (!file2.exists() && !file2.mkdirs()) {
                    if (a) {
                        Log.e("SubPkgDownloadUtil", "创建分包解压文件夹失败 unzipFolder=" + file2);
                    }
                    return false;
                } else {
                    jp2.c j = jp2.j(file);
                    int i = j.b;
                    if (i != -1) {
                        U = jp2.d(j.a, file2, i).a;
                    } else {
                        U = nm4.U(file.getAbsolutePath(), file2.getAbsolutePath());
                    }
                    if (U) {
                        if (a) {
                            Log.i("SubPkgDownloadUtil", "分包解压成功");
                            return true;
                        }
                        return true;
                    } else if (a) {
                        Log.e("SubPkgDownloadUtil", "分包解压文件失败, file:" + file.getAbsolutePath() + " folder:" + file2.getAbsolutePath());
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
