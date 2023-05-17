package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class i43 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947803489, "Lcom/baidu/tieba/i43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947803489, "Lcom/baidu/tieba/i43;");
                return;
            }
        }
        a = qp1.a;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static boolean a(Context context, @NonNull j43 j43Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, j43Var)) == null) {
            if (context instanceof SwanAppBaseActivity) {
                return true;
            }
            j43Var.b(2, "method should be called after setActivityRef");
            if (!a) {
                return false;
            }
            throw new IllegalStateException("this method should be called after setActivityRef");
        }
        return invokeLL.booleanValue;
    }

    public static boolean c(ArrayList<String> arrayList, @NonNull j43 j43Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, arrayList, j43Var)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                return false;
            }
            j43Var.a("permission has already granted");
            return true;
        }
        return invokeLL.booleanValue;
    }

    @NonNull
    public static ArrayList<String> d(@NonNull Context context, @NonNull String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, strArr)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (String str : strArr) {
                if (!cq4.a(context, str)) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static boolean b(@NonNull Context context, @NonNull String str, @NonNull j43 j43Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, str, j43Var)) == null) {
            if (cq4.a(context, str)) {
                j43Var.a("permission has already granted");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static void e(@NonNull String str, @NonNull String[] strArr, int i, @NonNull Context context, @NonNull j43 j43Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65541, null, new Object[]{str, strArr, Integer.valueOf(i), context, j43Var}) != null) || !a(context, j43Var) || b(context, str, j43Var)) {
            return;
        }
        g(context, strArr, i, j43Var);
    }

    @Deprecated
    public static void f(@NonNull Context context, @NonNull String[] strArr, int i, @NonNull j43 j43Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLIL(65542, null, context, strArr, i, j43Var) != null) || !a(context, j43Var)) {
            return;
        }
        ArrayList<String> d = d(context, strArr);
        if (c(d, j43Var)) {
            return;
        }
        ((SwanAppBaseActivity) context).A(i, (String[]) d.toArray(new String[0]), new e43(i, j43Var));
    }

    public static void g(@NonNull Context context, @NonNull String[] strArr, int i, @NonNull j43 j43Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLIL(65543, null, context, strArr, i, j43Var) != null) || !a(context, j43Var)) {
            return;
        }
        ArrayList<String> d = d(context, strArr);
        if (c(d, j43Var)) {
            return;
        }
        ((SwanAppBaseActivity) context).A(i, (String[]) d.toArray(new String[0]), new f43(context, i, j43Var));
    }

    public static void h(@NonNull String[] strArr, int i, @NonNull Context context, @NonNull j43 j43Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(65544, null, strArr, i, context, j43Var) != null) || !a(context, j43Var)) {
            return;
        }
        ArrayList<String> d = d(context, strArr);
        if (c(d, j43Var)) {
            return;
        }
        g(context, (String[]) d.toArray(new String[0]), i, j43Var);
    }

    @Deprecated
    public static void requestPermissions(@NonNull String[] strArr, int i, @NonNull Context context, @NonNull j43 j43Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(65545, null, strArr, i, context, j43Var) != null) || !a(context, j43Var)) {
            return;
        }
        ArrayList<String> d = d(context, strArr);
        if (c(d, j43Var)) {
            return;
        }
        f(context, (String[]) d.toArray(new String[0]), i, j43Var);
    }
}
