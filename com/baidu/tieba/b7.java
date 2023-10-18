package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class b7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final Field a(Class<?> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, cls, str)) == null) {
            Field field = null;
            while (cls != Object.class && field == null) {
                try {
                    field = cls.getDeclaredField(str);
                } catch (NoSuchFieldException unused) {
                }
                cls = cls.getSuperclass();
            }
            return field;
        }
        return (Field) invokeLL.objValue;
    }

    public static final Object d(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, obj, str)) == null) {
            Field a = a(obj.getClass(), str);
            if (a != null) {
                try {
                    a.setAccessible(true);
                    return a.get(obj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    return null;
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static final boolean e(Class<?> cls, Class<?> cls2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls, cls2)) == null) {
            if (cls != null && cls2 != null) {
                if (cls == cls2) {
                    return true;
                }
                return cls2.isAssignableFrom(cls);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static final List<Field> b(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cls)) == null) {
            LinkedList linkedList = new LinkedList();
            while (cls != Object.class) {
                Field[] declaredFields = cls.getDeclaredFields();
                if (declaredFields != null) {
                    for (Field field : declaredFields) {
                        if (field != null && !Modifier.isTransient(field.getModifiers())) {
                            linkedList.add(field);
                        }
                    }
                }
                cls = cls.getSuperclass();
            }
            return linkedList;
        }
        return (List) invokeL.objValue;
    }

    public static final Method c(Class<?> cls, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Method[] declaredMethods;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, cls, str, objArr)) == null) {
            Method method = null;
            while (cls != Object.class && method == null) {
                for (Method method2 : cls.getDeclaredMethods()) {
                    if (method2 != null && method2.getName().equals(str)) {
                        Class<?>[] parameterTypes = method2.getParameterTypes();
                        if (parameterTypes != null || objArr != null) {
                            if (parameterTypes != null && objArr != null && parameterTypes.length == objArr.length) {
                                boolean z = true;
                                for (int i = 0; i < parameterTypes.length; i++) {
                                    if (parameterTypes[i].isPrimitive()) {
                                        if (parameterTypes[i] == Integer.TYPE) {
                                            if (objArr[i].getClass() == Integer.class) {
                                            }
                                        }
                                        if (parameterTypes[i] == Short.TYPE) {
                                            if (objArr[i].getClass() == Short.class) {
                                            }
                                        }
                                        if (parameterTypes[i] == Long.TYPE) {
                                            if (objArr[i].getClass() == Long.class) {
                                            }
                                        }
                                        if (parameterTypes[i] == Float.TYPE) {
                                            if (objArr[i].getClass() == Float.class) {
                                            }
                                        }
                                        if (parameterTypes[i] == Double.TYPE) {
                                            if (objArr[i].getClass() == Double.class) {
                                            }
                                        }
                                        if (parameterTypes[i] == Boolean.TYPE) {
                                            if (objArr[i].getClass() == Boolean.class) {
                                            }
                                        }
                                        if (parameterTypes[i] == Byte.TYPE) {
                                            if (objArr[i].getClass() == Byte.class) {
                                            }
                                        }
                                        if (parameterTypes[i] == Character.TYPE && objArr[i].getClass() == Character.class) {
                                        }
                                        z = false;
                                    } else {
                                        if (objArr[i].getClass() == parameterTypes[i]) {
                                        }
                                        z = false;
                                    }
                                }
                                if (z) {
                                }
                            }
                        }
                        method = method2;
                        break;
                    }
                }
                cls = cls.getSuperclass();
            }
            return method;
        }
        return (Method) invokeLLL.objValue;
    }

    public static final <T> T f(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, cls)) == null) {
            try {
                Constructor<T> constructor = cls.getConstructor(new Class[0]);
                if (constructor.getParameterTypes().length != 0) {
                    return null;
                }
                constructor.setAccessible(true);
                return constructor.newInstance(new Object[0]);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return null;
            } catch (InstantiationException e3) {
                e3.printStackTrace();
                return null;
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
                return null;
            } catch (Exception e5) {
                BdLog.detailException(e5);
                return null;
            }
        }
        return (T) invokeL.objValue;
    }

    public static final Object g(Class<?> cls) {
        InterceptResult invokeL;
        Object newInstance;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, cls)) == null) {
            try {
                Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
                if (declaredConstructors.length == 1) {
                    Constructor<?> constructor = declaredConstructors[0];
                    if (constructor.getParameterTypes().length != 0) {
                        return null;
                    }
                    constructor.setAccessible(true);
                    newInstance = constructor.newInstance(new Object[0]);
                } else {
                    for (Constructor<?> constructor2 : declaredConstructors) {
                        constructor2.setAccessible(true);
                        if (constructor2.getParameterTypes().length == 0) {
                            constructor2.setAccessible(true);
                            newInstance = constructor2.newInstance(new Object[0]);
                        }
                    }
                    return null;
                }
                return newInstance;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return null;
            } catch (InstantiationException e3) {
                e3.printStackTrace();
                return null;
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return invokeL.objValue;
    }

    public static final Object h(Class<?> cls, int i) {
        InterceptResult invokeLI;
        Object newInstance;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, cls, i)) == null) {
            try {
                Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
                if (declaredConstructors.length == 1) {
                    Constructor<?> constructor = declaredConstructors[0];
                    if (constructor.getParameterTypes().length != 1) {
                        return null;
                    }
                    constructor.setAccessible(true);
                    newInstance = constructor.newInstance(Integer.valueOf(i));
                } else {
                    for (Constructor<?> constructor2 : declaredConstructors) {
                        constructor2.setAccessible(true);
                        if (constructor2.getParameterTypes().length == 1) {
                            constructor2.setAccessible(true);
                            newInstance = constructor2.newInstance(Integer.valueOf(i));
                        }
                    }
                    return null;
                }
                return newInstance;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return null;
            } catch (InstantiationException e3) {
                e3.printStackTrace();
                return null;
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return invokeLI.objValue;
    }

    public static final boolean i(Object obj, String str, Object obj2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, obj, str, obj2)) == null) {
            Field a = a(obj.getClass(), str);
            if (a != null) {
                try {
                    a.setAccessible(true);
                    a.set(obj, obj2);
                    return true;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    return false;
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
