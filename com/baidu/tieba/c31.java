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
public class c31 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<String> a(f31 f31Var) {
        InterceptResult invokeL;
        x21[][] e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, f31Var)) == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            for (x21[] x21VarArr : f31Var.e()) {
                String[] strArr = new String[x21VarArr.length];
                for (int i = 0; i < x21VarArr.length; i++) {
                    strArr[i] = x21VarArr[i].b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + f31Var.g() + "_" + TextUtils.join("_", strArr) + " ON " + f31Var.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String b(f31 f31Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, f31Var)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + f31Var.g() + " (" + f(f31Var.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String f(x21[] x21VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, x21VarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = x21VarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                x21 x21Var = x21VarArr[i];
                sb.append(str);
                sb.append(x21Var.b);
                sb.append(getType(x21Var));
                sb.append(c(x21Var));
                i++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getType(x21 x21Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, x21Var)) == null) {
            int i = x21Var.a;
            if (i == 1 || i == 2 || i == 3) {
                return " INTEGER";
            }
            if (i == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + x21Var.a);
        }
        return (String) invokeL.objValue;
    }

    public static String c(x21 x21Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, x21Var)) == null) {
            int i = x21Var.d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + x21Var.d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String d(x21... x21VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, x21VarArr)) == null) {
            return e(x21VarArr, null);
        }
        return (String) invokeL.objValue;
    }

    public static String e(x21[] x21VarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, x21VarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = x21VarArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                x21 x21Var = x21VarArr[i];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(x21Var.b);
                i++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
