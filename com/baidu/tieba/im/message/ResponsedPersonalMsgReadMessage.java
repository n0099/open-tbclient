package com.baidu.tieba.im.message;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import protobuf.CommitReceivedPmsg.CommitReceivedPmsgResIdl;
/* loaded from: classes9.dex */
public class ResponsedPersonalMsgReadMessage extends TbSocketReponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long groupId;
    public long hasSentMsgId;
    public long toUid;
    public int toUserType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponsedPersonalMsgReadMessage() {
        super(205006);
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
    }

    public long getGroupId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.groupId : invokeV.longValue;
    }

    public long getHasSentMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.hasSentMsgId : invokeV.longValue;
    }

    public long getToUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.toUid : invokeV.longValue;
    }

    public int getToUserType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.toUserType : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            CommitReceivedPmsgResIdl commitReceivedPmsgResIdl = (CommitReceivedPmsgResIdl) new Wire(new Class[0]).parseFrom(bArr, CommitReceivedPmsgResIdl.class);
            setError(commitReceivedPmsgResIdl.error.errorno.intValue());
            setErrorString(commitReceivedPmsgResIdl.error.usermsg);
            if (getError() != 0) {
                return;
            }
            this.hasSentMsgId = commitReceivedPmsgResIdl.data.readMsgId.longValue();
            this.groupId = commitReceivedPmsgResIdl.data.groupId.longValue();
            this.toUid = commitReceivedPmsgResIdl.data.toUid.longValue();
            this.toUserType = commitReceivedPmsgResIdl.data.toUserType.intValue();
        }
    }
}
