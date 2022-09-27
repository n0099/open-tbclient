package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tbclient.App;
/* loaded from: classes4.dex */
public class fd8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Comparator<ms4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(ms4 ms4Var, ms4 ms4Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ms4Var, ms4Var2)) == null) {
                if (ms4Var.e() && ms4Var2.e()) {
                    return ms4Var.i() - ms4Var2.i();
                }
                if (ms4Var.e() || ms4Var2.e()) {
                    return ms4Var.e() ? -1 : 1;
                }
                return (ms4Var.p() == null ? -1 : fd8.g(ms4Var.p())) - (ms4Var2.p() != null ? fd8.g(ms4Var2.p()) : -1);
            }
            return invokeLL.intValue;
        }
    }

    public static Set<Cdo> a(List<Cdo> list, int i, String str) {
        InterceptResult invokeLIL;
        AdvertAppInfo p;
        AdvertAppInfo p2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, list, i, str)) == null) {
            HashSet hashSet = new HashSet();
            if (ah7.e(list)) {
                return hashSet;
            }
            Set<Cdo> a2 = mf8.a(str);
            if (a2 == null) {
                a2 = new HashSet();
            }
            for (Cdo cdo : list) {
                if (cdo != null) {
                    for (Cdo cdo2 : a2) {
                        if ((cdo instanceof ms4) && (p2 = ((ms4) cdo).p()) != null && cdo2.hashCode() == p2.hashCode()) {
                            p2.i = ((AdvertAppInfo) cdo2).i;
                        }
                    }
                    if ((cdo instanceof ms4) && (p = ((ms4) cdo).p()) != null && p.i == null) {
                        dr4 dr4Var = new dr4();
                        p.i = dr4Var;
                        dr4Var.a = str;
                        dr4Var.b = i;
                        dr4Var.g = p.g;
                        dr4Var.h = false;
                        hashSet.add(p);
                    }
                }
            }
            a2.addAll(hashSet);
            mf8.b(str, a2);
            return hashSet;
        }
        return (Set) invokeLIL.objValue;
    }

    public static int b(@NonNull List<Cdo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            int i = 0;
            if (ah7.e(list)) {
                return 0;
            }
            int i2 = -1;
            for (int i3 = ah7.i(list) - 1; i3 >= 0 && !(ah7.d(list, i3) instanceof ms4); i3--) {
                if (ah7.d(list, i3) instanceof bu4) {
                    int i4 = ((bu4) ah7.d(list, i3)).position;
                    if (i4 != i2) {
                        i++;
                        i2 = i4;
                    }
                } else {
                    i++;
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static void c(List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, list) == null) || ah7.e(list)) {
            return;
        }
        Iterator<Cdo> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof ms4) {
                it.remove();
            }
        }
    }

    public static void d(String str, List list) {
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, list) == null) || TextUtils.isEmpty(str) || ah7.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            boolean z = next instanceof ms4;
            if (z || (next instanceof App)) {
                if (next instanceof App) {
                    str2 = gd8.a((App) next);
                } else {
                    if (z) {
                        ms4 ms4Var = (ms4) next;
                        if (ms4Var.p() != null) {
                            str2 = ms4Var.p().a;
                        }
                    }
                    str2 = "";
                }
                if (TextUtils.equals(str, str2)) {
                    it.remove();
                }
            }
        }
    }

    public static String e(List<Cdo> list, boolean z) {
        InterceptResult invokeLZ;
        ms4 ms4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !ah7.e(list)) {
                int i = 0;
                for (int i2 = ah7.i(list) - 1; i2 >= 0 && i < 6; i2--) {
                    if ((ah7.d(list, i2) instanceof ms4) && (ms4Var = (ms4) ah7.d(list, i2)) != null && !l(ms4Var.p())) {
                        sb.append(ms4Var.i() + 1);
                        sb.append(",");
                        i++;
                    }
                }
                if (sb.length() <= 1) {
                    return sb.toString();
                }
                sb.deleteCharAt(sb.length() - 1);
                return sb.toString();
            }
            return sb.toString();
        }
        return (String) invokeLZ.objValue;
    }

    public static String f(@NonNull AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, advertAppInfo)) == null) {
            return "#Nad=" + advertAppInfo.g;
        }
        return (String) invokeL.objValue;
    }

    public static int g(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, advertAppInfo)) == null) {
            if (advertAppInfo == null) {
                return 0;
            }
            if (TextUtils.isEmpty(advertAppInfo.f)) {
                return -1;
            }
            return dh.e(advertAppInfo.f, -1);
        }
        return invokeL.intValue;
    }

    public static List<ms4> h(List<App> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ah7.e(list)) {
                return arrayList;
            }
            Log.e("frs", "src ad list size " + list.size());
            for (App app : list) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.s(app);
                advertAppInfo.j = str;
                int k = k(advertAppInfo);
                if (k != 0) {
                    of8.h(advertAppInfo, 1, k);
                } else {
                    arrayList.add(advertAppInfo);
                }
            }
            Log.e("frs", "src ad jiaoyan size " + arrayList.size());
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<ms4> i(List<ms4> list, List<Cdo> list2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, list, list2, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ah7.e(list)) {
                return arrayList;
            }
            o(list);
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                ms4 ms4Var = (ms4) ah7.d(list, i3);
                if (ms4Var != null && ms4Var.p() != null) {
                    int i4 = ah7.i(list2);
                    int g = g(ms4Var.p()) - 1;
                    if (g < 0) {
                        n(ms4Var.p());
                    } else {
                        int i5 = ms4Var.e() ? ms4Var.i() : g + i;
                        if (i5 > i4) {
                            n(ms4Var.p());
                        } else {
                            ms4Var.setPosition(i5);
                            ah7.b(list2, ms4Var, i5);
                            arrayList.add(ms4Var);
                        }
                    }
                }
            }
            while (i < ah7.i(list2)) {
                Cdo cdo = list2.get(i);
                if (cdo instanceof ms4) {
                    i2++;
                } else if (cdo instanceof BaseCardInfo) {
                    ((BaseCardInfo) cdo).position += i2;
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeLLI.objValue;
    }

    public static boolean j(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("#Nad=");
        }
        return invokeL.booleanValue;
    }

    public static int k(@Nullable AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, advertAppInfo)) == null) {
            int n = advertAppInfo.n();
            if (g(advertAppInfo) < 0) {
                return 23;
            }
            return n;
        }
        return invokeL.intValue;
    }

    public static boolean l(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, advertAppInfo)) == null) ? advertAppInfo.b() : invokeL.booleanValue;
    }

    public static void m(AdvertAppInfo advertAppInfo, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65548, null, advertAppInfo, i) == null) {
            of8.h(advertAppInfo, 1, i);
        }
    }

    public static void n(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, advertAppInfo) == null) {
            m(advertAppInfo, 23);
        }
    }

    public static void o(List<ms4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, list) == null) {
            Collections.sort(list, new a());
        }
    }

    public static void p(List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, list) == null) {
            for (int i = 0; i < ah7.i(list); i++) {
                if (ah7.d(list, i) instanceof ms4) {
                    ((ms4) ah7.d(list, i)).setPosition(i);
                }
            }
        }
    }
}
