package com.baidu.tieba.flutter.base.hotreload;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.idlefish.flutterboost.FlutterBoost;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.PluginRegistry;
/* loaded from: classes10.dex */
public class FlutterHotReload {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1623260491, "Lcom/baidu/tieba/flutter/base/hotreload/FlutterHotReload;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1623260491, "Lcom/baidu/tieba/flutter/base/hotreload/FlutterHotReload;");
        }
    }

    public FlutterHotReload() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean changePlugin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            FlutterEngine engineProvider = FlutterBoost.instance().engineProvider();
            if (engineProvider == null || engineProvider.getPlugins() == null) {
                return false;
            }
            PluginRegistry plugins = engineProvider.getPlugins();
            try {
                Class<?> cls = Class.forName("com.baidu.networkinfo.NetworkinfoPlugin");
                if (plugins.has(cls)) {
                    plugins.remove((Class<? extends FlutterPlugin>) cls);
                    return true;
                }
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return true;
            }
        }
        return invokeV.booleanValue;
    }
}
