package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class gu {
    public static /* synthetic */ Interceptable $ic;
    public static final gu a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448305791, "Lcom/baidu/tieba/gu;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448305791, "Lcom/baidu/tieba/gu;");
                return;
            }
        }
        a = new gu();
    }

    public gu() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static /* synthetic */ JSONObject b(gu guVar, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        return guVar.a(str, str2, str3);
    }

    public final JSONObject a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, str3)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("taskId", str);
            jSONObject.put(TaskInfo.keyActTaskId, str2);
            if (str3 != null) {
                jSONObject.put("phase", str3);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLL.objValue;
    }

    public final String c(TaskStatus taskStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, taskStatus)) == null) {
            if (taskStatus.isFinished()) {
                return "finish";
            }
            if (taskStatus.isRegistered()) {
                return "guide";
            }
            return "doing";
        }
        return (String) invokeL.objValue;
    }

    public final String d(TaskStatus taskStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, taskStatus)) == null) {
            if (taskStatus.isUnRegistered()) {
                return "y_task_unregister";
            }
            if (taskStatus.isFinished()) {
                return "y_task_done";
            }
            if (taskStatus.isRegistered()) {
                return "y_task_active";
            }
            if (taskStatus.isRunning() && taskStatus.isLocalCompleted()) {
                return "y_task_local_done";
            }
            return "y_task_start";
        }
        return (String) invokeL.objValue;
    }
}
