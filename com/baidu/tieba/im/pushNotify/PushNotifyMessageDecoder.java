package com.baidu.tieba.im.pushNotify;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.LinkedList;
import java.util.List;
import protobuf.PushNotify.PushNotifyResIdl;
import protobuf.PushNotify.PusherMsg;
/* loaded from: classes6.dex */
public class PushNotifyMessageDecoder extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<PushNotifyMessage> mMsgList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushNotifyMessageDecoder() {
        super(202006);
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
        this.mMsgList = null;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            BdLog.e("cmd is " + i);
            PushNotifyResIdl pushNotifyResIdl = (PushNotifyResIdl) new Wire(new Class[0]).parseFrom(bArr, PushNotifyResIdl.class);
            List<PusherMsg> list = pushNotifyResIdl.multiMsg;
            if (list == null) {
                size = 0;
            } else {
                size = list.size();
            }
            this.mMsgList = new LinkedList<>();
            for (int i2 = 0; i2 < size; i2++) {
                PusherMsg pusherMsg = pushNotifyResIdl.multiMsg.get(i2);
                PushNotifyMessage pushNotifyMessage = new PushNotifyMessage();
                pushNotifyMessage.setGroupId(pusherMsg.data.groupId.longValue());
                pushNotifyMessage.setNewestMsgId(pusherMsg.data.msgId.longValue());
                pushNotifyMessage.setPushTime(pusherMsg.data.pushTime.longValue());
                pushNotifyMessage.setType(pusherMsg.data.type.intValue());
                pushNotifyMessage.setContent(pusherMsg.data.content);
                pushNotifyMessage.setEmitTime(pusherMsg.data.et);
                pushNotifyMessage.setGroupType(pusherMsg.data.groupType.intValue());
                this.mMsgList.add(pushNotifyMessage);
            }
            return pushNotifyResIdl;
        }
        return invokeIL.objValue;
    }

    public LinkedList<PushNotifyMessage> getMsgList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mMsgList;
        }
        return (LinkedList) invokeV.objValue;
    }
}
