package com.baidu.tbadk.switchs;

import b.a.q0.b.d;
import b.a.q0.s.e0.b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class LaunchUpPrefetchSwitch extends BaseNormalSwitch {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LAUNCH_UP_PREFETCH_ENABLE = "launch_up_prefetch";
    public static final int TYPE_OFF = 0;
    public static final int TYPE_ON = 1;
    public static final LaunchUpPrefetchSwitch mInstance;
    public static int type;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1117295953, "Lcom/baidu/tbadk/switchs/LaunchUpPrefetchSwitch;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1117295953, "Lcom/baidu/tbadk/switchs/LaunchUpPrefetchSwitch;");
                return;
            }
        }
        mInstance = new LaunchUpPrefetchSwitch();
        type = 3;
    }

    public LaunchUpPrefetchSwitch() {
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

    public static boolean getIsOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d.C()) {
                return false;
            }
            if (type > 1) {
                type = b.j().k("key_launch_up_prefetch", 1);
            }
            return type == 1;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, b.a.e.e.f.a
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? LAUNCH_UP_PREFETCH_ENABLE : (String) invokeV.objValue;
    }
}
