package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.component.buoy.TaskBuoyViewData;
import com.baidu.bdtask.component.buoy.TaskBuoyViewModel;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes4.dex */
public final class hp {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static final class a {
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

        @JvmStatic
        public final op a(ks<TaskBuoyViewData, TaskBuoyViewModel> ksVar, pp ppVar, TaskInfo taskInfo) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, ksVar, ppVar, taskInfo)) == null) ? new op(ksVar, ppVar, taskInfo) : (op) invokeLLL.objValue;
        }

        @JvmStatic
        public final rp b(ks<TaskBuoyViewData, TaskBuoyViewModel> ksVar, TaskBuoyViewModel taskBuoyViewModel, TaskInfo taskInfo) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ksVar, taskBuoyViewModel, taskInfo)) == null) ? new rp(ksVar, taskBuoyViewModel, taskInfo) : (rp) invokeLLL.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448306597, "Lcom/baidu/tieba/hp;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448306597, "Lcom/baidu/tieba/hp;");
                return;
            }
        }
        a = new a(null);
    }

    @JvmStatic
    public static final op a(ks<TaskBuoyViewData, TaskBuoyViewModel> ksVar, pp ppVar, TaskInfo taskInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, ksVar, ppVar, taskInfo)) == null) ? a.a(ksVar, ppVar, taskInfo) : (op) invokeLLL.objValue;
    }

    @JvmStatic
    public static final rp b(ks<TaskBuoyViewData, TaskBuoyViewModel> ksVar, TaskBuoyViewModel taskBuoyViewModel, TaskInfo taskInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, ksVar, taskBuoyViewModel, taskInfo)) == null) ? a.b(ksVar, taskBuoyViewModel, taskInfo) : (rp) invokeLLL.objValue;
    }
}
