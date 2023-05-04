package com.baidu.tieba;

import android.app.Application;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class dy9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            tx9.b();
        }
    }

    public static final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                d().deleteSharedPreferences(AccountConstants.LOGOUT_TYPE_NATIVE_SRC_SETTINGS);
            } else {
                f55.m().d();
            }
        }
    }

    public static final Application d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return ey9.a();
        }
        return (Application) invokeV.objValue;
    }

    public static final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return rx9.a();
        }
        return (String) invokeV.objValue;
    }

    public static final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String cacheDir = FileHelper.getCacheDir();
            Intrinsics.checkNotNullExpressionValue(cacheDir, "getCacheDir()");
            return cacheDir;
        }
        return (String) invokeV.objValue;
    }

    public static final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return zx9.a();
        }
        return invokeV.intValue;
    }

    public static final boolean c(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, file)) == null) {
            return FileHelper.deleteFileOrDir(file);
        }
        return invokeL.booleanValue;
    }

    public static final File g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            File GetFileByAbsolutePath = FileHelper.GetFileByAbsolutePath(str);
            Intrinsics.checkNotNullExpressionValue(GetFileByAbsolutePath, "GetFileByAbsolutePath(filePath)");
            return GetFileByAbsolutePath;
        }
        return (File) invokeL.objValue;
    }
}
