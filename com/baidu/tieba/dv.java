package com.baidu.tieba;

import androidx.annotation.CallSuper;
import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public interface dv {

    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(dv dvVar, SubTaskState subTaskState) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65536, null, dvVar, subTaskState) == null) || dvVar.b(subTaskState.getTaskInfo(), subTaskState.getTaskStatus().getCurStatusCode())) {
                return;
            }
            dvVar.a(subTaskState);
        }

        public static boolean b(dv dvVar, TaskInfo taskInfo, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, dvVar, taskInfo, i)) == null) ? i == 304 : invokeLLI.booleanValue;
        }

        @CallSuper
        public static void c(dv dvVar, SubTaskState subTaskState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, dvVar, subTaskState) == null) {
                gv.c.b(subTaskState);
            }
        }
    }

    @CallSuper
    void a(SubTaskState subTaskState);

    boolean b(TaskInfo taskInfo, int i);
}
