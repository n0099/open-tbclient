package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.annotation.CallSuper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public interface cy8 {

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @CallSuper
        public static void a(cy8 cy8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65536, null, cy8Var) == null) {
            }
        }

        @CallSuper
        public static void b(cy8 cy8Var, int i, int i2, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{cy8Var, Integer.valueOf(i), Integer.valueOf(i2), intent}) == null) {
            }
        }

        @CallSuper
        public static void c(cy8 cy8Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(65538, null, cy8Var, z) == null) {
            }
        }

        @CallSuper
        public static void d(cy8 cy8Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(65539, null, cy8Var, i) == null) {
            }
        }

        @CallSuper
        public static boolean e(cy8 cy8Var, int i, KeyEvent event) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, cy8Var, i, event)) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                return false;
            }
            return invokeLIL.booleanValue;
        }

        @CallSuper
        public static void f(cy8 cy8Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(65541, null, cy8Var, z) == null) {
            }
        }

        @CallSuper
        public static void g(cy8 cy8Var, int i, String[] permissions, int[] grantResults) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(65542, null, cy8Var, i, permissions, grantResults) == null) {
                Intrinsics.checkNotNullParameter(permissions, "permissions");
                Intrinsics.checkNotNullParameter(grantResults, "grantResults");
            }
        }

        public static void h(cy8 cy8Var, Bundle outState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65543, null, cy8Var, outState) == null) {
                Intrinsics.checkNotNullParameter(outState, "outState");
            }
        }

        @CallSuper
        public static void i(cy8 cy8Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(65544, null, cy8Var, z) == null) {
            }
        }
    }
}
