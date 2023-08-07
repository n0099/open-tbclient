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
import com.baidu.tieba.cw5;
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
/* loaded from: classes5.dex */
public class PriorityOrganizer implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_INITIAL_CAPACITY = 11;
    public transient /* synthetic */ FieldHolder $fh;
    public final Comparator<Task> comparator;
    public int executedTaskCount;
    @NonNull
    public final Handler handler;
    public final int oncePageExecuteTaskCount;
    public final PriorityBlockingQueue<Task> queue;
    @NonNull
    public final Timer timer;
    public final ConcurrentHashMap<String, List<Task>> waitingTasks;

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class Task {
        public static /* synthetic */ Interceptable $ic;
        public static int taskInitNumber;
        public transient /* synthetic */ FieldHolder $fh;
        public long autoFinishTime;
        public long executeDelayTime;
        @NonNull
        public String name;
        @Nullable
        public Task next;
        @Nullable
        public PriorityOrganizer organizer;
        @Nullable
        public Task prev;
        @IntRange(from = 0, to = 100)
        public int priority;
        @NonNull
        public Status status;
        @NonNull
        public final List<TimerTask> timerTaskList;
        @Nullable
        public String waitTaskName;
        public long waitTaskTimeout;

        public boolean isDataReady() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public abstract boolean isNeedExecute();

        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            }
        }

        public abstract void onExecute();

        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            }
        }

        public void onReset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes5.dex */
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
                if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                    return (Status) Enum.valueOf(Status.class, str);
                }
                return (Status) invokeL.objValue;
            }

            public static Status[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                    return (Status[]) $VALUES.clone();
                }
                return (Status[]) invokeV.objValue;
            }

            public boolean isCanceled() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    if (this == CANCELED) {
                        return true;
                    }
                    return false;
                }
                return invokeV.booleanValue;
            }

            public boolean isExecuting() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    if (this == EXECUTING) {
                        return true;
                    }
                    return false;
                }
                return invokeV.booleanValue;
            }

            public boolean isFinished() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    if (this == FINISHED) {
                        return true;
                    }
                    return false;
                }
                return invokeV.booleanValue;
            }

            public boolean isUnStart() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                    if (this == UN_START) {
                        return true;
                    }
                    return false;
                }
                return invokeV.booleanValue;
            }
        }

        /* loaded from: classes5.dex */
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
                    this.a.delayExecute();
                }
            }
        }

        /* loaded from: classes5.dex */
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
                    this.a.finish();
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
            this.priority = 50;
            this.status = Status.UN_START;
            this.timerTaskList = new ArrayList();
            this.name = getClass().getSimpleName() + "-" + nextTaskNum();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void attachOrganizer(@NonNull PriorityOrganizer priorityOrganizer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65551, this, priorityOrganizer) == null) {
                this.organizer = priorityOrganizer;
            }
        }

        public static void reset(@NonNull Task task) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65556, null, task) == null) {
                task.cancel();
                task.onReset();
                task.status = Status.UN_START;
                task.organizer = null;
            }
        }

        public boolean isExecuting(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                if (z) {
                    for (Task task = this; task != null; task = task.next) {
                        if (task.status.isExecuting()) {
                            return true;
                        }
                    }
                    return false;
                }
                return this.status.isExecuting();
            }
            return invokeZ.booleanValue;
        }

        public void setAutoFinishTime(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
                this.autoFinishTime = j;
            }
        }

        public void setExecuteDelayTime(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
                this.executeDelayTime = j;
            }
        }

        public void setName(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
                this.name = str;
            }
        }

        public void setPriority(@IntRange(from = 0, to = 100) int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
                this.priority = i;
            }
        }

        public void setWaitTask(@Nullable String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048594, this, str, j) == null) {
                this.waitTaskName = str;
                this.waitTaskTimeout = j;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cancelTimerTaskList() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65552, this) == null) {
                for (TimerTask timerTask : this.timerTaskList) {
                    timerTask.cancel();
                }
                this.timerTaskList.clear();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void delayExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65553, this) == null) {
                onExecute();
                if (this.autoFinishTime > 0) {
                    this.timerTaskList.add(requireOrganizer().schedule(new b(this), this.autoFinishTime));
                }
            }
        }

        public static synchronized int nextTaskNum() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
                synchronized (Task.class) {
                    i = taskInitNumber;
                    taskInitNumber = i + 1;
                }
                return i;
            }
            return invokeV.intValue;
        }

        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.status = Status.CANCELED;
                cancelTimerTaskList();
                onCancel();
                PriorityOrganizer priorityOrganizer = this.organizer;
                if (priorityOrganizer != null) {
                    priorityOrganizer.remove(this);
                }
            }
        }

        public void finish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.status = Status.FINISHED;
                cancelTimerTaskList();
                onFinish();
                requireOrganizer().remove(this);
            }
        }

        @NonNull
        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.name;
            }
            return (String) invokeV.objValue;
        }

        @Nullable
        public PriorityOrganizer getOrganizer() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.organizer;
            }
            return (PriorityOrganizer) invokeV.objValue;
        }

        @NonNull
        public Status getStatus() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.status;
            }
            return (Status) invokeV.objValue;
        }

        @NonNull
        public PriorityOrganizer requireOrganizer() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                if (this.organizer != null) {
                    z = true;
                } else {
                    z = false;
                }
                cw5.e(z, "任务需先添加到 PriorityOrganizer");
                return this.organizer;
            }
            return (PriorityOrganizer) invokeV.objValue;
        }

        public void tryReAddToOrganizer() {
            PriorityOrganizer priorityOrganizer;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (priorityOrganizer = this.organizer) != null) {
                priorityOrganizer.tryAdd(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void execute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65554, this) == null) {
                this.status = Status.EXECUTING;
                if (this.executeDelayTime > 0) {
                    this.timerTaskList.add(requireOrganizer().schedule(new a(this), this.executeDelayTime));
                } else {
                    delayExecute();
                }
            }
        }

        public void reset(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
                if (z) {
                    for (Task task = this; task != null; task = task.next) {
                        reset(task);
                    }
                    return;
                }
                reset(this);
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                return "Task{name='" + this.name + "', priority=" + this.priority + ", autoFinishTime=" + this.autoFinishTime + ", executeDelayTime=" + this.executeDelayTime + ", waitTaskName=" + this.waitTaskName + ", waitTaskTimeout=" + this.waitTaskTimeout + ", status=" + this.status + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
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
                if (task2.status.isExecuting()) {
                    return Integer.MAX_VALUE;
                }
                return task2.priority - task.priority;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
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
                List list = (List) this.b.waitingTasks.get(this.a.waitTaskName);
                if (list != null) {
                    list.remove(this.a);
                }
                this.b.doTryAdd(this.a, true);
            }
        }
    }

    /* loaded from: classes5.dex */
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
                this.b.handler.post(this.a);
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
        this.comparator = new a(this);
        this.queue = new PriorityBlockingQueue<>(11, this.comparator);
        this.waitingTasks = new ConcurrentHashMap<>();
        this.timer = new Timer();
        this.handler = new Handler(Looper.getMainLooper());
        this.executedTaskCount = 0;
        this.oncePageExecuteTaskCount = i;
    }

    public void tryAdd(@NonNull Task task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, task) == null) {
            if (task.waitTaskTimeout > 0) {
                if (task.waitTaskName != null) {
                    List<Task> list = this.waitingTasks.get(task.waitTaskName);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    if (!list.contains(task)) {
                        list.add(task);
                        this.waitingTasks.put(task.waitTaskName, list);
                    }
                }
                task.timerTaskList.add(schedule(new b(this, task), task.waitTaskTimeout));
                return;
            }
            doTryAdd(task, true);
        }
    }

    private void addTaskInTheList(@NonNull List<Task> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, list) == null) {
            for (Task task : list) {
                task.cancelTimerTaskList();
                doTryAdd(task, false);
            }
        }
    }

    @NonNull
    public static PriorityOrganizer create(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i)) == null) {
            return new PriorityOrganizer(i);
        }
        return (PriorityOrganizer) invokeI.objValue;
    }

    private Task getChainHead(@NonNull Task task) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, task)) == null) {
            while (task.prev != null) {
                task = task.prev;
            }
            return task;
        }
        return (Task) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void remove(@NonNull Task task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, task) == null) {
            this.queue.remove(task);
            executeNext();
        }
    }

    public static Task makeChain(@NonNull Task task, @NonNull Task... taskArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, task, taskArr)) == null) {
            Task task2 = task;
            for (Task task3 : taskArr) {
                task3.prev = task2;
                task2.next = task3;
                task2 = task2.next;
            }
            return task;
        }
        return (Task) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public TimerTask schedule(@NonNull Runnable runnable, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65552, this, runnable, j)) == null) {
            c cVar = new c(this, runnable);
            this.timer.schedule(cVar, j);
            return cVar;
        }
        return (TimerTask) invokeLJ.objValue;
    }

    @NonNull
    public static PriorityOrganizer create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return new PriorityOrganizer(Integer.MAX_VALUE);
        }
        return (PriorityOrganizer) invokeV.objValue;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.executedTaskCount = 0;
            executeNext();
        }
    }

    public boolean hasDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.executedTaskCount <= 0 && this.queue.size() <= 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doTryAdd(@NonNull Task task, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65545, this, task, z) == null) {
            Task task2 = task.prev;
            if (task2 != null) {
                if (!this.queue.contains(task2) && task2.isDataReady()) {
                    if (task2.status.isUnStart() && task2.isNeedExecute()) {
                        return;
                    }
                } else {
                    return;
                }
            }
            String str = getChainHead(task).name;
            while (task != null) {
                task.attachOrganizer(this);
                if (!this.queue.contains(task) && task.isDataReady()) {
                    if (!task.status.isUnStart() || !task.isNeedExecute()) {
                        task = task.next;
                    } else {
                        this.queue.add(task);
                        List<Task> remove = this.waitingTasks.remove(str);
                        if (remove != null) {
                            addTaskInTheList(remove);
                        }
                        List<Task> remove2 = this.waitingTasks.remove(task.name);
                        if (remove2 != null) {
                            addTaskInTheList(remove2);
                        }
                        if (z) {
                            executeNext();
                            return;
                        }
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void executeNext() {
        Task peek;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, this) == null) && this.executedTaskCount < this.oncePageExecuteTaskCount && (peek = this.queue.peek()) != null && peek.status.isUnStart()) {
            this.executedTaskCount++;
            peek.execute();
        }
    }
}
