package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class cj1 extends wi1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cj1 g;
    public transient /* synthetic */ FieldHolder $fh;
    public zi1 c;
    public dj1 d;
    public Context e;
    public int f;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cj1 a;

        public a(cj1 cj1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cj1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cj1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                this.a.i(true);
            } catch (Throwable th) {
                oj1.d(th);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ cj1 b;

        public b(cj1 cj1Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cj1Var, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cj1Var;
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.b.i(false)) {
                        ci1.f(this.b.e).F(this.a);
                    }
                } catch (Throwable th) {
                    oj1.d(th);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cj1 a;

        public c(cj1 cj1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cj1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cj1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                cj1.c(this.a.e).i(true);
            } catch (Throwable th) {
                oj1.d(th);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cj1(Context context, Handler handler) {
        super(context, handler);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (Handler) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = 0;
        this.e = context;
        this.c = zi1.a(context);
        this.d = new dj1();
    }

    public static cj1 c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (g == null) {
                synchronized (cj1.class) {
                    if (g == null) {
                        g = new cj1(context, null);
                    }
                }
            }
            return g;
        }
        return (cj1) invokeL.objValue;
    }

    public final JSONArray d(JSONArray jSONArray, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONArray, str)) == null) {
            try {
                jSONArray.put(new JSONObject(str));
            } catch (Throwable th) {
                oj1.d(th);
            }
            return jSONArray;
        }
        return (JSONArray) invokeLL.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            long c0 = ci1.f(this.e).c0();
            long j0 = ci1.f(this.e).j0() * oj1.e;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - c0 < j0 || oj1.j(this.e) == 0 || !oj1.n(this.e)) {
                return;
            }
            bj1.a().post(new b(this, currentTimeMillis));
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    public synchronized void f(String str, String str2, int i) {
        gj1 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, str2, i) == null) {
            synchronized (this) {
                try {
                    a2 = this.d.a(this.e, str, str2, i, 1);
                } finally {
                }
                if (a2 == null) {
                    return;
                }
                this.f++;
                fj1.a(this.e).c(a2);
                if (this.f >= 2 && oj1.n(this.e)) {
                    this.f = 0;
                    bj1.a().post(new a(this));
                }
            }
        }
    }

    public final boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                byte[] bytes = sj1.b(pj1.a(this.e)).getBytes();
                byte[] f = oj1.f();
                String b2 = this.c.b("p/1/r", URLEncoder.encode(Base64.encodeToString(qj1.h(f, bytes), 0)));
                byte[] e = this.c.e(f, str);
                if (e == null) {
                    return false;
                }
                String a2 = a(b2, e);
                if (TextUtils.isEmpty(a2)) {
                    return false;
                }
                try {
                } catch (Throwable th) {
                    oj1.d(th);
                }
                if (new JSONObject(a2).getInt("response") != 1) {
                    return false;
                }
                return true;
            } catch (Throwable th2) {
                oj1.d(th2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean i(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        String str;
        ArrayList<gj1> b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            try {
                int j = oj1.j(this.e);
                if (j == 2) {
                    z2 = false;
                } else {
                    z2 = j == 1 ? true : true;
                    return false;
                }
                if (z) {
                    str = String.valueOf(1);
                } else {
                    str = "1,2";
                }
                if (z2) {
                    b2 = fj1.a(this.e).e(str);
                    String b0 = ci1.f(this.e).b0();
                    String a2 = oj1.a();
                    if (!TextUtils.isEmpty(a2) && !a2.equals(b0)) {
                        ci1.f(this.e).G(a2);
                        ci1.f(this.e).U(0L);
                    }
                } else {
                    b2 = fj1.a(this.e).b(str);
                }
                if (b2 != null && b2.size() != 0) {
                    long n0 = ci1.f(this.e).n0();
                    int size = b2.size();
                    long h0 = ci1.f(this.e).h0() * 1048576;
                    JSONArray jSONArray = new JSONArray();
                    ArrayList<gj1> arrayList = new ArrayList<>();
                    for (int i = 0; i < size; i++) {
                        gj1 gj1Var = b2.get(i);
                        if (gj1Var != null) {
                            String d = gj1Var.d();
                            if (z2) {
                                if (d.length() + n0 > h0) {
                                    break;
                                }
                                n0 += d.length();
                            }
                            d(jSONArray, d);
                            arrayList.add(gj1Var);
                        }
                    }
                    if (jSONArray.length() == 0) {
                        return false;
                    }
                    boolean h = h(jSONArray.toString());
                    if (h) {
                        fj1.a(this.e).d(arrayList);
                        if (z2) {
                            ci1.f(this.e).U(ci1.f(this.e).n0() + jSONArray.toString().length());
                        }
                    }
                    return h;
                }
                return false;
            } catch (Throwable th) {
                oj1.d(th);
                return false;
            }
        }
        return invokeZ.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || !oj1.n(this.e)) {
            return;
        }
        bj1.a().post(new c(this));
    }
}
