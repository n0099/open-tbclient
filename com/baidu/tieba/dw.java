package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.security.DeviceInfoManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dw {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public boolean b;
    public boolean c;
    public boolean d;

    public dw() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!this.d) {
                return false;
            }
            if (!this.c) {
                this.c = c();
            }
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (DeviceInfoManager.INSTANCE.getHarmonyVersion(AppRuntime.getAppContext(), "pub_param", "").errorCode == 3) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!this.b) {
                StringBuilder sb = new StringBuilder();
                if (DeviceUtils.isHarmonyOS(AppRuntime.getAppContext())) {
                    this.d = true;
                    String str = DeviceInfoManager.INSTANCE.getHarmonyVersion(AppRuntime.getAppContext(), "pub_param", "").deviceId;
                    if (TextUtils.isEmpty(str)) {
                        str = com.baidu.mobads.sdk.internal.cj.d;
                    }
                    sb.append("HMS");
                    sb.append("_");
                    sb.append(str);
                }
                this.a = sb.toString();
                this.b = true;
            }
            return this.a;
        }
        return (String) invokeV.objValue;
    }
}
