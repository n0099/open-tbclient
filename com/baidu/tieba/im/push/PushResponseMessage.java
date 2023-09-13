package com.baidu.tieba.im.push;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.c35;
import com.baidu.tieba.im.message.ResponsePullMessage;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.LinkedList;
import protobuf.PushMessage.DataRes;
import protobuf.PushMessage.PushMessageResIdl;
import protobuf.PushMessage.PushMsg;
import protobuf.PushMsgInfo;
/* loaded from: classes6.dex */
public class PushResponseMessage extends ResponsePullMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c35 notificationData;

    @Override // com.baidu.tieba.im.message.ResponsePullMessage
    public boolean isPulledMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushResponseMessage() {
        super(202009);
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

    public c35 getNotificationData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.notificationData;
        }
        return (c35) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.message.ResponsePullMessage, com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        PushMsg pushMsg;
        PushMsgInfo pushMsgInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            PushMessageResIdl pushMessageResIdl = (PushMessageResIdl) new Wire(new Class[0]).parseFrom(bArr, PushMessageResIdl.class);
            DataRes dataRes = pushMessageResIdl.data;
            if (dataRes != null && (pushMsg = dataRes.msgs) != null && (pushMsgInfo = pushMsg.data) != null && pushMsgInfo.msgInfo != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp().getApplicationContext(), "push_content_receive", null);
                setGroupMsg(new LinkedList());
                PushMsgInfo pushMsgInfo2 = pushMessageResIdl.data.msgs.data;
                boolean z = true;
                if (pushMsgInfo2.msgInfo.size() == 1 && pushMsgInfo2.msgInfo.get(0).msgId.longValue() == 0 && pushMsgInfo2.groupType.intValue() == 30) {
                    z = false;
                }
                if (z) {
                    MessageUtils.generatePushData(getGroupMsg(), 30, pushMsgInfo2.msgInfo, pushMsgInfo2.groupId);
                } else {
                    this.notificationData = MessageUtils.generatePushNotifyData(pushMsgInfo2.msgInfo.get(0));
                }
            }
            return pushMessageResIdl;
        }
        return invokeIL.objValue;
    }
}
