package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.tblauncher.MainTabScheduleStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.PriorityQueue;
/* loaded from: classes3.dex */
public class aq8 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static MainTabScheduleStrategy b;
    public static boolean c;
    public static final PriorityQueue d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                aq8.d();
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                aq8.d();
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gq8 a;

        public c(gq8 gq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gq8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947623937, "Lcom/baidu/tieba/aq8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947623937, "Lcom/baidu/tieba/aq8;");
                return;
            }
        }
        b = MainTabScheduleStrategy.FLUSHING;
        c = false;
        d = new PriorityQueue();
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            while (!d.isEmpty()) {
                gq8 gq8Var = (gq8) d.poll();
                if (gq8Var != null) {
                    gq8Var.b();
                    gq8Var.c();
                }
            }
        }
    }

    public static void b(MainTabScheduleStrategy mainTabScheduleStrategy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, mainTabScheduleStrategy) == null) {
            b = mainTabScheduleStrategy;
            if (mainTabScheduleStrategy != MainTabScheduleStrategy.UNSCHEDULE && !c) {
                g(true);
            }
        }
    }

    public static void c(gq8 gq8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, gq8Var) == null) {
            System.nanoTime();
            gq8Var.b();
            hh.a().postAtFrontOfQueue(new c(gq8Var));
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            c = false;
            if (d.isEmpty() || b == MainTabScheduleStrategy.UNSCHEDULE) {
                return;
            }
            if (b == MainTabScheduleStrategy.FLUSHING) {
                e();
                return;
            }
            if (d.peek() != null && a >= ((gq8) d.peek()).a) {
                gq8 gq8Var = (gq8) d.poll();
                if (gq8Var == null) {
                    return;
                }
                c(gq8Var);
            }
            if (b == MainTabScheduleStrategy.SCHEDULE) {
                g(false);
            }
        }
    }

    public static void f(gq8 gq8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, gq8Var) != null) || gq8Var == null) {
            return;
        }
        if (b == MainTabScheduleStrategy.FLUSHING) {
            if (!(gq8Var instanceof hq8)) {
                gq8Var.d();
                gq8Var.b();
            }
            gq8Var.c();
            return;
        }
        gq8Var.d();
        d.add(gq8Var);
        if (b != MainTabScheduleStrategy.UNSCHEDULE && !c) {
            g(false);
        }
    }

    public static void g(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(65543, null, z) != null) || c) {
            return;
        }
        c = true;
        if (z) {
            hh.a().postAtFrontOfQueue(new a());
        } else {
            hh.a().post(new b());
        }
    }
}
