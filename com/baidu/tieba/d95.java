package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class d95<T> extends Thread implements h95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final List<c95<T>> a;
    @Nullable
    public f95<T> b;
    @NonNull
    public final g95<T> c;
    public volatile boolean d;
    public volatile boolean e;
    @Nullable
    public e95<T> f;

    public d95(@NonNull g95<T> g95Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {g95Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = Collections.synchronizedList(new ArrayList());
        this.d = false;
        this.e = false;
        this.c = g95Var;
        e();
    }

    @Override // com.baidu.tieba.h95
    public void a(@Nullable Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, objArr) == null) {
            synchronized (this.a) {
                for (c95<T> c95Var : this.a) {
                    c95Var.a(objArr);
                }
                this.e = false;
                this.d = true;
                this.a.notifyAll();
            }
        }
    }

    public final void b(@NonNull c95<T> c95Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c95Var) == null) {
            synchronized (this.a) {
                Collections.addAll(this.a, c95Var);
            }
        }
    }

    public void d(T t) {
        e95<T> e95Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, t) == null) && (e95Var = this.f) != null) {
            e95Var.a(t);
        }
    }

    public void f(@NonNull f95<T> f95Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, f95Var) == null) {
            synchronized (this.a) {
                this.b = f95Var;
                this.a.notifyAll();
            }
        }
    }

    public void g(@NonNull e95<T> e95Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, e95Var) == null) {
            this.f = e95Var;
        }
    }

    @WorkerThread
    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (c95<T> c95Var : this.a) {
                c95Var.onDestroy();
            }
            this.a.clear();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            start();
        }
    }

    @Override // com.baidu.tieba.h95
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.d = false;
            this.e = true;
            interrupt();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0051, code lost:
        r4 = false;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this.a) {
                while (true) {
                    if (isInterrupted()) {
                        c();
                        break;
                    } else if (this.e) {
                        c();
                        break;
                    } else {
                        if (this.a.size() == 0 || !this.d) {
                            try {
                                this.a.wait();
                            } catch (InterruptedException unused) {
                                c();
                            }
                        }
                        int i = 0;
                        while (true) {
                            z = true;
                            if (i >= this.a.size() || this.a.get(i).a == null) {
                                break;
                            } else if (i == this.a.size() - 1) {
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (z) {
                            if (this.b != null) {
                                this.b.a(this.c.a(this.a));
                            }
                            for (c95<T> c95Var : this.a) {
                                c95Var.a = null;
                                c95Var.onDestroy();
                            }
                            this.a.clear();
                            this.d = false;
                        }
                    }
                }
            }
        }
    }
}
