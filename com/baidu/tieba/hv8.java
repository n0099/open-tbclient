package com.baidu.tieba;

import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.lib.socket.msg.TbTaskInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class hv8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public hv8() {
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

    public IChatRoomEnterListener.TaskInfo a(TbTaskInfo tbInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tbInfo)) == null) {
            Intrinsics.checkNotNullParameter(tbInfo, "tbInfo");
            IChatRoomEnterListener.TaskInfo taskInfo = new IChatRoomEnterListener.TaskInfo();
            taskInfo.taskId = tbInfo.getTaskId();
            taskInfo.taskType = tbInfo.getTaskType();
            taskInfo.taskState = tbInfo.getTaskState();
            taskInfo.taskResult = tbInfo.getTaskResult();
            taskInfo.taskErrorMsg = tbInfo.getTaskErrorMsg();
            taskInfo.originMsgId = tbInfo.getOriginMsgId();
            taskInfo.originMsgKey = tbInfo.getOriginMsgKey();
            taskInfo.taskProgress = tbInfo.getTaskProgress();
            return taskInfo;
        }
        return (IChatRoomEnterListener.TaskInfo) invokeL.objValue;
    }

    public TbTaskInfo b(IChatRoomEnterListener.TaskInfo sdkInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sdkInfo)) == null) {
            Intrinsics.checkNotNullParameter(sdkInfo, "sdkInfo");
            TbTaskInfo tbTaskInfo = new TbTaskInfo();
            String taskId = sdkInfo.taskId;
            Intrinsics.checkNotNullExpressionValue(taskId, "taskId");
            tbTaskInfo.setTaskId(taskId);
            tbTaskInfo.setTaskType(sdkInfo.taskType);
            tbTaskInfo.setTaskState(sdkInfo.taskState);
            tbTaskInfo.setTaskResult(sdkInfo.taskResult);
            String taskErrorMsg = sdkInfo.taskErrorMsg;
            Intrinsics.checkNotNullExpressionValue(taskErrorMsg, "taskErrorMsg");
            tbTaskInfo.setTaskErrorMsg(taskErrorMsg);
            tbTaskInfo.setOriginMsgId(sdkInfo.originMsgId);
            String originMsgKey = sdkInfo.originMsgKey;
            Intrinsics.checkNotNullExpressionValue(originMsgKey, "originMsgKey");
            tbTaskInfo.setOriginMsgKey(originMsgKey);
            tbTaskInfo.setTaskProgress(sdkInfo.taskProgress);
            return tbTaskInfo;
        }
        return (TbTaskInfo) invokeL.objValue;
    }
}
