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
public class c51 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<String> a(f51 f51Var) {
        InterceptResult invokeL;
        x41[][] e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, f51Var)) == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            for (x41[] x41VarArr : f51Var.e()) {
                String[] strArr = new String[x41VarArr.length];
                for (int i = 0; i < x41VarArr.length; i++) {
                    strArr[i] = x41VarArr[i].b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + f51Var.g() + "_" + TextUtils.join("_", strArr) + " ON " + f51Var.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String b(f51 f51Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, f51Var)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + f51Var.g() + " (" + f(f51Var.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String f(x41[] x41VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, x41VarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = x41VarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                x41 x41Var = x41VarArr[i];
                sb.append(str);
                sb.append(x41Var.b);
                sb.append(getType(x41Var));
                sb.append(c(x41Var));
                i++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getType(x41 x41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, x41Var)) == null) {
            int i = x41Var.a;
            if (i == 1 || i == 2 || i == 3) {
                return " INTEGER";
            }
            if (i == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + x41Var.a);
        }
        return (String) invokeL.objValue;
    }

    public static String c(x41 x41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, x41Var)) == null) {
            int i = x41Var.d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + x41Var.d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String d(x41... x41VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, x41VarArr)) == null) {
            return e(x41VarArr, null);
        }
        return (String) invokeL.objValue;
    }

    public static String e(x41[] x41VarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, x41VarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = x41VarArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                x41 x41Var = x41VarArr[i];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(x41Var.b);
                i++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
