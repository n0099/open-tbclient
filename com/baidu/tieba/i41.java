package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class i41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<String> a(l41 l41Var) {
        InterceptResult invokeL;
        d41[][] e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, l41Var)) == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            for (d41[] d41VarArr : l41Var.e()) {
                String[] strArr = new String[d41VarArr.length];
                for (int i = 0; i < d41VarArr.length; i++) {
                    strArr[i] = d41VarArr[i].b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + l41Var.g() + "_" + TextUtils.join("_", strArr) + " ON " + l41Var.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String b(l41 l41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, l41Var)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + l41Var.g() + " (" + f(l41Var.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String f(d41[] d41VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, d41VarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = d41VarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                d41 d41Var = d41VarArr[i];
                sb.append(str);
                sb.append(d41Var.b);
                sb.append(getType(d41Var));
                sb.append(c(d41Var));
                i++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getType(d41 d41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, d41Var)) == null) {
            int i = d41Var.a;
            if (i == 1 || i == 2 || i == 3) {
                return " INTEGER";
            }
            if (i == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + d41Var.a);
        }
        return (String) invokeL.objValue;
    }

    public static String c(d41 d41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, d41Var)) == null) {
            int i = d41Var.d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + d41Var.d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String d(d41... d41VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, d41VarArr)) == null) {
            return e(d41VarArr, null);
        }
        return (String) invokeL.objValue;
    }

    public static String e(d41[] d41VarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, d41VarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = d41VarArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                d41 d41Var = d41VarArr[i];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(d41Var.b);
                i++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
