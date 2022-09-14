package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class cz2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public static volatile cz2 e;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<String, dz2<bz2>> a;
    public ConcurrentHashMap<String, Runnable> b;
    public a c;

    /* loaded from: classes3.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<cz2> a;
        public String b;

        public b(cz2 cz2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cz2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(cz2Var);
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            cz2 cz2Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cz2Var = this.a.get()) == null) {
                return;
            }
            if (cz2.d) {
                Log.d("MDelegate-Observe", "run: observer timeout " + this.b);
            }
            bz2 bz2Var = new bz2(this.b);
            bz2Var.setResult(null);
            cz2Var.c(bz2Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947691982, "Lcom/baidu/tieba/cz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947691982, "Lcom/baidu/tieba/cz2;");
                return;
            }
        }
        d = ij1.a;
    }

    public cz2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentHashMap<>();
        this.b = new ConcurrentHashMap<>();
        this.c = new a(Looper.getMainLooper());
    }

    public static cz2 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (e == null) {
                synchronized (cz2.class) {
                    if (e == null) {
                        e = new cz2();
                    }
                }
            }
            return e;
        }
        return (cz2) invokeV.objValue;
    }

    public void c(@NonNull bz2 bz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bz2Var) == null) {
            dz2<bz2> dz2Var = this.a.get(bz2Var.b());
            if (dz2Var == null) {
                if (d) {
                    Log.e("MDelegate-Observe", "notify a null observer");
                    return;
                }
                return;
            }
            String b2 = dz2Var.b();
            if (d) {
                Log.d("MDelegate-Observe", "notify observer: " + b2);
            }
            dz2Var.onEvent(bz2Var);
            if (this.b.containsKey(b2)) {
                if (d) {
                    Log.d("MDelegate-Observe", "remove observer: " + b2 + " timeout runnable");
                }
                this.c.removeCallbacks(this.b.get(b2));
                this.b.remove(b2);
            }
            if (dz2Var.c()) {
                if (d) {
                    Log.d("MDelegate-Observe", "auto unregister disposable observer: " + b2);
                }
                f(dz2Var);
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (d) {
                Log.d("MDelegate-Observe", "release observable");
            }
            if (e == null) {
                return;
            }
            this.a.clear();
            for (Map.Entry<String, Runnable> entry : this.b.entrySet()) {
                if (d) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.c.removeCallbacks(entry.getValue());
            }
            this.b.clear();
            e = null;
        }
    }

    public void e(dz2<bz2> dz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dz2Var) == null) {
            if (dz2Var == null) {
                if (d) {
                    Log.e("MDelegate-Observe", "register a null observer");
                    return;
                }
                return;
            }
            String b2 = dz2Var.b();
            if (this.a.containsKey(b2)) {
                if (d) {
                    Log.e("MDelegate-Observe", "multiple register observer：" + b2);
                    return;
                }
                return;
            }
            if (d) {
                Log.d("MDelegate-Observe", "register observer: " + b2);
            }
            this.a.put(b2, dz2Var);
            long a2 = dz2Var.a();
            if (a2 <= 0 || !dz2Var.c()) {
                return;
            }
            if (d) {
                Log.d("MDelegate-Observe", "post observer: " + b2 + " " + a2 + "ms timeout runnable");
            }
            b bVar = new b(this, b2);
            this.b.put(b2, bVar);
            this.c.postDelayed(bVar, a2);
        }
    }

    public void f(dz2<bz2> dz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dz2Var) == null) {
            if (dz2Var == null) {
                if (d) {
                    Log.e("MDelegate-Observe", "unregister a null observer");
                    return;
                }
                return;
            }
            String b2 = dz2Var.b();
            if (!this.a.containsKey(b2)) {
                if (d) {
                    Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                    return;
                }
                return;
            }
            if (d) {
                Log.d("MDelegate-Observe", "unregister observer: " + b2);
            }
            this.a.remove(b2);
        }
    }
}
