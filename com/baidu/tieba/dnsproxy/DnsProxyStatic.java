package com.baidu.tieba.dnsproxy;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.switchs.DnsProxySwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.j.a.d;
import d.a.c.e.p.j;
import d.a.s0.h0.e;
import d.a.s0.h0.f;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
/* loaded from: classes5.dex */
public class DnsProxyStatic {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f14539a;

    /* renamed from: b  reason: collision with root package name */
    public static int f14540b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends d.a.c.e.j.a.a {
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

        @Override // d.a.c.e.j.a.a
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

        @Override // d.a.c.e.j.a.a
        public void c(d.a.c.e.j.a.e eVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) && eVar != null && j.z()) {
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

    /* loaded from: classes5.dex */
    public static class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes5.dex */
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
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                d.a.c.e.m.e.a().postDelayed(new a(this), 1000L);
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
        MessageManager.getInstance().registerListener(new b(2007015));
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
        if (interceptable == null || interceptable.invokeV(65540, null) == null) {
            d.a.c.e.j.a.a.d(null);
            e.i().f();
        }
    }

    public static final void d(d.a.c.e.j.a.e eVar, d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, eVar, dVar) == null) || eVar == null || dVar == null) {
            return;
        }
        boolean z = eVar.c().f44207b >= 400;
        if (eVar.c().f44207b < 200) {
            z = true;
        }
        byte[] bArr = eVar.c().f44213h;
        if (bArr == null) {
            z = true;
        }
        if (bArr != null && bArr.length == 0) {
            z = true;
        }
        if (z) {
            try {
                URL url = new URL(eVar.b().i());
                d.a.c.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.b("workflow", "dnsproxy_unuse");
                statsItem.c("sucnum", Integer.valueOf(f14540b));
                statsItem.c("failnum", 1);
                statsItem.b("host", url.getHost());
                statsItem.b("reason", dVar.f44193h);
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                f14540b = 0;
                return;
            } catch (Throwable th) {
                BdLog.detailException(th);
                return;
            }
        }
        int i2 = f14540b + 1;
        f14540b = i2;
        if (i2 >= 100) {
            g();
        }
    }

    public static final void e(d.a.c.e.j.a.e eVar, d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, eVar, dVar) == null) || eVar == null || dVar == null) {
            return;
        }
        boolean z = eVar.c().f44207b >= 400;
        if (eVar.c().f44207b < 200) {
            z = true;
        }
        byte[] bArr = eVar.c().f44213h;
        if (bArr == null) {
            z = true;
        }
        if (bArr != null && bArr.length == 0) {
            z = true;
        }
        d.a.s0.h0.i.d.m().p(dVar.l, !z);
        if (z) {
            try {
                URL url = new URL(eVar.b().i());
                d.a.c.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.b("workflow", "dnsproxy_use");
                statsItem.c("sucnum", Integer.valueOf(f14539a));
                statsItem.c("failnum", 1);
                statsItem.b("host", url.getHost());
                statsItem.b("ip", dVar.l);
                statsItem.b("reason", dVar.f44193h);
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                f14539a = 0;
                return;
            } catch (Throwable th) {
                BdLog.detailException(th);
                return;
            }
        }
        int i2 = f14539a + 1;
        f14539a = i2;
        if (i2 >= 100) {
            h();
        }
    }

    public static final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            d.a.c.e.j.a.a.d(new a());
            e.i().n();
        }
    }

    public static final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, null) == null) || f14540b <= 0) {
            return;
        }
        try {
            d.a.c.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.b("workflow", "dnsproxy_unuse");
            statsItem.c("sucnum", Integer.valueOf(f14540b));
            BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
            f14540b = 0;
        } catch (Throwable th) {
            BdLog.detailException(th);
        }
    }

    public static final void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, null) == null) || f14539a <= 0) {
            return;
        }
        try {
            d.a.c.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.b("workflow", "dnsproxy_use");
            statsItem.c("sucnum", Integer.valueOf(f14539a));
            BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
            f14539a = 0;
        } catch (Throwable th) {
            BdLog.detailException(th);
        }
    }
}
