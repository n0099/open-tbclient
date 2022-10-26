package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.fv4;
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
/* loaded from: classes4.dex */
public class gv4 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static WeakReference b;
    public static final PriorityQueue c;
    public static final Handler d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public final class a implements fv4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv4 a;
        public final /* synthetic */ List b;
        public final /* synthetic */ int c;

        /* renamed from: com.baidu.tieba.gv4$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0258a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0258a(a aVar) {
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
                    gv4.k(this.a.a);
                }
            }
        }

        /* loaded from: classes4.dex */
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
                    gv4.h(aVar.b, aVar.c + 1);
                }
            }
        }

        public a(fv4 fv4Var, List list, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv4Var, list, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fv4Var;
            this.b = list;
            this.c = i;
        }

        @Override // com.baidu.tieba.fv4.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    gv4.d.post(new RunnableC0258a(this));
                } else {
                    gv4.d.post(new b(this));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public final class b implements Runnable {
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
            boolean unused = gv4.a = false;
            WeakReference unused2 = gv4.b = null;
            gv4.k((fv4) gv4.c.poll());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947807364, "Lcom/baidu/tieba/gv4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947807364, "Lcom/baidu/tieba/gv4;");
                return;
            }
        }
        c = new PriorityQueue();
        d = new Handler(Looper.getMainLooper());
    }

    public static void i() {
        fv4 fv4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            a = false;
            WeakReference weakReference = b;
            if (weakReference != null && (fv4Var = (fv4) weakReference.get()) != null) {
                fv4Var.b();
            }
            b = null;
            c.clear();
            d.removeCallbacksAndMessages(null);
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            d.post(new b());
        }
    }

    public static void g(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, list) == null) {
            h(list, 0);
        }
    }

    public static void h(List list, int i) {
        fv4 fv4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65544, null, list, i) != null) || list == null || list.size() <= i || (fv4Var = (fv4) list.get(i)) == null || fv4Var.b != TbadkCoreApplication.getInst().getCurrentActivity()) {
            return;
        }
        fv4Var.d(new a(fv4Var, list, i));
    }

    public static void k(fv4 fv4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65547, null, fv4Var) != null) || fv4Var == null) {
            return;
        }
        if (fv4Var.b != TbadkCoreApplication.getInst().getCurrentActivity()) {
            if (!a) {
                j();
            }
        } else if (a) {
            c.offer(fv4Var);
        } else {
            a = true;
            fv4Var.e();
            b = new WeakReference(fv4Var);
        }
    }
}
