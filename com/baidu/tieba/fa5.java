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
public class fa5<T> extends Thread implements ja5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final List<ea5<T>> a;
    @Nullable
    public ha5<T> b;
    @NonNull
    public final ia5<T> c;
    public volatile boolean d;
    public volatile boolean e;
    @Nullable
    public ga5<T> f;

    public fa5(@NonNull ia5<T> ia5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ia5Var};
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
        this.c = ia5Var;
        e();
    }

    @Override // com.baidu.tieba.ja5
    public void a(@Nullable Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, objArr) == null) {
            synchronized (this.a) {
                for (ea5<T> ea5Var : this.a) {
                    ea5Var.a(objArr);
                }
                this.e = false;
                this.d = true;
                this.a.notifyAll();
            }
        }
    }

    public final void b(@NonNull ea5<T> ea5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ea5Var) == null) {
            synchronized (this.a) {
                Collections.addAll(this.a, ea5Var);
            }
        }
    }

    public void d(T t) {
        ga5<T> ga5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, t) == null) && (ga5Var = this.f) != null) {
            ga5Var.a(t);
        }
    }

    public void f(@NonNull ha5<T> ha5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ha5Var) == null) {
            synchronized (this.a) {
                this.b = ha5Var;
                this.a.notifyAll();
            }
        }
    }

    public void g(@NonNull ga5<T> ga5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ga5Var) == null) {
            this.f = ga5Var;
        }
    }

    @WorkerThread
    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (ea5<T> ea5Var : this.a) {
                ea5Var.onDestroy();
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

    @Override // com.baidu.tieba.ja5
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
                            for (ea5<T> ea5Var : this.a) {
                                ea5Var.a = null;
                                ea5Var.onDestroy();
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
