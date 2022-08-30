package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.sb4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class cb4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(p84<T> p84Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, p84Var, t, str, str2)) == null) {
            if (t == null || p84Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, p84Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, TTDownloadField.TT_DOWNLOAD_URL, p84Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, p84<T> p84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, p84Var)) == null) {
            if (p84Var == null || t == null) {
                return false;
            }
            if (t instanceof w94) {
                w94 w94Var = (w94) t;
                return a(p84Var, t, w94Var.l, w94Var.n);
            } else if (t instanceof sb4.a) {
                x94 x94Var = ((sb4.a) t).d;
                return a(p84Var, t, x94Var.l, x94Var.n);
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static ab4<t94> c(t94 t94Var, t84 t84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, t94Var, t84Var)) == null) {
            if (t84Var != null && b(t94Var, t84Var.r())) {
                return new ab4<>(new za4(t94Var), t94Var, new xa4(t84Var.r()));
            }
            return null;
        }
        return (ab4) invokeLL.objValue;
    }

    public static ab4<v94> d(v94 v94Var, t84 t84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, v94Var, t84Var)) == null) {
            if (t84Var != null && b(v94Var, t84Var.s())) {
                return new ab4<>(new za4(v94Var), v94Var, new xa4(t84Var.s()));
            }
            return null;
        }
        return (ab4) invokeLL.objValue;
    }

    public static List<ab4<z94>> e(List<z94> list, t84 t84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, t84Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (t84Var != null && list != null && list.size() > 0) {
                for (z94 z94Var : list) {
                    if (b(z94Var, t84Var.q())) {
                        arrayList.add(new ab4(new za4(z94Var), z94Var, new xa4(t84Var.q())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<ab4<sb4.a>> f(List<sb4.a> list, t84 t84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, t84Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (t84Var != null && list != null && list.size() > 0) {
                for (sb4.a aVar : list) {
                    x94 x94Var = aVar.d;
                    if (x94Var != null && b(aVar, t84Var.v())) {
                        arrayList.add(new ab4(new za4(x94Var), aVar, new xa4(t84Var.v())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static ab4<x94> g(x94 x94Var, t84 t84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, x94Var, t84Var)) == null) {
            if (t84Var != null && b(x94Var, t84Var.u())) {
                return new ab4<>(new za4(x94Var), x94Var, new xa4(t84Var.u()));
            }
            return null;
        }
        return (ab4) invokeLL.objValue;
    }

    public static List<ab4<y94>> h(List<y94> list, t84 t84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, t84Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (t84Var != null && list != null && list.size() > 0) {
                for (y94 y94Var : list) {
                    if (b(y94Var, t84Var.A())) {
                        arrayList.add(new ab4(new za4(y94Var), y94Var, new xa4(t84Var.A())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static ab4<z94> i(z94 z94Var, t84 t84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, z94Var, t84Var)) == null) {
            if (t84Var != null && b(z94Var, t84Var.x())) {
                return new ab4<>(new za4(z94Var), z94Var, new xa4(t84Var.x()));
            }
            return null;
        }
        return (ab4) invokeLL.objValue;
    }

    public static ab4<aa4> j(aa4 aa4Var, t84 t84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, aa4Var, t84Var)) == null) {
            if (t84Var != null && b(aa4Var, t84Var.z())) {
                return new ab4<>(new za4(aa4Var), aa4Var, new xa4(t84Var.z()));
            }
            return null;
        }
        return (ab4) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, p84<T> p84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, p84Var) == null) {
            p84Var.e(t, new s94(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
