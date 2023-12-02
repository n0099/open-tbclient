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
import com.baidu.tieba.c52;
import com.baidu.tieba.eh4;
import com.baidu.tieba.gp2;
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
/* loaded from: classes6.dex */
public class h92 extends o92 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public sj4 c;
    public e92 d;
    public final List<kf4> e;
    public AtomicInteger f;
    public boolean g;
    public final CopyOnWriteArraySet<String> h;
    public xd4<eh4.a> i;
    public be4<kf4> j;
    public final be4<lf4> k;

    @Override // com.baidu.tieba.o92
    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 7;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public class b extends xd4<eh4.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h92 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ eh4.a a;
            public final /* synthetic */ b b;

            public a(b bVar, eh4.a aVar) {
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
                        aa2.c(this.a.g.appId);
                    }
                    ze2.f(this.a.b);
                }
            }
        }

        public b(h92 h92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h92Var;
        }

        @Override // com.baidu.tieba.xd4
        public void l(@NonNull PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, pMSAppInfo) == null) && pMSAppInfo.isForbiddenApp()) {
                u83.L(pMSAppInfo.appId, pMSAppInfo.appStatus);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.be4
        /* renamed from: q */
        public String d(eh4.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, aVar)) == null) {
                if (aVar == null) {
                    return null;
                }
                int i = aVar.c;
                if (i == 0) {
                    return ca2.g();
                }
                if (i != 1) {
                    return null;
                }
                return ca2.i();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: u */
        public void c(eh4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
                super.c(aVar);
                k32.k("SwanAppBatchDownloadCallback", "onDownloadStart: " + aVar.b);
            }
        }

        @Override // com.baidu.tieba.de4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.xd4
        public void p(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, pMSAppInfo, pMSAppInfo2) == null) {
                if (pMSAppInfo != null && pMSAppInfo.isForbiddenApp()) {
                    u83.L(pMSAppInfo.appKey, pMSAppInfo.appStatus);
                }
                this.a.X(pMSAppInfo, pMSAppInfo2);
            }
        }

        @Override // com.baidu.tieba.xd4
        public void o(eh4.a aVar, PMSAppInfo pMSAppInfo, ef4 ef4Var) {
            PMSAppInfo pMSAppInfo2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar, pMSAppInfo, ef4Var) == null) {
                k32.k("SwanAppBatchDownloadCallback", "#onSingleFetchError errorNo=" + ef4Var.a + " errorMsg=" + ef4Var.b + " errorDetails=" + ef4Var.d);
                if (this.a.d != null) {
                    this.a.d.f(ef4Var);
                }
                if (ef4Var.a == 1010) {
                    if (aVar == null) {
                        pMSAppInfo2 = null;
                    } else {
                        pMSAppInfo2 = aVar.g;
                    }
                    if (pMSAppInfo2 == null) {
                        pMSAppInfo2 = pMSAppInfo;
                    }
                    this.a.X(pMSAppInfo2, pMSAppInfo);
                    if (aa2.m(ef4Var) && pMSAppInfo2 != null) {
                        aa2.c(pMSAppInfo2.appId);
                        return;
                    }
                    return;
                }
                this.a.g = true;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: r */
        public void e(eh4.a aVar, ef4 ef4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, aVar, ef4Var) == null) {
                super.e(aVar, ef4Var);
                k32.k("SwanAppBatchDownloadCallback", "onDownloadError：" + ef4Var.toString());
                ze2.f(aVar.b);
                di3 di3Var = new di3();
                di3Var.k(11L);
                di3Var.i(ef4Var.a);
                di3Var.d("批量下载，主包下载失败：" + aVar.b);
                di3Var.f(ef4Var.toString());
                if (aVar.a != 0) {
                    if (h92.l) {
                        Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + di3Var.toString());
                    }
                } else if (aVar.d == null) {
                } else {
                    this.a.c.l(aVar.d);
                    g92.c().a(aVar.d, PMSDownloadType.BATCH, di3Var);
                    k32.k("SwanAppBatchDownloadCallback", "#onDownloadError del: " + aVar.d.a);
                    nm4.k(aVar.d.a);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: s */
        public void i(eh4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
                super.i(aVar);
                k32.k("SwanAppBatchDownloadCallback", "onFileDownloaded: " + aVar.d.i);
                this.a.h.add(aVar.b);
                a aVar2 = new a(this, aVar);
                ExecutorUtilsExt.postOnSerial(aVar2, aVar.d.g + " 下载完成，执行签名校验-重命名-解压-DB");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: t */
        public void a(eh4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
                super.a(aVar);
                if (h92.l) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + aVar.d.b + "/" + aVar.d.k);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: v */
        public void f(eh4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
                if (h92.l) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + aVar.b);
                }
                ze2.f(aVar.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h92 a;

        public a(h92 h92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h92Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean b = he4.i().b(null, this.a.e, null, null, null);
                if (b) {
                    for (kf4 kf4Var : this.a.e) {
                        if (this.a.d != null) {
                            this.a.d.g(kf4Var);
                        }
                        this.a.W();
                    }
                }
                if (h92.l) {
                    Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + b + ", size=" + this.a.e);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;
        public final /* synthetic */ PMSAppInfo b;
        public final /* synthetic */ h92 c;

        public c(h92 h92Var, PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var, pMSAppInfo, pMSAppInfo2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = h92Var;
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
                if (he4.i().l(this.b)) {
                    ca2.o(this.b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends r92<h92> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h92 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(h92 h92Var, h92 h92Var2) {
            super(h92Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var, h92Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((o92) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = h92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: q */
        public void e(kf4 kf4Var, ef4 ef4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, kf4Var, ef4Var) == null) {
                super.q(kf4Var, ef4Var);
                ze2.f(kf4Var.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: u */
        public void f(kf4 kf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, kf4Var) == null) {
                super.f(kf4Var);
                ze2.f(kf4Var.o);
            }
        }

        @Override // com.baidu.tieba.r92
        public void p(@NonNull kf4 kf4Var, @Nullable di3 di3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, kf4Var, di3Var) == null) {
                super.p(kf4Var, di3Var);
                if (di3Var == null) {
                    this.c.e.add(kf4Var);
                } else if (h92.l) {
                    Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + kf4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + di3Var);
                }
                ze2.f(kf4Var.o);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends p92<h92> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h92 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(h92 h92Var, h92 h92Var2) {
            super(h92Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var, h92Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((o92) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h92Var;
        }

        @Override // com.baidu.tieba.p92
        public void r(@NonNull lf4 lf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lf4Var) == null) {
                if (h92.l) {
                    Log.v("SwanAppBatchDownloadCallback", "onDownloadAndUnzipSuccess:" + lf4Var);
                }
                if (this.b.d != null) {
                    this.b.d.e(lf4Var);
                }
                this.b.W();
            }
        }

        @Override // com.baidu.tieba.p92
        public void u(lf4 lf4Var, di3 di3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lf4Var, di3Var) == null) {
                k32.k("SwanAppBatchDownloadCallback", "onDownloadOrUnzipFail:" + lf4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + di3Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947778472, "Lcom/baidu/tieba/h92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947778472, "Lcom/baidu/tieba/h92;");
                return;
            }
        }
        l = vm1.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h92() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((e92) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.fe4
    public be4<kf4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.j;
        }
        return (be4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fe4
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.D();
            k32.k("SwanAppBatchDownloadCallback", "onFetchStart");
        }
    }

    @Override // com.baidu.tieba.fe4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.E();
            k32.k("SwanAppBatchDownloadCallback", "onFetchSuccess");
        }
    }

    @Override // com.baidu.tieba.fe4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.F();
            k32.k("SwanAppBatchDownloadCallback", "onNoPackage");
            e92 e92Var = this.d;
            if (e92Var != null) {
                e92Var.d();
            }
        }
    }

    @Override // com.baidu.tieba.fe4
    public be4<lf4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.k;
        }
        return (be4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fe4
    public xd4<eh4.a> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.i;
        }
        return (xd4) invokeV.objValue;
    }

    public h92(e92 e92Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e92Var};
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
        this.d = e92Var;
        this.e = new Vector();
        this.f = new AtomicInteger(0);
        this.h = new CopyOnWriteArraySet<>();
    }

    @Override // com.baidu.tieba.fe4
    public void G(sj4 sj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sj4Var) == null) {
            super.G(sj4Var);
            this.c = sj4Var;
            ze2.e(sj4Var);
            k32.k("SwanAppBatchDownloadCallback", "onPrepareDownload: " + sj4Var.n());
        }
    }

    public final void X(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, pMSAppInfo, pMSAppInfo2) != null) || pMSAppInfo == null) {
            return;
        }
        ej3.k(new c(this, pMSAppInfo2, pMSAppInfo), "批量下载-只更新AppInfo-存储DB");
    }

    @Override // com.baidu.tieba.fe4
    public void C(ef4 ef4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ef4Var) == null) {
            super.C(ef4Var);
            k32.k("SwanAppBatchDownloadCallback", "onFetchError: " + ef4Var.toString());
            e92 e92Var = this.d;
            if (e92Var != null) {
                e92Var.b(ef4Var.a);
            }
        }
    }

    public final boolean V(eh4.a aVar) {
        InterceptResult invokeL;
        int c2;
        PMSAppInfo pMSAppInfo;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
            if (aVar == null || aVar.d == null || aVar.g == null) {
                return false;
            }
            if (!xj3.a(new File(aVar.d.a), aVar.d.m)) {
                k32.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
                return false;
            }
            di3 m = ca2.m(aVar.d, this);
            if (m != null) {
                k32.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + m);
                return false;
            }
            aVar.g.initMaxAgeInfo();
            ca2.k(aVar.g, aVar.d);
            aVar.g.updateInstallSrc(J());
            if (!he4.i().a(aVar.d, aVar.g)) {
                k32.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
                return false;
            }
            this.c.m(aVar.d);
            if (!aVar.h) {
                ca2.o(aVar.g);
            }
            ca2.b(aVar.d);
            jf4 jf4Var = aVar.d;
            if (jf4Var != null) {
                w63.c(gp2.e.i(jf4Var.g, String.valueOf(jf4Var.i)).getAbsolutePath(), true);
            }
            jf4 jf4Var2 = aVar.d;
            if (jf4Var2 == null || jf4Var2.h != 0 || ((c2 = c52.b.c()) > 0 && (pMSAppInfo = aVar.g) != null && ((i = pMSAppInfo.rank) == 0 || i > c2))) {
                return true;
            }
            z82 i2 = z82.i();
            jf4 jf4Var3 = aVar.d;
            i2.f(jf4Var3.g, jf4Var3.i);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void W() {
        e92 e92Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int incrementAndGet = this.f.incrementAndGet();
            int n = this.c.n();
            if (l) {
                Log.d("SwanAppBatchDownloadCallback", "batch download,total pkg num - " + n + ",success num - " + incrementAndGet);
            }
            if (incrementAndGet == n && !this.g && (e92Var = this.d) != null) {
                e92Var.a();
            }
        }
    }

    @Override // com.baidu.tieba.fe4, com.baidu.tieba.ce4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.b();
            k32.k("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            if (l) {
                Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            }
            if (!this.e.isEmpty()) {
                ej3.k(new a(this), "SwanAppBatchDownloadCallback");
            }
            e92 e92Var = this.d;
            if (e92Var != null) {
                e92Var.h();
            }
            if (!af2.a()) {
                k32.k("SwanAppBatchDownloadCallback", "#onTotalPkgDownloadFinish excludeIds=" + this.h);
                ue2 d2 = we2.c().d();
                CopyOnWriteArraySet<String> copyOnWriteArraySet = this.h;
                fg2 l2 = fg2.l();
                l2.i(7);
                d2.t(copyOnWriteArraySet, false, l2.k());
            }
        }
    }
}
