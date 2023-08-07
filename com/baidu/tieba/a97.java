package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.ComponentFactory;
/* loaded from: classes5.dex */
public final class a97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(List<ComponentFactory> componentList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, componentList)) == null) {
            Intrinsics.checkNotNullParameter(componentList, "componentList");
            for (ComponentFactory componentFactory : componentList) {
                if (componentFactory.feed_video != null) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
