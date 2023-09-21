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
/* loaded from: classes5.dex */
public class dq1 extends vp1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dq1 g;
    public transient /* synthetic */ FieldHolder $fh;
    public yp1 c;
    public eq1 d;
    public Context e;
    public int f;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq1 a;

        public a(dq1 dq1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dq1Var;
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
                pq1.d(th);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ dq1 b;

        public b(dq1 dq1Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq1Var, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dq1Var;
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.b.i(false)) {
                        zo1.g(this.b.e).L(this.a);
                    }
                } catch (Throwable th) {
                    pq1.d(th);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq1 a;

        public c(dq1 dq1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dq1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                dq1.c(this.a.e).i(true);
            } catch (Throwable th) {
                pq1.d(th);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dq1(Context context, Handler handler) {
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
        this.c = yp1.a(context);
        this.d = new eq1();
    }

    public static dq1 c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (g == null) {
                synchronized (dq1.class) {
                    if (g == null) {
                        g = new dq1(context, null);
                    }
                }
            }
            return g;
        }
        return (dq1) invokeL.objValue;
    }

    public final JSONArray d(JSONArray jSONArray, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONArray, str)) == null) {
            try {
                jSONArray.put(new JSONObject(str));
            } catch (Throwable th) {
                pq1.d(th);
            }
            return jSONArray;
        }
        return (JSONArray) invokeLL.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            long d0 = zo1.g(this.e).d0();
            long l0 = zo1.g(this.e).l0() * pq1.c;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - d0 < l0 || pq1.h(this.e) == 0 || !pq1.n(this.e)) {
                return;
            }
            cq1.b().post(new b(this, currentTimeMillis));
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    public synchronized void f(String str, String str2, int i) {
        hq1 a2;
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
                gq1.a(this.e).c(a2);
                if (this.f >= 2 && pq1.n(this.e)) {
                    this.f = 0;
                    cq1.b().post(new a(this));
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
                zp1 c2 = aq1.c(aq1.a(), sq1.b(str.getBytes("utf-8")));
                if (c2 == null) {
                    return false;
                }
                String b2 = this.c.b("p/1/r", URLEncoder.encode(Base64.encodeToString(rq1.b(c2.a(), uq1.b(qq1.a(this.e)).getBytes()), 0), "utf-8"));
                if (c2.b() == null) {
                    return false;
                }
                String a2 = a(b2, c2.b());
                if (TextUtils.isEmpty(a2)) {
                    return false;
                }
                try {
                } catch (Throwable th) {
                    pq1.d(th);
                }
                if (new JSONObject(a2).getInt("response") != 1) {
                    return false;
                }
                return true;
            } catch (Throwable th2) {
                pq1.d(th2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean i(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        String str;
        ArrayList<hq1> b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            try {
                int h = pq1.h(this.e);
                if (h == 2) {
                    z2 = false;
                } else {
                    z2 = h == 1 ? true : true;
                    return false;
                }
                if (z) {
                    str = String.valueOf(1);
                } else {
                    str = "1,2";
                }
                if (z2) {
                    b2 = gq1.a(this.e).e(str);
                    String c0 = zo1.g(this.e).c0();
                    String a2 = pq1.a();
                    if (!TextUtils.isEmpty(a2) && !a2.equals(c0)) {
                        zo1.g(this.e).C(a2);
                        zo1.g(this.e).X(0L);
                    }
                } else {
                    b2 = gq1.a(this.e).b(str);
                }
                if (b2 != null && b2.size() != 0) {
                    long o0 = zo1.g(this.e).o0();
                    int size = b2.size();
                    long j0 = zo1.g(this.e).j0() * 1048576;
                    JSONArray jSONArray = new JSONArray();
                    ArrayList<hq1> arrayList = new ArrayList<>();
                    for (int i = 0; i < size; i++) {
                        hq1 hq1Var = b2.get(i);
                        if (hq1Var != null) {
                            String d = hq1Var.d();
                            if (z2) {
                                if (d.length() + o0 > j0) {
                                    break;
                                }
                                o0 += d.length();
                            }
                            d(jSONArray, d);
                            arrayList.add(hq1Var);
                        }
                    }
                    if (jSONArray.length() == 0) {
                        return false;
                    }
                    boolean h2 = h(jSONArray.toString());
                    if (h2) {
                        gq1.a(this.e).d(arrayList);
                        if (z2) {
                            zo1.g(this.e).X(zo1.g(this.e).o0() + jSONArray.toString().length());
                        }
                    }
                    return h2;
                }
                return false;
            } catch (Throwable th) {
                pq1.d(th);
                return false;
            }
        }
        return invokeZ.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || !pq1.n(this.e)) {
            return;
        }
        cq1.b().post(new c(this));
    }
}
