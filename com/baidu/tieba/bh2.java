package com.baidu.tieba;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
/* loaded from: classes5.dex */
public class bh2 extends ch2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947644893, "Lcom/baidu/tieba/bh2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947644893, "Lcom/baidu/tieba/bh2;");
                return;
            }
        }
        b = rr1.a;
        c = "swan_preset" + File.separator + "preset_list.json";
    }

    public bh2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.ch2
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return sn3.b(ou2.c(), c);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ch2
    public boolean e(dh2 dh2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dh2Var)) == null) {
            if (dh2Var == null) {
                return false;
            }
            Context appContext = AppRuntime.getAppContext();
            String str = "swan_preset" + File.separator + dh2Var.g + File.separator + dh2Var.q;
            try {
                File j = j(dh2Var.h, dh2Var.g, dh2Var.i);
                if (j == null) {
                    if (b) {
                        Log.e("AssetPresetController", "获取解压路径失败");
                    }
                    return false;
                }
                return n(new BufferedInputStream(appContext.getAssets().open(str)), j);
            } catch (IOException e) {
                if (b) {
                    e.printStackTrace();
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ch2
    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            Application c2 = ou2.c();
            return sn3.b(c2, "swan_preset" + File.separator + str + File.separator + "app_info.json");
        }
        return (String) invokeL.objValue;
    }
}
