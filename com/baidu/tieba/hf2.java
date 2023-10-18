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
import com.baidu.tieba.ff2;
import com.baidu.tieba.h6c;
import com.baidu.tieba.l82;
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
/* loaded from: classes6.dex */
public final class hf2 extends t82 implements mi4, ji4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static int n;
    public static final PMSDownloadType o;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public n6c<? super re4> d;
    public n6c<re4> e;
    public xi4 f;
    public final vg4 g;
    public gd4<re4> h;
    public final Map<String, gf2> i;
    public final Map<String, ni4> j;
    public final ff2 k;
    public final zg4<JSONArray> l;

    @Override // com.baidu.tieba.mi4
    public kd4 getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this : (kd4) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements zg4<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hf2 a;

        public a(hf2 hf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zg4
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) && jSONArray != null && !this.a.i.isEmpty()) {
                for (gf2 gf2Var : this.a.i.values()) {
                    if (gf2Var != null && gf2Var.r(this.a)) {
                        gf2Var.a(jSONArray);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ik3<gf2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hf2 a;

        public b(hf2 hf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(gf2 gf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gf2Var) == null) {
                if (hf2.m) {
                    String str = this.a.c;
                    Log.i(str, "onCallback: SoUpdating=" + gf2Var);
                }
                if (gf2Var != null) {
                    this.a.k.c(gf2Var.k(), gf2Var.o());
                }
                this.a.Z(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ik3<gf2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hf2 a;

        public c(hf2 hf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(gf2 gf2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gf2Var) == null) && gf2Var != null) {
                this.a.k.d(gf2Var.k(), gf2Var.m());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements l82.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ re4 a;
        public final /* synthetic */ hf2 b;

        public d(hf2 hf2Var, re4 re4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hf2Var, re4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hf2Var;
            this.a = re4Var;
        }

        @Override // com.baidu.tieba.l82.c
        public void b(PMSDownloadType pMSDownloadType, ih3 ih3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ih3Var) == null) {
                this.b.f.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, ih3Var));
                }
            }
        }

        @Override // com.baidu.tieba.l82.c
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

    /* loaded from: classes6.dex */
    public class e implements h6c.a<re4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hf2 a;

        public e(hf2 hf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v6c
        /* renamed from: a */
        public void call(n6c<? super re4> n6cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, n6cVar) != null) {
                return;
            }
            this.a.d = n6cVar;
        }
    }

    /* loaded from: classes6.dex */
    public class f extends n6c<re4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hf2 e;

        public f(hf2 hf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = hf2Var;
        }

        public /* synthetic */ f(hf2 hf2Var, a aVar) {
            this(hf2Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i6c
        /* renamed from: g */
        public void onNext(re4 re4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, re4Var) == null) && hf2.m) {
                String str = this.e.c;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + re4Var.toString());
            }
        }

        @Override // com.baidu.tieba.i6c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (hf2.m) {
                    String str = this.e.c;
                    Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
                }
                this.e.e0(new Exception("failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.i6c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (hf2.m) {
                    Log.e(this.e.c, "PkgDlSubscriber 包下载完成");
                }
                this.e.e0(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends dd4<re4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hf2 a;

        public g(hf2 hf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hf2Var;
        }

        public /* synthetic */ g(hf2 hf2Var, a aVar) {
            this(hf2Var);
        }

        @Override // com.baidu.tieba.id4
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
        @Override // com.baidu.tieba.gd4
        /* renamed from: l */
        public String d(re4 re4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, re4Var)) == null) {
                String g = ef2.d.g(re4Var);
                if (hf2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback getDownloadPath: so=" + re4Var.g + " path=" + g);
                }
                return g;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: q */
        public void a(re4 re4Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, re4Var) == null) {
                super.a(re4Var);
                ni4 ni4Var = (ni4) this.a.j.get(re4Var.g);
                hf2 hf2Var = this.a;
                if (ni4Var == null) {
                    str = null;
                } else {
                    str = ni4Var.a;
                }
                gf2 a0 = hf2Var.a0(str);
                if (a0 != null) {
                    a0.x(new ff2.b(re4Var.b, re4Var.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: r */
        public void c(re4 re4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, re4Var) == null) {
                super.c(re4Var);
                if (hf2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadStart: so=" + re4Var.g);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: s */
        public void f(re4 re4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, re4Var) == null) {
                super.f(re4Var);
                if (hf2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloading: so=" + re4Var.g);
                }
                this.a.f0(re4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: o */
        public void e(re4 re4Var, je4 je4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, re4Var, je4Var) == null) {
                super.e(re4Var, je4Var);
                if (hf2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadError: so=" + re4Var.g + " err=" + je4Var);
                }
                this.a.f.l(re4Var);
                ih3 ih3Var = new ih3();
                ih3Var.k(13L);
                ih3Var.i(je4Var.a);
                ih3Var.d("so包下载失败");
                ih3Var.f(je4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(re4Var, ih3Var));
                }
                l82.c().a(re4Var, hf2.o, ih3Var);
                sl4.k(re4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: p */
        public void i(re4 re4Var) {
            ni4 ni4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, re4Var) == null) {
                super.i(re4Var);
                if (hf2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadFinish: so=" + re4Var);
                }
                String str2 = re4Var.p;
                if (TextUtils.isEmpty(str2) && (ni4Var = (ni4) this.a.j.get(re4Var.g)) != null) {
                    str2 = ni4Var.a;
                }
                gf2 a0 = this.a.a0(str2);
                if (a0 != null) {
                    boolean a = cj3.a(new File(re4Var.a), re4Var.m);
                    if (hf2.m) {
                        String str3 = this.a.c;
                        Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + re4Var.g + " checkSign=" + a);
                    }
                    boolean z = true;
                    z = (hf2.m && !jj3.G() && o13.j() == 1) ? false : false;
                    if (a || z) {
                        md4.i().m(re4Var);
                        if (hf2.m) {
                            String str4 = this.a.c;
                            Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + a0 + " libName=" + str2);
                        }
                    }
                    a0.q();
                }
                this.a.f.m(re4Var);
                if (this.a.d != null) {
                    this.a.d.onNext(re4Var);
                    this.a.d.onCompleted();
                }
                l82.c().b(re4Var, hf2.o);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947821717, "Lcom/baidu/tieba/hf2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947821717, "Lcom/baidu/tieba/hf2;");
                return;
            }
        }
        m = am1.a;
        n = 0;
        o = PMSDownloadType.SO_LIB;
    }

    @Override // com.baidu.tieba.kd4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (m) {
                Log.e(this.c, "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.kd4
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

    public final n6c<re4> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
            }
            return this.e;
        }
        return (n6c) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mi4
    public zg4<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.l;
        }
        return (zg4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mi4
    @Nullable
    public vg4 getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.g;
        }
        return (vg4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kd4
    public gd4<re4> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.h == null) {
                this.h = new g(this, null);
            }
            return this.h;
        }
        return (gd4) invokeV.objValue;
    }

    public hf2(vg4 vg4Var, ff2 ff2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vg4Var, ff2Var};
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
            Log.i(sb2, "SwanSoUpdater: config=" + ff2Var + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.g = vg4Var;
        this.k = ff2Var;
        if (ff2Var != null) {
            Iterator<String> it = ff2Var.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                cf2 a2 = df2.a(next);
                if (a2 == null) {
                    ff2Var.c(next, false);
                } else if (a2.f()) {
                    ff2Var.c(next, true);
                } else {
                    String e2 = a2.e();
                    gf2 t = ef2.d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.i.put(e2, t);
                    this.j.putAll(ni4.b(e2));
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

    public final gf2 a0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            gf2 gf2Var = this.i.get(str);
            if (gf2Var == null || !gf2Var.r(this)) {
                return null;
            }
            return gf2Var;
        }
        return (gf2) invokeL.objValue;
    }

    public final void f0(re4 re4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, re4Var) == null) {
            l82.c().d(re4Var, new d(this, re4Var));
        }
    }

    @Override // com.baidu.tieba.kd4
    public ji4 w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            if (TextUtils.equals("so", str)) {
                return this;
            }
            return super.w(str);
        }
        return (ji4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.kd4
    public void C(je4 je4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, je4Var) == null) {
            super.C(je4Var);
            if (m) {
                String str = this.c;
                Log.e(str, "onFetchError: " + je4Var.toString());
            }
            e0(new Exception("failed by fetch error = " + je4Var));
        }
    }

    @Override // com.baidu.tieba.kd4
    public void G(xi4 xi4Var) {
        int n2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, xi4Var) == null) {
            if (m) {
                String str = this.c;
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                if (xi4Var == null) {
                    n2 = 0;
                } else {
                    n2 = xi4Var.n();
                }
                sb.append(n2);
                Log.i(str, sb.toString());
            }
            super.G(xi4Var);
            if (xi4Var == null) {
                return;
            }
            this.f = xi4Var;
            if (!xi4Var.k()) {
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
            ff2 ff2Var = this.k;
            if (ff2Var != null) {
                ff2Var.b(exc);
            }
        }
    }

    @Override // com.baidu.tieba.ji4
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
            }
            if (jSONObject != null) {
                g0((re4) wi4.j(jSONObject, new re4()));
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
            for (gf2 gf2Var : this.i.values()) {
                if (!gf2Var.n()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + gf2Var);
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
            for (gf2 gf2Var : this.i.values()) {
                if (gf2Var != null && gf2Var.r(this) && !gf2Var.n() && !gf2Var.s()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "notifyPmsFinish: try install updating=" + gf2Var);
                    }
                    gf2Var.q();
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
                arrayList.add(h6c.d(new e(this)));
            }
            if (!arrayList.isEmpty()) {
                h6c.q(arrayList).F(b0());
            }
        }
    }

    public final void g0(re4 re4Var) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, re4Var) == null) {
            if (m) {
                Log.i(this.c, "SoNodeHandler updateBestSo start so=" + re4Var);
            }
            if (re4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by null so");
                    return;
                }
                return;
            }
            ni4 ni4Var = this.j.get(re4Var.g);
            if (ni4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by illegal bundleId=" + re4Var.g);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(re4Var.p)) {
                re4Var.p = ni4Var.a;
            }
            gf2 a0 = a0(re4Var.p);
            if (a0 == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by no updating lib=" + re4Var.p);
                    return;
                }
                return;
            }
            if (re4Var.q == null) {
                re4Var.q = ni4Var.c;
            }
            if (!AbiType.currentAbi().compat(re4Var.q)) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by currentAbi");
                    return;
                }
                return;
            }
            re4 l = a0.l();
            re4 j2 = a0.j();
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
            long j4 = re4Var.i;
            if (j4 < max) {
                if (m) {
                    Log.i(this.c, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(re4Var.i)));
                }
            } else if (j4 > max) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by update bestVer=" + re4Var.i);
                }
                a0.w(this, re4Var);
            } else {
                if (j2 == null || !j2.q.compat(re4Var.q)) {
                    if (m) {
                        Log.i(this.c, "SoNodeHandler updateBestSo end by update abi update=" + re4Var.q);
                    }
                    a0.w(this, re4Var);
                }
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by should not exec here");
                }
            }
        }
    }

    @Override // com.baidu.tieba.ji4
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            hi4 hi4Var = new hi4();
            xi4 xi4Var = new xi4();
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop start");
            }
            boolean z = true;
            if ((m && !jj3.G() && o13.j() == 1) ? false : false) {
                String i = o13.i();
                if (!TextUtils.isEmpty(i)) {
                    try {
                        re4 re4Var = (re4) wi4.j(new JSONObject(i), new re4());
                        re4Var.g = "so_zeus_armeabi";
                        g0(re4Var);
                        h53.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f14d5)).G();
                    } catch (JSONException e2) {
                        h53.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f14d4)).G();
                        e2.printStackTrace();
                    }
                }
            }
            for (gf2 gf2Var : this.i.values()) {
                if (gf2Var.r(this)) {
                    g0(gf2Var.l());
                    re4 j = gf2Var.j();
                    if (gf2Var.p() && j != null) {
                        if (m) {
                            String str = this.c;
                            Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                        }
                        ii4.b(j, xi4Var);
                        if (hi4Var.d == null) {
                            hi4Var.d = new ArrayList();
                        }
                        hi4Var.d.add(j);
                    } else {
                        if (m) {
                            Log.i(this.c, "SoNodeHandler localSo not update, just check for install");
                        }
                        gf2Var.q();
                    }
                }
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop end");
                String str2 = this.c;
                Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + xi4Var.n());
            }
            if (xi4Var.n() == 0) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler handle end by no pkg");
                }
                F();
                return;
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle end by start dl");
            }
            G(xi4Var);
            af4.e(hi4Var, this);
        }
    }
}
