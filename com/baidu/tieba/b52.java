package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.tieba.qq2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes3.dex */
public class b52 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public static final String b;
    public static final String c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947595882, "Lcom/baidu/tieba/b52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947595882, "Lcom/baidu/tieba/b52;");
                return;
            }
        }
        a = "__localDebug__" + File.separator + "master.js";
        b = "__localDebug__" + File.separator + "main.js";
        c = "__localDebug__" + File.separator + "slave.js";
    }

    public static qq2.g a(rs2 rs2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, rs2Var)) == null) {
            File d = d();
            d52.e().f("unzipstart");
            qq2.M(b(), d, rs2Var);
            d52.e().f("unzipend");
            qq2.g gVar = new qq2.g();
            File file = new File(d, "app.json");
            SwanAppConfigData b2 = g83.b(d.getAbsolutePath());
            gVar.a = d.getPath() + File.separator;
            gVar.b = b2;
            u42.k("LocalDebugBundleHelper", "configFile path: " + file.getPath() + " exist: " + file.exists() + " info.mAppBundlePath path: " + gVar.a);
            return gVar;
        }
        return (qq2.g) invokeL.objValue;
    }

    public static File b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new File(c(), "local_debug.swan");
        }
        return (File) invokeV.objValue;
    }

    public static File c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_local_debug_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeV.objValue;
    }

    public static File d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_local_debug");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return d() + File.separator + a;
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return d() + File.separator + c;
        }
        return (String) invokeV.objValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return new File(AppRuntime.getAppContext().getFilesDir(), "swan_local_debug").exists();
        }
        return invokeV.booleanValue;
    }
}
