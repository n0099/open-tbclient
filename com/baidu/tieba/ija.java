package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import com.baidu.tieba.tracker.Monitor;
import com.baidu.tieba.tracker.core.data.EventParams;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class ija {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(Fragment fragment, String pid, Pair<String, String>... params) {
        jja jjaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, fragment, pid, params) == null) {
            Intrinsics.checkNotNullParameter(fragment, "<this>");
            Intrinsics.checkNotNullParameter(pid, "pid");
            Intrinsics.checkNotNullParameter(params, "params");
            fja<jja> b = Monitor.a.b(pid);
            if (fragment instanceof jja) {
                jjaVar = (jja) fragment;
            } else {
                jjaVar = null;
            }
            if (jjaVar != null && b != null) {
                b.b((Pair[]) Arrays.copyOf(params, params.length));
            }
        }
    }

    public static final void c(Fragment fragment, String pid, Pair<String, ? extends Object>... params) {
        jja jjaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, fragment, pid, params) == null) {
            Intrinsics.checkNotNullParameter(fragment, "<this>");
            Intrinsics.checkNotNullParameter(pid, "pid");
            Intrinsics.checkNotNullParameter(params, "params");
            fja<jja> a = Monitor.a.a(fragment, pid);
            if (fragment instanceof jja) {
                jjaVar = (jja) fragment;
            } else {
                jjaVar = null;
            }
            if (jjaVar != null) {
                a.e(jjaVar, 20000L).fillTrackParams(new EventParams((Pair[]) Arrays.copyOf(params, params.length)));
            }
        }
    }

    public static final void e(Fragment fragment, String pid, Pair<String, String>... params) {
        jja jjaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, fragment, pid, params) == null) {
            Intrinsics.checkNotNullParameter(fragment, "<this>");
            Intrinsics.checkNotNullParameter(pid, "pid");
            Intrinsics.checkNotNullParameter(params, "params");
            fja<jja> b = Monitor.a.b(pid);
            if (fragment instanceof jja) {
                jjaVar = (jja) fragment;
            } else {
                jjaVar = null;
            }
            if (jjaVar != null && b != null) {
                b.f((Pair[]) Arrays.copyOf(params, params.length));
            }
        }
    }

    public static final void b(Fragment fragment, Pair<String, String>... params) {
        jja jjaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, fragment, params) == null) {
            Intrinsics.checkNotNullParameter(fragment, "<this>");
            Intrinsics.checkNotNullParameter(params, "params");
            if (fragment instanceof jja) {
                jjaVar = (jja) fragment;
            } else {
                jjaVar = null;
            }
            if (jjaVar != null) {
                a(fragment, jjaVar.getTraceId(), (Pair[]) Arrays.copyOf(params, params.length));
            }
        }
    }

    public static final void d(Fragment fragment, Pair<String, ? extends Object>... params) {
        jja jjaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, fragment, params) == null) {
            Intrinsics.checkNotNullParameter(fragment, "<this>");
            Intrinsics.checkNotNullParameter(params, "params");
            if (fragment instanceof jja) {
                jjaVar = (jja) fragment;
            } else {
                jjaVar = null;
            }
            if (jjaVar != null) {
                c(fragment, jjaVar.getTraceId(), (Pair[]) Arrays.copyOf(params, params.length));
            }
        }
    }

    public static final void f(Fragment fragment, Pair<String, String>... params) {
        jja jjaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, fragment, params) == null) {
            Intrinsics.checkNotNullParameter(fragment, "<this>");
            Intrinsics.checkNotNullParameter(params, "params");
            if (fragment instanceof jja) {
                jjaVar = (jja) fragment;
            } else {
                jjaVar = null;
            }
            if (jjaVar != null) {
                e(fragment, jjaVar.getTraceId(), (Pair[]) Arrays.copyOf(params, params.length));
            }
        }
    }
}
