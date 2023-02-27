package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.utils.AbiType;
import com.baidu.tieba.cj2;
import com.baidu.tieba.ic2;
import com.baidu.tieba.sma;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class ej2 extends qc2 implements jm4, gm4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static int n;
    public static final PMSDownloadType o;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public yma<? super oi4> d;
    public yma<oi4> e;
    public um4 f;
    public final sk4 g;
    public dh4<oi4> h;
    public final Map<String, dj2> i;
    public final Map<String, km4> j;
    public final cj2 k;
    public final wk4<JSONArray> l;

    @Override // com.baidu.tieba.jm4
    public hh4 getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this : (hh4) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class a implements wk4<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ej2 a;

        public a(ej2 ej2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ej2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ej2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wk4
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) && jSONArray != null && !this.a.i.isEmpty()) {
                for (dj2 dj2Var : this.a.i.values()) {
                    if (dj2Var != null && dj2Var.r(this.a)) {
                        dj2Var.a(jSONArray);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements fo3<dj2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ej2 a;

        public b(ej2 ej2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ej2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ej2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fo3
        /* renamed from: b */
        public void a(dj2 dj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dj2Var) == null) {
                if (ej2.m) {
                    String str = this.a.c;
                    Log.i(str, "onCallback: SoUpdating=" + dj2Var);
                }
                if (dj2Var != null) {
                    this.a.k.c(dj2Var.k(), dj2Var.o());
                }
                this.a.Z(null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements fo3<dj2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ej2 a;

        public c(ej2 ej2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ej2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ej2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fo3
        /* renamed from: b */
        public void a(dj2 dj2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dj2Var) == null) && dj2Var != null) {
                this.a.k.d(dj2Var.k(), dj2Var.m());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ic2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oi4 a;
        public final /* synthetic */ ej2 b;

        public d(ej2 ej2Var, oi4 oi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ej2Var, oi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ej2Var;
            this.a = oi4Var;
        }

        @Override // com.baidu.tieba.ic2.c
        public void b(PMSDownloadType pMSDownloadType, fl3 fl3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, fl3Var) == null) {
                this.b.f.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, fl3Var));
                }
            }
        }

        @Override // com.baidu.tieba.ic2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.f.m(this.a);
                if (this.b.d != null) {
                    this.b.d.onNext(this.a);
                    this.b.d.onCompleted();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements sma.a<oi4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ej2 a;

        public e(ej2 ej2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ej2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ej2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sma.a, com.baidu.tieba.gna
        public void call(yma<? super oi4> ymaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, ymaVar) != null) {
                return;
            }
            this.a.d = ymaVar;
        }
    }

    /* loaded from: classes4.dex */
    public class f extends yma<oi4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ej2 e;

        public f(ej2 ej2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ej2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ej2Var;
        }

        public /* synthetic */ f(ej2 ej2Var, a aVar) {
            this(ej2Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tma
        /* renamed from: g */
        public void onNext(oi4 oi4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, oi4Var) == null) && ej2.m) {
                String str = this.e.c;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + oi4Var.toString());
            }
        }

        @Override // com.baidu.tieba.tma
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (ej2.m) {
                    String str = this.e.c;
                    Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
                }
                this.e.e0(new Exception("failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.tma
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (ej2.m) {
                    Log.e(this.e.c, "PkgDlSubscriber 包下载完成");
                }
                this.e.e0(null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends ah4<oi4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ej2 a;

        public g(ej2 ej2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ej2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ej2Var;
        }

        public /* synthetic */ g(ej2 ej2Var, a aVar) {
            this(ej2Var);
        }

        @Override // com.baidu.tieba.fh4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dh4
        /* renamed from: l */
        public String d(oi4 oi4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, oi4Var)) == null) {
                String g = bj2.d.g(oi4Var);
                if (ej2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback getDownloadPath: so=" + oi4Var.g + " path=" + g);
                }
                return g;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ah4, com.baidu.tieba.dh4
        /* renamed from: q */
        public void a(oi4 oi4Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, oi4Var) == null) {
                super.a(oi4Var);
                km4 km4Var = (km4) this.a.j.get(oi4Var.g);
                ej2 ej2Var = this.a;
                if (km4Var == null) {
                    str = null;
                } else {
                    str = km4Var.a;
                }
                dj2 a0 = ej2Var.a0(str);
                if (a0 != null) {
                    a0.x(new cj2.b(oi4Var.b, oi4Var.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ah4, com.baidu.tieba.dh4
        /* renamed from: r */
        public void c(oi4 oi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, oi4Var) == null) {
                super.c(oi4Var);
                if (ej2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadStart: so=" + oi4Var.g);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ah4, com.baidu.tieba.dh4
        /* renamed from: s */
        public void f(oi4 oi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, oi4Var) == null) {
                super.f(oi4Var);
                if (ej2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloading: so=" + oi4Var.g);
                }
                this.a.f0(oi4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ah4, com.baidu.tieba.dh4
        /* renamed from: o */
        public void e(oi4 oi4Var, gi4 gi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, oi4Var, gi4Var) == null) {
                super.e(oi4Var, gi4Var);
                if (ej2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadError: so=" + oi4Var.g + " err=" + gi4Var);
                }
                this.a.f.l(oi4Var);
                fl3 fl3Var = new fl3();
                fl3Var.k(13L);
                fl3Var.i(gi4Var.a);
                fl3Var.d("so包下载失败");
                fl3Var.f(gi4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(oi4Var, fl3Var));
                }
                ic2.c().a(oi4Var, ej2.o, fl3Var);
                qp4.k(oi4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ah4, com.baidu.tieba.dh4
        /* renamed from: p */
        public void i(oi4 oi4Var) {
            km4 km4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, oi4Var) == null) {
                super.i(oi4Var);
                if (ej2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadFinish: so=" + oi4Var);
                }
                String str2 = oi4Var.p;
                if (TextUtils.isEmpty(str2) && (km4Var = (km4) this.a.j.get(oi4Var.g)) != null) {
                    str2 = km4Var.a;
                }
                dj2 a0 = this.a.a0(str2);
                if (a0 != null) {
                    boolean a = zm3.a(new File(oi4Var.a), oi4Var.m);
                    if (ej2.m) {
                        String str3 = this.a.c;
                        Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + oi4Var.g + " checkSign=" + a);
                    }
                    boolean z = true;
                    z = (ej2.m && !gn3.G() && l53.j() == 1) ? false : false;
                    if (a || z) {
                        jh4.i().m(oi4Var);
                        if (ej2.m) {
                            String str4 = this.a.c;
                            Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + a0 + " libName=" + str2);
                        }
                    }
                    a0.q();
                }
                this.a.f.m(oi4Var);
                if (this.a.d != null) {
                    this.a.d.onNext(oi4Var);
                    this.a.d.onCompleted();
                }
                ic2.c().b(oi4Var, ej2.o);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947736188, "Lcom/baidu/tieba/ej2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947736188, "Lcom/baidu/tieba/ej2;");
                return;
            }
        }
        m = wp1.a;
        n = 0;
        o = PMSDownloadType.SO_LIB;
    }

    @Override // com.baidu.tieba.hh4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (m) {
                Log.e(this.c, "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.hh4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            if (m) {
                Log.e(this.c, "onNoPackage:");
            }
            e0(null);
        }
    }

    public final yma<oi4> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
            }
            return this.e;
        }
        return (yma) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jm4
    public wk4<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.l;
        }
        return (wk4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jm4
    @Nullable
    public sk4 getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.g;
        }
        return (sk4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hh4
    public dh4<oi4> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.h == null) {
                this.h = new g(this, null);
            }
            return this.h;
        }
        return (dh4) invokeV.objValue;
    }

    public ej2(sk4 sk4Var, cj2 cj2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sk4Var, cj2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = "SwanSoUpdater";
        this.i = new HashMap();
        this.j = new HashMap();
        this.l = new a(this);
        StringBuilder sb = new StringBuilder();
        sb.append(this.c);
        int i3 = n;
        n = i3 + 1;
        sb.append(i3);
        String sb2 = sb.toString();
        this.c = sb2;
        if (m) {
            Log.i(sb2, "SwanSoUpdater: config=" + cj2Var + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.g = sk4Var;
        this.k = cj2Var;
        if (cj2Var != null) {
            Iterator<String> it = cj2Var.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                zi2 a2 = aj2.a(next);
                if (a2 == null) {
                    cj2Var.c(next, false);
                } else if (a2.f()) {
                    cj2Var.c(next, true);
                } else {
                    String e2 = a2.e();
                    dj2 t = bj2.d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.i.put(e2, t);
                    this.j.putAll(km4.b(e2));
                }
            }
        }
        if (m) {
            String str = this.c;
            Log.i(str, "SoNodeHandler() start mUpdatings=" + this.i.size());
        }
        if (this.i.isEmpty()) {
            e0(null);
        }
    }

    public final dj2 a0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            dj2 dj2Var = this.i.get(str);
            if (dj2Var == null || !dj2Var.r(this)) {
                return null;
            }
            return dj2Var;
        }
        return (dj2) invokeL.objValue;
    }

    public final void f0(oi4 oi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, oi4Var) == null) {
            ic2.c().d(oi4Var, new d(this, oi4Var));
        }
    }

    @Override // com.baidu.tieba.hh4
    public gm4 w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            if (TextUtils.equals("so", str)) {
                return this;
            }
            return super.w(str);
        }
        return (gm4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.hh4
    public void C(gi4 gi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gi4Var) == null) {
            super.C(gi4Var);
            if (m) {
                String str = this.c;
                Log.e(str, "onFetchError: " + gi4Var.toString());
            }
            e0(new Exception("failed by fetch error = " + gi4Var));
        }
    }

    @Override // com.baidu.tieba.hh4
    public void G(um4 um4Var) {
        int n2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, um4Var) == null) {
            if (m) {
                String str = this.c;
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                if (um4Var == null) {
                    n2 = 0;
                } else {
                    n2 = um4Var.n();
                }
                sb.append(n2);
                Log.i(str, sb.toString());
            }
            super.G(um4Var);
            if (um4Var == null) {
                return;
            }
            this.f = um4Var;
            if (!um4Var.k()) {
                c0();
            }
        }
    }

    public final void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, exc) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "notifyFinalCallback: e=" + Log.getStackTraceString(exc));
            }
            cj2 cj2Var = this.k;
            if (cj2Var != null) {
                cj2Var.b(exc);
            }
        }
    }

    @Override // com.baidu.tieba.gm4
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
            }
            if (jSONObject != null) {
                g0((oi4) tm4.j(jSONObject, new oi4()));
            }
        }
    }

    public final void Z(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, exc) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "finishWithUpdatingCheck: updatings=" + this.i.size() + " e=" + exc);
            }
            for (dj2 dj2Var : this.i.values()) {
                if (!dj2Var.n()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + dj2Var);
                        return;
                    }
                    return;
                }
            }
            d0(exc);
        }
    }

    public final void e0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, exc) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "notifyPmsFinish: updatings=" + this.i.size() + " e=" + exc);
            }
            for (dj2 dj2Var : this.i.values()) {
                if (dj2Var != null && dj2Var.r(this) && !dj2Var.n() && !dj2Var.s()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "notifyPmsFinish: try install updating=" + dj2Var);
                    }
                    dj2Var.q();
                }
            }
            Z(exc);
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.f.g()) {
                arrayList.add(sma.a(new e(this)));
            }
            if (!arrayList.isEmpty()) {
                sma.i(arrayList).u(b0());
            }
        }
    }

    public final void g0(oi4 oi4Var) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, oi4Var) == null) {
            if (m) {
                Log.i(this.c, "SoNodeHandler updateBestSo start so=" + oi4Var);
            }
            if (oi4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by null so");
                    return;
                }
                return;
            }
            km4 km4Var = this.j.get(oi4Var.g);
            if (km4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by illegal bundleId=" + oi4Var.g);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(oi4Var.p)) {
                oi4Var.p = km4Var.a;
            }
            dj2 a0 = a0(oi4Var.p);
            if (a0 == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by no updating lib=" + oi4Var.p);
                    return;
                }
                return;
            }
            if (oi4Var.q == null) {
                oi4Var.q = km4Var.c;
            }
            if (!AbiType.currentAbi().compat(oi4Var.q)) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by currentAbi");
                    return;
                }
                return;
            }
            oi4 l = a0.l();
            oi4 j2 = a0.j();
            long j3 = 0;
            if (l == null) {
                j = 0;
            } else {
                j = l.i;
            }
            if (j2 != null) {
                j3 = j2.i;
            }
            long max = Math.max(j3, j);
            long j4 = oi4Var.i;
            if (j4 < max) {
                if (m) {
                    Log.i(this.c, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(oi4Var.i)));
                }
            } else if (j4 > max) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by update bestVer=" + oi4Var.i);
                }
                a0.w(this, oi4Var);
            } else {
                if (j2 == null || !j2.q.compat(oi4Var.q)) {
                    if (m) {
                        Log.i(this.c, "SoNodeHandler updateBestSo end by update abi update=" + oi4Var.q);
                    }
                    a0.w(this, oi4Var);
                }
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by should not exec here");
                }
            }
        }
    }

    @Override // com.baidu.tieba.gm4
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            em4 em4Var = new em4();
            um4 um4Var = new um4();
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop start");
            }
            boolean z = true;
            if ((m && !gn3.G() && l53.j() == 1) ? false : false) {
                String i = l53.i();
                if (!TextUtils.isEmpty(i)) {
                    try {
                        oi4 oi4Var = (oi4) tm4.j(new JSONObject(i), new oi4());
                        oi4Var.g = "so_zeus_armeabi";
                        g0(oi4Var);
                        e93.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1317)).G();
                    } catch (JSONException e2) {
                        e93.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1316)).G();
                        e2.printStackTrace();
                    }
                }
            }
            for (dj2 dj2Var : this.i.values()) {
                if (dj2Var.r(this)) {
                    g0(dj2Var.l());
                    oi4 j = dj2Var.j();
                    if (dj2Var.p() && j != null) {
                        if (m) {
                            String str = this.c;
                            Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                        }
                        fm4.b(j, um4Var);
                        if (em4Var.d == null) {
                            em4Var.d = new ArrayList();
                        }
                        em4Var.d.add(j);
                    } else {
                        if (m) {
                            Log.i(this.c, "SoNodeHandler localSo not update, just check for install");
                        }
                        dj2Var.q();
                    }
                }
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop end");
                String str2 = this.c;
                Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + um4Var.n());
            }
            if (um4Var.n() == 0) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler handle end by no pkg");
                }
                F();
                return;
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle end by start dl");
            }
            G(um4Var);
            xi4.e(em4Var, this);
        }
    }
}
