package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class f41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<String> a(i41 i41Var) {
        InterceptResult invokeL;
        a41[][] e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, i41Var)) == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            for (a41[] a41VarArr : i41Var.e()) {
                String[] strArr = new String[a41VarArr.length];
                for (int i = 0; i < a41VarArr.length; i++) {
                    strArr[i] = a41VarArr[i].b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + i41Var.g() + "_" + TextUtils.join("_", strArr) + " ON " + i41Var.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String b(i41 i41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, i41Var)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + i41Var.g() + " (" + f(i41Var.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String f(a41[] a41VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, a41VarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = a41VarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                a41 a41Var = a41VarArr[i];
                sb.append(str);
                sb.append(a41Var.b);
                sb.append(getType(a41Var));
                sb.append(c(a41Var));
                i++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getType(a41 a41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, a41Var)) == null) {
            int i = a41Var.a;
            if (i == 1 || i == 2 || i == 3) {
                return " INTEGER";
            }
            if (i == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + a41Var.a);
        }
        return (String) invokeL.objValue;
    }

    public static String c(a41 a41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, a41Var)) == null) {
            int i = a41Var.d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + a41Var.d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String d(a41... a41VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, a41VarArr)) == null) {
            return e(a41VarArr, null);
        }
        return (String) invokeL.objValue;
    }

    public static String e(a41[] a41VarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, a41VarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = a41VarArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                a41 a41Var = a41VarArr[i];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(a41Var.b);
                i++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
