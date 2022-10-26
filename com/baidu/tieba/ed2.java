package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.utils.AbiType;
import com.baidu.tieba.cd2;
import com.baidu.tieba.i62;
import com.baidu.tieba.xx9;
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
public final class ed2 extends q62 implements jg4, gg4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static int n;
    public static final PMSDownloadType o;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public dy9 d;
    public dy9 e;
    public ug4 f;
    public final se4 g;
    public db4 h;
    public final Map i;
    public final Map j;
    public final cd2 k;
    public final we4 l;

    @Override // com.baidu.tieba.jg4
    public hb4 getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this : (hb4) invokeV.objValue;
    }

    /* loaded from: classes3.dex */
    public class a implements we4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ed2 a;

        public a(ed2 ed2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ed2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ed2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.we4
        /* renamed from: b */
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) && jSONArray != null && !this.a.i.isEmpty()) {
                for (dd2 dd2Var : this.a.i.values()) {
                    if (dd2Var != null && dd2Var.r(this.a)) {
                        dd2Var.a(jSONArray);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ed2 a;

        public b(ed2 ed2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ed2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ed2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(dd2 dd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dd2Var) == null) {
                if (ed2.m) {
                    String str = this.a.c;
                    Log.i(str, "onCallback: SoUpdating=" + dd2Var);
                }
                if (dd2Var != null) {
                    this.a.k.c(dd2Var.k(), dd2Var.o());
                }
                this.a.Z(null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ed2 a;

        public c(ed2 ed2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ed2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ed2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(dd2 dd2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dd2Var) == null) && dd2Var != null) {
                this.a.k.d(dd2Var.k(), dd2Var.m());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements i62.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oc4 a;
        public final /* synthetic */ ed2 b;

        public d(ed2 ed2Var, oc4 oc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ed2Var, oc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ed2Var;
            this.a = oc4Var;
        }

        @Override // com.baidu.tieba.i62.c
        public void b(PMSDownloadType pMSDownloadType, ff3 ff3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ff3Var) == null) {
                this.b.f.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, ff3Var));
                }
            }
        }

        @Override // com.baidu.tieba.i62.c
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

    /* loaded from: classes3.dex */
    public class e implements xx9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ed2 a;

        public e(ed2 ed2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ed2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ed2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xx9.a, com.baidu.tieba.ly9
        public void call(dy9 dy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dy9Var) != null) {
                return;
            }
            this.a.d = dy9Var;
        }
    }

    /* loaded from: classes3.dex */
    public class f extends dy9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ed2 e;

        public f(ed2 ed2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ed2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ed2Var;
        }

        public /* synthetic */ f(ed2 ed2Var, a aVar) {
            this(ed2Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yx9
        /* renamed from: g */
        public void onNext(oc4 oc4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, oc4Var) == null) && ed2.m) {
                String str = this.e.c;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + oc4Var.toString());
            }
        }

        @Override // com.baidu.tieba.yx9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (ed2.m) {
                    String str = this.e.c;
                    Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
                }
                this.e.e0(new Exception("failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.yx9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (ed2.m) {
                    Log.e(this.e.c, "PkgDlSubscriber 包下载完成");
                }
                this.e.e0(null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends ab4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ed2 a;

        public g(ed2 ed2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ed2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ed2Var;
        }

        public /* synthetic */ g(ed2 ed2Var, a aVar) {
            this(ed2Var);
        }

        @Override // com.baidu.tieba.fb4
        public Bundle m(Bundle bundle, Set set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.db4
        /* renamed from: l */
        public String d(oc4 oc4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, oc4Var)) == null) {
                String g = bd2.d.g(oc4Var);
                if (ed2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback getDownloadPath: so=" + oc4Var.g + " path=" + g);
                }
                return g;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: q */
        public void a(oc4 oc4Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, oc4Var) == null) {
                super.a(oc4Var);
                kg4 kg4Var = (kg4) this.a.j.get(oc4Var.g);
                ed2 ed2Var = this.a;
                if (kg4Var == null) {
                    str = null;
                } else {
                    str = kg4Var.a;
                }
                dd2 a0 = ed2Var.a0(str);
                if (a0 != null) {
                    a0.x(new cd2.b(oc4Var.b, oc4Var.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: r */
        public void c(oc4 oc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, oc4Var) == null) {
                super.c(oc4Var);
                if (ed2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadStart: so=" + oc4Var.g);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: s */
        public void f(oc4 oc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, oc4Var) == null) {
                super.f(oc4Var);
                if (ed2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloading: so=" + oc4Var.g);
                }
                this.a.f0(oc4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: o */
        public void e(oc4 oc4Var, gc4 gc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, oc4Var, gc4Var) == null) {
                super.e(oc4Var, gc4Var);
                if (ed2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadError: so=" + oc4Var.g + " err=" + gc4Var);
                }
                this.a.f.l(oc4Var);
                ff3 ff3Var = new ff3();
                ff3Var.k(13L);
                ff3Var.i(gc4Var.a);
                ff3Var.d("so包下载失败");
                ff3Var.f(gc4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(oc4Var, ff3Var));
                }
                i62.c().a(oc4Var, ed2.o, ff3Var);
                qj4.k(oc4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: p */
        public void i(oc4 oc4Var) {
            kg4 kg4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, oc4Var) == null) {
                super.i(oc4Var);
                if (ed2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadFinish: so=" + oc4Var);
                }
                String str2 = oc4Var.p;
                if (TextUtils.isEmpty(str2) && (kg4Var = (kg4) this.a.j.get(oc4Var.g)) != null) {
                    str2 = kg4Var.a;
                }
                dd2 a0 = this.a.a0(str2);
                if (a0 != null) {
                    boolean a = zg3.a(new File(oc4Var.a), oc4Var.m);
                    if (ed2.m) {
                        String str3 = this.a.c;
                        Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + oc4Var.g + " checkSign=" + a);
                    }
                    boolean z = true;
                    z = (ed2.m && !gh3.G() && lz2.j() == 1) ? false : false;
                    if (a || z) {
                        jb4.i().m(oc4Var);
                        if (ed2.m) {
                            String str4 = this.a.c;
                            Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + a0 + " libName=" + str2);
                        }
                    }
                    a0.q();
                }
                this.a.f.m(oc4Var);
                if (this.a.d != null) {
                    this.a.d.onNext(oc4Var);
                    this.a.d.onCompleted();
                }
                i62.c().b(oc4Var, ed2.o);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947730422, "Lcom/baidu/tieba/ed2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947730422, "Lcom/baidu/tieba/ed2;");
                return;
            }
        }
        m = wj1.a;
        n = 0;
        o = PMSDownloadType.SO_LIB;
    }

    @Override // com.baidu.tieba.hb4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (m) {
                Log.e(this.c, "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.hb4
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

    public final dy9 b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
            }
            return this.e;
        }
        return (dy9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jg4
    public we4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.l;
        }
        return (we4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jg4
    public se4 getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.g;
        }
        return (se4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hb4
    public db4 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.h == null) {
                this.h = new g(this, null);
            }
            return this.h;
        }
        return (db4) invokeV.objValue;
    }

    public ed2(se4 se4Var, cd2 cd2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {se4Var, cd2Var};
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
            Log.i(sb2, "SwanSoUpdater: config=" + cd2Var + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.g = se4Var;
        this.k = cd2Var;
        if (cd2Var != null) {
            Iterator it = cd2Var.a().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                zc2 a2 = ad2.a(str);
                if (a2 == null) {
                    cd2Var.c(str, false);
                } else if (a2.f()) {
                    cd2Var.c(str, true);
                } else {
                    String e2 = a2.e();
                    dd2 t = bd2.d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.i.put(e2, t);
                    this.j.putAll(kg4.b(e2));
                }
            }
        }
        if (m) {
            String str2 = this.c;
            Log.i(str2, "SoNodeHandler() start mUpdatings=" + this.i.size());
        }
        if (this.i.isEmpty()) {
            e0(null);
        }
    }

    public final dd2 a0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            dd2 dd2Var = (dd2) this.i.get(str);
            if (dd2Var == null || !dd2Var.r(this)) {
                return null;
            }
            return dd2Var;
        }
        return (dd2) invokeL.objValue;
    }

    public final void f0(oc4 oc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, oc4Var) == null) {
            i62.c().d(oc4Var, new d(this, oc4Var));
        }
    }

    @Override // com.baidu.tieba.hb4
    public gg4 w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            if (TextUtils.equals("so", str)) {
                return this;
            }
            return super.w(str);
        }
        return (gg4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.hb4
    public void C(gc4 gc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gc4Var) == null) {
            super.C(gc4Var);
            if (m) {
                String str = this.c;
                Log.e(str, "onFetchError: " + gc4Var.toString());
            }
            e0(new Exception("failed by fetch error = " + gc4Var));
        }
    }

    @Override // com.baidu.tieba.hb4
    public void G(ug4 ug4Var) {
        int n2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ug4Var) == null) {
            if (m) {
                String str = this.c;
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                if (ug4Var == null) {
                    n2 = 0;
                } else {
                    n2 = ug4Var.n();
                }
                sb.append(n2);
                Log.i(str, sb.toString());
            }
            super.G(ug4Var);
            if (ug4Var == null) {
                return;
            }
            this.f = ug4Var;
            if (!ug4Var.k()) {
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
            cd2 cd2Var = this.k;
            if (cd2Var != null) {
                cd2Var.b(exc);
            }
        }
    }

    @Override // com.baidu.tieba.gg4
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
            }
            if (jSONObject != null) {
                g0((oc4) tg4.j(jSONObject, new oc4()));
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
            for (dd2 dd2Var : this.i.values()) {
                if (!dd2Var.n()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + dd2Var);
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
            for (dd2 dd2Var : this.i.values()) {
                if (dd2Var != null && dd2Var.r(this) && !dd2Var.n() && !dd2Var.s()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "notifyPmsFinish: try install updating=" + dd2Var);
                    }
                    dd2Var.q();
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
                arrayList.add(xx9.a(new e(this)));
            }
            if (!arrayList.isEmpty()) {
                xx9.i(arrayList).u(b0());
            }
        }
    }

    public final void g0(oc4 oc4Var) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, oc4Var) == null) {
            if (m) {
                Log.i(this.c, "SoNodeHandler updateBestSo start so=" + oc4Var);
            }
            if (oc4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by null so");
                    return;
                }
                return;
            }
            kg4 kg4Var = (kg4) this.j.get(oc4Var.g);
            if (kg4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by illegal bundleId=" + oc4Var.g);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(oc4Var.p)) {
                oc4Var.p = kg4Var.a;
            }
            dd2 a0 = a0(oc4Var.p);
            if (a0 == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by no updating lib=" + oc4Var.p);
                    return;
                }
                return;
            }
            if (oc4Var.q == null) {
                oc4Var.q = kg4Var.c;
            }
            if (!AbiType.currentAbi().compat(oc4Var.q)) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by currentAbi");
                    return;
                }
                return;
            }
            oc4 l = a0.l();
            oc4 j2 = a0.j();
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
            long j4 = oc4Var.i;
            if (j4 < max) {
                if (m) {
                    Log.i(this.c, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(oc4Var.i)));
                }
            } else if (j4 > max) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by update bestVer=" + oc4Var.i);
                }
                a0.w(this, oc4Var);
            } else {
                if (j2 == null || !j2.q.compat(oc4Var.q)) {
                    if (m) {
                        Log.i(this.c, "SoNodeHandler updateBestSo end by update abi update=" + oc4Var.q);
                    }
                    a0.w(this, oc4Var);
                }
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by should not exec here");
                }
            }
        }
    }

    @Override // com.baidu.tieba.gg4
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            eg4 eg4Var = new eg4();
            ug4 ug4Var = new ug4();
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop start");
            }
            boolean z = true;
            if ((m && !gh3.G() && lz2.j() == 1) ? false : false) {
                String i = lz2.i();
                if (!TextUtils.isEmpty(i)) {
                    try {
                        oc4 oc4Var = (oc4) tg4.j(new JSONObject(i), new oc4());
                        oc4Var.g = "so_zeus_armeabi";
                        g0(oc4Var);
                        e33.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1268)).G();
                    } catch (JSONException e2) {
                        e33.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1267)).G();
                        e2.printStackTrace();
                    }
                }
            }
            for (dd2 dd2Var : this.i.values()) {
                if (dd2Var.r(this)) {
                    g0(dd2Var.l());
                    oc4 j = dd2Var.j();
                    if (dd2Var.p() && j != null) {
                        if (m) {
                            String str = this.c;
                            Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                        }
                        fg4.b(j, ug4Var);
                        if (eg4Var.d == null) {
                            eg4Var.d = new ArrayList();
                        }
                        eg4Var.d.add(j);
                    } else {
                        if (m) {
                            Log.i(this.c, "SoNodeHandler localSo not update, just check for install");
                        }
                        dd2Var.q();
                    }
                }
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop end");
                String str2 = this.c;
                Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + ug4Var.n());
            }
            if (ug4Var.n() == 0) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler handle end by no pkg");
                }
                F();
                return;
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle end by start dl");
            }
            G(ug4Var);
            xc4.e(eg4Var, this);
        }
    }
}
