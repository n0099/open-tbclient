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
import com.baidu.tieba.bm4;
import com.baidu.tieba.du2;
import com.baidu.tieba.z92;
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
public class ee2 extends le2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public po4 c;
    public be2 d;
    public final List<hk4> e;
    public AtomicInteger f;
    public boolean g;
    public final CopyOnWriteArraySet<String> h;
    public ui4<bm4.a> i;
    public yi4<hk4> j;
    public final yi4<ik4> k;

    @Override // com.baidu.tieba.le2
    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 7;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class b extends ui4<bm4.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ee2 a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ bm4.a a;
            public final /* synthetic */ b b;

            public a(b bVar, bm4.a aVar) {
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
                        xe2.c(this.a.g.appId);
                    }
                    wj2.f(this.a.b);
                }
            }
        }

        public b(ee2 ee2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ee2Var;
        }

        @Override // com.baidu.tieba.ui4
        public void l(@NonNull PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, pMSAppInfo) == null) && pMSAppInfo.isForbiddenApp()) {
                rd3.L(pMSAppInfo.appId, pMSAppInfo.appStatus);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yi4
        /* renamed from: q */
        public String d(bm4.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, aVar)) == null) {
                if (aVar == null) {
                    return null;
                }
                int i = aVar.c;
                if (i == 0) {
                    return ze2.g();
                }
                if (i != 1) {
                    return null;
                }
                return ze2.i();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: u */
        public void c(bm4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
                super.c(aVar);
                h82.k("SwanAppBatchDownloadCallback", "onDownloadStart: " + aVar.b);
            }
        }

        @Override // com.baidu.tieba.aj4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.ui4
        public void p(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, pMSAppInfo, pMSAppInfo2) == null) {
                if (pMSAppInfo != null && pMSAppInfo.isForbiddenApp()) {
                    rd3.L(pMSAppInfo.appKey, pMSAppInfo.appStatus);
                }
                this.a.X(pMSAppInfo, pMSAppInfo2);
            }
        }

        @Override // com.baidu.tieba.ui4
        public void o(bm4.a aVar, PMSAppInfo pMSAppInfo, bk4 bk4Var) {
            PMSAppInfo pMSAppInfo2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar, pMSAppInfo, bk4Var) == null) {
                h82.k("SwanAppBatchDownloadCallback", "#onSingleFetchError errorNo=" + bk4Var.a + " errorMsg=" + bk4Var.b + " errorDetails=" + bk4Var.d);
                if (this.a.d != null) {
                    this.a.d.f(bk4Var);
                }
                if (bk4Var.a == 1010) {
                    if (aVar == null) {
                        pMSAppInfo2 = null;
                    } else {
                        pMSAppInfo2 = aVar.g;
                    }
                    if (pMSAppInfo2 == null) {
                        pMSAppInfo2 = pMSAppInfo;
                    }
                    this.a.X(pMSAppInfo2, pMSAppInfo);
                    if (xe2.m(bk4Var) && pMSAppInfo2 != null) {
                        xe2.c(pMSAppInfo2.appId);
                        return;
                    }
                    return;
                }
                this.a.g = true;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: r */
        public void e(bm4.a aVar, bk4 bk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, aVar, bk4Var) == null) {
                super.e(aVar, bk4Var);
                h82.k("SwanAppBatchDownloadCallback", "onDownloadError：" + bk4Var.toString());
                wj2.f(aVar.b);
                an3 an3Var = new an3();
                an3Var.k(11L);
                an3Var.i(bk4Var.a);
                an3Var.d("批量下载，主包下载失败：" + aVar.b);
                an3Var.f(bk4Var.toString());
                if (aVar.a != 0) {
                    if (ee2.l) {
                        Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + an3Var.toString());
                    }
                } else if (aVar.d == null) {
                } else {
                    this.a.c.l(aVar.d);
                    de2.c().a(aVar.d, PMSDownloadType.BATCH, an3Var);
                    h82.k("SwanAppBatchDownloadCallback", "#onDownloadError del: " + aVar.d.a);
                    lr4.k(aVar.d.a);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: s */
        public void i(bm4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
                super.i(aVar);
                h82.k("SwanAppBatchDownloadCallback", "onFileDownloaded: " + aVar.d.i);
                this.a.h.add(aVar.b);
                a aVar2 = new a(this, aVar);
                ExecutorUtilsExt.postOnSerial(aVar2, aVar.d.g + " 下载完成，执行签名校验-重命名-解压-DB");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: t */
        public void a(bm4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
                super.a(aVar);
                if (ee2.l) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + aVar.d.b + "/" + aVar.d.k);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: v */
        public void f(bm4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
                if (ee2.l) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + aVar.b);
                }
                wj2.f(aVar.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ee2 a;

        public a(ee2 ee2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ee2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean b = ej4.i().b(null, this.a.e, null, null, null);
                if (b) {
                    for (hk4 hk4Var : this.a.e) {
                        if (this.a.d != null) {
                            this.a.d.g(hk4Var);
                        }
                        this.a.W();
                    }
                }
                if (ee2.l) {
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
        public final /* synthetic */ ee2 c;

        public c(ee2 ee2Var, PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee2Var, pMSAppInfo, pMSAppInfo2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ee2Var;
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
                if (ej4.i().l(this.b)) {
                    ze2.o(this.b);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends oe2<ee2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ee2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ee2 ee2Var, ee2 ee2Var2) {
            super(ee2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee2Var, ee2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((le2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ee2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: q */
        public void e(hk4 hk4Var, bk4 bk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, hk4Var, bk4Var) == null) {
                super.q(hk4Var, bk4Var);
                wj2.f(hk4Var.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: u */
        public void f(hk4 hk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, hk4Var) == null) {
                super.f(hk4Var);
                wj2.f(hk4Var.o);
            }
        }

        @Override // com.baidu.tieba.oe2
        public void p(@NonNull hk4 hk4Var, @Nullable an3 an3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, hk4Var, an3Var) == null) {
                super.p(hk4Var, an3Var);
                if (an3Var == null) {
                    this.c.e.add(hk4Var);
                } else if (ee2.l) {
                    Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + hk4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + an3Var);
                }
                wj2.f(hk4Var.o);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends me2<ee2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ee2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ee2 ee2Var, ee2 ee2Var2) {
            super(ee2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee2Var, ee2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((le2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ee2Var;
        }

        @Override // com.baidu.tieba.me2
        public void r(@NonNull ik4 ik4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ik4Var) == null) {
                if (ee2.l) {
                    Log.v("SwanAppBatchDownloadCallback", "onDownloadAndUnzipSuccess:" + ik4Var);
                }
                if (this.b.d != null) {
                    this.b.d.e(ik4Var);
                }
                this.b.W();
            }
        }

        @Override // com.baidu.tieba.me2
        public void u(ik4 ik4Var, an3 an3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ik4Var, an3Var) == null) {
                h82.k("SwanAppBatchDownloadCallback", "onDownloadOrUnzipFail:" + ik4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + an3Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947731383, "Lcom/baidu/tieba/ee2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947731383, "Lcom/baidu/tieba/ee2;");
                return;
            }
        }
        l = rr1.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ee2() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((be2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.cj4
    public yi4<hk4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.j;
        }
        return (yi4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cj4
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.D();
            h82.k("SwanAppBatchDownloadCallback", "onFetchStart");
        }
    }

    @Override // com.baidu.tieba.cj4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.E();
            h82.k("SwanAppBatchDownloadCallback", "onFetchSuccess");
        }
    }

    @Override // com.baidu.tieba.cj4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.F();
            h82.k("SwanAppBatchDownloadCallback", "onNoPackage");
            be2 be2Var = this.d;
            if (be2Var != null) {
                be2Var.d();
            }
        }
    }

    @Override // com.baidu.tieba.cj4
    public yi4<ik4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.k;
        }
        return (yi4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cj4
    public ui4<bm4.a> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.i;
        }
        return (ui4) invokeV.objValue;
    }

    public ee2(be2 be2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {be2Var};
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
        this.d = be2Var;
        this.e = new Vector();
        this.f = new AtomicInteger(0);
        this.h = new CopyOnWriteArraySet<>();
    }

    @Override // com.baidu.tieba.cj4
    public void G(po4 po4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, po4Var) == null) {
            super.G(po4Var);
            this.c = po4Var;
            wj2.e(po4Var);
            h82.k("SwanAppBatchDownloadCallback", "onPrepareDownload: " + po4Var.n());
        }
    }

    public final void X(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, pMSAppInfo, pMSAppInfo2) != null) || pMSAppInfo == null) {
            return;
        }
        bo3.k(new c(this, pMSAppInfo2, pMSAppInfo), "批量下载-只更新AppInfo-存储DB");
    }

    @Override // com.baidu.tieba.cj4
    public void C(bk4 bk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bk4Var) == null) {
            super.C(bk4Var);
            h82.k("SwanAppBatchDownloadCallback", "onFetchError: " + bk4Var.toString());
            be2 be2Var = this.d;
            if (be2Var != null) {
                be2Var.b(bk4Var.a);
            }
        }
    }

    public final boolean V(bm4.a aVar) {
        InterceptResult invokeL;
        int c2;
        PMSAppInfo pMSAppInfo;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
            if (aVar == null || aVar.d == null || aVar.g == null) {
                return false;
            }
            if (!uo3.a(new File(aVar.d.a), aVar.d.m)) {
                h82.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
                return false;
            }
            an3 m = ze2.m(aVar.d, this);
            if (m != null) {
                h82.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + m);
                return false;
            }
            aVar.g.initMaxAgeInfo();
            ze2.k(aVar.g, aVar.d);
            aVar.g.updateInstallSrc(J());
            if (!ej4.i().a(aVar.d, aVar.g)) {
                h82.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
                return false;
            }
            this.c.m(aVar.d);
            if (!aVar.h) {
                ze2.o(aVar.g);
            }
            ze2.b(aVar.d);
            gk4 gk4Var = aVar.d;
            if (gk4Var != null) {
                tb3.c(du2.e.i(gk4Var.g, String.valueOf(gk4Var.i)).getAbsolutePath(), true);
            }
            gk4 gk4Var2 = aVar.d;
            if (gk4Var2 == null || gk4Var2.h != 0 || ((c2 = z92.b.c()) > 0 && (pMSAppInfo = aVar.g) != null && ((i = pMSAppInfo.rank) == 0 || i > c2))) {
                return true;
            }
            wd2 i2 = wd2.i();
            gk4 gk4Var3 = aVar.d;
            i2.f(gk4Var3.g, gk4Var3.i);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void W() {
        be2 be2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int incrementAndGet = this.f.incrementAndGet();
            int n = this.c.n();
            if (l) {
                Log.d("SwanAppBatchDownloadCallback", "batch download,total pkg num - " + n + ",success num - " + incrementAndGet);
            }
            if (incrementAndGet == n && !this.g && (be2Var = this.d) != null) {
                be2Var.a();
            }
        }
    }

    @Override // com.baidu.tieba.cj4, com.baidu.tieba.zi4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.b();
            h82.k("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            if (l) {
                Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            }
            if (!this.e.isEmpty()) {
                bo3.k(new a(this), "SwanAppBatchDownloadCallback");
            }
            be2 be2Var = this.d;
            if (be2Var != null) {
                be2Var.h();
            }
            if (!xj2.a()) {
                h82.k("SwanAppBatchDownloadCallback", "#onTotalPkgDownloadFinish excludeIds=" + this.h);
                rj2 d2 = tj2.c().d();
                CopyOnWriteArraySet<String> copyOnWriteArraySet = this.h;
                cl2 l2 = cl2.l();
                l2.i(7);
                d2.t(copyOnWriteArraySet, false, l2.k());
            }
        }
    }
}
