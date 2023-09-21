package com.baidu.tieba.im.base.core.utility;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class ImChatLog {
    public static final /* synthetic */ ImChatLog[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ImChatLog INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbLog instance;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-412150907, "Lcom/baidu/tieba/im/base/core/utility/ImChatLog;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-412150907, "Lcom/baidu/tieba/im/base/core/utility/ImChatLog;");
                return;
            }
        }
        ImChatLog imChatLog = new ImChatLog("INSTANCE", 0);
        INSTANCE = imChatLog;
        $VALUES = new ImChatLog[]{imChatLog};
    }

    public static TbLog getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return INSTANCE.instance;
        }
        return (TbLog) invokeV.objValue;
    }

    public static ImChatLog[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (ImChatLog[]) $VALUES.clone();
        }
        return (ImChatLog[]) invokeV.objValue;
    }

    public ImChatLog(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.instance = new TbLog("default");
    }

    public static ImChatLog valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (ImChatLog) Enum.valueOf(ImChatLog.class, str);
        }
        return (ImChatLog) invokeL.objValue;
    }
}
