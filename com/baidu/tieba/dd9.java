package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
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
public class dd9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Comparator<qy4> {
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
        public int compare(qy4 qy4Var, qy4 qy4Var2) {
            InterceptResult invokeLL;
            int g;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, qy4Var, qy4Var2)) == null) {
                if (qy4Var.l() && qy4Var2.l()) {
                    return qy4Var.s() - qy4Var2.s();
                }
                int i = -1;
                if (!qy4Var.l() && !qy4Var2.l()) {
                    if (qy4Var.H() == null) {
                        g = -1;
                    } else {
                        g = dd9.g(qy4Var.H());
                    }
                    if (qy4Var2.H() != null) {
                        i = dd9.g(qy4Var2.H());
                    }
                    return g - i;
                } else if (qy4Var.l()) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return invokeLL.intValue;
        }
    }

    public static Set<in> a(List<in> list, int i, String str) {
        InterceptResult invokeLIL;
        AdvertAppInfo H;
        AdvertAppInfo H2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, list, i, str)) == null) {
            HashSet hashSet = new HashSet();
            if (ch8.e(list)) {
                return hashSet;
            }
            Set<in> a2 = mf9.a(str);
            if (a2 == null) {
                a2 = new HashSet();
            }
            for (in inVar : list) {
                if (inVar != null) {
                    for (in inVar2 : a2) {
                        if ((inVar instanceof qy4) && (H2 = ((qy4) inVar).H()) != null && inVar2.hashCode() == H2.hashCode()) {
                            H2.i = ((AdvertAppInfo) inVar2).i;
                        }
                    }
                    if ((inVar instanceof qy4) && (H = ((qy4) inVar).H()) != null && H.i == null) {
                        fx4 fx4Var = new fx4();
                        H.i = fx4Var;
                        fx4Var.a = str;
                        fx4Var.b = i;
                        fx4Var.g = H.g;
                        fx4Var.h = false;
                        hashSet.add(H);
                    }
                }
            }
            a2.addAll(hashSet);
            mf9.b(str, a2);
            return hashSet;
        }
        return (Set) invokeLIL.objValue;
    }

    public static List<qy4> i(List<qy4> list, List<in> list2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, list, list2, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ch8.e(list)) {
                return arrayList;
            }
            o(list);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                qy4 qy4Var = (qy4) ch8.d(list, i4);
                if (qy4Var != null && qy4Var.H() != null) {
                    int i5 = ch8.i(list2);
                    int g = g(qy4Var.H()) - 1;
                    if (g < 0) {
                        n(qy4Var.H());
                    } else {
                        if (qy4Var.l()) {
                            i2 = qy4Var.s();
                        } else {
                            i2 = g + i;
                        }
                        if (i2 > i5) {
                            n(qy4Var.H());
                        } else {
                            qy4Var.setPosition(i2);
                            ch8.b(list2, qy4Var, i2);
                            arrayList.add(qy4Var);
                        }
                    }
                }
            }
            while (i < ch8.i(list2)) {
                in inVar = list2.get(i);
                if (inVar instanceof qy4) {
                    i3++;
                } else if (inVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) inVar).position += i3;
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeLLI.objValue;
    }

    public static int b(@NonNull List<in> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            int i = 0;
            if (ch8.e(list)) {
                return 0;
            }
            int i2 = -1;
            for (int i3 = ch8.i(list) - 1; i3 >= 0 && !(ch8.d(list, i3) instanceof qy4); i3--) {
                if (ch8.d(list, i3) instanceof f05) {
                    int i4 = ((f05) ch8.d(list, i3)).position;
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

    public static void c(List<in> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, list) != null) || ch8.e(list)) {
            return;
        }
        Iterator<in> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof qy4) {
                it.remove();
            }
        }
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
            return gg.e(advertAppInfo.f, -1);
        }
        return invokeL.intValue;
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
            int h = advertAppInfo.h();
            if (g(advertAppInfo) < 0) {
                return 23;
            }
            return h;
        }
        return invokeL.intValue;
    }

    public static boolean l(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, advertAppInfo)) == null) {
            return advertAppInfo.b();
        }
        return invokeL.booleanValue;
    }

    public static void n(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, advertAppInfo) == null) {
            m(advertAppInfo, 23);
        }
    }

    public static void o(List<qy4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, list) == null) {
            Collections.sort(list, new a());
        }
    }

    public static void p(List<in> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, list) == null) {
            for (int i = 0; i < ch8.i(list); i++) {
                if (ch8.d(list, i) instanceof qy4) {
                    ((qy4) ch8.d(list, i)).setPosition(i);
                }
            }
        }
    }

    public static void d(String str, List list) {
        ThreadData threadData;
        np9 np9Var;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, str, list) != null) || ch8.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            i++;
            Object next = it.next();
            if (StringUtils.isNull(str)) {
                if (!(next instanceof App) && !(next instanceof qy4)) {
                    if ((next instanceof f05) && (threadData = ((f05) next).t) != null && (np9Var = threadData.funAdData) != null) {
                        np9Var.p(true);
                        it.remove();
                    }
                } else {
                    it.remove();
                }
            } else {
                if (i2 + 1 == i && (next instanceof x06)) {
                    it.remove();
                }
                if (next instanceof App) {
                    str2 = ed9.a((App) next);
                } else {
                    if (next instanceof qy4) {
                        qy4 qy4Var = (qy4) next;
                        if (qy4Var.H() != null) {
                            str2 = qy4Var.H().a;
                        }
                    }
                    str2 = "";
                }
                if (TextUtils.equals(str, str2)) {
                    it.remove();
                    i2 = i;
                }
            }
        }
    }

    public static String e(List<in> list, boolean z) {
        InterceptResult invokeLZ;
        qy4 qy4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !ch8.e(list)) {
                int i = 0;
                for (int i2 = ch8.i(list) - 1; i2 >= 0 && i < 6; i2--) {
                    if ((ch8.d(list, i2) instanceof qy4) && (qy4Var = (qy4) ch8.d(list, i2)) != null && !l(qy4Var.H())) {
                        sb.append(qy4Var.s() + 1);
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

    public static List<qy4> h(List<App> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ch8.e(list)) {
                return arrayList;
            }
            Log.e("frs", "src ad list size " + list.size());
            for (App app : list) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.k(app);
                advertAppInfo.j = str;
                int k = k(advertAppInfo);
                if (k != 0) {
                    of9.h(advertAppInfo, 1, k);
                } else {
                    arrayList.add(advertAppInfo);
                }
            }
            Log.e("frs", "src ad jiaoyan size " + arrayList.size());
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static void m(AdvertAppInfo advertAppInfo, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65548, null, advertAppInfo, i) == null) {
            of9.h(advertAppInfo, 1, i);
        }
    }
}
