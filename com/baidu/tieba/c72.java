package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ne4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.facebook.common.internal.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public final class c72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final Set b;
    public static final Map c;
    public static int d;
    public static final hi3 e;
    public static final hi3 f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public final class a implements hi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public String b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? str : (String) invokeL.objValue;
        }

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

        @Override // com.baidu.tieba.hi3
        public /* bridge */ /* synthetic */ Object a(Object obj) {
            String str = (String) obj;
            b(str);
            return str;
        }
    }

    /* loaded from: classes3.dex */
    public final class b implements hi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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
        @Override // com.baidu.tieba.hi3
        /* renamed from: b */
        public String a(ne4.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                if (aVar == null) {
                    return "";
                }
                return aVar.b();
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947627595, "Lcom/baidu/tieba/c72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947627595, "Lcom/baidu/tieba/c72;");
                return;
            }
        }
        a = wj1.a;
        b = Sets.newHashSet(0, 1010, 1011, 1012, 1020, 1015);
        c = new ConcurrentHashMap();
        d = 1800;
        e = new a();
        f = new b();
    }

    public static Object a(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, obj)) == null) {
            if (a) {
                Log.i("PreDownloadUtils", "Recorded=" + c.size() + " # " + str + " => " + obj);
            }
            return obj;
        }
        return invokeLL.objValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            Long l = (Long) c.get(str);
            if (l == null || System.currentTimeMillis() - l.longValue() > d * 1000) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return g(str, true);
        }
        return invokeL.booleanValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            return g(str, false);
        }
        return invokeL.booleanValue;
    }

    public static List h(Collection collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, collection)) == null) {
            return j(e, collection);
        }
        return (List) invokeL.objValue;
    }

    public static List i(Collection collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, collection)) == null) {
            return j(f, collection);
        }
        return (List) invokeL.objValue;
    }

    public static boolean l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i)) == null) {
            return b.contains(Integer.valueOf(i));
        }
        return invokeI.booleanValue;
    }

    public static boolean m(gc4 gc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, gc4Var)) == null) {
            if (gc4Var != null && l(gc4Var.a)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            if (str2 != null) {
                str = str + str2;
            }
            return c(str);
        }
        return invokeLL.booleanValue;
    }

    public static boolean f(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, str2)) == null) {
            if (str2 != null && str != null) {
                str = str + str2;
            }
            return e(str);
        }
        return invokeLL.booleanValue;
    }

    public static List j(hi3 hi3Var, Collection collection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, hi3Var, collection)) == null) {
            return k(hi3Var, collection, false);
        }
        return (List) invokeLL.objValue;
    }

    public static boolean g(String str, boolean z) {
        InterceptResult invokeLZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65543, null, str, z)) == null) {
            String str2 = "shouldDownloadItem app=" + str + " record=" + z + ZeusCrashHandler.NAME_SEPERATOR;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (z) {
                c.put(str, Long.valueOf(System.currentTimeMillis()));
                z2 = true;
            } else {
                z2 = !c.containsKey(str);
            }
            Boolean valueOf = Boolean.valueOf(z2);
            a(str2 + " should", valueOf);
            if (!valueOf.booleanValue()) {
                Boolean valueOf2 = Boolean.valueOf(b(str));
                a(str2 + " AB", valueOf2);
                if (!valueOf2.booleanValue()) {
                    return false;
                }
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public static List k(hi3 hi3Var, Collection collection, boolean z) {
        InterceptResult invokeLLZ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65547, null, hi3Var, collection, z)) == null) {
            ArrayList arrayList = new ArrayList();
            if (collection != null) {
                for (Object obj : collection) {
                    if (obj == null) {
                        str = "";
                    } else {
                        str = (String) hi3Var.a(obj);
                    }
                    if (g(str, z)) {
                        arrayList.add(obj);
                    }
                }
                a("shouldDownloadSet", "record=" + z + " targets=" + collection.size() + " should=" + arrayList.size());
            }
            return arrayList;
        }
        return (List) invokeLLZ.objValue;
    }

    public static boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            if (str == null) {
                return false;
            }
            Iterator it = c.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (entry != null && entry.getKey() != null && ((String) entry.getKey()).startsWith(str)) {
                    it.remove();
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
