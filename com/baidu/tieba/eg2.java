package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.oh2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class eg2 implements io1, oh2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public final d a;
    public final String b;
    public hg2 c;
    public dg2 d;
    public jp1 e;
    public AtomicInteger f;
    public CopyOnWriteArrayList<String> g;
    public mg2 h;

    /* loaded from: classes4.dex */
    public interface d extends cg2 {
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eg2 a;

        public a(eg2 eg2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eg2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eg2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                br2.h0().c(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ oh2.b c;
        public final /* synthetic */ eg2 d;

        public b(eg2 eg2Var, List list, boolean z, oh2.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eg2Var, list, Boolean.valueOf(z), bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = eg2Var;
            this.a = list;
            this.b = z;
            this.c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.h(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            HashSet hashSet;
            int i;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                if (bundle != null) {
                    hashSet = yl3.a(bundle.getStringArray("key_exclude_ids"));
                    z = bundle.getBoolean("key_force_clean");
                    i = bundle.getInt("key_clean_scenes_type");
                } else {
                    hashSet = null;
                    i = 0;
                    z = false;
                }
                eg2 d = gg2.c().d();
                ph2 l = ph2.l();
                l.i(i);
                d.t(hashSet, z, l.k());
                return null;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947733305, "Lcom/baidu/tieba/eg2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947733305, "Lcom/baidu/tieba/eg2;");
                return;
            }
        }
        i = eo1.a;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            l(k());
        }
    }

    public final Set<String> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return c(100);
        }
        return (Set) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.f.get() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            s(r());
        }
    }

    public final Set<String> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return c(103);
        }
        return (Set) invokeV.objValue;
    }

    public eg2(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = ProcessUtils.getCurProcessName();
        this.a = dVar;
        ExecutorUtilsExt.postOnElastic(new a(this), "addLoginStatusChangedListener", 2);
        this.f = new AtomicInteger(0);
        this.g = new CopyOnWriteArrayList<>();
        this.e = cr2.m();
        this.c = new hg2();
        jp1 jp1Var = this.e;
        if (jp1Var != null) {
            this.d = jp1Var.b();
        }
        this.h = new mg2();
        if (i) {
            Log.i("SwanAppPurger", "create : " + toString());
        }
    }

    public final Set<String> c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            HashSet hashSet = new HashSet();
            LinkedHashSet<t43> q = v43.k().q();
            if (q.size() < 1) {
                return hashSet;
            }
            Iterator<t43> it = q.iterator();
            while (it.hasNext()) {
                t43 next = it.next();
                if (next.T() && (next.E() || next.Q())) {
                    hashSet.add(next.getAppId());
                    if (i) {
                        Log.i("SwanAppPurger", "sent msg(" + i2 + ") to active swan(" + next.getAppId() + SmallTailInfo.EMOTION_SUFFIX);
                    }
                    k43 e = k43.e();
                    m43 m43Var = new m43(i2);
                    m43Var.b(next.b);
                    e.h(m43Var);
                }
            }
            return hashSet;
        }
        return (Set) invokeI.objValue;
    }

    @Override // com.baidu.tieba.io1
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            String h = br2.h0().h(this.a.a());
            if (i) {
                Log.i("SwanAppPurger", "onLoginStatusChanged : " + toString());
                Log.i("SwanAppPurger", "onLoginStatusChanged : uid(" + h + ")  -> " + z);
            }
            if (z) {
                q();
            } else {
                j();
            }
        }
    }

    public final void l(Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, set) == null) {
            mg3.j().g("aiapp_", set, true);
            String w = cf3.w();
            if (!TextUtils.isEmpty(w)) {
                yn4.k(w);
            }
            String y = cf3.y();
            if (!TextUtils.isEmpty(y)) {
                yn4.k(y);
            }
            String n = qq2.n();
            if (!TextUtils.isEmpty(n)) {
                yn4.k(n);
            }
            jp1 jp1Var = this.e;
            if (jp1Var != null) {
                jp1Var.g();
                this.e.c();
            }
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.g.add(str);
    }

    public boolean n(Map<String, PMSAppInfo> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, map)) == null) {
            if (map == null || map.size() <= 0) {
                return false;
            }
            if (map.size() == 1 && map.containsKey("sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void s(Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, set) == null) {
            mg3.j().g("aiapp_setting_", set, true);
        }
    }

    public final void d(String str, oh2.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, bVar) == null) {
            ph2.m(bVar).b(str);
            this.c.a(str);
            dg2 dg2Var = this.d;
            if (dg2Var != null) {
                dg2Var.a(str);
            }
            kb2.n(str);
        }
    }

    public void e(@Nullable String str, boolean z, oh2.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048580, this, new Object[]{str, Boolean.valueOf(z), bVar}) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        f(arrayList, z, bVar);
    }

    public void f(@Nullable List<String> list, boolean z, oh2.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{list, Boolean.valueOf(z), bVar}) == null) && list != null && !list.isEmpty()) {
            g(list, true, z, bVar);
        }
    }

    public void t(@Nullable Set<String> set, boolean z, oh2.b bVar) {
        mg2 mg2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{set, Boolean.valueOf(z), bVar}) == null) && (mg2Var = this.h) != null) {
            mg2Var.i(set, z, bVar);
        }
    }

    public void g(@Nullable List<String> list, boolean z, boolean z2, oh2.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2), bVar}) == null) {
            if (!ProcessUtils.isMainProcess()) {
                if (i) {
                    Log.w("SwanAppPurger", "非主进程调用，不执行操作");
                    return;
                }
                return;
            }
            u42.l("SwanAppPurger", "deleteSwanApp", new Exception("deleteSwanApp"));
            if (z2) {
                i(list);
            }
            if (list != null && !list.isEmpty()) {
                o(list);
                ExecutorUtilsExt.postOnSerial(new b(this, list, z, bVar), "deleteSwanApp");
            }
        }
    }

    @WorkerThread
    public void h(@Nullable List<String> list, boolean z, oh2.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{list, Boolean.valueOf(z), bVar}) == null) {
            if (list == null) {
                if (i) {
                    Log.d("SwanAppPurger", "deleteSwanAppAndResetAccreditSync empty");
                    return;
                }
                return;
            }
            this.f.incrementAndGet();
            if (z) {
                u42.k("SwanAppPurger", "删除小程序==>开始重置小程序授权");
                this.c.g(list);
                int size = list.size();
                String[] strArr = new String[size];
                for (int i2 = 0; i2 < size; i2++) {
                    strArr[i2] = wz1.a(list.get(i2));
                }
                ze2.b(strArr);
            }
            u42.k("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
            this.c.e(list);
            for (String str : list) {
                if (!this.g.contains(str) && !TextUtils.isEmpty(str)) {
                    if (i) {
                        Log.d("SwanAppPurger", "删除小程序==>删除小程序相关（小程序包、小程序分包）的APS记录: " + str);
                    }
                    u42.k("SwanAppPurger", "删除小程序==>删除小程序文件: " + str);
                    p(str, bVar);
                } else {
                    u42.k("SwanAppPurger", "删除小程序==>删除忽略: " + str);
                }
            }
            if (this.f.decrementAndGet() <= 0) {
                this.f.set(0);
                this.g.clear();
                jg2.a();
            }
            ph2.m(bVar).j();
        }
    }

    public final void i(@Nullable List<String> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) && list != null && !list.isEmpty()) {
            List<SwanFavorItemData> i2 = SwanFavorDataManager.h().i();
            HashMap hashMap = new HashMap();
            for (SwanFavorItemData swanFavorItemData : i2) {
                hashMap.put(swanFavorItemData.getAppKey(), swanFavorItemData);
            }
            Set<String> i3 = xe2.i(AppRuntime.getAppContext().getContentResolver());
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String next = it.next();
                boolean contains = i3.contains(next);
                boolean containsKey = hashMap.containsKey(next);
                if (!contains && !containsKey) {
                    if (eo1.a) {
                        Log.d("SwanAppPurger", "清理过滤-不过滤： " + next);
                    }
                } else {
                    if (eo1.a) {
                        Log.d("SwanAppPurger", "清理过滤-过滤此App：" + next + "； 历史：" + contains + "； 我的小程序：" + containsKey);
                    }
                    it.remove();
                }
            }
        }
    }

    public void o(@Nullable List<String> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, list) == null) && list != null && list.size() != 0) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                cg3 a2 = ig3.a();
                a2.putInt("bookshelf_insert" + it.next(), 0);
            }
        }
    }

    public final void p(String str, oh2.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, bVar) == null) {
            if (kg2.a() && qq2.f().contains(str)) {
                u42.k("SwanAppPurger", "删除小程序==>小程序现在存活: " + str);
            } else if (jg2.c(str)) {
                u42.k("SwanAppPurger", "删除小程序==>小程序现正在下载中: " + str);
            } else {
                d(str, bVar);
                u42.k("SwanAppPurger", "删除小程序==>删除小程序数据库数据: " + str);
                this.c.f(str);
                u42.k("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str);
                this.c.d(str);
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return "Process<" + this.b + "> " + super.toString();
        }
        return (String) invokeV.objValue;
    }

    public void u(@Nullable Set<String> set, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{set, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (ProcessUtils.isMainProcess()) {
                ph2 l = ph2.l();
                l.i(i2);
                t(set, z, l.k());
                return;
            }
            Bundle bundle = new Bundle();
            if (set != null && set.size() > 0) {
                bundle.putStringArray("key_exclude_ids", (String[]) set.toArray(new String[0]));
            }
            bundle.putBoolean("key_force_clean", z);
            bundle.putInt("key_clean_scenes_type", i2);
            h43.c(c.class, bundle);
        }
    }
}
