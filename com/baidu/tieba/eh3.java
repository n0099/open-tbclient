package com.baidu.tieba;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.swan.apps.system.wifi.listener.SwanWifiBroadcastReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes5.dex */
public abstract class eh3 implements fh3, gh3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public WifiManager b;
    public SwanWifiBroadcastReceiver c;
    public final gh3 d;
    public boolean e;
    public volatile List<dl3<kh3<jh3>>> f;
    public final ch3 g;

    /* loaded from: classes5.dex */
    public class c implements gh3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile List<dl3<kh3<List<jh3>>>> a;
        public boolean b;
        public List<dl3<kh3<Void>>> c;
        public Lock d;
        public Handler e;
        public List<ScanResult> f;
        public Runnable g;
        public dh3 h;
        public final /* synthetic */ eh3 i;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.d.lock();
                    try {
                        if (!this.a.b) {
                            return;
                        }
                        this.a.m(this.a.f);
                        this.a.b = false;
                    } finally {
                        this.a.d.unlock();
                    }
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements dh3 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // com.baidu.tieba.dh3
            public void a(List<ScanResult> list) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(1048576, this, list) != null) {
                    return;
                }
                this.a.f = list;
                this.a.d.lock();
                try {
                    if (!this.a.b) {
                        return;
                    }
                    this.a.e.removeCallbacks(this.a.g);
                    this.a.m(list);
                    this.a.b = false;
                } finally {
                    this.a.d.unlock();
                }
            }
        }

        /* renamed from: com.baidu.tieba.eh3$c$c  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0261c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ dl3 a;
            public final /* synthetic */ c b;

            public RunnableC0261c(c cVar, dl3 dl3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, dl3Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = dl3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!this.b.i.e) {
                        this.b.i.g(12000, "not init", null, this.a);
                    } else if (!this.b.i.b.isWifiEnabled()) {
                        this.b.i.g(12005, "wifi is not on", null, this.a);
                    } else if (!ek3.K(this.b.i.a)) {
                        this.b.i.g(12006, "LBS is not on", null, this.a);
                    } else if (ContextCompat.checkSelfPermission(this.b.i.a, com.kuaishou.weapon.p0.g.g) != 0) {
                        this.b.i.g(CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, "no location permission", null, this.a);
                    } else {
                        this.b.d.lock();
                        try {
                            if (this.b.b) {
                                this.b.c.add(this.a);
                                return;
                            }
                            this.b.b = true;
                            this.b.d.unlock();
                            this.b.e.postDelayed(this.b.g, LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION);
                            this.b.i.b.startScan();
                            this.b.i.g(0, "success", null, this.a);
                        } finally {
                            this.b.d.unlock();
                        }
                    }
                }
            }
        }

        public c(eh3 eh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eh3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = eh3Var;
            this.a = new CopyOnWriteArrayList();
            this.b = false;
            this.c = new CopyOnWriteArrayList();
            this.d = new ReentrantLock();
            this.e = new Handler(Looper.getMainLooper());
            this.g = new a(this);
            b bVar = new b(this);
            this.h = bVar;
            eh3Var.c.setScanListener(bVar);
        }

        public final void m(List<ScanResult> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                ArrayList arrayList = new ArrayList();
                if (list != null) {
                    for (ScanResult scanResult : list) {
                        arrayList.add(new jh3(scanResult));
                    }
                }
                List<dl3<kh3<List<jh3>>>> list2 = this.a;
                for (dl3<kh3<List<jh3>>> dl3Var : list2) {
                    this.i.g(0, "success", arrayList, dl3Var);
                }
                List<dl3<kh3<Void>>> list3 = this.c;
                this.c = new CopyOnWriteArrayList();
                for (dl3<kh3<Void>> dl3Var2 : list3) {
                    this.i.g(0, "success", null, dl3Var2);
                    for (dl3<kh3<List<jh3>>> dl3Var3 : list2) {
                        this.i.g(0, "success", arrayList, dl3Var3);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.gh3
        public boolean b(dl3<kh3<List<jh3>>> dl3Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dl3Var)) == null) {
                if (dl3Var == null) {
                    return false;
                }
                List<dl3<kh3<List<jh3>>>> list = this.a;
                if (!list.contains(dl3Var)) {
                    return true;
                }
                return list.remove(dl3Var);
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.gh3
        public void c(dl3<kh3<Void>> dl3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dl3Var) != null) || dl3Var == null) {
                return;
            }
            ej3.k(new RunnableC0261c(this, dl3Var), "wifiScan");
        }

        @Override // com.baidu.tieba.gh3
        public boolean d(dl3<kh3<List<jh3>>> dl3Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dl3Var)) == null) {
                if (dl3Var == null) {
                    return false;
                }
                List<dl3<kh3<List<jh3>>>> list = this.a;
                if (list.contains(dl3Var)) {
                    return true;
                }
                return list.add(dl3Var);
            }
            return invokeL.booleanValue;
        }

        public void n() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.a = new CopyOnWriteArrayList();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements ch3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eh3 a;

        public a(eh3 eh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eh3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eh3Var;
        }

        @Override // com.baidu.tieba.ch3
        public void a(WifiInfo wifiInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wifiInfo) == null) {
                if (wifiInfo == null) {
                    wifiInfo = this.a.b.getConnectionInfo();
                }
                this.a.m(wifiInfo);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dl3 a;
        public final /* synthetic */ eh3 b;

        public b(eh3 eh3Var, dl3 dl3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eh3Var, dl3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = eh3Var;
            this.a = dl3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                WifiInfo wifiInfo = null;
                if (!this.b.e) {
                    this.b.g(12000, "not init", null, this.a);
                } else if (!this.b.b.isWifiEnabled()) {
                    this.b.g(12005, "wifi is not on", null, this.a);
                } else if (!ek3.K(this.b.a)) {
                    this.b.g(12006, "LBS is not on", null, this.a);
                } else if (ContextCompat.checkSelfPermission(this.b.a, com.kuaishou.weapon.p0.g.g) != 0) {
                    this.b.g(CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, "no location permission", null, this.a);
                } else {
                    WifiInfo connectionInfo = this.b.b.getConnectionInfo();
                    if (connectionInfo == null || connectionInfo.getSupplicantState() == SupplicantState.COMPLETED) {
                        wifiInfo = connectionInfo;
                    }
                    eh3 eh3Var = this.b;
                    eh3Var.g(0, "success", new jh3(wifiInfo, mh3.a(lh3.b(eh3Var.a, eh3Var.b, wifiInfo))), this.a);
                }
            }
        }
    }

    public eh3(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = false;
        this.f = new CopyOnWriteArrayList();
        this.g = new a(this);
        this.a = context;
        this.b = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        SwanWifiBroadcastReceiver swanWifiBroadcastReceiver = new SwanWifiBroadcastReceiver(this.b);
        this.c = swanWifiBroadcastReceiver;
        swanWifiBroadcastReceiver.setConnectSuccessListener(this.g);
        this.d = new c(this);
    }

    @Override // com.baidu.tieba.gh3
    public boolean b(dl3<kh3<List<jh3>>> dl3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dl3Var)) == null) {
            return this.d.b(dl3Var);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.gh3
    public void c(dl3<kh3<Void>> dl3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dl3Var) == null) {
            this.d.c(dl3Var);
        }
    }

    @Override // com.baidu.tieba.gh3
    public boolean d(dl3<kh3<List<jh3>>> dl3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dl3Var)) == null) {
            return this.d.d(dl3Var);
        }
        return invokeL.booleanValue;
    }

    public void j(dl3<kh3<jh3>> dl3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, dl3Var) != null) || dl3Var == null) {
            return;
        }
        ej3.k(new b(this, dl3Var), "getConnectedWifi");
    }

    public boolean n(dl3<kh3<jh3>> dl3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, dl3Var)) == null) {
            if (dl3Var == null) {
                return false;
            }
            List<dl3<kh3<jh3>>> list = this.f;
            if (list.contains(dl3Var)) {
                return true;
            }
            return list.add(dl3Var);
        }
        return invokeL.booleanValue;
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.e = z;
        }
    }

    public void p(dl3<kh3<Void>> dl3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dl3Var) == null) {
            if (this.e) {
                g(0, "success", null, dl3Var);
                return;
            }
            k();
            g(0, "success", null, dl3Var);
        }
    }

    public void q(dl3<kh3<Void>> dl3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dl3Var) == null) {
            if (!this.e) {
                g(0, "success", null, dl3Var);
                return;
            }
            i();
            g(0, "success", null, dl3Var);
        }
    }

    public boolean r(dl3<kh3<jh3>> dl3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, dl3Var)) == null) {
            if (dl3Var == null) {
                return false;
            }
            List<dl3<kh3<jh3>>> list = this.f;
            if (!list.contains(dl3Var)) {
                return true;
            }
            return list.remove(dl3Var);
        }
        return invokeL.booleanValue;
    }

    public <ResultType> void g(int i, String str, ResultType resulttype, dl3<kh3<ResultType>> dl3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, resulttype, dl3Var}) != null) || dl3Var == null) {
            return;
        }
        kh3<ResultType> kh3Var = new kh3<>();
        kh3Var.a = i;
        kh3Var.b = str;
        kh3Var.c = resulttype;
        dl3Var.a(kh3Var);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c.unregisterSelf(this.a);
            this.f = new CopyOnWriteArrayList();
            ((c) this.d).n();
            o(false);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.c.unregisterSelf(this.a);
            o(false);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.c.registerSelf(this.a);
            o(true);
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public final void m(WifiInfo wifiInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, wifiInfo) == null) {
            for (dl3<kh3<jh3>> dl3Var : this.f) {
                g(0, "success", new jh3(wifiInfo, mh3.a(lh3.b(this.a, this.b, wifiInfo))), dl3Var);
            }
        }
    }
}
