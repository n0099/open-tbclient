package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tracker.Tracker;
import com.baidu.tieba.tracker.core.data.EventParams;
import com.baidu.tieba.tracker.core.data.IEventNode;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class aza {
    public static /* synthetic */ Interceptable $ic;
    public static final aza a;
    public static int b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947633857, "Lcom/baidu/tieba/aza;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947633857, "Lcom/baidu/tieba/aza;");
                return;
            }
        }
        a = new aza();
    }

    public aza() {
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

    public final boolean a(IEventNode events) {
        InterceptResult invokeL;
        IEventNode endNode;
        EventParams trackParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, events)) == null) {
            Intrinsics.checkNotNullParameter(events, "events");
            int i = b;
            if (i == 1) {
                return true;
            }
            if (i != 2 || (endNode = events.getEndNode()) == null || (trackParams = endNode.getTrackParams()) == null) {
                return false;
            }
            String valueOf = String.valueOf(trackParams.get("page"));
            if (Tracker.i.a().j().contains(valueOf)) {
                return true;
            }
            if (!Tracker.i.a().i().contains(valueOf) && Tracker.i.a().h()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            b = i;
        }
    }
}
