package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
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
/* loaded from: classes5.dex */
public class bca {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Comparator<tx4> {
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
        public int compare(tx4 tx4Var, tx4 tx4Var2) {
            InterceptResult invokeLL;
            int g;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tx4Var, tx4Var2)) == null) {
                if (tx4Var.k() && tx4Var2.k()) {
                    return tx4Var.m() - tx4Var2.m();
                }
                int i = -1;
                if (!tx4Var.k() && !tx4Var2.k()) {
                    if (tx4Var.B() == null) {
                        g = -1;
                    } else {
                        g = bca.g(tx4Var.B());
                    }
                    if (tx4Var2.B() != null) {
                        i = bca.g(tx4Var2.B());
                    }
                    return g - i;
                } else if (tx4Var.k()) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return invokeLL.intValue;
        }
    }

    public static Set<oi> a(List<oi> list, int i, String str) {
        InterceptResult invokeLIL;
        AdvertAppInfo B;
        AdvertAppInfo B2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, list, i, str)) == null) {
            HashSet hashSet = new HashSet();
            if (ic9.e(list)) {
                return hashSet;
            }
            Set<oi> a2 = lea.a(str);
            if (a2 == null) {
                a2 = new HashSet();
            }
            for (oi oiVar : list) {
                if (oiVar != null) {
                    for (oi oiVar2 : a2) {
                        if ((oiVar instanceof tx4) && (B2 = ((tx4) oiVar).B()) != null && oiVar2.hashCode() == B2.hashCode()) {
                            B2.i = ((AdvertAppInfo) oiVar2).i;
                        }
                    }
                    if ((oiVar instanceof tx4) && (B = ((tx4) oiVar).B()) != null && B.i == null) {
                        gw4 gw4Var = new gw4();
                        B.i = gw4Var;
                        gw4Var.a = str;
                        gw4Var.b = i;
                        gw4Var.g = B.g;
                        gw4Var.h = false;
                        hashSet.add(B);
                    }
                }
            }
            a2.addAll(hashSet);
            lea.b(str, a2);
            return hashSet;
        }
        return (Set) invokeLIL.objValue;
    }

    public static List<tx4> i(List<tx4> list, List<oi> list2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, list, list2, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ic9.e(list)) {
                return arrayList;
            }
            o(list);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                tx4 tx4Var = (tx4) ic9.d(list, i4);
                if (tx4Var != null && tx4Var.B() != null) {
                    int i5 = ic9.i(list2);
                    int g = g(tx4Var.B()) - 1;
                    if (g < 0) {
                        n(tx4Var.B());
                    } else {
                        if (tx4Var.k()) {
                            i2 = tx4Var.m();
                        } else {
                            i2 = g + i;
                        }
                        if (i2 > i5) {
                            n(tx4Var.B());
                        } else {
                            tx4Var.setPosition(i2);
                            ic9.b(list2, tx4Var, i2);
                            arrayList.add(tx4Var);
                        }
                    }
                }
            }
            while (i < ic9.i(list2)) {
                oi oiVar = list2.get(i);
                if (oiVar instanceof tx4) {
                    i3++;
                } else if (oiVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) oiVar).position += i3;
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeLLI.objValue;
    }

    public static int b(@NonNull List<oi> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            int i = 0;
            if (ic9.e(list)) {
                return 0;
            }
            int i2 = -1;
            for (int i3 = ic9.i(list) - 1; i3 >= 0 && !(ic9.d(list, i3) instanceof tx4); i3--) {
                if (ic9.d(list, i3) instanceof hz4) {
                    int i4 = ((hz4) ic9.d(list, i3)).position;
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

    public static void c(List<oi> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, list) != null) || ic9.e(list)) {
            return;
        }
        Iterator<oi> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof tx4) {
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
            return JavaTypesHelper.toInt(advertAppInfo.f, -1);
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

    public static void o(List<tx4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, list) == null) {
            Collections.sort(list, new a());
        }
    }

    public static void p(List<oi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, list) == null) {
            for (int i = 0; i < ic9.i(list); i++) {
                if (ic9.d(list, i) instanceof tx4) {
                    ((tx4) ic9.d(list, i)).setPosition(i);
                }
            }
        }
    }

    public static void d(String str, List list) {
        ThreadData threadData;
        sra sraVar;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, str, list) != null) || ic9.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            i++;
            Object next = it.next();
            if (StringUtils.isNull(str)) {
                if (!(next instanceof App) && !(next instanceof tx4)) {
                    if ((next instanceof hz4) && (threadData = ((hz4) next).t) != null && (sraVar = threadData.funAdData) != null) {
                        sraVar.p(true);
                        it.remove();
                    }
                } else {
                    it.remove();
                }
            } else {
                if (i2 + 1 == i && (next instanceof z26)) {
                    it.remove();
                }
                if (next instanceof App) {
                    str2 = cca.a((App) next);
                } else {
                    if (next instanceof tx4) {
                        tx4 tx4Var = (tx4) next;
                        if (tx4Var.B() != null) {
                            str2 = tx4Var.B().a;
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

    public static String e(List<oi> list, boolean z) {
        InterceptResult invokeLZ;
        tx4 tx4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !ic9.e(list)) {
                int i = 0;
                for (int i2 = ic9.i(list) - 1; i2 >= 0 && i < 6; i2--) {
                    if ((ic9.d(list, i2) instanceof tx4) && (tx4Var = (tx4) ic9.d(list, i2)) != null && !l(tx4Var.B())) {
                        sb.append(tx4Var.m() + 1);
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

    public static List<tx4> h(List<App> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ic9.e(list)) {
                return arrayList;
            }
            Log.e("frs", "src ad list size " + list.size());
            for (App app : list) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.l(app);
                advertAppInfo.j = str;
                int k = k(advertAppInfo);
                if (k != 0) {
                    nea.h(advertAppInfo, 1, k);
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
            nea.h(advertAppInfo, 1, i);
        }
    }
}
