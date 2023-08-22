package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/* loaded from: classes6.dex */
public class gc1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"DiscouragedPrivateApi"})
    public static void a(Activity activity, ec1 ec1Var) {
        Class<?>[] declaredClasses;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, activity, ec1Var) == null) {
            try {
                Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(activity, new Object[0]);
                Class<?> cls = null;
                for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
                    if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                        cls = cls2;
                    }
                }
                Object newProxyInstance = Proxy.newProxyInstance(Activity.class.getClassLoader(), new Class[]{cls}, new hc1(ec1Var));
                Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", cls, ActivityOptions.class);
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(activity, newProxyInstance, invoke);
            } catch (Throwable unused) {
                if (ec1Var != null) {
                    ec1Var.onTranslucent(false);
                }
            }
        }
    }

    public static void b(Activity activity, ec1 ec1Var) {
        Class<?>[] declaredClasses;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, activity, ec1Var) == null) {
            try {
                Class<?> cls = null;
                for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
                    if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                        cls = cls2;
                    }
                }
                Method declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", cls);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(activity, null);
                if (ec1Var != null) {
                    ec1Var.onTranslucent(true);
                }
            } catch (Throwable unused) {
                if (ec1Var != null) {
                    ec1Var.onTranslucent(false);
                }
            }
        }
    }

    public static Drawable e(Context context, String str) {
        InterceptResult invokeLL;
        Bitmap decodeFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str) || (decodeFile = BitmapFactory.decodeFile(str)) == null) {
                return null;
            }
            byte[] ninePatchChunk = decodeFile.getNinePatchChunk();
            if (NinePatch.isNinePatchChunk(ninePatchChunk)) {
                return new NinePatchDrawable(context.getResources(), decodeFile, ninePatchChunk, new Rect(), null);
            }
            return new BitmapDrawable(context.getResources(), decodeFile);
        }
        return (Drawable) invokeLL.objValue;
    }

    public static void c(Activity activity, ec1 ec1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, activity, ec1Var) == null) {
            try {
                Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(activity, new Object[0]);
                if (ec1Var != null) {
                    ec1Var.onTranslucent(false);
                }
            } catch (Throwable unused) {
                if (ec1Var != null) {
                    ec1Var.onTranslucent(true);
                }
            }
        }
    }

    public static void d(Activity activity, ec1 ec1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, activity, ec1Var) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    a(activity, ec1Var);
                } else {
                    b(activity, ec1Var);
                }
            } catch (Throwable unused) {
                if (ec1Var != null) {
                    ec1Var.onTranslucent(false);
                }
            }
        }
    }
}
