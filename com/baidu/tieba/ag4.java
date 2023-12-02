package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.eh4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class ag4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bg4 a;
    public BlockingQueue<Runnable> b;
    public ThreadPoolExecutor c;
    public mg4 d;
    public final AtomicBoolean e;
    @SuppressLint({"SyntheticAccessor"})
    public final ig4 f;
    public final sg4 g;
    public hg4 h;

    /* loaded from: classes5.dex */
    public class a implements ig4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ag4 a;

        public a(ag4 ag4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ag4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ag4Var;
        }

        @Override // com.baidu.tieba.ig4
        public <T> void a(mg4<T> mg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, mg4Var) != null) {
                return;
            }
            this.a.d = mg4Var;
        }

        @Override // com.baidu.tieba.ig4
        public <T> void b(mg4<T> mg4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mg4Var) != null) || this.a.d != mg4Var) {
                return;
            }
            this.a.d = null;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements hg4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ag4 a;

        public b(ag4 ag4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ag4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ag4Var;
        }

        @Override // com.baidu.tieba.hg4
        public Runnable a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                return this.a.d(z);
            }
            return (Runnable) invokeZ.objValue;
        }
    }

    public ag4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new AtomicBoolean(false);
        this.f = new a(this);
        this.g = new sg4(this.f);
        this.h = new b(this);
        this.a = new bg4();
        this.b = new LinkedBlockingQueue();
        this.c = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, this.b);
        c(this.a);
    }

    public void c(ig4 ig4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ig4Var) == null) {
            this.g.c(ig4Var);
        }
    }

    public synchronized Runnable d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            synchronized (this) {
                if (this.a != null) {
                    if (z) {
                        return this.a.g();
                    }
                    return this.a.i();
                }
                return null;
            }
        }
        return (Runnable) invokeZ.objValue;
    }

    public synchronized <T> void g(mg4<T> mg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mg4Var) == null) {
            synchronized (this) {
                this.a.h(mg4Var);
            }
        }
    }

    public synchronized <T> void h(mg4<T> mg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, mg4Var) == null) {
            synchronized (this) {
                g(mg4Var);
                j();
            }
        }
    }

    public void i(ig4 ig4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ig4Var) == null) {
            this.g.d(ig4Var);
        }
    }

    public synchronized boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            synchronized (this) {
                if (this.d == null) {
                    return false;
                }
                Object f = this.d.f();
                if (f instanceof jf4) {
                    return TextUtils.equals(((jf4) f).g, str);
                }
                if (!(f instanceof eh4.a)) {
                    return false;
                }
                return TextUtils.equals(((eh4.a) f).b, str);
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                Iterator<mg4> f = this.a.f();
                while (f.hasNext()) {
                    mg4 next = f.next();
                    if (next != null) {
                        Object f2 = next.f();
                        if (f2 instanceof jf4) {
                            if (TextUtils.equals(((jf4) f2).g, str)) {
                                return true;
                            }
                        } else if ((f2 instanceof eh4.a) && TextUtils.equals(((eh4.a) f2).b, str)) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                if (this.b.size() < 1) {
                    this.c.execute(new ng4(this.e, this.g, this.h));
                }
            }
        }
    }
}
