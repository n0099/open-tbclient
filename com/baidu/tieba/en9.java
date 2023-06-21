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
/* loaded from: classes5.dex */
public class en9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Comparator<z25> {
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
        public int compare(z25 z25Var, z25 z25Var2) {
            InterceptResult invokeLL;
            int g;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, z25Var, z25Var2)) == null) {
                if (z25Var.j() && z25Var2.j()) {
                    return z25Var.r() - z25Var2.r();
                }
                int i = -1;
                if (!z25Var.j() && !z25Var2.j()) {
                    if (z25Var.G() == null) {
                        g = -1;
                    } else {
                        g = en9.g(z25Var.G());
                    }
                    if (z25Var2.G() != null) {
                        i = en9.g(z25Var2.G());
                    }
                    return g - i;
                } else if (z25Var.j()) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return invokeLL.intValue;
        }
    }

    public static Set<wn> a(List<wn> list, int i, String str) {
        InterceptResult invokeLIL;
        AdvertAppInfo G;
        AdvertAppInfo G2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, list, i, str)) == null) {
            HashSet hashSet = new HashSet();
            if (sp8.e(list)) {
                return hashSet;
            }
            Set<wn> a2 = np9.a(str);
            if (a2 == null) {
                a2 = new HashSet();
            }
            for (wn wnVar : list) {
                if (wnVar != null) {
                    for (wn wnVar2 : a2) {
                        if ((wnVar instanceof z25) && (G2 = ((z25) wnVar).G()) != null && wnVar2.hashCode() == G2.hashCode()) {
                            G2.i = ((AdvertAppInfo) wnVar2).i;
                        }
                    }
                    if ((wnVar instanceof z25) && (G = ((z25) wnVar).G()) != null && G.i == null) {
                        n15 n15Var = new n15();
                        G.i = n15Var;
                        n15Var.a = str;
                        n15Var.b = i;
                        n15Var.g = G.g;
                        n15Var.h = false;
                        hashSet.add(G);
                    }
                }
            }
            a2.addAll(hashSet);
            np9.b(str, a2);
            return hashSet;
        }
        return (Set) invokeLIL.objValue;
    }

    public static List<z25> i(List<z25> list, List<wn> list2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, list, list2, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (sp8.e(list)) {
                return arrayList;
            }
            o(list);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                z25 z25Var = (z25) sp8.d(list, i4);
                if (z25Var != null && z25Var.G() != null) {
                    int i5 = sp8.i(list2);
                    int g = g(z25Var.G()) - 1;
                    if (g < 0) {
                        n(z25Var.G());
                    } else {
                        if (z25Var.j()) {
                            i2 = z25Var.r();
                        } else {
                            i2 = g + i;
                        }
                        if (i2 > i5) {
                            n(z25Var.G());
                        } else {
                            z25Var.setPosition(i2);
                            sp8.b(list2, z25Var, i2);
                            arrayList.add(z25Var);
                        }
                    }
                }
            }
            while (i < sp8.i(list2)) {
                wn wnVar = list2.get(i);
                if (wnVar instanceof z25) {
                    i3++;
                } else if (wnVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) wnVar).position += i3;
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeLLI.objValue;
    }

    public static int b(@NonNull List<wn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            int i = 0;
            if (sp8.e(list)) {
                return 0;
            }
            int i2 = -1;
            for (int i3 = sp8.i(list) - 1; i3 >= 0 && !(sp8.d(list, i3) instanceof z25); i3--) {
                if (sp8.d(list, i3) instanceof o45) {
                    int i4 = ((o45) sp8.d(list, i3)).position;
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

    public static void c(List<wn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, list) != null) || sp8.e(list)) {
            return;
        }
        Iterator<wn> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof z25) {
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
            return ug.e(advertAppInfo.f, -1);
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

    public static void o(List<z25> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, list) == null) {
            Collections.sort(list, new a());
        }
    }

    public static void p(List<wn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, list) == null) {
            for (int i = 0; i < sp8.i(list); i++) {
                if (sp8.d(list, i) instanceof z25) {
                    ((z25) sp8.d(list, i)).setPosition(i);
                }
            }
        }
    }

    public static void d(String str, List list) {
        ThreadData threadData;
        zz9 zz9Var;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, str, list) != null) || sp8.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            i++;
            Object next = it.next();
            if (StringUtils.isNull(str)) {
                if (!(next instanceof App) && !(next instanceof z25)) {
                    if ((next instanceof o45) && (threadData = ((o45) next).t) != null && (zz9Var = threadData.funAdData) != null) {
                        zz9Var.p(true);
                        it.remove();
                    }
                } else {
                    it.remove();
                }
            } else {
                if (i2 + 1 == i && (next instanceof r66)) {
                    it.remove();
                }
                if (next instanceof App) {
                    str2 = fn9.a((App) next);
                } else {
                    if (next instanceof z25) {
                        z25 z25Var = (z25) next;
                        if (z25Var.G() != null) {
                            str2 = z25Var.G().a;
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

    public static String e(List<wn> list, boolean z) {
        InterceptResult invokeLZ;
        z25 z25Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !sp8.e(list)) {
                int i = 0;
                for (int i2 = sp8.i(list) - 1; i2 >= 0 && i < 6; i2--) {
                    if ((sp8.d(list, i2) instanceof z25) && (z25Var = (z25) sp8.d(list, i2)) != null && !l(z25Var.G())) {
                        sb.append(z25Var.r() + 1);
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

    public static List<z25> h(List<App> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (sp8.e(list)) {
                return arrayList;
            }
            Log.e("frs", "src ad list size " + list.size());
            for (App app : list) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.l(app);
                advertAppInfo.j = str;
                int k = k(advertAppInfo);
                if (k != 0) {
                    pp9.h(advertAppInfo, 1, k);
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
            pp9.h(advertAppInfo, 1, i);
        }
    }
}
