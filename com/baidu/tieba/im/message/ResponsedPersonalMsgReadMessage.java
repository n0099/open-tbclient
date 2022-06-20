package com.baidu.tieba.im.message;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import protobuf.CommitReceivedPmsg.CommitReceivedPmsgResIdl;
/* loaded from: classes3.dex */
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

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            CommitReceivedPmsgResIdl commitReceivedPmsgResIdl = (CommitReceivedPmsgResIdl) new Wire(new Class[0]).parseFrom(bArr, CommitReceivedPmsgResIdl.class);
            setError(commitReceivedPmsgResIdl.error.errorno.intValue());
            setErrorString(commitReceivedPmsgResIdl.error.usermsg);
            if (getError() != 0) {
                return commitReceivedPmsgResIdl;
            }
            this.hasSentMsgId = commitReceivedPmsgResIdl.data.readMsgId.longValue();
            this.groupId = commitReceivedPmsgResIdl.data.groupId.longValue();
            this.toUid = commitReceivedPmsgResIdl.data.toUid.longValue();
            this.toUserType = commitReceivedPmsgResIdl.data.toUserType.intValue();
            return commitReceivedPmsgResIdl;
        }
        return invokeIL.objValue;
    }

    public long getGroupId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.groupId : invokeV.longValue;
    }

    public long getHasSentMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.hasSentMsgId : invokeV.longValue;
    }

    public long getToUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.toUid : invokeV.longValue;
    }

    public int getToUserType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.toUserType : invokeV.intValue;
    }
}
