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
import com.baidu.tieba.ag2;
import com.baidu.tieba.doc;
import com.baidu.tieba.g92;
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
/* loaded from: classes5.dex */
public final class cg2 extends o92 implements hj4, ej4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static int n;
    public static final PMSDownloadType o;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public joc<? super mf4> d;
    public joc<mf4> e;
    public sj4 f;
    public final qh4 g;
    public be4<mf4> h;
    public final Map<String, bg2> i;
    public final Map<String, ij4> j;
    public final ag2 k;
    public final uh4<JSONArray> l;

    @Override // com.baidu.tieba.hj4
    public fe4 getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this : (fe4) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements uh4<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cg2 a;

        public a(cg2 cg2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cg2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cg2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.uh4
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) && jSONArray != null && !this.a.i.isEmpty()) {
                for (bg2 bg2Var : this.a.i.values()) {
                    if (bg2Var != null && bg2Var.r(this.a)) {
                        bg2Var.a(jSONArray);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements dl3<bg2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cg2 a;

        public b(cg2 cg2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cg2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cg2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(bg2 bg2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bg2Var) == null) {
                if (cg2.m) {
                    String str = this.a.c;
                    Log.i(str, "onCallback: SoUpdating=" + bg2Var);
                }
                if (bg2Var != null) {
                    this.a.k.c(bg2Var.k(), bg2Var.o());
                }
                this.a.Z(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements dl3<bg2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cg2 a;

        public c(cg2 cg2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cg2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cg2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(bg2 bg2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bg2Var) == null) && bg2Var != null) {
                this.a.k.d(bg2Var.k(), bg2Var.m());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements g92.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mf4 a;
        public final /* synthetic */ cg2 b;

        public d(cg2 cg2Var, mf4 mf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cg2Var, mf4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cg2Var;
            this.a = mf4Var;
        }

        @Override // com.baidu.tieba.g92.c
        public void b(PMSDownloadType pMSDownloadType, di3 di3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, di3Var) == null) {
                this.b.f.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, di3Var));
                }
            }
        }

        @Override // com.baidu.tieba.g92.c
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

    /* loaded from: classes5.dex */
    public class e implements doc.a<mf4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cg2 a;

        public e(cg2 cg2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cg2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cg2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.roc
        /* renamed from: a */
        public void call(joc<? super mf4> jocVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, jocVar) != null) {
                return;
            }
            this.a.d = jocVar;
        }
    }

    /* loaded from: classes5.dex */
    public class f extends joc<mf4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cg2 e;

        public f(cg2 cg2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cg2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = cg2Var;
        }

        public /* synthetic */ f(cg2 cg2Var, a aVar) {
            this(cg2Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.eoc
        /* renamed from: g */
        public void onNext(mf4 mf4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, mf4Var) == null) && cg2.m) {
                String str = this.e.c;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + mf4Var.toString());
            }
        }

        @Override // com.baidu.tieba.eoc
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (cg2.m) {
                    String str = this.e.c;
                    Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
                }
                this.e.e0(new Exception("failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.eoc
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (cg2.m) {
                    Log.e(this.e.c, "PkgDlSubscriber 包下载完成");
                }
                this.e.e0(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends yd4<mf4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cg2 a;

        public g(cg2 cg2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cg2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cg2Var;
        }

        public /* synthetic */ g(cg2 cg2Var, a aVar) {
            this(cg2Var);
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.be4
        /* renamed from: l */
        public String d(mf4 mf4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, mf4Var)) == null) {
                String g = zf2.d.g(mf4Var);
                if (cg2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback getDownloadPath: so=" + mf4Var.g + " path=" + g);
                }
                return g;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: q */
        public void a(mf4 mf4Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, mf4Var) == null) {
                super.a(mf4Var);
                ij4 ij4Var = (ij4) this.a.j.get(mf4Var.g);
                cg2 cg2Var = this.a;
                if (ij4Var == null) {
                    str = null;
                } else {
                    str = ij4Var.a;
                }
                bg2 a0 = cg2Var.a0(str);
                if (a0 != null) {
                    a0.x(new ag2.b(mf4Var.b, mf4Var.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: r */
        public void c(mf4 mf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, mf4Var) == null) {
                super.c(mf4Var);
                if (cg2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadStart: so=" + mf4Var.g);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: s */
        public void f(mf4 mf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, mf4Var) == null) {
                super.f(mf4Var);
                if (cg2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloading: so=" + mf4Var.g);
                }
                this.a.f0(mf4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: o */
        public void e(mf4 mf4Var, ef4 ef4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mf4Var, ef4Var) == null) {
                super.e(mf4Var, ef4Var);
                if (cg2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadError: so=" + mf4Var.g + " err=" + ef4Var);
                }
                this.a.f.l(mf4Var);
                di3 di3Var = new di3();
                di3Var.k(13L);
                di3Var.i(ef4Var.a);
                di3Var.d("so包下载失败");
                di3Var.f(ef4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(mf4Var, di3Var));
                }
                g92.c().a(mf4Var, cg2.o, di3Var);
                nm4.k(mf4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: p */
        public void i(mf4 mf4Var) {
            ij4 ij4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, mf4Var) == null) {
                super.i(mf4Var);
                if (cg2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadFinish: so=" + mf4Var);
                }
                String str2 = mf4Var.p;
                if (TextUtils.isEmpty(str2) && (ij4Var = (ij4) this.a.j.get(mf4Var.g)) != null) {
                    str2 = ij4Var.a;
                }
                bg2 a0 = this.a.a0(str2);
                if (a0 != null) {
                    boolean a = xj3.a(new File(mf4Var.a), mf4Var.m);
                    if (cg2.m) {
                        String str3 = this.a.c;
                        Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + mf4Var.g + " checkSign=" + a);
                    }
                    boolean z = true;
                    z = (cg2.m && !ek3.G() && j23.j() == 1) ? false : false;
                    if (a || z) {
                        he4.i().m(mf4Var);
                        if (cg2.m) {
                            String str4 = this.a.c;
                            Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + a0 + " libName=" + str2);
                        }
                    }
                    a0.q();
                }
                this.a.f.m(mf4Var);
                if (this.a.d != null) {
                    this.a.d.onNext(mf4Var);
                    this.a.d.onCompleted();
                }
                g92.c().b(mf4Var, cg2.o);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947673723, "Lcom/baidu/tieba/cg2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947673723, "Lcom/baidu/tieba/cg2;");
                return;
            }
        }
        m = vm1.a;
        n = 0;
        o = PMSDownloadType.SO_LIB;
    }

    @Override // com.baidu.tieba.fe4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (m) {
                Log.e(this.c, "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.fe4
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

    public final joc<mf4> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
            }
            return this.e;
        }
        return (joc) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hj4
    public uh4<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.l;
        }
        return (uh4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hj4
    @Nullable
    public qh4 getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.g;
        }
        return (qh4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fe4
    public be4<mf4> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.h == null) {
                this.h = new g(this, null);
            }
            return this.h;
        }
        return (be4) invokeV.objValue;
    }

    public cg2(qh4 qh4Var, ag2 ag2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qh4Var, ag2Var};
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
            Log.i(sb2, "SwanSoUpdater: config=" + ag2Var + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.g = qh4Var;
        this.k = ag2Var;
        if (ag2Var != null) {
            Iterator<String> it = ag2Var.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                xf2 a2 = yf2.a(next);
                if (a2 == null) {
                    ag2Var.c(next, false);
                } else if (a2.f()) {
                    ag2Var.c(next, true);
                } else {
                    String e2 = a2.e();
                    bg2 t = zf2.d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.i.put(e2, t);
                    this.j.putAll(ij4.b(e2));
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

    public final bg2 a0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            bg2 bg2Var = this.i.get(str);
            if (bg2Var == null || !bg2Var.r(this)) {
                return null;
            }
            return bg2Var;
        }
        return (bg2) invokeL.objValue;
    }

    public final void f0(mf4 mf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, mf4Var) == null) {
            g92.c().d(mf4Var, new d(this, mf4Var));
        }
    }

    @Override // com.baidu.tieba.fe4
    public ej4 w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            if (TextUtils.equals("so", str)) {
                return this;
            }
            return super.w(str);
        }
        return (ej4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.fe4
    public void C(ef4 ef4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ef4Var) == null) {
            super.C(ef4Var);
            if (m) {
                String str = this.c;
                Log.e(str, "onFetchError: " + ef4Var.toString());
            }
            e0(new Exception("failed by fetch error = " + ef4Var));
        }
    }

    @Override // com.baidu.tieba.fe4
    public void G(sj4 sj4Var) {
        int n2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, sj4Var) == null) {
            if (m) {
                String str = this.c;
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                if (sj4Var == null) {
                    n2 = 0;
                } else {
                    n2 = sj4Var.n();
                }
                sb.append(n2);
                Log.i(str, sb.toString());
            }
            super.G(sj4Var);
            if (sj4Var == null) {
                return;
            }
            this.f = sj4Var;
            if (!sj4Var.k()) {
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
            ag2 ag2Var = this.k;
            if (ag2Var != null) {
                ag2Var.b(exc);
            }
        }
    }

    @Override // com.baidu.tieba.ej4
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
            }
            if (jSONObject != null) {
                g0((mf4) rj4.j(jSONObject, new mf4()));
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
            for (bg2 bg2Var : this.i.values()) {
                if (!bg2Var.n()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + bg2Var);
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
            for (bg2 bg2Var : this.i.values()) {
                if (bg2Var != null && bg2Var.r(this) && !bg2Var.n() && !bg2Var.s()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "notifyPmsFinish: try install updating=" + bg2Var);
                    }
                    bg2Var.q();
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
                arrayList.add(doc.d(new e(this)));
            }
            if (!arrayList.isEmpty()) {
                doc.q(arrayList).F(b0());
            }
        }
    }

    public final void g0(mf4 mf4Var) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, mf4Var) == null) {
            if (m) {
                Log.i(this.c, "SoNodeHandler updateBestSo start so=" + mf4Var);
            }
            if (mf4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by null so");
                    return;
                }
                return;
            }
            ij4 ij4Var = this.j.get(mf4Var.g);
            if (ij4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by illegal bundleId=" + mf4Var.g);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(mf4Var.p)) {
                mf4Var.p = ij4Var.a;
            }
            bg2 a0 = a0(mf4Var.p);
            if (a0 == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by no updating lib=" + mf4Var.p);
                    return;
                }
                return;
            }
            if (mf4Var.q == null) {
                mf4Var.q = ij4Var.c;
            }
            if (!AbiType.currentAbi().compat(mf4Var.q)) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by currentAbi");
                    return;
                }
                return;
            }
            mf4 l = a0.l();
            mf4 j2 = a0.j();
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
            long j4 = mf4Var.i;
            if (j4 < max) {
                if (m) {
                    Log.i(this.c, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(mf4Var.i)));
                }
            } else if (j4 > max) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by update bestVer=" + mf4Var.i);
                }
                a0.w(this, mf4Var);
            } else {
                if (j2 == null || !j2.q.compat(mf4Var.q)) {
                    if (m) {
                        Log.i(this.c, "SoNodeHandler updateBestSo end by update abi update=" + mf4Var.q);
                    }
                    a0.w(this, mf4Var);
                }
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by should not exec here");
                }
            }
        }
    }

    @Override // com.baidu.tieba.ej4
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            cj4 cj4Var = new cj4();
            sj4 sj4Var = new sj4();
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop start");
            }
            boolean z = true;
            if ((m && !ek3.G() && j23.j() == 1) ? false : false) {
                String i = j23.i();
                if (!TextUtils.isEmpty(i)) {
                    try {
                        mf4 mf4Var = (mf4) rj4.j(new JSONObject(i), new mf4());
                        mf4Var.g = "so_zeus_armeabi";
                        g0(mf4Var);
                        c63.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f14fd)).G();
                    } catch (JSONException e2) {
                        c63.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f14fc)).G();
                        e2.printStackTrace();
                    }
                }
            }
            for (bg2 bg2Var : this.i.values()) {
                if (bg2Var.r(this)) {
                    g0(bg2Var.l());
                    mf4 j = bg2Var.j();
                    if (bg2Var.p() && j != null) {
                        if (m) {
                            String str = this.c;
                            Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                        }
                        dj4.b(j, sj4Var);
                        if (cj4Var.d == null) {
                            cj4Var.d = new ArrayList();
                        }
                        cj4Var.d.add(j);
                    } else {
                        if (m) {
                            Log.i(this.c, "SoNodeHandler localSo not update, just check for install");
                        }
                        bg2Var.q();
                    }
                }
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop end");
                String str2 = this.c;
                Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + sj4Var.n());
            }
            if (sj4Var.n() == 0) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler handle end by no pkg");
                }
                F();
                return;
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle end by start dl");
            }
            G(sj4Var);
            vf4.e(cj4Var, this);
        }
    }
}
