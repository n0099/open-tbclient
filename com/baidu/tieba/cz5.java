package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.ra9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public final class cz5 implements ra9 {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern d;
    public static cz5 e;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ra9.a> a;
    public final ConcurrentHashMap<String, ra9.b> b;
    public ra9.c c;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ra9.a a;
        public final /* synthetic */ cz5 b;

        public a(cz5 cz5Var, ra9.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cz5Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cz5Var;
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.b.f(this.a);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947692075, "Lcom/baidu/tieba/cz5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947692075, "Lcom/baidu/tieba/cz5;");
                return;
            }
        }
        d = Pattern.compile(UrlManager.patternText, 2);
        e = new cz5();
    }

    public static cz5 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return e;
        }
        return (cz5) invokeV.objValue;
    }

    public cz5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new LinkedList();
        this.b = new ConcurrentHashMap<>();
        this.c = null;
    }

    @Override // com.baidu.tieba.ra9
    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str) || !d.matcher(str).find()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void e(ra9.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            if (ii.E()) {
                f(aVar);
            } else {
                jg.a().post(new a(this, aVar));
            }
        }
    }

    public final void f(ra9.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) && !this.a.contains(aVar)) {
            this.a.add(aVar);
        }
    }

    public final String k(String str) {
        InterceptResult invokeL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (StringUtils.isNull(str) || (lastIndexOf = str.lastIndexOf(":")) < 0) {
                return null;
            }
            return str.substring(lastIndexOf + 1);
        }
        return (String) invokeL.objValue;
    }

    public final String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            if (str.contains(":")) {
                return str.substring(0, str.lastIndexOf(":"));
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public void o(ra9.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.c = cVar;
        }
    }

    @Override // com.baidu.tieba.ra9
    public void b(Context context, String[] strArr, boolean z, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, strArr, Boolean.valueOf(z), bundle}) == null) {
            h(context, strArr, false, null, z, bundle);
        }
    }

    @Override // com.baidu.tieba.ra9
    public boolean c(Context context, String[] strArr, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, strArr, bundle)) == null) {
            return h(context, strArr, false, null, false, bundle);
        }
        return invokeLLL.booleanValue;
    }

    public boolean g(Context context, String str, String[] strArr, boolean z, ra9.d dVar, boolean z2, Bundle bundle) {
        InterceptResult invokeCommon;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{context, str, strArr, Boolean.valueOf(z), dVar, Boolean.valueOf(z2), bundle})) == null) {
            if (strArr == null || strArr.length == 0 || TextUtils.isEmpty(strArr[0])) {
                return false;
            }
            String str2 = strArr[0];
            ra9.b bVar = this.b.get(m(str2));
            if (bVar != null) {
                bVar.a(context, j(k(str2)));
                return true;
            }
            Iterator<ra9.a> it = this.a.iterator();
            while (true) {
                if (it.hasNext()) {
                    ra9.a next = it.next();
                    if (next != null && next.a(context, strArr) != 3) {
                        z3 = true;
                        break;
                    }
                } else {
                    z3 = false;
                    break;
                }
            }
            if (!z3 && this.c != null) {
                if (str2.contains("nohead:url") || str2.contains("booktown") || str2.contains("bookreader")) {
                    return true;
                }
                n(context, str, strArr[0], z, dVar, z2, bundle);
            }
            return z3;
        }
        return invokeCommon.booleanValue;
    }

    public boolean h(Context context, String[] strArr, boolean z, ra9.d dVar, boolean z2, Bundle bundle) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{context, strArr, Boolean.valueOf(z), dVar, Boolean.valueOf(z2), bundle})) == null) {
            return g(context, "", strArr, z, dVar, z2, bundle);
        }
        return invokeCommon.booleanValue;
    }

    public int i(Context context, String[] strArr) {
        InterceptResult invokeLL;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, context, strArr)) == null) {
            if (strArr != null && strArr.length != 0) {
                for (ra9.a aVar : this.a) {
                    if (aVar != null && (a2 = aVar.a(context, strArr)) != 3) {
                        return a2;
                    }
                }
            }
            return 3;
        }
        return invokeLL.intValue;
    }

    public final Map<String, String> j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            String[] split = str.split("[&]");
            if (split == null) {
                hashMap.put(UrlManager.DEFAULT_PARAM, str);
                return hashMap;
            }
            for (String str2 : split) {
                String[] split2 = str2.split("[=]");
                if (split2.length > 1) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public final void n(Context context, String str, String str2, boolean z, ra9.d dVar, boolean z2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, str, str2, Boolean.valueOf(z), dVar, Boolean.valueOf(z2), bundle}) == null) && d.matcher(str2).find()) {
            this.c.a(context, str, str2, z, dVar, z2, bundle);
        }
    }
}
