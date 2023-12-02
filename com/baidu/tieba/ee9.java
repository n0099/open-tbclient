package com.baidu.tieba;

import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.impersonal.data.MsgGuideInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class ee9 {
    public static /* synthetic */ Interceptable $ic;
    public static final ee9 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947731600, "Lcom/baidu/tieba/ee9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947731600, "Lcom/baidu/tieba/ee9;");
                return;
            }
        }
        a = new ee9();
    }

    public ee9() {
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

    public final MsgGuideInfo a(AbilityItem abilityItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, abilityItem)) == null) {
            Intrinsics.checkNotNullParameter(abilityItem, "abilityItem");
            AbilityItem.StyleConf styleConf = abilityItem.getStyleConf();
            if (styleConf != null) {
                return new MsgGuideInfo(styleConf.getContent(), styleConf.getSubContent());
            }
            return null;
        }
        return (MsgGuideInfo) invokeL.objValue;
    }
}
