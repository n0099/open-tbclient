package com.baidu.tieba;

import android.os.Environment;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.Channels;
/* loaded from: classes5.dex */
public class fh2 extends ch2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public File b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947764057, "Lcom/baidu/tieba/fh2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947764057, "Lcom/baidu/tieba/fh2;");
                return;
            }
        }
        c = rr1.a;
    }

    public fh2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = o();
    }

    @Override // com.baidu.tieba.ch2
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!this.b.exists()) {
                return null;
            }
            File file = new File(this.b, "preset_list.json");
            if (!file.exists()) {
                return null;
            }
            return lr4.E(file);
        }
        return (String) invokeV.objValue;
    }

    public final File o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return new File(Environment.getExternalStorageDirectory().getPath(), "baidu/swan_preset/");
        }
        return (File) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ch2
    public boolean e(dh2 dh2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dh2Var)) == null) {
            if (dh2Var == null || !this.b.exists()) {
                return false;
            }
            File file = this.b;
            File file2 = new File(file, dh2Var.g + File.separator + dh2Var.q);
            if (!file2.exists()) {
                return false;
            }
            try {
                if (!d(Channels.newChannel(new FileInputStream(file2)), dh2Var.m)) {
                    if (c) {
                        Log.e("SdCardPresetController", "校验签名失败");
                    }
                    return false;
                }
                File j = j(dh2Var.h, dh2Var.g, dh2Var.i);
                if (j == null) {
                    if (c) {
                        Log.e("SdCardPresetController", "获取解压路径失败");
                    }
                    return false;
                }
                return n(new BufferedInputStream(new FileInputStream(file2)), j);
            } catch (IOException e) {
                if (c) {
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
            if (!this.b.exists()) {
                return null;
            }
            File file = this.b;
            File file2 = new File(file, str + File.separator + "app_info.json");
            if (!file2.exists()) {
                return null;
            }
            return lr4.E(file2);
        }
        return (String) invokeL.objValue;
    }
}
