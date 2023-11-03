package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.TaskState;
import com.baidu.bdtask.component.buoy.TaskBuoyViewModel;
import com.baidu.bdtask.ctrl.model.TaskProcess;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hl extends TaskBuoyViewModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int g;
    public nl h;
    public final long i;
    public ml j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448306473, "Lcom/baidu/tieba/hl;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448306473, "Lcom/baidu/tieba/hl;");
        }
    }

    /* loaded from: classes6.dex */
    public static final class a implements ml {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hl a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(hl hlVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hlVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hlVar;
        }

        @Override // com.baidu.tieba.ml
        public void a(long j, long j2) {
            ml h;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && (h = this.a.h()) != null) {
                h.a(j, j2);
            }
        }

        @Override // com.baidu.tieba.ml
        public void onCancel() {
            ml h;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (h = this.a.h()) != null) {
                h.onCancel();
            }
        }

        @Override // com.baidu.tieba.ml
        public void onFinish() {
            ml h;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (h = this.a.h()) != null) {
                h.onFinish();
            }
        }

        @Override // com.baidu.tieba.ml
        public void onPause() {
            ml h;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (h = this.a.h()) != null) {
                h.onPause();
            }
        }

        @Override // com.baidu.tieba.ml
        public void onResume() {
            ml h;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (h = this.a.h()) != null) {
                h.onResume();
            }
        }

        @Override // com.baidu.tieba.ml
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (this.a.k()) {
                    ml h = this.a.h();
                    if (h != null) {
                        h.onResume();
                        return;
                    }
                    return;
                }
                ml h2 = this.a.h();
                if (h2 != null) {
                    h2.onStart();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hl(TaskInfo taskInfo) {
        super(taskInfo);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {taskInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TaskInfo) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = 8;
        this.i = taskInfo.getTaskRule().getStay();
    }

    public final void o(ml mlVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, mlVar) == null) {
            this.j = mlVar;
        }
    }

    public final ml h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.j;
        }
        return (ml) invokeV.objValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if ((this.g & 4) == 4) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if ((this.g & 2) == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if ((this.g & 1) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || !l()) {
            return;
        }
        this.g |= 4;
        nl nlVar = this.h;
        if (nlVar != null) {
            nlVar.e();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || !j()) {
            return;
        }
        this.g |= 2;
        r();
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.g = 1;
            r();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.g = 8;
            nl nlVar = this.h;
            if (nlVar != null) {
                nlVar.h();
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            nl nlVar = this.h;
            if (nlVar != null) {
                nlVar.j();
            }
            nl nlVar2 = new nl(i(), 200L, new a(this));
            this.h = nlVar2;
            if (nlVar2 != null) {
                nlVar2.b();
            }
        }
    }

    public final long i() {
        InterceptResult invokeV;
        TaskProcess taskProcess;
        long j;
        TaskStatus taskStatus;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            TaskState m = BDPTask.m.m(c().getActionId());
            if (m != null && (taskStatus = m.getTaskStatus()) != null) {
                taskProcess = taskStatus.getProcess();
            } else {
                taskProcess = null;
            }
            long j2 = this.i;
            if (taskProcess != null) {
                j = taskProcess.getStayDurTimeMs();
            } else {
                j = 0;
            }
            long j3 = j2 - j;
            if (j3 < 0) {
                return 0L;
            }
            return j3;
        }
        return invokeV.longValue;
    }
}
