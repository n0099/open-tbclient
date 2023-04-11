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
public class a21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<String> a(d21 d21Var) {
        InterceptResult invokeL;
        v11[][] e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, d21Var)) == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            for (v11[] v11VarArr : d21Var.e()) {
                String[] strArr = new String[v11VarArr.length];
                for (int i = 0; i < v11VarArr.length; i++) {
                    strArr[i] = v11VarArr[i].b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + d21Var.g() + "_" + TextUtils.join("_", strArr) + " ON " + d21Var.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String b(d21 d21Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, d21Var)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + d21Var.g() + " (" + f(d21Var.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String f(v11[] v11VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, v11VarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = v11VarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                v11 v11Var = v11VarArr[i];
                sb.append(str);
                sb.append(v11Var.b);
                sb.append(getType(v11Var));
                sb.append(c(v11Var));
                i++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getType(v11 v11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, v11Var)) == null) {
            int i = v11Var.a;
            if (i == 1 || i == 2 || i == 3) {
                return " INTEGER";
            }
            if (i == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + v11Var.a);
        }
        return (String) invokeL.objValue;
    }

    public static String c(v11 v11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, v11Var)) == null) {
            int i = v11Var.d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + v11Var.d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String d(v11... v11VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, v11VarArr)) == null) {
            return e(v11VarArr, null);
        }
        return (String) invokeL.objValue;
    }

    public static String e(v11[] v11VarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, v11VarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = v11VarArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                v11 v11Var = v11VarArr[i];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(v11Var.b);
                i++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
