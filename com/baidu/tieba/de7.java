package com.baidu.tieba;

import com.baidu.tieba.forum.model.FrsGeneralTabListResMsg;
import com.baidu.tieba.forum.model.FrsPageHttpResponseMessage;
import com.baidu.tieba.forum.model.FrsThreadListHttpResponseMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class de7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947701747, "Lcom/baidu/tieba/de7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947701747, "Lcom/baidu/tieba/de7;");
        }
    }

    public de7() {
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
        FrsPageHttpResponseMessage.Companion.a(new xh7());
        FrsThreadListHttpResponseMessage.Companion.a(new yh7());
        FrsGeneralTabListResMsg.Companion.a(new vh7());
        j87 j87Var = s67.a().get("feed");
        if (j87Var instanceof d87) {
            ((d87) j87Var).i().add(uh7.a);
        }
    }
}
