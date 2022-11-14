package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.sina.weibo.sdk.utils.ResourceManager;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class ca {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448301327, "Lcom/baidu/tieba/ca;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448301327, "Lcom/baidu/tieba/ca;");
        }
    }

    public static String a(String str, Object obj, List list) {
        InterceptResult invokeLLL;
        boolean z;
        int i;
        Map map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, obj, list)) == null) {
            StringBuffer stringBuffer = new StringBuffer("");
            if (obj == null) {
                stringBuffer.append(str + "[] = null\n");
                return stringBuffer.toString();
            }
            int i2 = 0;
            if (obj.getClass().isArray()) {
                if (Array.getLength(obj) > 0) {
                    if (!f(Array.get(obj, 0))) {
                        stringBuffer.append(str + " = [");
                        while (i2 < Array.getLength(obj) - 1) {
                            Object c = c(Array.get(obj, i2));
                            stringBuffer.append(c + ",");
                            i2++;
                        }
                        stringBuffer.append(Array.get(obj, Array.getLength(obj) - 1) + "]\n");
                    } else {
                        while (i2 < Array.getLength(obj)) {
                            Object obj2 = Array.get(obj, i2);
                            stringBuffer.append(k(str + PreferencesUtil.LEFT_MOUNT + i2 + PreferencesUtil.RIGHT_MOUNT, obj2, list));
                            i2++;
                        }
                    }
                } else {
                    stringBuffer.append(str + "[] = empty\n");
                }
            } else {
                boolean z2 = obj instanceof Collection;
                boolean z3 = obj instanceof Hashtable;
                boolean z4 = obj instanceof HashMap;
                boolean z5 = obj instanceof HashSet;
                boolean z6 = obj instanceof SparseArray;
                if (!(obj instanceof AbstractMap) && !z4 && !z3) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    Map map2 = (Map) obj;
                    Set keySet = map2.keySet();
                    int size = keySet.size();
                    if (size > 0) {
                        int i3 = 0;
                        for (Object obj3 : keySet) {
                            Object obj4 = map2.get(obj3);
                            Object c2 = c(obj3);
                            Object c3 = c(obj4);
                            if (!f(c3) && !f(c2)) {
                                if (i3 == 0) {
                                    stringBuffer.append(str + " = [");
                                    map = map2;
                                } else {
                                    map = map2;
                                    if (i3 == size - 1) {
                                        stringBuffer.append(c2 + " = " + c3 + "]\n");
                                    } else {
                                        stringBuffer.append(c2 + " = " + c3 + StringUtil.ARRAY_ELEMENT_SEPARATOR);
                                    }
                                }
                            } else {
                                map = map2;
                                stringBuffer.append(k(str + PreferencesUtil.LEFT_MOUNT + c2 + PreferencesUtil.RIGHT_MOUNT, c3, list));
                            }
                            i3++;
                            map2 = map;
                        }
                    } else {
                        stringBuffer.append(str + "[] = empty\n");
                    }
                } else if (!z2 && !z5) {
                    if (z6) {
                        SparseArray sparseArray = (SparseArray) obj;
                        int size2 = sparseArray.size();
                        if (size2 > 0) {
                            for (int i4 = 0; i4 < size2; i4++) {
                                Integer valueOf = Integer.valueOf(sparseArray.keyAt(i4));
                                Object valueAt = sparseArray.valueAt(i4);
                                Object c4 = c(valueOf);
                                Object c5 = c(valueAt);
                                if (!f(c5) && !f(c4)) {
                                    if (i4 == 0) {
                                        stringBuffer.append(str + " = [");
                                    } else if (i4 == size2 - 1) {
                                        stringBuffer.append(c4 + " = " + c5 + "]\n");
                                    } else {
                                        stringBuffer.append(c4 + " = " + c5 + StringUtil.ARRAY_ELEMENT_SEPARATOR);
                                    }
                                } else {
                                    stringBuffer.append(k(str + PreferencesUtil.LEFT_MOUNT + c4 + PreferencesUtil.RIGHT_MOUNT, c5, list));
                                }
                            }
                        } else {
                            stringBuffer.append(str + "[] = empty\n");
                        }
                    }
                } else {
                    Iterator it = null;
                    if (z2) {
                        Collection collection = (Collection) obj;
                        it = collection.iterator();
                        i = collection.size();
                    } else if (z5) {
                        HashSet hashSet = (HashSet) obj;
                        it = hashSet.iterator();
                        i = hashSet.size();
                    } else {
                        i = 0;
                    }
                    if (i > 0) {
                        int i5 = 0;
                        while (it.hasNext()) {
                            Object c6 = c(it.next());
                            if (!f(c6)) {
                                if (i5 == 0) {
                                    stringBuffer.append(str + " = [");
                                } else if (i5 == i - 1) {
                                    stringBuffer.append(c6 + "]\n");
                                } else {
                                    stringBuffer.append(c6 + StringUtil.ARRAY_ELEMENT_SEPARATOR);
                                }
                            } else {
                                stringBuffer.append(k(str + PreferencesUtil.LEFT_MOUNT + i5 + PreferencesUtil.RIGHT_MOUNT, c6, list));
                            }
                            i5++;
                        }
                    } else {
                        stringBuffer.append(str + "[] = empty\n");
                    }
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005e A[Catch: IllegalAccessException -> 0x008f, TryCatch #0 {IllegalAccessException -> 0x008f, blocks: (B:5:0x000b, B:8:0x0013, B:11:0x001a, B:14:0x004c, B:16:0x0052, B:18:0x005e, B:19:0x0071, B:20:0x0076, B:12:0x002d), top: B:30:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0071 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(String str, Object obj, List list) {
        InterceptResult invokeLLL;
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, obj, list)) == null) {
            StringBuffer stringBuffer = new StringBuffer("");
            try {
                cls = obj.getClass();
            } catch (IllegalAccessException e) {
                stringBuffer.append(e.toString());
            }
            if (str != null && !str.equals("")) {
                stringBuffer.append(str + " = {\n");
                while (cls != null && g(cls)) {
                    if (cls.getSimpleName().equals("Object")) {
                        a++;
                        i(cls.getDeclaredFields(), obj, stringBuffer, list);
                        a--;
                    }
                    cls = cls.getSuperclass();
                }
                stringBuffer.append(d() + "}\n");
                return stringBuffer.toString();
            }
            stringBuffer.append(d() + cls.getSimpleName() + " = {\n");
            while (cls != null) {
                if (cls.getSimpleName().equals("Object")) {
                }
                cls = cls.getSuperclass();
            }
            stringBuffer.append(d() + "}\n");
            return stringBuffer.toString();
        }
        return (String) invokeLLL.objValue;
    }

    public static Object c(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) {
            if (obj != null && obj.getClass() == String.class) {
                return "\"" + obj + "\"";
            }
            return obj;
        }
        return invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            StringBuffer stringBuffer = new StringBuffer("");
            for (int i = 0; i < a; i++) {
                stringBuffer.append("    ");
            }
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }

    public static boolean e(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, obj)) == null) {
            if (!obj.getClass().isArray() && !(obj instanceof Collection) && !(obj instanceof Hashtable) && !(obj instanceof HashMap) && !(obj instanceof SparseArray) && !(obj instanceof HashSet) && !(obj instanceof List) && !(obj instanceof AbstractMap)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"DefaultLocale"})
    public static boolean g(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, cls)) == null) {
            String[] strArr = {"activity", "content", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, NativeConstants.TYPE_VIEW, ResourceManager.DRAWABLE};
            for (int i = 0; i < 5; i++) {
                if (cls.getSimpleName().toLowerCase().endsWith(strArr[i])) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean f(Object obj) {
        InterceptResult invokeL;
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, obj)) == null) {
            if (obj == null || (obj instanceof Boolean) || (obj instanceof Short) || (obj instanceof Byte) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof String) || (cls = obj.getClass()) == Boolean.TYPE || cls == Boolean.class || cls == Short.TYPE || cls == Short.class || cls == Byte.TYPE || cls == Byte.class || cls == Integer.TYPE || cls == Integer.class || cls == Long.TYPE || cls == Long.class || cls == Float.TYPE || cls == Float.class || cls == Character.TYPE || cls == Character.class || cls == Double.TYPE || cls == Double.class || cls == String.class) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void h(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, obj) == null) {
            StringBuffer stringBuffer = new StringBuffer("");
            if (fa.a) {
                stringBuffer.append("Message_Type: " + str + "\n");
                stringBuffer.append(j("", obj));
                stringBuffer.append("----------------------------------------------------------\n");
                String[] split = stringBuffer.toString().split("\n");
                for (String str2 : split) {
                    BdLog.i(str2);
                }
            }
        }
    }

    public static void i(Field[] fieldArr, Object obj, StringBuffer stringBuffer, List list) throws IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, fieldArr, obj, stringBuffer, list) == null) {
            for (int i = 0; i < fieldArr.length; i++) {
                fieldArr[i].setAccessible(true);
                if (!Modifier.isStatic(fieldArr[i].getModifiers())) {
                    stringBuffer.append(k(d() + fieldArr[i].getName(), fieldArr[i].get(obj), list));
                }
            }
        }
    }

    public static String j(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, obj)) == null) {
            if (obj == null) {
                return str + ": null\n";
            } else if (e(obj)) {
                return a(str, obj, new ArrayList());
            } else {
                if (f(obj)) {
                    return b(str, obj, new ArrayList());
                }
                return str + " = " + obj.toString() + "\n\r";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String k(String str, Object obj, List list) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, str, obj, list)) == null) {
            if (obj == null) {
                return str + " = null\n";
            } else if (e(obj)) {
                return a(str, obj, list);
            } else {
                if (f(obj)) {
                    if (!list.contains(obj)) {
                        list.add(obj);
                        return b(str, obj, list);
                    }
                    return str + " = <already visited>\n";
                }
                return str + " = " + c(obj) + "\n";
            }
        }
        return (String) invokeLLL.objValue;
    }
}
