package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/* loaded from: classes5.dex */
public final class h8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Class a(String str) throws ReflectionException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            try {
                return Class.forName(str);
            } catch (ClassNotFoundException e) {
                throw new ReflectionException("Class not found: " + str, e);
            }
        }
        return (Class) invokeL.objValue;
    }

    public static j8[] d(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cls)) == null) {
            Field[] declaredFields = cls.getDeclaredFields();
            j8[] j8VarArr = new j8[declaredFields.length];
            int length = declaredFields.length;
            for (int i = 0; i < length; i++) {
                j8VarArr[i] = new j8(declaredFields[i]);
            }
            return j8VarArr;
        }
        return (j8[]) invokeL.objValue;
    }

    public static String e(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls)) == null) {
            return cls.getSimpleName();
        }
        return (String) invokeL.objValue;
    }

    public static boolean g(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, cls)) == null) {
            return cls.isMemberClass();
        }
        return invokeL.booleanValue;
    }

    public static boolean h(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, cls)) == null) {
            return Modifier.isStatic(cls.getModifiers());
        }
        return invokeL.booleanValue;
    }

    public static i8 b(Class cls, Class... clsArr) throws ReflectionException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cls, clsArr)) == null) {
            try {
                return new i8(cls.getConstructor(clsArr));
            } catch (NoSuchMethodException e) {
                throw new ReflectionException("Constructor not found for class: " + cls.getName(), e);
            } catch (SecurityException e2) {
                throw new ReflectionException("Security violation occurred while getting constructor for class: '" + cls.getName() + "'.", e2);
            }
        }
        return (i8) invokeLL.objValue;
    }

    public static i8 c(Class cls, Class... clsArr) throws ReflectionException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, cls, clsArr)) == null) {
            try {
                return new i8(cls.getDeclaredConstructor(clsArr));
            } catch (NoSuchMethodException e) {
                throw new ReflectionException("Constructor not found for class: " + cls.getName(), e);
            } catch (SecurityException e2) {
                throw new ReflectionException("Security violation while getting constructor for class: " + cls.getName(), e2);
            }
        }
        return (i8) invokeLL.objValue;
    }

    public static boolean f(Class cls, Class cls2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, cls, cls2)) == null) {
            return cls.isAssignableFrom(cls2);
        }
        return invokeLL.booleanValue;
    }

    public static <T> T i(Class<T> cls) throws ReflectionException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, cls)) == null) {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException e) {
                throw new ReflectionException("Could not instantiate instance of class: " + cls.getName(), e);
            } catch (InstantiationException e2) {
                throw new ReflectionException("Could not instantiate instance of class: " + cls.getName(), e2);
            }
        }
        return (T) invokeL.objValue;
    }
}
