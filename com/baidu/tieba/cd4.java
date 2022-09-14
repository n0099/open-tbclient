package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.sd4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class cd4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(pa4<T> pa4Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, pa4Var, t, str, str2)) == null) {
            if (t == null || pa4Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, pa4Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, TTDownloadField.TT_DOWNLOAD_URL, pa4Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, pa4<T> pa4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, pa4Var)) == null) {
            if (pa4Var == null || t == null) {
                return false;
            }
            if (t instanceof wb4) {
                wb4 wb4Var = (wb4) t;
                return a(pa4Var, t, wb4Var.l, wb4Var.n);
            } else if (t instanceof sd4.a) {
                xb4 xb4Var = ((sd4.a) t).d;
                return a(pa4Var, t, xb4Var.l, xb4Var.n);
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static ad4<tb4> c(tb4 tb4Var, ta4 ta4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tb4Var, ta4Var)) == null) {
            if (ta4Var != null && b(tb4Var, ta4Var.r())) {
                return new ad4<>(new zc4(tb4Var), tb4Var, new xc4(ta4Var.r()));
            }
            return null;
        }
        return (ad4) invokeLL.objValue;
    }

    public static ad4<vb4> d(vb4 vb4Var, ta4 ta4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, vb4Var, ta4Var)) == null) {
            if (ta4Var != null && b(vb4Var, ta4Var.s())) {
                return new ad4<>(new zc4(vb4Var), vb4Var, new xc4(ta4Var.s()));
            }
            return null;
        }
        return (ad4) invokeLL.objValue;
    }

    public static List<ad4<zb4>> e(List<zb4> list, ta4 ta4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, ta4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ta4Var != null && list != null && list.size() > 0) {
                for (zb4 zb4Var : list) {
                    if (b(zb4Var, ta4Var.q())) {
                        arrayList.add(new ad4(new zc4(zb4Var), zb4Var, new xc4(ta4Var.q())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<ad4<sd4.a>> f(List<sd4.a> list, ta4 ta4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, ta4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ta4Var != null && list != null && list.size() > 0) {
                for (sd4.a aVar : list) {
                    xb4 xb4Var = aVar.d;
                    if (xb4Var != null && b(aVar, ta4Var.v())) {
                        arrayList.add(new ad4(new zc4(xb4Var), aVar, new xc4(ta4Var.v())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static ad4<xb4> g(xb4 xb4Var, ta4 ta4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, xb4Var, ta4Var)) == null) {
            if (ta4Var != null && b(xb4Var, ta4Var.u())) {
                return new ad4<>(new zc4(xb4Var), xb4Var, new xc4(ta4Var.u()));
            }
            return null;
        }
        return (ad4) invokeLL.objValue;
    }

    public static List<ad4<yb4>> h(List<yb4> list, ta4 ta4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, ta4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ta4Var != null && list != null && list.size() > 0) {
                for (yb4 yb4Var : list) {
                    if (b(yb4Var, ta4Var.A())) {
                        arrayList.add(new ad4(new zc4(yb4Var), yb4Var, new xc4(ta4Var.A())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static ad4<zb4> i(zb4 zb4Var, ta4 ta4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, zb4Var, ta4Var)) == null) {
            if (ta4Var != null && b(zb4Var, ta4Var.x())) {
                return new ad4<>(new zc4(zb4Var), zb4Var, new xc4(ta4Var.x()));
            }
            return null;
        }
        return (ad4) invokeLL.objValue;
    }

    public static ad4<ac4> j(ac4 ac4Var, ta4 ta4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, ac4Var, ta4Var)) == null) {
            if (ta4Var != null && b(ac4Var, ta4Var.z())) {
                return new ad4<>(new zc4(ac4Var), ac4Var, new xc4(ta4Var.z()));
            }
            return null;
        }
        return (ad4) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, pa4<T> pa4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, pa4Var) == null) {
            pa4Var.e(t, new sb4(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
