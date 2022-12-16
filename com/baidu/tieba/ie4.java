package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.ye4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ie4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(vb4<T> vb4Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, vb4Var, t, str, str2)) == null) {
            if (t == null || vb4Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, vb4Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, TTDownloadField.TT_DOWNLOAD_URL, vb4Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, vb4<T> vb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, vb4Var)) == null) {
            if (vb4Var == null || t == null) {
                return false;
            }
            if (t instanceof cd4) {
                cd4 cd4Var = (cd4) t;
                return a(vb4Var, t, cd4Var.l, cd4Var.n);
            } else if (!(t instanceof ye4.a)) {
                return false;
            } else {
                dd4 dd4Var = ((ye4.a) t).d;
                return a(vb4Var, t, dd4Var.l, dd4Var.n);
            }
        }
        return invokeLL.booleanValue;
    }

    public static ge4<zc4> c(zc4 zc4Var, zb4 zb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, zc4Var, zb4Var)) == null) {
            if (zb4Var == null || !b(zc4Var, zb4Var.r())) {
                return null;
            }
            return new ge4<>(new fe4(zc4Var), zc4Var, new de4(zb4Var.r()));
        }
        return (ge4) invokeLL.objValue;
    }

    public static ge4<bd4> d(bd4 bd4Var, zb4 zb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, bd4Var, zb4Var)) == null) {
            if (zb4Var == null || !b(bd4Var, zb4Var.s())) {
                return null;
            }
            return new ge4<>(new fe4(bd4Var), bd4Var, new de4(zb4Var.s()));
        }
        return (ge4) invokeLL.objValue;
    }

    public static ge4<dd4> g(dd4 dd4Var, zb4 zb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, dd4Var, zb4Var)) == null) {
            if (zb4Var == null || !b(dd4Var, zb4Var.u())) {
                return null;
            }
            return new ge4<>(new fe4(dd4Var), dd4Var, new de4(zb4Var.u()));
        }
        return (ge4) invokeLL.objValue;
    }

    public static ge4<fd4> i(fd4 fd4Var, zb4 zb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, fd4Var, zb4Var)) == null) {
            if (zb4Var == null || !b(fd4Var, zb4Var.x())) {
                return null;
            }
            return new ge4<>(new fe4(fd4Var), fd4Var, new de4(zb4Var.x()));
        }
        return (ge4) invokeLL.objValue;
    }

    public static ge4<gd4> j(gd4 gd4Var, zb4 zb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, gd4Var, zb4Var)) == null) {
            if (zb4Var == null || !b(gd4Var, zb4Var.z())) {
                return null;
            }
            return new ge4<>(new fe4(gd4Var), gd4Var, new de4(zb4Var.z()));
        }
        return (ge4) invokeLL.objValue;
    }

    public static List<ge4<fd4>> e(List<fd4> list, zb4 zb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, zb4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (zb4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (fd4 fd4Var : list) {
                    if (b(fd4Var, zb4Var.q())) {
                        arrayList.add(new ge4(new fe4(fd4Var), fd4Var, new de4(zb4Var.q())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<ge4<ye4.a>> f(List<ye4.a> list, zb4 zb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, zb4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (zb4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (ye4.a aVar : list) {
                    dd4 dd4Var = aVar.d;
                    if (dd4Var != null && b(aVar, zb4Var.v())) {
                        arrayList.add(new ge4(new fe4(dd4Var), aVar, new de4(zb4Var.v())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<ge4<ed4>> h(List<ed4> list, zb4 zb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, zb4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (zb4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (ed4 ed4Var : list) {
                    if (b(ed4Var, zb4Var.A())) {
                        arrayList.add(new ge4(new fe4(ed4Var), ed4Var, new de4(zb4Var.A())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, vb4<T> vb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, vb4Var) == null) {
            vb4Var.e(t, new yc4(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
