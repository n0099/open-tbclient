package com.baidu.tieba;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bc3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) {
            switch (i) {
                case 2001:
                    return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f01e6);
                case 2002:
                    return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f01e8);
                case 2003:
                    return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f01e5);
                case 2004:
                    return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f01e9);
                case 2005:
                default:
                    return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f01e6);
                case 2006:
                    return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f01e7);
                case 2007:
                    return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f01e4);
            }
        }
        return (String) invokeI.objValue;
    }
}
