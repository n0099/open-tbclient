package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.h55;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.PriorityQueue;
/* loaded from: classes6.dex */
public class i55 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static WeakReference<h55> b;
    public static final PriorityQueue<h55> c;
    public static final Handler d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements h55.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h55 a;
        public final /* synthetic */ List b;
        public final /* synthetic */ int c;

        /* renamed from: com.baidu.tieba.i55$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0331a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0331a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    i55.k(this.a.a);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.a;
                    i55.h(aVar.b, aVar.c + 1);
                }
            }
        }

        public a(h55 h55Var, List list, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h55Var, list, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h55Var;
            this.b = list;
            this.c = i;
        }

        @Override // com.baidu.tieba.h55.a
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    i55.d.post(new RunnableC0331a(this));
                } else {
                    i55.d.post(new b(this));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            boolean unused = i55.a = false;
            WeakReference unused2 = i55.b = null;
            i55.k((h55) i55.c.poll());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947804512, "Lcom/baidu/tieba/i55;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947804512, "Lcom/baidu/tieba/i55;");
                return;
            }
        }
        c = new PriorityQueue<>();
        d = new Handler(Looper.getMainLooper());
    }

    public static void i() {
        h55 h55Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            a = false;
            WeakReference<h55> weakReference = b;
            if (weakReference != null && (h55Var = weakReference.get()) != null) {
                h55Var.b();
            }
            b = null;
            c.clear();
            d.removeCallbacksAndMessages(null);
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            d.postDelayed(new b(), 500L);
        }
    }

    public static void g(List<h55> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, list) == null) {
            h(list, 0);
        }
    }

    public static void h(List<h55> list, int i) {
        h55 h55Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65544, null, list, i) != null) || list == null || list.size() <= i || (h55Var = list.get(i)) == null) {
            return;
        }
        if (h55Var.b != TbadkCoreApplication.getInst().getCurrentActivity()) {
            for (h55 h55Var2 : list) {
                h55Var2.f();
            }
            return;
        }
        h55Var.d(new a(h55Var, list, i));
    }

    public static void k(h55 h55Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65547, null, h55Var) != null) || h55Var == null) {
            return;
        }
        if (h55Var.b != TbadkCoreApplication.getInst().getCurrentActivity()) {
            h55Var.f();
            if (!a) {
                j();
            }
        } else if (a) {
            c.offer(h55Var);
        } else {
            a = true;
            h55Var.e();
            b = new WeakReference<>(h55Var);
        }
    }
}
