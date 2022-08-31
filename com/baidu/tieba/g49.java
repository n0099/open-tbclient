package com.baidu.tieba;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64InputStream;
import android.util.Base64OutputStream;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.model.IMUserListModel;
import com.baidu.tieba.m59;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g49 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean y;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public long b;
    public boolean c;
    public Context d;
    public c59 e;
    public f49 f;
    public int g;
    public long h;
    public List<r49> i;
    public long j;
    public long k;
    public long l;
    public int m;
    public SparseArray<ArrayList> n;
    public HashMap<String, Long> o;
    public y49 p;
    public k49 q;
    public int r;
    public int s;
    public int t;
    public m59 u;
    public boolean v;
    public int w;
    public Runnable x;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g49 a;

        public a(g49 g49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g49Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.g == 1) {
                    long uptimeMillis = SystemClock.uptimeMillis() - this.a.h;
                    if (uptimeMillis >= 5000) {
                        if (g49.y) {
                            Log.d("UBCBehaviorModel", String.format("***saveCache after %d ms***", Long.valueOf(uptimeMillis)));
                        }
                        this.a.z();
                        this.a.g = 0;
                        return;
                    }
                    h49.w().J(this, 5000 - uptimeMillis);
                } else if (this.a.g == 2) {
                    this.a.g = 0;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements x49 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g49 a;

        public b(g49 g49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g49Var;
        }

        @Override // com.baidu.tieba.x49
        public void a(boolean z, r49 r49Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, r49Var) == null) {
                if (!z) {
                    this.a.e.z(r49Var);
                    return;
                }
                this.a.e.h();
                b59.f().a(r49Var.l(), false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public r49 b;
        public File c;
        public JSONObject d;
        public String e;
        public long f;
        public boolean g;
        public boolean h;
        public x49 i;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = true;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = -1L;
            this.g = false;
            this.h = false;
            this.i = null;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements m59.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(g49 g49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.m59.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h49.w().P();
                h49.w().K();
            }
        }

        @Override // com.baidu.tieba.m59.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                h49.w().P();
                h49.w().K();
                h49.w().E();
            }
        }

        @Override // com.baidu.tieba.m59.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                h49.w().K();
            }
        }

        @Override // com.baidu.tieba.m59.e
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                h49.w().P();
                h49.w().K();
                h49.w().E();
            }
        }

        @Override // com.baidu.tieba.m59.e
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                h49.w().P();
                h49.w().K();
                h49.w().E();
            }
        }

        public /* synthetic */ d(g49 g49Var, a aVar) {
            this(g49Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947744093, "Lcom/baidu/tieba/g49;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947744093, "Lcom/baidu/tieba/g49;");
                return;
            }
        }
        y = f59.m();
    }

    public g49(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = false;
        this.g = 0;
        this.h = 0L;
        this.x = new a(this);
        this.d = context;
        o59 a2 = o59.a();
        this.e = new c59(context);
        this.f = new f49(context);
        this.p = f59.j();
        this.i = new ArrayList(20);
        this.j = a2.c("ubc_last_upload_non_real", 0L);
        this.k = a2.c("ubc_reset_real_time_count_time", 0L);
        this.l = a2.c("ubc_last_upload_failed_data_time", 0L);
        this.m = a2.b("ubc_real_time_count", 0);
        k49 o = k49.o();
        this.q = o;
        o.D(this, context);
        this.b = System.currentTimeMillis();
        this.a = new Random().nextInt(31) + 60;
        this.v = k49.o().I();
        this.w = k49.o().x();
        b59.f().g(this.e);
        m59 m = m59.m();
        this.u = m;
        m.n(this.d, this.e, new d(this, null));
    }

    public void A(r49 r49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, r49Var) == null) {
            boolean equals = TextUtils.equals(r49Var.l(), r49Var.k());
            boolean z = (equals && (this.q.e(r49Var.l()) && (r49Var.n() & 64) == 0)) || (equals && ((r49Var.n() & 128) != 0));
            if (f59.i().d()) {
                if (!z) {
                    this.e.z(r49Var);
                    return;
                }
                List<String> j = f59.i().j();
                if (j != null && j.contains(r49Var.l())) {
                    if (!this.c) {
                        if ((System.currentTimeMillis() - this.b) / 1000 >= this.a) {
                            this.c = true;
                        } else {
                            this.e.z(r49Var);
                            return;
                        }
                    }
                } else {
                    this.e.z(r49Var);
                    return;
                }
            }
            if (z && !V(r49Var)) {
                if (this.q.K(r49Var.l())) {
                    this.e.z(r49Var);
                    return;
                }
                return;
            }
            if (z) {
                b59.f().a(r49Var.l(), false);
            }
            if (f59.i().d()) {
                this.e.e();
            } else if (Math.abs(System.currentTimeMillis() - this.j) >= k49.o().t()) {
                if (!z && this.q.K(r49Var.l())) {
                    g(r49Var);
                }
                U();
            } else if ((r49Var.n() & 1) == 0) {
                if (!z && this.q.K(r49Var.l())) {
                    g(r49Var);
                }
                if (this.i.size() >= 20) {
                    z();
                }
            } else if (z || !this.q.K(r49Var.l())) {
            } else {
                this.e.z(r49Var);
            }
        }
    }

    public void B(r49 r49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r49Var) == null) {
            this.f.g(r49Var, this.q.e(r49Var.l()));
        }
    }

    public void C(r49 r49Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, r49Var) == null) && kc1.g()) {
            this.f.i(r49Var);
        }
    }

    public final void D(String str, String str2) {
        OutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            String str3 = this.d.getFilesDir() + File.separator + "ubcsenddir";
            File file = new File(str3);
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(str3, str2);
            if (file2.exists()) {
                return;
            }
            OutputStream outputStream = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                outputStream = new Base64OutputStream(fileOutputStream, 0);
                outputStream.write(str.getBytes());
                outputStream.flush();
                e59.b("save to file suc");
                try {
                    outputStream.close();
                } catch (Exception e2) {
                    e = e2;
                    if (!y) {
                        return;
                    }
                    e.printStackTrace();
                }
            } catch (Exception e3) {
                e = e3;
                outputStream = fileOutputStream;
                if (y) {
                    e.printStackTrace();
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e4) {
                        e = e4;
                        if (!y) {
                            return;
                        }
                        e.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = fileOutputStream;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e5) {
                        if (y) {
                            e5.printStackTrace();
                        }
                    }
                }
                throw th;
            }
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && n59.a(this.d)) {
            if (this.n == null) {
                r();
            }
            p59 h = p59.h(this.d);
            if (!b59.f().d(h) || h == null || h.y()) {
                return;
            }
            h.L(true);
            J(h);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            p59 i = p59.i();
            if (this.f.e(i)) {
                JSONObject u = i.u();
                if (y) {
                    Log.d("UBCBehaviorModel", "sendQualityData:" + u.toString());
                }
                h49.w().R(u);
            }
        }
    }

    public final void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            p59 i = p59.i();
            i.L(z);
            if (this.f.f(i, z)) {
                JSONObject u = i.u();
                if (y) {
                    Log.d("UBCBehaviorModel", "checkFileData:" + u.toString());
                }
                this.f.c(z);
                h49.w().R(u);
            }
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.e.C();
        }
    }

    public void I(t49 t49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t49Var) == null) {
            this.e.B(t49Var);
        }
    }

    public final void J(p59 p59Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, p59Var) == null) {
            p59Var.k();
            if (p59Var.y()) {
                return;
            }
            if (p59Var.x()) {
                str = p59Var.p();
            } else {
                try {
                    JSONObject u = p59Var.u();
                    String c2 = n59.c(u.toString().getBytes(), true);
                    D(u.toString(), c2);
                    if (y) {
                        e59.a(p59Var);
                        Log.d("UBCBehaviorModel", "save send data to file " + c2);
                    }
                    str = c2;
                } catch (OutOfMemoryError unused) {
                    p59Var.e();
                    return;
                }
            }
            if (!this.e.g(p59Var, str)) {
                p59Var.e();
                File file = new File(this.d.getFilesDir() + File.separator + "ubcsenddir", str);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.e.l(str);
                return;
            }
            h59.a().m(p59Var.B(), p59Var.v());
            h49.w().Q(p59Var, str);
            p59Var.e();
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.l) < IMUserListModel.REQUEST_SPACE) {
                return;
            }
            this.l = currentTimeMillis;
            o59.a().e("ubc_last_upload_failed_data_time", this.l);
            h49.w().E();
            h49.w().K();
        }
    }

    public void K(a59 a59Var, boolean z, w49 w49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{a59Var, Boolean.valueOf(z), w49Var}) == null) {
            JSONArray jSONArray = new JSONArray();
            this.r = 0;
            this.s = 0;
            this.t = 0;
            k(a59Var, z, jSONArray);
            s(a59Var, z, jSONArray);
            if (w49Var != null && jSONArray.length() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("items", jSONArray);
                    int i = this.r + this.s + this.t;
                    jSONObject.put("count", i + "," + this.r + "," + this.t);
                    w49Var.setUBCConfigStatisticData(jSONObject);
                } catch (JSONException e) {
                    if (y) {
                        e.printStackTrace();
                    }
                }
            }
            this.q.Y(a59Var.b());
            this.q.P(a59Var.i() * 86400000);
            this.q.Q(a59Var.h());
            this.q.R(a59Var.c());
            this.q.U(a59Var.f());
            this.q.T(a59Var.e());
            this.q.S(a59Var.d());
            this.q.W(a59Var.j());
            this.q.X(a59Var.k());
            SparseArray<ArrayList> sparseArray = this.n;
            if (sparseArray == null) {
                this.n = new SparseArray<>();
            } else {
                sparseArray.clear();
            }
            HashMap<String, Long> hashMap = this.o;
            if (hashMap == null) {
                this.o = new HashMap<>();
            } else {
                hashMap.clear();
            }
            this.e.x(this.n);
            if (y) {
                Log.d("UBCBehaviorModel", "mIdArray: " + this.n.toString());
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.n.size(); i3++) {
                int keyAt = this.n.keyAt(i3);
                if (keyAt != 0 && i2 == 0) {
                    i2 = keyAt;
                }
                HashMap<String, Long> hashMap2 = this.o;
                hashMap2.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.q.V(i2);
            a59Var.b().clear();
        }
    }

    public void L(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048587, this, str, i, str2) == null) {
            this.e.E(str, i, str2);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && n59.a(this.d)) {
            p59 h = p59.h(this.d);
            int p = this.q.p();
            h.L(false);
            if (this.v) {
                h.M(this.w);
                this.e.b(h);
            } else {
                h.M(p);
                this.e.a(h);
            }
            int v = h.v();
            if (v > 0) {
                if (y) {
                    Log.d("UBCBehaviorModel", "uploadBackLog size=" + v);
                }
                J(h);
            }
        }
    }

    public final void N(c cVar) {
        boolean a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) || cVar == null) {
            return;
        }
        if (m59.m().p() && !n59.a(this.d)) {
            h49.w().V(cVar.e, false);
            return;
        }
        if (cVar.a) {
            a2 = this.p.b(cVar.c, cVar.f, cVar.g, cVar.h);
        } else {
            a2 = this.p.a(cVar.d, cVar.g, cVar.h);
        }
        x49 x49Var = cVar.i;
        if (x49Var != null) {
            x49Var.a(a2, cVar.b);
        }
        if (TextUtils.isEmpty(cVar.e)) {
            return;
        }
        h49.w().V(cVar.e, a2);
    }

    public void O(s49 s49Var) {
        InputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, s49Var) == null) || s49Var == null) {
            return;
        }
        String a2 = s49Var.a();
        File file = new File(this.d.getFilesDir() + File.separator + "ubcsenddir", a2);
        if (file.exists()) {
            if (s49Var.c()) {
                h49.w().Q(p59.g(file, (int) file.length()), a2);
                return;
            }
            InputStream inputStream = null;
            try {
                try {
                    if (y) {
                        Log.d("UBCBehaviorModel", "uploadFile fileName:" + a2);
                    }
                    fileInputStream = new FileInputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            } catch (OutOfMemoryError e2) {
                e = e2;
            }
            try {
                if (fileInputStream.available() > 0) {
                    inputStream = new Base64InputStream(fileInputStream, 0);
                    JSONObject jSONObject = new JSONObject(k69.b(inputStream));
                    JSONObject jSONObject2 = jSONObject.getJSONObject(TtmlNode.TAG_METADATA);
                    jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
                    jSONObject.put(TtmlNode.TAG_METADATA, jSONObject2);
                    h49.w().S(jSONObject, a2);
                    fileInputStream = inputStream;
                }
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    e = e3;
                    if (!y) {
                        return;
                    }
                    e.printStackTrace();
                }
            } catch (Exception e4) {
                e = e4;
                inputStream = fileInputStream;
                if (y) {
                    Log.d("UBCBehaviorModel", "error:" + e.getMessage());
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                        e = e5;
                        if (!y) {
                            return;
                        }
                        e.printStackTrace();
                    }
                }
            } catch (OutOfMemoryError e6) {
                e = e6;
                inputStream = fileInputStream;
                if (y) {
                    Log.d("UBCBehaviorModel", "OutOfMemoryError:" + e.getMessage());
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e7) {
                        e = e7;
                        if (!y) {
                            return;
                        }
                        e.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = fileInputStream;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e8) {
                        if (y) {
                            e8.printStackTrace();
                        }
                    }
                }
                throw th;
            }
        }
    }

    public void P(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (y) {
                Log.d("UBCBehaviorModel", "upload file fail:" + str);
            }
            e59.b("upload file fail");
            this.e.F(str);
        }
    }

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            File file = new File(this.d.getFilesDir() + File.separator + "ubcsenddir", str);
            if (y) {
                Log.d("UBCBehaviorModel", "deleteUploadFile file:" + file.getAbsolutePath());
            }
            e59.b("delete file");
            if (file.exists() && file.delete()) {
                Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
                e59.b("delete file suc");
            }
            this.e.l(str);
        }
    }

    public final void R(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, str) == null) && n59.a(this.d) && j()) {
            p59 h = p59.h(this.d);
            h.L(true);
            h.C();
            ArrayList<String> arrayList = new ArrayList<>(1);
            arrayList.add(str);
            this.e.r(arrayList, true, h);
            J(h);
            y();
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && n59.a(this.d)) {
            this.e.e();
            p59 h = p59.h(this.d);
            int p = this.q.p();
            h.M(p);
            h.L(true);
            p59 h2 = p59.h(this.d);
            h2.M(p);
            h2.L(false);
            this.e.n(h, h2);
            int v = h.v();
            int v2 = h2.v();
            if (y) {
                Log.d("UBCBehaviorModel", "real size = " + v + "   no real  = " + v2);
            }
            if (v > 0) {
                if (h.z()) {
                    h59.a().l("uploadAll", String.valueOf(p), String.valueOf(v));
                }
                J(h);
            }
            if (v2 > 0) {
                if (h2.z()) {
                    h59.a().l("uploadAll", String.valueOf(p), String.valueOf(v2));
                }
                J(h2);
            }
        }
    }

    public final void T(SparseArray<ArrayList> sparseArray, p59 p59Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, sparseArray, p59Var) == null) || sparseArray == null) {
            return;
        }
        boolean H = this.q.H();
        boolean G = this.q.G();
        int m = this.q.m();
        if (H && !G && sparseArray.get(m, null) == null) {
            sparseArray.put(m, new ArrayList(0));
            z = true;
        } else {
            z = false;
        }
        for (int i = 0; i < sparseArray.size() && !p59Var.d(51200); i++) {
            int keyAt = sparseArray.keyAt(i);
            if (keyAt == 0) {
                if (H && G) {
                    this.e.r(new ArrayList<>(this.q.u()), false, p59Var);
                } else {
                    this.e.r(sparseArray.valueAt(i), true, p59Var);
                }
            } else if (this.v) {
                p59Var.M(this.w);
                if (H && !G && keyAt == m) {
                    ArrayList<String> o = o(sparseArray, keyAt);
                    if (o != null) {
                        this.e.t(o, false, p59Var);
                    }
                } else {
                    this.e.t(sparseArray.valueAt(i), true, p59Var);
                }
            } else if (H && !G && keyAt == m) {
                ArrayList<String> o2 = o(sparseArray, keyAt);
                if (o2 != null) {
                    this.e.r(o2, false, p59Var);
                }
            } else {
                this.e.r(sparseArray.valueAt(i), true, p59Var);
            }
            if (p59Var.w()) {
                break;
            }
        }
        if (z) {
            sparseArray.remove(m);
        }
    }

    public final void U() {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && n59.a(this.d)) {
            if (y) {
                Log.d("UBCBehaviorModel", " upload no real data");
            }
            this.j = System.currentTimeMillis();
            o59.a().e("ubc_last_upload_non_real", this.j);
            i();
            z();
            this.e.e();
            HashSet hashSet = new HashSet();
            if (this.n == null) {
                r();
            }
            p59 h = p59.h(this.d);
            h.L(false);
            for (int i = 0; i < this.n.size(); i++) {
                int keyAt = this.n.keyAt(i);
                if (keyAt != 0) {
                    HashMap<String, Long> hashMap = this.o;
                    long longValue = hashMap.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    long j = (long) keyAt;
                    long j2 = 60000 * j;
                    if (this.v) {
                        j2 = 1000 * j;
                    }
                    if (longValue == 0 || (longValue + j2) - System.currentTimeMillis() < this.q.t()) {
                        if (this.v) {
                            h.M(this.w);
                            this.e.t(this.n.valueAt(i), true, h);
                        } else {
                            this.e.r(this.n.valueAt(i), true, h);
                        }
                        if (h.w()) {
                            break;
                        }
                        HashMap<String, Long> hashMap2 = this.o;
                        hashMap2.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (h.y()) {
                return;
            }
            boolean H = this.q.H();
            boolean G = this.q.G();
            int m = this.q.m();
            if (H && !G && this.n.get(m, null) == null) {
                this.n.put(m, new ArrayList(0));
                z = true;
            } else {
                z = false;
            }
            if (!this.v) {
                for (int i2 = 0; i2 < this.n.size(); i2++) {
                    int keyAt2 = this.n.keyAt(i2);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (h.d(51200)) {
                            break;
                        }
                        if (H && !G && keyAt2 == m) {
                            ArrayList<String> o = o(this.n, keyAt2);
                            if (o != null) {
                                this.e.r(o, false, h);
                            }
                        } else {
                            this.e.r(this.n.valueAt(i2), true, h);
                        }
                        if (h.w()) {
                            break;
                        }
                    }
                }
            }
            if (z) {
                this.n.remove(m);
            }
            if (y) {
                Log.d("UBCBehaviorModel", "UBC non real time:");
            }
            J(h);
        }
    }

    public final boolean V(r49 r49Var) {
        InterceptResult invokeL;
        SparseArray<ArrayList> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, r49Var)) == null) {
            if (n59.a(this.d) && j()) {
                z();
                p59 p = p(r49Var, false);
                if (p == null || p.y()) {
                    return false;
                }
                if ((r49Var.n() & 128) != 0) {
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(r49Var.l());
                    sparseArray = new SparseArray<>(1);
                    sparseArray.put(0, arrayList);
                } else {
                    if (this.n == null) {
                        r();
                    }
                    if (Y(p, "0")) {
                        return true;
                    }
                    sparseArray = this.n;
                }
                T(sparseArray, p);
                J(p);
                y();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && n59.a(this.d) && j()) {
            p59 h = p59.h(this.d);
            h.L(true);
            if (this.n == null) {
                r();
            }
            if (Y(h, "1")) {
                return;
            }
            T(this.n, h);
            J(h);
            y();
        }
    }

    public boolean X(r49 r49Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, r49Var)) == null) {
            if (n59.a(this.d)) {
                r49Var.A("1");
                p59 p = p(r49Var, true);
                if (p == null || p.y()) {
                    return false;
                }
                this.e.u(p);
                h49.w().U(p.u(), true, r49Var, new b(this));
                p.e();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean Y(p59 p59Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, p59Var, str)) == null) {
            if (f59.i().d()) {
                List<String> j = f59.i().j();
                if (j != null && j.size() != 0) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.addAll(j);
                    if (arrayList.size() == 0) {
                        return true;
                    }
                    this.e.r(arrayList, true, p59Var);
                    J(p59Var);
                    y();
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void g(r49 r49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, r49Var) == null) {
            this.i.add(r49Var);
            int i = this.g;
            if (i == 0) {
                this.h = SystemClock.uptimeMillis();
                h49.w().J(this.x, 5000L);
                this.g = 1;
            } else if (i == 2) {
                this.h = SystemClock.uptimeMillis();
                this.g = 1;
            }
        }
    }

    public void h(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048602, this, str, i) == null) {
            z();
            this.e.d(str, i);
            if (!f59.i().d() && Math.abs(System.currentTimeMillis() - this.j) >= k49.o().t()) {
                if (y) {
                    Log.d("UBCBehaviorModel", "cancel flow " + str + " invoke ->uploadNonRealTimeData ");
                }
                U();
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            G(true);
            G(false);
        }
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (y) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.k) > 86400000) {
                this.m = 0;
                this.k = currentTimeMillis;
                o59.a().e("ubc_reset_real_time_count_time", this.k);
                o59.a().d("ubc_real_time_count", this.m);
            }
            if (this.m >= 10000) {
                if (y) {
                    Log.d("UBCBehaviorModel", "real time upload total count check fail");
                }
                int i = this.m;
                if (i == 10000) {
                    this.m = i + 1;
                    if (!y) {
                        h59.a().f(String.valueOf(10000));
                    }
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void k(a59 a59Var, boolean z, JSONArray jSONArray) {
        JSONObject a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{a59Var, Boolean.valueOf(z), jSONArray}) == null) || (a2 = a59Var.a()) == null) {
            return;
        }
        Iterator<String> keys = a2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                JSONObject jSONObject = new JSONObject();
                n49 p = this.e.p(next);
                String optString = a2.optString(next, "0");
                String j = p != null ? p.j() : "0";
                boolean z2 = Integer.parseInt(j) >= Integer.parseInt(optString);
                if (z && j != null && z2) {
                    jSONObject.put("product", String.format("del/%s", next));
                    jSONObject.put("valid", "2");
                    jSONObject.put("version", optString);
                    jSONArray.put(jSONObject);
                    this.t++;
                } else {
                    jSONObject.put("product", String.format("del/%s", next));
                    jSONObject.put("version", optString);
                    jSONObject.put("valid", "1");
                    if (!this.e.j(next)) {
                        jSONObject.put("valid", "0");
                        this.s++;
                    } else {
                        this.r++;
                    }
                    jSONArray.put(jSONObject);
                }
            } catch (Exception e) {
                if (y) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void l(String str, int i, int i2, long j, JSONArray jSONArray) {
        List<String> j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), jSONArray}) == null) {
            z();
            this.e.m(str, i, j, jSONArray);
            if ((i2 & 128) != 0) {
                R(str);
                return;
            }
            boolean e = this.q.e(str);
            if (f59.i().d()) {
                if (!e || (j2 = f59.i().j()) == null || !j2.contains(str)) {
                    return;
                }
                if (!this.c) {
                    if ((System.currentTimeMillis() - this.b) / 1000 < this.a) {
                        return;
                    }
                    this.c = true;
                }
            }
            if (e) {
                if (y) {
                    Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadRealTimeFlow ");
                }
                W();
            }
            if (!f59.i().d() && Math.abs(System.currentTimeMillis() - this.j) >= k49.o().t()) {
                if (y) {
                    Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadNonRealTimeData ");
                }
                U();
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            try {
                z();
            } catch (RuntimeException unused) {
                if (y) {
                    Log.d("UBCBehaviorModel", "save cache error!");
                }
            }
        }
    }

    public c59 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.e : (c59) invokeV.objValue;
    }

    public final ArrayList o(SparseArray<ArrayList> sparseArray, int i) {
        InterceptResult invokeLI;
        ArrayList valueAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048609, this, sparseArray, i)) == null) {
            if (sparseArray == null || sparseArray.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                if (sparseArray.keyAt(i2) != i && (valueAt = sparseArray.valueAt(i2)) != null && valueAt.size() != 0) {
                    arrayList.addAll(valueAt);
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeLI.objValue;
    }

    public final p59 p(r49 r49Var, boolean z) {
        InterceptResult invokeLZ;
        p59 h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048610, this, r49Var, z)) == null) {
            if (z) {
                h = p59.i();
            } else {
                h = p59.h(this.d);
            }
            if (h.c(r49Var, r49Var.g())) {
                h.L(true);
                if ((r49Var.n() & 128) != 0) {
                    h.C();
                }
                if (!TextUtils.isEmpty(r49Var.h())) {
                    h.K("1");
                }
                return h;
            }
            return null;
        }
        return (p59) invokeLZ.objValue;
    }

    public int q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            k49 k49Var = this.q;
            if (k49Var != null) {
                return k49Var.C(str);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && this.n == null) {
            if (y) {
                Log.d("UBCBehaviorModel", "BehaviorModel initCache");
            }
            SparseArray<ArrayList> sparseArray = new SparseArray<>();
            this.n = sparseArray;
            this.e.x(sparseArray);
            if (y) {
                Log.d("UBCBehaviorModel", "mIdArray: " + this.n.toString());
            }
            this.o = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.n.size(); i2++) {
                int keyAt = this.n.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                HashMap<String, Long> hashMap = this.o;
                hashMap.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.q.V(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void s(a59 a59Var, boolean z, JSONArray jSONArray) {
        List<n49> b2;
        HashMap<String, String> hashMap;
        ArrayList arrayList;
        String str;
        String str2;
        String str3;
        String str4;
        JSONObject jSONObject;
        String optString;
        String j;
        JSONObject jSONObject2;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{a59Var, Boolean.valueOf(z), jSONArray}) == null) || (b2 = a59Var.b()) == null || b2.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(b2);
        String str5 = "Json格式转化失败";
        String str6 = "1";
        String str7 = "UBCBehaviorModel";
        if (this.e.q() > 0) {
            ArrayList<String> arrayList3 = new ArrayList<>();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(((n49) it.next()).c());
            }
            HashMap<String, String> o = this.e.o(arrayList3);
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                n49 n49Var = (n49) it2.next();
                String c2 = n49Var.c();
                String str8 = o.get(c2);
                if (!TextUtils.isEmpty(str8)) {
                    try {
                        jSONObject = new JSONObject(str8);
                        optString = jSONObject.optString("version");
                        hashMap = o;
                        try {
                            j = n49Var.j();
                            arrayList = arrayList2;
                        } catch (NumberFormatException unused) {
                            arrayList = arrayList2;
                            str2 = str5;
                            str3 = str7;
                            if (y) {
                                Log.d(str3, "数据转换失败");
                            }
                            str5 = str2;
                            str7 = str3;
                            o = hashMap;
                            arrayList2 = arrayList;
                        } catch (JSONException unused2) {
                            arrayList = arrayList2;
                            str = str5;
                            str4 = str7;
                            if (y) {
                                str2 = str;
                                str3 = str4;
                                Log.d(str3, str2);
                                str5 = str2;
                                str7 = str3;
                                o = hashMap;
                                arrayList2 = arrayList;
                            }
                            str2 = str;
                            str3 = str4;
                            str5 = str2;
                            str7 = str3;
                            o = hashMap;
                            arrayList2 = arrayList;
                        }
                    } catch (NumberFormatException unused3) {
                        hashMap = o;
                    } catch (JSONException unused4) {
                        hashMap = o;
                    }
                    try {
                        jSONObject2 = new JSONObject();
                        str = str5;
                        try {
                            str4 = str7;
                        } catch (NumberFormatException unused5) {
                            str3 = str7;
                            str2 = str;
                        } catch (JSONException unused6) {
                            str4 = str7;
                            if (y) {
                            }
                            str2 = str;
                            str3 = str4;
                            str5 = str2;
                            str7 = str3;
                            o = hashMap;
                            arrayList2 = arrayList;
                        }
                    } catch (NumberFormatException unused7) {
                        str2 = str5;
                        str3 = str7;
                        if (y) {
                        }
                        str5 = str2;
                        str7 = str3;
                        o = hashMap;
                        arrayList2 = arrayList;
                    } catch (JSONException unused8) {
                        str = str5;
                        str4 = str7;
                        if (y) {
                        }
                        str2 = str;
                        str3 = str4;
                        str5 = str2;
                        str7 = str3;
                        o = hashMap;
                        arrayList2 = arrayList;
                    }
                    try {
                        z2 = Integer.parseInt(optString) >= Integer.parseInt(j);
                    } catch (NumberFormatException unused9) {
                        str2 = str;
                        str3 = str4;
                        if (y) {
                        }
                        str5 = str2;
                        str7 = str3;
                        o = hashMap;
                        arrayList2 = arrayList;
                    } catch (JSONException unused10) {
                        if (y) {
                        }
                        str2 = str;
                        str3 = str4;
                        str5 = str2;
                        str7 = str3;
                        o = hashMap;
                        arrayList2 = arrayList;
                    }
                    if (z && optString != null && j != null && z2) {
                        it2.remove();
                        jSONObject2.put("product", "set/" + c2);
                        jSONObject2.put("valid", "2");
                        jSONObject2.put("version", j);
                        jSONArray.put(jSONObject2);
                        this.t++;
                        o = hashMap;
                        arrayList2 = arrayList;
                        str5 = str;
                        str7 = str4;
                    } else {
                        if (!TextUtils.equals(jSONObject.optString("dfc"), "1") && n49Var.l()) {
                            it2.remove();
                        }
                        str2 = str;
                        str3 = str4;
                        str5 = str2;
                        str7 = str3;
                        o = hashMap;
                        arrayList2 = arrayList;
                    }
                }
            }
        }
        ArrayList arrayList4 = arrayList2;
        String str9 = str5;
        String str10 = str7;
        boolean D = this.e.D(arrayList4);
        int size = arrayList4.size();
        if (D) {
            this.r += size;
        } else {
            this.s += size;
            str6 = "0";
        }
        Iterator it3 = arrayList4.iterator();
        while (it3.hasNext()) {
            n49 n49Var2 = (n49) it3.next();
            JSONObject jSONObject3 = new JSONObject();
            String c3 = n49Var2.c();
            String j2 = n49Var2.j();
            try {
                jSONObject3.put("product", "set/" + c3);
                jSONObject3.put("version", j2);
                jSONObject3.put("valid", str6);
            } catch (JSONException unused11) {
                if (y) {
                    Log.d(str10, str9);
                }
            }
            jSONArray.put(jSONObject3);
        }
        a59Var.m(arrayList4);
    }

    public void t(r49 r49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, r49Var) == null) {
            boolean equals = TextUtils.equals(r49Var.l(), r49Var.k());
            boolean z = false;
            boolean z2 = this.q.e(r49Var.l()) && (r49Var.n() & 64) == 0;
            boolean z3 = (r49Var.n() & 128) != 0;
            if ((equals && z2) || (equals && z3)) {
                z = true;
            }
            if (f59.i().d()) {
                if (!z) {
                    this.e.z(r49Var);
                    return;
                }
                List<String> j = f59.i().j();
                if (j != null && j.contains(r49Var.l())) {
                    if (!this.c) {
                        if ((System.currentTimeMillis() - this.b) / 1000 >= this.a) {
                            this.c = true;
                        } else {
                            this.e.z(r49Var);
                            return;
                        }
                    }
                } else {
                    this.e.z(r49Var);
                    return;
                }
            }
            if (z) {
                this.e.z(r49Var);
            } else if ((r49Var.n() & 1) == 0) {
                if (this.q.K(r49Var.l())) {
                    g(r49Var);
                }
                if (this.i.size() >= 20) {
                    z();
                }
            } else if (this.q.K(r49Var.l())) {
                this.e.z(r49Var);
            }
            h49.w().I(r49Var, z);
        }
    }

    public void u() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && n59.a(this.d)) {
            if (!k49.o().M() || System.currentTimeMillis() >= k49.o().v()) {
                File file = new File(this.d.getFilesDir() + File.separator + "ubcsenddir");
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    if (listFiles.length > 1000) {
                        if (!y) {
                            h59.a().d(String.valueOf(1000), listFiles.length);
                        }
                        for (File file2 : listFiles) {
                            file2.delete();
                        }
                        this.e.i();
                    }
                    for (int i = 0; i < listFiles.length; i++) {
                        if (y) {
                            Log.d("UBCBehaviorModel", "uploadFailedData fileName:" + listFiles[i].getAbsolutePath());
                        }
                        s49 w = this.e.w(listFiles[i].getName());
                        if (w != null && TextUtils.equals("0", w.b())) {
                            if (y) {
                                Log.d("UBCBehaviorModel", "processFailedData sending, not send again");
                            }
                            e59.b("processFailedData file, no need to send");
                        } else if (w != null && TextUtils.equals("1", w.b())) {
                            e59.b("processFailedData file, send");
                            this.e.G(listFiles[i].getName(), "0");
                            O(w);
                        } else {
                            if (y) {
                                Log.d("UBCBehaviorModel", "processFailedData data in db");
                            }
                            e59.b("processFailedData file, data in db, delete file");
                            listFiles[i].delete();
                        }
                    }
                }
            }
        }
    }

    public void v() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && n59.a(this.d)) {
            File file = new File(this.d.getFilesDir() + File.separator + "ubcsenddir");
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (int i = 0; i < listFiles.length; i++) {
                    s49 w = this.e.w(listFiles[i].getName());
                    if (w != null && TextUtils.equals("1", w.b())) {
                        if (y) {
                            Log.d("UBCBehaviorModel", "processOneFailedData send " + listFiles[i].getAbsolutePath());
                        }
                        e59.b("processOneFailedData file, send");
                        this.e.G(listFiles[i].getName(), "0");
                        O(w);
                        return;
                    }
                }
            }
        }
    }

    public void w(r49 r49Var, boolean z) {
        SparseArray<ArrayList> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048617, this, r49Var, z) == null) {
            if (z) {
                if (!n59.a(this.d) || !j()) {
                    return;
                }
                z();
                p59 h = p59.h(this.d);
                h.L(true);
                if ((r49Var.n() & 128) != 0) {
                    h.C();
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(r49Var.l());
                    sparseArray = new SparseArray<>(1);
                    sparseArray.put(0, arrayList);
                } else {
                    if (this.n == null) {
                        r();
                    }
                    if (Y(h, "0")) {
                        return;
                    }
                    sparseArray = this.n;
                }
                T(sparseArray, h);
                if (h.y()) {
                    return;
                }
                J(h);
                y();
            }
            x();
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            if (f59.i().d()) {
                this.e.e();
            } else if (Math.abs(System.currentTimeMillis() - this.j) >= k49.o().t()) {
                U();
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.m++;
            o59.a().d("ubc_real_time_count", this.m);
        }
    }

    public final void z() {
        List<r49> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || (list = this.i) == null || list.size() == 0) {
            return;
        }
        this.e.A(this.i);
        this.i.clear();
        if (this.g == 1) {
            this.g = 2;
        }
    }
}
