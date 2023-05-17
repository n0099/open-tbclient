package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
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
public class do1 extends vn1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile do1 g;
    public transient /* synthetic */ FieldHolder $fh;
    public yn1 c;
    public eo1 d;
    public Context e;
    public int f;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ do1 a;

        public a(do1 do1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {do1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = do1Var;
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
                po1.d(th);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ do1 b;

        public b(do1 do1Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {do1Var, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = do1Var;
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.b.i(false)) {
                        zm1.g(this.b.e).L(this.a);
                    }
                } catch (Throwable th) {
                    po1.d(th);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ do1 a;

        public c(do1 do1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {do1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = do1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                do1.c(this.a.e).i(true);
            } catch (Throwable th) {
                po1.d(th);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public do1(Context context, Handler handler) {
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
        this.c = yn1.a(context);
        this.d = new eo1();
    }

    public static do1 c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (g == null) {
                synchronized (do1.class) {
                    if (g == null) {
                        g = new do1(context, null);
                    }
                }
            }
            return g;
        }
        return (do1) invokeL.objValue;
    }

    public final JSONArray d(JSONArray jSONArray, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONArray, str)) == null) {
            try {
                jSONArray.put(new JSONObject(str));
            } catch (Throwable th) {
                po1.d(th);
            }
            return jSONArray;
        }
        return (JSONArray) invokeLL.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            long d0 = zm1.g(this.e).d0();
            long l0 = zm1.g(this.e).l0() * po1.c;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - d0 < l0 || po1.h(this.e) == 0 || !po1.n(this.e)) {
                return;
            }
            co1.b().post(new b(this, currentTimeMillis));
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    public synchronized void f(String str, String str2, int i) {
        ho1 a2;
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
                go1.a(this.e).c(a2);
                if (this.f >= 2 && po1.n(this.e)) {
                    this.f = 0;
                    co1.b().post(new a(this));
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
                zn1 c2 = ao1.c(ao1.a(), so1.b(str.getBytes(IMAudioTransRequest.CHARSET)));
                if (c2 == null) {
                    return false;
                }
                String b2 = this.c.b("p/1/r", URLEncoder.encode(Base64.encodeToString(ro1.b(c2.a(), uo1.b(qo1.a(this.e)).getBytes()), 0), IMAudioTransRequest.CHARSET));
                if (c2.b() == null) {
                    return false;
                }
                String a2 = a(b2, c2.b());
                if (TextUtils.isEmpty(a2)) {
                    return false;
                }
                try {
                } catch (Throwable th) {
                    po1.d(th);
                }
                if (new JSONObject(a2).getInt("response") != 1) {
                    return false;
                }
                return true;
            } catch (Throwable th2) {
                po1.d(th2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean i(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        String str;
        ArrayList<ho1> b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            try {
                int h = po1.h(this.e);
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
                    b2 = go1.a(this.e).e(str);
                    String c0 = zm1.g(this.e).c0();
                    String a2 = po1.a();
                    if (!TextUtils.isEmpty(a2) && !a2.equals(c0)) {
                        zm1.g(this.e).C(a2);
                        zm1.g(this.e).X(0L);
                    }
                } else {
                    b2 = go1.a(this.e).b(str);
                }
                if (b2 != null && b2.size() != 0) {
                    long o0 = zm1.g(this.e).o0();
                    int size = b2.size();
                    long j0 = zm1.g(this.e).j0() * 1048576;
                    JSONArray jSONArray = new JSONArray();
                    ArrayList<ho1> arrayList = new ArrayList<>();
                    for (int i = 0; i < size; i++) {
                        ho1 ho1Var = b2.get(i);
                        if (ho1Var != null) {
                            String d = ho1Var.d();
                            if (z2) {
                                if (d.length() + o0 > j0) {
                                    break;
                                }
                                o0 += d.length();
                            }
                            d(jSONArray, d);
                            arrayList.add(ho1Var);
                        }
                    }
                    if (jSONArray.length() == 0) {
                        return false;
                    }
                    boolean h2 = h(jSONArray.toString());
                    if (h2) {
                        go1.a(this.e).d(arrayList);
                        if (z2) {
                            zm1.g(this.e).X(zm1.g(this.e).o0() + jSONArray.toString().length());
                        }
                    }
                    return h2;
                }
                return false;
            } catch (Throwable th) {
                po1.d(th);
                return false;
            }
        }
        return invokeZ.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || !po1.n(this.e)) {
            return;
        }
        co1.b().post(new c(this));
    }
}
