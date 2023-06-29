package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h40 {
    public static /* synthetic */ Interceptable $ic;
    public static h40 i;
    public transient /* synthetic */ FieldHolder $fh;
    public Thread a;
    public AtomicInteger b;
    public i40 c;
    public r40 d;
    public HashMap<String, String> e;
    public HashMap<String, String> f;
    public p40 g;
    public Context h;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h40 a;

        public a(h40 h40Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h40Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h40Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h40 h40Var = this.a;
                h40Var.c = new m40(h40Var.h);
                if (this.a.g != null) {
                    this.a.g.a(this.a.c.a());
                    z = this.a.g.a();
                } else {
                    z = false;
                }
                if (z && this.a.k()) {
                    this.a.m();
                    this.a.o();
                }
                this.a.a = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static b a;
        public transient /* synthetic */ FieldHolder $fh;

        public b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (context == null) {
                throw new NullPointerException("context should not be null");
            }
            if (h40.i == null) {
                synchronized (h40.class) {
                    if (h40.i == null) {
                        h40 unused = h40.i = new h40(context.getApplicationContext(), null);
                    }
                }
            }
        }

        public static b c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                if (a == null) {
                    synchronized (h40.class) {
                        if (a == null) {
                            a = new b(context);
                        }
                    }
                }
                return a;
            }
            return (b) invokeL.objValue;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h40.i.e = new HashMap();
                h40.i.e.put(BOSTokenRequest.CHARSET, "utf-8");
                h40.i.e.put("Content-type", "application/json");
                h40.i.d = new z40();
            }
        }

        public h40 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (h40.i.d == null) {
                    a();
                }
                return h40.i;
            }
            return (h40) invokeV.objValue;
        }
    }

    public h40(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new AtomicInteger(0);
        new AtomicBoolean(false);
        this.h = context;
        this.g = new w40(context);
    }

    public /* synthetic */ h40(Context context, g40 g40Var) {
        this(context);
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new NullPointerException("url should not be empty");
            }
            HashMap<String, String> hashMap = this.f;
            return hashMap == null ? str : y40.b(str, hashMap);
        }
        return (String) invokeL.objValue;
    }

    public final Runnable h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (Runnable) invokeV.objValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        s40 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String e = e("https://mbd.baidu.com/store");
            r40 r40Var = this.d;
            JSONObject a3 = v40.a((r40Var == null || (a2 = r40Var.a()) == null) ? null : a2.a(e, "POST", this.e, this.c.a()));
            return a3 != null && a3.optInt("errno", -1) == 0;
        }
        return invokeV.booleanValue;
    }

    public final void m() {
        p40 p40Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (p40Var = this.g) == null) {
            return;
        }
        p40Var.b(this.c.a());
    }

    public final void o() {
        AtomicInteger atomicInteger;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (atomicInteger = this.b) == null) {
            return;
        }
        atomicInteger.set(2);
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (h40.class) {
                if (this.b.get() == 0) {
                    if (this.h == null) {
                        throw new NullPointerException("context should not be null");
                    }
                    this.b.set(1);
                    if (this.a == null) {
                        this.a = new Thread(h());
                    }
                    this.a.start();
                }
            }
        }
    }
}
