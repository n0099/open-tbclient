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
public class ha9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Comparator<ay4> {
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
        public int compare(ay4 ay4Var, ay4 ay4Var2) {
            InterceptResult invokeLL;
            int g;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ay4Var, ay4Var2)) == null) {
                if (ay4Var.j() && ay4Var2.j()) {
                    return ay4Var.p() - ay4Var2.p();
                }
                int i = -1;
                if (!ay4Var.j() && !ay4Var2.j()) {
                    if (ay4Var.B() == null) {
                        g = -1;
                    } else {
                        g = ha9.g(ay4Var.B());
                    }
                    if (ay4Var2.B() != null) {
                        i = ha9.g(ay4Var2.B());
                    }
                    return g - i;
                } else if (ay4Var.j()) {
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
        AdvertAppInfo B;
        AdvertAppInfo B2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, list, i, str)) == null) {
            HashSet hashSet = new HashSet();
            if (ue8.e(list)) {
                return hashSet;
            }
            Set<in> a2 = pc9.a(str);
            if (a2 == null) {
                a2 = new HashSet();
            }
            for (in inVar : list) {
                if (inVar != null) {
                    for (in inVar2 : a2) {
                        if ((inVar instanceof ay4) && (B2 = ((ay4) inVar).B()) != null && inVar2.hashCode() == B2.hashCode()) {
                            B2.i = ((AdvertAppInfo) inVar2).i;
                        }
                    }
                    if ((inVar instanceof ay4) && (B = ((ay4) inVar).B()) != null && B.i == null) {
                        pw4 pw4Var = new pw4();
                        B.i = pw4Var;
                        pw4Var.a = str;
                        pw4Var.b = i;
                        pw4Var.g = B.g;
                        pw4Var.h = false;
                        hashSet.add(B);
                    }
                }
            }
            a2.addAll(hashSet);
            pc9.b(str, a2);
            return hashSet;
        }
        return (Set) invokeLIL.objValue;
    }

    public static List<ay4> i(List<ay4> list, List<in> list2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, list, list2, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ue8.e(list)) {
                return arrayList;
            }
            o(list);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ay4 ay4Var = (ay4) ue8.d(list, i4);
                if (ay4Var != null && ay4Var.B() != null) {
                    int i5 = ue8.i(list2);
                    int g = g(ay4Var.B()) - 1;
                    if (g < 0) {
                        n(ay4Var.B());
                    } else {
                        if (ay4Var.j()) {
                            i2 = ay4Var.p();
                        } else {
                            i2 = g + i;
                        }
                        if (i2 > i5) {
                            n(ay4Var.B());
                        } else {
                            ay4Var.setPosition(i2);
                            ue8.b(list2, ay4Var, i2);
                            arrayList.add(ay4Var);
                        }
                    }
                }
            }
            while (i < ue8.i(list2)) {
                in inVar = list2.get(i);
                if (inVar instanceof ay4) {
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
            if (ue8.e(list)) {
                return 0;
            }
            int i2 = -1;
            for (int i3 = ue8.i(list) - 1; i3 >= 0 && !(ue8.d(list, i3) instanceof ay4); i3--) {
                if (ue8.d(list, i3) instanceof pz4) {
                    int i4 = ((pz4) ue8.d(list, i3)).position;
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
        if ((interceptable != null && interceptable.invokeL(65538, null, list) != null) || ue8.e(list)) {
            return;
        }
        Iterator<in> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof ay4) {
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
            int i = advertAppInfo.i();
            if (g(advertAppInfo) < 0) {
                return 23;
            }
            return i;
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

    public static void o(List<ay4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, list) == null) {
            Collections.sort(list, new a());
        }
    }

    public static void p(List<in> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, list) == null) {
            for (int i = 0; i < ue8.i(list); i++) {
                if (ue8.d(list, i) instanceof ay4) {
                    ((ay4) ue8.d(list, i)).setPosition(i);
                }
            }
        }
    }

    public static void d(String str, List list) {
        ThreadData threadData;
        yl9 yl9Var;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, str, list) != null) || ue8.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            i++;
            Object next = it.next();
            if (StringUtils.isNull(str)) {
                if (!(next instanceof App) && !(next instanceof ay4)) {
                    if ((next instanceof pz4) && (threadData = ((pz4) next).t) != null && (yl9Var = threadData.funAdData) != null) {
                        yl9Var.p(true);
                        it.remove();
                    }
                } else {
                    it.remove();
                }
            } else {
                if (i2 + 1 == i && (next instanceof wz5)) {
                    it.remove();
                }
                if (next instanceof App) {
                    str2 = ia9.a((App) next);
                } else {
                    if (next instanceof ay4) {
                        ay4 ay4Var = (ay4) next;
                        if (ay4Var.B() != null) {
                            str2 = ay4Var.B().a;
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
        ay4 ay4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !ue8.e(list)) {
                int i = 0;
                for (int i2 = ue8.i(list) - 1; i2 >= 0 && i < 6; i2--) {
                    if ((ue8.d(list, i2) instanceof ay4) && (ay4Var = (ay4) ue8.d(list, i2)) != null && !l(ay4Var.B())) {
                        sb.append(ay4Var.p() + 1);
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

    public static List<ay4> h(List<App> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ue8.e(list)) {
                return arrayList;
            }
            Log.e("frs", "src ad list size " + list.size());
            for (App app : list) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.l(app);
                advertAppInfo.j = str;
                int k = k(advertAppInfo);
                if (k != 0) {
                    rc9.h(advertAppInfo, 1, k);
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
            rc9.h(advertAppInfo, 1, i);
        }
    }
}
