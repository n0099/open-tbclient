package com.baidu.tbadk.plugins;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class PluginCheckUtil$Status {
    public static final /* synthetic */ PluginCheckUtil$Status[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PluginCheckUtil$Status Disabled;
    public static final PluginCheckUtil$Status Downloading;
    public static final PluginCheckUtil$Status Installed;
    public static final PluginCheckUtil$Status Installing;
    public static final PluginCheckUtil$Status UnInstalled;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-370039926, "Lcom/baidu/tbadk/plugins/PluginCheckUtil$Status;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-370039926, "Lcom/baidu/tbadk/plugins/PluginCheckUtil$Status;");
                return;
            }
        }
        UnInstalled = new PluginCheckUtil$Status("UnInstalled", 0);
        Downloading = new PluginCheckUtil$Status("Downloading", 1);
        Installing = new PluginCheckUtil$Status("Installing", 2);
        Installed = new PluginCheckUtil$Status("Installed", 3);
        PluginCheckUtil$Status pluginCheckUtil$Status = new PluginCheckUtil$Status("Disabled", 4);
        Disabled = pluginCheckUtil$Status;
        $VALUES = new PluginCheckUtil$Status[]{UnInstalled, Downloading, Installing, Installed, pluginCheckUtil$Status};
    }

    public PluginCheckUtil$Status(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static PluginCheckUtil$Status valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PluginCheckUtil$Status) Enum.valueOf(PluginCheckUtil$Status.class, str) : (PluginCheckUtil$Status) invokeL.objValue;
    }

    public static PluginCheckUtil$Status[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PluginCheckUtil$Status[]) $VALUES.clone() : (PluginCheckUtil$Status[]) invokeV.objValue;
    }
}
