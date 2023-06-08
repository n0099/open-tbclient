package com.baidu.tieba;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65536, null, str, z)) == null) {
            return tg.b(h(str), z);
        }
        return invokeLZ.booleanValue;
    }

    public static int d(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, str, i)) == null) {
            return tg.e(h(str), i);
        }
        return invokeLI.intValue;
    }

    public static long e(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, j)) == null) {
            return tg.g(h(str), j);
        }
        return invokeLJ.longValue;
    }

    public static OrmObject f(String str, Class<?> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, cls)) == null) {
            if (str != null && cls != null) {
                return OrmObject.objectWithJsonStr(h(str), cls);
            }
            return null;
        }
        return (OrmObject) invokeLL.objValue;
    }

    public static String g(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, str2)) == null) {
            String h = h(str);
            if (h != null) {
                return h;
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public static void k(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65546, null, str, z) == null) {
            o(str, Boolean.valueOf(z));
        }
    }

    public static void l(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65547, null, str, i) == null) {
            o(str, Integer.valueOf(i));
        }
    }

    public static void m(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65548, null, str, j) == null) {
            o(str, Long.valueOf(j));
        }
    }

    public static void n(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, str, str2) == null) {
            o(str, str2);
        }
    }

    public static void o(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, str, obj) == null) {
            p(Uri.parse(b() + str), j(str, obj));
        }
    }

    public static void p(Uri uri, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, uri, contentValues) == null) {
            q(uri, contentValues);
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return n95.m().j();
        }
        return (String) invokeV.objValue;
    }

    public static ContentResolver c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return n95.m().k();
        }
        return (ContentResolver) invokeV.objValue;
    }

    public static String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            return i(Uri.parse(b() + str));
        }
        return (String) invokeL.objValue;
    }

    public static String i(Uri uri) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, uri)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                str = c().getType(uri);
            } catch (SecurityException e) {
                BdLog.detailException(e);
                str = null;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            gp5.m("getValue uri=" + uri + " Time:" + (currentTimeMillis2 - currentTimeMillis));
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static ContentValues j(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, obj)) == null) {
            ContentValues contentValues = new ContentValues();
            String str2 = null;
            if (obj != null) {
                if (obj instanceof String) {
                    str2 = (String) obj;
                } else if (obj instanceof Boolean) {
                    str2 = String.valueOf(obj);
                } else if (obj instanceof Integer) {
                    str2 = String.valueOf(obj);
                } else if (obj instanceof Long) {
                    str2 = String.valueOf(obj);
                } else if (obj instanceof Float) {
                    str2 = String.valueOf(obj);
                } else if (obj instanceof Double) {
                    str2 = String.valueOf(obj);
                }
            }
            contentValues.put(str, str2);
            return contentValues;
        }
        return (ContentValues) invokeLL.objValue;
    }

    public static void q(Uri uri, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, uri, contentValues) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                c().insert(uri, contentValues);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            gp5.m("setValue uri=" + uri + " Time:" + (currentTimeMillis2 - currentTimeMillis));
        }
    }
}
