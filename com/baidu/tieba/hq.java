package com.baidu.tieba;

import androidx.annotation.CallSuper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.component.buoy.TaskBuoyViewData;
import com.baidu.bdtask.component.buoy.TaskBuoyViewModel;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class hq extends lt<TaskBuoyViewData, TaskBuoyViewModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TaskBuoyViewModel a;
    public final ot b;

    /* loaded from: classes6.dex */
    public static final class a implements ot {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hq a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(hq hqVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hqVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hqVar;
        }

        @Override // com.baidu.tieba.ot
        public void a() {
            TaskBuoyViewModel taskBuoyViewModel;
            TaskInfo c;
            TaskBuoyViewModel taskBuoyViewModel2;
            tt<TaskBuoyViewData> a;
            TaskBuoyViewData k;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (taskBuoyViewModel = this.a.a) != null && (c = taskBuoyViewModel.c()) != null && (taskBuoyViewModel2 = this.a.a) != null && (a = taskBuoyViewModel2.a()) != null && (k = a.k()) != null) {
                nq.a.b(k.getUiConfig().h(), c, k.getTaskStatus());
            }
        }

        @Override // com.baidu.tieba.ot
        public void b() {
            TaskBuoyViewModel taskBuoyViewModel;
            TaskInfo c;
            TaskBuoyViewModel taskBuoyViewModel2;
            tt<TaskBuoyViewData> a;
            TaskBuoyViewData k;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (taskBuoyViewModel = this.a.a) != null && (c = taskBuoyViewModel.c()) != null && (taskBuoyViewModel2 = this.a.a) != null && (a = taskBuoyViewModel2.a()) != null && (k = a.k()) != null) {
                nq.a.a(k.getUiConfig().h(), c, k.getTaskStatus());
            }
        }
    }

    public hq() {
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
        this.b = new a(this);
    }

    public ot c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (ot) invokeV.objValue;
    }

    @CallSuper
    public void d(TaskBuoyViewModel taskBuoyViewModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, taskBuoyViewModel) == null) {
            this.a = taskBuoyViewModel;
        }
    }
}
