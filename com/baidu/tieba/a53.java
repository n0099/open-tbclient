package com.baidu.tieba;

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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public class a53 implements y43, lw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final ExecutorService e;
    public transient /* synthetic */ FieldHolder $fh;
    public final d63 c;
    public final d63 d;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        public a(a53 a53Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a53Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (y43.b) {
                    try {
                        y43.b.wait(this.a);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Map<Runnable, String> c;
        public boolean d;

        @Override // com.baidu.tieba.d63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.d63
        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "HighPriorityTask" : (String) invokeV.objValue;
        }

        public b(a53 a53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = new ConcurrentHashMap();
            this.d = false;
        }

        @Override // com.baidu.tieba.d63
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.d = false;
                f();
            }
        }

        @Override // com.baidu.tieba.d63
        public void c(@NonNull Runnable runnable, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, runnable, str) == null) {
                if (this.d) {
                    this.c.put(runnable, str);
                } else {
                    bo3.l(runnable, str);
                }
            }
        }

        @Override // com.baidu.tieba.d63
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.d = false;
                long currentTimeMillis = System.currentTimeMillis();
                int size = this.c.size();
                f();
                if (lw2.a) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    Log.d("SwanPerformance", "high task dispatch cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; task num = " + size);
                }
            }
        }

        @Override // com.baidu.tieba.d63
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.d = true;
            }
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || this.c.isEmpty()) {
                return;
            }
            for (Map.Entry<Runnable, String> entry : this.c.entrySet()) {
                if (entry != null) {
                    bo3.l(entry.getKey(), entry.getValue());
                }
            }
            this.c.clear();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements d63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Map<Runnable, String> c;
        public boolean d;
        public final /* synthetic */ a53 e;

        @Override // com.baidu.tieba.d63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.d63
        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "LowPriorityTask" : (String) invokeV.objValue;
        }

        public c(a53 a53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = a53Var;
            this.c = new ConcurrentHashMap();
            this.d = false;
        }

        @Override // com.baidu.tieba.d63
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.d = false;
                f();
            }
        }

        @Override // com.baidu.tieba.d63
        public void c(@NonNull Runnable runnable, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, runnable, str) == null) {
                if (this.d) {
                    this.c.put(runnable, str);
                } else {
                    bo3.l(runnable, str);
                }
            }
        }

        @Override // com.baidu.tieba.d63
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.d = false;
                long currentTimeMillis = System.currentTimeMillis();
                int size = this.c.size();
                f();
                if (lw2.a) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    Log.d("SwanPerformance", "low task dispatch cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; task num = " + size);
                }
                if (i53.e()) {
                    this.e.c();
                }
            }
        }

        @Override // com.baidu.tieba.d63
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.d = true;
                if (i53.e()) {
                    this.e.b(i53.f());
                }
            }
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || this.c.isEmpty()) {
                return;
            }
            for (Map.Entry<Runnable, String> entry : this.c.entrySet()) {
                if (entry != null) {
                    bo3.l(entry.getKey(), entry.getValue());
                }
            }
            this.c.clear();
        }
    }

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final a53 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-994716758, "Lcom/baidu/tieba/a53$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-994716758, "Lcom/baidu/tieba/a53$d;");
                    return;
                }
            }
            a = new a53(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947566122, "Lcom/baidu/tieba/a53;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947566122, "Lcom/baidu/tieba/a53;");
                return;
            }
        }
        e = Executors.newSingleThreadExecutor();
    }

    public a53() {
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
        this.c = new b(this);
        this.d = new c(this);
    }

    public static a53 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return d.a;
        }
        return (a53) invokeV.objValue;
    }

    @Override // com.baidu.tieba.y43
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (lw2.a) {
                Log.d("SwanPerformance", "low priority thread notify");
            }
            synchronized (y43.b) {
                try {
                    y43.b.notifyAll();
                }
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b63.g().i(this.c, 3000);
            b63.g().i(this.d, 5000);
        }
    }

    public /* synthetic */ a53(a aVar) {
        this();
    }

    @Override // com.baidu.tieba.y43
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (lw2.a) {
                Log.d("SwanPerformance", "low priority thread wait = " + i);
            }
            e.execute(new a(this, i));
        }
    }

    public boolean d(@NonNull Runnable runnable, @NonNull String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, runnable, str, z)) == null) {
            if (z) {
                this.c.c(runnable, str);
                return true;
            } else if (i53.e()) {
                e.execute(runnable);
                return true;
            } else {
                this.d.c(runnable, str);
                return true;
            }
        }
        return invokeLLZ.booleanValue;
    }
}
