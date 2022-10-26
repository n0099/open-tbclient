package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.utils.Constant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class i91 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i91 b;
    public transient /* synthetic */ FieldHolder $fh;
    public Map a;

    public i91() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
    }

    public static i91 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (b == null) {
                synchronized (i91.class) {
                    if (b == null) {
                        b = new i91();
                    }
                }
            }
            return b;
        }
        return (i91) invokeV.objValue;
    }

    public static Object[] a(Class cls, Object[] objArr, Object[] objArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, cls, objArr, objArr2)) == null) {
            Object[] objArr3 = (Object[]) Array.newInstance(cls, objArr.length + objArr2.length);
            System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
            System.arraycopy(objArr2, 0, objArr3, objArr.length, objArr2.length);
            return objArr3;
        }
        return (Object[]) invokeLLL.objValue;
    }

    public static void e(Field field, Object obj, Object obj2) throws IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, field, obj, obj2) == null) {
            field.set(obj, c((Object[]) field.get(obj), (Object[]) field.get(obj2)));
        }
    }

    public static Object[] c(Object[] objArr, Object[] objArr2) throws IllegalArgumentException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, objArr, objArr2)) == null) {
            ArrayList arrayList = new ArrayList(Arrays.asList(objArr));
            for (Object obj : objArr2) {
                if (!arrayList.contains(obj)) {
                    arrayList.add(obj);
                }
            }
            Object[] objArr3 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), arrayList.size());
            for (int i = 0; i < objArr3.length; i++) {
                objArr3[i] = arrayList.get(i);
            }
            return objArr3;
        }
        return (Object[]) invokeLL.objValue;
    }

    public static void f(Field field, Object obj, Object obj2) throws IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, field, obj, obj2) == null) {
            List list = (List) field.get(obj);
            list.addAll((List) field.get(obj2));
            field.set(obj, list);
            Field b2 = x91.b(obj.getClass(), "nativeLibraryPathElements");
            b2.set(obj, c((Object[]) b2.get(obj), (Object[]) b2.get(obj2)));
        }
    }

    public static ClassLoader g(k91 k91Var, k91 k91Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, k91Var, k91Var2)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                h(k91Var, k91Var2);
                return k91Var;
            }
            return null;
        }
        return (ClassLoader) invokeLL.objValue;
    }

    public static ClassLoader h(k91 k91Var, k91 k91Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, k91Var, k91Var2)) == null) {
            Field b2 = x91.b(k91.class, "pathList");
            try {
                Object obj = b2.get(k91Var);
                Field b3 = x91.b(obj.getClass(), "dexElements");
                Field b4 = x91.b(obj.getClass(), "nativeLibraryDirectories");
                Object[] objArr = (Object[]) b3.get(obj);
                Object obj2 = b2.get(k91Var2);
                b3.set(obj, a(objArr.getClass().getComponentType(), objArr, (Object[]) b3.get(obj2)));
                if (Build.VERSION.SDK_INT >= 23) {
                    f(b4, obj, obj2);
                } else {
                    e(b4, obj, obj2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return k91Var;
        }
        return (ClassLoader) invokeLL.objValue;
    }

    public k91 b(BundleInfo bundleInfo, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bundleInfo, context)) == null) {
            boolean z = !TextUtils.isEmpty(bundleInfo.getGroupName());
            k91 k91Var = new k91(s91.d(context, bundleInfo.getPackageName() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX).getAbsolutePath(), s91.f(context, bundleInfo.getPackageName()).getAbsolutePath(), s91.e(context, bundleInfo.getPackageName()).getAbsolutePath(), context);
            if (z && Build.VERSION.SDK_INT >= 21) {
                k91 k91Var2 = (k91) this.a.get(bundleInfo.getGroupName());
                if (k91Var2 == null) {
                    this.a.put(bundleInfo.getGroupName(), k91Var);
                    return k91Var;
                }
                g(k91Var2, k91Var);
                return k91Var2;
            }
            return k91Var;
        }
        return (k91) invokeLL.objValue;
    }
}
