package com.baidu.tieba.im.pushNotify;

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
/* loaded from: classes12.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMsgList = null;
    }

    public LinkedList<PushNotifyMessage> getMsgList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mMsgList : (LinkedList) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            BdLog.e("cmd is " + i2);
            PushNotifyResIdl pushNotifyResIdl = (PushNotifyResIdl) new Wire(new Class[0]).parseFrom(bArr, PushNotifyResIdl.class);
            List<PusherMsg> list = pushNotifyResIdl.multiMsg;
            int size = list == null ? 0 : list.size();
            this.mMsgList = new LinkedList<>();
            for (int i3 = 0; i3 < size; i3++) {
                PusherMsg pusherMsg = pushNotifyResIdl.multiMsg.get(i3);
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
        }
    }
}
