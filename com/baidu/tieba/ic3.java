package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.tieba.hc3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.net.WebAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
/* loaded from: classes4.dex */
public final class ic3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public static volatile ic3 g;
    public static final hc3.a h;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map a;
    public final mc3 b;
    public volatile Boolean c;
    public volatile Boolean d;
    public final boolean e;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ic3 a;

        public a(ic3 ic3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ic3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ic3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.l();
                this.a.q().a(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public void a(ic3 ic3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ic3Var) == null) {
            }
        }

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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947848656, "Lcom/baidu/tieba/ic3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947848656, "Lcom/baidu/tieba/ic3;");
                return;
            }
        }
        f = wj1.a;
        h = new hc3.a();
    }

    public static synchronized ic3 l() {
        InterceptResult invokeV;
        ic3 ic3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (ic3.class) {
                if (g == null) {
                    g = new ic3();
                }
                ic3Var = g;
            }
            return ic3Var;
        }
        return (ic3) invokeV.objValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public final synchronized b q() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            synchronized (this) {
                bVar = new b();
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && l33.K().E() && a()) {
            gg3.k(new a(this), "preInitCookieDb");
        }
    }

    public ic3() {
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
        this.a = new LinkedHashMap(32, 0.75f, true);
        tm2.g0().getSwitch("swan_cookie_enable", false);
        this.e = false;
        this.b = new mc3(this);
    }

    public static synchronized void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, null, z) == null) {
            synchronized (ic3.class) {
                if (g != null) {
                    g.r(z);
                }
                g = null;
            }
        }
    }

    public String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            return f(str, null);
        }
        return (String) invokeL.objValue;
    }

    public final synchronized void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            synchronized (this) {
                if (z) {
                    this.b.c();
                }
                this.b.e();
                m02.k("SwanCookieManager", "onRelease");
            }
        }
    }

    public synchronized void y(hc3 hc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, hc3Var) == null) {
            synchronized (this) {
                hc3Var.i = 1;
            }
        }
    }

    public synchronized boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.c != null) {
                    m02.k("SwanCookieManager", "acceptCookie =" + this.c);
                    return this.c.booleanValue();
                }
                h();
                boolean z = false;
                if (this.d == null) {
                    return false;
                }
                if (this.d.booleanValue() && this.e) {
                    z = true;
                }
                this.c = Boolean.valueOf(z);
                m02.k("SwanCookieManager", "mEnableStore =" + this.d + "; mCookieABSwitch=" + this.e);
                return this.c.booleanValue();
            }
        }
        return invokeV.booleanValue;
    }

    public final synchronized void d(ArrayList arrayList, hc3 hc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, hc3Var) == null) {
            synchronized (this) {
                if (arrayList != null && hc3Var != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (hc3Var.e >= 0 && hc3Var.e <= currentTimeMillis) {
                        return;
                    }
                    if (arrayList.size() >= 50) {
                        hc3 hc3Var2 = new hc3();
                        hc3Var2.g = currentTimeMillis;
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            hc3 hc3Var3 = (hc3) it.next();
                            if (hc3Var3 != null && hc3Var3.g < hc3Var2.g && hc3Var3.i != 2) {
                                hc3Var2 = hc3Var3;
                            }
                        }
                        hc3Var2.i = 2;
                    }
                    hc3Var.g = currentTimeMillis;
                    hc3Var.h = currentTimeMillis;
                    hc3Var.i = 0;
                    arrayList.add(hc3Var);
                }
            }
        }
    }

    public String f(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (f) {
                Log.d("SwanCookieManager", "getCookie url: " + str + "; defaultCookie=" + str2);
            }
            if (l33.K().E() && a()) {
                if (!jc3.a(str)) {
                    return str2;
                }
                try {
                    return i(new WebAddress(str), str2);
                } catch (Exception unused) {
                    if (f) {
                        Log.e("SwanCookieManager", "Bad address: " + str);
                    }
                }
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public final synchronized String i(WebAddress webAddress, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, webAddress, str)) == null) {
            synchronized (this) {
                String[] e = jc3.e(webAddress);
                if (e == null) {
                    return str;
                }
                String d = jc3.d(e[0]);
                if (d == null) {
                    return str;
                }
                ArrayList arrayList = (ArrayList) this.a.get(d);
                if (arrayList == null) {
                    arrayList = this.b.k(d);
                    this.a.put(d, arrayList);
                }
                SortedSet m = m(arrayList, webAddress.getScheme(), e);
                if (m != null && !m.isEmpty()) {
                    String b2 = jc3.b(m, str);
                    if (f) {
                        Log.d("SwanCookieManager", "getCookie result:" + b2 + ";defaultCookie=" + str);
                    }
                    return b2;
                }
                return str;
            }
        }
        return (String) invokeLL.objValue;
    }

    public void x(String str, Collection collection) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048595, this, str, collection) == null) && !TextUtils.isEmpty(str) && collection != null && !collection.isEmpty()) {
            if (k(collection) > 4096) {
                m02.o("SwanCookieManager", "setCookie values is too large");
                return;
            }
            if (f) {
                Log.d("SwanCookieManager", "setCookie: url=" + str + "; values=" + collection);
            }
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                w(str, (String) it.next());
            }
        }
    }

    public final synchronized void e(String str, String str2, ArrayList arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, arrayList) == null) {
            synchronized (this) {
                if (!TextUtils.isEmpty(str2) && arrayList != null && !arrayList.isEmpty()) {
                    String d = jc3.d(str2);
                    if (d == null) {
                        return;
                    }
                    ArrayList arrayList2 = (ArrayList) this.a.get(d);
                    if (arrayList2 == null) {
                        arrayList2 = this.b.k(d);
                        this.a.put(d, arrayList2);
                    }
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        hc3 hc3Var = (hc3) arrayList.get(i);
                        if (!p(arrayList2, hc3Var, str)) {
                            d(arrayList2, hc3Var);
                        }
                    }
                }
            }
        }
    }

    public synchronized void g(hc3 hc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, hc3Var) == null) {
            synchronized (this) {
                if (hc3Var == null) {
                    return;
                }
                if (hc3Var.i == 2) {
                    String d = jc3.d(hc3Var.a);
                    if (d == null) {
                        return;
                    }
                    ArrayList arrayList = (ArrayList) this.a.get(d);
                    if (arrayList != null) {
                        arrayList.remove(hc3Var);
                        if (arrayList.isEmpty()) {
                            this.a.remove(d);
                        }
                    }
                }
            }
        }
    }

    public final long k(Collection collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, collection)) == null) {
            long j = 0;
            if (collection != null && !collection.isEmpty()) {
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (str != null) {
                        j += str.length();
                    }
                }
            }
            return j;
        }
        return invokeL.longValue;
    }

    public void h() {
        SwanAppConfigData Q;
        SwanAppConfigData.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || this.d != null || (Q = l33.K().q().Q()) == null || (cVar = Q.r) == null) {
            return;
        }
        this.d = Boolean.valueOf(cVar.a);
        m02.k("SwanCookieManager", "enableStore =" + this.d);
    }

    public synchronized ArrayList n() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                for (ArrayList arrayList2 : this.a.values()) {
                    if (arrayList2 != null) {
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            hc3 hc3Var = (hc3) it.next();
                            if (hc3Var != null && hc3Var.i != 1) {
                                arrayList.add(hc3Var);
                            }
                        }
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public final synchronized SortedSet m(ArrayList arrayList, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, arrayList, str, strArr)) == null) {
            synchronized (this) {
                if (arrayList != null) {
                    if (!arrayList.isEmpty() && strArr != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        TreeSet treeSet = new TreeSet(h);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            hc3 hc3Var = (hc3) it.next();
                            if (hc3Var != null && hc3Var.a(strArr[0]) && hc3Var.c(strArr[1]) && (hc3Var.e < 0 || hc3Var.e > currentTimeMillis)) {
                                if (!hc3Var.f || "https".equals(str)) {
                                    if (hc3Var.i != 2) {
                                        hc3Var.g = currentTimeMillis;
                                        treeSet.add(hc3Var);
                                    }
                                }
                            }
                        }
                        return treeSet;
                    }
                }
                return null;
            }
        }
        return (SortedSet) invokeLLL.objValue;
    }

    public final synchronized boolean p(ArrayList arrayList, hc3 hc3Var, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, arrayList, hc3Var, str)) == null) {
            synchronized (this) {
                if (arrayList == null || hc3Var == null) {
                    return false;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    hc3 hc3Var2 = (hc3) it.next();
                    if (hc3Var.b(hc3Var2)) {
                        if (hc3Var.e >= 0 && hc3Var.e <= currentTimeMillis) {
                            hc3Var2.h = currentTimeMillis;
                            hc3Var2.i = 2;
                            return true;
                        }
                        if (!hc3Var2.f || "https".equals(str)) {
                            hc3Var2.d = hc3Var.d;
                            hc3Var2.e = hc3Var.e;
                            hc3Var2.f = hc3Var.f;
                            hc3Var2.g = currentTimeMillis;
                            hc3Var2.h = currentTimeMillis;
                            hc3Var2.i = 3;
                        }
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final ArrayList s(String[] strArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, strArr, str)) == null) {
            if (strArr == null || TextUtils.isEmpty(str)) {
                return null;
            }
            if (strArr[1].length() > 1) {
                int lastIndexOf = strArr[1].lastIndexOf(47);
                String str2 = strArr[1];
                if (lastIndexOf <= 0) {
                    lastIndexOf++;
                }
                strArr[1] = str2.substring(0, lastIndexOf);
            }
            try {
                return jc3.g(strArr[0], strArr[1], str);
            } catch (Exception unused) {
                if (!f) {
                    return null;
                }
                Log.e("SwanCookieManager", "parse cookie failed: " + str);
                return null;
            }
        }
        return (ArrayList) invokeLL.objValue;
    }

    public final synchronized void v(WebAddress webAddress, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, webAddress, str) == null) {
            synchronized (this) {
                if (webAddress != null) {
                    if (!TextUtils.isEmpty(str)) {
                        if (str.length() > 4096) {
                            m02.o("SwanCookieManager", "setCookie value is too large");
                            return;
                        }
                        String[] e = jc3.e(webAddress);
                        if (e == null) {
                            return;
                        }
                        e(webAddress.getScheme(), e[0], s(e, str));
                        this.b.g();
                    }
                }
            }
        }
    }

    public void w(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, str, str2) != null) || !l33.K().E() || !a() || !jc3.a(str)) {
            return;
        }
        try {
            v(new WebAddress(str), str2);
        } catch (Exception unused) {
            if (f) {
                Log.e("SwanCookieManager", "setCookie with bad address: " + str);
            }
        }
    }
}
