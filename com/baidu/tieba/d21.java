package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class d21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<String> a(g21 g21Var) {
        InterceptResult invokeL;
        y11[][] e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, g21Var)) == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            for (y11[] y11VarArr : g21Var.e()) {
                String[] strArr = new String[y11VarArr.length];
                for (int i = 0; i < y11VarArr.length; i++) {
                    strArr[i] = y11VarArr[i].b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + g21Var.g() + "_" + TextUtils.join("_", strArr) + " ON " + g21Var.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String b(g21 g21Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, g21Var)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + g21Var.g() + " (" + f(g21Var.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String f(y11[] y11VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, y11VarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = y11VarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                y11 y11Var = y11VarArr[i];
                sb.append(str);
                sb.append(y11Var.b);
                sb.append(getType(y11Var));
                sb.append(c(y11Var));
                i++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getType(y11 y11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, y11Var)) == null) {
            int i = y11Var.a;
            if (i == 1 || i == 2 || i == 3) {
                return " INTEGER";
            }
            if (i == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + y11Var.a);
        }
        return (String) invokeL.objValue;
    }

    public static String c(y11 y11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, y11Var)) == null) {
            int i = y11Var.d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + y11Var.d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String d(y11... y11VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, y11VarArr)) == null) {
            return e(y11VarArr, null);
        }
        return (String) invokeL.objValue;
    }

    public static String e(y11[] y11VarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, y11VarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = y11VarArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                y11 y11Var = y11VarArr[i];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(y11Var.b);
                i++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
