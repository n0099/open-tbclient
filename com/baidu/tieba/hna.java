package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tracker.core.data.IEventNode;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class hna {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IEventNode a;

    public hna() {
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

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = null;
        }
    }

    public final IEventNode b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (IEventNode) invokeV.objValue;
    }

    public final hna c(IEventNode node) {
        InterceptResult invokeL;
        IEventNode iEventNode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, node)) == null) {
            Intrinsics.checkNotNullParameter(node, "node");
            IEventNode iEventNode2 = this.a;
            if (iEventNode2 == null) {
                this.a = node;
            } else {
                while (true) {
                    if (iEventNode2 != null) {
                        iEventNode = iEventNode2.getNext();
                    } else {
                        iEventNode = null;
                    }
                    if (iEventNode == null) {
                        break;
                    }
                    IEventNode iEventNode3 = this.a;
                    if (iEventNode3 != null) {
                        iEventNode2 = iEventNode3.getNext();
                    } else {
                        iEventNode2 = null;
                    }
                }
                if (iEventNode2 != null) {
                    iEventNode2.setNext(node);
                }
            }
            return this;
        }
        return (hna) invokeL.objValue;
    }
}
