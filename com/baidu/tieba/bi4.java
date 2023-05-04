package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.ri4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class bi4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(of4<T> of4Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, of4Var, t, str, str2)) == null) {
            if (t == null || of4Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, of4Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, TTDownloadField.TT_DOWNLOAD_URL, of4Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, of4<T> of4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, of4Var)) == null) {
            if (of4Var == null || t == null) {
                return false;
            }
            if (t instanceof vg4) {
                vg4 vg4Var = (vg4) t;
                return a(of4Var, t, vg4Var.l, vg4Var.n);
            } else if (!(t instanceof ri4.a)) {
                return false;
            } else {
                wg4 wg4Var = ((ri4.a) t).d;
                return a(of4Var, t, wg4Var.l, wg4Var.n);
            }
        }
        return invokeLL.booleanValue;
    }

    public static zh4<sg4> c(sg4 sg4Var, sf4 sf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, sg4Var, sf4Var)) == null) {
            if (sf4Var == null || !b(sg4Var, sf4Var.r())) {
                return null;
            }
            return new zh4<>(new yh4(sg4Var), sg4Var, new wh4(sf4Var.r()));
        }
        return (zh4) invokeLL.objValue;
    }

    public static zh4<ug4> d(ug4 ug4Var, sf4 sf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, ug4Var, sf4Var)) == null) {
            if (sf4Var == null || !b(ug4Var, sf4Var.s())) {
                return null;
            }
            return new zh4<>(new yh4(ug4Var), ug4Var, new wh4(sf4Var.s()));
        }
        return (zh4) invokeLL.objValue;
    }

    public static zh4<wg4> g(wg4 wg4Var, sf4 sf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, wg4Var, sf4Var)) == null) {
            if (sf4Var == null || !b(wg4Var, sf4Var.u())) {
                return null;
            }
            return new zh4<>(new yh4(wg4Var), wg4Var, new wh4(sf4Var.u()));
        }
        return (zh4) invokeLL.objValue;
    }

    public static zh4<yg4> i(yg4 yg4Var, sf4 sf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, yg4Var, sf4Var)) == null) {
            if (sf4Var == null || !b(yg4Var, sf4Var.x())) {
                return null;
            }
            return new zh4<>(new yh4(yg4Var), yg4Var, new wh4(sf4Var.x()));
        }
        return (zh4) invokeLL.objValue;
    }

    public static zh4<zg4> j(zg4 zg4Var, sf4 sf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, zg4Var, sf4Var)) == null) {
            if (sf4Var == null || !b(zg4Var, sf4Var.z())) {
                return null;
            }
            return new zh4<>(new yh4(zg4Var), zg4Var, new wh4(sf4Var.z()));
        }
        return (zh4) invokeLL.objValue;
    }

    public static List<zh4<yg4>> e(List<yg4> list, sf4 sf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, sf4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (sf4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (yg4 yg4Var : list) {
                    if (b(yg4Var, sf4Var.q())) {
                        arrayList.add(new zh4(new yh4(yg4Var), yg4Var, new wh4(sf4Var.q())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<zh4<ri4.a>> f(List<ri4.a> list, sf4 sf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, sf4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (sf4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (ri4.a aVar : list) {
                    wg4 wg4Var = aVar.d;
                    if (wg4Var != null && b(aVar, sf4Var.v())) {
                        arrayList.add(new zh4(new yh4(wg4Var), aVar, new wh4(sf4Var.v())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<zh4<xg4>> h(List<xg4> list, sf4 sf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, sf4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (sf4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (xg4 xg4Var : list) {
                    if (b(xg4Var, sf4Var.A())) {
                        arrayList.add(new zh4(new yh4(xg4Var), xg4Var, new wh4(sf4Var.A())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, of4<T> of4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, of4Var) == null) {
            of4Var.e(t, new rg4(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
