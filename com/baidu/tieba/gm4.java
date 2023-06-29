package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.wm4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class gm4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(tj4<T> tj4Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, tj4Var, t, str, str2)) == null) {
            if (t == null || tj4Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, tj4Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, TTDownloadField.TT_DOWNLOAD_URL, tj4Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, tj4<T> tj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, tj4Var)) == null) {
            if (tj4Var == null || t == null) {
                return false;
            }
            if (t instanceof al4) {
                al4 al4Var = (al4) t;
                return a(tj4Var, t, al4Var.l, al4Var.n);
            } else if (!(t instanceof wm4.a)) {
                return false;
            } else {
                bl4 bl4Var = ((wm4.a) t).d;
                return a(tj4Var, t, bl4Var.l, bl4Var.n);
            }
        }
        return invokeLL.booleanValue;
    }

    public static em4<xk4> c(xk4 xk4Var, xj4 xj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, xk4Var, xj4Var)) == null) {
            if (xj4Var == null || !b(xk4Var, xj4Var.r())) {
                return null;
            }
            return new em4<>(new dm4(xk4Var), xk4Var, new bm4(xj4Var.r()));
        }
        return (em4) invokeLL.objValue;
    }

    public static em4<zk4> d(zk4 zk4Var, xj4 xj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, zk4Var, xj4Var)) == null) {
            if (xj4Var == null || !b(zk4Var, xj4Var.s())) {
                return null;
            }
            return new em4<>(new dm4(zk4Var), zk4Var, new bm4(xj4Var.s()));
        }
        return (em4) invokeLL.objValue;
    }

    public static em4<bl4> g(bl4 bl4Var, xj4 xj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, bl4Var, xj4Var)) == null) {
            if (xj4Var == null || !b(bl4Var, xj4Var.u())) {
                return null;
            }
            return new em4<>(new dm4(bl4Var), bl4Var, new bm4(xj4Var.u()));
        }
        return (em4) invokeLL.objValue;
    }

    public static em4<dl4> i(dl4 dl4Var, xj4 xj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, dl4Var, xj4Var)) == null) {
            if (xj4Var == null || !b(dl4Var, xj4Var.x())) {
                return null;
            }
            return new em4<>(new dm4(dl4Var), dl4Var, new bm4(xj4Var.x()));
        }
        return (em4) invokeLL.objValue;
    }

    public static em4<el4> j(el4 el4Var, xj4 xj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, el4Var, xj4Var)) == null) {
            if (xj4Var == null || !b(el4Var, xj4Var.z())) {
                return null;
            }
            return new em4<>(new dm4(el4Var), el4Var, new bm4(xj4Var.z()));
        }
        return (em4) invokeLL.objValue;
    }

    public static List<em4<dl4>> e(List<dl4> list, xj4 xj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, xj4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (xj4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (dl4 dl4Var : list) {
                    if (b(dl4Var, xj4Var.q())) {
                        arrayList.add(new em4(new dm4(dl4Var), dl4Var, new bm4(xj4Var.q())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<em4<wm4.a>> f(List<wm4.a> list, xj4 xj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, xj4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (xj4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (wm4.a aVar : list) {
                    bl4 bl4Var = aVar.d;
                    if (bl4Var != null && b(aVar, xj4Var.v())) {
                        arrayList.add(new em4(new dm4(bl4Var), aVar, new bm4(xj4Var.v())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<em4<cl4>> h(List<cl4> list, xj4 xj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, xj4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (xj4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (cl4 cl4Var : list) {
                    if (b(cl4Var, xj4Var.A())) {
                        arrayList.add(new em4(new dm4(cl4Var), cl4Var, new bm4(xj4Var.A())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, tj4<T> tj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, tj4Var) == null) {
            tj4Var.e(t, new wk4(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
