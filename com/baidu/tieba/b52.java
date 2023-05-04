package com.baidu.tieba;

import android.os.Environment;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.tieba.tq2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes3.dex */
public class b52 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static tq2.g a(us2 us2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, us2Var)) == null) {
            File file = new File(Environment.getExternalStorageDirectory() + "/" + c52.d());
            tq2.M(file, b(), us2Var);
            bo4.j(file);
            tq2.g gVar = new tq2.g();
            File file2 = new File(b(), "app.json");
            SwanAppConfigData c = SwanAppConfigData.c(bo4.E(file2), b());
            gVar.a = b().getPath() + File.separator;
            gVar.b = c;
            x42.k("ADBDebugBundleHelper", "configFile path: " + file2.getPath() + " exist: " + file2.exists() + " info.mAppBundlePath path: " + gVar.a);
            return gVar;
        }
        return (tq2.g) invokeL.objValue;
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
