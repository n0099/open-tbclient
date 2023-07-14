package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class ao2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public static volatile ao2 d;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<zn2> a;
    public yn2 b;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Semaphore a;

        public a(ao2 ao2Var, Semaphore semaphore) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ao2Var, semaphore};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = semaphore;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.release();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947621829, "Lcom/baidu/tieba/ao2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947621829, "Lcom/baidu/tieba/ao2;");
                return;
            }
        }
        c = fs1.a;
    }

    public ao2() {
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
        this.a = new ArrayList<>();
        this.b = new yn2();
    }

    public static ao2 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (ao2.class) {
                    if (d == null) {
                        d = new ao2();
                    }
                }
            }
            return d;
        }
        return (ao2) invokeV.objValue;
    }

    public static synchronized void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            synchronized (ao2.class) {
                if (d != null) {
                    d.f();
                    d = null;
                }
            }
        }
    }

    public final void a(@NonNull zn2 zn2Var, @NonNull ArrayList<zn2> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, zn2Var, arrayList) == null) {
            if (c) {
                Log.i("FileSystemTaskManager", "addToWaitList: " + zn2Var + "," + arrayList.size() + "," + this.a.size());
            }
            Iterator<zn2> it = arrayList.iterator();
            while (it.hasNext()) {
                zn2 next = it.next();
                next.i();
                zn2Var.a(next);
            }
            this.a.add(zn2Var);
        }
    }

    public final zn2 b(@NonNull Semaphore semaphore) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, semaphore)) == null) {
            return new zn2(this, new a(this, semaphore), "JS_WAKE_UP_TASK", null);
        }
        return (zn2) invokeL.objValue;
    }

    public final boolean e(zn2 zn2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, zn2Var)) == null) {
            if (zn2Var != null && "JS_WAKE_UP_TASK".equals(zn2Var.c())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final synchronized boolean c(Semaphore semaphore, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, semaphore, strArr)) == null) {
            synchronized (this) {
                ArrayList<zn2> c2 = this.b.c(strArr);
                if (c2 != null && c2.size() != 0) {
                    a(b(semaphore), c2);
                    return true;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                this.b.b();
                Iterator<zn2> it = this.a.iterator();
                while (it.hasNext()) {
                    zn2 next = it.next();
                    if (e(next)) {
                        next.h();
                    }
                }
                this.a.clear();
            }
        }
    }

    public synchronized void g(zn2 zn2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, zn2Var) == null) {
            synchronized (this) {
                if (zn2Var == null) {
                    return;
                }
                this.b.d(zn2Var, zn2Var.b());
                if (!zn2Var.e()) {
                    return;
                }
                if (c) {
                    Log.i("FileSystemTaskManager", "onTaskComplete: " + zn2Var + "," + this.a.size());
                }
                for (int size = this.a.size() - 1; size >= 0; size--) {
                    zn2 zn2Var2 = this.a.get(size);
                    zn2Var2.g(zn2Var);
                    if (zn2Var2.d()) {
                        this.a.remove(size);
                        zn2Var2.f();
                    }
                }
            }
        }
    }

    public synchronized void h(@NonNull Runnable runnable, String str, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, runnable, str, strArr) == null) {
            synchronized (this) {
                zn2 zn2Var = new zn2(this, runnable, str, strArr);
                ArrayList<zn2> c2 = this.b.c(strArr);
                this.b.a(zn2Var, strArr);
                if (c2 != null && c2.size() != 0) {
                    a(zn2Var, c2);
                }
                zn2Var.f();
            }
        }
    }

    public final void j(Semaphore semaphore) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, semaphore) == null) {
            try {
                semaphore.tryAcquire(10L, TimeUnit.SECONDS);
            } catch (Exception e) {
                if (c) {
                    Log.e("FileSystemTaskManager", "semaphore.acquire: " + e);
                }
            }
        }
    }

    public void k(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, strArr) == null) {
            Semaphore semaphore = new Semaphore(0);
            if (c(semaphore, strArr)) {
                if (c) {
                    Log.i("FileSystemTaskManager", "waitIfHasPathDependence: " + Arrays.toString(strArr));
                }
                j(semaphore);
            }
        }
    }
}
