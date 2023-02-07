package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.qj4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class aj4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(ng4<T> ng4Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, ng4Var, t, str, str2)) == null) {
            if (t == null || ng4Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, ng4Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, TTDownloadField.TT_DOWNLOAD_URL, ng4Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, ng4<T> ng4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, ng4Var)) == null) {
            if (ng4Var == null || t == null) {
                return false;
            }
            if (t instanceof uh4) {
                uh4 uh4Var = (uh4) t;
                return a(ng4Var, t, uh4Var.l, uh4Var.n);
            } else if (!(t instanceof qj4.a)) {
                return false;
            } else {
                vh4 vh4Var = ((qj4.a) t).d;
                return a(ng4Var, t, vh4Var.l, vh4Var.n);
            }
        }
        return invokeLL.booleanValue;
    }

    public static yi4<rh4> c(rh4 rh4Var, rg4 rg4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, rh4Var, rg4Var)) == null) {
            if (rg4Var == null || !b(rh4Var, rg4Var.r())) {
                return null;
            }
            return new yi4<>(new xi4(rh4Var), rh4Var, new vi4(rg4Var.r()));
        }
        return (yi4) invokeLL.objValue;
    }

    public static yi4<th4> d(th4 th4Var, rg4 rg4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, th4Var, rg4Var)) == null) {
            if (rg4Var == null || !b(th4Var, rg4Var.s())) {
                return null;
            }
            return new yi4<>(new xi4(th4Var), th4Var, new vi4(rg4Var.s()));
        }
        return (yi4) invokeLL.objValue;
    }

    public static yi4<vh4> g(vh4 vh4Var, rg4 rg4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, vh4Var, rg4Var)) == null) {
            if (rg4Var == null || !b(vh4Var, rg4Var.u())) {
                return null;
            }
            return new yi4<>(new xi4(vh4Var), vh4Var, new vi4(rg4Var.u()));
        }
        return (yi4) invokeLL.objValue;
    }

    public static yi4<xh4> i(xh4 xh4Var, rg4 rg4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, xh4Var, rg4Var)) == null) {
            if (rg4Var == null || !b(xh4Var, rg4Var.x())) {
                return null;
            }
            return new yi4<>(new xi4(xh4Var), xh4Var, new vi4(rg4Var.x()));
        }
        return (yi4) invokeLL.objValue;
    }

    public static yi4<yh4> j(yh4 yh4Var, rg4 rg4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, yh4Var, rg4Var)) == null) {
            if (rg4Var == null || !b(yh4Var, rg4Var.z())) {
                return null;
            }
            return new yi4<>(new xi4(yh4Var), yh4Var, new vi4(rg4Var.z()));
        }
        return (yi4) invokeLL.objValue;
    }

    public static List<yi4<xh4>> e(List<xh4> list, rg4 rg4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, rg4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (rg4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (xh4 xh4Var : list) {
                    if (b(xh4Var, rg4Var.q())) {
                        arrayList.add(new yi4(new xi4(xh4Var), xh4Var, new vi4(rg4Var.q())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<yi4<qj4.a>> f(List<qj4.a> list, rg4 rg4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, rg4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (rg4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (qj4.a aVar : list) {
                    vh4 vh4Var = aVar.d;
                    if (vh4Var != null && b(aVar, rg4Var.v())) {
                        arrayList.add(new yi4(new xi4(vh4Var), aVar, new vi4(rg4Var.v())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<yi4<wh4>> h(List<wh4> list, rg4 rg4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, rg4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (rg4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (wh4 wh4Var : list) {
                    if (b(wh4Var, rg4Var.A())) {
                        arrayList.add(new yi4(new xi4(wh4Var), wh4Var, new vi4(rg4Var.A())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, ng4<T> ng4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, ng4Var) == null) {
            ng4Var.e(t, new qh4(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
