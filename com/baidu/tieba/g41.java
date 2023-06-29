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
public class g41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<String> a(j41 j41Var) {
        InterceptResult invokeL;
        b41[][] e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, j41Var)) == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            for (b41[] b41VarArr : j41Var.e()) {
                String[] strArr = new String[b41VarArr.length];
                for (int i = 0; i < b41VarArr.length; i++) {
                    strArr[i] = b41VarArr[i].b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + j41Var.g() + "_" + TextUtils.join("_", strArr) + " ON " + j41Var.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String b(j41 j41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, j41Var)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + j41Var.g() + " (" + f(j41Var.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String f(b41[] b41VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, b41VarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = b41VarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                b41 b41Var = b41VarArr[i];
                sb.append(str);
                sb.append(b41Var.b);
                sb.append(getType(b41Var));
                sb.append(c(b41Var));
                i++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getType(b41 b41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, b41Var)) == null) {
            int i = b41Var.a;
            if (i == 1 || i == 2 || i == 3) {
                return " INTEGER";
            }
            if (i == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + b41Var.a);
        }
        return (String) invokeL.objValue;
    }

    public static String c(b41 b41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, b41Var)) == null) {
            int i = b41Var.d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + b41Var.d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String d(b41... b41VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, b41VarArr)) == null) {
            return e(b41VarArr, null);
        }
        return (String) invokeL.objValue;
    }

    public static String e(b41[] b41VarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, b41VarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = b41VarArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                b41 b41Var = b41VarArr[i];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(b41Var.b);
                i++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
