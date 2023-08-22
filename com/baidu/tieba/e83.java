package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.ipc.SwanProcessCallStub;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class e83 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public static final long j;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedHashMap<SwanAppProcessInfo, c83> a;
    public final Deque<Long> b;
    public final Handler c;
    public final Messenger d;
    public final SwanProcessCallStub e;
    public long f;
    public final Set<a83> g;
    public final a83 h;

    /* loaded from: classes5.dex */
    public interface c<FILTER> {
        boolean a(FILTER filter, c83 c83Var);
    }

    /* loaded from: classes5.dex */
    public class a implements a83 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e83 a;

        @Override // com.baidu.tieba.a83
        public void timeout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        /* renamed from: com.baidu.tieba.e83$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0273a implements wp3<a83> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ c83 b;

            public C0273a(a aVar, String str, c83 c83Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str, c83Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = str;
                this.b = c83Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.wp3
            /* renamed from: b */
            public void a(a83 a83Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a83Var) == null) {
                    a83Var.a(this.a, this.b);
                }
            }
        }

        public a(e83 e83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e83Var;
        }

        @Override // com.baidu.tieba.a83
        public void a(String str, c83 c83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, c83Var) == null) {
                if (e83.i) {
                    Log.i("SwanPuppetManager", "onEvent: to=" + this.a.g.size() + " event=" + str + " client=" + c83Var.b);
                }
                synchronized (this.a.g) {
                    vp3.a(cb3.M(), new C0273a(this, str, c83Var), this.a.g);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a83 a;
        public final /* synthetic */ e83 b;

        public b(e83 e83Var, a83 a83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e83Var, a83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e83Var;
            this.a = a83Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            synchronized (this.b.g) {
                if (this.b.g.contains(this.a)) {
                    if (e83.i) {
                        Log.i("SwanPuppetManager", "timeout: callback = " + this.a);
                    }
                    this.b.h(this.a);
                    this.a.timeout();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static e83 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-877429591, "Lcom/baidu/tieba/e83$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-877429591, "Lcom/baidu/tieba/e83$d;");
                    return;
                }
            }
            a = new e83(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947688169, "Lcom/baidu/tieba/e83;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947688169, "Lcom/baidu/tieba/e83;");
                return;
            }
        }
        i = nr1.a;
        j = TimeUnit.MINUTES.toMillis(5L);
    }

    @SuppressLint({"BDThrowableCheck"})
    public static e83 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (!i || ProcessUtils.isMainProcess()) {
                return d.a;
            }
            throw new IllegalStateException("SwanAppClientObjManager should run in main process only");
        }
        return (e83) invokeV.objValue;
    }

    public a83 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.h;
        }
        return (a83) invokeV.objValue;
    }

    public synchronized LinkedHashSet<c83> q() {
        InterceptResult invokeV;
        LinkedHashSet<c83> linkedHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            synchronized (this) {
                linkedHashSet = new LinkedHashSet<>(this.a.values());
            }
            return linkedHashSet;
        }
        return (LinkedHashSet) invokeV.objValue;
    }

    public e83() {
        SwanAppProcessInfo[] indices;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new LinkedHashMap<>();
        this.b = new ArrayDeque();
        this.c = new SwanAppMessengerService.a();
        this.d = new Messenger(this.c);
        this.e = new SwanProcessCallStub(this.c);
        this.f = 0L;
        this.g = new HashSet();
        this.h = new a(this);
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
            if (swanAppProcessInfo != null && swanAppProcessInfo.isSwanAppProcess()) {
                this.a.put(swanAppProcessInfo, new c83(swanAppProcessInfo));
            }
        }
    }

    @Nullable
    public synchronized c83 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                u("b4 computNextPreloadProcess");
                c83 c83Var = null;
                for (int i2 = 0; i2 <= 5; i2++) {
                    c83 c83Var2 = this.a.get(SwanAppProcessInfo.indexOf(i2));
                    if (c83Var2 != null && c83Var2.b.isSwanAppProcess() && !c83Var2.E()) {
                        if (c83Var2.S()) {
                            if (i) {
                                Log.i("SwanPuppetManager", "computNextPreloadProcess: return null by found empty process=" + c83Var2);
                            }
                            return null;
                        } else if (c83Var == null) {
                            c83Var = c83Var2;
                        }
                    }
                }
                if (i) {
                    Log.i("SwanPuppetManager", "computNextPreloadProcess: firstPreloadableClient=" + c83Var);
                }
                return c83Var;
            }
        }
        return (c83) invokeV.objValue;
    }

    public /* synthetic */ e83(a aVar) {
        this();
    }

    public void b(a83 a83Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, a83Var) == null) {
            c(a83Var, -1L);
        }
    }

    @Nullable
    public synchronized c83 i(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            synchronized (this) {
                List<c83> j2 = j(str);
                if (j2.isEmpty()) {
                    return null;
                }
                return j2.get(j2.size() - 1);
            }
        }
        return (c83) invokeL.objValue;
    }

    public synchronized c83 l(@Nullable String str) {
        InterceptResult invokeL;
        c83 i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            synchronized (this) {
                i2 = i(str);
                if (i2 == null) {
                    i2 = e();
                }
            }
            return i2;
        }
        return (c83) invokeL.objValue;
    }

    public synchronized c83 n(int i2) {
        InterceptResult invokeI;
        c83 o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            synchronized (this) {
                o = o(SwanAppProcessInfo.indexOf(i2));
            }
            return o;
        }
        return (c83) invokeI.objValue;
    }

    public synchronized c83 o(SwanAppProcessInfo swanAppProcessInfo) {
        InterceptResult invokeL;
        c83 c83Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, swanAppProcessInfo)) == null) {
            synchronized (this) {
                c83Var = this.a.get(swanAppProcessInfo);
            }
            return c83Var;
        }
        return (c83) invokeL.objValue;
    }

    @NonNull
    public synchronized c83 r(@Nullable String str) {
        InterceptResult invokeL;
        c83 l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            synchronized (this) {
                l = l(str);
                v(l.b);
            }
            return l;
        }
        return (c83) invokeL.objValue;
    }

    public void c(a83 a83Var, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a83Var, j2) == null) {
            synchronized (this.g) {
                this.g.add(a83Var);
                if (i) {
                    Log.i("SwanPuppetManager", "addCallback: after = " + this.g.size());
                }
            }
            if (j2 > 0) {
                cb3.M().postDelayed(new b(this, a83Var), j2);
            }
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this.b) {
                t("checkRescuable ===>");
                boolean z = false;
                if (this.f > System.currentTimeMillis()) {
                    t(String.format(Locale.getDefault(), "disallowRescue by mRescueRefractoryUntil(%d)", Long.valueOf(this.f)));
                    return false;
                } else if (this.b.size() < 3) {
                    t(String.format(Locale.getDefault(), "allowRescue by size(%d) < max(%d)", Integer.valueOf(this.b.size()), 3));
                    return true;
                } else {
                    int size = this.b.size() - 3;
                    t("after offer purgeCount=" + size);
                    if (size > 0) {
                        for (int i2 = 0; i2 < size; i2++) {
                            t("purge: " + this.b.poll());
                        }
                    }
                    t("after purge");
                    Long peek = this.b.peek();
                    if (peek == null) {
                        t("allowRescue by null oldestRecord is should not happen");
                        return true;
                    }
                    long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
                    if (currentTimeMillis > j) {
                        z = true;
                    }
                    t("allowRescue:" + z + " oldestRecordDuration:" + currentTimeMillis);
                    return z;
                }
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized c83 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                u("b4 computNextAvailableProcess");
                c83 c83Var = null;
                c83 c83Var2 = null;
                for (int i2 = 0; i2 <= 5; i2++) {
                    c83 c83Var3 = this.a.get(SwanAppProcessInfo.indexOf(i2));
                    if (c83Var3 != null && c83Var3.b.isSwanAppProcess() && !c83Var3.E()) {
                        if (c83Var3.S()) {
                            if (i) {
                                Log.i("SwanPuppetManager", "computNextAvailableProcess: firstPreloadedClient=" + c83Var3);
                            }
                            return c83Var3;
                        }
                        if (c83Var == null && c83Var3.T()) {
                            c83Var = c83Var3;
                        }
                        if (c83Var2 == null) {
                            c83Var2 = c83Var3;
                        }
                    }
                }
                if (c83Var != null) {
                    if (i) {
                        Log.i("SwanPuppetManager", "computNextAvailableProcess: firstConnectedEmptyClient=" + c83Var);
                    }
                    return c83Var;
                } else if (c83Var2 != null) {
                    if (i) {
                        Log.i("SwanPuppetManager", "computNextAvailableProcess: firstEmptyClient=" + c83Var2);
                    }
                    return c83Var2;
                } else {
                    for (c83 c83Var4 : this.a.values()) {
                        if (c83Var4 != null) {
                            if (i) {
                                Log.i("SwanPuppetManager", "computNextAvailableProcess: lruClient=" + c83Var4);
                            }
                            return c83Var4;
                        }
                    }
                    if (i) {
                        Log.i("SwanPuppetManager", "computNextAvailableProcess: P0");
                    }
                    return o(SwanAppProcessInfo.P0);
                }
            }
        }
        return (c83) invokeV.objValue;
    }

    public synchronized void g(String str, c83 c83Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, c83Var) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                List<c83> j2 = k().j(str);
                if (j2.isEmpty()) {
                    return;
                }
                for (c83 c83Var2 : j2) {
                    if (c83Var2 != c83Var && c83Var2 != null && c83Var2.E()) {
                        if (i) {
                            Log.i("SwanPuppetManager", "deduplicateClients: protectedClient=" + c83Var);
                            Log.i("SwanPuppetManager", "deduplicateClients: exClient=" + c83Var2);
                        }
                        c83Var2.e0();
                        c83Var2.d0();
                        if (c83Var2.T()) {
                            t73 e = t73.e();
                            v73 v73Var = new v73(110, new Bundle());
                            v73Var.b(c83Var2.b);
                            e.h(v73Var);
                        }
                    }
                }
            }
        }
    }

    public void h(a83 a83Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, a83Var) == null) {
            synchronized (this.g) {
                this.g.remove(a83Var);
                if (i) {
                    Log.i("SwanPuppetManager", "delCallback: after = " + this.g.size());
                }
            }
        }
    }

    public void s(Message message) {
        c83 o;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048592, this, message) != null) || message == null) {
            return;
        }
        SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
        if (!indexOf.isSwanAppProcess() || (o = o(indexOf)) == null) {
            return;
        }
        Object obj = message.obj;
        if (!(obj instanceof Bundle)) {
            return;
        }
        Bundle bundle = (Bundle) obj;
        bundle.setClassLoader(e83.class.getClassLoader());
        o.o0(bundle.getLong("property_launch_cost", -1L));
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, str) == null) && i) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            Log.i("SwanPuppetManager", "\nlogStatus by " + str + ":\n" + toString());
        }
    }

    public synchronized void v(SwanAppProcessInfo swanAppProcessInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, swanAppProcessInfo) == null) {
            synchronized (this) {
                c83 remove = this.a.remove(swanAppProcessInfo);
                if (remove != null) {
                    this.a.put(swanAppProcessInfo, remove);
                }
                if (i) {
                    u("lru -> " + swanAppProcessInfo);
                }
            }
        }
    }

    @NonNull
    public synchronized List<c83> j(@Nullable String str) {
        InterceptResult invokeL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                if (!TextUtils.isEmpty(str)) {
                    for (c83 c83Var : this.a.values()) {
                        if (TextUtils.equals(c83Var.getAppId(), str)) {
                            arrayList.add(c83Var);
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public synchronized <FILTER> c83 p(FILTER filter, c<FILTER> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, filter, cVar)) == null) {
            synchronized (this) {
                for (c83 c83Var : this.a.values()) {
                    if (cVar.a(filter, c83Var)) {
                        return c83Var;
                    }
                }
                return null;
            }
        }
        return (c83) invokeLL.objValue;
    }

    public final void t(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, str) == null) && i) {
            Log.i("SwanPuppetManager", "SwanRescue:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.b.iterator();
            while (it.hasNext()) {
                Log.i("SwanPuppetManager", "SwanRescue::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue())));
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            LinkedHashSet<c83> q = q();
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(":");
            sb.append("\n-> clients: ");
            for (c83 c83Var : q) {
                sb.append("\n--> ");
                sb.append(c83Var.toString());
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            synchronized (this.b) {
                if (d()) {
                    this.b.offer(Long.valueOf(System.currentTimeMillis()));
                    Bundle bundle = new Bundle();
                    bundle.putString("bundle_key_preload_preload_scene", "1");
                    b83.n(ku2.c(), bundle);
                }
            }
        }
    }
}
