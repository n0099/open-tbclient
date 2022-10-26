package com.baidu.tieba;

import androidx.collection.LongSparseArray;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.MessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class cb7 extends pb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cb7() {
        super(202003);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.kb
    public /* bridge */ /* synthetic */ Message process(Message message, MessageTask messageTask) {
        SocketMessage socketMessage = (SocketMessage) message;
        process(socketMessage, (SocketMessageTask) messageTask);
        return socketMessage;
    }

    public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketMessage, socketMessageTask)) == null) {
            StringBuilder sb = new StringBuilder(200);
            if (socketMessage instanceof MessageSyncMessage) {
                MessageSyncMessage messageSyncMessage = (MessageSyncMessage) socketMessage;
                LongSparseArray groupMids = messageSyncMessage.getGroupMids();
                for (int i = 0; i < groupMids.size(); i++) {
                    sb.append(groupMids.keyAt(i));
                    sb.append("-");
                    sb.append(groupMids.valueAt(i));
                    sb.append("|");
                }
                jx4.a("im", socketMessage.getClientLogID(), 202003, "sendMsg", 0, null, "reason", "pull" + messageSyncMessage.getSyncTypeString(), "comment", sb.toString());
            }
            return socketMessage;
        }
        return (SocketMessage) invokeLL.objValue;
    }
}
