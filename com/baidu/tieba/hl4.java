package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.xl4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class hl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(ui4<T> ui4Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, ui4Var, t, str, str2)) == null) {
            if (t == null || ui4Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, ui4Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, TTDownloadField.TT_DOWNLOAD_URL, ui4Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, ui4<T> ui4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, ui4Var)) == null) {
            if (ui4Var == null || t == null) {
                return false;
            }
            if (t instanceof bk4) {
                bk4 bk4Var = (bk4) t;
                return a(ui4Var, t, bk4Var.l, bk4Var.n);
            } else if (!(t instanceof xl4.a)) {
                return false;
            } else {
                ck4 ck4Var = ((xl4.a) t).d;
                return a(ui4Var, t, ck4Var.l, ck4Var.n);
            }
        }
        return invokeLL.booleanValue;
    }

    public static fl4<yj4> c(yj4 yj4Var, yi4 yi4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, yj4Var, yi4Var)) == null) {
            if (yi4Var == null || !b(yj4Var, yi4Var.r())) {
                return null;
            }
            return new fl4<>(new el4(yj4Var), yj4Var, new cl4(yi4Var.r()));
        }
        return (fl4) invokeLL.objValue;
    }

    public static fl4<ak4> d(ak4 ak4Var, yi4 yi4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, ak4Var, yi4Var)) == null) {
            if (yi4Var == null || !b(ak4Var, yi4Var.s())) {
                return null;
            }
            return new fl4<>(new el4(ak4Var), ak4Var, new cl4(yi4Var.s()));
        }
        return (fl4) invokeLL.objValue;
    }

    public static fl4<ck4> g(ck4 ck4Var, yi4 yi4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, ck4Var, yi4Var)) == null) {
            if (yi4Var == null || !b(ck4Var, yi4Var.u())) {
                return null;
            }
            return new fl4<>(new el4(ck4Var), ck4Var, new cl4(yi4Var.u()));
        }
        return (fl4) invokeLL.objValue;
    }

    public static fl4<ek4> i(ek4 ek4Var, yi4 yi4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, ek4Var, yi4Var)) == null) {
            if (yi4Var == null || !b(ek4Var, yi4Var.x())) {
                return null;
            }
            return new fl4<>(new el4(ek4Var), ek4Var, new cl4(yi4Var.x()));
        }
        return (fl4) invokeLL.objValue;
    }

    public static fl4<fk4> j(fk4 fk4Var, yi4 yi4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, fk4Var, yi4Var)) == null) {
            if (yi4Var == null || !b(fk4Var, yi4Var.z())) {
                return null;
            }
            return new fl4<>(new el4(fk4Var), fk4Var, new cl4(yi4Var.z()));
        }
        return (fl4) invokeLL.objValue;
    }

    public static List<fl4<ek4>> e(List<ek4> list, yi4 yi4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, yi4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (yi4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (ek4 ek4Var : list) {
                    if (b(ek4Var, yi4Var.q())) {
                        arrayList.add(new fl4(new el4(ek4Var), ek4Var, new cl4(yi4Var.q())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<fl4<xl4.a>> f(List<xl4.a> list, yi4 yi4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, yi4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (yi4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (xl4.a aVar : list) {
                    ck4 ck4Var = aVar.d;
                    if (ck4Var != null && b(aVar, yi4Var.v())) {
                        arrayList.add(new fl4(new el4(ck4Var), aVar, new cl4(yi4Var.v())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<fl4<dk4>> h(List<dk4> list, yi4 yi4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, yi4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (yi4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (dk4 dk4Var : list) {
                    if (b(dk4Var, yi4Var.A())) {
                        arrayList.add(new fl4(new el4(dk4Var), dk4Var, new cl4(yi4Var.A())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, ui4<T> ui4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, ui4Var) == null) {
            ui4Var.e(t, new xj4(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
