package com.baidu.tieba.browser.core.statistics;

import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class HybridStatisticKey {
    public static final /* synthetic */ HybridStatisticKey[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final HybridStatisticKey KEY_OFFLINE_PACKAGE;
    public static final HybridStatisticKey KEY_RD_USE;
    public static final HybridStatisticKey KEY_UPDATE_OFFLINE_PACK;
    public transient /* synthetic */ FieldHolder $fh;
    public final String value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1053731327, "Lcom/baidu/tieba/browser/core/statistics/HybridStatisticKey;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1053731327, "Lcom/baidu/tieba/browser/core/statistics/HybridStatisticKey;");
                return;
            }
        }
        KEY_UPDATE_OFFLINE_PACK = new HybridStatisticKey("KEY_UPDATE_OFFLINE_PACK", 0, TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK);
        KEY_OFFLINE_PACKAGE = new HybridStatisticKey("KEY_OFFLINE_PACKAGE", 1, TbadkCoreStatisticKey.KEY_QUICK_WEBVIEW_LOCAL_URL);
        HybridStatisticKey hybridStatisticKey = new HybridStatisticKey("KEY_RD_USE", 2, CommonStatisticKey.KEY_RD_USE);
        KEY_RD_USE = hybridStatisticKey;
        $VALUES = new HybridStatisticKey[]{KEY_UPDATE_OFFLINE_PACK, KEY_OFFLINE_PACKAGE, hybridStatisticKey};
    }

    public HybridStatisticKey(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.value = str2;
    }

    public static HybridStatisticKey valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (HybridStatisticKey) Enum.valueOf(HybridStatisticKey.class, str);
        }
        return (HybridStatisticKey) invokeL.objValue;
    }

    public static HybridStatisticKey[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (HybridStatisticKey[]) $VALUES.clone();
        }
        return (HybridStatisticKey[]) invokeV.objValue;
    }

    public String getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.value;
        }
        return (String) invokeV.objValue;
    }
}
