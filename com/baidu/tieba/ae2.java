package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.v92;
import com.baidu.tieba.xl4;
import com.baidu.tieba.zt2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class ae2 extends he2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public lo4 c;
    public xd2 d;
    public final List<dk4> e;
    public AtomicInteger f;
    public boolean g;
    public final CopyOnWriteArraySet<String> h;
    public qi4<xl4.a> i;
    public ui4<dk4> j;
    public final ui4<ek4> k;

    @Override // com.baidu.tieba.he2
    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 7;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class b extends qi4<xl4.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ae2 a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ xl4.a a;
            public final /* synthetic */ b b;

            public a(b bVar, xl4.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, aVar};
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
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.b.a.V(this.a)) {
                        this.b.a.W();
                        if (this.b.a.d != null) {
                            this.b.a.d.c(this.a);
                        }
                        te2.c(this.a.g.appId);
                    }
                    sj2.f(this.a.b);
                }
            }
        }

        public b(ae2 ae2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ae2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ae2Var;
        }

        @Override // com.baidu.tieba.qi4
        public void l(@NonNull PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, pMSAppInfo) == null) && pMSAppInfo.isForbiddenApp()) {
                nd3.L(pMSAppInfo.appId, pMSAppInfo.appStatus);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4
        /* renamed from: q */
        public String d(xl4.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, aVar)) == null) {
                if (aVar == null) {
                    return null;
                }
                int i = aVar.c;
                if (i == 0) {
                    return ve2.g();
                }
                if (i != 1) {
                    return null;
                }
                return ve2.i();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: u */
        public void c(xl4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
                super.c(aVar);
                d82.k("SwanAppBatchDownloadCallback", "onDownloadStart: " + aVar.b);
            }
        }

        @Override // com.baidu.tieba.wi4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.qi4
        public void p(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, pMSAppInfo, pMSAppInfo2) == null) {
                if (pMSAppInfo != null && pMSAppInfo.isForbiddenApp()) {
                    nd3.L(pMSAppInfo.appKey, pMSAppInfo.appStatus);
                }
                this.a.X(pMSAppInfo, pMSAppInfo2);
            }
        }

        @Override // com.baidu.tieba.qi4
        public void o(xl4.a aVar, PMSAppInfo pMSAppInfo, xj4 xj4Var) {
            PMSAppInfo pMSAppInfo2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar, pMSAppInfo, xj4Var) == null) {
                d82.k("SwanAppBatchDownloadCallback", "#onSingleFetchError errorNo=" + xj4Var.a + " errorMsg=" + xj4Var.b + " errorDetails=" + xj4Var.d);
                if (this.a.d != null) {
                    this.a.d.f(xj4Var);
                }
                if (xj4Var.a == 1010) {
                    if (aVar == null) {
                        pMSAppInfo2 = null;
                    } else {
                        pMSAppInfo2 = aVar.g;
                    }
                    if (pMSAppInfo2 == null) {
                        pMSAppInfo2 = pMSAppInfo;
                    }
                    this.a.X(pMSAppInfo2, pMSAppInfo);
                    if (te2.m(xj4Var) && pMSAppInfo2 != null) {
                        te2.c(pMSAppInfo2.appId);
                        return;
                    }
                    return;
                }
                this.a.g = true;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: r */
        public void e(xl4.a aVar, xj4 xj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, aVar, xj4Var) == null) {
                super.e(aVar, xj4Var);
                d82.k("SwanAppBatchDownloadCallback", "onDownloadError：" + xj4Var.toString());
                sj2.f(aVar.b);
                wm3 wm3Var = new wm3();
                wm3Var.k(11L);
                wm3Var.i(xj4Var.a);
                wm3Var.d("批量下载，主包下载失败：" + aVar.b);
                wm3Var.f(xj4Var.toString());
                if (aVar.a != 0) {
                    if (ae2.l) {
                        Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + wm3Var.toString());
                    }
                } else if (aVar.d == null) {
                } else {
                    this.a.c.l(aVar.d);
                    zd2.c().a(aVar.d, PMSDownloadType.BATCH, wm3Var);
                    d82.k("SwanAppBatchDownloadCallback", "#onDownloadError del: " + aVar.d.a);
                    hr4.k(aVar.d.a);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: s */
        public void i(xl4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
                super.i(aVar);
                d82.k("SwanAppBatchDownloadCallback", "onFileDownloaded: " + aVar.d.i);
                this.a.h.add(aVar.b);
                a aVar2 = new a(this, aVar);
                ExecutorUtilsExt.postOnSerial(aVar2, aVar.d.g + " 下载完成，执行签名校验-重命名-解压-DB");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: t */
        public void a(xl4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
                super.a(aVar);
                if (ae2.l) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + aVar.d.b + "/" + aVar.d.k);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: v */
        public void f(xl4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
                if (ae2.l) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + aVar.b);
                }
                sj2.f(aVar.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ae2 a;

        public a(ae2 ae2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ae2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ae2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean b = aj4.i().b(null, this.a.e, null, null, null);
                if (b) {
                    for (dk4 dk4Var : this.a.e) {
                        if (this.a.d != null) {
                            this.a.d.g(dk4Var);
                        }
                        this.a.W();
                    }
                }
                if (ae2.l) {
                    Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + b + ", size=" + this.a.e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;
        public final /* synthetic */ PMSAppInfo b;
        public final /* synthetic */ ae2 c;

        public c(ae2 ae2Var, PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ae2Var, pMSAppInfo, pMSAppInfo2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ae2Var;
            this.a = pMSAppInfo;
            this.b = pMSAppInfo2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PMSAppInfo pMSAppInfo = this.a;
                if (pMSAppInfo != null) {
                    pMSAppInfo.updateInstallSrc(this.c.J());
                    this.b.copyLocalAppInfoData(this.a);
                } else {
                    this.b.updateInstallSrc(this.c.J());
                }
                this.b.initMaxAgeInfo();
                if (aj4.i().l(this.b)) {
                    ve2.o(this.b);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends ke2<ae2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ae2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ae2 ae2Var, ae2 ae2Var2) {
            super(ae2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ae2Var, ae2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((he2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ae2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: q */
        public void e(dk4 dk4Var, xj4 xj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, dk4Var, xj4Var) == null) {
                super.q(dk4Var, xj4Var);
                sj2.f(dk4Var.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: u */
        public void f(dk4 dk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dk4Var) == null) {
                super.f(dk4Var);
                sj2.f(dk4Var.o);
            }
        }

        @Override // com.baidu.tieba.ke2
        public void p(@NonNull dk4 dk4Var, @Nullable wm3 wm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dk4Var, wm3Var) == null) {
                super.p(dk4Var, wm3Var);
                if (wm3Var == null) {
                    this.c.e.add(dk4Var);
                } else if (ae2.l) {
                    Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + dk4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + wm3Var);
                }
                sj2.f(dk4Var.o);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends ie2<ae2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ae2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ae2 ae2Var, ae2 ae2Var2) {
            super(ae2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ae2Var, ae2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((he2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ae2Var;
        }

        @Override // com.baidu.tieba.ie2
        public void r(@NonNull ek4 ek4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ek4Var) == null) {
                if (ae2.l) {
                    Log.v("SwanAppBatchDownloadCallback", "onDownloadAndUnzipSuccess:" + ek4Var);
                }
                if (this.b.d != null) {
                    this.b.d.e(ek4Var);
                }
                this.b.W();
            }
        }

        @Override // com.baidu.tieba.ie2
        public void u(ek4 ek4Var, wm3 wm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ek4Var, wm3Var) == null) {
                d82.k("SwanAppBatchDownloadCallback", "onDownloadOrUnzipFail:" + ek4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + wm3Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947612219, "Lcom/baidu/tieba/ae2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947612219, "Lcom/baidu/tieba/ae2;");
                return;
            }
        }
        l = nr1.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ae2() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((xd2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.yi4
    public ui4<dk4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.j;
        }
        return (ui4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yi4
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.D();
            d82.k("SwanAppBatchDownloadCallback", "onFetchStart");
        }
    }

    @Override // com.baidu.tieba.yi4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.E();
            d82.k("SwanAppBatchDownloadCallback", "onFetchSuccess");
        }
    }

    @Override // com.baidu.tieba.yi4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.F();
            d82.k("SwanAppBatchDownloadCallback", "onNoPackage");
            xd2 xd2Var = this.d;
            if (xd2Var != null) {
                xd2Var.d();
            }
        }
    }

    @Override // com.baidu.tieba.yi4
    public ui4<ek4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.k;
        }
        return (ui4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yi4
    public qi4<xl4.a> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.i;
        }
        return (qi4) invokeV.objValue;
    }

    public ae2(xd2 xd2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xd2Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.i = new b(this);
        this.j = new d(this, this);
        this.k = new e(this, this);
        this.d = xd2Var;
        this.e = new Vector();
        this.f = new AtomicInteger(0);
        this.h = new CopyOnWriteArraySet<>();
    }

    @Override // com.baidu.tieba.yi4
    public void G(lo4 lo4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, lo4Var) == null) {
            super.G(lo4Var);
            this.c = lo4Var;
            sj2.e(lo4Var);
            d82.k("SwanAppBatchDownloadCallback", "onPrepareDownload: " + lo4Var.n());
        }
    }

    public final void X(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, pMSAppInfo, pMSAppInfo2) != null) || pMSAppInfo == null) {
            return;
        }
        xn3.k(new c(this, pMSAppInfo2, pMSAppInfo), "批量下载-只更新AppInfo-存储DB");
    }

    @Override // com.baidu.tieba.yi4
    public void C(xj4 xj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xj4Var) == null) {
            super.C(xj4Var);
            d82.k("SwanAppBatchDownloadCallback", "onFetchError: " + xj4Var.toString());
            xd2 xd2Var = this.d;
            if (xd2Var != null) {
                xd2Var.b(xj4Var.a);
            }
        }
    }

    public final boolean V(xl4.a aVar) {
        InterceptResult invokeL;
        int c2;
        PMSAppInfo pMSAppInfo;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
            if (aVar == null || aVar.d == null || aVar.g == null) {
                return false;
            }
            if (!qo3.a(new File(aVar.d.a), aVar.d.m)) {
                d82.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
                return false;
            }
            wm3 m = ve2.m(aVar.d, this);
            if (m != null) {
                d82.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + m);
                return false;
            }
            aVar.g.initMaxAgeInfo();
            ve2.k(aVar.g, aVar.d);
            aVar.g.updateInstallSrc(J());
            if (!aj4.i().a(aVar.d, aVar.g)) {
                d82.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
                return false;
            }
            this.c.m(aVar.d);
            if (!aVar.h) {
                ve2.o(aVar.g);
            }
            ve2.b(aVar.d);
            ck4 ck4Var = aVar.d;
            if (ck4Var != null) {
                pb3.c(zt2.e.i(ck4Var.g, String.valueOf(ck4Var.i)).getAbsolutePath(), true);
            }
            ck4 ck4Var2 = aVar.d;
            if (ck4Var2 == null || ck4Var2.h != 0 || ((c2 = v92.b.c()) > 0 && (pMSAppInfo = aVar.g) != null && ((i = pMSAppInfo.rank) == 0 || i > c2))) {
                return true;
            }
            sd2 i2 = sd2.i();
            ck4 ck4Var3 = aVar.d;
            i2.f(ck4Var3.g, ck4Var3.i);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void W() {
        xd2 xd2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int incrementAndGet = this.f.incrementAndGet();
            int n = this.c.n();
            if (l) {
                Log.d("SwanAppBatchDownloadCallback", "batch download,total pkg num - " + n + ",success num - " + incrementAndGet);
            }
            if (incrementAndGet == n && !this.g && (xd2Var = this.d) != null) {
                xd2Var.a();
            }
        }
    }

    @Override // com.baidu.tieba.yi4, com.baidu.tieba.vi4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.b();
            d82.k("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            if (l) {
                Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            }
            if (!this.e.isEmpty()) {
                xn3.k(new a(this), "SwanAppBatchDownloadCallback");
            }
            xd2 xd2Var = this.d;
            if (xd2Var != null) {
                xd2Var.h();
            }
            if (!tj2.a()) {
                d82.k("SwanAppBatchDownloadCallback", "#onTotalPkgDownloadFinish excludeIds=" + this.h);
                nj2 d2 = pj2.c().d();
                CopyOnWriteArraySet<String> copyOnWriteArraySet = this.h;
                yk2 l2 = yk2.l();
                l2.i(7);
                d2.t(copyOnWriteArraySet, false, l2.k());
            }
        }
    }
}
