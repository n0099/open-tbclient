package com.baidu.tieba.dnsproxy;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.j.a.d;
import c.a.d.f.p.l;
import c.a.t0.p0.e;
import c.a.t0.p0.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.switchs.DnsProxySwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
/* loaded from: classes12.dex */
public class DnsProxyStatic {
    public static /* synthetic */ Interceptable $ic;
    public static int a;

    /* renamed from: b  reason: collision with root package name */
    public static int f42476b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes12.dex */
    public static class a extends c.a.d.f.j.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.d.f.j.a.a
        public String a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (f.a().c(str)) {
                    try {
                        return e.i().h(new URL(str).getHost(), f.a().b(str));
                    } catch (MalformedURLException e2) {
                        e2.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // c.a.d.f.j.a.a
        public void c(c.a.d.f.j.a.e eVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) && eVar != null && l.z()) {
                d dVar = null;
                List<d> d2 = eVar.d();
                if (d2 != null && d2.size() > 0) {
                    dVar = d2.get(0);
                }
                if (dVar != null) {
                    if (!TextUtils.isEmpty(dVar.l)) {
                        DnsProxyStatic.e(eVar, dVar);
                    } else {
                        DnsProxyStatic.d(eVar, dVar);
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes12.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (SwitchManager.getInstance().findType(DnsProxySwitch.DNSPROXY_KEY) == 1) {
                        DnsProxyStatic.f();
                    } else {
                        DnsProxyStatic.c();
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && PermissionUtil.isAgreePrivacyPolicy()) {
                c.a.d.f.m.e.a().postDelayed(new a(this), 1000L);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(407339404, "Lcom/baidu/tieba/dnsproxy/DnsProxyStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(407339404, "Lcom/baidu/tieba/dnsproxy/DnsProxyStatic;");
                return;
            }
        }
        b bVar = new b(0);
        MessageManager.getInstance().registerListener(2007015, bVar);
        MessageManager.getInstance().registerListener(2921644, bVar);
    }

    public DnsProxyStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            c.a.d.f.j.a.a.d(null);
            e.i().f();
        }
    }

    public static final void d(c.a.d.f.j.a.e eVar, d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, null, eVar, dVar) == null) || eVar == null || dVar == null) {
            return;
        }
        boolean z = eVar.c().f2913b >= 400;
        if (eVar.c().f2913b < 200) {
            z = true;
        }
        byte[] bArr = eVar.c().f2919h;
        if (bArr == null) {
            z = true;
        }
        if (bArr != null && bArr.length == 0) {
            z = true;
        }
        if (z) {
            try {
                URL url = new URL(eVar.b().i());
                c.a.d.f.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.b("workflow", "dnsproxy_unuse");
                statsItem.c("sucnum", Integer.valueOf(f42476b));
                statsItem.c("failnum", 1);
                statsItem.b("host", url.getHost());
                statsItem.b("reason", dVar.f2901h);
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                f42476b = 0;
                return;
            } catch (Throwable th) {
                BdLog.detailException(th);
                return;
            }
        }
        int i2 = f42476b + 1;
        f42476b = i2;
        if (i2 >= 100) {
            g();
        }
    }

    public static final void e(c.a.d.f.j.a.e eVar, d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, eVar, dVar) == null) || eVar == null || dVar == null) {
            return;
        }
        boolean z = eVar.c().f2913b >= 400;
        if (eVar.c().f2913b < 200) {
            z = true;
        }
        byte[] bArr = eVar.c().f2919h;
        if (bArr == null) {
            z = true;
        }
        if (bArr != null && bArr.length == 0) {
            z = true;
        }
        c.a.t0.p0.i.d.m().p(dVar.l, !z);
        if (z) {
            try {
                URL url = new URL(eVar.b().i());
                c.a.d.f.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.b("workflow", "dnsproxy_use");
                statsItem.c("sucnum", Integer.valueOf(a));
                statsItem.c("failnum", 1);
                statsItem.b("host", url.getHost());
                statsItem.b("ip", dVar.l);
                statsItem.b("reason", dVar.f2901h);
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                a = 0;
                return;
            } catch (Throwable th) {
                BdLog.detailException(th);
                return;
            }
        }
        int i2 = a + 1;
        a = i2;
        if (i2 >= 100) {
            h();
        }
    }

    public static final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, null) == null) && PermissionUtil.isAgreePrivacyPolicy()) {
            c.a.d.f.j.a.a.d(new a());
            e.i().n();
        }
    }

    public static final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, null) == null) || f42476b <= 0) {
            return;
        }
        try {
            c.a.d.f.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.b("workflow", "dnsproxy_unuse");
            statsItem.c("sucnum", Integer.valueOf(f42476b));
            BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
            f42476b = 0;
        } catch (Throwable th) {
            BdLog.detailException(th);
        }
    }

    public static final void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, null) == null) || a <= 0) {
            return;
        }
        try {
            c.a.d.f.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.b("workflow", "dnsproxy_use");
            statsItem.c("sucnum", Integer.valueOf(a));
            BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
            a = 0;
        } catch (Throwable th) {
            BdLog.detailException(th);
        }
    }
}
