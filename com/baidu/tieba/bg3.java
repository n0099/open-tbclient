package com.baidu.tieba;

import com.baidu.tieba.ah3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes3.dex */
public class bg3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            List d = eo2.d();
            if (d != null && d.size() > 0) {
                File file = new File(((ah3.a) d.get(0)).a, "/debug/");
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file;
            }
            return null;
        }
        return (File) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new File(((ah3.a) eo2.d().get(0)).a, "/debug/").getAbsolutePath();
        }
        return (String) invokeV.objValue;
    }
}
