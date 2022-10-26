package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.ge4;
import com.baidu.tieba.ne4;
import com.baidu.tieba.qe4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public final class c22 implements gd2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public interface b {
        void a();

        void b(int i);

        void c();
    }

    /* loaded from: classes3.dex */
    public final class a extends g62 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ b b;
        public final /* synthetic */ Map c;

        public a(b bVar, Map map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bVar;
            this.c = map;
            this.a = false;
        }

        @Override // com.baidu.tieba.g62
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                b bVar = this.b;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }

        @Override // com.baidu.tieba.g62
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                i();
                b bVar = this.b;
                if (bVar != null && !this.a) {
                    bVar.a();
                }
            }
        }

        public final void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                for (String str : this.c.keySet()) {
                    j(str);
                }
            }
        }

        @Override // com.baidu.tieba.g62
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                super.b(i);
                b bVar = this.b;
                if (bVar != null) {
                    if (i == 1010) {
                        bVar.a();
                    } else {
                        bVar.b(3);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.g62
        public void c(ge4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                super.c(aVar);
                j(aVar.b);
                c72.c(aVar.b);
            }
        }

        @Override // com.baidu.tieba.g62
        public void f(gc4 gc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, gc4Var) == null) {
                super.f(gc4Var);
                if (gc4Var.a != 1010) {
                    this.a = true;
                    b bVar = this.b;
                    if (bVar != null) {
                        bVar.b(3);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.g62
        public void g(mc4 mc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, mc4Var) == null) {
                super.g(mc4Var);
                j(mc4Var.o);
            }
        }

        public final void j(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && this.c.containsKey(str)) {
                Set<String> set = (Set) this.c.get(str);
                if (set != null && !set.isEmpty()) {
                    for (String str2 : set) {
                        c72.d(str, str2);
                    }
                    return;
                }
                c72.c(str);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947622790, "Lcom/baidu/tieba/c22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947622790, "Lcom/baidu/tieba/c22;");
                return;
            }
        }
        a = wj1.a;
    }

    public static void a(List list, String str, b bVar) {
        String[] i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, list, str, bVar) == null) {
            if (!c(ac3.a().getString("predownload_network_switch", "1"))) {
                if (a) {
                    Log.e("SwanPreDownload", "pre download net invalid");
                }
                if (bVar != null) {
                    bVar.b(6);
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                qe4.b bVar2 = (qe4.b) it.next();
                if (bVar2 != null) {
                    if (bVar2.i() != null && bVar2.i().length != 0) {
                        Set set = (Set) hashMap.get(bVar2.b());
                        if (set == null) {
                            set = new HashSet();
                        }
                        boolean z = false;
                        for (String str2 : bVar2.i()) {
                            if (c72.f(bVar2.b(), str2) && !z) {
                                arrayList.add(bVar2);
                                z = true;
                            }
                            set.add(str2);
                        }
                        hashMap.put(bVar2.b(), set);
                    } else if (c72.e(bVar2.b())) {
                        arrayList.add(bVar2);
                        hashMap.put(bVar2.b(), null);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                if (a) {
                    Log.i("SwanPreDownload", "preDownload list empty");
                }
                if (bVar != null) {
                    bVar.a();
                    return;
                }
                return;
            }
            qe4 qe4Var = new qe4(arrayList, kh3.b());
            qe4Var.e(str);
            qe4Var.d("1");
            j62 j62Var = new j62(new a(bVar, hashMap));
            j62Var.L(s62.a(str));
            wa4.f(qe4Var, j62Var);
        }
    }

    public static void b(List list, String str, g62 g62Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, list, str, g62Var) == null) {
            if (!c(ac3.a().getString("predownload_network_switch", "1"))) {
                g62Var.b(6);
                return;
            }
            List i = c72.i(list);
            if (i.isEmpty()) {
                g62Var.d();
                return;
            }
            ne4 ne4Var = new ne4(i, (pg4) kh3.b());
            ne4Var.d("1");
            ne4Var.e(str);
            j62 j62Var = new j62(g62Var);
            j62Var.L(s62.a(str));
            wa4.f(ne4Var, j62Var);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (com.baidu.swan.apps.network.SwanAppNetworkUtils.j(com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            boolean z = true;
            if (!TextUtils.equals(str, "0")) {
                if (!TextUtils.equals(str, "1")) {
                    TextUtils.equals(str, "2");
                    z = false;
                }
                if (a) {
                    Log.d("SwanPreDownload", "SwanPredownload: current net suits for net config = " + z);
                }
                return z;
            }
        } else {
            return invokeL.booleanValue;
        }
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (!TextUtils.equals(SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME, str)) {
                return true;
            }
            tm2.g0().getSwitch("swan_game_feed_predownload", 0);
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void e(String str, String str2, String str3, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, null, str, str2, str3, bVar) == null) {
            qe4.b bVar2 = new qe4.b(str);
            if (!TextUtils.isEmpty(str2)) {
                bVar2.l(new String[]{str2});
            }
            a(Collections.singletonList(bVar2), str3, bVar);
        }
    }

    public static void f(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, str, str2, str3) == null) {
            if (TextUtils.isEmpty(str)) {
                if (a) {
                    Log.e("SwanPreDownload", "pre download swanAppId invalid");
                }
            } else if (!c(ac3.a().getString("predownload_network_switch", "1"))) {
                if (a) {
                    Log.e("SwanPreDownload", "pre download net invalid");
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new ne4.a(str));
                List i = c72.i(arrayList);
                if (i.isEmpty()) {
                    if (a) {
                        Log.e("SwanPreDownload", "pre download has record");
                        return;
                    }
                    return;
                }
                ne4 ne4Var = new ne4(i, (pg4) kh3.b());
                ne4Var.e(str2);
                ne4Var.d("1");
                j62 j62Var = new j62();
                j62Var.L(s62.a(str2));
                wa4.f(ne4Var, j62Var);
            }
        }
    }

    public static void g(String str, String str2, String str3, boolean z, String str4, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, str2, str3, Boolean.valueOf(z), str4, bVar}) == null) {
            if (a) {
                Log.d("SwanPreDownload", "preDownloadSwanAppByFeed appId: " + str + " ,appType: " + str2 + " ,isClick: " + z + ", scheme=" + str4);
            }
            if (z) {
                if (bVar != null) {
                    bVar.a();
                }
            } else if (TextUtils.isEmpty(str)) {
                if (bVar != null) {
                    bVar.c();
                }
            } else if (!d(str2)) {
                if (bVar != null) {
                    bVar.b(6);
                }
            } else {
                String str5 = null;
                if (!TextUtils.isEmpty(str4)) {
                    try {
                        Uri parse = Uri.parse(str4);
                        if (parse != null) {
                            str5 = eh3.n(str, parse, false);
                        }
                    } catch (Exception e) {
                        if (a) {
                            e.printStackTrace();
                        }
                    }
                }
                e(str, str5, str3, bVar);
            }
        }
    }
}
