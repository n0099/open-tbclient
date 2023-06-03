package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.sm4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class cm4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(pj4<T> pj4Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, pj4Var, t, str, str2)) == null) {
            if (t == null || pj4Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, pj4Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, TTDownloadField.TT_DOWNLOAD_URL, pj4Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, pj4<T> pj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, pj4Var)) == null) {
            if (pj4Var == null || t == null) {
                return false;
            }
            if (t instanceof wk4) {
                wk4 wk4Var = (wk4) t;
                return a(pj4Var, t, wk4Var.l, wk4Var.n);
            } else if (!(t instanceof sm4.a)) {
                return false;
            } else {
                xk4 xk4Var = ((sm4.a) t).d;
                return a(pj4Var, t, xk4Var.l, xk4Var.n);
            }
        }
        return invokeLL.booleanValue;
    }

    public static am4<tk4> c(tk4 tk4Var, tj4 tj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tk4Var, tj4Var)) == null) {
            if (tj4Var == null || !b(tk4Var, tj4Var.r())) {
                return null;
            }
            return new am4<>(new zl4(tk4Var), tk4Var, new xl4(tj4Var.r()));
        }
        return (am4) invokeLL.objValue;
    }

    public static am4<vk4> d(vk4 vk4Var, tj4 tj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, vk4Var, tj4Var)) == null) {
            if (tj4Var == null || !b(vk4Var, tj4Var.s())) {
                return null;
            }
            return new am4<>(new zl4(vk4Var), vk4Var, new xl4(tj4Var.s()));
        }
        return (am4) invokeLL.objValue;
    }

    public static am4<xk4> g(xk4 xk4Var, tj4 tj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, xk4Var, tj4Var)) == null) {
            if (tj4Var == null || !b(xk4Var, tj4Var.u())) {
                return null;
            }
            return new am4<>(new zl4(xk4Var), xk4Var, new xl4(tj4Var.u()));
        }
        return (am4) invokeLL.objValue;
    }

    public static am4<zk4> i(zk4 zk4Var, tj4 tj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, zk4Var, tj4Var)) == null) {
            if (tj4Var == null || !b(zk4Var, tj4Var.x())) {
                return null;
            }
            return new am4<>(new zl4(zk4Var), zk4Var, new xl4(tj4Var.x()));
        }
        return (am4) invokeLL.objValue;
    }

    public static am4<al4> j(al4 al4Var, tj4 tj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, al4Var, tj4Var)) == null) {
            if (tj4Var == null || !b(al4Var, tj4Var.z())) {
                return null;
            }
            return new am4<>(new zl4(al4Var), al4Var, new xl4(tj4Var.z()));
        }
        return (am4) invokeLL.objValue;
    }

    public static List<am4<zk4>> e(List<zk4> list, tj4 tj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, tj4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (tj4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (zk4 zk4Var : list) {
                    if (b(zk4Var, tj4Var.q())) {
                        arrayList.add(new am4(new zl4(zk4Var), zk4Var, new xl4(tj4Var.q())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<am4<sm4.a>> f(List<sm4.a> list, tj4 tj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, tj4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (tj4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (sm4.a aVar : list) {
                    xk4 xk4Var = aVar.d;
                    if (xk4Var != null && b(aVar, tj4Var.v())) {
                        arrayList.add(new am4(new zl4(xk4Var), aVar, new xl4(tj4Var.v())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<am4<yk4>> h(List<yk4> list, tj4 tj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, tj4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (tj4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (yk4 yk4Var : list) {
                    if (b(yk4Var, tj4Var.A())) {
                        arrayList.add(new am4(new zl4(yk4Var), yk4Var, new xl4(tj4Var.A())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, pj4<T> pj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, pj4Var) == null) {
            pj4Var.e(t, new sk4(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
