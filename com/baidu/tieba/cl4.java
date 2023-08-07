package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.sl4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class cl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(pi4<T> pi4Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, pi4Var, t, str, str2)) == null) {
            if (t == null || pi4Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, pi4Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, TTDownloadField.TT_DOWNLOAD_URL, pi4Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, pi4<T> pi4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, pi4Var)) == null) {
            if (pi4Var == null || t == null) {
                return false;
            }
            if (t instanceof wj4) {
                wj4 wj4Var = (wj4) t;
                return a(pi4Var, t, wj4Var.l, wj4Var.n);
            } else if (!(t instanceof sl4.a)) {
                return false;
            } else {
                xj4 xj4Var = ((sl4.a) t).d;
                return a(pi4Var, t, xj4Var.l, xj4Var.n);
            }
        }
        return invokeLL.booleanValue;
    }

    public static al4<tj4> c(tj4 tj4Var, ti4 ti4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tj4Var, ti4Var)) == null) {
            if (ti4Var == null || !b(tj4Var, ti4Var.r())) {
                return null;
            }
            return new al4<>(new zk4(tj4Var), tj4Var, new xk4(ti4Var.r()));
        }
        return (al4) invokeLL.objValue;
    }

    public static al4<vj4> d(vj4 vj4Var, ti4 ti4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, vj4Var, ti4Var)) == null) {
            if (ti4Var == null || !b(vj4Var, ti4Var.s())) {
                return null;
            }
            return new al4<>(new zk4(vj4Var), vj4Var, new xk4(ti4Var.s()));
        }
        return (al4) invokeLL.objValue;
    }

    public static al4<xj4> g(xj4 xj4Var, ti4 ti4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, xj4Var, ti4Var)) == null) {
            if (ti4Var == null || !b(xj4Var, ti4Var.u())) {
                return null;
            }
            return new al4<>(new zk4(xj4Var), xj4Var, new xk4(ti4Var.u()));
        }
        return (al4) invokeLL.objValue;
    }

    public static al4<zj4> i(zj4 zj4Var, ti4 ti4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, zj4Var, ti4Var)) == null) {
            if (ti4Var == null || !b(zj4Var, ti4Var.x())) {
                return null;
            }
            return new al4<>(new zk4(zj4Var), zj4Var, new xk4(ti4Var.x()));
        }
        return (al4) invokeLL.objValue;
    }

    public static al4<ak4> j(ak4 ak4Var, ti4 ti4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, ak4Var, ti4Var)) == null) {
            if (ti4Var == null || !b(ak4Var, ti4Var.z())) {
                return null;
            }
            return new al4<>(new zk4(ak4Var), ak4Var, new xk4(ti4Var.z()));
        }
        return (al4) invokeLL.objValue;
    }

    public static List<al4<zj4>> e(List<zj4> list, ti4 ti4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, ti4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ti4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (zj4 zj4Var : list) {
                    if (b(zj4Var, ti4Var.q())) {
                        arrayList.add(new al4(new zk4(zj4Var), zj4Var, new xk4(ti4Var.q())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<al4<sl4.a>> f(List<sl4.a> list, ti4 ti4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, ti4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ti4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (sl4.a aVar : list) {
                    xj4 xj4Var = aVar.d;
                    if (xj4Var != null && b(aVar, ti4Var.v())) {
                        arrayList.add(new al4(new zk4(xj4Var), aVar, new xk4(ti4Var.v())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<al4<yj4>> h(List<yj4> list, ti4 ti4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, ti4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ti4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (yj4 yj4Var : list) {
                    if (b(yj4Var, ti4Var.A())) {
                        arrayList.add(new al4(new zk4(yj4Var), yj4Var, new xk4(ti4Var.A())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, pi4<T> pi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, pi4Var) == null) {
            pi4Var.e(t, new sj4(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
