package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d61 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public final long b;
    public long c;
    public long d;
    public boolean e;
    public boolean f;
    public boolean g;
    public c h;
    @SuppressLint({"HandlerLeak"})
    public Handler i;

    /* loaded from: classes5.dex */
    public class a extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(d61 d61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.d61.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.e();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d61 a;

        public b(d61 d61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d61Var;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, message) != null) {
                return;
            }
            this.a.c(message);
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        public void f(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            }
        }

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
                }
            }
        }
    }

    public d61(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = false;
        this.f = true;
        this.g = false;
        this.h = new a(this);
        this.i = new b(this);
        this.a = j;
        this.b = j2;
    }

    public final synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                this.e = true;
                this.i.removeMessages(1);
                this.h.a();
            }
        }
    }

    public final void c(Message message) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
            synchronized (this) {
                if (!this.e && !this.f) {
                    long elapsedRealtime = this.c - SystemClock.elapsedRealtime();
                    long j2 = 0;
                    if (elapsedRealtime <= 0) {
                        this.g = true;
                        this.h.b();
                    } else {
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        this.h.f(elapsedRealtime);
                        long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime2;
                        if (elapsedRealtime < this.b) {
                            j = elapsedRealtime - elapsedRealtime3;
                            if (j < 0) {
                                this.i.sendMessageDelayed(this.i.obtainMessage(1), j2);
                            }
                        } else {
                            j = this.b - elapsedRealtime3;
                            while (j < 0) {
                                j += this.b;
                            }
                        }
                        j2 = j;
                        this.i.sendMessageDelayed(this.i.obtainMessage(1), j2);
                    }
                }
            }
        }
    }

    public final synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (!this.f && !this.e && !this.g) {
                    this.d = SystemClock.elapsedRealtime();
                    this.f = true;
                    this.h.c();
                    this.i.removeMessages(1);
                }
            }
        }
    }

    public final synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                if (this.f && !this.e && !this.g) {
                    this.f = false;
                    this.c = SystemClock.elapsedRealtime() + (this.c - this.d);
                    this.h.d();
                    this.i.sendMessage(this.i.obtainMessage(1));
                }
            }
        }
    }

    public d61 f(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cVar)) == null) {
            if (cVar != null) {
                this.h = cVar;
            }
            return this;
        }
        return (d61) invokeL.objValue;
    }

    public final synchronized d61 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                this.e = false;
                if (this.a <= 0) {
                    this.g = true;
                    this.h.b();
                    return this;
                }
                this.g = false;
                this.f = false;
                this.c = SystemClock.elapsedRealtime() + this.a;
                this.i.sendMessage(this.i.obtainMessage(1));
                this.h.e();
                return this;
            }
        }
        return (d61) invokeV.objValue;
    }
}
