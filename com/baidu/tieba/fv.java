package com.baidu.tieba;

import android.view.View;
import androidx.annotation.CallSuper;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.component.buoy.TaskBuoyViewData;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fv implements gv {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public fv() {
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

    @Override // com.baidu.tieba.gv
    @CallSuper
    public void a(View view2, TaskInfo taskInfo, TaskBuoyViewData taskBuoyViewData) {
        qs b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048576, this, view2, taskInfo, taskBuoyViewData) == null) && taskBuoyViewData.getTaskStatus().isFinished()) {
            if (view2.getParent() != null) {
                view2.setVisibility(8);
            }
            ku v = BDPTask.m.v();
            if (v != null && (b = v.b()) != null) {
                b.a(taskBuoyViewData.getScheme(), 3);
            }
        }
    }
}
