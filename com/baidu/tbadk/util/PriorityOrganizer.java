package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.bf5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;
/* loaded from: classes3.dex */
public class PriorityOrganizer implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Comparator<Task> a;
    public final PriorityBlockingQueue<Task> b;
    public final ConcurrentHashMap<String, List<Task>> c;
    @NonNull
    public final Timer d;
    @NonNull
    public final Handler e;
    public final int f;
    public int g;

    /* loaded from: classes3.dex */
    public static abstract class Task {
        public static /* synthetic */ Interceptable $ic;
        public static int l;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public String a;
        @Nullable
        public PriorityOrganizer b;
        @IntRange(from = 0, to = 100)
        public int c;
        public long d;
        public long e;
        @Nullable
        public String f;
        public long g;
        @NonNull
        public Status h;
        @NonNull
        public final List<TimerTask> i;
        @Nullable
        public Task j;
        @Nullable
        public Task k;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes3.dex */
        public static final class Status {
            public static final /* synthetic */ Status[] $VALUES;
            public static /* synthetic */ Interceptable $ic;
            public static final Status CANCELED;
            public static final Status EXECUTING;
            public static final Status FINISHED;
            public static final Status UN_START;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-470913811, "Lcom/baidu/tbadk/util/PriorityOrganizer$Task$Status;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-470913811, "Lcom/baidu/tbadk/util/PriorityOrganizer$Task$Status;");
                        return;
                    }
                }
                UN_START = new Status("UN_START", 0);
                EXECUTING = new Status("EXECUTING", 1);
                CANCELED = new Status("CANCELED", 2);
                Status status = new Status("FINISHED", 3);
                FINISHED = status;
                $VALUES = new Status[]{UN_START, EXECUTING, CANCELED, status};
            }

            public Status(String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        String str2 = (String) objArr2[0];
                        ((Integer) objArr2[1]).intValue();
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }

            public static Status valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Status) Enum.valueOf(Status.class, str) : (Status) invokeL.objValue;
            }

            public static Status[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Status[]) $VALUES.clone() : (Status[]) invokeV.objValue;
            }

            public boolean isCanceled() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this == CANCELED : invokeV.booleanValue;
            }

            public boolean isExecuting() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this == EXECUTING : invokeV.booleanValue;
            }

            public boolean isFinished() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this == FINISHED : invokeV.booleanValue;
            }

            public boolean isUnStart() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this == UN_START : invokeV.booleanValue;
            }
        }

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Task a;

            public a(Task task) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {task};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = task;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.s();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Task a;

            public b(Task task) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {task};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = task;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.u();
                }
            }
        }

        public Task() {
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
            this.c = 50;
            this.h = Status.UN_START;
            this.i = new ArrayList();
            this.a = getClass().getSimpleName() + "-" + y();
        }

        public static void E(@NonNull Task task) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, null, task) == null) {
                task.q();
                task.C();
                task.h = Status.UN_START;
                task.b = null;
            }
        }

        public static synchronized int y() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
                synchronized (Task.class) {
                    i = l;
                    l = i + 1;
                }
                return i;
            }
            return invokeV.intValue;
        }

        public abstract void A();

        public void B() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public void C() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @NonNull
        public PriorityOrganizer D() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                bf5.d(this.b != null, "任务需先添加到 PriorityOrganizer");
                return this.b;
            }
            return (PriorityOrganizer) invokeV.objValue;
        }

        public void F(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
                if (!z) {
                    E(this);
                    return;
                }
                for (Task task = this; task != null; task = task.k) {
                    E(task);
                }
            }
        }

        public void G() {
            PriorityOrganizer priorityOrganizer;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (priorityOrganizer = this.b) == null) {
                return;
            }
            priorityOrganizer.u(this);
        }

        public final void p(@NonNull PriorityOrganizer priorityOrganizer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, priorityOrganizer) == null) {
                this.b = priorityOrganizer;
            }
        }

        public void q() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.h = Status.CANCELED;
                r();
                z();
                PriorityOrganizer priorityOrganizer = this.b;
                if (priorityOrganizer != null) {
                    priorityOrganizer.s(this);
                }
            }
        }

        public final void r() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                for (TimerTask timerTask : this.i) {
                    timerTask.cancel();
                }
                this.i.clear();
            }
        }

        public final void s() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                A();
                if (this.d > 0) {
                    this.i.add(D().t(new b(this), this.d));
                }
            }
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                this.h = Status.EXECUTING;
                if (this.e > 0) {
                    this.i.add(D().t(new a(this), this.e));
                } else {
                    s();
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return "Task{name='" + this.a + "', priority=" + this.c + ", autoFinishTime=" + this.d + ", executeDelayTime=" + this.e + ", waitTaskName=" + this.f + ", waitTaskTimeout=" + this.g + ", status=" + this.h + '}';
            }
            return (String) invokeV.objValue;
        }

        public void u() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
                this.h = Status.FINISHED;
                r();
                B();
                D().s(this);
            }
        }

        public boolean v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public boolean w(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
                if (z) {
                    for (Task task = this; task != null; task = task.k) {
                        if (task.h.isExecuting()) {
                            return true;
                        }
                    }
                    return false;
                }
                return this.h.isExecuting();
            }
            return invokeZ.booleanValue;
        }

        public abstract boolean x();

        public void z() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Comparator<Task> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(PriorityOrganizer priorityOrganizer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {priorityOrganizer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Task task, Task task2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, task, task2)) == null) {
                if (task2.h.isExecuting()) {
                    return Integer.MAX_VALUE;
                }
                return task2.c - task.c;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Task a;
        public final /* synthetic */ PriorityOrganizer b;

        public b(PriorityOrganizer priorityOrganizer, Task task) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {priorityOrganizer, task};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = priorityOrganizer;
            this.a = task;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                List list = (List) this.b.c.get(this.a.f);
                if (list != null) {
                    list.remove(this.a);
                }
                this.b.o(this.a, true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Runnable a;
        public final /* synthetic */ PriorityOrganizer b;

        public c(PriorityOrganizer priorityOrganizer, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {priorityOrganizer, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = priorityOrganizer;
            this.a = runnable;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.e.post(this.a);
            }
        }
    }

    public PriorityOrganizer(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new a(this);
        this.b = new PriorityBlockingQueue<>(11, this.a);
        this.c = new ConcurrentHashMap<>();
        this.d = new Timer();
        this.e = new Handler(Looper.getMainLooper());
        this.g = 0;
        this.f = i;
    }

    @NonNull
    public static PriorityOrganizer n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? new PriorityOrganizer(Integer.MAX_VALUE) : (PriorityOrganizer) invokeV.objValue;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.g = 0;
            p();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
        }
    }

    public static void r(@NonNull Task task, @NonNull Task... taskArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, task, taskArr) == null) {
            for (Task task2 : taskArr) {
                task2.j = task;
                task.k = task2;
                task = task.k;
            }
        }
    }

    public final void m(@NonNull List<Task> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            for (Task task : list) {
                task.r();
                o(task, false);
            }
        }
    }

    public final void o(@NonNull Task task, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, task, z) == null) {
            Task task2 = task.j;
            if (task2 != null) {
                if (this.b.contains(task2) || !task2.v()) {
                    return;
                }
                if (task2.h.isUnStart() && task2.x()) {
                    return;
                }
            }
            String str = q(task).a;
            while (task != null) {
                task.p(this);
                if (this.b.contains(task) || !task.v()) {
                    return;
                }
                if (!task.h.isUnStart() || !task.x()) {
                    task = task.k;
                } else {
                    this.b.add(task);
                    List<Task> remove = this.c.remove(str);
                    if (remove != null) {
                        m(remove);
                    }
                    List<Task> remove2 = this.c.remove(task.a);
                    if (remove2 != null) {
                        m(remove2);
                    }
                    if (z) {
                        p();
                        return;
                    }
                    return;
                }
            }
        }
    }

    public final void p() {
        Task peek;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.g >= this.f || (peek = this.b.peek()) == null || !peek.h.isUnStart()) {
            return;
        }
        this.g++;
        peek.t();
    }

    public final Task q(@NonNull Task task) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, task)) == null) {
            while (task.j != null) {
                task = task.j;
            }
            return task;
        }
        return (Task) invokeL.objValue;
    }

    public final void s(@NonNull Task task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, task) == null) {
            this.b.remove(task);
            p();
        }
    }

    @NonNull
    public final TimerTask t(@NonNull Runnable runnable, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048581, this, runnable, j)) == null) {
            c cVar = new c(this, runnable);
            this.d.schedule(cVar, j);
            return cVar;
        }
        return (TimerTask) invokeLJ.objValue;
    }

    public void u(@NonNull Task task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, task) == null) {
            if (task.g > 0) {
                if (task.f != null) {
                    List<Task> list = this.c.get(task.f);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    if (!list.contains(task)) {
                        list.add(task);
                        this.c.put(task.f, list);
                    }
                }
                task.i.add(t(new b(this, task), task.g));
                return;
            }
            o(task, true);
        }
    }
}
