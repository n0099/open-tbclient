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
import com.baidu.tieba.bd2;
import com.baidu.tieba.fx9;
import com.baidu.tieba.h62;
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
/* loaded from: classes3.dex */
public final class dd2 extends p62 implements ig4, fg4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static int n;
    public static final PMSDownloadType o;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public lx9<? super nc4> d;
    public lx9<nc4> e;
    public tg4 f;
    public final re4 g;
    public cb4<nc4> h;
    public final Map<String, cd2> i;
    public final Map<String, jg4> j;
    public final bd2 k;
    public final ve4<JSONArray> l;

    /* loaded from: classes3.dex */
    public class a implements ve4<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dd2 a;

        public a(dd2 dd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ve4
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray == null || this.a.i.isEmpty()) {
                return;
            }
            for (cd2 cd2Var : this.a.i.values()) {
                if (cd2Var != null && cd2Var.r(this.a)) {
                    cd2Var.a(jSONArray);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ei3<cd2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dd2 a;

        public b(dd2 dd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(cd2 cd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cd2Var) == null) {
                if (dd2.m) {
                    String str = this.a.c;
                    Log.i(str, "onCallback: SoUpdating=" + cd2Var);
                }
                if (cd2Var != null) {
                    this.a.k.c(cd2Var.k(), cd2Var.o());
                }
                this.a.Z(null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ei3<cd2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dd2 a;

        public c(dd2 dd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(cd2 cd2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cd2Var) == null) || cd2Var == null) {
                return;
            }
            this.a.k.d(cd2Var.k(), cd2Var.m());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements h62.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nc4 a;
        public final /* synthetic */ dd2 b;

        public d(dd2 dd2Var, nc4 nc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dd2Var, nc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dd2Var;
            this.a = nc4Var;
        }

        @Override // com.baidu.tieba.h62.c
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

        @Override // com.baidu.tieba.h62.c
        public void b(PMSDownloadType pMSDownloadType, ef3 ef3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ef3Var) == null) {
                this.b.f.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, ef3Var));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements fx9.a<nc4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dd2 a;

        public e(dd2 dd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fx9.a, com.baidu.tieba.tx9
        public void call(lx9<? super nc4> lx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lx9Var) == null) {
                this.a.d = lx9Var;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends lx9<nc4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dd2 e;

        public f(dd2 dd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = dd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gx9
        /* renamed from: g */
        public void onNext(nc4 nc4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, nc4Var) == null) && dd2.m) {
                String str = this.e.c;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + nc4Var.toString());
            }
        }

        @Override // com.baidu.tieba.gx9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (dd2.m) {
                    Log.e(this.e.c, "PkgDlSubscriber 包下载完成");
                }
                this.e.e0(null);
            }
        }

        @Override // com.baidu.tieba.gx9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (dd2.m) {
                    String str = this.e.c;
                    Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
                }
                this.e.e0(new Exception("failed by Download error = ", th));
            }
        }

        public /* synthetic */ f(dd2 dd2Var, a aVar) {
            this(dd2Var);
        }
    }

    /* loaded from: classes3.dex */
    public class g extends za4<nc4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dd2 a;

        public g(dd2 dd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cb4
        /* renamed from: l */
        public String d(nc4 nc4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, nc4Var)) == null) {
                String g = ad2.d.g(nc4Var);
                if (dd2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback getDownloadPath: so=" + nc4Var.g + " path=" + g);
                }
                return g;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.eb4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: o */
        public void e(nc4 nc4Var, fc4 fc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nc4Var, fc4Var) == null) {
                super.e(nc4Var, fc4Var);
                if (dd2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadError: so=" + nc4Var.g + " err=" + fc4Var);
                }
                this.a.f.l(nc4Var);
                ef3 ef3Var = new ef3();
                ef3Var.k(13L);
                ef3Var.i(fc4Var.a);
                ef3Var.d("so包下载失败");
                ef3Var.f(fc4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(nc4Var, ef3Var));
                }
                h62.c().a(nc4Var, dd2.o, ef3Var);
                pj4.k(nc4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: p */
        public void i(nc4 nc4Var) {
            jg4 jg4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, nc4Var) == null) {
                super.i(nc4Var);
                if (dd2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadFinish: so=" + nc4Var);
                }
                String str2 = nc4Var.p;
                if (TextUtils.isEmpty(str2) && (jg4Var = (jg4) this.a.j.get(nc4Var.g)) != null) {
                    str2 = jg4Var.a;
                }
                cd2 a0 = this.a.a0(str2);
                if (a0 != null) {
                    boolean a = yg3.a(new File(nc4Var.a), nc4Var.m);
                    if (dd2.m) {
                        String str3 = this.a.c;
                        Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + nc4Var.g + " checkSign=" + a);
                    }
                    boolean z = true;
                    z = (dd2.m && !fh3.G() && kz2.j() == 1) ? false : false;
                    if (a || z) {
                        ib4.i().m(nc4Var);
                        if (dd2.m) {
                            String str4 = this.a.c;
                            Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + a0 + " libName=" + str2);
                        }
                    }
                    a0.q();
                }
                this.a.f.m(nc4Var);
                if (this.a.d != null) {
                    this.a.d.onNext(nc4Var);
                    this.a.d.onCompleted();
                }
                h62.c().b(nc4Var, dd2.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: q */
        public void a(nc4 nc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, nc4Var) == null) {
                super.a(nc4Var);
                jg4 jg4Var = (jg4) this.a.j.get(nc4Var.g);
                cd2 a0 = this.a.a0(jg4Var == null ? null : jg4Var.a);
                if (a0 != null) {
                    a0.x(new bd2.b(nc4Var.b, nc4Var.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: r */
        public void c(nc4 nc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, nc4Var) == null) {
                super.c(nc4Var);
                if (dd2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadStart: so=" + nc4Var.g);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: s */
        public void f(nc4 nc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, nc4Var) == null) {
                super.f(nc4Var);
                if (dd2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloading: so=" + nc4Var.g);
                }
                this.a.f0(nc4Var);
            }
        }

        public /* synthetic */ g(dd2 dd2Var, a aVar) {
            this(dd2Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947700631, "Lcom/baidu/tieba/dd2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947700631, "Lcom/baidu/tieba/dd2;");
                return;
            }
        }
        m = vj1.a;
        n = 0;
        o = PMSDownloadType.SO_LIB;
    }

    public dd2(re4 re4Var, bd2 bd2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {re4Var, bd2Var};
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
            Log.i(sb2, "SwanSoUpdater: config=" + bd2Var + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.g = re4Var;
        this.k = bd2Var;
        if (bd2Var != null) {
            Iterator<String> it = bd2Var.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                yc2 a2 = zc2.a(next);
                if (a2 == null) {
                    bd2Var.c(next, false);
                } else if (a2.f()) {
                    bd2Var.c(next, true);
                } else {
                    String e2 = a2.e();
                    cd2 t = ad2.d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.i.put(e2, t);
                    this.j.putAll(jg4.b(e2));
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

    @Override // com.baidu.tieba.gb4
    public void C(fc4 fc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fc4Var) == null) {
            super.C(fc4Var);
            if (m) {
                String str = this.c;
                Log.e(str, "onFetchError: " + fc4Var.toString());
            }
            e0(new Exception("failed by fetch error = " + fc4Var));
        }
    }

    @Override // com.baidu.tieba.gb4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (m) {
                Log.e(this.c, "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.gb4
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

    @Override // com.baidu.tieba.gb4
    public void G(tg4 tg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tg4Var) == null) {
            if (m) {
                String str = this.c;
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                sb.append(tg4Var == null ? 0 : tg4Var.n());
                Log.i(str, sb.toString());
            }
            super.G(tg4Var);
            if (tg4Var == null) {
                return;
            }
            this.f = tg4Var;
            if (tg4Var.k()) {
                return;
            }
            c0();
        }
    }

    public final void Z(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, exc) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "finishWithUpdatingCheck: updatings=" + this.i.size() + " e=" + exc);
            }
            for (cd2 cd2Var : this.i.values()) {
                if (!cd2Var.n()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + cd2Var);
                        return;
                    }
                    return;
                }
            }
            d0(exc);
        }
    }

    public final cd2 a0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            cd2 cd2Var = this.i.get(str);
            if (cd2Var == null || !cd2Var.r(this)) {
                return null;
            }
            return cd2Var;
        }
        return (cd2) invokeL.objValue;
    }

    public final lx9<nc4> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
            }
            return this.e;
        }
        return (lx9) invokeV.objValue;
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.f.g()) {
                arrayList.add(fx9.a(new e(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            fx9.i(arrayList).u(b0());
        }
    }

    public final void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, exc) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "notifyFinalCallback: e=" + Log.getStackTraceString(exc));
            }
            bd2 bd2Var = this.k;
            if (bd2Var != null) {
                bd2Var.b(exc);
            }
        }
    }

    public final void e0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, exc) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "notifyPmsFinish: updatings=" + this.i.size() + " e=" + exc);
            }
            for (cd2 cd2Var : this.i.values()) {
                if (cd2Var != null && cd2Var.r(this) && !cd2Var.n() && !cd2Var.s()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "notifyPmsFinish: try install updating=" + cd2Var);
                    }
                    cd2Var.q();
                }
            }
            Z(exc);
        }
    }

    public final void f0(nc4 nc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, nc4Var) == null) {
            h62.c().d(nc4Var, new d(this, nc4Var));
        }
    }

    @Override // com.baidu.tieba.ig4
    public ve4<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : (ve4) invokeV.objValue;
    }

    public final void g0(nc4 nc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, nc4Var) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler updateBestSo start so=" + nc4Var);
            }
            if (nc4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by null so");
                    return;
                }
                return;
            }
            jg4 jg4Var = this.j.get(nc4Var.g);
            if (jg4Var == null) {
                if (m) {
                    String str2 = this.c;
                    Log.i(str2, "SoNodeHandler updateBestSo end by illegal bundleId=" + nc4Var.g);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(nc4Var.p)) {
                nc4Var.p = jg4Var.a;
            }
            cd2 a0 = a0(nc4Var.p);
            if (a0 == null) {
                if (m) {
                    String str3 = this.c;
                    Log.i(str3, "SoNodeHandler updateBestSo end by no updating lib=" + nc4Var.p);
                    return;
                }
                return;
            }
            if (nc4Var.q == null) {
                nc4Var.q = jg4Var.c;
            }
            if (!AbiType.currentAbi().compat(nc4Var.q)) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by currentAbi");
                    return;
                }
                return;
            }
            nc4 l = a0.l();
            nc4 j = a0.j();
            long max = Math.max(j != null ? j.i : 0L, l == null ? 0L : l.i);
            long j2 = nc4Var.i;
            if (j2 < max) {
                if (m) {
                    Log.i(this.c, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(nc4Var.i)));
                }
            } else if (j2 > max) {
                if (m) {
                    String str4 = this.c;
                    Log.i(str4, "SoNodeHandler updateBestSo end by update bestVer=" + nc4Var.i);
                }
                a0.w(this, nc4Var);
            } else {
                if (j == null || !j.q.compat(nc4Var.q)) {
                    if (m) {
                        String str5 = this.c;
                        Log.i(str5, "SoNodeHandler updateBestSo end by update abi update=" + nc4Var.q);
                    }
                    a0.w(this, nc4Var);
                }
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by should not exec here");
                }
            }
        }
    }

    @Override // com.baidu.tieba.ig4
    public gb4 getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this : (gb4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ig4
    @Nullable
    public re4 getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.g : (re4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fg4
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
            }
            if (jSONObject != null) {
                g0((nc4) sg4.j(jSONObject, new nc4()));
            }
        }
    }

    @Override // com.baidu.tieba.fg4
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            dg4 dg4Var = new dg4();
            tg4 tg4Var = new tg4();
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop start");
            }
            boolean z = true;
            if ((m && !fh3.G() && kz2.j() == 1) ? false : false) {
                String i = kz2.i();
                if (!TextUtils.isEmpty(i)) {
                    try {
                        nc4 nc4Var = (nc4) sg4.j(new JSONObject(i), new nc4());
                        nc4Var.g = "so_zeus_armeabi";
                        g0(nc4Var);
                        d33.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1254)).G();
                    } catch (JSONException e2) {
                        d33.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1253)).G();
                        e2.printStackTrace();
                    }
                }
            }
            for (cd2 cd2Var : this.i.values()) {
                if (cd2Var.r(this)) {
                    g0(cd2Var.l());
                    nc4 j = cd2Var.j();
                    if (cd2Var.p() && j != null) {
                        if (m) {
                            String str = this.c;
                            Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                        }
                        eg4.b(j, tg4Var);
                        if (dg4Var.d == null) {
                            dg4Var.d = new ArrayList();
                        }
                        dg4Var.d.add(j);
                    } else {
                        if (m) {
                            Log.i(this.c, "SoNodeHandler localSo not update, just check for install");
                        }
                        cd2Var.q();
                    }
                }
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop end");
                String str2 = this.c;
                Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + tg4Var.n());
            }
            if (tg4Var.n() == 0) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler handle end by no pkg");
                }
                F();
                return;
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle end by start dl");
            }
            G(tg4Var);
            wc4.e(dg4Var, this);
        }
    }

    @Override // com.baidu.tieba.gb4
    public fg4 w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? TextUtils.equals("so", str) ? this : super.w(str) : (fg4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.gb4
    public cb4<nc4> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.h == null) {
                this.h = new g(this, null);
            }
            return this.h;
        }
        return (cb4) invokeV.objValue;
    }
}
