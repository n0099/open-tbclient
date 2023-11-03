package com.baidu.tieba;

import android.app.Activity;
import android.content.ComponentName;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
@JvmName(name = "PageUtil")
/* loaded from: classes5.dex */
public final class fn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(Activity activity) {
        InterceptResult invokeL;
        ComponentName componentName;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, activity)) == null) {
            if (activity != null) {
                componentName = activity.getComponentName();
            } else {
                componentName = null;
            }
            if (componentName == null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final boolean b(Activity activity, String activityClassName) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, activity, activityClassName)) == null) {
            Intrinsics.checkNotNullParameter(activityClassName, "activityClassName");
            if (!a(activity)) {
                Intrinsics.checkNotNull(activity);
                ComponentName componentName = activity.getComponentName();
                Intrinsics.checkNotNull(componentName);
                if (Intrinsics.areEqual(activityClassName, componentName.getClassName())) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
