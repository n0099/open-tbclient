package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class i31 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull Activity activity, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65536, null, activity, i) == null) || i == -1 || Build.VERSION.SDK_INT != 26 || activity.getApplicationInfo().targetSdkVersion <= 26 || !c(activity) || b(activity)) {
            return;
        }
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(activity);
            Field declaredField2 = ActivityInfo.class.getDeclaredField("screenOrientation");
            declaredField2.setAccessible(true);
            if (declaredField2.getInt(obj) == -1) {
                declaredField2.setInt(obj, i);
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static boolean b(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, activity)) == null) {
            try {
                Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(activity);
                Method declaredMethod = ActivityInfo.class.getDeclaredMethod("isFixedOrientation", new Class[0]);
                declaredMethod.setAccessible(true);
                return ((Boolean) declaredMethod.invoke(obj, new Object[0])).booleanValue();
            } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"PrivateApi"})
    public static boolean c(@NonNull Activity activity) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            try {
                Class<?> cls = Class.forName("com.android.internal.R$styleable");
                Field declaredField = cls.getDeclaredField("Window");
                declaredField.setAccessible(true);
                TypedArray obtainStyledAttributes = activity.obtainStyledAttributes((int[]) declaredField.get(null));
                Field declaredField2 = cls.getDeclaredField("Window_windowIsTranslucent");
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("Window_windowSwipeToDismiss");
                declaredField3.setAccessible(true);
                Field declaredField4 = cls.getDeclaredField("Window_windowIsFloating");
                declaredField4.setAccessible(true);
                Object obj = declaredField2.get(null);
                Object obj2 = declaredField3.get(null);
                if (obj instanceof Integer) {
                    z2 = obtainStyledAttributes.getBoolean(((Integer) obj).intValue(), false);
                    z = (obj2 instanceof Integer) && !obtainStyledAttributes.hasValue(((Integer) obj).intValue()) && obtainStyledAttributes.getBoolean(((Integer) obj2).intValue(), false);
                } else {
                    z = false;
                    z2 = false;
                }
                Object obj3 = declaredField4.get(null);
                boolean z3 = obj3 instanceof Integer ? obtainStyledAttributes.getBoolean(((Integer) obj3).intValue(), false) : false;
                obtainStyledAttributes.recycle();
                return z3 || z2 || z;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static int d(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, activity)) != null) {
            return invokeL.intValue;
        }
        int i = -1;
        if (Build.VERSION.SDK_INT != 26 || activity.getApplicationInfo().targetSdkVersion <= 26 || !c(activity) || !b(activity)) {
            return -1;
        }
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(activity);
            Field declaredField2 = ActivityInfo.class.getDeclaredField("screenOrientation");
            declaredField2.setAccessible(true);
            int i2 = declaredField2.getInt(obj);
            if (i2 != -1) {
                try {
                    declaredField2.setInt(obj, -1);
                } catch (IllegalAccessException e) {
                    e = e;
                    i = i2;
                    e.printStackTrace();
                    return i;
                } catch (NoSuchFieldException e2) {
                    e = e2;
                    i = i2;
                    e.printStackTrace();
                    return i;
                }
            }
            return i2;
        } catch (IllegalAccessException e3) {
            e = e3;
        } catch (NoSuchFieldException e4) {
            e = e4;
        }
    }
}
