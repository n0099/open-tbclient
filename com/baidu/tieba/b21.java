package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<String> a(e21 e21Var) {
        InterceptResult invokeL;
        w11[][] e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, e21Var)) == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            for (w11[] w11VarArr : e21Var.e()) {
                String[] strArr = new String[w11VarArr.length];
                for (int i = 0; i < w11VarArr.length; i++) {
                    strArr[i] = w11VarArr[i].b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + e21Var.g() + "_" + TextUtils.join("_", strArr) + " ON " + e21Var.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String b(e21 e21Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, e21Var)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + e21Var.g() + " (" + f(e21Var.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String f(w11[] w11VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, w11VarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = w11VarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                w11 w11Var = w11VarArr[i];
                sb.append(str);
                sb.append(w11Var.b);
                sb.append(getType(w11Var));
                sb.append(c(w11Var));
                i++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getType(w11 w11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, w11Var)) == null) {
            int i = w11Var.a;
            if (i == 1 || i == 2 || i == 3) {
                return " INTEGER";
            }
            if (i == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + w11Var.a);
        }
        return (String) invokeL.objValue;
    }

    public static String c(w11 w11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, w11Var)) == null) {
            int i = w11Var.d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + w11Var.d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String d(w11... w11VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, w11VarArr)) == null) {
            return e(w11VarArr, null);
        }
        return (String) invokeL.objValue;
    }

    public static String e(w11[] w11VarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, w11VarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = w11VarArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                w11 w11Var = w11VarArr[i];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(w11Var.b);
                i++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
