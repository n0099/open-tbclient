package com.baidu.tieba;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmStatic;
/* loaded from: classes5.dex */
public final class b16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947592162, "Lcom/baidu/tieba/b16;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947592162, "Lcom/baidu/tieba/b16;");
        }
    }

    @JvmStatic
    public static final Lifecycle a(Context context) {
        InterceptResult invokeL;
        Context context2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context instanceof MutableContextWrapper) {
                context2 = ((MutableContextWrapper) context).getBaseContext();
            } else {
                context2 = context;
            }
            if (context2 instanceof FragmentActivity) {
                return ((FragmentActivity) context2).getLifecycle();
            }
            if (!GlobalBuildConfig.isDebug()) {
                return null;
            }
            throw new IllegalStateException("context isn't FragmentActivity:" + context);
        }
        return (Lifecycle) invokeL.objValue;
    }

    @JvmStatic
    public static final void b(View view2, Context context) {
        Context context2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, view2, context) == null) {
            if (view2 != null) {
                context2 = view2.getContext();
            } else {
                context2 = null;
            }
            if (context2 instanceof MutableContextWrapper) {
                ((MutableContextWrapper) context2).setBaseContext(context);
            } else if (!GlobalBuildConfig.isDebug()) {
            } else {
                throw new IllegalStateException("context can't replace :" + context2);
            }
        }
    }
}
