package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.tm4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class dm4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(qj4<T> qj4Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, qj4Var, t, str, str2)) == null) {
            if (t == null || qj4Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, qj4Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, TTDownloadField.TT_DOWNLOAD_URL, qj4Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, qj4<T> qj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, qj4Var)) == null) {
            if (qj4Var == null || t == null) {
                return false;
            }
            if (t instanceof xk4) {
                xk4 xk4Var = (xk4) t;
                return a(qj4Var, t, xk4Var.l, xk4Var.n);
            } else if (!(t instanceof tm4.a)) {
                return false;
            } else {
                yk4 yk4Var = ((tm4.a) t).d;
                return a(qj4Var, t, yk4Var.l, yk4Var.n);
            }
        }
        return invokeLL.booleanValue;
    }

    public static bm4<uk4> c(uk4 uk4Var, uj4 uj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, uk4Var, uj4Var)) == null) {
            if (uj4Var == null || !b(uk4Var, uj4Var.r())) {
                return null;
            }
            return new bm4<>(new am4(uk4Var), uk4Var, new yl4(uj4Var.r()));
        }
        return (bm4) invokeLL.objValue;
    }

    public static bm4<wk4> d(wk4 wk4Var, uj4 uj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, wk4Var, uj4Var)) == null) {
            if (uj4Var == null || !b(wk4Var, uj4Var.s())) {
                return null;
            }
            return new bm4<>(new am4(wk4Var), wk4Var, new yl4(uj4Var.s()));
        }
        return (bm4) invokeLL.objValue;
    }

    public static bm4<yk4> g(yk4 yk4Var, uj4 uj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, yk4Var, uj4Var)) == null) {
            if (uj4Var == null || !b(yk4Var, uj4Var.u())) {
                return null;
            }
            return new bm4<>(new am4(yk4Var), yk4Var, new yl4(uj4Var.u()));
        }
        return (bm4) invokeLL.objValue;
    }

    public static bm4<al4> i(al4 al4Var, uj4 uj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, al4Var, uj4Var)) == null) {
            if (uj4Var == null || !b(al4Var, uj4Var.x())) {
                return null;
            }
            return new bm4<>(new am4(al4Var), al4Var, new yl4(uj4Var.x()));
        }
        return (bm4) invokeLL.objValue;
    }

    public static bm4<bl4> j(bl4 bl4Var, uj4 uj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, bl4Var, uj4Var)) == null) {
            if (uj4Var == null || !b(bl4Var, uj4Var.z())) {
                return null;
            }
            return new bm4<>(new am4(bl4Var), bl4Var, new yl4(uj4Var.z()));
        }
        return (bm4) invokeLL.objValue;
    }

    public static List<bm4<al4>> e(List<al4> list, uj4 uj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, uj4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (uj4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (al4 al4Var : list) {
                    if (b(al4Var, uj4Var.q())) {
                        arrayList.add(new bm4(new am4(al4Var), al4Var, new yl4(uj4Var.q())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<bm4<tm4.a>> f(List<tm4.a> list, uj4 uj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, uj4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (uj4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (tm4.a aVar : list) {
                    yk4 yk4Var = aVar.d;
                    if (yk4Var != null && b(aVar, uj4Var.v())) {
                        arrayList.add(new bm4(new am4(yk4Var), aVar, new yl4(uj4Var.v())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<bm4<zk4>> h(List<zk4> list, uj4 uj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, uj4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (uj4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (zk4 zk4Var : list) {
                    if (b(zk4Var, uj4Var.A())) {
                        arrayList.add(new bm4(new am4(zk4Var), zk4Var, new yl4(uj4Var.A())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, qj4<T> qj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, qj4Var) == null) {
            qj4Var.e(t, new tk4(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
