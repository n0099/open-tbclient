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
public class c41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<String> a(f41 f41Var) {
        InterceptResult invokeL;
        x31[][] e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, f41Var)) == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            for (x31[] x31VarArr : f41Var.e()) {
                String[] strArr = new String[x31VarArr.length];
                for (int i = 0; i < x31VarArr.length; i++) {
                    strArr[i] = x31VarArr[i].b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + f41Var.g() + "_" + TextUtils.join("_", strArr) + " ON " + f41Var.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String b(f41 f41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, f41Var)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + f41Var.g() + " (" + f(f41Var.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String f(x31[] x31VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, x31VarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = x31VarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                x31 x31Var = x31VarArr[i];
                sb.append(str);
                sb.append(x31Var.b);
                sb.append(getType(x31Var));
                sb.append(c(x31Var));
                i++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getType(x31 x31Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, x31Var)) == null) {
            int i = x31Var.a;
            if (i == 1 || i == 2 || i == 3) {
                return " INTEGER";
            }
            if (i == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + x31Var.a);
        }
        return (String) invokeL.objValue;
    }

    public static String c(x31 x31Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, x31Var)) == null) {
            int i = x31Var.d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + x31Var.d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String d(x31... x31VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, x31VarArr)) == null) {
            return e(x31VarArr, null);
        }
        return (String) invokeL.objValue;
    }

    public static String e(x31[] x31VarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, x31VarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = x31VarArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                x31 x31Var = x31VarArr[i];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(x31Var.b);
                i++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
