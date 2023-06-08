package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.dialog.yun.YunTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class a65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final Comparator<YunTask> b;
    public final PriorityBlockingQueue<YunTask> c;

    /* loaded from: classes4.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-993733748, "Lcom/baidu/tieba/a65$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-993733748, "Lcom/baidu/tieba/a65$a;");
                    return;
                }
            }
            int[] iArr = new int[YunTask.Type.values().length];
            iArr[YunTask.Type.DIRECT_EXECUTE.ordinal()] = 1;
            iArr[YunTask.Type.ENQUEUE.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947567145, "Lcom/baidu/tieba/a65;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947567145, "Lcom/baidu/tieba/a65;");
        }
    }

    public a65(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = i;
        this.b = new Comparator() { // from class: com.baidu.tieba.x55
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, obj, obj2)) == null) ? a65.b((YunTask) obj, (YunTask) obj2) : invokeLL.intValue;
            }
        };
        this.c = new PriorityBlockingQueue<>(11, this.b);
    }

    public final void c(YunTask yunTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yunTask) == null) {
            yunTask.b(this);
            this.c.add(yunTask);
            int size = this.c.size();
            int i = this.a;
            if (size > i) {
                int size2 = this.c.size();
                while (i < size2) {
                    YunTask yunTask2 = (YunTask) CollectionsKt___CollectionsKt.elementAt(this.c, i);
                    this.c.remove(yunTask2);
                    yunTask2.g();
                    i++;
                }
            }
            d();
        }
    }

    public static final int b(YunTask yunTask, YunTask yunTask2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, yunTask, yunTask2)) == null) {
            if (yunTask2.f().isExecuting()) {
                return Integer.MAX_VALUE;
            }
            return yunTask2.e() - yunTask.e();
        }
        return invokeLL.intValue;
    }

    public final void a(YunTask task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, task) == null) {
            Intrinsics.checkNotNullParameter(task, "task");
            int i = a.$EnumSwitchMapping$0[task.getType().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    c(task);
                    return;
                }
                return;
            }
            task.c();
        }
    }

    public final void e(YunTask task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, task) == null) {
            Intrinsics.checkNotNullParameter(task, "task");
            this.c.remove(task);
            d();
        }
    }

    public final void d() {
        YunTask peek;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (peek = this.c.peek()) != null && peek.f().isUnStart()) {
            peek.c();
        }
    }
}
