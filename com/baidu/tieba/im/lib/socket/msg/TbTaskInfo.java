package com.baidu.tieba.im.lib.socket.msg;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.TaskState;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010%\u001a\u00020&R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR$\u0010\u001e\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010\u0002\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001aR\u001e\u0010\"\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001a¨\u0006("}, d2 = {"Lcom/baidu/tieba/im/lib/socket/msg/TbTaskInfo;", "Ljava/io/Serializable;", "()V", "originMsgId", "", "getOriginMsgId", "()J", "setOriginMsgId", "(J)V", "originMsgKey", "", "getOriginMsgKey", "()Ljava/lang/String;", "setOriginMsgKey", "(Ljava/lang/String;)V", "taskErrorMsg", "getTaskErrorMsg", "setTaskErrorMsg", "taskId", "getTaskId", "setTaskId", "taskProgress", "", "getTaskProgress", "()I", "setTaskProgress", "(I)V", "taskResult", "getTaskResult", "setTaskResult", TaskState.key, "getTaskState$annotations", "getTaskState", "setTaskState", StatConstants.KEY_EXT_TASK_TYPE, "getTaskType", "setTaskType", "isComplete", "", "Companion", "im-lib-socket_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TbTaskInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final a Companion;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("origin_msg_id")
    public long originMsgId;
    @SerializedName("origin_msg_key")
    public String originMsgKey;
    @SerializedName("task_error_msg")
    public String taskErrorMsg;
    @SerializedName("task_id")
    public String taskId;
    @SerializedName("task_progress")
    public int taskProgress;
    @SerializedName("task_result")
    public int taskResult;
    @SerializedName("task_state")
    public int taskState;
    @SerializedName("task_type")
    public int taskType;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2111840055, "Lcom/baidu/tieba/im/lib/socket/msg/TbTaskInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2111840055, "Lcom/baidu/tieba/im/lib/socket/msg/TbTaskInfo;");
                return;
            }
        }
        Companion = new a(null);
    }

    public static /* synthetic */ void getTaskState$annotations() {
    }

    @JvmStatic
    public static final boolean isProgressChanged(TbTaskInfo tbTaskInfo, TbTaskInfo tbTaskInfo2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, tbTaskInfo, tbTaskInfo2)) == null) ? Companion.a(tbTaskInfo, tbTaskInfo2) : invokeLL.booleanValue;
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

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
        public final boolean a(TbTaskInfo tbTaskInfo, TbTaskInfo tbTaskInfo2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbTaskInfo, tbTaskInfo2)) == null) {
                if (tbTaskInfo2 == null) {
                    return false;
                }
                if (tbTaskInfo != null && tbTaskInfo.getTaskProgress() == tbTaskInfo2.getTaskProgress()) {
                    return false;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    public TbTaskInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.taskId = "";
        this.taskErrorMsg = "";
        this.originMsgKey = "";
    }

    public final long getOriginMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.originMsgId;
        }
        return invokeV.longValue;
    }

    public final String getOriginMsgKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.originMsgKey;
        }
        return (String) invokeV.objValue;
    }

    public final String getTaskErrorMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.taskErrorMsg;
        }
        return (String) invokeV.objValue;
    }

    public final String getTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.taskId;
        }
        return (String) invokeV.objValue;
    }

    public final int getTaskProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.taskProgress;
        }
        return invokeV.intValue;
    }

    public final int getTaskResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.taskResult;
        }
        return invokeV.intValue;
    }

    public final int getTaskState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.taskState;
        }
        return invokeV.intValue;
    }

    public final int getTaskType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.taskType;
        }
        return invokeV.intValue;
    }

    public final boolean isComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.taskState == 3) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void setOriginMsgId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.originMsgId = j;
        }
    }

    public final void setOriginMsgKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.originMsgKey = str;
        }
    }

    public final void setTaskErrorMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.taskErrorMsg = str;
        }
    }

    public final void setTaskId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.taskId = str;
        }
    }

    public final void setTaskProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.taskProgress = i;
        }
    }

    public final void setTaskResult(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.taskResult = i;
        }
    }

    public final void setTaskState(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.taskState = i;
        }
    }

    public final void setTaskType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.taskType = i;
        }
    }
}
