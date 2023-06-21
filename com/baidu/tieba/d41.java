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
public class d41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<String> a(g41 g41Var) {
        InterceptResult invokeL;
        y31[][] e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, g41Var)) == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            for (y31[] y31VarArr : g41Var.e()) {
                String[] strArr = new String[y31VarArr.length];
                for (int i = 0; i < y31VarArr.length; i++) {
                    strArr[i] = y31VarArr[i].b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + g41Var.g() + "_" + TextUtils.join("_", strArr) + " ON " + g41Var.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String b(g41 g41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, g41Var)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + g41Var.g() + " (" + f(g41Var.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String f(y31[] y31VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, y31VarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = y31VarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                y31 y31Var = y31VarArr[i];
                sb.append(str);
                sb.append(y31Var.b);
                sb.append(getType(y31Var));
                sb.append(c(y31Var));
                i++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getType(y31 y31Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, y31Var)) == null) {
            int i = y31Var.a;
            if (i == 1 || i == 2 || i == 3) {
                return " INTEGER";
            }
            if (i == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + y31Var.a);
        }
        return (String) invokeL.objValue;
    }

    public static String c(y31 y31Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, y31Var)) == null) {
            int i = y31Var.d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + y31Var.d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String d(y31... y31VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, y31VarArr)) == null) {
            return e(y31VarArr, null);
        }
        return (String) invokeL.objValue;
    }

    public static String e(y31[] y31VarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, y31VarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = y31VarArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                y31 y31Var = y31VarArr[i];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(y31Var.b);
                i++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
