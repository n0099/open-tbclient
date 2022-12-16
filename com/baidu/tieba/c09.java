package com.baidu.tieba;

import android.os.Environment;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class c09 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "databases";
    public static final String b = "shared_prefs";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947621085, "Lcom/baidu/tieba/c09;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947621085, "Lcom/baidu/tieba/c09;");
        }
    }

    public static final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            c(j09.f());
            e();
            d();
            j09.a();
        }
    }

    public static final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            a();
            f();
            h();
            g();
        }
    }

    public static final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (Intrinsics.areEqual("mounted", Environment.getExternalStorageState()) && j09.c(j09.d().getExternalCacheDir())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return j09.c(j09.d().getCacheDir());
        }
        return invokeV.booleanValue;
    }

    public static final boolean f() {
        InterceptResult invokeV;
        String parent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            File filesDir = j09.d().getFilesDir();
            if (filesDir == null) {
                parent = null;
            } else {
                parent = filesDir.getParent();
            }
            return j09.c(new File(parent, a));
        }
        return invokeV.booleanValue;
    }

    public static final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return j09.c(j09.d().getFilesDir());
        }
        return invokeV.booleanValue;
    }

    public static final boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return j09.c(j09.g(str));
        }
        return invokeL.booleanValue;
    }

    public static final boolean h() {
        InterceptResult invokeV;
        String parent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            File filesDir = j09.d().getFilesDir();
            if (filesDir == null) {
                parent = null;
            } else {
                parent = filesDir.getParent();
            }
            boolean c = j09.c(new File(parent, b));
            if (c) {
                j09.b();
            }
            return c;
        }
        return invokeV.booleanValue;
    }
}
