package com.baidu.tieba;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.messaging.client.SwanAppLocalService;
import com.baidu.tieba.i43;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Date;
import java.util.Deque;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes3.dex */
public final class d13 extends v03 implements Object {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;
    public final SwanAppProcessInfo b;
    public String c;
    public Messenger d;
    public SwanAppCores e;
    public PrefetchEvent f;
    public boolean g;
    public long h;
    public boolean i;
    public c j;
    public final Deque<Message> k;
    public b l;
    public final Set<String> m;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(d13 d13Var);
    }

    /* loaded from: classes3.dex */
    public class c implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d13 a;

        public c(d13 d13Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d13Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d13Var;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) != null) {
                return;
            }
            this.a.a0();
        }

        public /* synthetic */ c(d13 d13Var, a aVar) {
            this(d13Var);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                synchronized (this.a.b) {
                    this.a.d = new Messenger(iBinder);
                    f13 k = f13.k();
                    k.m().a("event_puppet_online", this.a);
                    if (d13.n) {
                        k.u("on main bind to swan: " + this.a.b);
                    }
                    this.a.L();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947651651, "Lcom/baidu/tieba/d13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947651651, "Lcom/baidu/tieba/d13;");
                return;
            }
        }
        n = u03.b;
    }

    @Override // com.baidu.tieba.m43, com.baidu.tieba.h43
    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return !TextUtils.isEmpty(this.c);
        }
        return invokeV.booleanValue;
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this.m) {
                this.m.clear();
                if (n) {
                    Log.d("SwanClientPuppet", "clear all prefetch ids");
                }
            }
        }
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            PrefetchEvent prefetchEvent = this.f;
            if (prefetchEvent != null) {
                return prefetchEvent.appId;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public SwanAppProcessInfo O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (SwanAppProcessInfo) invokeV.objValue;
    }

    public boolean P() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this.b) {
                if (this.d != null) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return P();
        }
        return invokeV.booleanValue;
    }

    public d13 Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            d0();
            f13.k().m().a("event_puppet_unload_app", this);
            return this;
        }
        return (d13) invokeV.objValue;
    }

    public d13 b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            this.i = true;
            this.h = 0L;
            b bVar = this.l;
            if (bVar != null) {
                bVar.a(this);
            }
            return this;
        }
        return (d13) invokeV.objValue;
    }

    public d13 c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            synchronized (this.b) {
                d0();
                this.d = null;
                this.e = null;
                j0(null);
                K();
                e0();
            }
            return this;
        }
        return (d13) invokeV.objValue;
    }

    public d13 d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            this.c = "";
            j0(null);
            K();
            return this;
        }
        return (d13) invokeV.objValue;
    }

    public d13 e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            this.i = false;
            this.h = 0L;
            j0(null);
            K();
            return this;
        }
        return (d13) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m43, com.baidu.tieba.h43
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public d13 l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            m0(false, null, null);
            return this;
        }
        return (d13) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m43, com.baidu.tieba.h43
    public SwanAppCores m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.e;
        }
        return (SwanAppCores) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d13(SwanAppProcessInfo swanAppProcessInfo) {
        super(d43.K());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppProcessInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((h43) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = "";
        this.d = null;
        this.g = true;
        this.h = 0L;
        this.i = false;
        this.k = new ArrayDeque();
        this.m = ii3.a(new String[0]);
        this.b = swanAppProcessInfo;
        b43 b43Var = new b43();
        b43Var.f(this, "event_messenger_call");
        u(b43Var);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Z */
    public void a(i43.a aVar) {
        String[] p;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048592, this, aVar) != null) || !q03.J(aVar.D(), "swan_multi_preload_on_server") || aVar.i("swan_multi_preload_app_process_index") != this.b.index || (p = aVar.p("swan_multi_preload_app_ids")) == null) {
            return;
        }
        synchronized (this.m) {
            this.m.clear();
            for (String str : p) {
                if (!TextUtils.isEmpty(str)) {
                    this.m.add(str);
                }
            }
            if (n) {
                Log.d("SwanClientPuppet", "get all in prefetch ids - " + this.m);
            }
        }
    }

    public final void V(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, str) == null) && n) {
            Log.i("SwanClientPuppet", str);
        }
    }

    public d13 W(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, bundle)) == null) {
            return update(bundle);
        }
        return (d13) invokeL.objValue;
    }

    public d13 X(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, bundle)) == null) {
            j0(null);
            K();
            return update(bundle);
        }
        return (d13) invokeL.objValue;
    }

    public boolean g0(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, message)) == null) {
            this.k.offer(message);
            L();
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean i0(Collection<Message> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, collection)) == null) {
            for (Message message : collection) {
                this.k.offer(message);
            }
            L();
            return true;
        }
        return invokeL.booleanValue;
    }

    public void j0(PrefetchEvent prefetchEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, prefetchEvent) == null) {
            this.f = prefetchEvent;
        }
    }

    public void k0(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bVar) == null) {
            this.l = bVar;
        }
    }

    public d13 o0(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048610, this, j)) == null) {
            if (j > 0) {
                f13.k().m().a("event_puppet_fmp_launch_finish", this);
            }
            return this;
        }
        return (d13) invokeJ.objValue;
    }

    public d13 p0(SwanAppCores swanAppCores) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, swanAppCores)) == null) {
            if (swanAppCores != null) {
                this.e = swanAppCores;
            }
            return this;
        }
        return (d13) invokeL.objValue;
    }

    private d13 update(Bundle bundle) {
        InterceptResult invokeL;
        SwanAppCores swanAppCores;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bundle)) == null) {
            Parcelable parcelable = bundle.getParcelable("app_core");
            if (parcelable instanceof SwanAppCores) {
                swanAppCores = (SwanAppCores) parcelable;
            } else {
                swanAppCores = null;
            }
            p0(swanAppCores);
            String string = bundle.getString("app_id");
            if (!TextUtils.isEmpty(string)) {
                U(string);
                f13.k().g(string, this);
                u03.e().d(string);
                e0();
            }
            l0();
            return this;
        }
        return (d13) invokeL.objValue;
    }

    public d13 L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            V("flushCachedMsgs");
            synchronized (this.b) {
                while (this.d != null && !this.k.isEmpty()) {
                    Message peek = this.k.peek();
                    if (peek.replyTo == null) {
                        peek.replyTo = f13.k().d;
                    }
                    if (!h0(peek)) {
                        break;
                    }
                    this.k.poll();
                }
            }
            return this;
        }
        return (d13) invokeV.objValue;
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            synchronized (this.b) {
                this.d = null;
                this.j = null;
                c0();
                f13 k = f13.k();
                k.m().a("event_puppet_offline", this);
                if (n) {
                    k.u("onSwanClientConnDown => " + this);
                }
                k.w();
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return String.format(Locale.getDefault(), "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", this.b.toString(), Integer.valueOf(T() ? 1 : 0), Integer.valueOf(this.i ? 1 : 0), SimpleDateFormat.getTimeInstance(2).format(new Date(this.h)), this.c);
        }
        return (String) invokeV.objValue;
    }

    public Set<String> M() {
        InterceptResult invokeV;
        HashSet hashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this.m) {
                hashSet = new HashSet(this.m);
                if (this.f != null && !TextUtils.isEmpty(this.f.appId)) {
                    hashSet.add(this.f.appId);
                }
            }
            return hashSet;
        }
        return (Set) invokeV.objValue;
    }

    public d13 U(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (!TextUtils.equals(str, this.c)) {
                if (TextUtils.isEmpty(str)) {
                    str = "swan_id_unknown";
                }
                this.c = str;
                f13.k().m().a("event_puppet_load_app", this);
                this.g = true;
            } else {
                this.g = false;
            }
            return this;
        }
        return (d13) invokeL.objValue;
    }

    public void f0(@NonNull Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, message) == null) {
            try {
                Application c2 = ln2.c();
                Intent intent = new Intent(c2, this.b.service);
                intent.setAction(SwanAppLocalService.ACTION_RECEIVER_MSG);
                intent.putExtra("data", message);
                c2.startService(intent);
            } catch (Throwable th) {
                e12.d("SwanClientPuppet", "sendMessageToClientService fail", th);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0021 A[Catch: all -> 0x0027, TryCatch #1 {, blocks: (B:7:0x0009, B:9:0x000f, B:11:0x0015, B:16:0x001a, B:18:0x0021, B:19:0x0024), top: B:29:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean h0(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, message)) == null) {
            synchronized (this.b) {
                if (message != null) {
                    if (T()) {
                        try {
                            this.d.send(message);
                            return true;
                        } catch (RemoteException e) {
                            e = e;
                            a0();
                            if (n) {
                                e.printStackTrace();
                            }
                            return false;
                        } catch (RuntimeException e2) {
                            e = e2;
                            a0();
                            if (n) {
                            }
                            return false;
                        }
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public d13 m0(boolean z, Context context, Bundle bundle) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{Boolean.valueOf(z), context, bundle})) == null) {
            if (n) {
                f13 k = f13.k();
                k.u("b4 tryPreBind: " + this.b + " trace=" + Log.getStackTraceString(new Throwable()));
            }
            Application c2 = ln2.c();
            Intent intent = new Intent(c2, this.b.service);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            this.h = System.currentTimeMillis();
            intent.putExtra("call_preload_time", System.currentTimeMillis());
            intent.putExtra("bundle_key_main_pid", Process.myPid());
            intent.setAction(SwanAppLocalService.ACTION_PERLOAD);
            intent.addCategory("android.intent.category.DEFAULT");
            synchronized (this.b) {
                try {
                    if (this.j == null) {
                        c cVar = new c(this, null);
                        this.j = cVar;
                        c2.bindService(intent, cVar, 1);
                    } else if (z) {
                        c2.startService(intent);
                    }
                } catch (Exception e) {
                    if (n) {
                        e.printStackTrace();
                    }
                }
                if (this.d != null) {
                    L();
                }
            }
            return this;
        }
        return (d13) invokeCommon.objValue;
    }

    public d13 n0(Context context, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048609, this, context, bundle)) == null) {
            if (n) {
                f13 k = f13.k();
                k.u("b4 preload: " + this.b);
            }
            m0(true, context, bundle);
            return this;
        }
        return (d13) invokeLL.objValue;
    }
}
