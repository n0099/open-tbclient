package com.baidu.tieba;

import android.os.Environment;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.tieba.vu2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes5.dex */
public class d92 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static vu2.g a(ww2 ww2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ww2Var)) == null) {
            File file = new File(Environment.getExternalStorageDirectory() + "/" + e92.d());
            vu2.M(file, b(), ww2Var);
            ds4.j(file);
            vu2.g gVar = new vu2.g();
            File file2 = new File(b(), "app.json");
            SwanAppConfigData c = SwanAppConfigData.c(ds4.E(file2), b());
            gVar.a = b().getPath() + File.separator;
            gVar.b = c;
            z82.k("ADBDebugBundleHelper", "configFile path: " + file2.getPath() + " exist: " + file2.exists() + " info.mAppBundlePath path: " + gVar.a);
            return gVar;
        }
        return (vu2.g) invokeL.objValue;
    }

    public static File b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_adb_debug");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_adb_debug";
        }
        return (String) invokeV.objValue;
    }
}
